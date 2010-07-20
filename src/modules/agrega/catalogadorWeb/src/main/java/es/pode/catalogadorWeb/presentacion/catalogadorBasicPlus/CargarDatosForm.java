// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * <p>
 * Metodo que realiza una llamada al metodo obtenerCombos del
 * servicio SrvVocabulariosControladosService y al metodo
 * obtenerLomBasico  que devuelve un LomBasicoVO del servicio
 * SrvCatalogacionBasicaService.
 * </p>
 * <p>
 * Una vez obtenido un LomBasicoVO se podran rellenar los campos
 * los campos del formulario.
 * </p>
 * <p>
 * Si el objeto de sesion esta vacio, el metodo cargarDatos
 * obtendra los datos del objeto Lom guardado en la tabla hash. Sin
 * embargo, si el objeto de sesion contiene datos, el metodo
 * cargarDatos obtendra los datos del mismo.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#cargarDatos
 */
public interface CargarDatosForm extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
{
    
}
