/*
 * Esta clase fue creada para poder conectarse a una base de datos 
 * y luego poder insertar, actualizar, eliminar y consultar la información
 * de ella.
 * Esta clase se conecta y trabaja sobre una tabla de la base de datos
 * que se llama pacientes
 */
package Datos;

import Entidades.Paciente;
import com.mysql.jdbc.Statement;
import java.beans.Statement;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

/**
 *
 * @author pablo
 */
public class Pacientes {

    //Información necesaria para realizar la conexion
    static final String DRIVER = "com.mysql.jdbc.Driver"; // Nombre del driver de MySQL 
    static final String servidor = "localhost"; // Servidor donde se ejecuta el servicio de MySQL. Puede ser un nombre o un numero de IP
    static final String DB = "clinica_colegio"; // Nombre de la base de datos donde se va a conectar
    static final String puerto = "3307"; // Puerto de escucha en el servidor de base de datos
    static final String usuario = "pablo"; // Usuario que tiene acceso a la base de datos
    static final String pws = "12345678a"; // Contraseña de usuario
    static final String URL = "jdbc:mysql://" + servidor + ":" + puerto + "/" + DB + "?" + "user=" + usuario + "&password=" + pws; // Direccion que se para
                    // al driver de conexion para crear una nueva conexion
    static final String TABLA = "pacientes"; // Nombre de la tabla dentro de la base de datos
    private Connection cn; // Objeto conexion que guarda toda la informacion necesaria para conectarse con la base de datos
    
    
    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    /**
     * Metodo que devuelve verdadero si se puede crear un Objeto Connection
     * @return 
     */
    public boolean isOkConexion() {
        Connection cn = null;
        boolean isOk = false;
        try {
            Class.forName(DRIVER).newInstance(); // para saber si el driver esta y se puede cargar
            cn = DriverManager.getConnection(URL); // Genera un objeto connexion
            setCn(cn); // se setea guarda la un Objeto connexion en la clase para luego ser usado
            isOk = true; // bandera para poner en true y el metodo isOkConexion() me retorne verdadero
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return isOk;
    }

    /**
     * Metodo para deconectar la base de datos
     * @return 
     */
    public boolean isCerrarConexion() {
        boolean isOk = false;
        try {
            if (getCn() != null && !getCn().isClosed()) {
                getCn().close();
                setCn(null);
                isOk = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return isOk;
        }
    }

    /**
     * Metodo que recibe informacion de tiempo(Calendar) y retorna un String en formato de 
     * Año-Mes-Día (2023-01-01), que es compatible con el formato estandar de campos tipo fecha en MySQL
     * @param fecha
     * @return 
     */
    private String getFechaMySQL(Calendar fecha) {
        String patron1 = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patron1);

        String fechaMySQL = simpleDateFormat.format(fecha.getTime());

        return fechaMySQL;
    }

    /**
     * Metodo que recibo informacion de tiempo(Timestamp) y retorna un Objeto tipo Calendar con la 
     * misma informacion
     * @param timestamp
     * @return 
     */
    private Calendar getCalendar(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp == null ? System.currentTimeMillis() : timestamp.getTime());
        return calendar;
    }

    /**
     * Metodo que recibe como parametro un Objeto tipo Paciente y lo
     * REGISTRA en la base de datos en la tabla pacientes 
     * @param p
     * @return true=registra, false=presencia de error
     */
    public boolean isNuevo(Paciente p) {
        boolean isOk = false;
        try {
            //Creo un Objeto tipo Statament (st), que es necesario para procesar sentencias SQL
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            //Del Objeto Statement genero otro Objeto tipo ResultSet que almacena los resultados
            //de la consulta sql.
            //En este caso resultados en blanco porque en la consulta no hay registros con id=-1
            //Esto se hace para luego crear un nuevo registro en blanco
            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=-1");

            //Creo un nuevo registro en blanco para luego ir actualizando cada campo del registro
            rs.moveToInsertRow();

            //rs.updateInt("id", p.getId()); // como el campo de id es autoincremental no se hace mención
            //Actualizo los campos del nuevo registro con los datos que recibo del Objeto Persona (p)
            rs.updateString("apellido", p.getApellido());
            rs.updateString("nombres", p.getNombres());
            rs.updateInt("documento", p.getDocumento());

            //Pregunto si la información de fecha de nacimiento es null actualizo el campo de fecha con null
            //y uso el metodo updateDate, sino pasa la información de tiempo a un valor String y uso el metodo
            //updateString.
            if (p.getFechaNacim() == null) {
                rs.updateDate("fecha_nacimiento", null);
            } else {
                rs.updateString("fecha_nacimiento", getFechaMySQL(p.getFechaNacim()));
            }

            //Por ultimo para que se termine de crear un registro en la base de datos/tabla, ejecuto el metodo insertRow
            rs.insertRow();

            //Cierro ResultSet (rs) y Statament (st), es indispensable NO Olvidarse de cerrar
            //estos objetos. De no ser asi, NO se registrara que se creo un registro
            rs.close();
            st.close();

            //Por Ultimo pongo a la bandera del metodo en true para indicar que no ha ocurrido ningun error
            //y el metodo tubo exito
            //Nota: es importante definir a lo ultimo del codigo esta bandera indicando que todos los pasos
            //fueron realizados con exito
            isOk = true;

        } catch (SQLException e) {
            //Si hay alguna excepción en algun momento relacionado con algun metodo mal escrito o mal ejecutado, o bien
            //problemas en la red para ejecutar los metodos se sucede esta seccion de codigo.
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    /**
     * Metodo que recibe como parametro un Objeto tipo Paciente y lo
     * ACTUALIZA en la base de datos en la tabla pacientes 
     * @param p
     * @return true=registra, false=presencia de error
     */
    public boolean isActualizar(Paciente p) {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=" + p.getId());

            //Metodo next() que indica si puedo ir al nuevo resultado del ResultSet, indicando que tengo un registro.
            //Pueden investigar si funciona tambien con el metodo rs.first()
            if(rs.next()){
                //Me ubico en el resultado y actualizo los campos
                rs.updateString("apellido", p.getApellido());
                rs.updateString("nombres", p.getNombres());
                rs.updateInt("documento", p.getDocumento());

                if (p.getFechaNacim() == null) {
                    rs.updateDate("fecha_nacimiento", null);
                } else {
                    rs.updateString("fecha_nacimiento", getFechaMySQL(p.getFechaNacim()));
                }

                //Metodo para atualizar resultado(registro) en la base de datos/tabla
                rs.updateRow();
                isOk = true;
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        } finally {
            return isOk;
        }
    }

    /**
     * Metodo que recibe como parametro un Objeto tipo Paciente y lo
     * BORRA en la base de datos en la tabla pacientes 
     * @param p
     * @return true=registra, false=presencia de error
     */
    public boolean isBorrar(Paciente p) {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("SELECT * FROM " + TABLA + " WHERE id=" + p.getId());

            if(rs.next()){
                //Al ejecutar el metodo deleteRow() confirmo los campos en la base de datos/tabla
                rs.deleteRow();
                isOk = true;
            }
            rs.close();
            st.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }

    /**
     * Metodo que BORRA TODOS pacientes en la base de datos 
     * @param p
     * @return true=registra, false=presencia de error
     */
    public boolean isBorrarTodo() {
        boolean isOk = false;
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            isOk = st.executeUpdate("DELETE FROM " + TABLA)>0;

            st.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return isOk;
        }
    }
    
    /**
     * Metodo que recibo una consulta SQL en String y retorna un 
     * ArrayList de pacientes
     * @param query
     * @return ArrayList
     */
    public ArrayList<Paciente> listarPacientes(String query) {
        ArrayList<Paciente> list = new ArrayList<Paciente>();
        try {
            Statement st = (Statement) this.getCn().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getInt("id"),
                        rs.getString("apellido"),
                        rs.getString("nombres"),
                        rs.getInt("documento"),
                        getCalendar(rs.getTimestamp("fecha_nacimiento")));

                list.add(paciente);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            return list;
        }
    }
    
    /**
     * Metodo que recibo codigo de paciente y retorna
     * un Objeto de tipo Paciente, sino encuentra el 
     * paciente el Objeto que retorna es nulo (null)
     * @param id
     * @return Paciente
     */
    public Paciente getPaciente(int id){
        Paciente p = null;
        //Saber si me puedo Conectar
        if(isOkConexion()){
            //Genero consulta SQL
            String query = "SELECT * FROM " + TABLA + " WHERE id=" + id;
            //Reutilizo metodo de listarPacientes con SQL en busqueda de paciente
            ArrayList<Paciente> pacientesList = listarPacientes(query);
            isCerrarConexion();//Cierro Conexion
            
            //Pregunto si el ArrayList en respuesta del metodo listarPacinetes(***) tiene un Objeto
            if(pacientesList.size()==1){
                //Si tiene acceso a la primer posicion
                Paciente pList = pacientesList.get(0);
                //hago una instancia de p(Paciente) con el valor de la posicion 0
                p = new Paciente(pList.getId(),
                                pList.getApellido(),
                                pList.getNombres(),
                                pList.getDocumento(),
                                pList.getFechaNacim());
            }
        }
        //Retorno el valor del Objeto p
        return p;
    }

    public boolean isokConexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Vector<?> toObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
