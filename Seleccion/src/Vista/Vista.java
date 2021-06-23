/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author ediss
 */
public class Vista extends JFrame {
    //private JPanel panelFigura;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private Panel panelFigura;
    private JPanel panelBotones;
    public Vista(){
        super();
        setTitle("Figuras");
        setBounds(0,0,500,500);
        setLayout(new FlowLayout()); //poner componentes botones uno al lado del otro
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.seleccionador();
    }
    public void seleccionador(){
        //creo primero los botones
        
        panelBotones=new JPanel();
        panelFigura=new Panel();
       
        boton1=new JButton("Linea");
        boton1.setBounds(0,0,150,50);
        panelBotones.add(boton1);
        
        boton2=new JButton("Cuadrado");
        boton2.setBounds(0,0,150,50);
        panelBotones.add(boton2);
        
        boton3=new JButton("Rectangulo");
        boton3.setBounds(0,0,150,50);
        panelBotones.add(boton3);
        
        boton4=new JButton("Circulo");
        boton4.setBounds(0,0,150,50);
        panelBotones.add(boton4);
        
        add(panelBotones,BorderLayout.NORTH);
        
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent me) {
                panelFigura.setCont(3);
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent me) {
                panelFigura.setCont(2);
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent me) {
                panelFigura.setCont(4);
            }
        });
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent me) {
                panelFigura.setCont(1);
            }
        });
        
   
    }
}
