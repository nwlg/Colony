// license-header java merge-point
package es.pode.administracion.presentacion.descargas;

import java.io.Serializable;

/**
 * 
 */
public class ConfigurarDescargaSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "configurarDescargaSession";

    private java.util.List descripciones;

    public java.util.List getDescripciones()
    {
        return this.descripciones;
    }

    public void setDescripciones(java.util.List descripciones)
    {
        this.descripciones = descripciones;
    }

    private java.lang.Long peso;

    public java.lang.Long getPeso()
    {
        return this.peso;
    }

    public void setPeso(java.lang.Long peso)
    {
        this.peso = peso;
    }

    private java.lang.String path;

    public java.lang.String getPath()
    {
        return this.path;
    }

    public void setPath(java.lang.String path)
    {
        this.path = path;
    }

    private java.lang.Long identificador;

    public java.lang.Long getIdentificador()
    {
        return this.identificador;
    }

    public void setIdentificador(java.lang.Long identificador)
    {
        this.identificador = identificador;
    }

    private java.util.Calendar fecha;

    public java.util.Calendar getFecha()
    {
        return this.fecha;
    }

    public void setFecha(java.util.Calendar fecha)
    {
        this.fecha = fecha;
    }

    private java.lang.Boolean activa;

    public java.lang.Boolean getActiva()
    {
        return this.activa;
    }

    public void setActiva(java.lang.Boolean activa)
    {
        this.activa = activa;
    }


}
