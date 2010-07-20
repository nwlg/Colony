// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importar;

public class ImportarControllerFactory
{
    private final static ImportarController INSTANCE = new ImportarControllerImpl();

    public final static ImportarController getImportarControllerInstance()
    {
        return INSTANCE;
    }
}