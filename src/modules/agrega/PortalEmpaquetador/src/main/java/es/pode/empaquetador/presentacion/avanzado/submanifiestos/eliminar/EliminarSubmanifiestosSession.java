// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar;

import java.io.Serializable;

/**
 * 
 */
public class EliminarSubmanifiestosSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "eliminarSubmanifiestosSession";

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
