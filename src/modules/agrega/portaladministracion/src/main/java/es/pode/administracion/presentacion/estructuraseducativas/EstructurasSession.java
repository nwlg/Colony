// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas;

import java.io.Serializable;

/**
 * 
 */
public class EstructurasSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "estructurasSession";

    private java.lang.String[] VdexEliminar;

    public java.lang.String[] getVdexEliminar()
    {
        return this.VdexEliminar;
    }

    public void setVdexEliminar(java.lang.String[] VdexEliminar)
    {
        this.VdexEliminar = VdexEliminar;
    }

    private java.util.List VdexSubir;

    public java.util.List getVdexSubir()
    {
        return this.VdexSubir;
    }

    public void setVdexSubir(java.util.List VdexSubir)
    {
        this.VdexSubir = VdexSubir;
    }


}
