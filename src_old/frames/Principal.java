/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Entity.JDesktopPaneComImage;
import Entity.Location;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

/**
 *
 * @author Melanio
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Integer niv = 0;
    R_Productos r_pro;
    R_Clientes r_cli;
    inf_venta i_ven;
    inf_lisProd i_lisp;
    reg_deucli r_dcl;
    reg_usuario r_usu;
    Ventas ven;
    reg_proveedor r_prove;
    reg_empresa r_emp;
    AnularVentas a_ven;

    JDesktopPane jDPPrincipal = new JDesktopPaneComImage("/image/logo1.png");
 


    @Override
    public void setContentPane(Container contentPane) {
        super.setContentPane(contentPane); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getNiv() {
        return niv;
    }

    public void setNiv(Integer niv) {
        this.niv = niv;
        habMenu();
    }

    private void habMenu() {
        if (getNiv() == 1) {
            this.MIOperador.setVisible(true);
            this.jMI_regEmpres.setVisible(true);
        } else {
            this.MIOperador.setVisible(false);
            this.jMI_regEmpres.setVisible(false);
        }
    }

    public Principal() {
        initComponents();
        ico();
        backImg();
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMIRPro = new javax.swing.JMenuItem();
        jMIVenta = new javax.swing.JMenuItem();
        MIAnuven = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        MILisProd = new javax.swing.JMenuItem();
        MIInfVentas = new javax.swing.JMenuItem();
        jMHerramienta = new javax.swing.JMenu();
        MIOperador = new javax.swing.JMenuItem();
        MIProveedor = new javax.swing.JMenuItem();
        jMI_regEmpres = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Control de Stock");
        setExtendedState(6);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jMenu1.setMnemonic('A');
        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setText("Registrar Clientes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMIRPro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jMIRPro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMIRPro.setText("Registrar Productos");
        jMIRPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIRProActionPerformed(evt);
            }
        });
        jMenu1.add(jMIRPro);

        jMIVenta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        jMIVenta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMIVenta.setText("Ventas");
        jMIVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIVentaActionPerformed(evt);
            }
        });
        jMenu1.add(jMIVenta);

        MIAnuven.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        MIAnuven.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MIAnuven.setText("Anular Ventas");
        MIAnuven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIAnuvenActionPerformed(evt);
            }
        });
        jMenu1.add(MIAnuven);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('I');
        jMenu3.setText("Informes");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        MILisProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        MILisProd.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MILisProd.setText("Lista de Productos");
        MILisProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MILisProdActionPerformed(evt);
            }
        });
        jMenu3.add(MILisProd);

        MIInfVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK));
        MIInfVentas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MIInfVentas.setText("Informe de Ventas");
        MIInfVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIInfVentasActionPerformed(evt);
            }
        });
        jMenu3.add(MIInfVentas);

        jMenuBar1.add(jMenu3);

        jMHerramienta.setText("Herramientas");
        jMHerramienta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        MIOperador.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        MIOperador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MIOperador.setText("Reg. Usuario");
        MIOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIOperadorActionPerformed(evt);
            }
        });
        jMHerramienta.add(MIOperador);

        MIProveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        MIProveedor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        MIProveedor.setText("Reg. Proveedor");
        MIProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MIProveedorActionPerformed(evt);
            }
        });
        jMHerramienta.add(MIProveedor);

        jMI_regEmpres.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMI_regEmpres.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMI_regEmpres.setText("Reg. Empresa");
        jMI_regEmpres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMI_regEmpresActionPerformed(evt);
            }
        });
        jMHerramienta.add(jMI_regEmpres);

        jMenuBar1.add(jMHerramienta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 843, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMIRProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIRProActionPerformed

        if (r_pro != null) {
            if (!r_pro.isShowing()) {
                jDPPrincipal.add(r_pro);
                Location loc = new Location(jDPPrincipal, r_pro);
                int x = loc.getX();
                int y = loc.getY();
                r_pro.setLocation(x, y);
                r_pro.show();
            }
        } else {
            r_pro = new R_Productos();
            jDPPrincipal.add(r_pro);
            Location loc = new Location(jDPPrincipal, r_pro);
            int x = loc.getX();
            int y = loc.getY();
            r_pro.setLocation(x, y);
            r_pro.show();
        }


    }//GEN-LAST:event_jMIRProActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // backImg();
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMIVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIVentaActionPerformed
        if (ven != null) {
            if (!ven.isShowing()) {
                jDPPrincipal.add(ven);
                Location loc = new Location(jDPPrincipal, ven);
                int x = loc.getX();
                int y = loc.getY();
                ven.setLocation(x, y);
                ven.show();
            }
        } else {
            ven = new Ventas();
            jDPPrincipal.add(ven);
            Location loc = new Location(jDPPrincipal, ven);
            int x = loc.getX();
            int y = loc.getY();
            ven.setLocation(x, y);
            ven.show();
        }
    }//GEN-LAST:event_jMIVentaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (r_cli != null) {
            if (!r_cli.isShowing()) {
                jDPPrincipal.add(r_cli);
                Location loc = new Location(jDPPrincipal, r_cli);
                int x = loc.getX();
                int y = loc.getY();
                r_cli.setLocation(x, y);
                r_cli.show();
            }

        } else {
            r_cli = new R_Clientes();
            jDPPrincipal.add(r_cli);
            Location loc = new Location(jDPPrincipal, r_cli);
            int x = loc.getX();
            int y = loc.getY();
            r_cli.setLocation(x, y);
            r_cli.show();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MIInfVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIInfVentasActionPerformed
        if (i_ven != null) {
            if (!i_ven.isShowing()) {
                jDPPrincipal.add(i_ven);
                Location loc = new Location(jDPPrincipal, i_ven);
                int x = loc.getX();
                int y = loc.getY();
                i_ven.setLocation(x, y);
                
                i_ven.show();
                
            }
        } else {
            i_ven = new inf_venta();
            jDPPrincipal.add(i_ven);
            Location loc = new Location(jDPPrincipal, i_ven);
            int x = loc.getX();
            int y = loc.getY();
            i_ven.setLocation(x, y);
            i_ven.show();
        }
    }//GEN-LAST:event_MIInfVentasActionPerformed

    private void MILisProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MILisProdActionPerformed
         if (i_lisp != null) {
            if (!i_lisp.isShowing()) {
                jDPPrincipal.add(i_lisp);
                Location loc = new Location(jDPPrincipal, i_lisp);
                int x = loc.getX();
                int y = loc.getY();
                i_lisp.setLocation(x, y);
                i_lisp.show();
            }
        } else {
            i_lisp = new inf_lisProd();
            jDPPrincipal.add(i_lisp);
            Location loc = new Location(jDPPrincipal, i_lisp);
            int x = loc.getX();
            int y = loc.getY();
            i_lisp.setLocation(x, y);
            i_lisp.show();
        }
    }//GEN-LAST:event_MILisProdActionPerformed

    private void MIAnuvenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIAnuvenActionPerformed
        /*if (r_dcl != null) {
            if (!r_dcl.isShowing()) {
                jDPPrincipal.add(r_dcl);
                Location loc = new Location(jDPPrincipal, r_dcl);
                int x = loc.getX();
                int y = loc.getY();
                r_dcl.setLocation(x, y);
                r_dcl.show();
            }
        } else {
            r_dcl = new reg_deucli();
            jDPPrincipal.add(r_dcl);
            Location loc = new Location(jDPPrincipal, r_dcl);
            int x = loc.getX();
            int y = loc.getY();
            r_dcl.setLocation(x, y);
            r_dcl.show();
        }*/
        if (a_ven != null) {
            if (!a_ven.isShowing()) {
                jDPPrincipal.add(a_ven);
                Location loc = new Location(jDPPrincipal, a_ven);
                int x = loc.getX();
                int y = loc.getY();
                a_ven.setLocation(x, y);
                a_ven.show();
            }
        } else {
            a_ven = new AnularVentas();
            jDPPrincipal.add(a_ven);
            Location loc = new Location(jDPPrincipal, a_ven);
            int x = loc.getX();
            int y = loc.getY();
            a_ven.setLocation(x, y);
            a_ven.show();
        }
    }//GEN-LAST:event_MIAnuvenActionPerformed

    private void MIOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIOperadorActionPerformed
        if (r_usu != null) {
            if (!r_usu.isShowing()) {
                jDPPrincipal.add(r_usu);
                Location loc = new Location(jDPPrincipal, r_usu);
                int x = loc.getX();
                int y = loc.getY();
                r_usu.setLocation(x, y);
                r_usu.show();
            }
        } else {
            r_usu = new reg_usuario();
            jDPPrincipal.add(r_usu);
            Location loc = new Location(jDPPrincipal, r_usu);
            int x = loc.getX();
            int y = loc.getY();
            r_usu.setLocation(x, y);
            r_usu.show();
        }
    }//GEN-LAST:event_MIOperadorActionPerformed

    private void MIProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MIProveedorActionPerformed
        if (r_prove != null) {
            if (!r_prove.isShowing()) {
                jDPPrincipal.add(r_prove);
                Location loc = new Location(jDPPrincipal, r_prove);
                int x = loc.getX();
                int y = loc.getY();
                r_prove.setLocation(x, y);
                r_prove.show();
            }
        } else {
            r_prove = new reg_proveedor();
            jDPPrincipal.add(r_prove);
            Location loc = new Location(jDPPrincipal, r_prove);
            int x = loc.getX();
            int y = loc.getY();
            r_prove.setLocation(x, y);
            r_prove.show();
        }
    }//GEN-LAST:event_MIProveedorActionPerformed

    private void jMI_regEmpresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMI_regEmpresActionPerformed
        if (r_emp != null) {
            if (!r_emp.isShowing()) {
                if(jDPPrincipal.getAllFrames().length==0){
                jDPPrincipal.add(r_emp);
                Location loc = new Location(jDPPrincipal, r_emp);
                int x = loc.getX();
                int y = loc.getY();
                r_emp.setLocation(x, y);
                r_emp.show();
                System.out.println("despues del show 1");
                }
            }
        } else {
            r_emp = new reg_empresa();
            jDPPrincipal.add(r_emp);
            Location loc = new Location(jDPPrincipal, r_emp);
            int x = loc.getX();
            int y = loc.getY();
            r_emp.setLocation(x, y);
            r_emp.show();
            System.out.println("despues del show ");
        }
    }//GEN-LAST:event_jMI_regEmpresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    private void backImg() {
        //jDPPrincipal = new JDesktopPaneComImage("/image/logo1.png");
        //this.add(jDPPrincipal);
        this.setContentPane(jDPPrincipal);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MIAnuven;
    private javax.swing.JMenuItem MIInfVentas;
    private javax.swing.JMenuItem MILisProd;
    private javax.swing.JMenuItem MIOperador;
    private javax.swing.JMenuItem MIProveedor;
    private javax.swing.JMenu jMHerramienta;
    private javax.swing.JMenuItem jMIRPro;
    private javax.swing.JMenuItem jMIVenta;
    private javax.swing.JMenuItem jMI_regEmpres;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
