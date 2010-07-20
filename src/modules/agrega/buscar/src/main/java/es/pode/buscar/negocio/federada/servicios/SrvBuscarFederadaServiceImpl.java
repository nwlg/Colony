/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.federada.servicios;

import org.apache.log4j.Logger;

import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosNodoArbolCurricularVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO;
import es.pode.buscar.negocio.buscar.servicios.SrvBuscarService;
import es.pode.indexador.negocio.servicios.busqueda.DocumentosVO;


/**
 * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService
 */

public class SrvBuscarFederadaServiceImpl
    extends es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceBase
{
	private static final String IDENTIFICADOR_NODO = "server.id";

	/**
	 * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#busquedaFederada(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO)
	 * @param es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO Este VO alberga los parametros que configuran la busqueda avanzada
	 * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosVO Esta clase representa los resultados de una busqueda encontrados en el repositorio de ODE's
	 */
    protected DocumentosVO handleBusquedaFederada(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametros)
        throws java.lang.Exception
    {
    	Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleBusquedaFederada Inicio");
    	SrvBuscarService srvBuscar= this.getSrvBuscarService();
    	DocumentosVO documentos = srvBuscar.busquedaAvanzadaLocal(parametros);
    	Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleBusquedaFederada: Comunidad peticion="+parametros.getComunidadPeticion()+" Resultados devueltos="+documentos.getNumeroResultados()+" Total resultados="+documentos.getTotalResultados());
    	return documentos;
    }

    /**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarFederadaService#buscarAvanzado(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
	 * @param es.pode.buscar.negocio.buscar.servicios.ParametrosNodoArbolCurricularVO Este VO alberga los parametros que configuran la busqueda de documentos a partir de un c�digo de �rea curricular.
	 * @return es.pode.indexador.negocio.servicios.busqueda.DocumentosVO Esta clase representa los resultados de una busqueda encontrados en el repositorio de ODE's
	 */
	protected DocumentosVO handleBuscarDocsNodoArbolCurricular(ParametrosNodoArbolCurricularVO parametros) throws Exception {
		
    	return null;
	}

	/**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarFederadaService#solicitarDocsCountArbolCurricular(es.pode.buscar.negocio.servicios.ParametrosBusquedaAvanzadaVO)
	 * @param es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO Este VO alberga los parametros para la solicitud de n�mero de documentos coincidentes con un �rea curricular
	 * @return es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO Esta clase representa el resultado de la solicitud de n�mero de odes para un �rea curricular
	 */
	protected ResultadosNodoCountVO handleSolicitarDocsCountArbolCurricular(ParametrosDocsCountVO parametros) throws Exception {
		Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleSolicitarDocsCountArbolCurricular Inicio");
    	SrvBuscarService srvBuscar= this.getSrvBuscarService();
    	ResultadosNodoCountVO resultados = srvBuscar.solicitudDocsCountLocal(parametros);
    	return resultados;
	}

	/**
	 * @see es.pode.buscar.negocio.servicios.SrvBuscarFederadaService#estoyActivo()
	 * @return boolean Devuelve true si est� activo el servicio buscar en un nodo
	 */
	protected boolean handleEstoyActivo() throws Exception {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Metodo para obtener el identificador del nodo
	 * @return String
	 * 			El identificador del nodo
	 */
	protected String handleObtenerIdentificadorNodo() throws Exception {
		// TODO Auto-generated method stub
		Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleObtenerIdentificadorNodo Inicio");
		String identificadorNodo = DependentServerProperties.getInstance().getProperty(IDENTIFICADOR_NODO);
		Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleObtenerIdentificadorNodo identificadorNodo="+identificadorNodo);
		return identificadorNodo;
	}

}