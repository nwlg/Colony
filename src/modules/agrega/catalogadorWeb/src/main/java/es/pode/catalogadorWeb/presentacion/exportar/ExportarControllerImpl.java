/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.exportar;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.catalogacion.negocio.servicios.AgregadorORVO;
import es.pode.catalogacion.negocio.servicios.AvAnnotationVO;
import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.AvEducationalVO;
import es.pode.catalogacion.negocio.servicios.AvGeneralVO;
import es.pode.catalogacion.negocio.servicios.AvLifeCycleVO;
import es.pode.catalogacion.negocio.servicios.AvMetametadataVO;
import es.pode.catalogacion.negocio.servicios.AvRelationVO;
import es.pode.catalogacion.negocio.servicios.AvRightsVO;
import es.pode.catalogacion.negocio.servicios.AvTechnicalVO;
import es.pode.catalogacion.negocio.servicios.ContribucionVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.FechaVO;
import es.pode.catalogacion.negocio.servicios.IdentificadorVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.VersionMaxVO;
import es.pode.catalogacion.negocio.servicios.VersionMinVO;
import es.pode.catalogadorWeb.presentacion.CatalogadorAvSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;



public class ExportarControllerImpl extends ExportarController
{

	private static final Logger logger = Logger.getLogger(ExportarControllerImpl.class);



	    public final String validarLomes(
	    		ActionMapping mapping, 
	    		ValidarLomesForm form, 
	    		HttpServletRequest request, 
	    		HttpServletResponse response) 
	    throws Exception
	    {
	    	String resultado;
			boolean ok= true;
			
			//String idiomaLocale=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();

			ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
			Collection mensajes = new ArrayList();
			
			LomAvanzadoVO lomAv= this.getCatalogadorAvSession(request).getMDSesion();
			
			if (lomAv == null){
				lomAv= new LomAvanzadoVO();
			}
			logger.debug("Método de validacion de metadatos avanzados");
			
			// -- GENERAL --
			if(lomAv.getGeneral()==null){
				mensajes.add(datosResources.getString("CAV.1"));
			}
			else{
				
				AvGeneralVO gn = lomAv.getGeneral();
				if(gn.getIdentificadores()!=null && gn.getIdentificadores().length>0){
		//			CATALOGOS
					int i= 0;
					while ((ok)&&(i<gn.getIdentificadores().length)){
						
						if (gn.getIdentificadores()[i]!=null){
							String cat= gn.getIdentificadores()[i].getCatalogo();
							String ent= gn.getIdentificadores()[i].getEntrada();
							
							if(((cat==null)||(cat.trim().equals("")))&& ((ent!=null)&&(!ent.trim().equals(""))))//Si existe una entrada, un catálogo es obligatorio
									mensajes.add(datosResources.getString("CAV.1.1.1"));
						}
						
						if (!mensajes.equals("")){
							ok= false;
						}
						else{
							i++;
						}	
					}
					//ENTRADAS
					i= 0;
					ok=true;
					while ((ok)&&(i<gn.getIdentificadores().length)){
						
						if (gn.getIdentificadores()[i]!=null){
							String cat= gn.getIdentificadores()[i].getCatalogo();
							String ent= gn.getIdentificadores()[i].getEntrada();
							
							if (((ent==null)||(ent.trim().equals("")))&& ((cat!=null)&&(!cat.trim().equals(""))))//Si existe un catálogo, una entrada es obligatoria
								mensajes.add(datosResources.getString("CAV.1.1.2"));
						}
						
						if (!mensajes.equals("")){
							ok= false;
						}
						else{
							i++;
						}	
					}
				}
				//TITULOS
				boolean todosVacios=true;
				String texto= null;
				if(gn.getTitulo()!=null){
					for(int i=0;i<gn.getTitulo().getTextos().length && todosVacios ;i++)
					{
						if (gn.getTitulo().getTextos()[i]!=null){
							texto=gn.getTitulo().getTextos()[i].getTexto();
						}
						
						if(texto!=null && !texto.trim().equals(""))
						{
							todosVacios=false;
						}
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
				}else
					mensajes.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
				
				//IDIOMA
				todosVacios=true;
				String idioma= null;
				if(gn.getIdiomas()!=null && gn.getIdiomas().length>0){
					for(int i=0;i<gn.getIdiomas().length && todosVacios;i++)
					{
						if (gn.getIdiomas()[i]!=null){
							idioma= gn.getIdiomas()[i].getTexto();
						}		
						if(idioma!=null && !idioma.equals(""))
						{
							todosVacios=false;
						}
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
				}else
					mensajes.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
				
				todosVacios=true;
				String descripcion= null;
				if(gn.getDescripciones()!=null && gn.getDescripciones().length>0){
					for(int i=0;i<gn.getDescripciones().length && todosVacios;i++)
					{
						if (gn.getDescripciones()[i]!=null){
							for(int j=0;j<gn.getDescripciones()[i].getTextos().length && todosVacios;j++)
							{
								if (gn.getDescripciones()[i].getTextos()[j]!=null){
									descripcion=gn.getDescripciones()[i].getTextos()[j].getTexto();
								}

								if(descripcion!=null && !descripcion.trim().equals(""))
								{
									todosVacios=false;
								}
							}
						}
						
					}
					if(todosVacios)
						mensajes.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
				}else
					mensajes.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
				
				//NIVEL DE AGREGACION
				if(gn.getNivelAgregacion()!=null){
					if(gn.getNivelAgregacion().getValor()==null || gn.getNivelAgregacion().getValor().equals(""))
						mensajes.add(datosResources.getString("CAV.1.8"));
				}else
					mensajes.add(datosResources.getString("CAV.1.8"));
			}
			
			//		 -- CICLO DE VIDA --
			if(lomAv.getLifeCycle()!=null){
				AvLifeCycleVO life = lomAv.getLifeCycle();
//				CONTRIBUCION
				String rol;
				boolean errorContRol=false;
				boolean errorContEntidad=false;
				boolean errorContFecha=false;
				boolean errorFecha=true;
				boolean errorFechaVacia=false;
				boolean errorDescVacia=false;
				boolean errorMinutos=false;
				
				boolean todosVacios=true;

				ContribucionVO[] contribuciones= life.getContribuciones();
				
				

				if(contribuciones!=null && contribuciones.length>0){
					for(int i=0;i<contribuciones.length && (!errorContRol || !errorContEntidad || !errorContFecha) ;i++ )
					{
		//				ROL
						if(!errorContRol)
						{
							if(contribuciones[i].getTipo()!=null){
								rol=contribuciones[i].getTipo().getValor();
								if(rol==null || rol.trim().equals(""))
								{
									errorContRol =true;
									mensajes.add(datosResources.getString("CAV.2.3.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
								}
							}else{
								errorContRol =true;
								mensajes.add(datosResources.getString("CAV.2.3.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}	
		//			//entidad
						if(!errorContEntidad)
						{
							todosVacios=true;
							if(contribuciones[i].getEntidades()!=null && contribuciones[i].getEntidades().length>0){
								for(int j=0;j<contribuciones[i].getEntidades().length && todosVacios;j++)
								{
									EntidadVO ent=contribuciones[i].getEntidades()[j];
									
									if (ent != null){
										if ((ent.getTexto()==null)||(ent.getTexto().trim().equals(""))){
											errorContEntidad=true;
											mensajes.add(datosResources.getString("CAV.2.3.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
										}
									}
									
								}
							}else{
								errorContEntidad=true;
								mensajes.add(datosResources.getString("CAV.2.3.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}
						
							
						//fecha
						if(!errorContFecha)
						{
							if(contribuciones[i].getFecha()!=null){
								FechaVO fechaCont= contribuciones[i].getFecha();
								DescripcionVO descCont=fechaCont.getDescripcion();
								
								boolean fechaVacia=true;
								
								if (fechaCont!=null && fechaVacia){
									if ((fechaCont.getFecha()==null)||(fechaCont.getFecha().equals(""))){
										fechaVacia=false;
									}
								}else{
									fechaVacia=false;
								}
								
								
								boolean descVacios=true;
								String descFec= null;
								if (descCont!= null){
									for(int j=0;j<descCont.getTextos().length && descVacios;j++)
									{
										descFec= descCont.getTextos()[j].getTexto();
										if(descFec==null || descFec.trim().equals(""))
										{
											descVacios=false;// si todos los campos descripcion son vacios
										}
									}
								}else{
									descVacios=false;
								}
								
								if(descVacios && fechaVacia && !errorFecha)
								{
//									errorContFecha=true;
									errorFecha=false;
									mensajes.add(datosResources.getString("CAV.2.3.3"));//El campo FECHA	 es obligatorio
								}else if(!descVacios && fechaVacia && !errorFechaVacia && errorFecha ) 
								{
//									errorContFecha=true;
									errorFechaVacia=true;
									mensajes.add(datosResources.getString("CAV.2.3.3.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
								}else if(descVacios && !fechaVacia && !errorDescVacia && errorFecha)
								{
//									errorContFecha=true;
									errorDescVacia=true;
									mensajes.add(datosResources.getString("CAV.2.3.3.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
								}
					
//								if(errorFecha && errorFechaVacia && errorDescVacia && errorMinutos)
//									errorContFecha=true;
							}else{
								errorContFecha=true;
								errorFecha=false;
								mensajes.add(datosResources.getString("CAV.2.3.3"));//El campo FECHA	 es obligatorio
							}
						}
					}
				}
			}
			
			//		 -- METAMETADATA --
			if(lomAv.getMetaMetadata()==null){
				mensajes.add(datosResources.getString("CAV.3"));
			}
			else{
				AvMetametadataVO mm = lomAv.getMetaMetadata();
				
				int i= 0;
				boolean completo=true;
				boolean todosVacios=true;
				
				//IDENTIFICADORES
				IdentificadorVO[] identificadores= mm.getIdentificadores();
				if(identificadores!=null && identificadores.length>0){
					for(i=0;i<identificadores.length && completo;i++)
					{
						if((identificadores[i].getCatalogo()!=null && identificadores[i].getCatalogo().trim().equals("")) &&
						   (identificadores[i].getEntrada()!=null && !identificadores[i].getEntrada().trim().equals("")) )
						{
							completo=false;
							mensajes.add(datosResources.getString("CAV.3.1.1"));//Si existe una entrada para un identificador, un cat&aacute;logo es obligatorio
						}
					}
					completo=true;
					for(i=0;i<identificadores.length && completo;i++)
					{
						if((identificadores[i].getCatalogo()!=null && !identificadores[i].getCatalogo().trim().equals("")) &&
						   (identificadores[i].getEntrada()!=null && identificadores[i].getEntrada().trim().equals("")) )
						{
							completo=false;
							mensajes.add(datosResources.getString("CAV.3.1.2"));//Si existe un cat&aacute;logo para un identificador, una entrada es obligatoria
						}
					}
				}
				
				
				//CONTRIBUCION
				String rol;
				boolean errorContRol=false;
				boolean errorContEntidad=false;
				boolean errorContFecha=false;
				boolean errorFecha=true;
				boolean errorFechaVacia=false;
				boolean errorDescVacia=false;
				boolean errorMinutos=false;

				ContribucionVO[] contribuciones= mm.getContribuciones();
				if(contribuciones!=null && contribuciones.length>0){
					for(i=0;i<contribuciones.length && (!errorContRol || !errorContEntidad || !errorContFecha) ;i++ )
					{
		//				ROL
						if(!errorContRol)
						{
							if(contribuciones[i].getTipo()!=null){
								rol=contribuciones[i].getTipo().getValor();
								if(rol==null || rol.trim().equals(""))
								{
									errorContRol =true;
									mensajes.add(datosResources.getString("CAV.3.2.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
								}
							}else{
								errorContRol =true;
								mensajes.add(datosResources.getString("CAV.3.2.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}	
		//			//entidad
						if(!errorContEntidad)
						{
							todosVacios=true;
							if(contribuciones[i].getEntidades()!=null && contribuciones[i].getEntidades().length>0){
								for(int j=0;j<contribuciones[i].getEntidades().length && todosVacios;j++)
								{
									EntidadVO ent=contribuciones[i].getEntidades()[j];
									
									if (ent != null){
										if ((ent.getTexto()==null)||(ent.getTexto().trim().equals(""))){
											errorContEntidad=true;
											mensajes.add(datosResources.getString("CAV.3.2.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
										}
									}
									
								}
							}else{
								errorContEntidad=true;
								mensajes.add(datosResources.getString("CAV.3.2.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
							}
						}
							
						//fecha
						if(!errorContFecha)
						{
							if(contribuciones[i].getFecha()!=null){
								FechaVO fechaCont= contribuciones[i].getFecha();
								DescripcionVO descCont=fechaCont.getDescripcion();
								
								boolean fechaVacia=true;
								
								if (fechaCont!=null && fechaVacia){
									if ((fechaCont.getFecha()==null)||(fechaCont.getFecha().equals(""))){
										fechaVacia=false;
									}
								}else{
									fechaVacia=false;
								}
								
								boolean descVacios=true;
								String descFec= null;
								if (descCont!= null){
									for(int j=0;j<descCont.getTextos().length && descVacios;j++)
									{
										descFec= descCont.getTextos()[j].getTexto();
										if(descFec==null && descFec.trim().equals(""))
										{
											descVacios=false;// si todos los campos descripcion son vacios
										}
									}
								}else{
									descVacios=false;
								}
								
								if(descVacios && fechaVacia && !errorFecha)
								{
//									errorContFecha=true;
									errorFecha=false;
									mensajes.add(datosResources.getString("CAV.3.2.3"));//El campo FECHA	 es obligatorio
								}else if(!descVacios && fechaVacia && !errorFechaVacia && errorFecha) 
								{
//									errorContFecha=true;
									errorFechaVacia=true;
									mensajes.add(datosResources.getString("CAV.3.2.3.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
								}else if(descVacios && !fechaVacia && !errorDescVacia && errorFecha)
								{
//									errorContFecha=true;
									errorDescVacia=true;
									mensajes.add(datosResources.getString("CAV.3.2.3.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
								}
					
//								if(errorFecha && errorFechaVacia && errorDescVacia && errorMinutos)
//									errorContFecha=true;
							}else{
								errorContFecha=true;
								errorFecha=true;
								mensajes.add(datosResources.getString("CAV.3.2.3"));//El campo FECHA	 es obligatorio
							}
						}
					}
				}

//				EsquemaDeMetadatosVO[] esquemasMeta= mm.getEsquemas(); No es obligatorio
//				//ESQUEMA METADATOS
//				todosVacios=true;
//				String esquema;
//				if(esquemasMeta!=null && esquemasMeta.length>0){
//					for(i=0;i<esquemasMeta.length && todosVacios;i++)
//					{
//						esquema=esquemasMeta[i].getTexto();
//						if(esquema!=null && !esquema.trim().equals(""))
//						{
//							todosVacios=false;
//						}
//					}
//					if(todosVacios)
//						mensajes.add(datosResources.getString("CAV.3.3"));//El campo Esquema de metadatos es obligatorio
//				}else{
//					mensajes.add(datosResources.getString("CAV.3.3"));//El campo Esquema de metadatos es obligatorio
//				}
				
				
				//IDIOMA
				if(mm.getIdioma()!=null){
					if(mm.getIdioma().getTexto()==null || mm.getIdioma().getTexto().equals(""))
						mensajes.add(datosResources.getString("CAV.3.4"));//El campo Idioma es obligatorio
				}else
					mensajes.add(datosResources.getString("CAV.3.4"));//El campo Idioma es obligatorio
				
			}
			
			//		 -- TECHNICAL --
	if (lomAv.getTechnical()!=null){
				
				AvTechnicalVO tec= lomAv.getTechnical();
				
//				NOMBRE

				
				if(tec.getRequisitos()!=null && tec.getRequisitos().length>0){
					
					ok=true;
					int i= 0;
					while ((ok)&&(i<tec.getRequisitos().length)){
						AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
						if(cat!=null && cat.length>0){
							int j=0;
							while((ok)&&(j<cat.length)){
								String nombre="";
								String tipo="";
								String maxi="";
								String mini="";
								SourceValueVO sNombre= cat[j].getNombre();
								SourceValueVO sTipo=cat[j].getTipo();
								if(sNombre!=null){
									nombre=sNombre.getValor();
								}
								if(sTipo!=null){
									tipo=sTipo.getValor();
								}
								VersionMinVO min=cat[j].getVersionMin();
								if(min!=null && min.getTexto()!=null){
									mini=min.getTexto().trim();
								}
								
								VersionMaxVO max=cat[j].getVersionMax();
								if(max!=null && max.getTexto()!=null){
									maxi=max.getTexto().trim();
								}

								if(((nombre==null)||(nombre.equals("")))&&(((!tipo.equals("")))||((!mini.equals("")))||((!maxi.equals(""))))){
									mensajes.add(datosResources.getString("CAV.4.4.1.2"));
									ok= false;
								}
								
								j++;		
							}
							
						}
							
						i++;
					}
					
					//TIPO
					ok=true;
					i= 0;
					while ((ok)&&(i<tec.getRequisitos().length)){
						AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
						if(cat!=null && cat.length>0){
							int j=0;
							while((ok)&&(j<cat.length)){
								String nombre="";
								String tipo="";
								String maxi="";
								String mini="";
								SourceValueVO sNombre= cat[j].getNombre();
								SourceValueVO sTipo=cat[j].getTipo();
								if(sNombre!=null){
									nombre=sNombre.getValor();
								}
								if(sTipo!=null){
									tipo=sTipo.getValor();
								}
								VersionMinVO min=cat[j].getVersionMin();
								if(min!=null && min.getTexto()!=null){
									mini=min.getTexto().trim();
								}
								
								VersionMaxVO max=cat[j].getVersionMax();
								if(max!=null && max.getTexto()!=null){
									maxi=max.getTexto().trim();
								}
								if(((tipo==null)||(tipo.equals("")))&&(((!nombre.equals("")))||((!mini.equals("")))||((!maxi.equals(""))))){
									mensajes.add(datosResources.getString("CAV.4.4.1.1"));
									ok= false;
								}
								
								j++;		
							}
						}
							i++;
						
					}
					
					//DURACION
					boolean todosVacios=true;

			        String descripcion;
			        if(tec.getDuracion()!=null){
			        	if((tec.getDuracion().getDescripcion()!=null)&&(tec.getDuracion().getDescripcion().getTextos()!=null)&&(tec.getDuracion().getDescripcion().getTextos().length>0)){
					        for(i=0;i<tec.getDuracion().getDescripcion().getTextos().length && todosVacios;i++)
					        {
			                    descripcion=tec.getDuracion().getDescripcion().getTextos()[i].getTexto();
			                    if(descripcion!=null && !descripcion.trim().equals(""))
			                    {
			                         todosVacios=false;
			                    }
					        }
			        	}
			        }
			        boolean duracionVacia=true;
			        if(tec.getDuracion()!=null){
				        if ((tec.getDuracion().getDuracion() != null)&&(!tec.getDuracion().getDuracion().equals(""))){
				        	duracionVacia=false;
				        }
			        }
		
			        if(todosVacios && !duracionVacia)
			              mensajes.add(datosResources.getString("CAV.4.7.2"));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
			        if(!todosVacios && duracionVacia)
			             mensajes.add(datosResources.getString("CAV.4.7.1"));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n
				}
			}
			//USO EDUCATIVO
			if ((lomAv.getEducational()==null)||(lomAv.getEducational().length==0)){
				mensajes.add(datosResources.getString("CAV.5")); //Al menos debe existir una categor&iacute;a Uso Educativo
			}
			else{
				for (int indexEdu= 0; indexEdu<lomAv.getEducational().length; indexEdu++){
					AvEducationalVO edu= lomAv.getEducational()[indexEdu];
					
					boolean todosVacios=true;
					int i;

				  	//TIPO DE RECURSO DE APRENDIZAJE
					String recurso= null;
					if(edu.getTiposrecursoedu()!=null && edu.getTiposrecursoedu().length>0){
						for(i=0;i<edu.getTiposrecursoedu().length && todosVacios;i++)
						{
							recurso= edu.getTiposrecursoedu()[i].getValor();
							if(recurso!=null && !recurso.equals(""))
							{
								todosVacios=false;
							}
						}
						if(todosVacios)
							mensajes.add(datosResources.getString("CAV.5.2.1")+" "+ (indexEdu+1));//El campo Tipo de recurso es obligatorio
					}else
						mensajes.add(datosResources.getString("CAV.5.2.1")+" "+ (indexEdu+1));//El campo Tipo de recurso es obligatorio
					//IDIOMA
					todosVacios=true;
					String idioma= null;
					if(edu.getIdiomas()!=null && edu.getIdiomas().length>0){
						for(i=0;i<edu.getIdiomas().length && todosVacios;i++)
						{
							idioma= edu.getIdiomas()[i].getTexto();
							if(idioma!=null && !idioma.equals(""))
							{
								todosVacios=false;
							}
						}
						if(todosVacios)
							mensajes.add(datosResources.getString("CAV.5.11.1")+" "+(indexEdu+1));//El campo Idioma es obligatorio
					}else
						mensajes.add(datosResources.getString("CAV.5.11.1")+" "+(indexEdu+1));//El campo Idioma es obligatorio
					
				  	//TIEMPO DE APRENDIZAJE
					//DESCRIPCIONES
					todosVacios=true;
					String descripcion;
					if(edu.getTiempoAprendizaje()!=null && edu.getTiempoAprendizaje().getDescripcion()!=null && edu.getTiempoAprendizaje().getDescripcion().getTextos()!=null && edu.getTiempoAprendizaje().getDescripcion().getTextos().length>0){
						for(i=0;i<edu.getTiempoAprendizaje().getDescripcion().getTextos().length && todosVacios;i++)
						{
								descripcion=edu.getTiempoAprendizaje().getDescripcion().getTextos()[i].getTexto();
								if(descripcion!=null && !descripcion.trim().equals(""))
								{
									todosVacios=false;
								}
						}
					}
					
					//DURACION
					boolean duracionVacia=true;
					if(edu.getTiempoAprendizaje()!=null){
						if ((edu.getTiempoAprendizaje().getDuracion()!=null)&&(!edu.getTiempoAprendizaje().getDuracion().equals(""))){
							duracionVacia=false;
						}
					}
								
					if(todosVacios && !duracionVacia)
						mensajes.add(datosResources.getString("CAV.5.9.2.1")+" "+(indexEdu+1));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
					if(!todosVacios && duracionVacia)
						mensajes.add(datosResources.getString("CAV.5.9.1.1")+" "+(indexEdu+1));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n

				}
			}
			
			// -- DERECHOS --
			if(lomAv.getDerechos()==null){
				mensajes.add(datosResources.getString("CAV.6"));
			}
			else{
//				COPYRIGHT 
				AvRightsVO de= lomAv.getDerechos();
				if(de!=null && de.getDerechosDeAutor()!=null){
					String copyright= de.getDerechosDeAutor().getValor();
			    	if(copyright==null || copyright.equals(""))
			    	{
			    		mensajes.add(datosResources.getString("CAV.6.2"));
			    	}
				}
		    	
		    	//ACCESO
				if(de!=null && de.getAcceso()!=null && de.getAcceso().getTipo()!=null){
			    	String tipoAcceso= de.getAcceso().getTipo().getValor();
			    	if(tipoAcceso==null || tipoAcceso.equals(""))
			    	{
			    		mensajes.add(datosResources.getString("CAV.6.4.1"));
			    	}
				}
		    	
		    	//AMBITO
				if(de!=null && 
				   de.getAcceso()!=null && de.getAcceso().getDescripcion()!=null && 
				   de.getAcceso().getDescripcion().getTextos()!=null && de.getAcceso().getDescripcion().getTextos().length>0)
				{
					if(!de.getAcceso().getTipo().getValor().equalsIgnoreCase("universal"))
					{
				    	String comunidades= de.getAcceso().getDescripcion().getTextos()[0].getTexto();
				    	if(comunidades==null || comunidades.trim().equals(""))
				    	{
				    		mensajes.add(datosResources.getString("CAV.6.4.2"));//Es necesario seleccionar al menos un &aacute;mbito
				    	}
					}
				}
			}
			
			// -- RELACION --
			if ((lomAv.getRelaciones()!=null)&&(lomAv.getRelaciones().length>0)){
				
				for (int indexRelacion= 0; indexRelacion<lomAv.getRelaciones().length; indexRelacion++){
					AvRelationVO re= lomAv.getRelaciones()[indexRelacion];

					ok= true;
					
					//TIPO
					if((re.getTipo()!=null)){
						String tip=re.getTipo().getValor();
						if((tip==null)||(tip.equals("")))
							mensajes.add(datosResources.getString("CAV.7.1.7")+(indexRelacion+1));
					}
					
					//IDENTIFICADOR
					
					if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)&&(re.getTipo()!=null)){
						String cat=re.getRecurso().getIdentificador().getCatalogo();
						String ent=re.getRecurso().getIdentificador().getEntrada();
						String tip=re.getTipo().getValor();
						if(((cat==null)||(cat.trim().equals("")))&& ((ent==null)||(ent.trim().equals(""))))//Si existe una entrada, un catálogo es obligatorio
							mensajes.add(datosResources.getString("CAV.7.3.7")+" "+(indexRelacion+1));
						if (!mensajes.equals("")){
							ok= false;
						}
						
					}
		//			CATALOGOS
					ok=true;
					if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)&&(re.getTipo()!=null)){
						String cat=re.getRecurso().getIdentificador().getCatalogo();
						String ent=re.getRecurso().getIdentificador().getEntrada();
						String tip=re.getTipo().getValor();
						if(((cat==null)||(cat.trim().equals("")))&& ((ent!=null)&&(!ent.trim().equals(""))))//Si existe una entrada, un catálogo es obligatorio
							mensajes.add(datosResources.getString("CAV.7.3.1.7")+" "+(indexRelacion+1));
						
						if (!mensajes.equals("")){
							ok= false;
						}
						
					}
					
					//ENTRADAS
					if((ok)&&(re.getRecurso()!=null)&&(re.getRecurso().getIdentificador()!=null)){
						String cat=re.getRecurso().getIdentificador().getCatalogo();
						String ent=re.getRecurso().getIdentificador().getEntrada();
						
						if (((ent==null)||(ent.trim().equals("")))&& ((cat!=null)&&(!cat.trim().equals(""))))//Si existe un catálogo, una entrada es obligatoria
							mensajes.add(datosResources.getString("CAV.7.3.2.7")+ " "+(indexRelacion+1));
						
						
						if (!mensajes.equals("")){
							ok= false;
						}
						
					}
				}
			}
			
			// -- ANOTACION --
			if ((lomAv.getAnotaciones()!=null)&&(lomAv.getAnotaciones().length>0)){
				int i;
				boolean todosVacios=true;
				
				for (int indexAnotacion= 0; indexAnotacion<lomAv.getAnotaciones().length; indexAnotacion++){
					
					AvAnnotationVO an= lomAv.getAnotaciones()[indexAnotacion];
					//ENTIDAD
					if(an.getEntidad()!=null){
						String entidad= an.getEntidad().getTexto();
						if ((entidad==null)||(entidad.trim().equals(""))){
							mensajes.add(datosResources.getString("CAV.8.1.8")+" "+(indexAnotacion+1));//El campo Entidad es obligatorio
						}
					}
					
					//FECHA
					boolean fechaVacia=false;
					if(an.getFecha()!=null){
						String fecha= an.getFecha().getFecha();
						if ((fecha==null)||(fecha.equals(""))){
							fechaVacia=true;
						}
					}
					
					boolean descVacios=false;
					if(an.getFecha()!=null && an.getFecha().getDescripcion()!=null && an.getFecha().getDescripcion().getTextos()!=null && an.getFecha().getDescripcion().getTextos().length>0){
						String descFec= an.getFecha().getDescripcion().getTextos()[0].getTexto();
						if ((descFec==null)||(descFec.trim().equals(""))){
							descVacios=true;
						}
					}
		
		
					if(descVacios && fechaVacia)
					{
						mensajes.add(datosResources.getString("CAV.8.2.8")+" "+(indexAnotacion+1));//El campo FECHA es obligatorio
					}else if(descVacios && !fechaVacia)
					{
						mensajes.add(datosResources.getString("CAV.8.2.2.8")+" "+(indexAnotacion+1));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
					}else if(!descVacios && fechaVacia)
					{
						mensajes.add(datosResources.getString("CAV.8.2.1.8")+" "+(indexAnotacion+1));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
					}
					
					
					//DESCRIPCION
					String desc;
					if(an.getDescripcion()!=null && an.getDescripcion().getTextos()!=null && an.getDescripcion().getTextos().length>0){
						for(i=0;i<an.getDescripcion().getTextos().length && todosVacios;i++)
						{
							desc= an.getDescripcion().getTextos()[i].getTexto();
							if(desc!=null && !desc.trim().equals(""))
							{
								todosVacios=false;
							}
						}
						if(todosVacios)
							mensajes.add(datosResources.getString("CAV.8.3.8")+" "+(indexAnotacion+1));//El campo Descripci&oacute;n es obligatorio
					}else
						mensajes.add(datosResources.getString("CAV.8.3.8")+" "+(indexAnotacion+1));//El campo Descripci&oacute;n es obligatorio
				}
			}
			
			if ((lomAv.getClasificaciones()!=null)&&(lomAv.getClasificaciones().length>0)){
				for (int indexClasificacion= 0; indexClasificacion<lomAv.getClasificaciones().length; indexClasificacion++){
					AvClassificationVO cl= lomAv.getClasificaciones()[indexClasificacion];
					
					if(cl.getProposito()!=null){
						if ((cl.getProposito().getValor()==null)||(cl.getProposito().getValor().equals(""))){
							mensajes.add(datosResources.getString("CAV.9.1.9")+" "+(indexClasificacion+1));
						}
					}
					if(cl.getRutasTaxonomicas()!=null && cl.getRutasTaxonomicas().length>0){
						for (int i= 0; i<cl.getRutasTaxonomicas().length; i++){
							if(cl.getRutasTaxonomicas()[i].getFuente()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos().length>0){
								String source= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
								if ((source==null)||(source.trim().equals(""))){
									mensajes.add(datosResources.getString("CAV.9.2.1.9")+" "+(indexClasificacion+1));
								}
							}
							if(cl.getRutasTaxonomicas()[i].getTaxones()!=null && cl.getRutasTaxonomicas()[i].getTaxones().length>0){
								for (int j= 0; j<cl.getRutasTaxonomicas()[i].getTaxones().length; j++){
									if(cl.getRutasTaxonomicas()[i].getTaxones()[j].getId()!=null &&  cl.getRutasTaxonomicas()[i].getTaxones()[j].getEntry()!=null &&
											cl.getRutasTaxonomicas()[i].getTaxones()[j].getEntry().getTextos()!=null && cl.getRutasTaxonomicas()[i].getTaxones()[j].getEntry().getTextos().length>0){ 
										String id= cl.getRutasTaxonomicas()[i].getTaxones()[j].getId().getTexto();
										String entry= cl.getRutasTaxonomicas()[i].getTaxones()[j].getEntry().getTextos()[0].getTexto();
										if ((id==null)||(id.trim().equals(""))||((entry==null)||(entry.trim().equals("")))){
											mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
										}
									}
								}
							}else{
								mensajes.add(datosResources.getString("CAV.9.2.2.9")+" "+(indexClasificacion+1));
							}
						}
					}else{
						mensajes.add(datosResources.getString("CAV.9.2")+" "+(indexClasificacion+1));
					}
				}
			}
	        	
			if(mensajes.size()>0) //hay errores
			{ 
				resultado= "NoValido";
				form.setMensajesError(mensajes);
//				this.saveErrorMessage(request,"catalogadorAvanzado.exportar.error.novalido");
			}else{
				resultado="Valido";
			}
	    	
	        return resultado;
	    }




	    public final void exportarLomes(
	    		ActionMapping mapping, 
	    		ExportarLomesForm form, 
	    		HttpServletRequest request, 
	    		HttpServletResponse response) 
	    throws Exception
	    {
	    	CatalogadorAvSession catAv= this.getCatalogadorAvSession(request);
	        final int BUFFER_SIZE = 2048;

	    	DataHandler dh;
	    	try{
	    		dh= this.getSrvCatalogacionAvanzadaService().exportarLomes(catAv.getIdentificador(), catAv.getUsuario(),catAv.getMDSesion(), catAv.getIdioma());
	    	}catch (Exception e) {
	    		logger.error(e);
	    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
			}
	    	    	
	    	if(dh==null)
	    	{
				logger.error("Fichero  vacio. Abortamos descarga.");
	    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
	    	}
	    	
//	    	 asignamos el titulo del fichero que vamos a exportar
	    	response.setContentType("text/xml;charset=utf-8");
	    	response.setHeader("Content-Disposition", "attachment;filename=metadataLOMES.xml");
	    	OutputStream out = response.getOutputStream();
	    	
	    	InputStream in = dh.getInputStream();
	    	logger.debug("Descargando metadata.xml");
			byte[] buffer = new byte[BUFFER_SIZE];
			int count;
			while((count = in.read(buffer, 0, BUFFER_SIZE))!= -1)
			{
				out.write(buffer, 0, count);
			}
			
			out.flush();
	    }





		public String evaluarRegreso(
				ActionMapping mapping,
				EvaluarRegresoForm form, 
				HttpServletRequest request,
				HttpServletResponse response) 
		throws Exception 
		{
			
			return form.getRegreso();
		}







}