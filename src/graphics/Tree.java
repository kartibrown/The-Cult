package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Tree extends Plant
{
	BufferedImage leaf1;

	public Tree(final int x, final int y, final int r)
	{
		pos.setLocation(x, y);
		size.setSize(r, r);
		color = new Color(20, 255, 20);

		try
		{
			leaf1 = ImageIO
					.read(
							new File(
									System.getProperty("user.dir")
											+ "\\data\\leaf.png"
							)
					);
		}
		catch (final IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void render(final Graphics2D g)
	{
		g.setColor(color);
		g.fillOval(
				(int) pos.getX(), (int) pos.getY(), (int) size.getWidth(),
				(int) size.getHeight()
		);

		g.drawImage(leaf1, (int) pos.getX(), (int) pos.getY(), null);
	}

	@Override
	public void physics()
	{}
}