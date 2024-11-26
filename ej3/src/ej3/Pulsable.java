package ej3;

public interface Pulsable {
	
	public default void pulsar() {
		System.out.println("Pulsando algo.");
	}

}
