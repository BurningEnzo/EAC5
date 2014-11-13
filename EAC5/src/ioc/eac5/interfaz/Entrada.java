/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;

/**
 *
 * @author Uri
 */
public class Entrada {

    Scanner teclado = new Scanner(System.in);
    int opcion;

    public void menu() {
        Salida imprimir = new Salida();
        System.out.println("-----------------------------------------------");
        System.out.println("                Menú principal");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Gestión de propietarios");
        System.out.println("2) Gestion de derramas");
        System.out.println("3) Gestión de cargos de la junta");
        System.out.println("4) Salir del programa");
        System.out.println("-----------------------------------------------");
        System.out.print("Por favor, seleccione una opción: ");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                    imprimir.cabeceraMenuPropietarios();
                    imprimir.menuPropietarios();
                
                break;
            case 2:
                    imprimir.cabeceraMenuDerramas();
                    imprimir.menuDerramas();

                break;
            case 3:
                
                break;
                
            case 4:    
                
                
                break;
            default:
                
                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                menu();
                break;
        }
    }

    

}
