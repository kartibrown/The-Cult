package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import creatures.Creature.Direction;
import creatures.Player;

public class Keyboard implements KeyListener
{
	private final Player player;

	public Keyboard(final Player player)
	{ this.player = player; }

	@Override
	public synchronized void keyTyped(final KeyEvent e)
	{}

	@Override
	public synchronized void keyPressed(final KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W)
		{
			player.setMoveY(Direction.FORWARD);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN
				|| e.getKeyCode() == KeyEvent.VK_S)
		{
			player.setMoveY(Direction.BACKWARD);
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_D)
		{
			player.setMoveX(Direction.RIGHT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT
				|| e.getKeyCode() == KeyEvent.VK_A)
		{
			player.setMoveX(Direction.LEFT);
		}
	}

	@Override
	public synchronized void keyReleased(final KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP
				|| e.getKeyCode() == KeyEvent.VK_DOWN
				|| e.getKeyCode() == KeyEvent.VK_W
				|| e.getKeyCode() == KeyEvent.VK_S)
		{
			player.setMoveY(Direction.NULL);
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_LEFT
				|| e.getKeyCode() == KeyEvent.VK_D
				|| e.getKeyCode() == KeyEvent.VK_A)
		{
			player.setMoveX(Direction.NULL);
		}
	}
}
