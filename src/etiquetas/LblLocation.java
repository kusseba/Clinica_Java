/*
 *Clase para mostrar un texto e icono asociado
 */
package etiquetas;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author pablo
 */
public class LblLocation extends Lbl{
    
    public LblLocation(){
        setText("Localidad:");
        setIcon(iconos.getLocation(16));
    }
    
}
