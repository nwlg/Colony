// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

import java.io.Serializable;

/**
 * 
 */
public class ModificarUsuarioBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "modificarUsuarioBSession";

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
