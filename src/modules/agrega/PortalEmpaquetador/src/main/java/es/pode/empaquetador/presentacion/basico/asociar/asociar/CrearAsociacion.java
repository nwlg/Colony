// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.asociar;

/**
 * 
 */
public final class CrearAsociacion extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _crearRecurso(mapping, form, request, response);
    }

    /**
     * <p>
     * Crear / Modificar el recurso asociado al grupo con los datos del
     * objeto de sesion.
     * </p>
     */
    private org.apache.struts.action.ActionForward _crearRecurso(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.empaquetador.presentacion.basico.asociar.asociar.CrearAsociacionControllerFactory.getCrearAsociacionControllerInstance().crearRecurso(mapping, new CrearRecursoForm(){}, request, response);
        forward = mapping.findForward("gestor.basico");


        return forward;
    }

}
