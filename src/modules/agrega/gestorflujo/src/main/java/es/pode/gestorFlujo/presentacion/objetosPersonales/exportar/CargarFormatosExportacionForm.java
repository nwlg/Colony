// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.exportar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarFormatosExportacion</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController</code> controller.
 *
 * <p>
 * Este metodo se encarga de recapitular la informacion necesaria
 * en la pantalla de descargar.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController#cargarFormatosExportacion
 */
public interface CargarFormatosExportacionForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * 
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * 
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
     * Identificador alfanumerico del ODE que se quiere exportar.
     * </p>
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE que se quiere exportar.
     * </p>
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

}
