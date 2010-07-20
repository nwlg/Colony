// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

public class DetalleClasificacionControllerFactory
{
    private final static DetalleClasificacionController INSTANCE = new DetalleClasificacionControllerImpl();

    public final static DetalleClasificacionController getDetalleClasificacionControllerInstance()
    {
        return INSTANCE;
    }
}