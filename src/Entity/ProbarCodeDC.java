/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author CAJA
 */
public class ProbarCodeDC implements JRDataSource {

    public ArrayList<Productos> Lpro = new ArrayList<>();
    private int indice = -1;

    @Override
    public boolean next() throws JRException {
         return ++indice < Lpro.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        Productos pro = Lpro.get(indice);

        if ("codpro".equals(jrf.getName())) {
            valor = pro.getProCodigo();
        } else if ("despro".equals(jrf.getName())) {
            valor = pro.getProDescri();
        }
        return valor;
    }
    
    public void addListPro(ArrayList<Productos> Lpr){
        this.Lpro=Lpr;
    }

}
