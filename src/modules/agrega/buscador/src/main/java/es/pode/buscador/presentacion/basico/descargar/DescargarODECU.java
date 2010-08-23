// license-header java merge-point
package es.pode.buscador.presentacion.basico.descargar;

import org.apache.log4j.Logger;



/**
 * 
 */
public final class DescargarODECU extends org.apache.struts.action.Action
{

    private static final Logger logger = Logger.getLogger(DescargarODECU.class);

    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DescargarODECUFormImpl specificForm = (DescargarODECUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEDescargarFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEDescargarFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEDescargarFormImpl)previousFormObject;
            specificForm.setMostrarVuelta(previousForm.getMostrarVuelta());
            specificForm.setBusquedaSimpleAvanzada(previousForm.getBusquedaSimpleAvanzada());
            specificForm.setLocalizadorODE(previousForm.getLocalizadorODE());
            specificForm.setIdentificadorODE(previousForm.getIdentificadorODE());
            specificForm.setTipoLayoutBuscador(previousForm.getTipoLayoutBuscador());
        }
//20/08/2010 Fernando Garcia: We need to know the format to grey out some options in the download jsp
        else if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.DetallarODECUFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.DetallarODECUFormImpl previousForm =
                    (es.pode.buscador.presentacion.basico.detallar.DetallarODECUFormImpl) previousFormObject;
            specificForm.setFormato(previousForm.getFormato());
            logger.debug(" specificForm = " + specificForm.toString());
            
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _cargarTiposFormato(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cargarTiposFormato(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.descargar.DescargarControllerFactory.getDescargarControllerInstance().cargarTiposFormato(mapping, (DescargarODECUFormImpl)form, request, response);
        forward = mapping.findForward("muestra.seleccion");


        return forward;
    }

}
