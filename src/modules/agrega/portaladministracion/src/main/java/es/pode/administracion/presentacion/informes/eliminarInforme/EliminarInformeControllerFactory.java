// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInforme;

public class EliminarInformeControllerFactory
{
    private final static EliminarInformeController INSTANCE = new EliminarInformeControllerImpl();

    public final static EliminarInformeController getEliminarInformeControllerInstance()
    {
        return INSTANCE;
    }
}