package pe.egcc.app.prueba;

import java.sql.Connection;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class Prueba02 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      System.out.println("Ejecutando proceso.");
      //Thread.currentThread().sleep(10000);
      System.out.println("Fin de proceso");
    } catch (Exception e) {
      e.printStackTrace();
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
