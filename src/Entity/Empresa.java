/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Melanio
 */
public class Empresa {
  Integer emp_codigo;
  String emp_nombre;
  String emp_descri;
  String emp_direc;
  String emp_tele;
  String emp_ruc;
  Integer emp_timbrado;
  Date emp_facvalidez;
  Integer emp_numfac1;
  Integer emp_numfac2;
  Integer emp_numfac3;
  Double emp_utilidad;
  Double emp_descuem;
  Integer emp_cantick;
  Integer emp_cantickleg;
  Integer emp_stock_min;
  Date emp_expire;
  String emp_dirDB;
  String emp_dirBK;
  Date emp_bkdate;
  String emp_dirImg;

    public Empresa() {
    }

    public Integer getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(Integer emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    public String getEmp_nombre() {
        return emp_nombre;
    }

    public void setEmp_nombre(String emp_nombre) {
        this.emp_nombre = emp_nombre;
    }

    public String getEmp_descri() {
        return emp_descri;
    }

    public void setEmp_descri(String emp_descri) {
        this.emp_descri = emp_descri;
    }

    public String getEmp_direc() {
        return emp_direc;
    }

    public void setEmp_direc(String emp_direc) {
        this.emp_direc = emp_direc;
    }

    public String getEmp_tele() {
        return emp_tele;
    }

    public void setEmp_tele(String emp_tele) {
        this.emp_tele = emp_tele;
    }

    public String getEmp_ruc() {
        return emp_ruc;
    }

    public void setEmp_ruc(String emp_ruc) {
        this.emp_ruc = emp_ruc;
    }

    public Integer getEmp_timbrado() {
        return emp_timbrado;
    }

    public void setEmp_timbrado(Integer emp_timbrado) {
        this.emp_timbrado = emp_timbrado;
    }

    public Date getEmp_facvalidez() {
        return emp_facvalidez;
    }

    public void setEmp_facvalidez(Date emp_facvalidez) {
        this.emp_facvalidez = emp_facvalidez;
    }

    public Integer getEmp_numfac1() {
        return emp_numfac1;
    }

    public void setEmp_numfac1(Integer emp_numfac1) {
        this.emp_numfac1 = emp_numfac1;
    }

    public Integer getEmp_numfac2() {
        return emp_numfac2;
    }

    public void setEmp_numfac2(Integer emp_numfac2) {
        this.emp_numfac2 = emp_numfac2;
    }

    public Integer getEmp_numfac3() {
        return emp_numfac3;
    }

    public void setEmp_numfac3(Integer emp_numfac3) {
        this.emp_numfac3 = emp_numfac3;
    }

    public Double getEmp_utilidad() {
        return emp_utilidad;
    }

    public void setEmp_utilidad(Double emp_utilidad) {
        this.emp_utilidad = emp_utilidad;
    }

    public Double getEmp_descuem() {
        return emp_descuem;
    }

    public void setEmp_descuem(Double emp_descuem) {
        this.emp_descuem = emp_descuem;
    }

    public Integer getEmp_cantick() {
        return emp_cantick;
    }

    public void setEmp_cantick(Integer emp_cantick) {
        this.emp_cantick = emp_cantick;
    }

    public Integer getEmp_cantickleg() {
        return emp_cantickleg;
    }

    public void setEmp_cantickleg(Integer emp_cantickleg) {
        this.emp_cantickleg = emp_cantickleg;
    }

    public Integer getEmp_stock_min() {
        return emp_stock_min;
    }

    public void setEmp_stock_min(Integer emp_stock_min) {
        this.emp_stock_min = emp_stock_min;
    }

    public Date getEmp_expire() {
        return emp_expire;
    }

    public void setEmp_expire(Date emp_expire) {
        this.emp_expire = emp_expire;
    }

    @Override
    public String toString() {
        return "Empresa{" + "emp_codigo=" + emp_codigo + ", emp_nombre=" + emp_nombre + ", emp_descri=" + emp_descri + ", emp_direc=" + emp_direc + ", emp_tele=" + emp_tele + ", emp_ruc=" + emp_ruc + ", emp_timbrado=" + emp_timbrado + ", emp_facvalidez=" + emp_facvalidez + ", emp_numfac1=" + emp_numfac1 + ", emp_numfac2=" + emp_numfac2 + ", emp_numfac3=" + emp_numfac3 + '}';
    }

    public String getEmp_dirDB() {
        return emp_dirDB;
    }

    public void setEmp_dirDB(String emp_dirDB) {
        this.emp_dirDB = emp_dirDB;
    }

    public String getEmp_dirBK() {
        return emp_dirBK;
    }

    public void setEmp_dirBK(String emp_dirBK) {
        this.emp_dirBK = emp_dirBK;
    }

    public Date getEmp_bkdate() {
        return emp_bkdate;
    }

    public void setEmp_bkdate(Date emp_bkdate) {
        this.emp_bkdate = emp_bkdate;
    }

    public String getEmp_dirImg() {
        return emp_dirImg;
    }

    public void setEmp_dirImg(String emp_dirImg) {
        this.emp_dirImg = emp_dirImg;
    }
  
    
}
