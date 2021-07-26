package creatures;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public abstract class Creature
{
	protected String name;
	protected int years;
	protected Color color;
	protected int health;

	/**
	 * Modifier for not letting creatures go faster when going diagonally
	 */
	protected final double speedModifier;
	protected double speed, weight;
	protected Point2D pos, centerPos;
	protected Dimension size;

	public static enum Direction
	{
		FORWARD, BACKWARD, RIGHT, LEFT, NULL
	}

	protected Direction dirX, dirY;

	public Creature()
	{
		speedModifier = 1.2;
		dirX = dirY = Direction.NULL;
	}

	public abstract void render(final Graphics2D g);

	public abstract void physics();

	public void move()
	{
		if (!dirX.equals(Direction.NULL) && !dirY.equals(Direction.NULL))
		{
			moveDiagonallyX();
			moveDiagonallyY();
		}
		else
		{
			moveX();
			moveY();
		}
	}

	private void moveY()
	{
		switch (dirY)
		{
		case FORWARD:
			pos.setLocation(pos.getX(), pos.getY() - speed);
			break;
		case BACKWARD:
			pos.setLocation(pos.getX(), pos.getY() + speed);
			break;
		default:
			break;
		}
	}

	private void moveX()
	{
		switch (dirX)
		{
		case RIGHT:
			pos.setLocation(pos.getX() + speed, pos.getY());
			break;
		case LEFT:
			pos.setLocation(pos.getX() - speed, pos.getY());
			break;
		case NULL:
			break;
		default:
			break;
		}
	}

	private void moveDiagonallyY()
	{
		switch (dirY)
		{
		case FORWARD:
			pos.setLocation(pos.getX(), pos.getY() - speed / speedModifier);
			break;
		case BACKWARD:
			pos.setLocation(pos.getX(), pos.getY() + speed / speedModifier);
			break;
		default:
			break;
		}
	}

	private void moveDiagonallyX()
	{
		switch (dirX)
		{
		case RIGHT:
			pos.setLocation(pos.getX() + speed / speedModifier, pos.getY());
			break;
		case LEFT:
			pos.setLocation(pos.getX() - speed / speedModifier, pos.getY());
			break;
		case NULL:
			break;
		default:
			break;
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