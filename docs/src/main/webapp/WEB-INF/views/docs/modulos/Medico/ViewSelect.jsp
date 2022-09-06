<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
	<fieldset>
		<legend>
			<g:path/>
		</legend>
		<label data-size="2">
			ID:
			<span>
				${screen.form.id}
			</span>
		</label>
		<label data-size="2">
			Sexo:
			<span style="color: ${g:color(screen.form.sexo)}">
				<g:icon type="${screen.form.sexo}"/>
				<g:print value='${screen.form.sexo}'/>
			</span>
		</label>
		<label data-size="4">
			CRM:
			<span>
				<g:print value="${screen.form.crm}"/>
			</span>
		</label>
		<label data-size="8">
			Nome:
			<span>
				${screen.form.nome}
			</span>
		</label>
	</fieldset>
	<g-coolbar>
		<g:link action="Update" _form.id='${screen.form.id}'/> 
		<g:link action="Delete" _form.id='${screen.form.id}'/>
		<hr/>
		<g:link screen="#">
			Retornar<g:icon type="return"/>
		</g:link>
	</g-coolbar>
</g:template>