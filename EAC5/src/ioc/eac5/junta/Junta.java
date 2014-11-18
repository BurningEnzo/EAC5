/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.junta;

import java.util.Scanner;
import ioc.eac5.vecinos.GestorDeVecinos;

/**
 * Aquesta clase disposarà de 3 funcionalitats : Llistar junta actual , Renovar càrrecs de la junta i Substituir un càrrec.
 * @author Anais
 */
public class Junta {
    
    Scanner teclado = new Scanner(System.in);
    private static String[] cargosJunta = {"President", "Vicepresident", "Secretari"};
    private static final char PRESIDENTE = 'P';
    private static final char VICEPRESIDENTE = 'V';
    private static final char SECRETARIO = 'S';
    private static final char AUSENTE = 'N';
    private static final char VIVE = 'S';
    
    /**
     * Este metodo muestra los vecinos que tenga el valor P , V o S
     */
    public void listarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            LISTAR JUNTA ACTUAL                                           |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        
    for (int a=0;a<GestorDeVecinos.datosVecino.length;a++){
                          if(GestorDeVecinos.datosVecino[a].getCargo()==PRESIDENTE ||
                           GestorDeVecinos.datosVecino[a].getCargo() == VICEPRESIDENTE ||
                           GestorDeVecinos.datosVecino[a].getCargo() == SECRETARIO ){
                            System.out.print("-"+GestorDeVecinos.datosVecino[a].getCargo()+"\t: "+GestorDeVecinos.datosVecino[a].getNombrePropietario()+" ("+GestorDeVecinos.datosVecino[a].getTelefono()+" ("+GestorDeVecinos.datosVecino[a].getNombrePiso()+")");
                           }
                }
    }
     /**
     * Este metodo asigna los cargos teniendo en cuenta el campo N y S que nos indica si el propietario vive en el piso.
     */   
    public void renovarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             RENOVAR JUNTA ACTUAL                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");
       int a;
       int cargoActual ;
      // String cargoActual[] GestorDeVecinos.datosVecino[a]getCargo;
       for (int i=0;i< GestorDeVecinos.datosVecino.length;i++) {
       if (GestorDeVecinos.datosVecino[a].getCargo() == SECRETARIO ){
      // String cargoActual = cargo[i];
       for (int i=0;<cargoActual){
       if (GestorDeVecinos.datosVecino[a].getPresencia() == VIVE ){                     
                          }else{if (GestorDeVecinos.datosVecino[a].getPresencia() == VIVE ){                     
                          }else{
        GestorDeVecinos.datosVecino[a- 1].setCargo(PRESIDENTE);
        System.out.println("Nuevos cargos de la junta: " + GestorDeVecinos.datosVecino[a- 1].getCargo() + " Nombre: " + GestorDeVecinos.datosVecino[a- 1].getNombrePropietario() + " Piso: " + GestorDeVecinos.datosVecino[a- 1].getNombrePiso() + " ");                             
                          }
    }
       }
       }
    }
    //for (int a=0;a<GestorDeVecinos.datosVecino.length;a++){
   //  private int posicioValida(int posActual, String[][] dadesPisos){
     //   int ret=(posActual+1)%dadesPisos.length;
       // while(ret!=posActual && dadesPisos[ret][POS_PRES].charAt(0)=='N'){
         //   ret=(ret+1)%dadesPisos.length;
    //    }
    //    if(dadesPisos[ret][POS_PRES].charAt(0)=='N'){
     //       ret=-1;
      //  }
      //  return ret;
   // }
       
        /* for (int a=0;a<GestorDeVecinos.datosVecino.length;a++){
                
            System.out.print("-"+GestorDeVecinos.datosVecino[a].getNombrePiso()+"\t("+GestorDeVecinos.datosVecino[a].getCoeficiente()+"): "+GestorDeVecinos.datosVecino[a].getNombrePropietario()+" ("+GestorDeVecinos.datosVecino[a].getTelefono()+")");
                    if(GestorDeVecinos.datosVecino[a].getPresencia() == GestorDeVecinos.AUSENTE){
                       System.out.println(" -AUSENTE-");
                    } else {

    }
         }
 */   
    
     /**
     * Este metodo asigna el cargo que le indique el usuario por teclado teniendo en cuenta
     * que si el cargo que quieren subtituir es el del presidente , el vicepresidente pasa a ser el presidente , el secretario sera el
     * vicepresidente y el secretario sera el primer propietario de la lista que no viva en el piso.
     * En el caso de que tengamos que subtituir el cargo de vicepresidente , el presidente se queda como esta , el secretario pasa a ser vicepresidente
     * y el secretario sera el primer propietario de la lista que no viva en el piso.
     * En el caso de que tengamos que subtituir el cargo del secretario , los cargos presidente y vicepresidente quedan igual.
     */
    
        public void substituirJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             SUBSTITUCION JUNTA ACTUAL                                     |");
        System.out.println("-------------------------------------------------------------------------------------------------");

        System.out.println("Introduzca el cargo que quiere subtituir");
        System.out.println("[Presidente , Vicepresidente o Secretario]");
      //cargosJunta = teclado.next();

 }
  
  public static void mostrarCargos(String identificador, int i) {
        System.out.println("\n       Detalle de cargos de los propietario");
        System.out.println("-----------------------------------------------");
        System.out.println(GestorDeVecinos.datosVecino[i].getNombrePiso());
        System.out.println("\t 1)Cargo: " + GestorDeVecinos.datosVecino[i].getCargo());
        System.out.println("\t 2)Nombre propietario: " + GestorDeVecinos.datosVecino[i].getNombrePropietario());
        System.out.println("\t 3)Teléfono: " + GestorDeVecinos.datosVecino[i].getTelefono());
        System.out.println("\t 4)Piso: " + GestorDeVecinos.datosVecino[i].getNombrePiso());
        if (GestorDeVecinos.datosVecino[i].getCargo()==PRESIDENTE) {
        }
        if (GestorDeVecinos.datosVecino[i].getCargo()==VICEPRESIDENTE) {
        }
        if (GestorDeVecinos.datosVecino[i].getCargo()==SECRETARIO) {
        }

        System.out.println("Muchas gracias por usar nuestro programa.");
    }
}

        
