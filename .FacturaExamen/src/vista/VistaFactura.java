/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.ControladorFactura;
import controlador.ControladorProducto;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;

/**
 *
 * @author ediss
 */
public class VistaFactura {
    public Scanner teclado;
    private ControladorFactura controladorFactura;
    private ControladorProducto controladorProducto;
    private ControladorCliente controladorCliente;
    public DateFormat formatoFecha;
    private List<Producto> listaProductosCliente;
    
    public VistaFactura(ControladorFactura controladorFactura, ControladorProducto controladorProducto, ControladorCliente controladorCliente){
        teclado = new Scanner(System.in);
        this.controladorFactura = controladorFactura;
        this.controladorProducto = controladorProducto;
        this.controladorCliente = controladorCliente;
        formatoFecha = new SimpleDateFormat("dd/mm/yyyy");
        listaProductosCliente = new ArrayList();
    }
    public void menu(){
        int opcion = 0;
        do {
            System.out.println("Menu de Facturas: ");
            System.out.println(" 1. Crear \n 2. Actualizar \n 3. Buscar \n 4. Eliminar \n 5. Listar \n 6. Salir");
            opcion = teclado.nextInt();
            switch(opcion){
                case 1: this.crear(); break;
                case 2: this.actualizar(); break;
                case 3: this.buscar(); break;
                case 4: this.eliminar(); break;
                case 5: this.listar(); break;
            }
        } while (opcion < 6);
    }
    public void crear(){
        int num1 = 1;
        double valor = 0;
        System.out.println("Ingrese cantidad de productos: ");
        int num = teclado.nextInt();
        System.out.println("Ingrese la cedula del cliente: ");
        teclado.nextLine();
        String cedula = teclado.nextLine();
        Cliente cliente = controladorCliente.buscar(cedula);
        if(cliente != null){ 
            while(num1 <= num){
                System.out.println("Ingrese la descripcion del producto a comprar: ");
                String productoCom = teclado.nextLine();
                Producto producto = controladorProducto.buscar(productoCom);
                if(producto != null){
                    System.out.println("El producto a comprar tiene iva (si/no): ");
                    String iva = teclado.nextLine();
                    System.out.println("Ingrese la cantidad del producto a comprar: ");
                    int cant = teclado.nextInt();
                    if(iva.equals("si")){
                        valor = (cant * (producto.getPrecio_uni()) + (0.12 * producto.getPrecio_uni()));
                    }else{
                        valor = (cant * producto.getPrecio_uni());
                    }
                    producto.setStock(producto.getStock()-cant);
                    listaProductosCliente.add(producto);
                    num1 = num1 + 1;
                }else{
                    System.out.println("El Producto no esta en la Base de Datos ");
                }  
            }
            System.out.println("Ingresar la Fecha de la Factura con formato (dd/mm/yyyy): ");
            String fecha = teclado.next();     
            try {
                System.out.println("Respuesta:" + controladorFactura.crear(controladorFactura.generarId(), formatoFecha.parse(fecha), listaProductosCliente, cliente, valor));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }else{
            System.out.println("El Cliente no esta en la Base de Datos ");
        }
    }
    
    public void actualizar(){
        System.out.println("Ingrese la cedula del cliente de la factura que va actualizar: ");        
        String cedula = teclado.next();
        System.out.println("Ingresar la Fecha de la Factura a actualizar con formato (dd/mm/yyyy): ");
        String fecha = teclado.next();     
        try {
            System.out.println("Respuesta:" + controladorFactura.actualizar(formatoFecha.parse(fecha), cedula));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }             
    }
    
    public void buscar(){
        System.out.println("Ingrese la cedula del cliente de la factura a buscar: ");
        String cedula = teclado.next();
        System.out.println(controladorFactura.buscar(cedula));       
    }
    
    public void eliminar(){
        System.out.println("Ingrese la cedula del cliente de la factura a eliminar: ");
        String cedula = teclado.next();
        System.out.println("respuesta: "+ controladorFactura.eliminar(cedula));
    }
    
    public void listar(){
        for(Factura factura : controladorFactura.getListaFacturas()) {
            System.out.println(factura);
        }
    }
}
