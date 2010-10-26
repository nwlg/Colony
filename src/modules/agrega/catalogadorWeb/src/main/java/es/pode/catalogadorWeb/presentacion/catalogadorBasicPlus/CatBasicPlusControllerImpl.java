/* Agrega es una federaci贸n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut贸nomas propiedad de Red.es. Este c贸digo ha sido desarrollado por la Entidad P煤blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav茅s de la Secretar铆a de Estado de Telecomunicaciones y para la Sociedad de la Informaci贸n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci贸n y de Convergencia con Europa y entre Comunidades Aut贸nomas y Ciudades Aut贸nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 聯Sociedad de la Informaci贸n聰

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePartDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.catalogacion.negocio.servicios.AccesoVO;
import es.pode.catalogacion.negocio.servicios.AgregadorORVO;
import es.pode.catalogacion.negocio.servicios.ArbolCurricularVO;
import es.pode.catalogacion.negocio.servicios.AvAnnotationVO;
import es.pode.catalogacion.negocio.servicios.AvClassificationVO;
import es.pode.catalogacion.negocio.servicios.AvEducationalVO;
import es.pode.catalogacion.negocio.servicios.AvGeneralVO;
import es.pode.catalogacion.negocio.servicios.AvLifeCycleVO;
import es.pode.catalogacion.negocio.servicios.AvMetametadataVO;
import es.pode.catalogacion.negocio.servicios.AvRelationVO;
import es.pode.catalogacion.negocio.servicios.AvRightsVO;
import es.pode.catalogacion.negocio.servicios.AvTechnicalVO;
import es.pode.catalogacion.negocio.servicios.CBTaxonVO;
import es.pode.catalogacion.negocio.servicios.ClassificationVO;
import es.pode.catalogacion.negocio.servicios.ContribucionVO;
import es.pode.catalogacion.negocio.servicios.DescripcionVO;
import es.pode.catalogacion.negocio.servicios.DuracionVO;
import es.pode.catalogacion.negocio.servicios.EducationalVO;
import es.pode.catalogacion.negocio.servicios.EntidadVO;
import es.pode.catalogacion.negocio.servicios.EntryVO;
import es.pode.catalogacion.negocio.servicios.EsquemaDeMetadatosVO;
import es.pode.catalogacion.negocio.servicios.FechaVO;
import es.pode.catalogacion.negocio.servicios.FormatoVO;
import es.pode.catalogacion.negocio.servicios.FuenteVO;
import es.pode.catalogacion.negocio.servicios.GeneralVO;
import es.pode.catalogacion.negocio.servicios.IdVO;
import es.pode.catalogacion.negocio.servicios.IdentificadorVO;
import es.pode.catalogacion.negocio.servicios.IdiomaVO;
import es.pode.catalogacion.negocio.servicios.LangStringVO;
import es.pode.catalogacion.negocio.servicios.LomAvanzadoVO;
import es.pode.catalogacion.negocio.servicios.LomBasicoVO;
import es.pode.catalogacion.negocio.servicios.OtrosRequisitosVO;
import es.pode.catalogacion.negocio.servicios.PalabraClaveVO;
import es.pode.catalogacion.negocio.servicios.PautasInstalacionVO;
import es.pode.catalogacion.negocio.servicios.RecursoVO;
import es.pode.catalogacion.negocio.servicios.RequisitoVO;
import es.pode.catalogacion.negocio.servicios.RutaTaxonomicaVO;
import es.pode.catalogacion.negocio.servicios.SourceValueVO;
import es.pode.catalogacion.negocio.servicios.TamanioVO;
import es.pode.catalogacion.negocio.servicios.TaxonVO;
import es.pode.catalogacion.negocio.servicios.TituloVO;
import es.pode.parseadorXML.util.types.CataloguerVCard;
import es.pode.catalogacion.soporte.CataloguerDuration;
import es.pode.catalogacion.soporte.Contribucion;
import es.pode.catalogacion.soporte.Entidad;
import es.pode.catalogacion.soporte.Fecha;
import es.pode.catalogacion.soporte.UtilidadesOrdenarCombos;
import es.pode.catalogadorWeb.presentacion.CatalogadorBPSession;
import es.pode.catalogadorWeb.presentacion.CatalogadorBSession;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoYPadreVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.validador.negocio.servicio.MDBasicosOblVO;
import es.pode.validador.negocio.servicio.ValidaVO;

/**
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController
 */
public class CatBasicPlusControllerImpl extends CatBasicPlusController {
 
	protected static Logger logger = Logger
			.getLogger(CatBasicPlusControllerImpl.class); 
	private static final String HTTP ="http://";
	private static final String BARRA ="/";
	private static final String SEPARADOR =":";

	// A list of user-friendly labels for MIME types.  We set this up at class
	// loading time and need no modifications to it thereafter.
	private static final Map<String, String> MIMEToLabelMap =
			initMIMEToFormatLabelMap();

	private static Map<String, String> initMIMEToFormatLabelMap() {
		Map fMap = new HashMap<String, String>();

		fMap.put("application/x-www-form-urlencoded"		 , "Application/X-www-form-urlencoded");
                fMap.put("application/exe"				 , "Application/exe");
		fMap.put("application/java"				 , "Application/Java");
		fMap.put("application/pdf"				 , "Text/PDF");
		fMap.put("application/postscript"		 , "Image/PS");
		fMap.put("application/rtf"				 , "Text/RTF");
		fMap.put("application/tar"				 , "Application/TAR");
		fMap.put("application/vnd.ms-excel"		 , "Spreadsheet/Excel");
		fMap.put("application/vnd.ms-powerpoint" , "Slideshow/Powerpoint");
		fMap.put("application/word"				 , "Text/Word");
		fMap.put("application/x-director"		 , "Multimedia/Director");
		fMap.put("application/x-shockwave-flash" , "Multimedia/Flash");
		fMap.put("application/zip"				 , "Application/ZIP");
		fMap.put("audio/aiff"					 , "Audio/AIFF");
		fMap.put("audio/basic"					 , "Audio/Sun");
		fMap.put("audio/midi"					 , "Audio/Midi");
		fMap.put("audio/mp3"					 , "Audio/MP3");
		fMap.put("audio/ogg"					 , "Audio/ogg");
		fMap.put("audio/vnd.rn-realaudio"		 , "Audio/Real");
		fMap.put("audio/wav"					 , "Audio/WAV");
		fMap.put("audio/x-ms-wma"				 , "Audio/WMA");
		fMap.put("image/bmp"					 , "Image/BMP");
		fMap.put("image/gif"					 , "Image/GIF");
		fMap.put("image/jpeg"					 , "Image/JPEG");
		fMap.put("image/png"					 , "Image/PNG");
		fMap.put("image/tiff"					 , "Image/TIFF");
		fMap.put("text/html"					 , "Text/HTML");
		fMap.put("text/plain"					 , "Text/Plain text");
		fMap.put("text/xml"						 , "Text/XML");
		fMap.put("video/avi"					 , "Video/AVI");
		fMap.put("video/mp4v-es"				 , "Video/MP4");
		fMap.put("video/mpeg"					 , "Video/MPEG");
		fMap.put("video/quicktime"				 , "Video/Quicktime");
		fMap.put("video/x-ms-wmv"				 , "Video/WMV");

		return fMap;
	}

	/**
	 * @see es.pode.catalogadorBasicPlus.presentacion.catalogador.CatBasicPlusController#cargarDatos(org.apache.struts.action.ActionMapping,
	 *      es.pode.catalogadorBasicPlus.presentacion.catalogador.CargarDatosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	
	public final void cargarDatos(
			ActionMapping mapping,
			es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
	
		//
		// Load the information from the ODE specified in the request into a
		// LOM object within the session
		//
		
		String idioma=((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		String ficheroProperties = "/catalogadorBasicPlus.properties";				
		String source = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		
		InputStream is = null;
		ResourceBundle datosResources = I18n.getInstance().getResource(
				"application-resources", 
				(Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
		
		try 
		{
			// Load the appropriate properties from the catalogadorBasicPlus.properties file
			is= this.getClass().getResourceAsStream(ficheroProperties);
			Properties prop = new Properties();
			prop.load(is);
			
			// Load the vocabulary terms for field values we wish to explicitly check for
			HashMap vocabTerms = getVocabularyTerms(idioma);
			
			// Setup the various backing lists required for this form; we do this by 
			// grabbing the terms specified
			// by the l_id array from the VocabulariosControladosService, and then
			// translating them from ISO form to their longer form
			int longVocabulario = 0;

			String[] l_id = { prop.getProperty("idioma"),
								prop.getProperty("aggregationLevel"),
								prop.getProperty("technicalOrCompositeType"),										
								prop.getProperty("tipoDeRecurso"),
								prop.getProperty("intendedEndUserRole"),
								prop.getProperty("relationKind"),
								prop.getProperty("technicalOrCompositeName"),
								prop.getProperty("format")
								};
			VocabularioVO[] vocabulario = this
					.getSrvVocabulariosControladosService().obtenerCombos(l_id,
							idioma);
			
			//vamos a ordenar vocabulario
			UtilidadesOrdenarCombos vocabularioOrdenado1 = new UtilidadesOrdenarCombos();
			VocabularioVO[] vocabularioOrdenado = vocabularioOrdenado1.ordenarVocabulariosVO(vocabulario);				
			
			longVocabulario = vocabularioOrdenado.length;
			for (int x = 0; x < longVocabulario; x++) {
				TerminoVO terminoVO = new TerminoVO();
				terminoVO.setIdiomaTermino("");
				terminoVO.setIdTermino("");
				terminoVO.setNomTermino("");
				switch (x) {
				case 0:						
					// For the language (idioma) list
					Collection idIdioma = new ArrayList();
					idIdioma.add(terminoVO);
					
					// modificamos las cadenas de idiomas
					TerminoVO[] terminos = vocabularioOrdenado[x].getTerminos();
					for (int li=0; li<terminos.length;li++){
						TerminoVO idAux = new TerminoVO();
						idAux=terminos[li];
						String textoIdioma= idAux.getNomTermino();
						String idiomasTra="";
						if(!textoIdioma.equals("x-none")){
							idiomasTra=I18n.getInstance().obtenerIdiomaTraducido(textoIdioma, idioma);
						}else{
							idiomasTra=datosResources.getString("x-none");
						}
						
						// Translate language code from short (ISO) format to long format
						idAux.setNomTermino(idiomasTra);
					}
					UtilidadesOrdenarCombos terminosOrd2 = new UtilidadesOrdenarCombos();
					TerminoVO[] terminosOrd = terminosOrd2.ordenarTerminosVO(terminos, idioma);						
					Collection id2 = Arrays
							.asList(terminosOrd);
					
					Iterator z = id2.iterator();
					while (z.hasNext()) {
						idIdioma.add(z.next());
					}
					
					// Set the language list
					form.setIdiomaBackingList(idIdioma, "idTermino", "nomTermino");
					break;
				
				case 1:
					// Aggregation Level list
					Collection idAggLevel = new ArrayList();
					idAggLevel.add(terminoVO);

					// Get the aggregation level terms
					TerminoVO[] terminosAggLevel = vocabularioOrdenado[x].getTerminos();
					
					// Sort them
					UtilidadesOrdenarCombos sortAggLevel = new UtilidadesOrdenarCombos();
					TerminoVO[] sortedAggLevelTerms = sortAggLevel.ordenarTerminosVO(terminosAggLevel, idioma);
					
					// Store as an ArrayList
					Collection idAggLevelList = Arrays
							.asList(sortedAggLevelTerms);
					
					Iterator zAggLevel = idAggLevelList.iterator();
					while (zAggLevel.hasNext()) {
						TerminoVO thisAggLevelTerm = (TerminoVO)zAggLevel.next();
						
						idAggLevel.add(thisAggLevelTerm);
					}
					
					//
					// HACK ALERT: Because the Aggregation Level form has separate labels
					// from values (and this is not supported in the VDEX vocabulary), we
					// forcibly override it here
					//
					
					zAggLevel = idAggLevelList.iterator();
					int c = 0;
					while (zAggLevel.hasNext()) {
						TerminoVO thisAggLevelTerm = (TerminoVO)zAggLevel.next();
						
						switch (c)
						{
						case 0:
							// Level 1
							thisAggLevelTerm.setNomTermino("Asset");
							break;
							
						case 1:
							// Level 2
							thisAggLevelTerm.setNomTermino("Lesson part");
							break;
							
						case 2:
							// Level 3
							thisAggLevelTerm.setNomTermino("Full lesson or topic");
							break;
							
						case 3:
							// Level 4
							thisAggLevelTerm.setNomTermino("Course");
							break;
						}
						
						c++;
					}

					
					// Set the aggregation level list
					form.setAggregationLevelBackingList(idAggLevel, "idTermino", "nomTermino");
					break;
					
				case 2:
					// Technical OrComposite type list
					Collection tTechOrCompositeType = new ArrayList();
					tTechOrCompositeType.add(terminoVO);
					Collection tTechOrCompositeType2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());
					
					Iterator contTechOrCompositeType = tTechOrCompositeType2.iterator();
					while (contTechOrCompositeType.hasNext()) {
						TerminoVO thisTechOrCompositeTypeTerm = (TerminoVO)contTechOrCompositeType.next();
						
						tTechOrCompositeType.add(thisTechOrCompositeTypeTerm);
					}
					
					// Set the technical OrComposite type backing list
					form.setTechnicalOrCompositeTypeBackingList(tTechOrCompositeType, "idTermino",
							"nomTermino");
					break;
					
				case 3:
					// Resource type list
					Collection tResourceType = new ArrayList();
					tResourceType.add(terminoVO);
					Collection tResourceType2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());
					
					Iterator contResourceType = tResourceType2.iterator();
					while (contResourceType.hasNext()) {
						TerminoVO thisTipoRecursoTerm = (TerminoVO)contResourceType.next();
						
						tResourceType.add(thisTipoRecursoTerm);
					}
					
					// Set the resource type backing list
					form.setTipoRecursoBackingList(tResourceType, "idTermino",
							"nomTermino");
					break;
					
				case 4:
					// Intended end user role list
					Collection tIntendedEndUserRole = new ArrayList();
					tIntendedEndUserRole.add(terminoVO);
					Collection tIntendedEndUserRole2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());
					
					Iterator contIntendedEndUserRoleType = tIntendedEndUserRole2.iterator();
					while (contIntendedEndUserRoleType.hasNext()) {
						TerminoVO thisIntendedEndUserRoleTerm = (TerminoVO)contIntendedEndUserRoleType.next();
								
						tIntendedEndUserRole.add(thisIntendedEndUserRoleTerm);
					}
					
					// Set the intended user role backing list
					form.setIntendedEndUserRoleBackingList(tIntendedEndUserRole, "idTermino",
							"nomTermino");
					break;
					
				case 5:
					// Relation kind list
					Collection tRelationKind = new ArrayList();
					tRelationKind.add(terminoVO);
					Collection tRelationKind2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());

					Iterator contRelationKindType = tRelationKind2.iterator();
					while (contRelationKindType.hasNext()) {
						TerminoVO thisRelationKindTerm = (TerminoVO)contRelationKindType.next();
								
						tRelationKind.add(thisRelationKindTerm);
					}
					
					// Set the relation kind backing list
					form.setRelationKindBackingList(tRelationKind, "idTermino",
							"nomTermino");
					break;
					
				case 6:
					// Technical OrComposite name list
					Collection tTechOrCompositeName = new ArrayList();
					tTechOrCompositeName.add(terminoVO);
					Collection tTechOrCompositeName2 = Arrays.asList(vocabularioOrdenado[x]
							.getTerminos());
					
					Iterator contTechOrCompositeName = tTechOrCompositeName2.iterator();
					while (contTechOrCompositeName.hasNext()) {
						TerminoVO thisTechOrCompositeNameTerm = (TerminoVO)contTechOrCompositeName.next();
						
						tTechOrCompositeName.add(thisTechOrCompositeNameTerm);
					}
					
					// Set the technical OrComposite type backing list
					form.setTechnicalOrCompositeNameBackingList(tTechOrCompositeName, "idTermino",
							"nomTermino");
					break;

				case 7:
					// Format list
					Collection tFormat = new ArrayList();
					tFormat.add(terminoVO);
					TerminoVO[] formatTVOs = vocabularioOrdenado[x].
							getTerminos();

					//
					// The default vocab term ordering uses name (a format MIME
					// type) as the sort key which makes the label list look
					// inconsistent; for instance, in the NWLG's label list,
					// "Text/PDF" corresponds to the MIME type "application/pdf"
					// and "Image/PS" to "application/postscript".
					//
					// Therefore, we use the term ID as the sort key for an
					// ascending order sort instead; the order in which the
					// format terms appear in the vocabulary is the order
					// of the backing list.
					//
					// In terms of overhead, this little merge sort is not even
					// close to the ugly sort in ordenarVocabulariosVO; which is
					// performed just above this loop.  Note that the frequency
					// of invocation in this method is the same for both sorts.
					//
					Arrays.sort(formatTVOs, new TerminoVOByIdComparator());

					for (TerminoVO ftvo : formatTVOs) {
						//
						// If we find a user-friendly label for this MIME type,
						// we use that instead.
						//
						String label = MIMEToLabelMap.get(ftvo.getNomTermino());
						if (label != null) {
							ftvo.setNomTermino(label);
						}

						tFormat.add(ftvo);
					}

					// Set the format backing list
					form.setFormatBackingList(tFormat, "idTermino",
							"nomTermino");
					break;
				}
			}			

			
			// Setup the advanced LOM
			CatalogadorBPSession os = this.getCatalogadorBPSession(request);
			LomAvanzadoVO lomAdvanced;
			
			
			if (os.getMBOSesion() == null) 
			{		
				// If the session object has not been set, load some defaults...			
				String usuario = LdapUserDetailsUtils.getUsuario();
				
				String identificador =request.getParameter("identificador");//"idLOM1";//
				//introducido nuevo parametro para vuelta al empaquetador
				String returnURL = request.getParameter("returnURL");
				//PortalEmpaquetador/Inicio/Inicio.do
				
				os.setIdioma(idioma);
				os.setIdentificador(identificador);
				os.setUsuario(usuario);
				//metemos en la sesion el parametro de vuelta al empaquetador
				os.setReturnURL(returnURL);

				
				// If we get here then we are entering the cataloguer for the first
				// time. Hence we need to make sure that the following sections of
				// the LOM exist:				
				//   - General
				//   - Technical
				//   - Educational
				//	 - Lifecycle
				//   - Relation

				// Grab the advanced LOM for this ODE
				lomAdvanced = this.getSrvCatalogacionAvanzadaService().obtenerLomAvanzado
								(identificador, usuario, idioma);
				
				if (lomAdvanced.getGeneral() == null)
					lomAdvanced.setGeneral(new AvGeneralVO());
				if (lomAdvanced.getTechnical() == null)
					lomAdvanced.setTechnical(new AvTechnicalVO());
				if (lomAdvanced.getEducational() == null)
					lomAdvanced.setEducational(new AvEducationalVO[] { new AvEducationalVO() });
				if (lomAdvanced.getRelaciones() == null)
					lomAdvanced.setRelaciones(new AvRelationVO[] { new AvRelationVO() });
				if (lomAdvanced.getLifeCycle() == null)
					lomAdvanced.setLifeCycle(new AvLifeCycleVO());
				if (lomAdvanced.getMetaMetadata() == null)
					lomAdvanced.setMetaMetadata(new AvMetametadataVO());

				// Store this LOM in the session
				this.getCatalogadorBPSession(request).setMBOSesion(lomAdvanced);
			}			
			else
			{
				// If we are already editing an object (i.e. it's in the session)
				// then we simply set the form values to be those set in the
				// LOM object within the session
				
				lomAdvanced = os.getMBOSesion();
			}

			// Set the title
			if (lomAdvanced.getGeneral().getTitulo() == null)
			{
				TituloVO tmpTituloVO = new TituloVO();
				lomAdvanced.getGeneral().setTitulo(tmpTituloVO);
				
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpTituloVO.setTextos(new LangStringVO[] { tmpLangStringVO });
			}

			
			// Set the language
			if (lomAdvanced.getGeneral().getIdiomas() == null ||
					lomAdvanced.getGeneral().getIdiomas().length == 0)
			{
				IdiomaVO[] tmpIdiomaVOArray = new IdiomaVO[1];
				IdiomaVO tmpIdiomaVO = new IdiomaVO();
				tmpIdiomaVO.setTexto("");
				
				tmpIdiomaVOArray[0] = tmpIdiomaVO;
				
				lomAdvanced.getGeneral().setIdiomas(tmpIdiomaVOArray);
			}
			
			
			// Set the description (we allow one field only in this cataloguer)
			if (lomAdvanced.getGeneral().getDescripciones() == null ||
					lomAdvanced.getGeneral().getDescripciones().length == 0)
			{
				DescripcionVO tmpDescriptionVO = new DescripcionVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpDescriptionVO.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				lomAdvanced.getGeneral().setDescripciones(new DescripcionVO[] { tmpDescriptionVO });
			}
			
			
			// Set the keyword (we allow one field in this cataloguer)
			if (lomAdvanced.getGeneral().getPalabrasClave() == null ||
					lomAdvanced.getGeneral().getPalabrasClave().length == 0)
			{
				PalabraClaveVO tmpKeywordVO = new PalabraClaveVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpKeywordVO.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				lomAdvanced.getGeneral().setPalabrasClave(new PalabraClaveVO[] { tmpKeywordVO });
			}			
			
			
			// Get a reference to the aggregation level object, creating one if it
			// doesn't already exist
			if (lomAdvanced.getGeneral().getNivelAgregacion() == null)
			{
				SourceValueVO tmpSourceValue = new SourceValueVO();
				tmpSourceValue.setSource(source);
				tmpSourceValue.setValor("");
			
				lomAdvanced.getGeneral().setNivelAgregacion(tmpSourceValue);
			}
			else
			{
				// Catch the case where the LOM has a general section, but no
				// initial value set
				if (lomAdvanced.getGeneral().getNivelAgregacion().getValor() == null)
					lomAdvanced.getGeneral().getNivelAgregacion().setValor("");
			}
			
			
			// We're about to set some fields based upon particular contributor values
			// so let's get the contribution list				
			if (lomAdvanced.getLifeCycle().getContribuciones() == null)
			{
				// Create an empty collection to keep things working
				lomAdvanced.getLifeCycle().setContribuciones(new ContribucionVO[] {});					
			}
						
			// Create a HashMap containing the contributions already within
			// the LOM keyed by contributor type
			HashMap contributorHashMap = new HashMap();
			
			for (int i = 0; i < lomAdvanced.getLifeCycle().getContribuciones().length; i++)
				contributorHashMap.put(
						lomAdvanced.getLifeCycle().getContribuciones()[i].getTipo().getValor(),
						lomAdvanced.getLifeCycle().getContribuciones()[i]);
			
			// Check to see if the author is present, and add it if not
			if (contributorHashMap.get((String)vocabTerms.get("lifecycleAuthor")) == null)
			{
				ContribucionVO thisContribution = new ContribucionVO();
				
				SourceValueVO tmpContributorSourceValueVO = new SourceValueVO();
				tmpContributorSourceValueVO.setSource(source);
				tmpContributorSourceValueVO.setValor((String)vocabTerms.get("lifecycleAuthor"));
				
				thisContribution.setTipo(tmpContributorSourceValueVO);
				thisContribution.setEntidades(new EntidadVO[] { new EntidadVO() });
				
				// Store back in the HashMap
				contributorHashMap.put((String)vocabTerms.get("lifecycleAuthor"), thisContribution);
			}

			// Check to see if the content provider is present, and add it if not
			if (contributorHashMap.get((String)vocabTerms.get("lifecycleContentProvider")) == null)
			{
				ContribucionVO thisContribution = new ContribucionVO();
				
				SourceValueVO tmpContributorSourceValueVO = new SourceValueVO();
				tmpContributorSourceValueVO.setSource(source);
				tmpContributorSourceValueVO.setValor((String)vocabTerms.get("lifecycleContentProvider"));
				
				thisContribution.setTipo(tmpContributorSourceValueVO);
				thisContribution.setEntidades(new EntidadVO[] { new EntidadVO() });
				
				// Store back in the HashMap
				contributorHashMap.put((String)vocabTerms.get("lifecycleContentProvider"), thisContribution);
			}
			
			// Convert the HashMap values back into an array and store in the LOM
			lomAdvanced.getLifeCycle().setContribuciones(
					(ContribucionVO[])contributorHashMap.values().toArray(new ContribucionVO[] {})
					);
			

			
			// Create a LifeCycle status object if it doesn't already exist...
			if (lomAdvanced.getLifeCycle().getEstado() == null)
			{
				SourceValueVO tmpState = new SourceValueVO();
				tmpState.setSource(source);
				tmpState.setValor((String)vocabTerms.get("lifeCycleStatusFinal"));
				
				lomAdvanced.getLifeCycle().setEstado(tmpState);
			}
			
			
			// Set the installation remarks
			if (lomAdvanced.getTechnical().getPautasInstalacion() == null)
			{
				PautasInstalacionVO tmpInstallationNotes = new PautasInstalacionVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpInstallationNotes.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				lomAdvanced.getTechnical().setPautasInstalacion(tmpInstallationNotes);
			}
			
	
			// Set the platform requirements
			if (lomAdvanced.getTechnical().getOtrosRequisitos() == null)
			{
				OtrosRequisitosVO tmpPlatformRequirements = new OtrosRequisitosVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpPlatformRequirements.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				lomAdvanced.getTechnical().setOtrosRequisitos(tmpPlatformRequirements);
			}
			
			
			// Set the duration fields
			// From Advanced: expresion regular P[yY][mM][dD][T[hH][nM][s[.s]S]]
			if (lomAdvanced.getTechnical().getDuracion() == null)
			{
				DuracionVO tmpDuration = new DuracionVO();
				
				DescripcionVO tmpDescription = new DescripcionVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpDescription.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				tmpDuration.setDescripcion(tmpDescription);
				
				lomAdvanced.getTechnical().setDuracion(tmpDuration);
			}

			
			// Create the requirements section with an single blank
			// OrRequirement if it doesn't exist in the LOM
			if (lomAdvanced.getTechnical().getRequisitos() == null ||
					lomAdvanced.getTechnical().getRequisitos().length == 0)
			{
				RequisitoVO tmpRequirement = new RequisitoVO();
				
				AgregadorORVO tmpOrRequirement = new AgregadorORVO();
				
				SourceValueVO tmpOrRequirementType = new SourceValueVO();
				tmpOrRequirementType.setSource(source);
				tmpOrRequirementType.setValor("");
				
				SourceValueVO tmpOrRequirementName = new SourceValueVO();
				tmpOrRequirementName.setSource(source);
				tmpOrRequirementName.setValor("");					
				
				tmpOrRequirement.setTipo(tmpOrRequirementType);
				tmpOrRequirement.setNombre(tmpOrRequirementName);
				
				tmpRequirement.setAgregadoresOR(new AgregadorORVO[] { tmpOrRequirement });
				
				lomAdvanced.getTechnical().setRequisitos(new RequisitoVO[] { tmpRequirement });
			}

			// Create the format section with a single blank format if it
			// doesn't exist in the LOM
			if (lomAdvanced.getTechnical().getFormatos() == null ||
					lomAdvanced.getTechnical().getFormatos().length == 0)
			{

				FormatoVO tmpFormat = new FormatoVO();
				tmpFormat.setTexto("");
				lomAdvanced.getTechnical().setFormatos(
						new FormatoVO[] { tmpFormat });
			}

			// Create the annotation section with a single blank note if it
			// doesn't exist in the LOM
			if (lomAdvanced.getAnotaciones() == null ||
					lomAdvanced.getAnotaciones().length == 0)
			{
				lomAdvanced.setAnotaciones(
						new AvAnnotationVO[] { createDefaultAnnotation() });
			}

			// Get a reference to the resource type object, creating one if it
			// doesn't already exist
			if (lomAdvanced.getEducational()[0].getTiposrecursoedu() == null ||
					lomAdvanced.getEducational()[0].getTiposrecursoedu().length == 0)
			{
				SourceValueVO tmpSourceValue = new SourceValueVO();
				tmpSourceValue.setSource(source);
				tmpSourceValue.setValor("");
			
				lomAdvanced.getEducational()[0].setTiposrecursoedu(new SourceValueVO[] { tmpSourceValue });
			}
			else
			{
				// Catch the case where the LOM has an educational section, but no
				// initial value set
				if (lomAdvanced.getEducational()[0].getTiposrecursoedu()[0].getValor() == null)
					lomAdvanced.getEducational()[0].getTiposrecursoedu()[0].setValor("");
			}
			
			
			// Get a reference to the intended end user role object, creating one if it
			// doesn't already exist
			if (lomAdvanced.getEducational()[0].getDestinatarios() == null ||
					lomAdvanced.getEducational()[0].getDestinatarios().length == 0)
			{
				SourceValueVO tmpSourceValue = new SourceValueVO();
				tmpSourceValue.setSource(source);
				tmpSourceValue.setValor("");
			
				lomAdvanced.getEducational()[0].setDestinatarios(new SourceValueVO[] { tmpSourceValue });
			}
			else
			{
				// Catch the case where the LOM has an educational section, but no
				// initial value set
				if (lomAdvanced.getEducational()[0].getDestinatarios()[0].getValor() == null)
					lomAdvanced.getEducational()[0].getDestinatarios()[0].setValor("");
			}
			
			
			// Set the typical learning time fields
			if (lomAdvanced.getEducational()[0].getTiempoAprendizaje() == null)
			{
				DuracionVO tmpDuration = new DuracionVO();
				
				DescripcionVO tmpDescription = new DescripcionVO();
				LangStringVO tmpLangStringVO = new LangStringVO();
				tmpLangStringVO.setIdioma("en");
				tmpLangStringVO.setTexto("");
				
				tmpDescription.setTextos(new LangStringVO[] { tmpLangStringVO });
				
				tmpDuration.setDescripcion(tmpDescription);
				
				lomAdvanced.getEducational()[0].setTiempoAprendizaje(tmpDuration);
			}				

			
			//
			// Load the curriculum trees from the LOM
			//
			
			// Make sure we have a classification object, and that we do not
			// overwrite the in-session curricular tree array when we reach here
			// from the curriculum tree browser.
			if (os.getCurriculumTreesArray() == null &&
					lomAdvanced.getClasificaciones() != null &&
					lomAdvanced.getClasificaciones().length > 0)
			{
				// And a taxonPath object
				if (lomAdvanced.getClasificaciones()[0].getRutasTaxonomicas() != null &&
						lomAdvanced.getClasificaciones()[0].getRutasTaxonomicas().length > 0)
					
				{
					// Create an array of ArbolCurricularVO objects containing
					// the information from the LOM
					ArbolCurricularVO[] curriculumTreeArray = new ArbolCurricularVO[lomAdvanced.getClasificaciones()[0].getRutasTaxonomicas().length];
					
					int treeId = 0;
					for (int i = 0; i < lomAdvanced.getClasificaciones()[0].getRutasTaxonomicas().length; i++)
					{
						RutaTaxonomicaVO thisTaxonPath = lomAdvanced.getClasificaciones()[0].getRutasTaxonomicas()[i];
						
						curriculumTreeArray[i] = new ArbolCurricularVO();
						
						// Convert taxons array from CBTaxonVO to TaxonVO							
						CBTaxonVO[] curriculumTaxonVO = new CBTaxonVO[thisTaxonPath.getTaxones().length];
						int n = thisTaxonPath.getTaxones().length;
						for (int j = 0; j < n; j++)
						{
							TaxonVO thisTaxon = thisTaxonPath.getTaxones()[(n-1)-j];
							
							curriculumTaxonVO[j] = new CBTaxonVO();								
							curriculumTaxonVO[j].setId(thisTaxon.getId().getTexto());
							curriculumTaxonVO[j].setValorTax(thisTaxon.getEntry().getTextos()[0].getTexto());
						}
						
						// Store in the curriculum tree array. Note the tree identifier is just set
						// as an dummy 0.X value (where X increments by 1) for use as
						// a unique identifier for deleting
						curriculumTreeArray[i].setIdArbol("0." + treeId);
						curriculumTreeArray[i].setTaxones(curriculumTaxonVO);
						
						treeId++;
					}
					
					// Finally store the trees in the session
					os.setCurriculumTreesArray(curriculumTreeArray);
				}
			}
			

			
			// Get a reference to the relation kind object, creating one if it
			// doesn't already exist. Note that this field is optional.
			if (lomAdvanced.getRelaciones().length == 0)
				lomAdvanced.setRelaciones(new AvRelationVO[] { new AvRelationVO() });
				
			if (lomAdvanced.getRelaciones()[0].getTipo() == null)
			{
				SourceValueVO tmpSourceValue = new SourceValueVO();
				tmpSourceValue.setSource(source);
				tmpSourceValue.setValor("");
			
				lomAdvanced.getRelaciones()[0].setTipo(tmpSourceValue);
			}
			else
			{
				// Catch the case where the LOM has an relation section, but no
				// initial value set
				if (lomAdvanced.getRelaciones()[0].getTipo().getValor() == null)
					lomAdvanced.getRelaciones()[0].getTipo().setValor("");
			}

			
			// Set the relation kind description
			if (lomAdvanced.getRelaciones()[0].getRecurso() == null)
			{
				RecursoVO tmpResource = new RecursoVO();
				DescripcionVO tmpDescription = new DescripcionVO();
				LangStringVO tmpLangString = new LangStringVO();
				tmpLangString.setIdioma("en");
				tmpLangString.setTexto("");
										
				tmpDescription.setTextos(new LangStringVO[] { tmpLangString });
				
				IdentificadorVO tmpIdentifier = new IdentificadorVO();
				tmpIdentifier.setCatalogo("");
				tmpIdentifier.setEntrada("");
				
				tmpResource.setIdentificador(tmpIdentifier);					
				tmpResource.setDescripciones(new DescripcionVO[] { tmpDescription });
				
				lomAdvanced.getRelaciones()[0].setRecurso(tmpResource);
			}
						
			// Force the list of items in the typicalLearningTimeFull backing list
			form.setTypicalLearningTimeFullLabelList(new String[] {
				"",
				"Less than 10 mins",
				"10 - 30 mins",
				"30 mins - 1 hour",
				"1 - 8 hours",
				"More than 8 hours"
				});
			
			form.setTypicalLearningTimeFullValueList(new String[] {
				"",
				"00-00-00-00-10-00",
				"00-00-00-00-30-00",
				"00-00-00-01-00-00",
				"00-00-00-08-00-00",
				"00-00-07-00-00-00"
			});

			//
			// Now load all of the form values from the LOM
			//						
			
			// Set the title
			form.setTitulo(
					lomAdvanced.getGeneral().getTitulo().getTextos()[0].getTexto()
					);
			
			// Set the description
			form.setDescription(
					lomAdvanced.getGeneral().getDescripciones()[0].getTextos()[0].getTexto()
					);

			// Set the keyword
			form.setKeyword(
					lomAdvanced.getGeneral().getPalabrasClave()[0].getTextos()[0].getTexto()
					);		
			
			// Set the author/content provider lifecycle contributions
			ContribucionVO[] contributions = lomAdvanced.getLifeCycle().getContribuciones(); 

			for (int i = 0; i < contributions.length; i++)
			{
				ContribucionVO thisContribution = contributions[i];
			
				// Check for author contributor type
				if (thisContribution.getTipo().getValor().equals(vocabTerms.get("lifecycleAuthor")))
				{
					logger.debug("Located the author lifecycle entity");
					
					// Grab the vCard string
					String vCardString = thisContribution.getEntidades()[0].getTexto();
					
					// Parse it into a vCard object
					CataloguerVCard cvc = new CataloguerVCard(vCardString);
					
					if (cvc != null)
					{
						// Set the LifeCycle -> Author field
						if (cvc.getFullName() != null)
							form.setAuthorFullName(cvc.getFullName());
						else
							form.setAuthorFullName("");
						
						// Set the LifeCycle -> Organisation field
						if (cvc.getOrganisation() != null)
							form.setAuthorOrganisation(cvc.getOrganisation());
						else
							form.setAuthorOrganisation("");
					}
				}
				
				// Check for content provider contributor type
				if (thisContribution.getTipo().getValor().equals(vocabTerms.get("lifecycleContentProvider")))
				{
					logger.debug("Located the provider lifecycle entity");
					
					// Grab the vCard string
					String vCardString = thisContribution.getEntidades()[0].getTexto();
					
					// Parse it into a vCard object
					CataloguerVCard cvc = new CataloguerVCard(vCardString);
					
					if (cvc != null)
					{
						// Set the LifeCycle -> Contributor field
						if (cvc.getFullName() != null)
							form.setProviderFullName(cvc.getFullName());
						else
							form.setProviderFullName("");
					}
				}
			}
			
			// Set the installation remarks
			form.setInstallationNotes(
					lomAdvanced.getTechnical().getPautasInstalacion().getTextos()[0].getTexto()
					);
			
			// Set the platform requirements
			form.setPlatformRequirements(
					lomAdvanced.getTechnical().getOtrosRequisitos().getTextos()[0].getTexto()
					);

			// Set the notes
			form.setNotes(
					lomAdvanced.getAnotaciones()[0].getDescripcion().getTextos()[0].getTexto()
					);
			
			// Set the duration fields: remember technical duration is optional...
			if (lomAdvanced.getTechnical().getDuracion() != null)
			{
				CataloguerDuration d1 = new CataloguerDuration(lomAdvanced.getTechnical().getDuracion().getDuracion());
				
				form.setDurationYears(d1.getYears());
				form.setDurationMonths(d1.getMonths());
				form.setDurationDays(d1.getDays());
				form.setDurationHours(d1.getHours());
				form.setDurationMinutes(d1.getMinutes());
				form.setDurationSeconds(d1.getSeconds());
			}
				
			// Set the typical learning time fields
			CataloguerDuration d2 = new CataloguerDuration(lomAdvanced.getEducational()[0].getTiempoAprendizaje().getDuracion());
			
			// We currently use a string of the form YY-MM-DD-HH-MM-SS to represent
			// the typical time within the form. Set let's generate this and then
			// set it.
			StringBuilder typicalLearningTimeFull = new StringBuilder();
			
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getYears()) + "-");
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getMonths()) + "-");
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getDays()) + "-");
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getHours()) + "-");
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getMinutes()) + "-");
			typicalLearningTimeFull.append(zeroFromEmpty(d2.getSeconds()));

			form.setTypicalLearningTimeFull(typicalLearningTimeFull.toString());
			
			// Set the relation kind entry (optional)
			if (lomAdvanced.getRelaciones().length > 0)
			{				
				form.setRelationKindEntry(
						lomAdvanced.getRelaciones()[0].getRecurso().getIdentificador().getEntrada()
						);
				
				// Set the relation kind description
				form.setRelationKindDescription(
						lomAdvanced.getRelaciones()[0].getRecurso().getDescripciones()[0].getTextos()[0].getTexto()
						);
			}
				
			//
			// For the LOM fields that are based upon backing lists (and so are
			// referenced by termIds rather than values), obtain the values for
			// the specified termIds from the vocabulary service so we can set
			// the form fields
			//
			
			TerminoYPadreVO[] terminoypadrear = new TerminoYPadreVO[longVocabulario];

			for (int i = 0; i < longVocabulario; i++) {
				TerminoYPadreVO terminoypadreVO = new TerminoYPadreVO();
				terminoypadreVO.setIdiomaTermino("en");
				terminoypadreVO.setIdVocabulario(l_id[i]);
				terminoypadreVO.setIdTermino("");
				
				switch (i) {
				case 0:
					// For the language (idioma) term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getGeneral().getIdiomas()[0].getTexto()
							);
					break;

				case 1:
					// Aggregation Level term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getGeneral().getNivelAgregacion().getValor()
							);					
					break;
					
				case 2:
					// Technical OrComposite type term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getTechnical().getRequisitos()[0].getAgregadoresOR()[0].getTipo().getValor()
							);
					break;
					
				case 3:
					// Resource type term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getEducational()[0].getTiposrecursoedu()[0].getValor()
							);
					break;
					
				case 4:
					// Intended end user role term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getEducational()[0].getDestinatarios()[0].getValor()
							);
					break;
					
				case 5:
					// Relation kind term
					terminoypadreVO.setNomTermino(
						lomAdvanced.getRelaciones()[0].getTipo().getValor()
						);						
					break;

				case 6:
					// Technical OrComposite name term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getTechnical().getRequisitos()[0].getAgregadoresOR()[0].getNombre().getValor()
							);
					break;

				case 7:
					// Format term
					terminoypadreVO.setNomTermino(
							lomAdvanced.getTechnical().getFormatos()[0].getTexto()
							);
					break;
				}

				terminoypadrear[i] = terminoypadreVO;
			}
			
			// Lookup the terms from the termIds
			TerminoYPadreVO[] terminoYPadreVuelta = this.getSrvVocabulariosControladosService()
					.obtenerIdTermino(terminoypadrear);
			
			String idi;
			
			// Set language term
			idi = terminoYPadreVuelta[0].getIdTermino();
			if (idi != null)
				form.setIdioma(idi);
			
			// Set the aggregation level term
			idi = terminoYPadreVuelta[1].getIdTermino();
			if (idi != null)
				form.setAggregationLevel(idi);
			
			// Set the technical OrComposite type term
			idi = terminoYPadreVuelta[2].getIdTermino();
			if (idi != null)
				form.setTechnicalOrCompositeType(idi);
			
			// Set the resource type term
			idi = terminoYPadreVuelta[3].getIdTermino();
			if (idi != null)
				form.setTipoRecurso(idi);
			
			// Set the intended end user role term
			idi = terminoYPadreVuelta[4].getIdTermino();
			if (idi != null)
				form.setIntendedEndUserRole(idi);
			
			// Set the relation kind term
			idi = terminoYPadreVuelta[5].getIdTermino();
			if (idi != null)
				form.setRelationKind(idi);

			// Set the technical OrComposite name term
			idi = terminoYPadreVuelta[6].getIdTermino();
			if (idi != null)
				form.setTechnicalOrCompositeName(idi);

			// Set the format term
			idi = terminoYPadreVuelta[7].getIdTermino();
			if (idi != null)
				form.setFormat(idi);
			
			//
			// Finally set the curriculum trees form variable so we can
			// display them
			//
			
			form.setCurriculumTreesAsArray(os.getCurriculumTreesArray());
			
			
		} catch (Exception e) {
			logger.error("could not open catalogadorBasicPlus.properties file");
			return;
		}
					
		logger.debug("#### Finished setting LomAdvanced");
		
	}

	public void cargarDatosGuardar(ActionMapping mapping,
			CargarDatosGuardarForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		//
		// Save the information posted from the form back into the session
		// object, ready for use later
		//

		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		String idioma = locale.getLanguage();
		CatalogadorBPSession os = this.getCatalogadorBPSession(request);	

		// Rebuild the LOM with the new form information
		LomAvanzadoVO lomAdvanced = os.getMBOSesion();
		
		// Parse the form fields and update the LOM
		updateLOMFromForm(form, lomAdvanced, idioma);
		
		// Store the result back into the session
		os.setMBOSesion(lomAdvanced);
		
		String returnURL = this.getCatalogadorBPSession(request).getReturnURL();
		os.setReturnURL(returnURL);
		this.setCatalogadorBPSession(request, os);
		if( logger.isDebugEnabled() ) {
            logger.debug("Insertamos los valores del formulario en el objeto de sesion" );
		}
		
	}

	/**
	 * @see es.pode.catalogadorBasicPlus.presentacion.catalogador.CatBasicPlusController#guardarMetadatos(org.apache.struts.action.ActionMapping,
	 *      es.pode.catalogadorBasicPlus.presentacion.catalogador.GuardarMetadatosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void guardarMetadatos(
			ActionMapping mapping,
			es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarMetadatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//
		// This Action is called once the user agrees to save the data. Note that
		// we don't need to update the LomAvanzado object as we did that earlier
		// and stored it in the session - for some reason the original Basic 
		// Cataloguer repeats most of the earlier code again here?!
		//
		
		String usuario = LdapUserDetailsUtils.getUsuario(); 
		String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		String identificador;

		if (this.getCatalogadorBPSession(request) == null) {
			identificador = request.getParameter("identificador");
		} else {
			identificador = this.getCatalogadorBPSession(request)
					.getIdentificador();
		}
		
		CatalogadorBPSession os = this.getCatalogadorBPSession(request);
		LomAvanzadoVO lomAdvanced = os.getMBOSesion();
		
		//
		// The curriculum trees are stored in the session, so extract
		// each term and add it to the LOM
		//
		
		if (os.getCurriculumTreesArray() != null)
			updateLOMFromCurriculumTreesArray(os.getCurriculumTreesArray(), lomAdvanced, idioma);

		// Okay... so this next bit of code looks as if it should just
		// generate a LomVO from a LomAvanzado, but it also seems to
		// set up a couple of variables in the session required for
		// any changes to be saved??!?
		this.getSrvCatalogacionAvanzadaService().generarMetadatos(
				identificador, usuario, lomAdvanced, idioma);
		
		// Store in the session
		logger.debug("FOO!");
		
	}

	public void cargarDatosSesion(ActionMapping mapping,
			CargarDatosSesionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// Update the LOM with any form variables in preparation before
		// forwarding to the taxonomy curriculum tree
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		String idioma = locale.getLanguage();
		
		CatalogadorBPSession os = this.getCatalogadorBPSession(request);
		LomAvanzadoVO lomAdvanced = os.getMBOSesion();
		
		updateLOMFromForm(form, lomAdvanced, idioma);
	}

	public boolean sonValidosMDBO(ActionMapping mapping,
			SonValidosMDBOForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// All of the hard work has been done by this point (in validarMetadatos), so 
		// we can simply return the isValid form variable
		
		return form.getIsValid();
	}

	public void validarMetadatos(ActionMapping mapping,
			ValidarMetadatosForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		// Validate the data in the LOM according the custom rules specified
		// by NWLG for the BasicPlus cataloguer. In order to make this easier
		// to follow, the code from the Advanced Cataloguer has been borrowed
		// as a starting point, split into a different method for each section.
		//
		// Each section method returns either true or false depending upon
		// whether or not the section passed validation.
		
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		String idioma = locale.getLanguage();
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", locale);

		CatalogadorBPSession os = this.getCatalogadorBPSession(request);	
		Collection errorMessages = new ArrayList();
		LomAvanzadoVO lomAdvanced = os.getMBOSesion();
		
		// Apply any form changes
		updateLOMFromForm(form, lomAdvanced, idioma);
		
		// Apply any curriculum tree changes
		updateLOMFromCurriculumTreesArray(os.getCurriculumTreesArray(), lomAdvanced, idioma);
		
		if (
				// General section: currently the only mandatory LOM-NDRB fields
				// are in this section
				validateBasicPlusGeneral(lomAdvanced, locale, errorMessages)
			)
		{
				// Assume we pass all tests, set the isValid variable to true
				// for the controller
				form.setIsValid(true);
				
				// Set the default validation successful message; if any of the
				// above validations returned false, we would have at least one
				// message
				errorMessages.add(datosResources.getString("CAV.0.0"));
		}

		// Store the resulting error messages in the form for retrieval later
		form.setMensajesError(errorMessages);
	}

	
	public void eliminarArbol(ActionMapping mapping, EliminarArbolForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		//
		// Remove the curriculum trees Ids from the LOM as specified by
		// the user
		//
		
		String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		CatalogadorBPSession os = this.getCatalogadorBPSession(request);	
		LomAvanzadoVO lomAdvanced = os.getMBOSesion();
		
		// Get the array of Ids to delete
		String[] treeIds =(String[]) request.getParameterValues("idArbol");
		
		// Search through the curriculum trees array, removing any entries that are
		// specified in the treeIds array. We use an ArrayList as we aren't 100% sure
		// of the final array length.
		ArrayList newCurriculumTreesArrayList = new ArrayList();
		
		for (int i = 0; i < os.getCurriculumTreesArray().length; i++)
		{
			ArbolCurricularVO thisCurriculumTree = os.getCurriculumTreesArray()[i];
			
			boolean toBeDeleted = false;
			for (int j = 0; j < treeIds.length; j++)
			{
				if (thisCurriculumTree.getIdArbol().equals(treeIds[j]))
					toBeDeleted = true;
			}

			// If we're not in the list of specified Ids to delete, copy
			// to the new ArrayList
			if (!toBeDeleted)
				newCurriculumTreesArrayList.add(thisCurriculumTree);
		}
		
		// Now store back in the session
		os.setCurriculumTreesArray((ArbolCurricularVO[])newCurriculumTreesArrayList.toArray(
				new ArbolCurricularVO[newCurriculumTreesArrayList.size()]));
		
		// And finally update the LOM
		updateLOMFromCurriculumTreesArray(os.getCurriculumTreesArray(), lomAdvanced, idioma);
		
	}

	public void volverAEmpaquetador(ActionMapping mapping, VolverAEmpaquetadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Recogemos el parametro para ir a PortalEmpaquetador
		String returnUrl = this.getCatalogadorBPSession(request).getReturnURL();
//		borramos datos de sesion
		request.getSession().removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
		
		String url = HTTP + LdapUserDetailsUtils.getHost();
		if(returnUrl==null){
			returnUrl = BARRA + request.getSession().getServletContext().getInitParameter("url_portada");
		}
		if(LdapUserDetailsUtils.getSubdominio()!=null && 
		   LdapUserDetailsUtils.getSubdominio().length() != 0 && 
		   !returnUrl.startsWith(LdapUserDetailsUtils.getSubdominio()))
		{
			returnUrl = LdapUserDetailsUtils.getSubdominio() + returnUrl;
		}
		url= url + returnUrl;
		response.sendRedirect(url);
	}

	public void realizarSubmit(ActionMapping mapping, RealizarSubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accion = form.getAccionSubmit();
		
	}

	public String recogeAccion(ActionMapping mapping, RecogeAccionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Recogemos la accion a realizar
		String accion= form.getAccionSubmit();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasicPlus.Aceptar").equals(accion)) {
			resAction = "Guardar";
		} else if (datosResources.getString("catalogadorBasicPlus.Validar").equals(accion)) {
			resAction = "Validar";
		} else if (datosResources.getString("catalogadorBasicPlus.ArbolCurricular").equals(accion)) {
			resAction = "Arbol Curricular";
		} else if( datosResources.getString("catalogadorBasicPlus.Eliminar").equals(accion)) {
			resAction = "Eliminar";
		}else if( datosResources.getString("catalogadorBasicPlus.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		}else if( accion==null || datosResources.getString("catalogadorBasicPlus.Exportar").equals(accion) ) {
			resAction = "Exportar";
		}
		
		return resAction;
	}

	public void exportarLomes(
			ActionMapping mapping, 
			ExportarLomesForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		//
		// This method is called after the LOM has been validated and exports
		// the LOM file content directly to the browser
		//

		CatalogadorBPSession os = this.getCatalogadorBPSession(request);
        final int BUFFER_SIZE = 2048;
        
    	DataHandler dh=null;
    	try{
    		
    		// Remember: grab the LOM from the disk so that we don't have any of the temporary fields
    		// that may have been added to accept user input.
    		LomAvanzadoVO lomAdvanced = this.getSrvCatalogacionAvanzadaService().obtenerLomAvanzado
				(os.getIdentificador(), os.getUsuario(), os.getIdioma());
    		
    		dh = this.getSrvCatalogacionAvanzadaService().exportarLomes(
    				os.getIdentificador(), os.getUsuario(), lomAdvanced, os.getIdioma());
    		
    	}catch (Exception e) {
    		logger.error(e);
    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
		}
    	    	
    	if(dh==null)
    	{
			logger.error("Fichero  vacio. Abortamos descarga.");
    		throw new ValidatorException("{catalogadorAvanzado.exportar.error.fichero}");
    	}
    	
//    	 asignamos el titulo del fichero que vamos a exportar
    	

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

	public void validarExportar(
			ActionMapping mapping, 
			ValidarExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		//
		// This method is called to validate the LOM before it is exported.
		// Since we are working on the last saved LOM, we perform the
		// validation without updating from the form, and set the IsValid
		// variable. Note that this is actually the same as validarMetadatos,
		// but without the form update parts.
		//
		
		Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", locale);
		
		CatalogadorBPSession os = this.getCatalogadorBPSession(request);
		Collection errorMessages = new ArrayList();
		LomAvanzadoVO lomAdvanced = this.getSrvCatalogacionAvanzadaService().obtenerLomAvanzado
										(os.getIdentificador(), os.getUsuario(), os.getIdioma());
		
		if (
				// General section: currently the only mandatory LOM-NDRB fields
				// are in this section
				validateBasicPlusGeneral(lomAdvanced, locale, errorMessages)
			)
		{
				// Assume we pass all tests, set the isValid variable to true
				// for the controller
				form.setIsValid(true);
				
				// Set the default validation successful message; if any of the
				// above validations returned false, we would have at least one
				// message
				errorMessages.add(datosResources.getString("CAV.0.0"));
		}

		// Store the resulting error messages in the form for retrieval later
		form.setMensajesError(errorMessages);
	}

	public boolean sonValidosExportar(
			ActionMapping mapping, 
			SonValidosExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		//
		// This is called once we have validated the form ready for export.
		// Normally you would return a set of error messages to the user
		// here, and set a form variable to indicate the validation passed.
		// Fortunately the validation routines already do this for us, so all
		// we have to do is return the precalculated value :D
		
		return form.getIsValid();
	}


	public String submitAdvertenciaExportar(
			ActionMapping mapping, 
			SubmitAdvertenciaExportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String accion= form.getAccion();
		String resAction = "";
		
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasicPlus.exportar.advertencia.exportar").equals(accion)) {
			resAction = "Exportar";
		} else if (datosResources.getString("catalogadorBasicPlus.exportar.advertencia.volver").equals(accion)) {
			resAction = "Volver";
		}else{
			resAction = "Volver";
		}
		
		return resAction;

	}


	public boolean actualizados(
			ActionMapping mapping, 
			ActualizadosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		// Yes, I know, this callback is so stupid as to be beyond comprehension...
		return form.isActualizados();
	}

	public void chequearDatos(
			ActionMapping mapping, 
			ChequearDatosForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		//
		// This method is called when the user has clicked on the LOM "Export"
		// button. It should determine whether any form fields have been set, and
		// if so, direct the user to a warning page to point out that only the
		// last saved LOM will be exported.
		//
		
		CatalogadorBasicPlusFormImpl entireForm = (CatalogadorBasicPlusFormImpl)form;
		
		// If the form is not empty, set the actualizados flag to false 
		// so that we emit a warning
		if (!lomesVacio(entireForm))
			form.setActualizados(true);
		else
			form.setActualizados(false);
	}

	
	private boolean lomesVacio(CatalogadorBasicPlusFormImpl form)
	throws Exception
	{
		// Return true or false depending upon whether any fields have been set
		// in the form
		boolean result = true;
		
		// Only check the compulsory fields
		// TODO: this may need to be revised during use
		if (
			(form.getAggregationLevel() != null && form.getAggregationLevel().length() != 0) ||
			(form.getAuthorFullName() != null && form.getAuthorFullName().length() != 0) ||
			(form.getDescription() != null && form.getDescription().length() != 0) ||
			(form.getProviderFullName() != null && form.getProviderFullName().length() != 0)
			)
			result = false;
		
		return result;
	}

	
	
	public String comprobarLomesVacio(
			ActionMapping mapping, 
			ComprobarLomesVacioForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String resultado="Vacio";
		
		return resultado;
		
	}

	public void subirFichero(
			ActionMapping mapping, 
			SubirFicheroForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		System.out.println("SUBMIT FORM!");
	}

	public String submitAdvertenciaImportar(
			ActionMapping mapping, 
			SubmitAdvertenciaImportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		
		String accion= form.getAccion();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasicPlus.importar.advertencia.aceptar").equals(accion)) {
			resAction = "Aceptar";
		} else if (datosResources.getString("catalogadorBasicPlus.importar.advertencia.cancelar").equals(accion)) {
			resAction = "Cancelar";
		}
		
		return resAction;

	}

	public String submitImportar(
			ActionMapping mapping, 
			SubmitImportarForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) 
	throws Exception 
	{
		String resAction = "";
		
		return resAction;

	}

	public String guardarDatos(ActionMapping mapping, GuardarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		Recogemos la accion a realizar
		String accion= form.getAccion();
		String resAction = "";
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));

		if (datosResources.getString("catalogadorBasicPlus.AceptarGuardar").equals(accion)) {
			resAction = "AceptarGuardar";
		} else if (datosResources.getString("catalogadorBasicPlus.NoGuardar").equals(accion)) {
			resAction = "NoGuardar";
		} else if( datosResources.getString("catalogadorBasicPlus.Cancelar").equals(accion)) {
			resAction = "Cancelar";
		}
		
		return resAction;
	}
	
	
	//
	// deepCopy method taken from JavaWorld's Java tips section:
	//     http://www.javaworld.com/javaworld/javatips/jw-javatip76.html
	//
	// Since the LomAvanzadoVO as generated from the WSDL implements Serializable
	// but not the clone() method, in order to make a copy we serialize/deserialize
	// into a new Object
	
	private Object deepCopy(Object oldObj) throws Exception
	{
	      ObjectOutputStream oos = null;
	      ObjectInputStream ois = null;
	      try
	      {
	         ByteArrayOutputStream bos = 
	               new ByteArrayOutputStream(); // A
	         oos = new ObjectOutputStream(bos); // B
	         // serialize and pass the object
	         oos.writeObject(oldObj);   // C
	         oos.flush();               // D
	         ByteArrayInputStream bin = 
	               new ByteArrayInputStream(bos.toByteArray()); // E
	         ois = new ObjectInputStream(bin);                  // F
	         // return the new object
	         return ois.readObject(); // G
	      }
	      catch(Exception e)
	      {
	         System.out.println("Exception in ObjectCloner = " + e);
	         throw(e);
	      }
	      finally
	      {
	         oos.close();
	         ois.close();
	      }
	}

	
	//
	// When setting defaults for some fields, we need to know the name of the
	// particular field values, e.g. when searching for "content provider" or 
	// "author".
	//
	// This function performs a vocabulary lookup for the terms we want and
	// then stores the results in a HashMap for retrieval later
	//
	
	private HashMap getVocabularyTerms(String idioma)
	{
		
		HashMap terms = new HashMap();
		
		String ficheroProperties = "/catalogadorBasicPlus.properties";
		InputStream is = this.getClass().getResourceAsStream(ficheroProperties);
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e)
		{
			logger.error("could not open properties file: " + ficheroProperties);
			return null;
		}
			
		String[] vocabInputTerms = new String[] { 
				prop.getProperty("roleLifeCycleVocabulary"),
				prop.getProperty("roleMetadataVocabulary"),
				prop.getProperty("copyrightRightsVocabulary"),
				prop.getProperty("costRightsVocabulary"),
				prop.getProperty("statusLifeCycleVocabulary"),
				prop.getProperty("copyrightRightsDescriptionVocabulary")
				};
		
		// Call the service to do the work
		VocabularioVO[] vocabTerms;
		
		try {
			vocabTerms = this.getSrvVocabulariosControladosService()
				.obtenerCombos(vocabInputTerms, idioma);
		} catch (Exception e)
		{
			logger.error("error calling SrvVocabulariosControladosService");
			return null;
		}
		
		// Now extract the terms we want:		
		// - LifeCycle Author role
		// - LifeCycle Content Provider role
		// - Metadata Creator Role
		// - Rights License
		// - Rights Cost
		
		for (int i = 0; i < vocabTerms.length; i++)
		{
			// Lifecycle Role terms
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("roleLifeCycleVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// Author
					if (thisTerm.getIdTermino().equals(prop.getProperty("roleLifeCycleAuthor")))
						terms.put("lifecycleAuthor", (String)thisTerm.getNomTermino());
					
					// Content provider
					if (thisTerm.getIdTermino().equals(prop.getProperty("roleLifeCycleContentProvider")))
						terms.put("lifecycleContentProvider", (String)thisTerm.getNomTermino());
				}
			}
			
			// Metadata Role terms
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("roleMetadataVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// Creator
					if (thisTerm.getIdTermino().equals(prop.getProperty("roleMetadataCreator")))
						terms.put("metadataCreator", (String)thisTerm.getNomTermino());
				}
			}
			
			// Rights has copyright term
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("copyrightRightsVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// By default, yes, we do have copyright
					if (thisTerm.getIdTermino().equals(prop.getProperty("copyrightRightsHasCopyright")))
						terms.put("rightsHasCopyright", (String)thisTerm.getNomTermino());
				}
			}
			
			// Rights description (license)
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("copyrightRightsDescriptionVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// Creative commons attribution, non-commercial, share-alike
					if (thisTerm.getIdTermino().equals(prop.getProperty("copyrightRightsDefaultLicenseDescription")))
						terms.put("rightsDefaultLicense", (String)thisTerm.getNomTermino());
				}
			}
			
			// Rights cost terms
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("costRightsVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// Creative commons attribution, non-commercial, share-alike
					if (thisTerm.getIdTermino().equals(prop.getProperty("costRightsNoCost")))
						terms.put("rightsNoCost", (String)thisTerm.getNomTermino());
				}
			}

			// Lifecycle status terms
			if (vocabTerms[i].getIdVocabulario().equals(prop.getProperty("statusLifeCycleVocabulary")))
			{
				for (int j = 0; j < vocabTerms[i].getTerminos().length; j++)
				{
					TerminoVO thisTerm = vocabTerms[i].getTerminos()[j];
					
					// Final status
					if (thisTerm.getIdTermino().equals(prop.getProperty("statusLifeCycleFinal")))
						terms.put("lifeCycleStatusFinal", (String)thisTerm.getNomTermino());
				}
			}
			
		}
		
		// Return the hashmap
		return terms;
	}
	
	
	//
	// This function takes an input from one of the CataloguerDuration input fields
	// and returns 00 if the input is either null or empty
	//
	
	private String zeroFromEmpty(String input)
	{
		if (input == null || input.length() == 0)
			return "00";
		else
			return input;
	}
	
	
	private void updateLOMFromForm(CatalogadorBasicPlusForm form, LomAvanzadoVO lomAdvanced, String idioma)
	{
	
		// Take all of the information from the specified form bean and apply it to
		// the specified LomAvanzadoVO
		
		String source = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		
		// Load the vocabulary terms for field values we wish to explicitly check for
		HashMap vocabTerms = getVocabularyTerms(idioma);
		
		try {

			// When the form is posted, the value sent will be the termId so in order to
			// insert into the LOM, we must convert the termId back into is text equivalent
			InputStream is = null;
			
			Properties prop = new Properties();
			is = this.getClass().getResourceAsStream("/catalogadorBasicPlus.properties");
	        prop.load(is);

	        // The array of terms Ids we are looking at
	        String[] l_id = { prop.getProperty("idioma"),
					prop.getProperty("aggregationLevel"),
					prop.getProperty("technicalOrCompositeType"),										
					prop.getProperty("tipoDeRecurso"),
					prop.getProperty("intendedEndUserRole"),
					prop.getProperty("relationKind"),
					prop.getProperty("technicalOrCompositeName"),
					prop.getProperty("format")
					};
	
	        // The array of actual terms from the form
	        String[] term_id = { form.getIdioma(),
	        		form.getAggregationLevel(),
	        		form.getTechnicalOrCompositeType(),
	        		form.getTipoRecurso(),
	        		form.getIntendedEndUserRole(),
	        		form.getRelationKind(),
	        		form.getTechnicalOrCompositeName(),
					form.getFormat()
	        		};
	        
	        TerminoYPadreVO[] termsArray = this.getSrvVocabulariosControladosService().crearTraduccionAIngles(term_id);
        	 
	        // Cambiado el identificador del termino al nombre del termino en ingles
	        boolean setLangTerm = false, setAggregationLevelTerm = false, 
	        	setOrCompositeTerm = false, setResourceTypeTerm = false,
	        	setEndUserRole = false, setRelationKind = false,
	        	setOrCompositeNameTerm = false, setFormat = false;
	        
	        for (int cont = 0; cont < termsArray.length; cont++) {

	        	// Language (idioma) term 
	        	if (l_id[0].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getGeneral().getIdiomas()[0].setTexto(termsArray[cont].getNomTermino());
	        		setLangTerm = true;
	        	}
	        	
	        	// Aggregation level term
	        	else if (l_id[1].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getGeneral().getNivelAgregacion().setValor(termsArray[cont].getNomTermino());
	        		setAggregationLevelTerm = true;
	        	}
	        	
	        	// Technical OrComposite type term
	        	else if (l_id[2].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getTechnical().getRequisitos()[0].getAgregadoresOR()[0].getTipo().setValor(termsArray[cont].getNomTermino());
	        		setOrCompositeTerm = true;
	        	}
	        	
	        	// Resource type term
	        	else if (l_id[3].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getEducational()[0].getTiposrecursoedu()[0].setValor(termsArray[cont].getNomTermino());
	        		setResourceTypeTerm = true;
	        	}
	        	
	        	// Intended end user role term
	        	else if (l_id[4].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getEducational()[0].getDestinatarios()[0].setValor(termsArray[cont].getNomTermino());
	        		setEndUserRole = true;
	        	}
	        	
	        	// Relation kind term
	        	else if (l_id[5].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getRelaciones()[0].getTipo().setValor(termsArray[cont].getNomTermino());
	        		setRelationKind = true;
	        	}	        	

	        	// Technical OrComposite name term
	        	else if (l_id[6].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getTechnical().getRequisitos()[0].getAgregadoresOR()[0].getNombre().setValor(termsArray[cont].getNomTermino());
	        		setOrCompositeNameTerm = true;
	        	}

				// Format term
	        	else if (l_id[7].equals(termsArray[cont].getIdVocabulario())) {
	        		lomAdvanced.getTechnical().getFormatos()[0].setTexto(termsArray[cont].getNomTermino());
	        		setFormat = true;
	        	}

	        }
		
	        // For any terms that were not set, remove them from the LOM
	        if (!setLangTerm)
	        	lomAdvanced.getGeneral().setIdiomas(null);
	        
	        if (!setAggregationLevelTerm)
	        	lomAdvanced.getGeneral().setNivelAgregacion(null);
	        
	        // According to spec, must be set as a pair
	        if (!setOrCompositeTerm || !setOrCompositeNameTerm)
	        	lomAdvanced.getTechnical().setRequisitos(new RequisitoVO[] {});
	        
	        if (!setEndUserRole)
	        	lomAdvanced.getEducational()[0].setDestinatarios(new SourceValueVO[] {});
	        
	        if (!setResourceTypeTerm)
	        	lomAdvanced.getEducational()[0].setTiposrecursoedu(new SourceValueVO[] {});

			if (!setFormat)
				lomAdvanced.getTechnical().setFormatos(new FormatoVO[] {});
	        	        
		} catch (Exception e) {
			logger.error("Could not look up vocabulary terms: " + e.getMessage());
			return;
		}
		
		
		// Set the title
		lomAdvanced.getGeneral().getTitulo().getTextos()[0].setTexto(form.getTitulo());
		
		// Set/remove the description
		if (!form.getDescription().equals(""))
			lomAdvanced.getGeneral().getDescripciones()[0].getTextos()[0].setTexto(form.getDescription());
		else
			lomAdvanced.getGeneral().setDescripciones(null);
		
		// Set/remove the keyword
		if (!form.getKeyword().equals(""))
			lomAdvanced.getGeneral().getPalabrasClave()[0].getTextos()[0].setTexto(form.getKeyword());
		else
			lomAdvanced.getGeneral().setPalabrasClave(null);
		
		// Set the author/content provider lifecycle contributions
		ContribucionVO[] contributions = lomAdvanced.getLifeCycle().getContribuciones(); 

		// Here we store the contributions we actually want to keep from those
		// currently stored in the LOM
		ArrayList newContributionArrayList = new ArrayList();
		
		for (int i = 0; i < contributions.length; i++)
		{
			ContribucionVO thisContribution = contributions[i];
			
			// Create a current time/date stamp for the contribution fields
			Date now = new Date();
			String nowString = new SimpleDateFormat("yyyy-MM-dd").format(now) + "T" +
				new SimpleDateFormat("HH:mm").format(now);
				
			// Check for author contributor type
			if (thisContribution.getTipo().getValor().equals(vocabTerms.get("lifecycleAuthor")))
			{
				logger.debug("Located the author lifecycle entity");
				
				// Grab the vCard string
				String vCardString = thisContribution.getEntidades()[0].getTexto();
				
				// Parse it into a vCard object
				CataloguerVCard cvc = new CataloguerVCard(vCardString);
				
				// Only update the entry if it has changed; otherwise the time/date
				// stamp will always be overwritten with the current time/date
				if (cvc.getFullName() != form.getAuthorFullName() ||
					cvc.getOrganisation() != form.getAuthorOrganisation())
				{
				
					// Set the LifeCycle -> Author field
					cvc.setFullName(form.getAuthorFullName());
					
					// Set the LifeCycle -> Organisation field
					cvc.setOrganisation(form.getAuthorOrganisation());
					
					// Store the vCard back into the LOM
					thisContribution.getEntidades()[0].setTexto(cvc.toString());
				
					// Update the time/date stamp field
					FechaVO dateVO = new FechaVO();
					dateVO.setFecha(nowString);
					
					DescripcionVO dateDescription = new DescripcionVO();
					LangStringVO dateDescriptionLangString = new LangStringVO();
					dateDescriptionLangString.setIdioma(idioma);
					dateDescriptionLangString.setTexto((String)vocabTerms.get("lifecycleAuthor"));					
					dateDescription.setTextos(new LangStringVO[] { dateDescriptionLangString });
					
					dateVO.setDescripcion(dateDescription);
					thisContribution.setFecha(dateVO);
				}
				
				// Finally: only keep this contribution if the author's full name and organisation
				// have been set
				if (!(form.getAuthorFullName().equals("") && form.getAuthorOrganisation().equals("")))
					newContributionArrayList.add((ContribucionVO)thisContribution);
			}
			
			// Check for content provider contributor type
			if (thisContribution.getTipo().getValor().equals(vocabTerms.get("lifecycleContentProvider")))
			{
				logger.debug("Located the provider lifecycle entity");
				
				// Grab the vCard string
				String vCardString = thisContribution.getEntidades()[0].getTexto();
				
				// Parse it into a vCard object
				CataloguerVCard cvc = new CataloguerVCard(vCardString);
				
				// Only update the entry if it has changed; otherwise the time/date
				// stamp will always be overwritten with the current time/date
				if (cvc.getFullName() != form.getProviderFullName())
				{
					// Set the LifeCycle -> Contributor field
					cvc.setFullName(form.getProviderFullName());
				
					// Store the vCard back into the LOM
					thisContribution.getEntidades()[0].setTexto(cvc.toString());
					
					// Update the time/date stamp field
					FechaVO dateVO = new FechaVO();
					dateVO.setFecha(nowString);
					
					DescripcionVO dateDescription = new DescripcionVO();
					LangStringVO dateDescriptionLangString = new LangStringVO();
					dateDescriptionLangString.setIdioma(idioma);
					dateDescriptionLangString.setTexto((String)vocabTerms.get("lifecycleContentProvider"));					
					dateDescription.setTextos(new LangStringVO[] { dateDescriptionLangString });
					
					dateVO.setDescripcion(dateDescription);
					thisContribution.setFecha(dateVO);
					
					// Finally: only keep this contribution and set the metadata if the provider's full name
					// has been specified
					if (!form.getProviderFullName().equals(""))
					{
						newContributionArrayList.add((ContribucionVO)thisContribution);	
						
						//
						// IMPORTANT: according to the LOM-NDRB spec then the meta-metadata
						// section should also be filled in for the creater role. We shall
						// simply duplicate the "content provider" contribution in order
						// to implement this.
						//
							
						// Always create a new object from scratch
						ContribucionVO thisMetaDataContribution = new ContribucionVO();
						
						SourceValueVO tmpSourceValue = new SourceValueVO();
						tmpSourceValue.setSource(source);
						tmpSourceValue.setValor((String)vocabTerms.get("metadataCreator"));
						
						thisMetaDataContribution.setTipo(tmpSourceValue);
						
						// Note: use the existing entity setup...
						thisMetaDataContribution.setEntidades(thisContribution.getEntidades());
						
						// and the existing date setup
						thisMetaDataContribution.setFecha(dateVO);
						
						// Store the result in the LOM
						lomAdvanced.getMetaMetadata().setContribuciones(new ContribucionVO[] { thisMetaDataContribution });
	
						// Now set the meta-metadata catalog and entry the same as general
						lomAdvanced.getMetaMetadata().setIdentificadores(
								lomAdvanced.getGeneral().getIdentificadores()
								);
						
						// Set the metadata schema
						EsquemaDeMetadatosVO[] metadataSchemeArray = new EsquemaDeMetadatosVO[1];
						metadataSchemeArray[0] = new EsquemaDeMetadatosVO();
						metadataSchemeArray[0].setTexto(source);
						
						lomAdvanced.getMetaMetadata().setEsquemas(metadataSchemeArray);
						
					}
					else
					{
						// If not set then we also need to clear the metadata
						// LOM section
						
						lomAdvanced.getMetaMetadata().setContribuciones(new ContribucionVO[] {});
						lomAdvanced.getMetaMetadata().setIdentificadores(new IdentificadorVO[] {});
						lomAdvanced.getMetaMetadata().setEsquemas(new EsquemaDeMetadatosVO[] {});
					}
				}
			}
		}
		
		
		// Always set the MetaMetadata language to "en" so that it appears in the English 
		// language index
		IdiomaVO metaDataLanguage = new IdiomaVO();
		metaDataLanguage.setTexto("en");
		
		lomAdvanced.getMetaMetadata().setIdioma(metaDataLanguage);
		
		
		// Set the contributions we wish to keep
		lomAdvanced.getLifeCycle().setContribuciones((ContribucionVO[])newContributionArrayList.toArray(new ContribucionVO[] {}));
		
		
		// Set/remove the installation remarks
		if (!form.getInstallationNotes().equals(""))
			lomAdvanced.getTechnical().getPautasInstalacion().getTextos()[0].setTexto(form.getInstallationNotes());
		else
			lomAdvanced.getTechnical().setPautasInstalacion(null);
		
		// Set the platform requirements
		if (!form.getPlatformRequirements().equals(""))
			lomAdvanced.getTechnical().getOtrosRequisitos().getTextos()[0].setTexto(form.getPlatformRequirements());
		else
			lomAdvanced.getTechnical().setOtrosRequisitos(null);

		// Set/remove the notes
		if (form.getNotes().length() != 0) {
			lomAdvanced.getAnotaciones()[0].getDescripcion().getTextos()[0].setTexto(form.getNotes());
			FechaVO dateVO = new FechaVO();
			// Create a current timestamp
			Date   now       = new Date();
			String nowString = new SimpleDateFormat("yyyy-MM-dd").format(now) + "T" +
				new SimpleDateFormat("HH:mm").format(now);
			dateVO.setFecha(nowString);

			DescripcionVO dateDescription           = new DescripcionVO();
			LangStringVO  dateDescriptionLangString = new LangStringVO();
			dateDescriptionLangString.setIdioma(idioma);
			dateDescriptionLangString.setTexto((String)vocabTerms.get("metadataValidator"));
			dateDescription.setTextos(new LangStringVO[] { dateDescriptionLangString });
			dateVO.setDescripcion(dateDescription);

			lomAdvanced.getAnotaciones()[0].setFecha(dateVO);
		}
		else {
			lomAdvanced.setAnotaciones(null);
		}

		// Set the duration fields
		CataloguerDuration d1 = new CataloguerDuration();
		d1.setYears(form.getDurationYears());
		d1.setMonths(form.getDurationMonths());
		d1.setDays(form.getDurationDays());
		d1.setHours(form.getDurationHours());
		d1.setMinutes(form.getDurationMinutes());
		d1.setSeconds(form.getDurationSeconds());
		
		// Note: the technical duration is optional, so if no duration
		// is specified then we simply omit/remove the technical duration
		// from the LOM
		if (!d1.isEmpty())
		{
			// Create a new duration object
			DuracionVO techDuration = new DuracionVO();
			lomAdvanced.getTechnical().setDuracion(techDuration);
			
			lomAdvanced.getTechnical().getDuracion().setDuracion(d1.toString());
			
			DescripcionVO durationDescription = new DescripcionVO();
			LangStringVO durationLangString = new LangStringVO();
			durationLangString.setIdioma(idioma);
			durationLangString.setTexto("duration for continuous play media");
			
			durationDescription.setTextos(new LangStringVO[] { durationLangString });
			
			lomAdvanced.getTechnical().getDuracion().setDescripcion(durationDescription);
		}
		else
		{
			// Remove from the LOM totally!
			lomAdvanced.getTechnical().setDuracion(null);
		}
			
		// Set the typical learning time fields		
		if (!form.getTypicalLearningTimeFull().equals(""))
		{
			// Note: the form variable is of the form YY-MM-DD-HH-MM-SS
			CataloguerDuration d2 = new CataloguerDuration();
			String[] splitLearningTime = form.getTypicalLearningTimeFull().split("-");
			
			d2.setYears(splitLearningTime[0]);
			d2.setMonths(splitLearningTime[1]);
			d2.setDays(splitLearningTime[2]);
			d2.setHours(splitLearningTime[3]);
			d2.setMinutes(splitLearningTime[4]);
			d2.setSeconds(splitLearningTime[5]);
			
			lomAdvanced.getEducational()[0].getTiempoAprendizaje().setDuracion(d2.toString());
	
			DescripcionVO learningTimeDescription = new DescripcionVO();
			LangStringVO learningTimeLangString = new LangStringVO();
			learningTimeLangString.setIdioma(idioma);
			learningTimeLangString.setTexto("duration for typical learning time");
			
			learningTimeDescription.setTextos(new LangStringVO[] { learningTimeLangString });
			
			lomAdvanced.getEducational()[0].getTiempoAprendizaje().setDescripcion(learningTimeDescription);
			
			// Create educational language entry if it doesn't already exist
			// and we've set one further up in the LOM
			if ((lomAdvanced.getEducational()[0].getIdiomas() == null ||
				lomAdvanced.getEducational()[0].getIdiomas().length == 0) &&
				lomAdvanced.getGeneral().getIdiomas() != null &&
				lomAdvanced.getGeneral().getIdiomas().length > 0)
			{
				IdiomaVO educationalLanguage = new IdiomaVO();
				
				lomAdvanced.getEducational()[0].setIdiomas( 
					lomAdvanced.getGeneral().getIdiomas()	
					);
			}
		}			
		else
		{
			// Remove from LOM totally!
			lomAdvanced.getEducational()[0].setTiempoAprendizaje(null);
			lomAdvanced.getEducational()[0].setIdiomas(new IdiomaVO[] {});
		}
		
		
		// Set the relation description entry (optional)
		if (lomAdvanced.getRelaciones().length > 0)
		{
			lomAdvanced.getRelaciones()[0].getRecurso().getDescripciones()[0].getTextos()[0].setTexto(form.getRelationKindDescription());
		}
			
		// Rights: according to the NDRB specification, the default license should
		// be creative commons: attribution - non commercial - share alike. So lets
		// add the default license here.
		
		// Create the rights entry if it doesn't already exist
		if (lomAdvanced.getDerechos() == null)
		{
			AvRightsVO rights = new AvRightsVO();
			SourceValueVO type = new SourceValueVO();
			type.setSource(source);
			type.setValor("universal");
			
			DescripcionVO description = new DescripcionVO();
			LangStringVO descriptionLangString = new LangStringVO();
			descriptionLangString.setIdioma(idioma);
			descriptionLangString.setTexto("MEC");
			
			description.setTextos(new LangStringVO[] { descriptionLangString });
			
			AccesoVO access = new AccesoVO();
			access.setDescripcion(description);
			access.setTipo(type);
			
			// Set the values in the LOM
			rights.setAcceso(access);
			
			lomAdvanced.setDerechos(rights);
		}
		
		// Set the cost
		SourceValueVO rightsCost = new SourceValueVO();
		rightsCost.setSource(source);
		rightsCost.setValor((String)vocabTerms.get("rightsNoCost"));

		lomAdvanced.getDerechos().setCoste(rightsCost);
		
		// Set the rights "has copyright" to yes
		SourceValueVO rightsHasCopyright = new SourceValueVO();
		rightsHasCopyright.setSource(source);
		rightsHasCopyright.setValor((String)vocabTerms.get("rightsHasCopyright"));
		
		lomAdvanced.getDerechos().setDerechosDeAutor(rightsHasCopyright);
		
		// Set the description to the default license (CC non-com share-alike)
		DescripcionVO rightsLicense = new DescripcionVO();
		LangStringVO rightsLicenseLangString = new LangStringVO();
		rightsLicenseLangString.setIdioma(idioma);
		rightsLicenseLangString.setTexto((String)vocabTerms.get("rightsDefaultLicense"));
		
		rightsLicense.setTextos(new LangStringVO[] { rightsLicenseLangString });
		
		lomAdvanced.getDerechos().setDescripcion(rightsLicense);
		
		
		//
		// Relation entry
		//
		if (form.getRelationKind() != null && form.getRelationKind().length() != 0)
		{
			// If no relation entry exists, create it...
			if (lomAdvanced.getRelaciones() == null || lomAdvanced.getRelaciones().length == 0)
			{
				AvRelationVO relation = new AvRelationVO();
				
				RecursoVO relationResource = new RecursoVO();
				
				IdentificadorVO relationId = new IdentificadorVO();
				relationResource.setIdentificador(relationId);
				
				relation.setRecurso(relationResource);
				
				lomAdvanced.setRelaciones(new AvRelationVO[] { relation } );
			}
			
			// Now set the catalogue and entry fields...
			
			// Create the identifier entry if it doesn't exist...
			if (lomAdvanced.getRelaciones()[0].getRecurso() == null)
				lomAdvanced.getRelaciones()[0].setRecurso(new RecursoVO());
			
			if (lomAdvanced.getRelaciones()[0].getRecurso().getIdentificador() == null)
				lomAdvanced.getRelaciones()[0].getRecurso().setIdentificador(new IdentificadorVO());
			
			// Borrow catalogue from the General LOM section
			lomAdvanced.getRelaciones()[0].getRecurso().getIdentificador().setCatalogo(
					lomAdvanced.getGeneral().getIdentificadores()[0].getCatalogo()
					);
			
			// Set the entry to the form value
			lomAdvanced.getRelaciones()[0].getRecurso().getIdentificador().setEntrada(
					form.getRelationKindEntry()
					);
			
			// Set the description
			DescripcionVO relationDescription = new DescripcionVO();
			LangStringVO relationDescriptionLangString = new LangStringVO();
			relationDescriptionLangString.setIdioma(idioma);
			relationDescriptionLangString.setTexto(form.getRelationKindDescription());
			
			relationDescription.setTextos(new LangStringVO[] { relationDescriptionLangString });
			
			lomAdvanced.getRelaciones()[0].getRecurso().setDescripciones(new DescripcionVO[] { relationDescription });
			
			// And the type... this is already handled by the vocabulary lookup at the
			// very start.

		}
		else
		{
			// Relation kind is unspecified; remove the relation element from the LOM
			lomAdvanced.setRelaciones(new AvRelationVO[] {});
		}
		
		logger.debug("Completed updateLOMFromForm");
	}
	
	
	private void updateLOMFromCurriculumTreesArray(ArbolCurricularVO[] curriculumTreesArray, LomAvanzadoVO lomAdvanced, String idioma)
	{
		// Take the contents of the specified ArbolCurricularVO[] which is used by the
		// session to store the curriculum trees, and then use it to update the LOM with
		// the entries within the array.
		
		
		// Firstly get the name of the vocabulary - this will be the source
		// name for the specified taxonomy entries
		String ficheroProperties = "/catalogadorBasicPlus.properties";
		InputStream iss=null;
		iss= this.getClass().getResourceAsStream(ficheroProperties);
		Properties fprop = new Properties();
		try {
			fprop.load(iss);
		
			String nomTaxonomia = fprop.getProperty("arbolCurricular").toString();
			String vocabName = this.getSrvTaxonomiaService().obtenerVocabName(nomTaxonomia, idioma);			

			// Create an array ready to store our new paths
			if (curriculumTreesArray != null && curriculumTreesArray.length > 0)
			{
				
				RutaTaxonomicaVO[] newTaxonPathArray = new RutaTaxonomicaVO[curriculumTreesArray.length];
	
				// Create the classification object within the LOM if it doesn't already exist
				if (lomAdvanced.getClasificaciones() == null || 
					lomAdvanced.getClasificaciones().length == 0)
				{
					AvClassificationVO tmpClassificationVO = new AvClassificationVO();
					lomAdvanced.setClasificaciones( new AvClassificationVO[] { tmpClassificationVO });
				}
					
				// Clear the existing taxonPaths are we are going to update them
				// from the ArbolCurricularVO[] input array
				lomAdvanced.getClasificaciones()[0].setRutasTaxonomicas(new RutaTaxonomicaVO[] {} );
				
				for (int i = 0; i < curriculumTreesArray.length; i++)
				{
					// Get a reference to the curriculum tree and then determine
					// the id with the longest path to check for duplicates				
					ArbolCurricularVO thisCurriculumTree = curriculumTreesArray[i];
					
					// Create the object ready for the LOM 
					newTaxonPathArray[i] = new RutaTaxonomicaVO();
	
					// First add the source
					FuenteVO tmpFuenteVO = new FuenteVO();
					LangStringVO tmpLangStringVO = new LangStringVO();
					tmpLangStringVO.setIdioma(idioma);
					tmpLangStringVO.setTexto(vocabName);
					
					tmpFuenteVO.setTextos(new LangStringVO[] { tmpLangStringVO });
					
					newTaxonPathArray[i].setFuente(tmpFuenteVO);
					
	
					// Now for the taxonPath. Loop through each entry and add it to
					// the newTaxonPathArray array
					int n = thisCurriculumTree.getTaxones().length;
					TaxonVO[] tmpTaxonVOArray = new TaxonVO[n];
											
					for (int o = 0; o < n; o++)
					{
						tmpTaxonVOArray[o] = new TaxonVO();
						
						IdVO tmpIdVO = new IdVO();
						tmpIdVO.setTexto(thisCurriculumTree.getTaxones()[(n-1)-o].getId());
						
						LangStringVO tmpLangStringEntryVO = new LangStringVO();
						tmpLangStringEntryVO.setIdioma(idioma);
						tmpLangStringEntryVO.setTexto(thisCurriculumTree.getTaxones()[(n-1)-o].getValorTax());
						
						EntryVO tmpEntryVO = new EntryVO();
						tmpEntryVO.setTextos(new LangStringVO[] { tmpLangStringEntryVO });
						
						tmpTaxonVOArray[o].setId(tmpIdVO);
						tmpTaxonVOArray[o].setEntry(tmpEntryVO);
					}
						
					// Set the new taxon array within the LOM
					newTaxonPathArray[i].setTaxones(tmpTaxonVOArray);
				}	
				
				// Now update the LOM to contains the new values
				lomAdvanced.getClasificaciones()[0].setRutasTaxonomicas(newTaxonPathArray);
			}
			else
			{
				// Otherwise if empty we simply remove the items from the LOM
				lomAdvanced.getClasificaciones()[0].setRutasTaxonomicas(new RutaTaxonomicaVO[] {});
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private boolean validateBasicPlusGeneral(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM general section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.
		
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", locale);
		boolean ok= true;
		String resultado = "";
		
		// Get a reference to the general section of the LOM
		AvGeneralVO gn = lomAdvanced.getGeneral(); 
		
		//CATALOGOS
		int i= 0;
		while ((ok)&&(i<gn.getIdentificadores().length)){
			String cat= gn.getIdentificadores()[i].getCatalogo().trim();
			String ent= gn.getIdentificadores()[i].getEntrada().trim();
			
			if(((cat==null)||(cat.length() == 0))&& ((ent!=null)&&(ent.length() != 0)))//Si existe una entrada, un cat醠ogo es obligatorio
					errorMessages.add(datosResources.getString("CAV.1.1.1"));

			if (resultado.length() != 0){
				ok= false;
			}
			else{
				i++;
			}	
		}
		//ENTRADAS
		i= 0;
		while ((ok)&&(i<gn.getIdentificadores().length)){
			String cat= gn.getIdentificadores()[i].getCatalogo().trim();
			String ent= gn.getIdentificadores()[i].getEntrada().trim();
			
			if (((ent==null)||(ent.length() == 0))&& ((cat!=null)&&(cat.length() != 0)))//Si existe un cat醠ogo, una entrada es obligatoria
				errorMessages.add(datosResources.getString("CAV.1.1.2"));
			
			
			if (resultado.length() != 0){
				ok= false;
			}
			else{
				i++;
			}	
		}
		//TITULOS
		boolean todosVacios=true;
		String texto;
		for(i=0;i<gn.getTitulo().getTextos().length && todosVacios ;i++)
		{
			texto=gn.getTitulo().getTextos()[i].getTexto().trim();
			if(texto!=null && texto.length() != 0)
			{
				todosVacios=false;
			}
		}
		if(todosVacios)
			errorMessages.add(datosResources.getString("CAV.1.2"));//debe tener por lo menos un titulo
		
		/*
		 * Not required for LOM-NDRB
		 * 

		//IDIOMA
		todosVacios=true;
		String idioma;
		for(i=0;i<gn.getIdiomas().length && todosVacios;i++)
		{
			idioma= gn.getIdiomas()[i].getTexto();
			if(idioma!=null && idioma.length() != 0)
			{
				todosVacios=false;
			}
		}
		if(todosVacios)
			errorMessages.add(datosResources.getString("CAV.1.3"));//debe tener por lo menos un idioma
		
		todosVacios=true;
		String descripcion;
		for(i=0;i<gn.getDescripciones().length && todosVacios;i++)
		{
			for(int j=0;j<gn.getDescripciones()[i].getTextos().length && todosVacios;j++)
			{
				descripcion=gn.getDescripciones()[i].getTextos()[j].getTexto().trim();
				if(descripcion!=null && descripcion.length() != 0)
				{
					todosVacios=false;
				}
			}
		}
		if(todosVacios)
			errorMessages.add(datosResources.getString("CAV.1.4"));//al menos una descripcion
		
		//NIVEL DE AGREGACION
		if(gn.getNivelAgregacion().getValor()==null || gn.getNivelAgregacion().getValor().length() == 0)
			errorMessages.add(datosResources.getString("CAV.1.8"));
		*/

		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

	}
	
	
	private boolean validateBasicPlusLifeCycle(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM lifecycle section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.
		
		boolean enc = false;
		boolean encDesc = false;
		boolean encTipo = false;
		SourceValueVO tipo = new SourceValueVO();
		String fech = "";
		
		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
		ContribucionVO[] contribucionesVO = lomAdvanced.getLifeCycle().getContribuciones();
		
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length;i++){
				tipo=contribucionesVO[i].getTipo();
				if(tipo ==null)
					encTipo=true;
				if(contribucionesVO[i].getEntidades()!=null && contribucionesVO[i].getEntidades().length>0){
					int j=0;
					while(!enc &&  j<contribucionesVO[i].getEntidades().length){
						if(contribucionesVO[i].getEntidades()[j].getTexto()==null)
							j++;
						else
							enc=true;
					}
				}
				if(contribucionesVO[i].getFecha()!=null){
					fech=contribucionesVO[i].getFecha().getFecha();
					int k=0;
					if(contribucionesVO[i].getFecha().getDescripcion()!=null){
						while(!encDesc && k<contribucionesVO[i].getFecha().getDescripcion().getTextos().length){
							if(contribucionesVO[i].getFecha().getDescripcion().getTextos()[k].getTexto().length() == 0)
								k++;
							else
								encDesc=true;
						}
					}
				}
				
				if(encTipo&&(enc||encDesc||fech!=null) && !errorMessages.contains(datosResources.getString("CAV.2.3.1"))){
					errorMessages.add(datosResources.getString("CAV.2.3.1"));
				}
				if(!enc &&(!encTipo||encDesc||fech!=null) && !errorMessages.contains(datosResources.getString("CAV.2.3.2"))){
					errorMessages.add(datosResources.getString("CAV.2.3.2"));
				}
				if((fech==null || fech.trim().length() == 0) && !encDesc &&(!encTipo||enc) && !errorMessages.contains(datosResources.getString("CAV.2.3.3"))){
					errorMessages.add(datosResources.getString("CAV.2.3.3"));
				}
				enc=false;
				encDesc=false;
				encTipo=false;
				
			}
			
		}
		
		
		//FECHA--DESCRIPCION
		boolean fechDesc=true;
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length && fechDesc;i++){
				String fecha="";
				String idiom="";
				String text="";
				if(contribucionesVO[i].getFecha()!=null){
					fecha=contribucionesVO[i].getFecha().getFecha();
					DescripcionVO descVO=contribucionesVO[i].getFecha().getDescripcion();
					if(descVO!=null){
						if(descVO.getTextos()!=null &&descVO.getTextos().length>0 &&fechDesc){
							for(int j=0;j<descVO.getTextos().length &&fechDesc;j++){
								idiom=descVO.getTextos()[j].getIdioma();
								text=descVO.getTextos()[j].getTexto();
							
								if((fecha==null||fecha.length() == 0)&&(idiom.length() != 0||text.length() != 0)){
									errorMessages.add(datosResources.getString("CAV.2.3.3.1"));
									fechDesc= false;
								}
							}
						}
					}
				}
			}	
					
		}
		//	DESCRIPCION-FECHA
		fechDesc=true;
		if(contribucionesVO!=null){
			for(int i=0;i<contribucionesVO.length && fechDesc;i++){
				String fecha="";
				String idiom="";
				String text="";
				if(contribucionesVO[i].getFecha()!=null){
					fecha=contribucionesVO[i].getFecha().getFecha();
					DescripcionVO descVO=contribucionesVO[i].getFecha().getDescripcion();
					if(descVO!=null){
						if(descVO.getTextos()!=null &&descVO.getTextos().length>0 &&fechDesc){
							for(int j=0;j<descVO.getTextos().length&&fechDesc;j++){
								idiom=descVO.getTextos()[j].getIdioma();
								text=descVO.getTextos()[j].getTexto();
								if(fechDesc&& fecha!=null &&((text.length() == 0))){
									if(fechDesc&& fecha.length() != 0&&((text.length() == 0))){
										errorMessages.add(datosResources.getString("CAV.2.3.3.2"));
										fechDesc= false;
									}
								}
							}
						}
					}else{
						errorMessages.add(datosResources.getString("CAV.2.3.3.2"));
					}
				}
			}	
					
		}
		
	
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}
	}
	
	
	private boolean validateBasicPlusMetaMetadata(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM meta-metadata section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with some heavy modifications in the middle, due to an internal
		// but different API being used for time/date extraction. I've added a
		// rather naive implementation which I hope will do for the moment...

		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
		
		int i= 0;
		boolean completo=true;
		boolean todosVacios=true;
		
		IdentificadorVO[] identificadores = lomAdvanced.getMetaMetadata().getIdentificadores();
		
		//IDENTIFICADORES
		for(i=0;i<identificadores.length && completo;i++)
		{
			if((identificadores[i].getCatalogo()!=null && identificadores[i].getCatalogo().trim().length() == 0) &&
			   (identificadores[i].getEntrada()!=null && identificadores[i].getEntrada().trim().length() != 0) )
			{
				completo=false;
				errorMessages.add(datosResources.getString("CAV.3.1.1"));//Si existe una entrada para un identificador, un cat&aacute;logo es obligatorio
			}
		}
		
		completo=true;
		for(i=0;i<identificadores.length && completo;i++)
		{
			if((identificadores[i].getCatalogo()!=null && identificadores[i].getCatalogo().trim().length() != 0) &&
			   (identificadores[i].getEntrada()!=null && identificadores[i].getEntrada().trim().length() == 0) )
			{
				completo=false;
				errorMessages.add(datosResources.getString("CAV.3.1.2"));//Si existe un cat&aacute;logo para un identificador, una entrada es obligatoria
			}
		}
		
		
		//CONTRIBUCION
		
		String rol;
//		boolean errorRol=false;
		boolean errorContRol=false;
		boolean errorContEntidad=false;
		boolean errorContFecha=false;
		
		boolean errorFecha=false;
		boolean errorFechaVacia=false;
		boolean errorDescVacia=false;
		boolean errorMinutos=false;

		boolean entidadesVacia;
		boolean fechaVacia;
		boolean horasVacia;
		boolean descVacios;
		
		ContribucionVO[] contribuciones = lomAdvanced.getMetaMetadata().getContribuciones();
		
		for(i=0;i<contribuciones.length && (!errorContRol || !errorContEntidad || !errorContFecha) ;i++ )
		{
//			ROL
				rol = contribuciones[i].getTipo().getValor();
//		//entidad
				entidadesVacia=true;
				for(int j=0;j<contribuciones[i].getEntidades().length && entidadesVacia;j++)
				{
					EntidadVO ent = contribuciones[i].getEntidades()[j];
					CataloguerVCard cvc = new CataloguerVCard(ent.getTexto());
					
					if((cvc.getFullName()!=null && cvc.getFullName().trim().length() != 0) ||
					   (cvc.getOrganisation()!=null && cvc.getOrganisation().trim().length() != 0) || 
					   (cvc.getEmailAddress()!=null && cvc.getEmailAddress().trim().length() != 0)
							)
					{
						entidadesVacia=false;
					}
					
				}
				
		//fecha
				FechaVO fechaCont = contribuciones[i].getFecha();
				DescripcionVO descCont = fechaCont.getDescripcion();
				
				// Ensure the date is set to something...
				fechaVacia=false;				
				if(fechaCont.getFecha() !=null && fechaCont.getFecha().length() == 0)
				{
					fechaVacia=true;
				}
				
				
				int timeDateSplit = fechaCont.getFecha().indexOf('T');
				horasVacia=false;
				if (timeDateSplit != -1)
				{
					// Warning: Very naive function. We simply split on T, then a colon
					// to break down to hours/minutes/seconds
					String[] splitDate = fechaCont.getFecha().substring(timeDateSplit + 1).split(":");
				
					if((splitDate[0].trim().length() == 0) && 
						(splitDate[1].trim().length() == 0))
					{
						horasVacia=true;
					}
				}
				else
				{
					// If there is no split, then the time has not been specified :(
					horasVacia=true;
				}
				
				descVacios=true;
				String descFec;
				for(int j=0;j<descCont.getTextos().length && descVacios;j++)
				{
					descFec= descCont.getTextos()[j].getTexto();
					if(descFec!=null && descFec.length() != 0)
					{
						descVacios=false;// si todos los campos descripcion son vacios
					}
				}
				
			
			if( !((rol==null || rol.trim().length() == 0) && //rol vacio
				(entidadesVacia) && //entidades vacia
				 fechaVacia && descVacios && horasVacia)//fechavacia
				)
			{
				if(rol==null || rol.trim().length() == 0)
				{
					errorContRol =true;
					errorMessages.add(datosResources.getString("CAV.3.2.1"));//El campo Tipo es obligatorio si se va a incluir una contribuci&oacute;n
				}
				
				if(entidadesVacia)
				{
					errorContEntidad=true;
					errorMessages.add(datosResources.getString("CAV.3.2.2"));//El campo Entidad es obligatorio si se va a incluir una contribuci&oacute;n
				}

				
				
				if(descVacios && fechaVacia && !errorFecha)
				{
					errorContFecha=true;
					errorFecha=true;
					errorMessages.add(datosResources.getString("CAV.3.2.3"));//El campo FECHA	 es obligatorio
				}else if(descVacios && !fechaVacia && !errorFechaVacia) 
				{
					errorContFecha=true;
					errorFechaVacia=true;
					errorMessages.add(datosResources.getString("CAV.3.2.3.2"));//La descripci&oacute;n de la fecha es obligatoria si existe una fecha
				}else if(!descVacios && fechaVacia && !errorDescVacia)
				{
					errorContFecha=true;
					errorDescVacia=true;
					errorMessages.add(datosResources.getString("CAV.3.2.3.1"));//La fecha es obligatoria si existe una descripci&oacuete;n de fecha
				}
				if(	fechaVacia && !horasVacia && !errorMinutos )
				{
					errorContFecha=true;
					errorMinutos=true;
					errorMessages.add(datosResources.getString("CAV.3.2.3.8"));//La fecha es obligatoria si el tiempo est&aacute; definido
				}
	
				if(errorFecha && errorFechaVacia && errorDescVacia && errorMinutos)
					errorContFecha=true;
			}

//			}
		
		}
		
		
		
		//ESQUEMA METADATOS No es obligatorio
//		todosVacios=true;
//		String esquema;
//		for(i=0;i<esquemasMeta.length && todosVacios;i++)
//		{
//			esquema=esquemasMeta[i].getTexto();
//			if(esquema!=null && esquema.length() != 0)
//			{
//				todosVacios=false;
//			}
//		}
//		if(todosVacios)
//			mensajes.add(datosResources.getString("CAV.3.3"));//El campo Esquema de metadatos es obligatorio
		
		
		//IDIOMA
		String idioma = lomAdvanced.getMetaMetadata().getIdioma().getTexto();
		
		if(idioma==null || idioma.length() == 0)
			errorMessages.add(datosResources.getString("CAV.3.4"));//El campo Idioma es obligatorio
		
	  	
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

		
	}
	

	private boolean validateBasicPlusTechnical(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM technical section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.	
		
		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
    	String resultado= ""; 
		boolean ok= true;

		String nombre="";
		String tipo="";
		
		AvTechnicalVO tec = lomAdvanced.getTechnical();
				
		//TIPO+NOMBRE
		ok=true;
		int i= 0;
		while ((ok)&&(tec.getRequisitos() != null && i<tec.getRequisitos().length)){
			AgregadorORVO[] cat= tec.getRequisitos()[i].getAgregadoresOR();
			if(cat!=null && cat.length>0){
				int j=0;
				while((ok)&&(j<cat.length)){
					SourceValueVO sNombre= cat[j].getNombre();
					SourceValueVO sTipo=cat[j].getTipo();
					if(sNombre!=null){
						nombre=sNombre.getValor();
					}
					
					if (nombre == null || nombre.length() == 0) {
						errorMessages.add(datosResources.getString("CAV.4.4.1.2"));
					}
					
					if(sTipo!=null){
						tipo=sTipo.getValor();
					}

					if(tipo == null || tipo.length() == 0){
						errorMessages.add(datosResources.getString("CAV.4.4.1.1"));
					}
					if (resultado.length() != 0){
						ok= false;
					}else{
						j++;
					}
							
				}
			}if (resultado.length() != 0){
				ok= false;
			}else
				i++;
			
		}
		
		//DURACION
		boolean todosVacios=true;
		boolean duracionVacia=false;
		
        String descripcion;
        if(tec.getDuracion()!=null){
        	if((tec.getDuracion().getDescripcion()!=null)&&(tec.getDuracion().getDescripcion().getTextos()!=null)&&(tec.getDuracion().getDescripcion().getTextos().length>0)){
		        for(i=0;i<tec.getDuracion().getDescripcion().getTextos().length && todosVacios;i++)
		        {
                    descripcion=tec.getDuracion().getDescripcion().getTextos()[i].getTexto();
                    if(descripcion!=null && descripcion.trim().length() != 0)
                    {
                         todosVacios=false;
                    }
		        }
        	}


	        //DURACION
	        
        	// MCA: Note that technical duration is optional (only for continuous play media)
	        // MCA: Use the new CataloguerDuration class to handle this easily :)
	        CataloguerDuration cd = new CataloguerDuration(tec.getDuracion().getDuracion());
	        
	        if(   (cd.getYears() == null || cd.getYears().trim().length() == 0) &&
	              (cd.getMonths() == null || cd.getMonths().trim().length() == 0) &&
	              (cd.getDays() == null || cd.getDays().trim().length() == 0) &&
	              (cd.getHours() == null || cd.getHours().trim().length() == 0) &&
	              (cd.getMinutes() == null || cd.getMinutes().trim().length() == 0) &&
	              (cd.getSeconds() == null || cd.getSeconds().trim().length() == 0))
	        {
	              //si alguno de los campos dia, mes o anyo esta vacio, fecha esta vacio
	              duracionVacia=true;
	        }
        
	        if(todosVacios && !duracionVacia)
	        	errorMessages.add(datosResources.getString("CAV.4.7.2"));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
	        if(!todosVacios && duracionVacia)
	        	errorMessages.add(datosResources.getString("CAV.4.7.1"));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n
        }
        
        // Size
        TamanioVO size = tec.getTamanio();
        if(size != null && size.getTexto() != null && size.getTexto().length() != 0){
	        try{
	        	Long bigSize=new Long(size.getTexto());
	        	if(bigSize.intValue()<0){
	        		errorMessages.add(datosResources.getString("CAV.4.1"));//Meterle la validaci髇 del integer no negativo
	        	}
	        }catch(Exception e){
	        	errorMessages.add(datosResources.getString("CAV.4.1"));//Meterle la validaci髇 del integer no negativo
	        }
        }

		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

	}
	
	
	private boolean validateBasicPlusEducational(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM educational section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.

		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
	  	
		boolean todosVacios=true;
		int i;

		// Cycle through all of the Educational sections
		for (int e = 0; e < lomAdvanced.getEducational().length; e++)
		{
			AvEducationalVO thisEducational = lomAdvanced.getEducational()[e];
					
		  	//TIPO DE RECURSO DE APRENDIZAJE
			String recurso;
			for(i = 0; i < thisEducational.getTiposrecursoedu().length && todosVacios;i++)
			{
				recurso= thisEducational.getTiposrecursoedu()[i].getValor();
				if(recurso!=null && recurso.length() != 0)
				{
					todosVacios=false;
				}
			}
			if(todosVacios)
				errorMessages.add(datosResources.getString("CAV.5.2"));//El campo Tipo de recurso es obligatorio
	
			//IDIOMA
			todosVacios=true;
			String idioma;
			
			if (thisEducational.getIdiomas() != null)
			{
				for(i = 0; i < thisEducational.getIdiomas().length && todosVacios;i++)
				{
					idioma = thisEducational.getIdiomas()[i].getTexto();
					if(idioma!=null && idioma.length() != 0)
					{
						todosVacios=false;
					}
				}
			}
			
			if(todosVacios)
				errorMessages.add(datosResources.getString("CAV.5.11"));//El campo Idioma es obligatorio
	
		  	//TIEMPO DE APRENDIZAJE
			//DESCRIPCIONES
			todosVacios=true;
			String descripcion;
			
			if (thisEducational.getTiempoAprendizaje() != null)
			{
				if (thisEducational.getTiempoAprendizaje().getDescripcion() != null &&
					thisEducational.getTiempoAprendizaje().getDescripcion().getTextos() != null &&
					thisEducational.getTiempoAprendizaje().getDescripcion().getTextos().length != 0)
				{
					todosVacios=false;
				}
			}
			
			/* MCA: This checks for general description, not just for learning time
			if (thisEducational.getDescripciones() != null)
			{
				for(i = 0; i < thisEducational.getDescripciones().length && todosVacios; i++)
				{
					for(int j = 0; j < thisEducational.getDescripciones()[i].getTextos().length && todosVacios;j++)
					{
						descripcion = thisEducational.getDescripciones()[i].getTextos()[j].getTexto();
						if(descripcion!=null && descripcion.trim().length() != 0)
						{
							todosVacios=false;
						}
					}
				}
			}
			*/
			
			//DURACION
			boolean duracionVacia=false;
			
			// MCA: Use the new CataloguerDuration object to handle this
			CataloguerDuration cd = new CataloguerDuration(thisEducational.getTiempoAprendizaje().getDuracion());
			
			if(	(cd.getYears() !=null && cd.getYears().trim().length() == 0) &&
				(cd.getMonths() != null && cd.getMonths().trim().length() == 0) &&
				(cd.getDays() != null && cd.getDays().trim().length() == 0) &&
				(cd.getHours() != null && cd.getHours().trim().length() == 0) &&
				(cd.getMinutes() != null && cd.getMinutes().trim().length() == 0) &&
				(cd.getSeconds() != null && cd.getSeconds().trim().length() == 0))
			{
				//si alguno de los campos dia, mes o anyo esta vacio, fecha esta vacio
				duracionVacia=true;
			}
			
			
			
			if(todosVacios && !duracionVacia)
				errorMessages.add(datosResources.getString("CAV.5.9.2"));//La descripci&oacute;n dela duraci&oacute;n es obligatoria si existe una duraci&oacute;n
			if(!todosVacios && duracionVacia)
				errorMessages.add(datosResources.getString("CAV.5.9.1"));//La duraci&oacute;n es obligatoria si existe una descripci&oacute;n de duraci&oacute;n

			
			// Intended User Role
			boolean intendedUserRolePresent = false;
			if (thisEducational.getDestinatarios() != null && thisEducational.getDestinatarios()[0] != null)
			{
				if (thisEducational.getDestinatarios()[0].getValor().length() != 0)
					intendedUserRolePresent = true;
			}

			if (intendedUserRolePresent == false)
				errorMessages.add(datosResources.getString("CAV.5.9.3"));//Intended user role must be set
			
		}
	  	
		
	  	//a馻dir mensajesError en el form
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}
		
	}

	
	private boolean validateBasicPlusRights(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM rights section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.

		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", locale);
		
		AvRightsVO rights = lomAdvanced.getDerechos();

    	//COST
		if (rights.getCoste() == null || rights.getCoste().getValor().length() == 0)
			errorMessages.add(datosResources.getString("CAV.6.1"));
		
    	//COPYRIGHT 
		if (rights.getDerechosDeAutor() == null || rights.getDerechosDeAutor().getValor().length() == 0)
			errorMessages.add(datosResources.getString("CAV.6.2"));
    	
    	//ACCESO
    	if(rights.getAcceso() == null || rights.getAcceso().getTipo() == null)
    		errorMessages.add(datosResources.getString("CAV.6.4.1"));
    	
    	//AMBITO
    	if(rights.getAcceso().getTipo().getSource().length() == 0)
    		errorMessages.add(datosResources.getString("CAV.6.4.2"));//Es necesario seleccionar al menos un &aacute;mbito
		
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

	}
	
	
	private boolean validateBasicPlusRelation(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM relation section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.

		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
		
		String resultado= "";
		boolean ok= true;
		
		// This field is optional, so we allow a LOM without this section to pass
		if (lomAdvanced.getRelaciones() != null)
		{
			for (int i = 0; i < lomAdvanced.getRelaciones().length; i++)
			{
				AvRelationVO thisRelation = lomAdvanced.getRelaciones()[i];
				
				//TIPO
				if((thisRelation.getTipo()!=null)){
					String tip=thisRelation.getTipo().getValor();
					if((tip==null)||(tip.length() == 0))
						errorMessages.add(datosResources.getString("CAV.7.1"));
				}
				
				//IDENTIFICADOR		
				if((ok)&&(thisRelation.getRecurso()!=null)&&(thisRelation.getRecurso().getIdentificador()!=null)&&(thisRelation.getTipo()!=null)){
					String cat=thisRelation.getRecurso().getIdentificador().getCatalogo();
					String ent=thisRelation.getRecurso().getIdentificador().getEntrada();
					String tip=thisRelation.getTipo().getValor();
					if(((cat==null)||(cat.trim().length() == 0))&& ((ent==null)||(ent.trim().length() == 0)))//Si existe una entrada, un cat醠ogo es obligatorio
						errorMessages.add(datosResources.getString("CAV.7.3"));
					if (resultado.length() != 0){
						ok= false;
					}
				}
				
				//CATALOGOS
				ok=true;
				if((ok)&&(thisRelation.getRecurso()!=null)&&(thisRelation.getRecurso().getIdentificador()!=null)&&(thisRelation.getTipo()!=null)){
					String cat=thisRelation.getRecurso().getIdentificador().getCatalogo();
					String ent=thisRelation.getRecurso().getIdentificador().getEntrada();
					String tip=thisRelation.getTipo().getValor();
					if(((cat==null)||(cat.trim().length() == 0))&& ((ent!=null)&&(ent.trim().length() != 0)))//Si existe una entrada, un cat醠ogo es obligatorio
						errorMessages.add(datosResources.getString("CAV.7.3.1"));
					
					if (resultado.length() != 0){
						ok= false;
					}
					
				}
				
				//ENTRADAS
				if((ok)&&(thisRelation.getRecurso()!=null)&&(thisRelation.getRecurso().getIdentificador()!=null)){
					String cat=thisRelation.getRecurso().getIdentificador().getCatalogo();
					String ent=thisRelation.getRecurso().getIdentificador().getEntrada();
					
					if (((ent==null)||(ent.trim().length() == 0))&& ((cat!=null)&&(cat.trim().length() != 0)))//Si existe un cat醠ogo, una entrada es obligatoria
						errorMessages.add(datosResources.getString("CAV.7.3.2"));
					
					
					if (resultado.length() != 0){
						ok= false;
					}
					
				}
			}
		}
			
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

	}

	private AvAnnotationVO createDefaultAnnotation() {
		AvAnnotationVO tmpAnn = new AvAnnotationVO();

		DescripcionVO tmpDesc    = new DescripcionVO();
		LangStringVO  tmpLangStr = new LangStringVO();
		tmpLangStr.setIdioma("en");
		tmpLangStr.setTexto("");
		tmpDesc.setTextos(new LangStringVO[] { tmpLangStr });
		tmpAnn.setDescripcion(tmpDesc);

		EntidadVO       tmpEntity = new EntidadVO();
		CataloguerVCard annEntCvc = new CataloguerVCard(null);
		annEntCvc.setFullName("NDRB"); // per basic+ specs
		tmpEntity.setTexto(annEntCvc.toString());
		tmpAnn.setEntidad(tmpEntity);

		return tmpAnn;
	}
	
	private boolean validateBasicPlusClassification(LomAvanzadoVO lomAdvanced, Locale locale, Collection errorMessages)
	{
		// Validate the LOM classification section with the criteria specified
		// for the BasicPlus cataloguer. This code is borrowed from the Advanced
		// Cataloguer with a few modifications.

		ResourceBundle datosResources =I18n.getInstance().getResource("application-resources", locale);
		
		// Obtain a reference to the classification section; if it doesn't exist then simply
		// exit with true to allow resources with no curriculum tagging
		if (lomAdvanced.getClasificaciones() == null)
			return true;
			
		AvClassificationVO cl = lomAdvanced.getClasificaciones()[0];
		
		if(cl.getProposito()!=null){
			if ((cl.getProposito().getValor()==null)||(cl.getProposito().getValor().length() == 0)){
				errorMessages.add(datosResources.getString("CAV.9.1"));
			}
		}
	  	boolean errorDado=true;
		if(cl.getRutasTaxonomicas()!=null && cl.getRutasTaxonomicas().length>0 && errorDado){
			for (int i= 0; i<cl.getRutasTaxonomicas().length; i++){
				boolean vacio=false;
				boolean propVacio=false;
				boolean taxonVacio=false;
				boolean todoVacio=true;
				if(cl.getRutasTaxonomicas().length==1){
					if(cl.getRutasTaxonomicas()[0].getFuente()!=null && cl.getRutasTaxonomicas()[0].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[0].getFuente().getTextos().length>0){
						String sce= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
						if ((sce==null)||(sce.length() == 0)){
							propVacio=true;
						}
					}
					if(cl.getRutasTaxonomicas()[0].getTaxones()!=null && cl.getRutasTaxonomicas()[0].getTaxones().length>0 ){
						if(cl.getRutasTaxonomicas()[0].getTaxones().length==1){
							if(cl.getRutasTaxonomicas()[0].getTaxones()[0].getId()!=null &&  cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry()!=null &&
									cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos()!=null && cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos().length>0){ 
									String id= cl.getRutasTaxonomicas()[0].getTaxones()[0].getId().getTexto();
									String entry= cl.getRutasTaxonomicas()[0].getTaxones()[0].getEntry().getTextos()[0].getTexto();
									if ((id==null)||(id.length() == 0)||((entry==null)||(entry.length() == 0))){
										taxonVacio=true;
									}
							}
						}
						
					}
					if(propVacio && taxonVacio){
						errorMessages.add(datosResources.getString("CAV.9.2"));
						todoVacio=false;
					}
				}
				
				if(cl.getRutasTaxonomicas()[i].getFuente()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos()!=null && cl.getRutasTaxonomicas()[i].getFuente().getTextos().length>0 && todoVacio){
					String sce= cl.getRutasTaxonomicas()[i].getFuente().getTextos()[0].getTexto();
					if ((sce==null)||(sce.length() == 0)){
						errorMessages.add(datosResources.getString("CAV.9.2.1"));
						errorDado=false;
					}
					
				}
				if(cl.getRutasTaxonomicas()[i].getTaxones()!=null && cl.getRutasTaxonomicas()[i].getTaxones().length==1 ){
					TaxonVO[] taxones=cl.getRutasTaxonomicas()[i].getTaxones();
					boolean identVacio=false;
					if(taxones!=null && taxones.length>0){
						EntryVO entrada=taxones[0].getEntry();
						IdVO identif=taxones[0].getId();
						
						if (identif != null) {
							String idText = identif.getTexto();
							if (idText != null && idText.length() != 0) {
								identVacio=false;
							}else{
								identVacio=true;
							}
						}else{
							identVacio=true;
						}
						boolean entradaLlena=false;
						if(entrada!=null && entrada.getTextos()!=null && entrada.getTextos().length>0){
							int k=0;
							
							while(k<entrada.getTextos().length && !entradaLlena){
								LangStringVO[] entradaTexto = entrada.getTextos();
								String textoEntrada=entradaTexto[k].getTexto();
								if(textoEntrada!=null && textoEntrada.length() != 0){
									entradaLlena=true;
								}
								k++;
							}
						}else{
							entradaLlena=true;
						}
						if(!entradaLlena && identVacio){
							errorMessages.add(datosResources.getString("CAV.9.2.2"));
							errorDado=false;
						}
					}else{
						errorMessages.add(datosResources.getString("CAV.9.2.2"));
						errorDado=false;
					}
				}
			}
		}
		
		if(errorMessages.size()>0)
		{
			return false;
		}else{
			return true;
		}

	}
}

class TerminoVOByIdComparator implements Comparator<TerminoVO> {

	@Override
	public int compare(TerminoVO tvoA, TerminoVO tvoB) {
		//
		// We are comparing term IDs of the form [0-9]+(.[0-9]+)* at the same
		// vocabulary term level; eg IDs for format terms run range from 4.1.1
		// to 4.1.33.  For ordering, we simply compare the leaf node numbers
		// the range for which is 1 to 33.
		//
		Integer idA = getIdInt(tvoA.getIdTermino());
		Integer idB = getIdInt(tvoB.getIdTermino());

		return idA.compareTo(idB);
	}

	private Integer getIdInt(String idStr) {
		//
		// A regex-based implementation could be a bit smaller but a few times
		// more expensive in this particular instance.  Note the frequency of
		// invocation for this method is reasonably high.
		//
		int idx = idStr.lastIndexOf(".");
		if (idx != -1) {
			return new Integer(Integer.parseInt(idStr.substring(idx + 1)));
		} else {
			return new Integer(Integer.parseInt(idStr));
		}
	}
}