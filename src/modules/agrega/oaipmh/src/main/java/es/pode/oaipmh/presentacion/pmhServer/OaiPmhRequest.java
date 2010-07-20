// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

/**
 * 
 */
public final class OaiPmhRequest extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final OaiPmhRequestFormImpl specificForm = (OaiPmhRequestFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _obtenerParametrosReq(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _obtenerRespuestaLlamadaError(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().obtenerResultadoOAIRequest(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerParametrosReq(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().obtenerParametros(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = __analizaPeticion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _identify(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().identify(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _getRecord(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().getRecord(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _listMetadataFormat(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().listMetadataFormat(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _listIdentifiers(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().listIdentifiers(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _listSets(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().listSets(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _listRecord(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().listRecords(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = _obtenerRespuestaProtocolo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _obtenerRespuestaProtocolo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().obtenerRespuestaProtocolo(mapping, (OaiPmhRequestFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaPeticion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerControllerFactory.getOaiPmhServerControllerInstance().analizaPeticion(mapping, (OaiPmhRequestFormImpl)form, request, response));

        if (value.equals("badVerb"))
        {
            return _obtenerRespuestaLlamadaError(mapping, form, request, response);
        }
        if (value.equals("GetRecord"))
        {
            return _getRecord(mapping, form, request, response);
        }
        if (value.equals("Identify"))
        {
            return _identify(mapping, form, request, response);
        }
        if (value.equals("ListIdentifiers"))
        {
            return _listIdentifiers(mapping, form, request, response);
        }
        if (value.equals("ListMetadataFormat"))
        {
            return _listMetadataFormat(mapping, form, request, response);
        }
        if (value.equals("ListRecords"))
        {
            return _listRecord(mapping, form, request, response);
        }
        if (value.equals("ListSets"))
        {
            return _listSets(mapping, form, request, response);
        }
        if (value.equals("badArgument"))
        {
            return _obtenerRespuestaLlamadaError(mapping, form, request, response);
        }
        if (value.equals("Error"))
        {
            return _obtenerRespuestaLlamadaError(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _obtenerRespuestaLlamadaError(mapping, form, request, response);
    }

}
