<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
    <logic:messagesPresent message="false">
        <logic:messagesNotPresent message="true" property="org.andromda.bpm4struts.errormessages">
                <html:messages id="error" message="false">
                    <div class="error">${error}</div>
                </html:messages>
        </logic:messagesNotPresent>
    </logic:messagesPresent>
    <logic:messagesPresent message="true" property="org.andromda.bpm4struts.errormessages">
            <html:messages id="error" message="true" property="org.andromda.bpm4struts.errormessages">
                <div class="error">${error}</div>
            </html:messages>
    </logic:messagesPresent>
    <logic:messagesPresent message="true" property="org.andromda.bpm4struts.successmessages">
			<html:messages id="message" message="true" property="org.andromda.bpm4struts.successmessages">
				<div class="exito">${message}</div>
			</html:messages>
	</logic:messagesPresent>
    