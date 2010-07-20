// license-header java merge-point
package es.pode.administracion.presentacion.nodos.modificarNodo;

public class ModificarNodoControllerFactory
{
    private final static ModificarNodoController INSTANCE = new ModificarNodoControllerImpl();

    public final static ModificarNodoController getModificarNodoControllerInstance()
    {
        return INSTANCE;
    }
}