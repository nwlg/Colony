// license-header java merge-point
package es.pode.empaquetador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService}.
 *
 * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService
 */
public class SrvGestorArchivosServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService}
     */
    private final es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService getSrvGestorArchivosService()
    {
        return es.pode.empaquetador.negocio.ServiceLocator.instance().getSrvGestorArchivosService();
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#crearCarpeta(java.lang.String, java.lang.String, java.lang.String)
     */
    public void crearCarpeta(java.lang.String identificador, java.lang.String carpetaPadre, java.lang.String nombreCarpeta)
    {
        getSrvGestorArchivosService().crearCarpeta(identificador, carpetaPadre, nombreCarpeta);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#crearArchivo(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.FicheroVO)
     */
    public void crearArchivo(java.lang.String identificador, java.lang.String carpetaPadre, es.pode.empaquetador.negocio.servicio.FicheroVO fichero)
        throws es.pode.empaquetador.negocio.servicio.SobreescrituraException
    {
        getSrvGestorArchivosService().crearArchivo(identificador, carpetaPadre, fichero);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#renombrar(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public void renombrar(java.lang.String identificador, java.lang.String carpetaPadre, java.lang.String nombre, java.lang.String nuevoNombre)
    {
        getSrvGestorArchivosService().renombrar(identificador, carpetaPadre, nombre, nuevoNombre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#descomprimirArchivo(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.FicheroVO)
     */
    public void descomprimirArchivo(java.lang.String identificador, java.lang.String carpetaPadre, es.pode.empaquetador.negocio.servicio.FicheroVO archivo)
        throws es.pode.empaquetador.negocio.servicio.FicheroInexistenteException, es.pode.empaquetador.negocio.servicio.NoEsZipException
    {
        getSrvGestorArchivosService().descomprimirArchivo(identificador, carpetaPadre, archivo);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#eliminar(java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO[])
     */
    public void eliminar(java.lang.String identificador, es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
    {
        getSrvGestorArchivosService().eliminar(identificador, ficheros);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#listar(java.lang.String, java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO[] listar(java.lang.String identificador, java.lang.String carpetaPadre)
    {
        return getSrvGestorArchivosService().listar(identificador, carpetaPadre);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#copiar(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO[])
     */
    public void copiar(java.lang.String identificador, java.lang.String carpetaDestino, es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
    {
        getSrvGestorArchivosService().copiar(identificador, carpetaDestino, ficheros);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#cortar(java.lang.String, java.lang.String, es.pode.empaquetador.negocio.servicio.ArchivoVO[])
     */
    public void cortar(java.lang.String identificador, java.lang.String carpetaDestino, es.pode.empaquetador.negocio.servicio.ArchivoVO[] ficheros)
    {
        getSrvGestorArchivosService().cortar(identificador, carpetaDestino, ficheros);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#generarBackup(java.lang.String)
     */
    public void generarBackup(java.lang.String identificador)
    {
        getSrvGestorArchivosService().generarBackup(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#eliminarBackup(java.lang.String)
     */
    public void eliminarBackup(java.lang.String identificador)
    {
        getSrvGestorArchivosService().eliminarBackup(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#restaurarBackup(java.lang.String)
     */
    public void restaurarBackup(java.lang.String identificador)
    {
        getSrvGestorArchivosService().restaurarBackup(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#recuperarArbol(java.lang.String)
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO recuperarArbol(java.lang.String identificador)
    {
        return getSrvGestorArchivosService().recuperarArbol(identificador);
    }

    /**
     * @see es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService#consultaCuota(java.lang.String, java.lang.Long, java.lang.Long)
     */
    public java.lang.Boolean consultaCuota(java.lang.String identificador, java.lang.Long espacioLibre, java.lang.Long espacioOdeInicio)
    {
        return getSrvGestorArchivosService().consultaCuota(identificador, espacioLibre, espacioOdeInicio);
    }

}