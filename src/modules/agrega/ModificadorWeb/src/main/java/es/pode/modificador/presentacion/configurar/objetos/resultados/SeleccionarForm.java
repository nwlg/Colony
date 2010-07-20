// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>seleccionar</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#seleccionar
 */
public interface SeleccionarForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPaths#sArray(Object[])
     */
    public void setPaths(java.util.List paths);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPaths#sArray()
     */
    public java.util.List getPaths();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPaths(java.util.List)
     */
    public void setPathsAsArray(Object[] paths);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPaths()
     */
    public java.lang.Object[] getPathsAsArray();

    /**
     * Resets the <code>paths</code> field.
     */
    public void resetPaths();

}
