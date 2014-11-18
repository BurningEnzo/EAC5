/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import ioc.eac5.derramas.GestorDeDerramas;
import ioc.eac5.vecinos.GestorDeVecinos;
import ioc.eac5.junta.Junta;
import ioc.eac5.vecinos.Vecino;
import java.util.Scanner;

/**
 *
 * @author Lorenzo
 */
public class Menu {

    static Scanner teclado = new Scanner(System.in);
    static GestorDeVecinos gestor = new GestorDeVecinos();
    static GestorDeDerramas derramas = new GestorDeDerramas();
    static Junta junta = new Junta();

    static int opcion = 0;
    static boolean correcto = false;
    static boolean importado = false;
    static String identificadorElegido = "";

    public static void bienvenida() {

        System.out.println("Bienvenido/a al programa de gestión de la comunidad\n"
                + "\nEl programa permite gestionar los propietarios de la comunidad,\n"
                + "gestionar las derramas y los cargos de la junta");

    }

    public static void despedida() {

        System.out.println("Muchas gracias por usar nuestro programa.");
    }

    public static void menuPrincipal() {

        System.out.println("\n-----------------------------------------------");
        System.out.println("                Menú principal");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Gestión de propietarios");
        System.out.println("2) Gestion de derramas");
        System.out.println("3) Gestión de cargos de la junta");
        System.out.println("4) Salir del programa");
        System.out.println("-----------------------------------------------");
        System.out.print("Por favor, seleccione una opción: ");

        correcto = false;

        do {
            correcto = teclado.hasNextInt();
            if (correcto) {
                opcion = teclado.nextInt();

            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.next();
            }
        } while (!correcto);

        switch (opcion) {
            case 1:
                cabeceraMenuPropietarios();
                menuPropietarios();

                break;
            case 2:
                if (importado) {
                    cabeceraMenuDerramas();
                    menuDerramas();
                } else {
                    System.out.println("\n-------------------------------Por favor, introduzca los datos de gestoría primero.------------------------------------");
                }
                menuPrincipal();
                break;
            case 3:
                if (importado) {
                    cabeceraMenuCargos();
                    menuCargos();
                } else {
                    System.out.println("\n-------------------------------Por favor, introduzca los datos de gestoría primero.------------------------------------");
                }
                menuPrincipal();
                break;

            case 4:
                despedida();
                break;
            default:

                System.out.println("\n-------------------------------Por favor, introduzca los datos de gestoría primero.------------------------------------");
                menuPrincipal();
                break;
        }
    }

    //Menús de: 1) Gestión de propietarios
    public static void cabeceraMenuPropietarios() {
        System.out.println("-----------------------------------------------");
        System.out.println("                Propietarios");
        System.out.println("-----------------------------------------------");
    }

    public static void menuPropietarios() {

        System.out.println("1) Importar datos desde la gestoría");
        System.out.println("2) Modificar datos de propietario");
        System.out.println("3) Listado de propietarios");
        System.out.println("4) Volver al menú anterior");
        System.out.print("\nPor favor, seleccione una opción: ");

        correcto = false;
        do {
            correcto = teclado.hasNextInt();
            if (correcto) {
                opcion = teclado.nextInt();

            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.next();
            }
        } while (!correcto);

        switch (opcion) {
            case 1:
                if (!importado) {

                    GestorDeVecinos.tratarDatosGestoria();
                    importado = true;
                    System.out.println("Datos importados correctamente.\n");
                    menuPropietarios();
                } else {
                    System.out.println("Los datos ya han sido importados previamente.");
                    menuPropietarios();
                }
                break;
            case 2:

                if (importado) {
                    int i;
                    boolean preguntar = true;

                    System.out.print("Por favor, introduzca el identificador del piso a modificar: ");
                    do {

                        identificadorElegido = teclado.nextLine();

                        for (i = 0; i < GestorDeVecinos.datosVecino.length; i++) {

                            if (identificadorElegido.equalsIgnoreCase(GestorDeVecinos.datosVecino[i].getIdentificador())) {
                                GestorDeVecinos.mostrarPropietario(identificadorElegido, i);

                                preguntar = false;

                            }

                        }

                    } while (preguntar);
                    GestorDeVecinos.solicitarDatosModificacion(identificadorElegido, i);
                }
                break;

            case 3:
                System.out.println("1) Ordenar por el orden natural del piso");
                System.out.println("2) Ordenar alfabéticamente por el nombre del propietario");
                System.out.println("3) Ordenar por coeficiente de propiedad");
                System.out.println("4) Volver al menú anterior");
                System.out.print("\nPor favor, seleccione una opción: ");
                int orden = 0;

                correcto = false;

                do {
                    correcto = teclado.hasNextInt();
                    if (correcto) {
                        orden = teclado.nextInt();

                    } else {
                        System.out.println("Por favor, introduzca una opción válida");
                        teclado.next();
                    }
                } while (!correcto);
                GestorDeVecinos.mostrarListado(orden);
                break;
            case 4:

                menuPrincipal();
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                menuPropietarios();
                break;

        }
    }

    //Menús de: 2) Gestión de derramas
    public static void cabeceraMenuDerramas() {
        System.out.println("-----------------------------------------------");
        System.out.println("                   Derramas");
        System.out.println("-----------------------------------------------");
    }

    public static void menuDerramas() {

        System.out.println("1) Añadir derrama");
        System.out.println("2) Modificar derrama existente");
        System.out.println("3) Listar derramas");
        System.out.println("4) Calcular reparto de los presupuestos");
        System.out.println("5) Volver al menú anterior");
        System.out.print("Por favor, seleccione una opción:");

        correcto = false;
        do {
            correcto = teclado.hasNextInt();
            if (correcto) {
                opcion = teclado.nextInt();

            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.next();
            }
        } while (!correcto);

        switch (opcion) {
            case 1:
                derramas.añadirDerrama();

                break;

            case 2:
                derramas.modificarDerramas();

                break;

            case 3:
                GestorDeDerramas.listarDerrama();

                break;

            case 4:
                derramas.tipoDerrama();

                break;
            case 5:
                menuPrincipal();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                menuDerramas();
                break;
        }

    }
//Menús de: 3) Gestión de cargos

    public static void cabeceraMenuCargos() {
        System.out.println("-----------------------------------------------");
        System.out.println("                   Cargos");
        System.out.println("-----------------------------------------------");

    }

    public static void menuCargos() {

        System.out.println("1) Listar la junta actual");
        System.out.println("2) Renovar cargos de la junta");
        System.out.println("3) Sustituir cargo de la junta");
        System.out.println("4) Volver al menú anterior");
        System.out.print("Por favor, seleccione una opción:");

        correcto = false;
        do {
            correcto = teclado.hasNextInt();
            if (correcto) {
                opcion = teclado.nextInt();

            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.next();
            }
        } while (!correcto);

        switch (opcion) {

            case 1:

                /* for (Vecino datosVecino : GestorDeVecinos.datosVecino) {
                 System.out.print("-" + datosVecino.getCargo() + "\t: " + datosVecino.getNombrePropietario() + " (" + datosVecino.getTelefono() + " (" + datosVecino.getNombrePiso() + ")");
                 if (datosVecino.getCargo().equalsIgnoreCase("P") || datosVecino.getCargo().equalsIgnoreCase("V") || datosVecino.getCargo().equalsIgnoreCase("S")) {
                 //System.out.println(" -CARGO-");
                 }
                 }*/
                break;

            case 2:

                /*for (Vecino datosVecino : GestorDeVecinos.datosVecino) {
                 // posSelec = posicioValida(posSelec, dadesPisos);
                 // posSortejades[i]=posSelec;
                 System.out.print("-" + datosVecino.getNombrePiso() + "\t(" + datosVecino.getCoeficiente() + "): " + datosVecino.getNombrePropietario() + " (" + datosVecino.getTelefono() + ")");
                 if (datosVecino.getPresencia().equalsIgnoreCase("N")) {
                 }
                 }*/
                break;
            case 3:
                /*
                 int i;
                 boolean preguntar = true;
                 String cargoElegido="";
                 System.out.print("Por favor, introduzca el cargo de la junta a modificar: ");
                 System.out.println("[Presidente , Vicepresidente o Secretario]");
                 do {

                 cargoElegido = teclado.nextLine();

                 for (i = 0; i < GestorDeVecinos.datosVecino.length; i++) {

                 if (cargoElegido.equalsIgnoreCase(GestorDeVecinos.datosVecino[i].getCargo())) {
                 Salida.mostrarPropietario(cargoElegido, i);

                 preguntar = false;

                 }

                 }

                 } while (preguntar);
                 GestorDeVecinos.solicitarDatosModificacion(cargoElegido, i);
                 */
                break;
            case 4:
                cabeceraMenuCargos();
                menuCargos();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");

        }
    }
}
