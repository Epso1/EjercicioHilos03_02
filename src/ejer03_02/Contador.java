package ejer03_02;

public class Contador {

    private int contador = 0;
    private int turno = 1;

    public int getContador() {
        return contador;
    }

    public synchronized void incrementarContador(int idHilo) {

        while (turno != idHilo) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("turno: " + turno);
        for (int i = 0; i < 500; i++) {
            contador++;
            System.out.println("Hilo " + idHilo + " lleva " + (i + 1) + " vueltas.");
        }
        System.out.println("*****El hilo " + idHilo + " ha terminado.*****");
        turno++;
        if (turno > 4) {
            turno = 1;
        }
        notifyAll();

    }
}
