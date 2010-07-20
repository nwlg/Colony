// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.inicioCatalogador;

/**
 * 
 */
public final class InicioCatalogador extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _inicio(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _inicio(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.catalogadorWeb.presentacion.inicioCatalogador.InicioControllerFactory.getInicioControllerInstance().crearSesion(mapping, new CrearSesionForm(){}, request, response);
        forward = __cargarTipoCatalogador(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __cargarTipoCatalogador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.inicioCatalogador.InicioControllerFactory.getInicioControllerInstance().cargarTipoCatalogador(mapping, new CargarTipoCatalogadorForm(){}, request, response));

        if (value.equals("Basico"))
        {
            return mapping.findForward("catalogador.basico");
        }
        if (value.equals("Avanzado"))
        {
            return mapping.findForward("catalogador.avanzado");
        }
        if (value.equals("BasicPlus"))
        {
            return mapping.findForward("catalogador.basic.plus");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.basic.plus");
    }

}
