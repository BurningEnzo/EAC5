/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.propietarios;
import ioc.eines.Gestoria;
import ioc.eac5.gestor.GestorDeDatos;

/**
 *
 * @author Uri
 */
public class Propietarios {

    public void gestionPropietarios() {
        Gestoria gestoria = new Gestoria();
        GestorDeDatos gestor = new GestorDeDatos();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                           Gestión de Propietarios                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        String Cadena=gestoria.importarDades();
        
    }

    public void modificacionGestionPropietarios() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                   Modificacion gestión propietarios                                           |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }

    public void listadoPropietarios() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                               Listado Propietarios                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }

}
