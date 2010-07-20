// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.repositorio;

/**
 * 
 */
public final class MensajeAgregarVolver extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return __tipoEmpaquetador(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __tipoEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.agregar.repositorio.AbrirBuscadorControllerFactory.getAbrirBuscadorControllerInstance().tipoEmpaquetador(mapping, new TipoEmpaquetadorForm(){}, request, response));

        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }
        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.submanifiestos");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.submanifiestos");
    }

}
