/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.junta;

//import java.util.Scanner;
import ioc.eac5.gestor.GestorDeDatos;
import ioc.eac5.gestor.Vecino;



/**
 * Aquesta clase disposarà de 3 funcionalitats : Llistar junta actual , Renovar càrrecs de la junta i Substituir un càrrec.
 * @author Anais
 */
public class Junta {
    
    //Scanner teclado = new Scanner(System.in);
    GestorDeDatos gestor = new GestorDeDatos();
    
    Vecino vecino = new Vecino();
    
    /**
     * Este metodo importa los datos de los propietarios y muestra los que tenga el valor P , V o S
     */
    public void listarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                            LISTAR JUNTA ACTUAL                                           |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        
    for (int a=0;a<gestor.datosVecino.length;a++){
                          if(gestor.datosVecino[a].getCargo().equalsIgnoreCase("P") ||
                           gestor.datosVecino[a].getCargo().equalsIgnoreCase("V")||
                           gestor.datosVecino[a].getCargo().equalsIgnoreCase("S")){
                            System.out.print("-"+gestor.datosVecino[a].getCargo()+"\t: "+gestor.datosVecino[a].getNombrePropietario()+" ("+gestor.datosVecino[a].getTelefono()+" ("+gestor.datosVecino[a].getNombrePiso()+")");
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
     */
    
     
    public void renovarJunta() {
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("|                             RENOVAR JUNTA ACTUAL                                            |");
        System.out.println("-------------------------------------------------------------------------------------------------");
        

     //   int[] posSortejades={-1,-1,-1};
       // posSelec = posSelec-1;
         for (int a=0;a<gestor.datosVecino.length;a++){
           // posSelec = posicioValida(posSelec, dadesPisos);
            // posSortejades[i]=posSelec;      
            System.out.print("-"+gestor.datosVecino[a].getNombrePiso()+"\t("+gestor.datosVecino[a].getCoeficiente()+"): "+gestor.datosVecino[a].getNombrePropietario()+" ("+gestor.datosVecino[a].getTelefono()+")");
                    if(gestor.datosVecino[a].getPresencia().equalsIgnoreCase("N")){
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
}


