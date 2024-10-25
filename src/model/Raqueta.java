package model;

import views.juego.Campo;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

public class Raqueta {
    public int x;
    public int y;
    float ya = 1;
    public final int ANCHO = 15;
    private final int ALTO = 100;

    public Raqueta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Rectangle2D getRaqueta() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void mover(Rectangle lim) {
        if (y > lim.getMaxY() - ALTO && ya > 0) {
            ya = 0;
        }
        if (y <= 0 && ya < 0) {
            ya = 0;
        }
        
        
        y += ya;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -1*Bola.speed;
        }
        if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = Bola.speed;

        }
    }

    public void keyReleased(KeyEvent e) {
        ya = 0;
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, ANCHO, ALTO);
    }
}
