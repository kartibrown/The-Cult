package creatures;

import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends Human
{
	public Player()
	{
		name = "";
		color = Color.CYAN;

		speed = 2;
		weight = 0;
		x = 100;
		y = 100;
		w = h = 20;
	}

	@Override
	public void render(final Graphics2D g)
	{
		g.setColor(color);
		g.fillOval(x, y, w, h);
	}
}