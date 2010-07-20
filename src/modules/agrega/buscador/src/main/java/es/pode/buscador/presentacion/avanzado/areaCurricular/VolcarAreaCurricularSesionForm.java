// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.areaCurricular;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>volcarAreaCurricularSesion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController</code> controller.
 *
 * <p>
 * Este metodo recupera de la pantalla de nivel educativo todos los
 * datos introducidos y los mete en la sesion.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController#volcarAreaCurricularSesion
 */
public interface VolcarAreaCurricularSesionForm
{
    /**
     * Sets the <code>areaCurricular</code> field.
     *
     * <p>
     * Se trata de la cadena de indices dentro de una rama de area
     * curricular que se ha seleccionado desde la pantalla.
     * </p>
     */
    public void setAreaCurricular(java.lang.String areaCurricular);

    /**
     * Gets the <code>areaCurricular</code> field.
     *
     * <p>
     * Se trata de la cadena de indices dentro de una rama de area
     * curricular que se ha seleccionado desde la pantalla.
     * </p>
     */
    public java.lang.String getAreaCurricular();
    
    /**
     * Resets the <code>areaCurricular</code> field.
     */
    public void resetAreaCurricular();

}
