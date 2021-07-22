package creatures;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Human
{
	public Player()
	{
		name = "Player";
		color = Color.CYAN;

		speed = 2;
		speedOffset = speed / 2;
		weight = 0;
		x = 100;
		y = 100;
		w = h = 20;
	}

	@Override
	public void render(final Graphics2D g)
	{
		g.setColor(color);
		g.fillOval((int) x, (int) y, (int) w, (int) h);
		g.setColor(Color.BLACK);
		g.drawLine((int) (x + w / 2), (int) y, (int) (x + w / 2), (int) y + 10);
	}

	@Override
	public void physics()
	{}
}