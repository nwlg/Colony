// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectOption</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosController#selectOption
 */
public interface SelectOptionForm
{
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
     * Sets the <code>option</code> field.
     *
     * 
     */
    public void setOption(java.lang.String option);

    /**
     * Gets the <code>option</code> field.
     *
     * 
     */
    public java.lang.String getOption();
    
    /**
     * Resets the <code>option</code> field.
     */
    public void resetOption();

}
