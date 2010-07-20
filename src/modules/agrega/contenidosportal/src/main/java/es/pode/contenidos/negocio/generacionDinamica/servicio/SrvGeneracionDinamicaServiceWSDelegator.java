// license-header java merge-point
package es.pode.contenidos.negocio.generacionDinamica.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService}.
 *
 * @see es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService
 */
public class SrvGeneracionDinamicaServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService}
     */
    private final es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService getSrvGeneracionDinamicaService()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvGeneracionDinamicaService();
    }

    /**
     * @see es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService#obtenODEDiario(java.util.Date)
     */
    public es.pode.contenidos.negocio.generacionDinamica.servicio.ContenidoODEVO obtenODEDiario(java.util.Date fecha)
    {
        return getSrvGeneracionDinamicaService().obtenODEDiario(fecha);
    }

    /**
     * @see es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService#generaODEDiario()
     */
    public void generaODEDiario()
    {
        getSrvGeneracionDinamicaService().generaODEDiario();
    }

}