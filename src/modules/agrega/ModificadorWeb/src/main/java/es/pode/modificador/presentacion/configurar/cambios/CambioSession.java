// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios;

import java.io.Serializable;

/**
 * 
 */
public class CambioSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "cambioSession";

    private java.lang.String tipo;

    public java.lang.String getTipo()
    {
        return this.tipo;
    }

    public void setTipo(java.lang.String tipo)
    {
        this.tipo = tipo;
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

    private java.lang.String valor;

    public java.lang.String getValor()
    {
        return this.valor;
    }

    public void setValor(java.lang.String valor)
    {
        this.valor = valor;
    }

    private java.lang.Boolean alcance;

    public java.lang.Boolean getAlcance()
    {
        return this.alcance;
    }

    public void setAlcance(java.lang.Boolean alcance)
    {
        this.alcance = alcance;
    }

    private java.lang.Integer posicion;

    public java.lang.Integer getPosicion()
    {
        return this.posicion;
    }

    public void setPosicion(java.lang.Integer posicion)
    {
        this.posicion = posicion;
    }

    private java.lang.String valorNuevo;

    public java.lang.String getValorNuevo()
    {
        return this.valorNuevo;
    }

    public void setValorNuevo(java.lang.String valorNuevo)
    {
        this.valorNuevo = valorNuevo;
    }

    private java.lang.Boolean exprReg;

    public java.lang.Boolean getExprReg()
    {
        return this.exprReg;
    }

    public void setExprReg(java.lang.Boolean exprReg)
    {
        this.exprReg = exprReg;
    }

    private java.lang.String lomTerm;

    public java.lang.String getLomTerm()
    {
        return this.lomTerm;
    }

    public void setLomTerm(java.lang.String lomTerm)
    {
        this.lomTerm = lomTerm;
    }

    private java.lang.String idLomTerm;

    public java.lang.String getIdLomTerm()
    {
        return this.idLomTerm;
    }

    public void setIdLomTerm(java.lang.String idLomTerm)
    {
        this.idLomTerm = idLomTerm;
    }

    private java.lang.Boolean replaceAll;

    public java.lang.Boolean getReplaceAll()
    {
        return this.replaceAll;
    }

    public void setReplaceAll(java.lang.Boolean replaceAll)
    {
        this.replaceAll = replaceAll;
    }

    private java.lang.String tipoAniadir;

    public java.lang.String getTipoAniadir()
    {
        return this.tipoAniadir;
    }

    public void setTipoAniadir(java.lang.String tipoAniadir)
    {
        this.tipoAniadir = tipoAniadir;
    }


}
