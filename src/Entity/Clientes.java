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
public class Clientes {
    
  Integer cli_codigo;
  Integer cli_ci;
  String cli_nombre;
  String cli_tel;
  String cli_direc;
  String character;
  Date cli_fecnac;
  String cli_ruc;
  Integer cli_lispre;

    public Clientes() {
    }

    public Integer getCli_codigo() {
        return cli_codigo;
    }

    public void setCli_codigo(Integer cli_codigo) {
        this.cli_codigo = cli_codigo;
    }

    public Integer getCli_ci() {
        return cli_ci;
    }

    public void setCli_ci(Integer cli_ci) {
        this.cli_ci = cli_ci;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_tel() {
        return cli_tel;
    }

    public void setCli_tel(String cli_tel) {
        this.cli_tel = cli_tel;
    }

    public String getCli_direc() {
        return cli_direc;
    }

    public void setCli_direc(String cli_direc) {
        this.cli_direc = cli_direc;
    }

    public Date getCli_fecnac() {
        return cli_fecnac;
    }

    public void setCli_fecnac(Date cli_fecnac) {
        this.cli_fecnac = cli_fecnac;
    }

    public String getCli_ruc() {
        return cli_ruc;
    }

    public void setCli_ruc(String cli_ruc) {
        this.cli_ruc = cli_ruc;
    }

    public Integer getCli_lispre() {
        return cli_lispre;
    }

    public void setCli_lispre(Integer cli_lispre) {
        this.cli_lispre = cli_lispre;
    }
    
    
    

    @Override
    public String toString() {
        return "Clietnes{" + "cli_codigo=" + cli_codigo + ", cli_ci=" + cli_ci + ", cli_nombre=" + cli_nombre + ", cli_tel=" + cli_tel + ", cli_direc=" + cli_direc + ", character=" + character + ", cli_fecnac=" + cli_fecnac + '}';
    }
  
  
    
}
