/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;
import ioc.eac5.vecinos.GestorDeVecinos;
import ioc.eac5.derramas.GestorDeDerramas;

import ioc.eac5.vecinos.Vecino;

/**
 *
 * @author Uri
 */
public class Entrada {
/*
    Scanner teclado = new Scanner(System.in);
    //   GestorDeVecinos gestor = new GestorDeVecinos();
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

                    GestorDeVecinos.tratarDatosGestoria();
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

                        for (i = 0; i < GestorDeVecinos.datosVecino.length; i++) {

                            if (identificadorElegido.equalsIgnoreCase(GestorDeVecinos.datosVecino[i].getIdentificador())) {
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
                GestorDeVecinos.mostrarListado(orden);
                /*switch (orden) {
                 case 1:
                 GestorDeVecinos.mostrarListado(orden);
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
                 }

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

                GestorDeVecinos.modificarCampo(identificador, opcion, nuevoNombre);

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

                GestorDeVecinos.modificarCampo(identificador, opcion, nuevoTelefono);
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

                GestorDeVecinos.modificarCampo(identificador, opcion, String.valueOf(nuevoCoeficiente));
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
                            GestorDeVecinos.modificarCampo(identificador, opcion, "0");
                        } else if (Character.toLowerCase(nuevoTipoC) == 'n') {
                            GestorDeVecinos.modificarCampo(identificador, opcion, "1");
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
                            GestorDeVecinos.modificarCampo(identificador, opcion, "N");
                        } else if (Character.toLowerCase(nuevaPresencia) == 'n') {
                            GestorDeVecinos.modificarCampo(identificador, opcion, "S");
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

        GestorDeDerramas GestorDe = new GestorDeDerramas();

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

                break;

            case 2:
                Salida.cabeceraMenuDerramas();

                break;

            case 3:
                Salida.cabeceraMenuDerramas();

                break;

            case 4:
                Salida.cabeceraMenuDerramas();

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
                if (!importado) {
                    GestorDeVecinos.tratarDatosGestoria();
                    importado = true;
                    System.out.println("Datos importados correctamente.\n");
                    Salida.menuCargos();
                } else {
                    System.out.println("Los datos ya han sido importados previamente.");
                    Salida.menuCargos();
                }
                break;
            case 2:
                Salida.cabeceraMenuCargos();
                for (Vecino datosVecino : GestorDeVecinos.datosVecino) {
                    System.out.print("-" + datosVecino.getCargo() + "\t: " + datosVecino.getNombrePropietario() + " (" + datosVecino.getTelefono() + " (" + datosVecino.getNombrePiso() + ")");
                    if (datosVecino.getCargo().equalsIgnoreCase("P") || datosVecino.getCargo().equalsIgnoreCase("V") || datosVecino.getCargo().equalsIgnoreCase("S")) {
                        //System.out.println(" -CARGO-");
                    }
                }
                break;

            case 3:
                Salida.cabeceraMenuCargos();
                for (Vecino datosVecino : GestorDeVecinos.datosVecino) {
            // posSelec = posicioValida(posSelec, dadesPisos);
                    // posSortejades[i]=posSelec;
                    System.out.print("-" + datosVecino.getNombrePiso() + "\t(" + datosVecino.getCoeficiente() + "): " + datosVecino.getNombrePropietario() + " (" + datosVecino.getTelefono() + ")");
                    if (datosVecino.getPresencia().equalsIgnoreCase("N")) {
                    }
                }
                break;
            case 4:
                Salida.cabeceraMenuCargos();
                int i;
                boolean preguntar = true;

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
                solicitarDatosModificacion(cargoElegido, i);

                break;
            case 5:
                Salida.cabeceraMenuCargos();
                Salida.menuCargos();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");

        }
    }
*/
}
