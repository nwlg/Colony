// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

public class ObjetosPersonalesControllerFactory
{
    private final static ObjetosPersonalesController INSTANCE = new ObjetosPersonalesControllerImpl();

    public final static ObjetosPersonalesController getObjetosPersonalesControllerInstance()
    {
        return INSTANCE;
    }
}