/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.vecinos;

import java.util.Scanner;
import ioc.eines.Gestoria;
import ioc.eac5.interfaz.Menu;

/**
 * Clase que gestiona los datos de la aplicación
 *
 * @author Lorenzo
 */
public class GestorDeVecinos {

    //CONSTANTES
    //Separadores de la cadena proporcionada por la gestoria
    private static final String SEPARADOR_PISOS = "#";
    private static final String SEPARADOR_DATOS = ";";

    //Identificadores del tipo de orden
    private static final int PISO = 0;
    private static final int NOMBRE = 1;
    private static final int COEFICIENTE = 2;

    public static final char AUSENTE = 'N';
    public static final char PRESENTE = 'S';

    //VARIABLES
    //Array con los datos de los vecinos
    public static Vecino[] datosVecino;
    //Número de pisos
    public static int numPisos;
    //Array de ordenación
    public static int[][] arrayOrden;

    /**
     * Método que importa los datos de la gestoría y los almacena en el array
     */
    public static void tratarDatosGestoria() {

        //Se inicializa la clase Gestoria para usar sus métodos
        Gestoria datosGestoria = new Gestoria();
        String cadenaDatos = datosGestoria.importarDades();
        //Se hace una primera división de la cadena de la gestoría
        //Se crean almacenes temporales para almacenar los datos a la hora de dividirlos
        String[] almacenTemporal;
        String[] almacenDatosVecino;
        almacenTemporal = cadenaDatos.split(SEPARADOR_PISOS);
        //Se almacena el número de pisos de la comunidad
        numPisos = Integer.parseInt(almacenTemporal[0]);
        arrayOrden = new int[numPisos][3];
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
            datosVecino[i].setPresencia(almacenDatosVecino[4].trim().charAt(0));
            //datosVecino[i].coeficiente = almacenDatosVecino[5].trim();
            datosVecino[i].setCoeficiente(Double.parseDouble(almacenDatosVecino[5].trim()));
            //datosVecino[i].tipoC = almacenDatosVecino[6].trim();
            datosVecino[i].setTipoC(Integer.parseInt(almacenDatosVecino[6].trim()));
            if (almacenDatosVecino.length == 8) {
                datosVecino[i].setCargo(almacenDatosVecino[7].trim().charAt(0));
            } else {
                datosVecino[i].setCargo(' ');
            }
        }
        for (int i = 0; i < datosVecino.length; i++) {
            arrayOrden[i][PISO] = i;
            arrayOrden[i][NOMBRE] = i;
            arrayOrden[i][COEFICIENTE] = i;
        }
    }

    /**
     * Método para modificar un campo de cualquier piso
     *
     * @param identificador Identificador del piso
     * @param campo Campo a modificar
     * @param dato Dato modificado
     */
    /*public static void modificarCampo(String identificador, int campo, String dato) {
     //Se hace un recorrido por todos los vecinos
     for (int i = 0; i < datosVecino.length; i++) {
     //Si el identificador introducido concuerda con uno de los pisos
     if (identificador.equalsIgnoreCase(datosVecino[i].getIdentificador())) {
     //Modifica el campo según la opción elegida
     switch (campo) {
     case 1:
     datosVecino[i].setNombrePropietario(dato);
     System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[i].getNombrePropietario() + ")");
     mostrarPropietario(identificador, i);
     solicitarDatosModificacion(identificador, i);
     break;
     case 2:
     datosVecino[i].setTelefono(dato);
     System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[i].getTelefono() + ")");
     mostrarPropietario(identificador, i);
     solicitarDatosModificacion(identificador, i);
     break;
     case 3:
     datosVecino[i].setCoeficiente(dato);
     System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[i].getCoeficiente() + ")");
     mostrarPropietario(identificador, i);
     solicitarDatosModificacion(identificador, i);
     break;
     case 4:
     datosVecino[i].setTipoC(dato);
     System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[i].getTipoC() + ")");
     mostrarPropietario(identificador, i);
     solicitarDatosModificacion(identificador, i);
     break;
     case 5:
     datosVecino[i].setPresencia(dato);
     System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[i].getPresencia() + ")");
     mostrarPropietario(identificador, i);
     solicitarDatosModificacion(identificador, i);
     break;

     default:
     System.out.println("Opción incorrecta.");
     break;
     }
     }
     }
     }*/
    /**
     * Método que muestra el listado de pisos por el orden especificado
     *
     * @param orden Tipo de ordenación
     */
    public static void mostrarListado(int orden) {

        switch (orden) {

            //Ordenar por orden natural del piso
            case 1:

                System.out.println("\nLISTA DE PROPIETARIOS POR ORDEN NATURAL DEL PISO");
                System.out.println("------------------------------------------------\n");

                for (int a = 0; a < arrayOrden.length; a++) {
                    System.out.print("-" + datosVecino[arrayOrden[a][PISO]].getNombrePiso() + "\t(" + datosVecino[arrayOrden[a][PISO]].getCoeficiente() + "): " + datosVecino[arrayOrden[a][PISO]].getNombrePropietario() + " (" + datosVecino[arrayOrden[a][PISO]].getTelefono() + ")");
                    if (datosVecino[arrayOrden[a][PISO]].getPresencia()==AUSENTE) {
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

                for (int i = 0; i < datosVecino.length - 1; i++) {
                    for (int j = i + 1; j < datosVecino.length; j++) {

                        if (datosVecino[arrayOrden[i][NOMBRE]].getNombrePropietario().compareToIgnoreCase(datosVecino[arrayOrden[j][NOMBRE]].getNombrePropietario()) > 0) {
                            int aux = arrayOrden[i][NOMBRE];
                            arrayOrden[i][NOMBRE] = arrayOrden[j][NOMBRE];
                            arrayOrden[j][NOMBRE] = aux;

                        }
                    }
                }

                for (int a = 0; a < arrayOrden.length; a++) {
                    System.out.print("-" + datosVecino[arrayOrden[a][NOMBRE]].getNombrePiso() + "\t(" + datosVecino[arrayOrden[a][NOMBRE]].getCoeficiente() + "): " + datosVecino[arrayOrden[a][NOMBRE]].getNombrePropietario() + " (" + datosVecino[arrayOrden[a][NOMBRE]].getTelefono() + ")");

                    if (datosVecino[arrayOrden[a][NOMBRE]].getPresencia()=='N') {

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

                for (int i = 0; i < datosVecino.length - 1; i++) {
                    for (int j = i + 1; j < datosVecino.length; j++) {

                        //if(datosVecino[arrayOrden[i][COEFICIENTE]].getCeficiente().compareToIgnoreCase(datosVecino[arrayOrden[j][COEFICIENTE]].getCoeficiente())>0){
                        if (datosVecino[arrayOrden[i][COEFICIENTE]].getCoeficiente() > datosVecino[arrayOrden[j][COEFICIENTE]].getCoeficiente()) {
                            int aux = arrayOrden[i][COEFICIENTE];
                            arrayOrden[i][COEFICIENTE] = arrayOrden[j][COEFICIENTE];
                            arrayOrden[j][COEFICIENTE] = aux;

                        }
                    }
                }

                for (int a = 0; a < arrayOrden.length; a++) {
                    System.out.print("-" + datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePiso() + "\t(" + datosVecino[arrayOrden[a][COEFICIENTE]].getCoeficiente() + "): " + datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePropietario() + " (" + datosVecino[arrayOrden[a][COEFICIENTE]].getTelefono() + ")");
                    if (datosVecino[arrayOrden[a][COEFICIENTE]].getPresencia()==AUSENTE) {
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }

                break;
            //Orden por defecto
            default:

                System.out.println("\nLISTA DE PROPIETARIOS POR ORDEN NATURAL DEL PISO");
                System.out.println("------------------------------------------------\n");

                for (int a = 0; a < arrayOrden.length; a++) {
                    System.out.print("-" + datosVecino[arrayOrden[a][PISO]].getNombrePiso() + "\t(" + datosVecino[arrayOrden[a][PISO]].getCoeficiente() + "): " + datosVecino[arrayOrden[a][PISO]].getNombrePropietario() + " (" + datosVecino[arrayOrden[a][PISO]].getTelefono() + ")");
                    if (datosVecino[arrayOrden[a][PISO]].getPresencia() == AUSENTE) {
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }
                break;
        }
    }

    public static void mostrarPropietario(String identificador, int i) {
        System.out.println("\n       Detalle de datos del propietario");
        System.out.println("-----------------------------------------------");
        System.out.println(datosVecino[i].getNombrePiso());
        System.out.println("\t 1)Nombre del propietario: " + datosVecino[i].getNombrePropietario());
        System.out.println("\t 2)Teléfono: " + datosVecino[i].getTelefono());
        System.out.println("\t 3)Coeficiente: " + datosVecino[i].getCoeficiente());
        if (datosVecino[i].getTipoC() == 1) {
            System.out.println("\t 4)¿Exento de gastos tipo C?: No");
        } else if (datosVecino[i].getTipoC()== 0) {
            System.out.println("\t 4)¿Exento de gastos tipo C?: Sí");
        }

        if (datosVecino[i].getPresencia()== AUSENTE) {
            System.out.println("\t 5)¿El propietario está ausente?: Sí");
        } else if (datosVecino[i].getPresencia()==PRESENTE) {
            System.out.println("\t 5)¿El propietario está ausente?: No");
        }
        System.out.println("\t 6)Cancelar");
    }

    public static void solicitarDatosModificacion(String identificador, int posicion) {
        boolean correcto;
        int opcion = 0;
        Scanner teclado = new Scanner(System.in);
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

                //modificarCampo(identificador, opcion, nuevoNombre);
                datosVecino[posicion].setNombrePropietario(nuevoNombre);
                System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getNombrePropietario() + ")");
                mostrarPropietario(identificador, posicion);
                solicitarDatosModificacion(identificador, posicion);

                break;

            case 2:

                String nuevoTelefono = "";
                System.out.print("Por favor, introduzca el nuevo teléfono: ");
                correcto = false;

                do {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevoTelefono = teclado.nextLine();

                    } else {
                        System.out.println("Por favor, introduzca una opción válida");
                        teclado.nextLine();
                    }
                } while (!correcto);

                datosVecino[posicion].setTelefono(nuevoTelefono);
                System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getTelefono() + ")");
                mostrarPropietario(identificador, posicion);
                solicitarDatosModificacion(identificador, posicion);
                break;

            case 3:

                double nuevoCoeficiente = 0;
                System.out.print("Por favor, introduzca el nuevo coeficiente: ");

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

                datosVecino[posicion].setCoeficiente(nuevoCoeficiente);
                System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getCoeficiente() + ")");
                mostrarPropietario(identificador, posicion);
                solicitarDatosModificacion(identificador, posicion);

                break;

            case 4:
                char nuevoTipoC;
                System.out.print("¿El propietario está exento de gastos de tipo C? (S/N): ");
                correcto = false;
                preguntar = true;
                while (preguntar) {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevoTipoC = teclado.next().charAt(0);

                        if (Character.toLowerCase(nuevoTipoC) == 's') {
                            //GestorDeVecinos.modificarCampo(identificador, opcion, "0");
                            datosVecino[posicion].setTipoC(0);
                            System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getTipoC() + ")");
                            mostrarPropietario(identificador, posicion);
                            solicitarDatosModificacion(identificador, posicion);
                        } else if (Character.toLowerCase(nuevoTipoC) == 'n') {
                            //GestorDeVecinos.modificarCampo(identificador, opcion, "1");
                            datosVecino[posicion].setTipoC(1);
                            System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getTipoC() + ")");
                            mostrarPropietario(identificador, posicion);
                            solicitarDatosModificacion(identificador, posicion);
                        }

                    }

                    preguntar = false;

                }

                break;

            case 5:
                char nuevaPresencia;
                System.out.print("¿El propietario está ausente? (S/N): ");
                correcto = false;
                preguntar = true;
                while (preguntar) {

                    correcto = teclado.hasNext();
                    if (correcto) {
                        nuevaPresencia = teclado.next().charAt(0);

                        if (Character.toLowerCase(nuevaPresencia) == 's') {
                            //modificarCampo(identificador, opcion, "N");
                            datosVecino[posicion].setPresencia('N');
                            System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getPresencia() + ")");
                            mostrarPropietario(identificador, posicion);
                            solicitarDatosModificacion(identificador, posicion);
                        } else if (Character.toLowerCase(nuevaPresencia) == 'n') {
                            //modificarCampo(identificador, opcion, "S");
                            datosVecino[posicion].setPresencia('S');
                            System.out.println("\nNombre modificado correctamente." + " (" + datosVecino[posicion].getPresencia() + ")");
                            mostrarPropietario(identificador, posicion);
                            solicitarDatosModificacion(identificador, posicion);
                        }

                    }

                    preguntar = false;

                }
                break;

            case 6:
                Menu.cabeceraMenuPropietarios();
                Menu.menuPropietarios();
                break;
            default:

                System.out.println("Opción no válida. Por favor, introduzca una opción válida.");

        }

    }
}
