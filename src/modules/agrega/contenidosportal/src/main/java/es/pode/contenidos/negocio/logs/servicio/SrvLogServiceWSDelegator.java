// license-header java merge-point
package es.pode.contenidos.negocio.logs.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.logs.servicio.SrvLogService}.
 *
 * @see es.pode.contenidos.negocio.logs.servicio.SrvLogService
 */
public class SrvLogServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.logs.servicio.SrvLogService}
     */
    private final es.pode.contenidos.negocio.logs.servicio.SrvLogService getSrvLogService()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvLogService();
    }

    /**
     * @see es.pode.contenidos.negocio.logs.servicio.SrvLogService#listarFicherosLog()
     */
    public es.pode.contenidos.negocio.logs.servicio.FileVO[] listarFicherosLog()
    {
        return getSrvLogService().listarFicherosLog();
    }

    /**
     * @see es.pode.contenidos.negocio.logs.servicio.SrvLogService#eliminarFicheroLog(java.lang.String[])
     */
    public es.pode.contenidos.negocio.logs.servicio.ValidaBajaLogVO eliminarFicheroLog(java.lang.String[] ficheros)
    {
        return getSrvLogService().eliminarFicheroLog(ficheros);
    }

    /**
     * @see es.pode.contenidos.negocio.logs.servicio.SrvLogService#recuperarFicheroLog(java.lang.String)
     */
    public javax.activation.DataHandler recuperarFicheroLog(java.lang.String fichero)
    {
        return getSrvLogService().recuperarFicheroLog(fichero);
    }

}