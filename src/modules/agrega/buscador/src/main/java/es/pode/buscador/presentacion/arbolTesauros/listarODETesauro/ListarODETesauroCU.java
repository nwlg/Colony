// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

/**
 * 
 */
public final class ListarODETesauroCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ListarODETesauroCUFormImpl specificForm = (ListarODETesauroCUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.MostrarDetalleODEVolverBusquedaFormImpl)previousFormObject;
            specificForm.setPagina(previousForm.getPagina());
            specificForm.setTipoBusquedaArbol(previousForm.getTipoBusquedaArbol());
            specificForm.setTesauroBusqueda(previousForm.getTesauroBusqueda());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl)
        {
            final es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl previousForm = (es.pode.buscador.presentacion.basico.detallar.OdeAgregadoAgregarNuevoFormImpl)previousFormObject;
            specificForm.setPagina(previousForm.getPagina());
            specificForm.setTipoBusquedaArbol(previousForm.getTipoBusquedaArbol());
            specificForm.setTesauroBusqueda(previousForm.getTesauroBusqueda());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroListarODETesauroFormImpl)
        {
            final es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroListarODETesauroFormImpl previousForm = (es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroListarODETesauroFormImpl)previousFormObject;
            specificForm.setNumMaxResultados(previousForm.getNumMaxResultados());
            specificForm.setTituloTesauro(previousForm.getTituloTesauro());
            specificForm.setIdioma(previousForm.getIdioma());
            specificForm.setRutaPadreVO(previousForm.getRutaPadreVO());
            specificForm.setIdTesauro(previousForm.getIdTesauro());
            specificForm.setIdiomaBuscador(previousForm.getIdiomaBuscador());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _buscarDocumentosTesauro(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _buscarDocumentosTesauro(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroControllerFactory.getListarODETesauroControllerInstance().buscarDocumentosTesauro(mapping, (ListarODETesauroCUFormImpl)form, request, response);
        forward = mapping.findForward("buscar.documentos");


        return forward;
    }

}
