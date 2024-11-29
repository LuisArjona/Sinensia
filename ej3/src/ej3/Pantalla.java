package ej3;

public final class Pantalla extends Periferico{
	private double pulgadas;
	private int herzios;
	
	public Pantalla(String nombre, double precio, int anhosEdad, double pulgadas, int herzios) {
		super(nombre, precio, anhosEdad);
		this.pulgadas=pulgadas;
		this.herzios=herzios;
	}

	public double getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(double pulgadas) {
		this.pulgadas = pulgadas;
	}

	public int getHerzios() {
		return herzios;
	}

	public void setHerzios(int herzios) {
		this.herzios = herzios;
	}

	/** 
	 * Muestra por pantalla que la pantalla se está conetando.
	 */
	@Override
	public void conectar() {
		System.out.println("Conectando la pantalla: " + getNombre() + " a través de HDMI");
	}

}
