// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarODESPersonales</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController</code> controller.
 *
 * <p>
 * Este metodo recupera los objetos personales (ODES personales) de
 * la plataforma que esten asociados al usuario.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController#cargarODESPersonales
 */
public interface CargarODESPersonalesForm
{
    /**
     * Sets the <code>cuotaUsuario</code> field.
     *
     * <p>
     * La cuota total de la que dispone el usuario
     * </p>
     */
    public void setCuotaUsuario(java.lang.Long cuotaUsuario);

    /**
     * Gets the <code>cuotaUsuario</code> field.
     *
     * <p>
     * La cuota total de la que dispone el usuario
     * </p>
     */
    public java.lang.Long getCuotaUsuario();
    
    /**
     * Resets the <code>cuotaUsuario</code> field.
     */
    public void resetCuotaUsuario();

    /**
     * Sets the <code>idUsuario</code> field.
     *
     * <p>
     * Identificador del usuario que quiere proponer el ODE para
     * publicacion.
     * </p>
     */
    public void setIdUsuario(java.lang.String idUsuario);

    /**
     * Gets the <code>idUsuario</code> field.
     *
     * <p>
     * Identificador del usuario que quiere proponer el ODE para
     * publicacion.
     * </p>
     */
    public java.lang.String getIdUsuario();
    
    /**
     * Resets the <code>idUsuario</code> field.
     */
    public void resetIdUsuario();

    /**
     * Sets the <code>porcentajeMemoriaCubierta</code> field.
     *
     * <p>
     * La memoria restante de la que dispone el usuario
     * </p>
     */
    public void setPorcentajeMemoriaCubierta(int porcentajeMemoriaCubierta);

    /**
     * Gets the <code>porcentajeMemoriaCubierta</code> field.
     *
     * <p>
     * La memoria restante de la que dispone el usuario
     * </p>
     */
    public int getPorcentajeMemoriaCubierta();
    
    /**
     * Resets the <code>porcentajeMemoriaCubierta</code> field.
     */
    public void resetPorcentajeMemoriaCubierta();

    /**
     * Sets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio libre del que dispone el usuario
     * </p>
     */
    public void setEspacioLibre(java.lang.Long espacioLibre);

    /**
     * Gets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio libre del que dispone el usuario
     * </p>
     */
    public java.lang.Long getEspacioLibre();
    
    /**
     * Resets the <code>espacioLibre</code> field.
     */
    public void resetEspacioLibre();

    /**
     * Sets the <code>tamainoOdes</code> field.
     *
     * <p>
     * Tamaino de los ODES
     * </p>
     */
    public void setTamainoOdes(java.lang.Long[] tamainoOdes);

    /**
     * Gets the <code>tamainoOdes</code> field.
     *
     * <p>
     * Tamaino de los ODES
     * </p>
     */
    public java.lang.Long[] getTamainoOdes();
    
    /**
     * Resets the <code>tamainoOdes</code> field.
     */
    public void resetTamainoOdes();

    /**
     * Sets the <code>totalSuma</code> field.
     *
     * <p>
     * La suma total de los Odes
     * </p>
     */
    public void setTotalSuma(java.lang.Long totalSuma);

    /**
     * Gets the <code>totalSuma</code> field.
     *
     * <p>
     * La suma total de los Odes
     * </p>
     */
    public java.lang.Long getTotalSuma();
    
    /**
     * Resets the <code>totalSuma</code> field.
     */
    public void resetTotalSuma();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Se trata de la lista de ODES de Objetos Personales que tiene
     * asociado el usuario.
     * </p>
     *
     * @see #setListaODES#sArray(Object[])
     */
    public void setListaODES(java.util.Collection listaODES);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Se trata de la lista de ODES de Objetos Personales que tiene
     * asociado el usuario.
     * </p>
     *
     * @see #getListaODES#sArray()
     */
    public java.util.Collection getListaODES();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Se trata de la lista de ODES de Objetos Personales que tiene
     * asociado el usuario.
     * </p>
     *
     * @see #setListaODES(java.util.Collection)
     */
    public void setListaODESAsArray(Object[] listaODES);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Se trata de la lista de ODES de Objetos Personales que tiene
     * asociado el usuario.
     * </p>
     *
     * @see #getListaODES()
     */
    public java.lang.Object[] getListaODESAsArray();

    /**
     * Resets the <code>listaODES</code> field.
     */
    public void resetListaODES();

}
