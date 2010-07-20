// license-header java merge-point
package es.pode.planificador.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.planificador.negocio.servicios.SrvPlanificadorService}.
 *
 * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService
 */
public class SrvPlanificadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.planificador.negocio.servicios.SrvPlanificadorService}
     */
    private final es.pode.planificador.negocio.servicios.SrvPlanificadorService getSrvPlanificadorService()
    {
        return es.pode.ServiceLocator.instance().getSrvPlanificadorService();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareaModificarCargaODEs(es.pode.planificador.negocio.servicios.TareaVO)
     */
    public es.pode.planificador.negocio.servicios.TareaCargaODEsVO obtenerTareaModificarCargaODEs(es.pode.planificador.negocio.servicios.TareaVO tarea)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().obtenerTareaModificarCargaODEs(tarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareaReindexado(es.pode.planificador.negocio.servicios.TareaVO)
     */
    public es.pode.planificador.negocio.servicios.TareaReindexadoVO obtenerTareaReindexado(es.pode.planificador.negocio.servicios.TareaVO tarea)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().obtenerTareaReindexado(tarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaCargaODEs(es.pode.planificador.negocio.servicios.TareaCargaODEsVO)
     */
    public es.pode.planificador.negocio.servicios.TareaCargaODEsVO crearTareaCargaODEs(es.pode.planificador.negocio.servicios.TareaCargaODEsVO datosTarea)
        throws es.pode.planificador.negocio.servicios.CrearTareaException
    {
        return getSrvPlanificadorService().crearTareaCargaODEs(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaReindexado(es.pode.planificador.negocio.servicios.TareaReindexadoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaReindexadoVO crearTareaReindexado(es.pode.planificador.negocio.servicios.TareaReindexadoVO datosTarea)
        throws es.pode.planificador.negocio.servicios.CrearTareaException
    {
        return getSrvPlanificadorService().crearTareaReindexado(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerInformeTrabajo(java.lang.Long)
     */
    public es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO[] obtenerInformeTrabajo(java.lang.Long idTarea)
        throws es.pode.planificador.negocio.servicios.ObtenerInformeException
    {
        return getSrvPlanificadorService().obtenerInformeTrabajo(idTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerInformeTrabajoErroneos(java.lang.Long)
     */
    public es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO[] obtenerInformeTrabajoErroneos(java.lang.Long id)
        throws es.pode.planificador.negocio.servicios.ObtenerInformeException
    {
        return getSrvPlanificadorService().obtenerInformeTrabajoErroneos(id);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#eliminarTrabajoEjecutado(java.lang.Long[])
     */
    public java.lang.Boolean eliminarTrabajoEjecutado(java.lang.Long[] idTrabajo)
        throws es.pode.planificador.negocio.servicios.EliminarTrabajoEjecException
    {
        return getSrvPlanificadorService().eliminarTrabajoEjecutado(idTrabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTrabajoEjecutado(java.lang.Long)
     */
    public es.pode.planificador.negocio.servicios.TareaEjecutadaVO obtenerTrabajoEjecutado(java.lang.Long id)
    {
        return getSrvPlanificadorService().obtenerTrabajoEjecutado(id);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTrabajosEjecutados()
     */
    public es.pode.planificador.negocio.servicios.TareaEjecutadaVO[] obtenerTrabajosEjecutados()
    {
        return getSrvPlanificadorService().obtenerTrabajosEjecutados();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTrabajosEjecutadosDesdeHasta(es.pode.planificador.negocio.servicios.ParametrosVO)
     */
    public es.pode.planificador.negocio.servicios.TareaEjecutadaVO[] obtenerTrabajosEjecutadosDesdeHasta(es.pode.planificador.negocio.servicios.ParametrosVO fechas)
    {
        return getSrvPlanificadorService().obtenerTrabajosEjecutadosDesdeHasta(fechas);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#eliminarTareas(es.pode.planificador.negocio.servicios.TrabajoVO[])
     */
    public java.lang.Boolean eliminarTareas(es.pode.planificador.negocio.servicios.TrabajoVO[] tareas)
        throws es.pode.planificador.negocio.servicios.EliminarTareaException
    {
        return getSrvPlanificadorService().eliminarTareas(tareas);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#eliminarTareasAdm(es.pode.planificador.negocio.servicios.TrabajoVO[])
     */
    public java.lang.Boolean eliminarTareasAdm(es.pode.planificador.negocio.servicios.TrabajoVO[] trabajo)
        throws es.pode.planificador.negocio.servicios.EliminarTareaException
    {
        return getSrvPlanificadorService().eliminarTareasAdm(trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareasPendientesTodas()
     */
    public es.pode.planificador.negocio.servicios.TareaVO[] obtenerTareasPendientesTodas()
    {
        return getSrvPlanificadorService().obtenerTareasPendientesTodas();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#lanzarTarea(es.pode.planificador.negocio.servicios.TareaVO)
     */
    public java.lang.Boolean lanzarTarea(es.pode.planificador.negocio.servicios.TareaVO tarea)
        throws es.pode.planificador.negocio.servicios.LanzarTrabajoException
    {
        return getSrvPlanificadorService().lanzarTarea(tarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareasEnEjecucion()
     */
    public es.pode.planificador.negocio.servicios.TareaVO[] obtenerTareasEnEjecucion()
    {
        return getSrvPlanificadorService().obtenerTareasEnEjecucion();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareasPendientes()
     */
    public es.pode.planificador.negocio.servicios.TareaVO[] obtenerTareasPendientes()
    {
        return getSrvPlanificadorService().obtenerTareasPendientes();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#pararTarea(es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public java.lang.Boolean pararTarea(es.pode.planificador.negocio.servicios.TrabajoVO job)
        throws es.pode.planificador.negocio.servicios.PararTrabajoException
    {
        return getSrvPlanificadorService().pararTarea(job);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#reiniciarPlanificador()
     */
    public java.lang.Boolean reiniciarPlanificador()
    {
        return getSrvPlanificadorService().reiniciarPlanificador();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#iniciarPlanificador()
     */
    public java.lang.Boolean iniciarPlanificador()
        throws es.pode.planificador.negocio.servicios.IniciarPlanificadorException
    {
        return getSrvPlanificadorService().iniciarPlanificador();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#pararPlanificador()
     */
    public java.lang.Boolean pararPlanificador()
        throws es.pode.planificador.negocio.servicios.PararPlanificadorException
    {
        return getSrvPlanificadorService().pararPlanificador();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#estaIniciado()
     */
    public java.lang.Boolean estaIniciado()
    {
        return getSrvPlanificadorService().estaIniciado();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#publicarPIF(javax.activation.DataHandler, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.String publicarPIF(javax.activation.DataHandler pif, java.lang.String idUsuario, java.lang.String comentarios, java.lang.String sobrescribir, java.lang.String titulo)
    {
        return getSrvPlanificadorService().publicarPIF(pif, idUsuario, comentarios, sobrescribir, titulo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#reindexado(java.lang.String, java.lang.Long)
     */
    public java.lang.Long reindexado(java.lang.String repositorio, java.lang.Long idTarea)
        throws es.pode.planificador.negocio.servicios.ReindexadoException
    {
        return getSrvPlanificadorService().reindexado(repositorio, idTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTipoTarea(es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public java.lang.String obtenerTipoTarea(es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
        throws es.pode.planificador.negocio.servicios.TipoTareaException
    {
        return getSrvPlanificadorService().obtenerTipoTarea(trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#existeTrabajo(es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public java.lang.Boolean existeTrabajo(es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
    {
        return getSrvPlanificadorService().existeTrabajo(trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaCargaODEs(es.pode.planificador.negocio.servicios.TareaCargaODEsVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaCargaODEsVO modificarTareaCargaODEs(es.pode.planificador.negocio.servicios.TareaCargaODEsVO datosTareaCargaODE, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().modificarTareaCargaODEs(datosTareaCargaODE, trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaReindexado(es.pode.planificador.negocio.servicios.TareaReindexadoVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaReindexadoVO modificarTareaReindexado(es.pode.planificador.negocio.servicios.TareaReindexadoVO datosTarea, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().modificarTareaReindexado(datosTarea, trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaEliminarNoDisponibles(es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO)
     */
    public es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO crearTareaEliminarNoDisponibles(es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO datosTarea)
        throws es.pode.planificador.negocio.servicios.CrearTareaException
    {
        return getSrvPlanificadorService().crearTareaEliminarNoDisponibles(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaEliminarNoDisponibles(es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO modificarTareaEliminarNoDisponibles(es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO datosTarea, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().modificarTareaEliminarNoDisponibles(datosTarea, trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareaEliminarrNoDisponibles(es.pode.planificador.negocio.servicios.TareaVO)
     */
    public es.pode.planificador.negocio.servicios.TareaEliminaNoDisponiblesVO obtenerTareaEliminarrNoDisponibles(es.pode.planificador.negocio.servicios.TareaVO tarea)
        throws es.pode.planificador.negocio.servicios.ModificarTareaException
    {
        return getSrvPlanificadorService().obtenerTareaEliminarrNoDisponibles(tarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#eliminarNoDisponibles(java.util.Calendar, java.util.Calendar, java.lang.Long)
     */
    public java.lang.String eliminarNoDisponibles(java.util.Calendar fechaInicio, java.util.Calendar fechaHasta, java.lang.Long idTarea)
        throws es.pode.planificador.negocio.servicios.EliminarNoDisponiblesException
    {
        return getSrvPlanificadorService().eliminarNoDisponibles(fechaInicio, fechaHasta, idTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO crearTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea)
    {
        return getSrvPlanificadorService().crearTareaInformes(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#obtenerTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO obtenerTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO tarea)
    {
        return getSrvPlanificadorService().obtenerTareaInformes(tarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO modificarTareaInformes(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
    {
        return getSrvPlanificadorService().modificarTareaInformes(datosTarea, trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#generarInforme(es.pode.planificador.negocio.servicios.TareaInformesVO, java.lang.Long)
     */
    public void generarInforme(es.pode.planificador.negocio.servicios.TareaInformesVO datosInforme, java.lang.Long idTarea)
    {
        getSrvPlanificadorService().generarInforme(datosInforme, idTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO)
     */
    public es.pode.planificador.negocio.servicios.TareaModificacionVO crearTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO datosTarea)
    {
        return getSrvPlanificadorService().crearTareaModificacion(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO)
     */
    public es.pode.planificador.negocio.servicios.TareaModificacionVO modificarTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO datosTarea)
    {
        return getSrvPlanificadorService().modificarTareaModificacion(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#lanzarRSS()
     */
    public void lanzarRSS()
    {
        getSrvPlanificadorService().lanzarRSS();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#informesPortada()
     */
    public void informesPortada()
    {
        getSrvPlanificadorService().informesPortada();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#portadaODE()
     */
    public void portadaODE()
    {
        getSrvPlanificadorService().portadaODE();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#generarSitemaps()
     */
    public void generarSitemaps()
    {
        getSrvPlanificadorService().generarSitemaps();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#generarCatalogo()
     */
    public void generarCatalogo()
    {
        getSrvPlanificadorService().generarCatalogo();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#generarInformeFederado(es.pode.planificador.negocio.servicios.TareaInformesVO, java.lang.Long)
     */
    public void generarInformeFederado(es.pode.planificador.negocio.servicios.TareaInformesVO datosInforme, java.lang.Long idTarea)
    {
        getSrvPlanificadorService().generarInformeFederado(datosInforme, idTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaInformesFederado(es.pode.planificador.negocio.servicios.TareaInformesVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO crearTareaInformesFederado(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea)
    {
        return getSrvPlanificadorService().crearTareaInformesFederado(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#crearTareaInformesCatalogo(es.pode.planificador.negocio.servicios.TareaInformesVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO crearTareaInformesCatalogo(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea)
    {
        return getSrvPlanificadorService().crearTareaInformesCatalogo(datosTarea);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaInformesCatalogo(es.pode.planificador.negocio.servicios.TareaInformesVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO modificarTareaInformesCatalogo(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
    {
        return getSrvPlanificadorService().modificarTareaInformesCatalogo(datosTarea, trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvPlanificadorService#modificarTareaInformesFederado(es.pode.planificador.negocio.servicios.TareaInformesVO, es.pode.planificador.negocio.servicios.TrabajoVO)
     */
    public es.pode.planificador.negocio.servicios.TareaInformesVO modificarTareaInformesFederado(es.pode.planificador.negocio.servicios.TareaInformesVO datosTarea, es.pode.planificador.negocio.servicios.TrabajoVO trabajo)
    {
        return getSrvPlanificadorService().modificarTareaInformesFederado(datosTarea, trabajo);
    }

}