// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

/**
 * 
 */
public final class ObjectArchivos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _archivos(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _archivos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().borrarSesion(mapping, new BorrarSesionForm(){}, request, response);
        forward = mapping.findForward("gestor.archivos");


        return forward;
    }

}
