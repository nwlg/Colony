/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.http;

/*
 * Copyright (c) 1997-2000 The Java Apache Project.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. All advertising materials mentioning features or use of this
 *    software must display the following acknowledgment:
 *    "This product includes software developed by the Java Apache
 *    Project for use in the Apache JServ servlet engine project
 *    <http://java.apache.org/>."
 *
 * 4. The names "Apache JServ", "Apache JServ Servlet Engine", "Turbine",
 *    "Apache Turbine", "Turbine Project", "Apache Turbine Project" and
 *    "Java Apache Project" must not be used to endorse or promote products
 *    derived from this software without prior written permission.
 *
 * 5. Products derived from this software may not be called "Apache JServ"
 *    nor may "Apache" nor "Apache JServ" appear in their names without
 *    prior written permission of the Java Apache Project.
 *
 * 6. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 *    "This product includes software developed by the Java Apache
 *    Project for use in the Apache JServ servlet engine project
 *    <http://java.apache.org/>."
 *
 * THIS SOFTWARE IS PROVIDED BY THE JAVA APACHE PROJECT "AS IS" AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE JAVA APACHE PROJECT OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Java Apache Group. For more information
 * on the Java Apache Project and the Apache JServ Servlet Engine project,
 * please see <http://java.apache.org/>.
 *
 */

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;



/**
 * This class provides utilities for handling some semi-trivial
 * HTTP stuff that would othterwize be handled elsewhere.
 *
 * @author <a href="mailto:magnus@handpoint.com">Magnús Þór Torfason</a>
 * @version $Id: HttpUtils.java,v 1.1 2001/08/10 20:38:12 jon Exp $
 */
public class HttpUtils
{
    /**
     * The date format to use for HTTP Dates.
     */
    private static SimpleDateFormat httpDateFormat;

    static
    {
        httpDateFormat = new SimpleDateFormat(
                "EEE, dd MMM yyyyy HH:mm:ss z", Locale.US  );
        httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    /**
     * Formats a java Date according to rfc 1123, the rfc
     * standard for dates in http.
     *
     * @param date The Date to format
     * @return A String represeentation of the date
     */
    public static String formatHttpDate(Date date)
    {
        synchronized (httpDateFormat)
        {
            return httpDateFormat.format(date);
        }
    }
    
    /**
     * Tries several variations of the header name
     * in an attempt to find a value for the header.
     * Header name should start with format: all caps, 
     * words seperated with an underscore.
     * JRun uses underscore w/allCap, Resin uses dash w/initCap,
     * and OrionServer uses dash w/allCap, for 3 examples.
     *
     * @param request The HttpRequest in which to look for Header.
     * @param header  The String with the beginning name of Header.
     *
     * @return The String value of the header, or NULL if cannot be found.
     */
    public static String findHeader(javax.servlet.http.HttpServletRequest request, String header)
    {
        // underscore w/allCap
        String headerValue = request.getHeader(header);
        if (headerValue == null)
        {
            // underscore w/initCap
            header = HttpUtils.initCap(header.toLowerCase()); 
            headerValue = request.getHeader(header);
            if (headerValue == null)
            {           
                // dash w/initCap
                header = StringUtils.replace(header, "_", "-"); 
                headerValue = request.getHeader(header);
                if (headerValue == null)
                {
                    // dash w/allCap
                    header = header.toUpperCase(); 
                    headerValue = request.getHeader(header);
                    if (headerValue == null)
                    {
                        // dash w/allLower
                        header = header.toLowerCase(); 
                        headerValue = request.getHeader(header);
                        if (headerValue == null)
                        {
                            // underscore w/allLower
                            header = StringUtils.replace(header, "-", "_"); 
                            headerValue = request.getHeader(header);
                        }
                    }
                }
            }
        }
        return headerValue;
    }

    /**
     * Special implemenation - just for request headers.
     * Make the first letter of each word initCap.
     * Depends on words being seperated with "_" or "-";
     *
     * @param header  The Header String to initCap.
     *
     * @return The modified String value of the header.
     */
    public static String initCap(String aStr)
    {
        int underscoreLoc = aStr.indexOf("_");
        if (underscoreLoc == -1) underscoreLoc = aStr.indexOf("-");
        String firstChar = aStr.substring(0,1).toUpperCase();
        if (underscoreLoc != -1)
        {
            String secondChar = aStr.substring(underscoreLoc+1, underscoreLoc+2).toUpperCase();

            aStr = firstChar + aStr.substring(1,underscoreLoc+1) +
                   secondChar + aStr.substring(underscoreLoc+2);
        }
        else
        {
            aStr = firstChar + aStr.substring(1);
        }
        return aStr;
    }
}
