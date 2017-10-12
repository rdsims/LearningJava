package org.team686.learning;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawingSurface
{
	public CircleSprite circleSprite;
	
	public DrawingSurface(Circle _circle)
	{
		circleSprite = new CircleSprite(_circle);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.lightGray);
		panel.setLayout(new BorderLayout());
		panel.add(circleSprite);
		
		JFrame frame = new JFrame("Drawing Surface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);		// center frame
		frame.setVisible(true);
	}

	
	
	public class CircleSprite extends JComponent
	{
		private static final long serialVersionUID = 1L;
		private Circle circle;
	
		public CircleSprite(Circle _circle)
		{
			circle = _circle;
		}
		
//		public void myPaint(Circle _circle)
//		{
//			circle = _circle;
//			repaint();
//		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.RED);
			g.fillOval((int)circle.getX(), (int)circle.getY(), (int)circle.getRadius(), (int)circle.getRadius());
		}
	}

	public void update(Circle _circle)
	{
//		circleSprite.myPaint(_circle);
		circleSprite.repaint();
	}
	
}
