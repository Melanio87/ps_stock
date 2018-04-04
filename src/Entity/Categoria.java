/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Melanio
 */
public class Categoria {
    Integer cate_codigo;
    String cate_descri;

    public Categoria() {
    }
    
   
    public Integer getCate_codigo() {
        return cate_codigo;
    }

    public void setCate_codigo(Integer cate_codigo) {
        this.cate_codigo = cate_codigo;
    }

    public String getCate_descri() {
        return cate_descri;
    }

    public void setCate_descri(String cate_descri) {
        this.cate_descri = cate_descri;
    }

    @Override
    public String toString() {
        return "Categoria{" + "cate_codigo=" + cate_codigo + ", cate_descri=" + cate_descri + '}';
    }

    
 
    
}
