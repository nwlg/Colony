/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.cerrar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import es.pode.modificador.negocio.servicio.CambioTypes;
import es.pode.modificador.negocio.servicio.Change;
import es.pode.modificador.negocio.servicio.Changes;
import es.pode.modificador.negocio.servicio.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.EspecialTermTypes;
import es.pode.modificador.presentacion.configurar.cambios.CambioSession;



/**
 * @see es.pode.modificador.presentacion.configurar.cambios.cerrar.CerrarController
 */
public class CerrarControllerImpl extends CerrarController
{


    /**
     * @see es.pode.modificador.presentacion.configurar.cambios.cerrar.CerrarController#cerrarSesion(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.cambios.cerrar.CerrarSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cerrarSesion(ActionMapping mapping, es.pode.modificador.presentacion.configurar.cambios.cerrar.CerrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Change change= new Change();
        CambioSession sesion = this.getCambioSession(request);
        if(sesion.getIdioma()!=null && !"".equals(sesion.getIdioma())) {
        	change.setLanguage(sesion.getIdioma());
        }
        change.setLomTerm(sesion.getLomTerm());
        change.setIdLomTerm(sesion.getIdLomTerm());
        change.setNewValue(sesion.getValorNuevo());
        change.setRegExp(sesion.getExprReg());
        change.setReplaceAll(sesion.getReplaceAll());
        if(sesion.getTipoAniadir()!=null)
        {
        	change.setTermType(EspecialTermTypes.fromString(sesion.getTipoAniadir()));
        }
        change.setMainLomOnly(sesion.getAlcance());
        change.setType(CambioTypes.fromValue(sesion.getTipo()));       
		if(sesion.getValor()!=null && !"".equals(sesion.getValor())) {
        	change.setValue(sesion.getValor());
        }
        if(sesion.getPosicion()!=null)
        {
        	Integer posicion=this.getCambioSession(request).getPosicion();
        	ConfiguracionTarea config = this.getConfigurarModificacionSession(request).getConfiguracion();
        	Changes cambios = config.getCambios();
        	Change[] arrayCambios = cambios.getCambios();
        	arrayCambios[posicion.intValue()]=change;
        	cambios.setCambios(arrayCambios);
        	config.setCambios(cambios);
        	this.getConfigurarModificacionSession(request).setConfiguracion(config);
        }
        else
        {

        	//desde el cambios.getCambios();
        	ConfiguracionTarea config = this.getConfigurarModificacionSession(request).getConfiguracion();
        	Changes cambios = config.getCambios();
        	Change[] arrayCambios = cambios.getCambios();
        	List arrayCamb=new ArrayList();	
        	
        	arrayCamb.addAll(Arrays.asList(arrayCambios));
        	arrayCamb.add(change);
        	arrayCambios =(Change[])arrayCamb.toArray(new Change[arrayCamb.size()]);
        	cambios.setCambios(arrayCambios);
        	config.setCambios(cambios);
        	this.getConfigurarModificacionSession(request).setConfiguracion(config);
        }
        
       
        this.removeCambioSession(request);
        
    }









}