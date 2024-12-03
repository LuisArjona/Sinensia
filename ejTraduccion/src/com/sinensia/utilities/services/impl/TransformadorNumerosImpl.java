package com.sinensia.utilities.services.impl;
import java.util.TreeMap;

import com.sinensia.utilities.services.TransformarNumero;

/**
 * La clase TransformadorNumeros transforma numeros a distintos formatos.
 * @authors Miguel Alonso & Luis Arjona
 *
 */
public class TransformadorNumerosImpl implements TransformarNumero{
	
	private static final TreeMap<Integer, String> unidades = new TreeMap<Integer, String>() {{
	    put(0, "Cero");
	    put(1, "Uno");
	    put(2, "Dos");
	    put(3, "Tres");
	    put(4, "Cuatro");
	    put(5, "Cinco");
	    put(6, "Seis");
	    put(7, "Siete");
	    put(8, "Ocho");
	    put(9, "Nueve");
	}};

	private static final TreeMap<Integer, String> decenas = new TreeMap<Integer, String>() {{
	    put(1, "Dieci");
	    put(2, "Veinti");
	    put(3, "Treinta y ");
	    put(4, "Cuarenta y ");
	    put(5, "Cincuenta y ");
	    put(6, "Sesenta y ");
	    put(7, "Setenta y ");
	    put(8, "Ochenta y ");
	    put(9, "Noventa y ");
	}};

	private static final TreeMap<Integer, String> centenas = new TreeMap<Integer, String>() {{
	    put(1, "Ciento");
	    put(2, "Doscientos");
	    put(3, "Trescientos");
	    put(4, "Cuatrocientos");
	    put(5, "Quinientos");
	    put(6, "Seiscientos");
	    put(7, "Setecientos");
	    put(8, "Ochocientos");
	    put(9, "Novecientos");
	}};
	
	private static final TreeMap<Integer, String> excepciones = new TreeMap<Integer, String>() {{
		put(10,"Diez");
	    put(11,"Once");
	    put(12,"Doce");
	    put(13,"Trece");
	    put(14,"Catorce");
	    put(15,"Quince");
		put(20,"Veinte");
		put(30,"Treinta");
		put(40,"Cuarenta");
		put(50,"Cincuenta");
		put(60,"Sesenta");
		put(70,"Setenta");
		put(80,"Ochenta");
		put(90,"Noventa");
		put(100,"Cien");
	}};

	
	public static String getUnidad(int num) {
		return unidades.get(num);
	}
	
	public static String getDecena(int num) {
		return decenas.get(num);
	}
	
	public static String getCentena(int num) {
		return centenas.get(num);
	}
	
	/**
	 * Transforma un entero a su palabra correspondiente que contiene alguna particularidad.
	 * @param Numero a transformar
	 * @return Numero como palabra
	 */
	private static String transformarExcepcion(int num) {

		if(excepciones.containsKey(num)) {//Números que no siguen el patrón de sus similares.
			return excepciones.get(num);
		}
		
		String numFinal="";
		String numero=String.valueOf(num);
		char[]array=numero.toCharArray();
		
		numFinal+=getCentena(Character.getNumericValue(array[0]));
		
		if((array[1] == '1' || array[1] == '2') && array[2] == '0') {
			if(array[1]=='1') {
				numFinal += " " + excepciones.get(10).toLowerCase();
			}else {
				numFinal += " " + excepciones.get(20).toLowerCase();
			}
				
		}else {
			if(array[1] != '0')
				numFinal += " " +getDecena(Character.getNumericValue(array[1])).toLowerCase();
			
			if(array[2] != '0')
				numFinal += " " + getUnidad(Character.getNumericValue(array[2])).toLowerCase();
		}
		
		return numFinal.replaceAll("y","").trim();
	}
	
	/**
	 * Transforma un entero de hasta tres cifras a su palabra correspondiente
	 * @param Numero a transformar
	 * @return Numero como palabra
	 */
	public static String transformarNumero(int num) {
		
		if(num>=0 && num<1000) {
			if(num >= 11 && num <= 15 || (String.valueOf(num).contains("0") && num != 0)) {
				return transformarExcepcion(num);
			}
			if(num < 10) {
				return transformarUnidad(num);
			}
			if(num < 100) {
				return transformarDecena(num);
			}
			if(num < 1000) {
				return transformarCentena(num);
			}	
		}
		
		throw new IllegalArgumentException("Valor fuera de rango.");
		
	}
	
	/**
	 * Método que convierte un numero de una sola cifra a texto.
	 * @param Numero a transformar
	 * @return Numero como palabra
	 */
	private static String transformarUnidad(int num) {
		return getUnidad(num);
	}
	
	/**
	 * Método que convierte un numero de dos cifras a texto.
	 * @param Numero a transformar
	 * @return Numero como palabra
	 */
	private static String transformarDecena(int num) {
		String numero = String.valueOf(num);
		char[]array = numero.toCharArray();
		return getDecena(Character.getNumericValue(array[0])) + (getUnidad(Character.getNumericValue(array[1]))).toLowerCase();
	}
	
	/**
	 * Método que convierte un numero de tres cifras a texto.
	 * @param Numero a transformar
	 * @return Numero como palabra
	 */
	private static String transformarCentena(int num) {
		String numero=String.valueOf(num);
		char[]array=numero.toCharArray();
		
		if(excepciones.containsKey(num%100))
			return getCentena(Character.getNumericValue(array[0])) + " " + excepciones.get(num%100).toLowerCase();
		
		return getCentena(Character.getNumericValue(array[0]))+ " " + (getDecena(Character.getNumericValue(array[1]))).toLowerCase() + (getUnidad(Character.getNumericValue(array[2]))).toLowerCase();
			
	}


}
