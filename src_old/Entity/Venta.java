/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Melanio
 */
public class Venta {

    Integer ven_codigo;
    Date ven_fecha;
    String ven_hora;
    Integer ven_codven;
    double ven_total;
    Integer ven_cliente;
    String ven_obs;
    Integer tipven;
    ArrayList<ItemVen> itemven;
    String nunfac;

    public Venta() {
    }

    public Integer getVen_codigo() {
        return ven_codigo;
    }

    public void setVen_codigo(Integer ven_codigo) {
        this.ven_codigo = ven_codigo;
    }

    public Date getVen_fecha() {
        return ven_fecha;
    }

    public void setVen_fecha(Date ven_fecha) {
        this.ven_fecha = ven_fecha;
    }

    public String getVen_hora() {
        return ven_hora;
    }

    public void setVen_hora(String ven_hora) {
        this.ven_hora = ven_hora;
    }

    public Integer getVen_codven() {
        return ven_codven;
    }

    public void setVen_codven(Integer ven_codven) {
        this.ven_codven = ven_codven;
    }

    public Double getVen_total() {
        return ven_total;
    }

    public void setVen_total(Double ven_total) {
        this.ven_total = ven_total;
    }

    public Integer getVen_cliente() {
        return ven_cliente;
    }

    public void setVen_cliente(Integer ven_cliente) {
        this.ven_cliente = ven_cliente;
    }

    public String getVen_obs() {
        return ven_obs;
    }

    public void setVen_obs(String ven_obs) {
        this.ven_obs = ven_obs;
    }

    public Integer getTipven() {
        return tipven;
    }

    public void setTipven(Integer tipven) {
        this.tipven = tipven;
    }

    public ArrayList<ItemVen> getItemven() {
        return itemven;
    }

    public void setItemven(ArrayList<ItemVen> itemven) {
        this.itemven = itemven;
    }

    public String getNunfac() {
        return nunfac;
    }

    public void setNunfac(String nunfac) {
        this.nunfac = nunfac;
    }
    

}
