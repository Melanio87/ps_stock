/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Connection.resizeImg;
import Entity.Categoria;
import Entity.Proveedor;
import Entity.Sector;
import Entity.Usuario;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Melanio
 */
public class ver_usuarios extends javax.swing.JDialog {

    /**
     * Creates new form ver_Produ
     */
    String ruta, nombre, foto;
    Image img = null;
    BufferedImage bimage;
    byte[] imageInByte = null;
    ArrayList<Usuario> aUsu = new ArrayList<Usuario>();
    DefaultTableModel modelo;
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    resizeImg rImg = new resizeImg();

    ArrayList<Proveedor> Lprovee = new ArrayList<Proveedor>();
    ArrayList<Categoria> Lcate = new ArrayList<Categoria>();
    ArrayList<Sector> Lsect = new ArrayList<Sector>();

    Usuario vUsu = new Usuario();

    TableRowSorter<TableModel> sorter;

    public ver_usuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txtBusqueda.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        filtrar();
                    }
                });

        TableModel();
        consultar();
    }

    private void filtrar() {
        RowFilter<TableModel, Object> rf = null;
        int indiceColumnaTabla = 1;
        try {
            rf = RowFilter.regexFilter(txtBusqueda.getText(), indiceColumnaTabla);
        } catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
    }

    public void consultar() {
        String sql = "select acc_id,acc_nombre,acc_user,acc_pass,acc_nivel from acceso order by acc_id";

        Coneccion con = new Coneccion();
        ResultSet rs = null;
        Usuario u = null;
        aUsu.clear();

        try {
            con.consulta(sql);
            rs = con.getRs();
            while (rs.next()) {
                u = new Usuario();
                u.setAcc_id(rs.getInt("acc_id"));
                u.setAcc_nombre(rs.getString("acc_nombre").trim().toUpperCase());
                u.setAcc_pass(rs.getString("acc_pass"));
                u.setAcc_user(rs.getString("acc_user").trim());
                u.setAcc_nivel(rs.getInt("acc_nivel"));
                aUsu.add(u);
            }

            if (aUsu.size() > 0) {
                CargarTabla();
            }

            con.close();
        } catch (Exception e) {
            if (con != null) {
                con.close();
            }
        }
    }

    public void CargarTabla() {
        modelo.setRowCount(0);
        this.TablaProductos.setModel(modelo);
        for (int i = 0; i < aUsu.size(); i++) {
            Usuario u = aUsu.get(i);
            System.out.print(u.toString());
            Object[] usu = new Object[modelo.getColumnCount()];
            usu[0] = u.getAcc_id();
            usu[1] = u.getAcc_nombre();
            usu[2] = u.getAcc_user();
            usu[3] = u.getAcc_pass();
            if (u.getAcc_nivel() == 1) {
                usu[4] = "ADMINISTRADOR";
            } else {
                usu[4] = "OPERADOR";
            }
            modelo.addRow(usu);
        }

        sorter = new TableRowSorter<TableModel>(modelo);
        TablaProductos.setRowSorter(sorter);
        TablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void Editar() {

        int filasele = TablaProductos.getSelectedRow();

        int xx = Integer.parseInt(TablaProductos.getValueAt(filasele, 0).toString());

        for (int i = 0; i < aUsu.size(); i++) {
            vUsu = aUsu.get(i);
            if (vUsu.getAcc_id() == xx) {
                //System.out.println("Codigo seleccionado "+pro.toString());
                break;
            }
        }

        this.dispose();
    }

    public void TableModel() {
        modelo = (DefaultTableModel) TablaProductos.getModel();
        modelo.setRowCount(0);
        this.TablaProductos.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        proCodigoLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ver Producto");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Usuario", "Contraseña", "Nivel"
            }
        ));
        TablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosMouseClicked(evt);
            }
        });
        TablaProductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TablaProductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 670, 230));

        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtBusquedaPropertyChange(evt);
            }
        });
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 11, 490, 30));

        proCodigoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proCodigoLabel.setText("Filtrar:");
        getContentPane().add(proCodigoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 30));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 291, 73, -1));

        setSize(new java.awt.Dimension(709, 365));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosMouseClicked
        Editar();

    }//GEN-LAST:event_TablaProductosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaProductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TablaProductosKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Editar();
        }
    }//GEN-LAST:event_TablaProductosKeyPressed

    private void txtBusquedaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtBusquedaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaPropertyChange

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ver_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ver_usuarios dialog = new ver_usuarios(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductos;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel proCodigoLabel;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
