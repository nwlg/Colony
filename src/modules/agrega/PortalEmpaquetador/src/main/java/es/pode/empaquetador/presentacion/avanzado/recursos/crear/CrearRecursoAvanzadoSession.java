// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear;

import java.io.Serializable;

/**
 * 
 */
public class CrearRecursoAvanzadoSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "crearRecursoAvanzadoSession";

    private java.lang.String tipo;

  /**
   * <p>
   * Tipo de recurso (asset, sco).
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getTipo()
    {
        return this.tipo;
    }

  /**
   * <p>
   * Tipo de recurso (asset, sco).
   * </p>
   *  @param tipo  Tipo de recurso (asset, sco).  
   */
    public void setTipo(java.lang.String tipo)
    {
        this.tipo = tipo;
    }

    private java.util.List archivos;

    public java.util.List getArchivos()
    {
        return this.archivos;
    }

    public void setArchivos(java.util.List archivos)
    {
        this.archivos = archivos;
    }

    private java.util.List dependencias;

    public java.util.List getDependencias()
    {
        return this.dependencias;
    }

    public void setDependencias(java.util.List dependencias)
    {
        this.dependencias = dependencias;
    }

    private java.lang.String principal;

    public java.lang.String getPrincipal()
    {
        return this.principal;
    }

    public void setPrincipal(java.lang.String principal)
    {
        this.principal = principal;
    }

    private java.lang.String identifier;

    public java.lang.String getIdentifier()
    {
        return this.identifier;
    }

    public void setIdentifier(java.lang.String identifier)
    {
        this.identifier = identifier;
    }

    private java.util.List pathArchivos;

    public java.util.List getPathArchivos()
    {
        return this.pathArchivos;
    }

    public void setPathArchivos(java.util.List pathArchivos)
    {
        this.pathArchivos = pathArchivos;
    }

    private boolean vistaArbol;

    public boolean isVistaArbol()
    {
        return this.vistaArbol;
    }

    public void setVistaArbol(boolean vistaArbol)
    {
        this.vistaArbol = vistaArbol;
    }

    private boolean modificar;

  /**
   * <p>
   * Flag para decidir si estamos en Creacion de recurso o
   * modificacion de recurso existente (ambos casos de uso son
   * iguales excepto en la ultima invocacion al servicio).
   * </p>
   * @return boolean
   */
    public boolean isModificar()
    {
        return this.modificar;
    }

  /**
   * <p>
   * Flag para decidir si estamos en Creacion de recurso o
   * modificacion de recurso existente (ambos casos de uso son
   * iguales excepto en la ultima invocacion al servicio).
   * </p>
   *  @param modificar  Flag para decidir si estamos en Creacion de recurso o modificacion de recurso existente (ambos casos de uso son iguales excepto en la ultima invocacion al servicio).  
   */
    public void setModificar(boolean modificar)
    {
        this.modificar = modificar;
    }


}
