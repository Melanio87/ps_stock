/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Entity.Productos;
import Connection.Coneccion;
import Connection.resizeImg;
import Entity.Categoria;
import Entity.LetraMayuscula;
import Entity.Proveedor;
import Entity.Sector;
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
public class ver_Produ extends javax.swing.JDialog {

    /**
     * Creates new form ver_Produ
     */
    
     String ruta, nombre, foto;
    Image img = null;
    BufferedImage bimage;
    byte[] imageInByte = null;
    ArrayList<Productos> aPro = new ArrayList<Productos>();
    DefaultTableModel modelo;
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    resizeImg rImg = new resizeImg();

    ArrayList<Proveedor> Lprovee = new ArrayList<Proveedor>();
    ArrayList<Categoria> Lcate = new ArrayList<Categoria>();
    ArrayList<Sector> Lsect = new ArrayList<Sector>();
    
    Productos vPro = new Productos();
    
    TableRowSorter<TableModel> sorter;
    public ver_Produ(java.awt.Frame parent, boolean modal) {
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
        String sql = "Select pro_codigo,pro_descri,pro_pre1,pro_pre2,pro_pre3,pro_cant,"
                + "pro_provee,pro_cate,pro_sect,pro_canmin,pro_venci,pro_cbarra"
                + " From productos order by pro_codigo";

        Coneccion con = new Coneccion();
        ResultSet rs = null;
        Productos p = null;
        aPro.clear();

        try {
            con.consulta(sql);
            rs = con.getRs();
            while (rs.next()) {
                p = new Productos();
                p.setProCodigo(rs.getInt("pro_codigo"));
                p.setProDescri(rs.getString("pro_descri"));
                p.setProPre1(rs.getBigDecimal("pro_pre1"));
                p.setProPre2(rs.getBigDecimal("pro_pre2"));
                p.setProPre3(rs.getBigDecimal("pro_pre3"));
                p.setProCant(rs.getBigDecimal("pro_cant"));
                p.setProProvee(rs.getInt("pro_provee"));
                p.setProCate(rs.getInt("pro_cate"));
                p.setProSect(rs.getInt("pro_sect"));
                p.setProCanmin(rs.getBigDecimal("pro_canmin"));
                p.setProVenci(rs.getDate("pro_venci"));
                p.setProCbarra(rs.getString("pro_cbarra"));
                aPro.add(p);
            }

            if (aPro.size() > 0) {
                CargarTabla();
            }
            con.close();
        } catch (Exception e) {
            if (con != null) {
                con.close();
            }
        }
    }
    
    public void CargarTabla(){
        modelo.setRowCount(0);
                this.TablaProductos.setModel(modelo);
                for (int i = 0; i < aPro.size(); i++) {
                   Productos p = aPro.get(i);
                    //System.out.print(p.toString());
                    Object[] pro = new Object[modelo.getColumnCount()];
                    pro[0] = p.getProCodigo();
                    pro[1] = p.getProDescri();    
                    pro[2] = p.getProPre2();
                    pro[3] = p.getProPre3();
                    pro[4] = p.getProCant();
                    modelo.addRow(pro);
                }
                
                sorter = new TableRowSorter<TableModel>(modelo);
        TablaProductos.setRowSorter(sorter);
        TablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void Editar() {
       
       
        int filasele = TablaProductos.getSelectedRow();
        
        int xx= Integer.parseInt(TablaProductos.getValueAt(filasele, 0).toString());
      
        for(int i=0;i<aPro.size();i++){
             vPro = aPro.get(i);
             if(vPro.getProCodigo()== xx){
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

        TablaProductos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Precio May.", "Precio Min.", "Cantidad"
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
        if (TablaProductos.getColumnModel().getColumnCount() > 0) {
            TablaProductos.getColumnModel().getColumn(0).setResizable(false);
            TablaProductos.getColumnModel().getColumn(1).setMinWidth(200);
            TablaProductos.getColumnModel().getColumn(4).setMinWidth(20);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 710, 260));

        txtBusqueda.setDocument(new LetraMayuscula());
        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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
        getContentPane().add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 11, 660, 30));

        proCodigoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proCodigoLabel.setText("Filtrar:");
        getContentPane().add(proCodigoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 30));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 73, -1));

        setSize(new java.awt.Dimension(747, 382));
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
            java.util.logging.Logger.getLogger(ver_Produ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_Produ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_Produ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_Produ.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ver_Produ dialog = new ver_Produ(new javax.swing.JFrame(), true);
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
