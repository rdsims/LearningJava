package org.team686.learning;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.Shape;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawingFigure
{
	public CircleSprite circleSprite;
	
	public static final int WIDTH  = 1000;
	public static final int HEIGHT =  600;
	public static final int SCALE  =   10;
	
	public DrawingFigure(Circle _circle)
	{
		circleSprite = new CircleSprite(_circle);
		
		DrawingPanel panel = new DrawingPanel();
		panel.setBackground(Color.lightGray);
		panel.setLayout(new BorderLayout());
		panel.setLocation(0, 0);
		panel.add(circleSprite);
		
		JFrame frame = new JFrame("Drawing Surface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocationRelativeTo(null);		// center frame
		frame.setVisible(true);
		
	}

	public static class MyScale extends AffineTransform
	{
		private static final long serialVersionUID = 1L;

		MyScale()
		{
			this.setToTranslation(WIDTH/2, HEIGHT/2);
			this.scale(SCALE, -SCALE);
		}
	}
	
	public class DrawingPanel extends JPanel
	{
		private static final long serialVersionUID = 1L;
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D)g;
			AffineTransform oldAt = g2d.getTransform();
			
			AffineTransform myScale = new MyScale();
					
			// draw x & y axes
			g.setColor(Color.BLACK);
			g2d.draw(myScale.createTransformedShape(new Line2D.Double(-getWidth()/2, 0, +getWidth()/2, 0)));
			g2d.draw(myScale.createTransformedShape(new Line2D.Double(0, -getHeight()/2, 0, +getHeight()/2)));

			// draw x & y ticks
			double tickSize = 1.0/3.0;
			for (int k=1; k<getHeight()/2; k++)
			{
				g2d.draw(myScale.createTransformedShape(new Line2D.Double(-tickSize, +k, +tickSize, +k)));
				g2d.draw(myScale.createTransformedShape(new Line2D.Double(-tickSize, -k, +tickSize, -k)));
			}
			for (int k=1; k<getWidth()/2; k++)
			{
				g2d.draw(myScale.createTransformedShape(new Line2D.Double(+k, -tickSize, +k, +tickSize)));
				g2d.draw(myScale.createTransformedShape(new Line2D.Double(-k, -tickSize, -k, +tickSize)));
			}
			
			g2d.setTransform(oldAt);
		}		
	}
	
	public class CircleSprite extends JComponent
	{
		private static final long serialVersionUID = 1L;
		private Circle circle;
	
		public CircleSprite(Circle _circle)
		{
			circle = _circle;
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			AffineTransform myScale = new MyScale();
			
			Graphics2D g2d = (Graphics2D)g;

			g2d.setColor(Color.RED);
			Shape s = new Ellipse2D.Double(circle.getX(), circle.getY(), circle.getRadius(), circle.getRadius());
			Shape ts = myScale.createTransformedShape(s);
			g2d.fill(ts);

		}
	}

	public void update(Circle _circle)
	{
		circleSprite.repaint();
	}
	
}
