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
		assertNotEquals("Doscientos cero",TransformadorNumerosImpl.transformarNumero(200));
		assertEquals("Novecientos treinta y dos", TransformadorNumerosImpl.transformarNumero(932));
	}
	
	@Test
	public void error() {
		assertThrows(IllegalArgumentException.class, () -> {
			TransformadorNumerosImpl.transformarNumero(1000);
		});
	}

}
