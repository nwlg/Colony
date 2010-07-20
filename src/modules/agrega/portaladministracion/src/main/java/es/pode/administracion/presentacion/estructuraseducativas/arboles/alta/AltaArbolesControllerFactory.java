// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.arboles.alta;

public class AltaArbolesControllerFactory
{
    private final static AltaArbolesController INSTANCE = new AltaArbolesControllerImpl();

    public final static AltaArbolesController getAltaArbolesControllerInstance()
    {
        return INSTANCE;
    }
}