/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscador.presentacion.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;

public class MailSender {

	private java.util.Properties pSpringProperties = null;
	
	private static Logger logger = Logger.getLogger(MailSender.class);

	public MailSender() {

	}

	public boolean send(String toAddress, String subject, StringBuffer body,
			String from) {

		log("Enviar email");
		log("Enviar email a la direccion ["+toAddress+"]");		
		boolean resultado = false;
		MimeMultipart multipart = new MimeMultipart();
		Properties properties = new Properties();
		String hostSmtp = null;
		Session session = null;
		try {			
			
			String senderAddress = null;
			if (from == null || from.equals("")) {
				senderAddress = this.getPropertyValue("fromSender");
			} else {
				log("from es distinto de null");			
				senderAddress = from;
			}

			hostSmtp = this.getPropertyValue("hostSmtp");
			properties.put("mail.smtp.host", hostSmtp);
			////////////AUTENTICACION ///////////////
			
			if(new Boolean(this.getPropertyValue("autentication")).booleanValue())
			{
			log("El envio de correo necesita autenticacion");				
			properties.setProperty("mail.smtp.auth", "true"); 
			}
			
			session = Session.getDefaultInstance(properties, null);
			session.setDebug(new Boolean(this.getPropertyValue("debug")).booleanValue());
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(senderAddress));			
			msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			// Cuerpo del mensaje
			MimeBodyPart mbp = new MimeBodyPart();			
			mbp.setContent(body.toString(), "text/html");
			multipart.addBodyPart(mbp);
			msg.setContent(multipart);
			if(new Boolean(this.getPropertyValue("autentication")).booleanValue())
			{
			Transport t = session.getTransport("smtp");
			log("antes de enviar");
			String usuario = this.getPropertyValue("userSmtp");
			String password =  this.getPropertyValue("passwordSmtp");
			t.connect(usuario,password);			
			t.sendMessage(msg,msg.getAllRecipients());
			log("despues de enviar el mensaje");			
			}else
			{
				log("se envía el mensaje sin autenticacion");
			    Transport.send(msg);
			}
			resultado = true;

		} catch (Exception mex) {
			logger.error("MailSender.send() error ["+mex+"]");			
		}
		return resultado;
	}

	private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream(
				"/agrega.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}	
	
	private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}