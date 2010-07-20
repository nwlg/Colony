// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPropuestos;

public class ObjetosPropuestosControllerFactory
{
    private final static ObjetosPropuestosController INSTANCE = new ObjetosPropuestosControllerImpl();

    public final static ObjetosPropuestosController getObjetosPropuestosControllerInstance()
    {
        return INSTANCE;
    }
}