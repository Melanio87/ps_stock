/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Clientes;
import Entity.Comunicador;
import Entity.ItemVen;
import Entity.Productos;
import Entity.Usuario;
import Entity.Venta;
import Entity.deucli;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.codehaus.groovy.tools.shell.util.SimpleCompletor;

/**
 *
 * @author Melanio
 */
public class reg_deucli extends javax.swing.JInternalFrame {

    /**
     * Creates new form Ventas
     */
    DefaultTableModel modelo;
    Productos pro = new Productos();
    TableRowSorter<TableModel> sorter;
    DecimalFormat df = new DecimalFormat("###,###,###.##");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Clientes clie = new Clientes();
    deucli dcl;
    ArrayList<deucli> Ldcl = new ArrayList<>();
    ArrayList<deucli> LdclN = new ArrayList<>();
    ArrayList<Venta> Lven = new ArrayList<>();
    public Usuario usu = (Usuario) Comunicador.getObjeto();

    Calendar Cfecha = new GregorianCalendar();
    String fecha = "";

    double Saldo = 0.0;
    double Entrega = 0.0;

    public reg_deucli() {
        initComponents();
        TableModel();
        usuario();

        jlDeuda.setVisible(false);
        jtxMonDeu.setVisible(false);

    }

    public void usuario() {
        if (usu.getAcc_id() != null) {
            txCodUsu.setText(usu.getAcc_id().toString());
            txDesusu.setText(usu.getAcc_nombre());
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

        bGTipos = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txCodCli = new javax.swing.JTextField();
        txDesCli = new javax.swing.JTextField();
        jlDeuda = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxMonDeu = new javax.swing.JTextField();
        txMontoDeuda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDeuda = new javax.swing.JTable();
        btCancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txTotDeu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txDescri = new javax.swing.JTextField();
        txCodUsu = new javax.swing.JTextField();
        txDesusu = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Registrar Deuda");
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_save.png"))); // NOI18N
        jButton1.setMnemonic('A');
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));

        txCodCli.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txCodCli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txCodCliFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txCodCliFocusLost(evt);
            }
        });
        txCodCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txCodCliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txCodCliKeyTyped(evt);
            }
        });
        jPanel1.add(txCodCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, -1));

        txDesCli.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txDesCli.setEnabled(false);
        jPanel1.add(txDesCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 390, -1));

        jlDeuda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDeuda.setText("Deuda Cliente:");
        jPanel1.add(jlDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Total de Deuda:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("F4-Cliente:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 20));

        jtxMonDeu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jtxMonDeu.setEnabled(false);
        jtxMonDeu.setFocusable(false);
        jPanel1.add(jtxMonDeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 140, 30));

        txMontoDeuda.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txMontoDeuda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txMontoDeudaKeyTyped(evt);
            }
        });
        jPanel1.add(txMontoDeuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 40));

        jTDeuda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Fecha", "Deuda"
            }
        ));
        jScrollPane1.setViewportView(jTDeuda);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 680, 140));

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_cancel.png"))); // NOI18N
        btCancel.setMnemonic('c');
        btCancel.setText("Cancelar");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 140, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Descripcion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 20));

        txTotDeu.setEditable(false);
        txTotDeu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(txTotDeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, 160, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Monto de la Deuda");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        txDescri.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(txDescri, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 680, 30));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 30, 720, 380);

        txCodUsu.setEnabled(false);
        getContentPane().add(txCodUsu);
        txCodUsu.setBounds(10, 0, 160, 28);

        txDesusu.setEnabled(false);
        getContentPane().add(txDesusu);
        txDesusu.setBounds(180, 0, 550, 28);

        setBounds(0, 0, 757, 485);
    }// </editor-fold>//GEN-END:initComponents

    private void txCodCliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodCliKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_F4) {
            ver_Cliente vcli = new ver_Cliente(null, true);
            vcli.setVisible(true);
            clie = vcli.vClie;

            txCodCli.setText(clie.getCli_codigo().toString());
            txDesCli.setText(clie.getCli_nombre().trim());
        } else {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            }
        }
    }//GEN-LAST:event_txCodCliKeyPressed

    private void txCodCliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txCodCliKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txCodCliKeyTyped

    private void txCodCliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCodCliFocusGained
        limpiar();
        txCodCli.selectAll();
    }//GEN-LAST:event_txCodCliFocusGained

    private void txCodCliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCodCliFocusLost
        if (!txCodCli.getText().isEmpty()) {
            consultarCliente();
        } else {
            txCodCli.setText("0");
            txDesCli.setText("Cliente ocasional");
        }
    }//GEN-LAST:event_txCodCliFocusLost

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        limpiar();
        txCodCli.setText("");
        txDesCli.setText("");
        txCodCli.grabFocus();
    }//GEN-LAST:event_btCancelActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButton1.doClick();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Calendar cal = new GregorianCalendar();
            cal = Calendar.getInstance();
            String Hora = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            deucli dc = new deucli();
            Venta v = new Venta();

            v.setVen_cliente(Integer.parseInt(txCodCli.getText()));
            v.setVen_codven(1);
            v.setVen_fecha(cal.getTime());
            v.setVen_hora(Hora);
            v.setVen_total(df.parse(txMontoDeuda.getText()).doubleValue());
            v.setVen_obs(txDescri.getText().trim());

            Coneccion coneccion = new Coneccion();
            Connection con = coneccion.getCon();
            con.setAutoCommit(false);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = null;
            int codvent = 0;

            String sql = "Insert into ventas(ven_fecha,ven_hora,ven_codven,ven_total,ven_cliente,ven_tipo,ven_obs) values('"
                    + v.getVen_fecha() + "','"
                    + v.getVen_hora() + "',"
                    + v.getVen_codven() + ","
                    + v.getVen_total() + ","
                    + v.getVen_cliente() + ","
                    + 1 + ",'"
                    + v.getVen_obs()
                    + "')";

            stmt.executeUpdate(sql);

            rs = stmt.executeQuery("SELECT last_value from ventas_ven_codigo_seq");

            if (rs.next()) {
                codvent = rs.getInt(1);
            }

            dc.setDcl_numven(codvent);
            dc.setDcl_codcli(Integer.parseInt(txCodCli.getText()));
            dc.setDcl_descli(txDesCli.getText().trim());
            dc.setDcl_fecha(cal.getTime());
            dc.setDcl_monto(df.parse(txMontoDeuda.getText()).doubleValue());
            
            

            sql = "insert into deucli(dcl_numven,dcl_monto,dcl_fecha,dcl_codcli) values("
                    + codvent + "," + v.getVen_total() + ",'" + v.getVen_fecha() + "'," + v.getVen_cliente() + ")";
            stmt.executeUpdate(sql);

            con.commit();
            con.close();
            Ldcl.add(dc);
            CargarTablaD();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txMontoDeudaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txMontoDeudaKeyTyped
        char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
    }//GEN-LAST:event_txMontoDeudaKeyTyped

    public void consultarCliente() {
        String sql = "";/*"select cli_codigo,cli_ci,cli_nombre,cli_tel,cli_direc,"
         + "cli_ruc,cli_fecnac from clientes where cli_codigo = " + txCodCli.getText() + "order by cli_codigo";*/
         sql = "select dcl_codigo,dcl_numven,cli_codigo,cli_nombre,dcl_fecha,dcl_monto as cli_deuda from clientes LEFT JOIN deucli deu ON deu.dcl_codcli = "+txCodCli.getText()+"  order by cli_codigo,dcl_fecha";

        Coneccion con = new Coneccion();
        ResultSet rs = null;

        try {
            con.consulta(sql);
            rs = con.getRs();
            while (rs.next()) {
                txDesCli.setText(rs.getString("cli_nombre"));
                dcl = new deucli();
                dcl.setDcl_codcli(rs.getInt("cli_codigo"));
                dcl.setDcl_fecha(rs.getDate("dcl_fecha"));
                dcl.setDcl_monto(rs.getDouble("cli_deuda"));
                dcl.setDcl_descli(rs.getString("cli_nombre"));
                Ldcl.add(dcl);
            }
            if (Ldcl.size() > 0) {
                CargarTablaD();
            }

            con.close();
        } catch (Exception e) {
            if (con != null) {
                con.close();
            }
        }
    }

    public void CargarTablaD() {
        double total = 0.0;
        modelo.setNumRows(0);
        this.jTDeuda.setModel(modelo);
        for (int i = 0; i < Ldcl.size(); i++) {
            deucli dc = Ldcl.get(i);
            //System.out.print(c.toString());
            Object[] deu = new Object[modelo.getColumnCount()];
            deu[0] = dc.getDcl_codcli();
            deu[1] = dc.getDcl_descli();
            deu[2] = sdf.format(dc.getDcl_fecha());
            deu[3] = df.format(dc.getDcl_monto());
            total = total + dc.getDcl_monto();

            modelo.addRow(deu);
        }

        sorter = new TableRowSorter<TableModel>(modelo);
        jTDeuda.setRowSorter(sorter);
        jTDeuda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        txTotDeu.setText(df.format(total));
    }

    public void TableModel() {
        modelo = (DefaultTableModel) jTDeuda.getModel();
        modelo.setRowCount(0);
        this.jTDeuda.setModel(modelo);
    }

    public void limpiar() {

        modelo.setRowCount(0);
        jTDeuda.setModel(modelo);

        jlDeuda.setVisible(false);
        jtxMonDeu.setVisible(false);
        
        txDesCli.setText("");
        txDescri.setText("");
        
        
        Ldcl.clear();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bGTipos;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTDeuda;
    private javax.swing.JLabel jlDeuda;
    private javax.swing.JTextField jtxMonDeu;
    private javax.swing.JTextField txCodCli;
    private javax.swing.JTextField txCodUsu;
    private javax.swing.JTextField txDesCli;
    private javax.swing.JTextField txDescri;
    private javax.swing.JTextField txDesusu;
    private javax.swing.JTextField txMontoDeuda;
    private javax.swing.JTextField txTotDeu;
    // End of variables declaration//GEN-END:variables
}