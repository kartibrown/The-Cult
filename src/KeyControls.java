import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import creatures.Creature.Direction;
import creatures.Player;

public class KeyControls implements KeyListener
{
	private final Player player;

	public KeyControls(final Player player)
	{ this.player = player; }

	@Override
	public synchronized void keyTyped(final KeyEvent e)
	{}

	@Override
	public synchronized void keyPressed(final KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			player.setDirectionY(Direction.FORWARD);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.setDirectionY(Direction.BACKWARD);
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.setDirectionX(Direction.RIGHT);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.setDirectionX(Direction.LEFT);
		}
	}

	@Override
	public synchronized void keyReleased(final KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_UP
				|| e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			player.setDirectionY(Direction.NULL);
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT
				|| e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.setDirectionX(Direction.NULL);
		}
	}
}
