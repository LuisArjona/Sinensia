package ejTraduccion;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/**
		
		Scanner entrada = new Scanner(System.in);
		int num;
		System.out.println("Introduce un numero.");
		while(true) {
			do {
				num=entrada.nextInt();
				
				if(num<0 || num>999)
					System.out.println("El numero tiene que estar comprendido entre 0 y 999");
				
			}while(num<0 || num>999);
			
			System.out.println(gestionNumeros.transformarNumero(num));
		}
		
		 */
		
		
		for(int i=0;i<1000;i++) {
			System.out.println(TransformadorNumeros.transformarNumero(i));
		}




	}

}
