/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;
import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.interfaz.Entrada;
import ioc.eac5.interfaz.Salida;
import java.util.Scanner;

/**
 * Esto es una prueba lo recibes soy Anais y lo recibo 08/11/2014 9:52
 *
 * @author Uri
 */
public class Derramas {

    double importe = 0;
    String descripcion = "";
    String tipoDerrama = "";
    int opcion;

    Scanner teclado = new Scanner(System.in);
    GestorDeDatos gestor = new GestorDeDatos();
    Entrada imprimirEn = new Entrada();
  
   

    public void añadirDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            Añadir derramas                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        gestor.introducirPresupuesto();
        System.out.println("Desea mostrar el informe de derrama introducido?(1- SI/2- NO)");
        opcion= teclado.nextInt();
        switch(opcion){
            case 1:
                if(opcion==1){
                   gestor.mostrarPresupuesto(); 
                   System.out.println("Gracias por su colaboracion");
                   imprimirEn.menu();
                   
                   
                }
                break;
            case 2:
                if(opcion==2){
                    
                    System.out.println("Gracias por su colaboracion");
                    imprimirEn.menu();
                    
                }
                break;
        }
        
//        System.out.println("Introduzca el importe de la derrama:");
//        importe = teclado.nextDouble();
//        System.out.println("Tipo de derrama(A/B/C)");
//        tipoDerrama = teclado.next();
//        System.out.println("Descripcion:");
//        descripcion = teclado.next();
//
//        if ("A".equalsIgnoreCase(tipoDerrama)) {
//
//            System.out.println("Importe de la derrama: " + importe);
//            System.out.println("Tipo: " + tipoDerrama);
//            System.out.println("Descripcion: " + descripcion);
//            gestor.tratarDatosGestoria();
//            double derramaA = gestor.DerramaA(importe);
//            System.out.println(derramaA);
//
//        } else if ("B".equalsIgnoreCase(tipoDerrama)) {
//
//            double derramaB = gestor.DerramaB(importe);
//
//            System.out.println("Importe de la derrama: " + importe);
//            System.out.println("Tipo: " + tipoDerrama);
//            System.out.println("Descripcion: " + descripcion);
//            System.out.println("Cada vecino debe abonar " + derramaB);
//
//        } else if ("C".equalsIgnoreCase(tipoDerrama)) {
//
//            System.out.println("Importe de la derrama: " + importe);
//            System.out.println("Tipo: " + tipoDerrama);
//            System.out.println("Descripcion: " + descripcion);
//            gestor.tratarDatosGestoria();
//            double derramaC = gestor.DerramaC(importe);
//            System.out.println(derramaC);
//        }
        //Al haber tratado double importe arriba ahora ya podemos pasarlo a string
//        String importeDatos = String.valueOf(importe / 10);
        //Almacenamos los datos introducidos por teclado en una variable String
//        String datos = importeDatos + "," + tipoDerrama + "," + descripcion;
        //System.out.println("\nTabla de datos\n"+datos);
//        String[] array = datos.split(",");
//        String[][] tablaDatos = new String[25][3];
//
//        for (int i = 0; i < 3; i++) {//Dimensión Uno.
//            for (int j = 0; j < 25; j++) {//Dimensión Dos.
//                tablaDatos[i][j] = array[i];
//            }
//        }
//
//        System.out.println("Imprimiendo Presupuestos.");
//        System.out.println("\n----------------------");
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 25; j++) {
//                System.out.print(tablaDatos[j][i] + " | ");
//            }
//            System.out.println();
//        }

    }

    public void modificacionDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             Modificación derramas                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println("1-Listar presupuestos almacenados    2-Solicitar");
    }
    public void listarPresupuestos(){
        
    }
}
