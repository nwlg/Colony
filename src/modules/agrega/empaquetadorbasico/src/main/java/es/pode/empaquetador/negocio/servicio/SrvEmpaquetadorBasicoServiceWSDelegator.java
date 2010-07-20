// license-header java merge-point
package es.pode.empaquetador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService}.
 *
 * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService
 */
public class SrvEmpaquetadorBasicoServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService}
     */
    private final es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService getSrvEmpaquetadorBasicoService()
    {
        return es.pode.empaquetador.negocio.ServiceLocator.instance().getSrvEmpaquetadorBasicoService();
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#editarOde(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.OdeVO editarOde(java.lang.String idOde)
    {
        return getSrvEmpaquetadorBasicoService().editarOde(idOde);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#agregarLocal(java.lang.String, es.pode.empaquetador.negocio.servicio.FicheroVO, java.lang.String)
     */
    public void agregarLocal(java.lang.String idOde, es.pode.empaquetador.negocio.servicio.FicheroVO fichero, java.lang.String idGrupo)
    {
        getSrvEmpaquetadorBasicoService().agregarLocal(idOde, fichero, idGrupo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#referenciadoPor(java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO)
     */
    public es.pode.empaquetador.negocio.servicio.GrupoVO[] referenciadoPor(java.lang.String idOde, es.pode.empaquetador.negocio.servicio.ArchivoVO fichero)
    {
        return getSrvEmpaquetadorBasicoService().referenciadoPor(idOde, fichero);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#eliminarFicheros(java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO[], boolean)
     */
    public boolean eliminarFicheros(java.lang.String idOde, es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros, boolean checked)
    {
        return getSrvEmpaquetadorBasicoService().eliminarFicheros(idOde, ficheros, checked);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#desagregarItem(java.lang.String, es.pode.empaquetador.negocio.servicio.GrupoVO[])
     */
    public java.lang.String desagregarItem(java.lang.String idOde, es.pode.empaquetador.negocio.servicio.GrupoVO[] items)
    {
        return getSrvEmpaquetadorBasicoService().desagregarItem(idOde, items);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#crearObjetoEmbebido(java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO crearObjetoEmbebido(java.lang.String idOde, java.lang.String contenido)
    {
        return getSrvEmpaquetadorBasicoService().crearObjetoEmbebido(idOde, contenido);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#agregarRepositorio(java.lang.String, java.lang.String, java.lang.String)
     */
    public void agregarRepositorio(java.lang.String idOde, java.lang.String idLocalizador, java.lang.String idGrupo)
    {
        getSrvEmpaquetadorBasicoService().agregarRepositorio(idOde, idLocalizador, idGrupo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#asociarContenidos(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.FileVO[], java.lang.String)
     */
    public void asociarContenidos(java.lang.String idOde, java.lang.String idGrupo, es.pode.empaquetador.negocio.servicio.FileVO[] ficheros, java.lang.String href)
    {
        getSrvEmpaquetadorBasicoService().asociarContenidos(idOde, idGrupo, ficheros, href);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#eliminarGrupo(java.lang.String, java.lang.String, java.lang.Boolean)
     */
    public void eliminarGrupo(java.lang.String idOde, java.lang.String idGrupo, java.lang.Boolean eliminarFicheros)
    {
        getSrvEmpaquetadorBasicoService().eliminarGrupo(idOde, idGrupo, eliminarFicheros);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#cortar(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO[])
     */
    public void cortar(java.lang.String identificador, java.lang.String carpetaDestino, es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
    {
        getSrvEmpaquetadorBasicoService().cortar(identificador, carpetaDestino, ficheros);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#renombrar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void renombrar(java.lang.String identificador, java.lang.String carpetaPadre, java.lang.String nombre, java.lang.String nuevoNombre)
    {
        getSrvEmpaquetadorBasicoService().renombrar(identificador, carpetaPadre, nombre, nuevoNombre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#desagregarItemLocal(java.lang.String, es.pode.empaquetador.negocio.servicio.GrupoVO[])
     */
    public javax.activation.DataHandler desagregarItemLocal(java.lang.String idOde, es.pode.empaquetador.negocio.servicio.GrupoVO[] items)
    {
        return getSrvEmpaquetadorBasicoService().desagregarItemLocal(idOde, items);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#analizaArchivo(java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.AnalizaArchivoVO analizaArchivo(java.lang.String rutaArchivo, java.lang.String rutaDescomprimido)
    {
        return getSrvEmpaquetadorBasicoService().analizaArchivo(rutaArchivo, rutaDescomprimido);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService#editarObjetoEmbebido(java.lang.String, java.lang.String)
     */
    public java.lang.String editarObjetoEmbebido(java.lang.String idOde, java.lang.String file)
    {
        return getSrvEmpaquetadorBasicoService().editarObjetoEmbebido(idOde, file);
    }

}