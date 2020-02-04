package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
	}

	/*
	public void draw() {
		background(0, 0, 255);
		stroke(255, 0, 0);
		fill(255, 255, 0);
		line(10, 10, 100, 100);		// x1, y1, x2, y2
		point(50, 50); // x, y
		ellipse(100, 200, 50, 150); // cx, cy, w, h
		fill(0, 255, 0);
		rect(50, 10, 100, 200); // tlx, tly, w, h
		triangle(10, 10, 100, 90, 200, 200); // vertices	
	}	
	*/

	int x = 0; // 4 bytes
	
	public void draw()
	{	
		/*
		background(0,0,255); //rgb values for the background (Will clear the screen)
		stroke(0,255,0); //rgb values for the outline of shapes
		fill(255,0,0); //rgb values for the fill colour
		noStroke(); //remove all outline
		line(10, 10, 100, 100); //Parameters are x1,y1,x2,y2,
		point(50, 50); //Draw a point parameters are x,y
		ellipse(100, 200, 100, 50); //Parameters are centerx,centery,width,height
		fill(200,64,198);
		rect(70, 150, 90, 10); //Parameters are topleftx,toplefty,width,height
		triangle(150, 90, 200, 100, 100, 250); //Parameters are vertex1x,vertex1y,vertex2x,vertex2y,vertex3x,vertex3y
		*/

		//In-class Exercise
		background(255, 0, 0);
		noStroke();
		fill(255,255,0);
		ellipse(250, 300, 400, 400);
		fill(109,250,251);
		triangle(250, 50, 50, 450, 450, 450);
		fill(199,200,199);
		ellipse(250, 250, 190, 100);
		fill(0);
		ellipse(250, 250, 70, 70);
		
		/*
		background(0);
		noStroke();
		fill(255);
		ellipse(x, mouseY, 50, 50);		
		x ++;
		*/
	}
}
