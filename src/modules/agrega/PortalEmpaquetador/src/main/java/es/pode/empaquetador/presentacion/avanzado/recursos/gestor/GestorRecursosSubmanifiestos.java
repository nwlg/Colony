// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

/**
 * 
 */
public final class GestorRecursosSubmanifiestos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return mapping.findForward("submanifiestos");
    }

}
