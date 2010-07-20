// license-header java merge-point
package es.pode.administracion.presentacion.planificador.informeTrabajo;

/**
 * 
 */
public final class Informe extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final InformeFormImpl specificForm = (InformeFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.ListarInformeFormImpl)
        {
            final es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.ListarInformeFormImpl previousForm = (es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.ListarInformeFormImpl)previousFormObject;
            specificForm.setId(previousForm.getId());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargar(mapping, form, request, response);
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
     * <p>
     * Obtención de los trabajos pertenecientes a una tarea ejecutada
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.administracion.presentacion.planificador.informeTrabajo.InformeControllerFactory.getInformeControllerInstance().obtenerInformeTrabajo(mapping, (InformeFormImpl)form, request, response);
        forward = mapping.findForward("listar");


        return forward;
    }

}
