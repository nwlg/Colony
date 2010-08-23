/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.planificador.negocio.servicios.jms;

import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.support.converter.SimpleMessageConverter;

/**
 * @see es.pode.planificador.negocio.servicios.jms.SrvTareaModificadorService
 *      Generated file:
 *      es/pode/planificador/negocio/servicios/jms/SrvTareaModificadorService
 */
public class SrvTareaModificadorServiceImpl

implements
		es.pode.planificador.negocio.servicios.jms.SrvTareaModificadorService

{

	private static final Logger logger = Logger
			.getLogger(SrvTareaModificadorServiceImpl.class);

	private JmsTemplate template;

	private Destination reply;

	// --------- Default Constructor ----------

	public SrvTareaModificadorServiceImpl() {
		super();
	}

	public void sendMessage(final String message) {
		template.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(message);
				msg.setJMSReplyTo(getReply());
				return msg;

			}
		});

	}

	public void sendMessage(final Object obj) {
		template.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				Message message = new SimpleMessageConverter().toMessage(obj,
						session);
				message.setJMSReplyTo(getReply());
				return message;

			}
		});

	}

	public void setJmsTemplate(JmsTemplate template) {

		this.template = template;
	}

	public void setReply(Destination reply) {

		this.reply = reply;
	}

	public Destination getReply() {
		return this.reply;
	}

	// -------- User Defined Methods --------------

	/**
	 * @see es.pode.planificador.negocio.servicios.jms.SrvTareaModificadorService#ejecutarTareaModificacion(java.lang.Long)
	 */
	public java.lang.Boolean ejecutarTareaModificacion(java.lang.Long idModificacion)
    {
    	logger.info("Enviando mensaje para la ejecuacion de la tarea de modificacion " + idModificacion);
    	Boolean result = Boolean.TRUE;
    	try {
    	sendMessage(idModificacion);
    	} catch (Exception e) {
    		result = Boolean.FALSE;
    		logger.error("No se ha podido enviar el mensaje para ejecutar la tarea de modificacion " + idModificacion);
    		if(logger.isDebugEnabled()) logger.debug(e);
		}
        
        return result;
    }

	public void sendMessage(Map map) {
		// TODO Auto-generated method stub
		
	}

}