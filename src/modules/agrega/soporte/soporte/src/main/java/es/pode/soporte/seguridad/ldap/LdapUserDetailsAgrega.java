/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;
import javax.naming.ldap.Control;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.userdetails.ldap.LdapUserDetails;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import es.pode.soporte.seguridad.servicios.UsuarioVO;


/**
 * UserDetails de Agrega para cuando usamos como back-end el ldap.
 * Los atributos nuevos son:
 * -idioma predeterminado de las búsquedas
 * -idioma
 * -nombre completo
 * -correo electrónico
 * -tipo de empaquetador
 * Se añadirán dos nuevos campos: tipo de catalogador y la cuota
 * */
public class LdapUserDetailsAgrega implements LdapUserDetails
{

	private static final long serialVersionUID = -2911263891208481635L;
	private static final GrantedAuthority NO_AUTHORITIES[] = new GrantedAuthority[0];
    private static final Control NO_CONTROLS[] = new Control[0];
    private Attributes attributes;
    private String dn;
    private String password;
    private String username;
    private GrantedAuthority authorities[];
    private Control controls[];
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    
    /**
     * Idioma predeterminado de las búsquedas
     * */
    private String idiomaBusqueda;
       
    /**
     * Codigo idioma del portal. Lo obtenemos del atributo preferredlanguage de ldap
     * */
    private String idioma;
    
    /**
     * Nombre completo del usuario.Lo obtenemos del atributo sn de ldap
     * */
    private String nombreCompleto;
        
    /**
     * Correo electrónico
     * */
    private String mail;    

    /**
     * Tipo de empaquetador elegido por defecto del usuario. Atributo employeeType del ldap
     * */
    private String empaquetador;    

    /**
     * Login del usuario. Atributo cn del ldap
     * */
    private String login;   
    
    /**
     * Tipo de catalogador
     * */
    private String catalogador;
    
    /**
     * Cuota del usuario
     * */
    private Long cuota;

    
	public static class Essence
    {
		private static Logger log = Logger.getLogger(Essence.class);
		
        public Essence addAuthority(GrantedAuthority a)
        {
            mutableAuthorities.add(a);
            return this;
        }

        public LdapUserDetails createUserDetails()
        {
            Assert.notNull(instance, "Essence can only be used to create a single instance");
            instance.authorities = getGrantedAuthorities();
            LdapUserDetails newInstance = instance;
            instance = null;            
            return newInstance;
        }

        public GrantedAuthority[] getGrantedAuthorities()
        {
            return (GrantedAuthority[])(GrantedAuthority[])mutableAuthorities.toArray(new GrantedAuthority[0]);
        }

        public Essence setAccountNonExpired(boolean accountNonExpired)
        {
            instance.accountNonExpired = accountNonExpired;
            return this;
        }

        public Essence setAccountNonLocked(boolean accountNonLocked)
        {
            instance.accountNonLocked = accountNonLocked;
            return this;
        }

        /*
         * Modificamos este metodo para setear los siguientes atributos:
         * -idioma de las búsquedas
         * -idioma.
         * -nombreCompleto
         * -Correo electrónico
         * -Tipo de empaquetador
         * -Login del usuario
         * - Tipo de catalogador
         * - Cuota del usuario
         * */
        public Essence setAttributes(Attributes attributes) 
        {
            instance.attributes = attributes;
                         
            try 
            {
        		log("Se añaden los atributos propios del usuario");            	            	
				instance.idiomaBusqueda=(String)attributes.get("initials").get(0);
				instance.idioma=(String)attributes.get("preferredlanguage").get(0);
				instance.nombreCompleto=(String)attributes.get("sn").get(0);
				instance.mail=(String)attributes.get("mail").get(0);
				instance.empaquetador=(String)attributes.get("employeeType").get(0);
				instance.login=(String)attributes.get("cn").get(0);
				instance.cuota=(Long)attributes.get("employeeNumber").get(0);
				instance.catalogador=(String)attributes.get("businessCategory").get(0);
					
			} 
            catch (NamingException e) 
            {
            	log.error(e);
			}
            
            return this;
        }
        
        /*
         * Modificamos este metodo para setear los siguientes atributos:
         * -idioma de las búsquedas
         * -idioma.
         * -nombreCompleto
         * -Correo electrónico
         * -Tipo de empaquetador
         * -Login del usuario
         * - Tipo de catalogador
         * - Cuota del usuario
         * */
        public Essence setDatosUsuario(String usuario) 
        {
            try 
            {
        		log("Se añaden los datos del usuario recuperados de un web service");
            	UsuarioVO datosUsuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(usuario);

				instance.idiomaBusqueda = datosUsuario.getIdiomaBusqueda();				
        		log("Idioma de búsqueda: " + instance.idiomaBusqueda);
        		
				instance.idioma = datosUsuario.getIdioma();
        		log("Idioma: " + instance.idioma);

				instance.mail = datosUsuario.getEmail();				
        		log("Email: " + instance.mail);

				instance.empaquetador = datosUsuario.getTipoEmpaquetador();
				log("Tipo empaquetador: " + instance.empaquetador);

				instance.login = datosUsuario.getUsuario();
				log("Login: " + instance.login);

				StringBuffer nombre = new StringBuffer();
				nombre.append(datosUsuario.getNombre());
				nombre.append(" ");
				nombre.append(datosUsuario.getApellido1());
				nombre.append(" ");
				nombre.append(datosUsuario.getApellido2());
				
				instance.nombreCompleto = nombre.toString();
				log("Nombre: " + instance.nombreCompleto);
				
				instance.catalogador = datosUsuario.getTipoCatalogador();
				log("Catalogador: "+ instance.catalogador);
				
				instance.cuota = datosUsuario.getCuota();
				log("Cuota: "+ instance.cuota);
			} 
            catch (Exception e) 
            {
            	log.error(e);
			}
            
            return this;
        }
        

        
        /*
         * Modificamos este metodo para añadir en el contexto los roles del sistema asociados a los roles
         * de acceso como GrantedAuthority
         * */

        public Essence setAuthorities(GrantedAuthority authorities[], String usuario, String password)
        {
            usuario = usuario.toLowerCase();
        	mutableAuthorities = new ArrayList(Arrays.asList(authorities));
            
           	log("Rol/es del usuario: " + mutableAuthorities.toString());
            
            GrantedAuthority[] rolesUsuario = WrapperSrvAdminUsuarios.obtenerRoles(authorities,usuario,password);
            
            if (rolesUsuario.length == 1 && rolesUsuario[0].getAuthority().equals("error"))
            {
        		log("Invalidación del contexto de Acegi");            	
            	mutableAuthorities.clear();
            	setEnabled(false);
            }
            else if(rolesUsuario.length > 0)
            {            	
            	log("Se añaden los roles al contexto de Acegi " + rolesUsuario.length);
            	mutableAuthorities.addAll(Arrays.asList(rolesUsuario));	
            }
            
            return this;
        }

        public void setControls(Control controls[])
        {
            instance.controls = controls;
        }

        public Essence setCredentialsNonExpired(boolean credentialsNonExpired)
        {
            instance.credentialsNonExpired = credentialsNonExpired;
            return this;
        }

        public Essence setDn(String dn)
        {
            instance.dn = dn;
            return this;
        }

        public Essence setEnabled(boolean enabled)
        {
            instance.enabled = enabled;
            return this;
        }

        public Essence setPassword(String password)
        {
            instance.password = password;
            return this;
        }

        public Essence setUsername(String username)
        {
            instance.username = username;
            return this;
        }

        LdapUserDetailsAgrega instance;
        List mutableAuthorities;

        public Essence()
        {
            instance = new LdapUserDetailsAgrega();
            mutableAuthorities = new ArrayList();
        }

        public Essence(LdapUserDetails copyMe)
        {
        	log("Constructor Essence");
            instance = new LdapUserDetailsAgrega();
            mutableAuthorities = new ArrayList();
            setDn(copyMe.getDn());
            setUsername(copyMe.getUsername().toLowerCase());
            setPassword(copyMe.getPassword());
            setEnabled(copyMe.isEnabled());
            setAccountNonExpired(copyMe.isAccountNonExpired());
            setCredentialsNonExpired(copyMe.isCredentialsNonExpired());
            setAccountNonLocked(copyMe.isAccountNonLocked());
            setControls(copyMe.getControls());
            setAuthorities(copyMe.getAuthorities(),copyMe.getUsername(),copyMe.getPassword());
            //Aqui seteamos los siguiente atributos:idioma,idioma de búsqueda...
            setDatosUsuario(copyMe.getUsername().toLowerCase());
            //setAttributes(copyMe.getAttributes());
        }
        
    	private static void log (Object obj)
    	{
    		if (log.isDebugEnabled())
    			log.debug(obj);
    	}
    }

    protected LdapUserDetailsAgrega()
    {
        attributes = new BasicAttributes();
        authorities = NO_AUTHORITIES;
        controls = NO_CONTROLS;
        accountNonExpired = true;
        accountNonLocked = true;
        credentialsNonExpired = true;
        enabled = true;
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public GrantedAuthority[] getAuthorities()
    {
        return authorities;
    }

    public Control[] getControls()
    {
        return controls;
    }

    public String getDn()
    {
        return dn;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

	public String getIdiomaBusqueda() 
	{
		return idiomaBusqueda;
	}

	public void setIdiomaBusqueda(String idiomaBusqueda) 
	{
		this.idiomaBusqueda = idiomaBusqueda;
	}

	public String getIdioma() 
	{
		return idioma;
	}

	public void setIdioma(String idioma) 
	{
		this.idioma = idioma;
	}

	public void setAccountNonExpired(boolean accountNonExpired) 
	{
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) 
	{
		this.accountNonLocked = accountNonLocked;
	}

	public void setAttributes(Attributes attributes) 
	{
		this.attributes = attributes;
	}

	public void setAuthorities(GrantedAuthority[] authorities) 
	{
		this.authorities = authorities;
	}

	public void setControls(Control[] controls) 
	{
		this.controls = controls;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) 
	{
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setDn(String dn) 
	{
		this.dn = dn;
	}

	public void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getNombreCompleto() 
	{
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) 
	{
		this.nombreCompleto = nombreCompleto;
	}

	public String getMail() 
	{
		return mail;
	}

	public void setMail(String mail) 
	{
		this.mail = mail;
	}

	public String getEmpaquetador() 
	{
		return empaquetador;
	}

	public void setEmpaquetador(String empaquetador) 
	{
		this.empaquetador = empaquetador;
	}
	
	public String getLogin() 
	{
		return login;
	}

	public void setLogin(String login) 
	{
		this.login = login;
	}
	
	public String getCatalogador() 
	{
		return catalogador;
	}

	public void setCatalogador(String catalogador) 
	{
		this.catalogador = catalogador;
	}
	
	public Long getCuota() 
	{
		return cuota;
	}

	public void setCuota(Long cuota) 
	{
		this.cuota = cuota;
	}
}