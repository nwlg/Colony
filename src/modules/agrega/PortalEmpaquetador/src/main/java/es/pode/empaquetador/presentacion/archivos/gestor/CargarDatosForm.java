// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController</code> controller.
 *
 * <p>
 * Obtiene los datos iniciales necesarios para la gestion de
 * archivos:
 * </p>
 * <p>
 * -listado de carpetas
 * </p>
 * <p>
 * -arbol (vista por arbol)
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController#cargarDatos
 */
public interface CargarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de ArchivosVO contenidos en la carpeta actual.
     * </p>
     *
     * @see #setListado#sArray(Object[])
     */
    public void setListado(java.util.List listado);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de ArchivosVO contenidos en la carpeta actual.
     * </p>
     *
     * @see #getListado#sArray()
     */
    public java.util.List getListado();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivosVO contenidos en la carpeta actual.
     * </p>
     *
     * @see #setListado(java.util.List)
     */
    public void setListadoAsArray(Object[] listado);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivosVO contenidos en la carpeta actual.
     * </p>
     *
     * @see #getListado()
     */
    public java.lang.Object[] getListadoAsArray();

    /**
     * Resets the <code>listado</code> field.
     */
    public void resetListado();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de ArchivosVO donde en la primera posicion esta la carpeta
     * principal del ODE (nombrada con el identificador) y en las
     * siguientes los ArchivosVO de las carpetas que componen el path
     * hasta la carpeta actual.
     * </p>
     *
     * @see #setPath#sArray(Object[])
     */
    public void setPath(java.util.List path);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de ArchivosVO donde en la primera posicion esta la carpeta
     * principal del ODE (nombrada con el identificador) y en las
     * siguientes los ArchivosVO de las carpetas que componen el path
     * hasta la carpeta actual.
     * </p>
     *
     * @see #getPath#sArray()
     */
    public java.util.List getPath();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivosVO donde en la primera posicion esta la carpeta
     * principal del ODE (nombrada con el identificador) y en las
     * siguientes los ArchivosVO de las carpetas que componen el path
     * hasta la carpeta actual.
     * </p>
     *
     * @see #setPath(java.util.List)
     */
    public void setPathAsArray(Object[] path);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivosVO donde en la primera posicion esta la carpeta
     * principal del ODE (nombrada con el identificador) y en las
     * siguientes los ArchivosVO de las carpetas que componen el path
     * hasta la carpeta actual.
     * </p>
     *
     * @see #getPath()
     */
    public java.lang.Object[] getPathAsArray();

    /**
     * Resets the <code>path</code> field.
     */
    public void resetPath();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Lista de ArchivoVO disponibles para copiar/mover.
     * </p>
     *
     * @see #setPortapapeles#sArray(Object[])
     */
    public void setPortapapeles(java.util.List portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Lista de ArchivoVO disponibles para copiar/mover.
     * </p>
     *
     * @see #getPortapapeles#sArray()
     */
    public java.util.List getPortapapeles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivoVO disponibles para copiar/mover.
     * </p>
     *
     * @see #setPortapapeles(java.util.List)
     */
    public void setPortapapelesAsArray(Object[] portapapeles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Lista de ArchivoVO disponibles para copiar/mover.
     * </p>
     *
     * @see #getPortapapeles()
     */
    public java.lang.Object[] getPortapapelesAsArray();

    /**
     * Resets the <code>portapapeles</code> field.
     */
    public void resetPortapapeles();

    /**
     * Sets the <code>arbol</code> field.
     *
     * 
     */
    public void setArbol(es.pode.empaquetador.negocio.servicio.ArchivoVO arbol);

    /**
     * Gets the <code>arbol</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArbol();
    
    /**
     * Resets the <code>arbol</code> field.
     */
    public void resetArbol();

}
