// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

import java.io.Serializable;

/**
 * <p>
 * Objeto de sesion que se crea al entrar en la pantalla de
 * seleccionar archivos para el recurso. Permanece en sesion
 * durante las iteraciones que se realicen en la pantalla de
 * navegacion de archivos.
 * </p>
 */
public class CrearRecursoArchivosSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "crearRecursoArchivosSession";

    private java.util.List archivos;

    public java.util.List getArchivos()
    {
        return this.archivos;
    }

    public void setArchivos(java.util.List archivos)
    {
        this.archivos = archivos;
    }


}
