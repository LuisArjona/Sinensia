package ej3;

public final class Raton extends Periferico implements Pulsable{
	private int dpi;
	private int botones;

	public Raton(String nombre, double precio, int anhosEdad, int dpi, int botones) {
		super(nombre,precio,anhosEdad);
		this.dpi = dpi;
		this.botones = botones;
	}

	public int getDpi() {
		return dpi;
	}

	public void setDpi(int dpi) {
		this.dpi = dpi;
	}
	
	public int getBotones() {
		return botones;
	}
	
	public void setBotones(int botones) {
		this.botones = botones;
	}
	
	/** 
	 * Muestra por pantalla que el ratón se está pulsando.
	 */
	@Override
	public void pulsar() {
		System.out.println("Pulsando el ratón: " + getNombre());
	}
	
	/** 
	 * Muestra por pantalla que el ratón se está conectando.
	 */
	@Override
	public void conectar() {
		System.out.println("Conectando el ratón: " + getNombre() + " a través de usb.");
	}
	
}
