// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.crear;

import java.io.Serializable;

/**
 * 
 */
public class CrearOrganizacionSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "crearOrganizacionSession";

    private java.lang.String title;

    public java.lang.String getTitle()
    {
        return this.title;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    private java.lang.String identifier;

    public java.lang.String getIdentifier()
    {
        return this.identifier;
    }

    public void setIdentifier(java.lang.String identifier)
    {
        this.identifier = identifier;
    }

    private boolean esModificar;

    public boolean isEsModificar()
    {
        return this.esModificar;
    }

    public void setEsModificar(boolean esModificar)
    {
        this.esModificar = esModificar;
    }


}
