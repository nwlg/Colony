// license-header java merge-point
package es.pode.indexador.negocio.servicios.indexado;

/**
 * Web service delegator for {@link es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService}.
 *
 * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService
 */
public class SrvIndexadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService}
     */
    private final es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService getSrvIndexadorService()
    {
        return es.pode.indexador.ServiceLocator.instance().getSrvIndexadorService();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService#indexarODE(es.pode.indexador.negocio.servicios.indexado.IdODEVO[])
     */
    public es.pode.indexador.negocio.servicios.indexado.IndexadorVO[] indexarODE(es.pode.indexador.negocio.servicios.indexado.IdODEVO[] localizador)
        throws es.pode.indexador.negocio.servicios.indexado.IndexaODEException
    {
        return getSrvIndexadorService().indexarODE(localizador);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService#reindexarODE(es.pode.indexador.negocio.servicios.indexado.IdODEVO[])
     */
    public es.pode.indexador.negocio.servicios.indexado.IndexadorVO[] reindexarODE(es.pode.indexador.negocio.servicios.indexado.IdODEVO[] localizador)
        throws es.pode.indexador.negocio.servicios.indexado.ReindexaODEException
    {
        return getSrvIndexadorService().reindexarODE(localizador);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService#eliminarODE(java.lang.String[])
     */
    public es.pode.indexador.negocio.servicios.indexado.IndexadorVO[] eliminarODE(java.lang.String[] idODE)
        throws es.pode.indexador.negocio.servicios.indexado.EliminaODEException
    {
        return getSrvIndexadorService().eliminarODE(idODE);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService#regenerarIndice(java.lang.String, es.pode.indexador.negocio.servicios.indexado.IdODEVO[])
     */
    public es.pode.indexador.negocio.servicios.indexado.IndexadorVO[] regenerarIndice(java.lang.String idioma, es.pode.indexador.negocio.servicios.indexado.IdODEVO[] odes)
        throws es.pode.indexador.negocio.servicios.indexado.IndexacionTotalException
    {
        return getSrvIndexadorService().regenerarIndice(idioma, odes);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.indexado.SrvIndexadorService#regenerarIndices(java.lang.Long, es.pode.indexador.negocio.servicios.indexado.IdODEVO[])
     */
    public es.pode.indexador.negocio.servicios.indexado.IndexadorVO[] regenerarIndices(java.lang.Long idTarea, es.pode.indexador.negocio.servicios.indexado.IdODEVO[] odes)
        throws es.pode.indexador.negocio.servicios.indexado.ReindexadoException
    {
        return getSrvIndexadorService().regenerarIndices(idTarea, odes);
    }

}