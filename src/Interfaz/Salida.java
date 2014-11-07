/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.Scanner;
import Propietarios.Propietarios;
import Derramas.Derramas;
/**
 *
 * @author Uri
 */

public class Salida {
    Entrada imprimirEn = new Entrada();
    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void Propietarios() {
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
                    imprimir.GestionPropietarios();
                }
                break;
            case 2:
                if(opcion==2){
                    imprimir.ModificacionGestionPropietarios();
                }
                break;
            case 3:
                if(opcion==3){
                    imprimir.ListadoPropietarios();
                }
                break;
            case 4:
                if(opcion==4){
                    imprimirEn.menu();
                }
        }
       
    
    }

    public void Derramas() {
        Derramas derramas = new Derramas();
        Entrada imprimirEn = new Entrada();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("| Derramas|");
        System.out.println("-------------------------------------------------------------------------------------------------");

        
        System.out.println("  1- Modificacion   2- Listado   3-Volver atras");
        System.out.println("Por favor, seleccione una opción:");
        opcion = teclado.nextInt();
        switch(opcion){
            case 1:
                if(opcion==1){
                    derramas.ModificacionDerramas();
                }
                break;
            case 2:
                if(opcion==2){
                    derramas.ListadoDerramas();
                }
                break;
            case 3:
                if(opcion==3){
                    imprimirEn.menu();
                }
                break;
            
        }
    }
}
