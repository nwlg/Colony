// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPublicados;

public class ObjetosPublicadosControllerFactory
{
    private final static ObjetosPublicadosController INSTANCE = new ObjetosPublicadosControllerImpl();

    public final static ObjetosPublicadosController getObjetosPublicadosControllerInstance()
    {
        return INSTANCE;
    }
}