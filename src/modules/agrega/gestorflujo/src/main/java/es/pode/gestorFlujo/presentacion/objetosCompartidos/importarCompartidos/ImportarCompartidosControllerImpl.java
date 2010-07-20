/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos;

import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.entregar.negocio.servicios.PaquetePifDriVO;
import es.pode.entregar.negocio.servicios.SrvEntregarService;
import es.pode.gestorFlujo.presentacion.objetosPersonales.ResultadoImportacion;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarCompartidosController
 */
public class ImportarCompartidosControllerImpl extends ImportarCompartidosController
{

	private Logger logger = Logger.getLogger(ImportarCompartidosController.class);
	private final String RESULTADOS = null;
	private final String RESULTADO_SI = String.valueOf(true);
	private final String RESULTADO_NO = String.valueOf(false);
	private final String SPLITTER = ";";


    /**
     * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarCompartidosController#importarODE(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarODEForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void importarODE(ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosCompartidos.importarCompartidos.ImportarODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
//    	long tamaino=new Long(request.getParameter("espacioLibre"));
//    	logger.debug("De la request:"+tamaino);

    	ResultadoOperacionVO unResultado = new ResultadoOperacionVO();
		String archivosSubidos = new String("(");
		int nr_archivos_subidos = 0;
		ArrayList resultado = new ArrayList(); 
		Long diferencia=new Long(0);
		logger.debug("Importando ode");
		if (form.getTitulo() != null && form.getTitulo().length() != 0) {
			
				try {
					ResultadoImportacion resultadoParcial = new ResultadoImportacion();
					resultadoParcial.setTitulo(form.getTitulo());
					unResultado = importarUnODE(form.getIdODE(),form.getTitulo(), request.getLocale().getLanguage());		
					if (unResultado.getIdResultado().equals("0.0")) {
						nr_archivos_subidos++;
						resultadoParcial.setValido(null);
						archivosSubidos = archivosSubidos + form.getTitulo() + ",";
						resultado.add(resultadoParcial);
					} else {
						resultadoParcial.setValido(RESULTADO_NO);
						logger.error("El archivo no se ha podido importar: " + unResultado.getDescripcion());					
						resultadoParcial.setMensajes(unResultado.getDescripcion().split(SPLITTER));
						resultado.add(resultadoParcial);
					}
					logger.error("Mensajes despues del splitter["+(unResultado.getDescripcion().split(SPLITTER)!= null?unResultado.getDescripcion().split(SPLITTER).length:0)+"] ");	
					logger.debug("Los atributos que pasamos a la jsp son: Una colleccion:["+resultado+"], con titulo ["+((ResultadoImportacion)resultado.get(0)).getTitulo()+" con mensajes ["+((ResultadoImportacion)resultado.get(0)).getMensajes()+" y validacion["+((ResultadoImportacion)resultado.get(0)).getValido());
				} catch (Exception ex) {
					logger.error("Excepcion al importar el ode compartido: ", ex);
					throw new ValidatorException("{gestorFlujo.error.inesperado}");
				}
			
		}
	logger.debug("Hemos llegado hasta aqui");
	if (nr_archivos_subidos > 0) {
		logger.info("Se ha importado correctamente el archivo: " + archivosSubidos);
		if (archivosSubidos.endsWith(",")) {
			archivosSubidos = (String) archivosSubidos.subSequence(0, archivosSubidos.length() - 1);
			archivosSubidos = nr_archivos_subidos + ": " + archivosSubidos;
			archivosSubidos = archivosSubidos + ")";
		}
		
	
	}
	form.setResultado(resultado);
 }

	
	private ResultadoOperacionVO importarUnODE(String idODE, String titulo, String idioma) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("Importando un ode");
		ResultadoOperacionVO resultado = new ResultadoOperacionVO();
		SrvEntregarService entregar=this.getSrvEntregarService();
		if(logger.isDebugEnabled())
			logger.debug("Llamamos a generarPaquetePIF() con identificador ["+idODE+"]");
//		Por ahora la entrega hace una validación binaria del ODE, con lo que si el ODE compartido no valida, la llamada a entregar falla y no nos
//		devuelve el PIF. Tan solo podemos pintar los errores que ha producido la generación del PIF y no podemos importar el ODE.
//		Esto va a cambiar: aunque el ODE no valide, se va a devolver un zip con el contenido y en el resto del VO de vuelta indicará los errores
//		de validación que hay encontrado, por lo que vamos a ser capaces de avisar de los errores de validación y además meter el ODE en la carpeta.
		PaquetePifDriVO pifDri = entregar.generarPaquetePIF(idODE);
		if(logger.isDebugEnabled())
			logger.debug("Recogemos  el paquete PIF");
		DataHandler pif = pifDri.getPaquetePIF();

		SrvPublicacionService publi = this.getSrvPublicacionService();
		try {
			if(logger.isDebugEnabled())
				logger.debug("Llamamos a crearPifConCuota con pif ["+pif+"], usuario [ "+ LdapUserDetailsUtils.getUsuario()+"], comentarios ["+titulo+"], titulo ["+titulo+"] e idioma ["+idioma+"]");
			resultado = publi.crearPifConCuota(pif, LdapUserDetailsUtils.getUsuario(), titulo,  titulo+".zip", idioma);
			logger.info("resultado de la importacion de un ode:" + resultado);
		} catch (Exception ex) {
			// Si ha habido alguna excepción no controlada lo indicamos
			resultado.setIdResultado("11.1");
			resultado.setDescripcion("Excepción al importar");
			logger.error("Excepcion al importar el ode: " + titulo, ex);
		}

		return resultado;
	}

}