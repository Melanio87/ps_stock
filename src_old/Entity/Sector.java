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
public class Sector {
    
    Integer sec_codigo;
    String sec_descri;

    public Sector() {
    }

    public Integer getSec_codigo() {
        return sec_codigo;
    }

    public void setSec_codigo(Integer sec_codigo) {
        this.sec_codigo = sec_codigo;
    }

    public String getSec_descri() {
        return sec_descri;
    }

    public void setSec_descri(String sec_descri) {
        this.sec_descri = sec_descri;
    }

    @Override
    public String toString() {
        return "Sector{" + "sec_codigo=" + sec_codigo + ", sec_descri=" + sec_descri + '}';
    }
    
    
    
}
