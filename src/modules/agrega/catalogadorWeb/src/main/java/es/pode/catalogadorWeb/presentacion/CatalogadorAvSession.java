// license-header java merge-point
package es.pode.catalogadorWeb.presentacion;

import java.io.Serializable;

/**
 * 
 */
public class CatalogadorAvSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "catalogadorAvSession";

    private java.lang.String idioma;

    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
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

    private java.lang.String identificador;

    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    private java.lang.String returnURL;

    public java.lang.String getReturnURL()
    {
        return this.returnURL;
    }

    public void setReturnURL(java.lang.String returnURL)
    {
        this.returnURL = returnURL;
    }

    private es.pode.catalogacion.negocio.servicios.LomAvanzadoVO MDSesion;

  /**
   * <p>
   * sera el LomAvanzadoVO
   * </p>
   * @return es.pode.catalogacion.negocio.servicios.LomAvanzadoVO
   */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO getMDSesion()
    {
        return this.MDSesion;
    }

  /**
   * <p>
   * sera el LomAvanzadoVO
   * </p>
   *  @param MDSesion  sera el LomAvanzadoVO  
   */
    public void setMDSesion(es.pode.catalogacion.negocio.servicios.LomAvanzadoVO MDSesion)
    {
        this.MDSesion = MDSesion;
    }

    private es.pode.catalogacion.negocio.servicios.AvClassificationVO clasificacionAux;

    public es.pode.catalogacion.negocio.servicios.AvClassificationVO getClasificacionAux()
    {
        return this.clasificacionAux;
    }

    public void setClasificacionAux(es.pode.catalogacion.negocio.servicios.AvClassificationVO clasificacionAux)
    {
        this.clasificacionAux = clasificacionAux;
    }

    private java.util.Collection rutasJerarquicas;

    public java.util.Collection getRutasJerarquicas()
    {
        return this.rutasJerarquicas;
    }

    public void setRutasJerarquicas(java.util.Collection rutasJerarquicas)
    {
        this.rutasJerarquicas = rutasJerarquicas;
    }

    private es.pode.catalogacion.negocio.servicios.LomAvanzadoVO LomValidacion;

    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO getLomValidacion()
    {
        return this.LomValidacion;
    }

    public void setLomValidacion(es.pode.catalogacion.negocio.servicios.LomAvanzadoVO LomValidacion)
    {
        this.LomValidacion = LomValidacion;
    }

    private java.lang.String tituloCategoria;

    public java.lang.String getTituloCategoria()
    {
        return this.tituloCategoria;
    }

    public void setTituloCategoria(java.lang.String tituloCategoria)
    {
        this.tituloCategoria = tituloCategoria;
    }

    private java.lang.String[] listaProposito;

    public java.lang.String[] getListaProposito()
    {
        return this.listaProposito;
    }

    public void setListaProposito(java.lang.String[] listaProposito)
    {
        this.listaProposito = listaProposito;
    }

    private javax.activation.DataHandler lomesImportado;

    public javax.activation.DataHandler getLomesImportado()
    {
        return this.lomesImportado;
    }

    public void setLomesImportado(javax.activation.DataHandler lomesImportado)
    {
        this.lomesImportado = lomesImportado;
    }


}
