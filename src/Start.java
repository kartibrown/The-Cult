import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controls.Keyboard;
import controls.Mouse;
import creatures.Player;
import graphics.MainMenu;
import graphics.MyWindow;
import graphics.OptionPanel;
import graphics.PlayPanel;

public class Start
{
	public static final void main(final String[] args)
	{
		final MyWindow window = new MyWindow("The Cult");

		final MainMenu menu = new MainMenu();
		menu.createTitle();
		menu.createButtons(new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				if (e.getActionCommand().equals("Play"))
				{
					window.remove(menu);

					final Player player = new Player(window.getContentPane().getSize());
					final PlayPanel playPanel = new PlayPanel(player);
					new Keyboard(playPanel, player);

					final Mouse mouse = new Mouse();
					playPanel.addMouseListener(mouse);
					playPanel.addMouseMotionListener(mouse);

					window.add(playPanel);
					window.setVisible(true);
				}
				else if (e.getActionCommand().equals("Options"))
				{
					window.remove(menu);
					
					final OptionPanel optionPanel = new OptionPanel();
					optionPanel.createBackButton();
					
					window.add(optionPanel);
					window.setVisible(true);
				}
				else
				{
					System.exit(0);
				}
			}
		});

		window.add(menu);
		window.setVisible(true);

	}
}