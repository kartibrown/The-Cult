package graphics;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;

public abstract class Entity
{
	protected String name;
	protected Image texture;
	protected int health;

	protected final Point2D pos;
	protected Point2D centerPos;
	protected final Dimension size;

	public Entity()
	{
		pos = new Point();
		size = new Dimension();
	}

	public abstract void render(final Graphics2D g);

	public abstract void physics();

	/*
	 * GETTERS & SETTERS
	 */

	public final Point2D getPos()
	{ return pos; }

	public final Point2D getCenterPos()
	{ return centerPos; }

	public final double getX()
	{ return pos.getX(); }

	public final double getY()
	{ return pos.getY(); }

	public final double getCenterX()
	{ return centerPos.getX(); }

	public final double getCenterY()
	{ return centerPos.getY(); }
}
