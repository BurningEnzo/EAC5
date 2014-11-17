/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5;
import ioc.eac5.interfaz.Salida;

import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.derramas.GestorDeDerramas;

//import ioc.eac5.gestor.GestorDeDatos;

/**
 * Clase principal que da inicio al programa
 * @author Lorenzo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        GestorDeDatos prueba = new GestorDeDatos();
        //GestorDeDerramas  prueba1 = new GestorDeDerramas();
        //Pruebas
        //prueba.tratarDatosGestoria();
        //imprimir.mostrarPropietario("LE", 0);
        //prueba.mostrarListado(1);
       // imprimir.bienvenida();


        //Salida.menuPrincipal();
        prueba1.añadirDerrama();
        //prueba1.listarDerrama();
        prueba1.modificarDerramas();
        //prueba1.tipoDerrama();

        Salida.menuPrincipal();
        //prueba1.añadirDerrama();
        //prueba1.modificarDerramas();


        //Salida.menuPrincipal();


  

    
    }
    
    

}


