// license-header java merge-point
package es.pode.visualizador.presentacion.recuerdoUsuario;

public class RecuerdoControllerFactory
{
    private final static RecuerdoController INSTANCE = new RecuerdoControllerImpl();

    public final static RecuerdoController getRecuerdoControllerInstance()
    {
        return INSTANCE;
    }
}