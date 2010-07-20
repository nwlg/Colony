// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica;

public class TecnicaControllerFactory
{
    private final static TecnicaController INSTANCE = new TecnicaControllerImpl();

    public final static TecnicaController getTecnicaControllerInstance()
    {
        return INSTANCE;
    }
}