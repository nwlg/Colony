// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesController</code> controller.
 *
 * <p>
 * carga los datos necesarios, como los idiomas.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesController#cargarDatos
 */
public interface CargarDatosForm
{
    /**
     * Sets the <code>ids</code> field.
     *
     * 
     */
    public void setIds(java.lang.String[] ids);

    /**
     * Gets the <code>ids</code> field.
     *
     * 
     */
    public java.lang.String[] getIds();
    
    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * Sets the <code>listODEs</code> field.
     *
     * <p>
     * Lista de los ODEs personales para eliminar
     * </p>
     */
    public void setListODEs(java.lang.String[] listODEs);

    /**
     * Gets the <code>listODEs</code> field.
     *
     * <p>
     * Lista de los ODEs personales para eliminar
     * </p>
     */
    public java.lang.String[] getListODEs();
    
    /**
     * Resets the <code>listODEs</code> field.
     */
    public void resetListODEs();

    /**
     * Sets the <code>seleccion</code> field.
     *
     * 
     */
    public void setSeleccion(java.lang.String seleccion);

    /**
     * Gets the <code>seleccion</code> field.
     *
     * 
     */
    public java.lang.String getSeleccion();
    
    /**
     * Resets the <code>seleccion</code> field.
     */
    public void resetSeleccion();

    /**
     * Sets the <code>titulos</code> field.
     *
     * 
     */
    public void setTitulos(java.lang.String[] titulos);

    /**
     * Gets the <code>titulos</code> field.
     *
     * 
     */
    public java.lang.String[] getTitulos();
    
    /**
     * Resets the <code>titulos</code> field.
     */
    public void resetTitulos();

}
