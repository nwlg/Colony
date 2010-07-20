// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar;

import java.io.Serializable;

/**
 * 
 */
public class DesagregarSubmanifiestoSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "desagregarSubmanifiestoSession";

    private java.util.List identificadores;

    public java.util.List getIdentificadores()
    {
        return this.identificadores;
    }

    public void setIdentificadores(java.util.List identificadores)
    {
        this.identificadores = identificadores;
    }


}
