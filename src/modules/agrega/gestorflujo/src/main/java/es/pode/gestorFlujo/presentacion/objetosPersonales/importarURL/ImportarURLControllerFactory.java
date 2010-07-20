// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL;

public class ImportarURLControllerFactory
{
    private final static ImportarURLController INSTANCE = new ImportarURLControllerImpl();

    public final static ImportarURLController getImportarURLControllerInstance()
    {
        return INSTANCE;
    }
}