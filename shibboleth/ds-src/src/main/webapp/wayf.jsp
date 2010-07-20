<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">

<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>

<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>

   <head>
      <meta charset="utf-8" />
      <title>national digital resource bank</title>

      <link rel="stylesheet" href="blueprint/screen.css" type="text/css" media="screen, projection">
      <link rel="stylesheet" href="blueprint/print.css" type="text/css" media="print">
      <!--[if lt IE 8]><link rel="stylesheet" href="blueprint/ie.css" type="text/css" media="screen, projection"><![endif]-->

      <!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
      <link rel="stylesheet" href="style.css" type="text/css" media="screen, projection, print">
      <link rel="stylesheet" href="iestyle.css" type="text/css" media="screen, projection">
      
      <script language="javascript">
         function doSubmit(url) {
            document.forms["ndrbform"].origin.value = url;
            document.forms["ndrbform"].submit(); 
            return false;
         }
      </script>

   </head>

   <body id="index" class="home">

      <div class="container">
         <div id="header" class="span-24">
            <div id="ndrb-logo" class="span-4">
               <img src="images/logo_ndrb.gif" title="ndrb"/>
            </div>
            <div class="" id="header-text">
               national digital resource bank
            </div>
         </div>
         <div id="heading" class="span-24">
            <h1>Where are you from?</h1>
         </div>

<form method="get" name="ndrbform" action="<bean:write name="requestURL" />">
                <logic:notPresent name="entityID" scope="request">
                    <input type="hidden" name="shire" value="<bean:write name="shire" />" />
                    <input type="hidden" name="target" value="<bean:write name="target" />" />
                    <input type="hidden" name="providerId" value="<bean:write name="providerId" />" />
                    <logic:present name="time" scope="request">
                         <input type="hidden" name="time" value="<bean:write name="time" />" />
                    </logic:present>
                </logic:notPresent>
                <logic:present name="entityID" scope="request">
                    <input type="hidden" name="entityID" value="<bean:write name="entityID" />" />
                    <input type="hidden" name="returnX" value="<bean:write name="returnX" />" />
                    <input type="hidden" name="returnIDParam" value="<bean:write name="returnIDParam" />" />
                 </logic:present>
              <input type="hidden" name="action" value="selection" />
              <input type="hidden" name="cache" value="false" />
              <input type="hidden" name="origin" value="https://identity.siriusit.co.uk/idp/shibboleth" />

	 <!-- Row 1 -->
         <div class="span-24 last row">

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/nwlg.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>North West Learning Grid</h5>
               <p>If you are a member of the NWLG, click here to enter
               your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/yhgfl.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Yorkshire and Humber Grid for Learning</h5>
               <p>If you are a member of the YHGfL, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://bradfordlearning.net/shibboleth')">
         <div class="span-8 la last">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/bradford.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Bradford</h5>
               <p>If you belong to the Bradford Learning Network, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         </div>
	 <!-- End of row 1 -->

	 <!-- Row 2 -->
         <div class="span-24 last row">

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/flintshire.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Flintshire</h5>
               <p>If you are from a school in Flintshire or belong to Flintshire LA, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/northumberland.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Northumberland</h5>
               <p>If you are from a school in Northumberland or belong to Northumberland LA, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la last">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/nottingham.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Nottingham</h5>
               <p>If you are from a school in Nottingham or belong to Nottingham LA, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         </div>
	 <!-- End of row 2 -->

	 <!-- Row 3 -->
         <div class="span-24 last row">

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/nottinghamshire.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Nottinghamshire</h5>
               <p>If you are from a school in Nottinghamshire or belong to Nottinghamshire LA, click here to enter your username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/pembrokeshire.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Pembrokeshire</h5>
               <p>If you are from a school in Pembrokeshire or belong to
               Pembrokeshire LA, click here to enter your username and
               password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la last">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/ucst.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>United Church Schools Trust</h5>
               <p>If you are a member of the UCST, click here to enter your
               username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         </div>
	 <!-- End of row 3 -->

	 <!-- Row 4 -->
         <div class="span-24 last row">

         <a href="#" onclick="javascript:doSubmit('https://shibboleth.networcs.net/SSO/shibboleth')">
	 <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/worcestershire.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>Worcestershire</h5>
               <p>If you belong to the Worcestershire Learning Gateway, click here to enter your username and
               password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
         </a>

         <a href="#" onclick="javascript:doSubmit('https://safari.data-archive.ac.uk/shibboleth-idp')">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/ukamf.jpg"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>UK Teacher Training Providers</h5>
               <p>If you are a University providing teacher training and you are a member of the UK access management federation, click here to enter your username and password.</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>

         <div class="span-8 la last">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/unknown.png"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>&nbsp;</h5>
              &nbsp; 
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
         </div>
	 <!-- End of row 4 -->

	 <!-- Row 5 -->
         <div class="span-24 last row">
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/unknown.png"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>&nbsp;</h5>
              &nbsp; 
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
         <div class="span-8 la">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/unknown.png"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>&nbsp;</h5>
              &nbsp; 
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>

         <a href="#" onclick="javascript:doSubmit('https://identity.siriusit.co.uk/idp/shibboleth')">
         <div class="span-8 la last">
            <div class="tl"></div><div class="tr"></div>
            <div class="span-3 logo">
               <div class="tl"></div><div class="tr"></div>
               <img src="images/logo_ndrb.gif"/>
               <div class="bl"></div><div class="br"></div>
            </div>
            <div class="span-5 last">
               <h5>national digital resource bank</h5>
               <p>If you aren't from a UK educational institution but you are
               registered with the ndrb, click here to enter your
               username and password</p>
            </div>
            <div class="bl"></div><div class="br"></div>
         </div>
	 </a>
         </div>
	 <!-- End of row 5 -->

</form>

         <div class="span-24 last" id="no-wayf">
            <div class="tl"></div><div class="tr"></div>
            <p>
            If you don't see yourself represented in the list above,
            talk to your Local Authority or RBC about membership of the
            national digital resource bank or contact us for more
            information at <a
               href="mailto:admin@nwlg.org">admin@nwlg.org</a></p>
            <div class="bl"></div><div class="br"></div>
         </div>
         <div class="span-24 last" id="footer">
            <div id="footer_logos"> 
               <ul> 
                  <li><a href="http://www.nwlg.org" id="nwlg" title="North West Learning Grid"><img src="images/logo_nwlg.gif" title="North West Learning Grid"/></a></li> 
                  <li><a href="http://www.nen.gov.uk" id="nen" title="National Education Network"><img src="images/logo_nen.gif" title="National Education Network"/></a></li> 
                  <li><a id="footertext" title="An initiative of the North-West Learning Grid"><img src="images/footer_text.png" title="An initiative of the North-West Learning Grid"/></a></li> 
               </ul> 
            </div> 

            <!-- Powered by Agrega --> 
            <div id="footer_poweredby"> 
               <a href="http://proyectoagrega.es/"><img src="images/powered_by_agrega.jpg"></a> 
            </div> 

            <!-- Link bar div --> 
            <div id="footer_linkbar"> 
               <a href="http://www.ndrb.org.uk/visualizadorcontenidos/AcercaDeAgrega/AcercaDeAgrega.do" class="bar leftpad" title="About ndrb" >About ndrb</a> 
               <a href="http://www.ndrb.org.uk/visualizadorcontenidos/Contacto/Contacto.do" class="bar leftpad" title="Contact" id="contacto">Contact</a> 
               <a href="http://www.ndrb.org.uk/visualizadorcontenidos/InformacionLegal/InformacionLegal.do"  class="bar leftpad" title="Legal Information" >Legal Information</a> 
            </div> 

         </div>
      </div> <!-- container -->


   </body>
</html>
