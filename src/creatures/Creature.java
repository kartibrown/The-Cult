package creatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Creature
{
	protected String name;
	protected int years;
	protected Color color;
	protected int health;

	protected float speed, speedOffset, weight;
	protected Point pos;
	protected Dimension size;

	public static enum Direction
	{
		FORWARD, BACKWARD, RIGHT, LEFT, NULL
	}

	protected Direction dirX, dirY;

	public Creature()
	{ dirX = dirY = Direction.NULL; }

	public abstract void render(final Graphics2D g);

	public abstract void physics();

	public void move()
	{
		if (!dirX.equals(Direction.NULL) && !dirY.equals(Direction.NULL))
		{
			switch (dirX)
			{
			case RIGHT:
				pos.x += speed / 1.1;
				break;
			case LEFT:
				pos.x -= speed / 1.1;
				break;
			case NULL:
				break;
			default:
				break;
			}

			switch (dirY)
			{
			case FORWARD:
				pos.y -= speed / 1.1;
				break;
			case BACKWARD:
				pos.y += speed / 1.1;
				break;
			default:
				break;
			}
		}
		else
		{
			switch (dirX)
			{
			case RIGHT:
				pos.x += speed;
				break;
			case LEFT:
				pos.x -= speed;
				break;
			case NULL:
				break;
			default:
				break;
			}

			switch (dirY)
			{
			case FORWARD:
				pos.y -= speed;
				break;
			case BACKWARD:
				pos.y += speed;
				break;
			default:
				break;
			}
		}
	}

	/*
	 * GETTERS & SETTERS
	 */

	public final void setMoveX(final Direction dirX)
	{ this.dirX = dirX; }

	public final void setMoveY(final Direction dirY)
	{ this.dirY = dirY; }

	public final Color getColor()
	{ return color; }

	public final void setColor(final Color color)
	{ this.color = color; }
}