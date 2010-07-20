// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.tipo;

public class CrearRecursoAvanzadoTipoControllerFactory
{
    private final static CrearRecursoAvanzadoTipoController INSTANCE = new CrearRecursoAvanzadoTipoControllerImpl();

    public final static CrearRecursoAvanzadoTipoController getCrearRecursoAvanzadoTipoControllerInstance()
    {
        return INSTANCE;
    }
}