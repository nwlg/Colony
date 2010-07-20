// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * 
 */
public final class GestorArchivosSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GestorArchivosSubmitFormImpl specificForm = (GestorArchivosSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _pegar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().pegar(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = _vaciarPortapapeles(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cortar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().cortar(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = _cargarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _copiar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().copiar(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = _cargarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _comprobarReferencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __comprobarReferencias(mapping, form, request, response);
        return forward;
    }

    /**
     * <p>
     * Envia las filas de la tabla (ArchivoVO) para realizar una
     * acción. El tipo de acción se discrimina en función del valor del
     * boton submit que haya enviado el formulario.
     * </p>
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().submit(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * <p>
     * Vacia el contenido del portapapeles y reajusta los valores de
     * modoPegar y accion.
     * </p>
     */
    private org.apache.struts.action.ActionForward _vaciarPortapapeles(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().vaciarPortapapeles(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = _cargarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().eliminar(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = _cargarDatos(mapping, form, request, response);


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

        es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().cargarDatos(mapping, (GestorArchivosSubmitFormImpl)form, request, response);
        forward = mapping.findForward("gestor.archivos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __comprobarReferencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().comprobarReferencias(mapping, (GestorArchivosSubmitFormImpl)form, request, response));

        if (value.equals("No"))
        {
            return _eliminar(mapping, form, request, response);
        }
        if (value.equals("Si"))
        {
            return mapping.findForward("advertencia");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("advertencia");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosControllerFactory.getGestorArchivosControllerInstance().selectAction(mapping, (GestorArchivosSubmitFormImpl)form, request, response));

        if (value.equals("CrearCarpeta"))
        {
            return mapping.findForward("crear.carpeta");
        }
        if (value.equals("CrearArchivo"))
        {
            return mapping.findForward("crear.archivo");
        }
        if (value.equals("Copiar"))
        {
            return _copiar(mapping, form, request, response);
        }
        if (value.equals("Cortar"))
        {
            return _cortar(mapping, form, request, response);
        }
        if (value.equals("Pegar"))
        {
            return _pegar(mapping, form, request, response);
        }
        if (value.equals("Eliminar"))
        {
            return _comprobarReferencias(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _comprobarReferencias(mapping, form, request, response);
    }

}
