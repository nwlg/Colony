// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.adminusuarios.negocio.servicios;

/**
 * 
 */
public class ValidaBajaUsuarioVO
    implements java.io.Serializable
{

    public ValidaBajaUsuarioVO()
    {
    }

    /**
     * Constructor taking all properties.
     */
    public ValidaBajaUsuarioVO(
        java.lang.String descripcion,
        java.lang.Integer numDeleted,
        es.pode.adminusuarios.negocio.servicios.UsuarioVO[] itemsDeleted)

    {
        this.descripcion = descripcion;
        this.numDeleted = numDeleted;
        this.itemsDeleted = itemsDeleted;
    }

    /**
     * Copies constructor from other ValidaBajaUsuarioVO
     */
    public ValidaBajaUsuarioVO(ValidaBajaUsuarioVO otherBean)
    {
        if (otherBean != null)
        {
            this.descripcion = otherBean.getDescripcion();
            this.numDeleted = otherBean.getNumDeleted();
            this.itemsDeleted = otherBean.getItemsDeleted();
        }
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

    private java.lang.Integer numDeleted;

    /**
     * 
     */
    public java.lang.Integer getNumDeleted()
    {
        return this.numDeleted;
    }

    public void setNumDeleted(java.lang.Integer numDeleted)
    {
        this.numDeleted = numDeleted;
    }

    private es.pode.adminusuarios.negocio.servicios.UsuarioVO[] itemsDeleted;

    /**
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] getItemsDeleted()
    {
        return this.itemsDeleted;
    }

    public void setItemsDeleted(es.pode.adminusuarios.negocio.servicios.UsuarioVO[] itemsDeleted)
    {
        this.itemsDeleted = itemsDeleted;
    }

}