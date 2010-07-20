<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="help.layout">

    <tiles:put name="title" type="string">
        <bean:message key="online.help.title"/>
        <bean:message key="ver.metadatos.categorias.form"/>
    </tiles:put>

    <tiles:put name="body" type="string">
        <h1><bean:message key="ver.metadatos.categorias.form"/></h1>
        <p>
            <bean:message key="ver.metadatos.categorias.form.online.help"/>
        </p>
        <h2><bean:message key="ver.metadatos.categorias.form.volver.a"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.volver.a.online.help"/>
        </p>
        <br/>
        <h2><bean:message key="ver.metadatos.categorias.form.general"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.general.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.identificador"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.general.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.identificador"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.identificador.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.ciclo.de.vida.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.meta.metadatos"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.meta.metadatos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.meta.metadatos.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.tecnica"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.tecnica.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.tecnica.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.uso.educativo"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.uso.educativo.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.uso.educativo.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.derechos"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.derechos.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.derechos.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.relacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.relacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.relacion.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.anotacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.anotacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.anotacion.param.datos.online.help"/></td>
                </tr>
            </table>
        <h2><bean:message key="ver.metadatos.categorias.form.clasificacion"/></h2>
        <p>
            <bean:message key="ver.metadatos.categorias.form.clasificacion.online.help"/>
        </p>
        <br/>
            <table>
                <tr class="even">
                    <th><bean:message key="online.help.inputfield"/></th>
                    <th><bean:message key="online.help.description"/></th>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.identificador.ode"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.identificador.ode.online.help"/></td>
                </tr>
                <tr class="even">
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.return.url"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.return.url.online.help"/></td>
                </tr>
                <tr class="odd">
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.datos"/></td>
                    <td><bean:message key="ver.metadatos.categorias.form.clasificacion.param.datos.online.help"/></td>
                </tr>
            </table>
    </tiles:put>

</tiles:insert>

