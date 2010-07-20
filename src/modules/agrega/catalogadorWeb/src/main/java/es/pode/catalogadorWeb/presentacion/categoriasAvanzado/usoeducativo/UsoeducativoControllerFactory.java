// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo;

public class UsoeducativoControllerFactory
{
    private final static UsoeducativoController INSTANCE = new UsoeducativoControllerImpl();

    public final static UsoeducativoController getUsoeducativoControllerInstance()
    {
        return INSTANCE;
    }
}