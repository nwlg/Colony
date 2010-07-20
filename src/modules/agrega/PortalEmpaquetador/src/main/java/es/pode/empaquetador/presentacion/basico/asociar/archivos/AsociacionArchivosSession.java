// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

import java.io.Serializable;

/**
 * 
 */
public class AsociacionArchivosSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "asociacionArchivosSession";

    private java.util.List ficheros;

  /**
   * <p>
   * Lista temporal de archivos asociados al grupo (recurso). Al
   * finalizar la transaccion de asociar archivos, se hace un swap de
   * esta lista con la contenida en AsociacionSession.
   * </p>
   * @return java.util.List
   */
    public java.util.List getFicheros()
    {
        return this.ficheros;
    }

  /**
   * <p>
   * Lista temporal de archivos asociados al grupo (recurso). Al
   * finalizar la transaccion de asociar archivos, se hace un swap de
   * esta lista con la contenida en AsociacionSession.
   * </p>
   *  @param ficheros  Lista temporal de archivos asociados al grupo (recurso). Al finalizar la transaccion de asociar archivos, se hace un swap de esta lista con la contenida en AsociacionSession.  
   */
    public void setFicheros(java.util.List ficheros)
    {
        this.ficheros = ficheros;
    }


}
