// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo;

public class DetalleUsoEduControllerFactory
{
    private final static DetalleUsoEduController INSTANCE = new DetalleUsoEduControllerImpl();

    public final static DetalleUsoEduController getDetalleUsoEduControllerInstance()
    {
        return INSTANCE;
    }
}