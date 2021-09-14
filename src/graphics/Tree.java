package graphics;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Tree extends Plant
{
	private final Image leaf1;

	public Tree(final int x, final int y, final int r)
	{
		pos.setLocation(x, y);
		size.setSize(r, r);
		
		texture = new ImageIcon().getImage();

		leaf1 = new ImageIcon(
				System.getProperty("user.dir") + "\\data\\leaf.png"
		).getImage().getScaledInstance(20, 20, 10);

	}

	@Override
	public void render(final Graphics2D g)
	{

		g.drawImage(leaf1, (int) pos.getX(), (int) pos.getY(), null);
	}

	@Override
	public void physics()
	{}
}