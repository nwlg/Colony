// license-header java merge-point
package es.pode.visualizador.presentacion.conexionFlash;

public class conexionFlashControllerFactory
{
    private final static conexionFlashController INSTANCE = new conexionFlashControllerImpl();

    public final static conexionFlashController getconexionFlashControllerInstance()
    {
        return INSTANCE;
    }
}