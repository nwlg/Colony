// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.federada.servicios;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.log4j.Logger;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService;

/**
 * Clase base para los test del los servicios. 
 *
 * @see AbstractTransactionalDataSourceSpringContextTests
 *
 * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService
 */
public class SrvBuscarFederadaServiceImplBase
    extends AbstractTransactionalDataSourceSpringContextTests
{

protected static Logger logger = Logger.getLogger(SrvBuscarFederadaServiceImplBase.class);
    
   /** Aqui se deben de inyectar los beans a utilizar dentro del test
    *  Inyeccion del bean del Servicio es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService
    */
    
    protected es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService servicio;
	public void setServicio(es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService servicio) {
		this.servicio = servicio;
	}
	/**
	 * Nombre de archivo que contiene el dataset de pruebas
	 */
	private String datasetFile = "SrvDataEmptyDataSet.xls";
	IDatabaseConnection connection = null;
	
    protected void onSetUpInTransaction() throws Exception {
		//	Inicializamos la conexion a base de datos
		connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
        // Inicializamos el dataset
        IDataSet dataSet =	new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
        DatabaseOperation.INSERT.execute(connection, dataSet);
    }
    
    protected void onTearDownInTransaction() {
	   	 try
		 { 
	   		// Inicializamos la conexion a base de datos
		 	connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
		 	// Inicializamos el dataset
		 	IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
		 	DatabaseOperation.DELETE.execute(connection, dataSet);
		 }
		 catch (Throwable th)
		 {
			 th.printStackTrace();
		 }
    }
    
    protected String[] getConfigLocations() {
        return new String[] { "testContext.xml" };
    }

	/**
	 * M�todo que inicializa un usuario para la autenticaci�n de la aplicaci�n.
	 * Este m�todo se utiliza en el caso de que se quiera acceder a un webservice
	 * que utiliza seguridad acegi.
	 * @param authenticationUser Nombre del usuario.
	 * @param authenticationPassword Password del usuario.
	 */
	protected void initAthenticationUser(String authenticationUser, String authenticationPassword) {
		UserDetails user = new User(authenticationUser, authenticationPassword,
				true, false, true, true, new GrantedAuthority[0]);
		Authentication currentAuth = new UsernamePasswordAuthenticationToken(
				user, null);
		SecurityContextHolder.getContext().setAuthentication(currentAuth);
	}
}