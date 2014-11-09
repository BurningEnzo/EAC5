/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;
import ioc.eac5.propietarios.Propietarios;
import ioc.eac5.derramas.Derramas;
/**
 *
 * @author Uri
 */

public class Salida {
    Entrada imprimirEn = new Entrada();
    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void propietarios() {
        Propietarios imprimir = new Propietarios();
        
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                                   Propietarios                                                |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        
        System.out.println("  1- Gestion Propietarios   2- Modificacion gestión propietarios   3- Listado datos propietarios   4-Volver atras");
        System.out.println("Por favor, seleccione una opción:");
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                if(opcion==1){
                    imprimir.gestionPropietarios();
                }
                break;
            case 2:
                if(opcion==2){
                    imprimir.modificacionGestionPropietarios();
                }
                break;
            case 3:
                if(opcion==3){
                    imprimir.listadoPropietarios();
                }
                break;
            case 4:
                if(opcion==4){
                    imprimirEn.menu();
                }
        }
       
    
    }

    public void derramas() {
        Derramas derramas = new Derramas();
        Entrada imprimirEn = new Entrada();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("| Derramas|");
        System.out.println("-------------------------------------------------------------------------------------------------");

        
        System.out.println("1-Añadir derrama   2- Modificacion   3- Listado   4-Volver atras");
        System.out.println("Por favor, seleccione una opción:");
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                if(opcion==1){
                    derramas.añadirDerramas();
                }
            break;
            case 2:
                if(opcion==2){
                    derramas.modificacionDerramas();
                }
                break;
            case 3:
                if(opcion==3){
                    derramas.listadoDerramas();
                }
                break;
            case 4:
                if(opcion==4){
                    imprimirEn.menu();
                }
                break;
            
        }
    }
}
