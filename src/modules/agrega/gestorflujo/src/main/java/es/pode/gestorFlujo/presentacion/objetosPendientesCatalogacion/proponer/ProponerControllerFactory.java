// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer;

public class ProponerControllerFactory
{
    private final static ProponerController INSTANCE = new ProponerControllerImpl();

    public final static ProponerController getProponerControllerInstance()
    {
        return INSTANCE;
    }
}