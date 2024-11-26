package ej3;

public class Main {

    public static void main(String[] args) {
        Raton raton = new Raton("Logitech G502", 30.50, 2, 1200, 6);
        Pantalla pantalla = new Pantalla("BenQ XL2411K", 250.75, 1, 27.0, 75);
        Teclado teclado = new Teclado("Omen Nitro", 100.0, 1, "Inglés", true);

        raton.pulsar();
        raton.conectar();
        
        pantalla.conectar();
        
        teclado.pulsar();
        teclado.conectar();
    }
}

