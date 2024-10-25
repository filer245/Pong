package model;

import views.juego.Marcador;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

import static views.juego.Campo.raqueta1;
import static views.juego.Campo.raqueta2;


public class Bola extends JPanel {
    private int x, y;
    public float xa=1f, ya=0.0f;
    public static float speed=1;
    public static int[] direc={0, 1,-1};
    public static int ganA=(int)(Math.random()*2)+1;
    private final int ANCHO = 20, ALTO = 20;

    public Bola(int x, int y) {
        this.x = x;
        this.y = y;
        saque();
    }

    public Rectangle2D getBola() {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }

    public void saque(){
        xa=1f;
        raqueta1.ya=0;
        raqueta2.ya=0;
        speed =1;
        if (ganA==1){
            ya=direc[(int)(Math.random()*2)+1];
        }else if(ganA==2){
            xa=-xa;
            ya=direc[(int)(Math.random()*2)+1];
        }
    }

    public void mover(Rectangle lim) {

        int reb = colision();

        if (reb == 1) {
            xa=xa-0.5f;

            xa = -1*xa;
            speed+=0.25f;

        }
        if (reb == 2) {
            xa=xa+0.5f;
            xa = -xa;
            speed+=0.25f;
        }

        if (x > lim.getMaxX() - ANCHO) {
            gol(lim, 1);
            saque();
        }
        if (x < 0) {
            gol(lim, 2);
            saque();
        }
        if (y > lim.getMaxY() - ALTO) {
            ya = -ya;
        }
        if (y < 0) {
            ya = -ya;
        }


        x += xa;
        y += ya;

        System.out.println(raqueta1.ya+ "\t\t\t"+ raqueta2.ya);
    }

    private void gol(Rectangle lim, int j) {

        if(j==1){Marcador.j1++;ganA=1;}else{Marcador.j2++;ganA=2;}
        x = (int) lim.getCenterX();
        y = (int) lim.getCenterY();
        raqueta1.y = (int)lim.getCenterY()-35;
        raqueta2.y = (int)lim.getCenterY()-35;

        if(Marcador.j1==7||Marcador.j2==7){System.exit(0);}



    }

    private int colision() {
        if (raqueta1.getBounds().intersects(getBounds())) {
            return 1;
        }
        if (raqueta2.getBounds().intersects(getBounds())) {
            return 2;
        }
        return 0;
    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, ANCHO, ALTO);
    }
}
