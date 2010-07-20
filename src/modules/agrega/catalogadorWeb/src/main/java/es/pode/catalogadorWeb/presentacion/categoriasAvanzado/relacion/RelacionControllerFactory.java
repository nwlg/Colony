// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

public class RelacionControllerFactory
{
    private final static RelacionController INSTANCE = new RelacionControllerImpl();

    public final static RelacionController getRelacionControllerInstance()
    {
        return INSTANCE;
    }
}