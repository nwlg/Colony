// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

public class CatAvanzadoControllerFactory
{
    private final static CatAvanzadoController INSTANCE = new CatAvanzadoControllerImpl();

    public final static CatAvanzadoController getCatAvanzadoControllerInstance()
    {
        return INSTANCE;
    }
}