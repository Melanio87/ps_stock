/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author HP
 */
public class con_acces {
    
    Connection con=null;
    Statement stm=null;
    ResultSet rs=null;
    
    public con_acces(){
        try {
            
             //System.out.println(driver);
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        String linea = null;

        
            // Cargamos el archivo de la ruta relativa
            // Ubicacion del bloc de texto
            archivo = new File("c:\\windows\\accesdb.txt");
            // Cargamos el objeto filereader
            fr = new FileReader(archivo);
            // creamos un buffer de lectura
            br = new BufferedReader(fr);

            String [] datos = null;

            // leemos hasta que se termine el archivo
            while ((linea = br.readLine()) != null) {
                // utilizamos el separador para los datos
                datos = linea.split(";");
            }
            
            String mdb  = datos[0];
            String user=datos[1];
            String pass = datos[0];
            //C:\\SGCDatory\\SGCDATOS.accdb;Admin
            //-------------
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            // C:\\databaseFileName.accdb" - location of your database 
           //String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "C:\\Program Files (x86)\\Att\\att2000.mdb";
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=C:\\SGCDatory\\SGCDATOS.accdb";
            // specify url, username, pasword - make sure these are valid 
            con = DriverManager.getConnection(url, "Admin", "C:\\SGCDatory\\SGCDATOS.accdb");
            stm = con.createStatement();
            System.out.println("Connection Succesfull");
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                System.out.println(ex.getMessage());
            Logger.getLogger(con_acces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    
    
    public void consulta(String sql){
        try {
            this.rs=stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(con_acces.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close(){
        try{
            con.close();
        }catch(Exception e){
           System.out.println("Error "+e.getMessage());
        }
    }
    
    
    
}
