package controls;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import graphics.creature.Player;
import graphics.creature.Creature.Direction;
import graphics.window.PlayPanel;

public class Keyboard
{
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

	public Keyboard(final PlayPanel playPanel, final Player player)
	{
		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "up");
		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "up release");

		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "down");
		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "down release");

		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right");
		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right release");

		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "left");
		playPanel.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "left release");

		playPanel.getActionMap().put("up", new MoveAction(player, "up"));
		playPanel.getActionMap().put("up release", new MoveAction(player, "up release"));

		playPanel.getActionMap().put("down", new MoveAction(player, "down"));
		playPanel.getActionMap().put("down release", new MoveAction(player, "down release"));

		playPanel.getActionMap().put("right", new MoveAction(player, "right"));
		playPanel.getActionMap().put("right release", new MoveAction(player, "right release"));

		playPanel.getActionMap().put("left", new MoveAction(player, "left"));
		playPanel.getActionMap().put("left release", new MoveAction(player, "left release"));
	}
}

class MoveAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

	final Player player;
	final String direction;

	MoveAction(final Player player, final String direction)
	{
		this.player = player;
		this.direction = direction;
	}

	@Override
	public void actionPerformed(final ActionEvent e)
	{
		switch (direction)
		{
		case "up":
			player.setMoveY(Direction.FORWARD);
			break;
		case "up release":
			player.setMoveY(Direction.NULL);
			break;
		case "down":
			player.setMoveY(Direction.BACKWARD);
			break;
		case "down release":
			player.setMoveY(Direction.NULL);
			break;
		case "right":
			player.setMoveX(Direction.RIGHT);
			break;
		case "right release":
			player.setMoveX(Direction.NULL);
			break;
		case "left":
			player.setMoveX(Direction.LEFT);
			break;
		case "left release":
			player.setMoveX(Direction.NULL);
			break;
		}
	}
}