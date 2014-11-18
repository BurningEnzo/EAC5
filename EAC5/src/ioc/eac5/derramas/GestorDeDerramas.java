/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;

import java.util.Scanner;
import ioc.eac5.vecinos.GestorDeVecinos;
import ioc.eac5.interfaz.Menu;

/**
 *
 * @author Lorenzo
 */
public class GestorDeDerramas {

    Scanner leer = new Scanner(System.in);
    //Salida salida = new Salida();
    GestorDeVecinos GestorDeVecinos = new GestorDeVecinos();
    Double importe = 0.0;
    char tipo = ' ';
    String descripcion = " ";
    static int cont = 0;
    int opcion = 0;
    int vecinos = GestorDeVecinos.numPisos;
    int tipoC = 0;
    static Derrama[] d = new Derrama[20];

    public void añadirDerrama() {

        System.out.println("1)Añadir nueva derrama\n2)Volver al menú anterior");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                d[cont] = new Derrama();
                System.out.println("Ingrese el importe:");
                importe = leer.nextDouble();
                System.out.println("Ingrese el tipo:");
                tipo = leer.next().charAt(0);
                System.out.println("Ingrese la descripción:");
                leer.nextLine();
                descripcion = leer.nextLine();

                d[cont].setImporte(importe);
                d[cont].setTipoDerrama(tipo);
                d[cont].setDescripcion(descripcion);
                cont++;
                listarDerrama();
                añadirDerrama();
                break;
            case 2:
                Menu.cabeceraMenuDerramas();
                Menu.menuDerramas();
                break;
        }

    }

    public static void listarDerrama() {

        if (cont > 0) {
            for (int i = 0; i < cont; i++) {
                System.out.println("#" + (i + 1) + " Importe: " + d[i].getImporte() + " Tipo: " + d[i].getTipoDerrama() + " Descripción: " + d[i].getDescripcion() + "");

            }
        } else {
            System.out.println("No existen presupuestos");
        }
    }

    public void tipoDerrama() {

        double pagarA = 0;
        double pagarB = 0;
        double pagarC = 0;

        for (int i = 0; i < cont; i++) {
            if (d[i].getTipoDerrama() == 'a' || d[i].getTipoDerrama() == 'A') {

                for (int j = 0; j < GestorDeVecinos.datosVecino.length; j++) {
                    double pagar = GestorDeVecinos.datosVecino[j].getCoeficiente();
                    pagarA = d[i].getImporte() * pagar;
                    GestorDeVecinos.datosVecino[j].setGastosTipoA(pagarA);
                }
            } else if (d[i].getTipoDerrama() == 'b' || d[i].getTipoDerrama() == 'B') {
                for (int k = 0; k < GestorDeVecinos.datosVecino.length; k++) {

                }
                pagarB = d[i].getImporte() / vecinos;
                GestorDeVecinos.datosVecino[i].setGastosTipoB(pagarB);
            } else if (d[i].getTipoDerrama() == 'c' || d[i].getTipoDerrama() == 'C') {
                int contadorC = 0;
                for (int l = 0; l < GestorDeVecinos.datosVecino.length; l++) {

                    //     tipoC = GestorDeVecinos.datosVecino[l].getTipoC();
                    if (GestorDeVecinos.datosVecino[l].getTipoC() == 1) {
                        contadorC = contadorC + 1;

                    }

                }
                double gastosC = d[i].getImporte() / contadorC;
                for (int w = 0; w < GestorDeVecinos.datosVecino.length; w++) {
                    if (GestorDeVecinos.datosVecino[w].getTipoC() == 1) {
                        GestorDeVecinos.datosVecino[w].setGastosTipoC(pagarC);
                    }
                }
            }

        }

        System.out.println("\n Relación de gastos detallados por propietario: ");
        System.out.println("---------------------------------------------------\n");
        for (int i = 0; i < GestorDeVecinos.datosVecino.length; i++) {
            System.out.println("-" + GestorDeVecinos.datosVecino[i].getNombrePiso() + ": " + (GestorDeVecinos.datosVecino[i].getGastosTipoA() + GestorDeVecinos.datosVecino[i].getGastosTipoB() + GestorDeVecinos.datosVecino[i].getGastosTipoC()));

        }
    }

    public void modificarDerramas() {
        int numero = 0;
        int Mopcion = 0;
        listarDerrama();
        System.out.print("Introduzca el numero de presupuesto el cual desea modificar: ");
        numero = leer.nextInt();
        System.out.println("\nModificación a realizar\n------------------------\n1) Modificar Importe\n2) Modificar tipo\n3) Modificar descripción\n4) Eliminar presupuesto");
        Mopcion = leer.nextInt();
        switch (Mopcion) {
            case 1:

                System.out.print("Introduce el nuevo importe: ");
                double nuevoImp = leer.nextDouble();
                d[numero - 1].setImporte(nuevoImp);
                System.out.println("\nNuevo Importe: " + d[numero - 1].getImporte() + " Tipo: " + d[numero - 1].getTipoDerrama() + " Descripción: " + d[numero - 1].getDescripcion() + " ");

                break;
            case 2:
                System.out.print("Introduce el nuevo tipo: ");
                char nuevoTipo = leer.next().charAt(0);
                d[numero - 1].setTipoDerrama(nuevoTipo);
                System.out.println("\nImporte: " + d[numero - 1].getImporte() + " Nuevo Tipo: " + d[numero - 1].getTipoDerrama() + " Descripción: " + d[numero - 1].getDescripcion() + " ");
                break;
            case 3:
                System.out.print("Introduce la nueva descripción: ");
                String nuevoDesc = leer.nextLine();
                d[numero - 1].setDescripcion(nuevoDesc);
                System.out.println("\nImporte: " + d[numero - 1].getImporte() + " Tipo: " + d[numero - 1].getTipoDerrama() + " Nueva Descripción: " + d[numero - 1].getDescripcion() + " ");
                break;
            case 4:

                boolean correcto = false;

                do {
                    correcto = leer.hasNextInt();
                    if (correcto) {
                        int numeroABorrar = leer.nextInt();
                        if (numeroABorrar >= 0 && numeroABorrar <= d.length) {
                            d = borrarDerrama(d, numeroABorrar - 1);
                            cont--;
                        } else {
                            System.out.println("El presupuesto indicado no existe.");
                        }
                    }
                } while (!correcto);

                break;

        }

    }

    /**
     *
     * @param array
     * @param pos
     * @return
     */
    public Derrama[] borrarDerrama(Derrama[] array, int pos) {
        if ((pos >= 0) && (pos < array.length)) {
            Derrama[] nuevoD = new Derrama[array.length - 1];
            copiarNPosiciones(array, nuevoD, pos);
            for (int i = pos + 1; i < array.length; i++) {
                nuevoD[i - 1] = array[i];
            }
            return nuevoD;
        } else {
            return null;
        }
    }

    /**
     * Método que copia las posiciones antes de la que se va a eliminar
     * @param origen Array par
     * @param destino
     * @param n
     */
    public void copiarNPosiciones(Derrama[] origen, Derrama[] destino, int n) {
        for (int i = 0; i < n; i++) {
            destino[i] = origen[i];
        }
    }
}
