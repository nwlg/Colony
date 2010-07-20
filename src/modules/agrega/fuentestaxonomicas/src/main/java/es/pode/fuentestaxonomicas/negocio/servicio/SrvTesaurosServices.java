// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringService.vsl in andromda-spring-cartridge.
//
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * 
 */
public interface SrvTesaurosServices
{
    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionadosPorId(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO[] obtenerJerarquia(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerPrimerNivelTesauro(java.lang.String nomTesauro, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionadosPorTexto(java.lang.String textoTesauro, java.lang.String nomTesauro, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionAsociativa(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTerminosRelacionJerarquica(java.lang.String id, java.lang.String nomTesauro, java.lang.String idioma);

    public void recargar();

    public java.lang.String obtenerVocabName(java.lang.String nomTesauro, java.lang.String idioma);

    public java.lang.String[] obtenerVocabNames(java.lang.String[] nomTesauros, java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.JerarquiaVO[] obtenerTerminos(java.lang.String texto, java.lang.String nomTesauro, java.lang.String idioma);

    public boolean chequearExistenciaIdioma(java.lang.String idioma);

    public es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO[] obtenerTextosDeIds(java.lang.String[] ids, java.lang.String idioma, java.lang.String nomTesauro);

}
