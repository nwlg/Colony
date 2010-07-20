// license-header java merge-point
package es.pode.buscar.negocio.nodosSQI.servicio;

/**
 * Web service delegator for {@link es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService}.
 *
 * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService
 */
public class SrvGestionSqiServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService}
     */
    private final es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService getSrvGestionSqiService()
    {
        return es.pode.buscar.negocio.ServiceLocator.instance().getSrvGestionSqiService();
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#altaNodoSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO)
     */
    public java.lang.Long altaNodoSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO nodoSQI)
    {
        return getSrvGestionSqiService().altaNodoSQI(nodoSQI);
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#bajaNodosSQI(java.lang.Long[])
     */
    public void bajaNodosSQI(java.lang.Long[] ids)
    {
        getSrvGestionSqiService().bajaNodosSQI(ids);
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#consultaNodosSQI(java.lang.Long[])
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] consultaNodosSQI(java.lang.Long[] ids)
    {
        return getSrvGestionSqiService().consultaNodosSQI(ids);
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#modificarNodoSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO)
     */
    public java.lang.Long modificarNodoSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO nodo)
    {
        return getSrvGestionSqiService().modificarNodoSQI(nodo);
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#listarNodosSQI()
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO[] listarNodosSQI()
    {
        return getSrvGestionSqiService().listarNodosSQI();
    }

    /**
     * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService#obtenerNodosSQI()
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] obtenerNodosSQI()
    {
        return getSrvGestionSqiService().obtenerNodosSQI();
    }

}