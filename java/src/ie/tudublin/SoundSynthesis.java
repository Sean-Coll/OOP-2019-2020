package ie.tudublin;

import ddf.minim.AudioOutput;
import ddf.minim.Minim;
import ddf.minim.ugens.Oscil;
import ddf.minim.ugens.Waves;
import processing.core.PApplet;

public class SoundSynthesis extends PApplet
{
    Minim minim;
    AudioOutput out;
    Oscil wave;
    Oscil wave2;

    public void settings()
    {
        size(500, 500);
        
    }

    public void setup()
    {
        colorMode(HSB);
        minim = new Minim(this);

        out = minim.getLineOut();
        wave = new Oscil( 440, 0.5f, Waves.SQUARE );
        wave2 = new Oscil( 440, 0.5f, Waves.SQUARE );
        wave.patch(out);
        wave2.patch(out);
    }

    public void keyPressed() {
        if (key == ' ')
        {
            wave.setFrequency(wave.frequency.getLastValue() + 100);
        }
        println(wave.frequency.getLastValue());
    }

    float offset = 0;

    public void draw()
    {
        //wave.setFrequency(random(60, 2000));
        float n = noise(offset);
        float n2 = noise(offset);
        if(frameCount % 2 == 0)
        {
            wave.setFrequency(
            map(n, 0, 1, 100, 400)
        );
        }
        if(frameCount % 2 == 1)
        {
            wave2.setFrequency(
            map(n2, 0, 1, 401, 1000)
        );
        }
        
        offset += 0.01f;

        float cx = width / 2;
        float cy = height / 2;

        background(0);
        stroke(map(n, 0, 1, 0, 255), 255, 255);
        noFill();
        ellipse(cx, cy, 300, 300);
        ellipse(cx, cy + map(n, 0, 1, 0, 50), 20, 20);
        ellipse(cx - map(n, 0, 1, 0, 100), cy - 50, 20, 20);
        ellipse(cx + map(n, 0, 1, 0, 100), cy - 50, 20, 20);

        ellipse(cx, cy + 100, 100,
            map(n, 0, 1, 0, 60)
        );
    }
}