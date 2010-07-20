// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

/**
 * 
 */
public final class CategoriasFormVolverA extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _volverA(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _volverA(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosControllerFactory.getVerMetadatosControllerInstance().volverA(mapping, new VolverAForm(){}, request, response);
        forward = null;


        return forward;
    }

}
