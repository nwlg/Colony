// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.entregar.negocio.servicios;

/**
 * 
 */
public class OrganizacionVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public OrganizacionVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param idOrg  
     * @param tituloOrg  
     * @param secuenciaOrg  
     * @param clicable  
     * @param idPadre  
     * @param items  
     */
    public OrganizacionVO(
        java.lang.String idOrg,
        java.lang.String tituloOrg,
        es.pode.entregar.negocio.servicios.SecuenciaVO secuenciaOrg,
        java.lang.Boolean clicable,
        java.lang.String idPadre,
        es.pode.entregar.negocio.servicios.ItemVO[] items)

    {
        this.idOrg = idOrg;
        this.tituloOrg = tituloOrg;
        this.secuenciaOrg = secuenciaOrg;
        this.clicable = clicable;
        this.idPadre = idPadre;
        this.items = items;
    }

    /**
     * Copies constructor from other OrganizacionVO
     * @param otherBean OrganizacionVO 
     */
    public OrganizacionVO(OrganizacionVO otherBean)
    {
        if (otherBean != null)
        {
            this.idOrg = otherBean.getIdOrg();
            this.tituloOrg = otherBean.getTituloOrg();
            this.secuenciaOrg = otherBean.getSecuenciaOrg();
            this.clicable = otherBean.getClicable();
            this.idPadre = otherBean.getIdPadre();
            this.items = otherBean.getItems();
        }
    }

    private java.lang.String idOrg;

    public java.lang.String getIdOrg()
    {
        return this.idOrg;
    }

    public void setIdOrg(java.lang.String idOrg)
    {
        this.idOrg = idOrg;
    }

    private java.lang.String tituloOrg;

    public java.lang.String getTituloOrg()
    {
        return this.tituloOrg;
    }

    public void setTituloOrg(java.lang.String tituloOrg)
    {
        this.tituloOrg = tituloOrg;
    }

    private es.pode.entregar.negocio.servicios.SecuenciaVO secuenciaOrg;

    public es.pode.entregar.negocio.servicios.SecuenciaVO getSecuenciaOrg()
    {
        return this.secuenciaOrg;
    }

    public void setSecuenciaOrg(es.pode.entregar.negocio.servicios.SecuenciaVO secuenciaOrg)
    {
        this.secuenciaOrg = secuenciaOrg;
    }

    private java.lang.Boolean clicable;

    public java.lang.Boolean getClicable()
    {
        return this.clicable;
    }

    public void setClicable(java.lang.Boolean clicable)
    {
        this.clicable = clicable;
    }

    private java.lang.String idPadre;

    public java.lang.String getIdPadre()
    {
        return this.idPadre;
    }

    public void setIdPadre(java.lang.String idPadre)
    {
        this.idPadre = idPadre;
    }

    /**
   * 
     */
    private es.pode.entregar.negocio.servicios.ItemVO[] items;

    public es.pode.entregar.negocio.servicios.ItemVO[] getItems()
    {
        return this.items;
    }

    public void setItems(es.pode.entregar.negocio.servicios.ItemVO[] items)
    {
        this.items = items;
    }

}