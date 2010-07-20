// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarGrupo;

import java.io.Serializable;

/**
 * 
 */
public class ModificarGrupoBSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "modificarGrupoBSession";

    private es.pode.adminusuarios.negocio.servicios.GrupoVO grupoVO;

    public es.pode.adminusuarios.negocio.servicios.GrupoVO getGrupoVO()
    {
        return this.grupoVO;
    }

    public void setGrupoVO(es.pode.adminusuarios.negocio.servicios.GrupoVO grupoVO)
    {
        this.grupoVO = grupoVO;
    }


}
