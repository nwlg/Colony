// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.fuentestaxonomicas.negocio.servicio;

/**
 * 
 */
public class VdexVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public VdexVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param nombre  
     * @param codigoError  
     * @param sufijo  
     */
    public VdexVO(
        java.lang.String nombre,
        java.lang.String codigoError,
        java.lang.String sufijo)

    {
        this.nombre = nombre;
        this.codigoError = codigoError;
        this.sufijo = sufijo;
    }

    /**
     * Copies constructor from other VdexVO
     * @param otherBean VdexVO 
     */
    public VdexVO(VdexVO otherBean)
    {
        if (otherBean != null)
        {
            this.nombre = otherBean.getNombre();
            this.codigoError = otherBean.getCodigoError();
            this.sufijo = otherBean.getSufijo();
        }
    }

    private java.lang.String nombre;

    public java.lang.String getNombre()
    {
        return this.nombre;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    private java.lang.String codigoError;

    public java.lang.String getCodigoError()
    {
        return this.codigoError;
    }

    public void setCodigoError(java.lang.String codigoError)
    {
        this.codigoError = codigoError;
    }

    private java.lang.String sufijo;

    public java.lang.String getSufijo()
    {
        return this.sufijo;
    }

    public void setSufijo(java.lang.String sufijo)
    {
        this.sufijo = sufijo;
    }

}