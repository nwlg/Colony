// license-header java merge-point
package es.pode.catalogacion.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService}.
 *
 * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService
 */
public class SrvCatalogacionBasicaServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService}
     */
    private final es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService getSrvCatalogacionBasicaService()
    {
        return es.pode.catalogacion.negocio.ServiceLocator.instance().getSrvCatalogacionBasicaService();
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#obtenerLomBasico(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO obtenerLomBasico(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
    {
        return getSrvCatalogacionBasicaService().obtenerLomBasico(identificador, usuario, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
    {
        return getSrvCatalogacionBasicaService().generarMetadatos(identificador, usuario, lomBasico, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#asociarTaxonomia(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.CBTaxonVO[], java.lang.String)
     */
    public void asociarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList, java.lang.String idioma)
    {
        getSrvCatalogacionBasicaService().asociarTaxonomia(identificador, nomTaxonomia, taxonList, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public java.lang.String cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
    {
        return getSrvCatalogacionBasicaService().cargarObjLom(identificador, usuario, lom);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarObjLoms(java.lang.String[])
     */
    public void eliminarObjLoms(java.lang.String[] ids)
    {
        getSrvCatalogacionBasicaService().eliminarObjLoms(ids);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#obtenerObjLoms(java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.IdLomVO[] obtenerObjLoms(java.lang.String[] ids)
    {
        return getSrvCatalogacionBasicaService().obtenerObjLoms(ids);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarTaxonomia(java.lang.String, java.lang.String, int)
     */
    public void eliminarTaxonomia(java.lang.String identificador, java.lang.String nomTaxonomia, int idArbol)
    {
        getSrvCatalogacionBasicaService().eliminarTaxonomia(identificador, nomTaxonomia, idArbol);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#asociarTaxonomiaEnLomBasico(java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, es.pode.catalogacion.negocio.servicios.CBTaxonVO[])
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO asociarTaxonomiaEnLomBasico(java.lang.String identificador, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, es.pode.catalogacion.negocio.servicios.CBTaxonVO[] taxonList)
    {
        return getSrvCatalogacionBasicaService().asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO eliminarTaxonomiasEnLomBasico(es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String[] idArbol)
    {
        return getSrvCatalogacionBasicaService().eliminarTaxonomiasEnLomBasico(lomBasico, idArbol);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomBasicoVO, java.lang.String)
     */
    public javax.activation.DataHandler exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomBasicoVO lomBasico, java.lang.String idioma)
    {
        return getSrvCatalogacionBasicaService().exportarLomes(identificador, usuario, lomBasico, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService#importarLomes(javax.activation.DataHandler, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomBasicoVO importarLomes(javax.activation.DataHandler ficheroLomes, java.lang.String idioma)
    {
        return getSrvCatalogacionBasicaService().importarLomes(ficheroLomes, idioma);
    }

}