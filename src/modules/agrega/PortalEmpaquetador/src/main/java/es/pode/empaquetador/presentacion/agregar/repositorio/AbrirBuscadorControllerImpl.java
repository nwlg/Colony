/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.repositorio;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.GestorSesion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.empaquetador.presentacion.agregar.repositorio.AbrirBuscadorController
 */
public class AbrirBuscadorControllerImpl extends AbrirBuscadorController
{

	private final static Logger logger = Logger.getLogger(AbrirBuscadorControllerImpl.class);

	private GestorSesion gs = new GestorSesion();


    /**
     * @see es.pode.empaquetador.presentacion.agregar.repositorio.AbrirBuscadorController#tipoEmpaquetador(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.agregar.repositorio.TipoEmpaquetadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String tipoEmpaquetador(ActionMapping mapping, es.pode.empaquetador.presentacion.agregar.repositorio.TipoEmpaquetadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return gs.tipoEmpaquetador(this.getEmpaquetadorSession(request));
    }


    /**
     * @see es.pode.empaquetador.presentacion.agregar.repositorio.AbrirBuscadorController#prepararParametros(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.agregar.repositorio.PrepararParametrosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void prepararParametros(ActionMapping mapping, es.pode.empaquetador.presentacion.agregar.repositorio.PrepararParametrosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        form.setIdOde(this.getEmpaquetadorSession(request).getIdLocalizador());
        form.setTipoEmpaquetador(this.getEmpaquetadorSession(request).getTipoEmpaquetador());
        String idDestino = null;
        if("avanzado".equalsIgnoreCase(this.getEmpaquetadorSession(request).getTipoEmpaquetador())) {
        	if(this.getEmpaquetadorSession(request).getSubmanifestPath().size()>1) {
        		List subManPath = this.getEmpaquetadorSession(request).getSubmanifestPath();
        		idDestino = ((OdeVO)subManPath.get(subManPath.size()-1)).getIdentifier();
        	}
        } else {
        	Object obj = this.getEmpaquetadorSession(request).getIdCollection().get(this.getEmpaquetadorSession(request).getIdCollection().size()-1);
        	if (obj instanceof OrganizacionVO) {
				OrganizacionVO org = (OrganizacionVO) obj;
				idDestino = org.getIdentifier();
			} else {
				GrupoVO grp = (GrupoVO) obj;
				idDestino = grp.getIdentifier();
			}
        }
        form.setIdDestino(idDestino);
     }









}