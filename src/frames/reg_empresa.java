/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import Connection.Coneccion;
import Entity.Empresa;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Melanio
 */
public class reg_empresa extends javax.swing.JInternalFrame {

    /**
     * Creates new form reg_empresa
     */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Calendar cal = new GregorianCalendar();
     DecimalFormat df= new DecimalFormat("#.00");

    public reg_empresa() {
        initComponents();
        consulta();
        
    }

    private void consulta() {
        try {
            Coneccion con = new Coneccion();
            String sql = "Select emp_codigo,emp_nombre,emp_descri,emp_direc,emp_tele,"
                    + "emp_ruc,emp_timbrado,emp_facvalidez,emp_numfac1,emp_numfac2,"
                    + "emp_numfac3,emp_utilidad,emp_desmay,emp_cantick,emp_cantickleg,emp_stock_min,emp_expire,emp_dirdb,emp_dirbk,emp_dirimg from empresa";
            con.consulta(sql);
            ResultSet rs;
            rs = con.getRs();
            if (rs.next()) {
                Empresa emp = new Empresa();
                emp.setEmp_codigo(rs.getInt("emp_codigo"));
                emp.setEmp_nombre(rs.getString("emp_nombre"));
                emp.setEmp_descri(rs.getString("emp_descri"));
                emp.setEmp_direc(rs.getString("emp_direc"));
                emp.setEmp_tele(rs.getString("emp_tele"));
                emp.setEmp_ruc(rs.getString("emp_ruc"));
                emp.setEmp_timbrado(rs.getInt("emp_timbrado"));
                emp.setEmp_facvalidez(rs.getDate("emp_facvalidez"));
                emp.setEmp_numfac1(rs.getInt("emp_numfac1"));
                emp.setEmp_numfac2(rs.getInt("emp_numfac2"));
                emp.setEmp_numfac3(rs.getInt("emp_numfac3"));
                emp.setEmp_utilidad(rs.getDouble("emp_utilidad"));
                emp.setEmp_descuem(rs.getDouble("emp_desmay"));
                emp.setEmp_cantick(rs.getInt("emp_cantick"));
                emp.setEmp_cantickleg(rs.getInt("emp_cantickleg"));
                emp.setEmp_stock_min(rs.getInt("emp_stock_min"));
                emp.setEmp_expire(rs.getDate("emp_expire"));
                emp.setEmp_dirDB(rs.getString("emp_dirdb"));
                emp.setEmp_dirBK(rs.getString("emp_dirbk"));
                emp.setEmp_dirImg(rs.getString("emp_dirimg"));
                
                Cargar(emp);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("frames.reg_empresa.consulta()"+e.getMessage());
        }
    }
    
    private void Cargar(Empresa emp){

            emp_codigo.setText(emp.getEmp_codigo().toString());
            emp_nombre.setText(emp.getEmp_nombre());
            emp_descrip.setText(emp.getEmp_descri());
            emp_direc.setText(emp.getEmp_direc());
            emp_tele.setText(emp.getEmp_tele());
            emp_ruc.setText(emp.getEmp_ruc());
            emp_timbra.setText(emp.getEmp_timbrado().toString());
            emp_fecval.setDate(emp.getEmp_facvalidez());
            emp_nf1.setText(emp.getEmp_numfac1().toString());
            emp_nf2.setText(emp.getEmp_numfac2().toString());
            emp_nf3.setText(emp.getEmp_numfac3().toString()); 
            emp_utilidad.setText(emp.getEmp_utilidad().toString());
            emp_descueMay.setText(df.format(emp.getEmp_descuem()));
            emp_canTick.setText(emp.getEmp_cantick()!= null?emp.getEmp_cantick().toString():"0");
            emp_canTickLeg.setText(emp.getEmp_cantickleg() != null?emp.getEmp_cantickleg().toString():"0");
            cbStkMin.setState(emp.getEmp_stock_min() == null?false: emp.getEmp_stock_min() == 1?true:false);
            jLDirBK.setText(emp.getEmp_dirBK()==null?"...":emp.getEmp_dirBK());
            jLDirDB.setText(emp.getEmp_dirDB()==null?"...":emp.getEmp_dirDB());
            jLDirImg.setText(emp.getEmp_dirImg() == null?"...":emp.getEmp_dirImg());
            
    }

    private void Guardar() {
        String sql;
        PreparedStatement pst;
        Coneccion con = new Coneccion();
        try {

            if (emp_codigo.getText().isEmpty()) {
                sql = "INSERT INTO empresa(emp_nombre,emp_descri,emp_direc,emp_tele,"
                        + "emp_ruc,emp_timbrado,emp_facvalidez,emp_numfac1,emp_numfac2,"
                        + "emp_numfac3,emp_utilidad,emp_desmay,emp_cantick,emp_cantickleg,emp_stock_min,emp_dirdb,emp_dirbk,emp_dirimg) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            } else {
                sql = "UPDATE empresa SET emp_nombre=?,emp_descri=?,emp_direc=?,emp_tele=?,"
                        + "emp_ruc=?,emp_timbrado=?,emp_facvalidez=?,emp_numfac1=?,emp_numfac2=?,"
                        + "emp_numfac3=?,emp_utilidad=?,emp_desmay=?,emp_cantick=?,emp_cantickleg=?,"
                        + "emp_stock_min=?,emp_dirdb=?,emp_dirbk=?,emp_dirimg= ?";
            }
            pst = con.getCon().prepareCall(sql);
            pst.setString(1, emp_nombre.getText().trim());
            pst.setString(2, emp_descrip.getText().trim());
            pst.setString(3, emp_direc.getText().trim());
            pst.setString(4, emp_tele.getText().trim());
            pst.setString(5, emp_ruc.getText().trim());
            pst.setInt(6, Integer.parseInt(emp_timbra.getText()));
           
            if (emp_fecval.getDate() != null) {
                System.out.println(emp_fecval.getDate().getTime());
                pst.setDate(7, new java.sql.Date(emp_fecval.getDate().getTime()));
            } else {
                pst.setDate(7, new java.sql.Date(cal.getTimeInMillis()));
            }

            pst.setInt(8, Integer.parseInt(emp_nf1.getText()));
            pst.setInt(9, Integer.parseInt(emp_nf2.getText()));
            pst.setInt(10, Integer.parseInt(emp_nf3.getText()));
            pst.setDouble(11, df.parse(emp_utilidad.getText()).doubleValue());
            pst.setDouble(12, df.parse(emp_descueMay.getText()).doubleValue());
            pst.setInt(13, Integer.parseInt(emp_canTick.getText()));
            pst.setInt(14, Integer.parseInt(emp_canTickLeg.getText()));
            pst.setInt(15, cbStkMin.getState()==true?1:0);
            pst.setString(16, jLDirDB.getText());
            pst.setString(17, jLDirBK.getText());
            pst.setString(18, jLDirImg.getText());
            

            
            int res = pst.executeUpdate();
            if (res == 1) {
                System.out.println("update finalizado");
                JOptionPane.showMessageDialog(null, "Datos insertados con éxito!");
            }
            
            
            con.close();
        } catch (SQLException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error !"+e.getMessage());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Error !"+ex.getMessage());
        }
    }
    
    private void Limpiar(){
            emp_nombre.setText("");
            emp_descrip.setText("");
            emp_direc.setText("");
            emp_tele.setText("");
            emp_ruc.setText("");
            emp_timbra.setText("");
            emp_fecval.setDate(null);
            emp_nf1.setText("");
            emp_nf2.setText("");
            emp_nf3.setText(""); 
            emp_nombre.grabFocus();
            emp_descueMay.setText("");
            emp_utilidad.setText("");
            emp_canTick.setText("");
            emp_canTickLeg.setText("");
            cbStkMin.setState(false);
            jLDirBK.setText("");
            jLDirDB.setText("");
            jLDirImg.setText("");
            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        emp_codigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emp_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emp_descrip = new javax.swing.JTextField();
        emp_direc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        emp_tele = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emp_ruc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emp_timbra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emp_nf1 = new javax.swing.JTextField();
        emp_nf2 = new javax.swing.JTextField();
        emp_nf3 = new javax.swing.JTextField();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        emp_utilidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emp_descueMay = new javax.swing.JTextField();
        emp_fecval = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        emp_canTick = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        emp_canTickLeg = new javax.swing.JTextField();
        cbStkMin = new java.awt.Checkbox();
        jLabel14 = new javax.swing.JLabel();
        jBdirBK = new javax.swing.JButton();
        jLDirDB = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jBdirDB = new javax.swing.JButton();
        jLDirBK = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jBdirImg = new javax.swing.JButton();
        jLDirImg = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registrar Datos de Empresa");

        jLabel1.setText("Código:");

        emp_codigo.setEditable(false);
        emp_codigo.setFocusable(false);
        emp_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emp_codigoFocusGained(evt);
            }
        });
        emp_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_codigoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        emp_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emp_nombreFocusGained(evt);
            }
        });

        jLabel3.setText("Descripción:");

        jLabel4.setText("Dirección:");

        jLabel5.setText("Teléfono:");

        jLabel6.setText("R.U.C:");

        jLabel7.setText("Timbrado:");

        emp_timbra.setText("0");

        jLabel8.setText("Fecha de Validez:");

        jLabel9.setText("N° Factura:");

        emp_nf1.setText("0");

        emp_nf2.setText("0");

        emp_nf3.setText("0");

        jbEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_delete.png"))); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

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

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ico_salir.png"))); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("% de Utilidad:");

        emp_utilidad.setText("0");
        emp_utilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emp_utilidadKeyTyped(evt);
            }
        });

        jLabel11.setText("% Descuento / Mayorista:");

        emp_descueMay.setText("0");
        emp_descueMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_descueMayActionPerformed(evt);
            }
        });
        emp_descueMay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emp_descueMayKeyTyped(evt);
            }
        });

        emp_fecval.setDateFormatString("dd/MM/yyyy");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel12.setText("Cant. Imp. Factura:");

        emp_canTick.setText("0");
        emp_canTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emp_canTickActionPerformed(evt);
            }
        });

        jLabel13.setText("Cant. Imp. Factura Lega:");

        emp_canTickLeg.setText("0");

        cbStkMin.setLabel("Stock mínimo");

        jLabel14.setText("Directorio de base de datos:");

        jBdirBK.setText("...");
        jBdirBK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdirBKActionPerformed(evt);
            }
        });

        jLDirDB.setText("...");

        jLabel16.setText("Directorio de la copia de seguridad:");

        jBdirDB.setText("...");
        jBdirDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdirDBActionPerformed(evt);
            }
        });

        jLDirBK.setText("...");

        jLabel17.setText("Directorio de las imagenes:");

        jBdirImg.setText("...");
        jBdirImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBdirImgActionPerformed(evt);
            }
        });

        jLDirImg.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(emp_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(emp_nombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emp_descrip))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emp_direc))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_ruc))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_timbra))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emp_utilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emp_nf1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(emp_nf2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_nf3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(emp_fecval, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emp_descueMay, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDirDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLDirBK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(emp_canTick, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(emp_canTickLeg, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbStkMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBdirDB))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBdirBK))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBdirImg)))
                                .addGap(0, 138, Short.MAX_VALUE))
                            .addComponent(jLDirImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(emp_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(emp_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emp_descrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emp_direc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(emp_tele, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(emp_ruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(emp_timbra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(emp_fecval, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(emp_nf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emp_nf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emp_nf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(emp_utilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(emp_descueMay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(emp_canTick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(emp_canTickLeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbStkMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jBdirDB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLDirDB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jBdirBK))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDirBK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jBdirImg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLDirImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbCancelar)
                    .addComponent(jbGuardar)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        Limpiar();
        consulta();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
       Guardar();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emp_codigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_codigoFocusGained
        
    }//GEN-LAST:event_emp_codigoFocusGained

    private void emp_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emp_nombreFocusGained
       
    }//GEN-LAST:event_emp_nombreFocusGained

    private void emp_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_codigoActionPerformed

    private void emp_utilidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_utilidadKeyTyped
       char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && emp_utilidad.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_emp_utilidadKeyTyped

    private void emp_descueMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_descueMayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_descueMayActionPerformed

    private void emp_descueMayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emp_descueMayKeyTyped
       char c = evt.getKeyChar();
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)
                && (c != '.')) {
            evt.consume();
        }
        if (c == '.' && emp_descueMay.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_emp_descueMayKeyTyped

    private void emp_canTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emp_canTickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emp_canTickActionPerformed

    private void jBdirDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdirDBActionPerformed
        
         JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen", "jpg"));
        //fileChooser.setCurrentDirectory(new java.io.File("e:/imagenes_tmp/"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //obtiene ruta y nombre del archivo
            jLDirDB.setText(fileChooser.getSelectedFile().getParent());
        }
    }//GEN-LAST:event_jBdirDBActionPerformed

    private void jBdirBKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdirBKActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen", "jpg"));
        //fileChooser.setCurrentDirectory(new java.io.File("e:/imagenes_tmp/"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //obtiene ruta y nombre del archivo
            jLDirBK.setText(fileChooser.getSelectedFile().getParent() );
        }
    }//GEN-LAST:event_jBdirBKActionPerformed

    private void jBdirImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBdirImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setFileFilter(new FileNameExtensionFilter("Archivo de Imagen", "jpg"));
        //fileChooser.setCurrentDirectory(new java.io.File("e:/imagenes_tmp/"));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //obtiene ruta y nombre del archivo
            jLDirImg.setText(fileChooser.getSelectedFile().getParent() );
        }
    }//GEN-LAST:event_jBdirImgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox cbStkMin;
    private javax.swing.JTextField emp_canTick;
    private javax.swing.JTextField emp_canTickLeg;
    private javax.swing.JTextField emp_codigo;
    private javax.swing.JTextField emp_descrip;
    private javax.swing.JTextField emp_descueMay;
    private javax.swing.JTextField emp_direc;
    private com.toedter.calendar.JDateChooser emp_fecval;
    private javax.swing.JTextField emp_nf1;
    private javax.swing.JTextField emp_nf2;
    private javax.swing.JTextField emp_nf3;
    private javax.swing.JTextField emp_nombre;
    private javax.swing.JTextField emp_ruc;
    private javax.swing.JTextField emp_tele;
    private javax.swing.JTextField emp_timbra;
    private javax.swing.JTextField emp_utilidad;
    private javax.swing.JButton jBdirBK;
    private javax.swing.JButton jBdirDB;
    private javax.swing.JButton jBdirImg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLDirBK;
    private javax.swing.JLabel jLDirDB;
    private javax.swing.JLabel jLDirImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    // End of variables declaration//GEN-END:variables
}
