// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

public class CatBasicPlusControllerFactory
{
    private final static CatBasicPlusController INSTANCE = new CatBasicPlusControllerImpl();

    public final static CatBasicPlusController getCatBasicPlusControllerInstance()
    {
        return INSTANCE;
    }
}