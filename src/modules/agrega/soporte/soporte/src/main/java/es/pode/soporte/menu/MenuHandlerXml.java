/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

import java.util.HashMap;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MenuHandlerXml extends DefaultHandler
{
	private static final String TAG_MENU = MenuController.getPropertyValue("tag_menu",MenuController.FILE_NAME_PROPERTIES);
	private static final String TAG_MENU_ITEM = MenuController.getPropertyValue("tag_menu_item",MenuController.FILE_NAME_PROPERTIES);

	HashMap hashMenu = null;
	Menu menu = null;

	
	public void startElement(String nsURI, String localName, String qName, Attributes attributes) throws SAXException 
	{
	     if (qName.equalsIgnoreCase(MenuHandlerXml.TAG_MENU))
	    	menu = new Menu(attributes);
	     else if (qName.equalsIgnoreCase(MenuHandlerXml.TAG_MENU_ITEM))
    	 	menu.addMenuItem(new MenuItemXml(menu.getI18nKey(),menu.getRoles(),attributes));
	}
	
	public void endElement(String uri, String localName, String qName)throws SAXException
	{
		super.endElement(uri, localName, qName);
	     if (qName.equalsIgnoreCase(MenuHandlerXml.TAG_MENU))
	     {
	    	 if (this.getHashMenu()== null)
	    		 this.hashMenu = new HashMap();
	    	 this.hashMenu.put(menu.getName(), menu);
	     }
	}

	public HashMap getHashMenu() {
		return hashMenu;
	}

	public void setHashMenu(HashMap hashMenu) {
		this.hashMenu = hashMenu;
	}

	public Menu getMenu(String sKey) {
		return (Menu)this.getHashMenu().get(sKey);
	}

}
