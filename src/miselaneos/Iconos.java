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
public class Iconos {

    static final String SEP = System.getProperty("file.separator"); // constante del separador de directorios
    static final String PATHING = new File("").getAbsolutePath() + SEP; //canstante que contiene la dirección donde se ejecuta el proyecto.

    public ImageIcon getSizeIcon(int x, int y, ImageIcon icono) {
        ImageIcon ImagenIconizable = icono;
        Image imgTrabajar = ImagenIconizable.getImage();
        Image imageIconizable = imgTrabajar.getScaledInstance(x, y, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(imageIconizable);
    }

    /**
     * Método que recibe el tamaño del ancho y el alto que se va a usar en la
     * imagen.
     *
     * @param size
     * @return
     */
    public ImageIcon getSys(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/sys.png"));
        return getSizeIcon(size, size, icono);
    }

    ;

    public ImageIcon getAdd(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/add.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getEdit(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/edit.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getDelete(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/delete.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getList(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/list.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getFilter(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/filter.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getUser(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/user.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getExit(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/exit.png"));
        return getSizeIcon(size, size, icono);
    }

    ;
    
    public ImageIcon getClient(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/client.png"));
        return getSizeIcon(size, size, icono);
    }
;

    public Icon getProvince(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/province.png"));
        return getSizeIcon(size, size, icono);
    }

    public Icon getLocation(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/location.png"));
        return getSizeIcon(size, size, icono);
    }

    public Icon getKey(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/key.png"));
        return getSizeIcon(size, size, icono);
    }

    public Icon getCheck(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/check.png"));
        return getSizeIcon(size, size, icono);
    }

    public Icon getClock(int size) {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/clock.png"));
        return getSizeIcon(size, size, icono);
    }

    public Icon getUpdate(int size) {
         ImageIcon icono = new ImageIcon(getClass().getResource("/Iconos/update.png"));
        return getSizeIcon(size, size, icono);
    }


}
