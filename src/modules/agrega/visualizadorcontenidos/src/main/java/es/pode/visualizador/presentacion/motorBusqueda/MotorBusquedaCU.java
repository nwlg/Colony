// license-header java merge-point
package es.pode.visualizador.presentacion.motorBusqueda;

/**
 * 
 */
public final class MotorBusquedaCU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        return _anadirMotorBusqueda(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirMotorBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        // we pass an empty form implementation to the controller, we know there are no parameters on this operation because the
        // cartridge would have issued a model validation error
        es.pode.visualizador.presentacion.motorBusqueda.MotorBusquedaControllerFactory.getMotorBusquedaControllerInstance().anadirMotorBusqueda(mapping, new AnadirMotorBusquedaForm(){}, request, response);
        forward = _motorBusqueda(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _motorBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

}
