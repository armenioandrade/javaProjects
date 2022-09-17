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
                    <g:text property="form.descricao" required=""/>
                </span>
            </label>
            <label data-size="3">
                Medico:
                <span>
                    Médicos Encontrados: ${screen.mcontrol.searchAll().size()}
                </span>
            </label>
            <label data-size="3">
                Paciente:
                <span>
                    <select>
                        <option></option>
                    </select>
                </span>
            </label>

        </fieldset>
    </form>	
</g:template>