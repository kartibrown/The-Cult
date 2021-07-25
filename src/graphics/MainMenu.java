package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel
{
	private static final long serialVersionUID = 1L;

	private final JPanel buttonPanel, titlePanel;

	public MainMenu()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BorderLayout());

		titlePanel = new JPanel();

		buttonPanel = new JPanel();
	}
	
	public void createTitle()
	{
		final GridBagConstraints gbc = new GridBagConstraints();
		
		titlePanel.setLayout(new GridBagLayout());
		titlePanel.setOpaque(false);

		gbc.insets = new Insets(70, 0, 0, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;

		final JLabel titleLabel = new JLabel("The Cult");
		titleLabel.setFont(titleLabel.getFont().deriveFont(60f));
		titleLabel.setForeground(Color.BLACK);

		titlePanel.add(titleLabel, gbc);

		this.add(titlePanel, BorderLayout.NORTH);
	}

	public void createButtons(final ActionListener bh)
	{
		final GridBagConstraints gbc = new GridBagConstraints();
		
		buttonPanel.setLayout(new GridBagLayout());
		buttonPanel.setOpaque(false);

		gbc.insets = new Insets(20, 0, 20, 0);

		final JButton play = new JButton("Play");
		final JButton options = new JButton("Options");
		final JButton exit = new JButton("Exit");

		initButtons(play, options, exit, gbc);
		play.addActionListener(bh);
		options.addActionListener(bh);
		exit.addActionListener(bh);

		this.add(buttonPanel, BorderLayout.CENTER);
	}

	private void initButtons(
			final JButton play, final JButton options, final JButton exit, final GridBagConstraints gbc
	)
	{
		play.setFont(play.getFont().deriveFont(20f));
		gbc.gridx = 0;
		gbc.gridy = 0;
		buttonPanel.add(play, gbc);

		options.setFont(options.getFont().deriveFont(20f));
		gbc.gridy = 1;
		buttonPanel.add(options, gbc);

		exit.setFont(exit.getFont().deriveFont(20f));
		gbc.gridy = 2;
		buttonPanel.add(exit, gbc);
	}
}