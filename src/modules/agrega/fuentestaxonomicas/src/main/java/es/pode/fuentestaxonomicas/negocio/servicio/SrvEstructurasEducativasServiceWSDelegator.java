// license-header java merge-point
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService}.
 *
 * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService
 */
public class SrvEstructurasEducativasServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService}
     */
    private final es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService getSrvEstructurasEducativasService()
    {
        return es.pode.fuentestaxonomicas.negocio.ServiceLocator.instance().getSrvEstructurasEducativasService();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#chequearIdiomaArbolCurricular(java.lang.String)
     */
    public java.lang.Boolean chequearIdiomaArbolCurricular(java.lang.String nombre)
    {
        return getSrvEstructurasEducativasService().chequearIdiomaArbolCurricular(nombre);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#chequearIdiomaTesauro(java.lang.String)
     */
    public java.lang.Boolean chequearIdiomaTesauro(java.lang.String nombre)
    {
        return getSrvEstructurasEducativasService().chequearIdiomaTesauro(nombre);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#listarArbolCurricular()
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] listarArbolCurricular()
    {
        return getSrvEstructurasEducativasService().listarArbolCurricular();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#listarTesauros()
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] listarTesauros()
    {
        return getSrvEstructurasEducativasService().listarTesauros();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#eliminarArbolesCurriculares(java.lang.String[])
     */
    public int[] eliminarArbolesCurriculares(java.lang.String[] nombres)
    {
        return getSrvEstructurasEducativasService().eliminarArbolesCurriculares(nombres);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#eliminarTesauros(java.lang.String[])
     */
    public int[] eliminarTesauros(java.lang.String[] nombres)
    {
        return getSrvEstructurasEducativasService().eliminarTesauros(nombres);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#subirArbolesCurriculares(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[])
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] subirArbolesCurriculares(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[] arboles)
    {
        return getSrvEstructurasEducativasService().subirArbolesCurriculares(arboles);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#subirTesauros(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[])
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] subirTesauros(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[] tesauros)
    {
        return getSrvEstructurasEducativasService().subirTesauros(tesauros);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#eliminarBackups(java.lang.String[])
     */
    public int[] eliminarBackups(java.lang.String[] nombres)
    {
        return getSrvEstructurasEducativasService().eliminarBackups(nombres);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#listarBackups()
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] listarBackups()
    {
        return getSrvEstructurasEducativasService().listarBackups();
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#subirBackups(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[])
     */
    public es.pode.fuentestaxonomicas.negocio.servicio.VdexVO[] subirBackups(es.pode.fuentestaxonomicas.negocio.servicio.ParamVdexVO[] listaVdex)
    {
        return getSrvEstructurasEducativasService().subirBackups(listaVdex);
    }

    /**
     * @see es.pode.fuentestaxonomicas.negocio.servicio.SrvEstructurasEducativasService#exportarVdex(java.lang.String, es.pode.fuentestaxonomicas.negocio.servicio.TipoVdex)
     */
    public javax.activation.DataHandler exportarVdex(java.lang.String nombre, es.pode.fuentestaxonomicas.negocio.servicio.TipoVdex tipoVdex)
    {
        return getSrvEstructurasEducativasService().exportarVdex(nombre, tipoVdex);
    }

}