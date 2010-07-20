// license-header java merge-point
package es.pode.administracion.presentacion.noticias.noticias;

public class NoticiasControllerFactory
{
    private final static NoticiasController INSTANCE = new NoticiasControllerImpl();

    public final static NoticiasController getNoticiasControllerInstance()
    {
        return INSTANCE;
    }
}