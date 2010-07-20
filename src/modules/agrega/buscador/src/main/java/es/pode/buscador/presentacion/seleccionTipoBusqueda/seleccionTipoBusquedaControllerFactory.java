// license-header java merge-point
package es.pode.buscador.presentacion.seleccionTipoBusqueda;

public class seleccionTipoBusquedaControllerFactory
{
    private final static seleccionTipoBusquedaController INSTANCE = new seleccionTipoBusquedaControllerImpl();

    public final static seleccionTipoBusquedaController getseleccionTipoBusquedaControllerInstance()
    {
        return INSTANCE;
    }
}