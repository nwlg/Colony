/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.noticias.servicio;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 * @see SrvNoticiasServiceImpl TODO: To execute test on services that invoke
 *      webservices which implement security, you must include the next param to
 *      the java virtual machine: -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvNoticiasServiceImpl extends SrvNoticiasServiceImplBase 
{

	/**
	 * Constructor
	 */
	public TestSrvNoticiasServiceImpl() 
	{
		super();
	}

	

	/**
	 * testInicial TODO: Agregar las pruebas unitarias que correspondan al
	 * servicio, siguiendo un patron de nombrado como public void test<nombreTest>().
	 * En el caso de tener que el metodo ${operation.name} acceda a un
	 * webservice el cuál implementa seguridad (se necesita la autenticación de
	 * usuario), antes de invocarlo en el test, se debe establecer un usuario
	 * con derechos de acceso utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testInicial() 
	{
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder");
		assertNull(prueba);
	}

	/**
	 * TEST obtenerCategoria TODO: Implementar el test para el metodo
	 * obtenerCategoria del servicio SrvNoticiasService. En el caso de tener que
	 * el metodo obtenerCategoria acceda a un webservice el cuál implementa
	 * seguridad (se necesita la autenticación de usuario), antes de invocarlo
	 * en el test, se debe establecer un usuario con derechos de acceso
	 * utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	//FUNCIONA
	public void testobtenerCategoria() 
	{
//		Pruebo con una categoria que existe en la base de datos
		CategoriaNoticiaVO categoria = this.servicio.obtenerCategoria(new Long(1));
		assertEquals("Comprobando el id de categoria", categoria.getId(), new Long(1));
		assertEquals("Comprobando el tamanho de categoriaIdiomaNoticia", categoria.getCategoriaIdioma().length, 2);
		
//		Pruebo con una categoria que no existe en la base de datos
		CategoriaNoticiaVO categoria2 = this.servicio.obtenerCategoria(new Long(2));
		assertNull(categoria2);

	}

	public void testcrearCategoria() 
	{
		CategoriaNoticiaVO[] categorias = this.servicio.obtenerCategorias();
		CategoriaNoticiaVO categoria = new CategoriaNoticiaVO();
		CategoriaIdiomaNoticiaVO[] categoriasIdiomaArray = new CategoriaIdiomaNoticiaVO[2]; 
		CategoriaIdiomaNoticiaVO categoriaIdioma1 = new CategoriaIdiomaNoticiaVO();		
		categoriaIdioma1.setIdioma("es");
		categoriaIdioma1.setNombreCategoria("Internacional");
		categoriasIdiomaArray[0] = categoriaIdioma1;
		
		CategoriaIdiomaNoticiaVO categoriaIdioma2 = new CategoriaIdiomaNoticiaVO();
		categoriaIdioma2.setIdioma("en");
		categoriaIdioma2.setNombreCategoria("International");
		categoriasIdiomaArray[1] = categoriaIdioma2;
		
		//categoria.setCategoriaGeneral(categoriasIdiomaArray);		
		categoria.setNombre("inter");
		categoria.setCategoriaIdioma(categoriasIdiomaArray);
		
		//Llamada al servicio
		this.servicio.crearCategoria(categoria);
		categorias = this.servicio.obtenerCategorias();
		String a="a";
//		CategoriaVO categoria = new CategoriaVO();
//		categoria.setNombre("deportes");
//		categoria.setNueva(new Boolean(true));
//		
//		this.servicio.crearCategoria(categoria);
//		CategoriaVO categoria = new CategoriaVO();
//		
//		CategoriaIdiomaAltaVO[] categoriasIdiomas = new	CategoriaIdiomaAltaVO[2]; 
//		CategoriaIdiomaAltaVO categoriaIdioma = new CategoriaIdiomaAltaVO();
//		categoriaIdioma.setIdioma("ca");
//		categoriaIdioma.setNombreCategoria("Internacional");
//		categoriasIdiomas[0] = categoriaIdioma;
//		
//		CategoriaIdiomaAltaVO categoriaIdioma2 = new CategoriaIdiomaAltaVO();
//		categoriaIdioma2.setIdioma("gl");
//		categoriaIdioma2.setNombreCategoria("International");
//		categoriasIdiomas[1] = categoriaIdioma2;
//		
//		categoria.setCategoriaIdioma(categoriasIdiomas);	
//		categoria.setNombre("nombreCategoria2");
//		
//		this.servicio.crearCategoria(categoria);
		
		
	
	}
	
	public void testObtenerCategoriaIdioma()
	{
//		this.servicio.obtenerCategoriaIdioma(new Long(34));
	}
	
	public void testmodificarCategoria()
	{
		
//		CategoriaModificaVO categoria = new CategoriaModificaVO();
		
//		CategoriaIdiomaModificaVO[] categoriasIdiomaArray = new CategoriaIdiomaModificaVO[2];
//		CategoriaIdiomaModificaVO[] categoriasIdiomaArray = null;
		
//		CategoriaIdiomaModificaVO categoriaIdioma = new CategoriaIdiomaModificaVO();
//		categoriaIdioma.setIdioma("cacambio23");
//		categoriaIdioma.setNombreCategoria("Internacionalcambio23");
//		categoriaIdioma.setId(new Long(28));
//		categoriasIdiomaArray[0] = categoriaIdioma;
		
//		CategoriaIdiomaModificaVO categoriaIdioma3 = new CategoriaIdiomaModificaVO();
//		categoriaIdioma3.setIdioma("glcambionuevo3222");
//		categoriaIdioma3.setNombreCategoria("Internationalcambionuevo3222");	
//		categoriaIdioma3.setId(new Long(30));
//		categoriasIdiomaArray[1] = categoriaIdioma3;
		
//		CategoriaIdiomaModificaVO categoriaIdioma2 = new CategoriaIdiomaModificaVO();
//		categoriaIdioma2.setIdioma("glcambio2322222");
//		categoriaIdioma2.setNombreCategoria("Internationalcambio23222222");
//		categoriaIdioma2.setId(new Long(29));
//		categoriasIdiomaArray[1] = categoriaIdioma2;
		
		
				
		
//		categoria.setCategoriaIdioma(categoriasIdiomaArray);	
//		categoria.setNombre("nombreCategoria2cambiosegundo322222");
//		categoria.setId(new Long(13));
//		
//		this.servicio.modificarCategoria(categoria);
	}
	
	//FUNCIONA
	public void testobtenerCategorias() 
	{
		//Existen categorias en la base de datos
		CategoriaNoticiaVO[] categorias = this.servicio.obtenerCategorias();
		assertEquals("Comprabando el numero de categorias recuperadas", categorias.length, 2);
	}
	
	public void testeliminarCategoria()
	{
//		Long id = new Long(13);
//		this.servicio.eliminarCategoria(id);
//		CategoriaListableVO[] cat = this.servicio.obtenerCategorias();
//		assertEquals("Comprueba categorias", 4, cat.length);
	}
	
	public void testeliminarCategorias()
	{
		Long[] ids = new Long[2];
		ids[0] = new Long(4);
		ids[1] = new Long(5);
		
		this.servicio.eliminarCategorias(ids);
		
	}

	/**
	 * TEST crearNoticia TODO: Implementar el test para el metodo crearNoticia
	 * del servicio SrvNoticiasService. En el caso de tener que el metodo
	 * crearNoticia acceda a un webservice el cuál implementa seguridad (se
	 * necesita la autenticación de usuario), antes de invocarlo en el test, se
	 * debe establecer un usuario con derechos de acceso utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testcrearNoticia() 
	{
		NoticiaVO noticia = new NoticiaVO();
		DescripcionNoticiaVO[] descripciones = new DescripcionNoticiaVO[3];
		DescripcionNoticiaVO descripcion1 = new DescripcionNoticiaVO();
		DescripcionNoticiaVO descripcion2 = new DescripcionNoticiaVO();
		DescripcionNoticiaVO descripcion3 = new DescripcionNoticiaVO();
		descripcion1.setCuerpo("cuerpo1");
		descripcion1.setIdioma("es");
		descripcion1.setResumen("resumen1");
		descripcion1.setTitulo("titulo1");
		descripcion2.setCuerpo("cuerpo2");
		descripcion2.setIdioma("en");
		descripcion2.setResumen("resumen2");
		descripcion2.setTitulo("titulo2");
		descripcion3.setCuerpo("cuerpo3");
		descripcion3.setIdioma("eu");
		descripcion3.setResumen("resumen3");
		descripcion3.setTitulo("titulo3");
		descripciones[0]=descripcion1;
		descripciones[1]=descripcion2;
		descripciones[2]=descripcion3;
		noticia.setActiva(new Boolean(true));
		CategoriaNoticiaVO categoria = new CategoriaNoticiaVO();
		CategoriaIdiomaNoticiaVO[] categoriasIdiomaArray = new CategoriaIdiomaNoticiaVO[2]; 
		CategoriaIdiomaNoticiaVO categoriaIdioma1 = new CategoriaIdiomaNoticiaVO();		
		categoriaIdioma1.setIdioma("es");
		categoriaIdioma1.setNombreCategoria("Inter");
		categoriasIdiomaArray[0] = categoriaIdioma1;
		
		CategoriaIdiomaNoticiaVO categoriaIdioma2 = new CategoriaIdiomaNoticiaVO();
		categoriaIdioma2.setIdioma("en");
		categoriaIdioma2.setNombreCategoria("Int");
		categoriasIdiomaArray[1] = categoriaIdioma2;
		
		//categoria.setCategoriaGeneral(categoriasIdiomaArray);		
		categoria.setNombre("nueva");
		categoria.setCategoriaIdioma(categoriasIdiomaArray);
		noticia.setCategoria(categoria);
		noticia.setDescripcionNoticia(descripciones);
		servicio.crearNoticia(noticia);
	}

	/**
	 * TEST modificarNoticia TODO: Implementar el test para el metodo
	 * modificarNoticia del servicio SrvNoticiasService. En el caso de tener que
	 * el metodo modificarNoticia acceda a un webservice el cuál implementa
	 * seguridad (se necesita la autenticación de usuario), antes de invocarlo
	 * en el test, se debe establecer un usuario con derechos de acceso
	 * utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testmodificarNoticia() 
	{
//		NoticiaListableVO[] noticias = servicio.obtenerNoticias();
//		CategoriaVO categoria = new CategoriaVO();
//		NoticiaModificaVO noticiaModificada = new NoticiaModificaVO();		
//		
//		DescripcionModificaNoticiaVO[] descripcionNoticiaArray = new DescripcionModificaNoticiaVO[2];
//		DescripcionModificaNoticiaVO descripcionNoticia = new DescripcionModificaNoticiaVO(); 
//		DescripcionModificaNoticiaVO descripcionNoticia2 = new DescripcionModificaNoticiaVO(); 
//
////		categoria.setNombre("nacional");
////		categoria.setNueva(new Boolean(true));
////		categoria.setId(new Long(4));
//		
//		noticiaModificada.setURLImagen("http://pa");		
//		noticiaModificada.setAlineamientoImg(new Integer("0"));
//		noticiaModificada.setActiva(new Boolean(true));
//		noticiaModificada.setFechaPublicacion(new Date());
//		noticiaModificada.setCategoria(categoria);			
//		noticiaModificada.setId(new Long(24));
//		
//		noticiaModificada.setCategoria(categoria);
//		
//		descripcionNoticia.setTitulo("pablocategorias1cambio");
//		descripcionNoticia.setResumen("ResumenNoticiaAlta4cambio");
//		descripcionNoticia.setCuerpo("Esto es el cuerpo de la noticiaAlta4cambio");
//		descripcionNoticia.setIdioma(Locale.getDefault().getLanguage());
//		descripcionNoticia.setId(new Long(44));			
//		descripcionNoticiaArray[0] = descripcionNoticia;
//		
//		descripcionNoticia2.setTitulo("pablocategorias2cambiocambio");
//		descripcionNoticia2.setResumen("ResumenNoticiaAlta4cambio");
//		descripcionNoticia2.setCuerpo("Esto es el cuerpo de la noticiaAlta4cambio");
//		descripcionNoticia2.setIdioma("en");
//		descripcionNoticia2.setId(new Long(45));		
//		descripcionNoticiaArray[1] = descripcionNoticia2;
//		
//		noticiaModificada.setDescripcionNoticia(descripcionNoticiaArray);
		
//		NoticiaModificaVO noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
//		NoticiaModificaVO noticiaaux=this.servicio.obtenerNoticiaModificable(new Long(2));
//		noticia.setResumen(noticia.getResumen() + " modificado");
//		noticia.getCategoria().setNueva(new Boolean(false));
//		this.servicio.modificarNoticia(noticiaModificada);
		
//		noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
//		assertFalse(noticia.equals(noticiaaux));
		
	}

	public void testmodificarNoticiaYCategoria() 
	{
//		NoticiaListableVO[] noticias = servicio.obtenerNoticias();
//		NoticiaModificaVO noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
////		CategoriaListableVO categoriaDistinta = this.servicio.obtenerCategoria(new Long(3));
//		NoticiaModificaVO noticiaaux=this.servicio.obtenerNoticiaModificable(new Long(2));
				
//		noticia.setCategoria(categoriaDistinta);
//		noticia.getCategoria().setNueva(new Boolean(false));
//		this.servicio.modificarNoticia(noticia);
//		noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
//		assertFalse(noticia.equals(noticiaaux));
//		

	}

	public void testmodificarNoticiaYCategoriaNueva() 
	{
//		NoticiaListableVO[] noticias = servicio.obtenerNoticias();
//		// Modificamos un campo de la noticia. Esto funciona por separado.
//		NoticiaModificaVO noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
//		NoticiaModificaVO noticiaaux=this.servicio.obtenerNoticiaModificable(new Long(2));
//
//		CategoriaVO categoriaNueva = new CategoriaVO();// "nueva categoria",
		// new Long(10), true
//		categoriaNueva.setId(new Long(10));
//		categoriaNueva.setNombre("nueva categoria2");
//		categoriaNueva.setNueva(new Boolean(true));
//		noticia.setCategoria(categoriaNueva);
//		this.servicio.modificarNoticia(noticia);
//		noticia = this.servicio.obtenerNoticiaModificable(new Long(2));
//		
//		assertFalse(noticia.equals(noticiaaux));

	}

	/**
	 * TEST obtenerNoticias TODO: Implementar el test para el metodo
	 * obtenerNoticias del servicio SrvNoticiasService. En el caso de tener que
	 * el metodo obtenerNoticias acceda a un webservice el cuál implementa
	 * seguridad (se necesita la autenticación de usuario), antes de invocarlo
	 * en el test, se debe establecer un usuario con derechos de acceso
	 * utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testobtenerNoticias() 
	{
//		Existen categorias en la base de datos
		NoticiaVO[] noticias = this.servicio.obtenerNoticias();		
		assertEquals("Comprabando el numero de noticias recuperadas", noticias.length, 2);
	
	}

	/**
	 * TEST obtenerNoticiaModificable TODO: Implementar el test para el metodo
	 * obtenerNoticiaModificable del servicio SrvNoticiasService. En el caso de
	 * tener que el metodo obtenerNoticiaModificable acceda a un webservice el
	 * cuál implementa seguridad (se necesita la autenticación de usuario),
	 * antes de invocarlo en el test, se debe establecer un usuario con derechos
	 * de acceso utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testobtenerNoticiaModificable() 
	{
//		NoticiaModificaVO noticiaMod=this.servicio.obtenerNoticiaModificable(new Long(2));
//		assertNotNull(noticiaMod);
	}

	/**
	 * TEST eliminarNoticia TODO: Implementar el test para el metodo
	 * eliminarNoticia del servicio SrvNoticiasService. En el caso de tener que
	 * el metodo eliminarNoticia acceda a un webservice el cuál implementa
	 * seguridad (se necesita la autenticación de usuario), antes de invocarlo
	 * en el test, se debe establecer un usuario con derechos de acceso
	 * utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testeliminarNoticia() 
	{
//		NoticiaListableVO[] noticias = servicio.obtenerNoticias();
		
		this.servicio.eliminarNoticia(new Long(25));
//		noticias = servicio.obtenerNoticias();
//		
//		/*
//		 * Como se que hay 3 noticias, si se ha borrado bien
//		 * ahora la longitud deberia ser 2
//		 */
//		assertEquals(noticias.length,2);
	
	}

	/**
	 * TEST eliminarNoticias TODO: Implementar el test para el metodo
	 * eliminarNoticias del servicio SrvNoticiasService. En el caso de tener que
	 * el metodo eliminarNoticias acceda a un webservice el cuál implementa
	 * seguridad (se necesita la autenticación de usuario), antes de invocarlo
	 * en el test, se debe establecer un usuario con derechos de acceso
	 * utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testeliminarNoticias() 
	{
//    	this.servicio.eliminarNoticias(new Long[] { new Long(29), new Long(30) });
//		NoticiaListableVO[] noticias = servicio.obtenerNoticias();
//		assertEquals(0, noticias.length);

	}

	/**
	 * TEST obtenerNoticiasPorIdioma TODO: Implementar el test para el metodo
	 * obtenerNoticiasPorIdioma del servicio SrvNoticiasService. En el caso de
	 * tener que el metodo obtenerNoticiasPorIdioma acceda a un webservice el
	 * cuál implementa seguridad (se necesita la autenticación de usuario),
	 * antes de invocarlo en el test, se debe establecer un usuario con derechos
	 * de acceso utilizando el método
	 * {@link es.indra.servicios.SrvNoticiasServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testobtenerNoticiasPorIdioma() 
	{
//		NoticiaListableVO[] lista = this.servicio.obtenerNoticiasPorIdioma("ca");
//		/*
//		 * System.out.println("Recogemos una lisata de [" + lista.length + "]
//		 * elementos.");
//		 */
//		assertEquals("Solo una noticia en catalan", 1, lista.length);
		String idioma = "es";
		System.out.print(idioma);
		
		//NoticiaVO[] noticias = this.servicio.obtenerNoticiasPorIdioma(idioma);
		String q = "d";
	}

	public void testalmacenarImagenNoticia() throws IOException
	{
		ImagenVO iImagenPrueba = new ImagenVO();
		
		java.net.URL nombrefichero = new java.net.URL(this.getClass().getResource("/invierno.jpg").toString());
				 
		//fImagen será el recurso origen
		
		File fImagen = new File(nombrefichero.getFile());
		DataSource source = new FileDataSource(fImagen);
		DataHandler dImagen = new DataHandler(source);
		/*FileInputStream fIsImagen = new FileInputStream(fImagen);
		  
		byte buffer[] = new byte[(int)fImagen.length()];
		fIsImagen.read(buffer,0,(int)fImagen.length());
		*/
		iImagenPrueba.setDatos(dImagen);
		iImagenPrueba.setNombre(fImagen.getName());
		this.servicio.almacenarImagenNoticia(iImagenPrueba);
		//crear file para comprobar que existe con assert 
		
		//primero hay que obtener la ruta:
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring.properties");
		java.util.Properties pSpringProperties = new java.util.Properties();
		pSpringProperties.load(fIsSpringProperties);
		
		//fImagenPrueba será el recurso destino
		File fImagenPrueba = new 
		  File(pSpringProperties.getProperty("noticias.imagenes.path").toString()+ fImagen.getName());
		assertEquals(true, fImagenPrueba.exists());
		//Nota: este test guarda la imagen en windows\temp
	}

	public void testObtenerNoticiasActivasPorIdioma() 
	{
		
		NoticiaTraducidaVO[] noticias = this.servicio.listarNoticiasActivasPorIdioma("es");
		String a = "a";

	}
	public void testObtenerNoticiasActivasPorCategoria() 
	{
//		CategoriaVO categoria= new CategoriaVO();
//		Boolean nueva=  new Boolean (false);
//		categoria.setId(new Long (1));
//		categoria.setNombre("PODE");


//		NoticiaListableVO[] lista = this.servicio.obtenerNoticiasActivasPorCategoria("es",categoria);
//		assertNotNull(lista);
	}
}