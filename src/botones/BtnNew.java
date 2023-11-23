/*
 * Boton nuevo
 */
package botones;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author kusse
 */
public class BtnNew extends Btn{
    
    public BtnNew() {
        setText("Nuevo");
        setIcon(iconos.getAdd(16));
    }
    
}
