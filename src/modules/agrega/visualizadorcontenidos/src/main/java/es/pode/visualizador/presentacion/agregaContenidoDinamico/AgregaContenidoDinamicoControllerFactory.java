// license-header java merge-point
package es.pode.visualizador.presentacion.agregaContenidoDinamico;

public class AgregaContenidoDinamicoControllerFactory
{
    private final static AgregaContenidoDinamicoController INSTANCE = new AgregaContenidoDinamicoControllerImpl();

    public final static AgregaContenidoDinamicoController getAgregaContenidoDinamicoControllerInstance()
    {
        return INSTANCE;
    }
}