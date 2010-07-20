// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.exportar;

public class ExportarControllerFactory
{
    private final static ExportarController INSTANCE = new ExportarControllerImpl();

    public final static ExportarController getExportarControllerInstance()
    {
        return INSTANCE;
    }
}