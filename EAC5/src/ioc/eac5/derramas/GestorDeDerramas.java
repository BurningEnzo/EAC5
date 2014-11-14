/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;

/**
 *
 * @author Lorenzo
 */
public class GestorDeDerramas {
/*
    //CONSTANTES
    //VARIABLES
    private Scanner teclado;
    private int cont;
    public Derramas[] datosDerramas;   [numero de derrama] [3   descripcion, importe y 

    private int importe;
    private char tipo;
    private String descripcion;

    /**
     * Reparto del importe segun el coeficiente de cada propietario
     *
     * @param numero
     * @return
     */
    /**
    contador++;
    * System.out.println();
    * importe=lecto.nexDouble();
    * datoDerramas[contador].setImporte(importe);
    * 
    * 
    * 
    * 
    * 
    * 
    * public void introducirPresupuesto() {
        teclado = new Scanner(System.in);
        System.out.println("Cuantos presupuestos introducira?");
        int presupuestos = teclado.nextInt();
        datosDerramas = new String[presupuestos][3];
        System.out.println("Debe introducir los datos del presupuesto segun el orden que le indiquemos a continuacion.");
        System.out.println("importe/tipo/descripcion");
        for (int f = 0; f < datosDerramas.length; f++) {
            System.out.println("----------------");
            for (int c = 0; c < datosDerramas[f].length; c++) {
                System.out.println("Ingrese el dato:");
                datosDerramas[f][c] = teclado.next();
            }
        }

    }
    /**
     * Muestra importe y guarda en variable
     */
    /*
    public void importe() {
        System.out.println("IMPORTE\n------------------");
        for (int f = 0; f < datosDerramas.length; f++) {
            for (int c = 0; c < datosDerramas[f].length; c = c + 3) {
                importe = Integer.parseInt(datosDerramas[f][c]);
                cont++;
                System.out.println("Importe " + cont + "|" + importe + "|");
            }
        }
    }

    /**
     * Muestra tipo derrama y guarda en variable
     *//*
    public void tipoDerrama() {
        System.out.println("TIPO\n------------------");
        for (int f = 0; f < datosDerramas.length; f++) {
            for (int c = 1; c < datosDerramas[f].length; c = c + 3) {
                tipo = datosDerramas[f][c].charAt(0);
                cont++;
                System.out.println("Tipo " + cont + "|" + tipo + "|");
            }
        }
    }
/*
    /**
     * Muestra la descripcion de presupuesto/s y guarda en variable
     *//*
    public void descripcion() {
        System.out.println("Descripcion\n------------------");
        for (int f = 0; f < datosDerramas.length; f++) {
            for (int c = 2; c < datosDerramas[f].length; c = c + 3) {
                descripcion = datosDerramas[f][c];
                cont++;
                System.out.println("descripcion " + cont + "|" + descripcion + "|");
            }
        }
    }

    /**
     * Muestra todos los presupuestos introducidos
     *//*
    public void mostrarPresupuesto() {
        System.out.println("Informe de derrama\n----------------------------");
        for (int f = 0; f < datosDerramas.length; f++) {
            for (int c = 0; c < datosDerramas[f].length; c++) {
                System.out.println("|" + datosDerramas[f][c] + "|");
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
     *//*
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
     *//*
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

    public void añadirDerramas() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            Añadir derramas                                             |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        gestor.introducirPresupuesto();
        System.out.println("Desea mostrar el informe de derrama introducido?(1- SI/2- NO)");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1:

                gestor.mostrarPresupuesto();
                System.out.println("Gracias por su colaboracion");
                imprimirEn.menu();

                break;
            case 2:

                System.out.println("Gracias por su colaboracion");
                imprimirEn.menu();

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

    public void listarPresupuestos() {

    }
    
*/
}
