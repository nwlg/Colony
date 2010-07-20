// license-header java merge-point
package es.pode.modificador.presentacion.configurar;

import java.io.Serializable;

/**
 * 
 */
public class ConfigurarModificacionSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "configurarModificacionSession";

    private java.lang.String nombre;

    public java.lang.String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    private es.pode.modificador.negocio.servicio.ConfiguracionTarea configuracion;

    public es.pode.modificador.negocio.servicio.ConfiguracionTarea getConfiguracion()
    {
        return this.configuracion;
    }

    public void setConfiguracion(es.pode.modificador.negocio.servicio.ConfiguracionTarea configuracion)
    {
        this.configuracion = configuracion;
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


}
