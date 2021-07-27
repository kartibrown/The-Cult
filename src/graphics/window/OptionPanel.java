package graphics.window;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	final JPanel southPanel;

	public OptionPanel()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BorderLayout());

		southPanel = new JPanel(new GridBagLayout());
		southPanel.setOpaque(false);
	}

	public void createBackButton()
	{
		final GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0, 0, 20, 0);

		final JButton back = new JButton("Back");
		southPanel.add(back, gbc);
		this.add(southPanel, BorderLayout.SOUTH);
	}
}