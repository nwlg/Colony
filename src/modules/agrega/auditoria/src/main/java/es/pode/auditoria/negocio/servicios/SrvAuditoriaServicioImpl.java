/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.servicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import java.sql.Date;
import java.util.*;
import java.util.logging.Level;
import javax.activation.DataHandler;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.xml.transform.stream.StreamSource;
import org.apache.axis.attachments.SourceDataSource;
import org.apache.log4j.Logger;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.HTMLRenderOption;
import org.eclipse.birt.report.engine.api.HTMLServerImageHandler;
import org.eclipse.birt.report.engine.api.IRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;
import org.eclipse.birt.report.engine.api.RenderOption;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.adminusuarios.negocio.servicios.ParametroAuditoriaUsuariosVO;
import es.pode.adminusuarios.negocio.servicios.UsuarioActivoVO;
import es.pode.auditoria.negocio.dominio.BusquedaDao;
import es.pode.auditoria.negocio.dominio.ComentarioDao;
import es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria;
import es.pode.auditoria.negocio.dominio.OdePublicadoDao;
import es.pode.auditoria.negocio.dominio.Operacion;
import es.pode.auditoria.negocio.dominio.OperacionDao;
import es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria;
import es.pode.auditoria.negocio.dominio.ValoracionDao;
import es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonConRutaVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonPathVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TaxonVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.indexador.negocio.servicios.auditoria.CoberturaVO;
import es.pode.indexador.negocio.servicios.auditoria.ParametroAuditIndexadorVO;
import es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO;

import es.pode.planificador.negocio.servicios.ParametrosVO;
import es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;
import es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO;
import es.pode.publicacion.negocio.servicios.DetalleTransicionVO;
import es.pode.publicacion.negocio.servicios.EstadoActividadVO;
import es.pode.publicacion.negocio.servicios.ODEsEstadoVO;
import es.pode.publicacion.negocio.servicios.ParametroAuditPublicacionVO;
import es.pode.publicacion.negocio.servicios.PesoODEVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.valoracion.negocio.servicios.auditoria.ParametroAuditValoracionVO;
import es.pode.valoracion.negocio.servicios.auditoria.ValoracionODEVO;
import es.pode.soporte.estadisticas.EstadisticasProperties;
import es.pode.soporte.estadisticas.EstadisticasPropertiesImpl;
import es.pode.soporte.i18n.I18n;

/**
 * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio
 */

public class SrvAuditoriaServicioImpl extends es.pode.auditoria.negocio.servicios.SrvAuditoriaServicioBase
{

	private static Logger log = Logger.getLogger(SrvAuditoriaServicioImpl.class);
	private java.util.Properties pAuditoriaProperties = null;
	private java.util.Properties pAgregaProperties = null;
	private JmsTemplate jmsTemplate;
	private final Integer nivelAgregacionCatalogo = 3;
	private static final SimpleDateFormat confDateStringFormat =
			new SimpleDateFormat("yyyy-mm-dd");

	/**
	 * Registra en la Tarea ejecutada 
	 * @param trabajo Trabajo que se va a registrar
	 * @retun tareaCreada.getId() El id de la tarea que se registra
	 * @throws Exception
	 */
	protected java.lang.Long handleRegistrarTrabajoPlan(TareaEjecutadaPlanVO trabajo) throws java.lang.Exception
	{
		TareaEjecutadaVO tarea = new TareaEjecutadaVO();

		log("Trabajo: " + trabajo.getTrabajo() + " grupotrabajo: " + trabajo.getGrupoTrabajo() + " Descripcion: " + trabajo.getDescripcion() + " Estado: " + trabajo.getEstado() + " Fecha inicio: " + trabajo.getFechaInicio());

		tarea.setTrabajo(trabajo.getTrabajo());
		tarea.setGrupoTrabajo(trabajo.getGrupoTrabajo());
		tarea.setDescripcion(trabajo.getDescripcion());
		tarea.setEstado(trabajo.getEstado());

		if (trabajo.getFechaInicio() != null)
		{
			GregorianCalendar fechaInicio = new GregorianCalendar();
			fechaInicio.setTime((trabajo.getFechaInicio()).getTime());
			tarea.setFechaInicio(fechaInicio);
		}

		if (trabajo.getFechaFin() != null)
		{
			GregorianCalendar fechaFin = new GregorianCalendar();
			fechaFin.setTime((trabajo.getFechaFin()).getTime());
			tarea.setFechaFin(fechaFin);
			log("Fecha fin: " + trabajo.getFechaInicio());
		}

		Long id = this.getSrvRegistroPlanificadorService().registrarTrabajo(tarea);

		return id;
	}

	/**
	 * Registra la fecha en la que se ha finalizado la ejecucion de un trabajo 
	 * y se comprueba si la ejecución ha sido o no correcta
	 * @param trabajoEjecutado TareaEjecutadaVO
	 * @return tareaEntity.getId() El id del trabajo
	 * @throws Exception
	 * @see es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio#registrarTrabajoFechaFinPlan(es.pode.auditoria.negocio.servicios.TareaEjecutadaPlanVO)
	 */
	protected java.lang.Long handleRegistrarTrabajoFechaFinPlan(TareaEjecutadaPlanVO trabajo) throws java.lang.Exception
	{
		TareaEjecutadaVO tarea = new TareaEjecutadaVO();

		log("Id: " + trabajo.getId() + " trabajo: " + trabajo.getTrabajo() + " grupotrabajo: " + trabajo.getGrupoTrabajo() + " Descripcion: " + trabajo.getDescripcion() + " Estado: " + trabajo.getEstado() + " Fecha inicio: "
				+ trabajo.getFechaInicio());

		tarea.setId(trabajo.getId());
		tarea.setTrabajo(trabajo.getTrabajo());
		tarea.setGrupoTrabajo(trabajo.getGrupoTrabajo());
		tarea.setDescripcion(trabajo.getDescripcion());
		tarea.setEstado(trabajo.getEstado());

		if (trabajo.getFechaInicio() != null)
		{
			GregorianCalendar fechaInicio = new GregorianCalendar();
			fechaInicio.setTime((trabajo.getFechaInicio()).getTime());
			tarea.setFechaInicio(fechaInicio);
		}

		if (trabajo.getFechaFin() != null)
		{
			GregorianCalendar fechaFin = new GregorianCalendar();
			fechaFin.setTime((trabajo.getFechaFin()).getTime());
			tarea.setFechaFin(fechaFin);
			log("Fecha fin: " + trabajo.getFechaInicio());
		} else
			log("La fecha fin no debería ser nula");

		Long id = this.getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(tarea);

		return id;
	}

	/**
	 * Registra en la tabla correspodiente si ha ido o no bien la carga de las sub-tareas que estan
	 * asociadas a una tarea en concreto 
	 * @param trabajoHijo El sub-trabajo de un trabajo concreto
	 * @return registroEntity.getId() El id del registro
	 * @throws Exception
	 */
	protected java.lang.Long handleRegistrarTrabajoHijoPlan(RegistroTareaEjecPlanVO trabajoHijo) throws java.lang.Exception
	{
		RegistroTareaEjecutadaVO tareaSub = new RegistroTareaEjecutadaVO();

		log("Trabajo hijo, descripcion: " + trabajoHijo.getDescripcion() + " Estado: " + trabajoHijo.getEstado() + " codigo: " + trabajoHijo.getCodigo() + " Fecha inicio: " + trabajoHijo.getFecha());

		tareaSub.setCodigo(trabajoHijo.getCodigo());
		tareaSub.setDescripcion(trabajoHijo.getDescripcion());
		tareaSub.setEstado(trabajoHijo.getEstado());

		if (trabajoHijo.getFecha() != null)
		{
			GregorianCalendar fecha = new GregorianCalendar();
			fecha.setTime((trabajoHijo.getFecha()).getTime());
			tareaSub.setFecha(fecha);
		}

		Long id = this.getSrvRegistroPlanificadorService().registrarTrabajoHijo(tareaSub);

		return id;
	}

	/**
	 * Realiza la operacion de cambio de estado a INTERRUMPIDO de los trabajos 
	 * que no finalizaron cuando el servidor de aplicaciones se ha parado inesperadamente
	 * @return filasModificadas Las filas modificadas
	 * @throws Exception
	 */
	protected java.lang.Long handleRegistrarTrabajoInterrPlan() throws java.lang.Exception
	{
		Long id = this.getSrvRegistroPlanificadorService().registrarTrabajoInterrumpido();

		log("Número de trabajos interrumpidos " + id);

		return id;
	}

	/**
	 * Registra la operacion realizada por el usuario
	 * @param operacion Operación realizada por el usuario
	 * @return resultadoRegistro resultado del registro
	 * @throws Exception
	 */

	protected void handleRegistrarOperacion(es.pode.auditoria.negocio.servicios.OperacionVO operacion) throws java.lang.Exception
	{
		log("REGISTRAR OPERACION");
		this.enviarMensajeOperacion(operacion);

	}

	/**
	 * Obtiene un array de InformeOperacionVO con las operaciones realizadas por los visitantes: ficha ODE, previsualización y descarga en un rango de fechas
	 * @param  parametrosInformeVO Value Object con los parámetros que necesita el método de generación del informe
	 * @return InformeOperacionVO[] Array de Value Objects con la información de las operaciones y el número de veces que han sido realizadas
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeOperacionVO[] handleInformeOperacionesRealizadas(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception
	{
		log.info("informeOperacionesRealizadas");
		InformeOperacionVO[] informeOperacionVO = null;
		String idioma = parametroInformeVO.getIdioma();
		if (idioma == null)
		{
			
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		Locale locale = new Locale(idioma);
		if (parametroInformeVO == null)
		{
			log.error("Error calculando operaciones realizadas. No hay parametros.");
			throw new Exception("Error calculando operaciones realizadas. No hay parametros.");
		}

		//Validamos las fechas
		
		if(!(this.validarFechas(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
			
		String[] operacionesString = obtenerOperaciones();
		

		if (operacionesString == null)
		{
			log.error("Error calculando operaciones realizadas. No se pueden obtener las operaciones a contabilizar.");
			throw new Exception("Error calculando operaciones realizadas. No se pueden obtener las operaciones a contabilizar.");
		}
		log("Las operaciones disponibles en la plataforma:");
		for (int i = 0; i < operacionesString.length; i++)
		{
			log("El valor de operacionesString " + operacionesString[i]);
		}
		informeOperacionVO = new InformeOperacionVO[operacionesString.length];
		Long numOperacion = null;
		for (int i = 0; i < operacionesString.length; i++)
		{
			informeOperacionVO[i] = new InformeOperacionVO();

			String tipo_operacion = operacionesString[i];
			log("tipo_operacion : " + tipo_operacion);
			if (tipo_operacion.indexOf("buscar") != -1)
			{
				try
				{
					numOperacion = this.getBusquedaDao().listarNumBusquedasDesdeHasta(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), tipo_operacion);
					log("Es una busqueda " + tipo_operacion + "numOperacion " + numOperacion);
				}catch(Exception e)
				{
					log.error("Se produce una excepcion en el informe de las operaciones realizadas "+e);
				}
			} else
			{
				log("Calculo el numero de operaciones realizadas");
				numOperacion = this.getOperacionDao().obtenerNumOperacionesDesdeHasta(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), tipo_operacion);
				log("Es una operacion " + tipo_operacion + "numOperacion " + numOperacion);
			}
			informeOperacionVO[i].setOperacion(this.getFicherRecursos(locale).getString(tipo_operacion));
			informeOperacionVO[i].setTotalOperacion(numOperacion.intValue());
		}
		if (informeOperacionVO == null)
		{
			log.error("Error obteniendo las operaciones realizadas");
			throw new Exception("Error calculando operaciones realizadas. No se ha obtenido ningun resultado.");
		}

		return informeOperacionVO;
	}

	/**
	 * Obtiene un array de InformeNivelAgregacionVO con los odes que hay por nivel de agregación
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeNivelAgregacionVO[] Array de Value Objects con la información de los odes de cada uno de los niveles de agregación
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeNivelAgregacionVO[] handleInformeNivelAgregacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		InformeNivelAgregacionVO[] informeNivelAgregacionVO = null;
		log.info("informeNivelAgregacion");
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando odes por nivel de agregacion. No hay parametros.");
			throw new Exception("Error calculando odes por nivel de agregacion. No hay parametros.");
		}
		
		//Validamos las fechas
		
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		ParametroAuditIndexadorVO parametroAuditIndexadorVO = new ParametroAuditIndexadorVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditIndexadorVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditIndexadorVO.setFechaHasta(gcHasta);
		log("Parametros del servicio: " + parametroAuditIndexadorVO.getFechaDesde()+" "+ parametroAuditIndexadorVO.getFechaHasta());
		CoberturaVO[] coberturaVO = this.getSrvAuditoriaIndexadorService().coberturaNivelAgregacion(parametroAuditIndexadorVO);
		if (coberturaVO == null)
		{
			log.error("coberturaVO es null " + coberturaVO);
		} else
		{
			informeNivelAgregacionVO = new InformeNivelAgregacionVO[coberturaVO.length];
			log("El array de resultados (InformeNivelAgregacionVO[]) tiene un tamanio de " + informeNivelAgregacionVO.length);
			for (int i = 0; i < coberturaVO.length; i++)
			{
				informeNivelAgregacionVO[i] = new InformeNivelAgregacionVO();
				this.getBeanMapper().map(coberturaVO[i], informeNivelAgregacionVO[i]);
			}
			log("devuelvo el VO informeNivelAgregacionVO ");
			if (informeNivelAgregacionVO == null)
			{
				log.error("Error calculando los odes por nivel de agregacion");
				throw new Exception("Error calculando los odes por nivel de agregacion. No se ha obtenido ningun resultado.");
			}
		}
		return informeNivelAgregacionVO;
	}

	/**
	 * Obtiene un array de InformeCoberturaCurricularVO con los odes que hay en cada uno de los nodos del árbol curricular
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeCoberturaCurricularVO[] Array de Value Objects con la información de los odes de cada una de las ramas del árbol curricular
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeCoberturaCurricularVO[] handleInformeCoberturaCurricular(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{

		InformeCoberturaCurricularVO[] informeCoberturaCurricularVO = null;
		log.info("informeCoberturaCurricular");
		String idioma = parametrosInformeVO.getIdioma();
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando cobertura por arbol curricular. No hay parametros.");
			throw new Exception("Error calculando cobertura por arbol curricular. No hay parametros.");
		}
		
		//Validamos las fechas
		
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		ParametroAuditIndexadorVO parametroAuditIndexadorVO = new ParametroAuditIndexadorVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditIndexadorVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditIndexadorVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditIndexadorVO.getFechaDesde() + " FechaFin : " + parametroAuditIndexadorVO.getFechaHasta());
		ArbolCurricularVO[] arbolCurricular = this.obtenerArbolCurricular(idioma);
		if (arbolCurricular == null)
		{
			log.error("Error obteniendo todo el arbol curricular para el idioma que se pasa por parametro");
			throw new Exception("Error obteniendo todo el arbol curricular para el idioma que se pasa por parametro");
		}else
		{
			log("El arbolCurricular obtenido es " + arbolCurricular.length);
		}
		String[] idNodos = this.obtenerIdArbolCurricular(arbolCurricular);
		log("El arbos curricular tiene " + idNodos.length+" nodos");
		log("El primer nodo es :" + idNodos[0]);
		parametroAuditIndexadorVO.setIdNodo(idNodos);
		CoberturaVO[] coberturaVO = this.getSrvAuditoriaIndexadorService().coberturaArbolCurricular(parametroAuditIndexadorVO);
		log("se ha obtenido el VO  coberturaVO" + coberturaVO);
		if(coberturaVO == null)
		{
			log.error("El VO coberturaVO es null");
			throw new Exception("Error obteniendo el informe de la cobertura por arbol curricular");
		}else
		{
			informeCoberturaCurricularVO = new InformeCoberturaCurricularVO[coberturaVO.length];
			for (int i = 0; i < coberturaVO.length; i++)
			{
				informeCoberturaCurricularVO[i] = new InformeCoberturaCurricularVO();
				this.getBeanMapper().map(coberturaVO[i], informeCoberturaCurricularVO[i]);
				informeCoberturaCurricularVO[i].setCoberturaCurricular(arbolCurricular[i].getIdNodo() + " " + arbolCurricular[i].getNombreNodo());
			}
			if (informeCoberturaCurricularVO == null)
			{
				log.error("Error obteniendo el informe de la cobertura por arbol curricular");
				throw new Exception("Error obteniendo el informe de la cobertura por arbol curricular");
			}else
			{
				log("El VO informeCoberturaCurricularVO tiene un tamanio " + informeCoberturaCurricularVO.length);
			}
		}
		return informeCoberturaCurricularVO;
	}

	/**
	 * Obtiene un array de InformeTerminoBusquedaVO con los terminos más buscados en un periodo de tiempo concreto
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeTerminoBusquedaVO[] Value Object con la información de los términos más buscados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeTerminoBusquedaVO[] handleInformeTerminosBusqueda(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		
		log.info("Informe de los terminos mas buscados");
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando terminos mas buscados. No hay parametros.");
			throw new Exception("Error calculando terminos mas buscados. No hay parametros.");
		}
		Calendar fechaDesde = parametrosInformeVO.getFechaDesde();
		Calendar fechaHasta = parametrosInformeVO.getFechaHasta();
		int numMaxRes = parametrosInformeVO.getRango();

		if (numMaxRes == 0)
		{
			log.error("Error calculando terminos mas buscados. El numero de resulados a devolver es nulo o 0.");
			throw new Exception("Error calculando terminos mas buscados El numero de resulados a devolver es nulo o 0.");
		}
		
		//Validamos las fechas
		
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
	
		String[] listaResultante = (String[]) this.getBusquedaDao().listarTerminosBuscadosDesdeHasta(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta()).toArray(new String[0]);
		if (listaResultante == null || listaResultante.length == 0)
		{
			log.info("Calculando terminos mas buscados. No existen terminos buscados dentro del periodo desde[" + fechaDesde + "]->hasta[" + fechaHasta + "]");
			return null;
		}
		log("El resultado es " + listaResultante.length);
		HashMap mapaValores = new HashMap();
		Long numeroBusquedas = null;
		for (int i = 0; i < listaResultante.length; i++)
		{
			try
			{
				if (!listaResultante[i].equals(""))//solo nos interesan los identificadores con contenido
				{
					numeroBusquedas = this.getBusquedaDao().obtenerNumTerminosBuscados(fechaDesde, fechaHasta, listaResultante[i]);
					if (numeroBusquedas != null)
						mapaValores.put(listaResultante[i], numeroBusquedas);
				}
			} catch (Exception e)
			{
				log.error("Calculando terminos mas buscados. Error obteniendo numero de busquedas para el termino[" + listaResultante[i] + "]. Continuamos el calculo.");
			}
		}
		if (mapaValores.isEmpty())
		{
			log.error("Error calculando contenidos mas valorados. No hay valoraciones disponibles para [" + listaResultante.length + "] ODEs!! desde[" + fechaDesde + "]->hasta[" + fechaHasta + "]");
			return null;
		}
		//Construimos el array de valores que devolveremos sin ordenar
		InformeTerminoBusquedaVO[] arrayTemp = new InformeTerminoBusquedaVO[mapaValores.size()];
		//Recogemos la lista de ids 
		log("mapaValores.size() "+mapaValores.size());
		String[] ids = (String[]) mapaValores.keySet().toArray(new String[0]);
		for (int i = 0; i < ids.length; i++)
		{
			Integer valor = new Integer((new Long((Long)mapaValores.get(ids[i])).toString()));
			arrayTemp[i] = new InformeTerminoBusquedaVO(ids[i], valor.intValue());
		}
		//Con los odes que hemos calculado tenemos que ordenarlos de mayor a menor y devolver solo la cantidad pedida.
		arrayTemp = ordenaDescendente(arrayTemp);
		if (arrayTemp.length <= numMaxRes)
			return arrayTemp;
		else
		{
			InformeTerminoBusquedaVO[] devuelto = new InformeTerminoBusquedaVO[numMaxRes];
			for (int i = 0; i < numMaxRes; i++)
			{
				devuelto[i] = arrayTemp[i];
			}
			return devuelto;
		}

	}

	/**
	 * Obtiene un array de InformeOperacionOdeUsuarioVO con el estado de todos los odes de la plataforma para un usuario concreto en un rango de fechas determinado
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeOperacionOdeUsuarioVO[] Value Object con la información de los odes de un usuario
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeOdeUsuarioVO[] handleInformeOdeUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception
	{
		log.info("informe OdeUsuario");
		InformeOdeUsuarioVO[] informeOperacionOdeUsuarioVO = null;
		String idioma = parametroInformeVO.getIdioma();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setLenient(false);
		
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		//Locale locale = new Locale(idioma);
		log(" fechaDesde " + parametroInformeVO.getFechaDesde());
		log(" fechaHasta " + parametroInformeVO.getFechaHasta());
		if (parametroInformeVO == null)
		{
			log.error("Error calculando las operaciones realizadas por un usuario. No hay parametros.");
			throw new Exception("Error calculando las operaciones realizadas por un usuario. No hay parametros.");
		}
		//Validamos las fechas
		
		if(!(this.validarFechas(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
	
		ParametroAuditPublicacionVO parametroAuditPublicacionVO = new ParametroAuditPublicacionVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametroInformeVO.getFechaDesde()).getTime());
		parametroAuditPublicacionVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametroInformeVO.getFechaHasta()).getTime());
		parametroAuditPublicacionVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditPublicacionVO.getFechaDesde() + " FechaFin : " + parametroAuditPublicacionVO.getFechaHasta());
		parametroAuditPublicacionVO.setIdioma(idioma);
		parametroAuditPublicacionVO.setIdUsuario(parametroInformeVO.getIdUsuario());
		log("parametroAuditPublicacionVO.getIdUsuario() " + parametroAuditPublicacionVO.getIdUsuario());
		EstadoActividadVO[] estadoActividadVO = this.getSrvAuditaPublicacionService().odesPorUsuario(parametroAuditPublicacionVO);
		//Deberíamos sacar los titulos
		log("Se ha realizado la llamada a this.getSrvAuditaPublicacionService().odesPorUsuario");
		if (!(estadoActividadVO == null))
		{
			log("El resultado de la llamada a SrvAuditaPublicacionService().odesPorEstados es " + estadoActividadVO.length);

		}
		//Sacamos el listado de operaciones para realizar las consultas
		int numInformesOperacion = 0;
		for (int j = 0; j < estadoActividadVO.length; j++)
		{
			if (estadoActividadVO[j].getDetalleTransicionVOs().length == 0)
			{
				numInformesOperacion = numInformesOperacion + 1;
			} else
			{
				numInformesOperacion = numInformesOperacion + estadoActividadVO[j].getDetalleTransicionVOs().length;
			}
		}
		String[] estados = new String[estadoActividadVO.length];
		Vector titulosTotal = new Vector();
		InformeOdeUsuarioVO informeTemp;
		InformeOdeUsuarioVO[] informeTempArray;
		for (int i = 0; i < estadoActividadVO.length; i++)
		{
 
			estados[i] = new String();
			estados[i] = estadoActividadVO[i].getEstado();
			DetalleTransicionVO[] detalleTransiccionVO = estadoActividadVO[i].getDetalleTransicionVOs();
			if (detalleTransiccionVO.length == 0)
			{
				log("no tiene titulos");
				informeTemp = new InformeOdeUsuarioVO();
				informeTemp.setEstado(estados[i]);
				informeTemp.setFechaTransiccion(null);
				informeTemp.setTitulo("");
				titulosTotal.add(informeTemp);
			} else
			{
				log("Tiene titulos");
				informeTempArray = new InformeOdeUsuarioVO[detalleTransiccionVO.length];
				for (int j = 0; j < detalleTransiccionVO.length; j++)
				{
					informeTempArray[j] = new InformeOdeUsuarioVO();
					informeTempArray[j].setEstado(estados[i]);
					String fechaT = "";
					fechaT = format.format((detalleTransiccionVO[j].getFechaTransicion()).getTime());
					informeTempArray[j].setFechaTransiccion(fechaT);
					informeTempArray[j].setTitulo(detalleTransiccionVO[j].getTitulo());
					titulosTotal.add(informeTempArray[j]);
				}
			}

		}
		log("titulosTotal.size() -> " + titulosTotal.size());
		//informeOperacionOdeUsuarioVOTemp = (InformeOdeUsuarioVO[])titulosTotal.toArray(new InformeOdeUsuarioVO[0]);
		//Sacamos las operaciones realizadas por el usuario

		informeOperacionOdeUsuarioVO = new InformeOdeUsuarioVO[titulosTotal.size()];
		for (int p = 0; p < titulosTotal.size(); p++)
		{
			informeOperacionOdeUsuarioVO[p] = new InformeOdeUsuarioVO();
			informeOperacionOdeUsuarioVO[p] = (InformeOdeUsuarioVO) titulosTotal.elementAt(p);

		}

		return informeOperacionOdeUsuarioVO;
	}





/**
 *
 * TODO: document it!
 * @param parametroInformeVO
 * @return
 * @throws java.lang.Exception
 */
	protected es.pode.auditoria.negocio.servicios.InformeOdeUsuarioPLUSVO[] handleInformeOdeUsuarioPLUS(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception
        {

		log.info("report OdeUsuarioPLUS");

                String userId = parametroInformeVO.getIdUsuario();

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setLenient(false);

		log(" fechaDesde " + parametroInformeVO.getFechaDesde());
		log(" fechaHasta " + parametroInformeVO.getFechaHasta());
		if (parametroInformeVO == null)
		{
			log.error("Error running the user operations. There aren't paremeters.");
			throw new Exception("Error running the user operations. There aren't paremeters.");
		}
		//Date validation

		if(!(this.validarFechas(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Dates are wrong.");
			throw new Exception("Error running the user operations. Dates are wrong.");
		}


                //Query Searches
		log.info("report OdeUsuarioPLUS: Searches");
                BusquedaDao busquedaDao = this.getBusquedaDao();
                final java.util.List obj = (java.util.List)busquedaDao.listBusquedasDesdeHastaByUser(nivelAgregacionCatalogo, userId, parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

                
                ArrayList<InformeOdeUsuarioPLUSVO> alresults = new ArrayList<InformeOdeUsuarioPLUSVO>();

                final Iterator it = obj.iterator();
                while (it.hasNext()) {
                    Object[] twoItems = (Object[])it.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Searches",item,""+count));
                }


                //Query Previews
                log.info("report OdeUsuarioPLUS: Previews");
                OperacionDao operacionDao = this.getOperacionDao();
                final java.util.List obj2= (java.util.List)operacionDao.findOdesTitleBetweenDatesByUserByOperation(nivelAgregacionCatalogo, userId, "previsualizado", parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

                final Iterator it2 = obj2.iterator();
                while (it2.hasNext()) {
                    Object[] twoItems = (Object[])it2.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Previewed",item,""+count));
                }


                //Query Downloads
                //There are many kinds of Downloads
                log.info("report OdeUsuarioPLUS: Downloads");               
                final java.util.List obj3= (java.util.List)operacionDao.findOdesTitleBetweenDatesByUserByOperation(nivelAgregacionCatalogo, userId, "descargado_%", parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

                final Iterator it3 = obj3.iterator();
                while (it3.hasNext()) {
                    Object[] twoItems = (Object[])it3.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Downloaded",item,""+count));
                }


                //Query Sends
                log.info("report OdeUsuarioPLUS: Sends");
                final java.util.List obj4= (java.util.List)operacionDao.findOdesTitleBetweenDatesByUserByOperation(nivelAgregacionCatalogo, userId, "enviarCorreo", parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

                final Iterator it4 = obj4.iterator();
                while (it4.hasNext()) {
                    Object[] twoItems = (Object[])it4.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Sent",item,""+count));
                }




                //Query Ratings
                log.info("report OdeUsuarioPLUS: Ratings");

                ValoracionDao valoracionDao = this.getValoracionDao();
                final java.util.List obj5= (java.util.List)valoracionDao.listarODEsValoradosDesdeHastaByUser(nivelAgregacionCatalogo, userId, parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

                final Iterator it5 = obj5.iterator();
                while (it5.hasNext()) {
                    Object[] twoItems = (Object[])it5.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Rated",item,""+count));
                }


                //10/11/2010    Fernando Garcia
                //              added comments ratings
                log.info("report OdeUsuarioPLUS: Comments");

                ComentarioDao comentarioDao = this.getComentarioDao();
                final java.util.List obj6= (java.util.List)comentarioDao.commentsPerUser(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), userId);

                final Iterator it6 = obj6.iterator();
                while (it6.hasNext()) {
                    Object[] twoItems = (Object[])it6.next();
                    String item = (String) twoItems[0];
                    Long count = (Long) twoItems[1];

                    alresults.add(new InformeOdeUsuarioPLUSVO("Comments",item,""+count));
                }



                InformeOdeUsuarioPLUSVO[] ioupa = new InformeOdeUsuarioPLUSVO[alresults.size()];
                ioupa = alresults.toArray(new InformeOdeUsuarioPLUSVO[]{});

            return ioupa;

        }













	/**
	 * Obtiene un array de InformeOperacionOdeUsuarioVO con el estado de todos los odes de la plataforma para un usuario concreto en un rango de fechas determinado
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeOperacionOdeUsuarioVO[] Value Object con la información de los odes de un usuario
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeOdeUsuarioVO[] handleInformeOdeUsuarioOperacion(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception
	{
		log.info("informe OdeUsuario");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setLenient(false);
		InformeOdeUsuarioVO[] informeOperacionOdeUsuarioVO = null;
		String[] operactionesString = null;
		String idioma = parametroInformeVO.getIdioma();
		Vector titulosTotal = new Vector();
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		Locale locale = new Locale(idioma);
		log(" fechaDesde " + parametroInformeVO.getFechaDesde());
		log(" fechaHasta " + parametroInformeVO.getFechaHasta());
		if (parametroInformeVO == null)
		{
			log.error("Error calculando las operaciones realizadas por un usuario. No hay parametros.");
			throw new Exception("Error calculando las operaciones realizadas por un usuario. No hay parametros.");
		}
		//Validamos las fechas
		
		if(!(this.validarFechas(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametroInformeVO.getFechaDesde()).getTime());
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametroInformeVO.getFechaHasta()).getTime());
		operactionesString = this.obtenerOperaciones();
		if (operactionesString == null)
		{
			log.error("Error calculando las operaciones realizadas por el usuario. La lista de operaciones es null");
			throw new Error("Error calculando las operaciones realizadas por el usuario. La lista de operaciones es null");
		}
		InformeOdeUsuarioVO informeOperacion = null;
		log("usuario[" + parametroInformeVO.getIdUsuario() + "]");
		for (int j = 0; j < operactionesString.length; j++)
		{
			String operacion = operactionesString[j];
			log("La operacion es[" + operacion + "]");
			if (operacion.indexOf("buscar") == -1)
			{

				List operacionesList = this.getOperacionDao().obtenerIdOdeOperUsuario(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), parametroInformeVO.getIdUsuario(), operacion);
				log("operacionesList.size() -> " + operacionesList.size());
				Operacion[] operacionesArray = (Operacion[]) operacionesList.toArray(new Operacion[0]);
				if ((operacionesArray == null) || (operacionesArray.length == 0))
				{
					log("No hay registros para esa operacion");
					informeOperacion = new InformeOdeUsuarioVO();
					informeOperacion.setEstado(this.getFicherRecursos(locale).getString(operactionesString[j]));
					informeOperacion.setFechaTransiccion(null);
					informeOperacion.setTitulo("");
					titulosTotal.add(informeOperacion);
				} else
				{
					log("Hay registros para esa operacion");
					String[] idOdes = new String[operacionesArray.length];
					for (int k = 0; k < idOdes.length; k++)
					{
						idOdes[k] = operacionesArray[k].getIdOde();
					}
					DetallePublicadoODEVO[] titulosIdOdes = (this.getSrvAuditaPublicacionService().titulosODEsPorID(idOdes));
					for (int k = 0; k < operacionesArray.length; k++)
					{
						informeOperacion = new InformeOdeUsuarioVO();
						informeOperacion.setEstado(this.getFicherRecursos(locale).getString(operactionesString[j]));
						String fechaO = "";
						fechaO = format.format((operacionesArray[k].getFecha()));
						informeOperacion.setFechaTransiccion(fechaO);
						informeOperacion.setTitulo(titulosIdOdes[k].getTitulo());
						titulosTotal.add(informeOperacion);
					}
				}
			} else
			{
				log("es una busqueda no hago nada");
			}

		}

		log("titulosTotal.size() -> " + titulosTotal.size());
		informeOperacionOdeUsuarioVO = new InformeOdeUsuarioVO[titulosTotal.size()];
		for (int p = 0; p < titulosTotal.size(); p++)
		{
			informeOperacionOdeUsuarioVO[p] = new InformeOdeUsuarioVO();
			informeOperacionOdeUsuarioVO[p] = (InformeOdeUsuarioVO) titulosTotal.elementAt(p);

		}
		
		return informeOperacionOdeUsuarioVO;
	}

	/**
	 * Obtiene un array de InformeOperacionOdeUsuarioVO con el estado de todos los odes de la plataforma para un usuario concreto en un rango de fechas determinado
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeOperacionOdeUsuarioVO[] VO con la información de los odes de un usuario
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeOperacionUsuarioVO[] handleInformeOperacionUsuario(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log("informeOperacionUsuario");
		InformeOperacionUsuarioVO[] informeOperacionUsuarioVO = null;
		String[] operactionesString = null;
		TitulosOdePorUsuarioDesdeHastaCriteria titulosOdePorUsuarioDesdeHastaCriteria = null;
		operactionesString = this.obtenerOperaciones();
		if (operactionesString == null)
		{
			log.error("Error calculando las operaciones realizadas por el usuario. La lista de operaciones es null");
			throw new Error("Error calculando las operaciones realizadas por el usuario. La lista de operaciones es null");
		}

		InformeOperacionUsuarioVO informeOperacion = null;
		Vector titulosTotal = new Vector();

		for (int j = 0; j < operactionesString.length; j++)
		{
			String operacion = operactionesString[j];
			log("La operacion es " + operacion);
			titulosOdePorUsuarioDesdeHastaCriteria = new TitulosOdePorUsuarioDesdeHastaCriteria();
			titulosOdePorUsuarioDesdeHastaCriteria.setFechaDesde(parametrosInformeVO.getFechaDesde());
			titulosOdePorUsuarioDesdeHastaCriteria.setFechaHasta(parametrosInformeVO.getFechaHasta());
			titulosOdePorUsuarioDesdeHastaCriteria.setUsuario(parametrosInformeVO.getIdUsuario());
			titulosOdePorUsuarioDesdeHastaCriteria.setOperacion(operactionesString[j]);
			List operacionesList = this.getOperacionDao().obtenerOdesUsuarioDesdeHasta(titulosOdePorUsuarioDesdeHastaCriteria);
			OperacionVO[] operacionesArray = (OperacionVO[]) operacionesList.toArray(new OperacionVO[0]);
			if ((operacionesArray == null) || (operacionesArray.length == 0))
			{
				log("No hay registros para esa operacion");
				informeOperacion = new InformeOperacionUsuarioVO();
				informeOperacion.setOperacion(operacion);
				informeOperacion.setFechaTransiccion(null);
				informeOperacion.setTitulo("");
				titulosTotal.add(informeOperacion);
			} else
			{
				log("Hay registros para esa operacion");
				String[] idOdes = new String[operacionesArray.length];
				for (int k = 0; k < idOdes.length; k++)
				{
					idOdes[k] = operacionesArray[k].getIdOde();
				}
				DetallePublicadoODEVO[] titulosIdOdes = (this.getSrvAuditaPublicacionService().titulosODEsPorID(idOdes));
				log("De publicacion obtengo los arrays de titulos " + titulosIdOdes.length);
				for (int k = 0; k < operacionesArray.length; k++)
				{
					informeOperacion = new InformeOperacionUsuarioVO();
					informeOperacion.setOperacion(operacion);
					informeOperacion.setFechaTransiccion(operacionesArray[k].getFecha());
					informeOperacion.setTitulo(titulosIdOdes[k].getTitulo());
					titulosTotal.add(informeOperacion);
				}
			}

		}

		informeOperacionUsuarioVO = (InformeOperacionUsuarioVO[]) titulosTotal.toArray(new InformeOdeUsuarioVO[0]);
		return informeOperacionUsuarioVO;
	}

	/**
	 * Obtiene un array de InformeEstadoOdesVO con el estado de todos los odes de la plataforma en un rango de fechas determinado.
	 * El estado en el que se encuentra los odes será el estado final de los mismos
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeEstadoOdesVO[] Array con el número de odes que se encuentran en cada estado 
	 * @throws Exception
	 */

	protected es.pode.auditoria.negocio.servicios.InformeEstadoOdesVO[] handleInformeEstadoOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe estado odes");
		InformeEstadoOdesVO[] informeEstadoOdesVO = null;
		ParametroAuditPublicacionVO parametroAuditPublicacionVO = new ParametroAuditPublicacionVO();
		String idioma = parametrosInformeVO.getIdioma();
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando los estados de los odes. No hay parametros.");
			throw new Exception("Error calculando los estados de los odes. No hay parametros.");
		}
		parametrosInformeVO.setIdioma(idioma);
		
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
	
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditPublicacionVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditPublicacionVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditPublicacionVO.getFechaDesde() + " FechaFin : " + parametroAuditPublicacionVO.getFechaHasta());
		parametroAuditPublicacionVO.setIdioma(idioma);
		ODEsEstadoVO[] odesEstadoVO = this.getSrvAuditaPublicacionService().odesPorEstados(parametroAuditPublicacionVO); //Estado final
		if (!(odesEstadoVO == null))
		{
			log("El resultado de la llamada a SrvAuditaPublicacionService().odesPorEstados es " + odesEstadoVO.length);
			informeEstadoOdesVO = new InformeEstadoOdesVO[odesEstadoVO.length];
			log("Mapeamos el resultado de SrvAuditaPublicacionService(): odesPorEstados al resultado de  SrvAuditoriaServie.EstadoOdes: informeEstadoOdesVO");
			for (int i = 0; i < odesEstadoVO.length; i++)
			{
				informeEstadoOdesVO[i] = new InformeEstadoOdesVO();
				informeEstadoOdesVO[i].setCantidad((odesEstadoVO[i].getCantidad()).intValue());
				informeEstadoOdesVO[i].setEstadoFinal(odesEstadoVO[i].getEstado());
				log("[odesPorEstado] estado - Cantidad " + informeEstadoOdesVO[i].getEstadoFinal() + "-" + informeEstadoOdesVO[i].getCantidad());
				
			}

			if (informeEstadoOdesVO == null)
			{
				log.error("Error calculando los estados de los odes. informeEstadoOdesVO es null.");
				throw new Exception("Error calculando los estados de los odes. informeEstadoOdesVO es null.");
			}
		} else
		{
			log("No se devuelve ningún dato para el informe");
		}
		return informeEstadoOdesVO;
	}

	/**
	 * Obtiene un array de InformeEstadoOdesVO con la transición entre estados de todos los odes de la plataforma en un rango de fechas determinado.
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeEstadoOdesVO[] Value Object con el número de odes de cada transición entre estados 
	 * @throws Exception
	 */

	protected es.pode.auditoria.negocio.servicios.InformeEstadoOdesVO[] handleInformeEstadoOdesTransicciones(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Estado Odes Transicciones");
		InformeEstadoOdesVO[] informeEstadoOdesVO = null;
		ParametroAuditPublicacionVO parametroAuditPublicacionVO = new ParametroAuditPublicacionVO();
		String idioma = parametrosInformeVO.getIdioma();
		
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando los estados de los odes. No hay parametros.");
			throw new Exception("Error calculando los estados de los odes. No hay parametros.");
		}
		parametrosInformeVO.setIdioma(idioma);
		
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditPublicacionVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditPublicacionVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditPublicacionVO.getFechaDesde() + " FechaFin : " + parametroAuditPublicacionVO.getFechaHasta());
		parametroAuditPublicacionVO.setIdioma(idioma);
		ODEsEstadoVO[] odesTransicionVO = this.getSrvAuditaPublicacionService().actividadTransiciones(parametroAuditPublicacionVO);
		if (odesTransicionVO != null)
		{
			informeEstadoOdesVO = new InformeEstadoOdesVO[odesTransicionVO.length];
			for (int j = 0; j < odesTransicionVO.length; j++)
			{
				informeEstadoOdesVO[j] = new InformeEstadoOdesVO();
				informeEstadoOdesVO[j].setCantidad((odesTransicionVO[j].getCantidad()).intValue());
				informeEstadoOdesVO[j].setEstadoTransicion(odesTransicionVO[j].getEstado());
				log("[odesPorTransiccion] estado - Cantidad " + informeEstadoOdesVO[j].getEstadoFinal() + "-" + informeEstadoOdesVO[j].getCantidad());
			}

		} else
		{
			log.error("El resultado del informe es null");
		}
		return informeEstadoOdesVO;
	}

	/**
	 * Registra los terminos que han sido buscados en la plataforma Agrega
	 * @param  busqueda Término buscado
	 * @throws Exception
	 */
	protected void handleRegistrarBusqueda(es.pode.auditoria.negocio.servicios.BusquedaVO busqueda) throws java.lang.Exception
	{
		log("REGISTRAR BUSQUEDA");
		this.enviarMensajeBusqueda(busqueda);

	}

	/**
	 * Obtiene un array de InformeLicenciasOdesVO con la información de los odes que hay publicados en la plataforma para cada una de las licencias 
	 * @param  ParametrosInformeVO Value Object con los parámetros que necesita el servicio que obtiene los datos del informe: fechaDesde, fechaHasta y licencias
	 * @return InformeLicenciasOdesVO[] 
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeLicenciasOdesVO[] handleInformeLicenciasOdes(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{

		log.info("Informe Licencias Ode");
		InformeLicenciasOdesVO[] informeLicenciasOdesVO = null;
		String idioma = parametrosInformeVO.getIdioma();
		if (idioma == null)
		{
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		}
		log("idioma " + idioma);
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando los odes por licencia. No hay parametros.");
			throw new Exception("Error calculando los odes por licencia. No hay parametros.");
		}
		
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
			
		if (parametrosInformeVO.getIdioma() == null)
		{
			log.error("Error calculando los odes por licencia. El idioma esta vacio.");
			throw new Exception("Error calculando los odes por licencia. El idioma esta vacio.");
		}
		String[] licenciasIdiomaSelected = this.obtenerLicencias(idioma);
		if (licenciasIdiomaSelected == null)
		{
			log.error("Error al obtener los odes por licencias. El listado de licencias es null");
			throw new Exception("Error al obtener los odes por licencias. El listado de licencias es null");
		}
		String[] licenciasIngles = this.obtenerLicencias("en");
		if (licenciasIngles == null)
		{
			log.error("Error al obtener los odes por licencias. El listado de licencias en ingles es null");
			throw new Exception("Error al obtener los odes por licencias. El listado de licencias en ingles es null");
		}
		log("Se obtienen las siguientes licencias : " + licenciasIdiomaSelected.length);
		log("La primera licencia es  " + licenciasIngles[1]);
		ParametroAuditIndexadorVO parametroAuditIndexador = new ParametroAuditIndexadorVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditIndexador.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditIndexador.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditIndexador.getFechaDesde() + " FechaFin : " + parametroAuditIndexador.getFechaHasta());
		parametroAuditIndexador.setIdLicencias(licenciasIngles);
		CoberturaVO[] coberturaVO = this.getSrvAuditoriaIndexadorService().coberturaLicencias(parametroAuditIndexador);
		log("Se obtiene el array de CoberturaVO[] " + coberturaVO);
		
		if(coberturaVO == null)
		{
			log.error("CoberturaVO es null");
			throw new Exception("Error al obtener los odes por licencias. El resultado es null");
		}else
		{
			informeLicenciasOdesVO = new InformeLicenciasOdesVO[coberturaVO.length];
			for (int i = 0; i < coberturaVO.length; i++)
			{
				informeLicenciasOdesVO[i] = new InformeLicenciasOdesVO();
				informeLicenciasOdesVO[i].setLicencia(licenciasIdiomaSelected[i]);
				informeLicenciasOdesVO[i].setNumOdes((coberturaVO[i].getNumDoc()).intValue());


			}
			log("El array de informes obtenido es el siguiente " + informeLicenciasOdesVO.length);
		}
		
		if (informeLicenciasOdesVO == null)
		{
			log.error("Error al obtener los odes por licencias. informeLicenciasOdesVO es null");
			throw new Exception("Error al obtener los odes por licencias. El resultado es null");
		}
		return informeLicenciasOdesVO;
	}

	/**
	 * Devuelve los usuarios que se encuentran activos entre dos fechas concretas
	 * @param  parametrosInformeVO Value Object con las fechas, para las que se quiere obtener los usuarios activos, como atributos
	 * @return InformeUsuariosVO[] Array de Value Object con toda la información de cada uno de los usuarios activos
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeUsuariosVO[] handleInformeUsuarios(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe Usuarios");
		InformeUsuariosVO[] informeUsuariosVO = null;
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando usuarios. No hay parametros.");
			throw new Exception("Error calculando usuarios. No hay parametros.");
		}
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		ParametroAuditoriaUsuariosVO parametroAuditoriaUsuariosVO = new ParametroAuditoriaUsuariosVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditoriaUsuariosVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditoriaUsuariosVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los usuarios activos: FechaInicio " + parametroAuditoriaUsuariosVO.getFechaDesde() + " FechaFin : " + parametroAuditoriaUsuariosVO.getFechaHasta());
		UsuarioActivoVO[] usuariosActivos = this.getSrvAdminUsuariosService().usuariosActivos(parametroAuditoriaUsuariosVO);
		log("Se ha realizado la llamada a this.getSrvAdminUsuariosService().usuariosActivos");
		if (!(usuariosActivos == null))
		{
			log("El resultado de la llamada a SrvAdminUsuariosService().usuariosActivos es " + usuariosActivos.length);
			informeUsuariosVO = new InformeUsuariosVO[usuariosActivos.length];
			log("Mapeamos el resultado de SrvAdminUsuariosService().usuariosActivos: usuariosActivos al resultado de  SrvAuditoriaServie.InformeUsuarios: InformeUsuarioVO");
			log("parametrosInformeVO.getIdioma() "+parametrosInformeVO.getIdioma());
			ResourceBundle resource = this.getFicherRecursos(new Locale(parametrosInformeVO.getIdioma()));
			log("resource "+resource);
			for (int i = 0; i < usuariosActivos.length; i++)
			{
				//Calculamos el nombre completo y la cadena de los grupos separados por comas
				informeUsuariosVO[i] = new InformeUsuariosVO();
				String nombreCompleto = usuariosActivos[i].getNombre() + " " + usuariosActivos[i].getApellido1() + " " + usuariosActivos[i].getApellido2();
				informeUsuariosVO[i].setNombreCompleto(nombreCompleto);
				informeUsuariosVO[i].setEmail(usuariosActivos[i].getEmail());
				informeUsuariosVO[i].setNif(usuariosActivos[i].getNIF());
				informeUsuariosVO[i].setLogin(usuariosActivos[i].getLogin());
				informeUsuariosVO[i].setIdiomaBusqueda(this.getEtiqueta(usuariosActivos[i].getIdiomaBusqueda(),parametrosInformeVO.getIdioma()));
				informeUsuariosVO[i].setIdiomaAplicacion(this.getEtiqueta(usuariosActivos[i].getIdiomaAplicacion(),parametrosInformeVO.getIdioma()));
				informeUsuariosVO[i].setTipoEmpaquetador(resource.getString(usuariosActivos[i].getTipoEmpaquetador()));
				informeUsuariosVO[i].setGrupos(usuariosActivos[i].getGrupos());
				informeUsuariosVO[i].setPermisos(usuariosActivos[i].getPermisos());
			}
			if (informeUsuariosVO == null)
			{
				log.error("Error calculando usuarios. informeUsuariosVO es null.");
				throw new Exception("Error calculando usuarios. informeUsuariosVO es null.");
			}
			log("informeUsuarios "+informeUsuariosVO.length);
		}
		
		return informeUsuariosVO;
	}







        /**
         * TODO: document it
         * @param parametroInformeVO
         * @return
         * @throws java.lang.Exception
         */
        protected es.pode.auditoria.negocio.servicios.ReportSiteWideActivityVO[] handleReportSiteWideActivity(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception
        {
            log.info("handleReportSiteWideActivity");
            ArrayList<ReportSiteWideActivityVO> allResults = new ArrayList<ReportSiteWideActivityVO>(8);


            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            format.setLenient(false);

            log(" fechaDesde " + parametroInformeVO.getFechaDesde());
            log(" fechaHasta " + parametroInformeVO.getFechaHasta());
            if (parametroInformeVO == null)
            {
                    log.error("Error running the user operations. There aren't paremeters.");
                    throw new Exception("Error running the user operations. There aren't paremeters.");
            }

            //Date validation
            if(!(this.validarFechas(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta())).booleanValue())
            {
                    log.error("Dates are wrong.");
                    throw new Exception("Error running the user operations. Dates are wrong.");
            }

            //Query total live resouces
            log.info("report siteWideActivity: Total number of resources");
            OdePublicadoDao odePublicadoDao = this.getOdePublicadoDao();

            final Long numOdesPublicados = odePublicadoDao.obtenNumODEsPublicados();

            allResults.add(new ReportSiteWideActivityVO("Total number of resources",""+numOdesPublicados));


            //Query total live resouces between dates
            log.info("report siteWideActivity: Total number of resources between dates");

            final Long numOdesPublicadosBetweenDates = odePublicadoDao.obtenNumODEsPublicadosBetweenDates(
                    parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

            allResults.add(new ReportSiteWideActivityVO("Resources published",""+numOdesPublicadosBetweenDates));


            //Query total searches between dates
            log.info("report siteWideActivity: Total number of searches between dates");

            BusquedaDao buscarDao = this.getBusquedaDao();

            final Long numBusquedas = buscarDao.listarNumBusquedasDesdeHasta(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), "buscar_local");

            allResults.add(new ReportSiteWideActivityVO("Searches",""+numBusquedas));



            //Query total previews between dates
            log.info("report siteWideActivity: Total number of previews between dates");

            OperacionDao operacionDao = this.getOperacionDao();

            final Long numPreviews = operacionDao.obtenerNumOperacionesDesdeHasta(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), "previsualizado");

            allResults.add(new ReportSiteWideActivityVO("Previews",""+numPreviews));



            //Query total downloads between dates
            log.info("report siteWideActivity: Total number of downloads between dates");

            final Long numDownloads = operacionDao.obtenerNumOperacionesDesdeHastaLike( parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), "descargado_%");

            allResults.add(new ReportSiteWideActivityVO("Downloads",""+numDownloads));



            //Query total items sent between dates
            log.info("report siteWideActivity: Total number of items sent between dates");

            final Long numSents = operacionDao.obtenerNumOperacionesDesdeHasta(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(), "enviarCorreo");

            allResults.add(new ReportSiteWideActivityVO("Items sent",""+numSents));



            //Query total items rated between dates
            log.info("report siteWideActivity: Total number of items rated between dates");

            ValoracionDao valoracionDao = this.getValoracionDao();
            final Long numValoraciones = valoracionDao.totalValoracionesBetweenDates(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());
            allResults.add(new ReportSiteWideActivityVO("Ratings",""+numValoraciones));


            //Query total comments between dates
            log.info("report siteWideActivity: Total number of comments between dates");

            ComentarioDao comentarioDao = this.getComentarioDao();
            final Long numComments = comentarioDao.totalComentariosBetweenDates(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());
            allResults.add(new ReportSiteWideActivityVO("Comments",""+numComments));




            return allResults.toArray(new ReportSiteWideActivityVO[]{});

            
        }







        /**
         * TODO: document it
         * @param parametroInformeVO
         * @return
         * @throws java.lang.Exception
         */
        protected es.pode.auditoria.negocio.servicios.MostActiveUsersVO[] handleMostActiveUsers(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametroInformeVO) throws java.lang.Exception {



            Integer howmanyPerCategory = parametroInformeVO.getRango();
            if (howmanyPerCategory==null || howmanyPerCategory==0) howmanyPerCategory=15;

            ArrayList<MostActiveUsersVO> results = new ArrayList<MostActiveUsersVO>(howmanyPerCategory*7);
            

            //top resources published
            log.info("report mostActiveUsers: top resources published");
            OdePublicadoDao odePublicadoDao = this.getOdePublicadoDao();
            java.util.List listTopUsersPublishing = odePublicadoDao.getUsersAndResourcesPublishedBetweenDates(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

            java.util.Iterator it = listTopUsersPublishing.iterator();
            int numItems = 0;
            while (it.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it.next();
                results.add(new MostActiveUsersVO("Resources published",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }

            //top searches
            log.info("report mostActiveUsers: top searches");
            BusquedaDao buscarDao = this.getBusquedaDao();
            java.util.List listTopUsersSearching = buscarDao.listTopUsersSearching(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

            java.util.Iterator it2 = listTopUsersSearching.iterator();
            numItems = 0;
            while (it2.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it2.next();
                results.add(new MostActiveUsersVO("Searches",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }

            //top previews
            log.info("report mostActiveUsers: top previews");
            OperacionDao operacionDao = this.getOperacionDao();
            java.util.List listTopUsersPreview = operacionDao.listTopUsersOperacion(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(),"previsualizado");

            java.util.Iterator it3 = listTopUsersPreview.iterator();
            numItems = 0;
            while (it3.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it3.next();
                results.add(new MostActiveUsersVO("Previews",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }


            //top downloads
            log.info("report mostActiveUsers: top downloads");
            java.util.List listTopUsersDownloads = operacionDao.listTopUsersOperacion(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(),"descargado_%");

            java.util.Iterator it4 = listTopUsersDownloads.iterator();
            numItems = 0;
            while (it4.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it4.next();
                results.add(new MostActiveUsersVO("Downloads",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }


            //top items sent
            log.info("report mostActiveUsers: top items sent");
            java.util.List listTopUsersSent = operacionDao.listTopUsersOperacion(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta(),"enviarCorreo");

            java.util.Iterator it5 = listTopUsersSent.iterator();
            numItems = 0;
            while (it5.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it5.next();
                results.add(new MostActiveUsersVO("Items sent",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }


            //top ratings
            ValoracionDao valoracionDao = this.getValoracionDao();
            java.util.List listTopUsersValoracion = valoracionDao.listTopUsersValoracion(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

            java.util.Iterator it6 = listTopUsersValoracion.iterator();
            numItems = 0;
            while (it6.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it6.next();
                results.add(new MostActiveUsersVO("Ratings",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }




            //top comments
            ComentarioDao comentarioDao = this.getComentarioDao();
            java.util.List listTopUsersComentario = comentarioDao.listTopUsersComentario(parametroInformeVO.getFechaDesde(), parametroInformeVO.getFechaHasta());

            java.util.Iterator it7 = listTopUsersComentario.iterator();
            numItems = 0;
            while (it7.hasNext() && numItems<howmanyPerCategory) {
                Object[] values = (Object[])it7.next();
                results.add(new MostActiveUsersVO("Comments",""+values[0],""+values[1],""+values[2]));
                numItems++;
            }

            

            return results.toArray(new MostActiveUsersVO[]{});


        }






	/**
	 * Obtiene los procesos planificados y su estado entre dos fechas concretas
	 * @param  parametrosInformeVO Value Object con las fechas, para las que se quiere obtener los procesos planificados
	 * @return InformeProcesoPlanificadoVO[] Array de Value Object con toda la información de cada uno de los procesos planificados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeProcesoPlanificadoVO[] handleInformeProcesosPlanificados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe procesos planificados");
		InformeProcesoPlanificadoVO[] informeProcesoPlanificadoVO = null;
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando los procesos planificados. No hay parametros.");
			throw new Exception("Error calculando los procesos planificados. No hay parametros.");
		}
		
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		ParametrosVO param = new ParametrosVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		param.setFechaDesde(gcDesde);
		param.setFechaHasta(gcHasta);
		TareaEjecutadaVO[] tareaEjecutada = this.getSrvPlanificadorService().obtenerTrabajosEjecutadosDesdeHasta(param);
		if ((tareaEjecutada == null) || (tareaEjecutada.length == 0))
		{
			log("No se devuelve ninguna tarea para ese periodo");
		} else
		{
			log("tareaEjecutadaVO " + tareaEjecutada);
			informeProcesoPlanificadoVO = new InformeProcesoPlanificadoVO[tareaEjecutada.length];
			for (int i = 0; i < tareaEjecutada.length; i++)
			{
				informeProcesoPlanificadoVO[i] = new InformeProcesoPlanificadoVO();
				informeProcesoPlanificadoVO[i].setEstado(tareaEjecutada[i].getEstado());
				Calendar fechaHasta = tareaEjecutada[i].getFechaFin();
				Calendar fechaDesde = tareaEjecutada[i].getFechaInicio();
				if (fechaHasta == null)
				{
					informeProcesoPlanificadoVO[i].setFechaFin("");
				} else
				{
					String fechaHastaS = (new Date(fechaHasta.getTimeInMillis())).toString();
					informeProcesoPlanificadoVO[i].setFechaFin(fechaHastaS);
				}
				String fechaDesdeS = new Date(fechaDesde.getTimeInMillis()).toString();
				informeProcesoPlanificadoVO[i].setFechaInicio(fechaDesdeS);
				informeProcesoPlanificadoVO[i].setNombre(tareaEjecutada[i].getDescripcion());
			}
		}
		return informeProcesoPlanificadoVO;
	}

	/**
	 * Devuelve los odes más valorados en el rango de fechas concreto
	 * @param  parametrosInformeVO Value Object con las fechas, para las que se quiere obtener y el número de odes más valorados
	 * @return InformeMasValoradoVO[] Array de Value Objects con toda la información de cada uno de los odes más valorados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeMasValoradoVO[] handleInformeMasValorado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe Mas Valorado");
		InformeMasValoradoVO[] informeMasValoradoVO = null;
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando odes mas valorados. No hay parametros.");
			throw new Exception("Error calculando odes mas valorados. No hay parametros.");
		}
		if (parametrosInformeVO.getRango() == 0)
		{
			log.error("Error calculando odes mas valorados. El parametro rango es 0.");
			throw new Exception("Error calculando odes mas valorados. El parametro rango es 0.");
		}
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
			
		ParametroAuditValoracionVO parametroAuditValoracionVO = new ParametroAuditValoracionVO();
		log("parametroAuditValoracionVO");
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditValoracionVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditValoracionVO.setFechaHasta(gcHasta);
		parametroAuditValoracionVO.setRango(new Integer(parametrosInformeVO.getRango()));
		ValoracionODEVO[] valoracionODEVO = this.getSrvAuditoriaValoracionService().contenidosMasValorados(parametroAuditValoracionVO);
		if (valoracionODEVO == null)
		{
			log.error("El servicio de valoracion para las fechas " + parametrosInformeVO.getFechaDesde() + " " + parametrosInformeVO.getFechaHasta() + " devuelve null");
		} else
		{
			//log("valoracionODEVO.length "+valoracionODEVO.length);
			informeMasValoradoVO = new InformeMasValoradoVO[valoracionODEVO.length];
			log("Despues de obtener informeMasValoradoVO "+valoracionODEVO.length);
			String[] idOdes = new String[valoracionODEVO.length];
			for (int j = 0; j < valoracionODEVO.length; j++)
			{
				idOdes[j] = valoracionODEVO[j].getIdODE();
				log("idOdes de " + j + " vale " + idOdes[j]);

			}
			//Obtendre los titulos de los odes cuyo id se devuelve en este array
			DetallePublicadoODEVO[] detallePublicadoOdeVO = this.getSrvAuditaPublicacionService().titulosODEsPorID(idOdes);
			log("Obtenemos el array con los titulos de los odes detallePublicadoOdeVO.length " + detallePublicadoOdeVO.length);
			String[] tituloOdes = new String[detallePublicadoOdeVO.length];
			for (int k = 0; k < detallePublicadoOdeVO.length; k++)
			{
				tituloOdes[k] = detallePublicadoOdeVO[k].getTitulo();
			}
			for (int i = 0; i < valoracionODEVO.length; i++)
			{
				informeMasValoradoVO[i] = new InformeMasValoradoVO();
				informeMasValoradoVO[i].setTitulo(tituloOdes[i]);
				informeMasValoradoVO[i].setValoracion((valoracionODEVO[i].getValoracion()));
				informeMasValoradoVO[i].setIdOde(idOdes[i]);
				informeMasValoradoVO[i].setIdiomaODE(valoracionODEVO[i].getIdiomaODE());
				
			}
			if (informeMasValoradoVO == null)
			{
				log("Error calculando odes mas valorados. informeMasValoradoVO.");
				throw new Exception("Error calculando odes mas valorados. informeMasValoradoVO.");
			}
		}
		return informeMasValoradoVO;
	}

	/**
	 * Devuelve los odes más mostrados en el rango de fechas que se le pasa por parámetro
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeMasValoradoVO[] Array de Value Objects con toda la información de cada uno de los odes más mostrados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeMasVO[] handleInformeMasMostrado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("INFORME mas Mostrados");
		String operacion = this.getPropertyValue("mostrado");
		InformeMasVO[] resultado = this.obtenerMasVO(operacion,parametrosInformeVO);
		if(resultado == null)
		{
			log("No existe odes mas mostrados en el periodo de tiempo ");
		}else
		{
			log("Devolvemos los siguientes odes "+resultado.length);
		}
		return resultado;
		
		
	}

	/**
	 * Devuelve los odes más previsualizados en el rango de fechas
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeMasValoradoVO[] Array de Value Objects con toda la información de cada uno de los odes más previsualizados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeMasVO[] handleInformeMasPrevisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe mas previsualizado");
		String operacion = this.getPropertyValue("previsualizado");
		InformeMasVO[] resultado = this.obtenerMasVO(operacion,parametrosInformeVO);
		if(resultado == null)
		{
			log("No existe odes mas mostrados en el periodo de tiempo ");
		}else
		{
			log("Devolvemos los siguientes odes "+resultado.length);
		}
		return resultado;
		
	
	}

	protected es.pode.auditoria.negocio.servicios.InformeMasVO[] handleInformeMasVisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		//@todo implement protected es.pode.auditoria.negocio.servicios.InformeMasVisualizadosVO[] handleInformeMasVisualizados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO)
		return null;
	}

	/**
	 * Devuelve los odes más descargados en el rango de fechas que se le pasa por parámetro
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeMasVO[] Array de Value Objects con toda la información de cada uno de los odes más descargados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeMasVO[] handleInformeMasDescargados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
	
		log.info("Informe mas previsualizado");
		String operacion = this.getPropertyValue("descargado") + "%";
		InformeMasVO[] resultado = this.obtenerMasVO(operacion,parametrosInformeVO);
		if(resultado == null)
		{
			log("No existe odes mas mostrados en el periodo de tiempo ");
		}else
		{
			log("Devolvemos los siguientes odes "+resultado.length);
		}
		return resultado;
			
	
	}
	protected es.pode.auditoria.negocio.servicios.InformeMasVO[] handleInformeMasEnviado(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
	
		log.info("Informe mas enviados");
		String operacion = this.getPropertyValue("enviado");
		InformeMasVO[] resultado = this.obtenerMasVO(operacion,parametrosInformeVO);
		if(resultado == null)
		{
			log("No existe odes mas mostrados en el periodo de tiempo ");
		}else
		{
			log("Devolvemos los siguientes odes "+resultado.length);
		}
		return resultado;
		
	}

	/**
	 * Obtiene un array de nformeMasPesadosVO con los odes que tienen mayor tamaño en la plataforma en un rango de fechas concreto
	 * @param  parametrosInformeVO Clase con los parámetros que necesita el método
	 * @return InformeMasPesadosVO[] VO con la información de los odes más pesados
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.InformeMasPesadosVO[] handleInformeMasPesados(es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws java.lang.Exception
	{
		log.info("Informe mas pesados");
		InformeMasPesadosVO[] informeMasPesadosVO = null;
		if (parametrosInformeVO == null)
		{
			log.error("Error calculando odes mas pesados. No hay parametros.");
			throw new Exception("Error calculando odes mas pesados. No hay parametros.");
		}
		if (parametrosInformeVO.getRango() == 0)
		{
			log.error("Error calculando odes mas pesados. El parametro rango es 0.");
			throw new Exception("Error calculando odes mas pesados. El parametro rango es 0.");
		}
		//Validamos las fechas
		if(!(this.validarFechas(parametrosInformeVO.getFechaDesde(), parametrosInformeVO.getFechaHasta())).booleanValue())
		{
			log.error("Las fechas no son correctas.");
			throw new Exception("Error calculando operaciones realizadas. Las fechas no son correctas.");
		}
		
		
		log("Informe más pesados");
		
		ParametroAuditPublicacionVO parametroAuditPublicacionVO = new ParametroAuditPublicacionVO();
		GregorianCalendar gcDesde = new GregorianCalendar();
		gcDesde.setTime((parametrosInformeVO.getFechaDesde()).getTime());
		parametroAuditPublicacionVO.setFechaDesde(gcDesde);
		GregorianCalendar gcHasta = new GregorianCalendar();
		gcHasta.setTime((parametrosInformeVO.getFechaHasta()).getTime());
		parametroAuditPublicacionVO.setFechaHasta(gcHasta);
		log("Parametros de busqueda de los odes por estado: FechaInicio " + parametroAuditPublicacionVO.getFechaDesde() + " FechaFin : " + parametroAuditPublicacionVO.getFechaHasta());
		parametroAuditPublicacionVO.setRango(new Integer(parametrosInformeVO.getRango()));
		PesoODEVO[] pesoOdeVO = this.getSrvAuditaPublicacionService().dimensionesODEsPublicados(parametroAuditPublicacionVO);
		log("Se ha realizado la llamada a this.getSrvAuditaPublicacionService().dimensionesODEsPublicados");
		if ((pesoOdeVO == null))
		{
			log.error("No se devuelve ningun resultado");

		} else
		{
			log("El resultado de la llamada a SrvAuditaPublicacionService().odesPorEstados es " + pesoOdeVO.length);
			informeMasPesadosVO = new InformeMasPesadosVO[pesoOdeVO.length];
			log("Mapeamos el resultado de SrvAuditaPublicacionService(): dimensionesODEsPublicados al resultado de  SrvAuditoriaServie.dimensionesODEsPublicados: InformeMasPesadosVO");
			for (int i = 0; i < pesoOdeVO.length; i++)
			{
				informeMasPesadosVO[i] = new InformeMasPesadosVO();
				this.getBeanMapper().map(pesoOdeVO[i], informeMasPesadosVO[i]);
				
			}

		}
		return informeMasPesadosVO;
	}
	
	
	/**
	 * Obtiene un array de InformeRepositorioVO con todos los odes del repositorio
	 * @return InformeRepositorioVO[] Array de Value Objects con la información del repositorio. Se utilizará para el informe del catálogo
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.RepositorioVO[] handleRepositorio() throws java.lang.Exception
	{
		RepositorioVO[] resultadoTemp = null;
		Vector odesDuplicados = new Vector();
		RepositorioVO repositorioVO = null;
		String[] niveles = null;
		RepositorioVO[] resultado = null;
		//HashMap en el que se almacenarán los identificadores del árbol y el nombre del árbol
		HashMap arbolCurricular = new HashMap();
		//Vector en el que se almacenan los identificadores de los nodos de segundo nivel
		//Este vector será el utilizado para hacer la llamada a fuentes taxonómicas para obtener el nombre del nodo del árbol
		Vector identificadorNodos = new Vector();
		String idioma = ""; //Idioma en el que se presentará el catálogo, será el idioma por defecto de la plataforma
		
		//Array de identificadores del área curricular, se añadirá a la ficha
		String[] idenAreaCurricular = null;
		ArrayList listaIdenAreaCurricular = new ArrayList();
		
		String[] idenNodos = null;
		
		log.info("repositorio");
		
		ResultadoRepositorioVO[] resultadoRepositorio = this.getSrvBuscadorService().obtenerCatalogoRepositorioParam(this.nivelAgregacionCatalogo);
		
		
		log.info("El contenido del repositorio es "+resultadoRepositorio);
		if(!(resultadoRepositorio == null))
		{
			resultadoTemp = new RepositorioVO[resultadoRepositorio.length];
			log.info("El resultado del indice "+resultadoRepositorio.length);
			log("Mapeo cada uno de los VO del buscador");
			//En el caso de que un ODE este repetido en varios nodos del árbol se repetirán los objetos en el array resultado
			/////Sacamos los valores obtenidos del indexador
				
		for (int i = 0; i < resultadoRepositorio.length; i++)
		{
			resultadoTemp[i] = new RepositorioVO();
			resultadoTemp[i].setDescripcion(resultadoRepositorio[i].getDescripcion());
			resultadoTemp[i].setEdad(resultadoRepositorio[i].getEdad());
			resultadoTemp[i].setTitulo(resultadoRepositorio[i].getTitulo());
			resultadoTemp[i].setIdiomaTexto((resultadoRepositorio[i].getIdiomaTexto()));
			String urlImagen = resultadoRepositorio[i].getUrlImagen();
			log("Imagen de la posicion "+i+" "+urlImagen);
			if((!(urlImagen == null))&&(!(urlImagen == ""))&&(!(urlImagen == " ")))
			{
				log("La url de la imagen pequeña esta indexada");
				int indiceExtension = urlImagen.indexOf(".png");
				if(!(indiceExtension == -1))
				{
					resultadoTemp[i].setUrlImagen(urlImagen.substring(0, indiceExtension)+"_captured.jpg");
				}else
				{
					log("La imagen pequeña no es extensión .png");
					resultadoTemp[i].setUrlImagen(resultadoRepositorio[i].getUrlImagen());
				}
			}else
			{
				log("No esta indexada la imagen pequeña");
				resultadoTemp[i].setUrlImagen(resultadoRepositorio[i].getUrlImagen());
			}
			resultadoTemp[i].setIdioma(resultadoRepositorio[i].getIdioma());
			resultadoTemp[i].setIdentificador(resultadoRepositorio[i].getIdentificador());
			String[] objetivos = resultadoRepositorio[i].getObjetivos();
			
			//Recogemos los objetivos
			String objetivo = "";
			for(int j=0;j<objetivos.length;j++)
			{
				objetivo = objetivo + objetivos[j] + " ";
			}
			resultadoTemp[i].setObjetivos(objetivo);
			log("añadidos los objetivos");
			
			String[] areasCurriculares = resultadoRepositorio[i].getAreaCurricularPath();
			log("Añadidos las areasCurriculares.length "+areasCurriculares.length);
		  
			log("Asignamos las areas curriculares a la ficha del ode");
			resultadoTemp[i].setAreaCurriculares(areasCurriculares);
			
			if((!(areasCurriculares == null))&&(areasCurriculares.length > 0))
			{
				log("areasCurriculares[0]"+areasCurriculares[0]);
				if((areasCurriculares[0].equalsIgnoreCase(""))||(areasCurriculares[0].equalsIgnoreCase(" ")))
				{
					log("El ode no tiene area curricular le asigno una ");
					resultadoTemp[i].setNivel1Cobertura("999999");
				}else
				{
					niveles = areasCurriculares[0].split("/");
					log("niveles.length "+niveles.length);
					resultadoTemp[i].setNivel1Cobertura(niveles[0]);
					log("El nodo del primer nivel "+niveles[0]);
									
					if(niveles.length > 2)
					{
						resultadoTemp[i].setNivel2Cobertura(niveles[1]);
						log("El nodo del segundo nivel "+niveles[1]);
						resultadoTemp[i].setNivel3Cobertura(niveles[2]);
						log("El nodo del tercer nivel "+niveles[2]);
						//Añado al vector los identificadores de los nodos de segundo nivel
						identificadorNodos.add(niveles[1]);
						identificadorNodos.add(niveles[2]);
					}else
					{
						if(niveles.length == 2)
						{
							resultadoTemp[i].setNivel2Cobertura(niveles[1]);
							log("El nodo del segundo nivel "+niveles[1]);
							identificadorNodos.add(niveles[1]);
						}else
						{
							identificadorNodos.add(niveles[0]);
						}
					}
				}
			}
			
			if(areasCurriculares.length > 1)
			{
				log.info("Tenemos mas de una area curricular");
				//El contenido se encuentra en varias ramas
				//Creo un nuevo objeto con cada una de las ramas en las que se encuentra
				for(int j=0;j<areasCurriculares.length -1;j++)
				{
					try
					{
					repositorioVO = new RepositorioVO();
					repositorioVO.setDescripcion(resultadoTemp[i].getDescripcion());
					repositorioVO.setEdad(resultadoTemp[i].getEdad());
					repositorioVO.setTitulo(resultadoTemp[i].getTitulo());
					repositorioVO.setIdiomaTexto(resultadoTemp[i].getIdiomaTexto());
					urlImagen = resultadoTemp[i].getUrlImagen();
					log("Imagen de la posicion "+j+" "+urlImagen);
					if((!(urlImagen == null))&&(!(urlImagen == ""))&&(!(urlImagen == " ")))
					{
						log("La url de la imagen pequeña esta indexada");
						int indiceExtension = urlImagen.indexOf(".png");
						if(!(indiceExtension == -1))
						{
							repositorioVO.setUrlImagen(urlImagen.substring(0, indiceExtension)+"_captured.jpg");
						}else
						{
							log("La imagen pequeña no es extensión .png");
							repositorioVO.setUrlImagen(resultadoTemp[i].getUrlImagen());
						}
					}else
					{
						log("No esta indexada la imagen pequeña");
						repositorioVO.setUrlImagen(resultadoTemp[i].getUrlImagen());
					}
					//repositorioVO.setUrlImagen(resultadoTemp[i].getUrlImagen());
					repositorioVO.setIdioma(resultadoTemp[i].getIdioma());
					repositorioVO.setIdentificador(resultadoTemp[i].getIdentificador());
					repositorioVO.setObjetivos(resultadoTemp[i].getObjetivos());
					niveles = areasCurriculares[j+1].split("/");
					repositorioVO.setNivel1Cobertura(niveles[0]);
					log("El nodo del primer nivel "+niveles[0]);
					repositorioVO.setAreaCurriculares(resultadoTemp[i].getAreaCurriculares());
					if(niveles.length > 2)
					{
						repositorioVO.setNivel2Cobertura(niveles[1]);
						identificadorNodos.add(niveles[1]);
						repositorioVO.setNivel3Cobertura(niveles[2]);
						identificadorNodos.add(niveles[2]);
					}else
					{
						if(niveles.length == 2)
						{
							repositorioVO.setNivel2Cobertura(niveles[1]);
							identificadorNodos.add(niveles[1]);
						}else
						{
							identificadorNodos.add(niveles[0]);
						}
					}
					//Añado al vector los identificadores de los nodos de segundo nivel y los del primer nivel si no tiene de segundo nivel
					
					log("El nodo del segundo nivel "+niveles[1]);
					//Se añade el VO con el nuevo nodo del árbol curricular
					odesDuplicados.add(repositorioVO);
					}catch(Exception e)
					{
						log.error("[catalogo]exception al obtener las siguientes areas curriculares ");
					}
				}
			}
			
			//Recorremos el array de areas curriculares para obtener el array de identificadores para la ficha
			for(int j=0;j < areasCurriculares.length ; j++)
			{
				String[] areasTemp = areasCurriculares[j].split("/");
				for(int k=0;k<areasTemp.length;k++)
				{
					listaIdenAreaCurricular.add(areasTemp[k]);
					log("Identificador de areaCurricular "+areasTemp[k]);
				}
				
				//La lista listaIdenAreaCurricular se usará para llamar a fuentesTaxonómicas y obtener todos los identificadores de los nodos para la ficha
			}
			
		}
			
		
			
		
		//Añadimos al array resultado los elementos del vector con los odes duplicados
		
		if(odesDuplicados.size() > 0)
		{
			log.info("Existen odes que se encuentran en varias ramas");
			log("Se añaden los vo duplicados al array de VO de resultado");
			RepositorioVO[] repositorioDuplicado = (RepositorioVO[])odesDuplicados.toArray(new RepositorioVO[0]);
			resultado = new RepositorioVO[resultadoTemp.length+repositorioDuplicado.length];
			System.arraycopy(resultadoTemp, 0, resultado, 0, resultadoTemp.length);
			System.arraycopy(repositorioDuplicado, 0, resultado, resultadoTemp.length, repositorioDuplicado.length);
			log("Se copia el array con todos los odes al array resultado");
			
			
		}else
		{
			log.info("No existen odes que se encuentran en varias ramas");
			resultado = new RepositorioVO[resultadoTemp.length];
			resultado = resultadoTemp;
		}
		//Obtengo el nombre de cada una de las ramas del nodo llamando a fuentes taxonómicas
		//Obtengo el array con los identificadores de los nodos y llamo a fuentes taxonómicas
		log.info("Obtengo los identificadores de de los nodos");
		log.debug("listaIdenAreaCurricular.size "+listaIdenAreaCurricular.size());
		idenNodos = new String[listaIdenAreaCurricular.size()];
		log.debug("idenNodos "+idenNodos.length);
		idenNodos = (String[])listaIdenAreaCurricular.toArray(new String[0]);
		log.debug("idNodos.length "+idenNodos.length);
		idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		log.info("Obtener Catalogo el idioma por defecto de la plataforma es "+idioma);
		
		TaxonPathVO[] taxonPathVO = this.getSrvTaxonomiaService().obtenerVariosTaxonPaths(idenNodos, this.getPropertyValue("nombreTaxonomia"), idioma);
		
		log("El tamanio del array del taxonPath es "+taxonPathVO.length);
		//Recorremos el array resultado para poblar el hashmap con los identificadores y sus nombres
		for(int j=0;j<taxonPathVO.length;j++)
		{
			TaxonVO[] taxonVO = taxonPathVO[j].getDatos();
			for(int k=0;k<taxonVO.length;k++)
			{
				String identificador = taxonVO[k].getId();
				String nombreNodo = taxonVO[k].getValorTax();
				arbolCurricular.put(identificador, nombreNodo);
			}
		}
		log("Se han obtenido los hashmap con los nodos del arbol traducidos "+arbolCurricular.size());
		
		/*
		 * Únicamente vamos a llamar a fuentes taxonómicas con todos los identificadores de los nodos
		 * 
		 */
				
		
		//Recorremos el array de RepositorioVO para asinar los nombres de los nodos del árbol
		log("resultado.length "+resultado.length);
		for(int i=0;i<resultado.length;i++)
		{
			log("resultado[i].getNivel1Cobertura() "+resultado[i].getNivel1Cobertura());
			log("resultado[i].getNivel2Cobertura() "+resultado[i].getNivel2Cobertura());
			log("resultado[i].getNivel3Cobertura() "+resultado[i].getNivel3Cobertura());
			if(!(resultado[i].getNivel1Cobertura().equals("999999")))
			{
				if(!(arbolCurricular.get(resultado[i].getNivel1Cobertura()) == null))
				{
					resultado[i].setNivel1Cobertura(resultado[i].getNivel1Cobertura()+"   "+(String)arbolCurricular.get(resultado[i].getNivel1Cobertura()));
				}else
				{
					resultado[i].setNivel1Cobertura(resultado[i].getNivel1Cobertura());
				}
			}else
			{
				
				resultado[i].setNivel1Cobertura("General");
			}
			if(!(resultado[i].getNivel2Cobertura() == null))
			{
				if(!(arbolCurricular.get(resultado[i].getNivel2Cobertura()) == null))
				{
					resultado[i].setNivel2Cobertura(resultado[i].getNivel2Cobertura()+"   "+(String)arbolCurricular.get(resultado[i].getNivel2Cobertura()));
				}else
				{
					resultado[i].setNivel2Cobertura(resultado[i].getNivel2Cobertura());
				}
				
			}else
			{
				resultado[i].setNivel2Cobertura("");
			}
			if(!(resultado[i].getNivel3Cobertura() == null))
			{
				if(!(arbolCurricular.get(resultado[i].getNivel3Cobertura()) == null))
				{
					resultado[i].setNivel3Cobertura(resultado[i].getNivel3Cobertura()+"   "+(String)arbolCurricular.get(resultado[i].getNivel3Cobertura()));
				}else
				{
					resultado[i].setNivel3Cobertura(resultado[i].getNivel3Cobertura());
				}
				
			}else
			{
				resultado[i].setNivel3Cobertura("");
			}
			
			log.debug("resultado[i].getAreaCurriculares().lenth "+resultado[i].getAreaCurriculares().length);
			//Obtenemos las áreas curriculares traducidas que se añadirá en la ficha
			idenAreaCurricular = new String[resultado[i].getAreaCurriculares().length];
			String nombreAreaCurricular = "";
			for (int k=0; k < resultado[i].getAreaCurriculares().length; k++)
			{
				log.debug("resultado[i].getAreaCurriculares())[k] "+k+" "+(resultado[i].getAreaCurriculares())[k]);
				String[] areasC = ((resultado[i].getAreaCurriculares())[k]).split("/") ;
				
				String areaTemporal = "";
				String areaT = "";
				for(int l = 0;l < areasC.length ; l++)
				{
					areaTemporal = "";
					
					if(l == areasC.length-1)
					{
						
						if(!(arbolCurricular.get(areasC[l]) == null))
						{
		
							areaTemporal = (String)arbolCurricular.get(areasC[l]);
							
						}
						
					}else
					{
						if(!(arbolCurricular.get(areasC[l]) == null))
						{
							areaTemporal = (String)arbolCurricular.get(areasC[l]) + "/";
							
						}
						
					}
					areaT = areaT + areaTemporal;
				}
				
				idenAreaCurricular[k] = areaT;
				nombreAreaCurricular = nombreAreaCurricular + "- " +idenAreaCurricular[k]+"<br>";
			}
			resultado[i].setAreaCurriculares(idenAreaCurricular);
			
			if(nombreAreaCurricular.equalsIgnoreCase("- <br>"))
			{
				resultado[i].setNombreAreaCurricular("");
			}else
			{
				resultado[i].setNombreAreaCurricular(nombreAreaCurricular);
			}
			
			
		}
		log.info("resultado "+resultado.length);
		}else
		{
			log.info("No existe ningun ode de nivel de agregacion mayor que 3");
		}
		return resultado;
	}
	/**
	 * Almacena en base de datos las búsquedas realizadas por los usuarios
	 * @param  busqueda Value Object con la búsqueda realizada
	 * @throws Exception
	 */
	protected void handleAlmacenarBusquedaBD(BusquedaVO busqueda) throws java.lang.Exception
	{

		log("SRVAUDITORIASERVICIO AlmacenarBusquedaBD busqueda " + busqueda);
		try
		{
			this.getBusquedaDao().create(this.getBusquedaDao().fromBusquedaVO(busqueda));

		} catch (Exception e)
		{
			log.error("Se produce un error al registrar el termino de busqueda " + e);

		}
	}

	/**
	 * Almacena en base de datos las operaciones realizadas por los usuarios
	 * @param  operacion Value Object con la operación realizada
	 * @throws Exception
	 */

	protected void handleAlmacenarOperacionBD(OperacionVO operacion) throws java.lang.Exception
	{

		log("AlmacenarOperacionBD");
		try
		{
			this.getOperacionDao().create(this.getOperacionDao().fromOperacionVO(operacion));

		} catch (Exception e)
		{
			log.error("Se produce un error al registrar el termino de busqueda " + e);

		}
	}

	/**
	 * Obtiene los informes que se encuentran registrados en la plataforma
	 * @return String[] Array con los identificadores de los informes
	 * @throws Exception
	 */
	protected String[] handleObtenerInformes() throws java.lang.Exception
	{
		
		
		String[] informes = null;
		log("Obtener informes");
		String descInformes = this.getPropertyValue("informes");
		informes = descInformes.split(",");
		return informes;
		
				

	}

	/**
	 * Crea un informe con los datos que se pasan como parámetro
	 * @param  parametrosInformeVO Value Object con los parámetros que necesita el método para crear el informe
	 * @return DataHandler con la información del informe
	 * @throws Exception
	 */

	protected javax.activation.DataHandler handleCrearInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametrosCrearInformeInforme) throws java.lang.Exception
	{
		
		
		IRunAndRenderTask task = null;
		String fechaDesde = "";
		String fechaHasta = "";
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String rangoFechas = "";
        
		//Validamos el VO con los parámetros del informe
		if(!(this.validarParametrosInforme(parametrosCrearInformeInforme).booleanValue()))
		{
			log.error("El vo con los parametros no es correcto");
			throw new Exception("parametrosCrearInformeInforme es incorrecto o no se ha seleccionado ningun informe");
		}
		
		
		String informe = parametrosCrearInformeInforme.getNombreInforme();
		fechaDesde = this.obtenerFecha(parametrosCrearInformeInforme, "desde");
		fechaHasta = this.obtenerFecha(parametrosCrearInformeInforme, "hasta");
		
		rangoFechas = this.obtenerRangoFechas(parametrosCrearInformeInforme);
		log("rangoFechas ->" + rangoFechas);
		log("fechaDesde ->" + fechaDesde);
		log("fechaHasta ->" + fechaHasta);
		log("informe -> " + informe);
		
		//Calculamos las fechas:

		try
		{
			
			String nombreFichero = this.getAgregaPropertyValue("informesDir") + informe + ".rptdesign";
			log("nombreFichero -> " + nombreFichero);
			//Saco según el tipo de informe los parámetros que le voy a asignar
			task = this.levantarPlataforma(nombreFichero);
			
			//Sacamos la fecha con el TimeZone
			String offSetDesde = this.getOffSetDate(parametrosCrearInformeInforme.getAnioDesde(), parametrosCrearInformeInforme.getMesDesde(), parametrosCrearInformeInforme.getDiaDesde());
			String offSetHasta = this.getOffSetDate(parametrosCrearInformeInforme.getAnioHasta(), parametrosCrearInformeInforme.getMesHasta(), parametrosCrearInformeInforme.getDiaHasta());
			task.setParameterValue("RP_fechaHasta", fechaHasta + "T23:59:59+0" + offSetHasta + ":00");
			task.setParameterValue("RP_fechaDesde", fechaDesde + "T00:00:00+0" + offSetDesde + ":00");
			task.setParameterValue("RP_rangoFechas", rangoFechas);
			String idioma = LdapUserDetailsUtils.getIdioma();
			log("RANGO -> " + parametrosCrearInformeInforme.getRango());
			if (idioma == null)
			{
				idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
			log("idioma -> " + idioma);
			task.setParameterValue("RP_Idioma", idioma);
			if (informe.equalsIgnoreCase("estadoOdes") || informe.equalsIgnoreCase("operacionesRealizadas") || informe.equalsIgnoreCase("nivelAgregacion") || informe.equalsIgnoreCase("coberturaCurricular") || informe.equalsIgnoreCase("odesLicencias")
					|| informe.equalsIgnoreCase("usuarios") || informe.equalsIgnoreCase("procesosPlanificados"))
			{
				log("El informe solicitado solo necesita las fechas");
				
			} else
			{
				if (informe.equalsIgnoreCase("mostActiveUsers") || informe.equalsIgnoreCase("terminosBusqueda") || informe.equalsIgnoreCase("masValorado") || informe.equalsIgnoreCase("masMostrado") || informe.equalsIgnoreCase("masPrevisualizado") || informe.equalsIgnoreCase("masVisualizado")
						|| informe.equalsIgnoreCase("masDescargado") || informe.equalsIgnoreCase("tamanio"))
				{
					log("El informe solicitado necesita fechas y rango");
					task.setParameterValue("RP_Rango", parametrosCrearInformeInforme.getRango());

				} else
				{
					if (informe.equalsIgnoreCase("odesUsuario"))
					{
						log("El informe seleccionado necesita fechas y usuario");
						task.setParameterValue("RP_Usuario", parametrosCrearInformeInforme.getUsuario());

					}

				}
				//Para los informas 'Mas' vamos a añadir el parámetro con el nodo y la url de la ficha para crear los enlaces
				if (informe.equalsIgnoreCase("masMostrado") || informe.equalsIgnoreCase("masPrevisualizado") || informe.equalsIgnoreCase("masVisualizado")
						|| informe.equalsIgnoreCase("masDescargado") || informe.equalsIgnoreCase("tamanio") || informe.equalsIgnoreCase("masValorado"))
				{
					log("El informe contiene enlaces a la ficha");
					
					String urlNodo =  this.getAgregaPropertyValue("host");
					String urlFicha = this.getPropertyValue("urlFicha");
					task.setParameterValue("RP_UrlFicha", "http://"+urlNodo+LdapUserDetailsUtils.getSubdominio() + urlFicha);

				}
			}

			String formato = parametrosCrearInformeInforme.getFormato();
			log("formato -> " + formato);
			if (formato == null)
			{
				log.error("El formato introducido es null");
				throw new Exception("El formato del informe es null");
			}
			if (formato.equalsIgnoreCase("html"))
			{
				//Añado el locale correspondiente al idioma de navegacion
				Locale locale = new Locale(idioma);
				task.setLocale(locale);
				HTMLRenderOption options = new HTMLRenderOption();
				options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
				options.setHtmlPagination(true);
				options.setImageHandler(new HTMLServerImageHandler());
				options.setImageDirectory(this.getAgregaPropertyValue("imgBirtDir"));
				log("options.getImageDirectory() " + options.getImageDirectory());
				options.setBaseImageURL(this.getAgregaPropertyValue("staticImgDir"));
				log("options.getBaseImageURL() " + options.getBaseImageURL());
				options.setOutputStream(response);
				task.setRenderOption(options);
				
			} else
			{
				if (formato.equalsIgnoreCase("pdf"))
				{
					log("el formato del informe es pdf");
					Locale locale = new Locale(idioma);
					task.setLocale(locale);
					PDFRenderOption options = new PDFRenderOption();
					options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
					options.setOutputStream(response);
					task.setRenderOption(options);
					

				} else
				{
					if (formato.equalsIgnoreCase("excel"))
					{
						log("el formato del informe es excel");
						Locale locale = new Locale(idioma);
						task.setLocale(locale);
						IRenderOption options = new RenderOption();
						options.setOutputFormat("xls");
						options.setOutputStream(response);
						task.setRenderOption(options);
						
					} else
					{
						log.error("El formato introducido no es correcto");
						throw new Exception("El formato del informe no es correcto");
					}
				}
			}

			task.run();
			DataHandler dataHandler = new DataHandler(new SourceDataSource(null, "text/html", new StreamSource(new ByteArrayInputStream(response.toByteArray()))));
			task.close();
			//No se elimina la plataforma
			/////  engine.destroy();
			/////  log("engine.destroy");
			///// Platform.shutdown();
			////  log("Platform.shutdown()");
			return dataHandler;

		} catch (Exception e)
		{
			log("Error al crear el informe " + e);
			task.close();
			////  engine.destroy();
			////  Platform.shutdown();
			throw new Exception(e);
		}
		

	}

	/**
	 * Genera y guarda en un directorio un informe con los datos que se pasan como parámetro
	 * @param  parametrosInformeVO Value Object con los parámetros que necesita el método para crear y guardar el informe
	 * @throws Exception
	 */
	public void handleCrearGuardarInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO) throws Exception
	{

		//El idioma en el que se mostrarán las etiquetas del informe será el idioma del que ha planificad
		//la tarea de ejecución del informe
		IRunAndRenderTask task = null;
		//String MIMETYPE_OCTET_STREAM = "application/octet-stream";
		String fechaDesde = "";
		String fechaHasta = "";
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String informesDir = "";
		String rangoFechas = "";
		
		
//		Validamos el VO con los parámetros del informe
		if(!(this.validarParametrosInforme(parametroCrearInformeVO).booleanValue()))
		{
			log.error("El vo con los parametros no es correcto");
			throw new Exception("parametrosCrearInformeInforme es incorrecto o no se ha seleccionado ningun informe");
		}
	
		String informe = parametroCrearInformeVO.getNombreInforme();
		
		//Calculamos las fechas:
		try
		{
			informesDir = this.getAgregaPropertyValue("destinoInformesDir");
			log("informesDir " + informesDir);
			fechaDesde = this.obtenerFecha(parametroCrearInformeVO, "desde");
			fechaHasta = this.obtenerFecha(parametroCrearInformeVO, "hasta");
		
			rangoFechas = this.obtenerRangoFechas(parametroCrearInformeVO);
			log("rangoFechas ->" + rangoFechas);
			log("fechaDesde ->" + fechaDesde);
			log("fechaHasta ->" + fechaHasta);
			log("informe -> " + informe);
			log("informesDir -> " + informesDir);
						
			String nombreFichero = this.getAgregaPropertyValue("informesDir") + informe + ".rptdesign";
			task = this.levantarPlataforma(nombreFichero);
			String offSetDesde = this.getOffSetDate(parametroCrearInformeVO.getAnioDesde(), parametroCrearInformeVO.getMesDesde(), parametroCrearInformeVO.getDiaDesde());
			String offSetHasta = this.getOffSetDate(parametroCrearInformeVO.getAnioHasta(), parametroCrearInformeVO.getMesHasta(), parametroCrearInformeVO.getDiaHasta());
			task.setParameterValue("RP_fechaHasta", fechaHasta + "T23:59:59+0" + offSetHasta + ":00");
			task.setParameterValue("RP_fechaDesde", fechaDesde + "T00:00:00+0" + offSetDesde + ":00");
			task.setParameterValue("RP_rangoFechas", rangoFechas);
			String idioma = LdapUserDetailsUtils.getIdioma();
			log("idioma -> " + idioma);
			if (idioma == null)
			{
				log("Se coge el idioma de la plataforma");
				idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
			task.setParameterValue("RP_Idioma", idioma);
			if (informe.equalsIgnoreCase("terminosBusqueda") || informe.equalsIgnoreCase("masValorado") || informe.equalsIgnoreCase("masMostrado") || informe.equalsIgnoreCase("masPrevisualizado") || informe.equalsIgnoreCase("masVisualizado")
						|| informe.equalsIgnoreCase("masDescargado") || informe.equalsIgnoreCase("tamanio"))
			{
				log("[CrearGuardarInforme] El informe solicitado necesita fechas y rango");
				task.setParameterValue("RP_Rango", parametroCrearInformeVO.getRango());
				log("El informe contiene enlaces a la ficha");
				String urlNodo =  this.getAgregaPropertyValue("host");
				String urlFicha = this.getPropertyValue("urlFicha");
				task.setParameterValue("RP_UrlFicha", "http://"+urlNodo+LdapUserDetailsUtils.getSubdominio() + urlFicha);
			} else
			{
				if (informe.equalsIgnoreCase("odesUsuario"))
				{
					log("[CrearGuardarInforme] El informe seleccionado necesita fechas y usuario");
					task.setParameterValue("RP_Usuario", parametroCrearInformeVO.getUsuario());
				}

				}
					
			
			String formato = parametroCrearInformeVO.getFormato();
			log("[CrearGuardarInforme] formato -> " + formato);
			if (formato == null)
			{
				log.error("[CrearGuardarInforme] El formato introducido es null");
				throw new Exception("El formato del informe es null");
			}
			if (formato.equalsIgnoreCase("html"))
			{
				log("formato es html");
				Locale locale = new Locale(idioma);
				task.setLocale(locale);
				log("El lenguage del locale "+task.getLocale().getLanguage());
				HTMLRenderOption options = null;
				
				//Comprobamos si ya existe un fichero con el mismo nombre, en caso de que exista le añado System.curren
				String nombreInforme = this.getAgregaPropertyValue(informe) + "-" + fechaDesde + ".html";

				if (estaNomInforme(nombreInforme, informesDir).booleanValue())
				{
					log("Ya existe un fichero con el mismo nombre añado el timestamp");
					nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fechaDesde + "-" + System.currentTimeMillis() + ".html";
					
				} else
				{
					nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fechaDesde + ".html";
				
				}
								
				options = this.obtenerRenderOptions(nombreInforme);
				task.setRenderOption(options);
				
			} else
			{
				if (formato.equalsIgnoreCase("pdf"))
				{
					log("formato pdf");
					Locale locale = new Locale(idioma);
					task.setLocale(locale);
					log("El lenguage del locale "+task.getLocale().getLanguage());
					PDFRenderOption options = new PDFRenderOption();
					options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
					String nombreInforme = this.getAgregaPropertyValue(informe) + "-" + fechaDesde + ".pdf";
					if (estaNomInforme(nombreInforme, informesDir).booleanValue())
					{
						log("Ya existe un fichero con el mismo nombre añado el timestamp");
						nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fechaDesde + "-" + System.currentTimeMillis() + ".pdf";
						options.setOutputFileName(nombreInforme);
					} else
					{
						options.setOutputFileName(informesDir + this.getAgregaPropertyValue(informe) + "-" + fechaDesde + ".pdf");
					}
					options.setOutputStream(response);
					task.setRenderOption(options);
					

				} else
				{
					if (formato.equalsIgnoreCase("excel"))
					{
						log("formato excel");
						Locale locale = new Locale(idioma);
						task.setLocale(locale);
						log("El lenguage del locale "+task.getLocale().getLanguage());
						IRenderOption options = new RenderOption();
						options.setOutputFormat("xls");
						String nombreInforme = informe + "-" + fechaDesde + ".xls";
						if (estaNomInforme(nombreInforme, informesDir).booleanValue())
						{
							log("Ya existe un fichero con el mismo nombre añado el timestamp");
							nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fechaDesde + "-" + System.currentTimeMillis() + ".xls";
						} else
						{
							options.setOutputFileName(informesDir + nombreInforme);
						}
						options.setOutputStream(response);
						task.setRenderOption(options);
						
					} else
					{
						log.error("[CrearGuardarInforme] El formato introducido no es correcto");
						throw new Exception("El formato del informe no es correcto");
					}
				}
			}

			task.run();
		//	DataHandler dataHandler = new DataHandler(new SourceDataSource(null, MIMETYPE_OCTET_STREAM, new StreamSource(new ByteArrayInputStream(response.toByteArray()))));
			task.close();
			//// engine.destroy();
			//// log("[CrearGuardarInforme] engine.destroy");
			//// Platform.shutdown();
			

		} catch (Exception e)
		{
			log("[CrearGuardarInforme] Error al crear el informe " + e);
			task.close();
			//// engine.destroy();
			//// Platform.shutdown();
			throw new Exception(e);
		}

	}
	
	
	
	/**
	 * Genera y guarda en un directorio un informe federado con los datos que se pasan como parámetro
	 * @param  parametrosInformeVO Value Object con los parámetros que necesita el método para crear y guardar el informe federado
	 * @throws Exception
	 */
	public void handleCrearGuardarInformeFederado(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO) throws Exception
	{

		log("entramos en el metodo crearGuardarInformeFederado de auditoria");
		//El idioma en el que se mostrarán las etiquetas del informe será el idioma del que ha planificado la tarea de ejecución del informe
		IRunAndRenderTask task = null;
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String informesDir = "";
		String fecha = "";
		String informe = parametroCrearInformeVO.getNombreInforme();
		
		Calendar fechaCalendar = new GregorianCalendar();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		fecha = formatoFecha.format(fechaCalendar.getTime());
		
		
		log("la fecha publicacion del informe federado es: " + fecha);
		
		try
		{
			informesDir = this.getAgregaPropertyValue("destinoInformesFederadosDir");
			
			log("informe -> " + informe);
			log("informesDir -> " + informesDir);
			
			String nombreFichero = this.getAgregaPropertyValue("informesDir") + informe + ".rptdesign";
			task = this.levantarPlataforma(nombreFichero);
			
			String idioma = "";
			//String idioma = LdapUserDetailsUtils.getIdioma();
			//log("idioma -> " + idioma);
			
			if (idioma == null)
			{
				log("Se coge el idioma de la plataforma");
				idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			}
			
			task.setParameterValue("RP_Idioma", idioma);
			
			
			String formato = parametroCrearInformeVO.getFormato();
			log("[CrearGuardarInforme] formato -> " + formato);
			
			if (formato == null)
			{
				log.error("[CrearGuardarInforme] El formato introducido es null");
				throw new Exception("El formato del informe es null");
			}
			
			if (formato.equalsIgnoreCase("html"))
			{
				log("formato es html");
				Locale locale = new Locale(idioma);
				task.setLocale(locale);
				log("El lenguage del locale "+task.getLocale().getLanguage());
				HTMLRenderOption options = null;
				
				//Comprobamos si ya existe un fichero con el mismo nombre, en caso de que exista le añado System.curren
				String nombreInforme = this.getAgregaPropertyValue(informe) + "-" + fecha + ".html";

				if (estaNomInforme(nombreInforme, informesDir).booleanValue())
				{
					log("Ya existe un fichero con el mismo nombre añado el timestamp");
					nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fecha + "-" + System.currentTimeMillis() + ".html";
					
				} else
				{
					nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fecha + ".html";
				
				}
								
				options = this.obtenerRenderOptions(nombreInforme);
				task.setRenderOption(options);
				
			} 
			else
			{
				if (formato.equalsIgnoreCase("pdf"))
				{
					log("formato pdf");
					Locale locale = new Locale(idioma);
					task.setLocale(locale);
					log("El lenguage del locale "+task.getLocale().getLanguage());
					PDFRenderOption options = new PDFRenderOption();
					options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
					String nombreInforme = this.getAgregaPropertyValue(informe) + "-" + fecha + ".pdf";
					if (estaNomInforme(nombreInforme, informesDir).booleanValue())
					{
						log("Ya existe un fichero con el mismo nombre añado el timestamp");
						nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fecha + "-" + System.currentTimeMillis() + ".pdf";
						options.setOutputFileName(nombreInforme);
					} else
					{
						options.setOutputFileName(informesDir + this.getAgregaPropertyValue(informe) + "-" + fecha + ".pdf");
					}
					options.setOutputStream(response);
					task.setRenderOption(options);
					

				} 
				else
				{
					if (formato.equalsIgnoreCase("excel"))
					{
						log("formato excel");
						Locale locale = new Locale(idioma);
						task.setLocale(locale);
						log("El lenguage del locale "+task.getLocale().getLanguage());
						IRenderOption options = new RenderOption();
						options.setOutputFormat("xls");
						String nombreInforme = this.getAgregaPropertyValue(informe) + "-" + fecha + ".xls";
						if (estaNomInforme(nombreInforme, informesDir).booleanValue())
						{
							log("Ya existe un fichero con el mismo nombre añado el timestamp");
							nombreInforme = informesDir + this.getAgregaPropertyValue(informe) + "-" + fecha + "-" + System.currentTimeMillis() + ".xls";
							options.setOutputFileName(nombreInforme);
						} 
						else
						{
							options.setOutputFileName(informesDir + nombreInforme);
						}
						options.setOutputStream(response);
						task.setRenderOption(options);
						
					} 
					else
					{
						log.error("[CrearGuardarInforme] El formato introducido no es correcto");
						throw new Exception("El formato del informe no es correcto");
					}
				}
			}

			task.run();
			task.close();
			

		} catch (Exception e)
		{
			log("[CrearGuardarInforme] Error al crear el informe " + e);
			task.close();
			throw new Exception(e);
		}

	}
	
			
	/**
	 * Genera y guarda en un directorio los informes 'Mas' generados para la portada. Se  generarán los siguientes informes
	 * 'Mas':
	 *  Uno cuya fecha_inicio y fecha_fin será el día anterior a la ejecución del informe
	 *  Otro cuya fecha_inicio = ayer - x días donde x aparecerá en el fichero agrega.properties 
	 * @throws Exception
	 */
	public void handleCrearInformesPortada() throws Exception
	{

		//El idioma en el que se mostrarán las etiquetas del informe será el idioma del nodo
	
		IRunAndRenderTask task = null;
		HTMLRenderOption options = null;
		String fDesde = "";
		String fHasta = "";
		//ByteArrayOutputStream response = new ByteArrayOutputStream();
		String[] informesMas = null;
		String informe = "";
		Calendar fechaDesde = null;
		Calendar fechaHasta = null;
		String diaDesde = "";
		String mesDesde = "";
		String diaHasta = "";
		String mesHasta = "";
		String formato = "";
		String idioma = ""; //Idioma en el que se crearan los informes
		String descInformes = ""; //Informes de tipo 'Mas'
		String rangoFechas = ""; //parámetro de los informes
		String nombreFichero = ""; //Nombre del fichero 'Mas'
		String offSetDesde = "";
		String offSetHasta = "";
		//Atributos que se recogerán de ficheros properties
		String informesMasDir = "";
		String urlNodo =  "";
		String urlFicha = "";
		String rango = "";
		String diasAnterioresInformesPortada = "";
		String nombreInformesPortada1 = "";
		String nombreInformesMas = "";
		Locale locale = null;
		
		
		//Se cogerá del fichero auditoria.properties los informes de tipo Mas que se van a generar
		//Calculamos las fechas:
		try
		{
			//Cogemos los atributos de los ficheros properties
			informesMasDir = this.getAgregaPropertyValue("destinoInformesMasDir"); //Aquí se guardarán todos los informes mas
			urlNodo =  this.getAgregaPropertyValue("host");
			urlFicha = this.getPropertyValue("urlFicha");
			rango = this.getAgregaPropertyValue("rangoInformesPortada");
			nombreInformesPortada1 = this.getAgregaPropertyValue("nombreInformesPortadaSemanales");
		//	nombreInformesPortada2 = this.getAgregaPropertyValue("dias");
			diasAnterioresInformesPortada = this.getAgregaPropertyValue("diasAnterioresInformesPortada");
			log("informesDir " + informesMasDir);
			//El formato será siempre html
			formato = "html";
			
			idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			log("idioma -> " + idioma);
			if (idioma == null)
			{
				log("Se coge por defecto es");
				idioma = "es";
			}
					
			descInformes = this.getPropertyValue("informesMas");
			informesMas = descInformes.split(",");
				
			
			for(int i=0;i<informesMas.length;i++)
			{
				//Para cada informe 'Mas' calcularemos el informe del dia anterior y el de hace x días, siendo x una constante
				//que aparecerá en el agrega.properties para que lo pueda cambiar el administrador del nodo
				informe = informesMas[i];
				nombreFichero = this.getAgregaPropertyValue("informesDir") + informe + ".rptdesign";
				//Saco según el tipo de informe los parámetros que le voy a asignar
//				Preparamos la plataforma
				task = this.levantarPlataforma(nombreFichero);
				task.setParameterValue("RP_Idioma", idioma);
				log("Se añade el rango");
				task.setParameterValue("RP_Rango",new Integer(rango));
				log("Sacamos los informes 'Mas' que aparecerán en la portada");
//				Para los informas 'Mas' vamos a añadir el parámetro con el nodo y la url de la ficha para crear los enlaces
				log("El informe contiene enlaces a la ficha");
				task.setParameterValue("RP_UrlFicha", "http://"+urlNodo+LdapUserDetailsUtils.getSubdominio()+urlFicha);
				//Obtenemos el informe
				log("formato es html");
				locale = new Locale(idioma);
				task.setLocale(locale);
				log("El lenguage del locale "+task.getLocale().getLanguage());
				
				//Obtengo el HTMLRenderOption
				nombreInformesMas = informesMasDir + this.getAgregaPropertyValue(informe) + ".html";
				//nombreInformesMas = informe;
				log("nombreInformesMas diario "+nombreInformesMas);
				//options = this.obtenerRenderOptions(nombreInformesMas);
				//task.setRenderOption(options);
				
				//Calculamos los informes del día anterior	
				log("Calculamos los informes del dia anterior");
				// Set the start range for the daily reports
				fechaDesde = dateStringToCalendar(
						getPropertyValue("reportRangeStartDate"));
				log("fechaDesde "+fechaDesde);
				diaDesde = new Integer(fechaDesde.get(Calendar.DAY_OF_MONTH)).toString();
				if(diaDesde.length() == 1)
				{
						diaDesde = "0" + diaDesde;
				}
				mesDesde = new Integer((fechaDesde.get(Calendar.MONTH))+1 ).toString();
				if(mesDesde.length() == 1)
				{
						mesDesde = "0" + mesDesde;
				}
				fDesde = new Integer(fechaDesde.get(Calendar.YEAR)).toString()+"-"+ mesDesde +"-"+ diaDesde;
				fechaHasta = Calendar.getInstance();
				fechaHasta.add(Calendar.DATE, -1);
				log("fechaDesde "+fechaHasta);
				diaHasta = new Integer(fechaHasta.get(Calendar.DAY_OF_MONTH)).toString();
				if(diaHasta.length() == 1)
				{
						diaHasta = "0" + diaHasta;
				}
				mesHasta = new Integer((fechaHasta.get(Calendar.MONTH))+1).toString();
				if(mesHasta.length() == 1)
				{
						mesHasta = "0" + mesHasta;
				}
				fHasta = new Integer(fechaHasta.get(Calendar.YEAR)).toString()+"-"+ mesHasta +"-"+ diaHasta;
				log("fDesde "+fDesde);
				log("fHasta "+fHasta);
				rangoFechas = fHasta+"-"+fDesde;
				log("rangoFechas ->" + rangoFechas);
				offSetDesde = this.getOffSetDate(new Integer(fechaDesde.get(Calendar.YEAR)).toString(), mesDesde, diaDesde);
				offSetHasta = this.getOffSetDate(new Integer(fechaHasta.get(Calendar.YEAR)).toString(), mesHasta, diaHasta);
				task.setParameterValue("RP_fechaHasta", fHasta + "T23:59:59+0" + offSetHasta + ":00");
				task.setParameterValue("RP_fechaDesde", fDesde + "T00:00:00+0" + offSetDesde + ":00");
				task.setParameterValue("RP_rangoFechas", rangoFechas);
				
				options = this.obtenerRenderOptions(nombreInformesMas);
					
				
				task.setRenderOption(options);
				
				task.run();
			
                                String daysBeforeReports = this.getAgregaPropertyValue("daysBeforeReports");
                                if (daysBeforeReports!=null && daysBeforeReports.toLowerCase().equals("yes")) {

                                    //Calculamos los informes diasAnterioresInformesPortada

                                    log("Calculamos los informes de hace "+diasAnterioresInformesPortada);
                                    fechaDesde = Calendar.getInstance();
                                    fechaDesde.add(Calendar.DATE, - (new Integer(diasAnterioresInformesPortada)).intValue());
                                    log("fechaDesde "+fechaDesde);
                                    diaDesde = new Integer(fechaDesde.get(Calendar.DAY_OF_MONTH)).toString();
                                    if(diaDesde.length() == 1)
                                    {
                                                    diaDesde = "0" + diaDesde;
                                    }
                                    mesDesde = new Integer((fechaDesde.get(Calendar.MONTH))+1 ).toString();
                                    if(mesDesde.length() == 1)
                                    {
                                                    mesDesde = "0" + mesDesde;
                                    }
                                    fDesde = new Integer(fechaDesde.get(Calendar.YEAR)).toString()+"-"+ mesDesde +"-"+ diaDesde;
                                    fechaHasta = Calendar.getInstance();
                                    fechaHasta.add(Calendar.DATE, -1);
                                    log("fechaDesde "+fechaHasta);
                                    diaHasta = new Integer(fechaHasta.get(Calendar.DAY_OF_MONTH)).toString();
                                    if(diaHasta.length() == 1)
                                    {
                                                    diaHasta = "0" + diaHasta;
                                    }
                                    mesHasta = new Integer((fechaHasta.get(Calendar.MONTH))+1).toString();
                                    if(mesHasta.length() == 1)
                                    {
                                                    mesHasta = "0" + mesHasta;
                                    }
                                    fHasta = new Integer(fechaHasta.get(Calendar.YEAR)).toString()+"-"+ mesHasta +"-"+ diaHasta;
                                    log("fDesde "+fDesde);
                                    log("fHasta "+fHasta);
                                    rangoFechas = fHasta+"-"+fDesde;
                                    log("rangoFechas ->" + rangoFechas);
                                    offSetDesde = this.getOffSetDate(new Integer(fechaDesde.get(Calendar.YEAR)).toString(), mesDesde, diaDesde);
                                    offSetHasta = this.getOffSetDate(new Integer(fechaHasta.get(Calendar.YEAR)).toString(), mesHasta, diaHasta);
                                    task.setParameterValue("RP_fechaHasta", fHasta + "T23:59:59+0" + offSetHasta + ":00");
                                    task.setParameterValue("RP_fechaDesde", fDesde + "T00:00:00+0" + offSetDesde + ":00");
                                    task.setParameterValue("RP_rangoFechas", rangoFechas);

                                    //Obtenemos el HTMLRenderOptions
                                    nombreInformesMas =  informesMasDir + this.getAgregaPropertyValue(informe) +nombreInformesPortada1+".html";
                                    log("nombreInformesMas semanal "+nombreInformesMas);
                                    options = this.obtenerRenderOptions(nombreInformesMas);


                                    task.setRenderOption(options);

                                    task.run();
                            }   //if (daysBeforeReports!=null && daysBeforeReports.toLowerCase().equals("yes")) 
				
				task.close();
				
				
			}
			//// engine.destroy();
			//// log("[CrearGuardarInforme] engine.destroy");
			//// Platform.shutdown();
			

		} catch (Exception e)
		{
			log("[CrearInformesPortada] Error al crear el informe " + e);
			task.close();
			//// engine.destroy();
			//// Platform.shutdown();
			throw new Exception(e);
		}

	}

	/**
	 * Genera y guarda en un directorio el informe con todos los contenidos del repositorio
	 * @throws Exception
	 */
	public void handleCrearInformeRepositorio() throws Exception
	{
		log.info("Crear informe Repositorio");
		//El idioma en el que se mostrarán las etiquetas del informe será el idioma del nodo
		IRunAndRenderTask task = null;
		PDFRenderOption options = null;
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String informe = "";
		String idioma = ""; //Idioma en el que se crearan los informes
		//Atributos que se recogerán de ficheros properties
		String destinoInformeCatalogo = "";
		String nombreInforme = "";
		Locale locale = null;
		
		
		//Se cogerá del fichero auditoria.properties los informes de tipo Mas que se van a generar
		//Calculamos las fechas:
		try
		{
		
			//El idioma será por defecto el castellano
			idioma = "es";
			log("idioma -> " + idioma);
			informe = this.getAgregaPropertyValue("informesDir") + "repositorio.rptdesign";
			//El destino del informe del catálogo se especificará en el agrega.properties
			destinoInformeCatalogo = this.getAgregaPropertyValue("destinoInformesDir");
			task = this.levantarPlataforma(informe);
			locale = new Locale(idioma);
			task.setLocale(locale);
			log("El lenguage del locale "+task.getLocale().getLanguage());
			String urlNodo =  this.getAgregaPropertyValue("host");
			String urlFicha = this.getPropertyValue("urlFicha");
			task.setParameterValue("RP_UrlFicha", "http://"+urlNodo+LdapUserDetailsUtils.getSubdominio()+urlFicha);
			options = new PDFRenderOption();
			options.setOutputFormat(PDFRenderOption.OUTPUT_FORMAT_PDF);
			nombreInforme = destinoInformeCatalogo+ this.getAgregaPropertyValue("informeCatalogo")+".pdf";
			options.setOutputFileName(nombreInforme);
			options.setOutputStream(response);
			task.setRenderOption(options);
			task.run();
		
			//// engine.destroy();
			//// log("[CrearGuardarInforme] engine.destroy");
			//// Platform.shutdown();
			

		} catch (Exception e)
		{
			log("[CrearInformesRepositorio] Error al crear el informe " + e);
			task.close();
			//// engine.destroy();
			//// Platform.shutdown();
			throw new Exception(e);
		}

	}
	
	
	/**
	 * Obtiene un array de InformeRepositorioVO con todos los odes del repositorio
	 * @return InformeRepositorioVO[] Array de Value Objects con la información del repositorio
	 * @throws Exception
	 */
	protected es.pode.auditoria.negocio.servicios.RepositorioVO[] handleRepositorioNivelAgregacion(Integer nivelAgregacion) throws java.lang.Exception
	{
		RepositorioVO[] resultado = null;
		log.info("RepositorioNivelAgregacion");
		try
		{
			nivelAgregacion.intValue();
		}catch(Exception e)
		{
			log.error("El nivel agregacion es erroneo");
			nivelAgregacion = new Integer(1);
		}
		if((nivelAgregacion == null)||(nivelAgregacion == new Integer(0)))
		{
			nivelAgregacion = new Integer(1);
		}
		ResultadoRepositorioVO[] resultadoRepositorio = this.getSrvBuscadorService().obtenerCatalogoRepositorioParam(nivelAgregacion);
		log("El contenido del repositorio es "+resultadoRepositorio.length);
		resultado = new RepositorioVO[resultadoRepositorio.length];
		log("Mapeo cada uno de los VO del buscador");
		for (int i = 0; i < resultadoRepositorio.length; i++)
		{
			resultado[i] = new RepositorioVO();
			resultado[i].setDescripcion(resultadoRepositorio[i].getDescripcion());
			resultado[i].setEdad(resultadoRepositorio[i].getEdad());
			resultado[i].setTitulo(resultadoRepositorio[i].getTitulo());
			resultado[i].setIdiomaTexto(resultadoRepositorio[i].getIdiomaTexto());
			resultado[i].setNivelAgregacion(resultadoRepositorio[i].getNivelAgregacion());
			resultado[i].setIdioma(resultadoRepositorio[i].getIdioma());
			resultado[i].setIdentificador(resultadoRepositorio[i].getIdentificador());
			resultado[i].setFechaPublicacion(resultadoRepositorio[i].getFechaPublicacion());
			String[] objetivos = resultadoRepositorio[i].getObjetivos();
			String objetivo = "";
			for(int j=0;j<objetivos.length;j++)
			{
				objetivo = objetivo + objetivos[j] + " ";
			}
			resultado[i].setObjetivos(objetivo);
			
			
		}
		
		return resultado;
	}
	
	
	/**
	 * Genera y guarda en un directorio el informe con todos los contenidos del repositorio
	 * @throws Exception
	 */
	public void handleCrearInformeOdesCargados(Integer nivelAgregacion) throws Exception
	{
		log.info("Crear informe Odes Cargados");
		//El idioma en el que se mostrarán las etiquetas del informe será el idioma del nodo
		IRunAndRenderTask task = null;		
		IRenderOption options = null;
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String informe = "";
		String idioma = ""; //Idioma en el que se crearan los informes
		//Atributos que se recogerán de ficheros properties
		String destinoInformeCatalogo = "";
		String nombreInforme = "";
		Locale locale = null;
		
		try
		{
			nivelAgregacion.intValue();
		}catch(Exception e)
		{
			log.error("El nivel agregacion es erroneo");
			nivelAgregacion = new Integer(1);
		}
		if((nivelAgregacion == null)||(nivelAgregacion == new Integer(0)))
		{
			nivelAgregacion = new Integer(1);
		}
		
		//Se cogerá del fichero auditoria.properties los informes de tipo Mas que se van a generar
		//Calculamos las fechas:
		try
		{
				
			//El idioma será por defecto el castellano
			idioma = "es";
			log("idioma -> " + idioma);
			informe = this.getAgregaPropertyValue("informesDir") + "odesCargados.rptdesign";
			//El destino del informe del catálogo se especificará en el agrega.properties
			destinoInformeCatalogo = this.getAgregaPropertyValue("destinoInformesDir");
			//Saco según el tipo de informe los parámetros que le voy a asignar
			//Preparamos la plataforma
			task = this.levantarPlataforma(informe);
			locale = new Locale(idioma);
			task.setLocale(locale);
			log("El lenguage del locale "+task.getLocale().getLanguage());
			task.setParameterValue("RP_NivelAgregacion", nivelAgregacion);
			options = new RenderOption();
			nombreInforme = destinoInformeCatalogo+ "OdesCargados.xls";
			log("formato excel");
			options = new RenderOption();
			options.setOutputFormat("xls");
			options.setOutputFileName(nombreInforme);
			options.setOutputStream(response);
			task.setRenderOption(options);
			task.run();
		
			//// engine.destroy();
			//// log("[CrearGuardarInforme] engine.destroy");
			//// Platform.shutdown();
			

		} catch (Exception e)
		{
			log("[CrearInformesOdesCargados] Error al crear el informe " + e);
			task.close();
			//// engine.destroy();
			//// Platform.shutdown();
			throw new Exception(e);
		}

	}
	
	
	/**
	 * Obtiene un array con todas las operaciones de la plataforma que son necesarias auditar 
	 * @return String[] 
	 * @throws Exception
	 */

	private String[] obtenerOperaciones() throws java.lang.Exception
	{
		String[] operaciones = null;
		String descOperaciones = this.getPropertyValue("operaciones");
		log.info("descOperaciones vale " + descOperaciones);
		operaciones = descOperaciones.split(",");

		return operaciones;

	}

	/**
	 * Obtiene el valor del offset para calcular la fecha en formato Calendar a partir de un año, un mes y un día 
	 * @param  anio 
	 * @param  mes
	 * @param  dia
	 * @return String
	 * @throws Exception
	 */

	private String getOffSetDate(String anio, String mes, String dia)
	{
		String offSet = "";
		TimeZone tz = TimeZone.getDefault();
		GregorianCalendar calendar = new GregorianCalendar(tz);
		calendar.set(GregorianCalendar.YEAR, new Integer(anio).intValue());
		calendar.set(GregorianCalendar.MONTH, new Integer(mes).intValue());
		calendar.set(GregorianCalendar.DAY_OF_MONTH, new Integer(dia).intValue());
		int zOffset = calendar.get(GregorianCalendar.ZONE_OFFSET) / 3600000;
		int dOffset = calendar.get(GregorianCalendar.DST_OFFSET) / 3600000;
		offSet = (new Integer(zOffset + dOffset)).toString();
		return offSet;
	}

	/**
	 * Asigna un valor al objeto jmsTemplate para acceder a la cola jms 
	 * @param  jmsTemplate 
	 * @throws Exception
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate)
	{

		this.jmsTemplate = jmsTemplate;
	}
	/**
	 * Obtiene una instancia del objeto jmsTemplate para acceder a la cola jms 
	 * @return  jmsTemplate 
	 * @throws Exception
	 */
	public JmsTemplate getJmsTemplate()
	{

		return this.jmsTemplate;
	}

	private void log(Object obj)
	{
		if (log.isDebugEnabled())
			log.debug(obj);
	}

	/**
	 * Obtiene el valor almacenado en el fichero properties auditoria de una determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/auditoria.properties");
		if (this.pAuditoriaProperties == null)
		{
			pAuditoriaProperties = new java.util.Properties();
			pAuditoriaProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pAuditoriaProperties.getProperty(sKey);
	}

	/**
	 * Obtiene el valor almacenado en el fichero properties agrega de determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getAgregaPropertyValue(String sKey) throws IOException
	{
		AgregaProperties properties = AgregaPropertiesImpl.getInstance();
		// devolvemos la propiedad
		return properties.getProperty(sKey);
	}

	/**
	 * Almacena en la cola jms un Value Object con la operación realizada 
	 * @param  operacion Value Objet con los datos de la operación que se va a encolar
	 * @throws Exception
	 */
	private void enviarMensajeOperacion(final es.pode.auditoria.negocio.servicios.OperacionVO operacion)
	{
		log("enviarMensajeOperacion");
		this.jmsTemplate.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				return new SimpleMessageConverter().toMessage(operacion, session);
			}
		});
		log("Se ha creado un mensaje con el objeto operacion");
	}

	/**
	 * Almacena en la cola jms un Value Object con la búsqueda realizada 
	 * @param  busqueda Value Objet con los datos de la búsqueda que se va a encolar
	 * @throws Exception
	 */
	private void enviarMensajeBusqueda(final es.pode.auditoria.negocio.servicios.BusquedaVO busqueda)
	{
		log("enviarMensajeBusqueda");
		this.jmsTemplate.send(new MessageCreator()
		{
			public Message createMessage(Session session) throws JMSException
			{
				return new SimpleMessageConverter().toMessage(busqueda, session);
			}
		});

	}

	/**
	 * Obtiene el fichero donde se encuentran los textos internacionalizados 
	 * @param  locale 
	 * @throws Exception
	 */
	private ResourceBundle getFicherRecursos(Locale locale)
	{

		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
	}

	/**
	 * Obtiene el array con los términos buscados según el número de veces que han sido buscados 
	 * @param  array Array con los Value Object de las búsquedas que serán ordenadas
	 * @return InformeTerminoBusquedaVO[] Array con los Value Object ordenados por número de búsquedas
	 * @throws Exception
	 */
	private InformeTerminoBusquedaVO[] ordenaDescendente(InformeTerminoBusquedaVO[] array)
	{
		InformeTerminoBusquedaVO tmp;
		int i, j, pos_max;
		int N = array.length;
		for (i = 0; i < N - 1; i++)
		{
			//Mayor elemento del vector
			pos_max = i;
			for (j = i + 1; j < N; j++)
			{
				if (array[j].getNumVeces() > array[pos_max].getNumVeces())
					pos_max = j;
			}
			//coloca el maximo en la posicion i
			tmp = array[i];
			array[i] = array[pos_max];
			array[pos_max] = tmp;
		}
		return array;
	}

	/**
	 * Obtiene una array de Value Objets ordenados 
	 * @param  array Array de Value Objects que se quiere ordenar
	 * @return InformeMasVO[] Array con los Value Object ordenados
	 * @throws Exception
	 */
	private InformeMasVO[] ordenaDescendente(InformeMasVO[] array)
	{
		log("OrdenaDescendente");
		InformeMasVO tmp;
		int i, j, pos_max;
		int N = array.length;
		for (i = 0; i < N - 1; i++)
		{
			//Mayor elemento del vector
			pos_max = i;
			for (j = i + 1; j < N; j++)
			{
			
			
				if (array[j].getNumVeces() > array[pos_max].getNumVeces())
					pos_max = j;
				
			}
			//coloca el maximo en la posicion i
			tmp = array[i];
			array[i] = array[pos_max];
			array[pos_max] = tmp;
		}
		return array;
	}

	/**
	 * Obtiene el array con los títulos de los odes a partir de un array de identificadores 
	 * @param  detallePublicadoODEVO Array con los Value Object de las búsquedas que serán ordenadas
	 * @return String[] Array con los títulos de los odes
	 * @throws Exception
	 */
	private String[] getTitulosOde(DetallePublicadoODEVO[] detallePublicadoODEVO)
	{
		String[] resultado = null;
		resultado = new String[detallePublicadoODEVO.length];

		for (int i = 0; i < detallePublicadoODEVO.length; i++)
		{
			
			resultado[i] = detallePublicadoODEVO[i].getTitulo();
		}
		return resultado;
	}

	/**
	 * Obtiene un array de ArbolCurricularVO con la información del árbol curricular: el identificador y el nombre del nodo 
	 * @param  idioma del árbol curricular
	 * @return ArbolCurricularVO[] 
	 * @throws Exception
	 */
	private es.pode.auditoria.negocio.servicios.ArbolCurricularVO[] obtenerArbolCurricular(java.lang.String idioma) throws java.lang.Exception
	{
		SrvTaxonomiaService srvTaxonomiaService = this.getSrvTaxonomiaService();
		log("Nombre taxonomia " + this.getPropertyValue("nombreTaxonomia"));
		TaxonConRutaVO[] taxonConRutaVO = srvTaxonomiaService.obtenerTaxonomiaCompletaPreorden(this.getPropertyValue("nombreTaxonomia"), idioma);
		log("taxonConRutaVO vale " + taxonConRutaVO.length);
		ArbolCurricularVO[] arbolCurricularVO = new ArbolCurricularVO[taxonConRutaVO.length - 1];
		log("arbolCurricularVO.length " + arbolCurricularVO.length);
		if (!(taxonConRutaVO == null))
		{

			for (int i = 0; i < taxonConRutaVO.length - 1; i++)
			{
				arbolCurricularVO[i] = new ArbolCurricularVO();
				TaxonConRutaVO taxon = taxonConRutaVO[i + 1];
				arbolCurricularVO[i].setIdNodo(taxon.getId());
				arbolCurricularVO[i].setNombreNodo(taxon.getValorTax());

			}
		}
		log("devuelvo arbolCurricularVO.length " + arbolCurricularVO.length);
		return arbolCurricularVO;
	}

	/**
	 * Obtiene un array de String  con los identificadores de los nodos del árbol curricular 
	 * @param  arbolCurricular ArbolCurricularVO[]
	 * @return String[] 
	 */
	private String[] obtenerIdArbolCurricular(ArbolCurricularVO[] arbolCurricular)
	{
		log("obtenerIdArbolCurricular ");
		String[] idNodos = null;
		idNodos = new String[arbolCurricular.length];
		for (int i = 0; i < arbolCurricular.length; i++)
		{
			idNodos[i] = new String();
			idNodos[i] = arbolCurricular[i].getIdNodo();
		}
		log("El tamanio del array de id nodos  es " + idNodos.length);
		return idNodos;
	}

	/**
	 * Obtiene un array de String  con los identificadores de las licencias disponibles en la plataforma 
	 * @param  idioma idioma de las licencias
	 * @return String[] 
	 * throws Exception
	 */
	private java.lang.String[] obtenerLicencias(String idioma) throws java.lang.Exception
	{

		String[] identificador = new String[1];
		identificador[0] = new String(this.getPropertyValue("licencia"));
		VocabularioVO[] vocabulario = this.getSrvVocabulariosControladosService().obtenerCombos(identificador, idioma);
		TerminoVO[] termino = vocabulario[0].getTerminos();
		String[] resultado = new String[termino.length];
		for (int i = 0; i < termino.length; i++)
		{
			resultado[i] = new String();
			resultado[i] = termino[i].getNomTermino();
			log("resultado[i] " + resultado[i]);
		}
		return resultado;
	}

	/**
	 * Comprueba si existe ya un archivo en el directorio con el mismo nombre 
	 * @param  nombreInforme nombre del informe
	 * @param  dirInformes directorio donde se comprobará la existencia del fichero
	 * @return Boolean 
	 */
	private Boolean estaNomInforme(String nombreInforme, String dirInformes)
	{
		Boolean resultado = Boolean.FALSE;
		try
		{
			File dir = new File(dirInformes);
			if (dir.isDirectory())
			{
				if (!dir.exists())
				{
					log.error("El directorio no existe ");

				}
				//tomamos los ficheros contenidos en la URL dada
				String[] archivos = dir.list();
				//agregamos cada fichero en una lista
				for (int i = 0; i < archivos.length; i++)
				{
					if (archivos[i].equalsIgnoreCase(nombreInforme))
					{
						log("Ya existe otro fichero con el mismo nombre");
						resultado = Boolean.TRUE;
						break;
					}
				}

			}
		} catch (Exception e)
		{
			log.error("Se produce una excepcion al buscar el nombre del fichero " + e);
		}
		log("estaNomInforme -> " + resultado);
		return resultado;
	}
	
	private String getEtiqueta(String etiqueta,String idioma)
	{
		String resultado = null;
		resultado = I18n.getInstance().traduceEtiqueta(etiqueta, idioma);
		log("resultado "+resultado);
		return resultado;
	}
	
	
	/**
	 * Comprueba si el VO con los parámetros es correcto 
	 * @param  parametroCrearInformeVO VO con los parámetros
	 * @return Boolean con el resultado de la validacion
	 */
	private Boolean validarParametrosInforme(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO)
	{
		Boolean resultado = new Boolean(true);
		if (parametroCrearInformeVO == null)
		{
			log.error("parametrosCrearInformeInforme es null");
			resultado = new Boolean(false);
		}else if (parametroCrearInformeVO.getAnioDesde() == null || parametroCrearInformeVO.getMesDesde() == null || parametroCrearInformeVO.getDiaDesde() == null || parametroCrearInformeVO.getAnioHasta() == null
				|| parametroCrearInformeVO.getMesHasta() == null || parametroCrearInformeVO.getDiaHasta() == null)
			{
				log.error("[CrearGuardarInforme] Error creando los informes alguna de las fechas es null");
				resultado = new Boolean(false); 
			}else 
			{
				String informe = parametroCrearInformeVO.getNombreInforme();
				if (informe == null)
				{
					log.error("[CrearGuardarInforme] Error al obtener el nombre del informe");
					resultado = new Boolean(false);
				}
			}
		
		return resultado;
	}
	
	/**
	 * Obtiene el rango de fechas para los que se calculará el informe 
	 * @param  parametroCrearInformeVO VO con los parámetros
	 * @return String con el rango de fechas
	 */
	private String obtenerRangoFechas(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO)
	{
		String resultado = "";
		resultado = parametroCrearInformeVO.getDiaDesde() + "/" + parametroCrearInformeVO.getMesDesde() + "/" + parametroCrearInformeVO.getAnioDesde() + " - " + parametroCrearInformeVO.getDiaHasta() + "/"
		+ parametroCrearInformeVO.getMesHasta() + "/" + parametroCrearInformeVO.getAnioHasta();
		return resultado;
	}
	
	/**
	 * Obtiene la fecha de inicio o de fin de generación del informe 
	 * @param  parametroCrearInformeVO VO con los parámetros
	 * @param  tipo tipo de fecha que se desea obtener: desde o hasta
	 * @return String con la fecha
	 */
	
	private String obtenerFecha(es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO parametroCrearInformeVO, String tipo)
	{
		String resultado = "";
		if(tipo.equalsIgnoreCase("desde"))
		{
			resultado = parametroCrearInformeVO.getAnioDesde() + "-" + parametroCrearInformeVO.getMesDesde() + "-" + parametroCrearInformeVO.getDiaDesde();
		}else
		{
			resultado = parametroCrearInformeVO.getAnioHasta() + "-" + parametroCrearInformeVO.getMesHasta() + "-" + parametroCrearInformeVO.getDiaHasta();
		}
		
		return resultado;
	}
	
	/**
	 * Levanta la plataforma de birt para la generación de informes 
	 * @param  informe informe que se quiere generar
	 * @return IRunAndRenderTask
	 */
	
	private IRunAndRenderTask levantarPlataforma(String informe)throws Exception
	{
		IRunAndRenderTask task = null;
		EngineConfig config = null;
		IReportEngine engine = null;
		IReportRunnable design = null;
		IReportEngineFactory factory = null;
		config = new EngineConfig();
		config.setBIRTHome(this.getAgregaPropertyValue("birtDir"));
		log("config.getBIRTHome() " + config.getBIRTHome());
		config.setResourcePath(this.getAgregaPropertyValue("informesDir"));
		log("config.getResourcePath() "+config.getResourcePath());
		Platform.startup(config);
		factory = (IReportEngineFactory) Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
		engine = factory.createReportEngine(config);
		engine.changeLogLevel(Level.ALL);
		design = engine.openReportDesign(informe);
		task = engine.createRunAndRenderTask(design);
		return task;
	}
	
	/**
	 * Obtiene HTMLRenderOptions para la ejecución del informe 
	 * @param  nombreInforme nombre del fichero con el informe
	 * @return HTMLRenderOption
	 */
	
	private HTMLRenderOption obtenerRenderOptions(String nombreInforme) throws Exception
	{
		
		HTMLRenderOption options = null;
		ByteArrayOutputStream response = new ByteArrayOutputStream();
		String urlNodo =  this.getAgregaPropertyValue("host");
		options = new HTMLRenderOption();
		options.setOutputFormat(HTMLRenderOption.OUTPUT_FORMAT_HTML);
		options.setImageHandler(new HTMLServerImageHandler());
		options.setImageDirectory(this.getAgregaPropertyValue("imgBirtDir"));
		
		log("options.getImageDirectory() " + options.getImageDirectory());
		options.setBaseImageURL("http://" + urlNodo + this.getAgregaPropertyValue("staticImgDir"));
		log("options.getBaseImageURL() " + options.getBaseImageURL());
		//Comprobamos si ya existe un fichero con el mismo nombre, en caso de que exista le añado System.curren
		options.setOutputFileName(nombreInforme);
		options.setHtmlPagination(true);
		options.setOutputStream(response);
		return options;
	}
	
	/**
	 * Comprueba si la fechas son correctas 
	 * @param  nombreInforme nombre del fichero con el informe
	 * @return Boolean
	 */
	
	private Boolean validarFechas(Calendar fechaDesde, Calendar fechaHasta)
	{
		
		Boolean resultado = new Boolean(true);
		if (fechaDesde == null || fechaHasta == null)
		{
			log.error("Error calculando odes mas mostrados. Fechas desde[" + fechaDesde == null ? null : fechaDesde + "] y hasta[" + fechaHasta == null ? null : fechaHasta + "] vacias.");
			resultado = new Boolean(false);
			
		}else if(fechaDesde.after(fechaHasta))
		{
			log.error("Error calculando odes mas mostrados. Fechas desde[" + fechaDesde + "] y hasta[" + fechaHasta + "] incoherentes.");
			resultado = new Boolean(false);
			
		}
		return resultado;
	}
	
	/**
	 * Obtiene el array de VO con la información de los odes mas del tipo de operación que se pasa por parámetro
	 * @param	tipoOperacion tipo de operación 
	 * @param	parametrosInformeVO VO con los parámetros del informe
	 * @return Boolean
	 */
	
	private InformeMasVO[] obtenerMasVO(String tipoOperacion,es.pode.auditoria.negocio.servicios.ParametrosInformeVO parametrosInformeVO) throws Exception
	{
			log.info("INFORME mas ");
			String[] listaIdOdesMasMostrado = null;
			String[] titulosOde = null;
			InformeMasVO[] devuelto = null;
			String[] listaIdOde = null;
			Long numeroVecesMostrado = null;
			InformeMasVO[] arrayTemp = null;
			
			if (parametrosInformeVO == null)
			{
				log.error("Error calculando odes mas mostrados. No hay parametros.");
				throw new Exception("Error calculando odes mas mostrados. No hay parametros.");
			}
			Calendar fechaDesde = parametrosInformeVO.getFechaDesde();
			Calendar fechaHasta = parametrosInformeVO.getFechaHasta();
			int numMaxRes = parametrosInformeVO.getRango();
			IdiomaOdeDesdeHastaCriteria idiomaOdeDesdeHastaCriteria = null;
			if (numMaxRes == 0)
			{
				log.error("Error calculando odes mas mostrados. El numero de resultados a devolver es nulo o 0.");
				throw new Exception("Error calculando odes mas mostrados. El numero de resultados a devolver es nulo o 0.");
			}
			if(!(this.validarFechas(fechaDesde, fechaHasta)).booleanValue())
			{
				log.error("Las fechas no son correctas");
				throw new Exception("Error calculando odes mas mostrados. Fechas desde[" + fechaDesde == null ? null : fechaDesde + "] y hasta[" + fechaHasta == null ? null : fechaHasta + "] erroneas.");
			}
			
			//Obtengo la lista de ids y los idiomas
			
			
			listaIdOde = (String[]) this.getOperacionDao().obtenerIdOdesOperacionDesdeHasta(fechaDesde, fechaHasta, tipoOperacion).toArray(new String[0]);
			 
			
			if (listaIdOde == null || listaIdOde.length == 0)
			{
				log.info("Calculando odes mas mostrados. No existen odes mas mostrados dentro del periodo desde[" + fechaDesde + "]->hasta[" + fechaHasta + "]");
				return null;
			}else
			{
				log("listaIdOde.length "+listaIdOde.length);
			}
			
			
			arrayTemp = new InformeMasVO[listaIdOde.length];
			
			for (int i = 0; i < listaIdOde.length; i++)
			{
				try
				{
						arrayTemp[i] = new InformeMasVO();
						numeroVecesMostrado = this.getOperacionDao().obtenerNumIdOdesOperacion(fechaDesde, fechaHasta, listaIdOde[i], tipoOperacion);
						log("idOde "+ listaIdOde[i]+ "numeroVecesMostrado "+numeroVecesMostrado);
						arrayTemp[i].setNumVeces(numeroVecesMostrado.intValue());
						arrayTemp[i].setIdOde(listaIdOde[i]);
				
				} catch (Exception e)
				{
					log.error("Calculando odes mas mostrados. Error obteniendo numero de veces que ha sido mostrado para el ode[" + listaIdOde[i] + "]. Continuamos el calculo. "+e);
				}
			}
			
			arrayTemp = ordenaDescendente(arrayTemp);
			log("Se ordena el listado en orden descendiente");
			
			if (arrayTemp.length <= numMaxRes)
			
				devuelto = arrayTemp;
			else
			{
				devuelto = new InformeMasVO[numMaxRes];
				for (int i = 0; i < numMaxRes; i++)
				{
					devuelto[i] = arrayTemp[i];
					
				}
				
			}
			//Recorro el array devuelto para ver los identificadores
			for(int n=0;n<devuelto.length;n++)
			{
				log("IdOde "+n+" "+devuelto[n].getIdOde()+" numVeces "+devuelto[n].getNumVeces());
			}
						
			
			//Obtengo los idOdes para sacar el titulo
			listaIdOdesMasMostrado = new String[devuelto.length];
			for(int l=0;l<devuelto.length;l++)
			{
				listaIdOdesMasMostrado[l] = devuelto[l].getIdOde();
			}
			log("Se obtienen los titulos de los odes del publicador");
			titulosOde = this.getTitulosOde(this.getSrvAuditaPublicacionService().titulosODEsPorID(listaIdOdesMasMostrado));
			log("titulosOde "+titulosOde);
			//Obtengo el idioma y el titulo de cada uno de los identificadores que se van a devolver
			for(int j=0;j<devuelto.length;j++)
			{
				idiomaOdeDesdeHastaCriteria = new IdiomaOdeDesdeHastaCriteria();
				idiomaOdeDesdeHastaCriteria.setFechaDesde(fechaDesde);
				idiomaOdeDesdeHastaCriteria.setFechaHasta(fechaHasta);
				idiomaOdeDesdeHastaCriteria.setIdOde(devuelto[j].getIdOde());
				List list = this.getOperacionDao().obtenerIdiomaIdOde(idiomaOdeDesdeHastaCriteria);
				if(list == null)
				{
					log("Marco el idioma vacio");
					devuelto[j].setIdioma("");
				}else
				{
				if(list.size() == 1)
				{
					log("La lista tiene tamanio 1");
					Operacion operacionVO = (Operacion)list.iterator().next();
					log("operacionVO.getIdioma() "+operacionVO.getIdioma());
					devuelto[j].setIdioma(operacionVO.getIdioma());
				}else
				{
					log("tenemos mas de un elimento");
					Operacion[] operacionesArray = (Operacion[]) list.toArray(new Operacion[0]);
					if(operacionesArray[0].getIdioma() == null)
					{
						log("asigno el idioma vacio");
						devuelto[j].setIdioma("");
					}else
					{
						
						devuelto[j].setIdioma(operacionesArray[0].getIdioma());
					}
					
					
				}
				
				}
				devuelto[j].setTituloOde(titulosOde[j]);
			}
/////////////////////////////////////////////////////
			InputStream is = null;
	   	 	Properties prop = new Properties();
			is = this.getClass().getResourceAsStream("/auditoria.properties");
			prop.load(is);
			String idiomas=prop.getProperty("idiomas");
			String[] listIdiomas=idiomas.split(",");
			List listaCatalan=new ArrayList();
			List listaIngles=new ArrayList();
			List listaCastellano=new ArrayList();
			List listaEuskera=new ArrayList();
			List listaGallego=new ArrayList();
			List listaValenciano=new ArrayList();
			List listaSin=new ArrayList();
			for(int i=0;i<devuelto.length;i++){
				String idioma=devuelto[i].getIdioma();
				
				if(listIdiomas[0].equals(idioma)){//ca				
					listaCatalan.add(devuelto[i].getIdOde());
				}else if(listIdiomas[1].equals(idioma)){//en				
					listaIngles.add(devuelto[i].getIdOde());
				}else if(listIdiomas[2].equals(idioma)){//es				
					listaCastellano.add(devuelto[i].getIdOde());
				}else if(listIdiomas[3].equals(idioma)){//eu				
					listaEuskera.add(devuelto[i].getIdOde());
				}else if(listIdiomas[4].equals(idioma)){//gl				
					listaGallego.add(devuelto[i].getIdOde());
				}else if(listIdiomas[5].equals(idioma)){//va				
					listaValenciano.add(devuelto[i].getIdOde());
				}else{//Cuando no traiga idioma
					listaSin.add(devuelto[i].getIdOde());
				}
			}
			HashMap hash=new HashMap();
			if(listaCatalan!=null && listaCatalan. size()>0){
				String[] arrayCatalan=(String[])listaCatalan.toArray(new String[listaCatalan.size()]);
				String[] catalan = this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[0],arrayCatalan);
				for(int i=0;i<arrayCatalan.length;i++){
					String id=listaCatalan.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El catalan"+i+" con identificador:[ "+id+" ] y su url:[ "+catalan[i]);
					hash.put(id, catalan[i]);
				}
			}
			if(listaIngles!=null && listaIngles.size()>0){
				String[] arrayIngles=(String[])listaIngles.toArray(new String[listaIngles.size()]);
				String[] ingles=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[1],arrayIngles);			
				for(int i=0;i<arrayIngles.length;i++){
					String id=listaIngles.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El ingles"+i+" con identificador:[ "+id+" ] y su url:[ "+ingles[i]);
					hash.put(id, ingles[i]);
				}
			}
			if(listaCastellano!=null && listaCastellano.size()>0){
				String[] arrayCastellano=(String[])listaCastellano.toArray(new String[listaCastellano.size()]);
				String[] castellano=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[2],arrayCastellano);			
				for(int i=0;i<arrayCastellano.length;i++){
					String id=listaCastellano.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El castellano"+i+" con identificador:[ "+id+" ] y su url:[ "+castellano[i]);
					hash.put(id, castellano[i]);
				}
			}
			if(listaEuskera!=null && listaEuskera.size()>0){
				String[] arrayEuskera=(String[])listaEuskera.toArray(new String[listaEuskera.size()]);
				String[] euskera=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[3],arrayEuskera);
				for(int i=0;i<arrayEuskera.length;i++){
					String id=listaEuskera.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El euskera"+i+" con identificador:[ "+id+" ] y su url:[ "+euskera[i]);
					hash.put(id, euskera[i]);
				}
			}
			if(listaGallego!=null && listaGallego.size()>0){
				String[] arrayGallego=(String[])listaGallego.toArray(new String[listaGallego.size()]);
				String[] gallego=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[4],arrayGallego);
				for(int i=0;i<arrayGallego.length;i++){
					String id=listaGallego.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El gallego"+i+" con identificador:[ "+id+" ] y su url:[ "+gallego[i]);
					hash.put(id, gallego[i]);
				}
			}
			if(listaValenciano!=null && listaValenciano.size()>0){
				String[] arrayValenciano=(String[])listaValenciano.toArray(new String[listaValenciano.size()]);
				String[] valenciano=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(listIdiomas[5],arrayValenciano);
				for(int i=0;i<arrayValenciano.length;i++){
					String id=listaValenciano.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("El valenciano"+i+" con identificador:[ "+id+" ] y su url:[ "+valenciano[i]);
					hash.put(id, valenciano[i]);
				}
			}
			if(listaSin!=null && listaSin.size()>0){
				String[] arraySin=(String[])listaSin.toArray(new String[listaSin.size()]);
				String[] sin=this.getSrvAuditoriaIndexadorService().obtenerURLImagenPequena(null,arraySin);
				for(int i=0;i<arraySin.length;i++){
					String id=listaSin.get(i).toString();
					if(log.isDebugEnabled())
					log.debug("Sin idioma"+i+" con identificador:[ "+id+" ] y su url:[ "+sin[i]);
					hash.put(id, sin[i]);
				}
			}
			String urlNodo =  this.getAgregaPropertyValue("host");
//			String urlNodo =DependentServerProperties.getInstance().getUrlNodo();
			String urlLocal="http://"+urlNodo+LdapUserDetailsUtils.getSubdominio();//O de DependServer?????
			for(int i=0;i<devuelto.length;i++){
				String identificador=((InformeMasVO)devuelto[i]).getIdOde();
				String foto=(String)(hash.get(identificador));
				String urlFoto=urlLocal+foto;
				devuelto[i].setUrlImagen(urlFoto);
				if(log.isDebugEnabled())
				log.debug("La url del identificador:[ "+foto+" ] es :["+urlFoto);
			}		
			return devuelto;
		
	}
	/**
	 * Obtiene el valor almacenado en el fichero properties estadisticas de determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getEstadisticasPropertyValue(String sKey) throws IOException
	{
		EstadisticasProperties properties = EstadisticasPropertiesImpl.getInstance();
		// devolvemos la propiedad
		return properties.getProperty(sKey);
	}

	/*
     * Este metodo devuelve un array de NumeroOperacionesVO,cada uno de estos VOs tiene el identificador(la entrada del metodo), la operacion y
     * cuantas veces se ha realizado esa operacion para ese identificador. Como salida nos devuelve el array de todas las operaciones para ese identificador.
     * */
	protected NumeroOperacionesVO[] handleObtenNumeroOperaciones(String identificador) throws Exception {
		String operaciones = this.getEstadisticasPropertyValue("numero_operacion");
		String[] lOperaciones = operaciones.split(",");
		NumeroOperacionesVO[] numeroOperaciones=new NumeroOperacionesVO[lOperaciones.length];
		log.info("El identificador es:["+identificador+"]");

		Long valor=null;
		for(int j=0;j< lOperaciones.length;j++){
			NumeroOperacionesVO numero=new NumeroOperacionesVO();
			String operacion=lOperaciones[j];
			valor = this.getOperacionDao().obtenerNumeroOperacion(identificador, operacion);
			log.info("La operacion requerida es:["+operacion+"] y el valor que devuelve:["+valor);
			numero.setIdentificador(identificador);
			numero.setOperacion(operacion);
			numero.setNumeroOperaciones(valor.intValue());
			
			numeroOperaciones[j]=numero;
		}
		return numeroOperaciones;
	}

	private Calendar dateStringToCalendar(String input) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(confDateStringFormat.parse(input));
		return cal;
	}

}