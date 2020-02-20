package ie.tudublin;

import java.util.Arrays; 
import java.util.Collections; 

import processing.core.PApplet;

public class ArraysExample extends PApplet
{	

	//float[] rainFall = new float[12]; 
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 0 ; i < rainFall.length; i ++)
		{
			println(months[i] + "\t" + rainFall[i]);
		}

		for(float f:rainFall)
		{
			println(f);
		}

		for(String s:months)
		{
			println(s);
		}

		int minIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}
		println(months[minIndex] + " had the minimum rainfall of " + rainFall[minIndex]);
		
		int maxIndex = 0;
		for(int i = 1 ; i < rainFall.length ; i ++)
		{
			if (rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}
		println(months[maxIndex] + " had the maximum rainfall of " + rainFall[maxIndex]);

		// You can also calculate the minimum and max of an arry this way:
		// Note the array is of type Float not float
		// Float are objects float is a primitive type
		Float[] floatArray = {10.0f, 5.0f, 20.0f};
		float min = Collections.min(Arrays.asList(floatArray)); 
        float max = Collections.max(Arrays.asList(floatArray));
	}

	void drawBarChart()
	{
		float w = width / (float) rainFall.length;
		float cGap = 255 / (float) rainFall.length;
		noStroke();
		colorMode(HSB);
		for(int i = 0 ; i < rainFall.length ; i ++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255);
			rect(x, height, w, -rainFall[i]);
		}
	}

	void drawLineGraph()
	{
		stroke(255);
		textSize(12);
		colorMode(HSB);
		float topX = 40;
		float topY = 20;

		float sideLineX = 35;
		float sideLineY = 20;
		float sidelineGap = 28;

		float baseLineX = 40;
		float baseLineY = 440;
		float baseLineEndX = 470;

		float bottomLineX = 40;
		float bottomLineY = 440;
		float bottomLineH = 5;
		float bottomLineGap = 39.0909090909090f;

		int sideTextVal = 150;
		float sideTextX = 30;
		float sideTextY = 22;

		float bottomTextX = 40;
		float bottomTextY = 470;

		float trendLineX = 40;
		float trendLineY = 0;
		float trendLineY2 = 0;

		float graphMin = 0;
		float graphMax = 150;


		line(topX, topY, baseLineX, baseLineY);
		line(baseLineX, baseLineY, baseLineEndX, baseLineY);

		textAlign(RIGHT);
		//SideLines and Y values
		for(int i = 0; i <= 15; i ++)
		{
			line(sideLineX, sideLineY, topX, sideLineY);
			text(sideTextVal, sideTextX, sideTextY);

			sideLineY += sidelineGap;
			sideTextY += sidelineGap;
			sideTextVal -= 10;
		}

		textAlign(CENTER);
		//BottomLines and Months
		for(int j = 0; j < months.length; j++)
		{
			line(bottomLineX, bottomLineY, bottomLineX, bottomLineY + bottomLineH);
			text(months[j], bottomTextX, bottomTextY);

			bottomLineX += bottomLineGap;
			bottomTextX += bottomLineGap;
		}
		stroke(130,255,255);
		//TrendLine
		for(int k = 0; k < months.length - 1; k++)
		{
			trendLineY = map(rainFall[k], graphMin, graphMax, baseLineY, topY);
			trendLineY2 = map(rainFall[k+1], graphMin, graphMax, baseLineY, topY);
			line(trendLineX, trendLineY, trendLineX + bottomLineGap, trendLineY2);
			trendLineX += bottomLineGap;
		}
	}

	
	//Bryan's solution
	void drawLineGraph2()
	{
		float border = width *0.1f;
		line(border, border, border, height - border);
		textAlign(CENTER, CENTER);
		fill(255);
		stroke(255);
		for(int ya = 0; ya <= 150; ya += 10)
		{
			float y = map(ya, 0, 150, height - border, border);
			line(border, y, border - 5, y);
			text(ya, border / 2, y);
			
		}
		line(border, height - border, width - border, height - border);
		for(int i = 0; i < months.length; i++)
		{
			float x = map(i, 0, months.length - 1, border, width - border);
			line(x, height - border, x, height - border + 5);
			text(months[i], x, height - border / 2);
		}

		for(int i = 0; i < rainFall.length - 1; i++)
		{
			float x1 = map(i, 0, months.length - 1, border, width - border);
			float x2 = map(i + 1, 0, months.length - 1, border, width - border);

			float y1 = map(rainFall[i], 0, 150, height - border, border);
			float y2 = map(rainFall[i+1], 0, 150, height - border, border);

			line(x1, y1, x2, y2);
		}
	}

	void drawPieChart()
	{
		float centerX = width / 2;
		float centerY = height / 2;
		float arcW = 400;

		float arrayTotal = 0.0f;
		float arrayMax = 104;

		float totalAng = 0;

		float hue_val = 0;
		colorMode(HSB);

		stroke(0);

		// arc(centerX, centerY, 100, 100, PI, PI * 1.5f);
		for(int j = 0; j < rainFall.length; j++)
		{
			arrayTotal += rainFall[j];
		}

		for(int i = 0; i < rainFall.length; i++)
		{
			float ang1 = map(totalAng, 0, arrayTotal, 0, TWO_PI);
			float ang2 = map(rainFall[i] + totalAng, 0, arrayTotal, 0, TWO_PI);
			fill(hue_val, 255, 255);
			arc(centerX, centerY, arcW, arcW, ang1, ang2, PIE);
			totalAng += rainFall[i];
			hue_val += 255 / rainFall.length - 1;
		}
	}
	

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

		//drawBarChart();
		// drawLineGraph();
		// drawLineGraph2();
		drawPieChart();
	}
}
