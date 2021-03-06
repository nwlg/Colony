// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.publicacion.negocio.servicios;

/**
 * 
 */
public class IdUsuarioVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public IdUsuarioVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param idUsuario  Identificador del usuario.
     */
    public IdUsuarioVO(
        java.lang.String idUsuario)

    {
        this.idUsuario = idUsuario;
    }

    /**
     * Copies constructor from other IdUsuarioVO
     * @param otherBean IdUsuarioVO 
     */
    public IdUsuarioVO(IdUsuarioVO otherBean)
    {
        if (otherBean != null)
        {
            this.idUsuario = otherBean.getIdUsuario();
        }
    }

    private java.lang.String idUsuario;

    /**
     * <p>
     * Identificador del usuario.
     * </p>
     * @return java.lang.String
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }

    /**
   * <p>
   * Identificador del usuario.
   * </p>
     *  @param idUsuario  Identificador del usuario.  
     */
    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

}