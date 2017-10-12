package org.team686.learning;

public class Tutorial1
{
	public static void main(String[] args)
	{
		Circle circle = new Circle(10, 10, 10);

		DrawingSurface surface = new DrawingSurface(circle);
	
		surface.update(circle);
		
        wait(1.0);
		
		circle.setX(20);
		surface.update(circle);

        wait(1.0);
		
		circle.setY(100);
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
