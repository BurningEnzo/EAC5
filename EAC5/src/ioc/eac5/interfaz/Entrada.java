/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.derramas.GestorDeDerramas;

/**
 *
 * @author Uri
 */
public class Entrada {

    Scanner teclado = new Scanner(System.in);
    //   GestorDeDatos gestor = new GestorDeDatos();
    int opcion;
    String identificadorElegido;
    String cargoElegido;
    private boolean importado = false;

    public void opcionesMenuPrincipal() {

        boolean correcto = false;

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
                Salida.cabeceraMenuPropietarios();
                Salida.menuPropietarios();

                break;
            case 2:
                Salida.cabeceraMenuDerramas();
                Salida.menuDerramas();

                break;
            case 3:
                Salida.cabeceraMenuCargos();
                Salida.menuCargos();
                break;

            case 4:
                Salida.despedida();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                opcionesMenuPrincipal();
                break;
        }
    }

    public void opcionesMenuPropietarios() {

        boolean correcto;
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

                    GestorDeDatos.tratarDatosGestoria();
                    importado = true;
                    System.out.println("Datos importados correctamente.\n");
                    Salida.menuPropietarios();
                } else {
                    System.out.println("Los datos ya han sido importados previamente.");
                    Salida.menuPropietarios();
                }
                break;
            case 2:

                if (importado) {
                    int i;
                    boolean preguntar = true;

                    System.out.print("Por favor, introduzca el identificador del piso a modificar: ");
                    do {

                        identificadorElegido = teclado.nextLine();

                        for (i = 0; i < GestorDeDatos.datosVecino.length; i++) {

                            if (identificadorElegido.equalsIgnoreCase(GestorDeDatos.datosVecino[i].getIdentificador())) {
                                Salida.mostrarPropietario(identificadorElegido, i);

                                preguntar = false;

                            }

                        }

                    } while (preguntar);
                    solicitarDatosModificacion(identificadorElegido, i);
                }
                break;

            case 3:
                //Ordenacion
                Salida.consultaPropietarios();
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
                GestorDeDatos.mostrarListado(orden);
                /*switch (orden) {
                 case 1:
                 GestorDeDatos.mostrarListado(orden);
                 break;
                 case 2:

                 break;
                 case 3:

                 break;

                 case 4:

                 break;
                 default:

                 System.out.println("Opción no válida. Por favor, introduzca una opción válida.");

                 break;
                 }*/

                break;
            case 4:

                opcionesMenuPrincipal();
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                opcionesMenuPropietarios();
                break;

        }
    }

    public void solicitarDatosModificacion(String identificador, int posicion) {
        boolean correcto;

        System.out.print("Elija el campo a modificar (1-5) o (6) para cancelar: ");
        do {

            correcto = teclado.hasNextInt();
            if (correcto) {
                opcion = teclado.nextInt();

            } else {
                System.out.println("Por favor, introduzca una opción válida");
                teclado.nextLine();
            }
        } while (!correcto);

        switch (opcion) {
            case 1:

                String nuevoNombre = "";
                System.out.print("Por favor, introduzca el nuevo nombre: ");

                boolean preguntar = true;
                while (preguntar) {
                    teclado.nextLine();
                    nuevoNombre = teclado.nextLine();

                    preguntar = false;

                }

                GestorDeDatos.modificarCampo(identificador, opcion, nuevoNombre);

                break;

            case 2:

                String nuevoTelefono = "";
                System.out.print("Por favor, introduzca el nuevo teléfono: ");

                preguntar = true;
                while (preguntar) {
                    teclado.nextLine();
                    nuevoTelefono = teclado.nextLine();

                    preguntar = false;

                }

                GestorDeDatos.modificarCampo(identificador, opcion, nuevoTelefono);
                break;

            case 3:

                double nuevoCoeficiente = 0;
                System.out.print("Por favor, introduzca el nuevo coeficiente: ");

                preguntar = true;
                while (preguntar) {

                    correcto = false;
                    do {
                        correcto = teclado.hasNextDouble();
                        if (correcto) {
                            nuevoCoeficiente = teclado.nextDouble();

                        } else {
                            System.out.println("Dato incorrecto.");
                            teclado.nextLine();
                        }
                    } while (!correcto);

                    preguntar = false;

                }

                GestorDeDatos.modificarCampo(identificador, opcion, String.valueOf(nuevoCoeficiente));
                break;

            case 4:
                char nuevoTipoC;
                System.out.print("¿El propietario está exento de gastos de tipo C? (S/N): ");

                preguntar = true;
                while (preguntar) {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevoTipoC = teclado.next().charAt(0);

                        if (Character.toLowerCase(nuevoTipoC) == 's') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "0");
                        } else if (Character.toLowerCase(nuevoTipoC) == 'n') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "1");
                        }

                    }

                    preguntar = false;

                }

                break;

            case 5:
                char nuevaPresencia;
                System.out.print("¿El propietario está ausente? (S/N): ");

                preguntar = true;
                while (preguntar) {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevaPresencia = teclado.next().charAt(0);

                        if (Character.toLowerCase(nuevaPresencia) == 's') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "N");
                        } else if (Character.toLowerCase(nuevaPresencia) == 'n') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "S");
                        }

                    }

                    preguntar = false;

                }
                break;

            case 6:
                Salida.cabeceraMenuPropietarios();
                Salida.menuPropietarios();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");

        }

    }

    public void opcionesMenuDerramas() {
        GestorDeDerramas GestorDeDerranas = new GestorDeDerramas();
        boolean correcto;
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
                Salida.cabeceraMenuDerramas();
                GestorDeDerranas.añadirDerrama();
                break;

            case 2:
                Salida.cabeceraMenuDerramas();
                GestorDeDerranas.modificarDerramas();
                break;

            case 3:
                Salida.cabeceraMenuDerramas();
                GestorDeDerranas.listarDerrama();
                break;

            case 4:
                Salida.cabeceraMenuDerramas();
                GestorDeDerranas.tipoDerrama();
                break;
            case 5:
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                opcionesMenuDerramas();
                break;
        }
    }

    public void opcionesMenuCargos() {
        boolean correcto;
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
                for (int a = 0; a < GestorDeDatos.datosVecino.length; a++) {
                    if (GestorDeDatos.datosVecino[a].getCargo().equalsIgnoreCase("P")
                            || GestorDeDatos.datosVecino[a].getCargo().equalsIgnoreCase("V")
                            || GestorDeDatos.datosVecino[a].getCargo().equalsIgnoreCase("S")) {
                        System.out.print("-" + GestorDeDatos.datosVecino[a].getCargo() + "\t: " + GestorDeDatos.datosVecino[a].getNombrePropietario() + " (" + GestorDeDatos.datosVecino[a].getTelefono() + " (" + GestorDeDatos.datosVecino[a].getNombrePiso() + ")");
                    }
                }

                break;

            case 2:
                int i;
                boolean preguntar = true;
                do {
                    cargoElegido = teclado.nextLine();
                    for (i = 0; i < GestorDeDatos.datosVecino.length; i++) {
                        System.out.println("RENOVAR CARGOS DE LA JUNTA");
                    }
                    if (cargoElegido.equalsIgnoreCase(GestorDeDatos.datosVecino[i].getCargo())) {

                    }
                    break;
                  case 3:
                     char nuevoCargo;
                System.out.print("Introduce el cargo a substituir ");

                preguntar = true;
                while (preguntar) {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevoCargo = teclado.next().charAt(0);

                        if (Character.toLowerCase(nuevoCargo) == 's') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "N");
                        } else if (Character.toLowerCase(nuevaPresencia) == 'n') {
                            GestorDeDatos.modificarCampo(identificador, opcion, "S");
                        }

                    }

                    preguntar = false;

                }
                break;
      
              
                case 4:

                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");
                opcionesMenuCargos();
                
                            }
                
        }
    }
}
