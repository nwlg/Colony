/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.catalogacion.soporte;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


public class Fecha {

	public static final Integer ErrorNoNumero= 0;
	public static final Integer ErrorFechaFueraRango= 1;
	public static final Integer ErrorZHFueraRango=2;
	public static final Integer ErrorFechaComboZH= 3;
	public static final Integer ErrorFechaZonaHoraria= 4;
	public static final Integer ErrorFechaObliHorMin= 5;
	public static final Integer ErrorFechaObli= 6;
	public static final Integer ErrorFormatoFecha= 7;

	private static Logger logger=Logger.getLogger(Fecha.class);
	
	private String anyo;
	private String mes;
	private String dia;
	private String hora;
	private String minutos;
	private String segundoP1;
	private String segundoP2;
	private String zhHora;
	private String zhMinutos;
	private String masOmenos;
	private String meridianoCero;

	private String fechaLomes;
	private String fechaCorta;

	private String formato;
	private String offSet;
	private String idioma;
	
	public Fecha(String fechaLomes) {
		super();
		this.fechaLomes = fechaLomes;
	}
	
	public Fecha() 
	{
		super();
		this.anyo="";
		this.dia="";
		this.fechaCorta="";
		this.fechaLomes = "";
		this.hora="";
		this.masOmenos="";
		this.meridianoCero="0";
		this.mes="";
		this.minutos="";
		this.segundoP1="";
		this.segundoP2="";
		this.zhHora="";
		this.zhMinutos="";
		setIdioma("es");
	}
	
	public Fecha(Fecha aux) 
	{
		this.anyo=aux.getAnyo();
		this.dia=aux.getDia();
		this.hora=aux.getHora();
		this.masOmenos=aux.getMasOmenos();
		this.meridianoCero=aux.getMeridianoCero();
		this.mes=aux.getMes();
		this.minutos=aux.getMinutos();
		this.segundoP1=aux.getSegundoP1();
		this.segundoP2=aux.getSegundoP2();
		this.zhHora=aux.getZhHora();
		this.zhMinutos=aux.getZhMinutos();
		this.idioma=aux.getIdioma();
		this.formato= aux.getFormato();
		this.fechaCorta=aux.getFechaCorta();
		this.fechaLomes="";

	}

	
	
	public String getAnyo() {
		return anyo;
	}
	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getMinutos() {
		return minutos;
	}
	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}
	public String getSegundoP1() {
		return segundoP1;
	}
	public void setSegundoP1(String segundoP1) {
		this.segundoP1 = segundoP1;
	}
	public String getSegundoP2() {
		return segundoP2;
	}
	public void setSegundoP2(String segundoP2) {
		this.segundoP2 = segundoP2;
	}
	public String getZhHora() {
		return zhHora;
	}
	public void setZhHora(String zhHora) {
		this.zhHora = zhHora;
	}
	public String getZhMinutos() {
		return zhMinutos;
	}
	public void setZhMinutos(String zhMinutos) {
		this.zhMinutos = zhMinutos;
	}
	public String getMasOmenos() {
		return masOmenos;
	}
	public void setMasOmenos(String masOmenos) {
		this.masOmenos = masOmenos;
	}
	public String getMeridianoCero() {
		return meridianoCero;
	}
	public void setMeridianoCero(String meridianoCero) {
		this.meridianoCero = meridianoCero;
	}
	public String getFechaLomes() 
	{
		String fechaTexto="";
		
		if((!dia.equals(""))||((!mes.equals(""))||((!anyo.equals("")))))
			fechaTexto=anyo + "-" + mes + "-" + dia;
		if(!fechaTexto.equals("") && (!hora.equals(""))||( !minutos.equals(""))||(!segundoP1.equals(""))||(!segundoP2.equals(""))){
			if(!hora.equals(""))
				fechaTexto = fechaTexto + "T" + hora;
			else{
				hora="00";
				fechaTexto = fechaTexto + "T" + hora;
			}
			if(!minutos.equals(""))
				fechaTexto = fechaTexto + ":" + minutos;
			else{
				minutos="00";
				fechaTexto = fechaTexto + ":" + minutos;
			}
			if(!segundoP1.equals(""))
				fechaTexto = fechaTexto + ":" + segundoP1;
			else{
				segundoP1="00";
				fechaTexto = fechaTexto + ":" + segundoP1;
			}
			if(!segundoP2.equals(""))
				fechaTexto = fechaTexto + "." + segundoP2;
			else{
				segundoP2="00";
				fechaTexto = fechaTexto + "." + segundoP2;
			}
		}
			
		if (!fechaTexto.equals("") && meridianoCero!=null && meridianoCero.equals("1")){
			if (masOmenos.equals("0")&& !zhHora.equals("") && !zhMinutos.equals(""))
				fechaTexto = fechaTexto + "+" + zhHora + ":" + zhMinutos;
			else if (masOmenos.equals("1")&& !zhHora.equals("") && !zhMinutos.equals(""))
				fechaTexto = fechaTexto + "-" + zhHora + ":" + zhMinutos;						
			else if(masOmenos.equals("0")&& (zhHora==null || zhHora.equals("")))
				fechaTexto = fechaTexto + "+00";
			else if(masOmenos.equals("1")&& (zhHora==null || zhHora.equals("")))
				fechaTexto = fechaTexto + "-00";
			else if(masOmenos.equals("0")&&!zhHora.equals(""))
				fechaTexto = fechaTexto + "+" + zhHora ;
			else if(masOmenos.equals("1")&&!zhHora.equals(""))
				fechaTexto = fechaTexto + "-" + zhHora ;
			else if((zhMinutos==null||zhMinutos.equals(""))){
				fechaTexto = fechaTexto + ":00";
			}else if(!zhMinutos.equals(""))
				fechaTexto=fechaTexto+":"+zhMinutos;
		}
		else if(meridianoCero!=null && meridianoCero.equals("0"))
			if(!fechaTexto.equals("") && (!hora.equals(""))||( !minutos.equals(""))||(!segundoP1.equals(""))||(!segundoP2.equals(""))){
				fechaTexto = fechaTexto + "Z";
			}
		
		
		if(fechaTexto.equals(""))
			fechaTexto=null;

		fechaLomes = fechaTexto;
		return fechaLomes;
	}
	public void setFechaLomes(String fechaLomes) 
	{
		this.fechaLomes = fechaLomes;
		fechaLomes2Fecha();
	}
	public String getFechaCorta() 
	{
		String resultado="";
		
		if(fechaCorta!=null && !fechaCorta.equals(""))
		{
			resultado=fechaCorta;
		}else{
		
			if(anyo!=null && !anyo.equals("") &&
				mes!=null && !mes.equals("") &&
				dia!=null && !dia.equals(""))
			{
				if("en".equals(idioma))
					resultado=mes +"/" + dia +"/" + anyo;
				else if("eu".equals(idioma))
					resultado=anyo +"/" + mes +"/" + dia;
				else
					resultado=dia +"/" + mes +"/" + anyo;
			}else
			{
				resultado = "";
			}
		}
		return resultado;
	}

	public void setFechaCorta(String fechaCorta) 
	{
		if(fechaCorta!=null && fechaCorta.equals("dd/mm/aaaa") ||
		   fechaCorta!=null && fechaCorta.equals("mm/dd/yyyy") ||
		   fechaCorta!=null && fechaCorta.equals("aaaa/mm/dd") 	)
		{
			fechaCorta=null;
		}

		if(fechaCorta==null || fechaCorta.equals(""))
		{
			anyo="";
			mes="";
			dia="";
		}else{
			SimpleDateFormat parser= null;
			SimpleDateFormat formater= null;
			
			if("en".equals(idioma))
			{
				parser= new SimpleDateFormat("mm/dd/yy");
				formater= new SimpleDateFormat("mm/dd/yyyy");
			}else if("eu".equals(idioma))
			{
				parser= new SimpleDateFormat("yy/mm/dd");
				formater= new SimpleDateFormat("yyyy/mm/dd");
			}else 
			{
				parser= new SimpleDateFormat("dd/mm/yy");
				formater= new SimpleDateFormat("dd/mm/yyyy");
			}
			
			try{
				fechaCorta = formater.format(parser.parse(fechaCorta));
			}catch (Exception e) {
				this.fechaCorta= fechaCorta;
				fechaCorta= "";
			}
			
			
			if(fechaCorta.split("/").length==3)
			{
				String[] fecha= fechaCorta.split("/");
				if("en".equals(idioma))
				{
					dia= fecha[1];
					mes= fecha[0];
					anyo= fecha[2];
				}else if("eu".equals(idioma))
				{
					dia= fecha[2];
					mes= fecha[1];
					anyo= fecha[0];
				}else
				{
					dia= fecha[0];
					mes= fecha[1];
					anyo= fecha[2];
				}
				
			}else
			{
				anyo="";
				mes="";
				dia="";
			}
			
		}
	}
	
	
	private void fechaLomes2Fecha()
	{
		if(fechaLomes!=null && fechaLomes.equals(""))
		{
			this.anyo="";
			this.mes="";
			this.dia="";
			this.hora="";
			this.minutos="";
			this.segundoP1="";
			this.segundoP2="";
			this.masOmenos="";
			this.meridianoCero="0";
			this.zhHora="";
			this.zhMinutos="";
			this.fechaCorta="";
		}else{
			String masMenos="";
			
			String[] fmtFecha = fechaLomes.split("T");
			String fechaAux=fechaLomes;
			//comprobamos si en la cadena de fecha existe el - ó +
			if(fmtFecha.length>1 && (fmtFecha[1].split("\\-").length>1 || fmtFecha[1].split("\\+").length>1 ||
					fmtFecha[1].endsWith("Z"))){
				String[] fechaMm={""};
				if(fmtFecha[1].endsWith("Z")){
					fechaMm = fmtFecha[1].split("Z");
					meridianoCero="0";
				}
				else if(fmtFecha[1].split("\\-").length>1){
					fechaMm = fmtFecha[1].split("\\-");
					masOmenos="1";// -	
					masMenos=fechaMm[1];
					this.meridianoCero="1";
				}
				else{
					fechaMm = fmtFecha[1].split("\\+");
					masOmenos="0";// +
					masMenos=fechaMm[1];
					this.meridianoCero="1";
				}
				
				fechaAux=fmtFecha[0] +" " + fechaMm[0];
			}
			
			 if ((masMenos!=null) && (!masMenos.equals(""))) //+- 00:00
			 {
				zhHora =(masMenos.split(":")[0]!=null)?masMenos.split(":")[0]:"" ;
				zhMinutos = (masMenos.split(":")[1]!=null)?masMenos.split(":")[1]:"";
			 }

			
			String inputFormat="";
			
			//Como max fechaAux tendra el formato ahora-- yyyy-MM-ddThh:mm:ss.S comprobamos la T
			if (fechaAux.split(" ").length>1) {
				if (fechaAux.split("\\.").length>1) { //Vemos si contiene el .
				  inputFormat="yyyy-MM-dd HH:mm:ss.SS";
				}else {
				  inputFormat="yyyy-MM-dd HH:mm:ss"; //CUIDADO CON LA T A VER SI FUNCIONA
				}
			} else {
				inputFormat="yyyy-MM-dd";
			}
			
			//String outputFormat ="yyyy-MM-dd hh:mm:ss.SS";//ver si no da error
			try {
    			SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
    			
    			Date date = sdf.parse(fechaAux);
    			String fechaDespues = sdf.format(date);
    			
    			 //Parto la fecha
    			 String[] fEspacio=fechaDespues.split(" ");//habia T
    			 for (int fe=0;fe<fEspacio.length; fe++) {
    				 if (fEspacio[fe].split("-").length>1) {
    					 anyo=fEspacio[fe].split("-")[0];
    					 mes=fEspacio[fe].split("-")[1];
    					 dia=fEspacio[fe].split("-")[2];
    				 } else if (fEspacio[fe].split(":").length>1) {
    					 hora=fEspacio[fe].split(":")[0];
    					 minutos=fEspacio[fe].split(":")[1];
    					 int lonS=fEspacio[fe].split(":")[2].indexOf(".");
    					 segundoP1=fEspacio[fe].split(":")[2].substring(0, 2);//falta el otro 00 .
    					 if (lonS>0) {
    						 segundoP2=fEspacio[fe].split(":")[2].substring(3, 5); // . 00
    					 }
    				 }
    			 }
    			 
			 }catch (Exception e) {
				this.anyo="";
				this.mes="";
				this.dia="";
				this.hora="";
				this.minutos="";
				this.segundoP1="";
				this.segundoP2="";
				this.masOmenos="";
				this.meridianoCero="0";
				this.zhHora="";
				this.zhMinutos="";
				this.fechaCorta="";
			}
			 
		}
		
	}
	
	
	
	public Integer[] validar()
	{
		List errores= new ArrayList();
		String fechaTexto="";
		try{
			
			
			//dia
			if(dia!=null){
				dia = dia.trim();
				if(!dia.equals(""))
					if (dia.matches("\\d{1,2}")){
		    			if(dia.length()< 2 && Integer.parseInt(dia)<10)
		    				dia="0" + dia.trim();
	    			}
	    			else 
	    				errores.add(ErrorNoNumero);
			}
			//mes
			if(mes!=null){
				mes = mes.trim();
				if(!mes.equals(""))
					if (mes.matches("\\d{1,2}")){
		    			if(mes.length()< 2 && Integer.parseInt(mes)<10)
		    				mes="0" + mes.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}
			//año
			if(anyo!=null){
				anyo = anyo.trim();
				if(!anyo.equals(""))
					if (anyo.matches("\\d{1,4}")){
						if(anyo.length()==1) anyo ="000"+anyo;
						if(anyo.length()==2) anyo ="00"+anyo;
						if(anyo.length()==3) anyo ="0"+anyo;
					}
					else
	    				errores.add(ErrorNoNumero);
				}
			//hora
			if(hora!=null)
				if(!hora.equals("")){
					hora = hora.trim();
					if (hora.matches("\\d{1,2}")){
						if(hora.length()< 2 && Integer.parseInt(hora)<10)
							hora = "0" + hora.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
				}
			//minutos
			if(minutos!=null){
				minutos = minutos.trim();
				if(!minutos.equals(""))
					if (minutos.matches("\\d{1,2}")){
		    			if(minutos.length()< 2 && Integer.parseInt(minutos)<10)
		    				minutos="0" + minutos.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}
			//segundos 1
			if(segundoP1!=null) {
				segundoP1 = segundoP1.trim();
				if (!segundoP1.equals(""))
					if (segundoP1.matches("\\d{1,2}")){
		    			if(segundoP1.length()< 2 && Integer.parseInt(segundoP1)<10)
		    				segundoP1="0" + segundoP1.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}
			//segundos 2
			if(segundoP2!=null){
				segundoP2 = segundoP2.trim();
				if (!segundoP2.equals(""))
					if (segundoP2.matches("\\d{1,2}")){
		    			if(segundoP2.length()< 2 && Integer.parseInt(segundoP2)<10)
		    				segundoP2="0" + segundoP2.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}  			
			//zh hora
			if(zhHora!=null){
				zhHora = zhHora.trim();
				if (!zhHora.equals(""))
					if (zhHora.matches("\\d{1,2}")){
						if(zhHora.length()< 2 && Integer.parseInt(zhHora)<10)
							zhHora = "0" + zhHora.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}
			//zh minutos
			if(zhMinutos!=null){
				zhMinutos = zhMinutos.trim();
				if (!zhMinutos.equals(""))
					if (zhMinutos.matches("\\d{1,2}")){
						if(zhMinutos.length()< 2 && Integer.parseInt(zhMinutos)<10)
							zhMinutos="0" + zhMinutos.trim();
					}
					else 
	    				errores.add(ErrorNoNumero);
			}	
			
			if ((anyo!=null) && (!anyo.equals("")) && (mes!=null) && (!mes.equals("")) && (dia!=null) && (!dia.equals(""))){
	
				if( !validaFecha(dia + mes + anyo,"ddMMyyyy"))
					errores.add(ErrorFechaFueraRango);

				
				fechaTexto=anyo + "-" + mes + "-" + dia;
				
				if((hora!=null) && (!hora.equals("")) && (minutos!=null) && (!minutos.equals("")) && (segundoP1!=null) && (!segundoP1.equals(""))){
					if(!validaFecha(dia + mes + anyo + hora + minutos + segundoP1,"ddMMyyyyHHmmss"))
	    				errores.add(ErrorFechaFueraRango);
					fechaTexto = fechaTexto + "T" + hora + ":" + minutos + ":" + segundoP1;
					
					if((segundoP2!=null) && (!segundoP2.equals(""))){
						if(!validaFecha(dia + mes + anyo + hora + minutos + segundoP1 + segundoP2,"ddMMyyyyHHmmssSS"))
		    				errores.add(ErrorFechaFueraRango);
						fechaTexto = fechaTexto + "." + segundoP2;
					}
					if (meridianoCero!=null && meridianoCero.equals("1")){// lleva zona horaria (no seleccionado meridiano cero)
						if((zhMinutos!=null) && (!zhMinutos.equals("")) && (zhHora!=null) && (!zhHora.equals(""))){
							if(!validaFecha(zhHora + zhMinutos,"HHmm"))
			    				errores.add(ErrorZHFueraRango);
							if (masOmenos.equals("0"))
								fechaTexto = fechaTexto + "+" + zhHora + ":" + zhMinutos;
							else if (masOmenos.equals("1"))
								fechaTexto = fechaTexto + "-" + zhHora + ":" + zhMinutos;
							else  errores.add(new Integer(ErrorFechaComboZH));
						}
						else if (((zhMinutos==null) || (zhMinutos.equals(""))) || ((zhHora==null) || (zhHora.equals("")))){
		    				errores.add(ErrorFechaZonaHoraria);
						}
					}
					else fechaTexto = fechaTexto + "Z"; //seleccionado meridiano cero
				}
				else if(((hora!=null) && (!hora.equals(""))) || ((minutos!=null) && (!minutos.equals("")))|| ((segundoP1!=null) && (!segundoP1.equals("")))){
					errores.add(ErrorFechaObliHorMin);
				}
			}
			else if(((hora!=null) && (!hora.equals(""))) || ((minutos!=null) && (!minutos.equals("")))
						|| ((segundoP1!=null) && (!segundoP1.equals(""))) || ((segundoP2!=null) && (!segundoP2.equals("")))
						|| ((anyo!=null) && (!anyo.equals(""))) || ((mes!=null) && (!mes.equals(""))) 
						|| ((dia!=null) && (!dia.equals("")))){
					errores.add(ErrorFechaObli);
			}
			
			if(fechaCorta!=null && (!fechaCorta.equals("") &&
			  !fechaCorta.equals("dd/mm/aaaa") &&
			  !fechaCorta.equals("mm/dd/yyyy") &&
			  !fechaCorta.equals("aaaa/mm/dd") ))
				errores.add(ErrorFormatoFecha);
			
		}catch (Exception e) {
			logger.debug("error al validar la fecha");
		}

		return (Integer[]) errores.toArray(new Integer[0]);
	}
	
	
	
	private boolean validaFecha(String fecha,String inputFormat){
		boolean resultado = true;
		try{
			
			SimpleDateFormat format = new SimpleDateFormat(inputFormat);
			format.setLenient(false);
			Date fechaIn = null;
			fechaIn = format.parse(fecha);
			
		}
		catch(java.text.ParseException pe){
			resultado= false;
		}
		return resultado;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
		if("en".equals(idioma)){
			formato= "m/d/Y";
			offSet="0";
		}else if("eu".equals(idioma)){
			formato= "Y/m/d";
			offSet="1";
		}else {
			formato= "d/m/Y"; //"d/m/Y";
			offSet="1";
		}
	}

	public String getFormato() 
	{
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getOffSet() {
		return offSet;
	}



}
