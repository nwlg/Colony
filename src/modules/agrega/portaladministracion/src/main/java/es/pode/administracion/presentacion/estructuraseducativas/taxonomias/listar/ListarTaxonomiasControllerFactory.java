// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.listar;

public class ListarTaxonomiasControllerFactory
{
    private final static ListarTaxonomiasController INSTANCE = new ListarTaxonomiasControllerImpl();

    public final static ListarTaxonomiasController getListarTaxonomiasControllerInstance()
    {
        return INSTANCE;
    }
}