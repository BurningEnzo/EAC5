/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.gestor;

import ioc.eines.Gestoria;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase que gestiona los datos de la aplicación
 *
 * @author Lorenzo
 */
public class GestorDeDatos {

    //Separadores de la cadena proporcionada por la gestoria
    public static final String SEPARADOR_PISOS = "#";
    public static final String SEPARADOR_DATOS = ";";
    private Scanner teclado;
    private int cont;
    private String[][] matriz;
    private int importe;
    private char tipo;
    private String descripcion;

    //Array con los datos de los vecinos
    public Vecino[] datosVecino;

    /**
     * Método que importa los datos de la gestoría y los almacena en el array
     */
    public void tratarDatosGestoria() {

        //Se inicializa la clase Gestoria para usar sus métodos
        Gestoria datosGestoria = new Gestoria();
        String cadenaDatos = datosGestoria.importarDades();
        //Se hace una primera división de la cadena de la gestoría
        //Almacenes temporales para almacenar los datos a la hora de dividirlos
        String[] almacenTemporal;
        String[] almacenDatosVecino;
        almacenTemporal = cadenaDatos.split(SEPARADOR_PISOS);
        //Se almacena el número de pisos de la comunidad
        int numPisos = Integer.parseInt(almacenTemporal[0]);
        //Se crea un array de objetos Vecino con el número de pisos
        //Vecino[] datosVecino = new Vecino[numPisos];
        //Por cada posición del array datosVecino
        datosVecino = new Vecino[numPisos];
        for (int i = 0; i < datosVecino.length; i++) {
            //Se almacenan los datos de cada vecino en un array temporal
            almacenDatosVecino = almacenTemporal[i + 1].split(SEPARADOR_DATOS);
            //Y se pasan los datos del array temporal a cada objeto Vecino
            datosVecino[i] = new Vecino();
            datosVecino[i].identificador = almacenDatosVecino[0].trim();
            datosVecino[i].nombrePiso = almacenDatosVecino[1].trim();
            datosVecino[i].nombrePropietario = almacenDatosVecino[2].trim();
            datosVecino[i].telefono = almacenDatosVecino[3].trim();
            datosVecino[i].presencia = almacenDatosVecino[4].trim();
            datosVecino[i].coeficiente = almacenDatosVecino[5].trim();
            datosVecino[i].tipoC = almacenDatosVecino[6].trim();
            if (almacenDatosVecino.length == 8) {
                datosVecino[i].cargo = almacenDatosVecino[7].trim();
            }
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
            if (identificador.equalsIgnoreCase(datosVecino[i].identificador)) {
                //Modifica el campo según la opción elegida
                switch (campo) {
                    case 1:
                        datosVecino[i].nombrePropietario = dato;
                        break;
                    case 2:
                        datosVecino[i].telefono = dato;
                        break;
                    case 3:
                        datosVecino[i].coeficiente = dato;
                        break;
                    case 4:
                        datosVecino[i].tipoC = dato;
                        break;
                    case 5:
                        datosVecino[i].presencia = dato;
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
        switch (orden) {
            //Ordenar por orden natural del piso
            case 1:
                Arrays.sort(datosVecino);
                break;
            //Ordenar por nombre del pripietario
            case 2:

                break;
            //Ordenar por coeficiente de propiedad
            case 3:

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
            coeficienteProp = Double.parseDouble(datosVecino[a].coeficiente);
            nombrePiso = datosVecino[a].nombrePiso;
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
            coeficienteProp = Double.parseDouble(datosVecino[c].coeficiente);
            nombrePiso = datosVecino[c].nombrePiso;
            tipoC = Integer.parseInt(datosVecino[c].tipoC);
            if (tipoC == 1) {
                derramaC = numero / 25;
                System.out.println(nombrePiso + " " + coeficienteProp + " " + tipoC + " " + derramaC);
            }
        }
        return derramaC;
    }

}
