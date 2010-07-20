// license-header java merge-point
package es.pode.buscar.negocio.monitorizar.servicio;

/**
 * Web service delegator for {@link es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService}.
 *
 * @see es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService
 */
public class SrvMonitorizarServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService}
     */
    private final es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService getSrvMonitorizarService()
    {
        return es.pode.buscar.negocio.ServiceLocator.instance().getSrvMonitorizarService();
    }

    /**
     * @see es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService#obtenerEstadoNodos()
     */
    public es.pode.buscar.negocio.monitorizar.dominio.EstadoNodoVO[] obtenerEstadoNodos()
    {
        return getSrvMonitorizarService().obtenerEstadoNodos();
    }

}