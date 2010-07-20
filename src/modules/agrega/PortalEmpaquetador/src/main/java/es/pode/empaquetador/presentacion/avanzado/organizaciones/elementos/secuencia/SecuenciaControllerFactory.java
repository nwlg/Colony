// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia;

public class SecuenciaControllerFactory
{
    private final static SecuenciaController INSTANCE = new SecuenciaControllerImpl();

    public final static SecuenciaController getSecuenciaControllerInstance()
    {
        return INSTANCE;
    }
}