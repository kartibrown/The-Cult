package graphics;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MyWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	public MyWindow(final String title, final Dimension size)
	{
		this.setTitle(title);
		this.setPreferredSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}