/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarGrupo;


import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.adminusuarios.negocio.servicios.GrupoVO;
import es.pode.adminusuarios.negocio.servicios.RolVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;


/**
 * @see es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController
 */
public class ModificarGruposControllerImpl extends ModificarGruposController {

    private static Logger log = Logger.getLogger(ModificarGruposControllerImpl.class);

    /**
     * @see es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController#cargarDescripcion(org.apache.struts.action.ActionMapping,
     *      es.pode.administracion.presentacion.adminusuarios.modificarGrupo.CargarDescripcionForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDescripcion(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarGrupo.CargarDescripcionForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    
		try {
		   
		    Long id = Long.valueOf(request.getParameter("id"));
		    GrupoVO grupo = this.getSrvAdminUsuariosService().descripcionGrupo(id);
		    if(log.isDebugEnabled())log.debug("Obtengo el grupoVO seleccionado");
		    form.setDescripcion(grupo.getDescripcion());
		    form.setId(grupo.getId());
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{modificarGrupo.error}");
		}
    }

    /**
     * @see es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController#recuperarRoles(org.apache.struts.action.ActionMapping,
     *      es.pode.administracion.presentacion.adminusuarios.modificarGrupo.RecuperarRolesForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarRoles(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarGrupo.RecuperarRolesForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		try {
		    String descripcion = request.getParameter("descripcion");
		    if(log.isDebugEnabled())log.debug("El valor de id es " + descripcion);
		    
		    //VALIDACION DE CARACTERES INCORRECTOS
		    Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
		    Matcher matcher = null;
		    
		    matcher = mask.matcher(descripcion);
		    if (!matcher.matches()) {
		    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
		    	throw new ValidatorException("{errors.altagrupo.descripcion.caracterIlegal}");
		    }
		    
		    Long id = Long.valueOf(request.getParameter("id"));
		    if(log.isDebugEnabled())log.debug("Chequeo si la descripcion ya esta asociada a otro grupo");
		    GrupoVO grupoVO = this.getSrvAdminUsuariosService().descripcionGrupo(id);
		    if ((this.getSrvAdminUsuariosService().existeDescripcion(descripcion, id)).booleanValue()) {
		    	if(log.isDebugEnabled())log.debug("Ya existe un grupo en el sistema con esa descripcion");
			throw new ValidatorException("{errors.modificaciongrupo.descripcionExistente}");
		    }
		    if (descripcion.length() > 0) {
	
			grupoVO.setDescripcion(descripcion);
			this.getModificarGrupoBSession(request).setGrupoVO(grupoVO);
			if(log.isDebugEnabled())log.debug("guardo el grupoVO en sesion");
		    } else {
		    	if(log.isDebugEnabled())log.debug("La descripcion introducida es nula");
			throw new ValidatorException("{errors.modificaciongrupo.descripcion}");
		    }
		    try {
			RolVO[] rolVO = this.getSrvAdminUsuariosService().listarRoles();
			RolVOCheck[] rolVOCheck = null;
			rolVOCheck = obtenerRolCheck(rolVO, grupoVO);
			// form.setRolesAsArray(rolVO);
			form.setRolesAsArray(rolVOCheck);
	
		    } catch (Exception e) {
			log.error("Error: " + e);
			throw new ValidatorException("{modificarGrupo.errorRoles}");
		    }
		} catch (ValidatorException validator) {
		    throw validator;
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{modificarGrupo.errorRoles}");
		}

    }

    /**
     * @see es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGruposController#modificarGrupo(org.apache.struts.action.ActionMapping,
     *      es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGrupoForm,
     *      javax.servlet.http.HttpServletRequest,
     *      javax.servlet.http.HttpServletResponse)
     */
    public final void modificarGrupo(ActionMapping mapping,
	    es.pode.administracion.presentacion.adminusuarios.modificarGrupo.ModificarGrupoForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		try {
		    GrupoVO grupoVO = (this.getModificarGrupoBSession(request)).getGrupoVO();
		    if(log.isDebugEnabled())log.debug("La nueva descripcion es " + grupoVO.getDescripcion());
		    String[] ids = form.getIdRowSelectionAsArray();
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		    if (ids == null) {
		    	if(log.isDebugEnabled())log.debug("No se ha seleccionado ningun permiso");
			throw new ValidatorException("{errors.modificaciongrupo.roles}");
		    } else {
			//Chequeamos si ese grupo es administrador y se ha deschequeado el rol administrador
	
			if ((esGrupoAdmin(grupoVO)).booleanValue() && (!((administradorSelected(ids)).booleanValue()))) {
				if(log.isDebugEnabled()){log.debug("El grupo no ha seleccionado el rol administrador se comprobara si existe otro grupo administrador");
			    log.debug("srvAdminUsuariosService.obtenerGrupoAdministrador() "
				    + srvAdminUsuariosService.obtenerGrupoAdministrador());
			    log.debug("srvAdminUsuariosService.obtenerGrupoAdministrador().length "
				    + srvAdminUsuariosService.obtenerGrupoAdministrador().length);
				}
			    if (srvAdminUsuariosService.obtenerGrupoAdministrador().length == 1) {
			    	if(log.isDebugEnabled())log.debug("No se permite modificar los roles es el unico grupo administrador");
				throw new ValidatorException("{errors.modificaciongrupo.unicoAdmin}");
			    } else {
			    	if(log.isDebugEnabled())log.debug("Tenemos mas de un grupo administrador");
				//Vamos a comprobar que otros grupos administradores tengan al menos un usuario
				if(!(existenUsuariosGruposAdmin(grupoVO).booleanValue()))
				{
					if(log.isDebugEnabled())log.debug("El resto de grupos administradores no tienen usuarios asociados no dejo modificar");
				 throw new ValidatorException("{errors.modificaciongrupo.unicoAdmin}");
				}else
				{
				RolVO[] rolVO = new RolVO[ids.length];
				Long idL = null;
				for (int i = 0; i < ids.length; i++) {
				    idL = new Long(ids[i]);
	
				    RolVO rolG = srvAdminUsuariosService.getRol(idL);
				    // rolG.setId(idL);
				    rolVO[i] = rolG;
	
				}
				grupoVO.setRols(rolVO);
				}
			    }
			} else {
			    RolVO[] rolVO = new RolVO[ids.length];
	
			    Long idL = null;
			    for (int i = 0; i < ids.length; i++) {
				idL = new Long(ids[i]);
	
				RolVO rolG = srvAdminUsuariosService.getRol(idL);
				// rolG.setId(idL);
				rolVO[i] = rolG;
	
			    }
			    grupoVO.setRols(rolVO);
			}
		    }
		    
		    Long idModificado = grupoVO.getId();
		    form.setIdModificado(idModificado);
		    
		    if(log.isDebugEnabled())log.debug("Elimino de la sesion la descripcion del grupo");
		    this.removeModificarGrupoBSession(request);
		    srvAdminUsuariosService.modificarGrupo(grupoVO);
		    form.setResultado("grupos.modificar.OK");
		    // /Elimino de la sesion la descripcion del grupo
		} catch (ValidatorException ve) {
		    log.error("se produce una excepcion " + ve);
		    form.setResultado("grupos.modificar.FALLO");
		    throw ve;
		} catch (Exception e) {
	
		    log.error("Error: " + e);
		    form.setResultado("grupos.modificar.FALLO");
		    //throw new ValidatorException("{modificarGrupo.errorRoles}");
		}
    }


    private Boolean esGrupoAdmin(GrupoVO grupo) {
    	
		Boolean resultado = new Boolean(false);
		RolVO[] roles = grupo.getRols();
		for (int i = 0; i < roles.length; i++) {
		    if (roles[i].getDescripcion().equalsIgnoreCase("administrador")) {
		    	resultado = new Boolean(true);
		    }
		}
		return resultado;
    }

    private Boolean administradorSelected(String[] ids) {
    	
		Boolean resultado = new Boolean(false);
		try {
		    Long idL = null;
		    for (int i = 0; i < ids.length; i++) {
		    	idL = new Long(ids[i]);
	
		    	RolVO rolG = this.getSrvAdminUsuariosService().getRol(idL);
		    	if (rolG.getDescripcion().equalsIgnoreCase("administrador")) {
		    		resultado = new Boolean(true);
		    	}
		    }
		} catch (Exception e) {
		    log.error("Se ha producido una excepcion " + e);
		}
		return resultado;
    }
    
    private Boolean existenUsuariosGruposAdmin(GrupoVO grupoVO) throws Exception{
	Boolean resultado = new Boolean(false);
		try
		{
			Long[] idAdmin = this.getSrvAdminUsuariosService().obtenerGrupoAdministrador();
			String descripcion = grupoVO.getDescripcion();
			for(int i=0;i<idAdmin.length;i++)
			{
			   GrupoVO grupoAdmin = this.getSrvAdminUsuariosService().descripcionGrupo(idAdmin[i]);
			   if((grupoAdmin.getDescripcion()).equalsIgnoreCase(descripcion))
			   {
				   if(log.isDebugEnabled())log.debug("El grupo administrador es el que queremos modificar");  
			   }else
			   {
			     if(this.getSrvAdminUsuariosService().obtenerUsuariosGrupo(idAdmin[i]).booleanValue()){
			    	 resultado = new Boolean(true);
			     }
			   }
			}
		}catch(Exception e)
		{
		  log.error("Se produce la siguiente excepcion "+e);  
		}
		return resultado;
    }

    private RolVOCheck[] obtenerRolCheck(RolVO[] rolVO, GrupoVO grupoVO) {
    	
		RolVOCheck[] resultado = null;
		resultado = new RolVOCheck[rolVO.length];
		RolVO[] rolesGrupo = grupoVO.getRols();
		Vector vRol = new Vector();
	
		for (int j = 0; j < rolesGrupo.length; j++) {
		    vRol.add(rolesGrupo[j].getId());
		}
	
		for (int i = 0; i < rolVO.length; i++) {
		    RolVOCheck rol = new RolVOCheck();
		    rol.setId(rolVO[i].getId());
		    rol.setDescripcion(rolVO[i].getDescripcion());
		    if (vRol.contains(rolVO[i].getId())) {
			rol.setChecked(Boolean.TRUE);
		    } else {
			rol.setChecked(Boolean.FALSE);
		    }
		    resultado[i] = rol;
		}
	
		return resultado;
    }

    // Nueva clase para obtener los roles que tiene asociados ese grupo
    public class RolVOCheck {
	private Long id;

	private String descripcion;

	private Boolean checked;

	public RolVOCheck() {
	}

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getDescripcion() {
	    return descripcion;
	}

	public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
	}

	public void setChecked(Boolean checked) {
	    this.checked = checked;
	}

	public Boolean getChecked() {
	    return checked;
	}
    }

}