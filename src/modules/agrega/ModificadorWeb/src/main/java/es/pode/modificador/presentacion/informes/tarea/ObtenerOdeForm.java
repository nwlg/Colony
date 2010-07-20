// license-header java merge-point
package es.pode.modificador.presentacion.informes.tarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerOde</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.informes.tarea.InformeTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController#obtenerOde
 */
public interface ObtenerOdeForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.String id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.String getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * Sets the <code>ode</code> field.
     *
     * 
     */
    public void setOde(es.pode.modificador.negocio.servicio.ResultadoModificacionVO ode);

    /**
     * Gets the <code>ode</code> field.
     *
     * 
     */
    public es.pode.modificador.negocio.servicio.ResultadoModificacionVO getOde();
    
    /**
     * Resets the <code>ode</code> field.
     */
    public void resetOde();

}
