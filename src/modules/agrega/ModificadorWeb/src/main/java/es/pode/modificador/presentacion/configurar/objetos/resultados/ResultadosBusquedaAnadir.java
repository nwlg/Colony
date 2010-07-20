// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

/**
 * 
 */
public final class ResultadosBusquedaAnadir extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _guardar(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _guardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoControllerFactory.getResultadosBuscarObjetoControllerInstance().guardarSeleccionados(mapping, new GuardarSeleccionadosForm(){}, request, response);
        forward = mapping.findForward("configurar.modificacion");


        return forward;
    }

}
