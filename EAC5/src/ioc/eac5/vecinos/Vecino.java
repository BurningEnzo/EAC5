/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.vecinos;

/**
 * Clase que gestiona todos y cada uno de los datos relacionados con cada vecino
 * @author Lorenzo
 */
public class Vecino {
    
    private String identificador;
    private String nombrePiso;
    private String nombrePropietario;
    private int telefono;
    private char presencia; //N -> ausente, S -> presente
    private double coeficiente;
    private int tipoC; //0 -> exento, 1 -> no exento
    private char cargo; //Cargo que ocupa en la junta
    
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
    
    public int getTelefono(){
        return telefono;
    }
    
    public void setTelefono(int telefono){
        this.telefono=telefono;
    }
    
    public char getPresencia(){
        return presencia;
    }
    
    public void setPresencia(char presencia){
        this.presencia=presencia;
    }
    
    public double getCoeficiente(){
        return coeficiente;
    }
    
    public void setCoeficiente(double coeficiente){
        this.coeficiente=coeficiente;
    }
    
    public int getTipoC(){
        return tipoC;
    }
    
    public void setTipoC(int tipoC){
        this.tipoC=tipoC;
    }
    
    public char getCargo(){
        return cargo;
    }
    
    public void setCargo(char cargo){
        this.cargo=cargo;
    }
        
}
