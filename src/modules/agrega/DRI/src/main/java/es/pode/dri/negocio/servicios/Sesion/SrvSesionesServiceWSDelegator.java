// license-header java merge-point
package es.pode.dri.negocio.servicios.Sesion;

/**
 * Web service delegator for {@link es.pode.dri.negocio.servicios.Sesion.SrvSesionesService}.
 *
 * @see es.pode.dri.negocio.servicios.Sesion.SrvSesionesService
 */
public class SrvSesionesServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.dri.negocio.servicios.Sesion.SrvSesionesService}
     */
    private final es.pode.dri.negocio.servicios.Sesion.SrvSesionesService getSrvSesionesService()
    {
        return es.pode.dri.negocio.ServiceLocator.instance().getSrvSesionesService();
    }

    /**
     * @see es.pode.dri.negocio.servicios.Sesion.SrvSesionesService#createSession(java.lang.String, java.lang.String)
     */
    public java.lang.String createSession(java.lang.String userID, java.lang.String password)
        throws es.pode.dri.negocio.servicios.Sesion.WrongCredentialsException
    {
        return getSrvSesionesService().createSession(userID, password);
    }

    /**
     * @see es.pode.dri.negocio.servicios.Sesion.SrvSesionesService#createAnonymousSession()
     */
    public java.lang.String createAnonymousSession()
    {
        return getSrvSesionesService().createAnonymousSession();
    }

    /**
     * @see es.pode.dri.negocio.servicios.Sesion.SrvSesionesService#destroySession(java.lang.String)
     */
    public void destroySession(java.lang.String sessionID)
        throws es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException
    {
        getSrvSesionesService().destroySession(sessionID);
    }

}