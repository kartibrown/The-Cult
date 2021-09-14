package graphics.creature;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.ImageIcon;

import controls.Mouse;

public class Player extends Human
{
	private int cameraX, cameraY;

	// private final Image sword;

	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		texture = new ImageIcon(
				System.getProperty("user.dir") + "\\data\\player-idle.gif"
		).getImage().getScaledInstance(80, 80, 40);
		health = 100;

		speed = 5;

		size.setSize(new Dimension(40, 40));

		pos.setLocation(
				contentPaneSize.width / 2 - size.width / 2,
				contentPaneSize.height / 2 - size.height / 2
		);

		centerPos = new Point(
				(int) pos.getX() + size.width / 2,
				(int) pos.getY() + size.height / 2
		);

		// sword = new ImageIcon(
		// System.getProperty("user.dir") + "\\data\\sword.png"
		// ).getImage();
	}

	@Override
	public void render(final Graphics2D g)
	{
		final Point mLoc = Mouse.getLocation();

		centerPos = new Point(
				(int) pos.getX() + size.width / 2,
				(int) pos.getY() + size.height / 2
		);

		final double calY = centerPos.getY() + cameraY - mLoc.y;
		final double calX = centerPos.getX() + cameraX - mLoc.x;
		final double rad = Math.atan2(calY, calX) - Math.PI / 2 - 1.8;

		// final AffineTransform originalAT = g.getTransform();

		// g.drawImage(sword, (int) pos.getX(), (int) pos.getY() - 30, null);

		g.setFont(g.getFont().deriveFont(16f));
		g.drawString(
				Integer.toString(health), (int) pos.getX(),
				(int) pos.getY() - 20
		);

		g.rotate(rad, centerPos.getX(), centerPos.getY());

		g.drawImage(
				texture, (int) pos.getX() - texture.getWidth(null) / 2,
				(int) pos.getY() - texture.getHeight(null) / 2, null
		);

		// g.setTransform(originalAT);
	}

	@Override
	public void physics()
	{}

	public void setCameraLocation(final int cameraX, final int cameraY)
	{
		this.cameraX = cameraX;
		this.cameraY = cameraY;
	}
}