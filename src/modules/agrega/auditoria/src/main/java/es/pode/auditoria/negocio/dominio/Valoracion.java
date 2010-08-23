// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateEntity.vsl in andromda-hibernate-cartridge.
//
package es.pode.auditoria.negocio.dominio;

/**
 * <p>
 * Esta clase implementa la valoración asociada a un ODE dentro de
 * la plataforma.
 * </p>
 */
public abstract class Valoracion
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -7527459396814658490L;

    private java.lang.Float valoracion;

  /**
   * <p>
   * Valoración asociada al ODE. Puede tener un valor decimal.
   * </p>
   * @return java.lang.Float
   */
    public java.lang.Float getValoracion()
    {
        return this.valoracion;
    }

  /**
   * <p>
   * Valoración asociada al ODE. Puede tener un valor decimal.
   * </p>
   *  @param valoracion  Valoración asociada al ODE. Puede tener un valor decimal. 
   */
    public void setValoracion(java.lang.Float valoracion)
    {
        this.valoracion = valoracion;
    }
    private java.lang.String idODE;

  /**
   * <p>
   * Identificador alfanumérico del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

  /**
   * <p>
   * Identificador alfanumérico del ODE.
   * </p>
   *  @param idODE  Identificador alfanumérico del ODE. 
   */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }
    private java.util.Calendar fecha;

  /**
   * <p>
   * Fecha en la que se ha realizado la valoración del ODE.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFecha()
    {
        return this.fecha;
    }

  /**
   * <p>
   * Fecha en la que se ha realizado la valoración del ODE.
   * </p>
   *  @param fecha  Fecha en la que se ha realizado la valoración del ODE. 
   */
    public void setFecha(java.util.Calendar fecha)
    {
        this.fecha = fecha;
    }
    private java.lang.String autor;

  /**
   * <p>
   * Autor de la valoración del ODE.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAutor()
    {
        return this.autor;
    }

  /**
   * <p>
   * Autor de la valoración del ODE.
   * </p>
   *  @param autor  Autor de la valoración del ODE. 
   */
    public void setAutor(java.lang.String autor)
    {
        this.autor = autor;
    }
    private java.lang.String idiomaODE;

  /**
   * <p>
   * Idioma en el que ha sido publicado el ode.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdiomaODE()
    {
        return this.idiomaODE;
    }

  /**
   * <p>
   * Idioma en el que ha sido publicado el ode.
   * </p>
   *  @param idiomaODE  Idioma en el que ha sido publicado el ode. 
   */
    public void setIdiomaODE(java.lang.String idiomaODE)
    {
        this.idiomaODE = idiomaODE;
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


    /**
     * Returns <code>true</code> if the argument is an Valoracion instance and all identifiers for this entity
     * equal the identifiers of the argument entity. Returns <code>false</code> otherwise.
     *
     * @param object The object to compare
     * @return boolean
     */
    public boolean equals(Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (!(object instanceof Valoracion))
        {
            return false;
        }
        final Valoracion that = (Valoracion)object;
        if (this.id == null || that.id == null || !this.id.equals(that.id))
        {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code based on this entity's identifiers.
     * @return int
     */
    public int hashCode()
    {
        int hashCode = 0;
        hashCode = 29 * hashCode + (id == null ? 0 : id.hashCode());

        return hashCode;
    }

    /**
     * Constructs new instances of {@link es.pode.valoracion.negocio.dominio.Valoracion}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link es.pode.valoracion.negocio.dominio.Valoracion}.
         * @return es.pode.valoracion.negocio.dominio.Valoracion
         */
        public static es.pode.auditoria.negocio.dominio.Valoracion newInstance()
        {
            return new es.pode.auditoria.negocio.dominio.ValoracionImpl();
        }
    }

// HibernateEntity.vsl merge-point
}