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
package es.pode.soporte.seguridad.openId.ui.openid;

import es.pode.soporte.seguridad.openId.providers.openid.OpenIDAuthenticationToken;

import javax.servlet.http.HttpServletRequest;


/**
 * An interface for OpenID library implementations
 *
 * @author Ray Krueger
 * @author Robin Bramley, Opsera Ltd
 */
public interface OpenIDConsumer {

    /**
     * @deprecated Use {@link #beginConsumption(javax.servlet.http.HttpServletRequest, String, String, String)}
     */
    public String beginConsumption(HttpServletRequest req, String identityUrl, String returnToUrl)
            throws OpenIDConsumerException;

    /**
     * Given the request, the claimedIdentity, the return to url, and a realm, lookup the openId authentication
     * page the user should be redirected to.
     *
     * @param req HttpServletRequest
     * @param claimedIdentity String URI the user presented during authentication
     * @param returnToUrl String URI of the URL we want the user sent back to by the OP
     * @param realm URI pattern matching the realm we want the user to see
     * @return String URI to redirect user to for authentication
     * @throws OpenIDConsumerException if anything bad happens
     */
    public String beginConsumption(HttpServletRequest req, String claimedIdentity, String returnToUrl, String realm)
            throws OpenIDConsumerException;

    public OpenIDAuthenticationToken endConsumption(HttpServletRequest req)
            throws OpenIDConsumerException;

}
