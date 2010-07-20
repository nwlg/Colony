// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

/**
 * 
 */
public final class CrearElemento extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CrearElementoFormImpl specificForm = (CrearElementoFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosModificarElementoFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosModificarElementoFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosModificarElementoFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperaSesion(mapping, form, request, response);
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
     * Comprueba si hay un objeto de sesion CrearElementoSession. En
     * caso de que lo haya y tenga esModificar a true, envia los datos
     * en la señal de salida para inicializar el formulario. Si no hay
     * objeto de sesion lo genera y pone el flag a false.
     * </p>
     */
    private org.apache.struts.action.ActionForward _recuperaSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().recuperarSesion(mapping, (CrearElementoFormImpl)form, request, response);
        forward = mapping.findForward("crear.elemento01");


        return forward;
    }

}
