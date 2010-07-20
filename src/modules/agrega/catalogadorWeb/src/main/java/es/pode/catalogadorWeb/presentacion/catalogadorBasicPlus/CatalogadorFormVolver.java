// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * <p>
 * Vuelta al Empaquetador Basico
 * </p>
 */
public final class CatalogadorFormVolver extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _volverAEmpaquetador(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _volverAEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusControllerFactory.getCatBasicPlusControllerInstance().volverAEmpaquetador(mapping, (VolverAEmpaquetadorForm)new CatalogadorBasicPlusFormImpl(), request, response);
        forward = null;


        return forward;
    }

}
