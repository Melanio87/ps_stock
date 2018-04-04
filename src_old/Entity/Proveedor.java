/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Melanio
 */
public class Proveedor {
    
    Integer pvee_codigo;
    String pvee_descri;

    public Proveedor() {
    }

    public Integer getPvee_codigo() {
        return pvee_codigo;
    }

    public void setPvee_codigo(Integer pvee_codigo) {
        this.pvee_codigo = pvee_codigo;
    }

    public String getPvee_descri() {
        return pvee_descri;
    }

    public void setPvee_descri(String pvee_descri) {
        this.pvee_descri = pvee_descri;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "pvee_codigo=" + pvee_codigo + ", pvee_descri=" + pvee_descri + '}';
    }
    
    
    
}
