// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.exportar;

import java.io.Serializable;

/**
 * 
 */
public class ExportarRecursosSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "exportarRecursosSession";

    private java.util.List recursosVO;

    public java.util.List getRecursosVO()
    {
        return this.recursosVO;
    }

    public void setRecursosVO(java.util.List recursosVO)
    {
        this.recursosVO = recursosVO;
    }


}
