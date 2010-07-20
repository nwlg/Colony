// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaController#submit
 */
public interface SubmitForm
{
    /**
     * Sets the <code>forwardOnly</code> field.
     *
     * 
     */
    public void setForwardOnly(java.lang.Boolean forwardOnly);

    /**
     * Gets the <code>forwardOnly</code> field.
     *
     * 
     */
    public java.lang.Boolean getForwardOnly();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.Boolean getForwardOnlyOptionValue(int optionIndex);

    /**
     * Resets the <code>forwardOnly</code> field.
     */
    public void resetForwardOnly();

    /**
     * Sets the <code>choice</code> field.
     *
     * 
     */
    public void setChoice(java.lang.Boolean choice);

    /**
     * Gets the <code>choice</code> field.
     *
     * 
     */
    public java.lang.Boolean getChoice();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.Boolean getChoiceOptionValue(int optionIndex);

    /**
     * Resets the <code>choice</code> field.
     */
    public void resetChoice();

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

    /**
     * Sets the <code>choiceExit</code> field.
     *
     * 
     */
    public void setChoiceExit(java.lang.Boolean choiceExit);

    /**
     * Gets the <code>choiceExit</code> field.
     *
     * 
     */
    public java.lang.Boolean getChoiceExit();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.Boolean getChoiceExitOptionValue(int optionIndex);

    /**
     * Resets the <code>choiceExit</code> field.
     */
    public void resetChoiceExit();

    /**
     * Sets the <code>flow</code> field.
     *
     * 
     */
    public void setFlow(java.lang.Boolean flow);

    /**
     * Gets the <code>flow</code> field.
     *
     * 
     */
    public java.lang.Boolean getFlow();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.Boolean getFlowOptionValue(int optionIndex);

    /**
     * Resets the <code>flow</code> field.
     */
    public void resetFlow();

}
