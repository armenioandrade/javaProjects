package gate.converter.custom;

import gate.constraint.Constraint;
import gate.constraint.Maxlength;
import gate.constraint.Pattern;
import gate.converter.Converter;
import gate.error.ConversionException;
import gate.type.CNPJ;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

public class CNPJConverter implements Converter
{

	@Override
	public List<Constraint.Implementation<?>> getConstraints()
	{
		List<Constraint.Implementation<?>> constraints = new LinkedList<>();
		constraints.add(new Maxlength.Implementation(18));
		constraints.add(new Pattern.Implementation("^[0-9]{2}[.][0-9]{3}[.][0-9]{3}[/][0-9]{4}[-][0-9]{2}$"));
		return constraints;
	}

	@Override
	public String getMask()
	{
		return "##.###.###/####-##";
	}

	@Override
	public String getDescription()
	{
		return "Campos de CNPJ devem ser preenchidos no formato 99.999.999/9999-99";
	}

	@Override
	public String toText(Class<?> type, Object object)
	{
		return object != null ? object.toString() : "";
	}

	@Override
	public String toText(Class<?> type, Object object, String format)
	{
		return object != null ? String.format(format, object) : "";
	}

	@Override
	public String toString(Class<?> type, Object object)
	{
		return object != null ? object.toString() : "";
	}

	@Override
	public Object ofString(Class<?> type, String string) throws ConversionException
	{
		if (string == null)
			return null;

		string = string.trim();
		if (string.isEmpty())
			return null;

		try
		{
			return CNPJ.of(string);
		} catch (IllegalArgumentException ex)
		{
			throw new ConversionException(string + " não é um CNPJ válido.");
		}
	}

	@Override
	public Object readFromResultSet(ResultSet rs, int fields, Class<?> type) throws SQLException
	{
		String value = rs.getString(fields);
		return rs.wasNull() ? null : CNPJ.of(value);
	}

	@Override
	public Object readFromResultSet(ResultSet rs, String fields, Class<?> type) throws SQLException
	{
		String value = rs.getString(fields);
		return rs.wasNull() ? null : CNPJ.of(value);
	}

	@Override
	public int writeToPreparedStatement(PreparedStatement ps, int fields, Object value) throws SQLException
	{
		if (value != null)
			ps.setString(fields++, value.toString());
		else
			ps.setNull(fields++, Types.VARCHAR);
		return fields;
	}
}
