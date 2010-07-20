/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.negocio.servicio.TaxonVO;
import es.pode.modificador.negocio.servicio.TaxonomiaVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.NavegarArbolCurricularController
 */
public class NavegarArbolCurricularControllerImpl extends NavegarArbolCurricularController
{
	private Logger logger = Logger.getLogger(NavegarArbolCurricularController.class);

    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.NavegarArbolCurricularController#navegarETB(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.NavegarETBForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */


    public String selectAction(ActionMapping mapping, SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//    	 tan simple como esto
    	logger.debug("Accion en navegarController: " + form.getAction());
    	if("Aceptar".equals(form.getAction()) && form.getIdTermino()==null) {
    		throw new ValidatorException("{navegarArbolCurricular.elemento.necesario}");
    	}
		return form.getAction();
	}

	/**
     * @see es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.NavegarArbolCurricularController#guardarTermino(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.GuardarTerminoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    // Guardamos en la sesión el elemento que se ha seleccionado.
    public final void guardarTermino(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.cambios.navegarArbolCurricular.GuardarTerminoForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String xml;
		try {
			if (form.getIdTermino() == null) {
				logger.debug("no se ha seleccionado un idTermino");
				saveErrorMessage(request,
						"navegarArbolCurricular.elemento.necesario");
			} else {
				TaxonomiaVO tx = this.getSrvHerramientaModificacion()
						.navegarArbolCurricular(form.getIdTermino(), null,
								LdapUserDetailsUtils.getIdioma());
				xml = this.getSrvHerramientaModificacion()
						.generarArbolCurricular(tx);
				this.getCambioSession(request).setValorNuevo(xml);
				this.getCambioSession(request).setLomTerm("lom.classification.taxonPath");
		        this.getCambioSession(request).setIdLomTerm("9.2");
				logger.info("NavegarArbolCurricular: taxon xml guardado en sesión: "
						+ xml);
			}
		} catch (RuntimeException e) {

			logger.error("Excepcion en el servicio de herramienta modificacion al guardar termino: ",e);
		}
		
	}

	public void navegar(ActionMapping mapping, NavegarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// De momento en nombreTaxonomia pasamos un null, más adelante quizás se ponga un combo para escoger una.
		// El srv por debajo si hay null mete una clave que fuentesTaxonomicas interpreta como que queremos el vigente.
		try {
			TaxonomiaVO tx = null;
			if (form.getIdTermino()!=null&&form.getIdTermino().trim().length()>0)
			{
				tx = this.getSrvHerramientaModificacion().navegarArbolCurricular(form.getIdTermino(),null,LdapUserDetailsUtils.getIdioma()); 
				form.setTaxonomia(tx);
			}
			else {
				//para el primer caso
				tx = this.getSrvHerramientaModificacion().navegarArbolCurricular(null, null,LdapUserDetailsUtils.getIdioma());
			}
//			 Es necesario hacer un reverse del taxonPath para mostrar correctamente la rama del arbol:
			if(tx.getTaxonPath()!=null && tx.getTaxonPath().length>1) {
				if(logger.isDebugEnabled()) logger.debug("Invierto el orden de taxonPath");
				List taxonPath = Arrays.asList(tx.getTaxonPath());
				Collections.reverse(taxonPath);
				tx.setTaxonPath((TaxonVO[])taxonPath.toArray(new TaxonVO[taxonPath.size()]));
			}
			form.setTaxonomia(tx);
		} catch (RuntimeException e) {
			logger.error("Excepcion en el servicio de herramienta modificacion al navegar: ",e);
			saveErrorMessage(request, "areaCurricular.error.inesperado");
				}
		logger.info("Taxonomia genereada correctamente");
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
	}

}