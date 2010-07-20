// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarETB;

import java.io.Serializable;

/**
 * 
 */
public class TesauroSession implements Serializable
{
  /**
   * Clave del objeto de session
   */
    public final static String SESSION_KEY = "tesauroSession";

    private es.pode.modificador.negocio.servicio.TaxonomiaVO taxonomia;

    public es.pode.modificador.negocio.servicio.TaxonomiaVO getTaxonomia()
    {
        return this.taxonomia;
    }

    public void setTaxonomia(es.pode.modificador.negocio.servicio.TaxonomiaVO taxonomia)
    {
        this.taxonomia = taxonomia;
    }


}
