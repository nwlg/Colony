/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.formularioAvanzado;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.agrega.soporte.serverProperties.DependentServerProperties;
import es.pode.buscador.presentacion.BuscarSession;
import es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl;
import es.pode.buscador.presentacion.basico.detallar.DetallarControllerImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.administrar.servicio.SrvNodoService;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoController
 */
public class FormularioAvanzadoControllerImpl extends FormularioAvanzadoController
{

	private static Logger logger = Logger.getLogger(BuscarAvanzadoControllerImpl.class);

	private java.util.Properties pSpringProperties = null;


    /**
     * @see es.pode.buscador.presentacion.avanzado.formularioAvanzado.FormularioAvanzadoController#prepararConsulta(org.apache.struts.action.ActionMapping, es.pode.buscador.presentacion.avanzado.formularioAvanzado.PrepararConsultaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void prepararConsulta(ActionMapping mapping, es.pode.buscador.presentacion.avanzado.formularioAvanzado.PrepararConsultaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	log("FormularioAvanzadoControllerImpl - prepararConsulta.");
    	inicializarSesion(request);
    	try{
	    	if(DetallarControllerImpl.TRUE.equals(AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO))) form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_NEUTRO);
	    	else form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    	}catch (Exception e)
    	{
    		log("No existe la propiedad neutro del agregaProperties");
    		form.setTipoLayoutBuscador(DetallarControllerImpl.LAYOUT_BUSCADOR);
    	}
    	NodoVO[] listaNodos = null;
		try{
			SrvNodoService nodo = this.getSrvNodoService();
			listaNodos = nodo.listarNodos();
			if(listaNodos.length > 0){
				ArrayList listaComunidades = new ArrayList();
				String stringComunidades="0"+DetallarControllerImpl.GUION+"1"+DetallarControllerImpl.GUION;
				listaComunidades.add(I18n.getInstance().getResource("configurar.avanzado.comunidades.Todas", BuscarAvanzadoControllerImpl.APPLICATION_PROPERTIES, (Locale) request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
				listaComunidades.add(DependentServerProperties.getInstance().getServerOn());
				for(int i=0; i<listaNodos.length;i++){
					listaComunidades.add(listaNodos[i].getNodo());
					if(i<listaNodos.length-1) stringComunidades=stringComunidades+String.valueOf(i+2)+DetallarControllerImpl.GUION;
					else stringComunidades=stringComunidades+String.valueOf(i+2);
				}
				form.setComunidades(listaComunidades);
				form.setEnlaceComunidadesSeleccionadas(stringComunidades);
			}else form.setComunidades(new ArrayList());
		}catch(Exception ex){
			form.setComunidades(new ArrayList());
			logger.error("BuscarAvanzadoControllerImpl - cargaFormularioBusquedaAvanzada ERROR: Error obteniendo nodos para configuracion búsqueda avanzada:",ex);
			saveErrorMessage(request,BuscarAvanzadoControllerImpl.MENSAJE_GENERICO_BUSQUEDA);
		}
     }

    private BuscarSession inicializarSesion(HttpServletRequest request){
		BuscarSession sesion = this.getBuscarSession(request);
//		Conservo los únicos parámetros constantes
		if(sesion.getEmpIdOde() != null || sesion.getEmpIdDestino() != null || sesion.getEmpTipoEmpaquetador() != null){
			log("FormularioAvanzadoControllerImpl - inicializarSesion: Se agrega ode federado al empaquetador con  IdOde:" +sesion.getEmpIdOde()+" IdDestino:"+sesion.getEmpIdDestino()+" TipoEmpaquetador:"+ sesion.getEmpTipoEmpaquetador());
			String idODe=sesion.getEmpIdOde();
			String idDestino=sesion.getEmpIdDestino();
			String tipoEmpaquetador=sesion.getEmpTipoEmpaquetador();
			sesion = new BuscarSession();
			sesion.setEmpIdOde(idODe);
			sesion.setEmpIdDestino(idDestino);
			sesion.setEmpTipoEmpaquetador(tipoEmpaquetador);
		}else{
			sesion = new BuscarSession();
		}
		this.setBuscarSession(request,sesion);
		return sesion;
	}

    private String array2String(String[] array) {
		String str = "";
		if (array != null && array.length > 0) for (int i = 0; i < array.length; i++)str+=array[i];
		return str;
	}
    private String getPropertyValue(String sKey) throws IOException {
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/spring_buscador.properties");
		if (this.pSpringProperties == null) {
			pSpringProperties = new java.util.Properties();
			pSpringProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();
		log("BuscarAvanzadoControllerImpl - getPropertyValue: Propiedad recuperada: " + sKey + " : "+ pSpringProperties.getProperty(sKey));
//		 devolvemos la propiedad
		return pSpringProperties.getProperty(sKey);
	}

    private void log(String traza){
		if (logger.isDebugEnabled())logger.debug(traza);
	}
}