/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.validador.negocio.servicio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.pode.parseadorXML.castor.Manifest;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.validador.negocio.dominio.ManifestEntityDaoImpl;
import es.pode.validador.negocio.soporte.XMLErrorHandler;

/**
 * 
 * @see es.pode.validador.negocio.servicio.SrvValidadorService
 */

public class SrvValidadorServiceImpl
    extends es.pode.validador.negocio.servicio.SrvValidadorServiceBase
{
 
	
	private  Logger logger = Logger.getLogger(this.getClass());
	  
    
	/**
	 * Validación Binaria: Este tipo de Validación chequea que el fichero esté bien formado, que todas sus etiquetas sean correctas,
	 * que contenga los datos requeridos por los esquemas establecidos y los contenidos a los que se hace referencia
	 * estén en su ruta correcta 
	 * 
	 * @param rutaManifest: ruta donde se encuentra el fichero a validar
	 * @return ValidaVO. Contiene el resultado de la validación; este objeto esta compuesto de resultadoValidación, 
	 * esValidoManifest y la rutaManifest
	 */
	
	 protected es.pode.validador.negocio.servicio.ValidaVO handleObtenerValidacionBin(java.lang.String rutaManifest)
     throws java.lang.Exception {
		String imsManifest = new StringBuffer(rutaManifest).append("/imsmanifest.xml").toString();
		//cambiamos las barras de directorio
		imsManifest = imsManifest.replace( '\\', '/');
		File fOde= new File(imsManifest);
		ValidaVO valida= new ValidaVO();
		ManifestEntityDaoImpl maniEntity = new ManifestEntityDaoImpl();
		maniEntity.setBaseDirectory(rutaManifest); 
		Boolean resultado =  new Boolean(true);
		Boolean resultadoSimple =  new Boolean(true);
		Boolean resultadoEsquemas =  new Boolean(true);
		Boolean resultadoLomes =  new Boolean(true);
		Boolean resultadoContenido= new Boolean(true);

		InputStream is = null;
    	Properties prop = new Properties();
//	    	Necesitamos el idioma para saber en que idioma tenemos que hacer las traducciones
    	String idioma="es";
	   	if (LdapUserDetailsUtils.estaAutenticado()) { 
	   		idioma = LdapUserDetailsUtils.getIdioma();
	   		if(idioma==null ||idioma.equals("")){
	   			idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	   		}
	   	}else{
	   		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	   	}
    	
		String nombreFich="/erroresValidacion_"+idioma+".properties";
		is = this.getClass().getResourceAsStream(nombreFich);
		prop.load(is);
    	
    	String resultadoValidacion = "";
    	List errores = null;
		if (fOde.exists())
		{			
			try {				
				//PARSEO SIMPLE parseo sin esquemas (ademas elimina metadatos que no sean LOM-ES)
				resultadoSimple = maniEntity.obtenerParseoSimple(imsManifest,"CA");			
	    		errores = maniEntity.getErroresParseo();//ERRORES GENERERADOS EN EL PARSEO SIMPLE. El resto de errores se iran añadiendo a este array	
	    		if(maniEntity.getDocument()!=null){	//El document es null cuando falla parseoSimple y es imposible 
	    											//montar el Document para pasarlo al metodo esNodoCorrecto
	    			
		    		//PARSEO DE TODOS LOS LOMES Se parsean por separado todos los lomes que contenga el manifest
					//se quitan del mDocument todos los lomes y se guardan en una array para parsearlos por separado
					//y hacer el parseo con esquema del manifest sin lomes, solo SCORM	
	    			boolean soloLocation = false;//Esto implica que va recuperar tantos los lomes referenciados mediante location como
												//como los lomes que tenga el manifest
		    		maniEntity.buscarLomes(maniEntity.getDocument(),soloLocation);
	    			//Se parsea los lomes obtenidos anteriormente
//	    			resultadoLomes = maniEntity.validarTodosLomes();
		    		//PARSEO DE MANIFEST SIN LOMES Se parsea el manifest libre metadatos
					resultadoEsquemas = maniEntity.obtenerParseoConEsquemasSinLomes(rutaManifest,"CA");
	    			//CHEQUEO DE CONTENIDOS
					Boolean rootOK = maniEntity.esRootValido(rutaManifest);
					if (rootOK.booleanValue()) {
						maniEntity.crearListaFicherosManifest(rutaManifest);					
						resultadoContenido = maniEntity.chequearContenido(maniEntity.getDocument(), ""); //Chequeo contenidos
					} else {
						// el root no es valido//Error: La etiqueta principal debe ser manifest o lom
						resultado = new Boolean(false);
						errores=insertarErrorParseo(errores,prop.getProperty("1.3"),new Integer(0),new Integer(0));
					}

	    		}
	    		else{//Ha fallado el parseo simple por que el fichero imsmanifest no esta bien formado, 
	    			 //hay alguna etiqueta incorrecta,falta alguna etiqueta,etc...
	    			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
	    		}
	    		
				resultado = Boolean.valueOf(resultadoSimple.booleanValue() && resultadoEsquemas.booleanValue() 
						&& resultadoLomes.booleanValue() && resultadoContenido.booleanValue());
						
				if(!resultadoLomes.booleanValue()){//Error en alguno de los lomes del ODE
					errores=insertarErrorParseo(errores, prop.getProperty("1.5"),new Integer(0),new Integer(0));
				}
				if(!resultadoEsquemas.booleanValue()){//Error Scorm
					errores=insertarErrorParseo(errores, prop.getProperty("1.6"),new Integer(0),new Integer(0));
				}
					
				valida.setEsValidoManifest(new Boolean(resultado.booleanValue()));
				
	 		} catch (Exception e) {
	 			
	 			valida.setEsValidoManifest(new Boolean(false));
	 			//	Error en la Estructura del imsmanifest
	 			logger.error("AOV: Error en el parseo ");
	 			if(errores==null)
	 				errores = new ArrayList();
	 			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
			}
		} else {//Si el fichero imsmanifest.xml del ode no existe en la raiz
			valida.setEsValidoManifest(new Boolean(false));
			//No Existe el ODE.
			errores = insertarErrorParseo(errores, prop.getProperty("1.1"),new Integer(0),new Integer(0));
		}
		
		//ERRORES GENERERADOS EN EL PARSEO SIMPLE Y AQUI
		ErrorParseoVO[] erroresPar=(ErrorParseoVO[])errores.toArray(new ErrorParseoVO[errores.size()]);
		
		for(int i=0;i<erroresPar.length;i++){
			String textoError=erroresPar[i].getMensaje();
			int posicion=textoError.indexOf("*");
			if(posicion>0){
				String inicioMensaje=textoError.substring(0, posicion-1);
				String finMensaje=textoError.substring(posicion+1);
				String traducido=prop.getProperty(inicioMensaje);
				textoError=traducido+finMensaje;
			}	
			int posi = resultadoValidacion.indexOf(textoError);
			//si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
			//de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
			if (posi<0)
				resultadoValidacion = resultadoValidacion + textoError + ";" ;
		}
		
		valida.setResultadoValidacion(resultadoValidacion);
		rellenaErroresParseo(valida, maniEntity);

		return valida;
 }
	 
    /**
	 * Validación Ligera: Este tipo de Validación chequea que el fichero esté bien formado y que todas sus etiquetas sean correctas
	 * 
	 * @param rutaManifest:ruta donde se encuentra el fichero a validar
	 * @param tipoOde: CA(contentAggregation) Si es obligatorio que tenga al menos una organización
	 * 				   RCP(ResourceContentPackage) No puede llevar ninguna organización
	 * @return ValidaVO. Contiene el resultado de la validación; este objeto esta compuesto de resultadoValidación, 
	 * esValidoManifest y la rutaManifest
	 */
	 
	 protected es.pode.validador.negocio.servicio.ValidaVO handleObtenervalidacionLigera(java.lang.String rutaManifest, String tipoOde)
	 throws java.lang.Exception{
				 
		  ValidaVO validavo = new ValidaVO();
		  ManifestEntityDaoImpl manEntity = new ManifestEntityDaoImpl();
		   manEntity.setBaseDirectory(rutaManifest);
		   String imsManifest = new StringBuffer(rutaManifest).append("/imsmanifest.xml").toString();
		   //cambiamos las barras de directorio
		   imsManifest = imsManifest.replace( '\\', '/');
		   validavo.setRutaManifest(imsManifest);
		   
		   Boolean manifestOk = manEntity.buscarManifest(rutaManifest);
		   Boolean resultado= new Boolean(true);
		   Boolean resultadoSimple= new Boolean(true);
		   Boolean resultadoEsquemas = new Boolean(true);
		   Boolean resultadoLomes = new Boolean(true);
		   InputStream is = null;
		   Properties prop = new Properties();
		   //Necesitamos el idioma para saber en que idioma tenemos que hacer las traducciones
		   String idioma="es";
		   if (LdapUserDetailsUtils.estaAutenticado()) { 
			   idioma = LdapUserDetailsUtils.getIdioma();
			   if(idioma==null || idioma.equals("")){
				   idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
			   }
		   }else{
			   idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		   }
	
		   String nombreFich="/erroresValidacion_"+idioma+".properties";
		   is = this.getClass().getResourceAsStream(nombreFich);
		   prop.load(is);	 
	
		   String resultadoValidacion="";
		   List errores = null;
		   if (manifestOk.booleanValue()) {
			   
			   
				 logger.debug("AOV: Parseamos el fichero "+ imsManifest +" mediante castor(parseadorXML)");

				 File fRutaManifest = new File(imsManifest);
				 boolean parseoOK = true;
				 Manifest manifestFile = null;
				 if (fRutaManifest.exists()) {
					 try{
						 manifestFile = this.getScormDao().parsearODEEager(fRutaManifest);
						 logger.debug("AOV: El parseo castor es correcto.");
					 }
					 catch(Exception e){
						 logger.debug("AOV: El parseo castor ha fallado, el ode no es correcto.");
						 parseoOK = false;
					 }
				 }
			   
			   
			   
			   try {
				   //PARSEO SIMPLE parseo sin esquemas (ademas elimina metadatos que no sean LOM-ES)
				   resultadoSimple = manEntity.obtenerParseoSimple(imsManifest,tipoOde);			
				   errores = manEntity.getErroresParseo();//ERRORES GENERERADOS EN EL PARSEO SIMPLE. El resto de errores se iran añadiendo a este array
			
				   if(manEntity.getDocument()!=null){//El document es null cuando falla parseoSimple y es imposible 
						//montar el Document para pasarlo al metodo esNodoCorrecto
					   if(parseoOK){					    
							//PARSEO DE LOS LOMES REFERENCIADOS MEDIANTE LOCATION Se parsean por separado todos los lomes 
							//se guardan en una array para parsearlos por separado
							boolean soloLocation = false;//true;//Esto implica que va recuperar solo los lomes referenciados mediante location
							manEntity.buscarLomes(manEntity.getDocument(),soloLocation);
							//Se parsea los lomes obtenidos anteriormente
								//quitado temporalmente!!!!!
							
							//resultadoLomes = manEntity.validarTodosLomes();
							
							////PARSEO DEL MANIFEST (INCLUIDOS TODOS LOS LOMES) 
							//resultadoEsquemas = manEntity.obtenerParseoConEsquemas(imsManifest,tipoOde);
							
							//////////-------------------------- ATENCION!!!! --------------------------------
							// CAMBIADO POR PROBLEMAS AL IMPORTAR UN ODE CON LOMES INCOMPLETO (CREADO, GUARDADO, VALIDADO BINARIO OK PERO AL IMPORTAR ---->>>>)
							//// VALIDACION LIGERA ERROR PQ SOLO TIENE TITULO, CATALOGO Y METAMETADATA (LOMES-V1.0)
							resultadoEsquemas = manEntity.obtenerParseoConEsquemasSinLomes(imsManifest,tipoOde);
							/////////////// CAMBIO TEMPORAL!!!!
							
					   }else{ 
						   boolean soloLocation = true;
						   manEntity.buscarLomes(manEntity.getDocument(),soloLocation);
						   resultadoLomes = manEntity.validarTodosLomes();
							
						   ////PARSEO DEL MANIFEST (INCLUIDOS TODOS LOS LOMES) 
						   resultadoEsquemas = manEntity.obtenerParseoConEsquemas(imsManifest,tipoOde);
					   }
					}
		    		else{//Ha fallado el parseo simple por que el fichero imsmanifest no esta bien formado, 
		    			 //hay alguna etiqueta incorrecta,falta alguna etiqueta,etc...
		    			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
		    		}
			
				   resultado = Boolean.valueOf(resultadoSimple.booleanValue() && resultadoEsquemas.booleanValue()
						   		&& resultadoLomes.booleanValue());
			
				   List lErroresXerces = manEntity.getErroresXerces();//ERRORES GENERADOS EN EL PARSEO CON ESQUEMAS
				   if(lErroresXerces !=null && lErroresXerces.size()>0){
					   lErroresXerces = this.traduceErroresXerces(lErroresXerces);
					   ErrorParseoVO[] erroresXerces=(ErrorParseoVO[])lErroresXerces.toArray(new ErrorParseoVO[lErroresXerces.size()]);
							
					   for(int i=0;i<erroresXerces.length;i++){
						   String textoError= erroresXerces[i].getMensaje();
						   int posi = resultadoValidacion.indexOf(textoError);
						   //si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
						   //de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
						   if (posi<0)
							   resultadoValidacion = resultadoValidacion + textoError + ";" ;
					   }    
				   }		
			
				   validavo.setEsValidoManifest(resultado);
			
			   } catch (Exception e) {
				   resultado = new Boolean(false);
				   //Error en la Estructura del imsmanifest
				   logger.error("AOV: Error en el parseo ");
				   if(errores==null)
					   errores = new ArrayList();
				   errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));	
			   }
		   }
		   else {//Si el fichero imsmanifest.xml del ode no existe en la raiz
			   resultado = new Boolean(false);
			   errores=insertarErrorParseo(errores,prop.getProperty("1.1"),new Integer(0),new Integer(0));
		   }
	
		   ErrorParseoVO[] erroresPar=(ErrorParseoVO[])errores.toArray(new ErrorParseoVO[errores.size()]);//ERRORES GENERERADOS EN EL PARSEO SIMPLE Y AQUI
	
		   for(int i=0;i<erroresPar.length;i++){
			   String textoError=erroresPar[i].getMensaje();
			   int posicion=textoError.indexOf("*");
			   if(posicion>0){
				   String inicioMensaje=textoError.substring(0, posicion-1);
				   String finMensaje=textoError.substring(posicion+1);
				   String traducido=prop.getProperty(inicioMensaje);
				   textoError=traducido+finMensaje;
			   }	
				int posi = resultadoValidacion.indexOf(textoError);
				//si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
				//de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
				if (posi<0)
					resultadoValidacion = resultadoValidacion + textoError + ";" ;
		   }
	
		   validavo.setResultadoValidacion(resultadoValidacion);
		   rellenaErroresParseo(validavo, manEntity);
		   validavo.setEsValidoManifest(resultado);
	
		   return validavo;
	 }

    /**
	 * Validación CargaOde: Es la Validación más completa; chequea que el fichero esté bien formado, que todas sus etiquetas sean correctas,
	 *  que contenga en sus metadatos al menos un LOM-ES además de chequear que los contenidos referenciados estén en su ubicación correcta 
	 * 
	 * @param rutaManifest:ruta donde se encuentra el fichero a validar
	 * @return ValidaVO. Contiene el resultado de la validación; este objeto esta compuesto de resultadoValidación, 
	 * esValidoManifest y la rutaManifest
	 */
	protected ValidaVO handleValidarCargaOde(String rutaOde) throws Exception {
		String rutaManifest = new StringBuffer(rutaOde).append("/imsmanifest.xml").toString();
//		cambiamos las barras de directorio
		rutaManifest = rutaManifest.replace( '\\', '/');
		File fOde= new File(rutaManifest);
		ValidaVO valida= new ValidaVO();
		ManifestEntityDaoImpl maniEntity = new ManifestEntityDaoImpl();
		maniEntity.setBaseDirectory(rutaOde); 
		Boolean resultado =  new Boolean(true);
		Boolean resultadoSimple =  new Boolean(true);
		Boolean resultadoEsquemas =  new Boolean(true);
		Boolean resultadoLomes =  new Boolean(true);
		Boolean resultadoTieneLomes =  new Boolean(true);
		Boolean resultadoContenido= new Boolean(true);
		InputStream is = null;
    	Properties prop = new Properties();
//    	Necesitamos el idioma para saber en que idioma tenemos que hacer las traducciones
    	String idioma="es";
    	if (LdapUserDetailsUtils.estaAutenticado()) { 
    		idioma = LdapUserDetailsUtils.getIdioma();
    		if(idioma==null ||idioma.equals("")){
    			idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    		}
    	}else{
    		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    	}
    	
		String nombreFich="/erroresValidacion_"+idioma+".properties";
		is = this.getClass().getResourceAsStream(nombreFich);
		prop.load(is);
    	
    	String resultadoValidacion = "";
    	List errores = null;
		if (fOde.exists())
		{			
			try {				
				//PARSEO SIMPLE parseo sin esquemas (ademas elimina metadatos que no sean LOM-ES)
				resultadoSimple = maniEntity.obtenerParseoSimple(rutaManifest,"CA");			
	    		errores = maniEntity.getErroresParseo();//ERRORES GENERERADOS EN EL PARSEO SIMPLE. El resto de errores se iran añadiendo a este array	
	    		if(maniEntity.getDocument()!=null){	//El document es null cuando falla parseoSimple y es imposible 
	    											//montar el Document para pasarlo al metodo esNodoCorrecto
	    			    			
	    			//PARSEO DE LOS LOMES REFERENCIADOS MEDIANTE LOCATION Se parsean por separado todos los lomes 
	    			//se guardan en una array para parsearlos por separado
	    			boolean soloLocation = true;//Esto implica que va recuperar solo los lomes referenciados mediante location
		    		maniEntity.buscarLomes(maniEntity.getDocument(),soloLocation);
	    			//Se parsea los lomes obtenidos anteriormente
	    			resultadoLomes = maniEntity.validarTodosLomes();
	    			//Se comprueba que en el manifest principal existe un lom (tambien si esta referenciado por adlcp:location)
	    			resultadoTieneLomes = maniEntity.tieneLomes(maniEntity.getDocument());
	    			//CHEQUEO DE CONTENIDOS
					Boolean rootOK = maniEntity.esRootValido(rutaOde);
					if (rootOK.booleanValue()) {
						maniEntity.crearListaFicherosManifest(rutaManifest);	
						resultadoContenido = maniEntity.chequearContenido(maniEntity.getDocument(), ""); //Chequeo contenidos
					} else {
						// el root no es valido//Error: La etiqueta principal debe ser manifest o lom
						resultado = new Boolean(false);
						errores=insertarErrorParseo(errores,prop.getProperty("1.3"),new Integer(0),new Integer(0));
					}
		    		//PARSEO DEL MANIFEST (INCLUIDOS TODOS LOS LOMES) 
		    		resultadoEsquemas = maniEntity.obtenerParseoConEsquemas(rutaManifest,"CA");	
	    		}
	    		else{//Ha fallado el parseo simple por que el fichero imsmanifest no esta bien formado, 
	    			 //hay alguna etiqueta incorrecta,falta alguna etiqueta,etc...
	    			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
	    		}
	    			    		
				resultado = Boolean.valueOf(resultadoSimple.booleanValue() && resultadoEsquemas.booleanValue() 
						 && resultadoContenido.booleanValue() && resultadoLomes.booleanValue() 
						 && resultadoTieneLomes.booleanValue());
				
				List lErroresXerces = maniEntity.getErroresXerces();//ERRORES GENERADOS EN EL PARSEO CON ESQUEMAS
				if(lErroresXerces !=null && lErroresXerces.size()>0){
 					lErroresXerces = this.traduceErroresXerces(lErroresXerces);
 					
 					ErrorParseoVO[] erroresXerces=(ErrorParseoVO[])lErroresXerces.toArray(new ErrorParseoVO[lErroresXerces.size()]);
 								
 					for(int i=0;i<erroresXerces.length;i++){
 						String textoError= erroresXerces[i].getMensaje();
 						int posi = resultadoValidacion.indexOf(textoError);
 						//si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
 						//de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
 						if (posi<0)
 							resultadoValidacion = resultadoValidacion + textoError + ";" ;
 					}    
				}		
				
				valida.setEsValidoManifest(resultado);
				
	 		} catch (Exception e) {
	 			
	 			valida.setEsValidoManifest(new Boolean(false));
	 			//	Error en la Estructura del imsmanifest
	 			logger.error("AOV: Error en el parseo ");
	 			if(errores==null)
	 				errores = new ArrayList();
	 			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
			}
		} else {//Si el fichero imsmanifest.xml del ode no existe en la raiz
			valida.setEsValidoManifest(new Boolean(false));
			//No Existe el ODE.
			errores = insertarErrorParseo(errores, prop.getProperty("1.1"),new Integer(0),new Integer(0));
		}
		
		//ERRORES GENERERADOS EN EL PARSEO SIMPLE Y AQUI
		ErrorParseoVO[] erroresPar=(ErrorParseoVO[])errores.toArray(new ErrorParseoVO[errores.size()]);
		
		for(int i=0;i<erroresPar.length;i++){
			String textoError=erroresPar[i].getMensaje();
			int posicion=textoError.indexOf("*");
			if(posicion>0){
				String inicioMensaje=textoError.substring(0, posicion-1);
				String finMensaje=textoError.substring(posicion+1);
				String traducido=prop.getProperty(inicioMensaje);
				textoError=traducido+finMensaje;
			}
			int posi = resultadoValidacion.indexOf(textoError);
			//si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
			//de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
			if (posi<0)
				resultadoValidacion = resultadoValidacion + textoError + ";" ;
		}
		
		valida.setResultadoValidacion(resultadoValidacion);
		rellenaErroresParseo(valida, maniEntity);

		return valida;
	}
	
	
    /**
	 * Validación : Chequea que el fichero esté bien formado, que todas sus etiquetas sean correctas,
	 * además de chequear que los contenidos referenciados estén en su ubicación correcta y que contenga 
	 * en sus metadatos al menos un LOM-ES
	 * 
	 * @param rutaManifest:ruta donde se encuentra el fichero a validar
	 * @return ValidaVO. Contiene el resultado de la validación; este objeto esta compuesto de resultadoValidación, 
	 * esValidoManifest y la rutaManifest
	 */
	protected ValidaVO handleObtenerValidacion(String rutaOde) throws Exception {

		String rutaManifest = new StringBuffer(rutaOde).append("/imsmanifest.xml").toString();
//		cambiamos las barras de directorio
		rutaManifest = rutaManifest.replace( '\\', '/');
		File fOde= new File(rutaManifest);
		ValidaVO valida= new ValidaVO();
		ManifestEntityDaoImpl maniEntity = new ManifestEntityDaoImpl();
		maniEntity.setBaseDirectory(rutaOde); 
		Boolean resultado =  new Boolean(true);
		Boolean resultadoSimple =  new Boolean(true);
		Boolean resultadoEsquemas =  new Boolean(true);
		Boolean resultadoLomes =  new Boolean(true);
		Boolean resultadoContenido= new Boolean(true);
		Boolean resultadoTieneLomes = new Boolean(true);
		InputStream is = null;
    	Properties prop = new Properties();
//    	Necesitamos el idioma para saber en que idioma tenemos que hacer las traducciones
    	String idioma="es";
    	if (LdapUserDetailsUtils.estaAutenticado()) { 
    		idioma = LdapUserDetailsUtils.getIdioma();
    		if(idioma==null ||idioma.equals("")){
    			idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    		}
    	}else{
    		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    	}
    	
		String nombreFich="/erroresValidacion_"+idioma+".properties";
		is = this.getClass().getResourceAsStream(nombreFich);
		prop.load(is);

	logger.info("### MCA: idiom is: " + idioma);

    	
    	String resultadoValidacion = "";
    	List errores = null;
		if (fOde.exists())
		{			
			try {
				//PARSEO SIMPLE parseo sin esquemas (ademas elimina metadatos que no sean LOM-ES)
				resultadoSimple = maniEntity.obtenerParseoSimple(rutaManifest,"CA");
//				ERRORES GENERERADOS EN EL PARSEO SIMPLE. El resto de errores se iran añadiendo a este array
	    		errores = maniEntity.getErroresParseo();
				
	    		if(maniEntity.getDocument()!=null){
					//Se comprueba que en el manifest principal existe un lom (tambien si esta referenciado por adlcp:location)
	    			resultadoTieneLomes = maniEntity.tieneLomes(maniEntity.getDocument());
		    		//PARSEO DE TODOS LOS LOMES Se parsean por separado todos los lomes que contenga el manifest
					//se quitan del mDocument todos los lomes y se guardan en una array para parsearlos por separado
					//y hacer el parseo con esquema del manifest sin lomes, solo SCORM	
	    			boolean soloLocation = false;//Esto implica que va recuperar tantos los lomes referenciados mediante location como
	    										//como los lomes que tenga el manifest	
		    		maniEntity.buscarLomes(maniEntity.getDocument(),soloLocation);
		    		//Una vez que tenemos todos los lomes se parsean uno a uno
		    		resultadoLomes = maniEntity.validarTodosLomes();
		    		
		    		//PARSEO DE MANIFEST SIN LOMES Se parsea el manifest libre metadatos
					resultadoEsquemas = maniEntity.obtenerParseoConEsquemasSinLomes(rutaManifest,"CA");
	    			
					//CHEQUEO DE CONTENIDOS
					Boolean rootOK = maniEntity.esRootValido(rutaOde);
					if (rootOK.booleanValue()) {
						maniEntity.crearListaFicherosManifest(rutaManifest);
						resultadoContenido = maniEntity.chequearContenido(maniEntity.getDocument(), ""); //Chequeo contenidos
					} else {
						// el root no es valido//Error: La etiqueta principal debe ser manifest o lom
						resultado = new Boolean(false);
						errores=insertarErrorParseo(errores,prop.getProperty("1.3"),new Integer(0),new Integer(0));
					}
	    		}
	    		else{//Ha fallado el parseo simple por que el fichero imsmanifest no esta bien formado, 
	    			 //hay alguna etiqueta incorrecta,falta alguna etiqueta,etc...
	    			errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));
	    		}
				
				resultado = Boolean.valueOf(resultadoSimple.booleanValue() && resultadoEsquemas.booleanValue() 
						&& resultadoLomes.booleanValue() && resultadoContenido.booleanValue()
						&& resultadoTieneLomes.booleanValue());;
						
				if(!resultadoLomes.booleanValue()){
					errores=insertarErrorParseo(errores, prop.getProperty("1.5"),new Integer(0),new Integer(0));
				}
				if(!resultadoEsquemas.booleanValue()){
					errores=insertarErrorParseo(errores, prop.getProperty("1.6"),new Integer(0),new Integer(0));
				}
					
				valida.setEsValidoManifest(new Boolean(resultado.booleanValue()));
				
			} catch (Exception e) {
				valida.setEsValidoManifest(new Boolean(false));
				//	Error en la Estructura del imsmanifest
				logger.error("AOV: Error en el parseo: Falla parseoSimple");
				if(errores==null)
					errores = new ArrayList();
				errores=insertarErrorParseo(errores,prop.getProperty("1.2"),new Integer(0),new Integer(0));	
			}

		} else {//Si el fichero imsmanifest.xml del ode no existe en la raiz 
			valida.setEsValidoManifest(new Boolean(false));
			//No Existe el ODE.
			errores = insertarErrorParseo(errores, prop.getProperty("1.1"),new Integer(0),new Integer(0));
		}
		
		//ERRORES GENERERADOS EN EL PARSEO SIMPLE Y AQUI
		ErrorParseoVO[] erroresPar=(ErrorParseoVO[])errores.toArray(new ErrorParseoVO[errores.size()]);
		
		for(int i=0;i<erroresPar.length;i++){
			String textoError=erroresPar[i].getMensaje();
			int posicion=textoError.indexOf("*");
			if(posicion>0){
				String inicioMensaje=textoError.substring(0, posicion-1);
				String finMensaje=textoError.substring(posicion+1);
				String traducido=prop.getProperty(inicioMensaje);
				textoError=traducido+finMensaje;
			}	
			int posi = resultadoValidacion.indexOf(textoError);
			//si posi es -1 no hemos añadido este error entonces lo añadimos, si posi es distinto 
			//de -1 ya hemos añadido este mismo texto por tanto no lo añadimos
			if (posi<0)
				resultadoValidacion = resultadoValidacion + textoError + ";" ;
		}
		
		valida.setResultadoValidacion(resultadoValidacion);
		rellenaErroresParseo(valida, maniEntity);

		return valida;
	
	}
	

	  /**
	 * Validación Metadatos Básicos Obligatorios: Valida exclusivamente que estén rellenos los metadatos básicos obligatorios
	 * 
	 * @param rutaManifest:ruta donde se encuentra el fichero a validar
	 * @return ValidaVO. Contiene el resultado de la validación; este objeto esta compuesto de resultadoValidación, 
	 * esValidoManifest y la rutaManifest
	 */
	protected ValidaVO handleValidarMDBasicosObl(MDBasicosOblVO mDBasicos) throws Exception {
		ValidaVO valida= new ValidaVO();
		valida.setRutaManifest(null);
		
		String resultado= "";
		InputStream is = null;
    	Properties prop = new Properties();
    	String idioma="es";
    	if (LdapUserDetailsUtils.estaAutenticado()) { 
    		idioma = LdapUserDetailsUtils.getIdioma();
    		if(idioma==null ||idioma.equals("")){
    			idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    		}
    	}else{
    		idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    	}
		String nombreFich="/erroresValidacion_"+idioma+".properties";
		is = this.getClass().getResourceAsStream(nombreFich);
		prop.load(is);
		// Estos mensajes hay que pasarlos a un fichero de properties
		if (mDBasicos != null)
		{
			resultado= ((mDBasicos.getTitulo()==null)||(mDBasicos.getTitulo().equals("")))?prop.getProperty("4.2")+";":""; //Titulo es obligatorio\n
		
			resultado = new StringBuffer(resultado)
            .append(((mDBasicos.getIdioma() ==null) ||(mDBasicos.getIdioma().equals(""))) ? prop.getProperty("4.3")+";":"") //Idioma es obligatorio\n
            .append(((mDBasicos.getDescripcion()==null) ||(mDBasicos.getDescripcion().equals(""))) ? prop.getProperty("4.4")+";":"") //Descripción es obligatorio\n
            .append(((mDBasicos.getTipoRecurso() ==null) ||(mDBasicos.getTipoRecurso().equals(""))) ? prop.getProperty("4.5")+";":"") //Tipo es obligatorio\n
            .append(((mDBasicos.getIdiomaDest()==null) ||(mDBasicos.getIdiomaDest().equals(""))) ? prop.getProperty("4.8")+";":"") //El idioma destino es obligatorio\n 
            .toString();
			
			if (!resultado.equals("")) 
			{
				valida.setEsValidoManifest(new Boolean(false));
				String resAux = resultado.substring(0, resultado.length()-1);
				valida.setResultadoValidacion(resAux);
			} else {
				valida.setEsValidoManifest(new Boolean(true));
				valida.setResultadoValidacion(prop.getProperty("0.0"));
				
			}
			
		} else {
			//la entrada es nula
			valida.setEsValidoManifest(new Boolean(false));
			valida.setResultadoValidacion(prop.getProperty("4.1")); //Los datos del form son obligatorios
			
		}
		return valida;
	}


	 /**
	 * Validación MEC: Valida que el MEC cumpla con el patrón establecido; para ello parsea el fichero
	 * y lo recoge de su posición correspondiente
	 * 
	 * @param rutaManifest:ruta donde se encuentra el fichero a validar
	 * @return String: Su retorno es el MEC si este es Válido y null en caso contrario
	 */
	protected String handleValidarMec(String rutaManifest) throws Exception {
//		cambiamos las barras de directorio
		rutaManifest = new StringBuffer(rutaManifest).append("/imsmanifest.xml").toString();
		rutaManifest = rutaManifest.replace( '\\', '/');
		File fOde= new File(rutaManifest);
		Manifest manifest= null;
		boolean mecValido=true;
		String entri=null;
		String salida=null;
		
		if (fOde.exists()){
			try {
				manifest = this.getScormDao().parsearODELazy(fOde);
				if ((manifest.getMetadata().getGrp_any() != null) && 
						 (manifest.getMetadata().getGrp_any().getAnyObject()!=null)){
					//buscamos objetos LOM en groupAny de Metadata
					int longmeta =manifest.getMetadata().getGrp_any().getAnyObject().length;
					for (int indmeta=0; indmeta< longmeta; indmeta++) {
						//es.pode.parseadorXML.scorm2004.Lom lomMeta = (es.pode.parseadorXML.scorm2004.Lom)manifest.getMetadata().getGrp_any().getAnyObject(indmeta);
						Object anyobject= manifest.getMetadata().getGrp_any().getAnyObject(indmeta);
						 if (anyobject instanceof es.pode.parseadorXML.castor.Lom) {
							 es.pode.parseadorXML.castor.Lom lomMeta = (es.pode.parseadorXML.castor.Lom) anyobject;
							 if (lomMeta != null){
								 es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega lomAgrega= new es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega(lomMeta);
								 es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega gen= lomAgrega.getGeneralAgrega();
								 if ((gen != null ) ){
									
//									validamos el mec
									
										 int nid = gen.getCountIdentifier();
										 if(nid>0){
											 String catalogo = gen.getCatalogo(0)!=null?gen.getCatalogo(0):"" ;
											 entri = gen.getEntry(0)!=null?gen.getEntry(0):"";
											 if ((!catalogo.equals("")) && (!entri.equals(""))) {
												 //miramos que el entry sea valido debe ser de la forma
												 //es-ex_20061017_2_1234567 siendo -ex opcional
												 Pattern mask=Pattern.compile("^([a-z]{2})(\\-[a-z][a-z])?\\_((?:19|20)\\d\\d)(?:0\\d|1[0-2])(3[01]|[012]\\d)\\_([0-9]{1})\\_([0-9]{7}$)"); //ejm ee-zz
												 Matcher matcher = mask.matcher(entri);
												 mecValido = mecValido && matcher.matches(); //true--> ok el matches
												
											 } else {
												 mecValido = mecValido && false;
											 }
										 }
									
									 ///// fin valida mec
										 if(mecValido){
											 salida=entri;
										 }else
											 salida=null;
										 
								 }
									 
							}
							
						 }
					}
				}
			}catch (Exception e) { 
				logger.error(e);
//	    		throw e;
			}

		}
		return salida;
	}


	protected boolean handleEstoyActivo() throws Exception {
		
		return true;
	}

	  /**
	 * Validación Metadatos Lomes: Valida que el metadato sea un metadato LOM-ES, que esté bien formado
	 * y que todas sus etiquetas sean correctas
	 * 
	 * @param dh:contiene los metadatos LOM-ES que queremos validar
	 * @return Boolean. Resultado de la validación
	 */
	protected Boolean handleObtenerValidacionLomes(
			DataHandler dh)
	throws Exception 
	{
    	boolean validadorRes = true;
    	String ficheroProperties = "/validador.properties";
		InputStream is= null;
		logger.info("ASC- METODO: obtenerValidacionLomes!!!! ");
    	DOMParser mParser = new DOMParser();
    	
		if (mParser != null)
		 {
		    try
		      {
		    	if( logger.isDebugEnabled() )
		    		logger.debug( "URL del parseador: " + mParser.getClass().getResource( mParser.getClass().getName().replace('.','/') + ".class") );
		    	
		    	is= this.getClass().getResourceAsStream(ficheroProperties);
				Properties fproperties = new Properties();
				fproperties.load(is);
				String lomCustom = fproperties.getProperty("lomCustom");
				
				File fileLomCustom=new File(lomCustom);
				String sLomCustom=fileLomCustom.getCanonicalPath();
				
				logger.info("ASC- METODO: obtenerValidacionLomes Namespaces: " + sLomCustom + "; ");
				
			     mParser.setFeature("http://xml.org/sax/features/validation", true);
			     mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      
//			      estas "feature" son para la validación del manifest contra los esquemas
			      mParser.setFeature("http://apache.org/xml/features/validation/schema",true);
			      
			      logger.info("METODO: obtenerValidacionLomes!!!! ANTES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      mParser.setFeature("http://apache.org/xml/features/validation/schema/ignore-xsi-type-until-elemdecl", true);
			     
			      logger.info("METODO: obtenerValidacionLomes!!!! DESPUES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      String namespacesFull = " http://ltsc.ieee.org/xsd/LOM "+ sLomCustom;
			      logger.info("METODO: obtenerValidacionLomes!!!! NAMESPACESFULL -> " + namespacesFull.replace( '\\', '/'));
				
			      mParser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", namespacesFull);
			      
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
			      mParser.setErrorHandler(new XMLErrorHandler());
			   }
			   catch (SAXException se )
			   {
			      String mensaje = "ERROR SAXException " + se;
			      logger.warn(mensaje);
			      validadorRes=false;
			   }
			   
			   try{
				   InputSource istr= new InputSource(dh.getInputStream());
				   mParser.parse(istr);
			   }catch ( SAXException se )
				{
					String mensaje = "Excepcion SAXException durante el parseo " + se;
					logger.error(mensaje);
					validadorRes=false;
				}
		 }
    	
		 return new Boolean(validadorRes);
    
	}
	
	private List insertarErrorParseo(List errores,String mensaje, Integer linea, Integer columna){
		if(errores ==null){
			errores = new ArrayList();
		}
		ErrorParseoVO error = new ErrorParseoVO();
		error.setMensaje(mensaje);
		error.setLinea(linea);
		error.setColumna(columna);
		errores.add(error);
		return errores;
	}
	
	private void rellenaErroresParseo(ValidaVO validavo, ManifestEntityDaoImpl manEntity) {
		if(manEntity.getErroresParseo()!=null) {
			validavo.setErrores((ErrorParseoVO[])manEntity.getErroresXerces().toArray(new ErrorParseoVO[manEntity.getErroresXerces().size()]));
		} else validavo.setErrores(new ErrorParseoVO[0]);
	}
	
	private List traduceErroresXerces(List erroresXerces) throws Exception{
		List erroresTraducido = new ArrayList();
		
	   InputStream is = null;
	   Properties prop = new Properties();
	   //Necesitamos el idioma para saber en que idioma tenemos que hacer las traducciones
	   String idioma="es";
	   if (LdapUserDetailsUtils.estaAutenticado()) { 
		   idioma = LdapUserDetailsUtils.getIdioma();
		   if(idioma==null || idioma.equals("")){
			   idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
		   }
	   }else{
		   idioma=I18n.getInstance().obtenerIdiomaDefectoPlataforma();
	   }

	   String nombreFich="/erroresValidacion_"+idioma+".properties";
	   is = this.getClass().getResourceAsStream(nombreFich);
	   try {
		   prop.load(is);

			if(erroresXerces!=null){
				for(int i=0;i<erroresXerces.size();i++){
					ErrorParseoVO error =  (ErrorParseoVO) erroresXerces.get(i);
					String mensaje = error.getMensaje();
					String fichero = mensaje.substring(mensaje.lastIndexOf(";")+1);
					mensaje = mensaje.substring(0, mensaje.lastIndexOf(";"));
					
					if(mensaje.endsWith("is expected.")){
						//Invalid content was found starting with element 'lomes:language'. One of '{"http://ltsc.ieee.org/xsd/LOM":identifier, "http://ltsc.ieee.org/xsd/LOM":title}' is expected.
						int inicio = mensaje.indexOf("{");
						int fin = mensaje.indexOf("}");
						String texto = mensaje.substring(inicio+1, fin);
						String[] aux = texto.split(",");
						String etiquetas="";
						for(int j=0;j<aux.length;j++){
							String[] aux2 = aux[j].split(":");
							if (etiquetas.equals(""))
								etiquetas = aux2[aux2.length-1];
							else etiquetas = etiquetas + ", " + aux2[aux2.length-1];
						}
						
						
						String traduccion = prop.getProperty("esperabaEtiquetas")+": '" + etiquetas + "'. "+ prop.getProperty("fichero")
											+": '" + fichero + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("must appear on element")>0){
						//Attribute 'identifier' must appear on element 'resource'.
						int x = mensaje.indexOf("'");
						mensaje = mensaje.substring(x,mensaje.length()-1);
						String[] valores= mensaje.split("must appear on element");
						String traduccion = prop.getProperty("faltaAtributo")+": " + valores[1].trim() + ". " + prop.getProperty("esperabaAtributo")+ ": "
											+ valores[0] + ". "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("is not a valid value of union type")>0){
						//'fia0l' is not a valid value of union type 'status'.
						int x = mensaje.indexOf("'");
						mensaje = mensaje.substring(x,mensaje.length()-1);
						String[] valores= mensaje.split("is not a valid value of union type");
						String traduccion = prop.getProperty("valorNoValido")+": " + valores[1].trim() + ". "+ prop.getProperty("valorInc")
											+ ": " + valores[0].trim() + ". "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("must be terminated by the matching end-tag")>0){
						//The element type "schema" must be terminated by the matching end-tag "</schema>"
						int x = mensaje.indexOf("\"");
						mensaje = mensaje.substring(x,mensaje.length()-1);
						String[] valores= mensaje.split("must be terminated by the matching end-tag");
						String traduccion = prop.getProperty("etiquetaMal") + ": '" + valores[0] 
						                    + "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("is not facet-valid with respect to pattern")>0){
						//Value 'dfjañlskf' is not facet-valid with respect to pattern '([a-zA-Z]{1,8})(-[a-zA-Z0-9]{1,8})*' for type 'language'.
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("valorExpresion") + ": '" + valores[3] + "'. "+prop.getProperty("valorInc")+": '" + valores[1] 
											+ "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("is not valid with respect to its type")>0 && mensaje.indexOf("on element")>0 
							&& mensaje.indexOf("of attribute")>0){
						//The value 'dfjañlskf' of attribute 'language' on element 'lomes:string' is not valid with respect to its type, 'language'.
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("errorElemento")+": '" + valores[5] + "'. "+ prop.getProperty("valorAtributo")+": '"+ valores[3]
						                    +"'. "+prop.getProperty("valorInc")+": '" + valores[1] + "'. "+ prop.getProperty("fichero")+": '" + fichero 
						                    + "'. "+ prop.getProperty("linea")+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.indexOf("for element")>0 && mensaje.indexOf("is not bound")>0){
						//The prefix "loes" for element "loes:lom" is not bound			
						String[] valores= mensaje.split("\"");
						String traduccion = prop.getProperty("errorElemento")+": '" + valores[3] + "'. " + prop.getProperty("prefijo")+ ": '"
											+ valores[1]+ "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")
											+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.indexOf("Cannot find the declaration of element")>0 
							|| mensaje.indexOf("The matching wildcard is strict, but no declaration can be found for element")>0){
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("nameSpace")+ ": '" + valores[1]
											+ "'. "+ prop.getProperty("fichero")+": '" + fichero + "'";
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.indexOf("There is no ID/IDREF binding for IDREF")>0){//NUEVO
						//There is no ID/IDREF binding for IDREF 'EP18'
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("idIncorrecto") + ": '" + valores[1]
						                    + "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")
						         			+": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.indexOf("There are multiple occurrences of ID value")>0){//NUEVO
						//There are multiple occurrences of ID value 'ORG-C4406F5C268B1F88D0586FA62ADDEC65'
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("valorIdRepetido")+": '" + valores[1]
						                    + "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")
						                    +": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.startsWith("The prefix") && mensaje.indexOf("for attribute")>0//NUEVO
							&& mensaje.indexOf("associated with an element type")>0 && mensaje.endsWith("is not bound.")){
						//The prefix "adlp" for attribute "adlp:scormType" associated with an element type "resource" is not bound.			
						String[] valores= mensaje.split("\"");
						String traduccion = prop.getProperty("errorElemento")+": '" + valores[5] + "'. "+ prop.getProperty("valorAtributo")+": '"+ valores[3]
						                    + "'. " + prop.getProperty("prefijo")+ ": '"+ valores[1]
						                    + "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")
						                    +": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if(mensaje.indexOf("is not allowed to appear in element")>0 ){//NUEVO
						//Attribute 'scormType' is not allowed to appear in element 'resource'.	¿¿¿???	
						String[] valores= mensaje.split("'");
						String traduccion = prop.getProperty("errorElemento")+": '" + valores[3] + "'. "+ prop.getProperty("atributoNoPermitido") +": '"+ valores[1]
						                    + "'. "+ prop.getProperty("fichero")+": '" + fichero + "'. "+ prop.getProperty("linea")
						                    +": " + error.getLinea();
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
					else if (mensaje.indexOf("must have no element [children], and the value must be valid.")>0
							|| mensaje.indexOf("is not a valid value for")>0
							|| mensaje.indexOf("is not allowed to appear in element")>0//creo que deberiamos mostrar el error
							|| mensaje.indexOf("is not facet-valid with respect to enumeration")>0){
						
					}
					else{
						String traduccion = prop.getProperty("errorLinea")+": " + error.getLinea() + ". "+ prop.getProperty("fichero")+": '" + fichero + "'. ";
						insertarErrorParseo(erroresTraducido,traduccion,error.getLinea(),error.getColumna());
					}
				}
			}
	   } catch (IOException e) {

		   String mensaje = "ERROR en la traducción de errores Xerces " + e;
		   logger.error(mensaje);
	   }
	   return erroresTraducido;
	}	
	
}
