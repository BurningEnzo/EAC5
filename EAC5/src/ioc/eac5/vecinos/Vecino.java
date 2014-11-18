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
    private String telefono;
    private char presencia; //N -> ausente, S -> presente
    private double coeficiente;
    private int tipoC; //0 -> exento, 1 -> no exento
    private char cargo; //Cargo que ocupa en la junta
    private double gastosTipoA; //Total del dinero a pagar del tipo A
    private double gastosTipoB; //Total del dinero a pagar del tipo B
    private double gastosTipoC; //Total del dinero a pagar del tipo C
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
    
    public double getGastosTipoA(){
        return gastosTipoA;
    }
    
    public void setGastosTipoA(double gastosTipoA){
        this.gastosTipoA = gastosTipoA;
    }
    public double getGastosTipoB(){
        return gastosTipoB;
    }
    
    public void setGastosTipoB(double gastosTipoB){
        this.gastosTipoB = gastosTipoB;
    }
    public double getGastosTipoC(){
        return gastosTipoC;
    }
    
    public void setGastosTipoC(double gastosTipoC){
        this.gastosTipoC = gastosTipoC;
    }
}
