package com.sinensia.main;

import java.util.Scanner;

import com.sinensia.utilities.services.impl.TransformadorNumerosImpl;

public class Main {

	public static void main(String[] args) {
		
		for(int i=0;i<1000;i++) {
			System.out.println(TransformadorNumerosImpl.transformarNumero(i));
		}
		




	}

}
