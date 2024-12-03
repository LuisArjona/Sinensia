package com.sinensia.utilities.services.impl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.sinensia.utilities.services.impl.TransformadorNumerosImpl;

public class TransformadorNumerosImplTest {
	
	@Test
	public void convert() {
		assertEquals("Ocho",TransformadorNumerosImpl.transformarNumero(8));
		assertEquals("Noventa",TransformadorNumerosImpl.transformarNumero(90));
		assertEquals("Noventa y uno",TransformadorNumerosImpl.transformarNumero(91));
		assertEquals("Ciento diez",TransformadorNumerosImpl.transformarNumero(110));
		assertEquals("Ciento quince",TransformadorNumerosImpl.transformarNumero(115));
		assertEquals("Doscientos",TransformadorNumerosImpl.transformarNumero(200));
		assertEquals("Doscientos uno",TransformadorNumerosImpl.transformarNumero(201));
		assertEquals("Doscientos treinta",TransformadorNumerosImpl.transformarNumero(230));
		assertEquals("Ciento veinte",TransformadorNumerosImpl.transformarNumero(120));
		assertNotEquals("Doscientos cero",TransformadorNumerosImpl.transformarNumero(200));
		assertEquals("Novecientos treinta y dos", TransformadorNumerosImpl.transformarNumero(932));
		assertEquals("Quince", TransformadorNumerosImpl.transformarNumero(15));
	}
	
	@Test
	public void error() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			TransformadorNumerosImpl.transformarNumero(1000);
		});
		
		assertEquals("Valor fuera de rango.", e.getMessage());
	}

}
