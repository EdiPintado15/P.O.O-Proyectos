/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1;

import java.util.Scanner;

/**
 *
 * @author ediss
 */
public class Tarea1 {
     public static void main(String[] args) {
        System.out.println("Ingrese una edad para determinar el grupo al que pertenece");
        Scanner teclado=new Scanner(System.in);
        int a=teclado.nextInt();
        System.out.println(a);
        if (a<=2 && a>0){
            System.out.println("Pertenece a los bebes");
        }else if(a<=12 && a>2){
            System.out.println("Pertenece a los ninos");
        }else if(a<=18 && a>12){
            System.out.println("Pertenece a los jovenes");
        }else if(a<=64 && a>18){
            System.out.println("Pertenece a los adultos");
        }else{
            System.out.println("Pertenece a los adultos mayores");
        }
        
     }     
    
}