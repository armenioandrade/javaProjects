<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>
<g:template filename="/WEB-INF/views/FULL.jsp">
    VIEWRECEITA
    <form method="" action="#">            
        <fieldset>
            <legend>
                <g:path/>
            </legend>
            <label data-size="16">
                Descricao:
                <span>
                    <g:textarea property="form.descricao"/>
                </span>
            </label>
            <label data-size="3">
                Medico:
                <span>
                    
                </span>
            </label>
            <label data-size="3">
                Paciente:
                <span>
    
                </span>
            </label>

        </fieldset>
    </form>	
                    
                    <g:print value="TESTE"/>              
                    <g:print value="${SCREEN}"/>              
                    <g:print value="${form.descricao}"/>              
</g:template>