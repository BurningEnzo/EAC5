/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5;
import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.interfaz.Entrada;

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
        Entrada imprimir = new Entrada();
        
        //Pruebas

//        prueba.tratarDatosGestoria();
//        prueba.mostrarListado(3);

        //prueba.tratarDatosGestoria();
        //prueba.mostrarListado(3);

        imprimir.menu();
        //prueba.DerramaB();

        
        
    }
    
}
