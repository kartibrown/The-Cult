package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import creatures.Player;

public class PlayPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private Player player;

	private final Timer timer;

	public PlayPanel(final Player player)
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new GridBagLayout());
		this.setFocusable(true);
		this.requestFocus();

		this.player = player;

		timer = new Timer(30, new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(final Graphics g)
	{
		final Thread t1 = new Thread()
		{
			@Override
			public void run()
			{ timer.start(); }
		};
		t1.start();

		super.paintComponent(g);
		final Graphics2D g2 = (Graphics2D) g;
		player.render(g2);
		player.physics();
		player.move();
	}
}