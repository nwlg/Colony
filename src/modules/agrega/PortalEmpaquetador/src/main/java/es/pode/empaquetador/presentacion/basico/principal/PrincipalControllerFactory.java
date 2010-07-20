// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.principal;

public class PrincipalControllerFactory
{
    private final static PrincipalController INSTANCE = new PrincipalControllerImpl();

    public final static PrincipalController getPrincipalControllerInstance()
    {
        return INSTANCE;
    }
}