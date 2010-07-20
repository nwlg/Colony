<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="importar.cu.seleccionar.recurso.importado"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="importar.cu.seleccionar.recurso.importado"/></h1>
        <p>
            <bean:message key="importar.cu.seleccionar.recurso.importado.online.help"/>
        </p>
        <h2><bean:message key="importar.cu.seleccionar.recurso.importado.cancelar"/></h2>
        <p>
            <bean:message key="importar.cu.seleccionar.recurso.importado.cancelar.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar"/></h2>
        <p>
            <bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode1"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode1.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode2"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode2.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode3"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode3.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode4"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode4.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode5"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.fichero.ode5.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.espacio.libre"/></td>
                    <td><bean:message key="importar.cu.seleccionar.recurso.importado.aceptar.param.espacio.libre.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

