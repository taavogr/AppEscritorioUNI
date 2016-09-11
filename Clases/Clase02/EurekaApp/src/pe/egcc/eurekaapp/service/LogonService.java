package pe.egcc.eurekaapp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.egcc.eurekaapp.db.AccesoDB;
import pe.egcc.eurekaapp.model.Empleado;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class LogonService {
  
  private static final Logger LOGGER = Logger.getLogger( LogonService.class.getName() );
  
  /**
   * Valida el usuario y la clase en la BD.
   * Si son correctos retorna un objeto de tipo Emplado.
   * Caso contrario, retorna null.
   * 
   * @param usuario
   * @param clave
   * @return Retorna un objeto de tipo Empleado.
   */
  public Empleado validar(String usuario, String clave){
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_emplcodigo,vch_emplpaterno,"
              + "vch_emplmaterno,vch_emplnombre, "
              + "vch_emplciudad,vch_empldireccion,"
              + "vch_emplusuario "
              + "from empleado "
              + "where vch_emplusuario = ? "
              + "and vch_emplclave = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Empleado();
        bean.setCodigo(rs.getString("chr_emplcodigo"));
        bean.setPaterno(rs.getString("vch_emplpaterno"));
        bean.setMaterno(rs.getString("vch_emplmaterno"));
        bean.setNombre(rs.getString("vch_emplnombre"));
        bean.setCiudad(rs.getString("vch_emplciudad"));
        bean.setDireccion(rs.getString("vch_empldireccion"));
        bean.setUsuario(rs.getString("vch_emplusuario"));
        bean.setClave("*********");
      }
      rs.close();
      pstm.close();
      if( bean == null ) {
        throw new Exception("Datos ingresados no son correctos.");
      }
      LOGGER.log(Level.INFO, "Validación de usuario ok.");
    } catch (Exception e) {
      LOGGER.log( Level.SEVERE, e.toString(), e );
      throw new RuntimeException(e.getMessage());
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }
  
}
