// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular;

public class NavegarArbolCurricularControllerFactory
{
    private final static NavegarArbolCurricularController INSTANCE = new NavegarArbolCurricularControllerImpl();

    public final static NavegarArbolCurricularController getNavegarArbolCurricularControllerInstance()
    {
        return INSTANCE;
    }
}