// license-header java merge-point
package es.pode.entregar.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.entregar.negocio.servicios.SrvEntregarService}.
 *
 * @see es.pode.entregar.negocio.servicios.SrvEntregarService
 */
public class SrvEntregarServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.entregar.negocio.servicios.SrvEntregarService}
     */
    private final es.pode.entregar.negocio.servicios.SrvEntregarService getSrvEntregarService()
    {
        return es.pode.entregar.negocio.ServiceLocator.instance().getSrvEntregarService();
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#generarPaquetePIF(java.lang.String)
     */
    public es.pode.entregar.negocio.servicios.PaquetePifDriVO generarPaquetePIF(java.lang.String identificador)
        throws es.pode.entregar.negocio.servicios.GeneraPIFException
    {
        return getSrvEntregarService().generarPaquetePIF(identificador);
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#cargarObjManifest(java.lang.String, javax.activation.DataHandler)
     */
    public java.lang.String cargarObjManifest(java.lang.String usuario, javax.activation.DataHandler fichManifest)
        throws es.pode.entregar.negocio.servicios.CargarManifestExcepcion
    {
        return getSrvEntregarService().cargarObjManifest(usuario, fichManifest);
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#obtenerOrganizaciones(es.pode.entregar.negocio.servicios.ArgObtOrganizacionesVO)
     */
    public es.pode.entregar.negocio.servicios.ManifestVO obtenerOrganizaciones(es.pode.entregar.negocio.servicios.ArgObtOrganizacionesVO argObtenerOrganizaciones)
        throws es.pode.entregar.negocio.servicios.ObtenerOrganizacionesException
    {
        return getSrvEntregarService().obtenerOrganizaciones(argObtenerOrganizaciones);
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#generarPaquetePIFTipoPIF(es.pode.entregar.negocio.servicios.TipoPifVO)
     */
    public es.pode.entregar.negocio.servicios.PaquetePifVO generarPaquetePIFTipoPIF(es.pode.entregar.negocio.servicios.TipoPifVO tipoPifVO)
        throws es.pode.entregar.negocio.servicios.GeneraPIFTipoPIFException
    {
        return getSrvEntregarService().generarPaquetePIFTipoPIF(tipoPifVO);
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#obtenerTiposPIF()
     */
    public java.lang.String[] obtenerTiposPIF()
    {
        return getSrvEntregarService().obtenerTiposPIF();
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#estoyActivo()
     */
    public boolean estoyActivo()
    {
        return getSrvEntregarService().estoyActivo();
    }

    /**
     * @see es.pode.entregar.negocio.servicios.SrvEntregarService#localizacionPaquetePIF(java.lang.String)
     */
    public es.pode.entregar.negocio.servicios.LocalizadorAdlVO localizacionPaquetePIF(java.lang.String identificador)
    {
        return getSrvEntregarService().localizacionPaquetePIF(identificador);
    }

}