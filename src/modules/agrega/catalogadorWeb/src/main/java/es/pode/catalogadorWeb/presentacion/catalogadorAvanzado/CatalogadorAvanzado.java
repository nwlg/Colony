// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

/**
 * 
 */
public final class CatalogadorAvanzado extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CatalogadorAvanzadoFormImpl specificForm = (CatalogadorAvanzadoFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloFormAccionSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloFormAccionSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloFormAccionSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos.MetaMetadatosFormSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos.MetaMetadatosFormSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos.MetaMetadatosFormSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaFormAccionSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaFormAccionSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaFormAccionSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsosEducativosFormCancelarFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsosEducativosFormCancelarFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsosEducativosFormCancelarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormSubmitFormFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormSubmitFormFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormSubmitFormFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.ListadoRelacionesFormCancelarFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.ListadoRelacionesFormCancelarFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.ListadoRelacionesFormCancelarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionFormSubmitFormFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionFormSubmitFormFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionFormSubmitFormFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.ListadoAnotacionesFormInicioAvanzadoFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.ListadoAnotacionesFormInicioAvanzadoFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.ListadoAnotacionesFormInicioAvanzadoFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormCancelarFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormCancelarFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormCancelarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.volver.ConfirmarGuardarDatosSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.volver.ConfirmarGuardarDatosSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.volver.ConfirmarGuardarDatosSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.importar.ImportarLomesSubmitFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.importar.ImportarLomesSubmitFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.importar.ImportarLomesSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.importar.AdvertenciaSubmitAdvertenciaFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.importar.AdvertenciaSubmitAdvertenciaFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.importar.AdvertenciaSubmitAdvertenciaFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.catalogadorWeb.presentacion.exportar.LomesNoValidoVolverFormImpl)
        {
            final es.pode.catalogadorWeb.presentacion.exportar.LomesNoValidoVolverFormImpl previousForm = (es.pode.catalogadorWeb.presentacion.exportar.LomesNoValidoVolverFormImpl)previousFormObject;
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
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoControllerFactory.getCatAvanzadoControllerInstance().cargarDatosAv(mapping, (CatalogadorAvanzadoFormImpl)form, request, response);
        forward = mapping.findForward("categorias.form");


        return forward;
    }

}
