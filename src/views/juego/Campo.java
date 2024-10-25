package views.juego;

import views.juego.Marcador;
import views.juego.Ventana;
import model.Bola;
import model.Mitad;
import model.Raqueta;

import javax.swing.*;
import java.awt.*;

import static views.juego.Ventana.campo;

public class Campo extends JPanel{
    Bola bola = new Bola(475, 200);
    public static Raqueta raqueta1 = new Raqueta(20, 185);
    public static Raqueta raqueta2 = new Raqueta(945, 185);
    public static Mitad mitad = new Mitad();
    public static Marcador m1 = new Marcador();
    public static Marcador m2 = new Marcador();


    public Campo() {
        setBackground(Color.BLACK);
    }

    public static int getMaxY() {
        return campo.getY();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        dibujar(g2d, m1.getText(Marcador.j1), m2.getText(Marcador.j2) );
        update();
    }


    public void dibujar(Graphics2D g, String m1, String m2) {
        g.fill(bola.getBola());
        g.fill(raqueta1.getRaqueta());
        g.fill(raqueta2.getRaqueta());
        g.setFont(new Font("Tahoma", Font.BOLD, 46));
        g.drawString(m1, 370, 50);
        g.drawString(m2, 610, 50);
        for (int i = -20; i < Ventana.ALTO; i += 75) {
            g.fill(mitad.getMitad(((Ventana.ANCHO / 2)), i));
        }
    }

    public void update() {
        bola.mover(getBounds());
        raqueta1.mover(getBounds());
        raqueta2.mover(getBounds());
    }


}
