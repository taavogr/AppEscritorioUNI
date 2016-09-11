package pe.egcc.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public final class AccesoDB {

  private AccesoDB() {
  }

  public static Connection getConnection() throws SQLException {
    Connection cn = null;
    // Parámetros
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://172.17.1.130:3306/eurekabank";
    String user = "eureka";
    String pass = "admin";
    try {
      Class.forName(driver).newInstance();
      cn = DriverManager.getConnection(urlDB, user, pass);
    } catch (SQLException e) {
      throw e;
    } catch(ClassNotFoundException e){
      throw new SQLException("No se encontro el driver de la BD.");
    } catch(Exception e){
      throw new SQLException("No se puede establecer "
              + "conexión de la BD.");
    }
    return cn;
  }

}
