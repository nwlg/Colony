// license-header java merge-point
package es.pode.indexador.negocio.servicios.auditoria;

/**
 * Web service delegator for {@link es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService}.
 *
 * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService
 */
public class SrvAuditoriaIndexadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService}
     */
    private final es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService getSrvAuditoriaIndexadorService()
    {
        return es.pode.indexador.ServiceLocator.instance().getSrvAuditoriaIndexadorService();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService#coberturaArbolCurricular(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO)
     */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaArbolCurricular(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria)
    {
        return getSrvAuditoriaIndexadorService().coberturaArbolCurricular(parametroAuditoria);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService#coberturaNivelAgregacion(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO)
     */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaNivelAgregacion(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria)
    {
        return getSrvAuditoriaIndexadorService().coberturaNivelAgregacion(parametroAuditoria);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService#coberturaLicencias(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO)
     */
    public es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] coberturaLicencias(es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO parametroAuditoria)
    {
        return getSrvAuditoriaIndexadorService().coberturaLicencias(parametroAuditoria);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService#obtenerURLImagenPequena(java.lang.String, java.lang.String[])
     */
    public java.lang.String[] obtenerURLImagenPequena(java.lang.String idioma, java.lang.String[] identificadores)
    {
        return getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(idioma, identificadores);
    }

}