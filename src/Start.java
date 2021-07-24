
import controls.Keyboard;
import controls.Mouse;
import creatures.Player;
import graphics.MainMenu;
import graphics.MyWindow;
import graphics.PlayPanel;

public class Start
{
	public static void main(final String[] args)
	{
		final MyWindow window = new MyWindow("The Cult");
		
		final MainMenu menu = new MainMenu("The Cult");

		window.add(menu);
		window.setVisible(true);
	}

	public void later()
	{
		/*
		 * final Player player = new Player(window.getContentPane().getSize()); final
		 * PlayPanel playPanel = new PlayPanel(player); panel.addKeyListener(new
		 * Keyboard(player));
		 * 
		 * final Mouse mouse = new Mouse(); panel.addMouseListener(mouse);
		 * panel.addMouseMotionListener(mouse);
		 * 
		 * window.add(panel);
		 */
	}
}