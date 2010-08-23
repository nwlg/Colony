/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.OaiPmhDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.oai_dc.Dc;
import es.pode.parseadorXML.oai_dc.DcCreator;
import es.pode.parseadorXML.oai_dc.DcSubject;
import es.pode.parseadorXML.oai_dc.DcTitle;
import es.pode.parseadorXML.oai_dc.Oai_dcTypeItem;
import es.pode.parseadorXML.oai_pmh.*;
import es.pode.parseadorXML.oai_pmh.Error;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.ListRecordsAgrega;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.OAIPMHAgrega;
import es.pode.parseadorXML.oai_pmh.oai_pmhAgrega.RecordAgrega;
import es.pode.parseadorXML.oai_pmh.types.DeletedRecordType;
import es.pode.parseadorXML.oai_pmh.types.GranularityType;
import es.pode.parseadorXML.oai_pmh.types.OAIPMHerrorcodeType;
import es.pode.parseadorXML.oai_pmh.types.ProtocolVersionType;
import es.pode.parseadorXML.oai_pmh.types.VerbType;
import es.pode.parseadorXML.oai_pmh_id.OaiIdentifier;
import junit.framework.TestCase;

public class OaiPmhDaoTest extends TestCase {
	private OaiPmhDao dao = null;

	private Properties properties = null;

	private Logger logger = Logger.getLogger(this.getClass());
	
	public OaiPmhDaoTest(){
		super();
		try {
			dao= new OaiPmhDao();
			
			this.properties = new Properties();
			InputStream is = this.getClass().getResourceAsStream(
					"/parseadorXML.properties");
			properties.load(is);
		} catch (IOException e) {
			logger.error("No se pudo abrir el fichero de propiedades; ", e);
		} catch (Exception e) {
			logger.error("Error en el constructor del test: ", e);
			fail("Error en la construccion del test : " + e.getMessage());
		}
	}
	
	protected void setUp() throws Exception {
		super.setUp();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testEscribirIdentify() {
		
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
	//	oaipmh.setOaipmh(new OAIPMH());
	//	oaipmh.getOaipmh().setOAIPMHtypeChoice(new OAIPMHtypeChoice());
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.IDENTIFY);
		oaipmh.setRequest(request);
		Identify identify = new Identify();
		identify.setRepositoryName("Universität Stuttgart, Fakultät 5, Germany, Computer Science Archive");
		identify.setBaseURL("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		identify.setProtocolVersion(ProtocolVersionType.VALUE_0);
		identify.addAdminEmail("reportadm@informatik.uni-stuttgart.de");
		identify.setEarliestDatestamp("2000-11-10T10:11:00Z");
		identify.setDeletedRecord(DeletedRecordType.TRANSIENT);
		identify.setGranularity(GranularityType.YYYY_MM_DDTHH_MM_SSZ);
		Description desc = new Description();
		desc.setAnyObject("Prueba");
		identify.addDescription(desc);
		
		oaipmh.setIdentify(identify);		
	
		try {
			//descripcion no es un oai-identifier
			dao.escribirOAIPMH(oaipmh,"D:/pruebaIdentify.xml", OaiPmhDao.IDENTIFY);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}
	
	public void testEscribirGetRecord() {
		
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.GETRECORD);
		oaipmh.setRequest(request);
		
		RecordAgrega record = new RecordAgrega();
		//CABECERA
		RecordTypeHeader header = new RecordTypeHeader();
		header.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-02");
		header.setDatestamp("2000-11-10T10:11:00Z");
		record.setHeader(header);
		
		//METADATOS EN DUBLIN CORE
		Dc dublinCore = new Dc();
		Oai_dcTypeItem item = new Oai_dcTypeItem();
		Oai_dcTypeItem item2 = new Oai_dcTypeItem();
		DcTitle titulo =new DcTitle();
		titulo.setContent("Grassmann's space analysis");
		titulo.setLang("en");
		
		DcCreator creador = new DcCreator();
		creador.setContent("Hyde, E. W. (Edward Wyllys)");
		
		DcSubject subject = new DcSubject();
		subject.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H99");
		
		item.setDcTitle(titulo);
		item.setDcCreator(creador);
		item.setDcSubject(subject);
		
		
		DcTitle titulo2 =new DcTitle();
		titulo2.setContent("Grassmann");
		titulo2.setLang("en");
		
		DcCreator creador2 = new DcCreator();
		creador2.setContent("Hyde");
		
		DcSubject subject2 = new DcSubject();
		subject2.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H95");
		
		item2.setDcTitle(titulo2);
		item2.setDcCreator(creador2);
		item2.setDcSubject(subject2);
		
		
		dublinCore.addOai_dcTypeItem(item);
		dublinCore.addOai_dcTypeItem(item2);
	
		record.setMetadata(dublinCore);
		
		//ABOUT
		About about = new About();
		about.setAnyObject("Prueba");
		record.setAbout(about,0);
		record.addAbout(3,about);
		record.setAbout(about, 3);
		About about2 = new About();
		about2.setAnyObject("Prueba about");
		record.setAbout(about2, 1);
		record.addAbout(2,about2);
		oaipmh.setGetRecord(record);
		
		oaipmh.getGetRecord();
	
		try {
			dao.escribirOAIPMH_DC(oaipmh,"D:/pruebaGetRecord.xml");
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}
	
	
	public void testEscribirListRecords() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.LISTRECORDS);
		oaipmh.setRequest(request);
		
		ListRecordsAgrega listRecordsAgrega = new ListRecordsAgrega();
		RecordAgrega[] aRecord = new RecordAgrega[2];
		///////RECORD 1/////////
		RecordAgrega record = new RecordAgrega();
		//CABECERA
		RecordTypeHeader header = new RecordTypeHeader();
		header.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-02");
		header.setDatestamp("2000-11-10T10:11:00Z");
		record.setHeader(header);
		
		//METADATOS EN DUBLIN CORE
		Dc dublinCore = new Dc();
		Oai_dcTypeItem item = new Oai_dcTypeItem();
		DcTitle titulo =new DcTitle();
		titulo.setContent("Prueba");
		titulo.setLang("es");
		item.setDcTitle(titulo);
		dublinCore.addOai_dcTypeItem(item);
		record.setMetadata(dublinCore);
		
		//ABOUT
		About about = new About();
		about.setAnyObject("Prueba about");
		About[] aboutArray = {about};
		record.setAbout(aboutArray);
		
		
		///////RECORD 2/////////
		RecordAgrega record2 = new RecordAgrega();
		//CABECERA
		RecordTypeHeader header2 = new RecordTypeHeader();
		header2.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-02");
		header2.setDatestamp("2000-11-10T10:11:00Z");
		record2.setHeader(header2);
		
		//METADATOS EN DUBLIN CORE
		Dc dublinCore2 = new Dc();
		Oai_dcTypeItem item2 = new Oai_dcTypeItem();
		DcTitle titulo2 =new DcTitle();
		titulo2.setContent("Prueba");
		titulo2.setLang("es");
		item2.setDcTitle(titulo2);
		dublinCore2.addOai_dcTypeItem(item2);
		record2.setMetadata(dublinCore2);
		
		//ABOUT
		About about2 = new About();
		about2.setAnyObject("Prueba about");
		About[] aboutArray2 = {about2};
		record2.setAbout(aboutArray2);
		
	
		aRecord[0]=record;
		aRecord[1]=record2;
		
		listRecordsAgrega.setRecord(aRecord);
		
		ListRecordsTypeResumptionToken resum = new ListRecordsTypeResumptionToken();
		resum.setCompleteListSize(4);
		resum.setContent("12353242");
		resum.setCursor(0);
		resum.setExpirationDate(new Date());
		listRecordsAgrega.setResumptionToken(resum);
		
		oaipmh.setListRecords(listRecordsAgrega);
				
	
		try {
			dao.escribirOAIPMH_DC(oaipmh,"D:/pruebaListRecords.xml");
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}

	public void testEscribirListIdentifiers() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.GETRECORD);
		oaipmh.setRequest(request);
		
		ListIdentifiers listIdentifiers = new ListIdentifiers();
	
		//CABECERA
		ListIdentifiersTypeHeader header = new ListIdentifiersTypeHeader();
		header.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-02");
		header.setDatestamp("2000-08-10T10:11:00Z");
		
		listIdentifiers.addListIdentifiersTypeHeader(header);
	
		//CABECERA
		ListIdentifiersTypeHeader header2 = new ListIdentifiersTypeHeader();
		header2.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-03");
		header2.setDatestamp("2000-11-10T10:11:00Z");
		
		listIdentifiers.addListIdentifiersTypeHeader(header2);
		
		//CABECERA
		ListIdentifiersTypeHeader header3 = new ListIdentifiersTypeHeader();
		header3.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-04");
		header3.setDatestamp("2000-02-10T10:11:00Z");
		
		listIdentifiers.addListIdentifiersTypeHeader(header3);
		
		oaipmh.setListIdentifiers(listIdentifiers);
		
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebaListIdentifiers.xml",OaiPmhDao.LISTIDENTIFIERS);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}


	public void testEscribirListSets() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.LISTSETS);
		oaipmh.setRequest(request);
		
		ListSets listSets= new ListSets();
	
		//CABECERA
		Set set = new Set();
		set.setSetName("Computer Science: Practical Course, Presentation, Seminar Paper, Lecture Script");
		set.setSetSpec("cs:05");	
		listSets.addSet(set);
	
		//CABECERA
		Set set2 = new Set();
		set2.setSetName("Computer Science: Practical Course, Presentation, Seminar Paper, Lecture Script");
		set2.setSetSpec("cs:05");	
		listSets.addSet(set2);
		
	
		//CABECERA
		Set set3 = new Set();
		set3.setSetName("Computer Science: Practical Course, Presentation, Seminar Paper, Lecture Script");
		set3.setSetSpec("cs:05");	
		listSets.addSet(set3);
		
		oaipmh.setListSets(listSets);
		
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebaListSets.xml",OaiPmhDao.LISTSETS);
		} catch (ParseadorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error(e1);
		}
	}

	public void testEscribirListMetadataFormats() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.GETRECORD);
		oaipmh.setRequest(request);
		
		ListMetadataFormats listMetadataFormats= new ListMetadataFormats();
		
		MetadataFormat meta = new MetadataFormat();
		meta.setMetadataPrefix("oai_dc");
		meta.setSchema("http://www.openarchives.org/OAI/2.0/dc.xsd");
		meta.setMetadataNamespace("http://purl.org/dc/elements/1.1/");
		
		listMetadataFormats.addMetadataFormat(meta);
		
		MetadataFormat meta2 = new MetadataFormat();
		meta2.setMetadataPrefix("oai_dc");
		meta2.setSchema("http://www.openarchives.org/OAI/2.0/dc.xsd");
		meta2.setMetadataNamespace("http://purl.org/dc/elements/1.1/");
		
		listMetadataFormats.addMetadataFormat(meta2);
		
		MetadataFormat meta3 = new MetadataFormat();
		meta3.setMetadataPrefix("oai_dc");
		meta3.setSchema("http://www.openarchives.org/OAI/2.0/dc.xsd");
		meta3.setMetadataNamespace("http://purl.org/dc/elements/1.1/");
		
		listMetadataFormats.addMetadataFormat(meta);
		
		oaipmh.setListMetadataFormats(listMetadataFormats);
		
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebaListMetadataFormats.xml",OaiPmhDao.LISTMETADATAFORMATS);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}

	public void testEscribirError() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		oaipmh.setRequest(request);
		
		Error error1 = new Error();
		
		error1.setCode(OAIPMHerrorcodeType.BADARGUMENT);
		error1.setContent("The argument metataPrefix included in the request is not valid.");	
		oaipmh.addError(error1);
		
		Error error2 = new Error();
		
		error2.setCode(OAIPMHerrorcodeType.BADARGUMENT);
		error2.setContent("The required argument metadataPrefix is missing in the request.");
		oaipmh.addError(error2);
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebaError.xml",OaiPmhDao.ERROR);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}

	public void testEscribirGenericoGetRecord() {
		
	OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.GETRECORD);
		oaipmh.setRequest(request);
		
		RecordAgrega record = new RecordAgrega();
		//CABECERA
		RecordTypeHeader header = new RecordTypeHeader();
		header.setIdentifier("oai:informatik.uni-stuttgart.de:ART-1996-02");
		header.setDatestamp("2000-11-10T10:11:00Z");
		record.setHeader(header);
		
		//METADATOS EN DUBLIN CORE
		Dc dublinCore = new Dc();
		Oai_dcTypeItem item = new Oai_dcTypeItem();
		Oai_dcTypeItem item2 = new Oai_dcTypeItem();
		DcTitle titulo =new DcTitle();
		titulo.setContent("Grassmann's space analysis");
		titulo.setLang("en");
		
		DcCreator creador = new DcCreator();
		creador.setContent("Hyde, E. W. (Edward Wyllys)");
		
		DcSubject subject = new DcSubject();
		subject.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H99");
		
		item.setDcTitle(titulo);
		item.setDcCreator(creador);
		item.setDcSubject(subject);
		
		
		DcTitle titulo2 =new DcTitle();
		titulo2.setContent("Grassmann");
		titulo2.setLang("en");
		
		DcCreator creador2 = new DcCreator();
		creador2.setContent("Hyde");
		
		DcSubject subject2 = new DcSubject();
		subject2.setContent("LCSH:Ausdehnungslehre; LCCN QA205.H95");
		
		item2.setDcTitle(titulo2);
		item2.setDcCreator(creador2);
		item2.setDcSubject(subject2);
		
		
		dublinCore.addOai_dcTypeItem(item);
		dublinCore.addOai_dcTypeItem(item2);
	
		record.setMetadata(dublinCore);
		
		//ABOUT
		About about = new About();
		about.setAnyObject("Prueba");
		record.setAbout(about,0);
		record.addAbout(3,about);
		record.setAbout(about, 3);
		About about2 = new About();
		about2.setAnyObject("Prueba about");
		record.setAbout(about2, 1);
		record.addAbout(2,about2);
		oaipmh.setGetRecord(record);
		
		oaipmh.getGetRecord();	
	
		try {	

			dao.escribirOAIPMH(oaipmh,"D:/pruebaEscribirGenericoGetRecord.xml",OaiPmhDao.GETRECORD);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}
	
	public void testPruebas() {
	
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		oaipmh.setRequest(request);
		
		Error error1 = new Error();
		
		error1.setCode(OAIPMHerrorcodeType.BADARGUMENT);
		error1.setContent("The argument metataPrefix included in the request is not valid.");	
		oaipmh.setError(0,error1);
		
		Error error2 = new Error();
		
		error2.setCode(OAIPMHerrorcodeType.BADARGUMENT);
		error2.setContent("The required argument metadataPrefix is missing in the request.");
		oaipmh.addError(2,error2);
		
		Error error3 = new Error();
		
		error3.setCode(OAIPMHerrorcodeType.BADARGUMENT);
		error3.setContent("The required argument metadataPrefix is missing in the request.");
		oaipmh.addError(0,error3);
		
		ListRecordsAgrega listRecords= new ListRecordsAgrega();
		RecordAgrega record = new RecordAgrega();
		listRecords.addRecord(0, record);
		
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebas.xml",OaiPmhDao.ERROR);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}
	
	public void testOAIidentifier() {
		
		OAIPMHAgrega oaipmh = new OAIPMHAgrega();
		
		oaipmh.setResponseDate(new Date());
		Request request = new Request();
		request.setContent("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		request.setVerb(VerbType.IDENTIFY);
		oaipmh.setRequest(request);
		Identify identify = new Identify();
		identify.setRepositoryName("Universität Stuttgart, Fakultät 5, Germany, Computer Science Archive");
		identify.setBaseURL("http://www.informatik.uni-stuttgart.de/cgi-bin/OAI/OAI.pl");
		identify.setProtocolVersion(ProtocolVersionType.VALUE_0);
		identify.addAdminEmail("reportadm@informatik.uni-stuttgart.de");
		identify.setEarliestDatestamp("2000-11-10T10:11:00Z");
		identify.setDeletedRecord(DeletedRecordType.TRANSIENT);
		identify.setGranularity(GranularityType.YYYY_MM_DDTHH_MM_SSZ);
		Description desc = new Description();
		
		OaiIdentifier id = new OaiIdentifier();
		id.setDelimiter(":");
		id.setRepositoryIdentifier("informatik.uni-stuttgart.de");
		id.setSampleIdentifier("oai:informatik.uni-stuttgart.de:INPROC-2006-49");
		id.setScheme("oai");
		desc.setAnyObject(id);
		
		identify.addDescription(desc);
		
		oaipmh.setIdentify(identify);		
	
		try {
			dao.escribirOAIPMH(oaipmh,"D:/pruebaOAI-IDENTIFIER.xml",OaiPmhDao.IDENTIFY);
		} catch (ParseadorException e1) {
			logger.error(e1);
		}
	}
}
