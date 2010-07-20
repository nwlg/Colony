// license-header java merge-point
package es.pode.planificador.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService}.
 *
 * @see es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService
 */
public class SrvRegistroPlanificadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService}
     */
    private final es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService getSrvRegistroPlanificadorService()
    {
        return es.pode.ServiceLocator.instance().getSrvRegistroPlanificadorService();
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService#registrarTrabajo(es.pode.planificador.negocio.servicios.TareaEjecutadaVO)
     */
    public java.lang.Long registrarTrabajo(es.pode.planificador.negocio.servicios.TareaEjecutadaVO trabajo)
        throws es.pode.planificador.negocio.servicios.RegistrarTrabajoException
    {
        return getSrvRegistroPlanificadorService().registrarTrabajo(trabajo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService#registrarTrabajoHijo(es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO)
     */
    public java.lang.Long registrarTrabajoHijo(es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO trabajoHijo)
        throws es.pode.planificador.negocio.servicios.RegistrarTrabajoException
    {
        return getSrvRegistroPlanificadorService().registrarTrabajoHijo(trabajoHijo);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService#registrarTrabajoFechaFin(es.pode.planificador.negocio.servicios.TareaEjecutadaVO)
     */
    public java.lang.Long registrarTrabajoFechaFin(es.pode.planificador.negocio.servicios.TareaEjecutadaVO trabajoEjecutado)
    {
        return getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(trabajoEjecutado);
    }

    /**
     * @see es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorService#registrarTrabajoInterrumpido()
     */
    public java.lang.Long registrarTrabajoInterrumpido()
    {
        return getSrvRegistroPlanificadorService().registrarTrabajoInterrumpido();
    }

}