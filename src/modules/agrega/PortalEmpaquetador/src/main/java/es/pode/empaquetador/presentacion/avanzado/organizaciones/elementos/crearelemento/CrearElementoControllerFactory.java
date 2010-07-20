// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

public class CrearElementoControllerFactory
{
    private final static CrearElementoController INSTANCE = new CrearElementoControllerImpl();

    public final static CrearElementoController getCrearElementoControllerInstance()
    {
        return INSTANCE;
    }
}