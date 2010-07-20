// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

public class CrearRecursoAvanzadoArchivosControllerFactory
{
    private final static CrearRecursoAvanzadoArchivosController INSTANCE = new CrearRecursoAvanzadoArchivosControllerImpl();

    public final static CrearRecursoAvanzadoArchivosController getCrearRecursoAvanzadoArchivosControllerInstance()
    {
        return INSTANCE;
    }
}