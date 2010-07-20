// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.bajaCatalogadores;

public class BajaCatalogadoresControllerFactory
{
    private final static BajaCatalogadoresController INSTANCE = new BajaCatalogadoresControllerImpl();

    public final static BajaCatalogadoresController getBajaCatalogadoresControllerInstance()
    {
        return INSTANCE;
    }
}