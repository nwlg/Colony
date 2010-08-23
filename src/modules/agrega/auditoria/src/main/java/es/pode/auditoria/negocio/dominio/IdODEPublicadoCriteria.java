// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.auditoria.negocio.dominio;

/**
 * 
 */
public class IdODEPublicadoCriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public IdODEPublicadoCriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param idODE java.lang.String
     */
    public IdODEPublicadoCriteria(
        java.lang.String idODE)

    {
        this.idODE = idODE;
    }

    /**
     * Copies constructor from other IdODEPublicadoCriteria
      * @param otherBean IdODEPublicadoCriteria
     */
    public IdODEPublicadoCriteria(IdODEPublicadoCriteria otherBean)
    {
        if (otherBean != null)
        {
            this.idODE = otherBean.getIdODE();
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
   * Identificador del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

  /**
   * <p>
   * Identificador del ODE.
   * </p>
   *  @param idODE  Identificador del ODE. 
   */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

}