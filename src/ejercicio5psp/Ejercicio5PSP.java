/**
 * Escribe una clase llamada orden que cree dos hilos y fuerce que la escritura
 * del segundo sea siempre anterior a la escritura por pantalla del primero.    
 * Ejemplo de ejecución. Hola, soy el hilo número 2. Hola, soy el hilo número 1.
 */
package ejercicio5psp;

/**
 *
 * @author oracle
 */
public class Ejercicio5PSP extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Ejercicio5PSP(1, "#1").start();
        new Ejercicio5PSP(10, "#2").start();
    }

    public Ejercicio5PSP(int prio, String nombre) {
        super(nombre);
        setPriority(prio);
    }

    @Override
    public void run() {
        System.out.println("Hola, soy el hilo número " + getName());
    }

}
