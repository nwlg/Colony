// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

import java.io.Serializable;

/**
 * 
 */
public class CrearElementoSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "crearElementoSession";

    private java.lang.String identifier;

    public java.lang.String getIdentifier()
    {
        return this.identifier;
    }

    public void setIdentifier(java.lang.String identifier)
    {
        this.identifier = identifier;
    }

    private java.lang.String title;

    public java.lang.String getTitle()
    {
        return this.title;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    private java.lang.String idRef;

    public java.lang.String getIdRef()
    {
        return this.idRef;
    }

    public void setIdRef(java.lang.String idRef)
    {
        this.idRef = idRef;
    }

    private boolean esModificar;

    public boolean isEsModificar()
    {
        return this.esModificar;
    }

    public void setEsModificar(boolean esModificar)
    {
        this.esModificar = esModificar;
    }

    private java.lang.String referenciado;

  /**
   * <p>
   * Valores posibles: Ninguno, Recurso, Submanifiesto
   * </p>
   * @return java.lang.String
   */
    public java.lang.String getReferenciado()
    {
        return this.referenciado;
    }

  /**
   * <p>
   * Valores posibles: Ninguno, Recurso, Submanifiesto
   * </p>
   *  @param referenciado  Valores posibles: Ninguno, Recurso, Submanifiesto  
   */
    public void setReferenciado(java.lang.String referenciado)
    {
        this.referenciado = referenciado;
    }

    private java.lang.String[] selectPresentation;

    public java.lang.String[] getSelectPresentation()
    {
        return this.selectPresentation;
    }

    public void setSelectPresentation(java.lang.String[] selectPresentation)
    {
        this.selectPresentation = selectPresentation;
    }

    private java.lang.String timeLimitAction;

    public java.lang.String getTimeLimitAction()
    {
        return this.timeLimitAction;
    }

    public void setTimeLimitAction(java.lang.String timeLimitAction)
    {
        this.timeLimitAction = timeLimitAction;
    }

    private java.lang.String dataFromLMS;

    public java.lang.String getDataFromLMS()
    {
        return this.dataFromLMS;
    }

    public void setDataFromLMS(java.lang.String dataFromLMS)
    {
        this.dataFromLMS = dataFromLMS;
    }

    private java.lang.Double completionThreshold;

    public java.lang.Double getCompletionThreshold()
    {
        return this.completionThreshold;
    }

    public void setCompletionThreshold(java.lang.Double completionThreshold)
    {
        this.completionThreshold = completionThreshold;
    }

    private java.lang.Boolean isVisible;

    public java.lang.Boolean getIsVisible()
    {
        return this.isVisible;
    }

    public void setIsVisible(java.lang.Boolean isVisible)
    {
        this.isVisible = isVisible;
    }


}
