package file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface IFile
{
	public static List<String> getListFromFile(final File file)
	{
		final List<String> list = new ArrayList<String>();

		try (final Scanner scan = new Scanner(file))
		{
			while (scan.hasNextLine())
			{
				list.add(scan.nextLine());
			}
			scan.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}

		return list;
	}
	
	public void create();
}
