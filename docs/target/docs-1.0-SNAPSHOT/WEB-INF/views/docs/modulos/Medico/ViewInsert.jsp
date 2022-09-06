<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<g:template filename="/WEB-INF/views/FULL.jsp">
    <div>viewinsert medico</div>
    	<form method="POST" action="#">
		<fieldset>
			<legend>
				<g:path/>
			</legend>
			<label data-size="4">
				ID:
				<span>
					Gerado automaticamente
				</span>
			</label>
			<label data-size="4">
				Sexo:
				<span>
					<g:select property="form.sexo"/>
				</span>
			</label>
			<label data-size="4">
				CPF:
				<span>
					<g:text property="form.cpf"/>
				</span>
			</label>
			<label data-size="4">
				CRM:
				<span>
					<g:text property="form.crm"/>
				</span>
			</label>
			<label data-size="16">
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
			<g:link class="Cancel" screen="#">
				Cancelar<g:icon type="cancel"/>
			</g:link>
		</g-coolbar>
	</form>
</g:template>