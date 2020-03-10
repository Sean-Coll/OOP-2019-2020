package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
    // Arraylist can grow and shrink
    // Generic
    ArrayList<Star> stars = new ArrayList<Star>(); 

    public void settings()
    {
        size(800, 800);
    }

    public void setup()
    {
        loadData();
        printStars();
    }

    public void loadData()
    {
        Table t = loadTable("HabHYG15ly.csv", "header");
        for(TableRow tr:t.rows())
        {
            Star s = new Star(tr);
            stars.add(s);
        }
    }

    public void printStars()
    {
        for(Star s:stars)
        {
            println(s);
        }
    }

    public void drawGrid()
    {
        stroke(0,0,255);
        fill(255);
        
        float border = 50;
        float textBorder = 25;
        float lineX = 50;
        float lineY = 50;
        float textX = 25;
        float textY = 25;
        float gridW = 750;
        float gridH = 750;

        int numLines = 10;
        int textVal = -5;

        for(int i = 0; i <= numLines; i ++)
        {
            lineX = map(i,0,10, border, gridW);
            lineY = map(i,0,10, border, gridH);
            //Horizontal Lines
            line(border, lineY, gridW, lineY);
            //Vertical Lines
            line(lineX, border, lineX, gridW);

            textX = map(i,0,10, border, gridW);
            textY = map(i,0,10, border, gridH);
            //Text
            text(textVal, textBorder, textY);
            text(textVal, textX, textBorder);
            
            textVal++;
        }
    }

    public void draw()
    {
        
        background(0);
        drawGrid();
    }

}
