// license-header java merge-point
package es.pode.publicacion.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService}.
 *
 * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService
 */
public class SrvAuditaPublicacionServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService}
     */
    private final es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService getSrvAuditaPublicacionService()
    {
        return es.pode.publicacion.negocio.ServiceLocator.instance().getSrvAuditaPublicacionService();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#actividadTransiciones(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO)
     */
    public es.pode.publicacion.negocio.servicios.ODEsEstadoVO[] actividadTransiciones(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO parametroAuditoria)
    {
        return getSrvAuditaPublicacionService().actividadTransiciones(parametroAuditoria);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#dimensionesODEsPublicados(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO)
     */
    public es.pode.publicacion.negocio.servicios.PesoODEVO[] dimensionesODEsPublicados(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO parametroAuditoria)
    {
        return getSrvAuditaPublicacionService().dimensionesODEsPublicados(parametroAuditoria);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#odesPorEstados(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO)
     */
    public es.pode.publicacion.negocio.servicios.ODEsEstadoVO[] odesPorEstados(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO parametroAuditoria)
    {
        return getSrvAuditaPublicacionService().odesPorEstados(parametroAuditoria);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#odesPorUsuario(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO)
     */
    public es.pode.publicacion.negocio.servicios.EstadoActividadVO[] odesPorUsuario(es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO parametroAuditoria)
    {
        return getSrvAuditaPublicacionService().odesPorUsuario(parametroAuditoria);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#titulosODEsPorID(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO[] titulosODEsPorID(java.lang.String[] idODEs)
    {
        return getSrvAuditaPublicacionService().titulosODEsPorID(idODEs);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#obtenerUltimosOdesPublicados(int)
     */
    public es.pode.publicacion.negocio.servicios.OdePublicadoVO[] obtenerUltimosOdesPublicados(int numeroOdes)
    {
        return getSrvAuditaPublicacionService().obtenerUltimosOdesPublicados(numeroOdes);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#odesPublicados()
     */
    public es.pode.publicacion.negocio.servicios.ODEsEstadoVO odesPublicados()
    {
        return getSrvAuditaPublicacionService().odesPublicados();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService#odesPublicadosPorIdioma()
     */
    public es.pode.publicacion.negocio.servicios.ODEsEstadoIdiomaVO[] odesPublicadosPorIdioma()
    {
        return getSrvAuditaPublicacionService().odesPublicadosPorIdioma();
    }

}