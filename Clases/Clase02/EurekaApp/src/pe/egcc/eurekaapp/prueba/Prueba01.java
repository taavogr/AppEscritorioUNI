package pe.egcc.eurekaapp.prueba;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.LogonService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    try {
      LogonService service = new LogonService();
      Empleado bean = service.validar("creyes", "linda");
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
