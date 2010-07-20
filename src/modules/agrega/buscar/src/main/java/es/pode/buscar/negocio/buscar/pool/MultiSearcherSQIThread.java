/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.pool;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.buscar.servicios.ParamBusquedaSQIVO;
import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;
import es.pode.buscar.negocio.sqi.interfaz.SrvSQIService;
import es.pode.buscar.negocio.sqi.interfaz.SrvSQIServiceServiceLocator;
import es.pode.buscar.negocio.sqi.lenguajes.LOMESWrapper;
import es.pode.buscar.negocio.sqi.lenguajes.LOMWrapper;
import es.pode.buscar.negocio.sqi.lenguajes.VSQLWrapper;
import es.pode.buscar.negocio.sqi.sesion.SrvSesionesService;
import es.pode.buscar.negocio.sqi.sesion.SrvSesionesServiceServiceLocator;

/**
 * A thread subclass for searching a single searchable 
 */
public class MultiSearcherSQIThread extends Thread {

	private final String LOMES = "LOM-ES";
	private final String LOM = "LOM";	
	private final String VSQL = "VSQL";
	
	private Logger logger = Logger.getLogger(this.getClass());
	private Exception ex;
	private Object result;
	private Object paramsSQI;
	private Object paramsBusqueda;
	private boolean done;
	boolean running;
	private boolean stopped;
  
	public MultiSearcherSQIThread() {
	    
	}
	 /**
	 * Método de ejecución del hilo.
	 * @param urlSQIService La URL del servicio al que se llama.
	 * @param params Parámetros necesarios para hacer la llamada
	 */
	public synchronized void execute(NodoSQIVO urlSQIService, Object params) {
        if(logger.isDebugEnabled()) logger.debug("Se ejecuta el hilo");
		this.paramsSQI = urlSQIService;
		this.paramsBusqueda = params;
		this.done = false;
        if(logger.isDebugEnabled())
            logger.debug("done false: Id: " + this.toString() + " direccion: " + ((NodoSQIVO)paramsSQI).getUrlServicio());
		if (!running) { //Si es la primera ejecución, lanza el hilo
            if(logger.isDebugEnabled())
                logger.debug("Primera vez que se ejecuta el hilo. Id: " + this.toString());
	        this.setDaemon(false);
	        this.start();
		} else { // Ya teníamos un hilo corriendo, así que lo despertamos
            if(logger.isDebugEnabled())
                logger.debug("No es la primera vez que se ejecuta el hilo notifyAll. Id: " + this.toString());
			this.notifyAll();
		}
	}
	
	private void execute() throws Exception{
//		Primero tenemos que crearnos un identificador de sesion.
		String idSession = obtenerIdentificadorSQISesion();
//		Despues tenemos que ejecutar la busqueda SQI con el identificador de sesion que hemos conseguido.
		String resultados = busquedaSQI(idSession);
//		Los resultados hay que convertirlos a un VO que se pueda entender por capas superiores.
		this.result = resultadoSQIToResultadoAgrega(resultados);
		
		
	
	}
	/**
	 * Método de ejecución del hilo.
	 */
	public void run(){
		running = true;
	    while (!stopped) { // El hilo sigue corriendo.
	    	if (done) { // We are waiting for a task now.
	    		synchronized (this) {
	    			try {
                        if(logger.isDebugEnabled())
	    				    logger.debug("Wait until we get a task to execute. Id: " + this.toString());
	    				this.wait(); //Wait until we get a task to execute.
	    			} catch (InterruptedException e) {
	    				stopped = true;
	    				logger.error("Run InterruptedException =" + ((NodoSQIVO)paramsSQI).getNombreNodo(), e);
	    			}
	            }
	         } else { //There is a task....let us execute it.
	    		try {
                    if(logger.isDebugEnabled())
	    			    logger.debug("Se ejecuta Id: " + this.toString());
	        		 execute();
	        	 } catch (Exception e) {
	        		 logger.error("#### Run exception ="+((NodoSQIVO)paramsSQI).getNombreNodo() ,e);
	        	 } finally {
	        		 reset();
	        	 }
	         }
	    }
	}
	
	/**
	 * Método para poner a null los parámetros de ejecución del hilo.
	 */
	public void reset() {
        if(logger.isDebugEnabled())
		    logger.debug("reset()");
		this.done = true;
//		this.result = null;
		this.paramsSQI = null;
		this.paramsBusqueda = null;
		this.ex = null;
	}

	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

    public Object getResult() {
    	return result;
	}
	
	  
	public Exception getException() {
		return ex;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public boolean isStopped() {
		return stopped;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	/**
	 * @return the paramsBusqueda
	 */
	public Object getParamsBusqueda() {
		return paramsBusqueda;
	}

	/**
	 * @param paramsBusqueda the paramsBusqueda to set
	 */
	public void setParamsBusqueda(Object paramsBusqueda) {
		this.paramsBusqueda = paramsBusqueda;
	}

	/**
	 * @return the paramsSQI
	 */
	public Object getParamsSQI() {
		return paramsSQI;
	}

	/**
	 * @param paramsSQI the paramsSQI to set
	 */
	public void setParamsSQI(Object paramsSQI) {
		this.paramsSQI = paramsSQI;
	}

	/*
	 * Este metodo implementa la logica de extraer un identificador de sesion utlizando el interfaz SQI
	 * */
	private String obtenerIdentificadorSQISesion() throws Exception
	{
		String idSesion = "";
//		Primero tenemos que crearnos un identificador de sesion: si hay uno configurado por defecto, lo cojemos, si no, habrá que comunicarse
//		con el servidor de sesiones para extraer uno
		NodoSQIVO nodo = (NodoSQIVO)this.getParamsSQI();
//		Tenemos un identificador de sesion valido, no llamamos al servicio de sesiones
		if (nodo.getIdentificadorSesion()!= null && !nodo.getIdentificadorSesion().equals("")) {
			if (logger.isDebugEnabled())
				logger.debug("Obteniendo identificador de sesion para nodo SQI["+nodo.getNombreNodo()+"]. Usando identificador preconfigurado["+nodo.getIdentificadorSesion()+"]");
			idSesion = nodo.getIdentificadorSesion();
		}
//		No hay identificador de sesion, tenemos que conseguir uno
		else  {
			es.pode.buscar.negocio.sqi.sesion.SrvSesionesServiceService srvSesionesService = null;
			SrvSesionesService servicio = null;
			try {
				srvSesionesService = new SrvSesionesServiceServiceLocator();
				((SrvSesionesServiceServiceLocator)srvSesionesService).setSrvSesionesServiceEndpointAddress(nodo.getGestorSesion());
				servicio = srvSesionesService.getSrvSesionesService();
				if (logger.isDebugEnabled())
					logger.debug("Obtenido el servicio de sesiones para nodo SQI["+nodo.getNombreNodo()+"] con URL["+nodo.getGestorSesion()+"]");
			} catch (RuntimeException e1) {
				logger.error("Error al crear el servicio de sesion con URL de nodo SQI["+nodo.getGestorSesion()+"]", e1);
				throw new Exception("Error al crear el servicio de sesion con URL de nodo SQI["+nodo.getGestorSesion()+"]", e1);
			}
			try {
				if((nodo.getUsuario()!=null && nodo.getUsuario().length()>0)&&(nodo.getClave()!=null &&nodo.getClave().length()>0)){
					idSesion = servicio.createSession(nodo.getUsuario(), nodo.getClave());
					if (logger.isDebugEnabled())
						logger.debug("Obteniendo identificador de sesion para nodo SQI["+nodo.getNombreNodo()+"]. Usando identificador creado["+idSesion+"]");
				}
				
			} catch (RuntimeException e) {
				logger.error("Error creando sesion con usuario["+nodo.getUsuario()+"] y clave ["+nodo.getClave()+"] en nodo SQI["+nodo.getNombreNodo()+"] con gestor sesiones["+srvSesionesService.getSrvSesionesServiceAddress()+"]");
				idSesion =null;
			}
//			Si no conseguimos id de sesion, intentamos con sesion anonima
			if (idSesion == null || idSesion.equals(""))
			{
				try {
					idSesion= servicio.createAnonymousSession();
					if(logger.isDebugEnabled())
						logger.debug("Obteniendo identificador de sesion anonima para nodo SQI["+nodo.getNombreNodo()+"]. Usando identificador creado["+idSesion+"]");
				} catch (RuntimeException e) {
					logger.error("Error creando sesion anonima en nodo SQI["+nodo.getNombreNodo()+"] con gestor sesiones["+srvSesionesService.getSrvSesionesServiceAddress()+"]");
					idSesion= null;
				}
				if (idSesion == null || idSesion.equals(""))
				{
//					Hemos fallado a la hora de conseguir una sesion
					logger.error("Error obteniendo identificador de sesion en nodo SQI["+nodo.getNombreNodo()+"] contra gestor de sesiones["+ srvSesionesService.getSrvSesionesServiceAddress()+"]. Imposible obtener identificador de sesion.");
					throw new Exception("Error obteniendo identificador de sesion en nodo SQI["+nodo.getNombreNodo()+"] contra gestor de sesiones["+ srvSesionesService.getSrvSesionesServiceAddress()+"]. Imposible obtener identificador de sesion.");
				}
			}
		}
		logger.info("Obtenida sesion["+idSesion+"] para nodo SQI["+nodo.getNombreNodo()+"]");
		return idSesion;
	}
	private String busquedaSQI(String idSession) throws Exception
	{
//		Con el identificador de sesion tenemos que configurar la consulta al repositorio con la informacion de busqueda que nos pasan.
		ParamBusquedaSQIVO params= (ParamBusquedaSQIVO)this.getParamsBusqueda();
		NodoSQIVO nodo= (NodoSQIVO)this.getParamsSQI();
		SrvSQIService servicio =null;
//		Accedemos al servicio
		es.pode.buscar.negocio.sqi.interfaz.SrvSQIServiceService srvSQIService = new SrvSQIServiceServiceLocator();
		try{
			
		    ((SrvSQIServiceServiceLocator)srvSQIService).setSrvSQIServiceEndpointAddress(((NodoSQIVO)this.getParamsSQI()).getUrlServicio());
		    servicio = srvSQIService.getSrvSQIService();
		}catch(Exception e){
			logger.error("Error al crear el servicio de sesion en la busquedaSQI  con la URL de servicio["+((NodoSQIVO)this.getParamsSQI()).getUrlServicio()+"]");
			throw new Exception("Error al crear el servicio de sesion en la busquedaSQI  con la URL de servicio["+((NodoSQIVO)this.getParamsSQI()).getUrlServicio()+"]", e);
		}
//		Configuramos los parametros de la consulta.
//        	LENGUAJE CONSULTA TODO: vigilar las excepciones que se pueden devolver
		try{
			servicio.setQueryLanguage(idSession, nodo.getLenguajeConsulta());
		}catch(Exception e){
			logger.error("Error al hacer la QueryLanguage con idSession ["+idSession+"] y con el lenguaje de consulta ["+nodo.getLenguajeConsulta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]");
			throw new Exception("Error al hacer la QueryLanguage con idSession ["+idSession+"] y con el lenguaje de consulta ["+nodo.getLenguajeConsulta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]", e);
		}
//			LENGUAJE RESPUESTA TODO: vigilar las excepciones que se pueden devolver
		try{
			servicio.setResultsFormat(idSession, nodo.getLenguajeRespuesta());
		}catch(Exception e){
			logger.error("Error al hacer el ResultsFormat con idSession ["+idSession+"] y con el lenguaje de respuesta ["+nodo.getLenguajeRespuesta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]");
			throw new Exception("Error al hacer el ResultsFormat con idSession ["+idSession+"] y con el lenguaje de respuesta ["+nodo.getLenguajeRespuesta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]", e);
		}
//			CREAMOS LA CONSULTA
		String consulta="";
		try{
			consulta = construirConsulta(params, nodo.getLenguajeConsulta());
		}catch(Exception e){
			logger.error("Error la crear la consulta con parametros ["+params+"] y con el lenguaje de consulta ["+nodo.getLenguajeConsulta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]");
			throw new Exception("Error la crear la consulta con parametros ["+params+"] y con el lenguaje de consulta ["+nodo.getLenguajeConsulta()+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]", e);
		}
//			EJECUTAMOS LA QUERY TODO: vigilar las excepciones que se pueden devolver
		String sinc="";
		try{
			sinc = servicio.synchronousQuery(idSession, consulta, new Integer(0));
//			sinc="<results><lom><general><identifier><catalog>edna</catalog><entry>edna:452836</entry></identifier><title><string>Save the Children Australia</string></title><description><string>Save the Children Australia is a member</string></description></general><technical><location>http://www.savethechildren.org.au/index.html</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:464417</entry></identifier><title><string>War Child Australia</string></title><description><string>War Child is an International Relief and Development Agency, dedicated to providing immediate, effective and sustainable aid to children affected by war in order to build peace, resolve conflict and empower future generations. War Child Australia is the Australian chapter of War Child and commenced operation in July 2002. The War Child Australia office is staffed entirely by volunteers to help keep administrative costs to a minimum. War Child Austyralia has a number of fund raising suggestions such as Bake for War Child, Read for War Child, Groove For War Child, and book selling ventures.</string></description></general><technical><location>http://www.warchild.org.au/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:170472</entry></identifier><title><string>National Network for Child Care (NNCC)</string></title><description><string>NNCC unites the exp</string></description></general><technical><location>http://www.nncc.org/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:266269</entry></identifier><title><string>Child Rights Information Network (CRIN)</string></title><description><string>CRIN is a global network of children's rights organisations striving to improve the lives of children. CRIN's website aims to be a first port of call for everyone seeking children's rights information on the Internet. The site features news and publications on children's rights, a calendar of events and a 'what's new'section and a website directory among other resources. Topics include: About child rights; Armed conflict; Child labour; Disability; Discrimination; Education; Health; HIV/AIDS; Juvenile justice; Macroeconomics; Media; Sexual exploitation; UN Special Session on Children; and Violence against children.</string></description></general><technical><location>http://www.crin.org/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:310015</entry></identifier><title><string>Global Movement for Children</string></title><description><string>The Global Movement for Children represents people and organisations around the world dedicated to promoting the rights of the child. The movement is about participation, action and accountability. The site includes information about current campaigns and projects.The Global Movement for Children is a collection of people and organisations from around the world dedicated to promoting the rights of the child. At the heart of the Global Movement for Children are the following ten imperatives relating to the many aspects of child rights protection: Leave no child out; Put children first; Care for every child; Fight HIV/AIDS; Stop harming and exploiting children; Listen to children; Educate every child; Protect children from war; Protect the Earth for Children; and Fight poverty: invest in children.</string></description></general><technical><location>http://www.gmfc.org/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:217252</entry></identifier><title><string>Child Welfa</string></title><description><string>This American site provides links to full text articles on issues related to the well being of children. Articles are organized into six categories: child abuse, foster care and adoption, welfare reform and children, child poverty and inequality, child advocacy, and values and children.</string></description></general><technical><location>http://www.childwelfare.com/kids/news.htm</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:180205</entry></identifier><title><string>National Society for the Preve</string></title><description><string>NSPCC is an organisation which will fight to obtain the citizenship of every child and justice for all children. The NSPCC exists: to prevent children suffering from significant harm as a result of ill treatment, to help protect children who are at risk from such harm, to help abused children to overcome the effects of such harm, to work to protect children from further harm. The UK's leading charity specialising in child protection and the prevention of cruelty to children since 1884. Runs the NSPCC Child Protection Helpline and over 180 child protection and family support projects; also raised over 85% of its income from donors. The NSPCC FULL STOP Campaign aims to end cruelty to children forever, working with all sectors of society to achieve this goal.</string></description></general><technical><location>http://www.nspcc.org.uk/default.html</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:712326</entry></identifier><title><string>Child friendly Australia</string></title><description><string>Child Friendly Australia is the social change initiative of the National Association for Prevention of Child Abuse and Neglect (NAPCAN); working to inspire everybody to make a positive difference to children's lives, and help create an Australia where every community that involves children in any way is child friendly. The sections of the website include: child friendly communities; children's champions; child friendly challenges; microgrants program; kids can; and a toolbox of resources. It includes the 'Children see, children do' media campaign.</string></description></general><technical><location>http://www.childfriendly.org.au/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:707685</entry></identifier><title><string>Every child needs a hero: A report tracking children's concerns and attitudes about childhood</string></title><description><string>The key objectives of this analysis were to identify the prevailing attitudes and issues of most concern to children and young people in relation to their experiences of growing up in contemporary Australia; explore the views of children and young people in relation to what they need from families and the community to assist them in their growth and development; explore the primary sources of support relied on by children and young people today; and, develop a basis for informing the evolution of public policy which seeks to further include the voices of children and young people. The study is based on a survey conducted by Quantum Market Research with a nationally representative sample of 986 children and young people aged between 10-17 years. The picture of childhood portrayed by the children in this study is concerning. The findings show that children themselves experience growing up too fast into an uncertain future that is the source of stress and worry.</string></description></general><technical><location>http://www.childhood.org.au/downloads/2006%20Every%20Child%20needs%20a%20hero%20Report.pdf</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:720461</entry></identifier><title><string>Information for families using child care: Fact sheet kit</string></title><description><string>The 'Information for families using child care' fact sheet kit aims to assist families to access the support and services required to make child care decisions. The set of fact sheets highlights the range of Australian Government services and programs available to families using child care. Fact sheets are available on: Child Care Benefit, Child Care Tax Rebate, Jobs, Education and Training (JET) Child Care fee assistance, Child Care Support program; and Child Care Access Hotline.</string></description></general><technical><location>http://www.oececc.gov.au/child_care/fact_sheets.htm</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:510676</entry></identifier><title><string>Picture of Australia's Children</string></title><description><string>A Picture of Australia's Children is the third national statistical report on the health, development and wellbeing of Australia's children aged 0-14 years. Childhood, particularly early childhood, has become a key priority for governments and non-government organisations across Australia. This is in response to emerging issues of concern for Australia's children in the context of rapid social change, as well as compelling evidence about the importance of the early years for laying the foundations for children's future competence and physical and mental wellbeing. This report has been broadened to bring together a wide variety of data, including information about individual, family and societal factors that influence the health, development and wellbeing of children. New topics include: exposure to environmental tobacco smoke, homelessness, literacy and numeracy, children as victims of violence, neighbourhood safety</string></description></general><technical><location>http://www.aihw.gov.au/publications/index.cfm/title/10127</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:313615</entry></identifier><title><string>Child Support Agency Australia</string></title><description><string>The official site of the Child Support Agency Australia. CSA provides information to help parents manage their financial child support responsibilities following separation or divorce. The CSA is part of the Commonwealth Department of Family and Community Services.</string></description></general><technical><location>http://www.csa.gov.au/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:712322</entry></identifier><title><string>Differential parenting of children from diverse cultural backgrounds attending child care</string></title><description><string>This research paper examines the differential parenting of children from culturally and linguistically diverse (CALD) backgrounds attending child care. The paper used data from the Child Care in Cultural Context (CCICC) study of children from Anglo, Somali and Vietnamese cultural backgrounds and found that children from CALD backgrounds who are looked after by a carer from a different cultural background may encounter competing and potentially confusing expectations and responses in day care. It is suggested that carers take the necessary steps to understand children's home environments so that new and potentially conflicting day care experiences can be acknowledged and addressed.</string></description></general><technical><location>http://www.aifs.gov.au/institute/pubs/rp39/rp39.html</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:378074</entry></identifier><title><string>America's Children</string></title><description><string>The Federal Interagency Forum on Child and Family Statistics has released its sixth annual report on the status and well being of America's children. The 2002 edition contains 24 key indicators divided into five categories -- population and family characteristics, economic security, health, beha</string></description></general><technical><location>http://childstats.gov/americaschildren/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:310615</entry></identifier><title><string>Australian Institute of Family Studies (AIFS) - National Child Protection Clearinghouse</string></title><description><string>The mission of the National Child Protection Clearinghouse is to support target groups by providing relevant information and a network of people committed to creating better opportunities for children through child abuse prevention. The clearinghouse operates from the library of the Australian Institute of Family Studies. A bibliographic database and a project database can be accessed from the site. The Clearinghouse publishes The Child Abuse Preventation Newsletter (online). A selection of publications, reports, bibliographies are also available online. The Clearinghouse is funded by the Commonwealth Department of Family and Community Services under the auspices of the National Child Protection Council as part of the Natio</string></description></general><technical><location>http://www.aifs.gov.au/nch/nch_menu.html</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:278350</entry></identifier><title><string>The Children's Partnership</string></title><description><string>The Children's Partnership is a US-based national nonprofit, nonpartisan organization whose mission is to inform leaders and the public about the needs of America's 70 million children, and to engage them in ways that benefit children. The Partnership undertakes research and policy analysis, publishes reports and multimedia materials, and forges new alliances among parents, policymakers and the private sector to achieve tangible gains for children. The Partnership focuses particular attention on identifying new trends and emerging issues that will affect large numbers of America's children and on providing early analysis and strategies for action. In this way, it functions as a research and development (R</string></description></general><technical><location>http://www.childrenspartnership.org//AM/Template.cfm?Section=Home</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:718002</entry></identifier><title><string>Report on Government Services 2008: Children's services</string></title><description><string>Children's services aim to meet the care, education and development needs of children. In this chapter of the Report on Government Services 2008 child care services are those that are provided to children aged less than 13 years (0-12 years), usually by someone other than the child's parents or guardian. Preschool services are the services provided to children mainly in the year or two before they begin full-time schooling. To acknowledge the important links between children's services and education, this chapter has been moved into the new 'Early childhood, education and training' section of the 2008 Report. The chapter includes: a profile of children's services; a framework of performance indicators; data on performance; future directions for performance reporting; jurisdiction's comments; and definitions of key terms.</string></description></general><technical><location>http://www.pc.gov.au/__data/assets/pdf_file/0007/74644/chapter03.pdf</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:714451</entry></identifier><title><string>Costs of children: research commissioned by the Ministerial Taskforce on Child Support</string></title><description><string>The paper is a collection of three reports on the costs of children in Australian families: 'The estimated costs of children in Australian families in 2005</string></description></general><technical><location>http://www.facs.gov.au/internet/facsinternet.nsf/research/ops-ops18.htm</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:199950</entry></identifier><title><string>United Nations Children's Fund (UNICEF)</string></title><description><string>The United Nations Children's Fund (UNICEF) works for children's rights, survival, development and protection, guided by the Convention on the Rights of the Child. This site contains information about countries around the world, including recent statistics.UNICEF priorities and programmes include: Participation, HIV Prevention among young people, Adolescent Girls Project, Xpression Involving communities and families in UNICEF supported health and child development programmes, Countries in crisis, emergency assistance, funding appeals and donors. Learning lessons from field experience. The empowerment of women and girls and the pursuit of gender equality: the way to a sustainable and just society, Preventive care, health in the home and community, disease prevention. Life skills-based education for HIV/AIDS prevention, and promoting health, human rights and peace. Data on the situation of children and women, for tracking progress and focusing action. Breastfeeding, adequate food, healthy diet, vitamin and nutrient deficiencies. Bringing children's rights to the centre of public policy. For UNICEF emergency and development programmes, Procurement Services for partners. The Innocenti Research Centre studies the chan</string></description></general><technical><location>http://www.unicef.org/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:710612</entry></identifier><title><string>Before and after school care: costs and usage of formal child care s</string></title><description><string>This conference paper uses unit record data from the 1999 and 2002 Child Care Surveys conducted by the Australian Bureau of Statistics to analyse formal child care usage and cost trends for school age children under 12 years of age. Multivariate statistical techniques are used to examine factors that predict the use of formal care for school age children, and to examine the statistical significance of changes in usage patterns over time.</string></description></general><technical><location>http://www.canberra.edu.au/centres/natsem/publications?sq_content_src=%2BdXJsPWh0dHAlM0ElMkYlMkZhbmltYWwuY2FuYmVycmEuZWR1LmF1JTNBNTgwJTJGbmF0c2VtJTJGaW5kZXgucGhwJTNGbW9kZSUzRHB1YmxpY2F0aW9uJTI2cHVibGljYXRpb24lM0Q5MzgmYWxsPTE%3D</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:421375</entry></identifier><title><string>NSW Commission for Children and Young People</string></title><description><string>The New South Wales Commission for Children and Young People is concerned with the safety, welfare and well-being of children, the promotion of healthy relationships between children, families and communities and the expression of children's views</string></description></general><technical><location>http://www.kids.nsw.gov.au/</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:705472</entry></identifier><title><string>Children's Rights</string></title><description><string>Early Childhood Australia has provided a collection of resources on 'children's rights'. It includes information o</string></description></general><technical><location>http://www.earlychildhoodaustralia.org.au/childrens_rights/index.html</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:472916</entry></identifier><title><string>A Last Resort? The Report of the National Inquiry into Children in Immigration Detention</string></title><description><string>The National Inquiry into Children in Immigration Detention was announced in November 2001. It was established to consider whether Australia's immigration detention laws and its treatment of children in immigration detention comply with the United Nations Convention on the Rights of the Child. The Inquiry received substantial evidence about the treatment of children in immigration detention centres between 1999 and 2002. This Report sets out the major findings and recommendations of the Inquiry. It also analyses the various rights to which children in immigration detention are entitled to such as: safety, mental and physical health, education, recreation, religion and culture. It also assesses temporary protection visas and explains the key principles that should guide the development of new laws applying to children who arrive in Australia without a visa.</string></description></general><technical><location>http:</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:310960</entry></identifier><title><string>Abused Child Trust</string></title><description><string>The Trust aims to affirm the importance and value of children to our community and prioritise their safety and welfare, by raising funds to provide services for abused, neglected and at-risk children nationally. It also undertakes Australia wide research and provides advocacy program. Resources on the site </string></description></general><technical><location>http://www.kidsfirst.com.au/index.htm</location></technical></lom><lom><general><identifier><catalog>edna</catalog><entry>edna:310614</entry></identifier><title><string>National Association for Prevention of Child Abuse and Neglect (NAPCAN)</string></title><description><string>The National Association for Prevention of Child Abuse </string></description></general><technical><location>http://www.napcan.org.au/</location></technical></lom></results>";
		}catch(Exception e){
			logger.error("Error al ejecutar la query con idSession ["+idSession+"] y la consulta ["+consulta+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]");
			throw new Exception("Error al ejecutar la query con idSession ["+idSession+"] y la consulta ["+consulta+"] y con gestor sesiones["+srvSQIService.getSrvSQIServiceAddress()+"]", e);
		}
		return sinc;

	}
	
	/*
	 * Este metodo construye un String de consulta para el interfaz SQI con los parametros de consulta que le pasan en el lenguaje de salida que le pasan 
	 * */
	private String construirConsulta(Object params, String lenguajeConsulta) throws Exception
	{
//		Construimos la consulta (Query) a partir de los parametros de cosulta y el lenguaje de consulta.
		if (VSQL.equalsIgnoreCase(lenguajeConsulta))
			try {
				return VSQLWrapper.map(params);
			} catch (Exception e) {
				logger.error("Error generando la consulta en lenguaje VSQL con los parametros suministrados. ", e);
				throw new Exception("Error generando la consulta en lenguaje VSQL con los parametros suministrados. ",e);
			}
		else
			logger.error("Error,para ese lenguaje de consulta no esta implementado la query.");
			throw new Exception("Error,para ese lenguaje de consulta no esta implementado la query. ");//Error Lenguaje no implementado
	}
	
	/*
	 * Este metodo recoge los resultados de búsqueda del interfaz SQI y los convierte en algo entendible por la plataforma Agrega
	 * */
	private Object resultadoSQIToResultadoAgrega(String resultadosBusqueda) throws Exception
	{
//		Dependiendo del lenguaje de respuesta del nodo, tendremos que utilizar un parseador u otro. Esto puede cambiar si el nodo admite varios
//		lenguajes de respuesta ya que dependera del que hayamos elegido para la consulta.
		String lenguajeSalida = ((NodoSQIVO)this.getParamsSQI()).getLenguajeRespuesta();
		if (LOM.equalsIgnoreCase(lenguajeSalida)) { // usamos el wrapper de lom
//			Hay que extraer la respuesta del formato de respuesta del interfaz SQI
			try {
				Object[] lomWr = LOMWrapper.map(obtenerRespuestaLom(resultadosBusqueda),LOMWrapper.TRANSFORM_LOM_TO_LOMESVO);
				return lomWr;
			} catch (RuntimeException e) {
				logger.error("Error en el mapeo del Lom.");
				throw new Exception("Error en el mapeo del Lom.");//Error Lenguaje no implementado
			}
		}
		else if (LOMES.equalsIgnoreCase(lenguajeSalida)) // usamos el wrapper de lom-es
		{
			try {
				return LOMESWrapper.map(obtenerRespuestaLomEs(resultadosBusqueda),LOMESWrapper.TRANSFORM_LOMES_TO_LOMESVO);
			} catch (RuntimeException e) {
				logger.error("Error en el mapeo del Lomes.");
				throw new Exception("Error en el mapeo del Lomes.");//Error Lenguaje no implementado
			}
		}
		logger.error("Error,para ese lenguaje de respuesta el parseador no esta implementado.");
		throw new Exception("Error,para ese lenguaje de respuesta el parseador no esta implementado.");//Error Lenguaje no implementado
	}
		
	/*
	 * Este metodo rescata la respuesta cruda de una consulta SQI del texto que devuelve la propia respuesta.
	 * */
	private String obtenerRespuestaLomEs(String respuestaSQI)
	{
		return obtenerRespuestaLom(respuestaSQI);
	}
	
	/*
	 * Este metodo rescata la respuesta cruda de una consulta SQI del texto que devuelve la propia respuesta.
	 * */
	private String obtenerRespuestaLom(String respuestaSQI)
	{
		
		String stringLoms="";
		if (respuestaSQI!= null && !respuestaSQI.equals("") && respuestaSQI.length()>0){//Vamos a coger la respuesta y vamos a sacar de ella, solo lo que nos interesa, los loms
			int i=0;
			if(logger.isDebugEnabled()){
				logger.debug("La respuesta es ["+respuestaSQI+"]");
			}
			int longitud = respuestaSQI.length();
			
			while( i<longitud){
				int inicio=respuestaSQI.indexOf(LOMWrapper.INICIO_LOM);
				if(inicio>0){
					if(logger.isDebugEnabled()){
						logger.debug("Indice de <lom ["+inicio+"]");
					}
					int fin=respuestaSQI.indexOf(LOMWrapper.FIN_LOM);
					if(logger.isDebugEnabled()){
						logger.debug("Indice de </lom> ["+fin+"]");
					}
					stringLoms=stringLoms+respuestaSQI.substring(inicio, fin+LOMWrapper.FIN_LOM.length());
//					if(logger.isDebugEnabled()){
//						logger.debug("El lom ["+respuestaSQI.substring(inicio, fin+LOMWrapper.FIN_LOM.length())+"]");
//						logger.debug("El string que estamos generando ["+stringLoms+"]");
//					}
					if(fin+LOMWrapper.FIN_LOM.length()+1<respuestaSQI.length()){
						respuestaSQI=respuestaSQI.substring(fin+LOMWrapper.FIN_LOM.length());
					}else{
						respuestaSQI="";
					}
//					if(logger.isDebugEnabled()){
//						logger.debug("El string que estamos dejando ["+respuestaSQI+"]");
//					}
					if(respuestaSQI.equals("</results>")){
						i=longitud;
					}else{
						i=fin+LOMWrapper.FIN_LOM.length();
					}
				}else{
					i=longitud;
				}
			}
//			if(logger.isDebugEnabled()){
//				logger.debug("Lo que devolvemos ["+stringLoms+"]");
//			}
		}
		return stringLoms;

	}

}
