// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

public class ClasificacionControllerFactory
{
    private final static ClasificacionController INSTANCE = new ClasificacionControllerImpl();

    public final static ClasificacionController getClasificacionControllerInstance()
    {
        return INSTANCE;
    }
}