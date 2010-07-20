// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaValidacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController</code> controller.
 *
 * <p>
 * Decide la salida a tomar en función de si ha pasado o no la
 * validación.
 * </p>
 * <p>
 * Devuelve "FORMULARIO_VALIDO" o "FORMULARIO_INVALIDO" en funcion
 * de si ha validado correctamente.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController#analizaValidacion
 */
public interface AnalizaValidacionForm
{
    /**
     * Sets the <code>resultadoValidacion</code> field.
     *
     * 
     */
    public void setResultadoValidacion(java.lang.String resultadoValidacion);

    /**
     * Gets the <code>resultadoValidacion</code> field.
     *
     * 
     */
    public java.lang.String getResultadoValidacion();
    
    /**
     * Resets the <code>resultadoValidacion</code> field.
     */
    public void resetResultadoValidacion();

}
