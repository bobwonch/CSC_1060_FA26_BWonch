float x, y, r, g, b;
float sqrSize = random(50, 150);
float lnWdith = random(4, 16);
float xspeed = 5;
float yspeed = 5;
float radius = 15;

boolean going = true;

void setup() {
  size(640, 360);
  background(0);
  x=26;
  y=180;
  r = 255;
  g = 255;
  b = 255;
}

void mousePressed() {
  going = !going;
}

void draw() {
  //SQUARES

  //sqrSize = random(50, 150);
  //lnWdith = random(4, 16);

  //rectMode(CENTER);
  //strokeWeight(lnWdith);
  //stroke(0, 0, 255, 10);
  //fill(0, 255, 10);
  //square(320, 180, sqrSize);

  //CIRCLES

  //RANDOM
  //x = random(width);
  //y = random(height);;
  //r = random(100, 255);;
  //g = random(55);
  //b = random(150, 255);;

  //MOVING RT AND LFT
  background(0);
  noStroke();
  //fill(r,g,b, random(0,100));
  fill(r, g, b);
  circle(x, y, radius * 2);
  if(going){
    x+=xspeed;
    y+=yspeed;
  }
  if (x >= width - radius || x <= 0 ) {
    xspeed = -xspeed;
    r = random(255);
    g = random(255);
    b = random(255);
  }
  if (y >= height - radius || y <= 0 ) {
    yspeed = -yspeed;
    r = random(255);
    g = random(255);
    b = random(255);
  }

  //line(random(width,height),random(width,height),random(width,height),random(width,height));
}
