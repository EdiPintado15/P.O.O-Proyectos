/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debererepeticion;

/**
 *
 * @author ediss
 */
public class DebereRepeticion {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        //while' tablas de multiplicar
        int contador = 1 ;
        System.out.println("While");
        int numero=5;
        while (contador<=12){
            int resultado=contador*numero;
            System.out.println(numero+"*"+contador+"="+resultado);
            contador++;
        } 
       
        System.out.println("do while");
        int contador2=12;
        do{
            int resultado=contador2*numero;
            System.out.println(numero+"*"+contador2+"="+resultado);
            contador2 -=1; 
            
        }while(contador2>=1);
        System.out.println("for");
        for(int contador3=1;contador3<=12;contador3++){
            int resultado=numero*contador3;
            System.out.println(numero+"*"+contador3+"="+resultado);
        }
    }
    
}
