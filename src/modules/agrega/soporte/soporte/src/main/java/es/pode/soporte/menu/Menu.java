/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

import java.util.ArrayList;

import org.xml.sax.Attributes;

public class Menu 
{
	private static final String TAG_MENU_NAME 		= MenuController.getPropertyValue("tag_name",MenuController.FILE_NAME_PROPERTIES);
	private static final String TAG_MENU_I18NKEY 	= MenuController.getPropertyValue("tag_i18nKey",MenuController.FILE_NAME_PROPERTIES);
	private static final String TAG_MENU_PATTERN	= MenuController.getPropertyValue("tag_pattern",MenuController.FILE_NAME_PROPERTIES);
	private static final String TAG_MENU_ROLES 		= MenuController.getPropertyValue("tag_roles",MenuController.FILE_NAME_PROPERTIES);

	String name = "";
	String i18nKey = "";
	String []roles = null;
	String pattern = "";

	ArrayList arrayMenuItem = null;

	public Menu(Attributes attributes)
	{
		for (int i = 0; i < attributes.getLength(); i++)
		{
			if (attributes.getQName(i).equals(Menu.TAG_MENU_NAME))
				this.setName(attributes.getValue(i));
			else if (attributes.getQName(i).equals(Menu.TAG_MENU_I18NKEY))
				this.setI18nKey(attributes.getValue(i));
			else if (attributes.getQName(i).equals(Menu.TAG_MENU_PATTERN))
				this.setPattern(attributes.getValue(i));
			else if (attributes.getQName(i).equals(Menu.TAG_MENU_ROLES))
				this.setRoles(attributes.getValue(i));
		}

	}

	public String getI18nKey() {
		return i18nKey;
	}

	public void setI18nKey(String key) 
	{
		if (isChangeable(key))
			i18nKey = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (isChangeable(name))
			this.name = name;
	}

	public String[] getRoles() {
		return roles;
	}

	public void setRoles(String sRoles) 
	{
		if (isChangeable(sRoles) && sRoles.indexOf(MenuController.SEPARATOR)!= -1)
			this.setRoles(sRoles.split(MenuController.SEPARATOR));
		else if (isChangeable(sRoles) )
		{
			String[] arrayRoles = new String[1];
			arrayRoles[0] = sRoles;
			this.setRoles(arrayRoles);
		}
	}

	public void setRoles(String[] roles) {
		this.roles = roles;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		if (isChangeable(pattern))
			this.pattern = pattern;
	}

	public void addMenuItem(MenuItemXml item) 
	{
		if (arrayMenuItem == null)
			arrayMenuItem = new ArrayList(5);
		arrayMenuItem.add(item);
	}

	private boolean isChangeable(String campo)
	{
		return campo != null && !campo.equals("");
	}
}
