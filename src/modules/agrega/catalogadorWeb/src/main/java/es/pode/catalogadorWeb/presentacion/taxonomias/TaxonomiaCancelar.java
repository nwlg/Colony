// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.taxonomias;

/**
 * 
 */
public final class TaxonomiaCancelar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _decidirElCatalogador(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _decidirElCatalogador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __decidirCatalogador(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __decidirCatalogador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiasControllerFactory.getTaxonomiasControllerInstance().decidirCatalogador(mapping, new DecidirCatalogadorForm(){}, request, response));

        if (value.equals("Basico"))
        {
            return mapping.findForward("catalogador.basico");
        }
        if (value.equals("Avanzado"))
        {
            return mapping.findForward("detalle.clasificacion");
        }
        if (value.equals("BasicPlus"))
        {
            return mapping.findForward("catalogador.basic.plus");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.basic.plus");
    }

}
