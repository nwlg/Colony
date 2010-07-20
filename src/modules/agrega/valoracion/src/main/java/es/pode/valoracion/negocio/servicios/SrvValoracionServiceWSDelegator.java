// license-header java merge-point
package es.pode.valoracion.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.valoracion.negocio.servicios.SrvValoracionService}.
 *
 * @see es.pode.valoracion.negocio.servicios.SrvValoracionService
 */
public class SrvValoracionServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.valoracion.negocio.servicios.SrvValoracionService}
     */
    private final es.pode.valoracion.negocio.servicios.SrvValoracionService getSrvValoracionService()
    {
        return es.pode.ServiceLocator.instance().getSrvValoracionService();
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#introducirComentario(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void introducirComentario(java.lang.String idODE, java.lang.String comentario, java.lang.String idiomaODE, java.lang.String usuario)
    {
        getSrvValoracionService().introducirComentario(idODE, comentario, idiomaODE, usuario);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#consultarValoracion(java.lang.String)
     */
    public java.lang.Float consultarValoracion(java.lang.String idODE)
    {
        return getSrvValoracionService().consultarValoracion(idODE);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#obtenerComentarios(java.lang.String)
     */
    public es.pode.valoracion.negocio.servicios.ComentarioVO[] obtenerComentarios(java.lang.String idODE)
    {
        return getSrvValoracionService().obtenerComentarios(idODE);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#eliminarComentarios(java.lang.Long[])
     */
    public java.lang.String eliminarComentarios(java.lang.Long[] id)
    {
        return getSrvValoracionService().eliminarComentarios(id);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#introducirValoracion(java.lang.Float, java.lang.String, java.lang.String, java.lang.String)
     */
    public void introducirValoracion(java.lang.Float valoracion, java.lang.String idODE, java.lang.String autor, java.lang.String idiomaODE)
    {
        getSrvValoracionService().introducirValoracion(valoracion, idODE, autor, idiomaODE);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#eliminarTodasValoraciones(java.lang.String)
     */
    public java.lang.String eliminarTodasValoraciones(java.lang.String idODE)
    {
        return getSrvValoracionService().eliminarTodasValoraciones(idODE);
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.SrvValoracionService#eliminarTodosComentarios(java.lang.String)
     */
    public java.lang.String eliminarTodosComentarios(java.lang.String idODE)
    {
        return getSrvValoracionService().eliminarTodosComentarios(idODE);
    }

}