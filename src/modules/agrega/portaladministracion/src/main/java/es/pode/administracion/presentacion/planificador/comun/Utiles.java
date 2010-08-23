/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.administracion.presentacion.planificador.comun;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.TimeZone;
import java.util.Calendar;

import org.apache.log4j.Logger;

public class Utiles {
	
	private static Logger log = Logger.getLogger(Utiles.class);
	private final static String PLANIFICADOR_PROP = "/portaladministracion.properties";
	private final static String ZONA_HORARIA = "zona_horaria";
	private static TimeZone tz = null;
	
    /** 
     * Método para asignar la zona horaria a partir del fichero de properties
     * 
     * @return zona horaria
     */
    public TimeZone asignarZonaHoraria()
    {
    	Properties props = null;
    	TimeZone zonaHoraria = TimeZone.getDefault();
    	InputStream pos = null;
    	
		try 
		{
			props = new Properties();
			pos = getClass().getResourceAsStream(this.PLANIFICADOR_PROP);
			props.load(getClass().getResourceAsStream(this.PLANIFICADOR_PROP));
			zonaHoraria.setID(props.getProperty(this.ZONA_HORARIA));
		} 
		catch (IOException e) 
		{
			log.error("ERROR: fichero no encontrado: " + PLANIFICADOR_PROP, e);
			/* Se asigna la zona horaria CEST por defecto */
			zonaHoraria.setID("CEST");
		}
		catch (Exception ex) 
		{
			log.error("ERROR: asignando zona horaria ", ex);
			/* Se asigna la zona horaria CEST por defecto */
			zonaHoraria.setID("CEST");
		}
		finally 
		{
			if( pos != null ) 
			{
               try 
               {
            	   pos.close();
               } 
               catch (Exception e) 
               {
            	   log.error(e);
               }
			}     
        }
   	
		return zonaHoraria;
    }
    
    /**
     *  Validación de la fecha :: Comprobamos si la fecha pasada como parametros es correcta 
     *  
    */
    
    //estaba en los parametros , (int hora, int minutos)
	public boolean validacionFechaDDMMAAAAHHMM(String dia, String mes, String anio, String mascara) 
	{
        String mesStr = null;
        String diaStr = null;
        
        try 
        {
        	SimpleDateFormat sdf = new SimpleDateFormat(mascara);
            sdf.setLenient(false);
            
            if (mes.length() == 1)
            	mesStr = "0" + mes;
            else 
            	mesStr = mes;
            
            if (dia.length() == 1)
            	diaStr = "0" + dia;
            else 
            	diaStr = dia;
                  
            
            Date fecha = sdf.parse(anio + mesStr + diaStr);
            
            
            return true;
        }
        catch(Exception e)
        {  	
        	return false;
        }
	}
	
	public boolean validacionHoraHHMM(String hora, String minutos) 
	{
		boolean correcta=true;
		
		Logger.getLogger(this.getClass()).debug("entra en hora:"+ hora + minutos);
		if ((new Integer(minutos).intValue() > 59 || new Integer(minutos).intValue() < 0) || 
				(new Integer(hora).intValue() > 23 || new Integer(hora).intValue() < 0))
		{
			Logger.getLogger(this.getClass()).debug("entra en if");
          	correcta=false;
		}
        
	  return correcta;
      
	}
	
	public boolean comparacionFechas(String anioDesde, String mesDesde, String diaDesde, String anioHasta, String mesHasta, String diaHasta)
	{
		if (tz == null) 
    		tz = this.asignarZonaHoraria();
		
		Calendar fechaDesde = Calendar.getInstance(tz);
		Calendar fechaHasta = null;
		
		fechaDesde = new GregorianCalendar(new Integer(anioDesde).intValue(), new Integer(mesDesde).intValue(), new Integer(diaDesde).intValue());
		
		fechaHasta = new GregorianCalendar(new Integer(anioHasta).intValue(), new Integer(mesHasta).intValue(), new Integer(diaHasta).intValue());
		
        log("fecha DEsde : " + fechaDesde.toString());
        log("fecha Hasta : " + fechaHasta.toString());
        
        if(fechaDesde.before(fechaHasta) || fechaDesde.equals(fechaHasta))
        	return true;
        else
        	return false;
	}
    
    /**
     * Comprobamos si un nombre recibido contiene algunos caracteres concretos
     * devolvemos false si contiene alguno de los caracteres
     * devolvemos true si no contiene ningun caracter de los que comprobamos
     */
    public boolean validacionCaracter(String nombre)
    {
    	//comprobamos que no contenga #
    	if(nombre.indexOf("#") >= 0)
    		return false;
    	
    	//comprobamos que no contenga %
    	if(nombre.indexOf("%") >= 0)
    		return false;
    	
    	//comprobamos que no contenga &
    	if(nombre.indexOf("&") >= 0)
    		return false;
    	
    	//comprobamos que no contenga +
    	if(nombre.indexOf("+") >= 0)
    		return false;
    	
    	//comprobamos que no contenga "
    	if(nombre.indexOf("\"") >= 0)
    		return false;
    	
    	//comprobamos que no contenga <
    	if(nombre.indexOf("<") >= 0)
    		return false;
    	
    	//comprobamos que no contenga >
    	if(nombre.indexOf(">") >= 0)
    		return false;
    	
    	//comprobamos que no contenga '
    	if(nombre.indexOf("\'") >= 0)
    		return false;
    	
    	return true;
    }
    
    public String getPropertyValue(String sKey, Properties pSpringProperties) throws IOException
	{
    	InputStream fIsSpringProperties = null;
    
    	try 
    	{
    		fIsSpringProperties = this.getClass().getResourceAsStream(PLANIFICADOR_PROP);
			if (pSpringProperties == null)
			{
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
    	}	
		catch (Exception ex)
		{
			log.error(ex);
		}
		finally 
		{
			if( fIsSpringProperties != null ) 
			{
               try 
               {
            	   fIsSpringProperties.close();
               } 
               catch (Exception e) 
               {
            	   log.error(e);
               }
			}     
        }
		
		// devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}
    
    private void log(Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
