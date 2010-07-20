// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

public class ResultadosBuscarObjetoControllerFactory
{
    private final static ResultadosBuscarObjetoController INSTANCE = new ResultadosBuscarObjetoControllerImpl();

    public final static ResultadosBuscarObjetoController getResultadosBuscarObjetoControllerInstance()
    {
        return INSTANCE;
    }
}