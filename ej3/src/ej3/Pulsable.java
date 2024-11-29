package ej3;


/**
 * Interfaz que implementa un comportamiento de pulsar.
 * 
 * @author Luis
 *
 */
public interface Pulsable {
	
	public default void pulsar() {
		System.out.println("Pulsando algo.");
	}

}
