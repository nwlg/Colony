// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.publicacion.negocio.dominio;

/**
 * <p>
 * Este criterio de busqueda implementa la busqueda de toda la
 * actividad de los ODEs creados por un usuario en un periodo de
 * fechas dado.
 * </p>
 */
public class UsuarioActividadCriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public UsuarioActividadCriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param idUsuario java.lang.String
      * @param estadoActual es.pode.publicacion.negocio.dominio.Estado
      * @param fechaDesde java.util.Calendar
      * @param fechaHasta java.util.Calendar
     */
    public UsuarioActividadCriteria(
        java.lang.String idUsuario,
        es.pode.publicacion.negocio.dominio.Estado estadoActual,
        java.util.Calendar fechaDesde,
        java.util.Calendar fechaHasta)

    {
        this.idUsuario = idUsuario;
        this.estadoActual = estadoActual;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    /**
     * Copies constructor from other UsuarioActividadCriteria
      * @param otherBean UsuarioActividadCriteria
     */
    public UsuarioActividadCriteria(UsuarioActividadCriteria otherBean)
    {
        if (otherBean != null)
        {
            this.idUsuario = otherBean.getIdUsuario();
            this.estadoActual = otherBean.getEstadoActual();
            this.fechaDesde = otherBean.getFechaDesde();
            this.fechaHasta = otherBean.getFechaHasta();
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

    private java.lang.String idUsuario;

  /**
   * <p>
   * Identificador del usuario.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }

  /**
   * <p>
   * Identificador del usuario.
   * </p>
   *  @param idUsuario  Identificador del usuario. 
   */
    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoActual;

  /**
   * <p>
   * Estado actual del ODE.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoActual()
    {
        return this.estadoActual;
    }

  /**
   * <p>
   * Estado actual del ODE.
   * </p>
   *  @param estadoActual  Estado actual del ODE. 
   */
    public void setEstadoActual(es.pode.publicacion.negocio.dominio.Estado estadoActual)
    {
        this.estadoActual = estadoActual;
    }

    private java.util.Calendar fechaDesde;

  /**
   * <p>
   * Fecha desde del periodo de activiad en el que se esta
   * interesado.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFechaDesde()
    {
        return this.fechaDesde;
    }

  /**
   * <p>
   * Fecha desde del periodo de activiad en el que se esta
   * interesado.
   * </p>
   *  @param fechaDesde  Fecha desde del periodo de activiad en el que se esta interesado. 
   */
    public void setFechaDesde(java.util.Calendar fechaDesde)
    {
        this.fechaDesde = fechaDesde;
    }

    private java.util.Calendar fechaHasta;

  /**
   * <p>
   * Fecha hasta del periodo de actividad en el que se esta
   * interesado.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFechaHasta()
    {
        return this.fechaHasta;
    }

  /**
   * <p>
   * Fecha hasta del periodo de actividad en el que se esta
   * interesado.
   * </p>
   *  @param fechaHasta  Fecha hasta del periodo de actividad en el que se esta interesado. 
   */
    public void setFechaHasta(java.util.Calendar fechaHasta)
    {
        this.fechaHasta = fechaHasta;
    }

}