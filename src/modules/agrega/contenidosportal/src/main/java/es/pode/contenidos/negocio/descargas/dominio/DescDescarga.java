// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateEntity.vsl in andromda-hibernate-cartridge.
//
package es.pode.contenidos.negocio.descargas.dominio;

/**
 * 
 */
public abstract class DescDescarga
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 6955234157849767011L;

    private java.lang.String idioma;

    /**
     * 
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    private java.lang.String descripcion;

    /**
     * 
     */
    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

    private java.lang.String titulo;

    /**
     * 
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
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

    private es.pode.contenidos.negocio.descargas.dominio.Descarga descarga;

    /**
     * 
     */
    public es.pode.contenidos.negocio.descargas.dominio.Descarga getDescarga()
    {
        return this.descarga;
    }

    public void setDescarga(es.pode.contenidos.negocio.descargas.dominio.Descarga descarga)
    {
        this.descarga = descarga;
    }

    /**
     * Returns <code>true</code> if the argument is an DescDescarga instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     */
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof DescDescarga))
        {
            return false;
        }
        final DescDescarga that = (DescDescarga)object;
        if (this.id == null || that.id == null || !this.id.equals(that.id))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     */
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (id == null ? 0 : id.hashCode());

        return hashCode;
    }

    /**
     * Constructs new instances of {@link es.pode.contenidos.negocio.descargas.dominio.DescDescarga}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link es.pode.contenidos.negocio.descargas.dominio.DescDescarga}.
         */
        public static es.pode.contenidos.negocio.descargas.dominio.DescDescarga newInstance()
        {
            return new es.pode.contenidos.negocio.descargas.dominio.DescDescargaImpl();
        }
    }

// HibernateEntity.vsl merge-point
}