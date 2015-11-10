/**
 * Escribe una clase llamada orden que cree dos hilos y fuerce que la escritura
 * del segundo sea siempre anterior a la escritura por pantalla del primero.    
 * Ejemplo de ejecución. Hola, soy el hilo número 2. Hola, soy el hilo número 1.
 */
package ejercicio5psp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Ejercicio5PSP extends Thread {

    static Ejercicio5PSP t1;
    static Ejercicio5PSP t2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        t1 = new Ejercicio5PSP("hilo1");
        t2 = new Ejercicio5PSP("hilo2");
        t1.start();
        t2.start();
    }

    public Ejercicio5PSP(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        if (getName().equalsIgnoreCase("hilo1")) {
            try {
                t2.join();
                System.out.println("Hola, soy el hilo número " + getName());
            } catch (InterruptedException ex) {
                ;
            }
        } else {
            System.out.println("Hola, soy el hilo número " + getName());
        }
    }

}
