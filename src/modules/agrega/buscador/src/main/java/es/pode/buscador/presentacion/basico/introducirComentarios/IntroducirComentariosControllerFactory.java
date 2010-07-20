// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

public class IntroducirComentariosControllerFactory
{
    private final static IntroducirComentariosController INSTANCE = new IntroducirComentariosControllerImpl();

    public final static IntroducirComentariosController getIntroducirComentariosControllerInstance()
    {
        return INSTANCE;
    }
}