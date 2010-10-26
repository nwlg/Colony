// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.auditoria.negocio.servicios;

/**
 * <p>
 * Esta clase implementa un posible mapeo de una tupla de la tabla
 * Comentario.
 * </p>
 */
public class ComentarioVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public ComentarioVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param comentario  Texto del comentario.
     * @param fecha  Fecha en la que se realizo el comentario.
     * @param idODE  Identificador del ODE al que se asocia el comentario.
     * @param id  Identificador del comentario en la BD.
     * @param usuario  Persona que ha introducido el comentario.
     */
    public ComentarioVO(
        java.lang.String comentario,
        java.util.Calendar fecha,
        java.lang.String idODE,
        java.lang.Long id,
        java.lang.String usuario)

    {
        this.comentario = comentario;
        this.fecha = fecha;
        this.idODE = idODE;
        this.id = id;
        this.usuario = usuario;
    }

    /**
     * Copies constructor from other ComentarioVO
     * @param otherBean ComentarioVO 
     */
    public ComentarioVO(ComentarioVO otherBean)
    {
        if (otherBean != null)
        {
            this.comentario = otherBean.getComentario();
            this.fecha = otherBean.getFecha();
            this.idODE = otherBean.getIdODE();
            this.id = otherBean.getId();
            this.usuario = otherBean.getUsuario();
        }
    }

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
     * Identificador del ODE al que se asocia el comentario.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }

    /**
   * <p>
   * Identificador del ODE al que se asocia el comentario.
   * </p>
     *  @param idODE  Identificador del ODE al que se asocia el comentario.  
     */
    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    private java.lang.Long id;

    /**
     * <p>
     * Identificador del comentario en la BD.
     * </p>
     * @return java.lang.Long
     */
    public java.lang.Long getId()
    {
        return this.id;
    }

    /**
   * <p>
   * Identificador del comentario en la BD.
   * </p>
     *  @param id  Identificador del comentario en la BD.  
     */
    public void setId(java.lang.Long id)
    {
        this.id = id;
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

}