// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.empaquetador.negocio.servicio;

/**
 * 
 */
public class AnalizaArchivoVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public AnalizaArchivoVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param tipoArchivo  
     * @param mensajes  
     */
    public AnalizaArchivoVO(
        java.lang.String tipoArchivo,
        java.lang.String[] mensajes)

    {
        this.tipoArchivo = tipoArchivo;
        this.mensajes = mensajes;
    }

    /**
     * Copies constructor from other AnalizaArchivoVO
     * @param otherBean AnalizaArchivoVO 
     */
    public AnalizaArchivoVO(AnalizaArchivoVO otherBean)
    {
        if (otherBean != null)
        {
            this.tipoArchivo = otherBean.getTipoArchivo();
            this.mensajes = otherBean.getMensajes();
        }
    }

    private java.lang.String tipoArchivo;

    public java.lang.String getTipoArchivo()
    {
        return this.tipoArchivo;
    }

    public void setTipoArchivo(java.lang.String tipoArchivo)
    {
        this.tipoArchivo = tipoArchivo;
    }

    private java.lang.String[] mensajes;

    public java.lang.String[] getMensajes()
    {
        return this.mensajes;
    }

    public void setMensajes(java.lang.String[] mensajes)
    {
        this.mensajes = mensajes;
    }

}