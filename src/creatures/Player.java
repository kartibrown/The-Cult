package creatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import controls.Mouse;

public class Player extends Human
{
	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		color = Color.CYAN;

		speed = 2;
		speedOffset = speed / 2;
		weight = 0;
		x = contentPaneSize.width / 2;
		y = contentPaneSize.height / 2;
		w = h = 20;
	}

	@Override
	public void render(final Graphics2D g)
	{
		final double r = Math
				.atan2(Mouse.getLocation().x, Mouse.getLocation().y);

		g.rotate(r, x - w / 2, y - h / 2);
		g.setColor(color);
		g.fillOval((int) x, (int) y, (int) w, (int) h);
		g.setColor(Color.BLACK);
		g.drawLine((int) (x + w / 2), (int) y, (int) (x + w / 2), (int) y + 10);
	}

	@Override
	public void physics()
	{}
}