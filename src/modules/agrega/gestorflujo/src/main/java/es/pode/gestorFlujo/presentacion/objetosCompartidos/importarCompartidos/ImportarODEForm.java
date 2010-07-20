// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>importarODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarCompartidosController</code> controller.
 *
 * <p>
 * Metodo para importar ODE compartido a nuestra carpeta de objetos
 * personales.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarCompartidosController#importarODE
 */
public interface ImportarODEForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * <p>
     * El titulo del ODE que vamos a importar
     * </p>
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * <p>
     * El titulo del ODE que vamos a importar
     * </p>
     */
    public java.lang.String getTitulo();
    
    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

    /**
     * Sets the <code>idODE</code> field.
     *
     * <p>
     * El identificador del ODE que vamos a importar
     * </p>
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * <p>
     * El identificador del ODE que vamos a importar
     * </p>
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * El resultado de la validacion de la importacion
     * </p>
     *
     * @see #setResultado#sArray(Object[])
     */
    public void setResultado(java.util.Collection resultado);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * El resultado de la validacion de la importacion
     * </p>
     *
     * @see #getResultado#sArray()
     */
    public java.util.Collection getResultado();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * El resultado de la validacion de la importacion
     * </p>
     *
     * @see #setResultado(java.util.Collection)
     */
    public void setResultadoAsArray(Object[] resultado);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * El resultado de la validacion de la importacion
     * </p>
     *
     * @see #getResultado()
     */
    public java.lang.Object[] getResultadoAsArray();

    /**
     * Resets the <code>resultado</code> field.
     */
    public void resetResultado();

}
