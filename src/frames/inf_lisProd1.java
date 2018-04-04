/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Categoria;
import Entity.Sector;
import Entity.Proveedor;
import java.net.URL;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Melanio
 */
public class inf_lisProd1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form inf_venta
     */
    ArrayList<Entity.Proveedor> Lprovee = new ArrayList<>();
    ArrayList<Categoria> Lcate = new ArrayList<>();
    ArrayList<Sector> Lsect = new ArrayList<>();

    public inf_lisProd1() {
        initComponents();
        consultar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        gbImpre = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        rbSect = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        rbCate = new javax.swing.JRadioButton();
        cbProveedor = new javax.swing.JComboBox();
        cbCategoria = new javax.swing.JComboBox();
        cbSector = new javax.swing.JComboBox();
        rbProvee = new javax.swing.JRadioButton();
        rbVP = new javax.swing.JRadioButton();
        rpImpr = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lista de Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Lista de Productos"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 140, 130));

        buttonGroup1.add(rbSect);
        rbSect.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbSect.setText("Por Sector:");
        rbSect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSectActionPerformed(evt);
            }
        });
        jPanel1.add(rbSect, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        buttonGroup1.add(rbTodos);
        rbTodos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbTodos.setSelected(true);
        rbTodos.setText("Todos");
        jPanel1.add(rbTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        buttonGroup1.add(rbCate);
        rbCate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbCate.setText("Por Categoría:");
        jPanel1.add(rbCate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        cbProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbProveedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Proveedor" }));
        jPanel1.add(cbProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        cbCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Categoría" }));
        jPanel1.add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 160, -1));

        cbSector.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbSector.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Sector" }));
        jPanel1.add(cbSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 160, -1));

        buttonGroup1.add(rbProvee);
        rbProvee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        rbProvee.setText("Por Proveedor:");
        jPanel1.add(rbProvee, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        gbImpre.add(rbVP);
        rbVP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbVP.setSelected(true);
        rbVP.setText("Vista Previa");
        jPanel1.add(rbVP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));

        gbImpre.add(rpImpr);
        rpImpr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rpImpr.setText("Imprimir");
        jPanel1.add(rpImpr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer.png"))); // NOI18N
        jButton1.setText("Imprimir");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(rbVP.isSelected()){
                imprimir();
            }else{
                Imprimir2();
            }
            //imprimir();
        } catch (ParseException ex) {
            Logger.getLogger(inf_lisProd1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbSectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSectActionPerformed

    public void imprimir() throws ParseException {
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
            Coneccion con = new Coneccion();
            Map<String, Object> param = new HashMap<String, Object>();
            URL archi = null;
            if (rbTodos.isSelected()) {
                archi = this.getClass().getResource("/reports/rep_produc.jasper");
            } else {
                if (rbProvee.isSelected()) {
                    archi = this.getClass().getResource("/reports/rep_produc_prov.jasper");
                    Proveedor proveedor = Lprovee.get(cbProveedor.getSelectedIndex());
                    param.put("codprovee", proveedor.getPvee_codigo());
                } else {
                    if (rbCate.isSelected()) {
                        archi = this.getClass().getResource("/reports/rep_produc_cate.jasper");
                        Categoria categoria = Lcate.get(cbCategoria.getSelectedIndex());
                        param.put("codcate", categoria.getCate_codigo());
                    } else {
                        if (rbSect.isSelected()) {
                            archi = this.getClass().getResource("/reports/rep_produc_sec.jasper");
                            Sector sector = Lsect.get(cbSector.getSelectedIndex());
                            param.put("codsect", sector.getSec_codigo());
                        }
                    }
                }
            }

            reporte = (JasperReport) JRLoader.loadObject(archi);

            // param.put("fecI",  txFecI.getDate());
            //param.put("fecF", txFecF.getDate());
            reporte_view = JasperFillManager.fillReport(reporte, param, con.getCon());
            JasperViewer.viewReport(reporte_view, false);
            //terminamos la conexion a la base de datos
            con.close();
        } catch (JRException E) {
            E.printStackTrace();
        }
    }

    private void consultar() {
        String sql = "";

        Coneccion con = new Coneccion();
        ResultSet rs;

        try {

            sql = "select * from proveedor order by  pvee_codigo";
            con.consulta(sql);
            rs = con.getRs();
            Lprovee.clear();
            while (rs.next()) {
                Entity.Proveedor pr = new Entity.Proveedor();
                pr.setPvee_codigo(rs.getInt(1));
                pr.setPvee_descri(rs.getString(2));
                Lprovee.add(pr);
            }
            if (Lprovee.size() > 0) {
                cbProveedor.removeAllItems();
                for (Entity.Proveedor Lprovee1 : Lprovee) {
                    cbProveedor.addItem(Lprovee1.getPvee_descri());
                }
            }

            sql = "select * from categoria order by  cate_codigo";
            con.consulta(sql);
            rs = con.getRs();
            Lcate.clear();
            while (rs.next()) {
                Categoria ca = new Categoria();
                ca.setCate_codigo(rs.getInt(1));
                ca.setCate_descri(rs.getString(2));
                Lcate.add(ca);
            }
            if (Lcate.size() > 0) {
                cbCategoria.removeAllItems();
                for (Categoria Lcate1 : Lcate) {
                    cbCategoria.addItem(Lcate1.getCate_descri());
                }
            }

            sql = "select * from sector order by  sec_codigo";
            con.consulta(sql);
            rs = con.getRs();
            Lsect.clear();
            while (rs.next()) {
                Sector se = new Sector();
                se.setSec_codigo(rs.getInt(1));
                se.setSec_descri(rs.getString(2));
                Lsect.add(se);
            }
            if (Lsect.size() > 0) {
                cbSector.removeAllItems();
                for (Sector Lsect1 : Lsect) {
                    cbSector.addItem(Lsect1.getSec_descri());
                }
            }

            con.close();
        } catch (Exception e) {
            if (con.getCon() != null) {
                con.close();
            }
        }
    }

    public void Imprimir2() {
        /* Array para almacenar las impresoras del sistema */
        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
        if (printService.length > 0)//si existen impresoras
        {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                    "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
            if (impresora != null) //Si se selecciono una impresora
            {
                try {
                    Coneccion con = new Coneccion();
                    //esto para el JasperReport
                    JasperReport jasperReport;
                    JasperPrint jasperPrint;
                    //se carga el reporte
                    Map<String, Object> param = new HashMap<String, Object>();
                    URL archi = null;

                    if (rbTodos.isSelected()) {
                        archi = this.getClass().getResource("/reports/rep_produc.jasper");
                    } else {
                        if (rbProvee.isSelected()) {
                            archi = this.getClass().getResource("/reports/rep_produc_prov.jasper");
                            Proveedor proveedor = Lprovee.get(cbProveedor.getSelectedIndex());
                            param.put("codprovee", proveedor.getPvee_codigo());
                        } else {
                            if (rbCate.isSelected()) {
                                archi = this.getClass().getResource("/reports/rep_produc_cate.jasper");
                                Categoria categoria = Lcate.get(cbCategoria.getSelectedIndex());
                                param.put("codcate", categoria.getCate_codigo());
                            } else {
                                if (rbSect.isSelected()) {
                                    archi = this.getClass().getResource("/reports/rep_produc_sec.jasper");
                                    Sector sector = Lsect.get(cbSector.getSelectedIndex());
                                    param.put("codsect", sector.getSec_codigo());
                                }
                            }
                        }
                    }
                     jasperReport = (JasperReport) JRLoader.loadObject(archi);
                    //se procesa el archivo jasper
                    jasperPrint = JasperFillManager.fillReport(jasperReport, param, con.getCon());
                    //se manda a la impresora
                    JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                    jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                    jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                    jrprintServiceExporter.exportReport();
                    con.close();
                } catch (JRException ex) {
                    System.err.println("Error JRException: " + ex.getMessage());
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JComboBox cbProveedor;
    private javax.swing.JComboBox cbSector;
    private javax.swing.ButtonGroup gbImpre;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rbCate;
    private javax.swing.JRadioButton rbProvee;
    private javax.swing.JRadioButton rbSect;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JRadioButton rbVP;
    private javax.swing.JRadioButton rpImpr;
    // End of variables declaration//GEN-END:variables
}
