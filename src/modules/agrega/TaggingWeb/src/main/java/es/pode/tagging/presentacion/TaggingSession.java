// license-header java merge-point
package es.pode.tagging.presentacion;

import java.io.Serializable;

/**
 * 
 */
public class TaggingSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "taggingSession";

    private java.lang.String usuario;

    public java.lang.String getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    private java.lang.String[] tagsEliminar;

    public java.lang.String[] getTagsEliminar()
    {
        return this.tagsEliminar;
    }

    public void setTagsEliminar(java.lang.String[] tagsEliminar)
    {
        this.tagsEliminar = tagsEliminar;
    }

    private java.lang.String tagPaginacion;

    public java.lang.String getTagPaginacion()
    {
        return this.tagPaginacion;
    }

    public void setTagPaginacion(java.lang.String tagPaginacion)
    {
        this.tagPaginacion = tagPaginacion;
    }


}
