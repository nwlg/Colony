// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

/**
 * <p>
 * Cierra la pantalla y vuelve a la pantalla principal del gestor
 * básico.
 * </p>
 */
public final class ValidacionErrorCerrar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _union(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _union(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esAvanzado(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.validar.ValidarControllerFactory.getValidarControllerInstance().esAvanzado(mapping, new EsAvanzadoForm(){}, request, response));

        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }
        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.archivos");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.archivos");
    }

}
