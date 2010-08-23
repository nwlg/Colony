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
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * @see es.pode.validador.negocio.servicio.SrvValidadorVDEXService
 */
 
public class SrvValidadorVDEXServiceImpl
    extends es.pode.validador.negocio.servicio.SrvValidadorVDEXServiceBase
    implements ErrorHandler
{

	private static Logger logger= Logger.getLogger(SrvValidadorServiceImpl.class);
    private DOMParser mParser;
	private static final String TESAURO= "TES";
	private static final String TAXONOMIA= "TAX";
    
	/**
	 * Validación Tesauro: Esta validación chequea que el fichero esté bien formado y cumpla con lo 
	 * especificado por su corresponiente esquema. 
 	 * el esquema que se utiliza es imsvdex_v1p0_thesaurus.xsd
 	 * 
	 * @param rutaVdex: ruta donde se encuentra el fichero a validar
	 * @return ValidaVdexVO. Contiene el resultado de la validación
	 */
	protected ValidaVdexVO handleObtenerValidacionTesauro(String rutaVdex) throws Exception {
		Boolean resultado = obtenerParseoConEsquemas(rutaVdex, TESAURO);
		ValidaVdexVO valida= new ValidaVdexVO();
		valida.setValido(resultado);
		valida.setTipoVdex(TESAURO);
		return valida;
	}

	/**
	 * Validación Taxonomia: Esta validación chequea que el fichero esté bien formado y cumpla con lo 
	 * especificado por su corresponiente esquema. 
	 * el esquema que se utiliza es imsvdex_v1p0_hierarchical.xsd
	 * 
	 * @param rutaVdex: ruta donde se encuentra el fichero a validar
	 * @return ValidaVdexVO. Contiene el resultado de la validación
	 */
	protected ValidaVdexVO handleObtenerValidacionTaxonomia(String rutaVdex) throws Exception {
		Boolean resultado = obtenerParseoConEsquemas(rutaVdex, TAXONOMIA);
		ValidaVdexVO valida= new ValidaVdexVO();
		valida.setValido(resultado);
		valida.setTipoVdex(TAXONOMIA);
		return valida;
	}

	
	/**
	 * este metodo realiza las tareas necesarias para validar el fichero contra los esquemas correspondientes.
	 * chequea que tipo de vdex es el que quiero validar y selecciona el esquema correspondiente para el mismo.
	 * 
	 * @param rutaVdex: ruta donde se encuentra el fichero a validar
	 * @param tipoVdex: tipo de vdex puede ser uno de los siguientes valores: "tesaruro" o "taxonomia"
	 * @return Boolean. Contiene el resultado de la validación
	 */
    private java.lang.Boolean obtenerParseoConEsquemas(String rutaVDEX,String tipoVdex) throws Exception
    {
    	boolean validadorRes = false;
    	String ficheroProperties = "/validador.properties";
		InputStream is= null;
    	mParser = new DOMParser();
    	
		if (mParser != null)
		 {
		    try
		      {
		    	is= this.getClass().getResourceAsStream(ficheroProperties);
				Properties fproperties = new Properties();
				fproperties.load(is);
				String namespaces="";
				
				if(tipoVdex.equals(TESAURO))
				{
					logger.info("tipo de VDEX es tesauro");
					logger.info("obtengo el nombre del xsd desde el properties");
					String imsvdex_tesauro = fproperties.getProperty("imsvdex_v1p0_thesaurus");
					File fileImsvdex_tesauro=new File(imsvdex_tesauro);
					String sProfile=fileImsvdex_tesauro.getCanonicalPath();
					logger.info("obtengo la ruta completa al xsd");
					String nsProfile="http://www.imsglobal.org/xsd/imsvdex_v1p0";
					StringBuffer sb= new StringBuffer();
					sb.append(nsProfile + " " + sProfile);
					namespaces= sb.toString().replace('\\', '/');
					

				}else if(tipoVdex.equals(TAXONOMIA))
				{
					logger.info("tipo de VDEX es taxonomia");
					logger.info("obtengo el nombre del xsd desde el properties");
					String imsvdex = fproperties.getProperty("imsvdex_v1p0_hierarchical");
					File fileImsvdex=new File(imsvdex);
					logger.info("obtengo la ruta completa al xsd");
					String sProfile=fileImsvdex.getCanonicalPath();
					String nsProfile="http://www.imsglobal.org/xsd/imsvdex_v1p0";
					StringBuffer sb= new StringBuffer();
					sb.append(nsProfile + " " + sProfile);
					namespaces= sb.toString().replace('\\', '/');
				}
				
				
				logger.info("ASC- METODO: obtenerParseoSimple Namespaces: " + namespaces);
				
			     mParser.setFeature("http://xml.org/sax/features/validation", true);
			     mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      
			     mParser.setFeature("http://apache.org/xml/features/validation/schema",true);
			      
			      logger.info("METODO: obtenerParseoConEsquemas!!!! ANTES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      mParser.setFeature("http://apache.org/xml/features/validation/schema/ignore-xsi-type-until-elemdecl", true);
			     
			      logger.info("METODO: obtenerParseoSimple!!!! DESPUES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      logger.info("METODO: obtenerParseoSimple!!!! NAMESPACESFULL -> " + namespaces);
				
			      mParser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", namespaces);
			      /**********/
			      
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
			      mParser.setErrorHandler(this);
			   }
			   catch (SAXException se )
			   {
			      String mensaje = "ERROR SAXException " + se;
			      logger.warn(mensaje);
			      validadorRes=false;
			   }
			   Document docValido = null;
			   String mensaje;
			   
			   
				if ( !rutaVDEX.equals("") )
				{
					try
					{
				 		Object eo= mParser.getProperty("http://apache.org/xml/properties/schema/external-schemaLocation");
						logger.info(" Recupero los namespaces del mParser " + eo.toString());
						mParser.parse(rutaVDEX);
						docValido = mParser.getDocument();
						logger.info("ASC-METODO OBTENERPARSEOSIMPLE!!!!! DESPUES DE PARSEO!!!!!!");
						
						if ( docValido != null )
						{
							validadorRes = true;
						}
					}
					catch ( SAXException se )
					{
						mensaje = "Excepcion SAXException durante el parseo " + se;
						logger.error(mensaje);
						validadorRes=false;
					}
				}
					
		 }
		 return new Boolean(validadorRes);
    }

	public void error(SAXParseException exception) throws SAXException {
		throw exception;
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		throw exception;
		
	}

	public void warning(SAXParseException exception) throws SAXException {
		throw exception;
		
	}

	/**
	 * Este método realiza la validación contra esquemas del fichero indicado por la ruta.
	 * el fichero puede ser tanto una taxonomía como un tesauro, por lo que se realizan 
	 * ambas validaciones devolviendo un value object que indica el resultado de la validación
	 * y el tipo de validación que cumple, permitiendonos así reconocer que tipo de vdex es 
	 * el fichero dado.
	 * 
	 * @param rutaVdex: ruta donde se encuentra el fichero a validar
	 * @return ValidaVdexVO. Contiene el resultado de la validación
	 */
	protected ValidaVdexVO handleObtenerValidacionVdex
		(String rutaVdex)
	throws Exception 
	{
		Boolean resultadoTes = obtenerParseoConEsquemas(rutaVdex, TESAURO);

		Boolean resultadoTax = obtenerParseoConEsquemas(rutaVdex, TAXONOMIA);
		ValidaVdexVO valida= new ValidaVdexVO();
		if(resultadoTes)
		{
			valida.setTipoVdex(TESAURO);
			valida.setValido(resultadoTes);
		}else if(resultadoTax)
		{
			valida.setTipoVdex(TAXONOMIA);
			valida.setValido(resultadoTax);
		}else{
			valida.setValido(new Boolean(false));
			valida.setTipoVdex("");
		}

		return valida;
	}





}