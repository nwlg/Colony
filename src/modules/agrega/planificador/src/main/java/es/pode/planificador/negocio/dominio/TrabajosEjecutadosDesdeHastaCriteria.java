// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SearchCriteria.vsl in andromda-spring-cartridge.
//
package es.pode.planificador.negocio.dominio;

/**
 * 
 */
public class TrabajosEjecutadosDesdeHastaCriteria
    implements java.io.Serializable
{

  /**
   * Constructor por defecto
   */
    public TrabajosEjecutadosDesdeHastaCriteria()
    {
    }

    /**
     * Constructor taking all properties.
      * @param fechaDesde java.util.Calendar
      * @param fechaHasta java.util.Calendar
     */
    public TrabajosEjecutadosDesdeHastaCriteria(
        java.util.Calendar fechaDesde,
        java.util.Calendar fechaHasta)

    {
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    /**
     * Copies constructor from other TrabajosEjecutadosDesdeHastaCriteria
      * @param otherBean TrabajosEjecutadosDesdeHastaCriteria
     */
    public TrabajosEjecutadosDesdeHastaCriteria(TrabajosEjecutadosDesdeHastaCriteria otherBean)
    {
        if (otherBean != null)
        {
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

    private java.util.Calendar fechaDesde;

  /**
   * <p>
   * Fecha de inicio
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFechaDesde()
    {
        return this.fechaDesde;
    }

  /**
   * <p>
   * Fecha de inicio
   * </p>
   *  @param fechaDesde  Fecha de inicio 
   */
    public void setFechaDesde(java.util.Calendar fechaDesde)
    {
        this.fechaDesde = fechaDesde;
    }

    private java.util.Calendar fechaHasta;

  /**
   * <p>
   * Fecha fin
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFechaHasta()
    {
        return this.fechaHasta;
    }

  /**
   * <p>
   * Fecha fin
   * </p>
   *  @param fechaHasta  Fecha fin 
   */
    public void setFechaHasta(java.util.Calendar fechaHasta)
    {
        this.fechaHasta = fechaHasta;
    }

}