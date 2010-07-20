// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

/**
 * 
 */
public final class EnviarMailCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EnviarMailCUFormImpl specificForm = (EnviarMailCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEEnviarMailFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEEnviarMailFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEEnviarMailFormImpl)previousFormObject;
            specificForm.setUrlODE(previousForm.getUrlODE());
            specificForm.setMostrarVuelta(previousForm.getMostrarVuelta());
            specificForm.setIdentificadorODE(previousForm.getIdentificadorODE());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _prepararEnvio(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _prepararEnvio(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.enviarMail.EnviarMailControllerFactory.getEnviarMailControllerInstance().prepararEnvio(mapping, (EnviarMailCUFormImpl)form, request, response);
        forward = mapping.findForward("envio.mail");


        return forward;
    }

}
