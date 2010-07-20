// license-header java merge-point
package es.pode.administracion.presentacion.noticias.verNoticia;

public class VerNoticiaControllerFactory
{
    private final static VerNoticiaController INSTANCE = new VerNoticiaControllerImpl();

    public final static VerNoticiaController getVerNoticiaControllerInstance()
    {
        return INSTANCE;
    }
}