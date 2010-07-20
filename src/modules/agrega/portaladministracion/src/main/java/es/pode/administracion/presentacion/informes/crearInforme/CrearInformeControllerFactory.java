// license-header java merge-point
package es.pode.administracion.presentacion.informes.crearInforme;

public class CrearInformeControllerFactory
{
    private final static CrearInformeController INSTANCE = new CrearInformeControllerImpl();

    public final static CrearInformeController getCrearInformeControllerInstance()
    {
        return INSTANCE;
    }
}