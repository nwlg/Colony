// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar;

public class rechazarPendCatalogacionControllerFactory
{
    private final static rechazarPendCatalogacionController INSTANCE = new rechazarPendCatalogacionControllerImpl();

    public final static rechazarPendCatalogacionController getrechazarPendCatalogacionControllerInstance()
    {
        return INSTANCE;
    }
}