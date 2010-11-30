// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * 
 */
public final class MostrarResultadosImagenesPaginarImagenes extends org.apache.struts.action.Action
{
    private Logger logger = Logger.getLogger(this.getClass());

    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final MostrarResultadosImagenesPaginarImagenesFormImpl specificForm = (MostrarResultadosImagenesPaginarImagenesFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl){
            es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl oldForm =
                    (es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl)previousFormObject;

            specificForm.setSortingMethod(oldForm.getSortingMethod());
        } else

        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl){
            es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl oldForm =
                    (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl)previousFormObject;

            specificForm.setSortingMethod(oldForm.getSortingMethod());
        }





        org.apache.struts.action.ActionForward forward = null;

        try
        {

            //  09/11/2010  Fernando Garcia
            //  This will be for a future combo box to select different sorting
            //  It will be hidden at mostrar-resultados-imagenes.jsp until I'll develop it
            //  TODO: get this struture from a common place (same code at BuscarAvanzadoCU.java and more places)

           Properties props = null;
            try {
                    props = new Properties();
                    props.load(this.getClass().getResourceAsStream("/spring_buscador.properties"));
            } catch (IOException e) {
                    logger.error("ERROR: file not found: spring_buscador.properties",
                                    e);
                    throw new RuntimeException(e);
            }

            Collection sortingMethodLabelList = new ArrayList();
            Collection sortingMethodValueList = new ArrayList();

            BuscarAvanzadoCU.loadSortingMethodCombo(props, sortingMethodLabelList,sortingMethodValueList);

            specificForm.setSortingMethodLabelList(sortingMethodLabelList.toArray());
            specificForm.setSortingMethodValueList(sortingMethodValueList.toArray());
            
            
            
            forward = _concentradorBusqueda(mapping, form, request, response);


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
    private org.apache.struts.action.ActionForward _mostrarResultados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("mostrar.resultados");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarSQI(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("busqueda.sqicu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatosFormularioAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().cargaFormularioBusquedaAvanzada(mapping, (MostrarResultadosImagenesPaginarImagenesFormImpl)form, request, response);
        forward = mapping.findForward("mostrar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _concentradorCargarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = _cargarDatosFormularioAvanzado(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _analizaVisualizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizarVisualizacion(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarAvanzada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().ejecutarBusquedaAvanzada(mapping, (MostrarResultadosImagenesPaginarImagenesFormImpl)form, request, response);
        forward = __analizaResultados(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _concentradorBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizaTipoBusqueda(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaTipoBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaTipoBusqueda(mapping, (MostrarResultadosImagenesPaginarImagenesFormImpl)form, request, response));

        if (value.equals("AGREGA"))
        {
            return _buscarAvanzada(mapping, form, request, response);
        }
        if (value.equals("SQI"))
        {
            return _buscarSQI(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _buscarSQI(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaResultados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaResultados(mapping, (MostrarResultadosImagenesPaginarImagenesFormImpl)form, request, response));

        if (value.equals("CON_SUGERENCIAS"))
        {
            return mapping.findForward("mostrar.quiso.decir.avanzado");
        }
        if (value.equals("CON_RESULTADOS"))
        {
            return _analizaVisualizacion(mapping, form, request, response);
        }
        if (value.equals("SIN_RESULTADOS"))
        {
            return _concentradorCargarFormulario(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _concentradorCargarFormulario(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizarVisualizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizarVisualizacion(mapping, (MostrarResultadosImagenesPaginarImagenesFormImpl)form, request, response));

        if (value.equals("SIN_IMAGENES"))
        {
            return mapping.findForward("mostrar.resultados.avanzado");
        }
        if (value.equals("CON_IMAGENES"))
        {
            return _mostrarResultados(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _mostrarResultados(mapping, form, request, response);
    }

}
