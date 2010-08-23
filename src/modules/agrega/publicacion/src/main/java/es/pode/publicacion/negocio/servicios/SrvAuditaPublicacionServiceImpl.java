/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.publicacion.negocio.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.publicacion.negocio.dominio.ActividadDesdeHastaCriteria;
import es.pode.publicacion.negocio.dominio.Estado;
import es.pode.publicacion.negocio.dominio.IdODECriteria;
import es.pode.publicacion.negocio.dominio.PublicadoDesdeHastaTamanioCriteria;
import es.pode.publicacion.negocio.dominio.Transicion;
import es.pode.publicacion.negocio.dominio.UltimosOdesPublicadosCriteria;
import es.pode.publicacion.negocio.dominio.UsuarioActividadCriteria;
import es.pode.soporte.utiles.date.DateManager;


/**
 * @see es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionService
 */

public class SrvAuditaPublicacionServiceImpl
    extends es.pode.publicacion.negocio.servicios.SrvAuditaPublicacionServiceBase
{

	
	private Logger logger = Logger.getLogger(this.getClass());
	

	/**
	 * Este metodo devuelve la informacion de detalle de la lista de identificadores que le pasan.
	 * @param idODEs Lista de los identificadores que le pasan.
	 * @throws Exception
	 * 
	 */
	protected DetallePublicadoODEVO[] handleTitulosODEsPorID(String[] idODEs) throws Exception {
//    	Chequeamos los datos por higiene
    	if (idODEs == null || idODEs.length == 0)
    	{
    		logger.error("Error obteniendo detalle de ODEs. Lista de identificadores de ODEs vacia["+(idODEs!= null?idODEs.length+"":null)+"]");
    		throw new Exception("Error obteniendo detalle de ODEs. Lista de identificadores de ODEs vacia["+(idODEs!= null?idODEs.length+"":null)+"]");
    	}
//    	Tengo que recorrer la lista de identificadores para obtener el estado en el que se encuentran y rescatar el titulo.
    	
    	IdODECriteria criterio = new IdODECriteria();
    	DetallePublicadoODEVO[] retorno = new DetallePublicadoODEVO[idODEs.length];
    	for (int i = 0; i < idODEs.length; i++) {
    		DetallePublicadoODEVO detalle = new DetallePublicadoODEVO();
    		detalle.setIdODE(idODEs[i]);
    		criterio.setIdODE(idODEs[i]);
    		List lista = this.getTransicionDao().buscarEstadoPorCriterioIdODE(criterio);
    		if (lista != null && lista.size() > 0) // tiene ultimo estado
    		{
    			if (((Transicion)lista.get(0)).getTitulo().equals(""))
    				detalle.setTitulo(idODEs[i]); // si el ode no tiene titulo, utilizamos el id como titulo.
    			else
    				detalle.setTitulo(((Transicion)lista.get(0)).getTitulo());
    		}
    		else  //si el ode no existe, ponemos su id como titulo
    			detalle.setTitulo(idODEs[i]);
    		retorno[i] = detalle;
    	}
    	return retorno;
	}

	/**
	 * Este metodo devuelve para cada estado posible de un ODE, el numero de transiciones que se han 
	 * detectado para cada estado en el periodo dado.
	 * @param parametroAuditoria Parametro de auditoria con toda la informacion necesaria.
	 * @throws Exception
	 * 
	 */
    protected es.pode.publicacion.negocio.servicios.ODEsEstadoVO[] handleActividadTransiciones(ParametroAuditPublicacionVO parametroAuditoria)
        throws java.lang.Exception
    {
    	if (parametroAuditoria == null)
    	{
    		logger.error("Error obteniendo el mumero de transiciones por estado. No hay parametros.");
    		throw new Exception("Error obteniendo el mumero de transiciones por estado. No hay parametros.");
    	}
//    	String idioma = parametroAuditoria.getIdioma();
    	Date fechaDesde = (parametroAuditoria.getFechaDesde()!=null?parametroAuditoria.getFechaDesde().getTime():null);
    	Date fechaHasta = (parametroAuditoria.getFechaHasta()!=null?parametroAuditoria.getFechaHasta().getTime():null);
//    	Chequeamos los datos por higiene
//    	if (idioma == null || idioma.equals(""))
//    	{
//    		logger.error("Error obteniendo el mumero de transiciones por estado. Idioma a utilizar invalido["+idioma+"]");
//    		throw new Exception("Error obteniendo el mumero de transiciones por estado. Idioma a utilizar invalido["+idioma+"]");
//    	}
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error obteniendo el mumero de transiciones por estado. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error obteniendo el mumero de transiciones por estado. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error obteniendo el mumero de transiciones por estado. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error obteniendo el mumero de transiciones por estados. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//    	Recuperamos los estados de la BD en orden del ciclo de vida de un ODE.
    	ArrayList listaEstadosOrdenada = new ArrayList();
    	for (int i = 0; i < SrvPublicacionServiceImpl.SECUENCIA_ESTADOS.length; i++) {
    		listaEstadosOrdenada.add(this.getEstadoDao().obtenEstadoPorNombre(SrvPublicacionServiceImpl.SECUENCIA_ESTADOS[i]));
		}

    	Estado[] estadosEntity = (Estado[])listaEstadosOrdenada.toArray(new Estado[0]);
    	if (estadosEntity == null || estadosEntity.length == 0)
    	{
    		logger.error("Error obteniendo el mumero de transiciones por estado. Imposible obtener estados de los ODEs.");
    		throw new Exception("Error obteniendo el mumero de transiciones por estados. Imposible obtener estados de los ODEs.");
    	}
    	ActividadDesdeHastaCriteria criterioActividadDesdeHasta = new ActividadDesdeHastaCriteria();
    	criterioActividadDesdeHasta.setFechaDesde(DateManager.dateToCalendar(fechaDesde));
    	criterioActividadDesdeHasta.setFechaHasta(DateManager.dateToCalendar(fechaHasta));
    	ODEsEstadoVO[] resultadosEstados = new ODEsEstadoVO[estadosEntity.length];
    	for (int i = 0; i < estadosEntity.length; i++) {
    		criterioActividadDesdeHasta.setEstado(estadosEntity[i]);
			List listadoDeResultados = this.getTransicionDao().buscarTransicionesPorCriterioDesdeHasta(criterioActividadDesdeHasta);
			ODEsEstadoVO resultado = new ODEsEstadoVO();
			resultado.setEstado(((EstadoVO)this.getEstadoDao().load(this.getEstadoDao().TRANSFORM_ESTADOVO,estadosEntity[i].getId())).getNombre());  // la traduccion del estado esta en el VO de estado
			if (listadoDeResultados == null || listadoDeResultados.size() == 0)
				resultado.setCantidad(new Long(0));
			else
				resultado.setCantidad(new Long(listadoDeResultados.size()));
			resultadosEstados[i]=resultado;
		}
        return resultadosEstados;
    }

	/**
	 * Este metodo devuelve el tamanio de los ODEs que estan publicados en la plataforma.
	 * Se le pasa la fecha desde y hasta que se quiere tener en cuenta y el numero de ODEs que se quieren devolver.
	 * @param parametroAuditoria Parametro de auditoria con toda la informacion necesaria.
	 * @return Se devuelve una lista de la cantidad de informacion pedida ordenada de mayor a menor de los mas pesados a los menos.
	 * @throws Exception
	 * 
	 */
    protected es.pode.publicacion.negocio.servicios.PesoODEVO[] handleDimensionesODEsPublicados(ParametroAuditPublicacionVO parametroAuditoria)
        throws java.lang.Exception
    {
    	if (parametroAuditoria == null)
    	{
    		logger.error("Error obteniendo las dimensiones de los ODEs publicados.. No hay parametros.");
    		throw new Exception("Error obteniendo las dimensiones de los ODEs publicados.. No hay parametros.");
    	}
    	Integer numODES = parametroAuditoria.getRango();
    	Date fechaDesde = (parametroAuditoria.getFechaDesde()!= null?parametroAuditoria.getFechaDesde().getTime():null);
    	Date fechaHasta = (parametroAuditoria.getFechaHasta()!= null?parametroAuditoria.getFechaHasta().getTime():null);
//    	Chequeamos los datos por higiene
    	if (numODES == null || numODES.intValue() == 0)
    	{
    		logger.error("Error obteniendo las dimensiones de los ODEs publicados. Numero de elementos requerido invalido["+numODES+"]");
    		throw new Exception("Error obteniendo las dimensiones de los ODEs publicados. Numero de elementos requerido invalido["+numODES+"]");
    	}
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error obteniendo las dimensiones de los ODEs publicados. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error obteniendo las dimensiones de los ODEs publicados. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error obteniendo las dimensiones de los ODEs publicados. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error obteniendo las dimensiones de los ODEs publicados. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
    	PublicadoDesdeHastaTamanioCriteria criterio = new PublicadoDesdeHastaTamanioCriteria();
    	criterio.setFechaDesde(DateManager.dateToCalendar(fechaDesde));
    	criterio.setFechaHasta(DateManager.dateToCalendar(fechaHasta));
    	criterio.setMaximumResultSize(numODES);
    	PesoODEVO[] resultados = (PesoODEVO[])this.getOdePublicadoDao().obtenODEsPorDimensionDesdeaHasta(this.getOdePublicadoDao().TRANSFORM_PESOODEVO,
    																criterio).toArray(new PesoODEVO[0]);
        return resultados;
    }

	/**
	 * Este metodo devuelve la cantidad de ODEs que hay en cada estado dentro en la fecha hasta dada.
	 * @param parametroAuditoria Parametro de auditoria con toda la informacion necesaria.
	 * @throws Exception
	 * 
	 */
    protected es.pode.publicacion.negocio.servicios.ODEsEstadoVO[] handleOdesPorEstados(ParametroAuditPublicacionVO parametroAuditoria)
        throws java.lang.Exception
    {
    	if (parametroAuditoria == null)
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado. No hay parametros.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado. No hay parametros.");
    	}
//    	String idioma = parametroAuditoria.getIdioma();
    	Date fechaDesde = (parametroAuditoria.getFechaDesde()!= null? parametroAuditoria.getFechaDesde().getTime(): null);
    	Date fechaHasta = (parametroAuditoria.getFechaHasta()!= null? parametroAuditoria.getFechaHasta().getTime():null);
//    	Chequeamos los datos por higiene
//    	if (idioma == null || idioma.equals(""))
//    	{
//    		logger.error("Error obteniendo el mumero de ODEs por estado. Idioma a utilizar invalido["+idioma+"]");
//    		throw new Exception("Error obteniendo el mumero de ODEs por estado. Idioma a utilizar invalido["+idioma+"]");
//    	}
//    	Solo nos importa la fecha hasta como parametro de tiempo imprescindible.
    	if (fechaHasta == null || fechaHasta == null)
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado. Fecha hsata["+fechaHasta==null?null:fechaHasta.toString()+"] vacia.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado. Fecha hsata["+fechaHasta==null?null:fechaHasta.toString()+"] vacia.");
    	}
//    	Recuperamos los estados de la BD en orden del ciclo de vida de un ODE.
    	ArrayList listaEstadosOrdenada = new ArrayList();
    	Hashtable mapaEstadosAcumumlados = new Hashtable();
    	try {
			for (int i = 0; i < SrvPublicacionServiceImpl.SECUENCIA_ESTADOS.length; i++) {
//				Si nos traemos el estadoVO, internacionaliza el texto del estado.
				EstadoVO estado = (EstadoVO)this.getEstadoDao().obtenEstadoPorNombre(this.getEstadoDao().TRANSFORM_ESTADOVO,SrvPublicacionServiceImpl.SECUENCIA_ESTADOS[i]);
				listaEstadosOrdenada.add(estado);
				mapaEstadosAcumumlados.put(estado.getClave(), new Integer(0));  // para cada estado voy inicializando el numero de eltos encontrados
			}
		} catch (RuntimeException e) {
			logger.error("Error obteniendo el mumero de ODEs por estado. Imposible obtener estados de los ODEs.["+e.getCause()+"]");
    		throw new Exception("Error obteniendo el mumero de ODEs por estados. Imposible obtener estados de los ODEs.["+e.getCause()+"]");
		}
    	
//    	Recuperamos la lista de la ultima transicion de cada ODE en la fecha que nos pasan
//    	List listaTransiciones = this.getTransicionDao().obtenerTransicionesFinalesFecha(getTransicionDao().TRANSFORM_TRANSICIONVO, fechaHasta);
		List listaTransiciones = this.getTransicionDao().obtenerTransicionesFinalesFecha(DateManager.dateToCalendar(fechaHasta));
    	Integer numEltosAntes = new Integer(0);
    	int numEltosDespues	= 0;
    	for (Iterator iter = listaTransiciones.iterator(); iter.hasNext();) {
    		Transicion transicion = (Transicion) iter.next();
			numEltosAntes = (Integer)mapaEstadosAcumumlados.get(transicion.getEstadoActual().getNombre()); // cogemos el acumulado para el estado actual    		 
			numEltosDespues = numEltosAntes.intValue() + 1;
			mapaEstadosAcumumlados.put(transicion.getEstadoActual().getNombre(), new Integer(numEltosDespues));
//	    	Antes de acabar, le restamos los publicados, no disponibles y eliminados a los propuestos, ya que al cambiar de propuesto a publicado
//	    	cambia el identificador y tengo el ODE propuesto con el id antiguo (UUID) y publicado o no diponible o eliminado con el id nuevo (MEC)
			if (transicion.getEstadoActual().getNombre().equals(SrvPublicacionServiceImpl.PUBLICADO)
					|| transicion.getEstadoActual().getNombre().equals(SrvPublicacionServiceImpl.NO_DISPONIBLE)
					|| transicion.getEstadoActual().getNombre().equals(SrvPublicacionServiceImpl.ELIMINADO))
			{
				numEltosAntes = (Integer)mapaEstadosAcumumlados.get(SrvPublicacionServiceImpl.PROPUESTO); // cogemos los propuestos    		 
				numEltosDespues = numEltosAntes.intValue() - 1; // le restamos el publicado o no disponible o eliminado
				mapaEstadosAcumumlados.put(SrvPublicacionServiceImpl.PROPUESTO, new Integer(numEltosDespues));
			}
		}
//    	Chequeamos que la cifra de propuestos no sea negativa, esto no deberia ocurrir en un caso normal, pero un informe con un numero de odes
//    	en estado propuesto negativo queda muy mal
    	if (((Integer)mapaEstadosAcumumlados.get(SrvPublicacionServiceImpl.PROPUESTO)).intValue() < 0)
    	{
    		logger.error("Detectado numero de ODEs PROPUESTOS negativos en informe. Dato anomalo para fecha["+fechaHasta.toString()+"]");
    		mapaEstadosAcumumlados.put(SrvPublicacionServiceImpl.PROPUESTO, new Integer(0));
    	}
//		Recorremos el array de estados en orden preparando la salida y los acumulados
    	ODEsEstadoVO[] resultadosEstados = new ODEsEstadoVO[listaEstadosOrdenada.size()];
    	Integer propNdElim = new Integer(0);
    	for (int i = 0; i < listaEstadosOrdenada.size(); i++) {
			ODEsEstadoVO resultado = new ODEsEstadoVO();
			resultado.setEstado(((EstadoVO)listaEstadosOrdenada.get(i)).getNombre());
			resultado.setCantidad(new Long((Integer)mapaEstadosAcumumlados.get(((EstadoVO)listaEstadosOrdenada.get(i)).getClave())));
			resultadosEstados[i]=resultado;
		}
        return resultadosEstados;
    }

	/**
	 * Este metodo devuelve el listado de ODEs que un usuario tiene asociado por estado dentro del ciclo de 
	 * vida definido en el modulo de publicacion.
	 * @param parametroAuditoria Parametro de auditoria con toda la informacion necesaria.
	 * @throws Exception
	 * 
	 */
    protected es.pode.publicacion.negocio.servicios.EstadoActividadVO[] handleOdesPorUsuario(ParametroAuditPublicacionVO parametroAuditoria)
        throws java.lang.Exception
    {
    	if (parametroAuditoria == null)
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. No hay parametros.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuario. No hay parametros.");
    	}
//    	String idioma = parametroAuditoria.getIdioma();
    	Date fechaDesde = (parametroAuditoria.getFechaDesde()!= null?parametroAuditoria.getFechaDesde().getTime():null);
    	Date fechaHasta = (parametroAuditoria.getFechaHasta() != null?parametroAuditoria.getFechaHasta().getTime():null) ;
    	String idUsuario = parametroAuditoria.getIdUsuario();
    	
//    	Chequeamos los datos por higiene
//    	if (idioma == null || idioma.equals(""))
//    	{
//    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. Idioma a utilizar invalido["+idioma+"]");
//    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuario. Idioma a utilizar invalido["+idioma+"]");
//    	}
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuario. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuarios. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
    	if (idUsuario == null || idUsuario.equals(""))
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. Identificador de usuario invalido["+idUsuario+"].");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuarios. Identificador de usuario invalido["+idUsuario+"].");    		
    	}
//    	Tenemos que recorrer los estados en el mismo orden que el ciclo de vida

//    	Recuperamos los estados de la BD en orden del ciclo de vida de un ODE.
    	ArrayList listaEstadosOrdenada = new ArrayList();
    	for (int i = 0; i < SrvPublicacionServiceImpl.SECUENCIA_ESTADOS.length; i++) {
    		listaEstadosOrdenada.add(this.getEstadoDao().obtenEstadoPorNombre(SrvPublicacionServiceImpl.SECUENCIA_ESTADOS[i]));
		}

    	Estado[] estadosEntity = (Estado[])listaEstadosOrdenada.toArray(new Estado[0]);
    	if (estadosEntity == null || estadosEntity.length == 0)
    	{
    		logger.error("Error obteniendo el mumero de ODEs por estado y usuario. Imposible obtener estados de los ODEs.");
    		throw new Exception("Error obteniendo el mumero de ODEs por estado y usuarios. Imposible obtener estados de los ODEs.");
    	}
    	UsuarioActividadCriteria criterioUsuarioActividadDesdeHasta = new UsuarioActividadCriteria();
    	criterioUsuarioActividadDesdeHasta.setFechaDesde(DateManager.dateToCalendar(fechaDesde));
    	criterioUsuarioActividadDesdeHasta.setFechaHasta(DateManager.dateToCalendar(fechaHasta));
    	criterioUsuarioActividadDesdeHasta.setIdUsuario(idUsuario);
    	ArrayList resultadosEstados = new ArrayList(); // lista de resultados del metodo
    	ArrayList listaTransicionesEstado = new ArrayList(); // lista de titulos para cada estado
    	
    	for (int i = 0; i < estadosEntity.length; i++) {
    		criterioUsuarioActividadDesdeHasta.setEstadoActual(estadosEntity[i]);
			List listadoDeResultados = this.getTransicionDao().buscarTransicionesPorCriterioActividad(criterioUsuarioActividadDesdeHasta);
			Transicion[] odes = (Transicion[])listadoDeResultados.toArray(new Transicion[0]);
//			Me he tradido todos los ODES que hay para un estado dado y un usuario. Para cada uno recojo la info
			for (int j = 0; odes!= null && j < odes.length; j++)
			{		
				DetalleTransicionVO detalle = new DetalleTransicionVO();
				detalle.setTitulo(odes[j].getTitulo());
				detalle.setFechaTransicion(odes[j].getFecha());
				listaTransicionesEstado.add(detalle);
			}
//			Para cada estado recopilamos todos los titulos que nos hemos encontrado
			EstadoActividadVO resultado = new EstadoActividadVO();
			resultado.setEstado(((EstadoVO)this.getEstadoDao().obtenEstadoPorNombre(this.getEstadoDao().TRANSFORM_ESTADOVO,estadosEntity[i].getNombre())).getNombre());
			resultado.setDetalleTransicionVOs((DetalleTransicionVO[])listaTransicionesEstado.toArray(new DetalleTransicionVO[0]));
			resultadosEstados.add(resultado);
			listaTransicionesEstado.clear(); // limpiamos los titulos recogidos para la siguiente iteracion
		}
        return (EstadoActividadVO[])resultadosEstados.toArray(new EstadoActividadVO[0]);
    }
    
    
    

    
    /**
	 * Obtiene los n últimos odes publicados. 
	 * Parametro de entrada: entero con el numero de odes que se quieren obtener.
     * Parametro de salida: array de vo con los n últimos odes publicados.
	 * @param numeroOdes Número de odes publicados que se quieren obtener.
	 * @throws Exception
	 * 
	 */
    protected OdePublicadoVO[] handleObtenerUltimosOdesPublicados(int numeroOdes) throws Exception {   	
    	
//    	Evaluamos si el valor de entrada sea correcto
    	if (logger.isDebugEnabled())
    		logger.debug("SrvAuditaPublicacionServiceImpl-- ObtenerUltimosOdesPublicados-- El valor de Numero de odes es ["+numeroOdes+"]");
    	if(numeroOdes <= 0)
    	{
    		//Su valor es incorrecto. Debe de ser estrictamente mayor que cero
    		logger.error("SrvAuditaPublicacionServiceImpl-- ObtenerUltimosOdesPublicados-- numero de odes no tiene un valor estrictamente positivo. ["+numeroOdes+"]");
    		throw new Exception("Error en el parametro de entrada numeroOdes. Su valor no es estrictamente mayor que cero");
    	}
//    	Creamos el criterio de busqueda
    	UltimosOdesPublicadosCriteria criterio = new UltimosOdesPublicadosCriteria();
    		criterio.setMaximumResultSize(new Integer(numeroOdes));      	
    	    	
    	return (OdePublicadoVO[])this.getOdePublicadoDao().buscarUltimosPublicados(this.getOdePublicadoDao().TRANSFORM_ODEPUBLICADOVO,
    														criterio).toArray(new OdePublicadoVO[0]);
	}

    
    /**
	 * Este metodo devuelve el numero de ODEs publicados en la plataforma.
	 * @throws Exception
	 */
	protected ODEsEstadoVO handleOdesPublicados() throws Exception {
		try {
			ODEsEstadoVO numODEs = new ODEsEstadoVO();
			numODEs.setCantidad(this.getOdePublicadoDao().obtenNumODEsPublicados());
//		Traducimos el estado de los ODEs.
			Estado estadoPublicado = this.getEstadoDao().obtenEstadoPorNombre(SrvPublicacionServiceImpl.PUBLICADO);
			numODEs.setEstado(estadoPublicado.getNombre());
			return numODEs;
		} catch (Exception e) {
			logger.error("Error obteniendo el número de ODEs publicados en la plataforma."+ e);
			throw new Exception("Error obteniendo el número de ODEs publicados en la plataforma."+ e);
		}
	}

	/**
	 * Este metodo devuelve el numero de ODEs que hay publicados por idiomas.
	 * @throws Exception
	 */
	protected ODEsEstadoIdiomaVO[] handleOdesPublicadosPorIdioma() throws Exception {
		// Primero extraemos todos los idiomas por los que hay ODEs publicados
		try {
			List listaIdiomas = this.getOdePublicadoDao().obtenIdiomasODEsPublicados();
			if (listaIdiomas == null || listaIdiomas.size() <0 )  // no hay odes cargados
			{
				logger.error("Error obteniendo numero de ODEs publicados por idioma. No hay idiomas de ODEs publicados.");
				throw new Exception("Error obteniendo numero de ODEs publicados por idioma. No hay idiomas de ODEs publicados.");
			}
			
//			Iteramos por la lisa y para cada idioma sacamos el numero de ODEs publicados
			String[] idiomas = (String[])listaIdiomas.toArray(new String[0]);
			ODEsEstadoIdiomaVO[] respuesta=new ODEsEstadoIdiomaVO[idiomas.length];
//			String nombrePubilcadoTraducido = (this.getEstadoDao().obtenEstadoPorNombre(SrvPublicacionServiceImpl.PUBLICADO)).getNombre();
			for (int i = 0; i < idiomas.length; i++) {
				ODEsEstadoIdiomaVO estadoPorIdioma=new ODEsEstadoIdiomaVO();
				estadoPorIdioma.setIdioma(idiomas[i]);
				Long cantidad=null;
//				Para cada idioma tenemos que calcular todos los ODEs que hay publicados. En principio tendria que haber al menos uno de cada
//				ya que los idiomas los hemos sacado de los ODEs publicados.
				cantidad=this.getOdePublicadoDao().obtenNumODEsPublicadosPorIdioma(idiomas[i]);
//				Para rellenar, para cada idioma y cada cifra, ponemos el estado del ODE. En este caso PUBLICADO (traducido)
				estadoPorIdioma.setNumODES(cantidad);
				respuesta[i]=estadoPorIdioma;
			}
			return respuesta;
		} catch (RuntimeException e) {
			logger.error("Error obteniendo el número de ODEs publicados por idioma en la plataforma."+ e);
			throw new Exception("Error obteniendo el número de ODEs publicados por idioma en la plataforma."+ e);
		}
	}
	
}