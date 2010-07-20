/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.pode.soporte.seguridad.openId.providers.openid;

//import org.springframework.security.GrantedAuthority;
import org.acegisecurity.GrantedAuthority;

import org.acegisecurity.providers.AbstractAuthenticationToken;



/**
 * OpenID Authentication Token
 *
 * @author Robin Bramley, Opsera Ltd
 */
public class OpenIDAuthenticationToken extends AbstractAuthenticationToken {
    //~ Instance fields ================================================================================================

    private OpenIDAuthenticationStatus status;
    private String identityUrl;
    private String message;

    //~ Constructors ===================================================================================================

    public OpenIDAuthenticationToken(OpenIDAuthenticationStatus status, String identityUrl, String message) {
        super(new GrantedAuthority[0]);
        this.status = status;
        this.identityUrl = identityUrl;
        this.message = message;
        setAuthenticated(false);
    }

    /**
     * Created by the OpenIDAuthenticationProvider on successful authentication.
     * <b>Do not use directly</b>
     *
     */
    public OpenIDAuthenticationToken(GrantedAuthority[] authorities, OpenIDAuthenticationStatus status, String identityUrl) {
        super(authorities);
        this.status = status;
        this.identityUrl = identityUrl;

        setAuthenticated(true);
    }

    //~ Methods ========================================================================================================

    /* (non-Javadoc)
     * @see org.springframework.security.Authentication#getCredentials()
     */
    public Object getCredentials() {
        return null;
    }

    public String getIdentityUrl() {
        return identityUrl;
    }

    public String getMessage() {
        return message;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.Authentication#getPrincipal()
     */
    public Object getPrincipal() {
        return identityUrl;
    }

    public OpenIDAuthenticationStatus getStatus() {
        return status;
    }
}
