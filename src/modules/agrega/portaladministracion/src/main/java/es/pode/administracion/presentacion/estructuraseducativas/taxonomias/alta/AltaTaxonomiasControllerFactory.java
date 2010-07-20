// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta;

public class AltaTaxonomiasControllerFactory
{
    private final static AltaTaxonomiasController INSTANCE = new AltaTaxonomiasControllerImpl();

    public final static AltaTaxonomiasController getAltaTaxonomiasControllerInstance()
    {
        return INSTANCE;
    }
}