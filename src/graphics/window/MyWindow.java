package graphics.window;

import javax.swing.JFrame;

public class MyWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MyWindow(final String title)
	{
		this.setTitle(title);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(false); // true to make fullscreen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.pack();
	}
}