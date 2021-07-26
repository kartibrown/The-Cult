package graphics.creature;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;

import controls.Mouse;

public class Player extends Human
{
	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		color = Color.CYAN;
		health = 100;

		speed = 5;

		size.setSize(new Dimension(40, 40));

		pos.setLocation(
				(int) contentPaneSize.width / 2 - size.width / 2,
				contentPaneSize.height / 2 - size.height / 2
		);
	}

	@Override
	public void render(final Graphics2D g)
	{
		final Point mLoc = Mouse.getLocation();

		centerPos = new Point(
				(int) pos.getX() + size.width / 2,
				(int) pos.getY() + size.height / 2
		);

		final double r = Math
				.atan2(centerPos.getY() - mLoc.y, centerPos.getX() - mLoc.x)
				- Math.PI / 2;

		final AffineTransform originalAT = g.getTransform();

		g.rotate(r, centerPos.getX(), centerPos.getY());

		g.setColor(color);
		g.fillOval(
				(int) pos.getX(), (int) pos.getY(), (int) size.width,
				(int) size.height
		);

		g.setColor(Color.BLACK);
		g.drawLine(
				(int) centerPos.getX(), (int) pos.getY(),
				(int) centerPos.getX(), (int) pos.getY() + 10
		);

		g.setTransform(originalAT);

		g.setFont(g.getFont().deriveFont(18f));
		g.drawString(
				Integer.toString(health), (int) pos.getX(),
				(int) pos.getY() - 20
		);
	}

	@Override
	public void physics()
	{}
}