// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.carpeta;

public class CrearCarpetaBasicoControllerFactory
{
    private final static CrearCarpetaBasicoController INSTANCE = new CrearCarpetaBasicoControllerImpl();

    public final static CrearCarpetaBasicoController getCrearCarpetaBasicoControllerInstance()
    {
        return INSTANCE;
    }
}