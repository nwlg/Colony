// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.importar;

public class ImportarControllerFactory
{
    private final static ImportarController INSTANCE = new ImportarControllerImpl();

    public final static ImportarController getImportarControllerInstance()
    {
        return INSTANCE;
    }
}