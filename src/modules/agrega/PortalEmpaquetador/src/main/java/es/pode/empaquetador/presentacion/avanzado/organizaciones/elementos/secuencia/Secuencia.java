// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia;

/**
 * 
 */
public final class Secuencia extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SecuenciaFormImpl specificForm = (SecuenciaFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSecuenciaFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSecuenciaFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosSecuenciaFormImpl)previousFormObject;
            specificForm.setForwardOnly(previousForm.getForwardOnly());
            specificForm.setChoice(previousForm.getChoice());
            specificForm.setChoiceExit(previousForm.getChoiceExit());
            specificForm.setFlow(previousForm.getFlow());
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
     * <p>
     * Analiza los datos de entrada para comprobar si el objeto ya
     * tenia secuencia (editar) o si se inicializa el formulario con la
     * secuencia por defecto (asociar secuencia por primera vez).
     * </p>
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().recuperarDatos(mapping, (SecuenciaFormImpl)form, request, response);
        forward = mapping.findForward("editar.secuencia");


        return forward;
    }

}
