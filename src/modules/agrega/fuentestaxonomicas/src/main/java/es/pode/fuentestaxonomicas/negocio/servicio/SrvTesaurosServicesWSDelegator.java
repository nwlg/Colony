// license-header java merge-point
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices}.
 *
 * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices
 */
public class SrvTesaurosServicesWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices}
     */
    private final es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices getSrvTesaurosServices()
    {
        return es.pode.fuentestaxonomicas.negocio.ServiceLocator.instance().getSrvTesaurosServices();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTerminosRelacionadosPorId(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionadosPorId(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerTerminosRelacionadosPorId(id, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerJerarquia(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO[] obtenerJerarquia(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerJerarquia(id, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerPrimerNivelTesauro(java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerPrimerNivelTesauro(java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerPrimerNivelTesauro(nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTerminosRelacionadosPorTexto(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionadosPorTexto(java.lang.String textoTesauro, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerTerminosRelacionadosPorTexto(textoTesauro, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTerminosRelacionAsociativa(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionAsociativa(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerTerminosRelacionAsociativa(id, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTerminosRelacionJerarquica(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionJerarquica(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerTerminosRelacionJerarquica(id, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerVocabName(java.lang.String, java.lang.String)
     */
    public java.lang.String obtenerVocabName(java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerVocabName(nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerVocabNames(java.lang.String[], java.lang.String)
     */
    public java.lang.String[] obtenerVocabNames(java.lang.String[] nomTesauros, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerVocabNames(nomTesauros, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTerminos(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO[] obtenerTerminos(java.lang.String texto, java.lang.String nomTesauro, java.lang.String idioma)
    {
        return getSrvTesaurosServices().obtenerTerminos(texto, nomTesauro, idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#chequearExistenciaIdioma(java.lang.String)
     */
    public boolean chequearExistenciaIdioma(java.lang.String idioma)
    {
        return getSrvTesaurosServices().chequearExistenciaIdioma(idioma);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices#obtenerTextosDeIds(java.lang.String[], java.lang.String, java.lang.String)
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTextosDeIds(java.lang.String[] ids, java.lang.String idioma, java.lang.String nomTesauro)
    {
        return getSrvTesaurosServices().obtenerTextosDeIds(ids, idioma, nomTesauro);
    }

}