// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * 
 */
public final class GestorArchivos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorArchivosFormImpl specificForm = (GestorArchivosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.iniciarEmpaquetador.TituloSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.iniciarEmpaquetador.TituloSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.iniciarEmpaquetador.TituloSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.iniciarEmpaquetador.Titulo2SubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.iniciarEmpaquetador.Titulo2SubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.iniciarEmpaquetador.Titulo2SubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorFormImpl)
        {
            final es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorFormImpl previousForm = (es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosArchivosFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosArchivosFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosArchivosFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.archivos.crearcarpeta.CrearCarpetaAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.archivos.crearcarpeta.CrearCarpetaAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.archivos.crearcarpeta.CrearCarpetaAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.archivos.modificar.FormularioModificarAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.archivos.modificar.FormularioModificarAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.archivos.modificar.FormularioModificarAceptarFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarDatos(mapping, form, request, response);
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
     * Obtiene los datos iniciales necesarios para la pantalla de
     * gestion de archivos.
     * </p>
     */
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().cargarDatos(mapping, (GestorArchivosFormImpl)form, request, response);
        forward = mapping.findForward("gestor.archivos");


        return forward;
    }

}
