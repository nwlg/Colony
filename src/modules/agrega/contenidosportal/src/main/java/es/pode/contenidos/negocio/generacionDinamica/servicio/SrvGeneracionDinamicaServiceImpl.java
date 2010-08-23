/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.generacionDinamica.servicio;

import java.io.File;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.contenidos.negocio.generacionDinamica.dominio.ContenidoODEImpl;
import es.pode.contenidos.negocio.generacionDinamica.dominio.FechaCriteria;
import es.pode.contenidos.negocio.generacionDinamica.dominio.FechaDiaCriteria;
import es.pode.indexador.negocio.servicios.busqueda.DocVO;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;


/**
 * @see es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService
 */

public class SrvGeneracionDinamicaServiceImpl
    extends es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaServiceBase
{
	private static final Logger logger = Logger.getLogger(SrvGeneracionDinamicaServiceImpl.class);
	private static final String ficheroProp= "/contenidosPortal.properties";
	private static  Properties propiedades;
	private static final String sufijo="_captured.jpg";
	private static final int cero=0;
	private static final int veintitres=23;
	private static final int cincuentaynueve=59;
	private static final int numeroIntentos=59;
		
		public SrvGeneracionDinamicaServiceImpl() throws Exception {
			InputStream fIsSpringProperties = SrvGeneracionDinamicaServiceImpl.class.getResourceAsStream(ficheroProp);
			propiedades = new java.util.Properties();
			propiedades.load(fIsSpringProperties);
	}
		
		
		
		/** Nos devuelve el ODE de la fecha de hoy que se genera automáticamente
		 * 
		 * @return ContenidoODEVO
		 * @throws Exception
		 * */
    protected ContenidoODEVO handleObtenODEDiario(java.util.Date fecha)
        throws java.lang.Exception
    {	 
    	try{
    		FechaCriteria fechaCriteria=new FechaCriteria();
    		Calendar calendario=new GregorianCalendar();
    		calendario.setTime(fecha);
    		GregorianCalendar gregorianoInicio=new GregorianCalendar(calendario.get(Calendar.YEAR),
	   	 			calendario.get(Calendar.MONTH),
	   	 			calendario.get(Calendar.DATE), cero,cero,cero);
	   	 	Date fechaInicio=gregorianoInicio.getTime();//Fecha inicio
	   	 	GregorianCalendar gregorianoFin=new GregorianCalendar(calendario.get(Calendar.YEAR),
	   	 			calendario.get(Calendar.MONTH),
	   	 			calendario.get(Calendar.DATE), veintitres,cincuentaynueve,cincuentaynueve);
	   	 	Date fechaFin=gregorianoFin.getTime();//Fecha fin
	   	 	FechaDiaCriteria fechaCriteriaInicio=new FechaDiaCriteria();
	   	 	FechaDiaCriteria fechaCriteriaFin=new FechaDiaCriteria();
	   	 	fechaCriteriaInicio.setFechaInicio(fechaInicio);//Tenemos que conseguir hacer la select sólo con la fecha, sin tener en cuenta las horas...
	   	 	fechaCriteriaFin.setFechaFin(fechaFin);
	   	 	List contenidos=this.getContenidoODEDao().buscarODEPorCriterioFechaDia(getContenidoODEDao().TRANSFORM_CONTENIDOODEVO,fechaCriteriaInicio,fechaCriteriaFin);
	   	 	
    		/*
	   	 	GregorianCalendar gregoriano=new GregorianCalendar(calendarioHoy.get(Calendar.YEAR),
	   	 		calendarioHoy.get(Calendar.MONTH),
	   	 		calendarioHoy.get(Calendar.DATE), calendarioHoy.get(Calendar.HOUR_OF_DAY), calendarioHoy.get(Calendar.MINUTE), calendarioHoy.get(Calendar.SECOND));
    		Date date=gregoriano.getTime();
    		
    		fechaCriteria.setFecha(date);
    		List contenidos = this.getContenidoODEDao().buscarODEPorCriterioFecha(getContenidoODEDao().TRANSFORM_CONTENIDOODEVO,fechaCriteria);
    		*/
    		ContenidoODEVO contenidoODE=new ContenidoODEVO();
    		boolean encontrado=false;
			if(contenidos!=null && contenidos.size()>0){
				contenidoODE =(ContenidoODEVO)contenidos.get(0);
				if(logger.isDebugEnabled()) logger.debug("Devolviendo ODE con identificador["+contenidoODE.getIdODE()+"] idioma["+contenidoODE.getIdioma()+"] para fechaInicio ["+gregorianoInicio.toString()+"] para fechaFin ["+gregorianoFin.toString());
    		}else{
    			logger.error("No ha devuelto ningún ODE con la fecha["+fecha+"], vamos a ir mirando los días anteriores" );
    			for(int i=0;i<numeroIntentos&&!encontrado;i++){
    				gregorianoInicio.add(Calendar.DATE, -1);
    				fechaInicio=gregorianoInicio.getTime();//Fecha inicio
    				gregorianoFin.add(Calendar.DATE, -1);
    				fechaFin=gregorianoFin.getTime();
    				logger.debug("Vamos a buscar entre las fechas de inicio "+gregorianoInicio+"y fecha final "+gregorianoFin);
    				contenidos=this.getContenidoODEDao().buscarODEPorCriterioFechaDia(getContenidoODEDao().TRANSFORM_CONTENIDOODEVO,fechaCriteriaInicio,fechaCriteriaFin);
    				if(contenidos!=null && contenidos.size()>0){
    					contenidoODE =(ContenidoODEVO)contenidos.get(0);
    					encontrado=true;
    				}
    			}
    			if(!encontrado){
    				logger.debug("No hemos encontrado ningún ode en los 10 días anteriores");
    				return null;
    			}
    		}
	   	 	return contenidoODE;
    	}catch(Exception e){
    		logger.error("No se pudo obtener el ODE diario",e);
    		throw new Exception("No se pudo obtener el ODE diario",e);
    	}
    }

    /** Genera el ODE diario y lo copia en disco; Si existe el ODE de ese día lo modifica.
	 * @throws Exception
	 * */
    protected void handleGeneraODEDiario()
        throws java.lang.Exception
    {
    	try{
    		
			String urlFichero=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PATH_IMAGEN_DINAMICA_DISCO);//Desde el properties
			
//    		ContenidoODEVO contenidoODE=new ContenidoODEVO();
    		DocVO odeDiario = obtenODEDiario();
    		if(odeDiario !=null){
    			
	    		if(logger.isDebugEnabled()) logger.debug("Obtenido ODERandon con identificador["+odeDiario.getIdentificadorODE()+"] idioma["+odeDiario.getIdioma()+"]");
		   	 	String identificador=odeDiario.getIdentificadorODE();
		   	 	String idioma=odeDiario.getIdioma();
		   	 	String urlImagen=odeDiario.getImagen();
	//	   		Modificamos la URL para que coja la imagen grande
		   	 	String[] urlsImagenes=urlImagen.split("\\.");
		   	 	urlImagen=urlsImagenes[0]+ sufijo;
		   	 	String urlLocal=DependentServerProperties.getInstance().getUrlNodo();
		   	 	String url=urlLocal+urlImagen;
	
		   	 	if(logger.isDebugEnabled()) logger.debug("Copiando imagen de url["+url+"] a la localización del disco["+urlFichero+"]");
		   	 	
		   	 	//Guardamos la imagen en memoria.
		    	//Primero borramos lo que había
		    	File ficheroViejo=new File(urlFichero);
		    	UtilesFicheros.eliminar(ficheroViejo);
		    	try {
		    		// Intentamos utilizar la imagen del propio ODE.
					UtilesFicheros.copiarFileFormURI(url, urlFichero);
				} catch (RuntimeException e) {
					//Ha dado error la copia de la imagen, copiamos la imagen por defecto de la plataforma
					logger.warn("Error copiando la imagen desde la url["+url+"] a ["+urlFichero+"]. Utilizamos la imagen por defecto de la plataforma.",e);
					url = urlLocal + "/"+ AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DINAMICA_DEFECTO);
					if(logger.isDebugEnabled()) logger.debug("La URL de la imagen por defecto va a ser en el caso del RuntimeException "+url);
					logger.warn("Error copiando la imagen desde la url["+url+"] por defecto a ["+urlFichero+"] en el error exception. Utilizamos la imagen por defecto de la plataforma.",e);
					UtilesFicheros.copiarFileFormURI(url, urlFichero);
				} catch(Exception e){
					logger.warn("Error copiando la imagen desde la url["+url+"] a ["+urlFichero+"] en el error exception. Utilizamos la imagen por defecto de la plataforma.",e);
					url = urlLocal + "/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DINAMICA_DEFECTO);
					if(logger.isDebugEnabled()) logger.debug("La URL de la imagen por defecto va a ser en el caso del Exception "+url);
					logger.warn("Error copiando la imagen desde la url["+url+"] por defecto a ["+urlFichero+"] en el error exception. Utilizamos la imagen por defecto de la plataforma.",e);
					UtilesFicheros.copiarFileFormURI(url, urlFichero);
				}
		   	 	//Miramos si existe un ODE para este día
				Calendar calendario=Calendar.getInstance();
		   	 	GregorianCalendar gregoriano=new GregorianCalendar(calendario.get(Calendar.YEAR),
		   	 			calendario.get(Calendar.MONTH),
		   	 			calendario.get(Calendar.DATE), calendario.get(Calendar.HOUR_OF_DAY),calendario.get(Calendar.MINUTE),calendario.get(Calendar.SECOND));
		   	 	Date fecha=gregoriano.getTime();//Fecha completa
				
		   	 	GregorianCalendar gregorianoInicio=new GregorianCalendar(calendario.get(Calendar.YEAR),
		   	 			calendario.get(Calendar.MONTH),
		   	 			calendario.get(Calendar.DATE), cero,cero,cero);
		   	 	Date fechaInicio=gregorianoInicio.getTime();//Fecha inicio
		   	 	GregorianCalendar gregorianoFin=new GregorianCalendar(calendario.get(Calendar.YEAR),
		   	 			calendario.get(Calendar.MONTH),
		   	 			calendario.get(Calendar.DATE), veintitres,cincuentaynueve,cincuentaynueve);
		   	 	Date fechaFin=gregorianoFin.getTime();//Fecha fin
		   	 	FechaDiaCriteria fechaCriteriaInicio=new FechaDiaCriteria();
		   	 	FechaDiaCriteria fechaCriteriaFin=new FechaDiaCriteria();
		   	 	fechaCriteriaInicio.setFechaInicio(fechaInicio);//Tenemos que conseguir hacer la select sólo con la fecha, sin tener en cuenta las horas...
		   	 	fechaCriteriaFin.setFechaFin(fechaFin);
		   	 	List odesBaseDatos=this.getContenidoODEDao().buscarODEPorCriterioFechaDia(fechaCriteriaInicio,fechaCriteriaFin);
		   	 	
		   	 	//Si no existe lo creo
		   	 	//	   	 	Lo insertamos en la base de datos
		   	 	if(odesBaseDatos==null || odesBaseDatos.size()==0){
		   	 		this.getContenidoODEDao().create(identificador, idioma, url, fecha);
		   	 	}else{//Si existe lo modifico
		   	 	if(logger.isDebugEnabled()){
			   	 	logger.debug("Existen tantos ODES:["+odesBaseDatos.size()+"con fecha ["+((ContenidoODEImpl)(odesBaseDatos.get(0))).getFecha().toString());
		   	 		logger.debug("Existe ODE para ese día, lo vamos a cambiar por una nueva con hora:["+fecha.toString());
		   	 	}
		   	 		ContenidoODEImpl contenidoBase=(ContenidoODEImpl)odesBaseDatos.get(0);
		   	 		contenidoBase.setIdioma(idioma);
		   	 		contenidoBase.setIdODE(identificador);
		   	 		contenidoBase.setUrlImagen(url);
		   	 		contenidoBase.setFecha(fecha);
		   	 		this.getContenidoODEDao().update(contenidoBase);
		   	 	if(logger.isDebugEnabled())
		   	 		logger.info("Actualizando contenido dinámico para fecha ["+fecha.toString()+"]con ODE con identificador["+identificador+"] idioma ["+idioma+"] url ["+url+"]");
		   	 	}
    		}
	    	
			
    	}catch(Exception e){
    		logger.error("No se pudo generar el ODE diario",e);
    		throw new Exception("No se pudo generar el ODE diario",e);
    		
    	}
      
    }

	/**Método para recoger un ODE con imagen, si en 10 intentos no se encuentra se mete uno por defecto 
	 * @return DocVO
	 * @throws RemoteException
	 * @throws Exception
	 */
	private DocVO obtenODEDiario() throws RemoteException, Exception {
		String reintentos=propiedades.getProperty("maximoReintentos");
		int reintentosInt=Integer.parseInt(reintentos);
		boolean urlImagenLleno=false;
		DocVO odeDiario=null;
		int i =0;
		for (i = 0;	 i < reintentosInt && !urlImagenLleno; i++) {
			odeDiario= this.getSrvBuscadorService().obtenerODERandom();
			if(odeDiario !=null && odeDiario.getImagen()!=null && !odeDiario.getImagen().equals("")){
				urlImagenLleno=true;
				if(logger.isDebugEnabled()) logger.debug("ODE con identificador ["+odeDiario.getIdentificadorODE()+"] tiene imagen, lo hemos encontrado en el intento ["+i+"]");
			}
		}
		if(odeDiario !=null && i==reintentosInt){
			odeDiario.setImagen(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DINAMICA_DEFECTO));//Le metemos la url de una imagen común para que no nos de error al copiarlo
			logger.info("No se ha encontrado ningún ODE con imagen en ["+reintentosInt+"] intentos");
		}
		return odeDiario;
	}

}