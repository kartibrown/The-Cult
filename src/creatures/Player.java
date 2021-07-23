package creatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import controls.Mouse;

public class Player extends Human
{
	private final Point centerScreen;

	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		color = Color.CYAN;
		health = 100;

		speed = 2;
		speedOffset = speed / 2;
		weight = 0;
		w = h = 40;
		x = contentPaneSize.width / 2 - w / 2;
		y = contentPaneSize.height / 2 - h / 2;

		centerScreen = new Point(
				contentPaneSize.width / 2, contentPaneSize.height / 2
		);
	}

	@Override
	public void render(final Graphics2D g)
	{
		final Point mLoc = Mouse.getLocation();
		double r = Math.atan2(centerScreen.y - mLoc.y, centerScreen.x - mLoc.x)
				- Math.PI / 2;

		final AffineTransform saveAT = g.getTransform();

		g.rotate(r, x + w / 2, y + h / 2);
		g.setColor(color);
		g.fillOval((int) x, (int) y, (int) w, (int) h);
		g.setColor(Color.BLACK);
		g.drawLine((int) (x + w / 2), (int) y, (int) (x + w / 2), (int) y + 10);

		g.setTransform(saveAT);
		g.setFont(g.getFont().deriveFont(18f));
		g.drawString(Integer.toString(health), (int) x, (int) y - 20);
	}

	@Override
	public void physics()
	{}
}