/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.gestor;
import ioc.eines.Gestoria;

/**
 * Clase que gestiona los datos de la aplicación
 * @author Lorenzo
 */
public class GestorDeDatos {
    
    
    Gestoria datosGestoria = new Gestoria();
    String cadenaDatos = datosGestoria.importarDades();
    
    
    
    public void tratarDatos(String cadena){
        //Aquí va el código con la importación de los datos de la gestoría
        
        
        
        Vecino[] datosVecino = new Vecino[25];
        //Almacena en un array los datos importados de la gestoria con el metodo importarDades()
        for (int i=0; i< datosVecino.length; i++){
          //  datosVecino[i] = new Vecino();
          //  datosVecino[i].identificador=;
          //  datosVecino[i].nombrePiso=;
          //  datosVecino[i].nombrePropietario=;
          //  datosVecino[i].telefono=;
          //  datosVecino[i].presencia=;
          //  datosVecino[i].coeficiente;
          //  datosVecino[i].tipoC=;
          //  datosVecino[i].cargo=;
        }
    }
    
}
