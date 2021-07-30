package file;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FileWorld extends GameFiles implements IFile
{
	private static final File world = new File(dataDir + "\\world\\world.data");

	public FileWorld()
	{}

	@Override
	public void create()
	{
		System.out.println("Checking world file...");
		if (!world.isFile())
		{
			makeDir();
			makeFile();
			System.out.println("World files created!");
		}
	}

	private void makeFile()
	{
		try
		{
			world.createNewFile();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

	private void makeDir()
	{
		world.getParentFile().mkdir();

		try
		{
			if (!world.getParentFile().isDirectory())
			{
				throw new IOException(
						"Could not create folder: " + world.getParent()
				);
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

	public void generate()
	{
		final Random rand = new Random();
	}
}