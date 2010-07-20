/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.serializar;

import java.io.IOException;

import javax.activation.DataHandler;

import junit.framework.TestCase;

public class SerializadorObjetosTest extends TestCase
{

	public SerializadorObjetosTest(String arg0)
	{
		super(arg0);
	}

	protected void setUp() throws Exception
	{
		super.setUp();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}
	
	public void testSerializar() 
	{
		String seri=new String();
		SerializadorObjetos serializador=new SerializadorObjetos();
		try
		{
			DataHandler dh=serializador.serializarObjeto(seri);
			System.out.print("datahandler recuperado "+dh);
			
		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
		
	}
	public void testDeserializar() 
	{
		String seri="aaaaa";
		SerializadorObjetos serializador=new SerializadorObjetos();
		DataHandler dh=null;
		try
		{
			dh=serializador.serializarObjeto(seri);
			System.out.print("datahandler recuperado "+dh);
			
		} 
		catch (Exception e)
		{
				e.printStackTrace();
		}
		
		try
		{
			Object obj = serializador.deserializarObjeto(dh);
			assertTrue(obj instanceof String);
			assertEquals(obj,seri);
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
