package graphics;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tree extends Plant
{
	public Tree(final int x, final int y, final int r)
	{
		pos.setLocation(x, y);
		size.setSize(r, r);
		color = new Color(20, 255, 20);
	}

	@Override
	public void render(final Graphics2D g)
	{
		g.setColor(color);
		g.fillOval(
				(int) pos.getX(), (int) pos.getY(), (int) size.getWidth(),
				(int) size.getHeight()
		);
	}

	@Override
	public void physics()
	{}
}