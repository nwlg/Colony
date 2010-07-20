// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion;

public class ProponerCatalogacionControllerFactory
{
    private final static ProponerCatalogacionController INSTANCE = new ProponerCatalogacionControllerImpl();

    public final static ProponerCatalogacionController getProponerCatalogacionControllerInstance()
    {
        return INSTANCE;
    }
}