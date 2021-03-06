/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class inf_venta extends javax.swing.JInternalFrame {

    /**
     * Creates new form inf_venta
     */
    public inf_venta() {
        initComponents();
        txFecI.setDate(new GregorianCalendar().getTime());
        txFecF.setDate(new GregorianCalendar().getTime());
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
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txFecF = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", ' ');
        txFecI = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", ' ');
        jCBdeta = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        rbAnuladas = new javax.swing.JRadioButton();
        rbNotComun = new javax.swing.JRadioButton();
        rbNotLegal = new javax.swing.JRadioButton();
        rbActivas = new javax.swing.JRadioButton();
        rbVende = new javax.swing.JRadioButton();
        rbVP = new javax.swing.JRadioButton();
        rpImpr = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informe de Ventas"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Fecha Inicial");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Fecha Final");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        txFecF.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txFecF, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, 30));

        txFecI.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel1.add(txFecI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jCBdeta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jCBdeta.setText("Detallado");
        jPanel1.add(jCBdeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(205, 205, 160));

        buttonGroup1.add(rbAnuladas);
        rbAnuladas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbAnuladas.setText("Anulados");
        rbAnuladas.setOpaque(false);

        buttonGroup1.add(rbNotComun);
        rbNotComun.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbNotComun.setText("Con Nota común");
        rbNotComun.setOpaque(false);

        buttonGroup1.add(rbNotLegal);
        rbNotLegal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbNotLegal.setText("Con Nota legal");
        rbNotLegal.setOpaque(false);
        rbNotLegal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNotLegalActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbActivas);
        rbActivas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbActivas.setSelected(true);
        rbActivas.setText("Activas");
        rbActivas.setOpaque(false);

        buttonGroup1.add(rbVende);
        rbVende.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbVende.setText("Por Vendedor/a");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbAnuladas)
                    .addComponent(rbNotComun)
                    .addComponent(rbNotLegal)
                    .addComponent(rbActivas)
                    .addComponent(rbVende))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(rbActivas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbAnuladas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNotLegal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbNotComun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbVende)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 320, 150));

        gbImpre.add(rbVP);
        rbVP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rbVP.setSelected(true);
        rbVP.setText("Vista Previa");
        jPanel1.add(rbVP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        gbImpre.add(rpImpr);
        rpImpr.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rpImpr.setText("Imprimir");
        jPanel1.add(rpImpr, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if (jCBdeta.isSelected()) {
                if (rbActivas.isSelected()) {
                    imprimir("rep_ventas_deta.jasper");
                } else {
                    if (rbAnuladas.isSelected()) {
                        imprimir("rep_ventas_deta_anu.jasper");
                    } else {
                        if (rbNotLegal.isSelected()) {
                            imprimir("rep_ventas_deta_legal.jasper");
                        } else {
                            if (rbNotComun.isSelected()) {
                                imprimir("rep_ventas_deta_com.jasper");
                            } else {
                                if (rbVende.isSelected()) {
                                    imprimir("rep_ventas_deta_vende.jasper");
                                }
                            }
                        }
                    }
                }

            } else {
                if (rbActivas.isSelected()) {
                    imprimir("rep_ventas.jasper");
                } else {
                    if (rbAnuladas.isSelected()) {
                        imprimir("rep_ventas_anu.jasper");
                    } else {
                        if (rbNotLegal.isSelected()) {
                            imprimir("rep_ventas_legal.jasper");
                        } else {
                            if (rbNotComun.isSelected()) {
                                imprimir("rep_ventas_com.jasper");
                            }else {
                                if (rbVende.isSelected()) {
                                    imprimir("rep_ventas_deta_vende.jasper");
                                }
                            }
                        }
                    }
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(inf_venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rbNotLegalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNotLegalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNotLegalActionPerformed

    private void imprimir(String report) throws ParseException {
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
            Coneccion con = new Coneccion();

            URL archi;
            archi = this.getClass().getResource("/reports/" + report);
            reporte = (JasperReport) JRLoader.loadObject(archi);
            Map<String, Object> param = new HashMap<>();
            Calendar cal = new GregorianCalendar();
            cal.setTime(txFecI.getDate());
            String fechaI = new SimpleDateFormat("d/M/y").format(txFecI.getDate());
            String fechaF = new SimpleDateFormat("d/M/y").format(txFecF.getDate());
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
            System.out.println(fechaI);
            System.out.println("cal " + cal.getTime());

            param.put("fecI", txFecI.getDate());
            param.put("fecF", txFecF.getDate());

            reporte_view = JasperFillManager.fillReport(reporte, param, con.getCon());
            if (rbVP.isSelected()) {
                JasperViewer.viewReport(reporte_view, false);
                //JasperPrintManager.printReport(reporte_view,false);
            /*JasperPrintManager print1 = new JasperPrintManager();
                 print1.printReport(reporte_view,false);*/
            } else {
                PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
                if (printService.length > 0)//si existen impresoras
                {
                    PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                            "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[0]);
                    if (impresora != null) //Si se selecciono una impresora
                    {
                        JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
                        jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, reporte_view);
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora);
                        jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                        jrprintServiceExporter.exportReport();
                    }
                    
                }
            }

            //terminamos la conexion a la base de datos
            con.close();
        } catch (JRException E) {

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup gbImpre;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCBdeta;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbActivas;
    private javax.swing.JRadioButton rbAnuladas;
    private javax.swing.JRadioButton rbNotComun;
    private javax.swing.JRadioButton rbNotLegal;
    private javax.swing.JRadioButton rbVP;
    private javax.swing.JRadioButton rbVende;
    private javax.swing.JRadioButton rpImpr;
    private com.toedter.calendar.JDateChooser txFecF;
    private com.toedter.calendar.JDateChooser txFecI;
    // End of variables declaration//GEN-END:variables
}
