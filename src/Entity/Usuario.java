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
public class Usuario {

    Integer acc_id;
    String acc_nombre;
    String acc_user;
    String acc_pass;
    Integer acc_nivel;
    Integer acc_situ;
    Integer acc_su;

    public Usuario() {
    }
    
    

    public Integer getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(Integer acc_id) {
        this.acc_id = acc_id;
    }

    public String getAcc_nombre() {
        return acc_nombre;
    }

    public void setAcc_nombre(String acc_nombre) {
        this.acc_nombre = acc_nombre;
    }

    public String getAcc_user() {
        return acc_user;
    }

    public void setAcc_user(String acc_user) {
        this.acc_user = acc_user;
    }

    public String getAcc_pass() {
        return acc_pass;
    }

    public void setAcc_pass(String acc_pass) {
        this.acc_pass = acc_pass;
    }

    public Integer getAcc_nivel() {
        return acc_nivel;
    }

    public void setAcc_nivel(Integer acc_nivel) {
        this.acc_nivel = acc_nivel;
    }

    public Integer getAcc_situ() {
        return acc_situ;
    }

    public void setAcc_situ(Integer acc_situ) {
        this.acc_situ = acc_situ;
    }

    public Integer getAcc_su() {
        return acc_su;
    }

    public void setAcc_su(Integer acc_su) {
        this.acc_su = acc_su;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "acc_id=" + acc_id + ", acc_nombre=" + acc_nombre + ", acc_user=" + acc_user + ", acc_pass=" + acc_pass + ", acc_nivel=" + acc_nivel + ", acc_situ=" + acc_situ + '}';
    }
    
    
}
