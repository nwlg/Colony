// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaGrupo;

import java.io.Serializable;

/**
 * 
 */
public class AltaGrupoBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "altaGrupoBSession";

    private java.lang.String descripcion;

    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }


}
