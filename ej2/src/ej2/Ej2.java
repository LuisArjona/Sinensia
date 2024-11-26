package ej2;

public class Ej2 {

	public static void main(String[] args) {
		Contador c1 = new Contador();
		Contador c2 = new Contador();
		for(int i=0;i<5;i++) {
			c1.incrementar();
		}
		for(int i=0;i<3;i++) {
			c2.incrementar();
		}
		
		System.out.println("Total contadores "+Contador.totalContadores);
		System.out.println("Contador 1: "+c1.getValor());
		System.out.println("Contador 2: "+c2.getValor());

	}

}
