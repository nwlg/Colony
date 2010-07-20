// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateSearchConfiguration.vsl in andromda-spring-cartridge.
//
package es.pode.localizador.negocio;

import org.hibernate.LockMode;

/**
 * Contains configuration parameters for a <code>CriteriaSearch</code>.
 *
 * @author Stefan Reichert
 * @author Peter Friese
 */
public class CriteriaSearchConfiguration
{

    /**
     * Allows set the lockMode from the application
     * 
     */
    private LockMode lockMode;

    /**
     * Constructs a new CriteriaSearchConfiguration instance with all fields set to
     * either <code>null</code> or <code>false</code>.
     */
    public CriteriaSearchConfiguration()
    {
        this.forceEagerLoading = false;
        this.firstResult = null;
        this.fetchSize = null;
        this.maximumResultSize = null;
        this.lockMode = null;
    }

    /**
     * If a parameter refers to a childEntity and <code>forceEagerLoading</code> is
     * <code>true</code>, the childEntity is always loaded. If <code>forceEagerLoading</code> is
     * <code>false</code>, the loading depends on the persister-configuration of the parentEntity.
     */
    private boolean forceEagerLoading;

    /**
     * Returns whether or not eager loading is enabled.
     *
     * @return <code>true</code> if eager loading is enabled, <code>false</code> otherwise
     */
    public boolean isForceEagerLoading()
    {
        return forceEagerLoading;
    }

    /**
     * Sets whether or not eager loading is to be enabled.
     *
     * @param forceEagerLoading <code>true</code> if eager loading is to be enabled, <code>false</code> otherwise
     */
    public void setForceEagerLoading(boolean forceEagerLoading)
    {
        this.forceEagerLoading = forceEagerLoading;
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
     * If <code>maximumResultSize</code> is not <code>null</code> it limits the maximum size of
     * the resultList.
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
    
     /**
     * Sets the maxmimum size of the result.
     *
     * @lockMode lockMode use for the Criteria(FORCE,NONE,READ,UPGRADE,UPGRADE_NOWAIT,WRITE)
     */
     public void setLockMode(LockMode lockMode) {
		this.lockMode = lockMode;
     }   


     /**
     * Gets the LockMode of the criteria.
     *
     * @return the LockMode
     */
     public LockMode getLockMode() {
		return lockMode;
	}
}
