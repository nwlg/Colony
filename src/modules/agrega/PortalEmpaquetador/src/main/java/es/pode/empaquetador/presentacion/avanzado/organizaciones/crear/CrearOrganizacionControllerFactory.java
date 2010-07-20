// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.crear;

public class CrearOrganizacionControllerFactory
{
    private final static CrearOrganizacionController INSTANCE = new CrearOrganizacionControllerImpl();

    public final static CrearOrganizacionController getCrearOrganizacionControllerInstance()
    {
        return INSTANCE;
    }
}