// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.areaCurricular;

public class AreaCurricularControllerFactory
{
    private final static AreaCurricularController INSTANCE = new AreaCurricularControllerImpl();

    public final static AreaCurricularController getAreaCurricularControllerInstance()
    {
        return INSTANCE;
    }
}