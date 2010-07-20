// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

public class CrearRecursoAvanzadoElementosControllerFactory
{
    private final static CrearRecursoAvanzadoElementosController INSTANCE = new CrearRecursoAvanzadoElementosControllerImpl();

    public final static CrearRecursoAvanzadoElementosController getCrearRecursoAvanzadoElementosControllerInstance()
    {
        return INSTANCE;
    }
}