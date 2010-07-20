/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.validador.negocio.dominio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Element;
import org.jdom.input.DOMBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.i18n.I18n;
import es.pode.validador.negocio.soporte.domTree.DOMTreeUtility;
import es.pode.validador.negocio.servicio.ErrorParseoVO;
import es.pode.validador.negocio.soporte.XMLErrorHandler;

public class ManifestEntityDaoImpl implements ManifestEntityDao, ErrorHandler {
	
	public final static String DEF_MAPPING_MANIFESTENTITY_VALIDAVO = "DEF_MAPPING_MANIFESTENTITY_VALIDAVO";
	public final static String DEF_MAPPING_VALIDAVO_MANIFESTENTITY = "DEF_MAPPING_MANIFESTENTITY_VALIDAVOPRIME";

	/**
	 * Reference to the dozer bean mapper used in the application (singleton).
	 */
	private MapperIF beanMapper;
	private Logger logger = Logger.getLogger(this.getClass());
	 /*
     * Declaramos variables privadas de la clase
     * */
     private DOMParser mParser;
	 private List mFileList;
	 private String mBaseDirectory;
	 private Document mDocument;
	 private List mResourceIdentifierList;
	 private boolean haCambiadoDocument; 
	 private int indiceMetadato;
	 private String ficheroActual;
	 
	 // Lista de errores de mensaje. La lista debe contener objetos de la clase ErrorParseoVO
	 private List erroresParseo=new ArrayList() ;
	 
	 private List erroresXerces = new ArrayList();
	 
	 private List lomes = new ArrayList();
	 private List nombreLomes= new ArrayList();//se guarda la localizacion de los lomes incluidos en el array "lomes" cuando esto lomes estan 
	 										   //referenciados mediante location, en otro caso se mete un string vacio	
	 
	 private List metadatos = new ArrayList();//se almacenan los metadatos que no son LOM-ESv1.0 para guardarlos en fichero fuera del imsmanifest.xml
	 private List nombreMetadatos = new ArrayList();
	 
	 /*
	  * Creamos un Constructor para inicializar las Variables
	  * */
	 public ManifestEntityDaoImpl()
	 {
		 mFileList =  new ArrayList();
		 mBaseDirectory = "";
		 mDocument = null;
		 mParser = null;
		 mResourceIdentifierList = new ArrayList();
		 haCambiadoDocument= false;

	 }
	
	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    protected MapperIF getBeanMapper() {
		return beanMapper;
	}

    /**
     * Sets the instance of the Dozer bean mapper to be used.
     * @param beanMapper
     */
	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}
	
	 /*
	  * Metodos privados
	  * */
	 private String getBaseDirectory()
	  {
	      return mBaseDirectory;
	  }

	  public Document getDocument()
	  {
	      return mDocument;
	  }
	  
	  public void setDocument(Document doc){
		  this.mDocument= doc;
	  }
	  
	  public void setBaseDirectory(String dirBase)
	  {
		  this.mBaseDirectory=dirBase;
	  }
	  
	  private boolean getHaCambiadoDocument() {
		  return haCambiadoDocument;
	  }
	  private void setHaCambiadoDocument(boolean docC) {
		  this.haCambiadoDocument=docC;
	  }
	  
	  
	  public List getErroresParseo() {
		  return erroresParseo;
	  }
	  private void setErroresParseo(List errores) {
		  this.erroresParseo=errores;
	  }
	  
	  public List getErroresXerces() {
		  return erroresXerces;
	  }
	  public void setErroresXerces(List errores) {
		  this.erroresXerces=errores;
	  }
	  
	  
	  private String buscaFichero( String nomFich, String tipoFich ) throws Exception
	  {
		boolean fichOk = false;
		String nomFichSalida = ""; 
		try 
		{
			
			if ( nomFich.length() > 6 && (nomFich.substring(0,5).equals("http:") || 
				nomFich.substring(0,6).equals("https:")) ) 
			{
				nomFichSalida = nomFich;
			}
			else
			{
				File fichEntrada = new File( nomFich );
				if ( fichEntrada.isFile() == true )
				{
					fichOk = true;
					nomFichSalida = fichEntrada.getAbsolutePath();
				}
				else
				{
					String fichero = nomFich.replaceAll(getBaseDirectory()+"/","");
					insertaError("8.0",fichero);
					//logger.warn("El Fichero no es un fichero Normal");
					logger.warn("Fichero no encontrado:" + fichero);
					
				}
			}
		}
		catch ( NullPointerException npe )
		{
			insertaError("8.1",npe.getMessage());
			logger.error("Fichero Vacio", npe);
			throw npe;
	
		}
		catch ( SecurityException se )
		{
			insertaError("8.2",se.getMessage());
			logger.error("Fichero no Accesible", se);
			throw se;
	
		}
	
		return nomFichSalida;
	}
	  
   
	  private Vector vectorIdentificadores(Node nRecNodos)
	   {
	      Vector vRecNodos = new Vector();
	      Vector valores = new Vector();
	      if( nRecNodos != null )
	      {
	         vRecNodos = DOMTreeUtility.getNodes(nRecNodos, "resource");
	         int vRecNodosSize = vRecNodos.size();

	         for( int i = 0; i < vRecNodosSize; i++ )
	         {
	            Node nodoHijo = (Node)vRecNodos.elementAt(i);
	            String valor = DOMTreeUtility.getAttributeValue(nodoHijo, "href");
	            String idRecurso = DOMTreeUtility.getAttributeValue(nodoHijo, "identifier");
	            
	            if (valor != null && !valor.equals(""))
	            {	
	            	valores.add(valor);
	            	//buscamos sus hijos
	            	Vector vHijos = new Vector();
	            	vHijos = DOMTreeUtility.getNodes(nodoHijo, "file");
	            	int numHijos = vHijos.size();
	            	for (int l=0; l<numHijos; l++)
	            	{
	            		Node subHijos = (Node) vHijos.elementAt(l);
	            		String valorHijos = DOMTreeUtility.getAttributeValue(subHijos,"href");
	            		if (valorHijos!=null && !valorHijos.equals("") && !valores.contains(valorHijos))
	            		{
	            			valores.add(valorHijos);
	            		}
	            	}
	            }
	         }
	      }// end if
	      return valores;
	   }
	
	public java.lang.Boolean buscarManifest(java.lang.String rutaManifest)
    {
        //@todo implement public java.lang.Boolean buscarManifest(java.lang.String rutaManifest)
		Boolean manifestFound = new Boolean(true);
		String fichImsManifest = rutaManifest + File.separator + "imsmanifest.xml";
		File manifestFile = new File(fichImsManifest);
	     if( !manifestFile.exists() )
	      {
	       manifestFound = new Boolean(false);
	      }
		return manifestFound;
    }

    /**
     * @throws Exception 
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#obtenerParseoSimple(java.lang.String)
     * llamada CA: contentAggregation--> si es obligatorio que tenga al menos una organizacion
     * llamada RCP: ResourceContentPackage --> la etiqueta organizations tiene que ir vacia
     */
    public java.lang.Boolean obtenerParseoSimple(java.lang.String rutaManifest, String tipoOde) throws Exception
    {
    	boolean validadorRes = false;
    	Document docValido = null;
    	String mensaje=null;
		mParser = new DOMParser();
		Document mDocAux;
		if (mParser != null)
		 {
			
		    try
		      {
			      mParser.setFeature("http://xml.org/sax/features/validation", false);
			      mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
				
			      mParser.setErrorHandler(this);
			      
			} catch (SAXException se ) {
//				 insertaError("8.3",se.getMessage());
			      logger.error("ERROR EN EL XML",se);
				  validadorRes=false;
		    }
		   String nomManifestFich = rutaManifest; //+ File.separator + "imsmanifest.xml"; 
		   String nomFich = buscaFichero( nomManifestFich, "xml" ); 
			
		   File tempXMLFich = new File(nomFich);
		   String xsdLoc = "file:///" + tempXMLFich.getParent() + "/";  
		   xsdLoc = xsdLoc.replaceAll( " ", "%20");  
		   xsdLoc = xsdLoc.replace( '\\', '/');
				
		   if ( !nomFich.equals("") ) {
				try
				{	
					parse(mParser,nomFich );
					docValido = mParser.getDocument();
					if ( docValido != null ) {
						validadorRes = true;
						mDocument= mParser.getDocument();
						
						this.setDocument(mParser.getDocument());
						mDocAux= mDocument; //antes de ser cambiado	
						//se cambian por una etiqueta location los metadatos que no sean LOM-ESv1.0
						indiceMetadato=0;
						validadorRes =esNodoCorrecto(mDocument, nomManifestFich, tipoOde);
						
						//si es correcto... con ese metodo nos hemos quitado los lom-es que no nos interesan
						if (getHaCambiadoDocument()) {
							if (validadorRes) {
								FileOutputStream fs = new FileOutputStream(new File(nomFich)); //machacamos imsmanifest
								DOMBuilder dom = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
								org.jdom.Document finalDoc = dom.build(
										(org.w3c.dom.Document)mDocument );
								
								new XMLOutputter().output(finalDoc,fs);
								
								escribirMetadatos();//se escribe en ficheros los metadatos que no sean LOM-ESv1.0
							}
		        		
						}
						
					}
				}
				catch ( SAXException se ) {
//					insertaError("8.3",se.getMessage());
				    logger.error("ERROR EN EL XML",se);
					
				    validadorRes=false;
				}
				catch ( IOException ioe ) {
					insertaError("8.7",ioe.getMessage());
				    logger.error("ERROR DE ENTRADA/SALIDA",ioe);
				    validadorRes=false;
				}
			}
		 }

		 return new Boolean(validadorRes);
    }
    

    /**
     * @throws Exception 
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#obtenerParseoEsquemasSinLomes(java.lang.String)
     * llamada CA: contentAggregation--> si es obligatorio que tenga al menos una organizacion
     * llamada RCP: ResourceContentPackage --> la etiqueta organizations tiene que ir vacia
     * Valida contra los esquemas, en este parseo el manifest viene sin metadatos
     */
    public java.lang.Boolean obtenerParseoConEsquemasSinLomes(String manifestAux, String tipoOde) throws Exception
    {
    	boolean validadorRes = false;
    	String ficheroProperties = "/validador.properties";
		InputStream is= null;
		logger.info("ASC- METODO: obtenerParseoConEsquemasSinLomes");
    	mParser = new DOMParser();
    	    	
		if (mParser != null)
		 {
		    try
		      {
		    	if( logger.isDebugEnabled() )
		    		logger.debug( "URL del parseador: " + mParser.getClass().getResource( mParser.getClass().getName().replace('.','/') + ".class") );
		    	
		    	is= this.getClass().getResourceAsStream(ficheroProperties);
		    	
				Properties fproperties = new Properties();
				
				fproperties.load(is);
				
				String imscp_v1p1 = fproperties.getProperty("imscp_v1p1");
				String lomCustom = fproperties.getProperty("lomCustom");
				String adlcp_v1p3 = fproperties.getProperty("adlcp_v1p3");
				String imsss_v1p0 = fproperties.getProperty("imsss_v1p0");
				String adlseq_v1p3 = fproperties.getProperty("adlseq_v1p3");
				String adlnav_v1p3 = fproperties.getProperty("adlnav_v1p3");
				
				String url_imscp_v1p1 = fproperties.getProperty("url_imscp_v1p1");
				String url_lomCustom = fproperties.getProperty("url_lomCustom");
				String url_adlcp_v1p3 = fproperties.getProperty("url_adlcp_v1p3");
				String url_imsss_v1p0 = fproperties.getProperty("url_imsss_v1p0");
				String url_adlseq_v1p3 = fproperties.getProperty("url_adlseq_v1p3");
				String url_adlnav_v1p3 = fproperties.getProperty("url_adlnav_v1p3");
				
				
				File fileImscp_v1p1=new File(imscp_v1p1);
				String sImscp_v1p1=fileImscp_v1p1.getCanonicalPath();
				File fileLomCustom=new File(lomCustom);
				String sLomCustom=fileLomCustom.getCanonicalPath();
				File fileAdlcp_v1p3=new File(adlcp_v1p3);
				String sAdlcp_v1p3=fileAdlcp_v1p3.getCanonicalPath();
				File fileImsss_v1p0=new File(imsss_v1p0);
				String sImsss_v1p0=fileImsss_v1p0.getCanonicalPath();
				File fileAdlseq_v1p3=new File(adlseq_v1p3);
				String sAdlseq_v1p3=fileAdlseq_v1p3.getCanonicalPath();
				File fileAdlnav_v1p3=new File(adlnav_v1p3);
				String sAdlnav_v1p3=fileAdlnav_v1p3.getCanonicalPath();
				
				logger.info("ASC- METODO: obtenerParseoConEsquemasSinLomes Namespaces: " + sImscp_v1p1 + "; " + sLomCustom + "; "
						+ sAdlcp_v1p3 + "; " + sImsss_v1p0 + "; " + sAdlseq_v1p3 + "; " + sAdlnav_v1p3 );
				
			     mParser.setFeature("http://xml.org/sax/features/validation", true);
			     mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      
//			      estas "feature" son para la validación del manifest contra los esquemas
			      mParser.setFeature("http://apache.org/xml/features/validation/schema",true);
			      
			      logger.info("METODO: obtenerParseoConEsquemasSinLomes!!!! ANTES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      mParser.setFeature("http://apache.org/xml/features/validation/schema/ignore-xsi-type-until-elemdecl", true);
			     
			      logger.info("METODO: obtenerParseoConEsquemasSinLomes!!!! DESPUES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      String namespacesFull = url_imscp_v1p1+" "+sImscp_v1p1+" "+ url_lomCustom+" "+sLomCustom+
			      " "+url_adlcp_v1p3+" "+sAdlcp_v1p3+" "+url_imsss_v1p0+" "+sImsss_v1p0+" "+url_adlseq_v1p3+" "+sAdlseq_v1p3+
			      " "+ url_adlnav_v1p3 +" "+sAdlnav_v1p3;
			      logger.info("METODO: obtenerParseoConEsquemasSinLomes!!!! NAMESPACESFULL -> " + namespacesFull.replace( '\\', '/'));
				

			      
			      mParser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", namespacesFull);
			      /**********/
			      
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
			      mParser.setErrorHandler(this);


			     

			   }
			   catch (SAXException se )
			   {
			      logger.error("Error de Xerces",se);
			      validadorRes=false;
			   }
			   Document docValido = null;
			   			   
				if ( mDocument!=null )
				{
					try
					{
				 		Object eo= mParser.getProperty("http://apache.org/xml/properties/schema/external-schemaLocation");
						logger.info(" Recupero los namespaces del mParser " + eo.toString());
						//Parseamos el fichero

						//Obtenemos un InputSource a partir de mDocument que es un Document limpio de metadatos
						//solo se parsea el manisfest(SCORM)
						DOMBuilder dom = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
						org.jdom.Document finalDoc = dom.build(
								(org.w3c.dom.Document) mDocument );
		                
						Writer writer = new StringWriter();
						XMLOutputter outputter = new XMLOutputter();
		                outputter.output(finalDoc, writer);  
		                
		                String xml = writer.toString();            	
		        		InputSource isrc = new InputSource(new StringReader(xml));
		        		
		        		
						parse(mParser,isrc,manifestAux);
							
						docValido = mParser.getDocument();
						
						this.setDocument(mParser.getDocument());
						logger.info("ASC-METODO obtenerParseoConEsquemasSinLomes!!!!! DESPUES DE PARSEO!!!!!!");
						
						if ( docValido != null )
						{
							validadorRes = true;
						}
					}
					catch ( SAXException se )
					{
//						insertaError("8.3",se.getMessage());
					    logger.error("ERROR EN EL XML",se);
						validadorRes=false;
					}
				}
					
		 }
		 return new Boolean(validadorRes);
    }
   
    /**
     * @throws Exception 
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#obtenerParseoEsquemasSinLomes(java.lang.String)
     * llamada CA: contentAggregation--> si es obligatorio que tenga al menos una organizacion
     * llamada RCP: ResourceContentPackage --> la etiqueta organizations tiene que ir vacia
     * Valida contra los esquemas
     */
    
    public java.lang.Boolean obtenerParseoConEsquemas(String manifestAux, String tipoOde) throws Exception
    {
    	boolean validadorRes = false;
    	String ficheroProperties = "/validador.properties";
		InputStream is= null;
		logger.info("ASC- METODO: obtenerParseoConEsquemas");
    	mParser = new DOMParser();
    	    	
		if (mParser != null)
		 {
		    try
		      {
		    	if( logger.isDebugEnabled() )
		    		logger.debug( "URL del parseador: " + mParser.getClass().getResource( mParser.getClass().getName().replace('.','/') + ".class") );
		    	
		    	is= this.getClass().getResourceAsStream(ficheroProperties);
		    	
				Properties fproperties = new Properties();
				
				fproperties.load(is);
				
				String imscp_v1p1 = fproperties.getProperty("imscp_v1p1");
				String lomCustom = fproperties.getProperty("lomCustom");
				String adlcp_v1p3 = fproperties.getProperty("adlcp_v1p3");
				String imsss_v1p0 = fproperties.getProperty("imsss_v1p0");
				String adlseq_v1p3 = fproperties.getProperty("adlseq_v1p3");
				String adlnav_v1p3 = fproperties.getProperty("adlnav_v1p3");
				
				String url_imscp_v1p1 = fproperties.getProperty("url_imscp_v1p1");
				String url_lomCustom = fproperties.getProperty("url_lomCustom");
				String url_adlcp_v1p3 = fproperties.getProperty("url_adlcp_v1p3");
				String url_imsss_v1p0 = fproperties.getProperty("url_imsss_v1p0");
				String url_adlseq_v1p3 = fproperties.getProperty("url_adlseq_v1p3");
				String url_adlnav_v1p3 = fproperties.getProperty("url_adlnav_v1p3");
				
				File fileImscp_v1p1=new File(imscp_v1p1);
				String sImscp_v1p1=fileImscp_v1p1.getCanonicalPath();
				File fileLomCustom=new File(lomCustom);
				String sLomCustom=fileLomCustom.getCanonicalPath();
				File fileAdlcp_v1p3=new File(adlcp_v1p3);
				String sAdlcp_v1p3=fileAdlcp_v1p3.getCanonicalPath();
				File fileImsss_v1p0=new File(imsss_v1p0);
				String sImsss_v1p0=fileImsss_v1p0.getCanonicalPath();
				File fileAdlseq_v1p3=new File(adlseq_v1p3);
				String sAdlseq_v1p3=fileAdlseq_v1p3.getCanonicalPath();
				File fileAdlnav_v1p3=new File(adlnav_v1p3);
				String sAdlnav_v1p3=fileAdlnav_v1p3.getCanonicalPath();
				
				logger.info("ASC- METODO: obtenerParseoConEsquemas Namespaces: " + sImscp_v1p1 + "; " + sLomCustom + "; "
						+ sAdlcp_v1p3 + "; " + sImsss_v1p0 + "; " + sAdlseq_v1p3 + "; " + sAdlnav_v1p3 );
				
			     mParser.setFeature("http://xml.org/sax/features/validation", true);
			     mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      
//			      estas "feature" son para la validación del manifest contra los esquemas
			      mParser.setFeature("http://apache.org/xml/features/validation/schema",true);
			      
			      logger.info("METODO: obtenerParseoConEsquemas!!!! ANTES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      mParser.setFeature("http://apache.org/xml/features/validation/schema/ignore-xsi-type-until-elemdecl", true);
			     
			      logger.info("METODO: obtenerParseoConEsquemas!!!! DESPUES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
			      String namespacesFull = url_imscp_v1p1+" "+sImscp_v1p1+" "+ url_lomCustom+" "+sLomCustom+
			      " "+url_adlcp_v1p3+" "+sAdlcp_v1p3+" "+url_imsss_v1p0+" "+sImsss_v1p0+
			      " "+url_adlseq_v1p3+" "+sAdlseq_v1p3+" "+ url_adlnav_v1p3 +" "+sAdlnav_v1p3;
			      logger.info("METODO: obtenerParseoConEsquemas!!!! NAMESPACESFULL -> " + namespacesFull.replace( '\\', '/'));

			      
			      mParser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", namespacesFull);
			      /**********/
			      
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
			      mParser.setErrorHandler(this);
			     
			   }
			   catch (SAXException se )
			   {
			      logger.error("Error de Xerces",se);
			      validadorRes=false;
			   }
			   Document docValido = null;
			   
				if ( !manifestAux.equals("") )
				{
					try
					{
				 		Object eo= mParser.getProperty("http://apache.org/xml/properties/schema/external-schemaLocation");
						logger.info(" Recupero los namespaces del mParser " + eo.toString());
						//Parseamos el fichero

						parse(mParser,manifestAux);
							
						docValido = mParser.getDocument();
						
						this.setDocument(mParser.getDocument());
						logger.info("ASC-METODO obtenerParseoConEsquemas!!!!! DESPUES DE PARSEO!!!!!!");
						
						if ( docValido != null )
						{
							validadorRes = true;

						}
					}
					catch ( SAXException se )
					{
					    logger.error("ERROR EN EL XML",se);
						validadorRes=false;
					}
				}
					
		 }
		 return new Boolean(validadorRes);
    }

    /**
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#crearListaFicherosManifest(java.lang.String)
     */
    public void crearListaFicherosManifest(java.lang.String rutaManifest)
    {
    	 File fichOCarpeta = new File(rutaManifest);
    	 File[] fichsEnDir;

	      if( fichOCarpeta.isDirectory() && !fichOCarpeta.getName().equals("common")
	         && !fichOCarpeta.getName().equals("vocab") && !fichOCarpeta.getName().equals("extend")
	         && !fichOCarpeta.getName().equals("unique") )
	      {
	         fichsEnDir = fichOCarpeta.listFiles();
	         int contFich = 0;
	         while( contFich < fichsEnDir.length )
	         {
	        	 crearListaFicherosManifest(fichsEnDir[contFich].getPath());
	            contFich++;
	          }// end while

	       }// end if

	      if( fichOCarpeta.isFile() && !fichOCarpeta.getName().endsWith(".xsd")
	         && !fichOCarpeta.getName().equals("imsmanifest.xml") && !fichOCarpeta.getName().endsWith(".dtd") )
	      {
	         String tempStr = fichOCarpeta.getPath();
	         tempStr = tempStr.replace('\\', '/');
	         if (mFileList != null){
		         if( !mFileList.contains(tempStr) )
		         {
		            mFileList.add(tempStr);
		         }
	         }
	      }
    }

    /**
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#chequearContenido(org.w3c.dom.Document, java.lang.String)
     */
    public java.lang.Boolean chequearContenido(org.w3c.dom.Node arbolDoc, java.lang.String rutaManifest)
    {
        //@todo implement public java.lang.Boolean chequearContenido(org.w3c.dom.Document arbolDoc, java.lang.String rutaManifest)
    	Boolean result = new Boolean(true);
	     Node iTestSubjectNode = (Node)arbolDoc;
	     if( iTestSubjectNode == null )
	      {
	         result = new Boolean(false);
	         return result;
	      }

	      switch( iTestSubjectNode.getNodeType() )
	      {
	         case Node.PROCESSING_INSTRUCTION_NODE:
	         {
	            // Skip any processing instructions, nothing for us to do
	            break;
	         }
	         case Node.DOCUMENT_NODE:
	         {
	            Node rootNode = ( (Document)iTestSubjectNode ).getDocumentElement();
	            String rootNodeName = rootNode.getLocalName();
	            result = new Boolean( (chequearContenido(rootNode, "")).booleanValue() && result.booleanValue());
	            break;
	         }
	         case Node.ELEMENT_NODE:
	         {
	            String parentNodeName = iTestSubjectNode.getLocalName();
	            if( parentNodeName.equals("manifest") )
	            {
	               Node resourcesNode = DOMTreeUtility.getNode(iTestSubjectNode, "resources");
	               if( resourcesNode != null )
	               {
	                  Vector files = new Vector();
	                  files = vectorIdentificadores(resourcesNode);
	                  if (files != null)
	                  {
	                	  int numElems = files.size();
	                	  for (int ll=0; ll< numElems; ll++)
	                	  {
	                		  String ruta = files.elementAt(ll).toString();
	                		  String rutaFinal= null;
	                		  
	                		  if( ( (ruta.length() > 4) && (ruta.substring(0, 5).equals("http:")) ) || 
	                		             ( (ruta.length() > 5) && (ruta.substring(0, 6).equals("https:")) ) ||
	                		             ( (ruta.length() > 3) && (ruta.substring(0, 4).equals("ftp:")) ) || 
	                		             ( (ruta.length() > 4) && (ruta.substring(0, 5).equals("ftps:")) ) ){
	                			  
	                			  rutaFinal= ruta;
	                		  }
	                		  else{
	                			  rutaFinal= rutaManifest + ruta;
	                		  }
	                			  
	                	      result= new Boolean((chequearHref(rutaFinal)).booleanValue() && result.booleanValue());
	                		 
		   
	                	  }
	                  }
	               }
	               //Chequeamos los contenidos de los submanifiestos
	               Vector vSubmanifest = DOMTreeUtility.getNodes(iTestSubjectNode, "manifest");
	               for(int i=0; i< vSubmanifest.size();i++){
	            	   Node submanifest = (Node) vSubmanifest.get(i);
	            	   String submXmlbase = DOMTreeUtility.getAttributeValue(submanifest, "base");

	            	   if (!submXmlbase.endsWith("/"))
	            		   submXmlbase = submXmlbase + '/';
	            	   if(submXmlbase.equals("./"))
	            		   submXmlbase = ""; 
	            	   
	            	   submXmlbase= rutaManifest +submXmlbase; //se concatenan al base obtenido, el base de su padre
	            	   result = new Boolean( (chequearContenido(submanifest, submXmlbase)).booleanValue() && result.booleanValue());
	               }
	               
	               
	            }
	            break;
	         }
	         // handle entity reference nodes
	         case Node.ENTITY_REFERENCE_NODE:
	         {
	            break;
	         }
	         // text
	         case Node.COMMENT_NODE:
	         {
	            break;
	         }
	         case Node.CDATA_SECTION_NODE:
	         {
	            break;
	         }
	         case Node.TEXT_NODE:
	         {
	            break;
	         }
	         default:
	         {
	            break;
	         }
	      }// end switch statement
	      return result;
    }

   
    private void trackResourceIdentifiers(Node iResourcesNode)
    {
       Vector resourceNodes = new Vector();
       if( iResourcesNode != null )
       {
          // this will return a Vector of all child nodes of iResourceNode whos
          //  name = "resource"
          resourceNodes = DOMTreeUtility.getNodes(iResourcesNode, "resource");
          int resourceNodesSize = resourceNodes.size();

          for( int i = 0; i < resourceNodesSize; i++ )
          {
             Node currentChild = (Node)resourceNodes.elementAt(i);
             String resourceId = DOMTreeUtility.getAttributeValue(currentChild, "identifier");
             if ((resourceId != null) && (!resourceId.equals("")) && (!mResourceIdentifierList.contains(resourceId))) {//para evitar repetidos
            	 mResourceIdentifierList.add(resourceId);
             }
             //mManifestResourceIdentifierList.add(resourceId);
          }
       }// end if
    }
    
    private void trackSubmIdentifiers(Vector vSubmNode) {
    	
    	if (vSubmNode != null) {
    		for (int v=0; v<vSubmNode.size(); v++) {
    			Node submNode = (Node)vSubmNode.elementAt(v);
		    	//todo submanifest tiene un xml:base 
		    	String submXmlbase = DOMTreeUtility.getAttributeValue(submNode, "base");
		    	if ((submXmlbase!=null) && (!submXmlbase.equals(""))) {
		    		String submIdentifier = DOMTreeUtility.getAttributeValue(submNode, "identifier");
		            if ((submIdentifier != null) && (!submIdentifier.equals("")) && (!mResourceIdentifierList.contains(submIdentifier))) {
		               	 mResourceIdentifierList.add(submIdentifier);
		            }
		        }
		    	Node resourcesNode = DOMTreeUtility.getNode(submNode, "resources");
		    	//para corregir el error de si un item hace referencia a un submanifiesto q esta mas abajo y no de error pq todavia no tiene los recursos
		    	trackResourceIdentifiers(resourcesNode); //llamada con ese nodo
	            
		    	//submanifiestos
	            Vector vSubmNodes = DOMTreeUtility.getNodes(submNode, "manifest");
	            if (vSubmNodes != null && vSubmNodes.size() >0) {
	            	trackSubmIdentifiers(vSubmNodes);//guardamos los identificadores de los submanifiestos mResourceIdentifierList
	            }
          }//end for
    	}
   
    }
    
    private int getMultiplicityUsed(NamedNodeMap iAttributeMap, String iNodeName)
    {
       int result = 0;
       int length = iAttributeMap.getLength();
       String currentName;

       for( int i = 0; i < length; i++ )
       {
          currentName = ( (Attr)iAttributeMap.item(i) ).getLocalName();
          if( currentName.equals(iNodeName) )
          {
             result++;
          } // end if current name equals node name
       } // end looping over attributes
       return result;
    }
    
    private int getMultiplicityUsed(Node iParentNode, String iNodeName)
    {
       NodeList kids = iParentNode.getChildNodes();
       int count = 0;

       int kidsLength = kids.getLength();
       for( int i = 0; i < kidsLength; i++ )
       {
          if( kids.item(i).getNodeType() == Node.ELEMENT_NODE )
          {
             String currentNodeName = kids.item(i).getLocalName();
             if( currentNodeName!= null && currentNodeName.equals(iNodeName) )
             {
                count++;
             } // end if the current node name equals the name we are looking for
          } // end of the node type is ELEMENT_NODE
       } // end looping over children
       return count;
    }
    
    private boolean checkResourceAttributes(Node iResourceNode, NamedNodeMap iAttrList)
    {
       int idMultiplicityUsed = -1;
       int typeMultiplicityUsed = -1;
       int scormMultiplicityUsed = -1;

       boolean result = true;

       // check for mandatory attributes

       idMultiplicityUsed = getMultiplicityUsed(iAttrList, "identifier");
       if( idMultiplicityUsed < 1 )
       {
    	   insertaError("8.45","");
    	   result = false && result;
       }

       typeMultiplicityUsed = getMultiplicityUsed(iAttrList, "type");

       if( typeMultiplicityUsed < 1 )
       {
    	   insertaError("8.44","");
    	   result = false && result;
       }

       scormMultiplicityUsed = getMultiplicityUsed(iAttrList, "scormType");
       if( scormMultiplicityUsed < 1 )
       {
    	   insertaError("8.43","");
           result = false && result;
       }

       return result;
    }
    
    private boolean esNodoCorrecto (org.w3c.dom.Node iTestSubjectNode, java.lang.String rutaManifest, String tipoOde) throws IOException
    {
        //@todo implement public java.lang.Boolean chequearContenido(org.w3c.dom.Document arbolDoc, java.lang.String rutaManifest)
    	boolean result = true;
		
		if( iTestSubjectNode == null )
		  {
		     result =false;
		     insertaError("8.13","");
		     return result;
		  }

		  switch( iTestSubjectNode.getNodeType() )
		  {
		     case Node.PROCESSING_INSTRUCTION_NODE:
		     {
		        // Skip any processing instructions, nothing for us to do
		        break;
		     }
		     case Node.DOCUMENT_NODE:
		     {
		        Node rootNode = ( (Document)iTestSubjectNode ).getDocumentElement();
		        
		        String parentNodeName = rootNode.getLocalName();
		    	 
		    	 if( parentNodeName.equals("manifest") )
		         {
		            Node resourcesNode = DOMTreeUtility.getNode(rootNode, "resources");
		            if( resourcesNode != null )
		            {
		               trackResourceIdentifiers(resourcesNode);//guardamos los identificadores de los recursos mResourceIdentifierList
		            }
		            //submanifiestos
		            Vector vSubmNodes = DOMTreeUtility.getNodes(rootNode, "manifest");
		            if (vSubmNodes != null) {
		            	trackSubmIdentifiers(vSubmNodes);//guardamos los identificadores de los submanifiestos mResourceIdentifierList
		            }
		         }
		    	 
		        result = esNodoCorrecto(rootNode, "", tipoOde);
		        break;
		     }
		     case Node.ELEMENT_NODE:
		     {
		    	 String parentNodeName = iTestSubjectNode.getLocalName();
		    	 Vector mResourceNodes = new Vector();
		    	 /**********location************/
		    	 if(parentNodeName ==null){
		    		 parentNodeName= iTestSubjectNode.getNodeName();//location
		    	 }
		    	 /**********location************/
		    	 if( parentNodeName.equals("manifest") )
		         {
		            Node resourcesNode = DOMTreeUtility.getNode(iTestSubjectNode, "resources");
		            if( resourcesNode != null )
		            {
		               mResourceNodes = DOMTreeUtility.getNodes(resourcesNode, "resource");
//		               trackResourceIdentifiers(resourcesNode);//guardamos los identificadores de los recursos mResourceIdentifierList
		            }
//		            submanifiestos
//		            Vector vSubmNodes = DOMTreeUtility.getNodes(iTestSubjectNode, "manifest");
//		            if (vSubmNodes != null) {
//		            	trackSubmIdentifiers(vSubmNodes);//guardamos los identificadores de los submanifiestos mResourceIdentifierList
//		            }
		         } 
		    	
		        //String parentNodeName = iTestSubjectNode.getLocalName();
		        NamedNodeMap attrList = iTestSubjectNode.getAttributes();
		        int numAttr = attrList.getLength();
		        int multiplicityUsed = -1;
		        Attr currentAttrNode = null;
		        String currentNodeName = "";
		        
		        // Loop throught attributes
		        for( int i = 0; i < numAttr; i++ )
		        {
		           currentAttrNode = (Attr)attrList.item(i);
		           currentNodeName = currentAttrNode.getLocalName();
		           if( currentNodeName.equalsIgnoreCase("persistState") )
		           {
		        	   insertaError("8.14",iTestSubjectNode.getLocalName());
		               result = false && result;
		           }
		           if( currentNodeName.equalsIgnoreCase("scormType") )
		           {
		              //result = checkSCORMTypeReq(currentAttrNode, iTestSubjectNode) && result;
		        	   boolean res1 = false;
		        	   if( DOMTreeUtility.isAppropriateElement(iTestSubjectNode, "resource", "http://www.imsglobal.org/xsd/imscp_v1p1") )
		        	      {
		        	         res1 = true;
		        	      } else {
		        	    	  res1 = false;
		        	    	  insertaError("8.15",iTestSubjectNode.getLocalName());
		        	      }
		        	    
		        	   	result = res1 && result;
		           }
		           if( currentNodeName.equalsIgnoreCase("objectivesGlobalToSystem") )
		           {
		              //result = checkObjGlobalToSystemReq(currentAttrNode, iTestSubjectNode) && result;
		        	   boolean res1 = false;
		        	   if( DOMTreeUtility.isAppropriateElement(iTestSubjectNode, "organization", "http://www.imsglobal.org/xsd/imscp_v1p1") )
		        	      {
		        	         res1 = true;
		        	      } else {
		        	    	  res1 = false;
		        	    	  insertaError("8.16",iTestSubjectNode.getLocalName());
		        	      }
		        	   
		        	   	result = res1 && result;
		           }

		        } // end for

		       if( parentNodeName.equals("manifest") )
		        {
		    	   multiplicityUsed = getMultiplicityUsed(attrList, "identifier");

		           if( multiplicityUsed < 1 )
		           {
		        	   insertaError("8.17","");
		               result = false && result;
		           }
		       }
		       else if( parentNodeName.equalsIgnoreCase("organizations"))
		       {
		             multiplicityUsed = getMultiplicityUsed(attrList, "default");
		             if(( multiplicityUsed < 1 ) && (tipoOde.equals("CA")))
		               {
		            	 insertaError("8.18","");
		                  result = false && result;
		               } else if ((multiplicityUsed > 0) && (tipoOde.equals("RCP"))){//si es RCP no puede aparecer
		            	   insertaError("8.19","");
		            	   result = false && result; 
		               }
		       }
		       else if( parentNodeName.equalsIgnoreCase("organization"))
		       {
		               multiplicityUsed = getMultiplicityUsed(attrList, "identifier");
		               if (( multiplicityUsed < 1 ) && (tipoOde.equals("CA")))
		               {
		            	   insertaError("8.20","");
			      		   result = false && result;
		               }else if ((multiplicityUsed > 0) && (tipoOde.equals("RCP"))){//si es RCP no puede aparecer
		            	   insertaError("8.21","");
			      		   result = false && result; 
		               }
		       }
		       
		       
		       else if( parentNodeName.equalsIgnoreCase("item"))
		       {
		    	   
		    	    metadatosCorrectos(result, iTestSubjectNode);	
		    	   		
		               multiplicityUsed = getMultiplicityUsed(attrList, "identifier");
		               int multTitle = getMultiplicityUsed(iTestSubjectNode, "title");
		               if( multiplicityUsed < 1 )
		               { 
		            	   insertaError("8.22","");
		            	   result = false && result;
		                  }
		               if( multTitle < 1 )
		               {
		            	   insertaError("8.23","");
			      		   result = false && result;
		               }
		               int idrefMult = -1;
		               int paramMult = -1;

		               idrefMult = getMultiplicityUsed(attrList, "identifierref");
		               paramMult = getMultiplicityUsed(attrList, "parameters");
		               if( idrefMult >= 1 )
		               {
		                  String iDREFValue = DOMTreeUtility.getAttributeValue(iTestSubjectNode, "identifierref");
		                  boolean validIdref = mResourceIdentifierList.contains(iDREFValue);
		                  if( validIdref )
		                  {
		                    // mValidIdrefs.add(iDREFValue);
		                	  result = true && result;
		                  } else { //Si no esta en la lista no es valido!!
		                	  result = false && result;
		                	  insertaError("8.24",iDREFValue);
		                  }

		               }

		              NodeList childrenOfItem = iTestSubjectNode.getChildNodes();
		               if( childrenOfItem != null )
		               {
		                  Node currentItemChild;
		                  String currentItemChildName;
		                  int len = childrenOfItem.getLength();
		                  for( int k = 0; k < len; k++ )
		                  {
		                    currentItemChild = childrenOfItem.item(k);
		                    currentItemChildName = currentItemChild.getLocalName();
		                    if (currentItemChildName != null){
		                     if( currentItemChildName.equals("timeLimitAction") || currentItemChildName.equals("dataFromLMS")
		                        || currentItemChildName.equals("completionThreshold") )
		                     {
		                        if( idrefMult < 1 )
		                        {
		                        	insertaError("8.25","");
		                          result = false && result;
		                        }
		                        else
		                        {
		                           String idrefValue = DOMTreeUtility.getAttributeValue(iTestSubjectNode, "identifierref");
		                           int lenr = mResourceNodes.size();
		                           String id;
		                           String type;
		                           boolean ress= true;
		                           for( int i = 0; i < lenr; i++ )
		                           {
		                              Node currentResource = (Node)mResourceNodes.get(i);
		                              id = DOMTreeUtility.getAttributeValue(currentResource, "identifier");
		                              if( id.equals(idrefValue) )
		                              {
		                                 type = DOMTreeUtility.getAttributeValue(currentResource, "scormType");
		                                 if( !type.equalsIgnoreCase("sco") )
		                                 {
		                                	 insertaError("8.41","");
		                                	 ress = false;
		                                 }
		                              }
		                           }
		                           result = result && ress;

		                        }
		                     }
		                     //vuelvo a lanzar la llamada para cada nodo hijo
		                     result = esNodoCorrecto(currentItemChild, "", tipoOde) && result;
		                   }
		                  }
		               } //en if nombre nodo
		               
		            } // end if Items
		       
		       		else if( parentNodeName.equalsIgnoreCase("resource") )
		       		{
		       			metadatosCorrectos(result, iTestSubjectNode);
		       			
		       			Node NodoPadre=iTestSubjectNode.getParentNode();
		       			String nombrePadre = NodoPadre.getLocalName();
		       			if (nombrePadre.equalsIgnoreCase("resources")) {
		       				boolean resourceResult = checkResourceAttributes(iTestSubjectNode, attrList);
		       				result = result && resourceResult;
		       			}
		       		}
		       		else if(parentNodeName.equalsIgnoreCase("file"))
		       		{
		       			metadatosCorrectos(result, iTestSubjectNode);	
		       		}
		        	//chequeo los hijos
		         NodeList children = iTestSubjectNode.getChildNodes();
		         if( children != null )
		         {
		           int numChildren = children.getLength();
		           //hacer el chequeo con los hijos
		           if( parentNodeName.equalsIgnoreCase("manifest") )
		           {

		              // check for mandatory metadata element at package level
		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "metadata");
		              if( multiplicityUsed < 1 )
		              {
		                 result = false && result;
		                 insertaError("8.26","");
//		                 break;
		              }
		              else
		              {
		                 Node caMetadataNode = DOMTreeUtility.getNode(iTestSubjectNode, "metadata");
		                		                 
		                 // check for mandatory <imscp:schema> element
		                 multiplicityUsed = getMultiplicityUsed(caMetadataNode, "schema");

		                 if( multiplicityUsed < 1 )
		                 {
		                  result = false && result;
		                  insertaError("8.27","");
//		                  break;
		                 }

		                 // check for mandatory <imscp:schemaversion> element
		                 multiplicityUsed = getMultiplicityUsed(caMetadataNode, "schemaversion");
		                 if( multiplicityUsed < 1 )
		                 {
		                    result = false && result;
		                    insertaError("8.28","");
//		                    break;
		                 }
		                 
		                 	                 
		                 //check for <imscp:lom>
		                 multiplicityUsed = getMultiplicityUsed(caMetadataNode, "lom");
		                 if (multiplicityUsed >= 1) {
		                	 boolean esLomOK = false;
		                	 boolean idiomasOK = false;
		                	 Vector vLomes = new Vector();
		                	 vLomes=DOMTreeUtility.getNodes(caMetadataNode, "lom");
		                	 for (int nl=0; nl<vLomes.size(); nl++) {
	                    		 Node nLom = (Node)vLomes.get(nl);
	                    		 idiomasOK = sonIdiomasCorrectos(nLom);
	                    		 if(!idiomasOK){
	                    			 result = false && result;
	                    			 
	                    		 }
	                    		 
	                    		 esLomOK =esLOMCorrecto(nLom);

	                    		 if (!esLomOK) { // lo eliminamos
	                    			 cambiarPorLocation(nLom, caMetadataNode, iTestSubjectNode);
	                    		 }
	                    	 }//fin for
		                 }//fin check lom
		                 
		                 // Borramos los hijos que no sean correctos
		                 String ficheroProperties = "/nodosCorrectosMetadata.properties";
		 				
		 				InputStream is= this.getClass().getResourceAsStream(ficheroProperties);
		 				Properties fproperties = new Properties();
		 				try {
							fproperties.load(is);
						} catch (IOException e) {
							result= false;
							insertaError("8.7",e.getMessage());
//							break;
						}
		 				String nodos=fproperties.getProperty("nodosMetadada").toString();
		 				NodeList hijosCorrectos = caMetadataNode.getChildNodes();
		                if (hijosCorrectos.getLength()>0) {
		                	for (int rHijos=0; rHijos<hijosCorrectos.getLength(); rHijos++ ) {
		                		Node nodoHijo=hijosCorrectos.item(rHijos);
		                		String nomHijo=nodoHijo.getLocalName();
		                		//mirar que lo q borramos no este en el property
		                		if (nomHijo!=null) {
		                    		StringTokenizer token = new StringTokenizer(nodos, ",");
		                    		boolean estaNodo= false;
		   	     					while ((token.hasMoreElements()) && (!estaNodo)) {
		   	     						String nOdo = token.nextElement().toString();
		   	     						if ((nomHijo.equals(nOdo)) ){
		   	     							estaNodo=true;
		   	     						}
		   	     					}
		                    		if (!estaNodo) {
		                    			cambiarPorLocation(nodoHijo, caMetadataNode, iTestSubjectNode);
		                    		}
		                		}
		                	}//end for
		                }

		                                		                 
		              }

		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "organizations");
		              if (( multiplicityUsed < 1 ))
		              {
		            	  insertaError("8.30","");
		                 result = false && result;
//		                 break;
		              }


		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "resources");
		              if( multiplicityUsed < 1 )
		              {
		                 result = false && result;
		                 insertaError("8.31","");
//		                 break;
		              }
		           }
		           else if( parentNodeName.equalsIgnoreCase("organizations"))
		           {
		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "organization");
		              if (( multiplicityUsed < 1 ) && (tipoOde.equals("CA")))
		              {
		            	  insertaError("8.32","");
		                 result = false && result;
//		                 break;
		              }else if ((multiplicityUsed > 0) && (tipoOde.equals("RCP"))){//si es RCP no puede aparecer
		            	  insertaError("8.33","");
		            	   result = false && result;
//		            	   break;
		              }

		           }
//		               else if( parentNodeName.equalsIgnoreCase("organizations"))
//		               {
//		                  multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "organization");
//		                  if( multiplicityUsed > 0 )
//		                  {
//		                     result = false && result;
//		                  }
//		                  
//		               }
		           else if( parentNodeName.equalsIgnoreCase("organization") )
		           {
		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "title");
		              if (( multiplicityUsed < 1 ) && (tipoOde.equals("CA")))
		              { 
		            	  insertaError("8.34","");
		                  result = false && result;
		              }else if ((multiplicityUsed > 0) && (tipoOde.equals("RCP"))){//si es RCP no puede aparecer
		            	  insertaError("8.35","");
		            	   result = false && result;
		              } 

		              multiplicityUsed = getMultiplicityUsed(iTestSubjectNode, "item");
		              if(( multiplicityUsed < 1 ) && (tipoOde.equals("CA")))
		              {
		            	  insertaError("8.36","");
		                  result = false && result;
		              }else if ((multiplicityUsed > 0) && (tipoOde.equals("RCP"))){//si es RCP no puede aparecer
		            	  insertaError("8.37","");
		            	   result = false && result;
		              }

		              
		              metadatosCorrectos(result, iTestSubjectNode);

//		                  // special checks for item
//		                  result = checkItem(iTestSubjectNode, mManifestInfo) && result;

		           }

		           for( int z = 0; z < numChildren; z++ )
		           {

		              Node currentChild = children.item(z);
		              String currentChildName = currentChild.getLocalName();
		              if( currentChildName != null )
		              {

		                 if( ( ( currentChildName.equals("timeLimitAction") ) || ( currentChildName.equals("dataFromLMS") )
		                    || ( currentChildName.equals("completionThreshold") ) || ( currentChildName
		                    .equals("presentation") ) )
		                    && ( !parentNodeName.equals("item") ) )
		                 {
		                	 insertaError("8.38","");
		                       result = false && result;
		                 }

		                 if( ( ( currentChildName.equals("constrainedChoiceConsiderations") ) || ( currentChildName
		                    .equals("rollupConsiderations") ) )
		                    && ( !parentNodeName.equals("sequencing") ) )
		                 {
		                	 insertaError("8.39","");
		                       result = false && result;

		                 }

		                 // must enforce that the adlcp:location exist
		                 // as a child of metadata only - warning for best practice.
		                 //quitamos esta validacion para que no de error cuando su padre es technical y pq lo validara desde el Schema
//
//		                     if( ( currentChildName.equals("location") ) && ( !parentNodeName.equals("metadata") ) )
//		                     {
//
//		                        result = false && result;
//
//		                     }

		                 if( ( currentChildName.equals("sequencing") ) && ( !parentNodeName.equals("item") )
		                        && ( !parentNodeName.equals("organization") )&& ( !parentNodeName.equals("sequencingCollection") ) )
		                     {
		                	 	insertaError("8.40","");
		                	 	result = false && result;

		                 }
		              } // end something
		              result = esNodoCorrecto(currentChild, "", tipoOde) && result;
		           }
		         }
		       
		        break;
		     }
		     // handle entity reference nodes
		     case Node.ENTITY_REFERENCE_NODE:
		     {
		        break;
		     }
		     // text
		     case Node.COMMENT_NODE:
		     {
		        break;
		     }
		     case Node.CDATA_SECTION_NODE:
		     {
		        break;
		     }
		     case Node.TEXT_NODE:
		     {
		        break;
		     }
		     default:
		     {
		        break;
		     }
		  }// end switch statement
		return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    private boolean esLOMCorrecto(Node lom) {
    	boolean resLom= false;
    	String metaValor="";
    	if (lom!= null) {
    		String parentNodeName = lom.getLocalName();
    		Vector metaHijos = new Vector();
            if( parentNodeName.equals("lom") ) {
            	//metaHijos = DOMTreeUtility.getNodes(lom, "metaMetadata");
            	metaHijos = DOMTreeUtility.getNodes(lom, "metaMetadata");
            	if (!metaHijos.isEmpty()) {
            		for (int im=0; im<metaHijos.size(); im++) {
            			Node nMeta = (Node)metaHijos.get(im);
            			Vector schemas = new Vector();
            			schemas = DOMTreeUtility.getNodes(nMeta, "metadataSchema");
            			for (int ll=0; ll<schemas.size();ll++) {
            				Node nsc= (Node)schemas.get(ll);
            				NodeList nl= nsc.getChildNodes();
            				if ((nl!=null) && (nl.getLength()>=1)) {
            					for (int nlh=0; nlh<nl.getLength(); nlh++) {
            						metaValor= nl.item(nlh).getNodeValue();
            						metaValor= metaValor.replaceAll("\\.", "");
            						metaValor=metaValor.replaceAll(" ", "");
            						String metaValorMinus=metaValor.toString().toLowerCase().trim();
            						
            						String esquemaLomes = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");//LOM-ESv1.0
//            						String esquemaLomes = "LOM-ESv1.0";
            						esquemaLomes = esquemaLomes.replaceAll("\\.", "");
            						esquemaLomes = esquemaLomes.replaceAll(" ", "");
            						esquemaLomes = esquemaLomes.toLowerCase().trim();
            						//De forma temporal son validos con espacios y las mayus y minus
            						if (metaValorMinus.equals(esquemaLomes)) {//"lom-esv1.0"
            							resLom=true; //si al menos uno no tiene esto... lo tenemos q quitar
            						}
            					}
            				}
            			}
            			
            		}
            	}
            }
    	}
    	return resLom;
    }
    /**
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#chequearHref(java.lang.String)
     */
    public java.lang.Boolean chequearHref(java.lang.String nomContenidos)
    {
        //@todo implement public java.lang.Boolean chequearHref(java.lang.String nomContenidos)
    	Boolean result = new Boolean(true);
	    String mensaje = "";
	    
		if( !( nomContenidos.equals("") ) )
	      {
	         // Chequea si el protocolo es valido
	         if( ( (nomContenidos.length() > 4) && (nomContenidos.substring(0, 5).equals("http:")) ) || 
	             ( (nomContenidos.length() > 5) && (nomContenidos.substring(0, 6).equals("https:")) ) ||
	             ( (nomContenidos.length() > 3) && (nomContenidos.substring(0, 4).equals("ftp:")) ) || 
	             ( (nomContenidos.length() > 4) && (nomContenidos.substring(0, 5).equals("ftps:")) ) )
	         {
	            try
	            {
	               URL url = new URL(nomContenidos);
	               //URL url = new URL("http://www.google-es.com");
//	               URLConnection urlConn = url.openConnection();
//	               HttpURLConnection httpUrlConn = (HttpURLConnection)urlConn;
//	               String pruebaHost=url.getHost();
//	               InetAddress address = InetAddress.getByName( pruebaHost );
//	               String ipAddress=address.getHostAddress();
//	               if( (ipAddress!=null) && (!ipAddress.equals("")) )
//	               {
//	                  mensaje = "ESTADO HTTP CORRECTO";
//	                  logger.debug(mensaje);
//	               }
//	               else
//	               {
//	                  mensaje =  "ERROR DE CONEXION";
//	                  logger.warn(mensaje);
//	                  result = new Boolean(false);
//	               }
	            }
//	            catch (UnknownHostException ue) {
//	            	   mensaje =  "URL DESCONOCIDA" + ue;
//		               logger.warn(mensaje);
//		               result = new Boolean(false);
//	            }
	            catch( MalformedURLException mfue )
	            {
	            	insertaError("8.6",nomContenidos);
	   				logger.warn("URL MALFORMADA"+nomContenidos, mfue); 
	   				result = new Boolean(false);
	            }
	            catch( IOException ioe )
	            {
	            	insertaError("8.7",nomContenidos);
	   				logger.warn("ERROR DE ENTRADA/SALIDA"+nomContenidos, ioe); 
	   				result = new Boolean(false);
	            }
	         }
	         else if ((nomContenidos.length() <= 5) && ((nomContenidos.startsWith("http")) || (nomContenidos.startsWith("ftp")) )) {
	        	 String pathAbsoluto= getBaseDirectory() + "/" + nomContenidos;
	        	 File fichCont = new File(pathAbsoluto);
	        	 if (!fichCont.exists())
	        	 {
	        		 insertaError("8.8",nomContenidos);
		   			logger.warn("EL FICHERO NO EXISTE"+nomContenidos); 
	        		result = new Boolean(false);
	        	 }
	         }
	         else if( nomContenidos.substring(0, 5).equals("file:") )
	         {
	            // This is the local file system
	        	 insertaError("8.9",nomContenidos);
	             logger.warn("FICHERO INCORRECTO"+nomContenidos);
	             result = new Boolean(false);
	         }
	         else
	         {
	            try {
					result = chequearLocalURL(nomContenidos);
//					if(!result.booleanValue()){
//						insertaError("8.10",nomContenidos);
//						logger.error("ERROR DE CONTENIDOS"+nomContenidos);
//					}
				} catch (Exception e) {
					insertaError("8.10",nomContenidos);
					logger.error("ERROR DE CONTENIDOS "+nomContenidos,e);
					result = new Boolean(false);
				} 
	         }
	      }
		return result;
    }

    /**
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#chequearLocalURL(java.lang.String)
     */
    public java.lang.Boolean chequearLocalURL(java.lang.String nomContenidos) throws Exception
    {
        //@todo implement public java.lang.Boolean chequearLocalURL(java.lang.String nomContenidos)
    	 Boolean resultado = new Boolean(true);
	      String mensaje = "";
	     
	    	 String pathAbsoluto = getBaseDirectory() + "/" + nomContenidos;
		     int queryIndex = pathAbsoluto.indexOf('?');
	         if( queryIndex > 0 )
	         {
	            pathAbsoluto = pathAbsoluto.substring(0, queryIndex);
	         }

	         int fragmentIndex = pathAbsoluto.indexOf('#');
	         if( fragmentIndex > 0 )
	         {
	            pathAbsoluto = pathAbsoluto.substring(0, fragmentIndex);
	         }
	       
//	        try
//	         { 	 
//	             pathAbsoluto = URLDecoder.decode(pathAbsoluto, "UTF-8");
//	         }
//	         catch( UnsupportedEncodingException uee )
//	         {
//	             mensaje= "ENCODING INCORRECTO" + uee;
//	             logger.error(mensaje);
//	             throw uee;
//	         }
	         try
	         {
	            File fichAElegir = new File(pathAbsoluto);
	            File fichAux = (new File(pathAbsoluto)).getCanonicalFile();
	            String rutaAux = fichAux.getPath();
	            String nomStringConverted = null;
	            if(!File.separator.equals("/")) nomStringConverted = nomContenidos.replace('/', File.separatorChar);
	            else nomStringConverted = nomContenidos;
	            //en nomStringConverted tenemos el fichero solo sea contenido\index.html, ./index.html, ../index.html.... si existe alguno de los dos ultimos habria que quitarlo
	            if (nomStringConverted.startsWith("..\\")) {
	            	int longiPuntos = nomContenidos.split("\\../").length;
	            	if (longiPuntos>1) {
	            		String nomAux=nomContenidos.split("\\../")[longiPuntos-1];
	            		nomStringConverted=nomAux;
	            	}
	            	
	            }else if (nomStringConverted.startsWith(".\\")) {
	            	int longiPuntos = nomContenidos.split("\\./").length;
	            	if (longiPuntos>1) {
	            		String nomAux=nomContenidos.split("\\./")[longiPuntos-1];
	            		nomStringConverted=nomAux;
	            	}
	            }
	            boolean ok= rutaAux.endsWith(nomStringConverted);
	            logger.debug("CHEQUEO URL ISFILE " + fichAElegir.isFile());
	            logger.debug("CHEQUEO URL CONTENIDO CORRECTO " + ok);
	            if(( fichAElegir.isFile() ) && (ok))
	            {
	               String tempStr = fichAElegir.getPath();
	               tempStr = tempStr.replace('\\', '/');
	               mFileList.remove(tempStr);
	            }
//
//		            File fichAElegir = new File(pathAbsoluto);
//		            if( fichAElegir.isFile() )
//		            {
//		               String tempStr = fichAElegir.getPath();
//		               tempStr = tempStr.replace('\\', '/');
//		               mFileList.remove(tempStr);
//		            }
	            else
	            {
	            	insertaError("8.9",nomContenidos);
	               logger.warn("FICHERO INCORRECTO " + pathAbsoluto);
	               resultado = new Boolean(false);
	            }
	         }
	         catch( NullPointerException npe )
	         {
	        	 insertaError("8.11","");
	            logger.error("ERROR NULL POINTER, EL OBJETO NO PUEDE SER VACIO",npe);
	            resultado = new Boolean(false);
	            throw npe;
	         }
	         catch( SecurityException se )
	         {
	        	 insertaError("8.12","");
	            logger.error("ERROR DE SEGURIDAD",se);
	            resultado = new Boolean(false);
	            throw se;
	         }
	      
	      return resultado;
    }

    /**
     * @see es.pode.validacion.negocio.dominio.ManifestEntity#chequearExcesoEquipaje()
     */
    public String chequearExcesoEquipaje()
    {
    	String mensaje = "";
    	String ficheros= "";
	      if( mFileList.size() > 0 )
	      {
	         // If there is only one file in the list
	         if( mFileList.size() == 1 )
	         {
	            mensaje =" El siguiente fichero está incluido en el contenido del paquete pero no ha sido "
	            	   + "referenciado en el fichero manifest: "; 
	            	
	         }
	         // If there is more than one file in the list
	         else
	         {
	            mensaje = "Los siguientes ficheros han sido incluidos en el contenido del paquete "
	               + "pero no han sido referencados en el fichero manifest: ";
	               
	         }
	         for( int i = 0; i < mFileList.size(); i++ )
	         {
	            ficheros = ficheros + ";" + (String)mFileList.get(i);
	            
	         }

	      }// end if
	      String ficherosAux="";
	      if (ficheros.startsWith(";", 0))
	      {
	    	  ficherosAux=ficheros.substring(1, ficheros.length());
	      }
	      else {
	    	  ficherosAux=ficheros;
	      }
	      return mensaje + ficherosAux;
    }
    
    // Devuelve true si el nodo raiz es un manifest o un lom
    public Boolean esRootValido(java.lang.String rutaManifest)
    {
       Boolean result = new Boolean(false);
       String fichImsManifest = rutaManifest + File.separator + "imsmanifest.xml";
	   File manifestFile = new File(fichImsManifest);
	   if( manifestFile.exists() )
	    {
	    	 Node rootNode = mDocument.getDocumentElement();
	         String rootNodeName = rootNode.getLocalName();
	         String rootNodeNamespace = rootNode.getNamespaceURI();

	         if( rootNodeName.equals("manifest") )  
	         {
	            if ( rootNodeNamespace.equals( DOMTreeUtility.IMSCP_NAMESPACE ) )
	            {
	               result = new Boolean(true);
	            }
	         }
	         else if( rootNodeName.equals("lom") )  
	         {
	            if ( rootNodeNamespace.equals( DOMTreeUtility.IEEE_LOM_NAMESPACE ) )
	            {
	               result = new Boolean(true);
	            }
	         }
	      }
	     
       return result;
    }
    ///////////////////////////////////////////////////////////////
    ///    			METODOS NUEVOS DE PRUEBA 			///
    
    /**
     * This method sets up the input source for the test subject file.
     *
     * @param iFileName The name of the file we are are setting up the input 
     * source for.
     *
     * @return Returns an input source needed for parsing
     */
//    private InputSource setUpInputSource( String iFileName )
//    {
//       InputSource is = new InputSource();
//       //is = setupFileSource(iFileName);
//       return is;
//    }
    
    /**
     * Sets up the file source for the test subject file.
     *
     * @param iFileName file to setup input source for.
     *
     * @return InputSource
     */
//    private InputSource setupFileSource( InputStreamReader iFileName)
//    {
//       String msgText;
//       boolean defaultEncoding = true;
//       String encoding = null;
//       PushbackInputStream inputStream;
//       FileInputStream inFile;
//
//       try
//       {
//            InputSource is = null;            
//            defaultEncoding = true;
//            int longi= iFileName.toString().length();
//            BufferedReader inStream =  new BufferedReader(iFileName);
//            StringBuffer dataString = new StringBuffer();
//            String s = ""; 
//            char[] cbuf = new char[9999];
//            //Builds the encoded file to be parsed
//                
//            int in=inStream.read(cbuf);
//            s = new String(cbuf);
//            inStream.close();
//            is = new InputSource(new StringReader(dataString.toString()));
//            is.setEncoding(encoding); 
//            return is;
//       }
//       catch ( NullPointerException  npe )
//       {
//          msgText = "Null pointer exception" + npe; 
//        }
//       catch ( SecurityException se )
//       {
//          msgText = "Security Exception" + se; 
//       }
//       catch ( FileNotFoundException fnfe )
//       {
//          msgText = "File Not Found Exception" + fnfe; 
//       }
//       catch ( Exception e )
//       {
//          msgText = "General Exception" + e; 
//       }
//
//       return new InputSource();
//    }
    //////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////
    
    private final Object transformEntity(final int transform, final es.pode.validador.negocio.dominio.ManifestEntityDaoImpl entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.pode.validador.negocio.dominio.ManifestEntityDao.TRANSFORM_VALIDAVO :
                    target = toValidaVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.pode.validador.negocio.dominio.ManifestEntityDao.TRANSFORM_VALIDAVO :
                toValidaVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }
    public final void toValidaVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, VALIDAVO_TRANSFORMER);
        }
    } 
    
    protected es.pode.validador.negocio.servicio.ValidaVO toValidaVO(Object[] row)
    {
        return null;
    }
    
    private final org.apache.commons.collections.Transformer VALIDAVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.pode.validador.negocio.dominio.ManifestEntityDaoImpl)
                {
                    result = toValidaVO((es.pode.validador.negocio.dominio.ManifestEntityDaoImpl)input);
                }
                else if (input instanceof Object[])
                {
                    result = toValidaVO((Object[])input);
                }
                return result;
            }
        };
        
        
        public es.pode.validador.negocio.dominio.ManifestEntityDaoImpl fromValidaVO(final es.pode.validador.negocio.servicio.ValidaVO vo) {
            //default mapping between VO and entity
            return (es.pode.validador.negocio.dominio.ManifestEntityDaoImpl) 
                      this.getBeanMapper().map(vo, es.pode.validador.negocio.dominio.ManifestEntityDaoImpl.class, DEF_MAPPING_VALIDAVO_MANIFESTENTITY);
        }
        
        public void fromValidaVO(es.pode.validador.negocio.servicio.ValidaVO vo, es.pode.validador.negocio.dominio.ManifestEntityDaoImpl entity) {
            //default mapping between VO and entity
            this.getBeanMapper().map(vo, entity, DEF_MAPPING_VALIDAVO_MANIFESTENTITY);
        }
        public es.pode.validador.negocio.servicio.ValidaVO toValidaVO(final es.pode.validador.negocio.dominio.ManifestEntityDaoImpl entity)
        {
            //default mapping between entity and VO
            //@todo verify or customize behaviour of this mapping
            return (es.pode.validador.negocio.servicio.ValidaVO) 
                      this.getBeanMapper().map(entity, es.pode.validador.negocio.servicio.ValidaVO.class, DEF_MAPPING_MANIFESTENTITY_VALIDAVO);
        }


        private void parse(DOMParser parser, String nombreFichero) throws Exception {
        	if(logger.isDebugEnabled()) logger.debug("Vacio la lista de errores");
//        	erroresParseo = new ArrayList();
        	if(logger.isDebugEnabled()) logger.debug("Iniciando parseo de " + nombreFichero);
        	int numErrores = erroresXerces.size();//num errores antes del parseo
        	ficheroActual="imsmanifest.xml";
        	parser.parse(nombreFichero);
        	if(numErrores < erroresXerces.size()) {//Si hay nuevos errores lanzamos la exception
        		String msg = "El fichero " + nombreFichero + " tiene errores de parseo";
        		if(logger.isDebugEnabled()) logger.debug(msg);
        		// Lanzo una excepcion para que se detecte el parseo erroneo. Los mensajes de error estan guardados en erroresXerces 
        		throw new SAXException(msg);
        	}
        	
        }
        
        //usado en los parseos de lomes
        private void parse(DOMParser parser, InputSource isrc, String nombreFichero) throws Exception {
        	if(logger.isDebugEnabled()) logger.debug("Vacio la lista de errores");
        	if(logger.isDebugEnabled()) logger.debug("Iniciando parseo de " + nombreFichero);
        	int numErrores = erroresXerces.size();//num errores antes del parseo
        	ficheroActual=nombreFichero;
        	parser.parse(isrc);
        	if(numErrores < erroresXerces.size()) {//Si hay nuevos errores en el array lanzamos la exception
        		String msg = "Fichero " +ficheroActual+" con errores de parseo";
        		if(logger.isDebugEnabled()) logger.debug(msg);
        		// Lanzo una excepcion para que se detecte el parseo erroneo. Los mensajes de error estan guardados en erroresXerces
        		throw new SAXException(msg);
        	}
        	
        }
        
        private ErrorParseoVO generaErrorParseoVO(int linea, int columna, String mensaje) {
        	ErrorParseoVO error = new ErrorParseoVO();
        	error.setLinea(new Integer(linea));
        	error.setColumna(new Integer(columna));
        	error.setMensaje(mensaje);
        	return error;
        }
        
		public void error(SAXParseException exception) throws SAXException {
			logger.error("Error de parseo : " + exception.getMessage());
			erroresXerces.add(generaErrorParseoVO(exception.getLineNumber(),
				exception.getColumnNumber(), exception.getMessage() + ";" + ficheroActual));
		}


		public void fatalError(SAXParseException exception) throws SAXException {
			logger.fatal("Error Fatal de parseo : " + exception.getMessage());
			erroresXerces.add(generaErrorParseoVO(exception.getLineNumber(),
					exception.getColumnNumber(), exception.getMessage() + ";" + ficheroActual));
		}


		public void warning(SAXParseException exception) throws SAXException {
			logger.warn("Error de parseo : " + exception.getMessage());
		}
		
		private void insertaError(String error, String textoAnadido){
			boolean encontrado=true;
			for(int i=0;i<erroresParseo.size()&& encontrado;i++){
				ErrorParseoVO errorParseo=(ErrorParseoVO)erroresParseo.get(i);
				String mensaje=errorParseo.getMensaje();
				int posicion=mensaje.indexOf("*");
				if(posicion>0){
					String inicioMensaje=mensaje.substring(0, posicion-1);
					String finMensaje=mensaje.substring(posicion+1);
					if(error.equals(inicioMensaje)){
						if(textoAnadido.equals("")|| finMensaje.equals(textoAnadido)){
							encontrado=false;	
						}
						
					}
				}	
			}
			
			if(encontrado){
				erroresParseo.add(generaErrorParseoVO(0, 0, error+" *  "+textoAnadido));
			}
			

			
		}
		
		
		private boolean sonIdiomasCorrectos(Node lom) {
	    	boolean correcto= true;
	    	boolean esIdiomaPlat =true;
	    	if (lom!= null) {
	    		String parentNodeName = lom.getLocalName();
	    		Vector hijos = new Vector();
	            if( parentNodeName.equals("lom") ) {
	            	//GENERAL
	            	hijos = DOMTreeUtility.getNodes(lom, "general");
	            	correcto =correcto && idiomaCorrecto(hijos);
	            	if(correcto)
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	//LIFECYCLE
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "lifeCycle");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//METAMETADATA 
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "metaMetadata");
		            	if(hijos.size()>0){
		            		Node metaMetadata = (Node) hijos.get(0);
		            		Node language = DOMTreeUtility.getNode(metaMetadata, "language");
		            		if(language !=null){
			            		NodeList nList=(NodeList) language.getChildNodes();
			            		String idioma = null;
			            		if (nList!=null && nList.getLength()>0){
			            			Node nValor = nList.item(0);
			            			if(nValor!=null)
			            				idioma = nValor.getNodeValue();
			            			}
			            		if(idioma !=null){
			            			esIdiomaPlat = esIdiomaDePlataforma(idioma);
			            			if(!esIdiomaPlat)
			            				insertaError("8.46", "");
			            		}
		            		}
	            		}	
	            		correcto =correcto && idiomaCorrecto(hijos);
	            		if(correcto)
	            			correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//TECHNICAL
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "technical");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//EDUCATIONAL
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "educational");
	            		correcto =correcto && idiomaCorrecto(hijos);
	            		if(correcto)
	            			correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//RIGHTS
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "rights");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//RELATION
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "relation");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//ANNOTATION
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "annotation");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            	//CLASIFICATION
	            	if(correcto){
	            		hijos = DOMTreeUtility.getNodes(lom, "classification");
	            		correcto =correcto && atributosIdiomaCorrectos(hijos,true);
	            	}
	            }
	    	}
	    	if (!correcto)
	    		insertaError("8.42","");
	    	return correcto && esIdiomaPlat;
	    }
	    
	    private boolean atributosIdiomaCorrectos(Vector hijos,boolean correcto){
        	if (!hijos.isEmpty()) {
        		for (int im=0; im<hijos.size() && correcto; im++) {
        			Node nodo = (Node)hijos.get(im);
        			NodeList hijosNodo=nodo.getChildNodes();
        			for(int i=0;i<hijosNodo.getLength() && correcto;i++){
        				Node hijo=hijosNodo.item(i);
            			Vector vString = new Vector();
            			String s=hijo.getLocalName();
            			vString = DOMTreeUtility.getNodes(hijo, "string");
            			if(vString.size()<=0 && s!=null){
            				Vector v =new Vector();
            				v.add(hijo);
            				correcto=atributosIdiomaCorrectos(v,correcto);
            			}else{
	            			for(int j=0;j<vString.size() && correcto;j++){
	            				Node nString = (Node)vString.get(j);
	                			NamedNodeMap atributos=nString.getAttributes();
	                			Node n=null;
	                			if(atributos!=null){
	                				n=atributos.getNamedItem("language");
	                				String idioma="";
	                				if(n!=null){
	                					idioma=n.getNodeValue();
	                					correcto = correcto && validaIdioma(idioma);//Comparacion con idioma iso
	                				}
	                			}			
	            			}
            			}
        			}
        		}
        	}
        	return correcto;
	    }
	    
	    private boolean idiomaCorrecto(Vector hijos){
	    	boolean correcto= true;
	    	String valor="";
        	if (!hijos.isEmpty()) {
        		for (int im=0; im<hijos.size() && correcto; im++) {
        			Node nodo = (Node)hijos.get(im);
        			Vector schemas = new Vector();
        			schemas = DOMTreeUtility.getNodes(nodo, "language");
        			for (int ll=0; ll<schemas.size() && correcto;ll++) {
        				Node nsc= (Node)schemas.get(ll);
        				NodeList nl= nsc.getChildNodes();
        				if ((nl!=null) && (nl.getLength()>=1)) {
        					for (int nlh=0; nlh<nl.getLength() && correcto; nlh++) {
        						valor= nl.item(nlh).getNodeValue();
        						correcto = correcto && validaIdioma(valor);//Comparacion con idioma iso
        					}
        				}
        			}		
        		}
        	}
        	return correcto;
	    }
	    
	    private boolean esIdiomaDePlataforma(String idioma){
	    	boolean enc = false;
	    	
	    	//
	    	// HACK ALERT: If the incoming idioma is "en-gb" then that is the same
	    	// as setting it to "en" (otherwise lots of things break unless we have
	    	// the overhead of including a complete new language set...)
	    	//
	    	
	    	if (idioma.equals("en-gb"))
	    		idioma = "en";
	    	
	    	try{
		    	String[] idiomasPlataforma = I18n.getInstance().obtenerIdiomasPlataforma();
//	    		String[] idiomasPlataforma = {"es","en","ca","gl","va","eu"};
		    	int i = 0;
		    	logger.info("AOV- IDIOMAS PLATAFORMA " + idiomasPlataforma);
		    	while (i< idiomasPlataforma.length && !enc){
		    		if (idiomasPlataforma[i].equals(idioma))
		    			enc = true;
		    		i++;
		    	}
			} catch (Exception e) {
				
				String mensaje = "ERROR validando idioma de catalogación " + e;
				logger.error(mensaje);
			}
			logger.info("AOV - esIdiomaDePlataforma " + enc);
			return enc;
	    }
	    
	    private boolean validaIdioma(String idioma){ 
	    	//([xX]{1}\\-([a-zA-Z0-9]{1,8}))
	    	//([a-zA-Z]{1,2})
	    	
	    	//cadenas que comienzan por "x-" mas un mínimo de un caracter y un máximo de ocho caracteres
	        Pattern pattern = Pattern.compile("^([xX]{1}\\-([a-zA-Z0-9]{1,8}))$");

	        Matcher matcher = pattern.matcher(idioma.trim());
	        boolean valido1=true;
	        if (!matcher.find()) {
	        	valido1 = false;
	        }
	        
	        //cadena de una o dos letra
	        
	        // MCA: modify this pattern to accept ISO languages of the form
	        // 2 letter code with an optional "-" followed by extra letters
	        pattern = Pattern.compile("^([a-zA-Z]{1,2}(\\-[a-zA-Z]+){0,1})$");

	        matcher = pattern.matcher(idioma.trim());
	        
	        boolean valido2=true;
	        if (!matcher.find()) {
	        	valido2 = false;
	        }
	    	
	    	
	    	return valido1 || valido2;
	    }
	    private void metadatosCorrectos(boolean result,Node iTestSubjectNode) throws IOException{
	    	Node caMetadataNode = DOMTreeUtility.getNode(iTestSubjectNode, "metadata");
	    	if(caMetadataNode!=null){
	            int multiplicityUsed = getMultiplicityUsed(caMetadataNode, "lom");
	            if (multiplicityUsed >= 1) {
	            	boolean esLomOK = false;
	           	 	boolean idiomasOK = false;
	           	 	Vector vLomes = new Vector();
	           	 	vLomes=DOMTreeUtility.getNodes(caMetadataNode, "lom");
	           	 	for (int nl=0; nl<vLomes.size(); nl++) {
	           	 		Node nLom = (Node)vLomes.get(nl);
	           		 
	           	 		idiomasOK = sonIdiomasCorrectos(nLom);
	           	 		if(!idiomasOK){
	           	 			result = false && result;
	           	 			
	           	 		}
	           		 
	           	 		esLomOK =esLOMCorrecto(nLom);
	
	               		if (!esLomOK) { // lo eliminamos
	            			 cambiarPorLocation(nLom, caMetadataNode, iTestSubjectNode);
	               		}
	           	 	}//fin for
	            }//fin check lom
            
				// Borramos los hijos que no sean correctos
				NodeList hijosCorrectos = caMetadataNode.getChildNodes();
				if (hijosCorrectos.getLength()>0) {
				   for (int rHijos=0; rHijos<hijosCorrectos.getLength(); rHijos++ ) {
				   		Node nodoHijo=hijosCorrectos.item(rHijos);
				   		String nomHijo=nodoHijo.getLocalName();
				   		//mirar que lo que borramos sea distinto de lom y location
				   		if (nomHijo!=null) {
				   			if (!(nomHijo.equals("lom")) && !(nomHijo.equals("location"))){
								cambiarPorLocation(nodoHijo, caMetadataNode, iTestSubjectNode);
							}
				   		}
				   }//end for
			   }
	    	}
	    }
	
	    private void cambiarPorLocation(Node metadato, Node caMetadataNode,Node iTestSubjectNode) throws IOException{

    		Document doc =iTestSubjectNode.getOwnerDocument();
            Element location= doc.createElement("adlcp:location");
    	    
			//comprobamos que no existe otro fichero con ese nombre, si ya existe buscamos otro que este libre
            String nombreMetadatoNoValido="metadatos/metadato" + indiceMetadato +".xml";
            String rutaMetadato = new StringBuffer(getBaseDirectory()).append("/").append(nombreMetadatoNoValido).toString();
            File fileMetadato = new File(rutaMetadato);
            while(fileMetadato.exists()){
            	indiceMetadato++;
            	nombreMetadatoNoValido="metadatos/metadato" + indiceMetadato +".xml";
                rutaMetadato = new StringBuffer(getBaseDirectory()).append("/").append(nombreMetadatoNoValido).toString();
                fileMetadato = new File(rutaMetadato);
            }
			indiceMetadato++;
			metadatos.add(metadato);
			nombreMetadatos.add(nombreMetadatoNoValido);
			//sustituimos el metadato no valido por la etiqueta location con la localizacion de fichero donde lo hemos guardado
			location.appendChild(doc.createTextNode(nombreMetadatoNoValido));
            caMetadataNode.replaceChild(location, metadato);
            setHaCambiadoDocument(true);
	    }
	    
	    private void escribirMetadatos()throws IOException {
            //comprobamos que la carpeta donde vamos a guardar los metadatos incorrectos existe, si no existe la creamos 
	    	
            String carpeta=new StringBuffer(getBaseDirectory()).append("/metadatos").toString();
            File carpetaMetadatos= new File(carpeta);
			if(!carpetaMetadatos.exists())
			{
				if(logger.isDebugEnabled()) logger.debug("si la carpeta metadatos no existe, la creo");
				carpetaMetadatos.mkdirs();
			}
			for(int i = 0;i<metadatos.size();i++){
				Node metadato = (Node) metadatos.get(i);
				
	            String nombreMetadatoNoValido=(String) nombreMetadatos.get(i);
	            String rutaMetadato = new StringBuffer(getBaseDirectory()).append("/").append(nombreMetadatoNoValido).toString();
	            File fileMetadato = new File(rutaMetadato);
	            //escribimos el archivo con el metadato no valido
				FileOutputStream fs = new FileOutputStream(fileMetadato);
				DOMBuilder dom = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
				org.jdom.Element finalDoc = dom.build(
						(org.w3c.dom.Element)metadato );
				new XMLOutputter().output(finalDoc,fs);
				
			}
	    }
	   
		public List getLomes() {
			return lomes;
		}

		public void setLomes(List lomes) {
			this.lomes = lomes;
		}
	    
		
		public Boolean validarTodosLomes(){
			boolean result =true;
			InputSource isrc = null;

			try {
				for (int i = 0; i< lomes.size();i++){//cada nodo lom lo pasamos a un inputsource y lo parseamos 
					Node lom = (Node) lomes.get(i);
					
					NamedNodeMap atributos = lom.getAttributes();
					boolean enc = false;
					for(int j=0;j<atributos.getLength() && !enc;j++){
						Node atributo = atributos.item(j);
						String valor = atributo.getLocalName();
						if(valor.equals("schemaLocation")){
							enc=true;
							atributos.removeNamedItem(atributo.getNodeName());
						}
					}
			
					
					DOMBuilder dom = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
					org.jdom.Element finalDoc = dom.build(
							(org.w3c.dom.Element)lom );
	                
					Writer writer = new StringWriter();
					XMLOutputter outputter = new XMLOutputter();
	                outputter.output(finalDoc, writer);  
	                
	                String xml = writer.toString();            	
				logger.info("### MCA: Parsing XML file " + xml);
	        		isrc = new InputSource(new StringReader(xml));
	        		
	        		result = parsearLomes(isrc,(String) nombreLomes.get(i)) && result;
				}
			} catch (Exception e) {
				
				String mensaje = "ERROR validando los LOM-ES " + e;
				logger.error(mensaje);
			}		
			
			return new Boolean(result);

		}
		
		
		public boolean parsearLomes (InputSource lomes,String nombreFichero) throws Exception {
			boolean result = true;

	    	String ficheroProperties = "/validador.properties";
			InputStream is= null;
			logger.info("ASC- METODO: obtenerValidacionLomes!!!! ");
	    	DOMParser mParser = new DOMParser();
	    	
			if (mParser != null){
				try
				{
					if( logger.isDebugEnabled() )
						logger.debug( "URL del parseador: " + mParser.getClass().getResource( mParser.getClass().getName().replace('.','/') + ".class") );
			    	
					is= this.getClass().getResourceAsStream(ficheroProperties);
					Properties fproperties = new Properties();
					fproperties.load(is);
					String lomCustom = fproperties.getProperty("lomCustom");
					String url_lomCustom = fproperties.getProperty("url_lomCustom");
					
					File fileLomCustom=new File(lomCustom);
					String sLomCustom=fileLomCustom.getCanonicalPath();
					
					logger.info("AOV- METODO: parsearLomes Namespaces: " + sLomCustom + "; ");
					
					mParser.setFeature("http://xml.org/sax/features/validation", true);
					mParser.setFeature("http://xml.org/sax/features/namespaces", true);
				     
					//estas "feature" son para la validación del manifest contra los esquemas
					mParser.setFeature("http://apache.org/xml/features/validation/schema",true);
				      
					logger.info("METODO: parsearLomes!!!! ANTES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
					mParser.setFeature("http://apache.org/xml/features/validation/schema/ignore-xsi-type-until-elemdecl", true);
				     
					logger.info("METODO: parsearLomes!!!! DESPUES DE IGNORE-XSI-TYPE-UNTIL-ELEMDECL");
					String namespacesFull = url_lomCustom + " "+ sLomCustom;
					logger.info("METODO: parsearLomes!!!! NAMESPACESFULL -> " + namespacesFull.replace( '\\', '/'));
						
					mParser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", namespacesFull);
				      
					mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
					mParser.setErrorHandler(this);
				}
				catch (SAXException se )
				{
					String mensaje = "ERROR SAXException " + se;
					logger.warn(mensaje);
					result=false;
				}
				   
				try{
					parse(mParser,lomes,nombreFichero);
				}
				catch ( SAXException se )
				{
					logger.error("ERROR EN EL XML",se);	
	        		String msg = "Lomes con errores de parseo";
	        		if(logger.isDebugEnabled()) logger.debug(msg);
					result=false;
				} 
			}
			return result;	
		}

		
		
		public Boolean tieneLomes(org.w3c.dom.Node arbolDoc) throws Exception{
			boolean result=true;

            Node rootNode = ( (Document)arbolDoc ).getDocumentElement();
            if(rootNode!=null){
            	Node metadata = DOMTreeUtility.getNode(rootNode, "metadata");
            	if (metadata!=null){
            		Node lom = DOMTreeUtility.getNode(metadata, "lom");
            		if(lom!=null){
            			if(!esLOMCorrecto(lom))
            				result = false;
            		}
            		else {
            			Node location = DOMTreeUtility.getNode(metadata, "location");
            			if(location!=null){
            				String localizacion = location.getFirstChild().getNodeValue();
            				//se obtiene el lom que se referencia en el location y se comprueba si esta bien formado
            				// y si es un lom-esv1.0
            				result = obtenerNodoLomDeLocation(localizacion).booleanValue();

            			}
            			else {
            				result = false;
            			}
            		}
            	}
            	else result =false;
            }
            else result =false;
            if (!result)
            	insertaError("2.1", "");
			return new Boolean(result);
		}
		
		private Boolean obtenerNodoLomDeLocation(String localizacion) throws Exception{
			Boolean result = new Boolean(true);
			Document docValido = null;
			mParser = new DOMParser();
			if (mParser != null){
				try
			      {
				      mParser.setFeature("http://xml.org/sax/features/validation", false);
				      mParser.setFeature("http://xml.org/sax/features/namespaces", true);
				      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
					
				      mParser.setErrorHandler(new XMLErrorHandler());//no añadimos los errores de xerces al array
				      
				} catch (SAXException se ) {
				      logger.error("ERROR EN EL XML",se);
				      result = new Boolean(false);
			    }
				localizacion =getBaseDirectory() + "/" + localizacion;
				String nomFich = buscaFichero( localizacion, "xml" ); 
				
				File tempXMLFich = new File(nomFich);
				String xsdLoc = "file:///" + tempXMLFich.getParent() + "/";  
				xsdLoc = xsdLoc.replaceAll( " ", "%20");  
				xsdLoc = xsdLoc.replace( '\\', '/');
					
				if ( !nomFich.equals("") ) {
					try
					{	
						parse(mParser,nomFich );
						
						docValido = mParser.getDocument();
						if ( docValido != null ) {		
							Node lom = mParser.getDocument().getDocumentElement();
							
							if(!esLOMCorrecto(lom))
								result = new Boolean(false);
						}
					}
					catch ( SAXException se ) {
						result = new Boolean(false);//Lomes mal formado
						logger.error("ERROR EN EL LOMES",se);					
					}
					catch ( IOException ioe ) {
						result = new Boolean(false);//Si algun fichero no se ha encontrado
						logger.error("ERROR DE ENTRADA/SALIDA",ioe);
					}
				}
				else 
					result = new Boolean(false);
			 }
			
			return result;
		}
		
		
		//Se buscan en el nodo iTestSubjectNode todos los lomes que contenga. Los referenciados mediante location se obtienen siempre
		//pero los lomes que este incrustados en el manifest, solo se obtienen para la validacion binaria(obtenerValidacionBin)
		//y la validacion del empaquetador(obtenerValidacion), en estos dos casos el valor de soloLocation es true
	    public boolean buscarLomes (org.w3c.dom.Node iTestSubjectNode,boolean soloLocation) throws Exception
	    {
	        //@todo implement public java.lang.Boolean chequearContenido(org.w3c.dom.Document arbolDoc, java.lang.String rutaManifest)
	    	boolean result = true;
		
			switch( iTestSubjectNode.getNodeType() )
			  {
			     case Node.PROCESSING_INSTRUCTION_NODE:
			     {
			        // Skip any processing instructions, nothing for us to do
			        break;
			     }
			     case Node.DOCUMENT_NODE:
			     {
			        Node rootNode = ( (Document)iTestSubjectNode ).getDocumentElement();
			        result = buscarLomes(rootNode,soloLocation);
			        break;
			     }
			     case Node.ELEMENT_NODE:
			     {
			    	 String parentNodeName = iTestSubjectNode.getLocalName();
			    	 /**********location************/
			    	 if(parentNodeName ==null){
			    		 parentNodeName= iTestSubjectNode.getNodeName();//location
			    	 }
			    	 /**********location************/
			       
			    	 if( parentNodeName.equalsIgnoreCase("item"))
			    	 {
			    		 NodeList childrenOfItem = iTestSubjectNode.getChildNodes();
			    		 if( childrenOfItem != null ){
			    			 Node currentItemChild;
			    			 String currentItemChildName;
			    			 int len = childrenOfItem.getLength();
			    			 for( int k = 0; k < len; k++ ){
			    				 currentItemChild = childrenOfItem.item(k);
			    				 currentItemChildName = currentItemChild.getLocalName();
			    				 if (currentItemChildName != null){
			    					 //vuelvo a lanzar la llamada para cada nodo hijo
			    					 result = buscarLomes(currentItemChild,soloLocation) && result;
			    				 }
			    			 }
			    		 } //en if nombre nodo  
			    	 } // end if Items
			       
			       	else if( parentNodeName.equalsIgnoreCase("resource") ){
			       		obtenerLomes(iTestSubjectNode,soloLocation);
			       	}
			       	else if(parentNodeName.equalsIgnoreCase("file")){
			       		obtenerLomes(iTestSubjectNode,soloLocation);	
		       		}
			        //chequeo los hijos
			    	NodeList children = iTestSubjectNode.getChildNodes();
			        int multiplicityUsed = -1;
			        if( children != null ){
			        	int numChildren = children.getLength();
			        	//hacer el chequeo con los hijos
			        	if( parentNodeName.equalsIgnoreCase("manifest") ){
			        		// check for mandatory metadata element at package level
			        		Node caMetadataNode = DOMTreeUtility.getNode(iTestSubjectNode, "metadata");
			  
			        		multiplicityUsed = getMultiplicityUsed(caMetadataNode, "lom");
			        		if (multiplicityUsed >= 1 && !soloLocation) {
			        			boolean esLomOK = false;
			        			Vector vLomes = new Vector();
			        			vLomes=DOMTreeUtility.getNodes(caMetadataNode, "lom");
			        			for (int nl=0; nl<vLomes.size(); nl++) {
			        				Node nLom = (Node)vLomes.get(nl);
			        				esLomOK =esLOMCorrecto(nLom);
			        				if (esLomOK) { //sustituimos lomes por la etiqueta location y añadimos el lomes a la lista de lomes para
			        					//para despues hacerles el parsearLom
			        					lomes.add(nLom);
			        					nombreLomes.add("");
			        					caMetadataNode.removeChild(nLom);
			        				}
			        			}//fin for
			        		}//fin check lom 
			        		
			                multiplicityUsed = getMultiplicityUsed(caMetadataNode, "location");
			                if (multiplicityUsed >= 1) {
			                	Vector vLocation = new Vector();
			               	 	vLocation=DOMTreeUtility.getNodes(caMetadataNode, "location");
			               	 	for (int nl=0; nl<vLocation.size(); nl++) {
			               	 		Node nLocation = (Node)vLocation.get(nl);          		 
			                      	String localizacion=nLocation.getFirstChild().getNodeValue();
			                      	obtenerLomesLocation(localizacion);//obtenemos el lomes si lo hubiese de la localizacion indicada
			               	 	}//fin for
			                }//fin check lom
			        		
			        	}

			        	else if( parentNodeName.equalsIgnoreCase("organization") )
			        	{		              
			        		obtenerLomes(iTestSubjectNode,soloLocation);
			        	}

			        	for( int z = 0; z < numChildren; z++ )
			        	{
			        		Node currentChild = children.item(z);
			        		result = buscarLomes(currentChild,soloLocation) && result;
			        	}
			        }
			       
			        break;
			     }
			     // handle entity reference nodes
			     case Node.ENTITY_REFERENCE_NODE:
			     {
			        break;
			     }
			     // text
			     case Node.COMMENT_NODE:
			     {
			        break;
			     }
			     case Node.CDATA_SECTION_NODE:
			     {
			        break;
			     }
			     case Node.TEXT_NODE:
			     {
			        break;
			     }
			     default:
			     {
			        break;
			     }
			  }// end switch statement
			return result;
	    }

	//Se obtienen los lomes que contenga el nodo, tanto los referenciados mediante location como los incrustados en el manifest
    private void obtenerLomes(Node iTestSubjectNode,boolean soloLocation) throws Exception{
    	Node caMetadataNode = DOMTreeUtility.getNode(iTestSubjectNode, "metadata");
    	if(caMetadataNode!=null){
            int multiplicityUsed = getMultiplicityUsed(caMetadataNode, "lom");
            if (multiplicityUsed >= 1 && !soloLocation) {
            	boolean esLomOK = false;
           	 	Vector vLomes = new Vector();
           	 	vLomes=DOMTreeUtility.getNodes(caMetadataNode, "lom");
           	 	for (int nl=0; nl<vLomes.size(); nl++) {
           	 		Node nLom = (Node)vLomes.get(nl);          		 
           	 		esLomOK =esLOMCorrecto(nLom);

               		 if (esLomOK) { 
               			lomes.add(nLom);
               			nombreLomes.add("");
               			caMetadataNode.removeChild(nLom);
            		 }
               		 
        		 
           	 	}//fin for
            }//fin check lom
            
            multiplicityUsed = getMultiplicityUsed(caMetadataNode, "location");
            if (multiplicityUsed >= 1) {
            	Vector vLocation = new Vector();
           	 	vLocation=DOMTreeUtility.getNodes(caMetadataNode, "location");
           	 	for (int nl=0; nl<vLocation.size(); nl++) {
           	 		Node nLocation = (Node)vLocation.get(nl);          		 
                  	String localizacion=nLocation.getFirstChild().getNodeValue();
                  	obtenerLomesLocation(localizacion);
           	 	}//fin for
            }//fin check lom
    	}
    }
    
    //Obtiene el lomes que hay en la localizacion indicada, añadiendo dicho lomes al array de lomes si esta bien formado y es un LOM-ESv1.0
    private void obtenerLomesLocation(String localizacion)throws Exception{
    	if (lomes ==null)
			lomes = new ArrayList();
    	
		Document docValido = null;
		mParser = new DOMParser();
		if (mParser != null){
			try
		      {
			      mParser.setFeature("http://xml.org/sax/features/validation", false);
			      mParser.setFeature("http://xml.org/sax/features/namespaces", true);
			      mParser.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false );
				
			      mParser.setErrorHandler(new XMLErrorHandler());//no añadimos los errores de xerces al array
			} catch (SAXException se ) {
			      logger.error("ERROR EN EL XML",se);
			}
			String locCompleta =getBaseDirectory() + "/" + localizacion;
			String nomFich = buscaFichero( locCompleta, "xml" ); 
			
			File tempXMLFich = new File(nomFich);
			String xsdLoc = "file:///" + tempXMLFich.getParent() + "/";  
			xsdLoc = xsdLoc.replaceAll( " ", "%20");  
			xsdLoc = xsdLoc.replace( '\\', '/');
				
			if ( !nomFich.equals("") ) {
				try
				{	
					parse(mParser,nomFich );
					
					docValido = mParser.getDocument();
					if ( docValido != null ) {		
						Node lom = mParser.getDocument().getDocumentElement();					
						
						if(esLOMCorrecto(lom)){
							lomes.add(lom);
							nombreLomes.add(localizacion);
						}
					}
				}
				catch ( SAXException se ) {
					//Lom mal formado
					logger.error("ERROR EN EL LOMES",se);					
				}
				catch ( IOException ioe ) {
					//Si algun fichero no se ha encontrado
					logger.error("ERROR DE ENTRADA/SALIDA",ioe);
				}
			}
			
		}
    }    
//    public void escribirFicheros(String nomFich) throws Exception{
//		if (getHaCambiadoDocument()) {
////			if (validadorRes) {
//				nomFich=nomFich.replaceAll("\\", "/");
//				FileOutputStream fs = new FileOutputStream(new File(nomFich)); //machacamos imsmanifest
//				DOMBuilder dom = new DOMBuilder("org.jdom.adapters.XercesDOMAdapter");
//				org.jdom.Document finalDoc = dom.build(
//						(org.w3c.dom.Document)mDocument );
//				
//				new XMLOutputter().output(finalDoc,fs);
//				
//				escribirMetadatos();//se escribe en ficheros los metadatos que no sean LOM-ESv1.0
////			}
//		
//		}
//    }
}
