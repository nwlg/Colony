// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.contenidos.negocio.generacionDinamica.servicio;

/**
 * <p>
 * Clase de objeto de valor que contiene los atributos de un ODE
 * como contenido generado dinamico.
 * </p>
 */
public class ContenidoODEVO
    implements java.io.Serializable
{

    public ContenidoODEVO()
    {
    }

    /**
     * Constructor taking all properties.
     */
    public ContenidoODEVO(
        java.lang.String idODE,
        java.lang.String urlImagen,
        java.lang.String idioma)

    {
        this.idODE = idODE;
        this.urlImagen = urlImagen;
        this.idioma = idioma;
    }

    /**
     * Copies constructor from other ContenidoODEVO
     */
    public ContenidoODEVO(ContenidoODEVO otherBean)
    {
        if (otherBean != null)
        {
            this.idODE = otherBean.getIdODE();
            this.urlImagen = otherBean.getUrlImagen();
            this.idioma = otherBean.getIdioma();
        }
    }

    private java.lang.String idODE;

    /**
     * <p>
     * Identificador alfanumerico de un ODE.
     * </p>
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private java.lang.String urlImagen;

    /**
     * <p>
     * URL de la imagen del ODE.
     * </p>
     */
    public java.lang.String getUrlImagen()
    {
        return this.urlImagen;
    }

    public void setUrlImagen(java.lang.String urlImagen)
    {
        this.urlImagen = urlImagen;
    }

    private java.lang.String idioma;

    /**
     * <p>
     * Idioma del ODE.
     * </p>
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

}