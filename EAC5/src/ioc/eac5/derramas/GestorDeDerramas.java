/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;

import ioc.eac5.interfaz.Salida;

/**
 *
 * @author Lorenzo
 */
public class GestorDeDerramas {

    Scanner leer = new Scanner(System.in);
    Salida salida = new Salida();
    GestorDeDatos gestor = new GestorDeDatos();

    Double importe = 0.0;
    char tipo = ' ';
    String descripcion = " ";
    static int cont = 0;
    int opcion = 0;
    int vecinos = 25;
    int tipoC=0;
    Derramas[] d = new Derramas[20];

    public void añadirDerrama() {

        System.out.println("1)Añadir nueva derrama\n2)Volver al menú anterior");
        opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                d[cont] = new Derramas();
                System.out.println("Ingrese el importe:");
                importe = leer.nextDouble();
                System.out.println("Ingrese el tipo:");
                tipo = leer.next().charAt(0);
                System.out.println("Ingrese la descripción:");
                descripcion = leer.next();
                leer.nextLine();
                d[cont].setImporte(importe);
                d[cont].setTipoDerrama(tipo);
                d[cont].setDescripcion(descripcion);
                cont++;

                break;
            case 2:
                salida.cabeceraMenuDerramas();
                salida.menuDerramas();
                break;
        }

    }

    public void listarDerrama() {
        for (int i = 0; i < cont; i++) {
            System.out.println("Importe: " + d[i].getImporte() + " Tipo: " + d[i].getTipoDerrama() + " Descripción: " + d[i].getDescripcion() + "");
            salida.cabeceraMenuDerramas();
            salida.menuDerramas();
        }
    }

    public void tipoDerrama() {
        for (int i = 0; i < cont; i++) {
            if (d[i].getTipoDerrama() == 'a') {
                System.out.println("Tipo A");
                gestor.tratarDatosGestoria();
                for (int j = 0; j < gestor.datosVecino.length; j++) {
                    double pagar = Double.parseDouble(gestor.datosVecino[j].getCoeficiente());
                    double pagarA = (d[i].getImporte() / pagar) / 100;
                    pagarA = Math.round(pagarA);
                    System.out.println(gestor.datosVecino[j].getNombrePiso() + " con coeficiente " + gestor.datosVecino[j].getCoeficiente() + " debe pagar " + pagarA);
                }
            } else if (d[i].getTipoDerrama() == 'b') {
                System.out.println("Tipo B");
                for (int k = 0; k < gestor.datosVecino.length; k++) {
                    System.out.print(gestor.datosVecino[k].getIdentificador() + " " + gestor.datosVecino[k].getNombrePiso() + " " + gestor.datosVecino[k].getNombrePropietario() + " " + gestor.datosVecino[k].getPresencia() + " " + gestor.datosVecino[k].getTelefono() + " " + gestor.datosVecino[k].getTipoC() + "\n");

                }
                System.out.println("\n------------------------------------------------------------------");
                double pagarB = d[i].getImporte() / vecinos;
                System.out.println("Cada vecino debe abonar: " + pagarB + "€");

            } else if (d[i].getTipoDerrama() == 'c') {
                System.out.println("Tipo C");
                for (int l = 0; l < gestor.datosVecino.length; l++) {
                    tipoC=Integer.parseInt(gestor.datosVecino[l].getTipoC());
                    if(tipoC==1){
                        double pagarC = d[i].getImporte() / vecinos;
                    System.out.print(gestor.datosVecino[l].getIdentificador() + " " + gestor.datosVecino[l].getNombrePiso() + " " + gestor.datosVecino[l].getNombrePropietario() + " " + gestor.datosVecino[l].getPresencia() + " " + gestor.datosVecino[l].getTelefono() + " " + gestor.datosVecino[l].getTipoC() +" debe abonar "+pagarC+"€\n");
                    }else{
                        System.out.print(gestor.datosVecino[l].getIdentificador() + " " + gestor.datosVecino[l].getNombrePiso() + " " + gestor.datosVecino[l].getNombrePropietario() + " " + gestor.datosVecino[l].getPresencia() + " " + gestor.datosVecino[l].getTelefono() + " " + gestor.datosVecino[l].getTipoC() +" EXEMPT\n");
                    }
                }

            }
        }

    }
}
