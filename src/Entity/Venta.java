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
    Double ven_efectivo;
    Double ven_vuelto;
    Double ven_descuento;
    Double ven_saldo;
    String ven_totlet;
    boolean ven_estado;
    Integer ven_mesa;
    

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

    public Double getVen_efectivo() {
        return ven_efectivo;
    }

    public void setVen_efectivo(Double ven_efectivo) {
        this.ven_efectivo = ven_efectivo;
    }

    public Double getVen_vuelto() {
        return ven_vuelto;
    }

    public void setVen_vuelto(Double ven_vuelto) {
        this.ven_vuelto = ven_vuelto;
    }

    public Double getVen_descuento() {
        return ven_descuento;
    }

    public void setVen_descuento(Double ven_descuento) {
        this.ven_descuento = ven_descuento;
    }

    public Double getVen_saldo() {
        return ven_saldo;
    }

    public void setVen_saldo(Double ven_saldo) {
        this.ven_saldo = ven_saldo;
    }

    public String getVen_totlet() {
        return ven_totlet;
    }

    public void setVen_totlet(String ven_totlet) {
        this.ven_totlet = ven_totlet;
    }

    public boolean isVen_estado() {
        return ven_estado;
    }

    public void setVen_estado(boolean ven_estado) {
        this.ven_estado = ven_estado;
    }

    public Integer getVen_mesa() {
        return ven_mesa;
    }

    public void setVen_mesa(Integer ven_mesa) {
        this.ven_mesa = ven_mesa;
    } 

}
