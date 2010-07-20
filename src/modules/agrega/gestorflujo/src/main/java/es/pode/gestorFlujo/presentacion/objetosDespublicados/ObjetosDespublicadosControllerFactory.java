// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosDespublicados;

public class ObjetosDespublicadosControllerFactory
{
    private final static ObjetosDespublicadosController INSTANCE = new ObjetosDespublicadosControllerImpl();

    public final static ObjetosDespublicadosController getObjetosDespublicadosControllerInstance()
    {
        return INSTANCE;
    }
}