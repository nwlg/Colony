// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaGrupo;

public class BajaControllerFactory
{
    private final static BajaController INSTANCE = new BajaControllerImpl();

    public final static BajaController getBajaControllerInstance()
    {
        return INSTANCE;
    }
}