// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.desagregar;

import java.io.Serializable;

/**
 * 
 */
public class DesagregarBasicoSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "desagregarBasicoSession";

    private java.util.List grupos;

  /**
   * <p>
   * Lista de GrupoVO que se quiere desagregar como ODE
   * </p>
   * @return java.util.List
   */
    public java.util.List getGrupos()
    {
        return this.grupos;
    }

  /**
   * <p>
   * Lista de GrupoVO que se quiere desagregar como ODE
   * </p>
   *  @param grupos  Lista de GrupoVO que se quiere desagregar como ODE  
   */
    public void setGrupos(java.util.List grupos)
    {
        this.grupos = grupos;
    }


}
