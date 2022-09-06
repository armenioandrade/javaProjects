<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
    <div>
        web-inf/views/docs/modulos/receita/GateView.jsp
    </div>
    <form method="" action="#">            
        <fieldset>
            <legend>
                <g:path/>
            </legend>
            <label data-size="8">
                Nome do Médico:
                <span>
                    <g:text property="form.medico.nome" required=""/>
                </span>
            </label>
            <label data-size="8">
                Nome do Paciente:
                <span>
                    <g:text property="form.paciente.nome" required=""/>
                </span>
                
                    <g:link method="">
                        Pesquisar<g:icon type="search"/>
                    </g:link>
                    <g:link action="Insert" />
                
            </label>
        </fieldset>
    </g:template>