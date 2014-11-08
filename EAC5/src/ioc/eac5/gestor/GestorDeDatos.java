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
    static String SEPARADOR_PISOS="#";
    static String SEPARADOR_DATOS=";";
    
    public void tratarDatos(){
        //Aquí va el código con la importación de los datos de la gestoría
        
        //Se inicializa la clase Gestoria para usar sus métodos
        
        Gestoria datosGestoria = new Gestoria();
        String cadenaDatos = datosGestoria.importarDades();
        
        //Se crean almacenes temporales para almacenar los datos a la hora de dividirlos
        String[] almacenTemporal;
        
        
        almacenTemporal = cadenaDatos.split(SEPARADOR_PISOS);
        int numPisos = Integer.parseInt(almacenTemporal[0]);
        Vecino[] datosVecino = new Vecino[numPisos];
        String[] almacenDatosVecino;
        //
        
       
           
        
        
        
        
        for (int t=0; t < datosVecino.length;t++){
            
              almacenDatosVecino = almacenTemporal[t+1].split(SEPARADOR_DATOS);  
            
            datosVecino[t] = new Vecino();
            datosVecino[t].identificador=almacenDatosVecino[0];
            datosVecino[t].nombrePiso=almacenDatosVecino[1];
            datosVecino[t].nombrePropietario=almacenDatosVecino[2];
            datosVecino[t].telefono=almacenDatosVecino[3];
            datosVecino[t].presencia=almacenDatosVecino[4];
            datosVecino[t].coeficiente=almacenDatosVecino[5];
            datosVecino[t].tipoC=almacenDatosVecino[6];
            datosVecino[t].cargo=almacenDatosVecino[6];
            
        }
           
        
       
        System.out.println(datosVecino[2].telefono);
        
        //Almacena en un array los datos importados de la gestoria con el metodo importarDades()
        //for (int i=0; i< datosVecino.length; i++){
          //  datosVecino[i] = new Vecino();
          //  datosVecino[i].identificador=;
          //  datosVecino[i].nombrePiso=;
          //  datosVecino[i].nombrePropietario=;
          //  datosVecino[i].telefono=;
          //  datosVecino[i].presencia=;
          //  datosVecino[i].coeficiente;
          //  datosVecino[i].tipoC=;
          //  datosVecino[i].cargo=;
        //}
    }
    
}
