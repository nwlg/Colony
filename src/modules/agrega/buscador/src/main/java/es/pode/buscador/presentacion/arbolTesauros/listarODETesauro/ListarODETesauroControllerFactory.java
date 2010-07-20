// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

public class ListarODETesauroControllerFactory
{
    private final static ListarODETesauroController INSTANCE = new ListarODETesauroControllerImpl();

    public final static ListarODETesauroController getListarODETesauroControllerInstance()
    {
        return INSTANCE;
    }
}