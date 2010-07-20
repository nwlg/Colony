// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.altaCatalogadores;

public class AltaCatalogadoresControllerFactory
{
    private final static AltaCatalogadoresController INSTANCE = new AltaCatalogadoresControllerImpl();

    public final static AltaCatalogadoresController getAltaCatalogadoresControllerInstance()
    {
        return INSTANCE;
    }
}