/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Melanio
 */
public class Coneccion {
    String driver = "org.postgresql.Driver";
    String usuario = "postgres";
   
    
    String url = "jdbc:postgresql://localhost:5432/";
    private String dbName="ps_stock";
    private String contra = "prosys@123456";

    

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "";
    
    public Coneccion(){
        try {
            Class.forName(driver);
            con= DriverManager.getConnection((url+dbName), usuario, contra);
            stmt= con.createStatement();
            //System.out.println("Conexión exitosa");
        } catch (Exception ex) {
            System.out.println("Error " +ex.getMessage());
        }
        
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
    public void close(){
        try{
            if(con != null){
                con.close();
               // System.out.println("Conexión terminada");
            }
        }catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    
    public void consulta(String sql){
        try {
            this.rs=stmt.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Error " +ex.getMessage());
        }
    }
    
    public int  update(String sql){
        int res=0;
        try{
            res=stmt.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error " +e.getMessage());
        }
        
        return res;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
    
}
