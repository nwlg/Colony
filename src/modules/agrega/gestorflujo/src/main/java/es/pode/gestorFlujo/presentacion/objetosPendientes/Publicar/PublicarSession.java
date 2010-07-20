// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

import java.io.Serializable;

/**
 * <p>
 * Este objeto contiene el comentario, el tipo de licencia y las
 * comunidades que ha escogido el usario durante la publicacion de
 * un ODE.
 * </p>
 */
public class PublicarSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "publicarSession";

    private java.lang.String tipoLicencia;

  /**
   * <p>
   * el codigo de la licencia que tenemos actualmente.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getTipoLicencia()
    {
        return this.tipoLicencia;
    }

  /**
   * <p>
   * el codigo de la licencia que tenemos actualmente.
   * </p>
   *  @param tipoLicencia  el codigo de la licencia que tenemos actualmente.  
   */
    public void setTipoLicencia(java.lang.String tipoLicencia)
    {
        this.tipoLicencia = tipoLicencia;
    }

    private java.lang.String comunidades;

    public java.lang.String getComunidades()
    {
        return this.comunidades;
    }

    public void setComunidades(java.lang.String comunidades)
    {
        this.comunidades = comunidades;
    }

    private java.lang.String universal;

  /**
   * <p>
   * Si es universal la licencia del ODE, se obtiene de vocabularios
   * controlados
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getUniversal()
    {
        return this.universal;
    }

  /**
   * <p>
   * Si es universal la licencia del ODE, se obtiene de vocabularios
   * controlados
   * </p>
   *  @param universal  Si es universal la licencia del ODE, se obtiene de vocabularios controlados  
   */
    public void setUniversal(java.lang.String universal)
    {
        this.universal = universal;
    }

    private java.lang.String idODE;

    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private java.lang.Boolean esDespublicado;

  /**
   * <p>
   * Indica si el ode que estamos tratando viene de despubilcados o
   * de pendientes
   * </p>
   * @return java.lang.Boolean
   */
    public java.lang.Boolean getEsDespublicado()
    {
        return this.esDespublicado;
    }

  /**
   * <p>
   * Indica si el ode que estamos tratando viene de despubilcados o
   * de pendientes
   * </p>
   *  @param esDespublicado  Indica si el ode que estamos tratando viene de despubilcados o de pendientes  
   */
    public void setEsDespublicado(java.lang.Boolean esDespublicado)
    {
        this.esDespublicado = esDespublicado;
    }

    private java.lang.String titulo;

  /**
   * <p>
   * El título del ode
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

  /**
   * <p>
   * El título del ode
   * </p>
   *  @param titulo  El título del ode  
   */
    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String comentarios;

    public java.lang.String getComentarios()
    {
        return this.comentarios;
    }

    public void setComentarios(java.lang.String comentarios)
    {
        this.comentarios = comentarios;
    }

    private java.lang.String[] comunidadesMostrar;

  /**
   * <p>
   * Las comunidades que mostramos en el ambito.
   * </p>
   * @return java.lang.String[]
   */
    public java.lang.String[] getComunidadesMostrar()
    {
        return this.comunidadesMostrar;
    }

  /**
   * <p>
   * Las comunidades que mostramos en el ambito.
   * </p>
   *  @param comunidadesMostrar  Las comunidades que mostramos en el ambito.  
   */
    public void setComunidadesMostrar(java.lang.String[] comunidadesMostrar)
    {
        this.comunidadesMostrar = comunidadesMostrar;
    }


}
