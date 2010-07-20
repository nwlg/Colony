// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

public class CatBasicoControllerFactory
{
    private final static CatBasicoController INSTANCE = new CatBasicoControllerImpl();

    public final static CatBasicoController getCatBasicoControllerInstance()
    {
        return INSTANCE;
    }
}