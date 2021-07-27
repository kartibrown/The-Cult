package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class World extends JPanel
{
	private static final long serialVersionUID = 1L;

	final Tree trees[];

	public World(final Dimension contentPaneSize)
	{
		this.setOpaque(false);
		this.setLayout(null);

		trees = new Tree[5];

		final Random rand = new Random();

		for (int i = 0; i < 5; i++)
		{
			final int x = rand.nextInt(contentPaneSize.width);
			final int y = rand.nextInt(contentPaneSize.height);
			final int r = rand.nextInt(20);
			trees[i] = new Tree(x, y, r);
		}
	}

	@Override
	public void paintComponent(final Graphics g)
	{
		super.paintComponent(g);

		final Graphics2D g2 = (Graphics2D) g;

		for (final Tree tree : trees)
		{
			tree.render(g2);
		}
	}
}