/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.gestor;

import ioc.eac5.interfaz.Salida;
import ioc.eines.Gestoria;
import ioc.eac5.interfaz.Entrada;

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

    //Identificadores del tipo de orden
    private static final int PISO = 0;
    private static final int NOMBRE = 1;
    private static final int COEFICIENTE = 2;

    //VARIABLES
    //Array con los datos de los vecinos
    public static Vecino[] datosVecino;
    //Número de pisos
    static private int numPisos;
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
    public static void modificarCampo(String identificador, int campo, String dato) {
        Entrada solicitar = new Entrada();
        //Se hace un recorrido por todos los vecinos
        for (int i = 0; i < datosVecino.length; i++) {
            //Si el identificador introducido concuerda con uno de los pisos
            if (identificador.equalsIgnoreCase(datosVecino[i].getIdentificador())) {
                //Modifica el campo según la opción elegida
                switch (campo) {
                    case 1:
                        datosVecino[i].setNombrePropietario(dato);
                        //Salida.mostrarPropietario(identificador, i);
                        System.out.println("\nNombre modificado correctamente."+" ("+datosVecino[i].getNombrePropietario()+")");
                        Salida.mostrarPropietario(identificador, i);
                        solicitar.solicitarDatosModificacion(identificador,i);
                        break;
                    case 2:
                        datosVecino[i].setTelefono(dato);
                        System.out.println("\nNombre modificado correctamente."+" ("+datosVecino[i].getTelefono()+")");
                        Salida.mostrarPropietario(identificador, i);
                        solicitar.solicitarDatosModificacion(identificador,i);
                        break;
                    case 3:
                        datosVecino[i].setCoeficiente(dato);
                        System.out.println("\nNombre modificado correctamente."+" ("+datosVecino[i].getCoeficiente()+")");
                        Salida.mostrarPropietario(identificador, i);
                        solicitar.solicitarDatosModificacion(identificador,i);
                        break;
                    case 4:
                        datosVecino[i].setTipoC(dato);
                        System.out.println("\nNombre modificado correctamente."+" ("+datosVecino[i].getTipoC()+")");
                        Salida.mostrarPropietario(identificador, i);
                        solicitar.solicitarDatosModificacion(identificador,i);
                        break;
                    case 5:
                        datosVecino[i].setPresencia(dato);
                        System.out.println("\nNombre modificado correctamente."+" ("+datosVecino[i].getPresencia()+")");
                        Salida.mostrarPropietario(identificador, i);
                        solicitar.solicitarDatosModificacion(identificador,i);
                        break;

                    default:
                        System.out.println("Opción incorrecta.");
                        break;
                }
            } //else {
            //Si el identificador no concuerda con ningún identificador del array muestra un mensaje
            //  System.out.println("El identificador " + identificador + " no pertenece a ningún piso.");
            //}
        }
    }

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
                    if (datosVecino[arrayOrden[a][PISO]].getPresencia().equalsIgnoreCase("N")) {
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
                    if (datosVecino[arrayOrden[a][NOMBRE]].getPresencia().equalsIgnoreCase("N")) {
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
                        if (Double.parseDouble(datosVecino[arrayOrden[i][COEFICIENTE]].getCoeficiente()) > Double.parseDouble(datosVecino[arrayOrden[j][COEFICIENTE]].getCoeficiente())) {
                            int aux = arrayOrden[i][COEFICIENTE];
                            arrayOrden[i][COEFICIENTE] = arrayOrden[j][COEFICIENTE];
                            arrayOrden[j][COEFICIENTE] = aux;

                        }
                    }
                }

                for (int a = 0; a < arrayOrden.length; a++) {
                    System.out.print("-" + datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePiso() + "\t(" + datosVecino[arrayOrden[a][COEFICIENTE]].getCoeficiente() + "): " + datosVecino[arrayOrden[a][COEFICIENTE]].getNombrePropietario() + " (" + datosVecino[arrayOrden[a][COEFICIENTE]].getTelefono() + ")");
                    if (datosVecino[arrayOrden[a][COEFICIENTE]].getPresencia().equalsIgnoreCase("N")) {
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
                    if (datosVecino[arrayOrden[a][PISO]].getPresencia().equalsIgnoreCase("N")) {
                        System.out.println(" -AUSENTE-");
                    } else {
                        System.out.println();
                    }
                }
                break;
        }
    }

}
