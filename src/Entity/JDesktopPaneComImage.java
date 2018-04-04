/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Melanio
 */
import java.awt.Color;
import java.awt.Graphics;    
import java.awt.Image;    
import java.awt.Toolkit;    
import javax.swing.JDesktopPane;    
    
public class JDesktopPaneComImage extends JDesktopPane {    
    
   private static final long serialVersionUID = 1L;    
   Image imagem;    
    
   public JDesktopPaneComImage(String caminho) {    
      imagem = Toolkit.getDefaultToolkit().getImage(getClass().getResource(caminho)); 
       //System.out.println("JDI 1 "+imagem);
   }    
    
    @Override  
   public void paintComponent(Graphics g) {    
      super.paintComponent(g);
      //System.out.println("JDI 2 "+imagem);
      if(imagem != null)   {    
         g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);     
      }    
      
   } 
}  