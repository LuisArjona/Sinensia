package com.sinensia.polloschicharron.business.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.business.services.ProductoServices;

@Service
public class ProductoServicesImpl implements ProductoServices{
	
	private final Map<Long, Producto> PRODUCTOS_DB = new HashMap<>();
	private FamiliaServices familiaServices;
	
	public ProductoServicesImpl(FamiliaServices familiaServices) {
		this.familiaServices=familiaServices;
		init();
	}

	@Override
	public Long create(Producto producto) {
		
		if(producto.getId()!=null)
			throw new IllegalStateException("El id ha de ser nulo");
		
		Long id;
		
		do {
			
			id=Long.parseLong(String.valueOf(Math.floor(Math.random()*1000000+1)));
			
		}while(PRODUCTOS_DB.containsKey(id));
		
		producto.setId(id);
		PRODUCTOS_DB.put(id, producto);
		
		return id;
	}

	@Override
	public Optional<Producto> read(Long id) {
		
		return Optional.ofNullable(PRODUCTOS_DB.get(id));
	}

	@Override
	public void update(Producto producto) {

		Long id = producto.getId();
		
		boolean existe = PRODUCTOS_DB.containsKey(id);
		
		if(id == null || !existe) {
			throw new IllegalStateException("El ID [" + id + "] no existe.");
		}
		
		PRODUCTOS_DB.replace(id, producto);
		
	}

	@Override
	public void delete(Long id) {
		
		boolean existe = PRODUCTOS_DB.containsKey(id);
		
		if(id == null || !existe) {
			throw new IllegalStateException("El ID [" + id + "] no existe.");
		}
		
		PRODUCTOS_DB.remove(id);
		
	}

	@Override
	public List<Producto> getAll() {
		return new ArrayList<>(PRODUCTOS_DB.values());
	}

	@Override
	public List<Producto> getBetweenPriceRange(double min, double max) {
		
		if((min<0 || max<0) || (min>=max)) {
			throw new IllegalStateException(" Rango de precios no válido ");
		}
		
		return PRODUCTOS_DB.values().stream().filter(prod -> prod.getPrecio() > min && prod.getPrecio() < max).toList();
	}

	@Override
	public List<Producto> getBetweenFechaAlta(Date desde, Date hasta) {
		
		if(desde.compareTo(hasta)>=0)
			throw new IllegalStateException("Fechas inválidas.");
		
		return PRODUCTOS_DB.values().stream().filter(prod -> prod.getFechaAlta().after(desde) && prod.getFechaAlta().before(hasta)).toList();
	}

	@Override
	public List<Producto> getByFamilia(Familia familia) {
		
		if(familiaServices.read(familia.getId()).isEmpty())
			throw new IllegalStateException("No existe tal familia.");
		
		return PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().equals(familia)).toList();
	}
	
	public List<Producto> getByFamilia(Long id) {
		
		if(familiaServices.read(id).isEmpty())
			throw new IllegalStateException("No existe tal familia.");
		
		return PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().getId().equals(id)).toList();
	}

	@Override
	public int getNumeroTotalProductos() {
		
		return PRODUCTOS_DB.size();
	}

	@Override
	public int getNumeroTotalProductosByFamilia(Familia familia) {
		
		return (int) PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().equals(familia)).count();
	}

	@Override
	public void incrementarPrecio(Familia familia, double porcentaje) {
		
		PRODUCTOS_DB.values().forEach(prod -> {
			if(prod.getFamilia().equals(familia)) {
				prod.setPrecio(prod.getPrecio() + prod.getPrecio() * porcentaje / 100);
			}
		});
		
	}

	@Override
	public void incrementarPrecio(List<Producto> productos, double porcentaje) {
		
		PRODUCTOS_DB.values().forEach(prod -> {
			if(productos.contains(prod)) {
				prod.setPrecio(prod.getPrecio() + prod.getPrecio() * porcentaje / 100);
			}
		});
		
	}

	@Override
	public void incrementarPrecio(Long[] ids, double porcentaje) {
		
		PRODUCTOS_DB.values().forEach(prod -> {
			if(encontrarId(ids, prod.getId())) {
				prod.setPrecio(prod.getPrecio() + prod.getPrecio() * porcentaje / 100);
			}
		});
		
	}
	
	private boolean encontrarId(Long[] ids, Long id) {
		
		for(Long idd : ids) {
			if(idd.equals(id))
				return true;
		}
		
		return false;
	}

	@Override
	public Map<Familia, Integer> getEstadisticaNumeroProductosPorFamilia() {
		
		List <Familia> familias = PRODUCTOS_DB.values().stream().map(Producto::getFamilia).distinct().toList();
		
		HashMap <Familia, Integer> total = new HashMap<>();
		
		familias.forEach(familia -> {
			Integer num = (int) PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().equals(familia)).count();
			total.put(familia, num);
		});
		
		return total;
	}

	@Override
	public Map<Familia, Double> getEstadisticaPrecioMedioProductosPorFamilia() {
		HashMap <Familia, Double> precioMedio = new HashMap<>();
		List <Familia> familias = PRODUCTOS_DB.values().stream().map(Producto::getFamilia).distinct().toList();
		
		familias.forEach(familia -> {
			Integer num = (int) PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().equals(familia)).count();
			Double total = PRODUCTOS_DB.values().stream().filter(prod -> prod.getFamilia().equals(familia)).mapToDouble(Producto::getPrecio).sum();
			Double media = total / num;
			precioMedio.put(familia, media);
		});
		
		return precioMedio;
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************	
	
	private void init() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Familia familia1 = new Familia();
		Familia familia2 = new Familia();
		
		familia1.setId(100L);
		familia2.setId(200L);
		
		familia1.setNombre("TAPAS");
		familia2.setNombre("REFRESCOS");
		
		Date fecha1 = null; // "24/10/2022"
		Date fecha2 = null;
		Date fecha3 = null;
		
		try {
			fecha1 = sdf.parse("24/10/2022");
			fecha2 = sdf.parse("25/10/2022");
			fecha3 = sdf.parse("26/10/2022");
		} catch(Exception e) {
			
		}
	
		Producto producto1 = new Producto();
		Producto producto2 = new Producto();
		Producto producto3 = new Producto();
		
		producto1.setId(1L);
		producto1.setFamilia(familia1);
		producto1.setNombre("PATATAS BRAVAS");
		producto1.setPrecio(5.20);
		producto1.setDescatalogado(false);
		producto1.setFechaAlta(fecha1);
		
		producto2.setId(2L);
		producto2.setFamilia(familia2);
		producto2.setNombre("COCACOLA ZERO 33cl");
		producto2.setPrecio(2.4);
		producto2.setDescatalogado(false);
		producto2.setFechaAlta(fecha2);
		
		producto3.setId(3L);
		producto3.setFamilia(familia1);
		producto3.setNombre("TORTILLA DE PATATA");
		producto3.setPrecio(4.6);
		producto3.setDescatalogado(true);
		producto3.setFechaAlta(fecha3);
		
		PRODUCTOS_DB.put(producto1.getId(), producto1);
		PRODUCTOS_DB.put(producto2.getId(), producto2);
		PRODUCTOS_DB.put(producto3.getId(), producto3);
		
	}

}
