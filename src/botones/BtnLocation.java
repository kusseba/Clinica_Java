/*
 * Boton Lacalización
 */
package botones;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author kusse
 */
public class BtnLocation extends Btn{
    
    public BtnLocation() {
        setText("Localización");
        setIcon(iconos.getLocation(16));
    }
    
}
