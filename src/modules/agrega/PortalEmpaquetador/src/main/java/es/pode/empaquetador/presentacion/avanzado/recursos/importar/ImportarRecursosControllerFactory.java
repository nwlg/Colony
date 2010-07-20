// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.importar;

public class ImportarRecursosControllerFactory
{
    private final static ImportarRecursosController INSTANCE = new ImportarRecursosControllerImpl();

    public final static ImportarRecursosController getImportarRecursosControllerInstance()
    {
        return INSTANCE;
    }
}