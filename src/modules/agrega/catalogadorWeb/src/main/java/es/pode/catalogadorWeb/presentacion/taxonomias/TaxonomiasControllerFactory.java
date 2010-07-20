// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.taxonomias;

public class TaxonomiasControllerFactory
{
    private final static TaxonomiasController INSTANCE = new TaxonomiasControllerImpl();

    public final static TaxonomiasController getTaxonomiasControllerInstance()
    {
        return INSTANCE;
    }
}