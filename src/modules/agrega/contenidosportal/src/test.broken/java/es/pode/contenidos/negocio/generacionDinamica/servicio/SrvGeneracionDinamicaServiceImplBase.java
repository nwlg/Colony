// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.generacionDinamica.servicio;

import org.apache.log4j.Logger;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.operation.DatabaseOperation;
import es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService;

/**
 * Clase base para los test del los servicios. 
 *
 * @see AbstractTransactionalDataSourceSpringContextTests
 *
 * @see es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService
 */
public class SrvGeneracionDinamicaServiceImplBase
    extends AbstractTransactionalDataSourceSpringContextTests
{

protected static Logger logger = Logger.getLogger(SrvGeneracionDinamicaServiceImplBase.class);
    
   /** Aqui se deben de inyectar los beans a utilizar dentro del test
    *  Inyeccion del bean del Servicio es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService
    */
    
    protected es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService servicio;
	public void setServicio(es.pode.contenidos.negocio.generacionDinamica.servicio.SrvGeneracionDinamicaService servicio) {
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

}