// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>importarODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController</code> controller.
 *
 * <p>
 * Este metodo recoge el ODE de disco del usuario y se lo asocia al
 * usuario.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarController#importarODE
 */
public interface ImportarODEForm
{
    /**
     * Sets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio del que dispone el usuario para la importacion
     * </p>
     */
    public void setEspacioLibre(java.lang.Long espacioLibre);

    /**
     * Gets the <code>espacioLibre</code> field.
     *
     * <p>
     * El espacio del que dispone el usuario para la importacion
     * </p>
     */
    public java.lang.Long getEspacioLibre();
    
    /**
     * Resets the <code>espacioLibre</code> field.
     */
    public void resetEspacioLibre();

    /**
     * Sets the <code>ficheroODE4</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFicheroODE4(org.apache.struts.upload.FormFile ficheroODE4);


    /**
     * Gets the <code>ficheroODE4</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE4();

    /**
     * Resets the <code>ficheroODE4</code> field.
     */
    public void resetFicheroODE4();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setResultado#sArray(Object[])
     */
    public void setResultado(java.util.Collection resultado);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getResultado#sArray()
     */
    public java.util.Collection getResultado();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setResultado(java.util.Collection)
     */
    public void setResultadoAsArray(Object[] resultado);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getResultado()
     */
    public java.lang.Object[] getResultadoAsArray();

    /**
     * Resets the <code>resultado</code> field.
     */
    public void resetResultado();

    /**
     * Sets the <code>ficheroODE5</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFicheroODE5(org.apache.struts.upload.FormFile ficheroODE5);


    /**
     * Gets the <code>ficheroODE5</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE5();

    /**
     * Resets the <code>ficheroODE5</code> field.
     */
    public void resetFicheroODE5();

    /**
     * Sets the <code>ficheroODE2</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFicheroODE2(org.apache.struts.upload.FormFile ficheroODE2);


    /**
     * Gets the <code>ficheroODE2</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE2();

    /**
     * Resets the <code>ficheroODE2</code> field.
     */
    public void resetFicheroODE2();

    /**
     * Sets the <code>ficheroODE3</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFicheroODE3(org.apache.struts.upload.FormFile ficheroODE3);


    /**
     * Gets the <code>ficheroODE3</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE3();

    /**
     * Resets the <code>ficheroODE3</code> field.
     */
    public void resetFicheroODE3();

    /**
     * Sets the <code>ficheroODE1</code> Struts FormFile field to the specified value.
     *
     * <p>
     * Se trata del fichero conteniendo el ODE importado.
     * </p>
     */
    public void setFicheroODE1(org.apache.struts.upload.FormFile ficheroODE1);


    /**
     * Gets the <code>ficheroODE1</code> Struts FormFile field value.
     *
     * <p>
     * Se trata del fichero conteniendo el ODE importado.
     * </p>
     */
    public org.apache.struts.upload.FormFile getFicheroODE1();

    /**
     * Resets the <code>ficheroODE1</code> field.
     */
    public void resetFicheroODE1();

}
