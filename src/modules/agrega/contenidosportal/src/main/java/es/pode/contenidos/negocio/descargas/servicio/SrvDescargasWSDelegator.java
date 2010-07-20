// license-header java merge-point
package es.pode.contenidos.negocio.descargas.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.descargas.servicio.SrvDescargas}.
 *
 * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas
 */
public class SrvDescargasWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.descargas.servicio.SrvDescargas}
     */
    private final es.pode.contenidos.negocio.descargas.servicio.SrvDescargas getSrvDescargas()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvDescargas();
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#modificarDescarga(java.lang.Long, java.lang.String, java.lang.Boolean, es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[])
     */
    public java.lang.Long modificarDescarga(java.lang.Long identificador, java.lang.String path, java.lang.Boolean activa, es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[] descripciones)
    {
        return getSrvDescargas().modificarDescarga(identificador, path, activa, descripciones);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#obtenerDescargasActivas()
     */
    public es.pode.contenidos.negocio.descargas.servicio.DescargaVO[] obtenerDescargasActivas()
    {
        return getSrvDescargas().obtenerDescargasActivas();
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#obtenerDescargasNoActivas()
     */
    public es.pode.contenidos.negocio.descargas.servicio.DescargaVO[] obtenerDescargasNoActivas()
    {
        return getSrvDescargas().obtenerDescargasNoActivas();
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#obtenerDescarga(java.lang.Long)
     */
    public es.pode.contenidos.negocio.descargas.servicio.DescargaVO obtenerDescarga(java.lang.Long identificador)
    {
        return getSrvDescargas().obtenerDescarga(identificador);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#obtenerDescDescargas(java.lang.Long)
     */
    public es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[] obtenerDescDescargas(java.lang.Long identificador)
    {
        return getSrvDescargas().obtenerDescDescargas(identificador);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#insertarDescDescarga(java.lang.Long, java.lang.String, java.lang.String, java.lang.String)
     */
    public void insertarDescDescarga(java.lang.Long identificador, java.lang.String idioma, java.lang.String desc, java.lang.String titulo)
    {
        getSrvDescargas().insertarDescDescarga(identificador, idioma, desc, titulo);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#insertarDescDescargas(java.lang.Long, es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[])
     */
    public void insertarDescDescargas(java.lang.Long identificador, es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[] descripciones)
    {
        getSrvDescargas().insertarDescDescargas(identificador, descripciones);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#descargar(java.lang.Long)
     */
    public javax.activation.DataHandler descargar(java.lang.Long identificador)
    {
        return getSrvDescargas().descargar(identificador);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#obtenerDescDescargasIdioma(es.pode.contenidos.negocio.descargas.servicio.DescargaVO[], java.lang.String)
     */
    public es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO[] obtenerDescDescargasIdioma(es.pode.contenidos.negocio.descargas.servicio.DescargaVO[] descargas, java.lang.String idioma)
    {
        return getSrvDescargas().obtenerDescDescargasIdioma(descargas, idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.descargas.servicio.SrvDescargas#eliminarDescargas(java.lang.Long[])
     */
    public void eliminarDescargas(java.lang.Long[] identificadores)
    {
        getSrvDescargas().eliminarDescargas(identificadores);
    }

}