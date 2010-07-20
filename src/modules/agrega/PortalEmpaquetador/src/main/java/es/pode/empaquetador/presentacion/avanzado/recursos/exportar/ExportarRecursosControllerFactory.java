// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.exportar;

public class ExportarRecursosControllerFactory
{
    private final static ExportarRecursosController INSTANCE = new ExportarRecursosControllerImpl();

    public final static ExportarRecursosController getExportarRecursosControllerInstance()
    {
        return INSTANCE;
    }
}