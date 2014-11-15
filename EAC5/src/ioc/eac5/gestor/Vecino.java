/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.gestor;

/**
 * Clase que gestiona todos y cada uno de los datos relacionados con cada vecino
 * @author Lorenzo
 */
public class Vecino {
    
    private String identificador;
    private String nombrePiso;
    private String nombrePropietario;
    private String telefono;
    private String presencia; //N -> ausente, S -> presente
    private String coeficiente;
    private String tipoC; //0 -> exento, 1 -> no exento
    private String cargo; //Cargo que ocupa en la junta
    
    //Métodos para acceder y modificar los datos de Vecino
    public String getIdentificador(){
        return identificador;
    }
    
    public void setIdentificador(String identificador){
        this.identificador=identificador;
    }
    
    public String getNombrePiso(){
        return nombrePiso;
    }
    
    public void setNombrePiso(String nombrePiso){
        this.nombrePiso=nombrePiso;
    }
    
    public String getNombrePropietario(){
        return nombrePropietario;
    }
    
    public void setNombrePropietario(String nombrePropietario){
        this.nombrePropietario=nombrePropietario;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    
    public String getPresencia(){
        return presencia;
    }
    
    public void setPresencia(String presencia){
        this.presencia=presencia;
    }
    
    public String getCoeficiente(){
        return coeficiente;
    }
    
    public void setCoeficiente(String coeficiente){
        this.coeficiente=coeficiente;
    }
    
    public String getTipoC(){
        return tipoC;
    }
    
    public void setTipoC(String tipoC){
        this.tipoC=tipoC;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
        
}
