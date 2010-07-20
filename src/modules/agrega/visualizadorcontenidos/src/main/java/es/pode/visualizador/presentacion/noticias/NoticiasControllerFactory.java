// license-header java merge-point
package es.pode.visualizador.presentacion.noticias;

public class NoticiasControllerFactory
{
    private final static NoticiasController INSTANCE = new NoticiasControllerImpl();

    public final static NoticiasController getNoticiasControllerInstance()
    {
        return INSTANCE;
    }
}