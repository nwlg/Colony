// license-header java merge-point
package es.pode.dri.negocio.servicios.DRI;

/**
 * Web service delegator for {@link es.pode.dri.negocio.servicios.DRI.SrvDRIService}.
 *
 * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService
 */
public class SrvDRIServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.dri.negocio.servicios.DRI.SrvDRIService}
     */
    private final es.pode.dri.negocio.servicios.DRI.SrvDRIService getSrvDRIService()
    {
        return es.pode.dri.negocio.ServiceLocator.instance().getSrvDRIService();
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#presentarAlmacenarSesion(java.lang.String, javax.activation.DataHandler)
     */
    public void presentarAlmacenarSesion(java.lang.String sesionId, javax.activation.DataHandler pif)
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        getSrvDRIService().presentarAlmacenarSesion(sesionId, pif);
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#solicitarEntregarSesion(java.lang.String, java.lang.String)
     */
    public javax.activation.DataHandler solicitarEntregarSesion(java.lang.String sesionId, java.lang.String mec)
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        return getSrvDRIService().solicitarEntregarSesion(sesionId, mec);
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#presentarAlmacenar(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public void presentarAlmacenar(java.lang.String usuario, java.lang.String clave, javax.activation.DataHandler pif)
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        getSrvDRIService().presentarAlmacenar(usuario, clave, pif);
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#estasActivo()
     */
    public java.lang.Boolean estasActivo()
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        return getSrvDRIService().estasActivo();
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#presentarCatalogar(java.lang.String, java.lang.String, javax.activation.DataHandler)
     */
    public void presentarCatalogar(java.lang.String usuario, java.lang.String clave, javax.activation.DataHandler pif)
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        getSrvDRIService().presentarCatalogar(usuario, clave, pif);
    }

    /**
     * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService#presentarCatalogarSesion(java.lang.String, javax.activation.DataHandler)
     */
    public void presentarCatalogarSesion(java.lang.String sesionId, javax.activation.DataHandler pif)
        throws es.pode.dri.negocio.servicios.DRI.SesionNoValidaException
    {
        getSrvDRIService().presentarCatalogarSesion(sesionId, pif);
    }

}