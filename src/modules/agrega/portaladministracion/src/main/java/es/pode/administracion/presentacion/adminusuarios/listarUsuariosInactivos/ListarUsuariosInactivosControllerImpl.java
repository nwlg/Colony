/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.UsuarioVO;



/**
 * @see es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ListarUsuariosInactivosController
 */
public class ListarUsuariosInactivosControllerImpl extends ListarUsuariosInactivosController
{


	private static Logger log = Logger.getLogger(ListarUsuariosInactivosControllerImpl.class);




    /**
     * @see es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ListarUsuariosInactivosController#obtenerUsuariosInactivos(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ObtenerUsuariosInactivosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerUsuariosInactivos(ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ObtenerUsuariosInactivosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	// el idioma será el que tenga en el atributo idioma del usuario
    	// que esta en sesion.
    	try {
    	   
    		 UsuarioVO[] usuarioVO = this.getSrvAdminUsuariosService().listarUsuariosInactivos();
    		
    		 UsuarioVODate[] usuariosDate = null;
    		
    		 if (usuarioVO != null) {
    			 
    			 usuariosDate = cambiarFormatoUsuarios(usuarioVO);
    			 
    			 log("Obtenemos los usuarios inactivos");
    			 
    	    	 form.setUsuariosAsArray(usuariosDate);
    		}
    		
    	   
    	    
    	} catch (Exception e) {
    	    log.error("Error: " + e);
    	    throw new ValidatorException("{errors.listarUsuariosInactivos}");
    	}
     }



    /**
     * @see es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ListarUsuariosInactivosController#getIds(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.GetIdsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void getIds(ActionMapping mapping, es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.GetIdsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    	    List lista = ((FormularioListadoUsuariosInactivosBajaFormImpl) form).getIdRowSelection();
    	    if (lista == null) {

    		throw new ValidatorException("{errors.borrarUsuario.idNulo}");
    	    } else {

    		Long[] usuariosAdmin = this.getSrvAdminUsuariosService().obtenerUsuariosAdministrador();

    		List gruposAdminList = Arrays.asList(usuariosAdmin);

    		int num_Admin = usuariosAdmin.length;
    		int usuarioDeleted = 0;
    		Iterator iter = lista.iterator();
    		while (iter.hasNext()) {
    		    Long identificador = new Long((String) iter.next());
    		    if (gruposAdminList.contains(identificador)) {
    			usuarioDeleted = usuarioDeleted + 1;
    		    }
    		}

    		if (usuarioDeleted == num_Admin) {
    		    log("Se intenta eliminar todos los usuarios que son administrador no se permite");
    		    throw new ValidatorException("{errors.borrarUsuario.todosUsuariosAdmin}");
    		}
    		form.setIds(lista);
    	    }
    	} catch (ValidatorException validator) {
    	    log.error("Se ha producido la siguiente exception " + validator);
    	    throw validator;
    	} catch (Exception e) {
    	    log.error("Se produce una excepcion ", e);
    	    throw new ValidatorException("{errors.borrarUsuario}");
    	}
     }

    
    /** Copiamos todos los usuarios que vienen en el arrays de usuarios recibidos en un nuevo array 
     * de usuarios cambiandole la fechaDesactivacion a tipo Date en vez de Calendar
     * */
    private UsuarioVODate[] cambiarFormatoUsuarios(UsuarioVO[] usuario) 
    {

    	UsuarioVODate[] usuariosDate = new UsuarioVODate[usuario.length];
    	
		for(int i=0; i<usuario.length; i++)
		{
			usuariosDate[i] = cambiarFormatoUsuario(usuario[i]);
		}

		return usuariosDate;
    }
    
    
    /** Copiamos todos los campos del usuario recibido y los metemos en el uevo usuario cambiando 
     * la fechaDesactivacion a Date
     * */
    
    private UsuarioVODate cambiarFormatoUsuario(UsuarioVO usuario) 
    {

    	UsuarioVODate usuarioDate = new UsuarioVODate();
    	
    	//Rellenamos el nuevo UsuarioVO con la fechaDesactivacion a Date
    	usuarioDate.setId(usuario.getId());
    	usuarioDate.setNombre(usuario.getNombre());
        usuarioDate.setApellido1(usuario.getApellido1());
        usuarioDate.setApellido2(usuario.getApellido2());
        usuarioDate.setEmail(usuario.getEmail());
        usuarioDate.setNIF(usuario.getNIF());
        usuarioDate.setUsuario(usuario.getUsuario());
        usuarioDate.setClave(usuario.getClave());
        usuarioDate.setIdioma(usuario.getIdioma());
        usuarioDate.setIdiomaBusqueda(usuario.getIdiomaBusqueda());
        usuarioDate.setTipoEmpaquetador(usuario.getTipoEmpaquetador());
        usuarioDate.setFechaAlta(usuario.getFechaAlta());
        usuarioDate.setFechaBaja(usuario.getFechaBaja());
        usuarioDate.setFechaSolicitudAlta(usuario.getFechaSolicitudAlta());
        usuarioDate.setClaveEncriptada(usuario.getClaveEncriptada());

        if(usuario.getFechaDesactivacion() != null)
        	usuarioDate.setFechaDesactivacion(usuario.getFechaDesactivacion().getTime());

        
    	    	
		return usuarioDate;
    }

    
    public class UsuarioVODate {
        
    	private java.lang.Long id;

        private java.lang.String nombre;

        private java.lang.String apellido1;

        private java.lang.String apellido2;

        private java.lang.String email;

        private java.lang.String NIF;

        private java.lang.String usuario;

        private java.lang.String clave;

        private java.lang.String idioma;

        private java.lang.String idiomaBusqueda;

        private java.lang.String tipoEmpaquetador;

        private java.util.Calendar fechaAlta;

        private java.util.Calendar fechaBaja;

        private java.util.Calendar fechaSolicitudAlta;

        private java.lang.String claveEncriptada;

        private java.util.Date fechaDesactivacion;

        private es.pode.adminusuarios.negocio.servicios.GrupoVO[] grupos;

        public UsuarioVODate() {
        }


        /**
         * Gets the id value for this UsuarioVO.
         * 
         * @return id
         */
        public java.lang.Long getId() {
            return id;
        }


        /**
         * Sets the id value for this UsuarioVO.
         * 
         * @param id
         */
        public void setId(java.lang.Long id) {
            this.id = id;
        }


        /**
         * Gets the nombre value for this UsuarioVO.
         * 
         * @return nombre
         */
        public java.lang.String getNombre() {
            return nombre;
        }


        /**
         * Sets the nombre value for this UsuarioVO.
         * 
         * @param nombre
         */
        public void setNombre(java.lang.String nombre) {
            this.nombre = nombre;
        }


        /**
         * Gets the apellido1 value for this UsuarioVO.
         * 
         * @return apellido1
         */
        public java.lang.String getApellido1() {
            return apellido1;
        }


        /**
         * Sets the apellido1 value for this UsuarioVO.
         * 
         * @param apellido1
         */
        public void setApellido1(java.lang.String apellido1) {
            this.apellido1 = apellido1;
        }


        /**
         * Gets the apellido2 value for this UsuarioVO.
         * 
         * @return apellido2
         */
        public java.lang.String getApellido2() {
            return apellido2;
        }


        /**
         * Sets the apellido2 value for this UsuarioVO.
         * 
         * @param apellido2
         */
        public void setApellido2(java.lang.String apellido2) {
            this.apellido2 = apellido2;
        }


        /**
         * Gets the email value for this UsuarioVO.
         * 
         * @return email
         */
        public java.lang.String getEmail() {
            return email;
        }


        /**
         * Sets the email value for this UsuarioVO.
         * 
         * @param email
         */
        public void setEmail(java.lang.String email) {
            this.email = email;
        }


        /**
         * Gets the NIF value for this UsuarioVO.
         * 
         * @return NIF
         */
        public java.lang.String getNIF() {
            return NIF;
        }


        /**
         * Sets the NIF value for this UsuarioVO.
         * 
         * @param NIF
         */
        public void setNIF(java.lang.String NIF) {
            this.NIF = NIF;
        }


        /**
         * Gets the usuario value for this UsuarioVO.
         * 
         * @return usuario
         */
        public java.lang.String getUsuario() {
            return usuario;
        }


        /**
         * Sets the usuario value for this UsuarioVO.
         * 
         * @param usuario
         */
        public void setUsuario(java.lang.String usuario) {
            this.usuario = usuario;
        }


        /**
         * Gets the clave value for this UsuarioVO.
         * 
         * @return clave
         */
        public java.lang.String getClave() {
            return clave;
        }


        /**
         * Sets the clave value for this UsuarioVO.
         * 
         * @param clave
         */
        public void setClave(java.lang.String clave) {
            this.clave = clave;
        }


        /**
         * Gets the idioma value for this UsuarioVO.
         * 
         * @return idioma
         */
        public java.lang.String getIdioma() {
            return idioma;
        }


        /**
         * Sets the idioma value for this UsuarioVO.
         * 
         * @param idioma
         */
        public void setIdioma(java.lang.String idioma) {
            this.idioma = idioma;
        }


        /**
         * Gets the idiomaBusqueda value for this UsuarioVO.
         * 
         * @return idiomaBusqueda
         */
        public java.lang.String getIdiomaBusqueda() {
            return idiomaBusqueda;
        }


        /**
         * Sets the idiomaBusqueda value for this UsuarioVO.
         * 
         * @param idiomaBusqueda
         */
        public void setIdiomaBusqueda(java.lang.String idiomaBusqueda) {
            this.idiomaBusqueda = idiomaBusqueda;
        }


        /**
         * Gets the tipoEmpaquetador value for this UsuarioVO.
         * 
         * @return tipoEmpaquetador
         */
        public java.lang.String getTipoEmpaquetador() {
            return tipoEmpaquetador;
        }


        /**
         * Sets the tipoEmpaquetador value for this UsuarioVO.
         * 
         * @param tipoEmpaquetador
         */
        public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador) {
            this.tipoEmpaquetador = tipoEmpaquetador;
        }


        /**
         * Gets the fechaAlta value for this UsuarioVO.
         * 
         * @return fechaAlta
         */
        public java.util.Calendar getFechaAlta() {
            return fechaAlta;
        }


        /**
         * Sets the fechaAlta value for this UsuarioVO.
         * 
         * @param fechaAlta
         */
        public void setFechaAlta(java.util.Calendar fechaAlta) {
            this.fechaAlta = fechaAlta;
        }


        /**
         * Gets the fechaBaja value for this UsuarioVO.
         * 
         * @return fechaBaja
         */
        public java.util.Calendar getFechaBaja() {
            return fechaBaja;
        }


        /**
         * Sets the fechaBaja value for this UsuarioVO.
         * 
         * @param fechaBaja
         */
        public void setFechaBaja(java.util.Calendar fechaBaja) {
            this.fechaBaja = fechaBaja;
        }


        /**
         * Gets the fechaSolicitudAlta value for this UsuarioVO.
         * 
         * @return fechaSolicitudAlta
         */
        public java.util.Calendar getFechaSolicitudAlta() {
            return fechaSolicitudAlta;
        }


        /**
         * Sets the fechaSolicitudAlta value for this UsuarioVO.
         * 
         * @param fechaSolicitudAlta
         */
        public void setFechaSolicitudAlta(java.util.Calendar fechaSolicitudAlta) {
            this.fechaSolicitudAlta = fechaSolicitudAlta;
        }


        /**
         * Gets the claveEncriptada value for this UsuarioVO.
         * 
         * @return claveEncriptada
         */
        public java.lang.String getClaveEncriptada() {
            return claveEncriptada;
        }


        /**
         * Sets the claveEncriptada value for this UsuarioVO.
         * 
         * @param claveEncriptada
         */
        public void setClaveEncriptada(java.lang.String claveEncriptada) {
            this.claveEncriptada = claveEncriptada;
        }


        /**
         * Gets the fechaDesactivacion value for this UsuarioVO.
         * 
         * @return fechaDesactivacion
         */
        public java.util.Date getFechaDesactivacion() {
            return fechaDesactivacion;
        }


        /**
         * Sets the fechaDesactivacion value for this UsuarioVO.
         * 
         * @param fechaDesactivacion
         */
        public void setFechaDesactivacion(java.util.Date fechaDesactivacion) {
            this.fechaDesactivacion = fechaDesactivacion;
        }


        /**
         * Gets the grupos value for this UsuarioVO.
         * 
         * @return grupos
         */
        public es.pode.adminusuarios.negocio.servicios.GrupoVO[] getGrupos() {
            return grupos;
        }


        /**
         * Sets the grupos value for this UsuarioVO.
         * 
         * @param grupos
         */
        public void setGrupos(es.pode.adminusuarios.negocio.servicios.GrupoVO[] grupos) {
            this.grupos = grupos;
        }
        
    }
    
        
    
    private void log(Object obj) {
    	
    	if (log.isDebugEnabled())
    	    log.debug(obj);
        }




}