package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet 
{
    //Random x value for the bug
    float randX = random(25, 425);
    //Whether the laser hits the bug or not
    boolean contact = false;
    //Player variables
    float playerX = 225;
    float playerY = 470;
    float playerWidth = 50;
    float playerHeight = (playerWidth/2);

    //Bug Variables
    float bugX = 240;
    float bugY = 10;
    float bugWidth = 20;
    float bugHeight = 30;

    //Set up the screen
    public void settings()
    {
        size(500,500);
    }

    public void setup() 
    {
    
    }

    public void draw()
    {
        drawPlayer(playerX, playerY, playerWidth, playerHeight);
        if ((frameCount % 60) == 0)
        {
            background(0);
            randX = random(25, 425);
            bugY = bugY + 50;
            drawBug(randX, bugY, bugWidth, bugHeight);
        }
        if (bugY >= 455)
        {
            System.out.println("You lose");
            bugY = 10;
        }
        
    }
    //Draw the player
    public void drawPlayer(float x, float y, float w, float h)
    {
        stroke(255,0,0);
        fill(0);
        rect(x, y, w, h);
        line(x + h, y, x + h, y - h);
    }
    //Draw the bug
    public void drawBug(float x, float y, float w, float h)
    {
        stroke(255,0,0);
        fill(0);
        rect(x, y, w, h);
        line((x-w), (y+5), x, (y+5));
        line((x-w), (y+15), x, (y+10));
        line((x-w), (y+25), x, (y+15));
        line((x-w), (y+35), x, (y+20));
        line((x+w*2), (y+5), (x+w), (y+5));
        line((x+w*2), (y+15), (x+w), (y+10));
        line((x+w*2), (y+25), (x+w), (y+15));
        line((x+w*2), (y+35), (x+w), (y+20));
    }
    //Make the player move in response to keys pressed
    public void keyPressed()
    {
        if (keyCode == LEFT)
		{
            if (playerX >= 25)
            {
                playerX = playerX - 5;
            }
		}
		if (keyCode == RIGHT)
		{
            if (playerX <= 425)
            {
                playerX = playerX + 5;
            }
		}
		if (key == ' ')
		{
			line(playerX + playerHeight, playerY, playerX + playerHeight, playerY - 500);
		}
    }
}
