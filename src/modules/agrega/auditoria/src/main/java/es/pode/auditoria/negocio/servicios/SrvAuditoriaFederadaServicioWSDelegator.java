// license-header java merge-point
package es.pode.auditoria.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio}.
 *
 * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio
 */
public class SrvAuditoriaFederadaServicioWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio}
     */
    private final es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio getSrvAuditoriaFederadaServicio()
    {
        return es.pode.auditoria.ServiceLocator.instance().getSrvAuditoriaFederadaServicio();
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#informeNivelAgregacionFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO[] informeNivelAgregacionFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().informeNivelAgregacionFederado(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#nivelAgregacionFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO nivelAgregacionFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().nivelAgregacionFederadoLocal(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#informeCoberturaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO[] informeCoberturaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().informeCoberturaFederado(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#coberturaFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO coberturaFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().coberturaFederadoLocal(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#informeOdesPublicadosFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO[] informeOdesPublicadosFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().informeOdesPublicadosFederado(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#odesPublicadosFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO odesPublicadosFederadoLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().odesPublicadosFederadoLocal(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#informeOdesIdiomaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO[] informeOdesIdiomaFederado(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().informeOdesIdiomaFederado(parametros);
    }

    /**
     * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicio#informeOdesIdiomaLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO)
     */
    public es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO informeOdesIdiomaLocal(es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO parametros)
    {
        return getSrvAuditoriaFederadaServicio().informeOdesIdiomaLocal(parametros);
    }

}