// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarMetadatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * <p>
 * Metodo que hace una llamada al metodo generarMetadatos del
 * Servicio de catalogacion.
 * </p>
 * <p>
 * Se encarga de recoger los valores introducidos mediante el
 * formulario y almacenarlos en el objeto Lom correspondiente que
 * se encuentra en la tabla hash.
 * </p>
 * <p>
 * Muestra ademas una pantalla de confirmacion para aceptar o
 * cancelar la accion de guardar los metadatos.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#guardarMetadatos
 */
public interface GuardarMetadatosForm extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
{
 
}
