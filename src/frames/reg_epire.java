/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SunsetTires
 */
public class reg_epire extends javax.swing.JInternalFrame {

    /**
     * Creates new form reg_epire
     */
    
    Empresa emp;
    public reg_epire() {
        initComponents();
        consulta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emp_fecExpire = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar fecha de expiración");

        emp_fecExpire.setDateFormatString("dd/MM/yyyy");

        jLabel14.setText("Fecha de Expiración:");

        jbGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_save.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(141, 141, 141))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(emp_fecExpire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jbGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jButton1)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(emp_fecExpire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbGuardar)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
        private void Guardar() {
        String sql;
        PreparedStatement pst;
        Coneccion con = new Coneccion();
        try {

            if (emp == null) {
                sql = "INSERT INTO empresa(emp_expire) VALUES(?)";
            } else {
                sql = "UPDATE empresa SET emp_expire=?";
            }
            pst = con.getCon().prepareCall(sql);
            
            if (emp_fecExpire.getDate() != null) {
                pst.setDate(1, new java.sql.Date(emp_fecExpire.getDate().getTime()));
            } else {
                pst.setDate(1, null);
            }
            
            int res = pst.executeUpdate();
            if (res == 1) {
                System.out.println("update finalizado");
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito!");
            }
            
            
            con.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error !"+e.getMessage());
        }
    }
        
        private void consulta() {
        try {
            Coneccion con = new Coneccion();
            String sql = "Select emp_codigo,emp_nombre,emp_descri,emp_direc,emp_tele,"
                    + "emp_ruc,emp_timbrado,emp_facvalidez,emp_numfac1,emp_numfac2,"
                    + "emp_numfac3,emp_utilidad,emp_desmay,emp_cantick,emp_cantickleg,emp_stock_min,emp_expire from empresa";
            con.consulta(sql);
            ResultSet rs;
            rs = con.getRs();
            if (rs.next()) {
                emp = new Empresa();
                emp.setEmp_codigo(rs.getInt("emp_codigo"));
                emp.setEmp_nombre(rs.getString("emp_nombre"));
                emp.setEmp_descri(rs.getString("emp_descri"));
                emp.setEmp_direc(rs.getString("emp_direc"));
                emp.setEmp_tele(rs.getString("emp_tele"));
                emp.setEmp_ruc(rs.getString("emp_ruc"));
                emp.setEmp_timbrado(rs.getInt("emp_timbrado"));
                emp.setEmp_facvalidez(rs.getDate("emp_facvalidez"));
                emp.setEmp_numfac1(rs.getInt("emp_numfac1"));
                emp.setEmp_numfac2(rs.getInt("emp_numfac2"));
                emp.setEmp_numfac3(rs.getInt("emp_numfac3"));
                emp.setEmp_utilidad(rs.getDouble("emp_utilidad"));
                emp.setEmp_descuem(rs.getDouble("emp_desmay"));
                emp.setEmp_cantick(rs.getInt("emp_cantick"));
                emp.setEmp_cantickleg(rs.getInt("emp_cantickleg"));
                emp.setEmp_stock_min(rs.getInt("emp_stock_min"));
                emp.setEmp_expire(rs.getDate("emp_expire"));
                
                emp_fecExpire.setDate(emp.getEmp_expire());
                
               
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("frames.reg_empresa.consulta()"+e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser emp_fecExpire;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JButton jbGuardar;
    // End of variables declaration//GEN-END:variables
}
