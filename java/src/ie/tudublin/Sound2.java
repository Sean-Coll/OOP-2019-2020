package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;

public class Sound2 extends PApplet
{	
	Minim minim;
	AudioSample as;

	int frameSize = 1024;



	float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
	String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

	public void settings()
	{
		size(1024, 500);
	}


	public void setup() 
	{
		minim = new Minim(this);
		as = minim.loadSample("scale.wav", frameSize);
		colorMode(HSB);
		textSize(24);
	}

	float lerpedw = 0;

	public void keyPressed()
	{
		as.stop();
		as.trigger();
	}

	public int countZeroCrossing()
	{
		int count = 0;

		for(int i = 1; i < as.bufferSize(); i++)
		{
			if(as.left.get(i-1) > 0 && as.left.get(i) <= 0)
			{
				count ++;
			}
		}
		return count;
	}

	public void drawCircleLines()
	{
		float cx = width / 2;
		float cy = height / 2;
		float theta = 0;

		for(int i = 0; i < as.bufferSize(); i++)
		{
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
			float radius = as.left.get(i);
			theta += TWO_PI / (float) as.bufferSize();

			float x = (sin(theta)) * radius * cy + cx;
			float y = (cos(theta)) * radius * cy + cy;

			line(cx, cy, x, y);
		}

	}
	
	public void draw()
	{	
		background(0);		
		stroke(255);
		float cy = height / 2;
		float sum = 0;
		for(int i = 0 ; i < as.bufferSize() ; i ++)
		{
			stroke(
				map(i, 0, as.bufferSize(), 0, 255)
				, 255
				, 255
			);
			//line(i, cy, i, cy + ai.left.get(i) * cy);
			sum += abs(as.left.get(i));
		}
		float average = sum / as.bufferSize();

		float w  = average * 1000;
		lerpedw = lerp(lerpedw, w, 0.1f);
		// noStroke();
		fill(
			map(average, 0, 1, 0, 255)
			, 255
			, 255
		);
		// ellipse(400 , cy,w, w);
		// ellipse(600 , cy,lerpedw, lerpedw);
		
		float zeroC = countZeroCrossing() * (1 / 0.023f);
		text(zeroC, 25, 25);
		String note = " ";

		for(int i = 0; i < frequencies.length - 1; i++)
		{
			float difference = frequencies[i + 1] - frequencies[i];
			if(zeroC > frequencies[i] && zeroC < frequencies[i+1])
			{
				if(zeroC >= frequencies[i] + (difference / 2))
				{
					note = spellings[i+1];
				}
				else if(zeroC <= frequencies[i] + (difference / 2))
				{
					note = spellings[i];
				}
			}
			if(zeroC < frequencies[0])
			{
				note = spellings[0];
			}
			text(note, 32, 75);
		}

		drawCircleLines();
	}
}
