/*
 * Esta clase fue creada para el manejo de la información relacionada a los pacientes de una
 * clinica. 
 */
package Entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author pablo
 */
public class Paciente {

    private int id;
    private String apellido;
    private String nombres;
    private int documento;
    private Calendar fechaNacim;

    public Paciente() {
        this.setId(0);
        this.setApellido("");
        this.setNombres("");
        this.setDocumento(0);
        this.setFechaNacim(null);
    }

    public Paciente(int id, String apell, String nom, int nroDoc, Calendar fech) {
        this.setId(id);
        this.setApellido(apell);
        this.setNombres(nom);
        this.setDocumento(nroDoc);
        this.setFechaNacim(fech);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public Calendar getFechaNacim() {
        return fechaNacim;
    }

    public void setFechaNacim(Calendar fechaNacim) {
        this.fechaNacim = fechaNacim;
    }

    public String toString() {
        return "[" + this.getId() + "]" + this.getApellido().trim() + " " + this.getNombres().trim();
    }

    public Object[] toObject() {

        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fNac = "";
        try{
            fNac = formato.format(getFechaNacim().getTime());
        }catch(Exception ex){}
        
        
        
        Object[] info = new Object[]{getId(),
            getApellido(),
            getNombres(),
            getDocumento(),
            fNac};

        return info;
    }

}
