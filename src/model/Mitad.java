package model;

import java.awt.geom.Rectangle2D;

public class Mitad {

    public static final int ANCHO = 4, ALTO = 50;


    public Rectangle2D getMitad(int x, int y) {
        return new Rectangle2D.Double(x, y, ANCHO, ALTO);
    }
}
