import java.awt.Dimension;

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

		final Player player = new Player();
		final MyPanel panel = new MyPanel(player);

		final KeyControls keyControls = new KeyControls(player);

		panel.addKeyListener(keyControls);
		// panel.addMouseListener(controls);

		window.add(panel);
		window.setVisible(true);
	}
}