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
    
    /**
     * Método que importa los datos de la gestoría y los almacena
     * en el array
     */
    public void tratarDatosGestoria(){
        
        
        //Se inicializa la clase Gestoria para usar sus métodos
        Gestoria datosGestoria = new Gestoria();
        String cadenaDatos = datosGestoria.importarDades();       
        //Se crean almacenes temporales para almacenar los datos a la hora de dividirlos
        String[] almacenTemporal;
        String[] almacenDatosVecino;
        //Se hace una primera división de la cadena de la gestoría
        almacenTemporal = cadenaDatos.split(SEPARADOR_PISOS);
        //Se almacena el número de pisos de la comunidad
        int numPisos = Integer.parseInt(almacenTemporal[0]);
        //Se crea un array de objetos Vecino con el número de pisos
        Vecino[] datosVecino = new Vecino[numPisos];
        //Por cada posición del array datosVecino
        for (int i=0; i < datosVecino.length;i++){
            //Se almacenan los datos de cada vecino en un array temporal
            almacenDatosVecino = almacenTemporal[i+1].split(SEPARADOR_DATOS);  
            //Y se pasan los datos del array temporal a cada objeto Vecino
            datosVecino[i] = new Vecino();
            datosVecino[i].identificador=almacenDatosVecino[0].trim();
            datosVecino[i].nombrePiso=almacenDatosVecino[1].trim();
            datosVecino[i].nombrePropietario=almacenDatosVecino[2].trim();
            datosVecino[i].telefono=almacenDatosVecino[3].trim();
            datosVecino[i].presencia=almacenDatosVecino[4].trim();
            datosVecino[i].coeficiente=almacenDatosVecino[5].trim();
            datosVecino[i].tipoC=almacenDatosVecino[6].trim();
            //datosVecino[i].cargo=almacenDatosVecino[7];
            
        }
        System.out.println(datosVecino[2].identificador);
        System.out.println(datosVecino[2].presencia);
        System.out.println(datosVecino[2].coeficiente);
    }
    

}
