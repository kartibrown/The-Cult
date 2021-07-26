package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Entity
{
	protected String name;
	protected Color color;
	protected int health;

	protected final Point2D pos;
	protected Point2D centerPos;
	protected final Dimension size;

	public Entity()
	{
		pos = new Point();
		size = new Dimension();
	}

	/*
	 * GETTERS & SETTERS
	 */

	public final Color getColor()
	{ return color; }

	public final void setColor(final Color color)
	{ this.color = color; }
}
