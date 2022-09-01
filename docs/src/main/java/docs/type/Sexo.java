package docs.type;

import gate.annotation.Color;
import gate.annotation.Converter;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.converter.EnumStringConverter;

@Converter(EnumStringConverter.class)
public enum Sexo
{
	@Icon("2280")
	@Color("#000066")
	@Name("Masculino")
	MASCULINO,
	@Icon("2281")
	@Color("#660000")
	@Name("Feminino")
	FEMININO
}
