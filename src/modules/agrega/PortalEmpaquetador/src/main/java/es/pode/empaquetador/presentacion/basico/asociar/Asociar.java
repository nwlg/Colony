// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

/**
 * 
 */
public final class Asociar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final AsociarFormImpl specificForm = (AsociarFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoAsociarFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoAsociarFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoAsociarFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosSubmitFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _crearSesion(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _crearSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().crearSesion(mapping, (AsociarFormImpl)form, request, response);
        forward = mapping.findForward("seleccionar");


        return forward;
    }

}
