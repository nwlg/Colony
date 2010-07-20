// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar;

/**
 * 
 */
public final class EliminarCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EliminarCUFormImpl specificForm = (EliminarCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosEliminarFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosEliminarFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosEliminarFormImpl)previousFormObject;
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

        es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarControllerFactory.getEliminarControllerInstance().cargarDatos(mapping, (EliminarCUFormImpl)form, request, response);
        forward = __analizaSelec(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaSelec(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarControllerFactory.getEliminarControllerInstance().analizaSelec(mapping, (EliminarCUFormImpl)form, request, response));

        if (value.equals("ALGUN_ODE_SELEC"))
        {
            return mapping.findForward("confirmacion");
        }
        if (value.equals("NINGUN_ODE_SELEC"))
        {
            return mapping.findForward("objetos.despublicados.cu");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("objetos.despublicados.cu");
    }

}
