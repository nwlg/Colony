// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.indexador.negocio.servicios.busqueda;

/**
 * 
 */
public class TaxonVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public TaxonVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param identificador  
     * @param nombre  
     */
    public TaxonVO(
        java.lang.String identificador,
        java.lang.String nombre)

    {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    /**
     * Copies constructor from other TaxonVO
     * @param otherBean TaxonVO 
     */
    public TaxonVO(TaxonVO otherBean)
    {
        if (otherBean != null)
        {
            this.identificador = otherBean.getIdentificador();
            this.nombre = otherBean.getNombre();
        }
    }

    private java.lang.String identificador;

    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
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

}