/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.publicacion.negocio.servicios.TransicionVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController
 */
public class ObjetosPersonalesControllerImpl extends ObjetosPersonalesController {

	private Logger logger = Logger.getLogger(ObjetosPersonalesController.class);
	public final static String SIN_ERRORES = "0.0";
	/**
	 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesController#cargarODESPersonales(org.apache.struts.action.ActionMapping, es.pode.gestorFlujo.presentacion.objetosPersonales.CargarODESPersonalesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void cargarODESPersonales(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.CargarODESPersonalesForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			if(logger.isDebugEnabled())
				logger.debug("Cargando objtos personales");
			SrvPublicacionService publi = this.getSrvPublicacionService();
			SrvLocalizadorService localizador=this.getSrvLocalizadorService();
			TransicionVO[] odesPersonales = publi.obtenODEsCreadosPorUsuario(LdapUserDetailsUtils.getUsuario()); 
			if(odesPersonales !=null && odesPersonales.length>0){
				TransicionConTamainoVO[] odesTamaino=new TransicionConTamainoVO[odesPersonales.length];

				String[] identificadoresOdesPersonales=new String[odesPersonales.length];
				if(logger.isDebugEnabled())
					logger.debug("Entramos en el mapeo");
				for(int i=0;i<odesPersonales.length;i++){
					odesTamaino[i]=new TransicionConTamainoVO();
					//			this.getBeanMapper().map(odesPersonales[i], odesTamaino[i]);//Intentar hacer el mapeo de array a array!!!!!!!!!!!!
					//			logger.debug("Hemos hecho el mapeo del elemento "+i+"del array");
					odesTamaino[i].setComentarios(odesPersonales[i].getComentarios());
					odesTamaino[i].setFecha(odesPersonales[i].getFecha());
					odesTamaino[i].setIdODE(odesPersonales[i].getIdODE());
					if(logger.isDebugEnabled())
						logger.debug("El identificador del ODE:"+odesTamaino[i].getIdODE());
					identificadoresOdesPersonales[i]=odesPersonales[i].getIdODE();//Los guardamos para hacer la consulta al localizador
					odesTamaino[i].setIdUsuario(odesPersonales[i].getIdUsuario());
					odesTamaino[i].setTitulo(odesPersonales[i].getTitulo());
					odesTamaino[i].setCompartir(odesPersonales[i].getCompartido());
				}
				Long[] tamainoOdes=null;
				if(identificadoresOdesPersonales!=null && identificadoresOdesPersonales.length>0){
					tamainoOdes=localizador.consultaEspacioLocalizadores(identificadoresOdesPersonales);
				}
				for(int i=0;i<odesPersonales.length;i++){
					if(tamainoOdes[i]!=null){
						if(logger.isDebugEnabled())
							logger.debug("taminoOdes[i]"+tamainoOdes[i]);
						//Vamos a insertar le tamaino en MB,no en bytes; 
						double div = (double) tamainoOdes[i]/(1024*1024);
						String pattern="###.##";
						java.text.DecimalFormat myFormatter = new java.text.DecimalFormat(pattern);
						String output = myFormatter.format(div);
						odesTamaino[i].setTamaino(output);
						if(logger.isDebugEnabled())
							logger.debug("Tamaino del ODE con id:"+odesTamaino[i].getIdODE()+ " con double ["+div+"] y su tamaino es:"+output);
					}else{
						odesTamaino[i].setTamaino("0");
						if(logger.isDebugEnabled())
							logger.debug("Tamaino del ODE con id:"+odesTamaino[i].getIdODE()+ "  su tamaino es: 0");
					}
				}
				if(logger.isDebugEnabled())
					logger.debug("Hemos salido de calcular los tamaños");
				form.setListaODESAsArray(odesTamaino);

				form.setIdUsuario(LdapUserDetailsUtils.getUsuario());
				if(logger.isDebugEnabled())
					logger.debug("Insertamos usuario");
				form.setTotalSuma(totalTamainoOdes(tamainoOdes));
				if(logger.isDebugEnabled())
					logger.debug("Hacemos la suma "+ form.getTotalSuma());
				long cuota=LdapUserDetailsUtils.getCuota()!=null?LdapUserDetailsUtils.getCuota():0L; //Lo tendremos que recoger de soporte
				if(logger.isDebugEnabled())
					logger.debug("Recogemos la cuota de soporte "+ cuota);
				form.setPorcentajeMemoriaCubierta(procentajeCubierto(form.getTotalSuma(),cuota));
				//La cuota irá en MB, no en bytes
				long divCuota = (long)cuota/(1024*1024);
				
				form.setCuotaUsuario(divCuota);
				form.setEspacioLibre(restanteTamaino(form.getTotalSuma(),cuota));
			}else{
				if(logger.isDebugEnabled())
					logger.debug("No tiene objetos personales");
				form.setListaODESAsArray(odesPersonales);
				form.setIdUsuario(LdapUserDetailsUtils.getUsuario());
				form.setTotalSuma(0L);
				form.setPorcentajeMemoriaCubierta(0);
				//La cuota debe ir en MB
				long divCuota = (long) ((LdapUserDetailsUtils.getCuota())/(1024*1024));
				
				form.setCuotaUsuario(divCuota);
				
				form.setEspacioLibre(LdapUserDetailsUtils.getCuota());
			}
		}catch(Exception e){
			logger.error("Error al obtener los objetos personales: " + e);
			throw new ValidatorException("{gestor.flujo.error.obtener.personales}");
		}
	}

	/**
	 * 
	 *  Este método sirve simplemente para resolver un bug de ibuilder: la imposibilidad de enviar
	 *  en la misma llamada un idoRowSelection y otro parámetro.
	 * 
	 */

	public void submitArchivos(ActionMapping mapping,
			es.pode.gestorFlujo.presentacion.objetosPersonales.SubmitArchivosForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 		Comprobamos que hay odes seleccionados
		try{
			List lista = (form).getIdODERowSelection();

			if (lista  != null)
			{
				form.setOrigen("personales");
				String[] lOdes = new String[lista.size()];
				lista.toArray(lOdes);
				form.setListODEs(lOdes);
			}
		} catch (Exception e){
    		logger.error("Se ha producido un error al intentar recuperar los ids de los odes a borrar: " +e);
    		throw e;
    	}

	}
	
	private long totalTamainoOdes(Long[] tamainosOdes){
		long suma=0;
		if(logger.isDebugEnabled())
			logger.debug("Estamos haciendo la suma");
		if (tamainosOdes!=null) {
			for (int i = 0; i < tamainosOdes.length; i++) {
				if(tamainosOdes[i]!=null)
					suma = suma + tamainosOdes[i];
			}
		}
		return suma;
	}
	private long restanteTamaino(Long suma, Long cuota){
		long restante=0;
		if(cuota>=suma){
			restante=cuota-suma;
		}
		return restante;
	}
	private int procentajeCubierto(Long suma, Long cuota){
		int porcentaje=0;
		double cuotaDou=new Double(cuota!=null?cuota:0L);
		double sumaDou=new Double(suma!=null?suma:0L);
		double div = new Double(sumaDou/cuotaDou);
		if(div >=0){
			if(div<=1){
				porcentaje=(int) java.lang.Math.ceil(div*100);//El techo para que la aprox. sea por arriba
				if(logger.isDebugEnabled())
					logger.debug("El porcentaje cubierto:["+porcentaje);
			}else{
				porcentaje=100;
				if(logger.isDebugEnabled())
					logger.debug("Si no es 100");
			}
		}else{
			porcentaje=0;//Para que no haya posiblidad de ningún número negativo
		}

		return porcentaje;

	}

	public void compartirDescompartirODE(ActionMapping mapping, CompartirDescompartirODEForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		ResultadoOperacionVO resultado;
		
		logger.debug("La variable que nos llega es:"+form.getIdODE()+" "+form.getCompartidoSN());
		if(!(Boolean.valueOf(form.getCompartidoSN()).booleanValue())){
			logger.debug("Vamos a COMPARTIRLO");
			resultado=this.getSrvPublicacionService().compartirODE(form.getIdODE());
		}else{
			resultado=this.getSrvPublicacionService().descompartirODE(form.getIdODE());
			logger.debug("Esta compartido y lo DESCOMPARTIREMOS");
		}
	}

	

	

}