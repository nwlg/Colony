// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.listarODEArea;

public class ListarODEAreaControllerFactory
{
    private final static ListarODEAreaController INSTANCE = new ListarODEAreaControllerImpl();

    public final static ListarODEAreaController getListarODEAreaControllerInstance()
    {
        return INSTANCE;
    }
}