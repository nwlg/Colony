// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.modificarCatalogadores;

public class modificarCatalogadoresControllerFactory
{
    private final static modificarCatalogadoresController INSTANCE = new modificarCatalogadoresControllerImpl();

    public final static modificarCatalogadoresController getmodificarCatalogadoresControllerInstance()
    {
        return INSTANCE;
    }
}