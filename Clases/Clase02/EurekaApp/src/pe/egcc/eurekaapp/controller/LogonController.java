package pe.egcc.eurekaapp.controller;

import pe.egcc.eurekaapp.model.Empleado;
import pe.egcc.eurekaapp.service.LogonService;
import pe.egcc.eurekaapp.util.Session;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronec@gmail.com
 */
public class LogonController {

  public void validar(String usuario, String clave) {
    LogonService service = new LogonService();
    Empleado bean = service.validar(usuario, clave);
    Session.put("usuario", bean);
  }
  
  
  
  
  
  
}
