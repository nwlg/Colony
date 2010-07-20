// license-header java merge-point
package es.pode.valoracion.negocio.servicios.auditoria;

/**
 * Web service delegator for {@link es.pode.valoracion.negocio.servicios.auditoria.SrvAuditoriaValoracionService}.
 *
 * @see es.pode.valoracion.negocio.servicios.auditoria.SrvAuditoriaValoracionService
 */
public class SrvAuditoriaValoracionServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.valoracion.negocio.servicios.auditoria.SrvAuditoriaValoracionService}
     */
    private final es.pode.valoracion.negocio.servicios.auditoria.SrvAuditoriaValoracionService getSrvAuditoriaValoracionService()
    {
        return es.pode.ServiceLocator.instance().getSrvAuditoriaValoracionService();
    }

    /**
     * @see es.pode.valoracion.negocio.servicios.auditoria.SrvAuditoriaValoracionService#contenidosMasValorados(es.pode.valoracion.negocio.servicios.auditoria.ParametroAuditValoracionVO)
     */
    public es.pode.valoracion.negocio.servicios.auditoria.ValoracionODEVO[] contenidosMasValorados(es.pode.valoracion.negocio.servicios.auditoria.ParametroAuditValoracionVO parametro)
    {
        return getSrvAuditoriaValoracionService().contenidosMasValorados(parametro);
    }

}