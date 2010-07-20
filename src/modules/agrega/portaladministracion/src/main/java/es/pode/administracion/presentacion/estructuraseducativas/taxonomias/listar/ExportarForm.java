// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>exportar</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar.ListarTaxonomiasController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar.ListarTaxonomiasController#exportar
 */
public interface ExportarForm
{
    /**
     * Sets the <code>nombre</code> field.
     *
     * 
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * 
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

    /**
     * Sets the <code>tipo</code> field.
     *
     * 
     */
    public void setTipo(java.lang.String tipo);

    /**
     * Gets the <code>tipo</code> field.
     *
     * 
     */
    public java.lang.String getTipo();
    
    /**
     * Resets the <code>tipo</code> field.
     */
    public void resetTipo();

}
