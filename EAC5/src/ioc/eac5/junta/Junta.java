/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.junta;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;

/**
 * Aquesta clase disposarà de 3 funcionalitats : Llistar junta actual , Renovar càrrecs de la junta i Substituir un càrrec.
 * @author Anais
 */
public class Junta {
    
    Scanner teclado = new Scanner(System.in);
    GestorDeDatos gestor = new GestorDeDatos();
    
     public void listarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            LISTAR JUNTA ACTUAL                                           |");
        System.out.println("-------------------------------------------------------------------------------------------------");
     }
}
    public void renovarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             RENOVAR JUNTA ACTUAL                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }
    public void substituirJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             SUBSTITUIR JUNTA                                      |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }