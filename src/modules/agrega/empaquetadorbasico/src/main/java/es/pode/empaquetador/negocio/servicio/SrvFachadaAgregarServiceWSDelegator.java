// license-header java merge-point
package es.pode.empaquetador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService}.
 *
 * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService
 */
public class SrvFachadaAgregarServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService}
     */
    private final es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService getSrvFachadaAgregarService()
    {
        return es.pode.empaquetador.negocio.ServiceLocator.instance().getSrvFachadaAgregarService();
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#agregar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void agregar(java.lang.String idOde, java.lang.String idDestino, java.lang.String tipoEmpaquetador, java.lang.String idAgregar)
    {
        getSrvFachadaAgregarService().agregar(idOde, idDestino, tipoEmpaquetador, idAgregar);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#agregarFederado(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void agregarFederado(java.lang.String idODE, java.lang.String idDestino, java.lang.String tipoEmpaquetador, java.lang.String url)
    {
        getSrvFachadaAgregarService().agregarFederado(idODE, idDestino, tipoEmpaquetador, url);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#prepararMetadatos(java.lang.String)
     */
    public java.lang.String prepararMetadatos(java.lang.String identificador)
    {
        return getSrvFachadaAgregarService().prepararMetadatos(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#descargarMetadato(java.lang.String)
     */
    public void descargarMetadato(java.lang.String identificador)
    {
        getSrvFachadaAgregarService().descargarMetadato(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#generarManifest(java.lang.String, java.lang.String[], java.lang.String, java.lang.String)
     */
    public void generarManifest(java.lang.String identificador, java.lang.String[] files, java.lang.String href, java.lang.String idioma)
    {
        getSrvFachadaAgregarService().generarManifest(identificador, files, href, idioma);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#generarManifestRCP(java.lang.String, java.lang.String)
     */
    public void generarManifestRCP(java.lang.String identificador, java.lang.String idioma)
    {
        getSrvFachadaAgregarService().generarManifestRCP(identificador, idioma);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#analizarArchivo(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.AnalizaArchivoVO analizarArchivo(java.lang.String rutaArchivo)
    {
        return getSrvFachadaAgregarService().analizarArchivo(rutaArchivo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService#generarManifestLom(java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void generarManifestLom(java.lang.String identificador, java.lang.String[] files, java.lang.String href, java.lang.String idioma, java.lang.String titulo, java.lang.String descripcion, java.lang.String idiomaDestinatario, java.lang.String tipo)
    {
        getSrvFachadaAgregarService().generarManifestLom(identificador, files, href, idioma, titulo, descripcion, idiomaDestinatario, tipo);
    }

}