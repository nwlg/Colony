/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.empaquetador.negocio.servicio;

import java.io.File;
import java.rmi.RemoteException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.rpc.ServiceException;

import es.pode.empaquetador.negocio.externos.ScormDao;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

/**
 * @see SrvGestorArchivosServiceImpl
 */
public class TestSrvGestorArchivosServiceImpl
    extends SrvGestorArchivosServiceImplBase
{


    private static final String ODE_PRUEBAS = "CON_SUBM";
    private SrvLocalizadorService localizador = null;
    protected SCORM2004Dao scormDao = null;
   

	/**
     * Constructor
     */
     public TestSrvGestorArchivosServiceImpl(){
		super();
		try {
			SrvLocalizadorServiceService localizadorLocator = new SrvLocalizadorServiceServiceLocator();
			localizador = localizadorLocator.getSrvLocalizadorService();
		} catch (ServiceException e) {
			logger.error("No se ha podido obtener una referencia al servicio localizador. " , e);
			fail("No se ha podido obtener una referencia al servicio de localizador.");
		}
	}

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
		super.onSetUpInTransaction();
		String identificador1="SIN_SUBM";
   	 	String identificador2=ODE_PRUEBAS;
   	 	LocalizadorVO localizadorManifest1 = new LocalizadorVO();
   	 	LocalizadorVO localizadorManifest2 = new LocalizadorVO();
   	  
   	 	try 
		{
			localizadorManifest2 = this.getSrvLocalizadorService().consultaLocalizador(identificador2);
			localizadorManifest1 = this.getSrvLocalizadorService().consultaLocalizador(identificador1);
			File newDir=new File(localizadorManifest2.getPath());
			File newDir1=new File(localizadorManifest1.getPath());
			// Si no existen los directorios de test, los creamos.
			if(!newDir.exists()) newDir.mkdirs();
			if(!newDir1.exists()) newDir1.mkdirs();
			
			java.net.URL nombrefichero2=null;
			java.net.URL nombrefichero1=null;
			
			nombrefichero2 = this.getClass().getResource("/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8");
			nombrefichero1 = this.getClass().getResource("/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C9");
			
	    	File oldDir= new File(nombrefichero2.getFile());
	    	File oldDir1= new File(nombrefichero1.getFile());
	    	
	    	UtilesFicheros.copiar(oldDir, newDir);
	    	UtilesFicheros.copiar(oldDir1, newDir1);
	    	
			localizadorManifest2 = this.getSrvLocalizadorService().consultaLocalizador(identificador2);
		} 
		catch (RemoteException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OdeVO manifestConSubm=this.servicioManifest.editarODE(identificador2);

		// Inyecto un SCORM2004Dao para parseos

		scormDao = (ScormDao)applicationContext.getBean("ScormDao");

	}

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
	 	
    	 super.onTearDownInTransaction();
    	 this.servicioManifest.descargarManifest("CON_SUBM");
    	//BORRAMOS LA CARPETA test_empaquetador CREADA EN EL ONSETUP
    	 File borrar=new File("test_empaquetador");
    	 
    	 try {
			UtilesFicheros.eliminar(borrar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
	

    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		String prueba = null;
		assertNull(prueba);
	}
	
	
    /**
     *   TEST crearCarpeta
     *   TODO: Implementar el test para el metodo crearCarpeta del servicio SrvGestorArchivosService.
     */
     
     
     
     //FUNCIONA si la carpetaPadre es "", si es null, o si existe
     //FUNCIONA si nombreCarpeta es ""
     public void testcrearCarpeta () throws java.lang.Exception 
     {
    	 
    	 String nombreCarpeta="Hijo";
    	 String identificador="CON_SUBM";
    	 String carpetaPadre = "contenido";
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();
    	 
    	 try 
    	 {
    		 servicio.crearCarpeta(identificador, carpetaPadre, nombreCarpeta);
    		 
    		 if (carpetaPadre!="" && carpetaPadre != null)
        	 {
        		 path=path+"/"+carpetaPadre;
        	 }

        	 File nombreCarpeta1=new File(path,nombreCarpeta);

        	 assertTrue(nombreCarpeta1.exists());
    		 
    	 } 
    	 catch (Exception e) 
    	 {
    		
    		 assertTrue(e.getCause().getMessage().equals("La carpeta no tiene nombre"));
    		   		
    	 }
     }

  

    /**
     *   TEST crearArchivo
     *   TODO: Implementar el test para el metodo crearArchivo del servicio SrvGestorArchivosService.
     */
     
     //FUNCIONA si la carpetaPadre existe y el fichero tambien
     //FUNCIONA si la carpetaPadre es null o si es "" y el fichero tambien
     public void testcrearArchivo() throws java.lang.Exception
     {

    	 String identificador="CON_SUBM";
    	 String carpetaPadre = "contenido";
    	 String recur= "inicio.htm";
    	 java.net.URL nombreFichero=null;
    	 try 
    	 {		
    		 nombreFichero = this.getClass().getResource("/"+recur);
    	 } 
    	 catch (Exception e1)  
    	 {
    		 // TODO Auto-generated catch block
    		 e1.printStackTrace();
    	 }
    	 
    	 
    	 File fArchivo= new File(nombreFichero.getFile());
    	 DataSource source = new FileDataSource(fArchivo);
    	 DataHandler dh = new DataHandler(source);

    	 FicheroVO fich = new FicheroVO();	
    	 fich.setDatos(dh);
    	 fich.setNombre(fArchivo.getName());
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();

    	 try 
    	 {
    		 servicio.crearArchivo(identificador, carpetaPadre, fich);
    		 
    		 if (carpetaPadre!="" && carpetaPadre!=null)
        	 {
        		 path=path+carpetaPadre;
        	 }

        	 File pruebaFich=new File(path);

        	 assertTrue(pruebaFich.exists());

    	 }
    	 catch (Exception e) 
    	 {
//    		 TODO Auto-generated catch block
    		 e.printStackTrace();
    		 fail("Error al crear el archivo");
    	 }
     }

    /**
     *   TEST renombrar
     *   TODO: Implementar el test para el metodo renombrar del servicio SrvGestorArchivosService.
     * @throws Exception 
     * @throws RemoteException 
     */
     
     //renombra ficheros y carpetas
     //FUNCIONA si la carpeta padre existe y queremos renombrar un fichero o carpeta
     //FUNCIONA si la carpeta origen es ""
     //FUNCIONA si la carpeta padre es "", o si es null y nombreCarpeta existe en raiz
     //FUNCIONA si padre es null y el origen no existe
     
     public void testrenombrar() throws java.lang.Exception
     {
    	 
    	 String nombreCarpeta="coche";
    	 String identificador="CON_SUBM";
    	 String carpetaPadre = null;
    	 String nuevoNombre="CarpetaRenombrada";
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();
    	 
    	 
    	 try 
    	 {
    		 servicio.renombrar(identificador, carpetaPadre, nombreCarpeta, nuevoNombre);
    		 if (carpetaPadre!="" && carpetaPadre!=null)
        	 {
        		 path=path+"/"+carpetaPadre;
        	 }

        	 File nombreCarpeta1=new File(path,nuevoNombre);

        	 assertTrue(nombreCarpeta1.exists());
    	 } 
    	 catch (Exception e) 
    	 {
//    		 assertTrue(e.getCause().getMessage().equals("No existe el origen"));
    		 assertTrue(e.getCause().getMessage().equals("El directorio / fichero que se desea renombrar no existe"));
    		 //assertTrue(e.getCause().getMessage().equals("No existe la carpetaPadre"));
    	 }

    }

    /**
     *   TEST descomprimirArchivo
     *   TODO: Implementar el test para el metodo descomprimirArchivo del servicio SrvGestorArchivosService.
     */
     //si la carpeta padre es "" lo descomprime en el directorio raiz
     //FUNCIONA si el fichero es un zip
     //FUNCIONA si el archivo que pasamos no es un zip
     public void testdescomprimirArchivo()throws java.lang.Exception
     {
    	 String identificador="SIN_SUBM";
    	 String carpetaPadre=null;
    	 String fich1="recurso_ejemplo.zip";
    	 java.net.URL nombrefichero=null;
    	 
    	 try 
    	 {		
    		 nombrefichero = this.getClass().getResource("/"+fich1);
    	 } 
    	 catch (Exception e1) 
    	 {
    		 logger.error(e1);
    		 fail(e1.getMessage());
    	 }
    	 FicheroVO fichero1 = new FicheroVO();
    	 File fArchivo = new File(nombrefichero.getFile());
    	  	
    	 DataSource source = new FileDataSource(fArchivo);
    	
    	 DataHandler dh = new DataHandler(source);
    	

    	 fichero1.setDatos(dh);
    	 fichero1.setNombre(fArchivo.getName());

    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath().concat("/").concat(fichero1.getNombre());
    	 fichero1.setRuta(path);
    
		 servicio.descomprimirArchivo(identificador, carpetaPadre,fichero1);
		 
		 File ficheroFile = new File(path,"RES-928143bd-1d8b-30dc-a2ac-5f002be29f33");
		 File ficheroFile2 = new File(path,"imsmanifest.xml");
	     assertTrue(ficheroFile.exists());
	     assertTrue(ficheroFile2.exists());
	     
	     // Pruebo a descomprimir otra vez para ver que crea una nueva carpeta con sufijo _1
	     servicio.descomprimirArchivo(identificador, carpetaPadre,fichero1);
	     path = path.concat("_1");
	     ficheroFile = new File(path,"RES-928143bd-1d8b-30dc-a2ac-5f002be29f33");
		 ficheroFile2 = new File(path,"imsmanifest.xml");
	     assertTrue(ficheroFile.exists());
	     assertTrue(ficheroFile2.exists());
    }

    /**
     *   TEST eliminar
     *   TODO: Implementar el test para el metodo eliminar del servicio SrvGestorArchivosService.
     * @throws EliminarException 
     * @throws RemoteException 
     * @throws ServiceException 
     */
     
     //Se ha probado con 2ficheros
     //se ha probado con 2ficheros y una carpeta vacia
     //Actualmente está probando:2ficheros y una carpeta(carpeta) con un fichero dentro(prueba2.htm)
     //FUNCIONA
     public void testeliminar()throws java.lang.Exception  
     {
    	 String identificador = "CON_SUBM";
    	 String fich1="inicio.htm";
    	 String carpetaPadre="contenido";
    	 java.net.URL nombrefichero=null;
    	 
    	 try 
    	 {		
    		 nombrefichero = this.getClass().getResource("/"+fich1);
    	 } 
    	 catch (Exception e1)  
    	 {
    		 // TODO Auto-generated catch block
    		 e1.printStackTrace();
    	 }
    	 FicheroVO fichero1 = new FicheroVO();
    	 File fArchivo = new File(nombrefichero.getFile());
    	  	
    	 DataSource source = new FileDataSource(fArchivo);
    	
    	 DataHandler dh = new DataHandler(source);
    	

    	 fichero1.setDatos(dh);
    	 fichero1.setNombre(fArchivo.getName());

    	 ArchivoVO arch1=new ArchivoVO();
    	 ArchivoVO[] archivos=new ArchivoVO[1];
    	 servicio.crearArchivo(identificador, carpetaPadre, fichero1);

    	 Boolean esFichero = null;
    	 arch1.setCarpetaPadre(carpetaPadre);
		 arch1.setEsFichero(Boolean.FALSE);
		 arch1.setNombre(fichero1.getNombre());
		 
		 archivos[0]=arch1;
    	 
    	 servicio.eliminar(identificador, archivos);
    	
    	 //compruebo que se ha eliminado
       	 LocalizadorVO localizador =new SrvLocalizadorServiceServiceLocator().getSrvLocalizadorService().consultaLocalizador(identificador);
	     String path= localizador.getPath();
	     if (carpetaPadre.equals(null))
	     	{
	    		path = localizador.getPath();
	    	}
	        else
	    	{
	    		path = localizador.getPath().concat("/"+carpetaPadre);
	    	}
	     	
	     File ficheroFile = new File(path,arch1.getNombre());
	     assertFalse(ficheroFile.exists());
    	 
    }

    /**
     *   TEST listar
     *   TODO: Implementar el test para el metodo listar del servicio SrvGestorArchivosService.
     * @throws ServiceException 
     * @throws RemoteException 
     */
     
     //FUNCIONA
     public void testlistar()
     {
    	 try {
	    	 String identificador="CON_SUBM";
	    	 String carpetaPadre = null;
	    	 
			//listamos
			
	         ArchivoVO[] ficheros=servicio.listar(identificador, carpetaPadre);
				
	
		     Boolean fichero = null;
		     assertTrue(ficheros.length==28);
		     assertTrue(ficheros[0].getEsFichero()==Boolean.TRUE);
		     assertTrue(ficheros[1].getNombre().equals("adlnav_v1p3.xsd"));
		     assertTrue(ficheros[1].getEsProtegido().booleanValue());
		     assertTrue(ficheros[27].getEsFichero()==Boolean.TRUE);
		     // Assert de contenidos
		     for(int i=0;i<ficheros.length;i++) {
		    	 if("common".equals(ficheros[i].getNombre())) {
		    		assertEquals("La carpeta common no tiene hijos",7, ficheros[i].getContenidos().length); 
		    	 }
		     }
	     }catch(Exception e) {
	    	 logger.error(e);
	    	 fail(e.getMessage());
	     }
     }

    /**
     *   TEST copiar
     *   TODO: Implementar el test para el metodo copiar del servicio SrvGestorArchivosService.
     * @throws AlmacenamientoException 
     * @throws ServiceException 
     * @throws RemoteException 
     */
     
     // si la carpeta destino existe se copia en ella
     //se ha probado si la carpeta destino no existe lanza una excepción
     //se ha comprobado si destino="", entonces se crea en el directorio padre
     //FUNCIONA
     public void testcopiar()
     {
		
    	 String identificador="CON_SUBM";
    	 String carpetaDestino="";
    	 //String carpetaDestino="Prueba";
    	 //String carpetaDestino="extend";
    	 
    	 String fich1="inicio.htm";
    	 String carpetaPadre="contenido";
    	 java.net.URL nombrefichero=null;
    	 
    	 try 
    	 {		
    		 nombrefichero = this.getClass().getResource("/"+fich1);
    	 } 
    	 catch (Exception e1)  
    	 {
    		 // TODO Auto-generated catch block
    		 e1.printStackTrace();
    	 }
    	 FicheroVO fichero1 = new FicheroVO();
    	 File fArchivo = new File(nombrefichero.getFile());
    	  	
    	 DataSource source = new FileDataSource(fArchivo);
    	
    	 DataHandler dh = new DataHandler(source);
    	

    	 fichero1.setDatos(dh);
    	 fichero1.setNombre(fArchivo.getName());

    	 ArchivoVO arch1=new ArchivoVO();
    	 ArchivoVO[] archivos=new ArchivoVO[1];
    	 try {
    		 servicio.crearArchivo(identificador, carpetaPadre, fichero1);
    	 } catch (SobreescrituraException e) {
    		 fail(e.getMessage());
    	 }
    	 
    	 Boolean esFichero = null;
    	 arch1.setCarpetaPadre(carpetaPadre);
		 arch1.setEsFichero(Boolean.FALSE);
		 arch1.setNombre(fichero1.getNombre());
		 
		 archivos[0]=arch1;
    	 
    	
		 
    	 try 
    	 {
    		 servicio.copiar(identificador, carpetaDestino, archivos);
        	 
    		 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
        	 String path=loc.getPath();
    		 File directorio=new File(path,carpetaDestino);
    		 
    		 assertTrue(directorio.exists());
    		 //assertTrue(directorio.listFiles().length==3);
    		 assertTrue(directorio.listFiles().length==29);
    	 } 
    	 catch (Exception e) 
    	 {
    		 assertTrue(e.getCause().getMessage().equals("No existe la carpeta destino"));
    		 
    	 }			
    }

    /**
     *   TEST cortar
     *   TODO: Implementar el test para el metodo cortar del servicio SrvGestorArchivosService.
     * @throws AlmacenamientoException 
     * @throws EliminarException 
     * @throws ServiceException 
     * @throws RemoteException 
     */
     
     
     //se ha probado si la carpeta destino no existe lanza una excepción
     //se ha comprobado si destino="", entonces se crea en el directorio padre
     //si la carpeta destino existe lo crea en ella
     //FUNCIONA
     public void testcortar() throws EliminarException, AlmacenamientoException, RemoteException, ServiceException 
     {
     
    	 String identificador="CON_SUBM";
    	 String carpetaDestino="";
    	 //String carpetaDestino="Prueba";
    	 //String carpetaDestino="extend";
    	 
    	 String fich1="inicio.htm";
    	 String carpetaPadre="contenido";
    	 java.net.URL nombrefichero=null;
    	 
    	 try 
    	 {		
    		 nombrefichero = this.getClass().getResource("/"+fich1);
    	 } 
    	 catch (Exception e1)  
    	 {
    		 // TODO Auto-generated catch block
    		 e1.printStackTrace();
    	 }
    	 FicheroVO fichero1 = new FicheroVO();
    	 File fArchivo = new File(nombrefichero.getFile());
    	  	
    	 DataSource source = new FileDataSource(fArchivo);
    	
    	 DataHandler dh = new DataHandler(source);
    	

    	 fichero1.setDatos(dh);
    	 fichero1.setNombre(fArchivo.getName());

    	 ArchivoVO arch1=new ArchivoVO();
    	 ArchivoVO[] archivos=new ArchivoVO[1];
    	 try {
    		 servicio.crearArchivo(identificador, carpetaPadre, fichero1);
    	 } catch (SobreescrituraException e) {
    		 fail(e.getMessage());
    	 }
    	 
    	 Boolean esFichero = null;
    	 arch1.setCarpetaPadre(carpetaPadre);
		 arch1.setEsFichero(Boolean.FALSE);
		 arch1.setNombre(fichero1.getNombre());
		 
		 archivos[0]=arch1;
    	 
    	
		 
    	 try 
    	 {
    		 servicio.cortar(identificador, carpetaDestino, archivos);
        	 
    		 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
        	 String path=loc.getPath();
    		 File directorio=new File(path,carpetaDestino);
    		 
    		 assertTrue(directorio.exists());
    		 //assertTrue(directorio.listFiles().length==3);
    		 assertTrue(directorio.listFiles().length==29);
    	 } 
    	 catch (Exception e) 
    	 {
    		 assertTrue(e.getCause().getMessage().equals("No existe la carpeta destino"));
    		 
    	 }			

    	 
    	 
    }

    //FUNCIONA
     public void testgenerarBackup() throws java.lang.Exception
     {
    	 
    	 String identificador="SIN_SUBM";
    	 String carpetaTemporal="../backup";
    	 
    	 servicio.generarBackup(identificador);
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();
		 		
		 File ficheroFile = new File(path+"/"+carpetaTemporal+"/"+loc.getIdentificador()+".zip");
	     		 
    	 assertTrue(ficheroFile.exists());
    	 
     }

    //FUNCIONA
     public void testeliminarBackup() throws java.lang.Exception {
    	 
    	 String identificador="CON_SUBM";
    	
    	 servicio.eliminarBackup(identificador);
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();
		
		 assertFalse(path.equals(""));
    }

    /**
     *   TEST restaurarBackup
     *   TODO: Implementar el test para el metodo restaurarBackup del servicio SrvGestorArchivosService.
     * @throws ServiceException 
     * @throws RemoteException 
     */
     
     //FUNCIONA
     public void testrestaurarBackup() throws java.lang.Exception {
    	 
    	 String identificador="CON_SUBM";
    	 String carpetaTemporal="../backup";
    	 
    	 servicio.restaurarBackup(identificador);
    	 
    	 LocalizadorVO loc=this.getSrvLocalizadorService().consultaLocalizador(identificador);
    	 String path=loc.getPath();
		
		 assertFalse(loc.getPath().equals(""));

    }

    /**
     *   TEST recuperarArbol
     *   TODO: Implementar el test para el metodo recuperarArbol del servicio SrvGestorArchivosService.
     */
     
     //FUNCIONA
     public void testrecuperarArbol() 
     {
    	 String identificador="CON_SUBM";
    	 ArchivoVO arbolRecuperado=servicio.recuperarArbol(identificador);
    	
    	 assertTrue(arbolRecuperado.getNombre().equals("CON_SUBM"));
		 assertTrue(arbolRecuperado.getContenidos().length==28);
		 assertTrue(arbolRecuperado.getContenidos()[1].getEsProtegido().booleanValue());
		
    }

     protected final es.pode.localizador.negocio.servicios.SrvLocalizadorService getSrvLocalizadorService()
     throws java.lang.Exception
 {
 	
     return localizador;
     
 }
	
	
}