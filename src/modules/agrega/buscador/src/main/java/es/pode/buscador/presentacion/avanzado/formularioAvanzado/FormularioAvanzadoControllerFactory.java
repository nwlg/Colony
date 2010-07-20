// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.formularioAvanzado;

public class FormularioAvanzadoControllerFactory
{
    private final static FormularioAvanzadoController INSTANCE = new FormularioAvanzadoControllerImpl();

    public final static FormularioAvanzadoController getFormularioAvanzadoControllerInstance()
    {
        return INSTANCE;
    }
}