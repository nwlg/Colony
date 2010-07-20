/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Properties;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.OAIPMHAgrega;

public class OaiPmhDao {
	private static Properties props = null;
	
    public static final int IDENTIFY = 0;
    public static final int LISTMETADATAFORMATS = 1;
    public static final int LISTSETS = 2;
    public static final int GETRECORD = 3;
    public static final int LISTIDENTIFIERS = 4;
    public static final int LISTRECORDS = 5;
    public static final int ERROR = 6;
    
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
	
	//ESCRIBIR OAIPMH CON METADATA EN DUBLIN CORE EN CASO DE SER UN GETRECORD O LISTRECORDS
	
	/**
	 * @param oaipmh
	 * @param oaipmhfile
	 */
	public void escribirOAIPMH_DC(OAIPMHAgrega oaipmh, Writer writer) throws ParseadorException {	
		try {
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setEncoding(getProperty("default.encoding"));
			marshaller.setNamespaceMapping("oai_dc", "http://www.openarchives.org/OAI/2.0/oai_dc/");
			marshaller.setNamespaceMapping("dc", "http://purl.org/dc/elements/1.1/");
			marshaller.setSchemaLocation("http://www.openarchives.org/OAI/2.0/ http://www.openarchives.org/OAI/2.0/OAI-PMH.xsd " +
					"http://www.openarchives.org/OAI/2.0/oai_dc/ http://www.openarchives.org/OAI/2.0/oai_dc.xsd");
			marshaller.setSuppressXSIType(true);
			marshaller.setEncoding(getProperty("default.encoding"));
			marshaller.setValidation(false);
			marshaller.marshal(oaipmh.getOaipmh());
			
		} catch (MarshalException e) {
			throw new ParseadorException(
					"Error de parseo al escribir el oaipmh", e);
		} catch (ValidationException e) {
			throw new ValidacionException(
					"Error de validacion al escribir el oaipmh", e);
		} catch (IOException e) {
			throw new ParseadorException(
					"No se pudo abrir el fichero oaipmh para su escritura", e);
		}
		
	}

	public void escribirOAIPMH_DC(OAIPMHAgrega oaipmh, String file)
	throws ParseadorException {
		File fFile = new File(file);
		escribirOAIPMH_DC(oaipmh, fFile);
	}
	
	public void escribirOAIPMH_DC(OAIPMHAgrega oaipmh, OutputStream out)
	throws ParseadorException {
		String encoding = getProperty("default.encoding");
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out,encoding);
			escribirOAIPMH_DC(oaipmh, osw);
		} catch (UnsupportedEncodingException e) {
			throw new ParseadorException(e.getMessage(),e);
		}
	}
	
	public void escribirOAIPMH_DC(OAIPMHAgrega oaipmh, File file)
	throws ParseadorException {
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
			escribirOAIPMH_DC(oaipmh, fos);
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
	
	//ESCRIBIR GENERICOS
	//Escribe los xml de la respuestas a cualquier tipo request de OAI-PMH (Identify,ListMetadataFormats,ListSets,ListIdentifiers,ListRecords,GetRecord)
	/**
	 * @param oaipmh
	 * @param oaipmhfile
	 */
	public void escribirOAIPMH(OAIPMHAgrega oaipmh, Writer writer, int tipo) throws ParseadorException {	
		try {
			Marshaller marshaller = new Marshaller(writer);
			marshaller.setEncoding(getProperty("default.encoding"));
			String schemas = "http://www.openarchives.org/OAI/2.0/ http://www.openarchives.org/OAI/2.0/OAI-PMH.xsd";
			
			if(tipo == IDENTIFY){
				String nameSpace = getProperty("nameSpaceIdentify");
				String urlNameSpace = getProperty("urlNameSpaceIdentiy");
				marshaller.setNamespaceMapping(nameSpace, urlNameSpace);
				String schemaLocIdentify = getProperty("schemaLocIdentify");
				schemas = schemas + " " + schemaLocIdentify;
			}
			else if (tipo == GETRECORD || tipo == LISTRECORDS){
				String nameSpaceOAIDC = getProperty("nameSpaceOAIDC");
				String urlNameSpaceOAIDC = getProperty("urlNameSpaceOAIDC");
				marshaller.setNamespaceMapping(nameSpaceOAIDC, urlNameSpaceOAIDC);
				String schemaLocOAIDC = getProperty("schemaLocOAIDC");
				schemas = schemas + " " + schemaLocOAIDC;
				String nameSpaceDC = getProperty("nameSpaceDC");
				String urlNameSpaceDC =getProperty("urlNameSpaceDC");
				marshaller.setNamespaceMapping(nameSpaceDC, urlNameSpaceDC);
			}
		
			marshaller.setSchemaLocation(schemas);
			marshaller.setSuppressXSIType(true);
			marshaller.setEncoding(getProperty("default.encoding"));
			marshaller.setValidation(false);
			marshaller.marshal(oaipmh.getOaipmh());
			
		} catch (MarshalException e) {
			throw new ParseadorException(
					"Error de parseo al escribir el oaipmh", e);
		} catch (ValidationException e) {
			throw new ValidacionException(
					"Error de validacion al escribir el oaipmh", e);
		} catch (IOException e) {
			throw new ParseadorException(
					"No se pudo abrir el fichero oaipmh para su escritura", e);
		}
		
	}

	public void escribirOAIPMH(OAIPMHAgrega oaipmh, String file, int tipo)
	throws ParseadorException {
		File fFile = new File(file);
		escribirOAIPMH(oaipmh, fFile, tipo);
	}
	
	public void escribirOAIPMH(OAIPMHAgrega oaipmh, OutputStream out, int tipo)
	throws ParseadorException {
		String encoding = getProperty("default.encoding");
		try {
			OutputStreamWriter osw = new OutputStreamWriter(out,encoding);
			escribirOAIPMH(oaipmh, osw, tipo);
		} catch (UnsupportedEncodingException e) {
			throw new ParseadorException(e.getMessage(),e);
		}
	}
	
	public void escribirOAIPMH(OAIPMHAgrega oaipmh, File file, int tipo)
	throws ParseadorException {
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
			escribirOAIPMH(oaipmh, fos, tipo);
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
	
}
