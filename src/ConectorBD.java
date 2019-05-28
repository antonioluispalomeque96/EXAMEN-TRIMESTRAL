
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectorBD {

    private String bd = "agenda";
    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/" + bd;
    private Connection conn = null;

    /**
     * Constructor de DbConnection
     */
    public ConectorBD() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexiÃ³n
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("Coneccion a base de datos " + bd + ". lista");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     */
    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        System.out.println("La conexion a la  base de datos " + bd + " ha terminado");
    }

    public boolean altaPersona(Persona p) {

        String letraDni = p.getDni().substring(8);
        System.out.println(letraDni);
        int dni = Integer.parseInt(p.getDni().substring(0, 8));
        boolean comprobar = false;
        String consulta = "INSERT INTO agenda VALUES( ? , ? , ? , ? , ? , ? , ? )";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(consulta);

            ps.setInt(1, dni);
            ps.setString(2, letraDni);
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellidos());
            ps.setInt(5, p.getTelefono());
            ps.setInt(6, p.getEdad());
            ps.setDouble(7, p.getPeso());

            if (ps.executeUpdate() > 0) {

                comprobar = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comprobar;

    }

    public String DatosPersonas(String dni) {

        dni = dni.substring(0, 8);

        int dniNumerico = Integer.parseInt(dni);
        String retorno;
        StringBuilder listado = new StringBuilder();
        String consulta = "SELECT * FROM agenda WHERE dni= ? ";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(consulta);

            ps.setInt(1, dniNumerico);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                listado.append(Utilidades.formatoColumna("" + rs.getInt(1), 50)).append(Utilidades.formatoColumna(rs.getString(2), 50)).append(Utilidades.formatoColumna(rs.getString(3), 50)).append(Utilidades.formatoColumna(rs.getString(4), 50)).append(Utilidades.formatoColumna("" + rs.getInt(5), 50)).append(Utilidades.formatoColumna("" + rs.getInt(6), 50)).append(Utilidades.formatoColumna("" + rs.getDouble(7), 50)).append("\n");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        retorno = listado.toString();

        return retorno;

    }

    public boolean borrarPersona(String dni) {

        dni = dni.substring(0, 8);

        int dniNumerico = Integer.parseInt(dni);
        boolean comprobar = false;

        String consulta = "DELETE FROM agenda WHERE dni= ?";

        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(consulta);

            ps.setInt(1, dniNumerico);

            if (ps.executeUpdate() > 0) {

                comprobar = true;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comprobar;

    }

    public String mostrarDatos() {

        String retorno;
        StringBuilder listado = new StringBuilder();

        String consulta = "SELECT * FROM agenda";

        Statement s;
        try {
            s = conn.createStatement();

            ResultSet rs = s.executeQuery(consulta);

            while (rs.next()) {

                listado.append(Utilidades.formatoColumna("" + rs.getInt(1), 50)).append(Utilidades.formatoColumna(rs.getString(2), 50)).append(Utilidades.formatoColumna(rs.getString(3), 50)).append(Utilidades.formatoColumna(rs.getString(4), 50)).append(Utilidades.formatoColumna("" + rs.getInt(5), 50)).append(Utilidades.formatoColumna("" + rs.getInt(6), 50)).append(Utilidades.formatoColumna("" + rs.getDouble(7), 50)).append("\n");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConectorBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        retorno = listado.toString();

        return retorno;

    }

}
