/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author CAJA
 */
public class Moneda {
    Integer mon_codigo;
    String mon_descri;
    Double mon_valor;

    public Moneda() {
    }

    public Integer getMon_codigo() {
        return mon_codigo;
    }

    public void setMon_codigo(Integer mon_codigo) {
        this.mon_codigo = mon_codigo;
    }

    public String getMon_descri() {
        return mon_descri;
    }

    public void setMon_descri(String mon_descri) {
        this.mon_descri = mon_descri;
    }

    public Double getMon_valor() {
        return mon_valor;
    }

    public void setMon_valor(Double mon_valor) {
        this.mon_valor = mon_valor;
    }
    
    
    
}
