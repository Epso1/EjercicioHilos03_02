package ejer03_02;

/**
 *
 * @author cesar
 */
public class Main {
    public static void main(String[] args) {
        Contador contadorCompartido = new Contador();

        Hilo hilo1 = new Hilo(contadorCompartido);
        Hilo hilo2 = new Hilo(contadorCompartido);
        Hilo hilo3 = new Hilo(contadorCompartido);
        Hilo hilo4 = new Hilo(contadorCompartido);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            System.out.println("Error en la espera de los hilos.");
        }

        System.out.println("El valor del contador compartido es: " + contadorCompartido.getContador());
    }
    
}
