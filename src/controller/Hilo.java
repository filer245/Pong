package controller;

import views.juego.Campo;

public class Hilo extends Thread {
    Campo campo = new Campo();
    public static boolean pausa = false;

    public Hilo(Campo campo) {
        this.campo = campo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!pausa){campo.repaint();}
            
        }
    }
}
