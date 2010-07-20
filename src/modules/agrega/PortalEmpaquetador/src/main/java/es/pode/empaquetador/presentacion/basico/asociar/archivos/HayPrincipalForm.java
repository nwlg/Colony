// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>hayPrincipal</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController</code> controller.
 *
 * <p>
 * Comprueba si en la transaccion de asociacion de archivos ya hay
 * elegido un archivo principal (porque se esta modificando o
 * porque s�lo se ha elegido un archivo).
 * </p>
 * <p>
 * En caso de que no haya archivos, no se muestra error, se
 * finaliza la sesion dejando el Grupo sin recurso referenciado.
 * </p>
 * <p>
 * En caso de que se modifique un Grupo que previamente ten�a
 * archivos (un recurso), y se le desasocie todos los archivos, se
 * elimina el recurso. Esto se hace en la siguiente actividad,
 * cuando se modifica el recurso.
 * </p>
 * <p>
 * Si s�lo hay un archivo, se configura como archivo principal.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#hayPrincipal
 */
public interface HayPrincipalForm
{
}
