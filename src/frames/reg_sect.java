/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Sector;
import Entity.LetraMayuscula;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
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
public class reg_sect extends javax.swing.JInternalFrame {

    /**
     * Creates new form reg_categ
     */
    ArrayList<Sector> aSect = new ArrayList<>();
    DefaultTableModel modelo;
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    TableRowSorter<TableModel> sorter;

    Calendar cal = new GregorianCalendar();
    public reg_sect() {
        initComponents();
         txtBusqueda.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        filtrar();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        filtrar();
                    }
                });
        TableModel();
    }
    
    private void TableModel() {
        modelo = (DefaultTableModel) jtSect.getModel();
        modelo.setRowCount(0);
        this.jtSect.setModel(modelo);
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

    private void consultar() {
        String sql = "Select sec_codigo,sec_descri from sector order by sec_codigo";

        Coneccion con = new Coneccion();
        ResultSet rs;
        Sector sec;
        aSect.clear();
        modelo.setNumRows(0);
        try {
            con.consulta(sql);
            rs = con.getRs();
            while (rs.next()) {
                sec = new Sector();
                sec.setSec_codigo(rs.getInt("sec_codigo"));
                sec.setSec_descri(rs.getString("sec_descri"));
                aSect.add(sec);
            }
            if (aSect.size() > 0) {
                CargarTabla();
            }
            con.close();
        } catch (SQLException e) {
            if (con.getCon() != null) {
                con.close();
            }
        }

    }

    public void CargarTabla() {
        modelo.setNumRows(0);
        this.jtSect.setModel(modelo);
        for (Sector s: aSect) {
            Object[] sec = new Object[modelo.getColumnCount()];
            sec[0] = s.getSec_codigo();
            sec[1] = s.getSec_descri();
            modelo.addRow(sec);
        }
        sorter = new TableRowSorter<TableModel>(modelo);
        jtSect.setRowSorter(sorter);
        jtSect.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void Editar() {

        int filasele = jtSect.getSelectedRow();

        int xx = Integer.parseInt(jtSect.getValueAt(filasele, 0).toString());
        Sector sec = new Sector();
        for (Sector aSec : aSect) {
            sec = aSec;
            if (sec.getSec_codigo() == xx) {
                //System.out.println("Codigo seleccionado "+pro.toString());
                break;
            }
        }
        txCodSect.setText(sec.getSec_codigo().toString());
        txDesSec.setText(sec.getSec_descri());

    }

    private void Guardar() {
        String sql;
        PreparedStatement pst;
        Coneccion con = new Coneccion();
        try {
            if (txCodSect.getText().isEmpty()) {
                sql = "INSERT INTO sector(sec_descri) values(?)";
            } else {
                sql = "UPDATE sector set sec_descri=? where sec_codigo=" + txCodSect.getText();
            }
            pst = con.getCon().prepareCall(sql);
            pst.setString(1, txDesSec.getText().trim());
            int res = pst.executeUpdate();
            if (res == 1) {
                System.out.println("update finalizado");
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito!");
                txtBusqueda.grabFocus();
            }
            con.close();
        } catch (SQLException | HeadlessException e) {

        }
    }
    
    private void Limpiar(){
        txCodSect.setText("");
        txDesSec.setText("");
        txDesSec.grabFocus();
    }
    
    private void eliminar(){
        String sql;
        Coneccion con = new Coneccion();
        try {
            sql = "delete from sector where sec_codigo="+txCodSect.getText();
            int res = con.update(sql);
            if (res == 1) {
                System.out.println("Regístro eliminado");
                JOptionPane.showMessageDialog(null, "Dato eliminado!");
                txtBusqueda.grabFocus();
            }
            con.close();
        } catch (HeadlessException e) {

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbEliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSect = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        proCodigoLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txCodSect = new javax.swing.JTextField();
        txDesSec = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();

        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_delete.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
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

        jtSect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Descripción"
            }
        ));
        jtSect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtSectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtSect);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Código:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripción:");

        txtBusqueda.setDocument(new LetraMayuscula());
        txtBusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBusquedaFocusGained(evt);
            }
        });
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });

        proCodigoLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        proCodigoLabel.setText("Filtrar:");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/lupa64.png"))); // NOI18N

        txCodSect.setEnabled(false);
        txCodSect.setFocusable(false);

        txDesSec.setDocument(new LetraMayuscula());

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txCodSect, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(338, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDesSec))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbGuardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(34, 34, 34)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(proCodigoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusqueda)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proCodigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txCodSect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDesSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardar)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        Guardar();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void txtBusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusquedaFocusGained
       consultar();
        
    }//GEN-LAST:event_txtBusquedaFocusGained

    private void jtSectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtSectMouseClicked
       Editar();
    }//GEN-LAST:event_jtSectMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JTable jtSect;
    private javax.swing.JLabel proCodigoLabel;
    private javax.swing.JTextField txCodSect;
    private javax.swing.JTextField txDesSec;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
