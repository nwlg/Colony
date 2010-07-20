// license-header java merge-point
package es.pode.visualizador.presentacion.contenidoDinamico;

public class ContenidoDinamicoControllerFactory
{
    private final static ContenidoDinamicoController INSTANCE = new ContenidoDinamicoControllerImpl();

    public final static ContenidoDinamicoController getContenidoDinamicoControllerInstance()
    {
        return INSTANCE;
    }
}