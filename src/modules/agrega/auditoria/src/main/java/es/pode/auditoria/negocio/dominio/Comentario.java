// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: HibernateEntity.vsl in andromda-hibernate-cartridge.
//
package es.pode.auditoria.negocio.dominio;

/**
 * <p>
 * Esta clase implementa el comentario asociado a un ODE dentro de
 * la plataforma.
 * </p>
 */
public abstract class Comentario
    implements java.io.Serializable
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -717711948340362225L;

    private java.lang.String comentario;

  /**
   * <p>
   * Texto del comentario.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getComentario()
    {
        return this.comentario;
    }

  /**
   * <p>
   * Texto del comentario.
   * </p>
   *  @param comentario  Texto del comentario. 
   */
    public void setComentario(java.lang.String comentario)
    {
        this.comentario = comentario;
    }
    private java.util.Calendar fecha;

  /**
   * <p>
   * Fecha en la que se realizo el comentario.
   * </p>
   * @return java.util.Calendar
   */
    public java.util.Calendar getFecha()
    {
        return this.fecha;
    }

  /**
   * <p>
   * Fecha en la que se realizo el comentario.
   * </p>
   *  @param fecha  Fecha en la que se realizo el comentario. 
   */
    public void setFecha(java.util.Calendar fecha)
    {
        this.fecha = fecha;
    }
    private java.lang.String idODE;

  /**
   * <p>
   * Identificador del ODE al que pertenece este comentario.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

  /**
   * <p>
   * Identificador del ODE al que pertenece este comentario.
   * </p>
   *  @param idODE  Identificador del ODE al que pertenece este comentario. 
   */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }
    private java.lang.String idiomaODE;

  /**
   * <p>
   * Idioma del ODE
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getIdiomaODE()
    {
        return this.idiomaODE;
    }

  /**
   * <p>
   * Idioma del ODE
   * </p>
   *  @param idiomaODE  Idioma del ODE 
   */
    public void setIdiomaODE(java.lang.String idiomaODE)
    {
        this.idiomaODE = idiomaODE;
    }
    private java.lang.String usuario;

  /**
   * <p>
   * Persona que ha introducido el comentario.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getUsuario()
    {
        return this.usuario;
    }

  /**
   * <p>
   * Persona que ha introducido el comentario.
   * </p>
   *  @param usuario  Persona que ha introducido el comentario. 
   */
    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
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
     * Returns <code>true</code> if the argument is an Comentario instance and all identifiers for this entity
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
        if (!(object instanceof Comentario))
        {
            return false;
        }
        final Comentario that = (Comentario)object;
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
     * Constructs new instances of {@link es.pode.valoracion.negocio.dominio.Comentario}.
     */
    public static final class Factory
    {
        /**
         * Constructs a new instance of {@link es.pode.valoracion.negocio.dominio.Comentario}.
         * @return es.pode.auditoria.negocio.dominio.Comentario
         */
        public static es.pode.auditoria.negocio.dominio.Comentario newInstance()
        {
            return new es.pode.auditoria.negocio.dominio.ComentarioImpl();
        }
    }

// HibernateEntity.vsl merge-point
}