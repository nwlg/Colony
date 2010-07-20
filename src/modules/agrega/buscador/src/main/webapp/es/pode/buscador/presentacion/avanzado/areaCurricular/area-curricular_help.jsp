<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="area.curricular.cu.area.curricular"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="area.curricular.cu.area.curricular"/></h1>
        <p>
            <bean:message key="area.curricular.cu.area.curricular.online.help"/>
        </p>
        <h2><bean:message key="area.curricular.cu.area.curricular.selecciona.hijo"/></h2>
        <p>
            <bean:message key="area.curricular.cu.area.curricular.selecciona.hijo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.hijo.param.id"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.hijo.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.hijo.param.buscador.empaquetador"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.hijo.param.buscador.empaquetador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="area.curricular.cu.area.curricular.selecciona.padre"/></h2>
        <p>
            <bean:message key="area.curricular.cu.area.curricular.selecciona.padre.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.padre.param.id"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.padre.param.id.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.padre.param.buscador.empaquetador"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.selecciona.padre.param.buscador.empaquetador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular"/></h2>
        <p>
            <bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular.param.area.curricular"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular.param.area.curricular.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.volcar.area.curricular.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="area.curricular.cu.area.curricular.cancelar"/></h2>
        <p>
            <bean:message key="area.curricular.cu.area.curricular.cancelar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="area.curricular.cu.area.curricular.cancelar.param.tipo.layout.buscador"/></td>
                    <td><bean:message key="area.curricular.cu.area.curricular.cancelar.param.tipo.layout.buscador.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

