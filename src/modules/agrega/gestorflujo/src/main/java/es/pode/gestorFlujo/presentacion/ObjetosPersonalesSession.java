// license-header java merge-point
package es.pode.gestorFlujo.presentacion;

import java.io.Serializable;

/**
 * <p>
 * Este objeto almacena las listas de diferentes tipos de objetos
 * personales que tiene asociado un usuario. Se almacenan en sesion
 * para poder tener acceso a ellas en el caso de haber paginacion.
 * </p>
 * <p>
 * OJO, puede que esto no sea necesario ya que vamos a utilizar la
 * nueva version de ibuilder en la que la paginacion externa es
 * posible. No es definitivo.
 * </p>
 */
public class ObjetosPersonalesSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "objetosPersonalesSession";

    private java.util.List listaObjetosPersonales;

  /**
   * <p>
   * Se trata de la lista de ODEs creados que pertenecen al usuario
   * de la sesion.
   * </p>
   * @return java.util.List
   */
    public java.util.List getListaObjetosPersonales()
    {
        return this.listaObjetosPersonales;
    }

  /**
   * <p>
   * Se trata de la lista de ODEs creados que pertenecen al usuario
   * de la sesion.
   * </p>
   *  @param listaObjetosPersonales  Se trata de la lista de ODEs creados que pertenecen al usuario de la sesion.  
   */
    public void setListaObjetosPersonales(java.util.List listaObjetosPersonales)
    {
        this.listaObjetosPersonales = listaObjetosPersonales;
    }

    private java.util.List listaObjetosPropuestos;

  /**
   * <p>
   * Se trata de la lista de ODEs propuestos que pertenecen al
   * usuario de la sesion.
   * </p>
   * @return java.util.List
   */
    public java.util.List getListaObjetosPropuestos()
    {
        return this.listaObjetosPropuestos;
    }

  /**
   * <p>
   * Se trata de la lista de ODEs propuestos que pertenecen al
   * usuario de la sesion.
   * </p>
   *  @param listaObjetosPropuestos  Se trata de la lista de ODEs propuestos que pertenecen al usuario de la sesion.  
   */
    public void setListaObjetosPropuestos(java.util.List listaObjetosPropuestos)
    {
        this.listaObjetosPropuestos = listaObjetosPropuestos;
    }

    private java.util.List listaObjetosPublicados;

  /**
   * <p>
   * Se trata de la lista de objetos publicados que pertenece al
   * usuario de la sesion.
   * </p>
   * @return java.util.List
   */
    public java.util.List getListaObjetosPublicados()
    {
        return this.listaObjetosPublicados;
    }

  /**
   * <p>
   * Se trata de la lista de objetos publicados que pertenece al
   * usuario de la sesion.
   * </p>
   *  @param listaObjetosPublicados  Se trata de la lista de objetos publicados que pertenece al usuario de la sesion.  
   */
    public void setListaObjetosPublicados(java.util.List listaObjetosPublicados)
    {
        this.listaObjetosPublicados = listaObjetosPublicados;
    }


}
