// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.contenidos.negocio.informes.servicio;

/**
 * 
 */
public class InformeVO
    implements java.io.Serializable
{

    public InformeVO()
    {
    }

    /**
     * Constructor taking all properties.
     */
    public InformeVO(
        java.lang.String nombre,
        java.util.Date fecha)

    {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    /**
     * Copies constructor from other InformeVO
     */
    public InformeVO(InformeVO otherBean)
    {
        if (otherBean != null)
        {
            this.nombre = otherBean.getNombre();
            this.fecha = otherBean.getFecha();
        }
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

    private java.util.Date fecha;

    /**
     * 
     */
    public java.util.Date getFecha()
    {
        return this.fecha;
    }

    public void setFecha(java.util.Date fecha)
    {
        this.fecha = fecha;
    }

}