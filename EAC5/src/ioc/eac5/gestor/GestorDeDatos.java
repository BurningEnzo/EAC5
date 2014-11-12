/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.gestor;

import ioc.eines.Gestoria;
import java.util.Scanner;

/**
 * Clase que gestiona los datos de la aplicación
 *
 * @author Lorenzo
 */
public class GestorDeDatos {
    
    //CONSTANTES
    //Separadores de la cadena proporcionada por la gestoria

    public static final String SEPARADOR_PISOS = "#";
    public static final String SEPARADOR_DATOS = ";";
    private Scanner teclado;
    private int cont;
    private String[][] matriz;
    private int importe;
    private char tipo;
    private String descripcion;
    
    //Identificadores del tipo de orden
    private static final int PISO=0;
    private static final int NOMBRE=1;
    private static final int COEFICIENTE=2;
     
    //VARIABLES

    //Array con los datos de los vecinos
    public Vecino[] datosVecino;
    //Número de pisos
    private int numPisos=0;
    public int [][] arrayOrden;
    
    /**
     * Método que importa los datos de la gestoría y los almacena en el array
     */
    public void tratarDatosGestoria() {

        //Se inicializa la clase Gestoria para usar sus métodos
        Gestoria datosGestoria = new Gestoria();
        String cadenaDatos = datosGestoria.importarDades();
        //Se hace una primera división de la cadena de la gestoría
        //Se crean lmacenes temporales para almacenar los datos a la hora de dividirlos
        String[] almacenTemporal;
        String[] almacenDatosVecino;
        almacenTemporal = cadenaDatos.split(SEPARADOR_PISOS);
        //Se almacena el número de pisos de la comunidad
        numPisos = Integer.parseInt(almacenTemporal[0]);
        arrayOrden = new int [numPisos][3];
        //Se inicializa el array datosVecino con el número de pisos
        datosVecino = new Vecino[numPisos];
        //Se recorre cada posición del array
        for (int i = 0; i < datosVecino.length; i++) {
            //Se almacenan los datos de cada vecino en un array temporal
            almacenDatosVecino = almacenTemporal[i + 1].split(SEPARADOR_DATOS);
            //Y se pasan los datos del array temporal a cada objeto Vecino
            datosVecino[i] = new Vecino();
            //datosVecino[i].identificador = almacenDatosVecino[0].trim();
            datosVecino[i].setIdentificador(almacenDatosVecino[0].trim());
            //datosVecino[i].nombrePiso = almacenDatosVecino[1].trim();
            datosVecino[i].setNombrePiso(almacenDatosVecino[1].trim());
            //datosVecino[i].nombrePropietario = almacenDatosVecino[2].trim();
            datosVecino[i].setNombrePropietario(almacenDatosVecino[2].trim());
            //datosVecino[i].telefono = almacenDatosVecino[3].trim();
            datosVecino[i].setTelefono(almacenDatosVecino[3].trim());
            //datosVecino[i].presencia = almacenDatosVecino[4].trim();
            datosVecino[i].setPresencia(almacenDatosVecino[4].trim());
            //datosVecino[i].coeficiente = almacenDatosVecino[5].trim();
            datosVecino[i].setCoeficiente(almacenDatosVecino[5].trim());
            //datosVecino[i].tipoC = almacenDatosVecino[6].trim();
            datosVecino[i].setTipoC(almacenDatosVecino[6].trim());
            if (almacenDatosVecino.length == 8) {
                datosVecino[i].setCargo(almacenDatosVecino[7].trim());
            } else {
                datosVecino[i].setCargo(null);
            }
        }
        for (int i=0; i<datosVecino.length;i++){
                    arrayOrden[i][PISO]=i;
                    arrayOrden[i][NOMBRE]=i;
                    arrayOrden[i][COEFICIENTE]=i;
        }
    }

    /**
     * Método para modificar un campo de cualquier piso
     *
     * @param identificador Identificador del piso
     * @param campo Campo a modificar
     * @param dato Dato modificado
     */
    public void modificarCampo(String identificador, int campo, String dato) {
        //Se hace un recorrido por todos los vecinos
        for (int i = 0; i < datosVecino.length; i++) {
            //Si el identificador introducido concuerda con uno de los pisos
            if (identificador.equalsIgnoreCase(datosVecino[i].getIdentificador())) {
                //Modifica el campo según la opción elegida
                switch (campo) {
                    case 1:
                        datosVecino[i].setNombrePropietario(dato);
                        break;
                    case 2:
                        datosVecino[i].setTelefono(dato);
                        break;
                    case 3:
                        datosVecino[i].setCoeficiente(dato);
                        break;
                    case 4:
                        datosVecino[i].setTipoC(dato);
                        break;
                    case 5:
                        datosVecino[i].setPresencia(dato);
                        break;
                    default:
                        System.out.println("Opción incorrecta.");
                        break;
                }
            } else {
                //Si el identificador no concuerda con ningún identificador del array muestra un mensaje
                System.out.println("El identificador " + identificador + " no pertenece a ningún piso.");
            }
        }
    }

    public void mostrarListado(int orden) {
        //Se crea un array de índices para los diferentes tipos de ordenamiento
        
        
        switch (orden) {
            //Ordenar por orden natural del piso
            case 1:
                
                
                System.out.println("\nLISTA DE PROPIETARIOS POR ORDEN NATURAL DEL PISO");
                System.out.println("------------------------------------------------\n");

                for (int a=0;a<arrayOrden.length;a++){
                    System.out.print("-"+datosVecino[arrayOrden[a][PISO]].getNombrePiso()+"\t("+datosVecino[arrayOrden[a][PISO]].getCoeficiente()+"): "+datosVecino[arrayOrden[a][PISO]].getNombrePropietario()+" ("+datosVecino[arrayOrden[a][PISO]].getTelefono()+")");
                    if(datosVecino[arrayOrden[a][PISO]].getPresencia().equalsIgnoreCase("N")){
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }
                
                break;
            //Ordenar por nombre del pripietario
            case 2:
                System.out.println("\nLISTA DE PROPIETARIOS POR ORDEN ALFABÉTICO");
                System.out.println("------------------------------------------\n");
                
                for(int i=0; i<datosVecino.length-1;i++){
                    for (int j=i+1;j<datosVecino.length;j++){
                    
                        if(datosVecino[arrayOrden[i][NOMBRE]].getNombrePropietario().compareToIgnoreCase(datosVecino[arrayOrden[j][NOMBRE]].getNombrePropietario())>0){
                            int aux=arrayOrden[i][NOMBRE];
                            arrayOrden[i][NOMBRE]=arrayOrden[j][NOMBRE];
                            arrayOrden[j][NOMBRE]=aux;
                        
                        }
                    }
                }    
                
                for (int a=0;a<arrayOrden.length;a++){
                    System.out.print("-"+datosVecino[arrayOrden[a][NOMBRE]].getNombrePiso()+"\t("+datosVecino[arrayOrden[a][NOMBRE]].getCoeficiente()+"): "+datosVecino[arrayOrden[a][NOMBRE]].getNombrePropietario()+" ("+datosVecino[arrayOrden[a][NOMBRE]].getTelefono()+")");
                    if(datosVecino[arrayOrden[a][NOMBRE]].getPresencia().equalsIgnoreCase("N")){
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }

                break;
            //Ordenar por coeficiente de propiedad
            case 3:
                
                System.out.println("\nLISTA DE PROPIETARIOS POR COEFICIENTE DE PROPIEDAD");
                System.out.println("--------------------------------------------------\n");
                
                for(int i=0; i<datosVecino.length-1;i++){
                    for (int j=i+1;j<datosVecino.length;j++){
                    
                        //if(datosVecino[arrayOrden[i][COEFICIENTE]].getCeficiente().compareToIgnoreCase(datosVecino[arrayOrden[j][COEFICIENTE]].getCoeficiente())>0){
                        if(Double.parseDouble(datosVecino[arrayOrden[i][COEFICIENTE]].getCoeficiente())>Double.parseDouble(datosVecino[arrayOrden[j][COEFICIENTE]].getCoeficiente())){
                            int aux=arrayOrden[i][COEFICIENTE];
                            arrayOrden[i][COEFICIENTE]=arrayOrden[j][COEFICIENTE];
                            arrayOrden[j][COEFICIENTE]=aux;
                        
                        }
                    }
                }    
                
                for (int a=0;a<arrayOrden.length;a++){
                    System.out.print("-"+datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePiso()+"\t("+datosVecino[arrayOrden[a][COEFICIENTE]].getCoeficiente()+"): "+datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePropietario()+" ("+datosVecino[arrayOrden[a][COEFICIENTE]].getTelefono()+")");
                    if(datosVecino[arrayOrden[a][COEFICIENTE]].getPresencia().equalsIgnoreCase("N")){
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }

                break;
            //Orden por defecto
            default:

                break;

        }
    }

    /**
     * Reparto del importe segun el coeficiente de cada propietario
     *
     * @param numero
     * @return
     */
    public void introducirPresupuesto() {
        teclado = new Scanner(System.in);
        System.out.println("Cuantos presupuestos introducira?");
        int presupuestos = teclado.nextInt();
        matriz = new String[presupuestos][3];
        System.out.println("Debe introducir los datos del presupuesto segun el orden que le indiquemos a continuacion.");
        System.out.println("importe/tipo/descripcion");
        for (int f = 0; f < matriz.length; f++) {
            System.out.println("----------------");
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.println("Ingrese el dato:");
                matriz[f][c] = teclado.next();
            }
        }

    }
/**
 * Muestra importe y guarda en variable
 */
    public void importe() {
        System.out.println("IMPORTE\n------------------");
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c=c+3) {
                importe=Integer.parseInt(matriz[f][c]);
                cont++;
                System.out.println("Importe "+cont+"|" +importe+ "|");
            }
        }
    }
    /**
     * Muestra tipo derrama y guarda en variable
     */
    public void tipoDerrama(){
        System.out.println("TIPO\n------------------");
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 1; c < matriz[f].length; c=c+3) {
                 tipo=matriz[f][c].charAt(0);
                cont++;
                System.out.println("Tipo "+cont+"|" +tipo+ "|");
            }
        }
    }
    /**
     * Muestra la descripcion de presupuesto/s y guarda en variable
     */
    public void descripcion(){
         System.out.println("Descripcion\n------------------");
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 2; c < matriz[f].length; c=c+3) {
                 descripcion=matriz[f][c];
                cont++;
                System.out.println("descripcion "+cont+"|" +descripcion+ "|");
            }
        }
    }
/**
 * Muestra todos los presupuestos introducidos
 */
    public void mostrarPresupuesto() {
        System.out.println("Informe de derrama\n----------------------------");
        for (int f = 0; f < matriz.length; f++) {
            for (int c = 0; c < matriz[f].length; c++) {
                System.out.println("|" + matriz[f][c] + "|");
            }
            System.out.println("\n------------------------------------------");
        }
    }

    public double DerramaA(double numero) {
        double coeficienteProp = 0;
        String nombrePiso;
        double porPiso = 0;
        double derramaA = 0;

        for (int a = 0; a < datosVecino.length; a++) {
            coeficienteProp = Double.parseDouble(datosVecino[a].getCoeficiente());
            nombrePiso = datosVecino[a].getNombrePiso();
            derramaA = numero / coeficienteProp;
            System.out.println(nombrePiso + " " + coeficienteProp + " debes abonar " + (double) Math.round(derramaA) / 100 + "€");

        }
        return derramaA;

    }

    /**
     * Realiza el reparto del importe entre los 25 propietarios
     *
     * @param numero
     * @return
     */

    public double DerramaB(double numero) {
        System.out.println("\n-------------------------\n");
        System.out.println("Informe derrama");
        System.out.println("\n-------------------------\n");
        double derramaB = numero / 25;
        return derramaB;

    }

    /**
     * Segun si estan excemptos o el importe es igual para todos a abonar
     *
     * @param numero
     * @return
     */
    public double DerramaC(double numero) {
        double coeficienteProp = 0;
        double derramaC = 0;
        String nombrePiso;
        int tipoC;

        for (int c = 0; c < datosVecino.length; c++) {
            coeficienteProp = Double.parseDouble(datosVecino[c].getCoeficiente());
            nombrePiso = datosVecino[c].getNombrePiso();
            tipoC = Integer.parseInt(datosVecino[c].getTipoC());
            if (tipoC == 1) {
                derramaC = numero / 25;
                System.out.println(nombrePiso + " " + coeficienteProp + " " + tipoC + " " + derramaC);
            }
        }
        return derramaC;
    }

}
