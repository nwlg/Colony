// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.buscar;

import java.io.Serializable;

/**
 * 
 */
public class BusquedaSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "busquedaSession";

    private java.lang.String identificador;

    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    private java.lang.String titulo;

    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String autor;

    public java.lang.String getAutor()
    {
        return this.autor;
    }

    public void setAutor(java.lang.String autor)
    {
        this.autor = autor;
    }

    private java.lang.String diaDesde;

    public java.lang.String getDiaDesde()
    {
        return this.diaDesde;
    }

    public void setDiaDesde(java.lang.String diaDesde)
    {
        this.diaDesde = diaDesde;
    }

    private java.lang.String mesDesde;

    public java.lang.String getMesDesde()
    {
        return this.mesDesde;
    }

    public void setMesDesde(java.lang.String mesDesde)
    {
        this.mesDesde = mesDesde;
    }

    private java.lang.String anyoDesde;

    public java.lang.String getAnyoDesde()
    {
        return this.anyoDesde;
    }

    public void setAnyoDesde(java.lang.String anyoDesde)
    {
        this.anyoDesde = anyoDesde;
    }

    private java.lang.String anyoHasta;

    public java.lang.String getAnyoHasta()
    {
        return this.anyoHasta;
    }

    public void setAnyoHasta(java.lang.String anyoHasta)
    {
        this.anyoHasta = anyoHasta;
    }

    private java.lang.String mesHasta;

    public java.lang.String getMesHasta()
    {
        return this.mesHasta;
    }

    public void setMesHasta(java.lang.String mesHasta)
    {
        this.mesHasta = mesHasta;
    }

    private java.lang.String diaHasta;

    public java.lang.String getDiaHasta()
    {
        return this.diaHasta;
    }

    public void setDiaHasta(java.lang.String diaHasta)
    {
        this.diaHasta = diaHasta;
    }

    private java.util.List seleccionados;

    public java.util.List getSeleccionados()
    {
        return this.seleccionados;
    }

    public void setSeleccionados(java.util.List seleccionados)
    {
        this.seleccionados = seleccionados;
    }

    private java.util.List resultados;

    public java.util.List getResultados()
    {
        return this.resultados;
    }

    public void setResultados(java.util.List resultados)
    {
        this.resultados = resultados;
    }

    private java.lang.String idioma;

    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }


}
