// license-header java merge-point
package es.pode.modificador.presentacion.informes;

import java.io.Serializable;

/**
 * 
 */
public class InformeSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "informeSession";

    private java.util.List odes;

    public java.util.List getOdes()
    {
        return this.odes;
    }

    public void setOdes(java.util.List odes)
    {
        this.odes = odes;
    }

    private java.lang.String nombreTarea;

    public java.lang.String getNombreTarea()
    {
        return this.nombreTarea;
    }

    public void setNombreTarea(java.lang.String nombreTarea)
    {
        this.nombreTarea = nombreTarea;
    }

    private java.lang.String resultadoTarea;

    public java.lang.String getResultadoTarea()
    {
        return this.resultadoTarea;
    }

    public void setResultadoTarea(java.lang.String resultadoTarea)
    {
        this.resultadoTarea = resultadoTarea;
    }

    private java.lang.String descResultado;

    public java.lang.String getDescResultado()
    {
        return this.descResultado;
    }

    public void setDescResultado(java.lang.String descResultado)
    {
        this.descResultado = descResultado;
    }

    private java.lang.String origen;

    public java.lang.String getOrigen()
    {
        return this.origen;
    }

    public void setOrigen(java.lang.String origen)
    {
        this.origen = origen;
    }

    private java.lang.Long idModificacion;

    public java.lang.Long getIdModificacion()
    {
        return this.idModificacion;
    }

    public void setIdModificacion(java.lang.Long idModificacion)
    {
        this.idModificacion = idModificacion;
    }

    private java.lang.Long tareaSeleccionada;

    public java.lang.Long getTareaSeleccionada()
    {
        return this.tareaSeleccionada;
    }

    public void setTareaSeleccionada(java.lang.Long tareaSeleccionada)
    {
        this.tareaSeleccionada = tareaSeleccionada;
    }


}
