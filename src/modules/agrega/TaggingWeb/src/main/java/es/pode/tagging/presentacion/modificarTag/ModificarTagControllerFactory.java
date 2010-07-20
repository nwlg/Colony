// license-header java merge-point
package es.pode.tagging.presentacion.modificarTag;

public class ModificarTagControllerFactory
{
    private final static ModificarTagController INSTANCE = new ModificarTagControllerImpl();

    public final static ModificarTagController getModificarTagControllerInstance()
    {
        return INSTANCE;
    }
}