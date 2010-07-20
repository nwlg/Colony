// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.publicacion.negocio.dominio;

/**
 * <p>
 * Este criterio implementa la busqueda del estado final de un ODE
 * dentro de su diagrama de transiciones para un identificador de
 * ODE dado.
 * </p>
 */
public class IdODECriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public IdODECriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param idODE java.lang.String
      * @param estadoTransitado es.pode.publicacion.negocio.dominio.Estado
     */
    public IdODECriteria(
        java.lang.String idODE,
        es.pode.publicacion.negocio.dominio.Estado estadoTransitado)

    {
        this.idODE = idODE;
        this.estadoTransitado = estadoTransitado;
    }

    /**
     * Copies constructor from other IdODECriteria
      * @param otherBean IdODECriteria
     */
    public IdODECriteria(IdODECriteria otherBean)
    {
        if (otherBean != null)
        {
            this.idODE = otherBean.getIdODE();
            this.estadoTransitado = otherBean.getEstadoTransitado();
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

    private java.lang.String idODE;

  /**
   * <p>
   * Identificador del ODE del que queremos obtener el ultimo estado.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

  /**
   * <p>
   * Identificador del ODE del que queremos obtener el ultimo estado.
   * </p>
   *  @param idODE  Identificador del ODE del que queremos obtener el ultimo estado. 
   */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private es.pode.publicacion.negocio.dominio.Estado estadoTransitado;

  /**
   * <p>
   * Estado al que transita la transicion. En este caso null. La
   * transicion con el esado transitado vacio identifica el estado
   * actual.
   * </p>
   * @return es.pode.publicacion.negocio.dominio.Estado
   */
    public es.pode.publicacion.negocio.dominio.Estado getEstadoTransitado()
    {
        return this.estadoTransitado;
    }

  /**
   * <p>
   * Estado al que transita la transicion. En este caso null. La
   * transicion con el esado transitado vacio identifica el estado
   * actual.
   * </p>
   *  @param estadoTransitado  Estado al que transita la transicion. En este caso null. La transicion con el esado transitado vacio identifica el estado actual. 
   */
    public void setEstadoTransitado(es.pode.publicacion.negocio.dominio.Estado estadoTransitado)
    {
        this.estadoTransitado = estadoTransitado;
    }

}