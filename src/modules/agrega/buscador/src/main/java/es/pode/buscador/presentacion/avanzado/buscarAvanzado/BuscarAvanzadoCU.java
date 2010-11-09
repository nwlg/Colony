// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 
 */
public final class BuscarAvanzadoCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final BuscarAvanzadoCUFormImpl specificForm = (BuscarAvanzadoCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.listar.ListarODECUFormImpl)
        {
            final es.pode.buscador.presentacion.basico.listar.ListarODECUFormImpl previousForm = (es.pode.buscador.presentacion.basico.listar.ListarODECUFormImpl)previousFormObject;
            specificForm.setBusquedaSimpleAvanzada(previousForm.getBusquedaSimpleAvanzada());
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setKeyword(previousForm.getKeyword());
            specificForm.setBuscadorGeneral(previousForm.getBuscadorGeneral());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());

            //  09/11/2010  Fernando Garcia
            //  This will be for a future combo box to select different sorting
            //  It will be hidden at mostrar-resultados-imagenes.jsp until I'll develop it
            //  TODO: get this struture from a common place (same code at serveral places)
            
            Collection sortingMethodLabelList = new ArrayList();
            Collection sortingMethodValueList = new ArrayList();

            sortingMethodLabelList.add("Relevance");
            sortingMethodValueList.add("RELEVANCE");

            sortingMethodLabelList.add("Index Order");
            sortingMethodValueList.add("Index");

            specificForm.setSortingMethodLabelList(sortingMethodLabelList.toArray());
            specificForm.setSortingMethodValueList(sortingMethodValueList.toArray());
            
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl)previousFormObject;
            specificForm.setAutor(previousForm.getAutor());
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoVisualizacion(previousForm.getTipoVisualizacion());
            specificForm.setDescripcion(previousForm.getDescripcion());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
            specificForm.setAnyoPublicacion(previousForm.getAnyoPublicacion());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
            specificForm.setProcesoCognitivo(previousForm.getProcesoCognitivo());
            specificForm.setAreaCurricular(previousForm.getAreaCurricular());
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setValoracion(previousForm.getValoracion());
            specificForm.setPagina(previousForm.getPagina());
            specificForm.setEdad(previousForm.getEdad());
            specificForm.setC_s_secuencia(previousForm.getC_s_secuencia());
            specificForm.setDiaPublicacion(previousForm.getDiaPublicacion());
            specificForm.setMesPublicacion(previousForm.getMesPublicacion());
            specificForm.setRecurso(previousForm.getRecurso());
            specificForm.setContexto(previousForm.getContexto());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl)previousFormObject;
            specificForm.setAutor(previousForm.getAutor());
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoVisualizacion(previousForm.getTipoVisualizacion());
            specificForm.setDescripcion(previousForm.getDescripcion());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setFormato(previousForm.getFormato());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
            specificForm.setAnyoPublicacion(previousForm.getAnyoPublicacion());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
            specificForm.setProcesoCognitivo(previousForm.getProcesoCognitivo());
            specificForm.setAreaCurricular(previousForm.getAreaCurricular());
            specificForm.setTitulo(previousForm.getTitulo());
            specificForm.setValoracion(previousForm.getValoracion());
            specificForm.setPagina(previousForm.getPagina());
            specificForm.setEdad(previousForm.getEdad());
            specificForm.setC_s_secuencia(previousForm.getC_s_secuencia());
            specificForm.setDiaPublicacion(previousForm.getDiaPublicacion());
            specificForm.setMesPublicacion(previousForm.getMesPublicacion());
            specificForm.setRecurso(previousForm.getRecurso());
            specificForm.setContexto(previousForm.getContexto());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.enviarMail.EnvioMailBuscarFormImpl)
        {
            final es.pode.buscador.presentacion.basico.enviarMail.EnvioMailBuscarFormImpl previousForm = (es.pode.buscador.presentacion.basico.enviarMail.EnvioMailBuscarFormImpl)previousFormObject;
            specificForm.setMostrarVuelta(previousForm.getMostrarVuelta());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.enviarMail.ResultadoEnvioBuscarFormImpl)
        {
            final es.pode.buscador.presentacion.basico.enviarMail.ResultadoEnvioBuscarFormImpl previousForm = (es.pode.buscador.presentacion.basico.enviarMail.ResultadoEnvioBuscarFormImpl)previousFormObject;
            specificForm.setMostrarVuelta(previousForm.getMostrarVuelta());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularVolcarAreaCurricularFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularVolcarAreaCurricularFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularVolcarAreaCurricularFormImpl)previousFormObject;
            specificForm.setAreaCurricular(previousForm.getAreaCurricular());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularCancelarFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularCancelarFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularCancelarFormImpl)previousFormObject;
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.eliminarOdes.ResultadoEliminacionAceptarFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.eliminarOdes.ResultadoEliminacionAceptarFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.eliminarOdes.ResultadoEliminacionAceptarFormImpl)previousFormObject;
            specificForm.setBusquedaSimpleAvanzada(previousForm.getBusquedaSimpleAvanzada());
            specificForm.setIdioma(previousForm.getIdioma());
            specificForm.setNumeroResultados(previousForm.getNumeroResultados());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.eliminarOdes.ConfirmacionCancelarFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.eliminarOdes.ConfirmacionCancelarFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.eliminarOdes.ConfirmacionCancelarFormImpl)previousFormObject;
            specificForm.setBusquedaSimpleAvanzada(previousForm.getBusquedaSimpleAvanzada());
            specificForm.setIdioma(previousForm.getIdioma());
            specificForm.setNumeroResultados(previousForm.getNumeroResultados());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.tesauros.TesaurosAsociarTesauroFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.tesauros.TesaurosAsociarTesauroFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.tesauros.TesaurosAsociarTesauroFormImpl)previousFormObject;
            specificForm.setNomTesauros(previousForm.getNomTesauros());
            specificForm.setTaxonesVO(previousForm.getTaxonesVO());
            specificForm.setIdioma(previousForm.getIdioma());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setRutaPadreVO(previousForm.getRutaPadreVO());
            specificForm.setIdTesauro(previousForm.getIdTesauro());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.tesauros.TesaurosCancelarFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.tesauros.TesaurosCancelarFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.tesauros.TesaurosCancelarFormImpl)previousFormObject;
            specificForm.setNomTesauros(previousForm.getNomTesauros());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setIdTesauro(previousForm.getIdTesauro());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoCUFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoCUFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoCUFormImpl)previousFormObject;
            specificForm.setBusquedaSimpleAvanzada(previousForm.getBusquedaSimpleAvanzada());
            specificForm.setEnlaceComunidadesSeleccionadas(previousForm.getEnlaceComunidadesSeleccionadas());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
            specificForm.setComunidades(previousForm.getComunidades());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosAnalizaTipoBusquedaFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosAnalizaTipoBusquedaFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosAnalizaTipoBusquedaFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _prepararEntrada(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _validarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().validarFormulario(mapping, (BuscarAvanzadoCUFormImpl)form, request, response);
        forward = __analizaValidacion(mapping, form, request, response);


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
    private org.apache.struts.action.ActionForward _prepararEntrada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizaEntrada(mapping, form, request, response);
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

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().cargaFormularioBusquedaAvanzada(mapping, (BuscarAvanzadoCUFormImpl)form, request, response);
        forward = mapping.findForward("mostrar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarFormularioQuisoDecir(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().cargarFormularioQuisoDecir(mapping, (BuscarAvanzadoCUFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.quiso.decir.avanzado");


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

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().ejecutarBusquedaAvanzada(mapping, (BuscarAvanzadoCUFormImpl)form, request, response);
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
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaTipoBusqueda(mapping, (BuscarAvanzadoCUFormImpl)form, request, response));

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
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaResultados(mapping, (BuscarAvanzadoCUFormImpl)form, request, response));

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
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizarVisualizacion(mapping, (BuscarAvanzadoCUFormImpl)form, request, response));

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

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaValidacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaValidacion(mapping, (BuscarAvanzadoCUFormImpl)form, request, response));

        if (value.equals("FORMULARIO_INVALIDO"))
        {
            return _cargarFormularioQuisoDecir(mapping, form, request, response);
        }
        if (value.equals("FORMULARIO_VALIDO"))
        {
            return _concentradorBusqueda(mapping, form, request, response);
        }
        if (value.equals("FORMULARIO_INVALIDO_AVANZADO"))
        {
            return _concentradorCargarFormulario(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _concentradorCargarFormulario(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaEntrada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaEntrada(mapping, (BuscarAvanzadoCUFormImpl)form, request, response));

        if (value.equals("BUSCAR"))
        {
            return _validarFormulario(mapping, form, request, response);
        }
        if (value.equals("CONFIGURAR_AVANZADO"))
        {
            return _concentradorCargarFormulario(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _concentradorCargarFormulario(mapping, form, request, response);
    }

}
