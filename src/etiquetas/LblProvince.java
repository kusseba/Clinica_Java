/*
 *Clase para mostrar un texto e icono asociado
 */
package etiquetas;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author pablo
 */
public class LblProvince extends Lbl{
    
    public LblProvince(){
        setText("Provincia:");
        setIcon(iconos.getProvince(16));
    }
    
}
