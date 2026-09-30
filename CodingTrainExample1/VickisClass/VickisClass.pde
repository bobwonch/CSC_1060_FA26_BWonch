int x = 50;
int y = 50;

void setup()
{
   size(800 , 600);
   background(0);
}

void draw()
{
   background(0);
   fill(255,0,0);
   stroke(0,255,0);
   strokeWeight(5);
   
   circle(x,y, 90);
   
   x += 10; 
   x = x % 800;
}
