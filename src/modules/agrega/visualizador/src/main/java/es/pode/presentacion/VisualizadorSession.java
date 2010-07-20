// license-header java merge-point
package es.pode.presentacion;

import java.io.Serializable;

/**
 * 
 */
public class VisualizadorSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "visualizadorSession";

    private java.util.Collection datosSalida;

    public java.util.Collection getDatosSalida()
    {
        return this.datosSalida;
    }

    public void setDatosSalida(java.util.Collection datosSalida)
    {
        this.datosSalida = datosSalida;
    }

    private java.util.Collection itemsFlow;

    public java.util.Collection getItemsFlow()
    {
        return this.itemsFlow;
    }

    public void setItemsFlow(java.util.Collection itemsFlow)
    {
        this.itemsFlow = itemsFlow;
    }

    private java.lang.String identificador;

    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    private java.lang.String localizadorCont;

    public java.lang.String getLocalizadorCont()
    {
        return this.localizadorCont;
    }

    public void setLocalizadorCont(java.lang.String localizadorCont)
    {
        this.localizadorCont = localizadorCont;
    }

    private java.lang.String UrlContenido;

    public java.lang.String getUrlContenido()
    {
        return this.UrlContenido;
    }

    public void setUrlContenido(java.lang.String UrlContenido)
    {
        this.UrlContenido = UrlContenido;
    }

    private java.lang.Boolean btnIzquierdo;

    public java.lang.Boolean getBtnIzquierdo()
    {
        return this.btnIzquierdo;
    }

    public void setBtnIzquierdo(java.lang.Boolean btnIzquierdo)
    {
        this.btnIzquierdo = btnIzquierdo;
    }

    private java.lang.Boolean btnDerecho;

    public java.lang.Boolean getBtnDerecho()
    {
        return this.btnDerecho;
    }

    public void setBtnDerecho(java.lang.Boolean btnDerecho)
    {
        this.btnDerecho = btnDerecho;
    }

    private int contador;

    public int getContador()
    {
        return this.contador;
    }

    public void setContador(int contador)
    {
        this.contador = contador;
    }

    private java.lang.String usuario;

    public java.lang.String getUsuario()
    {
        return this.usuario;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    private java.lang.String idSeleccionado;

    public java.lang.String getIdSeleccionado()
    {
        return this.idSeleccionado;
    }

    public void setIdSeleccionado(java.lang.String idSeleccionado)
    {
        this.idSeleccionado = idSeleccionado;
    }

    private java.lang.String tituloOde;

    public java.lang.String getTituloOde()
    {
        return this.tituloOde;
    }

    public void setTituloOde(java.lang.String tituloOde)
    {
        this.tituloOde = tituloOde;
    }

    private java.lang.String urlCerrar;

    public java.lang.String getUrlCerrar()
    {
        return this.urlCerrar;
    }

    public void setUrlCerrar(java.lang.String urlCerrar)
    {
        this.urlCerrar = urlCerrar;
    }

    private java.lang.String idiomaCat;

    public java.lang.String getIdiomaCat()
    {
        return this.idiomaCat;
    }

    public void setIdiomaCat(java.lang.String idiomaCat)
    {
        this.idiomaCat = idiomaCat;
    }

    private java.lang.String contenidoEmbebido;

    public java.lang.String getContenidoEmbebido()
    {
        return this.contenidoEmbebido;
    }

    public void setContenidoEmbebido(java.lang.String contenidoEmbebido)
    {
        this.contenidoEmbebido = contenidoEmbebido;
    }

    private boolean masOpciones;

  /**
   * <p>
   * variable que indica si se mostrarán opciones adicionales en la
   * metanavegación, dependiendo si el usuario está autenticado y ha
   * llamado al visualizador desde la busqueda
   * </p>
   * @return boolean
   */
    public boolean isMasOpciones()
    {
        return this.masOpciones;
    }

  /**
   * <p>
   * variable que indica si se mostrarán opciones adicionales en la
   * metanavegación, dependiendo si el usuario está autenticado y ha
   * llamado al visualizador desde la busqueda
   * </p>
   *  @param masOpciones  variable que indica si se mostrarán opciones adicionales en la metanavegación, dependiendo si el usuario está autenticado y ha llamado al visualizador desde la busqueda  
   */
    public void setMasOpciones(boolean masOpciones)
    {
        this.masOpciones = masOpciones;
    }

    private boolean offLine;

    public boolean isOffLine()
    {
        return this.offLine;
    }

    public void setOffLine(boolean offLine)
    {
        this.offLine = offLine;
    }

    private boolean abiertos;

    public boolean isAbiertos()
    {
        return this.abiertos;
    }

    public void setAbiertos(boolean abiertos)
    {
        this.abiertos = abiertos;
    }

    private java.util.Collection rutaSeleccionado;

    public java.util.Collection getRutaSeleccionado()
    {
        return this.rutaSeleccionado;
    }

    public void setRutaSeleccionado(java.util.Collection rutaSeleccionado)
    {
        this.rutaSeleccionado = rutaSeleccionado;
    }


}
