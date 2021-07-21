package creatures;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Creature
{
	protected String name;
	protected int years;
	protected Color color;

	protected int speed, weight;
	protected int x, y, w, h;

	protected static enum Direction
	{
		FORWARD, FORWARD_RIGHT, FORWARD_LEFT, BACKWARD, BACKWARD_RIGHT,
		BACKWARD_LEFT, RIGHT, LEFT, NULL
	}

	protected Direction direction;

	public Creature()
	{}

	public abstract void render(final Graphics2D g);

	public void move()
	{
		switch (direction)
		{
		case FORWARD:
			y += speed;
			break;
		case FORWARD_RIGHT:
			x += speed;
			y += speed;
			break;
		case FORWARD_LEFT:
			x -= speed;
			y += speed;
			break;
		case BACKWARD:
			y -= speed;
			break;
		case BACKWARD_RIGHT:
			x += speed;
			y -= speed;
			break;
		case BACKWARD_LEFT:
			x -= speed;
			y -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case LEFT:
			x -= speed;
			break;
		case NULL:
			break;
		}
	}

	/*
	 * GETTERS & SETTERS
	 */

	public final void setDirection(final Direction direction)
	{ this.direction = direction; }

	public final Color getColor()
	{ return color; }

	public final void setColor(final Color color)
	{ this.color = color; }
}