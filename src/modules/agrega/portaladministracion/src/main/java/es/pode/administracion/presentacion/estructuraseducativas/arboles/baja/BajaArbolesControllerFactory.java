// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.arboles.baja;

public class BajaArbolesControllerFactory
{
    private final static BajaArbolesController INSTANCE = new BajaArbolesControllerImpl();

    public final static BajaArbolesController getBajaArbolesControllerInstance()
    {
        return INSTANCE;
    }
}