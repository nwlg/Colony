// license-header java merge-point
package es.pode.modificador.presentacion.importar;

public class ImportarModificacionControllerFactory
{
    private final static ImportarModificacionController INSTANCE = new ImportarModificacionControllerImpl();

    public final static ImportarModificacionController getImportarModificacionControllerInstance()
    {
        return INSTANCE;
    }
}