// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.crear;

/**
 * 
 */
public final class OrganizacionSubmanifiestos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _submanifiestos(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submanifiestos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionControllerFactory.getCrearOrganizacionControllerInstance().terminarCreacion(mapping, new TerminarCreacionForm(){}, request, response);
        forward = mapping.findForward("gestor.submanifiestos");


        return forward;
    }

}
