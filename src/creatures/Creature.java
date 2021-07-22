package creatures;

import java.awt.Color;
import java.awt.Graphics2D;

import controls.Mouse;

public abstract class Creature
{
	protected String name;
	protected int years;
	protected Color color;

	protected float speed, speedOffset, weight;
	protected float x, y, w, h;

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
				x += speed / 1.1;
				break;
			case LEFT:
				x -= speed / 1.1;
				break;
			case NULL:
				break;
			default:
				break;
			}

			switch (dirY)
			{
			case FORWARD:
				y -= speed / 1.1;
				break;
			case BACKWARD:
				y += speed / 1.1;
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
				x += speed;
				break;
			case LEFT:
				x -= speed;
				break;
			case NULL:
				break;
			default:
				break;
			}

			switch (dirY)
			{
			case FORWARD:
				y -= speed;
				break;
			case BACKWARD:
				y += speed;
				break;
			default:
				break;
			}
		}
	}

	/*
	 * GETTERS & SETTERS
	 */

	public final void setDirectionX(final Direction dirX)
	{ this.dirX = dirX; }

	public final void setDirectionY(final Direction dirY)
	{ this.dirY = dirY; }

	public final Color getColor()
	{ return color; }

	public final void setColor(final Color color)
	{ this.color = color; }
}