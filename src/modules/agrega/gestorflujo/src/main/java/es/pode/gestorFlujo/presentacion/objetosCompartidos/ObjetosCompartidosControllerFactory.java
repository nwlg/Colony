// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos;

public class ObjetosCompartidosControllerFactory
{
    private final static ObjetosCompartidosController INSTANCE = new ObjetosCompartidosControllerImpl();

    public final static ObjetosCompartidosController getObjetosCompartidosControllerInstance()
    {
        return INSTANCE;
    }
}