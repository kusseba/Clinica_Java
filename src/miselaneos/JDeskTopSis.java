/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miselaneos;

import static Recepcion.FrmSistema.imgs;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JDesktopPane;

/**
 *
 * @author kusse
 */
public class JDeskTopSis extends JDesktopPane {
    
    private Image backGround;
    
    public JDeskTopSis() {
        backGround = imgs.getBackGround();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backGround, 0, 0, (int) getWidth(), (int) getHeight(), null);
    }
}
