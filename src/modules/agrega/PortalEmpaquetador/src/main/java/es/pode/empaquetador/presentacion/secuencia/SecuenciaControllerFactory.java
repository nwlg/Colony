// license-header java merge-point
package es.pode.empaquetador.presentacion.secuencia;

public class SecuenciaControllerFactory
{
    private final static SecuenciaController INSTANCE = new SecuenciaControllerImpl();

    public final static SecuenciaController getSecuenciaControllerInstance()
    {
        return INSTANCE;
    }
}