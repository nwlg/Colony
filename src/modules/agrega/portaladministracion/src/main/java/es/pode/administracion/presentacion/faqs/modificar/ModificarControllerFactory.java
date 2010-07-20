// license-header java merge-point
package es.pode.administracion.presentacion.faqs.modificar;

public class ModificarControllerFactory
{
    private final static ModificarController INSTANCE = new ModificarControllerImpl();

    public final static ModificarController getModificarControllerInstance()
    {
        return INSTANCE;
    }
}