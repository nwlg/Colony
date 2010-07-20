// license-header java merge-point
package es.pode.visualizador.presentacion.idioma;

public class IdiomaControllerFactory
{
    private final static IdiomaController INSTANCE = new IdiomaControllerImpl();

    public final static IdiomaController getIdiomaControllerInstance()
    {
        return INSTANCE;
    }
}