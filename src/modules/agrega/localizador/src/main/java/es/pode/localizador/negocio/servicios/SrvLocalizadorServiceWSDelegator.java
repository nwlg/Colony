// license-header java merge-point
package es.pode.localizador.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.localizador.negocio.servicios.SrvLocalizadorService}.
 *
 * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService
 */
public class SrvLocalizadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.localizador.negocio.servicios.SrvLocalizadorService}
     */
    private final es.pode.localizador.negocio.servicios.SrvLocalizadorService getSrvLocalizadorService()
    {
        return es.pode.localizador.negocio.ServiceLocator.instance().getSrvLocalizadorService();
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#crearLocalizadorNoPublicado(java.lang.String, java.lang.String)
     */
    public es.pode.localizador.negocio.servicios.LocalizadorVO crearLocalizadorNoPublicado(java.lang.String usuario, java.lang.String uuid)
        throws es.pode.localizador.negocio.servicios.CreaLocalizadorNoPublicadoException
    {
        return getSrvLocalizadorService().crearLocalizadorNoPublicado(usuario, uuid);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#crearLocalizadorPublicado(java.lang.String, java.lang.String)
     */
    public es.pode.localizador.negocio.servicios.LocalizadorVO crearLocalizadorPublicado(java.lang.String uuid, java.lang.String mec)
        throws es.pode.localizador.negocio.servicios.CreaLocalizadorPublicadoException
    {
        return getSrvLocalizadorService().crearLocalizadorPublicado(uuid, mec);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#consultaLocalizador(java.lang.String)
     */
    public es.pode.localizador.negocio.servicios.LocalizadorVO consultaLocalizador(java.lang.String identificador)
        throws es.pode.localizador.negocio.servicios.ConsultaLocalizadorException
    {
        return getSrvLocalizadorService().consultaLocalizador(identificador);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#buscarLocalizadoresPorId(java.lang.String[])
     */
    public es.pode.localizador.negocio.servicios.LocalizadorVO[] buscarLocalizadoresPorId(java.lang.String[] ids)
        throws es.pode.localizador.negocio.servicios.BuscarLocalizadoresException
    {
        return getSrvLocalizadorService().buscarLocalizadoresPorId(ids);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#eliminarLocalizador(java.lang.String)
     */
    public java.lang.Boolean eliminarLocalizador(java.lang.String identificador)
        throws es.pode.localizador.negocio.servicios.EliminaLocalizadorException
    {
        return getSrvLocalizadorService().eliminarLocalizador(identificador);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#consultaLocalizadorNoPublicado(java.lang.String)
     */
    public es.pode.localizador.negocio.servicios.LocalizadorVO consultaLocalizadorNoPublicado(java.lang.String mec)
    {
        return getSrvLocalizadorService().consultaLocalizadorNoPublicado(mec);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#consultaEspacioLocalizadores(java.lang.String[])
     */
    public java.lang.Long[] consultaEspacioLocalizadores(java.lang.String[] identificadores)
    {
        return getSrvLocalizadorService().consultaEspacioLocalizadores(identificadores);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#consultaEspacioLocalizador(java.lang.String)
     */
    public java.lang.Long consultaEspacioLocalizador(java.lang.String idLocalizador)
    {
        return getSrvLocalizadorService().consultaEspacioLocalizador(idLocalizador);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#actualizaEspacioLocalizador(java.lang.String)
     */
    public java.lang.Long actualizaEspacioLocalizador(java.lang.String idLocalizador)
    {
        return getSrvLocalizadorService().actualizaEspacioLocalizador(idLocalizador);
    }

    /**
     * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService#calculaEspacioLocalizador(java.lang.String)
     */
    public java.lang.Long calculaEspacioLocalizador(java.lang.String idLocalizador)
    {
        return getSrvLocalizadorService().calculaEspacioLocalizador(idLocalizador);
    }

}