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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txFecF = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", ' ');
        txFecI = new com.toedter.calendar.JDateChooser("dd/MM/yyyy","##/##/####", ' ');
        jCBdeta = new javax.swing.JCheckBox();
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
        jPanel1.add(jCBdeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

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
                        .addGap(120, 120, 120)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            if(jCBdeta.isSelected()){
                imprimir("rep_ventas_deta.jasper"); 
            }else{
                imprimir("rep_ventas.jasper"); 
            }
           
        } catch (ParseException ex) {
            Logger.getLogger(inf_venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

        private void imprimir(String report) throws ParseException {
        JasperReport reporte;
        JasperPrint reporte_view;
        try {
             Coneccion con = new Coneccion();
             
            URL archi;
            archi = this.getClass().getResource("/reports/"+report);
            reporte = (JasperReport) JRLoader.loadObject(archi);
           Map<String, Object> param = new HashMap<>();
            Calendar cal  = new GregorianCalendar();
            cal.setTime(txFecI.getDate());
            String fechaI = new SimpleDateFormat("d/M/y").format(txFecI.getDate());
            String fechaF = new SimpleDateFormat("d/M/y").format(txFecF.getDate());
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
            System.out.println(fechaI);
             System.out.println("cal "+cal.getTime());
            
            param.put("fecI",  txFecI.getDate());
            param.put("fecF", txFecF.getDate());


            reporte_view = JasperFillManager.fillReport(reporte, param, con.getCon());
            JasperViewer.viewReport(reporte_view, false);
            //JasperPrintManager.printReport(reporte_view,false);
            /*JasperPrintManager print1 = new JasperPrintManager();
            print1.printReport(reporte_view,false);*/
            
            //terminamos la conexion a la base de datos
            con.close();
        } catch (JRException E) {
            
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCBdeta;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser txFecF;
    private com.toedter.calendar.JDateChooser txFecI;
    // End of variables declaration//GEN-END:variables
}