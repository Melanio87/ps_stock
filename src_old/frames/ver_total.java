/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Clientes;
import Entity.ItemVen;
import Entity.Venta;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WIN7
 */
public class ver_total extends javax.swing.JDialog {

    /**
     * Creates new form ver_total
     */
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar Cfecha = new GregorianCalendar();
    Coneccion coneccion;
    Connection con;
    String fecha = "";
    public Venta venta;
    public int numven, tipfac;
    private Clientes clie;

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getNumven() {
        return numven;
    }

    public void setNumven(int numven) {
        this.numven = numven;
    }

    public int getTipfac() {
        return tipfac;
    }

    public void setTipfac(int tipfac) {
        this.tipfac = tipfac;
    }

    public ver_total(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void cargar() {

        this.txTotal.setText(df.format(getVenta().getVen_total()));
        txCodcli.setText(getVenta().getVen_cliente().toString());
        consultarCliente();
        txEntrega.grabFocus();

    }

    public void consultarCliente() {
        String sql;

        sql = "select cli_codigo,cli_nombre,cli_ruc from "
                + "clientes  "
                + "  where cli_codigo =" + txCodcli.getText() + "   order by cli_codigo";

        Coneccion con = new Coneccion();
        ResultSet rs;
        Clientes cli = null;

        try {
            con.consulta(sql);
            rs = con.getRs();
            if (rs.next()) {
                txdescli.setText(rs.getString("cli_nombre"));
                txRUC.setText(rs.getString("cli_ruc"));
            }

            con.close();
        } catch (Exception e) {
            if (con != null) {
                con.close();
            }
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

        tipFac = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txEntrega = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txVuelto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRComun = new javax.swing.JRadioButton();
        jRLega = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txCodcli = new javax.swing.JTextField();
        txdescli = new javax.swing.JTextField();
        btAcepta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txRUC = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Finalizar Pago");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Total Venta:");

        txTotal.setEditable(false);
        txTotal.setBackground(new java.awt.Color(0, 102, 0));
        txTotal.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        txTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txTotal.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Efectivo:");

        txEntrega.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        txEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEntregaActionPerformed(evt);
            }
        });
        txEntrega.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txEntregaFocusGained(evt);
            }
        });
        txEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txEntregaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txEntregaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txEntregaKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Vuelto:");

        txVuelto.setEditable(false);
        txVuelto.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        txVuelto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txVuelto.setFocusable(false);
        txVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txVueltoActionPerformed(evt);
            }
        });
        txVuelto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txVueltoFocusGained(evt);
            }
        });
        txVuelto.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txVueltoInputMethodTextChanged(evt);
            }
        });
        txVuelto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txVueltoKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Comprobante");

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setForeground(new java.awt.Color(204, 255, 204));

        tipFac.add(jRComun);
        jRComun.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRComun.setSelected(true);
        jRComun.setText("Común");
        jRComun.setOpaque(false);
        jRComun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRComunKeyPressed(evt);
            }
        });

        tipFac.add(jRLega);
        jRLega.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRLega.setText("Legal");
        jRLega.setOpaque(false);
        jRLega.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRLegaItemStateChanged(evt);
            }
        });
        jRLega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRLegaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jRComun)
                .addGap(39, 39, 39)
                .addComponent(jRLega)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRComun)
                    .addComponent(jRLega))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("F4-Cliente:");

        txCodcli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txCodcli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodcliKeyPressed(evt);
            }
        });

        txdescli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txdescli.setEnabled(false);
        txdescli.setFocusable(false);

        btAcepta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAcepta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_aceptar.png"))); // NOI18N
        btAcepta.setText("Aceptar");
        btAcepta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("R.U.C.:");

        txRUC.setEditable(false);
        txRUC.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(117, 117, 117)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(105, 105, 105)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txCodcli, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txdescli)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addComponent(btAcepta)
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txRUC, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addComponent(jLabel4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)))
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txCodcli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txdescli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txRUC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btAcepta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(590, 538));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txEntregaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEntregaKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != '.')) {
            evt.consume();
        }


    }//GEN-LAST:event_txEntregaKeyTyped

    private void txVueltoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txVueltoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txVueltoFocusGained

    private void txVueltoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txVueltoKeyReleased

    }//GEN-LAST:event_txVueltoKeyReleased

    private void txVueltoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txVueltoInputMethodTextChanged

    }//GEN-LAST:event_txVueltoInputMethodTextChanged

    private void txEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEntregaKeyReleased
        try {
            if (!txEntrega.getText().isEmpty()) {
                txEntrega.setText(df.format(df.parse(txEntrega.getText())));

                double res = df.parse(txEntrega.getText()).doubleValue() - df.parse(txTotal.getText()).doubleValue();
                txVuelto.setText(df.format(res));
            }
        } catch (ParseException ex) {
            Logger.getLogger(ver_total.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txEntregaKeyReleased

    private void txEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEntregaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEntregaActionPerformed

    private void txEntregaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txEntregaFocusGained
        try {

            cargar();

            if (!txTotal.getText().isEmpty()) {
                txTotal.setText(df.format(df.parse(txTotal.getText())));
            }
        } catch (ParseException ex) {
            Logger.getLogger(ver_total.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txEntregaFocusGained

    private void jRLegaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRLegaItemStateChanged
        if (jRLega.isSelected()) {
            txCodcli.setEditable(true);
            txCodcli.requestFocus();
        }
    }//GEN-LAST:event_jRLegaItemStateChanged

    private void btAceptaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAceptaActionPerformed
        GuaVenta();
    }//GEN-LAST:event_btAceptaActionPerformed

    private void txCodcliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodcliKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            ver_Cliente vcli = new ver_Cliente(null, true);
            vcli.setVisible(true);
            clie = vcli.vClie;

            txCodcli.setText(clie.getCli_codigo().toString());
            txdescli.setText(clie.getCli_nombre().trim());
            txRUC.setText(clie.getCli_ruc());
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                if (!txCodcli.getText().isEmpty()) {
                    consultarCliente();
                } else {
                    txCodcli.setText("0");
                    txdescli.setText("Cliente ocasional");
                }
            }
        }
    }//GEN-LAST:event_txCodcliKeyPressed

    private void txEntregaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txEntregaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jRComun.grabFocus();
        }
    }//GEN-LAST:event_txEntregaKeyPressed

    private void txVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txVueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txVueltoActionPerformed

    private void jRLegaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRLegaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.jRLega.setSelected(true);
        }
    }//GEN-LAST:event_jRLegaKeyPressed

    private void jRComunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRComunKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.btAcepta.requestFocus();
        }
    }//GEN-LAST:event_jRComunKeyPressed

    private void GuaVenta() {
        int tipven;
        try {

            ResultSet rs;
            int codvent = 0;

            String Hora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            Cfecha = Calendar.getInstance();
            fecha = sdf.format(Cfecha.getTime());

            Venta ven = getVenta();
            ven.setVen_cliente(Integer.parseInt(txCodcli.getText()));

            coneccion = new Coneccion();
            con = coneccion.getCon();
            Statement stmt;

            con.setAutoCommit(false);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int numfac = 0;
            String sql;
            if (jRComun.isSelected()) {
                this.setTipfac(1);
            } else {
                this.setTipfac(2);
                sql = "select (emp_numfac3+1) as numfac,(to_char(emp_numfac1, 'FM999099')||'-'||to_char(emp_numfac2, 'FM999099')||'-'||to_char((emp_numfac3+1), 'FM9990999999')) AS des_numfac from empresa";
                rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    numfac = rs.getInt("numfac");
                    ven.setNunfac(rs.getString("des_numfac"));
                }
                stmt.executeUpdate("update empresa set emp_numfac3=" + numfac);
            }

            sql = "Insert into ventas(ven_fecha,ven_hora,ven_codven,ven_total,ven_cliente,ven_tipo,ven_numfac) values('"
                    + ven.getVen_fecha() + "','"
                    + ven.getVen_hora() + "',"
                    + ven.getVen_codven() + ","
                    + ven.getVen_total() + ","
                    + ven.getVen_cliente() + ","
                    + ven.getTipven() + ",'"
                    + ven.getNunfac() + "')";

            stmt.executeUpdate(sql);

            rs = stmt.executeQuery("SELECT last_value from ventas_ven_codigo_seq");

            if (rs.next()) {
                codvent = rs.getInt(1);
                setNumven(codvent);
            }
            ArrayList<ItemVen> lisItem = venta.getItemven();
            for (int i = 0; i < lisItem.size(); i++) {
                ItemVen itv = lisItem.get(i);
                itv.setItv_codven(codvent);
                sql = "Insert into item_ventas( itv_codven,itv_codpro,itv_canti,itv_precio) values("
                        + itv.getItv_codven() + ","
                        + itv.getItv_codpro() + ","
                        + itv.getItv_canti() + ","
                        + itv.getItv_precio()
                        + ")";

                stmt.executeUpdate(sql);

            }

            con.commit();
            this.dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar Ventas " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(ver_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ver_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ver_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ver_total.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ver_total dialog = new ver_total(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAcepta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRComun;
    private javax.swing.JRadioButton jRLega;
    private javax.swing.ButtonGroup tipFac;
    private javax.swing.JTextField txCodcli;
    private javax.swing.JTextField txEntrega;
    private javax.swing.JTextField txRUC;
    private javax.swing.JTextField txTotal;
    private javax.swing.JTextField txVuelto;
    private javax.swing.JTextField txdescli;
    // End of variables declaration//GEN-END:variables
}
