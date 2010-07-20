// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

public class CiclodevidaControllerFactory
{
    private final static CiclodevidaController INSTANCE = new CiclodevidaControllerImpl();

    public final static CiclodevidaController getCiclodevidaControllerInstance()
    {
        return INSTANCE;
    }
}