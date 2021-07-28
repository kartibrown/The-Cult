package graphics.creature;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import controls.Mouse;

public class Player extends Human
{
	private int cameraX, cameraY;

	private final BufferedImage sword;

	public Player(final Dimension contentPaneSize)
	{
		name = "Player";
		color = Color.CYAN;
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

		final ImageIcon swordImage = new ImageIcon(
				System.getProperty("user.dir") + "\\data\\sword.png"
		);

		final Image tempImage = swordImage.getImage();

		sword = new BufferedImage(
				swordImage.getIconWidth(), swordImage.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB
		);
		sword.getGraphics().drawImage(tempImage, 0, 0, null);
		tempImage.flush();
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
		final double rad = Math.atan2(calY, calX) - Math.PI / 2;

		// final AffineTransform originalAT = g.getTransform();

		g.drawImage(sword, (int) pos.getX(), (int) pos.getY() - 30, null);

		g.setFont(g.getFont().deriveFont(16f));
		g.drawString(
				Integer.toString(health), (int) pos.getX(),
				(int) pos.getY() - 20
		);

		g.rotate(rad, centerPos.getX(), centerPos.getY());

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