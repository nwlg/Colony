/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.descargas.activas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession;
import es.pode.administracion.presentacion.descargas.DescargaInfo;
import es.pode.contenidos.negocio.descargas.servicio.DescDescargaVO;
import es.pode.contenidos.negocio.descargas.servicio.DescargaVO;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.administracion.presentacion.descargas.activas.ActivasController
 */
public class ActivasControllerImpl extends ActivasController
{
	private static final long serialVersionUID = 2821489197786167571L;
	private static final Logger logger = Logger.getLogger(ActivasControllerImpl.class);
	private static String VACIA ="";

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#obtenerDatos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.ObtenerDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerDatos(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.ObtenerDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	DescargaVO descargas[] = getSrvDescargas().obtenerDescargasActivas();
		logger.debug("Recuperadas "+descargas.length+" descargas");
		ArrayList<DescargaInfo> listaDescargas = new ArrayList<DescargaInfo>();
		if (descargas!=null&&descargas.length>0) {
			String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
			DescDescargaVO[] descs = getSrvDescargas()
					.obtenerDescDescargasIdioma(descargas, idioma);
			logger.debug("Recuperadas " + descs.length
					+ " descripciones de descargas");
			for (int i = 0; i < descargas.length; i++) {
				DescargaInfo info = new DescargaInfo(descargas[i],descs[i]);
				listaDescargas.add(info);
			}
		}
		logger.debug("Lista de descargas construida");
		form.setDescargas(listaDescargas);
     }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#desactivar(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.DesactivarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void desactivar(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.DesactivarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Long identificador =new Long(form.getIdentificador());
		getSrvDescargas().modificarDescarga(identificador, VACIA, Boolean.FALSE, new DescDescargaVO[]{});
     }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#eliminar(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.EliminarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminar(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.EliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if(form.getIds()==null) {
    		throw new ValidatorException("{descargasActivas.no.seleccionados}");	
    	}
    	getSrvDescargas().eliminarDescargas((Long[])form.getIds().toArray(new Long[]{}));
     }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#iniciarSesion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.IniciarSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void iniciarSesion(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.IniciarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	setConfigurarDescargaSession(request, new ConfigurarDescargaSession());
    }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#obtenerDescarga(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.ObtenerDescargaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerDescarga(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.ObtenerDescargaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Long identificador = new Long(form.getIdentificador());
    	DescargaVO descarga = getSrvDescargas().obtenerDescarga(identificador);
    	DescDescargaVO[] desc = getSrvDescargas().obtenerDescDescargas(identificador);
    	ConfigurarDescargaSession sesion = new ConfigurarDescargaSession();
    	sesion.setActiva(descarga.getActiva());
    	sesion.setDescripciones(Arrays.asList(desc));
    	sesion.setFecha(descarga.getFecha());
    	sesion.setIdentificador(identificador);
    	sesion.setPath(descarga.getPath());
    	sesion.setPeso(descarga.getPeso());
    	
    	setConfigurarDescargaSession(request, sesion);
    	
     }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#submit(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void submit(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		String[] ids = form.getIdentificadorRowSelectionAsArray();
		if (ids!=null) {
			ArrayList<Long> idsLong = new ArrayList<Long>();
			for (int i = 0; i < ids.length; i++) {
				idsLong.add(new Long(ids[i]));
			}
			form.setIds(idsLong);
		}
     }

    /**
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasController#selectOption(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.descargas.activas.SelectOptionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectOption(ActionMapping mapping, es.pode.administracion.presentacion.descargas.activas.SelectOptionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String result;
    	ResourceBundle resources = ResourceBundle.getBundle("application-resources", (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		String action = form.getAction();
		if(resources.getString("descargasActivas.crear").equals(action)) {
			result = "Crear";
		} else {
			result = "Eliminar";
		}
		return result;
    }

}