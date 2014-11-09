/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;

/**
 * Esto es una prueba lo recibes soy Anais y lo recibo 08/11/2014 9:52
 *
 * @author Uri
 */
public class Derramas {

    double importe = 0;
    String descripcion = "";
    String tipoDerrama = "";

    Scanner teclado = new Scanner(System.in);
    GestorDeDatos gestor = new GestorDeDatos();

    public void añadirDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            Añadir derramas                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println("Introduzca el importe de la derrama:");
        importe = teclado.nextDouble();
        System.out.println("Tipo de derrama(A/B/C)");
        tipoDerrama = teclado.next();
        System.out.println("Descripcion:");
        descripcion = teclado.next();
        
        if ("A".equalsIgnoreCase(tipoDerrama)) {

            System.out.println("Importe de la derrama: " + importe);
            System.out.println("Tipo: " + tipoDerrama);
            System.out.println("Descripcion: " + descripcion);
            gestor.tratarDatosGestoria();
            double derramaA = gestor.DerramaA(importe);
            System.out.println(derramaA);

        } else if ("B".equalsIgnoreCase(tipoDerrama)) {

            double derramaB = gestor.DerramaB(importe);

            System.out.println("Importe de la derrama: " + importe);
            System.out.println("Tipo: " + tipoDerrama);
            System.out.println("Descripcion: " + descripcion);
            System.out.println("Cada vecino debe abonar " + derramaB);

        } else if ("C".equalsIgnoreCase(tipoDerrama)) {
            
            System.out.println("Importe de la derrama: " + importe);
            System.out.println("Tipo: " + tipoDerrama);
            System.out.println("Descripcion: " + descripcion);
            gestor.tratarDatosGestoria();
            double derramaC = gestor.DerramaC(importe);
            System.out.println(derramaC);
        }
        //Al haber tratado double importe arriba ahora ya podemos pasarlo a string
        String importeDatos= String.valueOf(importe/10);
        //Almacenamos los datos introducidos por teclado en una variable String
        String datos=importeDatos+","+tipoDerrama+","+descripcion+";";
        
        System.out.println("Datos para almacenar: "+datos);

    }

    public void modificacionDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             Modificación derramas                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }

    public void listadoDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                              Listado derramas                                                 |");
        System.out.println("-------------------------------------------------------------------------------------------------");

    }

}
