// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: ValueObject.vsl in andromda-java-cartridge.
//
package es.pode.empaquetador.negocio.servicio;

/**
 * 
 */
public class CompletionThresholdVO
    implements java.io.Serializable
{

    /**
     * Constructor por defecto
     */        
    public CompletionThresholdVO()
    {
    }

    /**
     * Constructor taking all properties.
     * @param content  
     */
    public CompletionThresholdVO(
        java.lang.Double content)

    {
        this.content = content;
    }

    /**
     * Copies constructor from other CompletionThresholdVO
     * @param otherBean CompletionThresholdVO 
     */
    public CompletionThresholdVO(CompletionThresholdVO otherBean)
    {
        if (otherBean != null)
        {
            this.content = otherBean.getContent();
        }
    }

    private java.lang.Double content;

    public java.lang.Double getContent()
    {
        return this.content;
    }

    public void setContent(java.lang.Double content)
    {
        this.content = content;
    }

}