<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
	<form method="POST" action="#">
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
				<span>
					<g:select property="form.sexo"/>
				</span>
			</label>
			<label data-size="2">
				CPF:
				<span>
					<g:text property="form.cpf"/>
				</span>
			</label>
			<label data-size="2">
				CRM:
				<span>
					<g:text property="form.crm"/>
				</span>
			</label>
			<label data-size="8">
				Nome:
				<span>
					<g:text property="form.nome"/>
				</span>
			</label>
		</fieldset>

		<g-coolbar>
			<g:link class="Commit" method="post">
				Concluir<g:icon type="commit"/>
			</g:link>
			<hr/>
			<g:link class="Cancel" action="Select" _form.id="${screen.form.id}">
				Cancelar<g:icon type="cancel"/>
			</g:link>
		</g-coolbar>

		<g:hidden property="form.id"/>
	</form>
</g:template>