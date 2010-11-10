/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.visualizador.presentacion.portada;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO;
import es.pode.fuentestaxonomicas.negocio.servicio.TerminoVO;
import es.pode.fuentestaxonomicas.negocio.servicio.VocabularioVO;
import es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO;
import es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.visualizador.presentacion.noticia.NoticiaCodex;
import java.util.Hashtable;
import java.util.StringTokenizer;


/**
 * @see es.pode.visualizador.presentacion.portada.PortadaController
 */
public class PortadaControllerImpl extends PortadaController {

	private java.util.Properties pSpringProperties = null;
	private static Logger logger = Logger.getLogger(PortadaControllerImpl.class);


        public static String FILTERFMTGROUPNAME = "filterFMTGroupName";
        public static String FILTERFMTGROUPNAME_GRP = "filterFMTGroup";
        public static String FILTERFMTGROUPNAME_FMT = "fmt";
	
	/**
	 * @see es.pode.visualizador.presentacion.portada.PortadaController#obtenerNoticias(org.apache.struts.action.ActionMapping,
	 *      es.pode.visualizador.presentacion.portada.ObtenerNoticiasForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void obtenerNoticias(ActionMapping mapping,
			es.pode.visualizador.presentacion.portada.ObtenerNoticiasForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	
		
		try {

			// I know this is really naughty putting this here, but I just
			// can't help myself :)
			loadSearchFilters(form);
			
			logger.debug("Obteniendo noticias. ");
			
			System.out.print("sesiones activas: " + SessionCounter.getActiveSessions());
			form.setUsuarios(SessionCounter.getActiveSessions());
			SrvBuscadorService srvBuscadorService = this.getSrvBuscadorService();
			ResultadosCountVO resultadosCountVO = srvBuscadorService.obtenerTotalesRepositorio();
			System.out.print("objetos: " + resultadosCountVO);
			form.setObjetos(resultadosCountVO.getDocumentosCount().intValue());

			 NoticiaTraducidaVO[]	arrayNoticias = this.getSrvNoticiasService().listarNoticiasActivasPorIdioma((String)((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
			
			for(int h=0;h<arrayNoticias.length;h++)
			{
				//sustiuimos los retorno de carro por <br> en el resumen
				arrayNoticias[h].setResumen(arrayNoticias[h].getResumen().replaceAll("\n\r", "<br/>"));
				arrayNoticias[h].setResumen(arrayNoticias[h].getResumen().replaceAll("\r\n", "<br/>"));
				arrayNoticias[h].setResumen(arrayNoticias[h].getResumen().replaceAll("\n", "<br/>"));
				arrayNoticias[h].setResumen(arrayNoticias[h].getResumen().replaceAll("\r", "<br/>"));
				
				//sustituimos @,",:,%,+,-,' por su codigo correspondiente en ASCII
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("@","&#64"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("\\\"","&#34"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll(":","&#58"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("%","&#37"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("\\+","&#43"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("-","&#45"));
				arrayNoticias[h].setTitulo(arrayNoticias[h].getTitulo().replaceAll("'","&#39"));
				
			}
			
			//Cojo solo las que debo
			int iTotal = new Integer(this.getPropertyValue("portada.noticias.total")).intValue();
			
//			NoticiaCodex[] noticiaCodex=new NoticiaCodex[arrayNoticias.length];
			NoticiaCodex[] noticiaCodex=NoticiaCodex.mapToCodexArray(arrayNoticias);
//			 Poblando la tabla con el listado de noticias
			form.setNumNoticias(iTotal);
			form.setNoticiasAsArray(noticiaCodex);
//			SrvBuscadorService srvBuscadorService = this.getSrvBuscadorService();
//			ParamDocsCountVO paramBusq = new ParamDocsCountVO();
//			paramBusq.setArbolCurricularVigente(null);
//			paramBusq.setAreaCurricular(null);
//			paramBusq.setIdiomaBusqueda(null);
//			paramBusq.setTesauros(null);
//			ResultadosCountVO resultadosCountVO = srvBuscadorService.solicitudDocsCount(paramBusq);
//			form.setObjetos(resultadosCountVO.getDocumentosCount().intValue());
//			form.setUsuarios(SessionCounter.getActiveSessions());
			logger.info("Noticias de portada obtenidas correctamente("+iTotal+").");
		} catch (Exception e) {
			logger.error("Excepcion inesperada obteniendo noticias: "+ e);
			e.printStackTrace();
			throw e;
		}
	}
	
	private void loadSearchFilters(ObtenerNoticiasForm form)
	{		
		// Load values into form backing lists ready for display
		// in the search filters
		logger.debug("Loading search filters");
	
		int i;

		try {
		
			// Subject:
			//
			// this is not easily derivable from the curriculum
			// tree and so we read the values from our local properties
			// file.
			Collection subjectFilterLabelList = new ArrayList();
			Collection subjectFilterValueList = new ArrayList();
			i = 1;
			
			while (getPropertyValue("filterSubjectName" + i) != null)
			{
				subjectFilterLabelList.add(getPropertyValue("filterSubjectName" + i));
				subjectFilterValueList.add(getPropertyValue("filterSubjectValue" + i));
				
				i++;
			}

			form.setSubjectSearchFilterLabelList(subjectFilterLabelList.toArray());
			form.setSubjectSearchFilterValueList(subjectFilterValueList.toArray());

			
			// Keystage:
			//
			// this is not easily derivable from the curriculum
			// tree and so we read the values from our local properties
			// file.
			Collection keystageFilterLabelList = new ArrayList();
			Collection keystageFilterValueList = new ArrayList();
			i = 1;
			
			while (getPropertyValue("filterKeystageName" + i) != null)
			{
				keystageFilterLabelList.add(getPropertyValue("filterKeystageName" + i));
				keystageFilterValueList.add(getPropertyValue("filterKeystageValue" + i));
				
				i++;
			}

			form.setKeystageSearchFilterLabelList(keystageFilterLabelList.toArray());
			form.setKeystageSearchFilterValueList(keystageFilterValueList.toArray());

			
			// Learning Time:
			//
			// this is a set of fixed values (see BasicPlus Cataloguer) we
			// read from the configuration file
			Collection learningTimeFilterLabelList = new ArrayList();
			Collection learningTimeFilterValueList = new ArrayList();
			i = 1;
			
			while (getPropertyValue("filterLearningTimeName" + i) != null)
			{
				learningTimeFilterLabelList.add(getPropertyValue("filterLearningTimeName" + i));
				learningTimeFilterValueList.add(getPropertyValue("filterLearningTimeValue" + i));
				
				i++;
			}			

			form.setLearningTimeSearchFilterLabelList(learningTimeFilterLabelList.toArray());
			form.setLearningTimeSearchFilterValueList(learningTimeFilterValueList.toArray());
			
			
			// End User Role:
			//
			// this we can grab from the in-built vocabularies
			Collection intendedEndUserRoleFilterLabelList = new ArrayList();
			Collection intendedEndUserRoleFilterValueList = new ArrayList();
			
			// Add the default "All" entry
			intendedEndUserRoleFilterLabelList.add(new String("All"));
			intendedEndUserRoleFilterValueList.add(new String(""));
			
			String[] l_id = { 
					getPropertyValue("filterIntendedEndUserRoleVocabulary")
					};


			VocabularioVO[] vocabulario = this
					.getSrvVocabulariosControladosService().obtenerCombos(l_id,
							"en");

        //10/11/2010    Fernando Garcia
        //              Filtering the filter,   listEndUserRolesInFilter parameter at spring_visualizadorcontenidos.properties
        //              point out which items will be included

                        String listEndUserRolesInFilter = getPropertyValue("listEndUserRolesInFilter");
                        ArrayList<String> als = new ArrayList<String>();
                        if (listEndUserRolesInFilter!=null) {
                            StringTokenizer strTkn = new StringTokenizer(listEndUserRolesInFilter,",");
                            while (strTkn.hasMoreElements()) {
                                als.add(strTkn.nextToken().trim().toLowerCase());
                            }


                        } else {
                            //if no filterIntendedEndUserRoleVocabulary, we will show all
                            als=null;
                        }


			
			for (int j = 0; j < vocabulario.length; j++)
			{
				VocabularioVO thisVocabulary = vocabulario[j];
			
                                    for (int k = 0; k < thisVocabulary.getTerminos().length; k++)
                                    {
                                        TerminoVO thisTerm = thisVocabulary.getTerminos()[k];
                                        if ( als==null || als.indexOf(thisTerm.getIdTermino().trim().toLowerCase())!=-1 ) {

                                            // Add the term text as both a label and value
                                            intendedEndUserRoleFilterLabelList.add(
                                                    thisTerm.getNomTermino()
                                                    );

                                            intendedEndUserRoleFilterValueList.add(
                                                    thisTerm.getNomTermino()
                                                    );
                                        }//if
                                    }
			}
			
			form.setIntendedEndUserRoleSearchFilterLabelList(intendedEndUserRoleFilterLabelList.toArray());
			form.setIntendedEndUserRoleSearchFilterValueList(intendedEndUserRoleFilterValueList.toArray());

        //19/10/2010    Fernando Garcia
        //              Adding a new filter for file mime types



                        
                        Hashtable<String,ArrayList<String>> fmtStructure = getFMTGroups();

                        Collection intendedFMTFilterLabelList = new ArrayList();
			Collection intendedFMTFilterValueList = new ArrayList();

			// Add the default "All" entry
			intendedFMTFilterLabelList.add(new String("All"));
			intendedFMTFilterValueList.add(new String(""));

                        int groupNumber = 1;
                        String groupName = "";
                        while(groupName!=null) {
                            groupName = getPropertyValue(FILTERFMTGROUPNAME + groupNumber);
                            if (groupName!=null) {
                                intendedFMTFilterLabelList.add(groupName);
                                intendedFMTFilterValueList.add( arrayListStr2String(fmtStructure.get(groupName)," "));
                                groupNumber++;
                            }
                        }

                        form.setIntendedFMTSearchFilterLabelList(intendedFMTFilterLabelList.toArray());
                        form.setIntendedFMTSearchFilterValueList(intendedFMTFilterValueList.toArray());


		} catch (Exception e)
		{
			logger.error("There was a problem loading search filter properties: " + e.getMessage());
		}
			
		logger.debug("Done loading search filters");
	}
	
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_visualizadorcontenidos.properties");
		if (this.pSpringProperties == null)
		{
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

	public void obtenerCategoria(ActionMapping mapping, ObtenerCategoriaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			logger.debug("Obteniendo categoria. ");
		if (form.getIdCategoria()!=null) {
			form.setIdCategoria(form.getIdCategoria());
			logger.info("Categoria obtenida correctamente");
		}
		} catch (Exception e) {
			logger.error("Excepcion inesperada obteniendo categoria: "+ e);
			e.printStackTrace();
			throw e;
		}
	}


        //19/10/2010    Fernando Garcia
        //              Adding a new filter for file mime types

        /**
         * Read all properties in spring_visualizadorcontenidos.properties needed to fill a java structure (hashtable)
         * with this information
         * @return
         */
        public Hashtable<String,ArrayList<String>> getFMTGroups(){

            Hashtable<String,ArrayList<String>> result = new Hashtable<String,ArrayList<String>>();

            try {
                int groupNumber = 1;
                String groupName = "";
                while (groupName!=null) {
                    groupName = getPropertyValue(FILTERFMTGROUPNAME + groupNumber);
                    if (groupName!=null) {

                        int fmtNumber = 1;
                        ArrayList<String> aFilemimetypes = new ArrayList<String>();
                        String filemimetype ="";

                        while (filemimetype!=null) {
                            filemimetype = getPropertyValue(FILTERFMTGROUPNAME_GRP + groupNumber +"." +
                                FILTERFMTGROUPNAME_FMT + fmtNumber);
                            if (filemimetype!=null) {
                                aFilemimetypes.add(filemimetype);
                                fmtNumber++;
                            }
                        }
                        result.put(groupName, aFilemimetypes);
                        groupNumber++;
                    }
                }
            } catch (IOException ex) {
                java.util.logging.Logger.getLogger(PortadaControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            return result;
        }



        private String arrayListStr2String(ArrayList<String> anArrayListStrm, String separator) {

            StringBuffer strBuf = new StringBuffer("");
            for (String val : anArrayListStrm) {
                strBuf = strBuf.append(val + separator);
            }
            
            return strBuf.toString().trim();
        }

}