// license-header java merge-point
package es.pode.contenidos.negocio.informes.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.informes.servicio.SrvInformeService}.
 *
 * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService
 */
public class SrvInformeServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.informes.servicio.SrvInformeService}
     */
    private final es.pode.contenidos.negocio.informes.servicio.SrvInformeService getSrvInformeService()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvInformeService();
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#listarInformes()
     */
    public es.pode.contenidos.negocio.informes.servicio.InformeVO[] listarInformes()
    {
        return getSrvInformeService().listarInformes();
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#eliminarInforme(java.lang.String[])
     */
    public es.pode.contenidos.negocio.informes.servicio.ValidaBajaInformeVO eliminarInforme(java.lang.String[] ficheros)
    {
        return getSrvInformeService().eliminarInforme(ficheros);
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#recuperarInforme(java.lang.String)
     */
    public javax.activation.DataHandler recuperarInforme(java.lang.String fichero)
    {
        return getSrvInformeService().recuperarInforme(fichero);
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#listarInformesMas()
     */
    public es.pode.contenidos.negocio.informes.servicio.InformeVO[] listarInformesMas()
    {
        return getSrvInformeService().listarInformesMas();
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#recuperarInformeMas(java.lang.String)
     */
    public javax.activation.DataHandler recuperarInformeMas(java.lang.String fichero)
    {
        return getSrvInformeService().recuperarInformeMas(fichero);
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#listarInformesFederados()
     */
    public es.pode.contenidos.negocio.informes.servicio.InformeVO[] listarInformesFederados()
    {
        return getSrvInformeService().listarInformesFederados();
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#eliminarInformeFederado(java.lang.String[])
     */
    public es.pode.contenidos.negocio.informes.servicio.ValidaBajaInformeVO eliminarInformeFederado(java.lang.String[] ficheros)
    {
        return getSrvInformeService().eliminarInformeFederado(ficheros);
    }

    /**
     * @see es.pode.contenidos.negocio.informes.servicio.SrvInformeService#recuperarInformesFederados(java.lang.String)
     */
    public javax.activation.DataHandler recuperarInformesFederados(java.lang.String fichero)
    {
        return getSrvInformeService().recuperarInformesFederados(fichero);
    }

}