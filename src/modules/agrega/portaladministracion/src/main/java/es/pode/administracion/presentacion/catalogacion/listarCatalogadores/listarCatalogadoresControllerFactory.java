// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.listarCatalogadores;

public class listarCatalogadoresControllerFactory
{
    private final static listarCatalogadoresController INSTANCE = new listarCatalogadoresControllerImpl();

    public final static listarCatalogadoresController getlistarCatalogadoresControllerInstance()
    {
        return INSTANCE;
    }
}