// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.contenidos.negocio.faqs.servicio;

/**
 * 
 */
public class CategoriaTraducidaVO
    implements java.io.Serializable
{

    public CategoriaTraducidaVO()
    {
    }

    /**
     * Constructor taking all properties.
     */
    public CategoriaTraducidaVO(
        java.lang.Long id,
        java.lang.String idiomas,
        java.lang.String nombre)

    {
        this.id = id;
        this.idiomas = idiomas;
        this.nombre = nombre;
    }

    /**
     * Copies constructor from other CategoriaTraducidaVO
     */
    public CategoriaTraducidaVO(CategoriaTraducidaVO otherBean)
    {
        if (otherBean != null)
        {
            this.id = otherBean.getId();
            this.idiomas = otherBean.getIdiomas();
            this.nombre = otherBean.getNombre();
        }
    }

    private java.lang.Long id;

    /**
     * 
     */
    public java.lang.Long getId()
    {
        return this.id;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    private java.lang.String idiomas;

    /**
     * 
     */
    public java.lang.String getIdiomas()
    {
        return this.idiomas;
    }

    public void setIdiomas(java.lang.String idiomas)
    {
        this.idiomas = idiomas;
    }

    private java.lang.String nombre;

    /**
     * 
     */
    public java.lang.String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

}