
package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Parametros
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://172.17.1.130:3306/eurekabank";
    String user = "eureka";
    String pass = "admin";
    try {
      // Cargar Driver
      Class.forName(driver).newInstance();
      // Obtener Conexión
      Connection cn = DriverManager.getConnection(urlDB,user,pass);
      // Mensaje
      System.out.println("Conexión ok.");
      // Cerrar Conexión
      cn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
    
}
