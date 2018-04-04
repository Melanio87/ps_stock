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

    @Override
    public String toString() {
        return "Empresa{" + "emp_codigo=" + emp_codigo + ", emp_nombre=" + emp_nombre + ", emp_descri=" + emp_descri + ", emp_direc=" + emp_direc + ", emp_tele=" + emp_tele + ", emp_ruc=" + emp_ruc + ", emp_timbrado=" + emp_timbrado + ", emp_facvalidez=" + emp_facvalidez + ", emp_numfac1=" + emp_numfac1 + ", emp_numfac2=" + emp_numfac2 + ", emp_numfac3=" + emp_numfac3 + '}';
    }
  
    
}
