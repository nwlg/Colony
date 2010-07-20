// license-header java merge-point
package es.pode.buscador.presentacion.basico.descargar;

public class DescargarControllerFactory
{
    private final static DescargarController INSTANCE = new DescargarControllerImpl();

    public final static DescargarController getDescargarControllerInstance()
    {
        return INSTANCE;
    }
}