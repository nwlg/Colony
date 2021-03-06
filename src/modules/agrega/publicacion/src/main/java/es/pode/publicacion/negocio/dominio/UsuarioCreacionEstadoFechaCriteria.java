// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.publicacion.negocio.dominio;

/**
 * <p>
 * Este criterio de busqueda obtiene los ODEs que hayan sido
 * creados por un usuario, que se encuentren en el estado dado y
 * los devuelve ordenados por fecha de transicion a dicho estado.
 * </p>
 */
public class UsuarioCreacionEstadoFechaCriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public UsuarioCreacionEstadoFechaCriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param idUsuarioCreacion java.lang.String
      * @param estadoActual es.pode.publicacion.negocio.dominio.Estado
      * @param estadoTransitado es.pode.publicacion.negocio.dominio.Estado
      * @param fecha java.util.Calendar
     */
    public UsuarioCreacionEstadoFechaCriteria(
        java.lang.String idUsuarioCreacion,
        es.pode.publicacion.negocio.dominio.Estado estadoActual,
        es.pode.publicacion.negocio.dominio.Estado estadoTransitado,
        java.util.Calendar fecha)

    {
        this.idUsuarioCreacion = idUsuarioCreacion;
        this.estadoActual = estadoActual;
        this.estadoTransitado = estadoTransitado;
        this.fecha = fecha;
    }

    /**
     * Copies constructor from other UsuarioCreacionEstadoFechaCriteria
      * @param otherBean UsuarioCreacionEstadoFechaCriteria
     */
    public UsuarioCreacionEstadoFechaCriteria(UsuarioCreacionEstadoFechaCriteria otherBean)
    {
        if (otherBean != null)
        {
            this.idUsuarioCreacion = otherBean.getIdUsuarioCreacion();
            this.estadoActual = otherBean.getEstadoActual();
            this.estadoTransitado = otherBean.getEstadoTransitado();
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

    private java.lang.String idUsuarioCreacion;

  /**
   * <p>
   * Identificador del usuario que creo el ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdUsuarioCreacion()
    {
        return this.idUsuarioCreacion;
    }

  /**
   * <p>
   * Identificador del usuario que creo el ODE.
   * </p>
   *  @param idUsuarioCreacion  Identificador del usuario que creo el ODE. 
   */
    public void setIdUsuarioCreacion(java.lang.String idUsuarioCreacion)
    {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoActual;

  /**
   * <p>
   * Estado en el que se quiere encontrar ODEs para este usuario.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoActual()
    {
        return this.estadoActual;
    }

  /**
   * <p>
   * Estado en el que se quiere encontrar ODEs para este usuario.
   * </p>
   *  @param estadoActual  Estado en el que se quiere encontrar ODEs para este usuario. 
   */
    public void setEstadoActual(es.pode.publicacion.negocio.dominio.Estado estadoActual)
    {
        this.estadoActual = estadoActual;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoTransitado;

  /**
   * <p>
   * Estado al que se ha transitado. Es null.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoTransitado()
    {
        return this.estadoTransitado;
    }

  /**
   * <p>
   * Estado al que se ha transitado. Es null.
   * </p>
   *  @param estadoTransitado  Estado al que se ha transitado. Es null. 
   */
    public void setEstadoTransitado(es.pode.publicacion.negocio.dominio.Estado estadoTransitado)
    {
        this.estadoTransitado = estadoTransitado;
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