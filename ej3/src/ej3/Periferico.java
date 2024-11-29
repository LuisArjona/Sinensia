package ej3;

public sealed abstract class Periferico permits Pantalla, Teclado, Raton {
	private String nombre;
	private double precio;
	private int anhosEdad;
	
	private static int numPerifericos=0;
	
	public Periferico(String nombre, double precio, int anhosEdad) {
		numPerifericos++;
		this.nombre = nombre;
		this.precio = precio;
		this.anhosEdad = anhosEdad;
	}
	
	public abstract void conectar();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getAnhosEdad() {
		return anhosEdad;
	}
	
	public void setAnhosEdad(int anhosEdad) {
		this.anhosEdad = anhosEdad;
	}

	public static int getNumPerifericos() {
		return numPerifericos;
	}
	
	
	
}
