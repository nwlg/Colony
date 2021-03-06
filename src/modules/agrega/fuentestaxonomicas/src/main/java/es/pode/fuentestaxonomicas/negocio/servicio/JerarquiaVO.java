// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * 
 */
public class JerarquiaVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public JerarquiaVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param jerarquia  
     */
    public JerarquiaVO(
        es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] jerarquia)

    {
        this.jerarquia = jerarquia;
    }

    /**
     * Copies constructor from other JerarquiaVO
     * @param otherBean JerarquiaVO 
     */
    public JerarquiaVO(JerarquiaVO otherBean)
    {
        if (otherBean != null)
        {
            this.jerarquia = otherBean.getJerarquia();
        }
    }

    private es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] jerarquia;

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] getJerarquia()
    {
        return this.jerarquia;
    }

    public void setJerarquia(es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] jerarquia)
    {
        this.jerarquia = jerarquia;
    }

}