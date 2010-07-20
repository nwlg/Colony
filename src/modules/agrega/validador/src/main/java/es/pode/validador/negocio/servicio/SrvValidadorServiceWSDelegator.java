// license-header java merge-point
package es.pode.validador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.validador.negocio.servicio.SrvValidadorService}.
 *
 * @see es.pode.validador.negocio.servicio.SrvValidadorService
 */
public class SrvValidadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.validador.negocio.servicio.SrvValidadorService}
     */
    private final es.pode.validador.negocio.servicio.SrvValidadorService getSrvValidadorService()
    {
        return es.pode.validador.negocio.ServiceLocator.instance().getSrvValidadorService();
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#obtenerValidacionBin(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVO obtenerValidacionBin(java.lang.String rutaManifest)
    {
        return getSrvValidadorService().obtenerValidacionBin(rutaManifest);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#obtenervalidacionLigera(java.lang.String, java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVO obtenervalidacionLigera(java.lang.String rutaManifest, java.lang.String tipoOde)
    {
        return getSrvValidadorService().obtenervalidacionLigera(rutaManifest, tipoOde);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#validarCargaOde(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVO validarCargaOde(java.lang.String rutaOde)
    {
        return getSrvValidadorService().validarCargaOde(rutaOde);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#validarMDBasicosObl(es.pode.validador.negocio.servicio.MDBasicosOblVO)
     */
    public es.pode.validador.negocio.servicio.ValidaVO validarMDBasicosObl(es.pode.validador.negocio.servicio.MDBasicosOblVO mDBasicos)
    {
        return getSrvValidadorService().validarMDBasicosObl(mDBasicos);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#validarMec(java.lang.String)
     */
    public java.lang.String validarMec(java.lang.String rutaManifest)
    {
        return getSrvValidadorService().validarMec(rutaManifest);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#estoyActivo()
     */
    public boolean estoyActivo()
    {
        return getSrvValidadorService().estoyActivo();
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#obtenerValidacionLomes(javax.activation.DataHandler)
     */
    public java.lang.Boolean obtenerValidacionLomes(javax.activation.DataHandler fichero)
    {
        return getSrvValidadorService().obtenerValidacionLomes(fichero);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorService#obtenerValidacion(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVO obtenerValidacion(java.lang.String rutaOde)
    {
        return getSrvValidadorService().obtenerValidacion(rutaOde);
    }

}