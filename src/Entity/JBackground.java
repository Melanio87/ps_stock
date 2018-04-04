/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author HP
 */
public class JBackground extends JDesktopPane{


    protected void paintComponent(Graphics g) {
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/image/logo2_mod.jpg")); 
         try{
            Graphics2D g2D = (Graphics2D) g;
            double x = img.getWidth(null);
            double y = img.getHeight(null);
            g2D.scale(getWidth()/x, getHeight()/y);
            g2D.drawImage(img, null, this); 
         }catch(Exception e){
            System.out.println(e.getMessage());
         }//To change body of generated methods, choose Tools | Templates.
    }
    
}
