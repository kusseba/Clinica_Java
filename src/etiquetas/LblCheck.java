/*
 *Clase para mostrar un texto e icono asociado
 */
package etiquetas;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author pablo
 */
public class LblCheck extends Lbl{
    
    public LblCheck(){
        setText("Oblicatorio:");
        setIcon(iconos.getCheck(16));
    }
    
}
