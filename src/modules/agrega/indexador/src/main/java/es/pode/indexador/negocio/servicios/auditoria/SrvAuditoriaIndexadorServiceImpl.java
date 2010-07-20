/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.indexador.negocio.servicios.auditoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.indexador.negocio.dominio.Indice;
import es.pode.indexador.negocio.servicios.busqueda.DocVO;
import es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO;
import es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService;
import es.pode.soporte.utiles.date.DateManager;


/**
 * @see es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorService
 */

public class SrvAuditoriaIndexadorServiceImpl
    extends es.pode.indexador.negocio.servicios.auditoria.SrvAuditoriaIndexadorServiceBase
{

	private Logger logger = Logger.getLogger(this.getClass());
    
    public static final int NIVELES_AGREGACION = 4; // hay 4 niveles de agregacion. 
    /**
     * Este metodo recibe un recorrido de arbol curricular y devuelve el recubrimiento 
     * del mismo que hacen los elementos que estan indexados en el repositorio.
     * @param parametroAuditoria Parametros del metodo.	 	    	 
     * @return Se devuelve un VO con el numero de documentos indexados totales para cada nodo del recorrido de arbol
     * curricular que se pasa.
     * @throws Exception
     * 
     */
    protected es.pode.indexador.negocio.servicios.auditoria.CoberturaVO[] handleCoberturaArbolCurricular(ParametroAuditIndexadorVO parametroAuditoria)
    throws java.lang.Exception
    {
    	if (parametroAuditoria == null)
    	{
    		logger.error("Error calculando cobertura de arbol curricular. No hay parametros.");
    		throw new Exception("Error calculando cobertura de arbol curricular. No hay parametros.");
    	}
    	Date fechaDesde = parametroAuditoria.getFechaDesde().getTime();
    	Date fechaHasta = parametroAuditoria.getFechaHasta().getTime();
    	String[] idNodos = parametroAuditoria.getIdNodo();
    	
    	if (idNodos == null || idNodos.length == 0)
    	{
    		logger.error("Error calculando cobertura de arbol curricular. No hay nodos en el arbol.");
    		throw new Exception("Error calculando cobertura de arbol curricular. No hay nodos en el arbol.");
    	}
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error calculando cobertura de arbol curricular. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error calculando cobertura de arbol curricular. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error calculando cobertura de arbol curricular. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error calculando cobertura de arbol curricular. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//  	Recogemos todos los idiomas indexados para recorrer todos los indices.
    	String[] idiomas = new String[0];
    	try {
    		idiomas= recuperaIndices();
    	} catch (Exception e) {
    		logger.error("Error calculando cobertura de arbol curricular. Imposible recuperar idiomas de los indices.["+e.getCause()+"]");
    		throw new Exception("Error calculando cobertura de arbol curricular. Imposible recuperar idiomas de los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todos los nodos del arbol y sumar el acumulado.
    	if (idiomas == null || idiomas.length == 0)
    	{
    		logger.error("Error calculando cobertura de arbol curricular. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error calculando cobertura de arbol curricular. No existen indices en el indexador. Imposible continuar.");
    	}
//  	Para cada idioma me voy recorriendo todos los id's y voy calculando todos los odes que hay para ese nodo
    	SrvBuscadorService servicioBusqueda = this.getSrvBuscadorService(); 
//    	Creamos un mapa para albergar las sumas de los documentos encontrados.
    	HashMap mapa = inicializaHash(idNodos, new Integer(0));
    	for (int i = 0; i < idiomas.length; i++) {
    		for (int j = 0; j < idNodos.length; j++) {
    			ResultadosCountVO resultado = servicioBusqueda.busquedaDocsNodoFechaArbolCurricular(idNodos[j], DateManager.dateToCalendar(fechaDesde), DateManager.dateToCalendar(fechaHasta), idiomas[i]);
				// tenemos el resultado de la cuenta de elementos de este nodo para este indice. lo sumamos al acumulado
    			if (resultado != null && resultado.getDocumentosCount()!= null)
    			{
    				Integer valorAnterior = (Integer)mapa.get(idNodos[j]);
    				Integer valorNuevo = new Integer(valorAnterior.intValue() + resultado.getDocumentosCount().intValue());
    				mapa.put(idNodos[j], valorNuevo);
    			}
    		}
    	}
//    	Con todos los nodos repasados, preparamos la salida.
    	CoberturaVO[] resultado = new CoberturaVO[idNodos.length];
    	for (int j = 0; j < idNodos.length; j++) {
    		CoberturaVO cobertura = new CoberturaVO();
    		cobertura.setId(idNodos[j]);
    		cobertura.setNumDoc((Integer)mapa.get(idNodos[j]));
    		resultado[j] = cobertura;
    	}
//  	Devolvemos el array de todos los acumulados
    	return resultado;
    }

    /**
     * Este metodo devuelve el nivel de cobertura de los elementos indexados sobre todas las licencias.
     * @param parametroAuditoria Parametros del metodo.	 	    	 
     * @return Se devuelve un VO con el numero de documentos indexados totales para cada licencia que se pasa.
     * @throws Exception
     * 
     */
	protected CoberturaVO[] handleCoberturaLicencias(ParametroAuditIndexadorVO parametroAuditoria) throws Exception {
	   	
		if (parametroAuditoria == null)
    	{
    		logger.error("Error calculando cobertura de licencias. No hay parametros.");
    		throw new Exception("Error calculando cobertura de licencias. No hay parametros.");
    	}
    	Date fechaDesde = parametroAuditoria.getFechaDesde().getTime();
    	Date fechaHasta = parametroAuditoria.getFechaHasta().getTime();
    	String[] licencias = parametroAuditoria.getIdLicencias();
    	
    	if (licencias == null || licencias.length == 0)
    	{
    		logger.error("Error calculando cobertura de licencias. No hay licencias.");
    		throw new Exception("Error calculando cobertura de licencias. No hay licencias.");
    	}
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error calculando cobertura de licencias. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error calculando cobertura de licencias. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error calculando cobertura de licencias. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error calculando cobertura de licencias. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//  	Recogemos todos los idiomas indexados para recorrer todos los indices.
    	String[] idiomas = new String[0];
    	try {
    		idiomas= recuperaIndices();
    	} catch (Exception e) {
    		logger.error("Error calculando cobertura de licencias. Imposible recuperar idiomas de los indices.["+e.getCause()+"]");
    		throw new Exception("Error calculando cobertura de licencias. Imposible recuperar idiomas de los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todas las licencias y sumar el acumulado.
    	if (idiomas == null || idiomas.length == 0)
    	{
    		logger.error("Error calculando cobertura de licencias. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error calculando cobertura de licencias. No existen indices en el indexador. Imposible continuar.");
    	}
//  	Para cada idioma me voy recorriendo todas las licencias y voy calculando todos los odes que hay para esa licencia
    	SrvBuscadorService servicioBusqueda = this.getSrvBuscadorService(); 
//    	Creamos un mapa para albergar las sumas de los documentos encontrados.
    	HashMap mapa = inicializaHash(licencias, new Integer(0));
    	for (int i = 0; i < idiomas.length; i++) {
    		for (int j = 0; j < licencias.length; j++) {
    			ResultadosCountVO resultado = servicioBusqueda.busquedaDocsLicenciaFecha(licencias[j], DateManager.dateToCalendar(fechaDesde), DateManager.dateToCalendar(fechaHasta), idiomas[i]);
				// tenemos el resultado de la cuenta de elementos de esta licencia para este indice. lo sumamos al acumulado
    			if (resultado != null && resultado.getDocumentosCount()!= null)
    			{
    				Integer valorAnterior = (Integer)mapa.get(licencias[j]);
    				Integer valorNuevo = new Integer(valorAnterior.intValue() + resultado.getDocumentosCount().intValue());
    				mapa.put(licencias[j], valorNuevo);
    			}
    		}
    	}
//    	Con todos los nodos repasados, preparamos la salida.
    	CoberturaVO[] resultado = new CoberturaVO[licencias.length];
    	for (int j = 0; j < licencias.length; j++) {
    		CoberturaVO cobertura = new CoberturaVO();
    		cobertura.setId(licencias[j]);
    		cobertura.setNumDoc((Integer)mapa.get(licencias[j]));
    		resultado[j] = cobertura;
    	}
//  	Devolvemos el array de todos los acumulados
    	return resultado;
	}

    /**
     * Este metodo devuelve el nivel de cobertura que tienen los elementos del indice sobre el nivel de agregacion.
     * @param parametroAuditoria Parametros del metodo.	 	    	 
     * @return Se devuelve un VO con el numero de documentos indexados totales para cada nivel de agregacion.
     * @throws Exception
     * 
     */
	protected CoberturaVO[] handleCoberturaNivelAgregacion(ParametroAuditIndexadorVO parametroAuditoria) throws Exception {
		if (parametroAuditoria == null)
    	{
    		logger.error("Error calculando cobertura de nivel de agregacion. No hay parametros.");
    		throw new Exception("Error calculando cobertura de nivel de agregacion. No hay parametros.");
    	}
    	Date fechaDesde = parametroAuditoria.getFechaDesde().getTime();
    	Date fechaHasta = parametroAuditoria.getFechaHasta().getTime();
    	int nivelesAgregacion = NIVELES_AGREGACION; // el nivel de agregacion va de 1 a 4
    	String[] nivelesAgrega= new String[nivelesAgregacion];
    	for (int i = 0; i< nivelesAgregacion; i++)
    	{
    		nivelesAgrega[i]=""+(i+1);
    	}
    	
    	if (fechaDesde == null || fechaHasta == null)
    	{
    		logger.error("Error calculando cobertura de nivel de agregacion. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    		throw new Exception("Error calculando cobertura de nivel de agregacion. Fechas desde["+fechaDesde==null?null:fechaDesde.toString()+"] y hasta["+fechaHasta==null?null:fechaHasta.toString()+"] vacias.");
    	}
    	if (fechaDesde.after(fechaHasta))
    	{
    		logger.error("Error calculando cobertura de nivel de agregacion. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");
    		throw new Exception("Error calculando cobertura de nivel de agregacion. Fechas desde["+fechaDesde.toString()+"] y hasta["+fechaHasta.toString()+"] incoherentes.");    		
    	}
//  	Recogemos todos los idiomas indexados para recorrer todos los indices.
    	String[] idiomas = new String[0];
    	try {
    		idiomas= recuperaIndices();
    	} catch (Exception e) {
    		logger.error("Error calculando cobertura de nivel de agregacion. Imposible recuperar idiomas de los indices.["+e.getCause()+"]");
    		throw new Exception("Error calculando cobertura de nivel de agregacion. Imposible recuperar idiomas de los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todas las licencias y sumar el acumulado.
    	if (idiomas == null || idiomas.length == 0)
    	{
    		logger.error("Error calculando cobertura de nivel de agregacion. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error calculando cobertura de nivel de agregacion. No existen indices en el indexador. Imposible continuar.");
    	}
//  	Para cada idioma me voy recorriendo todas los niveles de agregacion y voy calculando todos los odes que hay para ese nivel
    	SrvBuscadorService servicioBusqueda = this.getSrvBuscadorService(); 
//    	Creamos un mapa para albergar las sumas de los documentos encontrados.
    	HashMap mapa = inicializaHash(nivelesAgrega, new Integer(0));
    	for (int i = 0; i < idiomas.length; i++) {
    		for (int j = 0; j < nivelesAgrega.length; j++) {
    			ResultadosCountVO resultado = servicioBusqueda.busquedaDocsRangoFechaNivelAgregacion(nivelesAgrega[j], DateManager.dateToCalendar(fechaDesde), DateManager.dateToCalendar(fechaHasta), idiomas[i]);
				// tenemos el resultado de la cuenta de elementos de este nivel de agregacion para este indice. lo sumamos al acumulado
    			if (resultado != null && resultado.getDocumentosCount()!= null)
    			{
    				Integer valorAnterior = (Integer)mapa.get(nivelesAgrega[j]);
    				Integer valorNuevo = new Integer(valorAnterior.intValue() + resultado.getDocumentosCount().intValue());
    				mapa.put(nivelesAgrega[j], valorNuevo);
    			}
    		}
    	}
//    	Con todos los nodos repasados, preparamos la salida.
    	CoberturaVO[] resultado = new CoberturaVO[nivelesAgrega.length];
    	for (int j = 0; j < nivelesAgrega.length; j++) {
    		CoberturaVO cobertura = new CoberturaVO();
    		cobertura.setId(nivelesAgrega[j]);
    		cobertura.setNumDoc((Integer)mapa.get(nivelesAgrega[j]));
    		resultado[j] = cobertura;
    	}
//  	Devolvemos el array de todos los acumulados
    	return resultado;
	}

	/*
     * Este metodo recupera todos los indiomas para los que existen indices en el indexador.
     * */
    private String[] recuperaIndices() throws Exception
    {
    	ArrayList listaIndices = (ArrayList) this.getIndiceDao().loadAll();
		Indice[] indices = (Indice[])listaIndices.toArray(new Indice[0]);
		if (indices == null || indices.length ==0)
		{
			logger.error("Error obteniendo indices de escritura. Tabla vacia.");
			throw new Exception("Error obteniendo indices. Tabla vacia.");
		}
		String[] idiomas = new String[indices.length];
		for (int i = 0; i < indices.length; i++) {
			idiomas[i]= indices[i].getIdentificador();
		}
		return idiomas;
    }
    
    /*
     * Este metodo inicializa un mapa con las claves que le pasan y utilizando el valor de inicializacion que le pasan
     * */
    private HashMap inicializaHash(Object[] claves, Object valorInicial)
    {
    	if (claves == null || claves.length == 0)
    	{
    		logger.warn("Inicializamos mapa con array de claves vacio.");
    		return new HashMap();
    	}
    	HashMap mapa = new HashMap(claves.length);
    	for (int i = 0; i < claves.length; i++) {
			mapa.put(claves[i], valorInicial);
		}
    	return mapa;
    }
    /**
     * Este metodo devuelve las urls de la imagenes de los identificadores de los odes.
     * @param idioma
     * 			El idioma de los odes.
     * @param identificadores
     * 			Los identificadores de los odes	 	    	 
     * @return Se devuelve un array de String con la url pequeña de la imagen.
     * @throws Exception
     * 
     */
    /*
     * Este metodo devuelve las urls de la imagenes de los identificadores de los odes
     * */
	protected String[] handleObtenerURLImagenPequena(String idioma, String[] identificadores) throws Exception {
		if(logger.isDebugEnabled())
		logger.debug("Estamos en obtener URLImagenPequeña con: idioma:["+idioma+" ] y identificadores con logitud:["+identificadores.length);
		String[] urls=new String[identificadores.length];
		SrvBuscadorService servicioBusqueda = this.getSrvBuscadorService(); 
//		Recogemos todos los idiomas indexados para recorrer todos los indices.
    	String[] idiomas = new String[0];
    	try {
    		idiomas= recuperaIndices();
    	} catch (Exception e) {
    		logger.error("Error calculando url imagen pequena. Imposible recuperar idiomas de los indices.["+e.getCause()+"]");
    		throw new Exception("Error calculando url imagen pequena. Imposible recuperar idiomas de los indices.", e);
    	}
//  	Para cada indice, tenemos que hacer un recorrido de todas las licencias y sumar el acumulado.
    	if (idiomas == null || idiomas.length == 0)
    	{
    		logger.error("Error calculando url imagen pequena. No existen indices en el indexador. Imposible continuar.");
    		throw new Exception("Error calculando url imagen pequena. No existen indices en el indexador. Imposible continuar.");
    	}
    	
    	if(idioma!=null && !idioma.equals("")){//Cuando el idioma no es nulo
    		boolean encontrado=false;
        	for(int i=0;i<idiomas.length;i++){
        		if(idiomas[i].equals(idioma)){
        			encontrado=true;
        		}
        	}
    		if(encontrado){
				if(logger.isDebugEnabled())
				logger.debug("Tenemos ["+identificadores.length+"] identificadores para encontrar en el indexador con el idioma ["+idioma);
				for(int i=0;i<identificadores.length;i++){
					String url="";
					try{
						DocVO busqueda = servicioBusqueda.busquedaMEC(identificadores[i], idioma);
		
						if(busqueda!=null){//Está indexado
							String localizador=busqueda.getLocalizadorODE();
							if(logger.isDebugEnabled())
							logger.debug("El localizador que nos devuelve es:["+localizador);
							String urlImagen=busqueda.getImagen();
							if(urlImagen !=null || !urlImagen.equals("")){
								url=urlImagen;
								logger.debug("La url del identificador:["+identificadores[i]+"[es :["+url);
							}else{//No tiene imagen,aunque ODE este indexado
								if(logger.isDebugEnabled())
								logger.debug("Esta indexado, pero no tiene imagen");
								url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
								if(logger.isDebugEnabled())
								logger.debug("La url que devolvemos es:["+url);
							}
						}else{//No está indexado
							if(logger.isDebugEnabled())
							logger.debug("No está indexado");
							url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
							if(logger.isDebugEnabled())
							logger.debug("La url que devolvemos es:["+url);
							
						}
						urls[i]=url;
						
					}catch(Exception e){
						logger.error("Ha saltado una excepcion", e);
						url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
						if(logger.isDebugEnabled())
						logger.debug("La url que devolvemos es:["+url);
						urls[i]=url;
					}
				}
			}else{//Viene un idioma que no es un idioma de indexacion
				logger.error("Ese idioma no es un idioma de indexación");
				for(int i=0;i<identificadores.length;i++){
					String url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
					urls[i]=url;
				}
				
				
				logger.error("Error calculando url imagen pequena. No existen indices con ese idioma en el indexador. Imposible continuar.");
	    		throw new Exception("Error calculando url imagen pequena. No existen indices con ese idioma en el indexador. Imposible continuar.");
				
			}
    	}else{//Si el idioma viene vacío
    		if(logger.isDebugEnabled())
    		logger.debug("El array de identificadores es de:"+identificadores.length+" posiciones");
    		for (int j = 0; j < identificadores.length; j++) {
    			String url="";
    			boolean encontrado=false;
    			for (int i = 0; i < idiomas.length && !encontrado; i++) {
        			DocVO resultado = servicioBusqueda.busquedaMEC(identificadores[j], idiomas[i]);
        			if(logger.isDebugEnabled())
						logger.debug("El identificador"+j+" es:["+identificadores[j]+"y el idioma"+i+":"+idiomas[i]+" Y el resultado que devuelve es:["+resultado);
        			if (resultado != null )
        			{
        				encontrado=true;
        				logger.debug("El resultado que devuelve:["+resultado.getIdentificadorODE());
        				String localizador=resultado.getLocalizadorODE();
						if(logger.isDebugEnabled())
						logger.debug("El localizador que nos devuelve es:["+localizador);
						String urlImagen=resultado.getImagen();
						if(urlImagen !=null || !urlImagen.equals("")){
							url=urlImagen;
							logger.debug("La url del identificador:["+identificadores[j]+"[es :["+url);
						}else{//No tiene imagen,aunque ODE este indexado
							if(logger.isDebugEnabled())
							logger.debug("Esta indexado, pero no tiene imagen");
							url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
							if(logger.isDebugEnabled())
							logger.debug("La url que devolvemos es:["+url);
						}
						urls[j]=url;
        			}
        			
        		}if(!encontrado){//Si no se encuentra en ningún indice, imagen por defecto
        			if(logger.isDebugEnabled())
						logger.debug("No lo hemos encontrado en ningun indice");
						url =  "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO);
						if(logger.isDebugEnabled())
						logger.debug("La url que devolvemos es:["+url);
						urls[j]=url;
        		}
        		
        	}
    	}
		return urls;
	}
}