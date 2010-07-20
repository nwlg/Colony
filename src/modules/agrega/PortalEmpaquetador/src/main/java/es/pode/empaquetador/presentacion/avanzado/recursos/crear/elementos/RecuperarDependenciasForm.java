// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarDependencias</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosController#recuperarDependencias
 */
public interface RecuperarDependenciasForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRecursos#sArray(Object[])
     */
    public void setRecursos(java.util.List recursos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRecursos#sArray()
     */
    public java.util.List getRecursos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRecursos(java.util.List)
     */
    public void setRecursosAsArray(Object[] recursos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRecursos()
     */
    public java.lang.Object[] getRecursosAsArray();

    /**
     * Resets the <code>recursos</code> field.
     */
    public void resetRecursos();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDependencias#sArray(Object[])
     */
    public void setDependencias(java.util.List dependencias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDependencias#sArray()
     */
    public java.util.List getDependencias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDependencias(java.util.List)
     */
    public void setDependenciasAsArray(Object[] dependencias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDependencias()
     */
    public java.lang.Object[] getDependenciasAsArray();

    /**
     * Resets the <code>dependencias</code> field.
     */
    public void resetDependencias();

}
