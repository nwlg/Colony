// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.ruta;

public class IndicarRutaControllerFactory
{
    private final static IndicarRutaController INSTANCE = new IndicarRutaControllerImpl();

    public final static IndicarRutaController getIndicarRutaControllerInstance()
    {
        return INSTANCE;
    }
}