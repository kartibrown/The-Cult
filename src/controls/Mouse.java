package controls;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
	private static Point location;
	
	public Mouse()
	{
		location = new Point();
	}

	/*
	 * Mouse Listener
	 */

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
	 * Mouse Motion Listener
	 */

	@Override
	public void mouseDragged(final MouseEvent e)
	{}

	@Override
	public void mouseMoved(final MouseEvent e)
	{ location = e.getPoint(); }

	/*
	 * GETTERS & SETTERS
	 */

	public static final Point getLocation()
	{
		return location;
	}
}