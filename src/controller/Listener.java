package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import views.Menu;
import views.Pausa;

import static views.juego.Campo.raqueta1;
import static views.juego.Campo.raqueta2;


public class Listener implements KeyListener {
    
    public static Pausa pausa = new Pausa();
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
            raqueta1.keyPressed(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            raqueta2.keyPressed(e);
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            pausa.setVisible(true);
            Menu.vent.setEnabled(false);
            Hilo.pausa=true;
         
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
            raqueta1.keyReleased(e);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
            raqueta2.keyReleased(e);
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            
        }
    }
}
