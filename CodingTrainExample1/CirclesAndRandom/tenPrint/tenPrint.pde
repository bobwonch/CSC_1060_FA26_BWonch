float spacing = 35;

void setup(){
 size(1280, 720);
 
}

void draw(){
 background(0);
 //noFill();
 stroke(255);
 strokeWeight(3);
 for (float y = 0; y < height; y += spacing)
 {
   for( float x = 0; x < width; x += spacing)
   {
     float rand = random(1);
     stroke(random(255),random(255),random(255) );  
      //circle(x, y, spacing);
      if (rand >= .5) 
      {
        line(x,y, x+ spacing, y + spacing);
      }
      else
      {
        line(x, y + spacing, x + spacing,y);
      }
      
   }
 }
 noLoop();
}
