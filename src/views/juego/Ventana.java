package views.juego;

import controller.Hilo;
import controller.Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana extends JFrame {
    public static final int ANCHO = 1000;
    public static final int ALTO = 500;
    public static Campo campo = new Campo();

    public static Hilo hilo;

    public Ventana() {
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ANCHO, ALTO);
        setLocationRelativeTo(null);
        setResizable(false);
        add(campo);
        hilo = new Hilo(campo);
        addKeyListener(new Listener());
        hilo.start();
        setVisible(true);

    }
    
   

}
