/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.servicios.jms;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import org.apache.log4j.Logger;
import javax.jms.MessageListener;
import es.pode.auditoria.ServiceLocator;
import es.pode.auditoria.negocio.servicios.BusquedaVO;
import es.pode.auditoria.negocio.servicios.OperacionVO;

public class SrvAuditoriaRecibirServicioImpl implements es.pode.auditoria.negocio.servicios.jms.SrvAuditoriaRecibirServicio, MessageListener
{

	protected static Logger logger = Logger.getLogger(SrvAuditoriaRecibirServicioImpl.class);
	private es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio srvAuditoriaServicio;

	/**
	 * Saca de la cola jms los mensajes almacenados en la misms
	 * @param msg Mensage almacenado en la cola
	 * @param session
	 * @throws Exception
	 */

	public void onMessage(Message msg, Session session) throws Exception
	{

		try
		{
			if (logger.isDebugEnabled())
				logger.debug("Begin:onMessage");
			// Implementation
			if (msg instanceof ObjectMessage)
			{
				logger.info("msd instanceof ObjectMessage");
				if (logger.isDebugEnabled())
					logger.debug("Transformo el mensaje");
				ObjectMessage obj = (ObjectMessage) msg;
				logger.info("obj.getObject()!!! " + obj.getObject());
				BusquedaVO busqueda = (BusquedaVO) obj.getObject();
				logger.info("busqueda vale " + busqueda);
				if (logger.isDebugEnabled())
					logger.debug("El termino buscado es  [" + busqueda.getTerminoBuscado());
				//Si todo ha ido bien hago la petición RMI pasando el Objeto
				if (logger.isDebugEnabled())
					logger.debug("Se almacena en BD el termino");
				logger.info("antes de this.registrarBusqueda");
				this.registrarBusqueda(busqueda);

				if (logger.isDebugEnabled())
					logger.debug("Fin registrar termino busqueda");
			} else
			{
				if (logger.isDebugEnabled())
					logger.debug("No hay más mensajes que tratar");
			}
			//session.close();
			if (logger.isDebugEnabled())
				logger.debug("End:onMessage");
		} catch (Exception ex)
		{
			logger.error("Se ha producido un error al leer el mensaje [" + msg + "]", ex);
		}

	}

	/**
	 * Registra en base de datos la operación de búsqueda 
	 * @param busqueda Value Object con los datos de la búsqueda
	 * @throws Exception
	 */
	public void registrarBusqueda(es.pode.auditoria.negocio.servicios.BusquedaVO busqueda)
	{
		logger.info("registrarBusqueda busqueda vale " + busqueda);
		if (logger.isDebugEnabled())
			logger.debug("SRVAUDITORIARECIBIRSERVICIO registrarBusqueda " + busqueda);
		logger.info("this.getSrvAuditoriaServicio() " + this.getSrvAuditoriaServicio());
		ServiceLocator.instance().getSrvAuditoriaServicio().almacenarBusquedaBD(busqueda);
		//this.getSrvAuditoriaServicio().almacenarBusquedaBD(busqueda);
		if (logger.isDebugEnabled())
			logger.debug("SRVAUDITORIARECIBIRSERVICIO despues de almacenar la busqueda en BD");

	}

	/**
	 * Registra en base de datos la operación de búsqueda 
	 * @param busqueda Value Object con los datos de la búsqueda
	 * @throws Exception
	 */
	public void setSrvAuditoriaServicio(es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio srvAuditoriaServicio)
	{
		this.srvAuditoriaServicio = srvAuditoriaServicio;
	}

	/**
	 * Obtiene la referencia al objeto SrvAuditoriaServicio
	 * @return SrvAuditoriaServicio
	 * @throws Exception
	 */
	public es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio getSrvAuditoriaServicio()
	{
		logger.info("dentro de getSrvAuditoriaServicio()");
		return this.srvAuditoriaServicio;
	}

	/**
	 * Registra en base de datos la operación realizada 
	 * @param operacion Value Object con los datos de la operación
	 * @throws Exception
	 */
	public void registrarOperacion(OperacionVO operacion)
	{
		logger.info("registrarOperacion operacion vale " + operacion);
		if (logger.isDebugEnabled())
			logger.debug("SRVAUDITORIARECIBIRSERVICIO registrarBusqueda " + operacion);
		logger.info("this.getSrvAuditoriaServicio() " + this.getSrvAuditoriaServicio());
		ServiceLocator.instance().getSrvAuditoriaServicio().almacenarOperacionBD(operacion);
		//this.getSrvAuditoriaServicio().almacenarBusquedaBD(busqueda);
		if (logger.isDebugEnabled())
			logger.debug("SRVAUDITORIARECIBIRSERVICIO despues de almacenar la busqueda en BD");

	}

	/**
	 * Saca de la cola jms los mensajes almacenados en la misms
	 * @param msg
	 * @throws Exception
	 */
	public void onMessage(Message msg)
	{
		try
		{
			logger.info("ONMESSAGE");
			if (logger.isDebugEnabled())
				logger.debug("Begin:onMessage");
			// Implementation
			if (msg instanceof ObjectMessage)
			{
				logger.info("msg instanceof ObjectMessage " + msg);
				if (logger.isDebugEnabled())
					logger.debug("Transformo el mensaje");

				ObjectMessage obj = (ObjectMessage) msg;
				logger.info("obj.getObject() vale " + obj.getObject());
				if (obj.getObject() instanceof BusquedaVO)
				{
					logger.info("obj.getObject().getClass() vale " + obj.getObject().getClass());
					BusquedaVO busqueda = (BusquedaVO) obj.getObject();
					logger.info("busqueda vale " + busqueda);
					logger.info("antes de registrarBusqueda");
					this.registrarBusqueda(busqueda);
				} else
				{
					if (obj.getObject() instanceof OperacionVO)
					{
						logger.info("obj.getObject().getClass() vale " + obj.getObject().getClass());
						OperacionVO operacion = (OperacionVO) obj.getObject();
						logger.info("busqueda vale " + operacion);
						logger.info("antes de registrarBusqueda");
						this.registrarOperacion(operacion);
					}
				}
				if (logger.isDebugEnabled())
					logger.debug("El termino buscado es  [");
				//Si todo ha ido bien hago la petición RMI pasando el Objeto
				if (logger.isDebugEnabled())
					logger.debug("Se almacena en BD el termino");

				if (logger.isDebugEnabled())
					logger.debug("Fin registrar termino busqueda");
			} else
			{
				if (logger.isDebugEnabled())
					logger.debug("No hay más mensajes que tratar");
			}
			//session.close();
			if (logger.isDebugEnabled())
				logger.debug("End:onMessage");
		} catch (Exception ex)
		{
			logger.error("Se ha producido un error al leer el mensaje [" + msg + "]", ex);
		}

	}

}