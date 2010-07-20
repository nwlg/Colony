// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular;

public class NavegarArbolCurricularControllerFactory
{
    private final static NavegarArbolCurricularController INSTANCE = new NavegarArbolCurricularControllerImpl();

    public final static NavegarArbolCurricularController getNavegarArbolCurricularControllerInstance()
    {
        return INSTANCE;
    }
}