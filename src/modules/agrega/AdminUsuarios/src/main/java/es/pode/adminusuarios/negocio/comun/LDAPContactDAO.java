/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.adminusuarios.negocio.comun;

import org.springframework.ldap.LdapTemplate;

import org.springframework.ldap.support.DistinguishedName;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

public class LDAPContactDAO {
	private LdapTemplate ldapTemplate;

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
/*
	public void insertUser(String user, String password, String nombreApellido,
			String email, String tipoEmpaquetador, String idioma,
			String idiomaBusqueda) {
		BasicAttributes attrs = new BasicAttributes();
		BasicAttribute ocattr = new BasicAttribute("objectclass");
		ocattr.add("person");
		ocattr.add("inetOrgPerson");
		ocattr.add("top");
		attrs.put(ocattr);
		attrs.put("cn", user);
		attrs.put("sn", nombreApellido);
		attrs.put("userPassword", password);
		attrs.put("mail", email);
		attrs.put("employeeType", tipoEmpaquetador);
		attrs.put("preferredLanguage", idioma);
		attrs.put("initials", idiomaBusqueda);
		DistinguishedName newContactDN = new DistinguishedName();
		newContactDN.add("cn", user);
		ldapTemplate.bind(newContactDN, null, attrs);

	}
*/
	
	public void insertUser(String user, String password, String nombreApellido) {
		BasicAttributes attrs = new BasicAttributes();
		BasicAttribute ocattr = new BasicAttribute("objectclass");
		ocattr.add("person");
		ocattr.add("top");
		attrs.put(ocattr);
		attrs.put("cn", user);
		attrs.put("sn", nombreApellido);
		attrs.put("userPassword", password);
		//attrs.put("mail", email);
		//attrs.put("employeeType", tipoEmpaquetador);
		//attrs.put("preferredLanguage", idioma);
		//attrs.put("initials", idiomaBusqueda);
		DistinguishedName newContactDN = new DistinguishedName();
		newContactDN.add("cn", user);
		ldapTemplate.bind(newContactDN, null, attrs);

	}
	
	/*
	public void modifyUser(String user, String password, String nombreApellido,
			String email, String tipoEmpaquetador, String idioma,
			String idiomaBusqueda) {

		//DistinguishedName dn = new DistinguishedName("ou=usuarios");
		DistinguishedName dn = new DistinguishedName();
		dn.add("cn", user);
		ModificationItem[] mods = new ModificationItem[6];
		Attribute mod0 = new BasicAttribute("userPassword", password);
		Attribute mod1 = new BasicAttribute("mail", email);
		Attribute mod2 = new BasicAttribute("sn", nombreApellido);
		Attribute mod3 = new BasicAttribute("employeeType", tipoEmpaquetador);
		Attribute mod4 = new BasicAttribute("preferredLanguage", idioma);
		Attribute mod5 = new BasicAttribute("initials", idiomaBusqueda);
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
		mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
		mods[2] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod2);
		mods[3] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod3);
		mods[4] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod4);
		mods[5] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod5);
		ldapTemplate.modifyAttributes(dn, mods);

	}
*/ 
	
	public void modifyUser(String user, String password, String nombreApellido) {

		//DistinguishedName dn = new DistinguishedName("ou=usuarios");
		DistinguishedName dn = new DistinguishedName();
		dn.add("cn", user);
		ModificationItem[] mods = new ModificationItem[2];
		Attribute mod0 = new BasicAttribute("userPassword", password);
		Attribute mod1 = new BasicAttribute("sn", nombreApellido);
		mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod0);
		mods[1] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, mod1);
		ldapTemplate.modifyAttributes(dn, mods);

	}
	
	
	
	public void deleteContact(String user) {

		DistinguishedName dn = new DistinguishedName();
		dn.add("cn", user);
		ldapTemplate.unbind(dn);

	}

}
