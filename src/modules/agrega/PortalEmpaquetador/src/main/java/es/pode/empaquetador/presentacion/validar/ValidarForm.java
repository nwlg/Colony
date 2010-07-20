// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.validar.ValidarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.validar.ValidarController#validar
 */
public interface ValidarForm
{
    /**
     * Sets the <code>validaVO</code> field.
     *
     * 
     */
    public void setValidaVO(es.pode.empaquetador.negocio.servicio.ValidaVO validaVO);

    /**
     * Gets the <code>validaVO</code> field.
     *
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ValidaVO getValidaVO();
    
    /**
     * Resets the <code>validaVO</code> field.
     */
    public void resetValidaVO();

}
