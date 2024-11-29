package ej3;

public final class Teclado extends Periferico implements Pulsable{
	private String idioma;
	private boolean isMecanico;
	
	
	public Teclado(String nombre, double precio, int anhosEdad, String idioma, boolean isMecanico) {
		super(nombre, precio, anhosEdad);
		this.idioma=idioma;
		this.isMecanico=isMecanico;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public boolean isMecanico() {
		return isMecanico;
	}
	
	public void setMecanico(boolean isMecanico) {
		this.isMecanico = isMecanico;
	}
	
	/** 
	 * Muestra por pantalla que el teclado se está pulsando.
	 */
	@Override
	public void conectar() {
		System.out.println("Conectando el teclado: " + getNombre() + " a través de USB.");
	}
	
	/** 
	 * Muestra por pantalla que el teclado se está conectando.
	 */
	@Override
	public void pulsar() {
		System.out.println("Pulsando las teclas del teclado: " + getNombre());
	}

}
