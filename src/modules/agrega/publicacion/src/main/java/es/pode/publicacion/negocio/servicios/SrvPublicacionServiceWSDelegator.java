// license-header java merge-point
package es.pode.publicacion.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.publicacion.negocio.servicios.SrvPublicacionService}.
 *
 * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService
 */
public class SrvPublicacionServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.publicacion.negocio.servicios.SrvPublicacionService}
     */
    private final es.pode.publicacion.negocio.servicios.SrvPublicacionService getSrvPublicacionService()
    {
        return es.pode.publicacion.negocio.ServiceLocator.instance().getSrvPublicacionService();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenEstadoPorIdODE(java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.EstadoVO obtenEstadoPorIdODE(java.lang.String idODE, java.lang.String idioma)
        throws es.pode.publicacion.negocio.servicios.ObtenEstadoODEException
    {
        return getSrvPublicacionService().obtenEstadoPorIdODE(idODE, idioma);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenHistorialPorIdODE(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenHistorialPorIdODE(java.lang.String idODE)
        throws es.pode.publicacion.negocio.servicios.ObtenerHistoriaODEException
    {
        return getSrvPublicacionService().obtenHistorialPorIdODE(idODE);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#rechazar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO rechazar(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
    {
        return getSrvPublicacionService().rechazar(idODE, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#creacion(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO creacion(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
        throws es.pode.publicacion.negocio.servicios.CreacionException
    {
        return getSrvPublicacionService().creacion(idODE, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#publicar(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO publicar(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo, java.lang.String comunidades, java.lang.String tipoLicencia, java.lang.String universal)
        throws es.pode.publicacion.negocio.servicios.PublicarException
    {
        return getSrvPublicacionService().publicar(idODE, idUsuario, comentarios, titulo, comunidades, tipoLicencia, universal);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#publicarPIF(javax.activation.DataHandler, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO publicarPIF(javax.activation.DataHandler pif, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String sobrescribir, java.lang.String titulo)
        throws es.pode.publicacion.negocio.servicios.PublicarPIFException
    {
        return getSrvPublicacionService().publicarPIF(pif, idUsuario, comentarios, sobrescribir, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#noDisponible(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO noDisponible(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
    {
        return getSrvPublicacionService().noDisponible(idODE, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#proponerPublicacion(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO proponerPublicacion(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
    {
        return getSrvPublicacionService().proponerPublicacion(idODE, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPublicados()
     */
    public es.pode.publicacion.negocio.servicios.IdODEVO[] obtenODEsPublicados()
    {
        return getSrvPublicacionService().obtenODEsPublicados();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsCreadosPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsCreadosPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODEsCreadosPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPropuestosPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsPropuestosPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODEsPropuestosPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPublicadosPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsPublicadosPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODEsPublicadosPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#crearPIF(javax.activation.DataHandler, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO crearPIF(javax.activation.DataHandler ficheroPIF, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo, java.lang.String idioma)
    {
        return getSrvPublicacionService().crearPIF(ficheroPIF, idUsuario, comentarios, titulo, idioma);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsRechazadosPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsRechazadosPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODEsRechazadosPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#eliminar(java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO eliminar(java.lang.String idODEs, java.lang.String idUsuario)
    {
        return getSrvPublicacionService().eliminar(idODEs, idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#reindexarODEPublicado(java.lang.String, java.lang.Float)
     */
    public es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO reindexarODEPublicado(java.lang.String idODE, java.lang.Float valoracion)
    {
        return getSrvPublicacionService().reindexarODEPublicado(idODE, valoracion);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#reindexarODEsPublicados(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO[] reindexarODEsPublicados(java.lang.String[] idODEs)
    {
        return getSrvPublicacionService().reindexarODEsPublicados(idODEs);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#regeneraIndiceIdioma(es.pode.publicacion.negocio.servicios.RegeneracionIndiceVO)
     */
    public es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO[] regeneraIndiceIdioma(es.pode.publicacion.negocio.servicios.RegeneracionIndiceVO paramRegenera)
    {
        return getSrvPublicacionService().regeneraIndiceIdioma(paramRegenera);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPropuestos()
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsPropuestos()
    {
        return getSrvPublicacionService().obtenODEsPropuestos();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsDespublicados()
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsDespublicados()
    {
        return getSrvPublicacionService().obtenODEsDespublicados();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#publicarDespublicado(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO publicarDespublicado(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo, java.lang.String comunidades, java.lang.String tipoLicencia, java.lang.String universal)
    {
        return getSrvPublicacionService().publicarDespublicado(idODE, idUsuario, comentarios, titulo, comunidades, tipoLicencia, universal);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsDespublicadosPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsDespublicadosPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODEsDespublicadosPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#eliminarNoDisponibles(es.pode.publicacion.negocio.servicios.EliminarNoDisponiblesVO)
     */
    public es.pode.publicacion.negocio.servicios.EliminarResultadoVO[] eliminarNoDisponibles(es.pode.publicacion.negocio.servicios.EliminarNoDisponiblesVO parametro)
    {
        return getSrvPublicacionService().eliminarNoDisponibles(parametro);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#modificaODECreado(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO modificaODECreado(java.lang.String idODE, java.lang.String idUsuario, java.lang.String titulo, java.lang.String comentarios)
    {
        return getSrvPublicacionService().modificaODECreado(idODE, idUsuario, titulo, comentarios);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenLicenciaODE(java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.LicenciaVO obtenLicenciaODE(java.lang.String idODE, java.lang.String idioma)
    {
        return getSrvPublicacionService().obtenLicenciaODE(idODE, idioma);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODESPropuestosCatalogacion()
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODESPropuestosCatalogacion()
    {
        return getSrvPublicacionService().obtenODESPropuestosCatalogacion();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODESPropuestosCatalogacionPorUsuario(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODESPropuestosCatalogacionPorUsuario(java.lang.String idUsuario)
    {
        return getSrvPublicacionService().obtenODESPropuestosCatalogacionPorUsuario(idUsuario);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#proponerCatalogacion(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO proponerCatalogacion(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
    {
        return getSrvPublicacionService().proponerCatalogacion(idODE, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#crearPIFCatalogado(javax.activation.DataHandler, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO crearPIFCatalogado(javax.activation.DataHandler pif, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo)
    {
        return getSrvPublicacionService().crearPIFCatalogado(pif, idUsuario, comentarios, titulo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#crearPifConCuota(javax.activation.DataHandler, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO crearPifConCuota(javax.activation.DataHandler pif, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo, java.lang.String idioma)
    {
        return getSrvPublicacionService().crearPifConCuota(pif, idUsuario, comentarios, titulo, idioma);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPropuestosCatalogacionPorUsuarios(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsPropuestosCatalogacionPorUsuarios(java.lang.String[] idsUsuarios)
    {
        return getSrvPublicacionService().obtenODEsPropuestosCatalogacionPorUsuarios(idsUsuarios);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODESCompartidos()
     */
    public es.pode.publicacion.negocio.servicios.TransicionAutorVO[] obtenODESCompartidos()
    {
        return getSrvPublicacionService().obtenODESCompartidos();
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#descompartirODE(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO descompartirODE(java.lang.String idODE)
    {
        return getSrvPublicacionService().descompartirODE(idODE);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#compartirODE(java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO compartirODE(java.lang.String idODE)
    {
        return getSrvPublicacionService().compartirODE(idODE);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#crearDesdeURL(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.servicios.ResultadoOperacionVO crearDesdeURL(java.lang.String url, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String titulo, java.lang.String idioma, java.lang.String idiomaDestinatario, java.lang.String tipo)
    {
        return getSrvPublicacionService().crearDesdeURL(url, idUsuario, comentarios, titulo, idioma, idiomaDestinatario, tipo);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsPropuestosPorUsuarios(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsPropuestosPorUsuarios(java.lang.String[] ids)
    {
        return getSrvPublicacionService().obtenODEsPropuestosPorUsuarios(ids);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsCompartidosPorUsuarios(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.TransicionAutorVO[] obtenODEsCompartidosPorUsuarios(java.lang.String[] ids)
    {
        return getSrvPublicacionService().obtenODEsCompartidosPorUsuarios(ids);
    }

    /**
     * @see es.pode.publicacion.negocio.servicios.SrvPublicacionService#obtenODEsDespublicadosPorUsuarios(java.lang.String[])
     */
    public es.pode.publicacion.negocio.servicios.TransicionVO[] obtenODEsDespublicadosPorUsuarios(java.lang.String[] ids)
    {
        return getSrvPublicacionService().obtenODEsDespublicadosPorUsuarios(ids);
    }

}