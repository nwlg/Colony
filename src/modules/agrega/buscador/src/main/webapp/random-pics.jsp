<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils" %>
<% //TODO: move this to a class 
//If session doesn't exist, one will be created
request.getSession(true);

String numObjStr = request.getParameter("numobj");
if (numObjStr!=null) { 
	int numObj = new Integer(numObjStr);
	
	int maxResPerPage = request.getSession().getServletContext().getInitParameter("max_res_pagina")==null?10:new Integer(request.getSession().getServletContext().getInitParameter("max_res_pagina"));

	if (numObj>=maxResPerPage) { // 1 page at least

		int numPages = numObj / maxResPerPage ; 
		java.util.Random rnd = new java.util.Random();
		int rndPage = rnd.nextInt(numPages)+ 1; // don't want last page

		//Look for page
		es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl baci =
		new es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerImpl();

		es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl bacufi =
		new es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl();

                //We have to remove other filters in session if they exist
                session.removeAttribute("campo_typicalLearningTime");
                session.removeAttribute("campo_keystage");
                session.removeAttribute("campo_subject");
                session.removeAttribute("campo_destinatarios");


		//Set up structure to search
		bacufi.setBuscadorContenido(".*");
		bacufi.setTipoLayoutBuscador("BUSCADOR");
		bacufi.setContadorPropiedadesContenido("0");
		bacufi.setValidado("FORMULARIO_VALIDO");
		bacufi.setBusquedaSimpleAvanzada("BUSCAR_SIMPLE");
		bacufi.setPagina(""+rndPage);

		baci.ejecutarBusquedaAvanzada(null,bacufi,request,response);
		//Now we got the page and we need 3 random items

		es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] vbvo = (es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[])bacufi.getResultadosVO().toArray(new es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[]{});

                int max = new Integer(vbvo.length);
                if (max>0) { 
                    int count = 0; //It will not have to look for a item many times
                    int number1 = rnd.nextInt(max);
                    int number2 = rnd.nextInt(max); while (number1==number2 && count<10) { number2 = rnd.nextInt(max); count++; }
                    int number3 = rnd.nextInt(max); while ( ((number1==number3) || (number2==number3)) && count<20 ) { number3 = rnd.nextInt(max); count++; }
%>
<!-- pics layer -->
<div>
	<table width="100%" style="padding: 5px;">
		<tr>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=vbvo[number1].getId()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='http://<%=LdapUserDetailsUtils.getHost()+""+vbvo[number1].getUrlImagen() %>' alt='<%=vbvo[number1].getTitulo()%>'/></center>
				</a>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=vbvo[number2].getId()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='http://<%=LdapUserDetailsUtils.getHost()+""+vbvo[number2].getUrlImagen() %>' alt='<%=vbvo[number2].getTitulo()%>'/></center>
				</a>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=vbvo[number3].getId()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='http://<%=LdapUserDetailsUtils.getHost()+""+vbvo[number3].getUrlImagen() %>' alt='<%=vbvo[number3].getTitulo()%>'/></center>
				</a>
			</td>
		</tr>
		<tr>
			<td  width="30%">
						<center><span style="font-size: 80%;"><%=vbvo[number1].getTitulo()%></span></center>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%">
						<center><span style="font-size: 80%;"><%=vbvo[number2].getTitulo()%></span></center>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%">
						<center><span style="font-size: 80%;"><%=vbvo[number3].getTitulo()%></span></center>
			</td>
		</tr>
	</table>
</div>
<!-- end pics layer -->
<%          } //if max>0
 	}// if (numObj>=maxResPerPage)
} //if any object %>
