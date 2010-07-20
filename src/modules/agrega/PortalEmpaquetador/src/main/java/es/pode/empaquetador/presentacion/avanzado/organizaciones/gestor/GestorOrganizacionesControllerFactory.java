// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor;

public class GestorOrganizacionesControllerFactory
{
    private final static GestorOrganizacionesController INSTANCE = new GestorOrganizacionesControllerImpl();

    public final static GestorOrganizacionesController getGestorOrganizacionesControllerInstance()
    {
        return INSTANCE;
    }
}