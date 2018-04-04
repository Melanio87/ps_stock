/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Comunicador;
import Entity.Usuario;
import Entity.Util;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author LIZ
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        ico();
    }

    private void ico() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/p_s.png"));
        setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxUsuario = new javax.swing.JTextField();
        jtxContra = new javax.swing.JPasswordField();
        jbAceptar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Control de Stock");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Usuario y Contraseña"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Contraseña:");

        jtxUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxUsuarioActionPerformed(evt);
            }
        });

        jtxContra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxContraKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtxUsuario)
                    .addComponent(jtxContra, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxContra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 25, 380, -1));

        jbAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbAceptar.setMnemonic('A');
        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });
        jbAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbAceptarKeyPressed(evt);
            }
        });
        getContentPane().add(jbAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 237, -1, -1));

        jbCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbCancelar.setMnemonic('C');
        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 237, -1, -1));

        jbSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbSalir.setMnemonic('S');
        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 237, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pass.png"))); // NOI18N
        jLabel3.setText("Imagen");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, 120));

        setSize(new java.awt.Dimension(553, 318));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jtxUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxUsuarioActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        Coneccion con = new Coneccion();
        String nom = this.jtxUsuario.getText().trim();
        String cont = Util.encrypt(this.jtxContra.getText().trim());
        
        String sDateExpire= "15/06/2017";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
         

        try {
            
            Usuario usua=null;

            ResultSet rs;
            String sql;
            
            sql = "select * from acceso where acc_situ=1 and  acc_user='" + nom + "' and acc_pass='" + cont + "'";
            
             con.consulta(sql);
             rs = con.getRs();
            if (rs.next()) {
              usua = new Usuario();
              usua.setAcc_id(rs.getInt("acc_id"));
              usua.setAcc_nombre(rs.getString("acc_nombre"));
              usua.setAcc_nivel(rs.getInt("acc_nivel"));
              usua.setAcc_su(rs.getInt("acc_su"));
            }
             
            sql = "select emp_expire from empresa";
            con.consulta(sql);
            rs = con.getRs();
            if (rs.next()) {
                if (rs.getDate("emp_expire") != null) {
                    System.out.println(rs.getDate("emp_expire").getDate());
                    System.out.println(new Date().getDate());
                    int su =0;
                    if(usua != null){
                        su = usua.getAcc_su();
                    }
                    if (rs.getDate("emp_expire").before(new Date()) && su == 0) {
                        JOptionPane.showMessageDialog(this, "Tiempo de prueba Finalizado \n Comunicarse con el desarrollador\n 0973551539", "Aviso", JOptionPane.WARNING_MESSAGE);
                        this.dispose();
                    } else {
                       /* sql = "select * from acceso where acc_situ=1 and  acc_user='" + nom + "' and acc_pass='" + cont + "'";
                        //System.out.println(sql);
                        con.consulta(sql);
                        rs = con.getRs();
                        if (rs.next()) {
                           
                            usua.setAcc_id(rs.getInt("acc_id"));
                            usua.setAcc_nombre(rs.getString("acc_nombre"));
                            usua.setAcc_nivel(rs.getInt("acc_nivel"));
                            usua.setAcc_su(rs.getInt("acc_su"));*/
                        if(usua != null){
                            Comunicador.setObjeto(usua);

                            Principal pri = new Principal();
                            pri.setVisible(true);
                            pri.setNiv(usua.getAcc_nivel());
                            pri.setSu(usua.getAcc_su());

                        this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                        }
 
                       /* } else {
                            JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                        }*/
                    }
                } else {
                   /* sql = "select * from acceso where acc_situ=1 and  acc_user='" + nom + "' and acc_pass='" + cont + "'";
                    //System.out.println(sql);
                    con.consulta(sql);
                    rs = con.getRs();
                    if (rs.next()) {
                        Usuario usua = new Usuario();
                        usua.setAcc_id(rs.getInt("acc_id"));
                        usua.setAcc_nombre(rs.getString("acc_nombre"));
                        usua.setAcc_nivel(rs.getInt("acc_nivel"));*/
                   if(usua != null){
                       Comunicador.setObjeto(usua);

                        Principal pri = new Principal();
                        pri.setVisible(true);
                        pri.setNiv(usua.getAcc_nivel());
                        pri.setSu(usua.getAcc_su());

                        this.dispose();
                   }else{
                       JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                   }
                        
                    /*} else {
                        JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                    }*/
                }
            }else{
                if(usua != null){
                       Comunicador.setObjeto(usua);

                        Principal pri = new Principal();
                        pri.setVisible(true);
                        pri.setNiv(usua.getAcc_nivel());
                        pri.setSu(usua.getAcc_su());

                        this.dispose();
                   }else{
                       JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                   }
            }
                    /*if (sdf.parse(sDateExpire).before(new Date())) {
                        JOptionPane.showMessageDialog(this, "Tiempo de prueba Finalizado \n Comunicarse con el desarrollador\n 0973551539", "Aviso", JOptionPane.WARNING_MESSAGE);
                        this.dispose();
                    } else {
                    sql = "select * from acceso where acc_situ=1 and  acc_user='" + nom + "' and acc_pass='" + cont + "'";
                    //System.out.println(sql);
                    con.consulta(sql);
                    rs = con.getRs();
                    if (rs.next()) {
                        Usuario usua = new Usuario();
                        usua.setAcc_id(rs.getInt("acc_id"));
                        usua.setAcc_nombre(rs.getString("acc_nombre"));
                        usua.setAcc_nivel(rs.getInt("acc_nivel"));
                        Comunicador.setObjeto(usua);

                        Principal pri = new Principal();
                        pri.setVisible(true);
                        pri.setNiv(rs.getInt("acc_nivel"));

                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Usuario o Contraseña incorrecta", "Avisos", JOptionPane.INFORMATION_MESSAGE);
                    }
                    }*/

            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al logar " + e.getMessage());
        }

    }//GEN-LAST:event_jbAceptarActionPerformed


    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.jtxUsuario.setText("");
        this.jtxContra.setText("");
        this.jtxUsuario.grabFocus();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbAceptarKeyPressed
        this.jbAceptar.doClick();
    }//GEN-LAST:event_jbAceptarKeyPressed

    private void jtxContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxContraKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jbAceptar.doClick();
        }
    }//GEN-LAST:event_jtxContraKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JPasswordField jtxContra;
    private javax.swing.JTextField jtxUsuario;
    // End of variables declaration//GEN-END:variables
}
