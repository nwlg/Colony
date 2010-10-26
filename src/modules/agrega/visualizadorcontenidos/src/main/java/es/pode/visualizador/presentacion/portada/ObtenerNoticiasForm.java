// license-header java merge-point
package es.pode.visualizador.presentacion.portada;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNoticias</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.portada.PortadaController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.portada.PortadaController#obtenerNoticias
 */
public interface ObtenerNoticiasForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNoticias#sArray(Object[])
     */
    public void setNoticias(java.util.Collection noticias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNoticias#sArray()
     */
    public java.util.Collection getNoticias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNoticias(java.util.Collection)
     */
    public void setNoticiasAsArray(Object[] noticias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNoticias()
     */
    public java.lang.Object[] getNoticiasAsArray();

    /**
     * Resets the <code>noticias</code> field.
     */
    public void resetNoticias();

    /**
     * Sets the <code>numNoticias</code> field.
     *
     * <p>
     * Numero de noticias por pagina en la portada.
     * </p>
     */
    public void setNumNoticias(int numNoticias);

    /**
     * Gets the <code>numNoticias</code> field.
     *
     * <p>
     * Numero de noticias por pagina en la portada.
     * </p>
     */
    public int getNumNoticias();
    
    /**
     * Resets the <code>numNoticias</code> field.
     */
    public void resetNumNoticias();

    /**
     * Sets the <code>usuarios</code> field.
     *
     * 
     */
    public void setUsuarios(int usuarios);

    /**
     * Gets the <code>usuarios</code> field.
     *
     * 
     */
    public int getUsuarios();
    
    /**
     * Resets the <code>usuarios</code> field.
     */
    public void resetUsuarios();

    /**
     * Sets the <code>objetos</code> field.
     *
     * 
     */
    public void setObjetos(int objetos);

    /**
     * Gets the <code>objetos</code> field.
     *
     * 
     */
    public int getObjetos();
    
    /**
     * Resets the <code>objetos</code> field.
     */
    public void resetObjetos();

    /**
     * Set the subject search filter backing list
     */
    public void setSubjectSearchFilter(java.lang.String subjectSearchFilter);
    public java.lang.String getSubjectSearchFilter();
    public java.lang.Object[] getSubjectSearchFilterValueList();
    public void setSubjectSearchFilterValueList(java.lang.Object[] subjectSearchFilterValueList);
    public java.lang.Object[] getSubjectSearchFilterLabelList();
    public void setSubjectSearchFilterLabelList(java.lang.Object[] subjectSearchFilterLabelList);
    public java.lang.Object[] getSubjectSearchFilterBackingList();

    /**
     * Set the keystage search filter backing list
     */
    public void setKeystageSearchFilter(java.lang.String keystageSearchFilter);
    public java.lang.String getKeystageSearchFilter();
    public java.lang.Object[] getKeystageSearchFilterValueList();
    public void setKeystageSearchFilterValueList(java.lang.Object[] keystageSearchFilterValueList);
    public java.lang.Object[] getKeystageSearchFilterLabelList();
    public void setKeystageSearchFilterLabelList(java.lang.Object[] keystageSearchFilterLabelList);
    public java.lang.Object[] getKeystageSearchFilterBackingList();

    /**
     * Set the learning time search filter backing list
     */
    public void setLearningTimeSearchFilter(java.lang.String learningTimeSearchFilter);
    public java.lang.String getLearningTimeSearchFilter();
    public java.lang.Object[] getLearningTimeSearchFilterValueList();
    public void setLearningTimeSearchFilterValueList(java.lang.Object[] learningTimeSearchFilterValueList);
    public java.lang.Object[] getLearningTimeSearchFilterLabelList();
    public void setLearningTimeSearchFilterLabelList(java.lang.Object[] learningTimeSearchFilterLabelList);
    public java.lang.Object[] getLearningTimeSearchFilterBackingList();

    /**
     * Set the intended end user role search filter backing list
     */
    public void setIntendedEndUserRoleSearchFilter(java.lang.String intendedEndUserSearchFilter);
    public java.lang.String getIntendedEndUserRoleSearchFilter();
    public java.lang.Object[] getIntendedEndUserRoleSearchFilterValueList();
    public void setIntendedEndUserRoleSearchFilterValueList(java.lang.Object[] intendedEndUserSearchFilterValueList);
    public java.lang.Object[] getIntendedEndUserRoleSearchFilterLabelList();
    public void setIntendedEndUserRoleSearchFilterLabelList(java.lang.Object[] intendedEndUserSearchFilterLabelList);
    public java.lang.Object[] getIntendedEndUserRoleSearchFilterBackingList();


    //19/10/2010    Fernando Garcia
    //              Adding a new filter for file mime types
    /**
     * Set the intended end user role search filter backing list
     */
    public void setIntendedFMTSearchFilter(java.lang.String intendedFMTSearchFilter);
    public java.lang.String getIntendedFMTSearchFilter();
    public java.lang.Object[] getIntendedFMTSearchFilterValueList();
    public void setIntendedFMTSearchFilterValueList(java.lang.Object[] intendedFMTSearchFilterValueList);
    public java.lang.Object[] getIntendedFMTSearchFilterLabelList();
    public void setIntendedFMTSearchFilterLabelList(java.lang.Object[] intendedFMTSearchFilterLabelList);
    public java.lang.Object[] getIntendedFMTSearchFilterBackingList();

    
}
