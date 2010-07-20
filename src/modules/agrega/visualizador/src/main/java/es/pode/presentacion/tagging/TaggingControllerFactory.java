// license-header java merge-point
package es.pode.presentacion.tagging;

public class TaggingControllerFactory
{
    private final static TaggingController INSTANCE = new TaggingControllerImpl();

    public final static TaggingController getTaggingControllerInstance()
    {
        return INSTANCE;
    }
}