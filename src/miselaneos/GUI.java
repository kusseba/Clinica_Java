/*
 * Clases para saber si una ventana ya se encuentra activa.
 */
package miselaneos;

import static Recepcion.FrmSistema.jDeskTopSis;
import forms_pacientes.FrmPacient;
import forms_profecionales.FrmLocation;
import java.awt.BorderLayout;
import java.util.HashMap;

/**
 *
 * @author kusse
 */
public class GUI {

    private HashMap<Integer, FrmIntern> frmList;

    public GUI() {
        frmList = new HashMap<Integer, FrmIntern>();
    }

    public FrmLocation loadLocation(int id, boolean isView) {
        FrmLocation frm = null;
        if (frmList.containsKey(id)) {
            frm = (FrmLocation) frmList.get(id);
        } else {
            frm = new FrmLocation();
            frmList.put(id, frm);
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }

        if (isView) {
            frm._show();
        }
        return frm;
    }
    
    public FrmPacient loadClients(int id, boolean isView) {
        FrmPacient frm = null;
        if (frmList.containsKey(id)) {
            frm = (FrmPacient) frmList.get(id);
        } else {
            frm = new FrmPacient();
            frmList.put(id, frm);
            jDeskTopSis.add(frm, BorderLayout.CENTER);
        }

        if (isView) {
            frm._show();
        }
        return frm;
    }

    public void loadLocation(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
