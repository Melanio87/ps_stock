/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class Location {
    
    public int x;
    public int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public  Location(JDesktopPane jpanel,JInternalFrame iframe){
    
         x = (jpanel.getWidth()/2) - iframe.getWidth()/2;
         y = (jpanel.getHeight()/2)- iframe.getHeight()/2;
    }
    
    public Location(JDesktopPane jpanel,JLabel logo){
        x = (jpanel.getWidth()/2) - logo.getWidth()/2;
         y = (jpanel.getHeight()/2)- logo.getHeight()/2;
    }
    
    public Location(JDesktopPane jpanel,JDialog dialog){
        x = (jpanel.getWidth()/2) - dialog.getWidth()/2;
         y = (jpanel.getHeight()/2)- dialog.getHeight()/2;
    }
    
}
