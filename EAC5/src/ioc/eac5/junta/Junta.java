/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.junta;

//import java.util.Scanner;
import ioc.eac5.vecinos.GestorDeVecinos;




/**
 * Aquesta clase disposarà de 3 funcionalitats : Llistar junta actual , Renovar càrrecs de la junta i Substituir un càrrec.
 * @author Anais
 */
public class Junta {
    
    //Scanner teclado = new Scanner(System.in);

    private static final char PRESIDENTE = 'P';
    private static final char VICEPRESIDENTE = 'V';
    private static final char SECRETARIO = 'S';
    
    /**
     * Este metodo importa los datos de los propietarios y muestra los que tenga el valor P , V o S
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
                            }else{
                               System.out.println("Fallo!!");
                           }
                }
    }

    //coeficiente=datosVecino[i].getCoeficiente()
      //      for (int i=0;j<datosVecino.lenght;i++){datosVecino[i]getcoeficiente();
     /**
     * Este metodo importa los datos de los propietarios y asigna los cargos teniendo en cuenta el campo N y S que nos indica
     * si el propietario vive en el piso.
    //coeficiente=datosVecino[i].getCoeficiente()
      //      for (int i=0;j<datosVecino.lenght;i++){datosVecino[i]getcoeficiente();
     /**
     * Este metodo importa los datos de los propietarios y asigna los cargos teniendo en cuenta el campo N y S que nos indica
     * si el propietario vive en el piso.
    //coeficiente=datosVecino[i].getCoeficiente()
      //      for (int i=0;j<datosVecino.lenght;i++){datosVecino[i]getcoeficiente();
     /**
     * Este metodo importa los datos de los propietarios y asigna los cargos teniendo en cuenta el campo N y S que nos indica
     * si el propietario vive en el piso.
    //coeficiente=datosVecino[i].getCoeficiente()
      //      for (int i=0;j<datosVecino.lenght;i++){datosVecino[i]getcoeficiente();
     /**
     * Este metodo importa los datos de los propietarios y asigna los cargos teniendo en cuenta el campo N y S que nos indica
     * si el propietario vive en el piso.
     */
    
     
    public void renovarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             RENOVAR JUNTA ACTUAL                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        

     //   int[] posSortejades={-1,-1,-1};
       // posSelec = posSelec-1;
         for (int a=0;a<GestorDeVecinos.datosVecino.length;a++){
           // posSelec = posicioValida(posSelec, dadesPisos);
            // posSortejades[i]=posSelec;      
            System.out.print("-"+GestorDeVecinos.datosVecino[a].getNombrePiso()+"\t("+GestorDeVecinos.datosVecino[a].getCoeficiente()+"): "+GestorDeVecinos.datosVecino[a].getNombrePropietario()+" ("+GestorDeVecinos.datosVecino[a].getTelefono()+")");
                    if(GestorDeVecinos.datosVecino[a].getPresencia() == GestorDeVecinos.AUSENTE){
                       System.out.println(" -AUSENTE-");
                    } else {

       
    }
         }
    }
    
  //  int[] posSortejades={-1,-1,-1};
    //    posSelec = posSelec-1;
      //  for(int i=0; i<3; i++){
        //    posSelec = posicioValida(posSelec, dadesPisos);
          //  posSortejades[i]=posSelec;
    //    }
        
        //
//return posSortejades;
 //   }
    
     /**
     * Este metodo importa los datos de los propietarios y asigna el cargo que le indique el usuario por teclado teniendo en cuenta
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

//        //cargo = teclado.next();

//        cargo = teclado.next();


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


