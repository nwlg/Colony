// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.tagging.negocio.servicios;

/**
 * 
 */
public class TaggingVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public TaggingVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param id  
     * @param idOde  
     * @param titulo  
     * @param idiomaCat  
     * @param tag  
     * @param idUsuario  
     */
    public TaggingVO(
        java.lang.Long id,
        java.lang.String idOde,
        java.lang.String titulo,
        java.lang.String idiomaCat,
        java.lang.String tag,
        java.lang.String idUsuario)

    {
        this.id = id;
        this.idOde = idOde;
        this.titulo = titulo;
        this.idiomaCat = idiomaCat;
        this.tag = tag;
        this.idUsuario = idUsuario;
    }

    /**
     * Copies constructor from other TaggingVO
     * @param otherBean TaggingVO 
     */
    public TaggingVO(TaggingVO otherBean)
    {
        if (otherBean != null)
        {
            this.id = otherBean.getId();
            this.idOde = otherBean.getIdOde();
            this.titulo = otherBean.getTitulo();
            this.idiomaCat = otherBean.getIdiomaCat();
            this.tag = otherBean.getTag();
            this.idUsuario = otherBean.getIdUsuario();
        }
    }

    private java.lang.Long id;

    public java.lang.Long getId()
    {
        return this.id;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    private java.lang.String idOde;

    public java.lang.String getIdOde()
    {
        return this.idOde;
    }

    public void setIdOde(java.lang.String idOde)
    {
        this.idOde = idOde;
    }

    private java.lang.String titulo;

    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    private java.lang.String idiomaCat;

    public java.lang.String getIdiomaCat()
    {
        return this.idiomaCat;
    }

    public void setIdiomaCat(java.lang.String idiomaCat)
    {
        this.idiomaCat = idiomaCat;
    }

    private java.lang.String tag;

    public java.lang.String getTag()
    {
        return this.tag;
    }

    public void setTag(java.lang.String tag)
    {
        this.tag = tag;
    }

    private java.lang.String idUsuario;

    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }

    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

}