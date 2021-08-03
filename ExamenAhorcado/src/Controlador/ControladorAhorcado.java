/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Archivos.Palabras;
import Modelo.Ahorcado;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ediss
 */
public class ControladorAhorcado {
    private List<Ahorcado> Ahorcados;
    private Palabras palabras;
    private Ahorcado seleccionado;
    private ArrayList palabra;
    public ControladorAhorcado(Palabras palabras){
        Ahorcados=new ArrayList<>();
        palabra=new ArrayList<>();
        this.palabras=palabras;
        
    }
    public boolean crear(String usuario,int intentos){
        Ahorcado ahorcado=new Ahorcado(this.leer(), usuario, intentos);
        seleccionado=ahorcado;
        return Ahorcados.add(ahorcado);
    }
    public Ahorcado buscar(String usuario){
        for (Ahorcado ahorcado : Ahorcados) {
            if (ahorcado.getUsuario().equals(usuario)) {
                return ahorcado;
            }
        }
        return null;
    }
    public boolean actualizar(String usuario,int intentos){
        Ahorcado ahorcado=this.buscar(usuario);
        if (ahorcado!=null) {
            int posicion=Ahorcados.indexOf(ahorcado);
            ahorcado.setIntentos(intentos);
            ahorcado.setPalabra(this.leer());
            ahorcado.setUsuario(usuario);
            Ahorcados.set(posicion, ahorcado);
            return true;
        }
        return false;
    }
    public boolean eliminar(String usuario){
        Ahorcado ahorcado=this.buscar(usuario);
        if (ahorcado!=null) {
            Ahorcados.remove(ahorcado);
            return true;
        }
        return false;
    }
    public String leer(){
        Random r=new Random();
        List<String> lista= new ArrayList<>();
        lista=palabras.leer();
        int n=r.nextInt(lista.size()-1);
        String palabra=lista.get(n);
        return palabra;
    }
    public int comparar(String consonante,String palabra){ ///******************
        char [] longitud=palabra.toCharArray();
        for (int i = 0; i < longitud.length; i++) {
            String com=String.valueOf(longitud[i]);
            if (com.equals(consonante)) {
                return i+1;
            }
        }
        return 0;
    }

    public List<Ahorcado> getAhorcados() {
        return Ahorcados;
    }

    public void setAhorcados(List<Ahorcado> Ahorcados) {
        this.Ahorcados = Ahorcados;
    }

    public Palabras getPalabras() {
        return palabras;
    }

    public void setPalabras(Palabras palabras) {
        this.palabras = palabras;
    }

    public Ahorcado getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Ahorcado seleccionado) {
        this.seleccionado = seleccionado;
    }
    
}
