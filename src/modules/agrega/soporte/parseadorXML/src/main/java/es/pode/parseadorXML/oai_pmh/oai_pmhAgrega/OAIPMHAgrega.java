/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.oai_pmh.oai_pmhAgrega;

import java.util.Date;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.oai_pmh.Error;
import es.pode.parseadorXML.oai_pmh.GetRecord;
import es.pode.parseadorXML.oai_pmh.GetRecordTypeRecord;
import es.pode.parseadorXML.oai_pmh.Identify;
import es.pode.parseadorXML.oai_pmh.ListIdentifiers;
import es.pode.parseadorXML.oai_pmh.ListMetadataFormats;
import es.pode.parseadorXML.oai_pmh.ListRecords;
import es.pode.parseadorXML.oai_pmh.ListSets;
import es.pode.parseadorXML.oai_pmh.OAIPMH;
import es.pode.parseadorXML.oai_pmh.OAIPMHtypeChoice;
import es.pode.parseadorXML.oai_pmh.Request;

public class OAIPMHAgrega {

	private OAIPMH oaipmh= null;
	
	private Logger logger = Logger.getLogger(this.getClass());

	public OAIPMHAgrega() {
		super();
		oaipmh = new OAIPMH();
	}

	public OAIPMHAgrega(OAIPMH oaipmh) {
		super();
		setOaipmh(oaipmh);
	}
	
	public OAIPMH getOaipmh() {
		return oaipmh;
	}

	public void setOaipmh(OAIPMH oaipmh) {
		this.oaipmh = oaipmh;
	}
	
	public Date getResponseDate(){
		if(oaipmh!=null)
			return oaipmh.getResponseDate();
		else 
			return null;
	}
	
	public void setResponseDate(Date responseDate){
		if(oaipmh != null)			
			oaipmh.setResponseDate(responseDate);
	}
	
	public Request getRequest(){
		if(oaipmh!=null)
			return oaipmh.getRequest();
		else 
			return null;
	}
	
	public void setRequest(Request request){
		if(oaipmh!=null)
			oaipmh.setRequest(request);
	}
	
	public Identify getIdentify(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null){
			return oaipmh.getOAIPMHtypeChoice().getIdentify();
		}
		else 
			return null;
		}
	
	public void setIdentify(Identify identify){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setIdentify(identify);
		}
	}
	
	public ListIdentifiers getListIdentifiers(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null)
			return oaipmh.getOAIPMHtypeChoice().getListIdentifiers();
		else 
			return null;
	}
	
	public void setListIdentifiers(ListIdentifiers listIdentifiers){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setListIdentifiers(listIdentifiers);
		}
	}
	
	public ListSets getListSets(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null)
			return oaipmh.getOAIPMHtypeChoice().getListSets();
		else 
			return null;
	}
	
	public void setListSets(ListSets listSets){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setListSets(listSets);
		}
	}
	
	public ListMetadataFormats getListMetadataFormats(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null)
			return oaipmh.getOAIPMHtypeChoice().getListMetadataFormats();
		else 
			return null;
	}
		
	public void setListMetadataFormats(ListMetadataFormats listMetadataFormats){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setListMetadataFormats(listMetadataFormats);
		}
	}
	
	public RecordAgrega getGetRecord(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null){
			GetRecord gRecord = oaipmh.getOAIPMHtypeChoice().getGetRecord();
			return new RecordAgrega(gRecord.getGetRecordTypeRecord());
		}
		else 
			return null;
	}
	
	public void setGetRecord(RecordAgrega record){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			if(oaipmh.getOAIPMHtypeChoice().getGetRecord() == null)
				oaipmh.getOAIPMHtypeChoice().setGetRecord(new GetRecord());
			
			GetRecordTypeRecord getRecord = new GetRecordTypeRecord();
			if(record.getRecord()!=null){
				getRecord.setMetadata(record.getRecord().getMetadata());
				getRecord.setRecordTypeHeader(record.getRecord().getRecordTypeHeader());
				getRecord.setAbout(record.getRecord().getAbout());
			}
			oaipmh.getOAIPMHtypeChoice().getGetRecord().setGetRecordTypeRecord(getRecord);
		}
	}
	
	public ListRecordsAgrega getListRecords(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null){
			ListRecords lRecords = oaipmh.getOAIPMHtypeChoice().getListRecords();
			return new ListRecordsAgrega(lRecords);
		}
		else 
			return null;
	}
	
	public void setListRecords(ListRecordsAgrega listRecords){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setListRecords(listRecords.getListRecords());
		}
	}
		
	public Error[] getError(){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null)
			return oaipmh.getOAIPMHtypeChoice().getError();
		else 
			return null;
	}
	
	public Error getError(int index){
		if(oaipmh!=null && oaipmh.getOAIPMHtypeChoice()!=null)
			return oaipmh.getOAIPMHtypeChoice().getError(index);
		else 
			return null;
	}
	
	public void setError(Error[] errores){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().setError(errores);
		}
	}
	
	public void setError(int index,Error error){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			if(oaipmh.getOAIPMHtypeChoice().getErrorCount()>index)
				oaipmh.getOAIPMHtypeChoice().setError(index,error);
			else
				oaipmh.getOAIPMHtypeChoice().addError(error);
				
		}
	}
	
	public void addError(Error error){
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			oaipmh.getOAIPMHtypeChoice().addError(error);		
		}
	}
	
	public void addError(int index,Error error){	
		if(oaipmh!=null){
			if(oaipmh.getOAIPMHtypeChoice() == null)
				oaipmh.setOAIPMHtypeChoice(new OAIPMHtypeChoice());
			if(oaipmh.getOAIPMHtypeChoice().getErrorCount()>index)
				oaipmh.getOAIPMHtypeChoice().addError(index,error);
			else
				oaipmh.getOAIPMHtypeChoice().addError(error);
				
				
		}
	}
}
