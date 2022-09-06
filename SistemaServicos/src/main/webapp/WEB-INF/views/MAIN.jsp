<!DOCTYPE HTML>

<%@ taglib uri="http://www.gate.com.br/gate" prefix="g"%>

<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>${app.id} - ${app.name}</title>
		<link rel="shortcut icon" href="FavIcon.png" />
		<link rel='stylesheet' type='text/css' href='gate/style/Gate.css?version=${version}'/>
		<script type='module' src='gate/script/Gate.mjs?version=${version}' charset="utf-8"></script>
	</head>
	<body>
		<g:insert/>
	</body>
</html>