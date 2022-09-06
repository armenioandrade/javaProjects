package gate.sql.fetcher;

import gate.sql.Cursor;
import java.util.ArrayList;
import java.util.List;

/**
 * Fetches a cursor as a list of java arrays.
 */
public class ArrayListFetcher implements Fetcher<List<Object[]>>
{

	private final List<Object[]> result = new ArrayList<>();

	/**
	 * Fetches each row as a list of java arrays of Objects.
	 *
	 * @param cursor the cursor to be fetched
	 *
	 * @return each row fetched as a list of java arrays of Objects
	 */
	@Override
	public List<Object[]> fetch(Cursor cursor)
	{
		Class[] types = cursor.getColumnTypes();
		while (cursor.next())
		{
			Object[] array = new Object[types.length];
			for (int i = 0; i < array.length; i++)
				array[i] = cursor.getCurrentValue(types[i]);
			result.add(array);
		}
		return result;
	}

	/**
	 * Return the accumulated result of fetch operations.
	 *
	 * @return the accumulated result of fetch operations
	 */
	public List<Object[]> getResult()
	{
		return result;
	}
}
