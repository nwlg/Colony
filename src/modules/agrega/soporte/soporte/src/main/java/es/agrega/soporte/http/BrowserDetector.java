/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.http;

/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
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
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" and
 *    "Apache Turbine" must not be used to endorse or promote products
 *    derived from this software without prior written permission. For
 *    written permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache Turbine", nor may "Apache" appear in their name, without
 *    prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

/**
 * <p>This class parses the user agent string and sets javasciptOK and
 * cssOK following the rules described below.  If you want to check
 * for specific browsers/versions then use this class to parse the
 * user agent string and use the accessor methods in this class.</p>
 *
 * <p>JavaScriptOK means that the browser understands JavaScript on the
 * same level the Navigator 3 does.  Specifically, it can use named
 * images.  This allows easier rollovers.  If a browser doesn't do
 * this (Nav 2 or MSIE 3), then we just assume it can't do any
 * JavaScript.  Referencing images by load order is too hard to
 * maintain.</p>
 *
 * <p>CSSOK is kind of sketchy in that Nav 4 and MSIE work differently,
 * but they do seem to have most of the functionality.  MSIE 4 for the
 * Mac has buggy CSS support, so we let it do JavaScript, but no CSS.</p>
 *
 * <p>Ported from Leon's PHP code at
 * http://www.working-dogs.com/freetrade by Frank.</p>
 *
 * <p>Additional properties and functionality initiated 9/27/2001.
 * Several new properties "infered" from browser.</p>
 *
 * @author <a href="mailto:frank.kim@clearink.com">Frank Y. Kim</a>
 * @author <a href="mailto:leon@clearink.com">Leon Atkisnon</a>
 * @author <a href="mailto:mospaw@polk-county.com">Chris Mospaw</a>
 * @author <a href="mailto:bgriffin@cddb.com">Benjamin Elijah Griffin</a>
 * @author <a href="mailto:lance@brainopolis.com">Lance Lavandowska</a>
 */

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class BrowserDetector implements java.io.Serializable
{
    protected static final boolean debug = false;
    protected static final String MSIE = "MSIE";
    protected static final String OPERA = "Opera";
    protected static final String MOZILLA = "Mozilla";

    protected static final String WINDOWS = "Windows";
    protected static final String UNIX = "Unix";
    protected static final String MACINTOSH = "Macintosh";

    /** The user agent string. */
    private String userAgentString = "";

    /** The browser name specified in the user agent string. */
    private String browserName = "";

    /**
     * The browser version specified in the user agent string.  If we
     * can't parse the version just assume an old browser.
     */
    private float browserVersion = (float)1.0;

    /**
     * The browser platform specified in the user agent string.
     */
    private String browserPlatform = "unknown";

    /** Whether or not javascript works in this browser. */
    private boolean javascriptOK = false;

    /** Whether or not CSS works in this browser. */
    private boolean cssOK = false;

    /** Whether or not file upload works in this browser. */
    private boolean fileUploadOK = false;
    
    /** The ISP may be AOL, MSN or WebTV */
    private boolean AOL = false;
    private boolean webTV = false;
    private boolean MSN = false;
    
    /** estimate which version of Javascript is supported **/
    private float   javascriptVersion = (float)1.0;
    
    /** attempt to get more precise platform information **/
    private String  platform = null;
    private float   platformVersion = (float)-1.0;
    
    /** 
     * Additional attributes that can be determined from
     * knowledge of the Browser and version.
     **/
    private boolean appletsOK = false;
    private boolean embedOK  = false;
    private boolean framesOK = false;
    private boolean objectOK = false;
    private boolean tablesOK = false;
    private boolean tableBGColor = false;
    private boolean tableBGImage = false;
    private boolean pngOK = false;
    private boolean xmlOK = false;
    private boolean bgSoundOK = false;
    
    /**
     * Certain header information not likely to change
     * from request-to-request, store that information
     * in the bean rather than having to ask for
     * headers.
     **/
    /** which MIME Types are listed in the request. **/
    private List acceptMIME = null; //example: "image/gif"
    
    /** Is gzip supported? **/
    private boolean gzipOK = false;
    
    /** Store the client's IP & Host values **/
    private String  clientIP = null;
    private String  clientHost = null;
    
    /** parse the request protocol **/
    private String  protocol = "HTTP/1.0";
    private String  protocolType = null;
    private float   protocolVersion = (float)1.0;
    private boolean keepAliveOK = false; // if HTTP/1.1 = true

    /**
     * Default constructor. Does nothing.
     */
    public BrowserDetector()
    {
    }

    /**
     * Constructor used to initialize this class.
     *
     * @param request An HttpRequest used to gather client information.
     */
    public BrowserDetector(HttpServletRequest request)
    {
        this.setRequest(request);
    }
    
    //private HttpServletRequest request = null;
    /**
     * Process the HttpServletRequest for client information.
     * Prosecute to the fullest extent possible ;-)
     *
     * @param request An HttpRequest used to gather client information.
     */  
    public void setRequest(HttpServletRequest request)
    {   
        // because different containers/web-servers use diffent naming conventions,
        // we need to be extra careful fetching this headers
        String tempUAS = HttpUtils.findHeader(request, "USER_AGENT");
        if (tempUAS != null)
        {
            this.setUserAgentString(tempUAS);
        }
        
        // get values from request headers
        clientIP = request.getRemoteAddr();
        clientHost = request.getRemoteHost();
        String acceptEncoding = HttpUtils.findHeader(request, "ACCEPT_ENCODING");
        if (acceptEncoding != null && acceptEncoding.indexOf("gzip") != -1)
        {
            gzipOK = true;
        }
                
        // acceptMIME: parse ACCEPT and place into ARRAYLIST
        String[] acceptArray = StringUtils.split(HttpUtils.findHeader(request, "ACCEPT"), ",");
        acceptMIME = java.util.Arrays.asList(acceptArray);
        
        String protocol = request.getProtocol();
        if (protocol != null && protocol.indexOf("/") != -1)
        {
            int slashLoc = protocol.indexOf("/");
            protocolType = protocol.substring(0, slashLoc);
            try
            {
                protocolVersion = Float.valueOf(
                                    protocol.substring(slashLoc+1)
                                    ).floatValue();
            } 
            catch (Exception e)
            {   // if there was an error getting protocolVersion, set to -1
                protocolVersion = (float)-1.0;
            }
            if ("HTTP".equals(protocolType) && protocolVersion > 1.0)
                keepAliveOK = true;
                
        }
    }
    
    /**
     * Constructor used to initialize this class.
     *
     * @param userAgentString A String with the user agent field.
     */
    public BrowserDetector(String userAgentString)
    {
        super();
        this.setUserAgentString(userAgentString);
    }
    
    /**
     * Setting the userAgentString causes parsing to occur.
     *
     * @param userAgentString A String with the user agent field.
     */
    public void setUserAgentString(String userAgentString)
    {
        this.userAgentString = userAgentString;
        parse();
    }       

    /**
     * Whether or not CSS works in this browser.
     *
     * @return True if CSS works in this browser.
     */
    public boolean isCssOK()
    {
        return cssOK;
    }

    /**
     * Whether or not file upload works in this browser.
     *
     * @return True if file upload works in this browser.
     */
    public boolean isFileUploadOK()
    {
        return fileUploadOK;
    }

    /**
     * Whether or not Javascript works in this browser.
     *
     * @return True if Javascript works in this browser.
     */
    public boolean isJavascriptOK()
    {
        return javascriptOK;
    }

    /**
     * The browser name specified in the user agent string.
     *
     * @return A String with the browser name.
     */
    public String getBrowserName()
    {
        return browserName;
    }

    /**
     * The browser platform specified in the user agent string.
     *
     * @return A String with the browser platform.
     */
    public String getBrowserPlatform()
    {
        return browserPlatform;
    }

    /**
     * The browser version specified in the user agent string.
     *
     * @return A String with the browser version.
     */
    public float getBrowserVersion()
    {
        return browserVersion;
    }

    /**
     * The user agent string for this class.
     *
     * @return A String with the user agent.
     */
    public String getUserAgentString()
    {
        return userAgentString;
    }


    public boolean isAOL()
    {
        return AOL;
    }
    public boolean isWebTV()
    {
        return webTV;
    }
    public boolean isMSN()
    {
        return MSN;
    }

    public String  getPlatform()
    {
        return platform;
    }
    public float   getPlatformVersion()
    {
        return platformVersion;
    }

    public boolean isAppletsOK()
    {
        return appletsOK;
    }
    public boolean isEmbedOK ()
    {
        return embedOK;
    }
    public boolean isFramesOK()
    {
        return framesOK;
    }
    public boolean isObjectOK()
    {
        return objectOK;
    }
    public boolean isTablesOK()
    {
        return tablesOK;
    }
    public boolean isTableBGColor()
    {
        return tableBGColor;
    }
    public boolean isTableBGImage()
    {
        return tableBGImage;
    }
    public boolean isPngOK()
    {
        return pngOK;
    }
    public boolean isXmlOK()
    {
        return xmlOK;
    }
    public boolean isBgSoundOK()
    {
        return bgSoundOK;
    }

    public ArrayList getAcceptMIME()
    {
        return (ArrayList) acceptMIME;
    }
    public boolean isGzipOK()
    {
        return gzipOK;
    }

    public String  getClientIP()
    {
        return clientIP;
    }
    public String  getClientHost()
    {
        return clientHost;
    }

    public String  getProtocol()
    {
        return protocol;
    }
    public String  getProtocolType()
    {
        return protocolType;
    }
    public float   getProtocolVersion()
    {
        return protocolVersion;
    }
    public boolean isKeepAliveOK()
    {
        return keepAliveOK;
    }

    /**
     * Helper method to initialize this class.
     */
    private void parse()
    {
        // break this out into more methods, for readability & maintainability?
        // or is this faster this way -Lance
        int versionStartIndex = userAgentString.indexOf("/");
        int versionEndIndex = userAgentString.indexOf(" ");

        // Get the browser name and version.
        browserName = userAgentString.substring(0, versionStartIndex);
        try
        {
            // Not all user agents will have a space in the reported
            // string.
            String agentSubstring = null;
            if (versionEndIndex < 0)
            {
                agentSubstring =
                    userAgentString.substring(versionStartIndex + 1);
            }
            else
            {
                agentSubstring = userAgentString.substring
                    (versionStartIndex + 1, versionEndIndex);
            }
            browserVersion = toFloat( agentSubstring );
        }
        catch (NumberFormatException e)
        {
            // Just use the default value.
        }

        // MSIE lies about its name.  Of course...
        if (userAgentString.indexOf(MSIE) != -1)
        {
            /* Examples:
            Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)
            Mozilla/4.0 WebTV/2.6 (compatible; MSIE 4.0)
            Mozilla/4.0 (compatible; MSIE 5.5; MSNIA; Windows 98)
            Mozilla/4.0 (compatible; MSIE 5.5; Windows 98; MSN 6.1; MSNbDELL; MSNmen-us; MSNcIA)
            Mozilla/4.0 (compatible; MSIE 5.5; MSN 2.5; AOL 7.0; Windows 98; AT&T WNS IE4.0)
            Mozilla/4.0 (compatible; MSIE 5.5; AOL 6.0; Windows 98)           
            */
            versionStartIndex = (userAgentString.indexOf(MSIE) +
                                 MSIE.length() + 1);
            versionEndIndex = userAgentString.indexOf(";", versionStartIndex);
            if (versionEndIndex == -1) versionEndIndex = userAgentString.length()-1;

            browserName = MSIE;
            if (userAgentString.indexOf("AOL") != -1)   AOL = true;
            if (userAgentString.indexOf("MSN") != -1)   MSN = true;
            if (userAgentString.indexOf("WebTV") != -1) webTV = true;
            try
            {
                browserVersion = toFloat(userAgentString.substring
                                         (versionStartIndex, versionEndIndex));
            }
            catch (NumberFormatException e)
            {
                // Just use the default value.
            }

            // PHP code
            // $Browser_Name = "MSIE";
            // $Browser_Version = strtok("MSIE");
            // $Browser_Version = strtok(" ");
            // $Browser_Version = strtok(";");
        }

        // Opera isn't completely honest, either...
        // Modificaton by Chris Mospaw <mospaw@polk-county.com>
        if (userAgentString.indexOf(OPERA) != -1)
        {
            //Ex: Mozilla/4.0 (Windows NT 4.0;US) Opera 3.61  [en]
            versionStartIndex = (userAgentString.indexOf(OPERA) +
                                 OPERA.length() + 1);
            versionEndIndex = userAgentString.indexOf( " ",
                                                       versionStartIndex );

            browserName = OPERA;
            try
            {
                browserVersion = toFloat(userAgentString.substring
                                         (versionStartIndex, versionEndIndex));
            }
            catch (NumberFormatException e)
            {
                // Just use the default value.
            }

            // PHP code
            // $Browser_Name = "Opera";
            // $Browser_Version = strtok("Opera");
            // $Browser_Version = strtok("/");
            // $Browser_Version = strtok(";");
        }

        /**
            Make educated guesses about javascript and tag
            support based on the browserName & version.
            These attributes do not appear to have OS dependancies.
            
            -- javascript version support : guesswork table
                js 1.0 : N2
                js 1.1 : N3
                js 1.2 : N4.0 -> N4.05, IE4+
                js 1.3 : N4.06 -> N4.5
                js 1.4 : ?
                js 1.5 : N6, IE5?   - equals ECMA-262, Edition 3.

            -- tag support in browsers: haven't seen documentation
            on how these vary between platforms
                appletsOK   : IE3+, N3+
                framesOK    : IE3+, N2+
                tablesOK    : IE2+, N2+
                tableBGColor : IE2+, N3+
                tableBGImage : IE2+
                pngOK       : ? IE4+, N4+ ?
                bgSoundOK   : IE2+
                embedOK     : IE3+, N2+
                objectOK    : IE3+
                xmlOK       : ? IE5+ ?
        */
        if (browserName.equals(MOZILLA))
        {
            if (browserVersion < 2.0)
            {
                // can't do nothin'!
            }
            else if (browserVersion < 3.0)
            {
                javascriptVersion = 1.0f;
                framesOK = true;
                tablesOK = true;
                embedOK = true;
            }
            else if (browserVersion < 4.0)
            {
                javascriptVersion = 1.1f;
                framesOK = true;
                tablesOK = true;
                embedOK = true;
                tableBGColor = true;
            }
            else if (browserVersion < 5.0)
            {
                framesOK = true;
                tablesOK = true;
                embedOK = true;
                tableBGColor = true;
                pngOK = true;
                
                if (browserVersion < 4.06)
                {
                    javascriptVersion = 1.2f;
                }
                else if (browserVersion < 5)
                {
                    javascriptVersion = 1.3f;
                }
                else
                {
                    javascriptVersion = 1.5f;
                }
            }
        }
        else if (browserName == MSIE)
        {
            if (browserVersion < 3.0 && browserVersion >= 2.0)
            {
                javascriptVersion = 1.0f;
                tablesOK = true;
                tableBGColor = true;
                tableBGImage = true;
                bgSoundOK = true;
            }
            else if (browserVersion < 4.0)
            {
                javascriptVersion = 1.1f;
                tablesOK = true;
                tableBGColor = true;
                tableBGImage = true;
                bgSoundOK = true;
                appletsOK = true;
                framesOK = true;
                embedOK = true;
                objectOK = true;
            }
            else if (browserVersion < 5.0)
            {
                javascriptVersion = 1.2f;
                tablesOK = true;
                tableBGColor = true;
                tableBGImage = true;
                bgSoundOK = true;
                appletsOK = true;
                framesOK = true;
                embedOK = true;
                objectOK = true;
                pngOK = true;
            }
            else if (browserVersion < 6.0)
            {
                javascriptVersion = 1.3f;
                tablesOK = true;
                tableBGColor = true;
                tableBGImage = true;
                bgSoundOK = true;
                appletsOK = true;
                framesOK = true;
                embedOK = true;
                objectOK = true;
                pngOK = true;
                xmlOK = true;
            }
            else if (browserVersion >=.0)
            {
                javascriptVersion = 1.5f;
                tablesOK = true;
                tableBGColor = true;
                tableBGImage = true;
                bgSoundOK = true;
                appletsOK = true;
                framesOK = true;
                embedOK = true;
                objectOK = true;
                pngOK = true;
                xmlOK = true;
            }
        }
            
        // Try to figure out what platform.
        int platformStartIndex = -1;
        if ( ((platformStartIndex = userAgentString.indexOf("Windows")) != -1) ||
             ((platformStartIndex = userAgentString.indexOf("WinNT")) != -1) ||
             ((platformStartIndex = userAgentString.indexOf("Win98")) != -1) ||
             ((platformStartIndex = userAgentString.indexOf("Win95")) != -1) ||
             ((platformStartIndex = userAgentString.indexOf("WinXP")) != -1))
        {
            browserPlatform = WINDOWS;
            
            int platformEndIndex = userAgentString.indexOf(";", platformStartIndex);
            if (platformEndIndex == -1) platformEndIndex = userAgentString.length()-1;
            platform = userAgentString.substring(platformStartIndex, platformEndIndex);
        }

        if (userAgentString.indexOf("Mac") != -1)
        {
            browserPlatform = MACINTOSH;
        }

        // Opera on Linux doesn't always report X11 in its userAgentString
        if (userAgentString.indexOf("X11") != -1 ||
            userAgentString.indexOf("Linux") != -1 )
        {
            browserPlatform =  UNIX;
        }

        if (browserPlatform == WINDOWS)
        {
            if (browserName.equals(MOZILLA))
            {
                if (browserVersion >= 3.0)
                {
                    javascriptOK = true;
                    fileUploadOK = true;
                }
                if (browserVersion >= 4.0)
                {
                    cssOK = true;
                }
            }
            else if (browserName == MSIE)
            {
                if (browserVersion >= 4.0)
                {
                    javascriptOK = true;
                    fileUploadOK = true;
                    cssOK = true;
                }
            }
            else if (browserName == OPERA)
            {
                if (browserVersion >= 3.0)
                {
                    javascriptOK = true;
                    fileUploadOK = true;
                    cssOK = true;
                }
            }
        }
        else if (browserPlatform == MACINTOSH)
        {
            if (browserName.equals(MOZILLA))
            {
                if (browserVersion >= 3.0)
                {
                    javascriptOK = true;
                    fileUploadOK = true;
                }
                if( browserVersion >= 4.0)
                {
                    cssOK = true;
                }
            }
            else if (browserName == MSIE)
            {
                if (browserVersion >= 4.0)
                {
                    javascriptOK = true ;
                    fileUploadOK = true;
                }
                if (browserVersion > 4.0)
                {
                    cssOK = true;
                }
            }
        }
        else if (browserPlatform ==  UNIX)
        {
            if (browserName.equals(MOZILLA))
            {
                if (browserVersion >= 3.0)
                {
                    javascriptOK = true;
                    fileUploadOK = true;
                }
                if (browserVersion >= 4.0)
                {
                    cssOK = true;
                }
            }
        }
    }

    /**
     * Helper method to conver String to a float.
     *
     * @param s A String.
     * @return The String converted to float.
     */
    private static final float toFloat(String s)
    {
        return Float.valueOf(s).floatValue();
    }
    
    /**
     * Return String with all values of this Bean.
     *
     * @return The BrowserDetector values as a String.
     */
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append("userAgentString:").append(userAgentString).append("\n");
        buf.append("AOL:").append(AOL).append("\n");
        buf.append("MSN:").append(MSN).append("\n");
        buf.append("webTV:").append(webTV).append("\n");
        buf.append("browserName:").append(browserName).append("\n");
        buf.append("browserVersion:").append(browserVersion).append("\n");
        buf.append("browserPlatform:").append(browserPlatform).append("\n");
        buf.append("javascriptOK:").append(javascriptOK).append("\n");
        buf.append("cssOK:").append(cssOK).append("\n");
        buf.append("fileUploadOK:").append(fileUploadOK).append("\n");
        buf.append("javascriptVersion:").append(javascriptVersion).append("\n");
        buf.append("platform:").append(platform).append("\n");
        buf.append("platformVersion:").append(platformVersion).append("\n");
        buf.append("framesOK:").append(framesOK).append("\n");
        buf.append("tablesOK:").append(tablesOK).append("\n");
        buf.append("tableBGColor:").append(tableBGColor).append("\n");
        buf.append("tableBGImage:").append(tableBGImage).append("\n");
        buf.append("pngOK:").append(pngOK).append("\n");
        buf.append("xmlOK:").append(xmlOK).append("\n");
        buf.append("bgSoundOK:").append(bgSoundOK).append("\n");
        buf.append("acceptMIME:").append(acceptMIME).append("\n");
        buf.append("clientIP:").append(clientIP).append("\n");
        buf.append("clientHost:").append(clientHost).append("\n");
        buf.append("protocol:").append(protocol).append("\n");
        buf.append("protocolType:").append(protocolType).append("\n");
        buf.append("protocolVersion:").append(protocolVersion).append("\n");
        buf.append("keepAliveOK:").append(keepAliveOK).append("\n");
        buf.append("gzipOK:").append(gzipOK).append("\n");
        
        return buf.toString();
    }

}

