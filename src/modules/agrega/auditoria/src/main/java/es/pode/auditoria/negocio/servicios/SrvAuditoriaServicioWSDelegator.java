// license-header java merge-point
package es.pode.auditoria.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio}.
 *
 * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio
 */
public class SrvAuditoriaServicioWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio}
     */
    private final es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio getSrvAuditoriaServicio()
    {
        return es.pode.auditoria.ServiceLocator.instance().getSrvAuditoriaServicio();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarTrabajoPlan(es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO)
     */
    public java.lang.Long registrarTrabajoPlan(es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO trabajo)
    {
        return getSrvAuditoriaServicio().registrarTrabajoPlan(trabajo);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarTrabajoFechaFinPlan(es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO)
     */
    public java.lang.Long registrarTrabajoFechaFinPlan(es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO trabajo)
    {
        return getSrvAuditoriaServicio().registrarTrabajoFechaFinPlan(trabajo);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarTrabajoHijoPlan(es.pode.auditoria.negocio.servicios.RegistroTareaEjecPlanVO)
     */
    public java.lang.Long registrarTrabajoHijoPlan(es.pode.auditoria.negocio.servicios.RegistroTareaEjecPlanVO trabajoHijo)
    {
        return getSrvAuditoriaServicio().registrarTrabajoHijoPlan(trabajoHijo);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarTrabajoInterrPlan()
     */
    public java.lang.Long registrarTrabajoInterrPlan()
    {
        return getSrvAuditoriaServicio().registrarTrabajoInterrPlan();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarOperacion(es.pode.auditoria.negocio.servicios.OperacionVO)
     */
    public void registrarOperacion(es.pode.auditoria.negocio.servicios.OperacionVO operacion)
    {
        getSrvAuditoriaServicio().registrarOperacion(operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeOperacionesRealizadas(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOperacionVO[] informeOperacionesRealizadas(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO)
    {
        return getSrvAuditoriaServicio().informeOperacionesRealizadas(parametroInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeNivelAgregacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeNivelAgregacionVO[] informeNivelAgregacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeNivelAgregacion(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeCoberturaCurricular(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeCoberturaCurricularVO[] informeCoberturaCurricular(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeCoberturaCurricular(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeTerminosBusqueda(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeTerminoBusquedaVO[] informeTerminosBusqueda(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeTerminosBusqueda(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeOdeUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdeUsuarioVO[] informeOdeUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO)
    {
        return getSrvAuditoriaServicio().informeOdeUsuario(parametroInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeEstadoOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeEstadoOdesVO[] informeEstadoOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeEstadoOdes(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarBusqueda(es.pode.auditoria.negocio.servicios.BusquedaVO)
     */
    public void registrarBusqueda(es.pode.auditoria.negocio.servicios.BusquedaVO busqueda)
    {
        getSrvAuditoriaServicio().registrarBusqueda(busqueda);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeLicenciasOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeLicenciasOdesVO[] informeLicenciasOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeLicenciasOdes(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeUsuarios(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeUsuariosVO[] informeUsuarios(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO)
    {
        return getSrvAuditoriaServicio().informeUsuarios(parametroInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeProcesosPlanificados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeProcesoPlanificadoVO[] informeProcesosPlanificados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeProcesosPlanificados(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasValorado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasValoradoVO[] informeMasValorado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasValorado(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasMostrado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasVO[] informeMasMostrado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasMostrado(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasPrevisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasVO[] informeMasPrevisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasPrevisualizados(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasVisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasVO[] informeMasVisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasVisualizados(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasDescargados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasVO[] informeMasDescargados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasDescargados(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasPesados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasPesadosVO[] informeMasPesados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasPesados(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#obtenerInformes()
     */
    public java.lang.String[] obtenerInformes()
    {
        return getSrvAuditoriaServicio().obtenerInformes();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#crearGuardarInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO)
     */
    public void crearGuardarInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO)
    {
        getSrvAuditoriaServicio().crearGuardarInforme(parametroCrearInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeOperacionUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOperacionUsuarioVO[] informeOperacionUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeOperacionUsuario(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeEstadoOdesTransicciones(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeEstadoOdesVO[] informeEstadoOdesTransicciones(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeEstadoOdesTransicciones(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#crearInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO)
     */
    public javax.activation.DataHandler crearInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametrosCrearInforme)
    {
        return getSrvAuditoriaServicio().crearInforme(parametrosCrearInforme);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeOdeUsuarioOperacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdeUsuarioVO[] informeOdeUsuarioOperacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeOdeUsuarioOperacion(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#repositorio()
     */
    public es.pode.auditoria.negocio.servicios.RepositorioVO[] repositorio()
    {
        return getSrvAuditoriaServicio().repositorio();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#crearInformesPortada()
     */
    public void crearInformesPortada()
    {
        getSrvAuditoriaServicio().crearInformesPortada();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#crearInformeRepositorio()
     */
    public void crearInformeRepositorio()
    {
        getSrvAuditoriaServicio().crearInformeRepositorio();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#obtenNumeroOperaciones(java.lang.String)
     */
    public es.pode.auditoria.negocio.servicios.NumeroOperacionesVO[] obtenNumeroOperaciones(java.lang.String identificador)
    {
        return getSrvAuditoriaServicio().obtenNumeroOperaciones(identificador);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#informeMasEnviado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeMasVO[] informeMasEnviado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
    {
        return getSrvAuditoriaServicio().informeMasEnviado(parametrosInformeVO);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#crearGuardarInformeFederado(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO)
     */
    public void crearGuardarInformeFederado(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO)
    {
        getSrvAuditoriaServicio().crearGuardarInformeFederado(parametroCrearInformeVO);
    }

}