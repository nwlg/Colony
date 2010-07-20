// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;

public class NoticiaControllerFactory
{
    private final static NoticiaController INSTANCE = new NoticiaControllerImpl();

    public final static NoticiaController getNoticiaControllerInstance()
    {
        return INSTANCE;
    }
}