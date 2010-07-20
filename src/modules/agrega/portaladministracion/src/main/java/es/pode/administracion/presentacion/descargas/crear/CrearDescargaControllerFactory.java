// license-header java merge-point
package es.pode.administracion.presentacion.descargas.crear;

public class CrearDescargaControllerFactory
{
    private final static CrearDescargaController INSTANCE = new CrearDescargaControllerImpl();

    public final static CrearDescargaController getCrearDescargaControllerInstance()
    {
        return INSTANCE;
    }
}