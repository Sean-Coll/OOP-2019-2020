package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	float center = 250;
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		/*background(0);		
		stroke(255);
		line(10, 10, 100, 10);
		line(10, 20, 100, 20);
		line(10, 30, 100, 30);
		line(10, 40, 100, 40);

		for(int y = 10 ; y <= 40 ; y += 10)
		{
			line(200, y, 300, y);
		}

		int yy = 10;
		while(yy <= 40)
		{
			line(300, yy, 400, yy);
			yy += 10;
		}*/
		// drawLinePattern();
		// drawPlainCircles();
		// drawRainbowRects();
		// drawGrid();
		drawRects();
	}

	public void drawLinePattern()
	{
		background(127);
		stroke(0);

		float lineX, lineY;

		//Draw lines
		for(lineX = 0, lineY = 0; lineX <= 500 && lineY <= 500; lineX += 19.23, lineY += 19.23)
		{
			line(lineX, 0, center, center); //Top lines
			line(lineX, 500, center, center); //Bottom lines
			line(500, lineY, center, center); //Right lines
			line(0, lineY, center, center); //Left lines
		}
	}

	public void drawPlainCircles()
	{
		background(127);
		stroke(0);

		float elipX, elipY;

		//Draw circles
		for(elipX = 25, elipY = center; elipX <= 500; elipX += 50)
		{
			ellipse(elipX, elipY, 50, 50);
		}
		
	}

	public void drawRainbowRects()
	{
		noStroke();
		float rectX, rectY;
		float recth = 500;
		float rectw = 50;
		float hue_val;

		for(rectX = 0, rectY = 0, hue_val = 0; rectX < 250; rectX += rectw, hue_val += 20)
		{
			fill(hue_val, 255, 255);
			rect(rectX, rectY, rectw, recth);
		}

		for(rectX = 250, rectY = 0, hue_val = 80; rectX <= 500; rectX += rectw, hue_val -= 20)
		{
			fill(hue_val, 255, 255);
			rect(rectX, rectY, rectw, recth);
		}
		
	}

	public void drawGrid()
	{
		background(0);
		stroke(85, 255, 255);
		float lineX = 50; 
		float lineY = 50;
		float numX = 40;
		float numY = 55;
		int grid_num = -5;
		float cornerX = 50;
		float cornerY = 50;

		int i = 0;

		for(i = 0; i <= 10; i++)
		{
			line(cornerX, lineY, width - cornerX, lineY); //Horizontal
			line(lineX, cornerY, lineX, width - cornerY); //Vertical
			text(grid_num, numX, 35); //Top numbers
			text(grid_num, 20, numY); //Side numbers

			lineX += 40;
			lineY += 40;
			numX += 40; 
			numY += 40;
			grid_num++;
		}
	}

	public void drawRects()
	{
		background(125);
		stroke(0);
		fill(255);
		float rectX = 125;
		float rectY = 125;
		float rectW = 150;
		float rectH = 40;
		
		int i = 0;

		for(i = 0; i <= 5; i++)
		{
			rect(rectX, rectY, rectW, rectH);

			rectY = rectY + rectH; //Move down
			rectX += 12.5; //Move Right
			rectW -= 25; //Shorten rectangles
		}
	}

}
