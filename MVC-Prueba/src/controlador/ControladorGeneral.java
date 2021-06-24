package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Arquitecto;
import modelo.DibujoPlanoGeneral;
import modelo.Figura;
import modelo.JefeProyecto;
import modelo.Linea;
import modelo.Plano;
import modelo.Poligono;
import modelo.Proyecto;

public class ControladorGeneral {
    private ArrayList<Arquitecto> listaArquitectos;
    private ArrayList<DibujoPlanoGeneral> listaDibujosPlanoGeneral; 
    private ArrayList<Figura> listaFiguras;
    private ArrayList<JefeProyecto> listaJefeProyectos;
    private ArrayList<Linea> listaLineas;
    private ArrayList<Plano> listaPlanos;
    private ArrayList<Poligono> listaPoligonos;
    private ArrayList<Proyecto> listaProyectos;

    public ControladorGeneral() {
        listaArquitectos = new ArrayList<Arquitecto>();
        listaDibujosPlanoGeneral = new ArrayList<DibujoPlanoGeneral>();
        listaFiguras = new ArrayList<Figura>();
        listaJefeProyectos = new ArrayList<JefeProyecto>();
        listaLineas = new ArrayList<Linea>();
        listaPlanos = new ArrayList<Plano>();
        listaPoligonos = new ArrayList<Poligono>();
        listaProyectos = new ArrayList<Proyecto>();
    }
    
/*----------------------------------------------------------------------------*/
/*---------------------------- CONTROLADOR PROYECTO --------------------------*/
/*----------------------------------------------------------------------------*/
public long generarCodigoProyecto() {
        return (listaProyectos.size() > 0) ? listaProyectos.get(listaProyectos.size() - 1).getCodigoProyecto() + 1 : 1;
    }
public ArrayList crearProyecto(long codigoProyecto, String nombreProyecto, JefeProyecto jefeProyecto, List<Plano> listaPlanos)  {
        listaPlanos = new  ArrayList<Plano>();
        Proyecto proyecto = new Proyecto( codigoProyecto,  nombreProyecto,  jefeProyecto, listaPlanos);
        codigoProyecto = generarCodigoProyecto();
        proyecto.setCodigoProyecto(codigoProyecto);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Proyecto");
        proyecto.setNombreProyecto(teclado.next());
        System.out.println("");
        System.out.println("Seleccione una opcion");
        int opcion1 = 0;
        do {
            System.out.println("1. Agregar Planos al Proyecto");
            System.out.println("2. Salir");
            opcion1 = teclado.nextInt();
            switch (opcion1) {
                case 1:
                    Plano plano = new Plano();
                    plano = buscarPlano(0);
                    listaPlanos.add(plano);
                    proyecto.setListaPlanos(listaPlanos);
                    break;
            }
        } while (opcion1 < 2);
        System.out.println("Agregar Jefe de Proyecto al Proyecto");
        jefeProyecto = buscarJefeProyecto("");
        proyecto.setJefeProyecto(jefeProyecto);
        listaProyectos.add(proyecto);
        System.out.println("Se creo el Proyecto " + proyecto);
        System.out.println("");
        return listaProyectos;
    }
public Proyecto buscarProyecto(long codigoProyecto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo del Proyecto a buscar");
        codigoProyecto = teclado.nextLong();
        System.out.println("");
        for (Proyecto proyecto : listaProyectos) {
            if ((String.valueOf(proyecto.getCodigoProyecto())).equals((String.valueOf(codigoProyecto))) == true) {
                System.out.println("Se encontro el Proyecto: " + proyecto);
                System.out.println("");
                return proyecto;
            }
        }
        return null;
    }
public boolean actualizarProyecto(long codigoProyecto, String nombreProyecto, JefeProyecto jefeProyecto, List<Plano> listaPlanos)  {
    Proyecto proyecto = new Proyecto( codigoProyecto,  nombreProyecto,  jefeProyecto, listaPlanos);
    Scanner teclado = new Scanner(System.in);
    if (proyecto != null) {
        proyecto =  buscarProyecto(codigoProyecto);
        System.out.println("Ingrese el nuevo nombre del Proyecto");
        proyecto.setNombreProyecto(teclado.next());
        System.out.println("");
        System.out.println("Seleccione una opcion");
        int opcion1 = 0;
        do {
            System.out.println("1. Agregar Planos al Proyecto");
            System.out.println("2. Salir");
            opcion1 = teclado.nextInt();
            switch (opcion1) {
                case 1:
                    Plano plano = new Plano();
                    plano = buscarPlano(0);
                    listaPlanos.add(plano);
                    proyecto.setListaPlanos(listaPlanos);
                    break;
            }
        } while (opcion1 < 2);
        System.out.println("Agregar nuevo Jefe de Proyecto al Proyecto");
        jefeProyecto = buscarJefeProyecto("");
        proyecto.setJefeProyecto(jefeProyecto);
        int posicion = listaProyectos.indexOf(proyecto);
        listaProyectos.set(posicion, proyecto);
        System.out.println("Se actualizo el Proyecto : " + proyecto);
        System.out.println("");
        return true;
    }
    return false;
}
public boolean eliminarProyecto(long codigoProyecto) {
    Proyecto proyecto = new Proyecto(codigoProyecto);
    proyecto = buscarProyecto( codigoProyecto);
    if (proyecto != null) {
            listaProyectos .remove(proyecto);
            System.out.println("Se elimino el Proyecto: " + proyecto);
            System.out.println("");
        }
        return true;
    }
public void listarProyectos() {
        System.out.println("El Proyecto es");
        for (int i = 0; i <= listaProyectos.size() - 1; i++) {
            System.out.println(listaProyectos.get(i));
        }
        System.out.println("");
    }

/*----------------------------------------------------------------------------*/
/*------------------------------- CONTROLADOR PLANO --------------------------*/
/*----------------------------------------------------------------------------*/     
public long generarCodigoPlano() {
        return (listaPlanos.size() > 0) ? listaPlanos.get(listaPlanos.size() - 1).getCodigoPlano() + 1 : 1;
    }   
public ArrayList crearPlano(long codigoPlano, Date fechaEntregaPlano, ArrayList<Arquitecto> listaArquitectos, DibujoPlanoGeneral dibujoPlanoGeneral, ArrayList<Figura> listaFiguras) throws ParseException {
        listaArquitectos = new  ArrayList<Arquitecto>();
        listaFiguras = new  ArrayList<Figura>();
        Plano plano = new Plano(codigoPlano, fechaEntregaPlano,  listaArquitectos,  dibujoPlanoGeneral, listaFiguras);
        codigoPlano = generarCodigoPlano();
        plano.setCodigoPlano(codigoPlano);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la fecha de entrega en formato dd/MM/yyyyy ");
        String fechaComoTexto = teclado.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fechaEntregaPlano = df.parse(fechaComoTexto);
        plano.setFechaEntregaPlano(fechaEntregaPlano);
        
        System.out.println("Seleccione una opcion");
        int opcion1 = 0;
        do {
            System.out.println("1. Agregar Arquitectos al Proyecto");
            System.out.println("2. Salir");
            opcion1 = teclado.nextInt();
            switch (opcion1) {
                case 1:
                    Arquitecto arquitecto = new Arquitecto();
                    arquitecto = buscarArquitecto("");
                    listaArquitectos.add(arquitecto);
                    plano.setListaArquitectos(listaArquitectos);
                    break;
            }
        } while (opcion1 < 2);
        
        System.out.println("Seleccione una opcion");
        int opcion2 = 0;
        do {
            System.out.println("1. Agregar Figuras al Proyecto");
            System.out.println("2. Salir");
            opcion2 = teclado.nextInt();
            switch (opcion2) {
                case 1:
                    Figura figura = new Figura();
                    figura = buscarFigura(0) ;
                    listaFiguras.add(figura);
                    plano.setListaFiguras(listaFiguras);
                    break;
            }
        } while (opcion2 < 2);
        
        System.out.println("Agregar Dibujo Plano general");
        dibujoPlanoGeneral =  buscarDibujoPlanoGeneral(0); 
        plano.setDibujoPlanoGeneral(dibujoPlanoGeneral);
        
        listaPlanos.add(plano);
        System.out.println("Se creo el Plano: " + plano);
        System.out.println("");
        return listaPlanos;
    }
public Plano buscarPlano(long codigoPlano) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo del Plano a buscar");
        codigoPlano = teclado.nextLong();
        System.out.println("");
        for (Plano plano : listaPlanos) {
            if ((String.valueOf(plano.getCodigoPlano())).equals((String.valueOf(codigoPlano))) == true) {
                System.out.println("Se encontro el Plano: " + plano);
                System.out.println("");
                return plano;
            }
        }
        return null;
    }
public boolean actualizarPlano(long codigoPlano, Date fechaEntregaPlano, ArrayList<Arquitecto> listaArquitectos, DibujoPlanoGeneral dibujoPlanoGeneral, ArrayList<Figura> listaFiguras) throws ParseException {
    Plano plano = new Plano(codigoPlano,  fechaEntregaPlano, listaArquitectos,  dibujoPlanoGeneral,  listaFiguras);
    Scanner teclado = new Scanner(System.in);
    if (plano != null) {
        plano =  buscarPlano(codigoPlano);
        System.out.println("Ingrese la nueva fecha de entrega en formato dd/MM/yyyyy ");
        String fechaComoTexto = teclado.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        fechaEntregaPlano = df.parse(fechaComoTexto);
        plano.setFechaEntregaPlano(fechaEntregaPlano);
        System.out.println("Seleccione una opcion");
        int opcion1 = 0;
        do {
            System.out.println("1. Agregar Arquitectos al Proyecto");
            System.out.println("2. Salir");
            opcion1 = teclado.nextInt();
            switch (opcion1) {
                case 1:
                    Arquitecto arquitecto = new Arquitecto();
                    arquitecto = buscarArquitecto("");
                    listaArquitectos.add(arquitecto);
                    plano.setListaArquitectos(listaArquitectos);
                    break;
            }
        } while (opcion1 < 2);
        System.out.println("Seleccione una opcion");
        int opcion2 = 0;
        do {
            System.out.println("1. Agregar Figuras al Proyecto");
            System.out.println("2. Salir");
            opcion2 = teclado.nextInt();
            switch (opcion2) {
                case 1:
                    Figura figura = new Figura();
                    figura = buscarFigura(0) ;
                    listaFiguras.add(figura);
                    plano.setListaFiguras(listaFiguras);
                    break;
            }
        } while (opcion2 < 2);
        
        System.out.println("Agregar Dibujo Plano general");
        dibujoPlanoGeneral =  buscarDibujoPlanoGeneral(0); 
        plano.setDibujoPlanoGeneral(dibujoPlanoGeneral);
            int posicion = listaPlanos.indexOf(plano);
            listaPlanos.set(posicion, plano);
            System.out.println("Se actualizo el Plano : " + plano);
            System.out.println("");
            return true;
        }
        return false;
    }
public boolean eliminarPlano(long codigoPlano) {
        Plano plano = new Plano(codigoPlano);
        plano =  buscarPlano( codigoPlano);
        if (plano != null) {
            listaPlanos .remove(plano);
            System.out.println("Se elimino el Plano: " + plano);
            System.out.println("");
        }
        return true;
    }
public void listarPlano() {
        System.out.println("El Plano es");
        for (int i = 0; i <= listaPlanos.size() - 1; i++) {
            System.out.println(listaPlanos.get(i));
        }
        System.out.println("");
    }



/*----------------------------------------------------------------------------*/
/*--------------------------- CONTROLADOR JEFEPROYECTO -----------------------*/
/*----------------------------------------------------------------------------*/   
public long generarCodigoJefeProyecto() {
        return (listaJefeProyectos.size() > 0) ? listaJefeProyectos.get(listaJefeProyectos.size() - 1).getCodigoJefeProyecto() + 1 : 1;
    }    
public ArrayList crearJefeProyecto(long codigoJefeProyecto, String nombreJefeProyecto, String direccionJefeProyecto, String telefonoJefeProyecto, String cedulaJefeProyecto) {
        JefeProyecto jefeProyecto = new JefeProyecto( codigoJefeProyecto,  nombreJefeProyecto,  direccionJefeProyecto,  telefonoJefeProyecto,  cedulaJefeProyecto);
        codigoJefeProyecto = generarCodigoJefeProyecto();
        jefeProyecto.setCodigoJefeProyecto(codigoJefeProyecto);
         Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Jefe Proyecto");
        jefeProyecto.setNombreJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese la direccion del Jefe Proyecto");
        jefeProyecto.setDireccionJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese el telefono del Jefe Proyecto");
        jefeProyecto.setTelefonoJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese la cedula del Jefe Proyecto");
        jefeProyecto.setCedulaJefeProyecto(teclado.next());
        System.out.println("");
        listaJefeProyectos.add(jefeProyecto);
        System.out.println("Se creo el Jefe Proyecto : " + jefeProyecto);
        System.out.println("");
        return listaJefeProyectos;
    }
 public JefeProyecto buscarJefeProyecto(String cedulaJefeProyecto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la cedula del Jefe Proyecto a buscar");
        cedulaJefeProyecto = teclado.next();
        System.out.println("");
        for (JefeProyecto jefeProyecto : listaJefeProyectos) {
            if (jefeProyecto.getCedulaJefeProyecto().equals(cedulaJefeProyecto) == true) {
                System.out.println("Se encontro el Jefe Proyecto: " + jefeProyecto);
                System.out.println("");
                return jefeProyecto;
            }
        }
        return null;
    }
public boolean actualizarJefeProyecto( String nombreJefeProyecto, String direccionJefeProyecto, String telefonoJefeProyecto, String cedulaJefeProyecto) {
    JefeProyecto jefeProyecto = new JefeProyecto(nombreJefeProyecto,  direccionJefeProyecto,  telefonoJefeProyecto,  cedulaJefeProyecto);
        Scanner teclado = new Scanner(System.in);
        if (jefeProyecto != null) {
            jefeProyecto = buscarJefeProyecto( cedulaJefeProyecto);
        System.out.println("Ingrese el nuevo nombre del Jefe Proyecto");
        jefeProyecto.setNombreJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese la nueva direccion del Jefe Proyecto");
        jefeProyecto.setDireccionJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese el nuevo telefono del Jefe Proyecto");
        jefeProyecto.setTelefonoJefeProyecto(teclado.next());
        System.out.println("");
        System.out.println("Ingrese la nueva cedula del Jefe Proyecto");
        jefeProyecto.setCedulaJefeProyecto(teclado.next());
        System.out.println("");
        int posicion = listaJefeProyectos.indexOf(jefeProyecto);
        listaJefeProyectos.set(posicion, jefeProyecto);
        System.out.println("Se actualizo el Jefe Proyecto: " + jefeProyecto);
        System.out.println("");
        return true;
        }
        return false;
    }
public boolean eliminarJefeProyecto(String cedulaJefeProyecto) {
        JefeProyecto jefeProyecto = new JefeProyecto(cedulaJefeProyecto);
        jefeProyecto = buscarJefeProyecto( cedulaJefeProyecto);
        if (jefeProyecto != null) {
            listaJefeProyectos .remove(jefeProyecto);
            System.out.println("Se elimino el Jefe Proyecto: " + jefeProyecto);
            System.out.println("");
        }
        return true;
    }
public void listarJefesProyecto() {
        System.out.println("Lista de Jefes Proyecto");
        for (int i = 0; i <= listaJefeProyectos.size() - 1; i++) {
            System.out.println(listaJefeProyectos.get(i));
        }
        System.out.println("");
    }










/*----------------------------------------------------------------------------*/
/*------------------------------ CONTROLADOR FIGURA --------------------------*/
/*----------------------------------------------------------------------------*/    
public long generarCodigoFigura() {
        return (listaFiguras.size() > 0) ? listaFiguras.get(listaFiguras.size() - 1).getCodigoFigura() + 1 : 1;
    } 
public ArrayList crearFigura(long codigoFigura, String nombreFigura, String color, Poligono poligono) {
        Figura figura = new Figura(codigoFigura, nombreFigura, color, poligono);
        codigoFigura = generarCodigoFigura();
        figura.setCodigoFigura(codigoFigura);
        poligono = buscarPoligono(0);
        figura.setPoligono(poligono);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la Figura");
        figura.setNombreFigura(teclado.next());
        System.out.println("");
        System.out.println("Ingrese el color de la Figura");
        figura.setColor(teclado.next());
        System.out.println("");
        listaFiguras.add(figura);
        System.out.println("Se creo la Figura: " + figura);
        System.out.println("");
        return listaFiguras;
    }
public Figura buscarFigura(long codigoFigura) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo de la Figura a buscar ");
        codigoFigura = teclado.nextLong();
        System.out.println("");
        for (Figura figura : listaFiguras) {
            if ((String.valueOf(figura.getCodigoFigura())).equals((String.valueOf(codigoFigura))) == true) {
                System.out.println("Se encontro la Figura: " + figura);
                System.out.println("");
                return figura;
            }
        }
        return null;
    }
public boolean actualizarFigura(long codigoFigura, String nombreFigura, String color, Poligono poligono) {
    Figura figura = new Figura( codigoFigura,  nombreFigura,  color, poligono);
        Scanner teclado = new Scanner(System.in);
        if (figura != null) {
            figura = buscarFigura(codigoFigura);
            figura.setPoligono(poligono);
            poligono = buscarPoligono(0);
            System.out.println("Ingrese el nuevo nombre de la Figura");
            figura.setNombreFigura(teclado.next());
            System.out.println("");
            System.out.println("Ingrese el nuevo color de la Figura");
            figura.setColor(teclado.next());
            System.out.println("");
            int posicion = listaFiguras.indexOf(figura);
            listaFiguras.set(posicion, figura);
            System.out.println("Se actualizo ls Figura : " + figura);
            System.out.println("");
            return true;
        }
        return false;
    }
public boolean eliminarFigura(long codigoFigura) {
        Figura figura = new Figura(codigoFigura);
        figura = buscarFigura( codigoFigura);
        if (figura != null) {
            listaFiguras .remove(figura);
            System.out.println("Se elimino la Figura: " + figura);
            System.out.println("");
        }
        return true;
    }
public void listarFiguras() {
        System.out.println("Lista de Figuras");
        for (int i = 0; i <= listaFiguras.size() - 1; i++) {
            System.out.println(listaFiguras.get(i));
        }
        System.out.println("");
    }






/*----------------------------------------------------------------------------*/
/*---------------------- CONTROLADOR DIBUJOPLANOGENERAL ----------------------*/
/*----------------------------------------------------------------------------*/
public long generarCodigoDibujoPlanoGeneral() {
        return (listaDibujosPlanoGeneral.size() > 0) ? listaDibujosPlanoGeneral.get(listaDibujosPlanoGeneral.size() - 1).getCodigoDibujoPlanoGeneral() + 1 : 1;
    }  
public ArrayList crearDibujoPlanoGeneral(long codigoDibujoPlanoGeneral, int numeroFiguras) {
        DibujoPlanoGeneral  dibujoPlanoGeneral = new DibujoPlanoGeneral(codigoDibujoPlanoGeneral, numeroFiguras);
        codigoDibujoPlanoGeneral = generarCodigoDibujoPlanoGeneral();
        dibujoPlanoGeneral.setCodigoDibujoPlanoGeneral(codigoDibujoPlanoGeneral);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero de figuras");
        dibujoPlanoGeneral.setNumeroFiguras(teclado.nextInt());
        System.out.println("");

        listaDibujosPlanoGeneral.add(dibujoPlanoGeneral);
        System.out.println("Se creo el Dibujo Plano General: " + dibujoPlanoGeneral);
        System.out.println("");
        return listaDibujosPlanoGeneral;
    }
public DibujoPlanoGeneral buscarDibujoPlanoGeneral(long codigoDibujoPlanoGeneral) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo del Dibujo Plano General a buscar ");
        codigoDibujoPlanoGeneral = teclado.nextLong();
        System.out.println("");
        for (DibujoPlanoGeneral dibujoPlanoGeneral : listaDibujosPlanoGeneral) {
            if ((String.valueOf(dibujoPlanoGeneral.getCodigoDibujoPlanoGeneral())).equals((String.valueOf(codigoDibujoPlanoGeneral))) == true) {
                System.out.println("Se encontro el Dibujo Plano General: " + dibujoPlanoGeneral);
                System.out.println("");
                return dibujoPlanoGeneral;
            }
        }
        return null;
    }
public boolean actualizarNumeroFiguras(long codigoDibujoPlanoGeneral, int numeroFiguras) {
    DibujoPlanoGeneral dibujoPlanoGeneral = new DibujoPlanoGeneral(codigoDibujoPlanoGeneral, numeroFiguras);
        Scanner teclado = new Scanner(System.in);
        if (dibujoPlanoGeneral != null) {
            dibujoPlanoGeneral = buscarDibujoPlanoGeneral(codigoDibujoPlanoGeneral);
            System.out.println("Ingrese el nuevo numero de figuras: " + dibujoPlanoGeneral);
            numeroFiguras = teclado.nextInt();
            System.out.println("");
            int posicion = listaDibujosPlanoGeneral.indexOf(dibujoPlanoGeneral);
            dibujoPlanoGeneral.setNumeroFiguras(numeroFiguras);
            listaDibujosPlanoGeneral.set(posicion, dibujoPlanoGeneral);
            System.out.println("Se actualizo el nuevo numero de figura del Dibujo Plano General a buscars : " + dibujoPlanoGeneral);
            System.out.println("");
            return true;
        }
        return false;
    }
public boolean eliminarDibujoPlanoGeneral(long codigoDibujoPlanoGeneral) {
        DibujoPlanoGeneral dibujoPlanoGeneral = new DibujoPlanoGeneral(codigoDibujoPlanoGeneral);
        dibujoPlanoGeneral = buscarDibujoPlanoGeneral(codigoDibujoPlanoGeneral);
        if (dibujoPlanoGeneral != null) {
            listaDibujosPlanoGeneral .remove(dibujoPlanoGeneral);
            System.out.println("Se elimino el Dibujo Pano General: " + dibujoPlanoGeneral);
            System.out.println("");
        }
        return true;
    }
public void listarDibujosPlanoGeneral() {
        System.out.println("Lista de Dibujos Plano General");
        for (int i = 0; i <= listaDibujosPlanoGeneral.size() - 1; i++) {
            System.out.println(listaDibujosPlanoGeneral.get(i));
        }
        System.out.println("");
    }



/*----------------------------------------------------------------------------*/
/*--------------------------- CONTROLADOR ARQUITECTO -------------------------*/
/*----------------------------------------------------------------------------*/
public long generarCodigoArquitecto() {
        return (listaArquitectos.size() > 0) ? listaArquitectos.get(listaArquitectos.size() - 1).getCodigoArquitecto() + 1 : 1;
    } 
public ArrayList crearArquitecto(long codigoArquitecto, String nombreArquitecto, String cedulaArquitecto) {
        Arquitecto  arquitecto = new Arquitecto(codigoArquitecto, nombreArquitecto, cedulaArquitecto);
        codigoArquitecto = generarCodigoArquitecto();
        arquitecto.setCodigoArquitecto(codigoArquitecto);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del arquitecto");
        arquitecto.setNombreArquitecto(teclado.nextLine());
        System.out.println("");
        System.out.println("Ingrese la cedula del arquitecto");
        arquitecto.setCedulaArquitecto(teclado.next());
        System.out.println("");
        
        listaArquitectos.add(arquitecto);
        System.out.println("Se creo el arquitecto: " + arquitecto);
        System.out.println("");
        return listaArquitectos;
    }
public Arquitecto buscarArquitecto(String cedulaArquitecto) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la cedula del arquitecto a buscar");
        cedulaArquitecto = teclado.next();
        System.out.println("");
        for (Arquitecto  arquitecto : listaArquitectos) {
            if (arquitecto.getCedulaArquitecto().equals(cedulaArquitecto) == true) {
                System.out.println("Se encontro el arquitecto: " + arquitecto);
                System.out.println("");
                return arquitecto;
            }
        }
        return null;
    }
public boolean actualizarArquitecto() {
        return false;
    }
public boolean eliminarArquitecto(String cedulaArquitecto) {
        Arquitecto arquitecto = new Arquitecto(cedulaArquitecto);
        arquitecto = buscarArquitecto(cedulaArquitecto);
        if (arquitecto != null) {
            listaArquitectos .remove(arquitecto);
            System.out.println("Se elimino el arquitecto: " + arquitecto);
            System.out.println("");
        }
        return true;
    }
public void listarArquitectos() {
        System.out.println("Lista de Arquitectos");
        for (int i = 0; i <= listaArquitectos.size() - 1; i++) {
            System.out.println(listaArquitectos.get(i));
        }
        System.out.println("");
    }



/*----------------------------------------------------------------------------*/
/*---------------------------- CONTROLADOR POLIGONO --------------------------*/
/*----------------------------------------------------------------------------*/
public long generarCodigoPoligono() {
        return (listaPoligonos.size() > 0) ? listaPoligonos.get(listaPoligonos.size() - 1).getCodigoPoligono() + 1 : 1;
    } 
public ArrayList crearPoligono(long codigoPoligono, int numeroLineasContenidas, Linea LineaForman,  double perimetro, double area) {
        Poligono poligono = new Poligono(codigoPoligono,  numeroLineasContenidas,  LineaForman, perimetro,  area);
        codigoPoligono = generarCodigoPoligono();
        poligono.setCodigoPoligono(codigoPoligono);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el numero de lineas que contiene el poligono");
        poligono.setNumeroLineasContenidas(teclado.nextInt());
        Linea linea = new Linea();
        linea = buscarLinea(0);
        poligono.setLineaForman(linea);
        perimetro=(poligono.getNumeroLineasContenidas())*(linea.getLongitud());
        poligono.setPerimetro(perimetro);
        if ((poligono.getNumeroLineasContenidas()) >= 5){
            System.out.println("Ingrese el valor de la apotema"); 
            double apotema = teclado.nextDouble();
            area = (perimetro*apotema)/2;
            poligono.setArea(area);
        } 
        if ((poligono.getNumeroLineasContenidas()) == 4){
            area = (linea.getLongitud())*(linea.getLongitud());
            poligono.setArea(area);
        } 
        if ((poligono.getNumeroLineasContenidas()) == 3){
            System.out.println("Ingrese el valor de la altuta"); 
            double altura = teclado.nextDouble();
            area = ((linea.getLongitud())*(altura))/2;
            poligono.setArea(area);
        } 
        listaPoligonos.add(poligono);
        System.out.println("Se creo el poligono: " + poligono);
        System.out.println("");
        return listaPoligonos;
    }
public Poligono buscarPoligono(long codigoPoligono) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo del poligono a buscar");
        codigoPoligono = teclado.nextLong();
        System.out.println("");
        for (Poligono poligono : listaPoligonos) {
            if ((String.valueOf(poligono.getCodigoPoligono())).equals((String.valueOf(codigoPoligono))) == true) {
                System.out.println("Se encontro el poligono : " + poligono);
                System.out.println("");
                return poligono;
            }
        }
        return null;
    }
public boolean actualizarPoligono(long codigoPoligono, int numeroLineasContenidas, Linea LineaForman,  double perimetro, double area) {
    Poligono poligono = new Poligono(codigoPoligono,  numeroLineasContenidas,  LineaForman,   perimetro,  area);
        Scanner teclado = new Scanner(System.in);
        if (poligono != null) {
            poligono = buscarPoligono(codigoPoligono);
            System.out.println("Ingrese el  nuevo numero de lineas que contiene el poligono: " + poligono);
            numeroLineasContenidas = teclado.nextInt();
            System.out.println("");
            Linea linea = new Linea();
            linea = buscarLinea(0);
            poligono.setLineaForman(linea);
            perimetro=(poligono.getNumeroLineasContenidas())*(linea.getLongitud());
            poligono.setPerimetro(perimetro);
            if ((poligono.getNumeroLineasContenidas()) >= 5){
            System.out.println("Ingrese el valor de la apotema"); 
            double apotema = teclado.nextDouble();
            area = (perimetro*apotema)/2;
            poligono.setArea(area);
            } 
            if ((poligono.getNumeroLineasContenidas()) == 4){
            area = (linea.getLongitud())*(linea.getLongitud());
            poligono.setArea(area);
            } 
            if ((poligono.getNumeroLineasContenidas()) == 3){
            System.out.println("Ingrese el valor de la altuta"); 
            double altura = teclado.nextDouble();
            area = ((linea.getLongitud())*(altura))/2;
            poligono.setArea(area);
            } 
            int posicion = listaPoligonos.indexOf(poligono);
            poligono.setNumeroLineasContenidas(numeroLineasContenidas);
            listaPoligonos.set(posicion, poligono);
            System.out.println("Se actualizo el poligono: " + poligono);
            System.out.println("");
            return true;
        }
        return false;
    }
public boolean eliminarPoligono(long codigoPoligono) {
    Poligono poligono = new Poligono();
    poligono = buscarPoligono(codigoPoligono);
        if (poligono != null) {
            listaPoligonos .remove(poligono);
            System.out.println("Se elimino el poligono: " + poligono);
            System.out.println("");
        }
        return true;
    }
public void listarPoligonos() {
        System.out.println("Lista de Poligonos");
        for (int i = 0; i <= listaPoligonos.size() - 1; i++) {
            System.out.println(listaPoligonos.get(i));
        }
        System.out.println("");
    }



/*----------------------------------------------------------------------------*/
/*----------------------------- CONTROLADOR LINEA ----------------------------*/
/*----------------------------------------------------------------------------*/  
public long generarCodigoLinea() {
        return (listaLineas.size() > 0) ? listaLineas.get(listaLineas.size() - 1).getCodigoLinea() + 1 : 1;
    }    
public ArrayList crearLinea(long codigoLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud) {
        Linea linea = new Linea(codigoLinea,  puntoOrigenX,  puntoOrigenY,  puntoFinalX,  puntoFinalY,  longitud);
        codigoLinea = generarCodigoLinea();
        linea.setCodigoLinea(codigoLinea);
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la coordenada X del punto de origen");
        linea.setPuntoOrigenX(teclado.nextDouble());
        System.out.println("");
        System.out.println("Ingrese la coordenada Y del punto de origen");
        linea.setPuntoOrigenY(teclado.nextDouble());
        System.out.println("");
        System.out.println("Ingrese la coordenada X del punto final");
        linea.setPuntoFinalX(teclado.nextDouble());
        System.out.println("");
        System.out.println("Ingrese la coordenada Y del punto final");
        linea.setPuntoFinalY(teclado.nextDouble());
        System.out.println("");
        longitud = Math.sqrt(Math.pow(((linea.getPuntoFinalX())-(linea.getPuntoOrigenX())),2)+Math.pow(((linea.getPuntoFinalY())-(linea.getPuntoOrigenY())),2));
        linea.setLongitud(longitud);
        listaLineas.add(linea);
        System.out.println("Se creo la linea: " + linea);
        System.out.println("");
        return listaLineas;
    }
public Linea buscarLinea(long codigoLinea) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el codigo de la linea a buscar ");
        codigoLinea = teclado.nextLong();
        System.out.println("");
        for (Linea linea : listaLineas) {
            if ((String.valueOf(linea.getCodigoLinea())).equals((String.valueOf(codigoLinea))) == true) {
                System.out.println("Se encontro la linea: " + linea);
                System.out.println("");
                return linea;
            }
        }
        return null;
    }
public boolean actualizarLinea(long codigoLinea, double puntoOrigenX, double puntoOrigenY, double puntoFinalX, double puntoFinalY, double longitud) {
    Linea linea = new Linea(codigoLinea,  puntoOrigenX,  puntoOrigenY,  puntoFinalX,  puntoFinalY, longitud);
        Scanner teclado = new Scanner(System.in);
        if (linea != null) {
            linea = buscarLinea(codigoLinea);
            System.out.println("Ingrese la nueva  coordenada X del punto de origen: " + linea);
            puntoOrigenX = teclado.nextDouble();
            System.out.println("");
            System.out.println("Ingrese la nueva coordenada Y del punto de orige: " + linea);
            puntoOrigenY = teclado.nextDouble();
            System.out.println("");
            System.out.println("Ingrese la nueva coordenada X del punto final: " + linea);
            puntoFinalX = teclado.nextDouble();
            System.out.println("");
            System.out.println("Ingrese la nueva coordenada Y del punto final: " + linea);
            puntoFinalY = teclado.nextDouble();
            System.out.println("");
            longitud = Math.sqrt(Math.pow(((puntoFinalX)-(puntoOrigenX)),2)+Math.pow(((puntoFinalY)-(puntoOrigenY)),2));
            int posicion = listaLineas.indexOf(linea);
            linea.setPuntoOrigenX(puntoOrigenX);
            linea.setPuntoOrigenY(puntoOrigenY);
            linea.setPuntoFinalX(puntoFinalX);
            linea.setPuntoFinalY(puntoFinalY);
            linea.setLongitud(longitud);
            listaLineas.set(posicion, linea);
            System.out.println("Se actualizo la linea: " + linea);
            System.out.println("");
            return true;
        }
        return false;
    }
public boolean eliminarLinea(long codigoLinea) {
        Linea linea = new Linea(codigoLinea);
        linea = buscarLinea(codigoLinea);
        if (linea != null) {
            listaLineas .remove(linea);
            System.out.println("Se elimino la linea: " + linea);
            System.out.println("");
        }
        return true;
    }
public void listarLineas() {
        System.out.println("Lista de Lineas");
        for (int i = 0; i <= listaLineas.size() - 1; i++) {
            System.out.println(listaLineas.get(i));
        }
        System.out.println("");
    }
}
