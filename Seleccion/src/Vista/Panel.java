/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author ediss
 */
public class Panel extends  JPanel {
    public Figura figura;
    private int cont;
    public Panel(){
        setBounds(0, 0, 500, 500);
        setBackground(Color.BLUE);
        figura=new Figura(0, 0,30,45);
        cont=0;
    }
    @Override
    public void paint(Graphics lienzo){
        lienzo.clearRect(0, 0, 500, 500);
        lienzo.setColor(Color.BLACK);
        switch (cont) {
            case 1:
                lienzo.drawLine(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
            case 2:
                lienzo.drawRect(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
            case 3:
                lienzo.drawOval(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
                break;
            case 4:
                lienzo.drawRect(figura.getX(), figura.getY(), figura.getAlto(), figura.getAlto());
                break;
        }
    }
    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }
    
    
}
