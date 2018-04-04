/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Connection.Coneccion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author mac
 */
public class Util {
    
    // Definición del tipo de algoritmo a utilizar (AES, DES, RSA)
    private final static String alg = "AES";
    // Definición del modo de cifrado a utilizar
    private final static String cI = "AES/CBC/PKCS5Padding";
    
    private final static String key = "92AE31A79F174871";
    private final static String iv = "0123456789174871";
    

    
    public static String encrypt( String cleartext){
        
            try{
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(cleartext.getBytes());
            return new String(Base64.encodeBase64(encrypted));
            }catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e){
                System.out.println("Entity.Util.encrypt()"+ e.getMessage());
                return null;
            }
    }
 

    public static String decrypt( String encrypted) {
        try{
            Cipher cipher = Cipher.getInstance(cI);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), alg);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = Base64.decodeBase64(encrypted.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
        }catch(NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e){
            System.out.println("Entity.Util.encrypt()"+ e.getMessage());
                return null;
        }
    }
    
    public static void main(String[] arg){
        try {
            System.out.println(encrypt("admin"));
            System.err.println(decrypt("olcc3kk4gZOtQh8xaFWxxQ=="));
            
            //exportDb2();
        } catch (Exception ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static boolean  exportDb2(Empresa empresa) throws IOException, InterruptedException {
        Coneccion con = new Coneccion();
        Runtime rt = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        rt = Runtime.getRuntime();
        pb = new ProcessBuilder(
                empresa.getEmp_dirDB()+"\\pg_dump.exe",
                "--host", "localhost",
                "--port", "5432",
                "--username", "postgres",
                "--no-password",
                "--format", "custom",
                "--blobs",
                "--verbose", "--file", empresa.getEmp_dirBK()+"\\psstock"+new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(new Date())+".backup", con.getDbName());
        try {
            final Map<String, String> env = pb.environment();
            env.put("PGPASSWORD", con.getContra());
            p = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }   
            r.close();
            p.waitFor();
            System.out.println(p.exitValue());
            con.close();
            return true;

    } catch (IOException | InterruptedException e) {
        System.out.println(e.getMessage());
        return true;
    }
}
   
}
