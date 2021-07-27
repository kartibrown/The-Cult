package graphics.window;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import graphics.World;
import graphics.creature.Player;

public class PlayPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private final Player player;

	private final World world;
	private final Dimension contentPaneSize;

	private final Timer timer;

	public PlayPanel(
			final Player player, final World world,
			final Dimension contentPaneSize
	)
	{
		this.setBackground(Color.DARK_GRAY);
		this.setOpaque(true);
		this.setLayout(new GridBagLayout());

		this.player = player;
		this.world = world;
		this.contentPaneSize = contentPaneSize;

		timer = new Timer(30, new ActionListener()
		{
			@Override
			public void actionPerformed(final ActionEvent e)
			{ repaint(); }
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

		final int cameraX = (int) (contentPaneSize.width / 2 - player.getX());
		final int cameraY = (int) (contentPaneSize.height / 2 - player.getY());
		g.translate(cameraX, cameraY);

		world.paintComponent(g);
		final Graphics2D g2 = (Graphics2D) g;
		player.setCameraLocation(cameraX, cameraY);
		player.render(g2);
		player.physics();
		player.move();
	}
}