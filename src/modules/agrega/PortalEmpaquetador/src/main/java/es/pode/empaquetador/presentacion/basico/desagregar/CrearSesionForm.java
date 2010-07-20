// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.desagregar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearSesion</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#crearSesion
 */
public interface CrearSesionForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentificadores#sArray(Object[])
     */
    public void setIdentificadores(java.util.List identificadores);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentificadores#sArray()
     */
    public java.util.List getIdentificadores();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdentificadores(java.util.List)
     */
    public void setIdentificadoresAsArray(Object[] identificadores);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentificadores()
     */
    public java.lang.Object[] getIdentificadoresAsArray();

    /**
     * Resets the <code>identificadores</code> field.
     */
    public void resetIdentificadores();

}
