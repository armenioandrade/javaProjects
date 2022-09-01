<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
    <div>
        web-inf/views/view.jsp
    </div>
            <nav>
            <g-tabbar>
                <g:link module='#' screen='Paciente'/>
                <g:link module='#' screen='Medico'/>
                <g:link module='#' screen='Receita'/>
            </g-tabbar>            
        </nav>
</g:template>