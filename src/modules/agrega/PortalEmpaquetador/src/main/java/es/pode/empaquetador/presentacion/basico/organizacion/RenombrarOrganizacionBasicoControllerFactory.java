// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.organizacion;

public class RenombrarOrganizacionBasicoControllerFactory
{
    private final static RenombrarOrganizacionBasicoController INSTANCE = new RenombrarOrganizacionBasicoControllerImpl();

    public final static RenombrarOrganizacionBasicoController getRenombrarOrganizacionBasicoControllerInstance()
    {
        return INSTANCE;
    }
}