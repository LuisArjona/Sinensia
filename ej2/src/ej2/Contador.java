package ej2;

public class Contador {
	public static int totalContadores=0;
	
	private int valor;
	
	public Contador() {
		totalContadores++;
		this.valor=0;
	}
	
	public void incrementar() {
		this.valor++;
	}
	
	public int getValor() {
		return this.valor;
	}

}
