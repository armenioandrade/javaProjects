<%-- 
    Document   : View
    Created on : 26 de ago. de 2022, 17:06:14
    Author     : amaf
--%>
<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <div>
        modulos/medico/view
    </div>
    <div>
        <form method="POST" action="#">
            <fieldset>
                <legend>
                    <g:path/>
                </legend>
                <label data-size="4">
                    ID:
                    <span>
                        <g:text property="form.id" required=""/>
                    </span>
                </label>
                <label data-size="4">
                    Sexo:
                    <span>
                        <g:select property="form.sexo" required=""/>
                    </span>
                </label>
                <label data-size="4">
                    CPF
                    <span>
                        <g:text property="form.cpf" required=""/>
                    </span>
                </label>
                <label data-size="4">
                    CRM:
                    <span>
                        <g:text property="form.crm" required=""/>
                    </span>
                </label>
                <label data-size="10">
                    Nome:
                    <span>
                        <g:text property="form.nome" required=""/>
                    </span>
                </label>
            </fieldset>
            <g-coolbar>
                <g:link method="post">
                    Pesquisar<g:icon type="search"/>
                </g:link>
                <g:link action="Insert" />
            </g-coolbar>
        </form>
        <g:block condition="${screen.POST}"
                 otherwise="Entre com os critérios de busca e clique em pesquisar">
            <g:block condition="${not empty screen.page}"
                     otherwise="Nenhum registro encontrado">

                <table class="c1 c2 c3 c4">
                    <caption>
                        MÉDICOS ENCONTRADOS: ${screen.page.size()}
                    </caption>
                    <thead>
                        <tr>
                            <th style="width: 120px">
                                ID
                            </th>
                            <th style="width: 120px">
                                CPF
                            </th>
                            <th style="width: 120px">
                                Sexo
                            </th>
                            <th style="width: 120px">
                                CRM
                            </th>
                            <th>
                                Nome
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <g:iterator source="${screen.page}">
                            <tr data-action="Gate?MODULE=${MODULE}&SCREEN=${SCREEN}&ACTION=Select&form.id=${target.id}">
                                <td>
                                    ${target.id}
                                </td>
                                <td>
                                    ${target.cpf}
                                </td>
                                <td>
                                    <g:print value="${target.sexo}"/>
                                </td>
                                <td>
                                    <g:print value="${target.crm}"/>
                                </td>
                                <td>
                                    ${target.nome}
                                </td>
                            </tr>
                        </g:iterator>
                    </tbody>
                </table>
            </g:block>
        </g:block>
    </div>
</g:template>