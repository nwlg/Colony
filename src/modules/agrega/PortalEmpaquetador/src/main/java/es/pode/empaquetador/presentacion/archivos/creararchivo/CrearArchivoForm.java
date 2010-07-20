// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.creararchivo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearArchivo</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoController</code> controller.
 *
 * <p>
 * Llama al servicio de gestion de archivos para crear el archivo
 * solicitado (o descomprimir el conjunto de archivos contenidos en
 * el ZIP). El OdeVO devuelto se introduce en el objeto de sesion.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoController#crearArchivo
 */
public interface CrearArchivoForm
{
    /**
     * Sets the <code>tipo1</code> field.
     *
     * <p>
     * Valores posibles: ZIP, FICHERO
     * </p>
     */
    public void setTipo1(java.lang.String tipo1);

    /**
     * Gets the <code>tipo1</code> field.
     *
     * <p>
     * Valores posibles: ZIP, FICHERO
     * </p>
     */
    public java.lang.String getTipo1();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getTipo1OptionValue(int optionIndex);

    /**
     * Resets the <code>tipo1</code> field.
     */
    public void resetTipo1();

    /**
     * Sets the <code>tipo3</code> field.
     *
     * 
     */
    public void setTipo3(java.lang.String tipo3);

    /**
     * Gets the <code>tipo3</code> field.
     *
     * 
     */
    public java.lang.String getTipo3();
    
    /**
     * Resets the <code>tipo3</code> field.
     */
    public void resetTipo3();

    /**
     * Sets the <code>fichero1</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFichero1(org.apache.struts.upload.FormFile fichero1);


    /**
     * Gets the <code>fichero1</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFichero1();

    /**
     * Resets the <code>fichero1</code> field.
     */
    public void resetFichero1();

    /**
     * Sets the <code>tipo2</code> field.
     *
     * 
     */
    public void setTipo2(java.lang.String tipo2);

    /**
     * Gets the <code>tipo2</code> field.
     *
     * 
     */
    public java.lang.String getTipo2();
    
    /**
     * Resets the <code>tipo2</code> field.
     */
    public void resetTipo2();

    /**
     * Sets the <code>action</code> field.
     *
     * <p>
     * Valor del boton de submit.
     * </p>
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * <p>
     * Valor del boton de submit.
     * </p>
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

    /**
     * Sets the <code>fichero2</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFichero2(org.apache.struts.upload.FormFile fichero2);


    /**
     * Gets the <code>fichero2</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFichero2();

    /**
     * Resets the <code>fichero2</code> field.
     */
    public void resetFichero2();

    /**
     * Sets the <code>fichero3</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFichero3(org.apache.struts.upload.FormFile fichero3);


    /**
     * Gets the <code>fichero3</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFichero3();

    /**
     * Resets the <code>fichero3</code> field.
     */
    public void resetFichero3();

}
