package org.team686.learning;

public class Tutorial1
{
	public static void main(String[] args)
	{
		Circle circle = new Circle(1, 1, 1);

		DrawingFigure surface = new DrawingFigure(circle);
	
		surface.update(circle);
		
        wait(1.0);
		
		circle.setX(2);
		surface.update(circle);

        wait(1.0);
		
		circle.setY(10);
		surface.update(circle);
	}

	public static void wait(double timeInSec)
	{
		double startTime = System.currentTimeMillis() / 1000.0;
		double endTime = startTime + timeInSec;
		
		double currentTime = startTime;
		
		while (currentTime < endTime)
		{
			currentTime = System.currentTimeMillis() / 1000.0;
		}
	}

}
