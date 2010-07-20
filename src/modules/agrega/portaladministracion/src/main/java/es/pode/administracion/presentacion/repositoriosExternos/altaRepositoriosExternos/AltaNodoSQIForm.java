// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>altaNodoSQI</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIController</code> controller.
 *
 * <p>
 * Metodo para dar de alta un nodo SQI
 * </p>
 *
 * @see es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIController#altaNodoSQI
 */
public interface AltaNodoSQIForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * <p>
     * El identificador del nodo SQI
     * </p>
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * <p>
     * El identificador del nodo SQI
     * </p>
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * Sets the <code>urlServicio</code> field.
     *
     * <p>
     * La URL del servicio
     * </p>
     */
    public void setUrlServicio(java.lang.String urlServicio);

    /**
     * Gets the <code>urlServicio</code> field.
     *
     * <p>
     * La URL del servicio
     * </p>
     */
    public java.lang.String getUrlServicio();
    
    /**
     * Resets the <code>urlServicio</code> field.
     */
    public void resetUrlServicio();

    /**
     * Sets the <code>gestorSesion</code> field.
     *
     * <p>
     * El gestor de sesiones
     * </p>
     */
    public void setGestorSesion(java.lang.String gestorSesion);

    /**
     * Gets the <code>gestorSesion</code> field.
     *
     * <p>
     * El gestor de sesiones
     * </p>
     */
    public java.lang.String getGestorSesion();
    
    /**
     * Resets the <code>gestorSesion</code> field.
     */
    public void resetGestorSesion();

    /**
     * Sets the <code>descripcionNodo</code> field.
     *
     * <p>
     * La descripcion del nodo SQI
     * </p>
     */
    public void setDescripcionNodo(java.lang.String descripcionNodo);

    /**
     * Gets the <code>descripcionNodo</code> field.
     *
     * <p>
     * La descripcion del nodo SQI
     * </p>
     */
    public java.lang.String getDescripcionNodo();
    
    /**
     * Resets the <code>descripcionNodo</code> field.
     */
    public void resetDescripcionNodo();

    /**
     * Sets the <code>usuario</code> field.
     *
     * <p>
     * El usuario
     * </p>
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * <p>
     * El usuario
     * </p>
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

    /**
     * Sets the <code>idModificado</code> field.
     *
     * 
     */
    public void setIdModificado(java.lang.Long idModificado);

    /**
     * Gets the <code>idModificado</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificado();
    
    /**
     * Resets the <code>idModificado</code> field.
     */
    public void resetIdModificado();

    /**
     * Sets the <code>nombreNodo</code> field.
     *
     * <p>
     * El nombre del nodo
     * </p>
     */
    public void setNombreNodo(java.lang.String nombreNodo);

    /**
     * Gets the <code>nombreNodo</code> field.
     *
     * <p>
     * El nombre del nodo
     * </p>
     */
    public java.lang.String getNombreNodo();
    
    /**
     * Resets the <code>nombreNodo</code> field.
     */
    public void resetNombreNodo();

    /**
     * Sets the <code>clave</code> field.
     *
     * <p>
     * La clave del usuario
     * </p>
     */
    public void setClave(java.lang.String clave);

    /**
     * Gets the <code>clave</code> field.
     *
     * <p>
     * La clave del usuario
     * </p>
     */
    public java.lang.String getClave();
    
    /**
     * Resets the <code>clave</code> field.
     */
    public void resetClave();

    /**
     * Sets the <code>lenguajeConsulta</code> field.
     *
     * <p>
     * El lenguaje que se va a utilizar para hacer la consulta
     * </p>
     */
    public void setLenguajeConsulta(java.lang.String lenguajeConsulta);

    /**
     * Gets the <code>lenguajeConsulta</code> field.
     *
     * <p>
     * El lenguaje que se va a utilizar para hacer la consulta
     * </p>
     */
    public java.lang.String getLenguajeConsulta();
    
    /**
     * Resets the <code>lenguajeConsulta</code> field.
     */
    public void resetLenguajeConsulta();

    /**
     * Sets the <code>lenguajeRespuesta</code> field.
     *
     * <p>
     * El lenguaje en el que nos devolveran la respuesta
     * </p>
     */
    public void setLenguajeRespuesta(java.lang.String lenguajeRespuesta);

    /**
     * Gets the <code>lenguajeRespuesta</code> field.
     *
     * <p>
     * El lenguaje en el que nos devolveran la respuesta
     * </p>
     */
    public java.lang.String getLenguajeRespuesta();
    
    /**
     * Resets the <code>lenguajeRespuesta</code> field.
     */
    public void resetLenguajeRespuesta();

    /**
     * Sets the <code>identificadorSesion</code> field.
     *
     * <p>
     * El identificador de sesiones
     * </p>
     */
    public void setIdentificadorSesion(java.lang.String identificadorSesion);

    /**
     * Gets the <code>identificadorSesion</code> field.
     *
     * <p>
     * El identificador de sesiones
     * </p>
     */
    public java.lang.String getIdentificadorSesion();
    
    /**
     * Resets the <code>identificadorSesion</code> field.
     */
    public void resetIdentificadorSesion();

}
