// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar;

/**
 * 
 */
public final class EliminarSubmanifiestos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EliminarSubmanifiestosFormImpl specificForm = (EliminarSubmanifiestosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl)previousFormObject;
            specificForm.setIdentificadores(previousForm.getIdentificadores());
            specificForm.setAction(previousForm.getAction());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarDatos(mapping, form, request, response);
        }
        catch (java.lang.Exception exception)
        {
            // we populate the current form with only the request parameters
            Object currentForm = request.getSession().getAttribute("form");
            // if we can't get the 'form' from the session, try from the request
            if (currentForm == null)
            {
                currentForm = request.getAttribute("form");
            }
            if (currentForm != null)
            {
                final java.util.Map parameters = new java.util.HashMap();
                for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
                {
                    final String name = String.valueOf(names.nextElement());
                    parameters.put(name, request.getParameter(name));
                }
                try
                {
                    org.apache.commons.beanutils.BeanUtils.populate(currentForm, parameters);
                }
                catch (java.lang.Exception populateException)
                {
                    // ignore if we have an exception here (we just don't populate).
                }
            }
            throw exception;
        }
        request.getSession().setAttribute("form", form);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosControllerFactory.getEliminarSubmanifiestosControllerInstance().eliminar(mapping, (EliminarSubmanifiestosFormImpl)form, request, response);
        forward = _borrarObjetoSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _borrarObjetoSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosControllerFactory.getEliminarSubmanifiestosControllerInstance().borrarObjetoSesion(mapping, (EliminarSubmanifiestosFormImpl)form, request, response);
        forward = mapping.findForward("gestor.submanifiestos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosControllerFactory.getEliminarSubmanifiestosControllerInstance().recuperarDatos(mapping, (EliminarSubmanifiestosFormImpl)form, request, response);
        forward = __hayReferencias(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __hayReferencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosControllerFactory.getEliminarSubmanifiestosControllerInstance().hayReferencias(mapping, (EliminarSubmanifiestosFormImpl)form, request, response));

        if (value.equals("Si"))
        {
            return mapping.findForward("advertencia");
        }
        if (value.equals("No"))
        {
            return _eliminar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _eliminar(mapping, form, request, response);
    }

}
