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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Melanio
 */
public class reg_empresa extends javax.swing.JInternalFrame {

    /**
     * Creates new form reg_empresa
     */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = new GregorianCalendar();

    public reg_empresa() {
        initComponents();
        
    }

    private void consulta() {
        try {
            Coneccion con = new Coneccion();
            String sql = "Select emp_codigo,emp_nombre,emp_descri,emp_direc,emp_tele,"
                    + "emp_ruc,emp_timbrado,emp_facvalidez,emp_numfac1,emp_numfac2,"
                    + "emp_numfac3 from empresa";
            con.consulta(sql);
            ResultSet rs;
            rs = con.getRs();
            if (rs.next()) {
                Empresa emp = new Empresa();
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
                Cargar(emp);
            }
            con.close();
        } catch (SQLException e) {

        }
    }
    
    private void Cargar(Empresa emp){
            emp_codigo.setText(emp.getEmp_codigo().toString());
            emp_nombre.setText(emp.getEmp_nombre());
            emp_descrip.setText(emp.getEmp_descri());
            emp_direc.setText(emp.getEmp_direc());
            emp_tele.setText(emp.getEmp_tele());
            emp_ruc.setText(emp.getEmp_ruc());
            emp_timbra.setText(emp.getEmp_timbrado().toString());
            emp_fecval.setDate(emp.getEmp_facvalidez());
            emp_nf1.setText(emp.getEmp_numfac1().toString());
            emp_nf2.setText(emp.getEmp_numfac2().toString());
            emp_nf3.setText(emp.getEmp_numfac3().toString()); 
    }

    private void Guardar() {
        String sql;
        PreparedStatement pst;
        Coneccion con = new Coneccion();
        try {

            if (emp_codigo.getText().isEmpty()) {
                sql = "INSERT INTO empresa(emp_nombre,emp_descri,emp_direc,emp_tele,"
                        + "emp_ruc,emp_timbrado,emp_facvalidez,emp_numfac1,emp_numfac2,"
                        + "emp_numfac3) VALUES(?,?,?,?,?,?,?,?,?,?)";
            } else {
                sql = "UPDATE empresa SET emp_nombre=?,emp_descri=?,emp_direc=?,emp_tele=?,"
                        + "emp_ruc=?,emp_timbrado=?,emp_facvalidez=?,emp_numfac1=?,emp_numfac2=?,"
                        + "emp_numfac3=?";
            }
            pst = con.getCon().prepareCall(sql);
            pst.setString(1, emp_nombre.getText().trim());
            pst.setString(2, emp_descrip.getText().trim());
            pst.setString(3, emp_direc.getText().trim());
            pst.setString(4, emp_tele.getText().trim());
            pst.setString(5, emp_ruc.getText().trim());
            pst.setInt(6, Integer.parseInt(emp_timbra.getText()));

            if (emp_fecval.getDate() != null) {
                pst.setDate(7, new java.sql.Date(emp_fecval.getDate().getTime()));
            } else {
                pst.setDate(7, new java.sql.Date(cal.getTimeInMillis()));
            }

            pst.setInt(8, Integer.parseInt(emp_nf1.getText()));
            pst.setInt(9, Integer.parseInt(emp_nf2.getText()));
            pst.setInt(10, Integer.parseInt(emp_nf3.getText()));
            
            int res = pst.executeUpdate();
            if (res == 1) {
                System.out.println("update finalizado");
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito!");
            }
            
            
        } catch (SQLException | NumberFormatException e) {

        }
    }
    
    private void Limpiar(){
           
            emp_nombre.setText("");
            emp_descrip.setText("");
            emp_direc.setText("");
            emp_tele.setText("");
            emp_ruc.setText("");
            emp_timbra.setText("");
            emp_fecval.setDate(null);
            emp_nf1.setText("");
            emp_nf2.setText("");
            emp_nf3.setText(""); 
            emp_nombre.grabFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emp_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emp_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emp_descrip = new javax.swing.JTextField();
        emp_direc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emp_tele = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emp_ruc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emp_timbra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        emp_fecval = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        emp_nf1 = new javax.swing.JTextField();
        emp_nf2 = new javax.swing.JTextField();
        emp_nf3 = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Datos de Empresa");

        jLabel1.setText("Código:");

        emp_codigo.setEditable(false);
        emp_codigo.setFocusable(false);
        emp_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emp_codigoFocusGained(evt);
            }
        });

        jLabel2.setText("Nombre:");

        emp_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emp_nombreFocusGained(evt);
            }
        });

        jLabel3.setText("Descripción:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Teléfono:");

        jLabel6.setText("R.U.C:");

        jLabel7.setText("Timbrado:");

        jLabel8.setText("Fecha de Validez:");

        jLabel9.setText("N° Factura:");

        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_delete.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_save.png"))); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_cancel.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emp_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(emp_nombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_descrip))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_direc))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emp_ruc))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emp_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emp_timbra))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(emp_fecval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_nf1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_nf2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emp_nf3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emp_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emp_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emp_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emp_direc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emp_tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(emp_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emp_timbra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(emp_fecval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(emp_nf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emp_nf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emp_nf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardar)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
       Guardar();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emp_codigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_codigoFocusGained
        
    }//GEN-LAST:event_emp_codigoFocusGained

    private void emp_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_nombreFocusGained
       consulta();
    }//GEN-LAST:event_emp_nombreFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emp_codigo;
    private javax.swing.JTextField emp_descrip;
    private javax.swing.JTextField emp_direc;
    private com.toedter.calendar.JDateChooser emp_fecval;
    private javax.swing.JTextField emp_nf1;
    private javax.swing.JTextField emp_nf2;
    private javax.swing.JTextField emp_nf3;
    private javax.swing.JTextField emp_nombre;
    private javax.swing.JTextField emp_ruc;
    private javax.swing.JTextField emp_tele;
    private javax.swing.JTextField emp_timbra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    // End of variables declaration//GEN-END:variables
}
