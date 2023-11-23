/*
 * Clase para trabajar con imagenes necesarias para luego tabrajar con Jbutton.
 */
package miselaneos;

import java.awt.Image;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author kusse
 */
public class Imagenes {

    static final String SEP = System.getProperty("file.separator"); // constante del separador de directorios
    static final String PATHING = new File("").getAbsolutePath() + SEP; //canstante que contiene la dirección donde se ejecuta el proyecto.

    public ImageIcon getSizeIcon(int x, int y, ImageIcon icono) {
        ImageIcon ImagenIconizable = icono;
        Image imgTrabajar = ImagenIconizable.getImage();
        Image imageIconizable = imgTrabajar.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imageIconizable);
    }

    public Image getBackGround(){
        ImageIcon icono = new ImageIcon(getClass().getResource("/img/background.jpg"));
        return icono.getImage();
    }


}
