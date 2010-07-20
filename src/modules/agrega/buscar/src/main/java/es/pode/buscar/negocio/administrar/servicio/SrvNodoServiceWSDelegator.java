// license-header java merge-point
package es.pode.buscar.negocio.administrar.servicio;

/**
 * Web service delegator for {@link es.pode.buscar.negocio.administrar.servicio.SrvNodoService}.
 *
 * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService
 */
public class SrvNodoServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.buscar.negocio.administrar.servicio.SrvNodoService}
     */
    private final es.pode.buscar.negocio.administrar.servicio.SrvNodoService getSrvNodoService()
    {
        return es.pode.buscar.negocio.ServiceLocator.instance().getSrvNodoService();
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#eliminarNodo(java.lang.Long[])
     */
    public es.pode.buscar.negocio.administrar.servicio.ValidaBajaNodoVO eliminarNodo(java.lang.Long[] ids)
    {
        return getSrvNodoService().eliminarNodo(ids);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#listarNodos()
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO[] listarNodos()
    {
        return getSrvNodoService().listarNodos();
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#crearNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO)
     */
    public java.lang.Integer crearNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO nodo)
    {
        return getSrvNodoService().crearNodo(nodo);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#modificarNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO)
     */
    public java.lang.Integer modificarNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO nodo)
    {
        return getSrvNodoService().modificarNodo(nodo);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#obtenerNodo(java.lang.Long)
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO obtenerNodo(java.lang.Long id)
    {
        return getSrvNodoService().obtenerNodo(id);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#obtenerCCAA(java.lang.Long)
     */
    public es.pode.buscar.negocio.administrar.servicio.CcaaVO obtenerCCAA(java.lang.Long id)
    {
        return getSrvNodoService().obtenerCCAA(id);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#obtenerCCAAs()
     */
    public es.pode.buscar.negocio.administrar.servicio.CcaaVO[] obtenerCCAAs()
    {
        return getSrvNodoService().obtenerCCAAs();
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#obtenerServicio(java.lang.Long)
     */
    public es.pode.buscar.negocio.administrar.servicio.ServicioVO obtenerServicio(java.lang.Long id)
    {
        return getSrvNodoService().obtenerServicio(id);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#obtenerServicios()
     */
    public es.pode.buscar.negocio.administrar.servicio.ServicioVO[] obtenerServicios()
    {
        return getSrvNodoService().obtenerServicios();
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#estaDadoAlta(java.lang.String, java.lang.String)
     */
    public java.lang.Boolean estaDadoAlta(java.lang.String url, java.lang.String urlWS)
    {
        return getSrvNodoService().estaDadoAlta(url, urlWS);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService#existeNombreNodo(java.lang.String)
     */
    public java.lang.Boolean existeNombreNodo(java.lang.String nombreNodo)
    {
        return getSrvNodoService().existeNombreNodo(nombreNodo);
    }

}