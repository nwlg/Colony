// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.baja;

public class BajaTaxonomiasControllerFactory
{
    private final static BajaTaxonomiasController INSTANCE = new BajaTaxonomiasControllerImpl();

    public final static BajaTaxonomiasController getBajaTaxonomiasControllerInstance()
    {
        return INSTANCE;
    }
}