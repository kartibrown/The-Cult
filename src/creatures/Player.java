package creatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import controls.Mouse;

public class Player extends Human
{
	private final Point centerContentPane;

	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		color = Color.CYAN;
		health = 100;

		speed = 2;
		speedOffset = speed / 2;
		weight = 0;

		size = new Dimension(40, 40);

		pos = new Point();
		pos.x = contentPaneSize.width / 2 - size.width / 2;
		pos.y = contentPaneSize.height / 2 - size.height / 2;

		centerContentPane = new Point(contentPaneSize.width / 2, contentPaneSize.height / 2);
	}

	@Override
	public void render(final Graphics2D g)
	{
		final Point mLoc = Mouse.getLocation();
		
		final Point centerPos = new Point(pos.x + size.width / 2, pos.y + size.height / 2);

		final double r = Math.atan2(centerPos.y - mLoc.y, centerPos.x - mLoc.x) - Math.PI / 2;

		final AffineTransform originalAT = g.getTransform();

		g.rotate(r, centerPos.x, centerPos.y);
		g.setColor(color);
		g.fillOval((int) pos.x, (int) pos.y, (int) size.width, (int) size.height);
		g.setColor(Color.BLACK);
		g.drawLine(centerPos.x, (int) pos.y, centerPos.x, (int) pos.y + 10);

		g.setTransform(originalAT);
		g.setFont(g.getFont().deriveFont(18f));
		g.drawString(Integer.toString(health), (int) pos.x, (int) pos.y - 20);
	}

	@Override
	public void physics()
	{}
}