// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial;

/**
 * 
 */
public final class VerHistorialCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final VerHistorialCUFormImpl specificForm = (VerHistorialCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPropuestos.MostrarODESPropuestosVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPropuestos.MostrarODESPropuestosVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPropuestos.MostrarODESPropuestosVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPersonales.MostrarODESPersonalesVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPublicados.MostrarODESPublicadosVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPublicados.MostrarODESPublicadosVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPublicados.MostrarODESPublicadosVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosDespublicados.MostrarODESDespublicadosVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.MostrarODESPendientesVerHistorialFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.MostrarODESPendientesVerHistorialFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.MostrarODESPendientesVerHistorialFormImpl)previousFormObject;
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setIdODE(previousForm.getIdODE());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarHistorial(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargarHistorial(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial.VerHistorialControllerFactory.getVerHistorialControllerInstance().cargarHistorialODE(mapping, (VerHistorialCUFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.historial");


        return forward;
    }

}
