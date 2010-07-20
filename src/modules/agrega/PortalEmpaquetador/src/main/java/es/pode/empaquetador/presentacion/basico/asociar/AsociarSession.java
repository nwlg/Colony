// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

import java.io.Serializable;

/**
 * 
 */
public class AsociarSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "asociarSession";

    private java.lang.String idGrupo;

    public java.lang.String getIdGrupo()
    {
        return this.idGrupo;
    }

    public void setIdGrupo(java.lang.String idGrupo)
    {
        this.idGrupo = idGrupo;
    }

    private java.lang.String idRecurso;

    public java.lang.String getIdRecurso()
    {
        return this.idRecurso;
    }

    public void setIdRecurso(java.lang.String idRecurso)
    {
        this.idRecurso = idRecurso;
    }

    private java.util.List ficheros;

    public java.util.List getFicheros()
    {
        return this.ficheros;
    }

    public void setFicheros(java.util.List ficheros)
    {
        this.ficheros = ficheros;
    }

    private java.lang.String href;

    public java.lang.String getHref()
    {
        return this.href;
    }

    public void setHref(java.lang.String href)
    {
        this.href = href;
    }

    private boolean modificar;

    public boolean isModificar()
    {
        return this.modificar;
    }

    public void setModificar(boolean modificar)
    {
        this.modificar = modificar;
    }


}
