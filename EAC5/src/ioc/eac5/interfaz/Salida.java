




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.interfaz;

import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.junta.Junta;


/**
 *
 * @author Uri
 */
public class Salida {

    static Entrada solicitar = new Entrada();

    Scanner teclado = new Scanner(System.in);
    Junta junta = new Junta();
    //static GestorDeDatos gestor = new GestorDeDatos();

    int opcion;

    public static void bienvenida() {

        System.out.println("Bienvenido/a al programa de gestión de la comunidad\n"
                + "\nEl programa permite gestionar los propietarios de la comunidad,\n"
                + "gestionar las derramas y los cargos de la junta");
    }

    public static void despedida() {

        System.out.println("Muchas gracias por usar nuestro programa.");
    }

    public static void menuPrincipal() {

        System.out.println("-----------------------------------------------");
        System.out.println("                Menú principal");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Gestión de propietarios");
        System.out.println("2) Gestion de derramas");
        System.out.println("3) Gestión de cargos de la junta");
        System.out.println("4) Salir del programa");
        System.out.println("-----------------------------------------------");
        System.out.print("Por favor, seleccione una opción: ");
        solicitar.opcionesMenuPrincipal();

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
        solicitar.opcionesMenuPropietarios();

    }

    public static void mostrarPropietario(String identificador, int i) {
        System.out.println("\n       Detalle de datos del propietario");
        System.out.println("-----------------------------------------------");
        System.out.println(GestorDeDatos.datosVecino[i].getNombrePiso());
        System.out.println("\t 1)Nombre del propietario: " + GestorDeDatos.datosVecino[i].getNombrePropietario());
        System.out.println("\t 2)Teléfono: " + GestorDeDatos.datosVecino[i].getTelefono());
        System.out.println("\t 3)Coeficiente: " + GestorDeDatos.datosVecino[i].getCoeficiente());
        if (GestorDeDatos.datosVecino[i].getTipoC().equalsIgnoreCase("1")) {
            System.out.println("\t 4)¿Exento de gastos tipo C?: No");
        } else if (GestorDeDatos.datosVecino[i].getTipoC().equalsIgnoreCase("0")) {
            System.out.println("\t 4)¿Exento de gastos tipo C?: Sí");
        }

        if (GestorDeDatos.datosVecino[i].getPresencia().equalsIgnoreCase("N")) {
            System.out.println("\t 5)¿El propietario está ausente?: Sí");
        } else if (GestorDeDatos.datosVecino[i].getPresencia().equalsIgnoreCase("S")) {
            System.out.println("\t 5)¿El propietario está ausente?: No");
        }
        System.out.println("\t 6)Cancelar");
    }

    public static void consultaPropietarios() {
        System.out.println("1) Ordenar por el orden natural del piso");
        System.out.println("2) Ordenar alfabéticamente por el nombre del propietario");
        System.out.println("3) Ordenar por coeficiente de propiedad");
        System.out.println("4) Volver al menú anterior");
        System.out.print("\nPor favor, seleccione una opción: ");
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
        System.out.println("4) Volver al menú anterior");
        System.out.print("Por favor, seleccione una opción:");
        solicitar.opcionesMenuDerramas();

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
        solicitar.opcionesMenuCargos();
    }
    
      public static void mostrarCargos(String identificador, int i) {
        System.out.println("\n       Detalle de cargos de los propietario");
        System.out.println("-----------------------------------------------");
        System.out.println(GestorDeDatos.datosVecino[i].getNombrePiso());
        System.out.println("\t 1)Cargo: " + GestorDeDatos.datosVecino[i].getCargo());
        System.out.println("\t 2)Nombre propietario: " + GestorDeDatos.datosVecino[i].getNombrePropietario());
        System.out.println("\t 3)Teléfono: " + GestorDeDatos.datosVecino[i].getTelefono());
        System.out.println("\t 4)Piso: " + GestorDeDatos.datosVecino[i].getNombrePiso());
       if (GestorDeDatos.datosVecino[i].getCargo().equalsIgnoreCase("P")) {
        }   if (GestorDeDatos.datosVecino[i].getCargo().equalsIgnoreCase("V")) {
        }  if (GestorDeDatos.datosVecino[i].getCargo().equalsIgnoreCase("S")) {
    }

  }
}

      

      