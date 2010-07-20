/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.ComplexTypeDurationDescription;
import es.pode.parseadorXML.castor.ComplexTypeDurationDuration;
import es.pode.parseadorXML.castor.ComplexTypeNameVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeNameVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeTypeVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeTypeVocabValue;
import es.pode.parseadorXML.castor.Duration;
import es.pode.parseadorXML.castor.Format;
import es.pode.parseadorXML.castor.GroupDurationDuration;
import es.pode.parseadorXML.castor.GroupFormatFormat;
import es.pode.parseadorXML.castor.GroupInstallationRemarksInstallationRemarks;
import es.pode.parseadorXML.castor.GroupLocationLocation;
import es.pode.parseadorXML.castor.GroupMaximumVersionMaximumVersion;
import es.pode.parseadorXML.castor.GroupMinimumVersionMinimumVersion;
import es.pode.parseadorXML.castor.GroupNameName;
import es.pode.parseadorXML.castor.GroupOrCompositeOrComposite;
import es.pode.parseadorXML.castor.GroupOtherPlatformRequirementsOtherPlatformRequirements;
import es.pode.parseadorXML.castor.GroupRequirementRequirement;
import es.pode.parseadorXML.castor.GroupSizeSize;
import es.pode.parseadorXML.castor.GroupTechnicalTechnical;
import es.pode.parseadorXML.castor.GroupTypeType;
import es.pode.parseadorXML.castor.InstallationRemarks;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.LocationLomes;
import es.pode.parseadorXML.castor.MaximumVersion;
import es.pode.parseadorXML.castor.MinimumVersion;
import es.pode.parseadorXML.castor.Name;
import es.pode.parseadorXML.castor.OrComposite;
import es.pode.parseadorXML.castor.OtherPlatformRequirements;
import es.pode.parseadorXML.castor.Requirement;
import es.pode.parseadorXML.castor.Size;
import es.pode.parseadorXML.castor.Technical;
import es.pode.parseadorXML.castor.Type;

public class TechnicalAgrega {

	private Technical technical = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public TechnicalAgrega(Technical technical) {
		super();
		
		if (technical.getGroupTechnicalTechnical()==null){
			technical.setGroupTechnicalTechnical(new GroupTechnicalTechnical());
		}
		
        setTechnical(technical);
	}
	
    //-----------/
    //- Methods -/
   //-----------/

   public Technical getTechnical() {
		return technical;
	}
   
   public void setTechnical(Technical technical) {
		this.technical = technical;
	}
   
   /*****/
   
   // método que recoge los formatos que existen en la categoría Technical
   public ArrayList getFormatos()
   throws java.lang.Exception {
   	
       ArrayList al= new ArrayList();
       
       try{
    	   Format[] f= technical.getGroupTechnicalTechnical().getFormat();
    	   if (f != null){
    		   for (int i= 0; i<f.length; i++){
    			   al.add(f[i].getGroupFormatFormat().getContent());
    		   }
    	   }
    	   
       } catch (Exception e){
    	   String mensaje = "Warning: No es posible recoger los formatos de la categoría Technical";
		   logger.warn(mensaje);
		   
		   al= new ArrayList();
		   return al;
		   //throw e;
       }
       
       return al;
   }
   
   /*****************************Métodos para Catalogador Avanzado********************************/
   
   public ArrayList getFormatosAv() throws Exception{
	   ArrayList lFormatos=null;
	   lFormatos=getFormatos();
	   return lFormatos;
   }
   
   public String getTamañoAv(){
	   String tamaño=null;

	   try{
		   Size size = technical.getGroupTechnicalTechnical().getSize();
		   if(size!=null)
			   tamaño=size.getGroupSizeSize().getContent().toString();
   		
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger el tamaño " ;
		    logger.warn(mensaje);
		    
		    return tamaño;
		    //throw e;
   	}
   	return tamaño;
   }
	
   public ArrayList getLocalizacionAv(){
	   ArrayList lLocalizacion=new ArrayList();
	   try{
		   LocationLomes[] location = technical.getGroupTechnicalTechnical().getLocation();
		   if((location!=null)&&(location.length>0)){
			   for (int i= 0; i<location.length; i++){
    			   lLocalizacion.add(location[i].getGroupLocationLocation().getContent());
    		   }
		   }
		   
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger las localizaciones " ;
		    logger.warn(mensaje);
		    
		    return lLocalizacion;
		    //throw e;
   		}
	   return lLocalizacion;
   }
   
   public ArrayList getRequisitosAv(){
	   ArrayList lRequisitos=new ArrayList();
	   
	   try{
		   Requirement[] requisito = technical.getGroupTechnicalTechnical().getRequirement();
		   if((requisito!=null)&&(requisito.length>0)){
			   for(int i=0;i<requisito.length;i++){
				   OrComposite[] composite = requisito[i].getGroupRequirementRequirement().getOrComposite();
				   ArrayList lCompo=new ArrayList();
				   if((composite!=null)&&(composite.length>0)){
					   for(int j=0;j<composite.length;j++){
						   RequisitoAgrega aRequisito=new RequisitoAgrega();
						   if((composite[j].getGroupOrCompositeOrComposite().getType()!=null)){
							   aRequisito.setTipo(composite[j].getGroupOrCompositeOrComposite().getType().getGroupTypeType().getComplexTypeTypeVocabValue().getContent());
						   }else
							   aRequisito.setTipo(null);
						   if(composite[j].getGroupOrCompositeOrComposite().getName()!=null)
							   aRequisito.setNombre(composite[j].getGroupOrCompositeOrComposite().getName().getGroupNameName().getComplexTypeNameVocabValue().getContent());
						   else
							   aRequisito.setNombre(null);
						   if(composite[j].getGroupOrCompositeOrComposite().getMinimumVersion()!=null)
								   aRequisito.setVersionMinima(composite[j].getGroupOrCompositeOrComposite().getMinimumVersion().getGroupMinimumVersionMinimumVersion().getContent());
						   else
							   aRequisito.setVersionMinima(null);
						   if(composite[j].getGroupOrCompositeOrComposite().getMaximumVersion()!=null)
							   aRequisito.setVersionMaxima(composite[j].getGroupOrCompositeOrComposite().getMaximumVersion().getGroupMaximumVersionMaximumVersion().getContent());
						   else
							   aRequisito.setVersionMaxima(null);
						   lCompo.add(aRequisito);
					   }
				   }
				   lRequisitos.add(lCompo);
			   }
			   
		   }
		   
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger los requisitos " ;
		    logger.warn(mensaje);
		    
		    return lRequisitos;
		    //throw e;
   		}
	   return lRequisitos;
   }
   
   public ArrayList getPautasDeInstalacionAv(){
	   ArrayList lPautas=new ArrayList();
	   try{
		   InstallationRemarks install = technical.getGroupTechnicalTechnical().getInstallationRemarks();
		   if(install!=null){
			   LanguageStringItem[] lInstall = install.getGroupInstallationRemarksInstallationRemarks().getLanguageStringItem();
			   if((lInstall!=null)&&(lInstall.length>0)){
				   for(int i=0;i<lInstall.length;i++){
					   LangStringAgrega lString=new LangStringAgrega();
					   lString.setValor(lInstall[i].getString().getContent());
					   lString.setIdioma(lInstall[i].getString().getLanguage());
					   lPautas.add(lString);
				   }
			   }
		   }
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger las pautas de instalacion " ;
		    logger.warn(mensaje);
		    
		    return lPautas;
		    //throw e;
   		}
	   return lPautas;
   }
   
   public ArrayList getOtrosRequisitosAv(){
	   ArrayList lOtrosRequi=new ArrayList();
	   try{
		   OtherPlatformRequirements req = technical.getGroupTechnicalTechnical().getOtherPlatformRequirements();
		   if(req!=null){
			   LanguageStringItem[] lOtrosR = req.getGroupOtherPlatformRequirementsOtherPlatformRequirements().getLanguageStringItem();
			   if((lOtrosR!=null)&&(lOtrosR.length>0)){
				   for(int i=0;i<lOtrosR.length;i++){
					   LangStringAgrega lOtros=new LangStringAgrega();
					   lOtros.setValor(lOtrosR[i].getString().getContent());
					   lOtros.setIdioma(lOtrosR[i].getString().getLanguage());
					   lOtrosRequi.add(lOtros);
				   }
			   }
		   }
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger otros requisitos " ;
		    logger.warn(mensaje);
		    
		    return lOtrosRequi;
		    //throw e;
   		}
	   return lOtrosRequi;
   }
   
   public DuracionAgrega getDuracionAv(){
	   DuracionAgrega tiempo=new DuracionAgrega();
	   ArrayList lDesc=new ArrayList();
	   try{
		   Duration dura = technical.getGroupTechnicalTechnical().getDuration();
		   if(dura!=null){
			   LanguageStringItem[] lsi=dura.getGroupDurationDuration().getComplexTypeDurationDescription().getLanguageStringItem();
			   tiempo.setDuracion(technical.getGroupTechnicalTechnical().getDuration().getGroupDurationDuration().getComplexTypeDurationDuration().getContent());
			  if((lsi!=null)&&(lsi.length>0)){
				  int cont= 0;
					while (cont<lsi.length){
						
						LangStringAgrega lString=new LangStringAgrega();
						lString.setValor(lsi[cont].getString().getContent());
						lString.setIdioma(lsi[cont].getString().getLanguage());
						lDesc.add(lString);
						cont++;
					}
					tiempo.setDescripciones(lDesc);
			  }
		   }
	   }catch (Exception e){
   		String mensaje = "Warning: No es posible recoger la duracion " ;
		    logger.warn(mensaje);
		    
		    return tiempo;
		    //throw e;
   		}
	   return tiempo;
   }
   
   /*********************Métodos SET para el Avanzado***************/
   
   public void setFormatosAv(ArrayList formatos) throws Exception{
	   try{
		  
		   ArrayList lista=new ArrayList();
		   if((formatos!=null)&&(formatos.size()>0)){
			   
			   for (int i=0;i<formatos.size();i++){
				   String formato=formatos.get(i).toString();
				   Format format=new Format();
				   GroupFormatFormat gff=new GroupFormatFormat();
				   gff.setContent(formato);
				   format.setGroupFormatFormat(gff);
				   lista.add(format);
			   }
		   }
		   Format[] forma=(Format[])lista.toArray(new Format[lista.size()]);
		   technical.getGroupTechnicalTechnical().setFormat(forma);
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los formatos";
		    logger.error(mensaje);
		    throw e;
	    } 
	   
   }
   
   public void setTamañoAv(String tamaño) throws Exception{
	   try{
		   if(tamaño!=null){
			   Size size=new Size();
			   GroupSizeSize gss=new GroupSizeSize();

			   BigDecimal big= new BigDecimal(tamaño);

			   gss.setContent(big);
			   size.setGroupSizeSize(gss);
			   technical.getGroupTechnicalTechnical().setSize(size);
		   }
	  
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar el tamaño";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setLocalizadorAv(ArrayList localizadores) throws Exception{
	   try{
		   ArrayList lista=new ArrayList();
		   if((localizadores!=null)&&(localizadores.size()>0)){
			   for(int i=0;i<localizadores.size();i++){
					String localizar=(String) localizadores.get(i);
					LocationLomes locationLomes=new LocationLomes();
					GroupLocationLocation gll=new GroupLocationLocation();
					gll.setContent(localizar);
					locationLomes.setGroupLocationLocation(gll);
					
					lista.add(locationLomes);
				   }
			   }
			   LocationLomes[] locat=(LocationLomes[])lista.toArray(new LocationLomes[lista.size()]);
			   technical.getGroupTechnicalTechnical().setLocation(locat);

	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los localizadores";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setRequisitosAv(ArrayList requisitos) throws Exception{
	   try{
		   ArrayList lista =new ArrayList();
		  
		    String requiProp = null;
	
		    requiProp = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");

		   if((requisitos!=null)&&(requisitos.size()>0)){
			   for(int i=0;i<requisitos.size();i++){
				   ArrayList array=(ArrayList)(requisitos.get(i));
				   ArrayList orLista=new ArrayList();
				   Requirement requirement=new Requirement();
				   GroupRequirementRequirement grr=new GroupRequirementRequirement();
				   if((array!=null)&&(array.size()>0)){
					   for(int j=0;j<array.size();j++){
						   String tipo=((RequisitoAgrega)(array.get(j))).getTipo();
						   String nombre=((RequisitoAgrega)(array.get(j))).getNombre();
						   String maxima=((RequisitoAgrega)(array.get(j))).getVersionMaxima();
						   String minima=((RequisitoAgrega)(array.get(j))).getVersionMinima();
						   
						   OrComposite orComposite=new OrComposite();
						   GroupOrCompositeOrComposite gococ=new GroupOrCompositeOrComposite();
						   
						   Name name=null;
						   if(nombre!=null){
							   name=new Name();
							   GroupNameName gnn=new GroupNameName();
							   ComplexTypeNameVocabSource ctnvs=new ComplexTypeNameVocabSource();
							   ComplexTypeNameVocabValue ctnvv=new ComplexTypeNameVocabValue();
							   ctnvs.setContent(requiProp);
							   ctnvv.setContent(nombre);
							   gnn.setComplexTypeNameVocabSource(ctnvs);
							   gnn.setComplexTypeNameVocabValue(ctnvv);
							   name.setGroupNameName(gnn);
						   }
						   gococ.setName(name);
						   
						   Type type=null; 
						   if(tipo!=null){
							   type=new Type();
							   GroupTypeType gtt=new GroupTypeType();
							   ComplexTypeTypeVocabSource cttvs=new ComplexTypeTypeVocabSource();
							   ComplexTypeTypeVocabValue cttvv=new ComplexTypeTypeVocabValue();
							   cttvs.setContent(requiProp);
							   cttvv.setContent(tipo);
							   gtt.setComplexTypeTypeVocabSource(cttvs);
							   gtt.setComplexTypeTypeVocabValue(cttvv);
							   type.setGroupTypeType(gtt);
						   }
						   gococ.setType(type);
						   
						   MaximumVersion max = null;
						   if(maxima!=null){
							   max=new MaximumVersion();
							   GroupMaximumVersionMaximumVersion gmvmv=new GroupMaximumVersionMaximumVersion(); 
							   gmvmv.setContent(maxima);
							   max.setGroupMaximumVersionMaximumVersion(gmvmv);
						   }
						   gococ.setMaximumVersion(max);
						   
						   MinimumVersion min=null;
						   if(minima!=null){
							   min = new MinimumVersion();
							   GroupMinimumVersionMinimumVersion gmivmv=new GroupMinimumVersionMinimumVersion();
							   gmivmv.setContent(minima);
							   min.setGroupMinimumVersionMinimumVersion(gmivmv);
						   }
						   gococ.setMinimumVersion(min);
						   
						   if(minima!=null || maxima!=null || tipo != null || nombre!=null){
							   orComposite.setGroupOrCompositeOrComposite(gococ);
							   orLista.add(orComposite);
						   }
					   }
				   }
				   OrComposite[] orComps=(OrComposite[])orLista.toArray(new OrComposite[orLista.size()]);
				   grr.setOrComposite(orComps);
				   requirement.setGroupRequirementRequirement(grr);
				   lista.add(requirement);
				   
			   }
			   
		   }
		   
		   
		   Requirement[] requirimientos=(Requirement[])lista.toArray(new Requirement[lista.size()]);
		   technical.getGroupTechnicalTechnical().setRequirement(requirimientos);
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los requisitos";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setPautasDeInstalacionAv(ArrayList pautas) throws Exception{
	   try{
		   GroupInstallationRemarksInstallationRemarks girir=new GroupInstallationRemarksInstallationRemarks();
		   ArrayList array=new ArrayList();
		   InstallationRemarks remarks=new InstallationRemarks();
		   if((pautas!=null)&&(pautas.size()>0)){
			   for(int i=0;i<pautas.size();i++){
				  
				  
				   LanguageStringItem lsi=new LanguageStringItem();
				   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
				   String idioma=((LangStringAgrega)(pautas.get(i))).getIdioma();
				   String valor=((LangStringAgrega)(pautas.get(i))).getValor();
				   string.setContent(valor);
				   string.setLanguage(idioma);
				   lsi.setString(string);
				   array.add(lsi);
				  
				   
				   
			   }
		   LanguageStringItem[] listas1=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
		   girir.setLanguageStringItem(listas1);
		   remarks.setGroupInstallationRemarksInstallationRemarks(girir);
		   }
		   technical.getGroupTechnicalTechnical().setInstallationRemarks(remarks);
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las pautas de instalación";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setOtrosRequisitosAv(ArrayList otrosRequisitos) throws Exception{
	   try{
		   ArrayList array=new ArrayList();
	   	   OtherPlatformRequirements other=new OtherPlatformRequirements();
	   	   GroupOtherPlatformRequirementsOtherPlatformRequirements gopropr=new GroupOtherPlatformRequirementsOtherPlatformRequirements();
	   	   
		   
		   if((otrosRequisitos!=null)&&(otrosRequisitos.size()>0)){
			   for(int i=0;i<otrosRequisitos.size();i++){
				   LanguageStringItem lsi=new LanguageStringItem();
				   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
				   String idioma=((LangStringAgrega)(otrosRequisitos.get(i))).getIdioma();
				   String valor=((LangStringAgrega)(otrosRequisitos.get(i))).getValor();
				   string.setContent(valor);
				   string.setLanguage(idioma);
				   lsi.setString(string);
				   array.add(lsi);
			   }
			   
			   LanguageStringItem[] listas1=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
			   gopropr.setLanguageStringItem(listas1);
			   other.setGroupOtherPlatformRequirementsOtherPlatformRequirements(gopropr);
			   
		   }
		   technical.getGroupTechnicalTechnical().setOtherPlatformRequirements(other);
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los otros requisitos";
		    logger.error(mensaje);
		    throw e;
	    }
	   
   }
   
   public void setDuracionAv(DuracionAgrega duracion) throws Exception{
	   try{
		   Duration duration=new Duration();
		   GroupDurationDuration gdd=new GroupDurationDuration();
		   ArrayList array=new ArrayList();
		   
		   if(duracion!=null){
			   String duration2=duracion.getDuracion();
			   ComplexTypeDurationDuration ctddu=new ComplexTypeDurationDuration();
			   if(duration2!=null){
				   ctddu.setContent(duration2);
			   }
			   gdd.setComplexTypeDurationDuration(ctddu);
				   
			   ArrayList descripciones=duracion.getDescripciones();
			   if((descripciones!=null)&&(descripciones.size()>0)){
				   ComplexTypeDurationDescription ctdd=new ComplexTypeDurationDescription();
				   for(int i=0;i<descripciones.size();i++){
					   
					   LanguageStringItem lsi=new LanguageStringItem();
					   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
					   
					   String idioma=((LangStringAgrega)(descripciones.get(i))).getIdioma(); 
					   String valor=((LangStringAgrega)(descripciones.get(i))).getValor();
					   string.setContent(valor);
					   string.setLanguage(idioma);
					   lsi.setString(string);
					   array.add(lsi);
				   }
				   LanguageStringItem[] listas1=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
				   ctdd.setLanguageStringItem(listas1);
				   gdd.setComplexTypeDurationDescription(ctdd);
			   }
			  
		   }
		   duration.setGroupDurationDuration(gdd);
		   technical.getGroupTechnicalTechnical().setDuration(duration);
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar la duracion";
		    logger.error(mensaje);
		    throw e;
	    }
   }
}
