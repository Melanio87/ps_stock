/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Connection.Coneccion;

/**
 *
 * @author mac
 */
public class Mesa {
    
    private int m_codigo;
    private String m_descri;
    private boolean m_estado;

    public Mesa() {
    }

    public int getM_codigo() {
        return m_codigo;
    }

    public void setM_codigo(int m_codigo) {
        this.m_codigo = m_codigo;
    }

    public String getM_descri() {
        return m_descri;
    }

    public void setM_descri(String m_descri) {
        this.m_descri = m_descri;
    }

    public boolean isM_estado() {
        return m_estado;
    }

    public void setM_estado(boolean m_estado) {
        this.m_estado = m_estado;
    }
    
}
