package vista;

import controlador.ControladorGeneral;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.Arquitecto;
import modelo.DibujoPlanoGeneral;
import modelo.Figura;
import modelo.JefeProyecto;
import modelo.Linea;
import modelo.Plano;
import modelo.Poligono;

public class VistaGeneral {
    public Scanner teclado;
    public ControladorGeneral controladorGeneral;
    public Linea linea;
    public Poligono poligono;
    public Date fechaEntregaPlano;
    public DibujoPlanoGeneral dibujoPlanoGeneral;
    public ArrayList<Arquitecto> listaArquitectos;
    public ArrayList<Figura> listaFiguras;
    public JefeProyecto jefeProyecto;
    public ArrayList<Plano> listaPlanos;

    public VistaGeneral() {
        controladorGeneral = new ControladorGeneral();
        teclado = new Scanner(System.in);
        linea = new Linea();
        poligono = new Poligono();
    }
    
    public void menuGeneral() throws ParseException {
        System.out.println("Seleccione una opcion");
        int opcion = 0;
        do {
            System.out.println("1. Lineas");
            System.out.println("2. Poligonos ");
            System.out.println("3. Figuras");
            System.out.println("4. Artitectos");
            System.out.println("5. Dibujos Plano General");
            System.out.println("6. Planos");
            System.out.println("7. Jefes de Proyecto");
            System.out.println("8. Proyectos");
            System.out.println("9. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    menuLinea();
                    break;
                case 2:
                    menuPoligono();
                    break;
                case 3:
                    menuFigura();
                    break;
                case 4:
                    menuArquitecto();
                    break;
                case 5:
                    menuDibujoPlanoGeneral();
                    break;
                case 6:
                    menuPlano();
                    break;
                case 7:
                    menuJefeProyecto();
                    break;  
                case 8:
                    menuProyecto();

                    break;     
                    
                    
            }
        } while (opcion < 9);
    }

    
    public void menuArquitecto() {
        int opcion = 0;
        do {
            System.out.println("Gestion Arquitectos");
            System.out.println("1. Crear Arquitecto");
            System.out.println("2. Buscar Arquitecto");
            System.out.println("3. Eliminar Arquitecto");
            System.out.println("4. Listar Arquitecto");
            System.out.println("5. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearArquitecto(0, "", "");
                    break;
                case 2:
                    controladorGeneral.buscarArquitecto("");
                    break;
                case 3:
                    controladorGeneral.eliminarArquitecto("");
                    break;
                case 4:
                    controladorGeneral.listarArquitectos();
                    break;
            }
        } while (opcion < 5);
    }
    
    public void menuDibujoPlanoGeneral() {
        int opcion = 0;
        do {
            System.out.println("Gestion Dibujos Plano General");
            System.out.println("1. Crear DibujoPlanoGeneral");
            System.out.println("2. Buscar DibujoPlanoGeneral");
            System.out.println("3. Actualizar numero de figuras");
            System.out.println("4. Eliminar DibujoPlanoGeneral");
            System.out.println("5. Listar DibujoPlanoGeneral");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearDibujoPlanoGeneral(0, 0);
                    break;
                case 2:
                    controladorGeneral.buscarDibujoPlanoGeneral(0);
                    break;
                case 3:
                    controladorGeneral.actualizarNumeroFiguras(0, 0);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarDibujoPlanoGeneral(0);
                    break;
                case 5:
                    controladorGeneral.listarDibujosPlanoGeneral();
                    break;
            }
        } while (opcion < 6);
    }
    
    public void menuLinea() {
        int opcion = 0;
        do {
            System.out.println("Gestion Lineas");
            System.out.println("1. Crear Linea");
            System.out.println("2. Buscar Linea");
            System.out.println("3. Actualizar Lineas");
            System.out.println("4. Eliminar Linea");
            System.out.println("5. Listar Lineas");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearLinea(0, 0.00, 0.00,  0.00,  0.00, 0.00);
                    break;
                case 2:
                    controladorGeneral.buscarLinea(0);
                    break;
                case 3:
                    controladorGeneral.actualizarLinea(0, 0.00, 0.00,  0.00,  0.00, 0.00);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarLinea(0);
                    break;
                case 5:
                    controladorGeneral.listarLineas();
                    break;
            }
        } while (opcion < 6);
    }
    
    public void menuPoligono() {
        int opcion = 0;
        do {
            System.out.println("Gestion Poligono");
            System.out.println("1. Crear Poligono");
            System.out.println("2. Buscar Poligono");
            System.out.println("3. Actualizar Poligono");
            System.out.println("4. Eliminar Poligono");
            System.out.println("5. Listar Poligonos");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearPoligono(0, 0, linea , 0, 0);
                    break;
                case 2:
                    controladorGeneral.buscarPoligono(0);
                    break;
                case 3:
                    controladorGeneral.actualizarPoligono(0, 0, linea , 0, 0);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarPoligono(0);
                    break;
                case 5:
                    controladorGeneral.listarPoligonos();
                    break;
            }
        } while (opcion < 6);
    }
    public void menuFigura() {
        int opcion = 0;
        do {
            System.out.println("Gestion Figura");
            System.out.println("1. Crear Figura");
            System.out.println("2. Buscar Figura");
            System.out.println("3. Actualizar Figura");
            System.out.println("4. Eliminar Figura");
            System.out.println("5. Listar Figuras");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearFigura(0, "", "", poligono);
                    break;
                case 2:
                    controladorGeneral.buscarFigura(0);
                    break;
                case 3:
                    controladorGeneral.actualizarFigura(0, "", "", poligono);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarFigura(0);
                    break;
                case 5:
                    controladorGeneral.listarFiguras();
                    break;
            }
        } while (opcion < 6);
    }
    
    public void menuJefeProyecto() {
        int opcion = 0;
        do {
            System.out.println("Gestion Jefe Proyecto");
            System.out.println("1. Crear Jefe Proyecto");
            System.out.println("2. Buscar Jefe Proyecto");
            System.out.println("3. Actualizar Jefe Proyecto");
            System.out.println("4. Eliminar Jefe Proyecto");
            System.out.println("5. Listar Jefes Proyecto");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearJefeProyecto(0, "", "", "", "");
                    break;
                case 2:
                    controladorGeneral.buscarJefeProyecto("");
                    break;
                case 3:
                    controladorGeneral.actualizarJefeProyecto("", "", "", "");
                    break;
                    
                case 4:
                    controladorGeneral.eliminarJefeProyecto("");
                    break;
                case 5:
                    controladorGeneral.listarJefesProyecto();
                    break;
            }
        } while (opcion < 6);
    }
    public void menuPlano() throws ParseException {
        int opcion = 0;
        do {
            System.out.println("Gestion Plano");
            System.out.println("1. Crear Plano");
            System.out.println("2. Buscar Plano");
            System.out.println("3. Actualizar Plano");
            System.out.println("4. Eliminar Plano");
            System.out.println("5. Listar Plano");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearPlano(0, fechaEntregaPlano, listaArquitectos, dibujoPlanoGeneral, listaFiguras);
                    break;
                case 2:
                    controladorGeneral.buscarPlano(opcion);
                    break;
                case 3:
                    controladorGeneral.actualizarPlano(0, fechaEntregaPlano, listaArquitectos, dibujoPlanoGeneral, listaFiguras);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarPlano(opcion);
                    break;
                case 5:
                    controladorGeneral.listarPlano();
                    break;
            }
        } while (opcion < 6);
    }
    
    public void menuProyecto()  {
        int opcion = 0;
        do {
            System.out.println("Gestion Proyecto");
            System.out.println("1. Crear Proyecto");
            System.out.println("2. Buscar Proyecto");
            System.out.println("3. Actualizar Proyecto");
            System.out.println("4. Eliminar Proyecto");
            System.out.println("5. Listar Proyectos");
            System.out.println("6. Salir");
            opcion = teclado.nextInt();
            System.out.println("");
            switch (opcion) {
                case 1:
                    controladorGeneral.crearProyecto(0, "", jefeProyecto, listaPlanos);
                    break;
                case 2:
                    controladorGeneral.buscarProyecto(0);
                    break;
                case 3:
                    controladorGeneral.actualizarProyecto(0, "", jefeProyecto, listaPlanos);
                    break;
                    
                case 4:
                    controladorGeneral.eliminarProyecto(0);
                    break;
                case 5:
                    controladorGeneral.listarProyectos();
                    break;
            }
        } while (opcion < 6);
    }
}

