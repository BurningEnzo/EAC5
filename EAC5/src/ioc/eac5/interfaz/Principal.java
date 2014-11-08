/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;
import ioc.eac5.gestor.GestorDeDatos;

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
        
        
        prueba.tratarDatosGestoria();
        
        
        
        
        
        
    }
    
}
