// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion;

public class DetalleAnotacionControllerFactory
{
    private final static DetalleAnotacionController INSTANCE = new DetalleAnotacionControllerImpl();

    public final static DetalleAnotacionController getDetalleAnotacionControllerInstance()
    {
        return INSTANCE;
    }
}