/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author mac
 */
import Connection.Coneccion;
import java.awt.Component;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class RenderCelda extends DefaultTableCellRenderer 
{
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) 
    {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        
        
        if(value instanceof String){
           String me = (String) value;
            Coneccion con = new Coneccion();
            Mesa mesa = new Mesa();
            
            try {
                con.setRs(con.getStmt().executeQuery("Select * from mesa where  m_descri ='"+me+"'"));
                if(con.getRs().next()){
                   if(con.getRs().getBoolean("m_estatus")){
                        this.setBackground(Color.GREEN);
                        this.setHorizontalAlignment(CENTER);
                   }else{
                        cell.setBackground(Color.red);
                        this.setHorizontalAlignment(CENTER);
                   }
                }
                con.close();
            } catch (SQLException ex) {
                con.close();
                Logger.getLogger(RenderCelda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return cell;
    }
}