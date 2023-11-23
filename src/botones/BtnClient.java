/*
 * Boton Cliente
 */
package botones;

import static Recepcion.FrmSistema.iconos;

/**
 *
 * @author kusse
 */
public class BtnClient extends Btn{
    
    public BtnClient() {
        setText("Cliente");
        setIcon(iconos.getClient(16));
    }
    
}
