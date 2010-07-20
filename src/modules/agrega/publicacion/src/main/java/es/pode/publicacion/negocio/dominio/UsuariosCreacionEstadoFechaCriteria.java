// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.publicacion.negocio.dominio;

/**
 * <p>
 * Criterio de busqueda para seleccionar los ODEs  en el estado
 * especificado pertenecientes a alguno de los usuarios que me
 * pasan como creadores ordenados por fecha en la que transitaron a
 * dicho estado.
 * </p>
 */
public class UsuariosCreacionEstadoFechaCriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public UsuariosCreacionEstadoFechaCriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param idsUsuarios java.lang.String[]
      * @param estadoTransitado es.pode.publicacion.negocio.dominio.Estado
      * @param estadoActual es.pode.publicacion.negocio.dominio.Estado
      * @param fecha java.util.Calendar
     */
    public UsuariosCreacionEstadoFechaCriteria(
        java.lang.String[] idsUsuarios,
        es.pode.publicacion.negocio.dominio.Estado estadoTransitado,
        es.pode.publicacion.negocio.dominio.Estado estadoActual,
        java.util.Calendar fecha)

    {
        this.idsUsuarios = idsUsuarios;
        this.estadoTransitado = estadoTransitado;
        this.estadoActual = estadoActual;
        this.fecha = fecha;
    }

    /**
     * Copies constructor from other UsuariosCreacionEstadoFechaCriteria
      * @param otherBean UsuariosCreacionEstadoFechaCriteria
     */
    public UsuariosCreacionEstadoFechaCriteria(UsuariosCreacionEstadoFechaCriteria otherBean)
    {
        if (otherBean != null)
        {
            this.idsUsuarios = otherBean.getIdsUsuarios();
            this.estadoTransitado = otherBean.getEstadoTransitado();
            this.estadoActual = otherBean.getEstadoActual();
            this.fecha = otherBean.getFecha();
        }
    }

    /**
     * The first result to retrieve.
     */
    private java.lang.Integer firstResult;

    /**
     * Gets the first result to retrieve.
     *
     * @return the first result to retrieve
     */
    public java.lang.Integer getFirstResult()
    {
        return this.firstResult;
    }

    /**
     * Sets the first result to retrieve.
     *
     * @param firstResult the first result to retrieve
     */
    public void setFirstResult(java.lang.Integer firstResult)
    {
        this.firstResult = firstResult;
    }

    /**
     * The fetch size.
     */
    private java.lang.Integer fetchSize;

    /**
     * Gets the fetch size.
     *
     * @return the fetch size
     */
    public java.lang.Integer getFetchSize()
    {
        return this.fetchSize;
    }

    /**
     * Sets the fetch size.
     *
     * @param fetchSize the fetch size
     */
    public void setFetchSize(java.lang.Integer fetchSize)
    {
        this.fetchSize = fetchSize;
    }

    /**
     * The maximum size of the result set.
     */
    private java.lang.Integer maximumResultSize;

    /**
     * Gets the maximum size of the search result.
     *
     * @return the maximum size of the search result.
     */
    public java.lang.Integer getMaximumResultSize()
    {
        return this.maximumResultSize;
    }

    /**
     * Sets the maxmimum size of the result.
     *
     * @param maximumResultSize A number indicating how many results will be returned.
     */
    public void setMaximumResultSize(java.lang.Integer maximumResultSize)
    {
        this.maximumResultSize = maximumResultSize;
    }

    private java.lang.String[] idsUsuarios;

  /**
   * <p>
   * El listado de los identificadores de los usuarios
   * </p>
   * @return java.lang.String[]
   */
    public java.lang.String[] getIdsUsuarios()
    {
        return this.idsUsuarios;
    }

  /**
   * <p>
   * El listado de los identificadores de los usuarios
   * </p>
   *  @param idsUsuarios  El listado de los identificadores de los usuarios 
   */
    public void setIdsUsuarios(java.lang.String[] idsUsuarios)
    {
        this.idsUsuarios = idsUsuarios;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoTransitado;

  /**
   * <p>
   * Estado al que va la transicion. En este caso null. La transicion
   * actual vacio identifica al estado actual.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoTransitado()
    {
        return this.estadoTransitado;
    }

  /**
   * <p>
   * Estado al que va la transicion. En este caso null. La transicion
   * actual vacio identifica al estado actual.
   * </p>
   *  @param estadoTransitado  Estado al que va la transicion. En este caso null. La transicion actual vacio identifica al estado actual. 
   */
    public void setEstadoTransitado(es.pode.publicacion.negocio.dominio.Estado estadoTransitado)
    {
        this.estadoTransitado = estadoTransitado;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoActual;

  /**
   * <p>
   * Este es el estado actual del Ode.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoActual()
    {
        return this.estadoActual;
    }

  /**
   * <p>
   * Este es el estado actual del Ode.
   * </p>
   *  @param estadoActual  Este es el estado actual del Ode. 
   */
    public void setEstadoActual(es.pode.publicacion.negocio.dominio.Estado estadoActual)
    {
        this.estadoActual = estadoActual;
    }

    private java.util.Calendar fecha;

  /**
   * <p>
   * Fecha. Sirve para ordenar el resultado.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFecha()
    {
        return this.fecha;
    }

  /**
   * <p>
   * Fecha. Sirve para ordenar el resultado.
   * </p>
   *  @param fecha  Fecha. Sirve para ordenar el resultado. 
   */
    public void setFecha(java.util.Calendar fecha)
    {
        this.fecha = fecha;
    }

}