// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion;

public class ObjetosPendientesCatalogacionControllerFactory
{
    private final static ObjetosPendientesCatalogacionController INSTANCE = new ObjetosPendientesCatalogacionControllerImpl();

    public final static ObjetosPendientesCatalogacionController getObjetosPendientesCatalogacionControllerInstance()
    {
        return INSTANCE;
    }
}