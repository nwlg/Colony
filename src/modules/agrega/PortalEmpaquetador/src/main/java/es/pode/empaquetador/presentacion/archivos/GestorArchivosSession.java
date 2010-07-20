// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos;

import java.io.Serializable;

/**
 * 
 */
public class GestorArchivosSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "gestorArchivosSession";

    private java.util.List path;

  /**
   * <p>
   * Lista de ArchivosVO indicando la ruta hasta la carpeta actual.
   * </p>
   * @return java.util.List
   */
    public java.util.List getPath()
    {
        return this.path;
    }

  /**
   * <p>
   * Lista de ArchivosVO indicando la ruta hasta la carpeta actual.
   * </p>
   *  @param path  Lista de ArchivosVO indicando la ruta hasta la carpeta actual.  
   */
    public void setPath(java.util.List path)
    {
        this.path = path;
    }

    private java.lang.String accion;

  /**
   * <p>
   * Flag que permite distinguir la accion a realizar cuando el
   * portapapeles esta lleno: CORTAR, COPIAR, NORMAL.
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getAccion()
    {
        return this.accion;
    }

  /**
   * <p>
   * Flag que permite distinguir la accion a realizar cuando el
   * portapapeles esta lleno: CORTAR, COPIAR, NORMAL.
   * </p>
   *  @param accion  Flag que permite distinguir la accion a realizar cuando el portapapeles esta lleno: CORTAR, COPIAR, NORMAL.  
   */
    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    private boolean modoPegar;

  /**
   * <p>
   * Flag para indicar si el modo copiar/pegar esta bloqueado hasta
   * que se pegue o se vacie el contenido del portapapeles.
   * </p>
   * @return boolean
   */
    public boolean isModoPegar()
    {
        return this.modoPegar;
    }

  /**
   * <p>
   * Flag para indicar si el modo copiar/pegar esta bloqueado hasta
   * que se pegue o se vacie el contenido del portapapeles.
   * </p>
   *  @param modoPegar  Flag para indicar si el modo copiar/pegar esta bloqueado hasta que se pegue o se vacie el contenido del portapapeles.  
   */
    public void setModoPegar(boolean modoPegar)
    {
        this.modoPegar = modoPegar;
    }

    private java.util.List portapapeles;

  /**
   * <p>
   * Lista de ArchivoVO disponibles para copiar/mover.
   * </p>
   * @return java.util.List
   */
    public java.util.List getPortapapeles()
    {
        return this.portapapeles;
    }

  /**
   * <p>
   * Lista de ArchivoVO disponibles para copiar/mover.
   * </p>
   *  @param portapapeles  Lista de ArchivoVO disponibles para copiar/mover.  
   */
    public void setPortapapeles(java.util.List portapapeles)
    {
        this.portapapeles = portapapeles;
    }


}
