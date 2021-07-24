package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel
{
	private static final long serialVersionUID = 1L;

	private final JPanel buttonPanel;
	private final JButton play, options, exit;

	public MainMenu(final String title)
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BorderLayout());

		final JLabel titleLabel = new JLabel(title);
		titleLabel.setFont(titleLabel.getFont().deriveFont(25f));
		titleLabel.setForeground(Color.BLACK);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());

		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 0, 20, 0);

		play = new JButton("Play");
		play.setFont(play.getFont().deriveFont(20f));
		gbc.gridx = 0;
		gbc.gridy = 0;
		buttonPanel.add(play, gbc);

		options = new JButton("Options");
		options.setFont(options.getFont().deriveFont(20f));
		gbc.gridy = 1;
		buttonPanel.add(options, gbc);

		exit = new JButton("Exit");
		exit.setFont(exit.getFont().deriveFont(20f));
		gbc.gridy = 2;
		buttonPanel.add(exit, gbc);

		this.add(titleLabel, BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
	}
}