/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ioc.eac5.derramas;

/**
 * Clase que gestiona cada uno de los datos de las derramas
 *
 * @author Uri
 */
public class Derramas {

    private double importe;
    private String descripcion;
    private String tipoDerrama;

    //Métodos para acceder y modificar los datos de Derramas
    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoDerrama() {
        return tipoDerrama;
    }

    public void setTipoDerrama(String tipoDerrama) {
        this.tipoDerrama = tipoDerrama;
    }

}
