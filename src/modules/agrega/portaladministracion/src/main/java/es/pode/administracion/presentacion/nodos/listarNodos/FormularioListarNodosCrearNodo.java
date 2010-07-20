// license-header java merge-point
package es.pode.administracion.presentacion.nodos.listarNodos;

/**
 * 
 */
public final class FormularioListarNodosCrearNodo extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return mapping.findForward("crear.nodo");
    }

}
