/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;
import ioc.eac5.propietarios.Propietarios;
import ioc.eac5.derramas.Derramas;
import ioc.eac5.gestor.GestorDeDatos;

/**
 *
 * @author Uri
 */

public class Salida {
    Entrada imprimirEn = new Entrada();
    Propietarios imprimir = new Propietarios();
    Derramas derramas = new Derramas();
    Scanner teclado = new Scanner(System.in);
    int opcion;
    boolean importado=false;
    boolean correcto=false;
    
    public void bienvenida() {
        
        System.out.println("Bienvenido/a al programa de gestión de la comunidad\n"
                            +"\nEl programa permite gestionar los propietarios de la comunidad,\n"
                            +"gestionar las derramas y los cargos de la junta");
    }
    
    public void cabeceraMenuPropietarios(){
        System.out.println("-----------------------------------------------");
        System.out.println("                Propietarios");
        System.out.println("-----------------------------------------------");
    }
    
    
    
    public void menuPropietarios() {
        
        GestorDeDatos gestoria = new GestorDeDatos();
        
        
        //System.out.println("  1- Importar datos desde la gestoria  2- Modificacion gestión propietarios   3- Listado datos propietarios   4-Volver atras");
        System.out.println("1) Importar datos desde la gestoría");
        System.out.println("2) Modificar datos de propietario");
        System.out.println("3) Listado de propietarios");
        System.out.println("4) Volver al menú anterior");
        
        System.out.print("\nPor favor, seleccione una opción: ");
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                if (!importado){
                    //imprimir.gestionPropietarios();
                    gestoria.tratarDatosGestoria();
                    importado=true;
                    System.out.println("Datos importados correctamente.\n");
                    menuPropietarios();
                } else {
                    System.out.println("Los datos ya han sido importados previamente.");
                    menuPropietarios();
                }
                break;
            case 2:
                
                if (importado){
                    imprimir.modificacionGestionPropietarios();
                } else {
                    System.out.println("Por favor, primero importe los datos de la gestoría.");
                    menuPropietarios();
                }
                    
                
                break;
            case 3:
          
                    imprimir.listadoPropietarios();
                
                break;
            case 4:
               
                    imprimirEn.menu();
                
        }
       
    
    }
    
    public void cabeceraMenuDerramas() {
        System.out.println("-----------------------------------------------");
        System.out.println("                   Derramas");
        System.out.println("-----------------------------------------------");
    }
    
    
    
    public void menuDerramas() {
                
        System.out.println("1) Añadir derrama");
        System.out.println("2) Modificar derrama existente");
        System.out.println("3) Listar derramas");
        System.out.println("4) Volver al menú anterior");
        System.out.print("Por favor, seleccione una opción:");
        
        do {
            correcto=teclado.hasNextInt();
            if(correcto){
                opcion = teclado.nextInt();
                
            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.next();
            }  
        } while (!correcto);
        
        switch(opcion){
            case 1:
            
                derramas.añadirDerramas();
                
                break;
                
            case 2:
                
                derramas.modificacionDerramas();
                
                break;
                
            case 3:
           
                derramas.listarPresupuestos();
                
                break;
                
            case 4:
              
                imprimirEn.menu();
                
                break;
            default:
                
                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                menuDerramas();
                break;
                
        }
    }
}
