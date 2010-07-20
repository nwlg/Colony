// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

/**
 * 
 */
public final class ResultadoValidacionDecide extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return __decideVuelta(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __decideVuelta(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        final java.lang.String value = java.lang.String.valueOf(es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarControllerFactory.getPublicarControllerInstance().decideVuelta(mapping, new DecideVueltaForm(){}, request, response));

        if (value.equals("false"))
        {
            return mapping.findForward("objetos.pendientes.cu");
        }
        if (value.equals("true"))
        {
            return mapping.findForward("objetos.despublicados.cu");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("objetos.despublicados.cu");
    }

}
