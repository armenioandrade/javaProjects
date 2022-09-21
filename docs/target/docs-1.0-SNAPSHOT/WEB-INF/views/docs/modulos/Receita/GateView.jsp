<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>
<g:template filename="/WEB-INF/views/FULL.jsp">
    VIEWRECEITA
  
             <form method="POST" action="#">            
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

                             <g:select property="mcontrol" options=""/>

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
             <g:iterator source="pageMedico" target="">
                 ${target.id}
             </g:iterator>
                      
   
</g:template>