// license-header java merge-point
package es.pode.visualizador.presentacion.agregaSlider;

public class AgregaSliderControllerFactory
{
    private final static AgregaSliderController INSTANCE = new AgregaSliderControllerImpl();

    public final static AgregaSliderController getAgregaSliderControllerInstance()
    {
        return INSTANCE;
    }
}