// license-header java merge-point
package es.pode.catalogacion.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService}.
 *
 * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService
 */
public class SrvCatalogacionAvanzadaServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService}
     */
    private final es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService getSrvCatalogacionAvanzadaService()
    {
        return es.pode.catalogacion.negocio.ServiceLocator.instance().getSrvCatalogacionAvanzadaService();
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#obtenerLomAvanzado(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO obtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
    {
        return getSrvCatalogacionAvanzadaService().obtenerLomAvanzado(identificador, usuario, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#generarMetadatos(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO generarMetadatos(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
    {
        return getSrvCatalogacionAvanzadaService().generarMetadatos(identificador, usuario, lomAvanzado, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#cargarObjLom(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public java.lang.String cargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
    {
        return getSrvCatalogacionAvanzadaService().cargarObjLom(identificador, usuario, lom);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#eliminarObjLoms(java.lang.String[])
     */
    public void eliminarObjLoms(java.lang.String[] ids)
    {
        getSrvCatalogacionAvanzadaService().eliminarObjLoms(ids);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#obtenerObjLoms(java.lang.String[])
     */
    public es.pode.catalogacion.negocio.servicios.IdLomVO[] obtenerObjLoms(java.lang.String[] ids)
    {
        return getSrvCatalogacionAvanzadaService().obtenerObjLoms(ids);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#exportarLomes(java.lang.String, java.lang.String, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO, java.lang.String)
     */
    public javax.activation.DataHandler exportarLomes(java.lang.String identificador, java.lang.String usuario, es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, java.lang.String idioma)
    {
        return getSrvCatalogacionAvanzadaService().exportarLomes(identificador, usuario, lomAvanzado, idioma);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#importarLomes(javax.activation.DataHandler)
     */
    public es.pode.catalogacion.negocio.servicios.LomAvanzadoVO importarLomes(javax.activation.DataHandler ficheroLomes)
    {
        return getSrvCatalogacionAvanzadaService().importarLomes(ficheroLomes);
    }

    /**
     * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService#exportarLomesDesdeLom(java.lang.String, java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public javax.activation.DataHandler exportarLomesDesdeLom(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma, javax.activation.DataHandler lom)
    {
        return getSrvCatalogacionAvanzadaService().exportarLomesDesdeLom(identificador, usuario, idioma, lom);
    }

}