/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.publicacion.negocio.servicios.LicenciaVO;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.menu.MenuController;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController
 */
public class PublicarControllerImpl extends PublicarController {

	protected static final String FILE_NAME_PROPERTIES = "/gestorFlujo.properties";

	private static Properties props = null;

	private Logger logger = Logger.getLogger(PublicarController.class);

	private static final String IDENTIFICADOR_NODO = "server.id";

	private final String SPLITTER_VAL = ";";

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#publicarODE(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 * 
	 * publica un ode, ya sea despublicado o propuesto.
	 */

	public final void publicarODE(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultadoOperacionVO resultadoPublicacion;
		PublicarSession publiSes = this.getPublicarSession(request);
		logger.info("Publicando ODE: " + publiSes.getTitulo() + " Despublicado?: "
				+ publiSes.getEsDespublicado().booleanValue() + " IdODE: " + publiSes.getIdODE());
		
		boolean comentarioValidado=false;//El comentario es obligatorio en el caso de los despublicados, pero no en el caso de la primera publicaion
		if(publiSes.getEsDespublicado().booleanValue()){
			if(logger.isDebugEnabled())
				logger.debug("Es un ODE despublicado");
			if(form.getComentarios()!=null){
				if ((form.getComentarios().trim().length() > 0) && (form.getComentarios().length() < 2500)) {
					if(logger.isDebugEnabled())
					logger.debug("Comentarios correctos publicando ODE :" + publiSes.getIdODE() + " de titulo: "
							+ publiSes.getTitulo() + " Comentarios: " + form.getComentarios() + " tipoLicencia: "
							+ publiSes.getTipoLicencia() + " Comunidades: " + publiSes.getComunidades() + ";");
					comentarioValidado=true;
					publiSes.setEsDespublicado(new Boolean(true));
				}else{
					logger.warn("Longitud de comentario no válida al publicar el ODE con IdODE[" + publiSes.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + publiSes.getTitulo() + "]; longitud: " + form.getComentarios().length());
					throw new ValidatorException("{gestorFlujo.comentario.longitud}");
				}
			}else{
				logger.warn("Longitud de comentario no válida al publicar el ODE con IdODE[" + publiSes.getIdODE()
						+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
						+ "] y titulo[" + publiSes.getTitulo() + "]; longitud: " + form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.comentario.longitud}");
			}
		}else if(!publiSes.getEsDespublicado().booleanValue()){
			if(form.getComentarios().length() < 2500){
				if(logger.isDebugEnabled())
					logger.debug("Comentarios correctos publicando ODE :" + publiSes.getIdODE() + " de titulo: "
							+ publiSes.getTitulo() + " Comentarios: " + form.getComentarios() + " tipoLicencia: "
							+ publiSes.getTipoLicencia() + " Comunidades: " + publiSes.getComunidades() + ";");
					comentarioValidado=true;
					publiSes.setEsDespublicado(new Boolean(false));
			}else{
				logger.warn("Longitud de comentario no válida al publicar el ODE con IdODE[" + publiSes.getIdODE()
						+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
						+ "] y titulo[" + publiSes.getTitulo() + "]; longitud: " + form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.comentario.longitud}");
			}
		}else{
			logger.warn("No se han introducido comentarios al publicar el ODE con IdODE[" + publiSes.getIdODE()
					+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
					+ "] y titulo[" + publiSes.getTitulo() + "]");
			throw new ValidatorException("{gestorFlujo.comentario.obligatorio}");
		}
		if(logger.isDebugEnabled())
		logger.debug("Comentarios correctos publicando ODE :" + publiSes.getIdODE() + " de titulo: "
				+ publiSes.getTitulo() + " Comentarios: " + form.getComentarios() + " tipoLicencia: "
				+ publiSes.getTipoLicencia() + " Comunidades: " + publiSes.getComunidades() + ";");
	
		if (publiSes.getTipoLicencia() != null && publiSes.getTipoLicencia().length() > 0) {
			// Ahora comprobamos que existan las comunidades
			
	
			String[] nodosValidos=interseccionNodos(publiSes.getComunidades());
			if ((nodosValidos != null) && nodosValidos.length > 0) {
				String nodosValidosString="";
				for(int i=0;i<nodosValidos.length;i++){//Para que sólo haya nodos válidos en la publicacion y tambien el nodo local
					nodosValidosString=nodosValidosString+nodosValidos[i]+",";
				}
				nodosValidosString=nodosValidosString.substring(0, nodosValidosString.length()-1);
				publiSes.setComunidades(nodosValidosString);
				
				//Si tienes todos los nodos será universal
				
				SrvNodoService nodosPlataforma = this.getSrvNodoService();
				
				String[] nodosListados=obtenNodosLocalesIds(nodosPlataforma);
				if(nodosValidos.length== nodosListados.length){
					publiSes.setUniversal(getPropertyValue("licencia.acceso.universal"));
				}
				
				try {
					TerminoYPadreVO[] typ = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(
							new String[] { publiSes.getTipoLicencia() });
	
					publiSes.setTipoLicencia(typ[0].getNomTermino());
	
					if (publiSes.getEsDespublicado().booleanValue()) {
						resultadoPublicacion = this.getSrvPublicacionService().publicarDespublicado(
								publiSes.getIdODE(), LdapUserDetailsUtils.getUsuario(), form.getComentarios(),
								publiSes.getTitulo(), publiSes.getComunidades(), publiSes.getTipoLicencia(),
								publiSes.getUniversal());
						publiSes.setEsDespublicado(true);
						if(logger.isDebugEnabled())
						logger.debug("Publicando ODE despublicado: en nodos " + publiSes.getComunidades() + "idODE:"+publiSes.getIdODE()+"idioma usuario:"+LdapUserDetailsUtils.getUsuario()+"comentarios:"+form.getComentarios()
								+"titulo:"+publiSes.getTitulo()+"comunidades:"+publiSes.getComunidades()+"tipoLicencia:"+publiSes.getTipoLicencia()+"universa?"+publiSes.getUniversal());
					} else {
						resultadoPublicacion = this.getSrvPublicacionService().publicar(publiSes.getIdODE(),
								LdapUserDetailsUtils.getUsuario(), form.getComentarios(), publiSes.getTitulo(),
								publiSes.getComunidades(), publiSes.getTipoLicencia(), publiSes.getUniversal());
						publiSes.setEsDespublicado(false);
						if(logger.isDebugEnabled())
						logger.debug("Publicando ODE publicado: en nodos " + publiSes.getComunidades() + "idODE:"+publiSes.getIdODE()+"idioma usuario:"+LdapUserDetailsUtils.getUsuario()+"comentarios:"+form.getComentarios()
								+"comunidades:"+publiSes.getComunidades()+"tipoLicencia:"+publiSes.getTipoLicencia()+"universa?"+publiSes.getUniversal());
					
					}
					// limpiamos la sesión una vez que hemos publicado
					publiSes.setComunidades("");
					publiSes.setIdODE("");
					publiSes.setTipoLicencia("");
					publiSes.setUniversal("");
					
	
				} catch (Exception ex) {
					logger.error("ERROR (excepción) publicando el ODE con IdODE[" + publiSes.getIdODE()
							+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
							+ form.getComentarios() + "] y titulo[" + publiSes.getTitulo() + "]" + "\n", ex);
					throw new ValidatorException("{gestorFlujo.excepcion.publicar.publicar}");
				}
	
				if (!resultadoPublicacion.getIdResultado().equals("0.0")) {
					logger.error("Error publicando el ODE con IdODE[" + publiSes.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + publiSes.getTitulo() + "] : "
							+ resultadoPublicacion.getDescripcion());
	
					// throw new
					// ValidatorException(resultadoPublicacion.getDescripcion());
					// saveErrorMessage(request,
					// "gestorFlujo.error.publicar", new String[] {
					// publiSes.getTitulo(),
					// resultadoPublicacion.getDescripcion() });
					form.setMensajes(resultadoPublicacion.getDescripcion().substring(0,
							resultadoPublicacion.getDescripcion().length() - 1).split(SPLITTER_VAL));
	
				} else {
					logger.info("Publicado correctamente: ODE con IdODE[" + publiSes.getIdODE() + "] usuario["
							+ LdapUserDetailsUtils.getUsuario() + "]comentarios[" + form.getComentarios()
							+ "] y titulo[" + publiSes.getTitulo() + "]");
				}
			} else {
				logger.warn("No se puede publicar pq la licencia no tiene asociadas comunidades["
						+ publiSes.getIdODE() + "] usuario[" + LdapUserDetailsUtils.getUsuario()
						+ "]comentarios[" + form.getComentarios() + "] y titulo[" + publiSes.getTitulo()
						+ "]; longitud: " + form.getComentarios().length());
				throw new ValidatorException("{gestorFlujo.publicar.comunidadObligatoria}");
			}
		} else {
			logger.warn("No se puede publicar pq no hay un tipo de licencia asociada[" + publiSes.getIdODE()
					+ "] usuario[" + LdapUserDetailsUtils.getUsuario() + "]comentarios["
					+ form.getComentarios() + "] y titulo[" + publiSes.getTitulo() + "]; longitud: "
					+ form.getComentarios().length());
			throw new ValidatorException("{gestorFlujo.publicar.tipoLicenciaObligatoria}");
		}
			
		

	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#cargaFormularioPublicar(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularioPublicarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 * 
	 * Carga las opciones necesarios en el formulario, en este caso los valores
	 * del idioma para el buscador
	 */
	public final void cargaFormularioPublicar(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularioPublicarForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			String idioma =LdapUserDetailsUtils.getIdioma();
			if(logger.isDebugEnabled())
				logger.debug("Cargando los datos de publicar ode");
			
			PublicarSession publiSes = this.getPublicarSession(request);
			
			// (las comunidades si puede ser null pq sea universal)
			if ((publiSes.getTipoLicencia() == null || publiSes.getTipoLicencia().length() == 0)
					|| (publiSes.getUniversal() == null || publiSes.getUniversal().length() == 0)) {//Cuando entramos de publicar
				// sacamos la licencia del ode (viene con una del catalogador,
				// de momento)
				
				LicenciaVO licenciaVO = this.getSrvPublicacionService().obtenLicenciaODE(form.getIdODE(), idioma);
				if(logger.isDebugEnabled())
					logger.debug("En este caso los sacamos del lomes del ODE el ambito es: "+ licenciaVO.getUniversal()
						+ " las comunidades son: " + licenciaVO.getComunidades() + ";");

				form.setUniversal(licenciaVO.getUniversal());

				publiSes.setUniversal(licenciaVO.getUniversal());
				publiSes.setComunidades(licenciaVO.getComunidades());
				// //Ahora el tipo de licencia en el idioma del perfil
				TerminoYPadreVO TerminoYPadreVOida = new TerminoYPadreVO();
				TerminoYPadreVOida.setIdiomaTermino(getPropertyValue("fuentesTaxonicas.traduccion.idioma"));
				TerminoYPadreVOida.setNomTermino(licenciaVO.getTipoLicencia());
				TerminoYPadreVOida.setIdVocabulario(getPropertyValue("combo.tipoLicencias"));
				TerminoYPadreVOida.setIdTermino("");
				// TerminoYPadreVO[] arrayTerminoYPadreTitulos=

				TerminoYPadreVO[] terminoYPadreTitulosVuelta = this.getSrvVocabulariosControladosService()
						.obtenerIdTermino(new TerminoYPadreVO[] { TerminoYPadreVOida });

				// ampliado para probar pq devuelve null esta llamada al
				// webservice
				publiSes.setTipoLicencia(terminoYPadreTitulosVuelta[0].getIdTermino());

				NodoVO[] nodos = obtenNodosLocalesVO(this.getSrvNodoService());
				// Le pasamos las comunidades dnd aplica el ambito, si es universal tb hay
				if (!licenciaVO.getUniversal().equalsIgnoreCase(getPropertyValue("licencia.acceso.universal"))) {//Si no es universal
					
					String[] comunidadesMostrarIds=interseccionNodos(licenciaVO.getComunidades());//Cogemos los nodos válidos y le añadimos el nodo local

					String[] comunidadesMostrar = new String[comunidadesMostrarIds.length];//Cogemos las urls para pintar
					
					for (int i = 0; i < comunidadesMostrar.length; i++) {

						for (int j = 0; j < nodos.length; j++) {
							if (nodos[j].getIdNodo().equalsIgnoreCase(comunidadesMostrarIds[i])) {
								comunidadesMostrar[i] = nodos[j].getUrlWS();
								break;
							}
							
						}
					}
					publiSes.setComunidadesMostrar(comunidadesMostrar);
				}
				else//Si es universal, lleva todos los nodos
				{
					String nodoLista="";
					for(int i=0;i<nodos.length;i++){//Si es universal tenemos que meter todos los nodos
						
						String idsNodos=nodos[i].getIdNodo();
						nodoLista=nodoLista+idsNodos+",";
					}
					licenciaVO.setComunidades(nodoLista);
					String[] comunidadesMostrar = new String[nodos.length];//Todas las urls para pintar
					for (int j = 0; j < nodos.length; j++) {						
							comunidadesMostrar[j] = nodos[j].getUrlWS();
							
					}
					
					publiSes.setComunidadesMostrar(comunidadesMostrar);
					publiSes.setComunidades(nodoLista);

				}
				

			}
			//Cuando volvemos de modificar, o le damos a publicar
			// universal
			if ((publiSes.getUniversal() != null) && (publiSes.getUniversal().length() > 0)) {
				form.setUniversal(publiSes.getUniversal());
			} else {
				form.setUniversal("");
			}

			// tipoLicencia
			if ((publiSes.getTipoLicencia() != null) && (publiSes.getTipoLicencia().length() > 0)) {
				// traducimos la licencia al idioma de navegacion para mostrarla
				if(logger.isDebugEnabled())
					logger.debug("traduciendo la licencia de la sesion["+publiSes.getTipoLicencia()+"] y idioma ["+idioma+"]");
				TerminoVO[] licencia = this.getSrvVocabulariosControladosService().crearTraduccionAIdioma(
						new String[] { publiSes.getTipoLicencia() }, idioma);
				if(licencia!=null && licencia.length>0)
					form.setTipoLicencia(licencia[0].getNomTermino());
				else{
					form.setTipoLicencia("");
				}

			} else {
				form.setTipoLicencia("");
			}

			// comunidades
			if ((publiSes.getComunidades() != null)) {//Puede que venga un string "" (si no se chequea ningun ode en modificar)
				if(logger.isDebugEnabled())
					logger.debug("las comunidades ya estaban en la sesion: " + publiSes.getComunidades());
				String[] nodosIntersacados=interseccionNodos(publiSes.getComunidades());//Los nodos válidos y el nodo local
				
				String conLocal="";
				for(int i=0;i<nodosIntersacados.length;i++){
					conLocal=conLocal+nodosIntersacados[i]+",";
				}
				conLocal = conLocal.substring(0, conLocal.length() - 1);
				if(logger.isDebugEnabled())
					logger.debug("Despues de concatenar el nodo local:" + conLocal);
				NodoVO[] nodos = obtenNodosLocalesVO(this.getSrvNodoService());//Las url para pintar
				for (int i = 0; i < nodosIntersacados.length; i++) {
					for (int j = 0; j < nodos.length; j++) {
						if (nodos[j].getIdNodo().equalsIgnoreCase(nodosIntersacados[i])) {
							nodosIntersacados[i] = nodos[j].getUrlWS();
							break;
						}
						
					}
				}
				publiSes.setComunidadesMostrar(nodosIntersacados);
				form.setComunidades(conLocal);
				form.setComunidadesMostrar(publiSes.getComunidadesMostrar());
			} else {
				form.setComunidades("");
			}

			// idODE

			if ((publiSes.getIdODE() == null) || (publiSes.getIdODE().length() == 0))
				publiSes.setIdODE(form.getIdODE());
			if(logger.isDebugEnabled())
				logger.debug("idode form = " + form.getIdODE() + " idode ses = " + publiSes.getIdODE() + ";");

			// titulo
			if (publiSes.getTitulo() == null)
				publiSes.setTitulo(form.getTitulo());

			// es despublicado
			//Nunca viene vacio el esDespublicado; excepto cuando entramos a modificar las licencias, y en ese caso la sesion ya viene implementada.
			if(!(form.getEsDespublicado()==null)){
				publiSes.setEsDespublicado(form.getEsDespublicado());
				logger.debug("Lo metemos en el objeto de sesion.Este ODE es despublicado?"+form.getEsDespublicado());
			}else{
				logger.debug("Volvemos del modificar?"+form.getEsDespublicado()+"es del form; y de la sesion"+publiSes.getEsDespublicado());
			}
			

			// posibles comentarios anteriores
			form.setComentarios(publiSes.getComentarios());

			// Ahora pasamos la licencia
			if(logger.isDebugEnabled()){
				logger.debug("Metemos los campos en el form");
				logger.debug("Licencia: " + publiSes.getTipoLicencia() + " Universal?" + publiSes.getUniversal());
				logger.debug("Licencia obtenida.");
			}

		} catch (Exception ex) {
			logger.error("Error al cargar pantalla de publicar: ", ex);
			throw new ValidatorException("{gestorFlujo.error.inesperado}");

		}
	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#despublicado(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.DespublicadoForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final java.lang.Boolean despublicado(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.DespublicadoForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		PublicarSession publiSes = this.getPublicarSession(request);

		// limpiamos la sesión una vez que hemos cancelado
		publiSes.setComunidades("");
		publiSes.setIdODE("");
		publiSes.setTipoLicencia("");
		publiSes.setUniversal("");
		Boolean resultado = (this.getPublicarSession(request).getEsDespublicado());
		publiSes.setEsDespublicado(false);
		// volvemos a la pagina de la que seamos :)
		return resultado;

	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#cargaFormularoLicencias(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularoLicenciasForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cargaFormularoLicencias(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularoLicenciasForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean disponible = true;
		try {
			if(logger.isDebugEnabled())
				logger.debug("Cargando formulario licencias" );
			// Los idiomas del buscador
			// el combo lo mostramos en el idioma de navegación, pero en la
			// consolidación habrá que guardarlo en inglés
			String[] menCombos = new String[] { getPropertyValue("combo.tipoLicencias") };
			TerminoVO[] licencias = this.getSrvVocabulariosControladosService().obtenerCombos(menCombos,
					LdapUserDetailsUtils.getIdioma())[0].getTerminos();
			licencias = ordena(licencias, LdapUserDetailsUtils.getIdioma());
			if(logger.isDebugEnabled())
			logger.debug("vocabularios obtenidos, idioma: " + request.getLocale().getLanguage());
			form.setLicenciasAsArray(licencias);
			// la licencia seleccionada
			form.setTipo_licencia(this.getPublicarSession(request).getTipoLicencia());
			if ((this.getPublicarSession(request).getUniversal()
					.compareTo(getPropertyValue("licencia.acceso.universal"))) == 0)
				form.setAmbito_todas("1");
			else
				form.setAmbito_todas("0");

			SrvNodoService nodos = this.getSrvNodoService();
			// Cargamos la lista de NODOS con los nodos dados de alta.
			// Hay que tener en cuenta los nodos que ya tenga el propio ODE,
			// para que aparezcan seleccionados. No va a aparecer el nodo local
			if (nodos != null) {
				// Ahora llamamos al mapero que me dice cuantos de los nodos de
				// la lista estan licenciados
				if(logger.isDebugEnabled())
				logger.debug("Vamos a listar los nodos con las licencias impresas");
				form.setComunidadesAsArray(mapeaArrayNodoVOToNodoVOODE(nodos.listarNodos(), this.getPublicarSession(
						request).getComunidades()));
			} else {
				if(logger.isDebugEnabled())
				logger.error("No hay servicio de nodos cargando licencias");
				disponible = false;
			}

		} catch (Exception ex) {
			logger.error("Error cargando licencias. ", ex);
			if (disponible)
				throw new ValidatorException("{gestorFlujo.error.inesperado}");
			else
				throw new ValidatorException("{gestorFlujo.agregarLicencia.noDisponible}");
		}
	}

	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#consolidaLicencias(org.apache.struts.action.ActionMapping,
	 *      es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.ConsolidaLicenciasForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void consolidaLicencias(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.ConsolidaLicenciasForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {


		try {
			PublicarSession publiSes = this.getPublicarSession(request);
			//Nos olvidamos del nodo local, al cargar la pagina de publicar se lo meteremos siempre
//				if (form.getUniversal() == null && !form.getUniversal().equals("")) {
					//si hemos seleccionado todos los nodos entendemos que es universal
					if (form.getComunidadesSeleccionadasAsArray()!=null && form.getComunidadesSeleccionadasAsArray().length == (this.getSrvNodoService().listarNodos().length)+1) {
						publiSes.setUniversal(getPropertyValue("licencia.acceso.universal"));
					} else {
						publiSes.setUniversal(getPropertyValue("licencia.acceso.non-universal"));
						if(form.getComunidadesSeleccionadasAsArray()!=null && form.getComunidadesSeleccionadasAsArray().length>0){//Si hemos chequeado algún nodo lo recogemos
							String[] comunidadesMostrar = new String[form.getComunidadesSeleccionadasAsArray().length];
							String comunidadesDesc = "";
							NodoVO[] nodos = this.getSrvNodoService().listarNodos();

							for (int i = 0; i < form.getComunidadesSeleccionadasAsArray().length ; i++) { 
								comunidadesDesc = comunidadesDesc+(form.getComunidadesSeleccionadasAsArray()[i]).toString()+ ",";
								// TODO manera transitoria de recuperar el nombre de los
								// nodos								
								for (int j = 0; j < nodos.length; j++) {//Los nombres de los nodos
									if (nodos[j].getIdNodo().equalsIgnoreCase(
											form.getComunidadesSeleccionadasAsArray()[i].toString())) {
										comunidadesMostrar[i] = nodos[j].getUrlWS();
										break;
									}
	
								}
							}
							if(logger.isDebugEnabled())
								logger.debug("ComunidadesMostrar:"+comunidadesDesc);
							comunidadesDesc = comunidadesDesc.substring(0, comunidadesDesc.length() - 1);
							publiSes.setComunidades(comunidadesDesc);
							publiSes.setComunidadesMostrar(comunidadesMostrar);
							if(publiSes.getComunidadesMostrar().length== (this.getSrvNodoService().listarNodos().length)){
								publiSes.setUniversal(getPropertyValue("licencia.acceso.universal"));
								logger.debug("Hemos seleccionado todos los nodos, por lo que será universal");
							}
							if(logger.isDebugEnabled())
								logger.debug("Consolidando licencias: tipo= " + form.getTipoLicenciaSeleccionada()
												+ " Número de comunidades = " + form.getComunidadesSeleccionadasAsArray().length
												+ " comunidades: " + publiSes.getComunidades() + " Universal= "
												+ publiSes.getUniversal() + ".");
							
						}else{//Si no se ha chequeado ningún nodo, le pasamos un String vacío y comunidades para mostrar vacío
							String[] comunidadesMostrar = new String[0];
							publiSes.setComunidadesMostrar(comunidadesMostrar);
							publiSes.setComunidades("");
						}
					}
//				}else{
//					publiSes.setUniversal(getPropertyValue("licencia.acceso.universal"));
//					logger.debug("licencia del ode universal");
//				}

			// hay que mostrar el tipo de licencia en el idioma de la sesión

			 publiSes.setTipoLicencia(form.getTipoLicenciaSeleccionada());
			 logger.info("Licencia consolidada correctamente en la session ["+form.getTipoLicenciaSeleccionada());
			logger.info("Ambito consolidado correctamente en la session");

		} catch (ValidatorException ex) {
			logger.error("Excepcion consolidando licencias:", ex);
			throw ex;
		} catch (Exception ex) {
			logger.error("Excepcion consolidando licencias:", ex);
			throw new ValidatorException("{gestorFlujo.error.inesperado}");
		}
	}

	private TerminoVO[] ordena(TerminoVO[] termino, String idioma) {
		for (int j = 0; j < termino.length - 1; j++) {

			for (int k = j + 1; k < termino.length; k++) {

				if (termino[j].getNomTermino().compareTo(termino[k].getNomTermino()) > 0) {

					TerminoVO auxTerm = new TerminoVO();

					String aux = termino[k].getNomTermino();
					String auxId = termino[k].getIdTermino();
					auxTerm.setIdiomaTermino(idioma);
					auxTerm.setIdTermino(auxId);
					auxTerm.setNomTermino(aux);

					termino[k] = termino[j];
					termino[j] = auxTerm;
				}
			}
		}
		return termino;
	}

	/** obtener el property* */
	private String getPropertyValue(String sKey) {
		String sReturn = new String();
		try {
			if (props == null) {
				InputStream fIsSpringProperties = MenuController.class.getResourceAsStream(FILE_NAME_PROPERTIES);
				props = new java.util.Properties();
				props.load(fIsSpringProperties);
			}
			sReturn = props.getProperty(sKey);
		} catch (IOException e) {
			logger.error(e);
		}
		// devolvemos la propiedad
		return sReturn;
	}

	/*
	 * Este metodo mapea los objetos de nodovo a nodoODE vo dependiendo de si
	 * los nodos que le pasan estan en la lista de nodos licenciados
	 */
	private NodoVOODE[] mapeaArrayNodoVOToNodoVOODE(NodoVO[] listaNodos, String listaLicenciados) {
		NodoVOODE[] nodosReturn = new NodoVOODE[listaNodos.length];
		ArrayList arrayLicenciados = new ArrayList(Arrays.asList(listaLicenciados.split(",")));
		// Nos recorremos la lista de nodos y vemos uno a uno si aparece en la
		// lista de licenciados, si es asi, los marcamos positivamente,
		// si no, negativamente.
//		logger.debug("los nodos que somos en mapear: " + listaLicenciados);
//		logger.debug("tamaño de array licenciados: " + arrayLicenciados.size()+";");
//		for (int i =0;i<arrayLicenciados.size();i++)
//		{
//			logger.debug("array licenciado de " + i + " = " + (String)arrayLicenciados.get(i) + ";");
//		}
//		logger.debug("el penultimo arraylist: " + (String)arrayLicenciados.get(arrayLicenciados.size()-2));
//		logger.debug("el ultimo arraylist: " + (String)arrayLicenciados.get(arrayLicenciados.size()-1));
		for (int i = 0; i < listaNodos.length; i++) {
			if(logger.isDebugEnabled())
			logger.debug("Mapeando nodo[" + listaNodos[i].getIdNodo() + "] etiqueta[" + listaNodos[i].getNodo()
					+ "]esta presente?[" + arrayLicenciados.contains(listaNodos[i].getIdNodo()) + "]");
			// NodoVOODE nodo=
			// (NodoVOODE)this.getBeanMapper().map(listaNodos[i],
			// NodoVOODE.class);
			NodoVOODE nodo = new NodoVOODE();
			nodo.setNodo(listaNodos[i].getNodo());
			nodo.setIdNodo(listaNodos[i].getIdNodo());
			nodo.setEstaLicenciado(arrayLicenciados.contains(listaNodos[i].getIdNodo()));
			nodosReturn[i] = nodo;
		}
		// No vamos a añadir el nodo local
//		NodoVOODE nodo = new NodoVOODE();
//		nodo.setNodo(DependentServerProperties.getInstance().getServerOn());
//		nodo.setIdNodo(DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO));
//		nodo.setEstaLicenciado(true);
//		nodosReturn[listaNodos.length] = nodo;
		return nodosReturn;
	}

	// Necesitamos un VO que albergue los nodos (la info de id y etiqueta) y
	// cierta informacion para saber si el nodo estaba ya en el ODE o no.
	public class NodoVOODE {
		private String idNodo;

		private String nodo;

		boolean estaLicenciado;

		public boolean isEstaLicenciado() {
			return estaLicenciado;
		}

		public void setEstaLicenciado(boolean estaLicenciado) {
			this.estaLicenciado = estaLicenciado;
		}

		public String getNodo() {
			return nodo;
		}

		public void setNodo(String nodo) {
			this.nodo = nodo;
		}

		public String getIdNodo() {
			return idNodo;
		}

		public void setIdNodo(String idNodo) {
			this.idNodo = idNodo;
		}

	}

	public Boolean decideVuelta(ActionMapping mapping, DecideVueltaForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(logger.isDebugEnabled())
			logger.debug("Es despublicado?"+this.getPublicarSession(request).getEsDespublicado());

		return this.getPublicarSession(request).getEsDespublicado();

	}
	
	private String[] interseccionNodos( String nodos) throws Exception
	{
			SrvNodoService nodosPlataforma = this.getSrvNodoService();
			
			String[] nodosListados=obtenNodosLocalesIds(nodosPlataforma);
			HashSet nodosTotal = new HashSet(Arrays.asList(nodosListados));
			ArrayList listaNodos=new ArrayList(Arrays.asList(nodos.split(",")));
			HashSet nodosLeidos = new HashSet(listaNodos);
			nodosLeidos.retainAll(nodosTotal);
			if(!nodosLeidos.contains(nodosListados[0])){
				nodosLeidos.add(nodosListados[0]);
			}
			String[] retorno = (String[]) nodosLeidos.toArray(new String[0]);
			return retorno;
	}
	
	private static String[] obtenNodosLocalesIds(SrvNodoService srvNodos) throws Exception
	{
		NodoVO[] nodos = srvNodos.listarNodos();
//		Obtenemos el nodo local y lo añadimos
		String[] nodosReturn = new String[((nodos!=null)?nodos.length+1:1)];
		nodosReturn[0] = DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO);
		for (int i = 1; i < nodosReturn.length; i++) {
			nodosReturn[i] = nodos[i-1].getIdNodo();
		}
		return nodosReturn;
	}
	private  NodoVO[] obtenNodosLocalesVO(SrvNodoService srvNodos) throws Exception
	{
		NodoVO[] nodos = srvNodos.listarNodos();
		if(logger.isDebugEnabled())
		logger.debug("Son los nodos nulos?"+nodos);
//		Obtenemos el nodo local y lo añadimos
		NodoVO[] nodosReturn = new NodoVO[((nodos!=null && nodos.length>0)?nodos.length+1:1)];
		if(logger.isDebugEnabled())
		logger.debug("El length de nodosReturn:"+nodosReturn.length);
		NodoVO nodoAux=new NodoVO();
		nodoAux.setIdNodo(DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO));
		nodoAux.setUrlWS(DependentServerProperties.getInstance().getServerOn());
		nodosReturn[0]=nodoAux;
		for (int i = 1; i < nodosReturn.length; i++) {
			nodosReturn[i]=nodos[i-1];
		}
		return nodosReturn;
	}
}
