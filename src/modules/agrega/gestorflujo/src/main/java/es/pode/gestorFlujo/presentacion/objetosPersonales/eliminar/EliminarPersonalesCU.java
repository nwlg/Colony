// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar;

/**
 * 
 */
public final class EliminarPersonalesCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EliminarPersonalesCUFormImpl specificForm = (EliminarPersonalesCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesEliminarFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesEliminarFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesEliminarFormImpl)previousFormObject;
            specificForm.setListODEs(previousForm.getListODEs());
            specificForm.setOrigen(previousForm.getOrigen());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarDatosEliminar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargarDatosEliminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesControllerFactory.geteliminarPersonalesControllerInstance().cargarDatos(mapping, (EliminarPersonalesCUFormImpl)form, request, response);
        forward = __analizaSelec(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaSelec(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar.eliminarPersonalesControllerFactory.geteliminarPersonalesControllerInstance().analizaSelec(mapping, (EliminarPersonalesCUFormImpl)form, request, response));

        if (value.equals("ALGUN_ODE_SELEC"))
        {
            return mapping.findForward("confirmacion");
        }
        if (value.equals("NINGUN_ODE_SELEC"))
        {
            return mapping.findForward("objetos.personales.cu");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("objetos.personales.cu");
    }

}
