// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos;

public class ImportarCompartidosControllerFactory
{
    private final static ImportarCompartidosController INSTANCE = new ImportarCompartidosControllerImpl();

    public final static ImportarCompartidosController getImportarCompartidosControllerInstance()
    {
        return INSTANCE;
    }
}