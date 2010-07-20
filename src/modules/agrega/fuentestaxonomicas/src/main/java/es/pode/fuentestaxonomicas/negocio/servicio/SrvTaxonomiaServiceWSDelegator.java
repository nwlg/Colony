// license-header java merge-point
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService}.
 *
 * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService
 */
public class SrvTaxonomiaServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService}
     */
    private final es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService getSrvTaxonomiaService()
    {
        return es.pode.fuentestaxonomicas.negocio.ServiceLocator.instance().getSrvTaxonomiaService();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerNodos(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerNodos(java.lang.String id, java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerNodos(id, nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerTaxonomia(java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTaxonomia(java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerTaxonomia(nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerTaxonPath(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTaxonPath(java.lang.String id, java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerTaxonPath(id, nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerTaxonomiaCompletaPreorden(java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonConRutaVO[] obtenerTaxonomiaCompletaPreorden(java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerTaxonomiaCompletaPreorden(nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerVariosTaxonPaths(java.lang.String[], java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonPathVO[] obtenerVariosTaxonPaths(java.lang.String[] ides, java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerVariosTaxonPaths(ides, nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerVocabName(java.lang.String, java.lang.String)
     */
    public java.lang.String obtenerVocabName(java.lang.String nomTaxonomia, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerVocabName(nomTaxonomia, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService#obtenerVocabNames(java.lang.String[], java.lang.String)
     */
    public java.lang.String[] obtenerVocabNames(java.lang.String[] nomTaxonomias, java.lang.String idioma)
    {
        return getSrvTaxonomiaService().obtenerVocabNames(nomTaxonomias, idioma);
    }

}