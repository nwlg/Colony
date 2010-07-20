// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

/**
 * 
 */
public final class GestorBasico extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorBasicoFormImpl specificForm = (GestorBasicoFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.secuencia.SecuenciaAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.secuencia.SecuenciaAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.secuencia.SecuenciaAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.salir.ConfirmacionGuardarSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.salir.ConfirmacionGuardarSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.salir.ConfirmacionGuardarSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.previsualizar.TipoVisualizadorAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.previsualizar.TipoVisualizadorAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.previsualizar.TipoVisualizadorAceptarFormImpl)previousFormObject;
        }
        else
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
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.carpeta.CrearCarpetaSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.carpeta.CrearCarpetaSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.carpeta.CrearCarpetaSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.desagregar.DestinoSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.desagregar.DestinoSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.desagregar.DestinoSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.principal.PrincipalSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.principal.PrincipalSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.principal.PrincipalSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.asociar.SeleccionarSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.asociar.SeleccionarSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.asociar.SeleccionarSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosEstructuraFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosEstructuraFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosEstructuraFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.organizacion.RenombrarSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.organizacion.RenombrarSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.organizacion.RenombrarSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.local.SubirArchivoAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.personales.ObjetosPersonalesAceptarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl)
        {
            final es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl previousForm = (es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenAceptarFormImpl)previousFormObject;
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
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerFactory.getGestorBasicoControllerInstance().recuperarDatos(mapping, (GestorBasicoFormImpl)form, request, response);
        forward = mapping.findForward("gestor.basico");


        return forward;
    }

}
