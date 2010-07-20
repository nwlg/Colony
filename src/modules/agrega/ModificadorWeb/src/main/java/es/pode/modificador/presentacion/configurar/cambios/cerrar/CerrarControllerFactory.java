// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.cerrar;

public class CerrarControllerFactory
{
    private final static CerrarController INSTANCE = new CerrarControllerImpl();

    public final static CerrarController getCerrarControllerInstance()
    {
        return INSTANCE;
    }
}