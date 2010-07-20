// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.crearcarpeta;

public class CrearCarpetaControllerFactory
{
    private final static CrearCarpetaController INSTANCE = new CrearCarpetaControllerImpl();

    public final static CrearCarpetaController getCrearCarpetaControllerInstance()
    {
        return INSTANCE;
    }
}