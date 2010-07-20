// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

import java.io.Serializable;

/**
 * 
 */
public class AltaUsuarioBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "altaUsuarioBSession";

    private es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario;

    public es.pode.adminusuarios.negocio.servicios.UsuarioVO getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(es.pode.adminusuarios.negocio.servicios.UsuarioVO usuario)
    {
        this.usuario = usuario;
    }


}
