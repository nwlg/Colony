// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

public class DetallarControllerFactory
{
    private final static DetallarController INSTANCE = new DetallarControllerImpl();

    public final static DetallarController getDetallarControllerInstance()
    {
        return INSTANCE;
    }
}