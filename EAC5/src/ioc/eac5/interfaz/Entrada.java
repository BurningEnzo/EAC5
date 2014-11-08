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
        System.out.println("                    Menú");
        System.out.println("-----------------------------------------------");
        System.out.println("1.- Gestión Propietarios   2.- Gestion Derramas");
        System.out.println("-----------------------------------------------");
        System.out.println("Por favor, elija una de las opciones anteriores:");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                if (opcion == 1) {
                    
                    imprimir.propietarios();
                }
                break;
            case 2:
                if (opcion == 2) {
                    imprimir.derramas();

                }
                break;
        }
    }

    

}
