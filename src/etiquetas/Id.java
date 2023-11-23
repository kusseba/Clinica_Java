/*
 *Clase para mostrar un texto e icono asociado
 */
package etiquetas;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author pablo
 */
public class Id extends Lbl{
    
    public Id(){
        setText("Id:");
        setIcon(iconos.getKey(16));
    }
    
}
