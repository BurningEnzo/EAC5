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
    
    String cargo = "";
    String presidente = "";
    String vicepresidente = "";
    String secretario = "";
   
   
    Scanner teclado = new Scanner(System.in);
    GestorDeDatos gestor = new GestorDeDatos();
    
    /**
     * Este metodo importa los datos de los propietarios y muestra los que tenga el valor P , V o S
     */
    public void listarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            LISTAR JUNTA ACTUAL                                           |");
        System.out.println("-------------------------------------------------------------------------------------------------");
     }

     /**
     * Este metodo importa los datos de los propietarios y asigna los cargos teniendo en cuenta el campo N y S que nos indica
     * si el propietario vive en el piso.
     */
    
    public void renovarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             RENOVAR JUNTA ACTUAL                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }
    
     /**
     * Este metodo importa los datos de los propietarios y asigna el cargo que le indique el usuario por teclado teniendo en cuenta
     * que si el cargo que quieren subtituir es el del presidente , el vicepresidente pasa a ser el presidente , el secretario sera el
     * vicepresidente y el secretario sera el primer propietario de la lista que no viva en el piso.
     * En el caso de que tengamos que subtituir el cargo de vicepresidente , el presidente se queda como esta , el secretario pasa a ser vicepresidente
     * y el secretario sera el primer propietario de la lista que no viva en el piso.
     * En el caso de que tengamos que subtituir el cargo del secretario , los cargos presidente y vicepresidente quedan igual.
     */
    
    public void substituirJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             SUBSTITUCION JUNTA ACTUAL                                     |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println("Introduzca el cargo que quiere subtituir");
        System.out.println("[Presidente , Vicepresidente o Secretario]");
        cargo = teclado.next();

    }
}

