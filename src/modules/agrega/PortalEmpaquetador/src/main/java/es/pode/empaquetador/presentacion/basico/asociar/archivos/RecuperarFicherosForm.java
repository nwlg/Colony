// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarFicheros</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#recuperarFicheros
 */
public interface RecuperarFicherosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setFicheros#sArray(Object[])
     */
    public void setFicheros(java.util.List ficheros);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getFicheros#sArray()
     */
    public java.util.List getFicheros();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setFicheros(java.util.List)
     */
    public void setFicherosAsArray(Object[] ficheros);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getFicheros()
     */
    public java.lang.Object[] getFicherosAsArray();

    /**
     * Resets the <code>ficheros</code> field.
     */
    public void resetFicheros();

}
