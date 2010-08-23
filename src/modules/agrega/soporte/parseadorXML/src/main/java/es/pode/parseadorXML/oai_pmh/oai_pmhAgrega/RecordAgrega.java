/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.oai_pmh.oai_pmhAgrega;

import java.io.Serializable;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.oai_pmh.About;
import es.pode.parseadorXML.oai_pmh.Metadata;
import es.pode.parseadorXML.oai_pmh.RecordType;
import es.pode.parseadorXML.oai_pmh.RecordTypeHeader;

public class RecordAgrega implements Serializable{
	private RecordType record=null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public RecordAgrega(){
		super();
		record= new RecordType();
	}
	
	public RecordAgrega(RecordType record){
		super();
		this.record = record;
	}
		
	public RecordType getRecord() {
		return record;
	}

	public void setRecord(RecordType record) {
		this.record = record;
	}
	
	public RecordTypeHeader getHeader(){
		RecordTypeHeader header = record.getRecordTypeHeader();
		return header;
	}
	
	public void setHeader(RecordTypeHeader header){
		record.setRecordTypeHeader(header);
	}
	
	public Object getMetadata(){
		Object metadata =record.getMetadata().getAnyObject();
		return metadata;
	}
	
	public void setMetadata(Object metadata){
		if(record.getMetadata()==null){
			Metadata md= new Metadata();
			record.setMetadata(md);
		}
		record.getMetadata().setAnyObject(metadata);	
	}

	public About[] getAbout(){
		About[] about = record.getAbout();
		return about;
	}
	
	public About getAboutIndex(int index){
		About about = record.getAbout(index);
		return about;
	}
	
	public void setAbout(About[] aboutArray){
		record.setAbout(aboutArray);
	}
	
	public void setAbout(About about, int index){
		if(record.getAboutCount()>index)
			record.setAbout(index, about);
		else
			record.addAbout(about);
	}

	public void addAbout(About about){
		record.addAbout(about);
	}
	
	public void addAbout(int index,About about){
		if(record.getAboutCount()>index)
			record.addAbout(index, about);
		else
			record.addAbout(about);
	}
	
}

