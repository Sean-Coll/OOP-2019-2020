package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{	
	//float[] rainFall = new float[12]; //One way to make an array with 12 elements
	//Initialising the array with constant values
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58}; 
	//Adding .0 to any element will create an error because then it becomes a double which is too big to be stored in a float 
	//Array of strings
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		// for(int i = 0; i < rainFall.length; i++)
		// {
		// 	println(months[i] + "\t" + rainFall[i]);
		// }

		// //for each/enhanced for loop used for iterating over collections of objects
		// for(float f:rainFall)
		// {
		// 	println(f);
		// }
		// //The code is executed for every object in the collection
		// for(String s:months)
		// {
		// 	println(s);
		// }

		findMin();
		findMax();
	}

	void findMin()
	{
		float minRain = Float.MAX_VALUE;
		String minMonth = " ";
		for(float f:rainFall)
		{
			if(f < minRain)
			{
				minRain =  f;
			}
		}

		for(int i = 0; i < months.length; i++)
		{
			if(minRain == rainFall[i])
			{
				minMonth = months[i];
			}
		}

		println(minMonth + ": " + minRain);
	}

	void findMax()
	{
		float maxRain = 0.0f;
		String maxMonth = " ";

		for(float f:rainFall)
		{
			if(f > maxRain)
			{
				maxRain =  f;
			}
		}

		for(int i = 0; i < months.length; i++)
		{
			if(maxRain == rainFall[i])
			{
				maxMonth = months[i];
			}
		}

		println(maxMonth + ": " + maxRain);
	}

	void drawBarChart()
	{
		colorMode(HSB);	
		float x_axisY = 400;
		float y_axisX = 50;
		float barWidth = 20;
		float barHeight = 0;
		float barGap = 10;

		float hue_val = 0;
		float sat_val = 255;
		float bright_val = 255;

		//Draw axis
		fill(255, 255, 255);
		stroke(255, 0, 255);
		line(y_axisX, x_axisY, y_axisX, 0);
		line(y_axisX, x_axisY, 500, x_axisY);

		//Draw Bars
		for(float f:rainFall)
		{
			fill(hue_val, sat_val, bright_val);
			barHeight = f;
			rect(y_axisX + barGap, x_axisY, barWidth, ((f * 3) * -1.0f) );
			barGap += barWidth * 1.5f;
			hue_val += 20;
		}
	}
	

	float offset = 0;

	
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);		
		colorMode(HSB);	
		drawBarChart();
	}
}
