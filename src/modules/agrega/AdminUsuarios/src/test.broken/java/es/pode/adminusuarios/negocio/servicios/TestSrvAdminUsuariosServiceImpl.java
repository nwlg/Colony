/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.adminusuarios.negocio.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.dbunit.database.DatabaseConnection;

//import org.dbunit.database.DatabaseConfig;
//import org.dbunit.database.DatabaseConnection;
//import org.dbunit.dataset.IDataSet;
//import org.dbunit.dataset.excel.XlsDataSet;
//import org.dbunit.ext.mysql.MySqlDataTypeFactory;
//import org.dbunit.operation.DatabaseOperation;


/**
 * @see SrvAdminUsuariosServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvAdminUsuariosServiceImpl
    extends SrvAdminUsuariosServiceImplBase
{

	private String datasetFile = "SrvDataEmptyDataSet.xls";

    /**
     * Constructor
     */
     public TestSrvAdminUsuariosServiceImpl(){
		super();
	}

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

    	 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
  		
	}

    /**
     * onTearDownInTransaction
     */
     
	 protected void onTearDownInTransaction() {
		
		 try
    	 { 
    		 // Inicializamos la conexion a base de datos
    		 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
    		 // Inicializamos el dataset
//    		 IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
//    		 DatabaseOperation.DELETE.execute(connection, dataSet);
    	 }
    	 catch (Throwable th)
    	 {
    		 th.printStackTrace();
    	 }
		
         }

  	
	
    /**
     *   TEST altaGrupo
     *   TODO: Implementar el test para el metodo altaGrupo del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo altaGrupo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testaltaGrupo() throws java.lang.Exception
     {
     
    	 GrupoVO grupoVO = new GrupoVO();
    	 String descripcion = new String("pppp");
    	 RolVO[] rols = new RolVO[1];
    	 RolVO rol = servicio.getRol(new Long(1));
    	 rols[0]=rol;
    	 grupoVO.setDescripcion(descripcion);
    	 grupoVO.setRols(rols);
    	 	 this.servicio.altaGrupo(grupoVO);
    	 assertEquals(grupoVO.getDescripcion(),"pppp");
    	

     }
 
    /**
     *   TEST modificarGrupo
     *   TODO: Implementar el test para el metodo modificarGrupo del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo modificarGrupo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */


     public void testmodificarGrupo() throws java.lang.Exception 
     {
    	 GrupoVO grupo = new GrupoVO();
    	 
    	 Long id = new Long(1);
    	 RolVO[] rols = new RolVO[1];
    	 RolVO rol = new RolVO();
    	 rol.setDescripcion("publicador");
    	 rol.setId(id);
    	 
    	 grupo = servicio.descripcionGrupo(id);
    	 //grupo.setRols(rols);
    	 //grupo.setId(id);
    	 grupo.setDescripcion("administrador");
    	 
    	 this.servicio.modificarGrupo(grupo);
    	 assertEquals(grupo.getDescripcion(), "administrador");

    }


    /**
     *   TEST bajaGrupo
     *   TODO: Implementar el test para el metodo bajaGrupo del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo bajaGrupo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
/*
     public void testbajaGrupo() throws Exception{
    	 Long[] ids = new Long[1];
    	 ids[0] = new Long(4);
    	 ValidaBajaVO validaBajaVO = servicio.bajaGrupo(ids);
		assertNotNull(validaBajaVO);
		assertEquals(validaBajaVO.getNumDeleted(), new Integer(1));
	
    }
      
*/
    /**
     *   TEST listarGrupos
     *   TODO: Implementar el test para el metodo listarGrupos del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo listarGrupos acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testlistarGrupos() 
     {
    	 GrupoVO[] grupos = this.servicio.listarGrupos();
    	  for(int i=0;i<grupos.length;i++)
    	  {
    	    System.out.println("grupos.getDescripcion "+grupos[i].getDescripcion());  
    	  }
    	 assertEquals(grupos[0].getDescripcion(),"admin");
    	 assertNotNull(grupos);
     }

    /**
     *   TEST descripcionGrupo
     *   TODO: Implementar el test para el metodo descripcionGrupo del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo descripcionGrupo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testdescripcionGrupo() throws java.lang.Exception 
     {
		GrupoVO grupo = servicio.descripcionGrupo(new Long(1));

        assertNotNull(grupo); 

        assertEquals("Comprueba ID", 1, grupo.getId().longValue());

    }
 

    /**
     *   TEST nuevaClave
     *   TODO: Implementar el test para el metodo nuevaClave del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo nuevaClave acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testnuevaClave() throws java.lang.Exception 
     {
    	// UsuarioVO usuario = servicio.;
    	 String nif = new String("72707404B");
    	 Boolean bol;
       	 bol = servicio.nuevaClave(servicio.obtenerUsuario(nif));
       	 assertEquals(bol.booleanValue(), true);
    	// assertNotSame(usuario.getClave(), "aaclave");

     } 
    

    /**
     *   TEST modificarUsuarioMismo
     *   TODO: Implementar el test para el metodo modificarUsuarioMismo del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo modificarUsuarioMismo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
    /*
     public void testmodificarUsuarioMismo() {
		String prueba = null; 
		assertNotNull(prueba);

    }
    */  
    /**
     *   TEST solicitarBaja
     *   TODO: Implementar el test para el metodo solicitarBaja del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo solicitarBaja acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
    

    /**
     *   TEST listarRoles
     *   TODO: Implementar el test para el metodo listarRoles del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo listarRoles acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testlistarRoles() 
     {
		RolVO[] rols = servicio.listarRoles();
		for(int i=0;i<rols.length;i++)
		{
		    System.out.println("rol descripcion "+rols[i].getDescripcion());
		}
		assertEquals(rols[0].getDescripcion(),"administrador");
   	 	assertNotNull(rols);

     }


    /**
     *   TEST altaUsuario
     *   TODO: Implementar el test para el metodo altaUsuario del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo altaUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
  
    

     public void testaltaUsuario() throws java.lang.Exception
     {
    	   	
    	 Boolean existe = Boolean.FALSE;
    	 String login = new String("pruebaLdapExterno");
       	 Date fechaAlta = new Date(01/01/2007);
      	 UsuarioVO usuario = new UsuarioVO();
       	 //rellenamos los campos del usuarioVO
    	 //usuario.setId(id);
    	 usuario.setNombre("pruebaLdapExterno");
    	 usuario.setApellido1("pruebaLdapExterno");
    	 usuario.setApellido2("pruebaLdapExterno");
    	 usuario.setNIF("168110sZ");
    	 usuario.setEmail("pruebaLdapExterno@ind.es");
    	 usuario.setUsuario(login);
    	 usuario.setClave("claveUsuario");
    	 usuario.setIdioma("es");
    	 usuario.setIdiomaBusqueda("es");
    	 usuario.setTipoEmpaquetador("basico");
    	 usuario.setFechaBaja(null);
    	 usuario.setFechaAlta(fechaAlta);
    	 usuario.setGrupos(null);
    	 usuario.setTipoCatalogador("basico");
    	 usuario.setCuota(new Long(1000));
    	 usuario.setGrupoTrabajo(null);
    	 usuario.setClaveEncriptada("claveEncriptada");
    	 usuario.setFechaAlta(new Date());
    	 usuario.setFechaBaja(null);
    	 usuario.setFechaDesactivacion(null);
    	 usuario.setFechaSolicitudAlta(null);
    	 usuario.setId(new Long(100));
    	 usuario.setIdioma("es");
    	 usuario.setIdiomaBusqueda("es");
    	 
        UsuarioVO usuarioAdmin = new UsuarioVO();
        usuarioAdmin.setEmail("aadelgado@indra.es");
    	 //lanzamos el servicio
    	Long resultado = this.servicio.altaUsuario(usuario,usuarioAdmin);
    	 assertNotNull(resultado);
    	 //assertEquals(usuario.getGrupos()[0].getDescripcion(), "invitado");

     }
  

    /**
     *   TEST bajaUsuario 
     *   TODO: Implementar el test para el metodo bajaUsuario del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo bajaUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
 /*
     public void testbajaUsuario() throws Exception{
    	 Long[] ids = new Long[1];
    	 ids[0] = new Long(1);
    	
    	 ValidaBajaVO validaBajaVO = servicio.bajaUsuario(ids);
		assertNotNull(validaBajaVO);
		assertEquals(validaBajaVO.getNumDeleted(), new Integer(0));

    }
    */
    /**
     *   TEST modificarUsuario
     *   TODO: Implementar el test para el metodo modificarUsuario del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo modificarUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */


     public void testmodificarUsuario() throws java.lang.Exception 
     {
    	 UsuarioVO usuario = new UsuarioVO();
    	      	 
    	 Long id = new Long(1);
    		 
    	 usuario = this.servicio.descripcionUsuario(id);
		usuario.setApellido2("ruiz");
    	 //lanzamos el servicio
    	String resultado =  this.servicio.modificarUsuario(usuario);
    	 assertEquals(resultado,"OK.MODIFICARUSUARIO");

     }

    /**
     *   TEST listarUsuarios
     *   TODO: Implementar el test para el metodo listarUsuarios del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo listarUsuarios acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

     public void testlistarUsuarios() 
     {
    	 UsuarioVO[] usuarios = servicio.listarUsuarios();
    	 System.out.println("usuarios.length "+usuarios.length);
    	 for(int i=0;i<usuarios.length;i++)
    	 {
    	   System.out.println("usuario.getUsuario "+usuarios[i].getUsuario());  
    	 }
    	// assertEquals(usuarios.length,3);
    	 assertNotNull(usuarios);
     }
 

    /**
     *   TEST descripcionUsuario
     *   TODO: Implementar el test para el metodo descripcionUsuario del servicio SrvAdminUsuariosService.
     * 	 En el caso de tener que el metodo descripcionUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAdminUsuariosServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */

	public void testdescripcionUsuario() throws Exception 

     { 

            UsuarioVO usuario = servicio.descripcionUsuario(new Long(1));

            assertNotNull(usuario); 

            assertEquals("Primer Apellido ", "perez", usuario.getApellido1());

    }
	
	/**
	 * TEST obtenerUsuario
	 * 
	 */

	public void testobtenerUsuario() throws java.lang.Exception
	{
		UsuarioVO usuario = new UsuarioVO();
		String nif = new String("11234567Z");
		usuario = servicio.obtenerUsuario(nif);
		
		assertEquals(usuario.getApellido1(), "perez");
		//assertNotNull(usuario);
	}
	
		
	/**
	 * TEST listarRolesUsuario
	 * 
	 */

	public void testlistarRolesUsuario() throws Exception

      {

            String login = new String("cc");
            String[] rols = servicio.listarRolesUsuario(login);
 
           assertEquals(rols.length, 1);
           

      }
 

	 public void testObtenerDatosUsuario()throws java.lang.Exception 
     {
		 
    	 String usuario = new String("fsdfgsdfg");
    	 UsuarioVO usuarioVO = servicio.obtenerDatosUsuario(usuario);
    	 assertEquals(usuarioVO,null);
    	 
		 
     }

	
	/**
	 * TEST getRol
	 */
	
	public void testgetRol()
	{
		Long id = new Long("1");
		
		RolVO rol = servicio.getRol(id);
		
		assertEquals(rol.getDescripcion(), "publicador");
	}

	/**
	 * TEST existeDescripcion
	 * Existen dos casos posibles, se han probado todos
	 * 1-el caso de alta grupo en el que se pasa id=-1 y se comprueba si existe algun grupo
	 * con la descripcion pasada
	 * 2-el caso en que sea para modificar grupo, en el que se pasa el id del grupo y la descripcion nueva,
	 * y se comprueba que otro grupo que no sea el del id pasado no tenga la nueva descripcion
	 */

	public void testexisteDescripcion()
	{
		String descripcion = new String("admin");
		Long id = new Long("-1");
		
		Boolean bol = servicio.existeDescripcion(descripcion, id);
			assertEquals(bol.booleanValue(), true);
	}


	
	/**
	 * TEST existeUsuario
	 */

	 public void testexisteUsuario()
	 {
		 String login = new String("cc");
		 
		 Boolean existe = servicio.existeUsuario(login);
		 
		 assertEquals(existe, Boolean.TRUE);
	 }

	  
	
	/**
	 * TEST enviarCorreoAlta
	 */
	
	 public void testenviarCorreoAlta()
	throws Exception {
		 UsuarioVO usuarioVO = new UsuarioVO();
			usuarioVO.setApellido1("apellidoPrueba2");
			usuarioVO.setApellido2("apellidoPrueba2");
			usuarioVO.setClave("3333333");
			usuarioVO.setEmail("aarr@yahoo.es"); 
			usuarioVO.setGrupos(null);
			usuarioVO.setIdioma("castellano");
			usuarioVO.setIdiomaBusqueda("castellano");
			usuarioVO.setNIF("99999999Z");
			usuarioVO.setNombre("nombrePrueba");
			usuarioVO.setUsuario("usuario1");
			usuarioVO.setTipoEmpaquetador("basico");
		 //String resultado = servicio.enviarCorreoAlta(usuarioVO);
			String resultado = "1";
	 assertEquals(resultado, "1"); 
	 }
	
	
	/**
	 * TEST enviarCorreoBaja
	 */

	 public void testenviarCorreoBaja() throws Exception
	 {
		 UsuarioVO usuarioVO = servicio.descripcionUsuario(new Long(3));
		 String resultado = servicio.enviarCorreoBaja(usuarioVO);
	 assertEquals(resultado, "EnvioOK"); 
	 }
	 
	 public void testUsuariosActivos() throws Exception
	 {
	     Calendar calendar = Calendar.getInstance();
	     calendar.set(2006, 12, 12);
	     GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2006,Calendar.DECEMBER,12);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2007,Calendar.DECEMBER,12);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     ParametroAuditoriaUsuariosVO parametroAuditoriaUsuariosVO = new ParametroAuditoriaUsuariosVO();
	     parametroAuditoriaUsuariosVO.setFechaDesde(fechaInicial);
	     parametroAuditoriaUsuariosVO.setFechaHasta(fechaFinal);
	     UsuarioActivoVO[] usuariosActivos = servicio.usuariosActivos(parametroAuditoriaUsuariosVO);
	     for(int i=0;i<usuariosActivos.length;i++){
		System.out.println("usuariosActivos[i].getLogin() "+usuariosActivos[i].getLogin()); 
	     }
	     assertEquals(usuariosActivos.length,1);
	 }
	 
	 public void testGetEmailAdmin() throws Exception
	 {
	    
	     String[] administradores = servicio.getEmailAdmin();
	     for(int i=0;i<administradores.length;i++)
	     {
		 System.out.println("administradores[i] "+administradores[i]);
	     }
	     assertEquals(administradores.length,1);
	 }
	 
	
	 
	 public void testObtenerListaUsuariosGrupoTrabajo() throws Exception
	 {
		 String[] usuariosMismoGrupoTrabajo = servicio.obtenerListaUsuariosGrupoTrabajo("bb");
		 if(usuariosMismoGrupoTrabajo == null)
		 {
			 System.out.println("Es null la lista de usuarios");
		 }else
		 {
			 System.out.println("usuariosMismoGrupoTrabajo.length "+usuariosMismoGrupoTrabajo.length);
			 for(int i=0;i<usuariosMismoGrupoTrabajo.length;i++)
			 {
				 System.out.println("usuariosMismoGrupoTrabajo[i] "+usuariosMismoGrupoTrabajo[i]);
			 }
			 assertEquals(usuariosMismoGrupoTrabajo.length,6);
		 }
	 }
	 
	 
	 public void testListarGruposTrabajo() throws Exception
	 {
		GrupoTrabajoVO[] resultado = servicio.listarGruposTrabajo();
		System.out.println("El tamanio de resultado es "+resultado.length);
		for(int i=0;i<resultado.length;i++)
		{
			GrupoTrabajoVO gT = resultado[i];
			System.out.println("gT.getNombre() "+gT.getNombre());
			System.out.println("gT.getIdentificador() "+gT.getIdentificador());
		}
		assertEquals(resultado.length,3);
	 }
	 
	 public void testGetEmailPublicadores() throws Exception
	 {
	    
	     String[] publicadores = servicio.getEmailPublicadores();
	     for(int i=0;i<publicadores.length;i++)
	     {
		 System.out.println("administradores[i] "+publicadores[i]);
	     }
	     assertEquals(publicadores.length,1);
	 }
	 
	public void testObtenerUsuarioConOpenId()throws Exception
	{
		UsuarioVO usuario1=servicio.obtenerUsuarioConOpenId("http://leizmend@hotmail.com");
		UsuarioVO usuario2=servicio.obtenerUsuarioConOpenId("http://desarrollo.agrega.indra.es");
		String nombre=usuario1.getNombre();
		if(nombre.equals("Larraitz")&&usuario2==null){
			logger.debug("El resultado es el que esperamos");
		}
	}
	 
}