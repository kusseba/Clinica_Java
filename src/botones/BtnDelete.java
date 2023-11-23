/*
 * Boton Borrar
 */
package botones;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author kusse
 */
public class BtnDelete extends Btn{
    
    public BtnDelete() {
        setText("Eliminar");
        setIcon(iconos.getDelete(16));
    }
    
}
