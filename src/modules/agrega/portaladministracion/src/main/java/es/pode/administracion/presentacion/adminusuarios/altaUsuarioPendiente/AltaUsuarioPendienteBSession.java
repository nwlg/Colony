// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuarioPendiente;

import java.io.Serializable;

/**
 * 
 */
public class AltaUsuarioPendienteBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "altaUsuarioPendienteBSession";

    private es.pode.adminusuarios.negocio.servicios.UsuarioVO usuarioPendiente;

    public es.pode.adminusuarios.negocio.servicios.UsuarioVO getUsuarioPendiente()
    {
        return this.usuarioPendiente;
    }

    public void setUsuarioPendiente(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuarioPendiente)
    {
        this.usuarioPendiente = usuarioPendiente;
    }


}
