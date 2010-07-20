// license-header java merge-point
package es.pode.empaquetador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.empaquetador.negocio.servicio.SrvGestorManifestService}.
 *
 * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService
 */
public class SrvGestorManifestServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.empaquetador.negocio.servicio.SrvGestorManifestService}
     */
    private final es.pode.empaquetador.negocio.servicio.SrvGestorManifestService getSrvGestorManifestService()
    {
        return es.pode.empaquetador.negocio.ServiceLocator.instance().getSrvGestorManifestService();
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#cargarManifest(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO cargarManifest(java.lang.String identificador)
    {
        return getSrvGestorManifestService().cargarManifest(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#descargarManifest(java.lang.String)
     */
    public java.lang.Boolean descargarManifest(java.lang.String identificador)
    {
        return getSrvGestorManifestService().descargarManifest(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#crearGrupo(java.lang.String, es.pode.empaquetador.negocio.servicio.GrupoVO, java.lang.String)
     */
    public java.lang.String crearGrupo(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.GrupoVO grupoVO, java.lang.String identificadorPadre)
    {
        return getSrvGestorManifestService().crearGrupo(identificador, grupoVO, identificadorPadre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#modificarGrupo(java.lang.String, es.pode.empaquetador.negocio.servicio.GrupoVO)
     */
    public java.lang.String modificarGrupo(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.GrupoVO grupoVO)
    {
        return getSrvGestorManifestService().modificarGrupo(identificador, grupoVO);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#eliminarGrupo(java.lang.String, java.lang.String)
     */
    public java.lang.String eliminarGrupo(java.lang.String identificador, java.lang.String identificadorGrupo)
    {
        return getSrvGestorManifestService().eliminarGrupo(identificador, identificadorGrupo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#vincularGrupo(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String vincularGrupo(java.lang.String identificador, java.lang.String identificadorGrupo, java.lang.String identificadorRecurso)
    {
        return getSrvGestorManifestService().vincularGrupo(identificador, identificadorGrupo, identificadorRecurso);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#desvincularGrupo(java.lang.String, java.lang.String)
     */
    public java.lang.String desvincularGrupo(java.lang.String identificador, java.lang.String identificadorGrupo)
    {
        return getSrvGestorManifestService().desvincularGrupo(identificador, identificadorGrupo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#guardarManifiesto(java.lang.String)
     */
    public void guardarManifiesto(java.lang.String identificador)
    {
        getSrvGestorManifestService().guardarManifiesto(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#crearOrganizacion(java.lang.String, es.pode.empaquetador.negocio.servicio.OrganizacionVO)
     */
    public java.lang.String crearOrganizacion(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
    {
        return getSrvGestorManifestService().crearOrganizacion(identificador, organizacion);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#eliminarOrganizacion(java.lang.String, java.lang.String)
     */
    public java.lang.String eliminarOrganizacion(java.lang.String identificador, java.lang.String idOrganizacion)
    {
        return getSrvGestorManifestService().eliminarOrganizacion(identificador, idOrganizacion);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#modificarOrganizacion(java.lang.String, es.pode.empaquetador.negocio.servicio.OrganizacionVO)
     */
    public java.lang.String modificarOrganizacion(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
    {
        return getSrvGestorManifestService().modificarOrganizacion(identificador, organizacion);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#fijarOrganizacionPorDefecto(java.lang.String, java.lang.String)
     */
    public java.lang.String fijarOrganizacionPorDefecto(java.lang.String identificador, java.lang.String idOrganizacion)
    {
        return getSrvGestorManifestService().fijarOrganizacionPorDefecto(identificador, idOrganizacion);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#agregarManifiestoZIP(java.lang.String, javax.activation.DataHandler, java.lang.String)
     */
    public java.lang.String agregarManifiestoZIP(java.lang.String identificador, javax.activation.DataHandler paqueteSCORM, java.lang.String submanifestId)
    {
        return getSrvGestorManifestService().agregarManifiestoZIP(identificador, paqueteSCORM, submanifestId);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#agregarManifiestoRepositorio(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String agregarManifiestoRepositorio(java.lang.String identificador, java.lang.String localizador, java.lang.String submanifestId)
    {
        return getSrvGestorManifestService().agregarManifiestoRepositorio(identificador, localizador, submanifestId);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#desagregarSubmanifiestoLocal(java.lang.String, java.lang.String, java.lang.String)
     */
    public javax.activation.DataHandler desagregarSubmanifiestoLocal(java.lang.String identificador, java.lang.String submanifiesto, java.lang.String submanifestId)
    {
        return getSrvGestorManifestService().desagregarSubmanifiestoLocal(identificador, submanifiesto, submanifestId);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#eliminarSubmanifiesto(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String eliminarSubmanifiesto(java.lang.String identificador, java.lang.String submanifiestoId, java.lang.String idSubmanifestPadre)
    {
        return getSrvGestorManifestService().eliminarSubmanifiesto(identificador, submanifiestoId, idSubmanifestPadre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#desagregarSubmanifiestoRepositorio(java.lang.String, java.lang.String, java.lang.String)
     */
    public void desagregarSubmanifiestoRepositorio(java.lang.String identificador, java.lang.String submanifiestoId, java.lang.String submanifestId)
    {
        getSrvGestorManifestService().desagregarSubmanifiestoRepositorio(identificador, submanifiestoId, submanifestId);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#iniciarNuevoODE(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO iniciarNuevoODE(java.lang.String user, java.lang.String titulo, java.lang.String idioma)
    {
        return getSrvGestorManifestService().iniciarNuevoODE(user, titulo, idioma);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#editarODE(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO editarODE(java.lang.String identificador)
    {
        return getSrvGestorManifestService().editarODE(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#terminarEdicion(java.lang.String)
     */
    public void terminarEdicion(java.lang.String identificador)
    {
        getSrvGestorManifestService().terminarEdicion(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#crearRecurso(java.lang.String, es.pode.empaquetador.negocio.servicio.RecursoVO)
     */
    public java.lang.String crearRecurso(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.RecursoVO recurso)
    {
        return getSrvGestorManifestService().crearRecurso(identificador, recurso);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#eliminarRecursos(java.lang.String, java.lang.String[])
     */
    public void eliminarRecursos(java.lang.String identificador, java.lang.String[] recursos)
    {
        getSrvGestorManifestService().eliminarRecursos(identificador, recursos);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#modificarRecurso(java.lang.String, es.pode.empaquetador.negocio.servicio.RecursoVO)
     */
    public java.lang.String modificarRecurso(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.RecursoVO recurso)
    {
        return getSrvGestorManifestService().modificarRecurso(identificador, recurso);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#asociarLom(java.lang.String, java.lang.String, java.lang.String)
     */
    public void asociarLom(java.lang.String identificador, java.lang.String idElemento, java.lang.String href)
    {
        getSrvGestorManifestService().asociarLom(identificador, idElemento, href);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#prepararCatalogacion(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String prepararCatalogacion(java.lang.String identificador, java.lang.String idElemento, java.lang.String href)
    {
        return getSrvGestorManifestService().prepararCatalogacion(identificador, idElemento, href);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#subirItem(java.lang.String, java.lang.String)
     */
    public java.lang.String subirItem(java.lang.String identificador, java.lang.String idItem)
    {
        return getSrvGestorManifestService().subirItem(identificador, idItem);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#bajarItem(java.lang.String, java.lang.String)
     */
    public java.lang.String bajarItem(java.lang.String identificador, java.lang.String idItem)
    {
        return getSrvGestorManifestService().bajarItem(identificador, idItem);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#subirOrganization(java.lang.String, java.lang.String)
     */
    public java.lang.String subirOrganization(java.lang.String identificador, java.lang.String idOrganization)
    {
        return getSrvGestorManifestService().subirOrganization(identificador, idOrganization);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#bajarOrganization(java.lang.String, java.lang.String)
     */
    public java.lang.String bajarOrganization(java.lang.String identificador, java.lang.String idOrganization)
    {
        return getSrvGestorManifestService().bajarOrganization(identificador, idOrganization);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#copiarElementos(java.lang.String, java.lang.String[], java.lang.String)
     */
    public void copiarElementos(java.lang.String identificador, java.lang.String[] elementos, java.lang.String destino)
    {
        getSrvGestorManifestService().copiarElementos(identificador, elementos, destino);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#moverElementos(java.lang.String, java.lang.String[], java.lang.String)
     */
    public void moverElementos(java.lang.String identificador, java.lang.String[] elementos, java.lang.String destino)
    {
        getSrvGestorManifestService().moverElementos(identificador, elementos, destino);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#asociarSecuencia(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.ControlModeVO)
     */
    public java.lang.String asociarSecuencia(java.lang.String identificador, java.lang.String idElemento, es.pode.empaquetador.negocio.servicio.ControlModeVO controlMode)
    {
        return getSrvGestorManifestService().asociarSecuencia(identificador, idElemento, controlMode);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#crearReferenciaEnCache(java.lang.String, java.lang.String)
     */
    public java.lang.Boolean crearReferenciaEnCache(java.lang.String identificador, java.lang.String idElemento)
    {
        return getSrvGestorManifestService().crearReferenciaEnCache(identificador, idElemento);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#importarRecursos(java.lang.String, javax.activation.DataHandler, java.lang.String)
     */
    public void importarRecursos(java.lang.String identificador, javax.activation.DataHandler paqueteRCP, java.lang.String submanifestId)
    {
        getSrvGestorManifestService().importarRecursos(identificador, paqueteRCP, submanifestId);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#exportarRecursos(java.lang.String, java.lang.String[], java.lang.String, java.lang.String)
     */
    public javax.activation.DataHandler exportarRecursos(java.lang.String identificador, java.lang.String[] recursos, java.lang.String submanifestId, java.lang.String nombre)
    {
        return getSrvGestorManifestService().exportarRecursos(identificador, recursos, submanifestId, nombre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#validar(java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.ValidaVO validar(java.lang.String identificador, java.lang.String tipo)
    {
        return getSrvGestorManifestService().validar(identificador, tipo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#previsualizarOde(java.lang.String)
     */
    public java.lang.String previsualizarOde(java.lang.String identificador)
    {
        return getSrvGestorManifestService().previsualizarOde(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#obtenerObjetosPersonales(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.TransicionVO[] obtenerObjetosPersonales(java.lang.String user)
    {
        return getSrvGestorManifestService().obtenerObjetosPersonales(user);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#eliminarODE(java.lang.String)
     */
    public void eliminarODE(java.lang.String identificador)
    {
        getSrvGestorManifestService().eliminarODE(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#generarMetadatoInicial(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO generarMetadatoInicial(java.lang.String titulo, java.lang.String idioma, java.lang.String identificador)
    {
        return getSrvGestorManifestService().generarMetadatoInicial(titulo, idioma, identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#asociarDatosItem(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.TimeLimitActionVO, es.pode.empaquetador.negocio.servicio.DataFromLMSVO, es.pode.empaquetador.negocio.servicio.CompletionThresholdVO, es.pode.empaquetador.negocio.servicio.PresentationVO)
     */
    public void asociarDatosItem(java.lang.String identificador, java.lang.String idElemento, es.pode.empaquetador.negocio.servicio.TimeLimitActionVO timeLimitAction, es.pode.empaquetador.negocio.servicio.DataFromLMSVO dataFromLMS, es.pode.empaquetador.negocio.servicio.CompletionThresholdVO completionThreshold, es.pode.empaquetador.negocio.servicio.PresentationVO presentation)
    {
        getSrvGestorManifestService().asociarDatosItem(identificador, idElemento, timeLimitAction, dataFromLMS, completionThreshold, presentation);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#obtenerObjetosCompartidos()
     */
    public es.pode.empaquetador.negocio.servicio.TransicionVO[] obtenerObjetosCompartidos()
    {
        return getSrvGestorManifestService().obtenerObjetosCompartidos();
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorManifestService#agregarManifiestoZipUrl(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String agregarManifiestoZipUrl(java.lang.String identificador, java.lang.String fichero, java.lang.String submanifestId)
    {
        return getSrvGestorManifestService().agregarManifiestoZipUrl(identificador, fichero, submanifestId);
    }

}