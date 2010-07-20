/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.entregar.negocio.servicios;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.entregar.negocio.utils.GeneradorHtml;
import es.pode.entregar.negocio.utils.OrganizationStringComparator;
import es.pode.entregar.servicio.dominio.EntregarDozerDao;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Organization;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.soporte.serializar.SerializadorObjetos;
import es.pode.soporte.uuid.PodeUUIDGenerator;
import es.pode.validador.negocio.servicio.SrvValidadorService;
import es.pode.validador.negocio.servicio.ValidaVO;

/**
 * @see es.pode.entregar.negocio.servicios.SrvEntregarService
 */

public class SrvEntregarServiceImpl extends
		es.pode.entregar.negocio.servicios.SrvEntregarServiceBase {
 	
	private Map colaGeneracionZip= new HashMap();
	private static final long TiempoBloqueoZip =300000;
	private static final String BARRA="/";
	
	protected static final Logger logger = Logger
			.getLogger(SrvEntregarServiceImpl.class);

	private HashMap tablaHash = new HashMap(5);

	private EntregarDozerDao entregarDao;
    
	private Properties prop= new Properties();
	public static final String MANIFEST_NAME = "imsmanifest.xml";
	

	/**
	 * Este metodo recibe un identificador de un ODE.
	 * Devuelve el paquete PIF con todos los elementos que contiene el ODE.
	 * Para entregar el paquete, el metodo tiene que localizar la informacion referente al ODE 
	 * en disco (invocar al localizador), despues tiene que validar la 
	 * informacion (invocar al validador) para despues generar el paquete.
	 * 
	 * @param identificador: Identificador del ODE del que se requiere el paquete.
	 * @return PaquetePifVO: Fichero conteniendo el ODE en formato PIF.
	 */

	protected PaquetePifDriVO handleGenerarPaquetePIF(
			java.lang.String identificador) throws java.lang.Exception {
		
		PaquetePifDriVO paquetePif = new PaquetePifDriVO();
		// inicializo un DataHandler porque es la salida.
		DataHandler dh = null;
		// localizador

		try {
			logger.debug("Llammos al servicio de localización");
			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			String pathComprimir = localizadorService.consultaLocalizador(identificador).getPath();
			logger.debug("El path comprimir es = " + pathComprimir);
			SrvValidadorService validadorService = this.getSrvValidadorService();
			logger.debug("Validamos el fichero");
			ValidaVO valid = validadorService.obtenerValidacionBin(pathComprimir);
			CBValidoVO valida = new CBValidoVO();
			valida.setEsValidoManifest(valid.getEsValidoManifest());
			valida.setResultadoValidacion(valid.getResultadoValidacion());
			valida.setRutaManifest(valid.getRutaManifest());
			paquetePif.setResultadoValidacion(valida);//añadimos el resultado de validacion al VO que se devuelve
			
			logger.debug("Despues de validar = " + valid.getEsValidoManifest());
			if (valid.getEsValidoManifest().booleanValue()) {
				InputStream io= this.getClass().getResourceAsStream("/entregar.properties");
				if(io!=null) prop.load(io);
				
				String carpetaExport=pathComprimir+ prop.getProperty("carpeta.temporal");
				File carpetaExportFile=new File(carpetaExport);
				if(!carpetaExportFile.exists())
					carpetaExportFile.mkdirs();
				carpetaExportFile=null;
				

				File exportar= new File(carpetaExport + "/" + identificador + ".zip");
				String pathZip= exportar.getAbsolutePath().replace('\\', '/');
				
				if(exportar.exists())
					exportar.delete();

				logger.debug("Vamos a generar el zip en el directorio = " + pathZip);
				try {
					this.getZipDao().comprimir(pathZip,pathComprimir);
					dh = new DataHandler(new FileDataSource(exportar));
					if(dh!=null)
						logger.debug("\n\n\n nombre del datahandler   = " +  dh.getName() + "\n\n");
					else
						logger.debug("\n\n\n datahandler es null \n\n");

					logger.debug("Devolvemos VO paquetePif");
					paquetePif.setPaquetePIF(dh);//añadimos un datahandler, con el contenido del ODE, al VO que se devuelve 
					return paquetePif;
				}

				catch (Exception e) {
					if (logger.isDebugEnabled()) {logger.debug("Error en SrvEntregarServiceImpl:GenerarPaquetePif : " + e.getMessage());}
					throw e;
				}

			} // if
		}// try

		catch (Exception e) {
			if (logger.isDebugEnabled()) {logger.debug("Error en SrvEntregarServiceImpl:GenerarPaquetePif : " + e.getMessage());}
			throw e;
		}
		logger.debug("Devolvemos VO paquetePif");
		paquetePif.setPaquetePIF(dh);
		return paquetePif;
	}
	

	/**
	 * Este metodo elimina la carpeta temporal contenedora del paquete a exportar.
	 * Elimina recursivamente todos los ficheros existentes en su interior, y luego 
	 * se elimina la carpeta temporal.
	 * 
	 * @param path: File carpeta temporal que contiene el paquete a exportar
	 * @return :boolean devuelve true si ha podido eliminar todos los ficheros 
	 * 			de la carpeta path
	 */
	  private boolean borrarCarpeta(File path)
	  {
	    if( path.exists() ) {
	      File[] files = path.listFiles();
	      for(int i=0; i<files.length; i++) {
	         if(files[i].isDirectory()) {
	        	 borrarCarpeta(files[i]);
	         }
	         else {
	           files[i].delete();
	         }
	      }
	    }
	    return( path.delete() );
  }
	

	/**
	 * Este metodo se comporta como el homonimo de la clase pero permite configurar el formato 
	 * del fichero PIF que se devuelve entre la coleccion de formatos que se soportan por la clase TiposPIF.
	 * Toma como parametro de entrada un objeto TipoPifVO que contiene 
	 * el identificador del ODE y el tipo de fichero PIF 
	 * que desea a la salida de entre los posibles por la clase TipoPIF.
	 * Devuelve el ODE el formato PIF con el tipo escogido.
	 * 
	 * @param tipoPifVO: Value Object que contiene el Id del ODE y el tipoPif
	 * @return PaquetePifVO : Fichero conteniendo el ODE en el formato especificado.
	 */
	protected PaquetePifVO handleGenerarPaquetePIFTipoPIF(TipoPifVO tipoPifVO) throws Exception 
	{
		PaquetePifVO paquetePif= new PaquetePifVO();
		File exportar=null;
		File ficheroZip=null;
		String pathZip= "";
		
		
		logger.info("identificador:  " + tipoPifVO.getIdODE());
		logger.info("tipoPif:  " + tipoPifVO.getTipoPif());
		
		try {
			logger.debug("chequeo si el tipoPif es válido");
			TipoPIFCst.fromString(tipoPifVO.getTipoPif());
			
			logger.debug("Llamamos al servicio de localización");
			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			String pathODE = localizadorService.consultaLocalizador(tipoPifVO.getIdODE()).getPath();
			logger.debug("El path del Ode a comprimir es = " + pathODE);
			SrvValidadorService validadorService = this.getSrvValidadorService();
			logger.debug("Validamos el fichero manifest");
			ValidaVO valid = validadorService.obtenerValidacionBin(pathODE);
			//valid.setErrores();
			
			CBValidoVO valida = new CBValidoVO();
			valida.setEsValidoManifest(valid.getEsValidoManifest());
			valida.setResultadoValidacion(valid.getResultadoValidacion());
			valida.setRutaManifest(valid.getRutaManifest());
			
			paquetePif.setResultadoValidacion(valida);
						
			logger.debug("\nResultado validacion = " + valid.getResultadoValidacion());
			logger.debug("Despues de validar = " + valid.getEsValidoManifest());
			if (!valid.getEsValidoManifest().booleanValue()) {
				logger.info("El ODE no es válido, se envía el zip y los mensajes de validación..");
			}
				if(logger.isDebugEnabled()) logger.debug("cargo las propiedades de la aplicación");
				InputStream io= this.getClass().getResourceAsStream("/entregar.properties");
				if(io!=null) prop.load(io);
				
				if(logger.isDebugEnabled()) logger.debug("creo fichero zip y carpeta temporal");
				File zipDir=new File(pathODE+ prop.getProperty("carpeta.temporal")+ tipoPifVO.getTipoPif().toString()+ BARRA + tipoPifVO.getIdODE());
				
				if(!zipDir.exists())
					zipDir.mkdirs();

				if(!zipDir.canWrite())
				{
					logger.error("\n\n el directorio donde deben crearse los ficheros zip no se puede escribir. comuniquese con el administrador\n\n");
					throw new Exception("El directorio donde se generan los ficheros a exportar no existe o no tiene permisos de escritura.. comuniquese con el administrador..");
				}

				
				pathZip= zipDir.getCanonicalPath() + obtenerNombreZip(pathODE, tipoPifVO.getIdioma(),tipoPifVO.getIdODE());
				ficheroZip= new File(pathZip);
				
				pathZip= ficheroZip.getCanonicalPath().replace('\\', '/');
				
				
				
				
				while(bloquearZip(pathZip)) // pregunto si está siendo utilizado
				{
					logger.debug("el fichero zip no es accesible.. comienza la espera .... " + (new Date()).toString() );
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						logger.debug("SrvEntregarServiceImpl.generarPaquetePifTipoPif: error en la espera cuando se generaba el fichero zip");
					}
					logger.debug("acabó la espera .... " + (new Date()).toString() + " intento bloquear el fichero zip.");
				}
				
				
//				opciones
//				1.- el fichero no existe... lo tengo que crear si o si
//				2.- el fichero existe.. 
//					2.1 - origen = publicados..
//						2.1.1.- fichero viejo.. lo elimino y vuelvo a generar
//						2.1.2.- fichero no es tan viejo.. devuelvo el que ya existe
//					2.2.- origen= personales
//						2.2.1.- elimino el fichero y vuelvo a generarlo

				
				boolean existe= false;
				boolean publicado=false;
				boolean viejo=false;
				if(ficheroZip.exists())
				{
					existe=true;
					if(pathZip.indexOf(prop.getProperty("publicacionUrlBase")) !=-1) // es  uno publicado
					{
						Date ahora= new Date();
						long diferencia = ahora.getTime() - ficheroZip.lastModified() ;
						
						String tiempoStr="";
						try {
							tiempoStr=AgregaPropertiesImpl.getInstance().getProperty("tiempolimite");
							logger.debug("tiempo limite: " + tiempoStr);
						} catch (RuntimeException e) {
							logger.debug("no existe definido el parametro tiempolimite en el fichero agrega.properties; se define como tiempolimite por defecto un tiempo de 7 dias");
							tiempoStr="604800000";
						}
						
						long limiteTiempo= Long.parseLong(tiempoStr);
						publicado=true;
						if(diferencia > limiteTiempo  )
						{
							viejo=true;
						}
					}
				}
				
				
				
				if(!existe || ( existe && !publicado) || (existe && publicado && viejo) )
				{
					logger.debug("si el zip existe ... lo elimino..");
					if(ficheroZip.exists())
						ficheroZip.delete();
					ficheroZip=null;
	
					String carpetaExport= zipDir.getAbsolutePath() + BARRA + "exp-" +tipoPifVO.getIdODE();
					//crear la carpeta temporal....	
					exportar= new File(carpetaExport);
					carpetaExport= exportar.getCanonicalPath().replace('\\', '/');
					
					if(!exportar.exists())
					{
						if(logger.isDebugEnabled()) logger.debug("no existe la carpeta temporal... creo una vacia ");
						exportar.mkdirs();
					}else{
						if(logger.isDebugEnabled()) logger.debug("existe una carpeta temporal... la vacio");
						borrarCarpeta(exportar);
					}
	
					String[] excludeList;
	
					
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//				tipo SCORM 2004 SIN SUBMANIFEST
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					if(tipoPifVO.getTipoPif().equals(TipoPIFCst.SCORM_04_SIN_SUBMANIF.toString()))
					{
						if(logger.isDebugEnabled()) logger.debug("se ha seleccionado Scorm04SinSubmanif");
						if(logger.isDebugEnabled()) logger.debug("genero la carpeta que llevara el nuevo manifest");
						StringBuffer nuevoManifest= new StringBuffer(carpetaExport);
						nuevoManifest.append(BARRA).append(MANIFEST_NAME);
						File fileManifest =new File(nuevoManifest.toString());
						this.getScormDao().escribirODE(aplanarManifest(tipoPifVO.getIdODE()), fileManifest );
						fileManifest = null;
						
						excludeList= new String[1];
						excludeList[0]=MANIFEST_NAME;
						
						if(logger.isDebugEnabled()) logger.debug("genero el zip sin el manifest");
						this.getZipDao().comprimir(pathZip, pathODE, excludeList);
						if(logger.isDebugEnabled()) logger.debug("agrego al zip el manifest generado");
						this.getZipDao().comprimir(pathZip, carpetaExport);
					}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//				tipo SCORM 1.2 E IMSCP
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					else if(tipoPifVO.getTipoPif().equals(TipoPIFCst.SCORM_12.toString() ) || 
							tipoPifVO.getTipoPif().equals(TipoPIFCst.IMS_CP.toString()))
					{
						if(logger.isDebugEnabled()) logger.debug("el tipo pif no es SCORM2004, por lo que voy a transformar el manifest");
						File xmlFile=null;
						File xslFile=null;
						FileOutputStream xmlResult=null;
						String xslt="";
						String schemas="";
	
						if(logger.isDebugEnabled()) logger.debug("genero el zip sin los esquemas del scrom2004");
						excludeList= prop.getProperty("esquemasSCORM2004").split(",");
						this.getZipDao().comprimir(pathZip, pathODE, excludeList);
	
						if(tipoPifVO.getTipoPif().equals(TipoPIFCst.SCORM_12.toString()))
						{
							if(logger.isDebugEnabled()) logger.debug("se ha seleccionado SCORM_12 .. voy a modificar el manifest");
							xslt=prop.getProperty("transformacion.scorm12.xslt");
							if(logger.isDebugEnabled()) logger.debug("xslt a utilizar.. " + xslt);
							//copiar los esquemas del scorm1.2
							schemas= prop.getProperty("transformacion.scorm12.schema");
							if(logger.isDebugEnabled()) logger.debug("agrego al zip los ficheros del esquema de SCORM1.2");
							this.getZipDao().comprimir(pathZip, schemas);
							
						}else if(tipoPifVO.getTipoPif().equals(TipoPIFCst.IMS_CP.toString()))
						{
							if(logger.isDebugEnabled()) logger.debug("se ha seleccionado IMS_CP .. voy a modificar el manifest");
							xslt=prop.getProperty("transformacion.imscp.xslt");
							if(logger.isDebugEnabled()) logger.debug("xslt a utilizar.. " + xslt);
							schemas= prop.getProperty("transformacion.imscp.schema");
							if(logger.isDebugEnabled()) logger.debug("agrego al zip los ficheros del esquema de ISC_MP");
							this.getZipDao().comprimir(pathZip, schemas);
						}
	
						if(logger.isDebugEnabled()) logger.debug("");
						xmlResult= new FileOutputStream(carpetaExport+ BARRA +MANIFEST_NAME);
						if(logger.isDebugEnabled()) logger.debug("fichero resultado:"+ carpetaExport + BARRA + MANIFEST_NAME);
						xmlFile= new File(pathODE+ BARRA +MANIFEST_NAME);
						if(logger.isDebugEnabled()) logger.debug("ruta del origen " + xmlFile.getAbsolutePath());
						xslFile= new File(xslt);
						if(logger.isDebugEnabled()) logger.debug("ruta del xsl " + xslFile.getAbsolutePath());
	
						Source xmlSource = new StreamSource(xmlFile);
						Source xslSource = new StreamSource(xslFile);
						Result result = new StreamResult(xmlResult);
						TransformerFactory factory= TransformerFactory.newInstance();
						Transformer transformer= factory.newTransformer(xslSource);
						transformer.transform(xmlSource,result);
	
						if(logger.isDebugEnabled()) logger.debug("agrego al zip el manifest generado");
					this.getZipDao().comprimir(pathZip, carpetaExport);

					try {
						if(xmlResult!=null )
							xmlResult.close();
						xmlResult=null;
					} catch (Exception e) {
					}
						
					}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//				HTML y CONTENIDOS
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					else if(tipoPifVO.getTipoPif().equals(TipoPIFCst.HTML.toString()))
					{
						if(logger.isDebugEnabled()) logger.debug("genero el zip sin los esquemas del scrom2004");
						excludeList = prop.getProperty("esquemasSCORM2004").split(",");
						this.getZipDao().comprimir(pathZip + "/contenido", pathODE, excludeList);
					
						GeneradorHtml gen= new GeneradorHtml();
						if(tipoPifVO.getTipoPif().equals(TipoPIFCst.HTML.toString()))
						{
							if(logger.isDebugEnabled()) logger.debug("agrego al zip la carpeta de estilos static");
							this.getZipDao().comprimir(pathZip + BARRA +  "contenido" + BARRA + "static", prop.getProperty("carpeta.static"));
							
	//						ManifestVO orgs= this.obtenerOrganizaciones(tipoPifVO.getIdODE(), "", "es");
	//						gen.generarFrames(pathComprimir, carpetaExport,orgs);
							if(logger.isDebugEnabled()) logger.debug("creo los ficheros html necesarios para el index");
							gen.generarFrames(pathODE, carpetaExport);
						}
						if(logger.isDebugEnabled()) logger.debug("creo la carpeta Catalogacion y genero los metadatos");
						gen.obtenerLOMES(pathODE, carpetaExport, "catalogacion",
								"catalogacionLomes.xml");
						if(logger.isDebugEnabled()) logger.debug("agrego al zip los ficheros generados");
						this.getZipDao().comprimir(pathZip, carpetaExport);
					}
					else if (tipoPifVO.getTipoPif().equals(
							TipoPIFCst.CONTENIDOS.toString())) {
						if (logger.isDebugEnabled()) {
							logger.debug("Generating simple content package.");
						}
						excludeList = prop.getProperty("simplePkgExcludeList").split(",");
						// Pack the resource content under "content"
						this.getZipDao().comprimir(
								pathZip + File.separator + "content",
								pathODE,
								excludeList);

						GeneradorHtml gen = new GeneradorHtml();
						if (logger.isDebugEnabled()) {
							logger.debug("creo la carpeta Catalogacion y genero los metadatos");
						}

						// Pack the LOM under "metadata"
						gen.obtenerLOMES(pathODE, carpetaExport, "metadata",
								"LOM-NDRB.xml");
						if (logger.isDebugEnabled()) {
							logger.debug("agrego al zip los ficheros generados");
						}
						this.getZipDao().comprimir(pathZip, carpetaExport);
					}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//				tipo SCORM 2004
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					else // si el tipoPif no es reconocido.. se devuelve por defecto un paquete del tipo SCORM 2004
					{
						if(logger.isDebugEnabled()) logger.debug("se ha seleccionado Scorm04 ");
						//agrego todo los ficheros al zip
						this.getZipDao().comprimir(pathZip, pathODE);
						
					}
					if(exportar!=null && exportar.exists())
						borrarCarpeta(exportar );
	
				
				}else
				{
					logger.debug("\n\n el fichero zip ya existe y no es necesario volver a generarlo... se devuelve el existente..\n\n");
				}

				
				desbloquearZip(pathZip);

				
				int inicio = pathZip.indexOf(prop.getProperty("publicacionUrlBase"));
				if(inicio<0)
					inicio= pathZip.indexOf(prop.getProperty("tallerUrlBase") );
				if(inicio<0)
					inicio=0;
				
				
				paquetePif.setHref(pathZip.substring( inicio, pathZip.length()));
				if(paquetePif.getHref()!=null)
					logger.debug("path del ode: " + paquetePif.getHref());


		}catch (Exception e) {
			if(exportar!=null && exportar.exists())
				borrarCarpeta(exportar );
			if(pathZip!=null && !pathZip.equals(""))
			{
				if(ficheroZip==null)
					ficheroZip = new File(pathZip);
				
				if(ficheroZip.exists())
					ficheroZip.delete();
				
				ficheroZip=null;
			}
			if (logger.isDebugEnabled()) {logger.error("Error en SrvEntregarServiceImpl:GenerarPaquetePifTipoPif : " + e.getMessage());}
			throw e;
		}
		logger.debug("Devolvemos VO paquetePif");
		return paquetePif;

	}

	
	private Manifest aplanarManifest(String identificador) throws Exception
	{
		Manifest manifest= null;
		manifest= new Manifest();
		logger.debug("Llamamos al servicio de localización");
		SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
		
		logger.debug("Llammos al servicio de localización con el identificador = " + identificador);
		LocalizadorVO localVo = localizadorService.consultaLocalizador(identificador);
		
		StringBuffer sbPath = new StringBuffer();
		sbPath.append(localVo.getPath()).append("/").append(MANIFEST_NAME);
		logger.debug("El objeto se ecuentra en la ruta = " + sbPath);
//		String localizacion = localVo.getUrl();
		String sRuta = sbPath.toString().replace('\\', '/');

		logger.debug("Miro el fichero en la ruta = " + sRuta);
		File rutaManifest = new File(sRuta);
		logger.debug("Parseamos el objeto");
		if (rutaManifest.exists()) {
			manifest = this.getScormDao().parsearODELazy(rutaManifest);
		}
		logger.debug("Objeto parseado");		
		
		procesarManifest(manifest , true,null);

		return manifest;
	}
	

	private void procesarManifest(Manifest manifest, boolean resetearIDs, HashMap<String, Item> aplanados)
	throws java.lang.Exception 
	{
		ManifestAgrega ma = new ManifestAgrega(manifest);
		
//		aplanarOrganizaciones(manifest);

		/*
		 * Cambios en empaquetador movidos a entregar: Aplanamos todos los
		 * recursos de los submanifiestos y despues los submanifiestos.
		 */
		if(resetearIDs) aplanarRecursosDeSubmanifiestos(manifest);
		
		aplanarSubmanifiestos(manifest, aplanados);
		if(resetearIDs) {
			ma.resetearIds();
		}
	}
	private void aplanarRecursosDeSubmanifiestos(Manifest manifest) {
		String base = null;
		if(logger.isDebugEnabled()) logger.debug("Aplanando recursos de submanifiestos");
		for(int i=0;i<manifest.getManifestCount();i++) {
			// Aplano el submanifiesto
			base =  manifest.getManifest(i).getBase()==null?"":manifest.getManifest(i).getBase();
			aplanarRecursosDeSubmanifiestos(manifest.getManifest(i));
			if(manifest.getManifest(i).getResources()!=null){
				for(int j=0;j<manifest.getManifest(i).getResources().getResourceCount();j++) {
					Resource resource = manifest.getManifest(i).getResources().getResource(j);
					resource = aplanaRecurso(resource,base);
					manifest.getResources().addResource(resource);
				}
			}
		}
	}
	private Resource aplanaRecurso(Resource res, String base) {
		if (res.getHref() != null) {
			// Compruebo si href apunta a un file (sino, es URL)
			for (int i = 0; res.getFile() != null && i < res.getFile().length; i++) {
				if (res.getFile(i).getHref().equals(res.getHref())) {
					if (logger.isDebugEnabled())
						logger.debug("Aplanado href de recurso "
								+ res.getIdentifier());
					res.setHref(base + res.getHref());
					break;
				}
			}
		}
		// Aplano los File
		for (int i = 0; res.getFile() != null && i < res.getFile().length; i++) {
			if (logger.isDebugEnabled())
				logger.debug("Aplanado file de recurso " + res.getIdentifier()
						+ " : " + res.getFile(i).getHref() + " por " + base
						+ res.getFile(i).getHref());
			res.getFile(i).setHref(base + res.getFile(i).getHref());
		}
		return res;
	}
	
	private static Organization getOrganizacionPrincipal(Manifest manifest) {
		String principalId = manifest.getOrganizations().getDefault();
		int principalIndex = Arrays.binarySearch(manifest.getOrganizations()
				.getOrganization(), principalId, new OrganizationStringComparator());
		Organization principal = manifest.getOrganizations().getOrganization(
				principalIndex);
		return principal;
	}	
	

	private void aplanarSubmanifiestos(Manifest manifest, HashMap<String, Item> aplanados) throws Exception {
		if(aplanados==null) aplanados = new HashMap<String, Item>(10);
		Organization org = getOrganizacionPrincipal(manifest);
		if (org.getItemCount() > 0)
			aplanaSubmanifiestoEnItems(org.getItem(), manifest, aplanados);
		// Elimino los submanifiestos una vez aplanados
		manifest.setManifest(new Manifest[] {});
	}

	private void aplanaSubmanifiestoEnItems(Item[] items, Manifest manifest,
			HashMap<String, Item> aplanados) throws Exception {
		ManifestAgrega ma = new ManifestAgrega(manifest);
		for (int i = 0; i < items.length; i++) {
			if (items[i].getItemCount() > 0) {
				/*
				 * Me interno primero en los hijos ya que cuando se aplane el
				 * submanifiesto, el item pasara a tener nuevos hijos.
				 */
				if (logger.isDebugEnabled())
					logger.debug("Iterando en los hijos de "
							+ items[i].getIdentifier());
				aplanaSubmanifiestoEnItems(items[i].getItem(), manifest,
						aplanados);
			}
			// Comprueba idRef
			if (items[i].getIdentifierref() != null) {
				Object obj = ma.obtenerElemento(items[i].getIdentifierref());
				if (obj instanceof Manifest || aplanados.containsKey(items[i].getIdentifierref())) {
					if (logger.isDebugEnabled())
						logger.debug("Submanifiesto "
								+ items[i].getIdentifierref()
								+ " referenciado por "
								+ items[i].getIdentifier());
					
					Item submanifiestoAplanado = null;
					if (aplanados.containsKey(items[i].getIdentifierref())) {
						/*
						 * Para evitar keys duplicadas al terminar de aplanar,
						 * debo clonar el Item de la cache, de lo contrario, al
						 * resetear IDs se generan IDs iguales para multiples
						 * elementos (referencias).
						 */
						Item tmp = (Item) aplanados.get(items[i].getIdentifierref());
						submanifiestoAplanado = (Item) getBeanMapper().map(tmp,
								Item.class);
						if (logger.isDebugEnabled())
							logger.debug("Submanifiesto "
									+ items[i].getIdentifierref()
									+ " recuperado de la cache de aplanados");
					} else {
						Manifest submanifiesto = (Manifest) obj;
						if (logger.isDebugEnabled())
							logger.debug("Procesando submanifiesto "
									+ items[i].getIdentifierref()
									+ " antes de aplanar");
						procesarManifest(submanifiesto,false,aplanados);
						if (logger.isDebugEnabled())
							logger.debug("Aplanando submanifiesto");
						submanifiestoAplanado = aplanarSubmanifest((Manifest) obj);
						if (logger.isDebugEnabled())
							logger
									.debug("Introduciendo submanifiesto aplanado en la cache aplanados");
						aplanados.put(submanifiesto.getIdentifier(),
								submanifiestoAplanado);
						if (logger.isDebugEnabled())
							logger
									.debug("Aplanando los recursos del submanifiesto");
//						aplanarRecursos(manifest, submanifiesto);
					}
					if (logger.isDebugEnabled())
						logger.debug("Insertando submanifiesto aplanado "
								+ items[i].getIdentifierref() + " en Item "
								+ items[i].getIdentifier());

					/*
					 * Cambios del C27: Se ha solicitado que al previsualizar
					 * items que referencian a submanifiestos se imite la
					 * estructura creada por los LMSs clasicos: el item que
					 * referencia hereda el título de la organización principal
					 * del submanifiesto y pierde el propio.
					 * El importar de empaquetador básico debe reproducir esta estructura.
					 */
//					items[i].addItem(0, submanifiestoAplanado);
					items[i].setTitle(submanifiestoAplanado.getTitle());
					ArrayList<Item> listaTmp = new ArrayList<Item>(); 
					listaTmp.addAll(Arrays.asList(submanifiestoAplanado.getItem()));
					if(items[i].getItemCount()>0) listaTmp.addAll(Arrays.asList(items[i].getItem()));
					items[i].setItem(listaTmp.toArray(new Item[listaTmp.size()]));
					
					items[i].setIdentifierref(null);
				}
			}

		}
	}

	

	private Item aplanarSubmanifest(Manifest subManifest)
	throws java.lang.Exception 
	{
		Item itemManifest = new Item();
		// Id del Item = Id de la organizacion principal
		itemManifest.setIdentifier(PodeUUIDGenerator.getItemUUID(String
				.valueOf(java.lang.Math.random())));
		itemManifest.setItem(getOrganizacionPrincipal(subManifest).getItem());
		itemManifest.setTitle(obtenerTituloSubmanifiesto(subManifest,
				getOrganizacionPrincipal(subManifest).getTitle()));
		
		return itemManifest;
	}

private String obtenerTituloSubmanifiesto(Manifest submanifiesto,
	String porDefecto) throws Exception 
	{
		String resultado = null;
		ManifestAgrega ma = new ManifestAgrega(submanifiesto);
		Lom lomes = ma.obtenerLom(submanifiesto.getIdentifier(), null);
		if (lomes == null) {
			resultado = porDefecto;
		} else {
			LomAgrega la = new LomAgrega(lomes);
			String titulo = la.getGeneralAgrega().getTitulo(
					la.getMetaMetadataAgrega().getIdioma());
			if (titulo == null)
				resultado = porDefecto;
			else
				resultado = titulo;
		}
		return resultado;
	}


	/**
	 * Metodo obtenerObjManifest
	 * El Empaquetador, llamara a este metodo del servicio para guardar el manifest en memoria;
	 * El método cogerá el objeto serializado lo deserializará obtendrá un manifest y lo metará en memoria (HashMap)
	 * Devolvera un string que sera el identificador este identificador estara formado con el id del 
	 * manifest (manifest.getIdentifier()) y el prefijo EMP
	 * 
	 * @param fichManifest: Objeto Manifest serializado.
	 * @param usuario: usuario.
	 * @return String: el identificador.
	 */
	protected String handleCargarObjManifest(String usuario,
			DataHandler fichManifest) throws Exception {

		String identificador = null;
		if (fichManifest.getContentType().equals(
				"application/x-java-serialized-object")) {
			// Deserializamos el objeto a un Manifest
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			fichManifest.writeTo(baos);
//			Object tmp = deserializar(baos.toByteArray());
			Manifest manifest = null;
			SerializadorObjetos so= new SerializadorObjetos();
			Object tmp= so.deserializarObjeto(fichManifest);
			logger.debug("ESTO ES LO QUE SE RECUPERA COMO MANIFEST: " + tmp);
			if (tmp instanceof Manifest)
				manifest = (Manifest) tmp;
			else {
				Logger.getLogger(this.getClass()).error(
						"El objeto recibido no es un Manifest");
				throw new Exception("El objeto recibido no es un Manifest");
			}

			identificador = "EMP" + manifest.getIdentifier();
			if (tablaHash == null)
				tablaHash = new HashMap(5);
			tablaHash.put(identificador, manifest);
		} else
			throw new Exception("No existe objeto para cargar");

		return identificador;
	}
	
	
	

	private Object deserializar(byte[] entrada) 
	throws Exception 
	{
		ByteArrayInputStream bs = new ByteArrayInputStream(entrada);
		ObjectInputStream is = new ObjectInputStream(bs);
		Object salida = null;
		try {
			salida = is.readObject();
		} catch (Exception e) {
			logger.error("Ha fallado al deserializar el objeto");
		}
		is.close();
		return salida;
	}

	 /**
	 * ObtenerOrganizaciones: Método que obtiene todas las organizaciones que se encuentren en el 
	 * Manifest del objeto educativo que se desea visualizar. 
	 * Al obtener las organizaciones, se obtienen también los ítems que las componen y 
	 * los recursos de los cuales consta el objeto educativo, además de los submanifiestos
	 * para los cuales realizamos un tratamiento específico haciendo la transformación de sus
	 * organizaciones en items adaptando su estructura.
	 * 
	 * @param argObtenerOrganizaciones: objeto que empaqueta el id del ode, el usuario y el idioma
	 * @return ManifestVO: Devuelve el tipo ManifestVO con los datos para ese identificador y usuario
	 */
	protected ManifestVO handleObtenerOrganizaciones(
			ArgObtOrganizacionesVO argObtenerOrganizaciones) 
	throws Exception 
	{
		String identificador= argObtenerOrganizaciones.getIdentificador();
		String idioma= argObtenerOrganizaciones.getIdiomaTitulo();
		
		String prefijo = identificador.substring(0, 3);

		Manifest manifestFile = null;
		String localizacion = null;
		// si es distinto a EMP no tiene hashmap
		logger.debug("Llammos al servicio de localización");
		SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
		
		if (!(prefijo.equals("EMP"))) 
		{
			logger.debug("Llammos al servicio de localización con el identificador = " + identificador);
			LocalizadorVO localVo = localizadorService.consultaLocalizador(identificador);
			
			StringBuffer sbPath = new StringBuffer();
			sbPath.append(localVo.getPath());
			sbPath.append("/imsmanifest.xml");
			logger.debug("El objeto se ecuentra en la ruta = " + sbPath);
			localizacion = localVo.getUrl();
			String sRuta = sbPath.toString().replace('\\', '/');

			logger.debug("Miro el fichero en la ruta = " + sRuta);
			File rutaManifest = new File(sRuta);
			logger.debug("Parseamos el objeto");
			if (rutaManifest.exists()) {
				manifestFile = this.getScormDao().parsearODELazy(rutaManifest);
			}
			logger.debug("Objeto parseado");
		}// if (!(prefijo.equals("EMP")))
		else// prefijo.equals("EMP")
		{
			manifestFile = (Manifest) tablaHash.get(identificador);
			String sIdentificador = identificador.substring(prefijo.length(),
					identificador.length());
			logger.info("Identificador = " + sIdentificador);
			LocalizadorVO localVo = localizadorService
					.consultaLocalizador(sIdentificador);
			localizacion = localVo.getUrl();
		}
//		Añadimos el Titulo del ODE o en su Defecto "Nuevo ODE"
		ManifestAgrega mA = new ManifestAgrega(manifestFile);
		String tituloOde=null;
		
		Lom lomes = mA.obtenerLom(manifestFile.getIdentifier(), null);
		if(lomes!=null)
		{
			LomAgrega lom = new LomAgrega(lomes); 
			tituloOde= lom.getGeneralAgrega().getTitulo(idioma);
			if(tituloOde == null) tituloOde = lom.getGeneralAgrega().getTitulo(null);
		}

		EntregarDozerDao entregarDao = this.getEntregarDozerDao();
		ManifestVO manifestVo = entregarDao
				.transformarManifest2VO(manifestFile);
		manifestVo.setLocalizacionURL(localizacion);
		if ((tituloOde!=null) && (!tituloOde.equals(""))) {
			manifestVo.setTitulo(tituloOde);
		} else {
			manifestVo.setTitulo("Nuevo ODE");
		}
		return manifestVo;
	}

	/**
	 * Este metodo devuelve un array de Strings con todos los tipos de formatos PIF que 
	 * maneja el modulo de Entregar. Los propios Strings son identificadores para ulteriores 
	 * llamadas de peticion de conversion de formato de ODEs.
	 * 
	 * @return String[]: Array de Strings con con los tipos de formatos PIF soportados.
	 */
	protected String[] handleObtenerTiposPIF() throws Exception {
		return (String[])TipoPIFCst.literals().toArray(new String[0]);
	}

	/**
	 * @return the entregarDao
	 */
	public EntregarDozerDao getEntregarDao() {
		return entregarDao;
	}

	/**
	 * @param entregarDao
	 *            the entregarDao to set
	 */
	public void setEntregarDao(EntregarDozerDao entregarDao) {
		this.entregarDao = entregarDao;
	}

	protected boolean handleEstoyActivo() throws Exception {

		return true;
	}

	private String obtenerNombreZip(String pathOde  , String idioma, String identificador)
	{
		String resultado=null;
		
		try {
			String tituloOde="ODE";
			if(identificador!=null)
				tituloOde= identificador;
			
			String sRuta =pathOde + "/imsmanifest.xml"; 
			sRuta.replace('\\', '/');

			logger.debug("Miro el fichero en la ruta = " + sRuta);
			File rutaManifest = new File(sRuta);
			logger.debug("Parseamos el objeto");
			Manifest manifestFile=null;
			if (rutaManifest.exists()) {
				manifestFile = this.getScormDao().parsearODELazy(rutaManifest);
				logger.debug("Objeto parseado");
			}
			
			ManifestAgrega mA =null;
			if(manifestFile!=null)
			{
				mA = new ManifestAgrega(manifestFile);
			}
				
			Lom lomes = null;
			if(mA!=null)
				lomes = mA.obtenerLom(manifestFile.getIdentifier(), null);
				
			if(lomes!=null)
			{
				LomAgrega lom = new LomAgrega(lomes); 
				tituloOde= lom.getGeneralAgrega().getTitulo(idioma);
				if(tituloOde == null) tituloOde = lom.getGeneralAgrega().getTitulo(null);
				logger.debug("el titulo del ode será : " + tituloOde );
			}else
			{
				logger.debug("el ODE no tiene lomes... se utilizará el identificador para formar el nombre del zip: " + tituloOde );
			}
			
			String tituloEnc = tituloOde.replace(' ', '_');
			tituloEnc = tituloEnc.replace('?', '_').replace('¿', '_').replace('/', '_').replace('[', '_').replace(']', '_').replace('@', '_');
			tituloEnc = tituloEnc.replace('ñ', 'n').replace('Ñ', 'N').replace(':', '_');
			tituloEnc = convertNonAscii(tituloEnc);
			
			resultado = "/" + tituloEnc+ ".zip";
			logger.debug("nombre del zip: " + resultado);
		} catch (ParseadorException e) {
			logger.error("Error!!!! - error en SrvEntregar.obtenerNombreZip: " + e.getMessage());
		} catch (Exception e) {
			logger.error("Error!!!! - error en SrvEntregar.obtenerNombreZip: " + e.getMessage());
		}
		return resultado;
	}
	

	
	
	private String convertNonAscii(String s) 
	{
		final String PLAIN_ASCII =
		      "AaEeIiOoUu"    // grave
		    + "AaEeIiOoUuYy"  // acute
		    + "AaEeIiOoUuYy"  // circumflex
		    + "AaOo"          // tilde
		    + "AaEeIiOoUuYy"  // umlaut
		    + "Aa"            // ring
		    + "Cc"            // cedilla
		    ;

		final String UNICODE =
		 "\u00C0\u00E0\u00C8\u00E8\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"             
		+"\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD" 
		+"\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177" 
		+"\u00C3\u00E3\u00D5\u00F5"
		+"\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF" 
		+"\u00C5\u00E5"                                                             
		+"\u00C7\u00E7" ;
		
		
	       StringBuffer sb = new StringBuffer();
	       int n = s.length();
	       for (int i = 0; i < n; i++) {
	          char c = s.charAt(i);
	          int pos = UNICODE.indexOf(c);
	          if (pos > -1){
	              sb.append(PLAIN_ASCII.charAt(pos));
	          }
	          else {
	              sb.append(c);
	          }
	       }
	       return sb.toString();
	    }

	
	
	
	private synchronized  boolean bloquearZip(String pathZip )
	{
		boolean esperar= true; 
		if(colaGeneracionZip.containsKey(pathZip))
		{
			Date hora = (Date) colaGeneracionZip.get(pathZip);
			// compruebo que el zip no permanezca bloqueado por mas de 5 minutos para 
			// evitar que se quede bloqueado eternamente.. si lleva mas de 5 minutos
			// bloqueado, lo desbloqueo
			if( TiempoBloqueoZip < ( (new Date()).getTime() - hora.getTime() ))
			{
				desbloquearZip(pathZip);
			}
		}else
		{// hay que esperar un tiempo
			colaGeneracionZip.put(pathZip, new Date());
			esperar=false;
		}
		
		return esperar;
	}
	
	private synchronized  void desbloquearZip(String pathZip)
	{
		if(colaGeneracionZip.containsKey(pathZip))
		{
			colaGeneracionZip.remove(pathZip);
		}
	}
 

	 /**
	 * Obtiene la localización física de un ODE.
	 * @param identificador: identificador del ODE que se quiere localizar
	 * @return LocalizadorAdlVO: Devuelve el tipo LocalizadorAdlVO con los datos de localización del ODE
	 */
	protected LocalizadorAdlVO handleLocalizacionPaquetePIF(String identificador) throws Exception {
		LocalizadorAdlVO localAdl = null;
		try {
			logger.debug("Llammos al servicio de localización");
			SrvLocalizadorService localizadorService = this.getSrvLocalizadorService();
			
			logger.debug("Llammos al servicio de localización con el identificador = " + identificador);
			LocalizadorVO localvo = localizadorService.consultaLocalizador(identificador);
			localAdl=new LocalizadorAdlVO();
			localAdl.setPath(localvo.getPath());
			localAdl.setUrl(localvo.getUrl());
			localAdl.setIdentificador(localvo.getIdentificador());
			localAdl.setIdUsuario(localvo.getIdentificador());
			
		}catch (Exception e) {
			logger.error("Error!!!! - Servicio Entregar -- método localizacionPaquetePIF");
		}
		
		return localAdl;
	}

}
