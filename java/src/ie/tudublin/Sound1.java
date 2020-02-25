package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.*;
import javafx.scene.shape.Polygon;

public class Sound1 extends PApplet
{	
	Minim minim;
	AudioInput ai;
	AudioSample as;

	float circleY;
	float lerpedcircleY;
	float lerpedw = 0;

	float hue_val_F = 0;
	float hue_val_S = 0;

	public void settings()
	{
		size(1024, 500);
	}

	public void setup() 
	{
		minim = new Minim(this);
		ai = minim.getLineIn(Minim.MONO, width, 44100, 16);

		as = minim.loadSample("heroplanet.mp3");
		as.trigger();
		

		colorMode(HSB);
		circleY = height / 2;
	}

	void drawCircle()
	{
		float centerX = width / 2;
		float centerY = height / 2;
		float radius = 0;
		float average = 0;

		if(frameCount % 5 == 0)
		{
			hue_val_F = (float) Math.random() * 255;
			hue_val_S = (float) Math.random() * 255;
		}
		
		background(0);
		stroke(hue_val_S,255,255);
		fill(hue_val_F,255,255);

		for(int i = 0; i < ai.bufferSize(); i++)
		{
			radius = abs(ai.left.get(i) * centerY);
			average += radius;
		}
		average = (average % ai.bufferSize()) / 2;
		lerpedw = lerp(lerpedw, average, 0.1f);
		ellipse(centerX, centerY, lerpedw, lerpedw);

		// circleY += random(-20,20);
		// lerpedcircleY = lerp(lerpedcircleY, circleY, 0.1f);
		// ellipse(100, circleY, 50, 50);
		// ellipse(200, lerpedcircleY, 50, 50);	
	}

	void drawLines()
	{
		background(0);		
		stroke(255);
		float cy = height / 2;
		
		for(int i = 0 ; i < as.bufferSize() ; i ++)
		{
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
			line(i, 0, i, 0 + abs(as.left.get(i) * cy));
			line(i, 500, i, 500 - abs(as.left.get(i) * cy));
		}
	}

	void drawPolygon()
	{
		background(0);		
		stroke(255);

		float cx = width / 2;
		float cy = height / 2;
		float vertices = 5;
		float radius = 200;
		float length = radius / vertices;

		//Try to draw a Pentagon
		beginShape();
		vertex(250, 200);
		vertex(300, 250);
		vertex(275, 300);
		vertex(225, 300);
		vertex(200, 250);
		endShape(CLOSE);
	}	

	
	public void draw()
	{	
		// drawLines();
		// drawCircle();
		drawPolygon();
	}
}
