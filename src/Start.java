import java.awt.Dimension;

import controls.Keyboard;
import controls.Mouse;
import creatures.Player;
import graphics.MyPanel;
import graphics.MyWindow;

public class Start
{
	public static void main(final String[] args)
	{
		final MyWindow window = new MyWindow(
				"The Cult", new Dimension(800, 600)
		);

		final Player player = new Player(window.getContentPane().getSize());
		final MyPanel panel = new MyPanel(player);

		panel.addKeyListener(new Keyboard(player));
		panel.addMouseListener(new Mouse());

		window.add(panel);
		window.setVisible(true);
	}
}