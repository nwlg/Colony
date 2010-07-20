// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosDespublicados;

/**
 * 
 */
public final class ObjetosDespublicadosCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ObjetosDespublicadosCUFormImpl specificForm = (ObjetosDespublicadosCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODECancelarFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODECancelarFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODECancelarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesDespublicadosFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesDespublicadosFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPendientes.MostrarODESPendientesDespublicadosFormImpl)previousFormObject;
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarCUFormImpl)
        {
            final es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarCUFormImpl previousForm = (es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.EliminarCUFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargaODESDespublicados(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargaODESDespublicados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.gestorFlujo.presentacion.objetosDespublicados.ObjetosDespublicadosControllerFactory.getObjetosDespublicadosControllerInstance().cargarODESDespublicados(mapping, (ObjetosDespublicadosCUFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.odesdespublicados");


        return forward;
    }

}
