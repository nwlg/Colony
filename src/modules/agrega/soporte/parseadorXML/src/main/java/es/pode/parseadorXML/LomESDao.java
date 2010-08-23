/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import net.sf.dozer.util.mapping.MapperIF;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import es.pode.parseadorXML.castor.Lom;


public class LomESDao {

	private MapperIF beanMapper = null;

	public MapperIF getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}
	
	private static Properties props = null;
	
	public String getProperty(String key) throws ParseadorException {
		if(props==null) {
			InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
			props = new Properties();
			try {
				props.load(is);
			} catch (Exception e) {
				throw new ParseadorException(e.getMessage(),e);
			}
		}
		String value = props.getProperty(key);
		return value;
	}

	public es.pode.parseadorXML.castor.Lom parsearLom(InputStream is) throws ParseadorException {
		InputSource isrc = null;
		isrc = new InputSource(is);
		return parsearLom(isrc);
	}
	
	public es.pode.parseadorXML.castor.Lom parsearLom(File file) throws ParseadorException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			return parsearLom(fis);
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		} finally {
			try {
				if(fis!=null) fis.close();
			} catch (Exception e){
				// No hago nada con esta excepcion
			}
		}
		
	}
	
	public es.pode.parseadorXML.castor.Lom parsearLom(Reader is) throws ParseadorException {
		InputSource isrc = null;
		isrc = new InputSource(is);
		return parsearLom(isrc);
	}
	
	public es.pode.parseadorXML.castor.Lom parsearLom(String path) throws ParseadorException {
		File file = new File(path);
		es.pode.parseadorXML.castor.Lom result = null;
		if(file.isFile()) {
			result = parsearLom(file);
		} else {
			throw new ParseadorException("El path " + path + " no apunta a un descriptor de metadato LOM-ES");
		}
		return result;
	}
	
	/**
	 * @param lomfile
	 * @return
	 */
	public es.pode.parseadorXML.castor.Lom parsearLom(InputSource input) throws ParseadorException {
		// Abrir fichero xml para su lectura.
		
		es.pode.parseadorXML.castor.Lom lomCastor = null;

		
		
		try {
			
			// Parsear XML
			Unmarshaller unmarshaller = new Unmarshaller(Lom.class);
			unmarshaller.setValidation(false);
			
			lomCastor = (Lom)unmarshaller.unmarshal(input);
			
			// Cerrar fichero
			
		} catch (MarshalException e) {
			throw new ParseadorException("Error en el parseo del fichero lom-es", e);
		} catch (ValidationException e) {
			throw new ValidacionException(
					"Error de validacion en el parseo del fichero lom-es", e);
		} 
		return lomCastor;
	}

	
	public void escribirLom(es.pode.parseadorXML.castor.Lom lom, File file) throws ParseadorException {
		FileOutputStream fos = null;
		try {
			if(!file.exists()) file.createNewFile();
			else if(file.isDirectory()) {
				throw new ParseadorException("El path " + file.getPath() + " es una carpeta y no puede sobreescribirse como fichero");
			}
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		}
		try {
			fos = new FileOutputStream(file);
			escribirLom(lom, fos);
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		} finally {
			try {
				if(fos!=null) fos.close();
			} catch (Exception e) {
				// no hacer nada
			}
		}
	}
	
	public void escribirLom(es.pode.parseadorXML.castor.Lom lom, String pathMetadato) throws ParseadorException {
		File file = new File(pathMetadato);
		escribirLom(lom, file);
	}
	
	
	public void escribirLom(es.pode.parseadorXML.castor.Lom lom, OutputStream os) throws ParseadorException {
		String encoding = getProperty("default.encoding");
		OutputStreamWriter osw=null;
		try {
			osw = new OutputStreamWriter(os,encoding);
			escribirLom(lom, osw);
		} catch (IOException e) {
			throw new ParseadorException(e.getMessage(),e);
		}finally{
			if(osw!=null){
				try{
					osw.close();
				}catch (Exception e) {
					//error al cerrar el outputStreamWriter 
				}
			}
		}
		
	}
	
	/**
	 * @param lom
	 * @param lomfile
	 */
	public void escribirLom(es.pode.parseadorXML.castor.Lom lom, Writer writer) throws ParseadorException {
		
		try {
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setEncoding(getProperty("default.encoding"));
			
			marshaller.setSchemaLocation("http://ltsc.ieee.org/xsd/LOM lomCustom.xsd");
			marshaller.setSuppressXSIType(true);
			marshaller.setValidation(false);
			marshaller.marshal(lom);
			
		} catch (MarshalException e) {
			throw new ParseadorException(
					"Error de parseo al escribir el lom", e);
		} catch (ValidationException e) {
			throw new ValidacionException(
					"Error de validacion al escribir el lom", e);
		} catch (IOException e) {
			throw new ParseadorException(
					"No se pudo abrir el fichero lom-es para su escritura", e);
		}
		
	}

}
