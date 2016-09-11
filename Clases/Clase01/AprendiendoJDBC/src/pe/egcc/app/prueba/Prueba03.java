package pe.egcc.app.prueba;

import java.sql.Connection;
import java.sql.Statement;
import pe.egcc.app.db.AccesoDB;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class Prueba03 {

  public static void main(String[] args) {
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      System.out.println("Ejecutando proceso.");
      // ============================================
      String sql = "insert into parametro(chr_paracodigo,"
              + "vch_paradescripcion,vch_paravalor,"
              + "vch_paraestado) values('777',"
              + "'PROFESOR','E. GUSTAVO CORONEL CASTILLO',"
              + "'ACTIVO')";
      Statement stm = cn.createStatement();
      stm.executeUpdate(sql);
      // ============================================
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
