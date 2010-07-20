// license-header java merge-point
package es.pode.empaquetador.presentacion.catalogar;

public class CatalogarControllerFactory
{
    private final static CatalogarController INSTANCE = new CatalogarControllerImpl();

    public final static CatalogarController getCatalogarControllerInstance()
    {
        return INSTANCE;
    }
}