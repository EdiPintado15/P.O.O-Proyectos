/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.deber.serie.fibonacci;

/**
 *
 * @author ediss
 */
public class DeberSERIEFIBONACCI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("serie Fibonacci ");
        int Cant= 12;
        int a = 0;
        int b = 1;
        int c = 1;
        System.out.println(a);
        for(int i = 1; i < Cant; i++){
        System.out.println(b);
        c = a + b;
        a = b;
        b = c;
       }    
      
    }   
}

    
    

