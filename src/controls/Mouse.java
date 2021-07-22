package controls;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener
{

	public Mouse()
	{}

	@Override
	public void mouseClicked(final MouseEvent e)
	{}

	@Override
	public void mousePressed(final MouseEvent e)
	{}

	@Override
	public void mouseReleased(final MouseEvent e)
	{}

	@Override
	public void mouseEntered(final MouseEvent e)
	{}

	@Override
	public void mouseExited(final MouseEvent e)
	{}

	/*
	 * GETTERS & SETTERS
	 */

	public static final Point getLocation()
	{ return MouseInfo.getPointerInfo().getLocation(); }
}