// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.principal;

public class OrganizacionPrincipalControllerFactory
{
    private final static OrganizacionPrincipalController INSTANCE = new OrganizacionPrincipalControllerImpl();

    public final static OrganizacionPrincipalController getOrganizacionPrincipalControllerInstance()
    {
        return INSTANCE;
    }
}