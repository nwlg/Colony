// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearSesion</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.CrearRecursoAvanzadoTipoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo.CrearRecursoAvanzadoTipoController#crearSesion
 */
public interface CrearSesionForm
{
    /**
     * Sets the <code>tipo</code> field.
     *
     * <p>
     * Tipo scorm de recurso (asset o sco)
     * </p>
     */
    public void setTipo(java.lang.String tipo);

    /**
     * Gets the <code>tipo</code> field.
     *
     * <p>
     * Tipo scorm de recurso (asset o sco)
     * </p>
     */
    public java.lang.String getTipo();
    
    /**
     * Resets the <code>tipo</code> field.
     */
    public void resetTipo();

}
