
package ejer03_02;


public class Hilo extends Thread {

    private Contador cont;
    private static int id = 0;
    private int hiloId; 
    
    public Hilo(Contador cont) {
        this.cont = cont;
        id++; 
        this.hiloId = id; 

    }

    @Override
    public void run() {
        cont.incrementarContador(hiloId);
    }
}