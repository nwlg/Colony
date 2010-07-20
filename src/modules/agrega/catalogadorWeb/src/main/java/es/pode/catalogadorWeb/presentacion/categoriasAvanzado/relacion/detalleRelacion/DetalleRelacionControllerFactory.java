// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion;

public class DetalleRelacionControllerFactory
{
    private final static DetalleRelacionController INSTANCE = new DetalleRelacionControllerImpl();

    public final static DetalleRelacionController getDetalleRelacionControllerInstance()
    {
        return INSTANCE;
    }
}