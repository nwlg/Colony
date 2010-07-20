// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.areaCurricular;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerAreasCurriculares</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController</code> controller.
 *
 * <p>
 * Este metodo recopila la informacion necesaria para mostrar el
 * apartado de nivel educativo, en el buscador avanzado.
 * </p>
 * <p>
 * Tiene en cuenta los valores almacenados en la sesion.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularController#obtenerAreasCurriculares
 */
public interface ObtenerAreasCurricularesForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * <p>
     * Identificador dentro del arbol de Nivel Educativo del nodo
     * padre.
     * </p>
     */
    public void setId(java.lang.String id);

    /**
     * Gets the <code>id</code> field.
     *
     * <p>
     * Identificador dentro del arbol de Nivel Educativo del nodo
     * padre.
     * </p>
     */
    public java.lang.String getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Son los nodos que cuelgan del nivel del arbol de Nivel Educativo
     * que se ha seleccionado.
     * </p>
     *
     * @see #setNodos#sArray(Object[])
     */
    public void setNodos(java.util.Collection nodos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Son los nodos que cuelgan del nivel del arbol de Nivel Educativo
     * que se ha seleccionado.
     * </p>
     *
     * @see #getNodos#sArray()
     */
    public java.util.Collection getNodos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Son los nodos que cuelgan del nivel del arbol de Nivel Educativo
     * que se ha seleccionado.
     * </p>
     *
     * @see #setNodos(java.util.Collection)
     */
    public void setNodosAsArray(Object[] nodos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Son los nodos que cuelgan del nivel del arbol de Nivel Educativo
     * que se ha seleccionado.
     * </p>
     *
     * @see #getNodos()
     */
    public java.lang.Object[] getNodosAsArray();

    /**
     * Resets the <code>nodos</code> field.
     */
    public void resetNodos();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Se trata de la ruta del arbol de Niveles Educativos hasta llegar
     * al Nivel Educativo que se ha seleccionado.
     * </p>
     *
     * @see #setRutaArbol#sArray(Object[])
     */
    public void setRutaArbol(java.util.Collection rutaArbol);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Se trata de la ruta del arbol de Niveles Educativos hasta llegar
     * al Nivel Educativo que se ha seleccionado.
     * </p>
     *
     * @see #getRutaArbol#sArray()
     */
    public java.util.Collection getRutaArbol();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Se trata de la ruta del arbol de Niveles Educativos hasta llegar
     * al Nivel Educativo que se ha seleccionado.
     * </p>
     *
     * @see #setRutaArbol(java.util.Collection)
     */
    public void setRutaArbolAsArray(Object[] rutaArbol);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Se trata de la ruta del arbol de Niveles Educativos hasta llegar
     * al Nivel Educativo que se ha seleccionado.
     * </p>
     *
     * @see #getRutaArbol()
     */
    public java.lang.Object[] getRutaArbolAsArray();

    /**
     * Resets the <code>rutaArbol</code> field.
     */
    public void resetRutaArbol();

    /**
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

}
