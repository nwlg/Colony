// license-header java merge-point
package es.pode.empaquetador.presentacion.catalogar;

/**
 * 
 */
public final class Catalogar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CatalogarFormImpl specificForm = (CatalogarFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosMetadatosFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosMetadatosFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosMetadatosFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosCatalogarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosCatalogarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosCatalogarFormImpl)previousFormObject;
            specificForm.setIdentificador(previousForm.getIdentificador());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoMetadatoFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoMetadatoFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoMetadatoFormImpl)previousFormObject;
            specificForm.setHref(previousForm.getHref());
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.GestorOrganizacionesMetadatosFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.GestorOrganizacionesMetadatosFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.organizaciones.gestor.GestorOrganizacionesMetadatosFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosMetadatoFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosMetadatoFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosMetadatoFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosMetadatoFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosMetadatoFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosMetadatoFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoCatalogarFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoCatalogarFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoCatalogarFormImpl)previousFormObject;
            specificForm.setIdentifier(previousForm.getIdentifier());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosCatalogarFormImpl)
        {
            final es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosCatalogarFormImpl previousForm = (es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosCatalogarFormImpl)previousFormObject;
            specificForm.setIdentificador(previousForm.getIdentificador());
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperaDatos(mapping, form, request, response);
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
     * Verifica los datos para averiguar cual es el objeto a catalogar.
     * Despues, invoca al servicio de catalogación para preparar el
     * objeto que se quiere catalogar. Despues redirije la aplicacion
     * al catalogador.
     * </p>
     */
    private org.apache.struts.action.ActionForward _catalogar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.catalogar.CatalogarControllerFactory.getCatalogarControllerInstance().catalogar(mapping, (CatalogarFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * <p>
     * Actividad vacia para documentar los datos que necesita el CU
     * Catalogar.
     * </p>
     */
    private org.apache.struts.action.ActionForward _recuperaDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = _catalogar(mapping, form, request, response);
        return forward;
    }

}
