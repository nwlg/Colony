// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.verCatalogadores;

public class verCatalogadoresControllerFactory
{
    private final static verCatalogadoresController INSTANCE = new verCatalogadoresControllerImpl();

    public final static verCatalogadoresController getverCatalogadoresControllerInstance()
    {
        return INSTANCE;
    }
}