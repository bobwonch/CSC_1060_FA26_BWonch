import java.util.Random;


  float[] Xs = new float[100];
  float[] Ys = new float[100];
  int x = 320;
  int y = 480;
void setup() {
  size(640, 360);
  background(128);
  Random rand = new Random();
  
  
  for (int i = 0; i < 100; i++) {
     Xs[i] = rand.nextInt(640);
     Ys[i] = rand.nextInt(360);
  }  
  
}
void draw() {
  background(128);
  for(int i = 0; i < 100;i++){
    star(Xs[i], Ys[i], 2, 5, 5);
  }
  stroke(87);
  strokeWeight(3);
  drawRocket(x, y);
  
  y = (y - 1);
  if(y == -100) y = 480;
  //drawRocket(320, 180);
}

//rectMode(CENTER);
//square(120, 180, 100);
void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}
void drawRocket (int x,int y) {
  x = x - 320;
  y = y - 180;
  ellipse((280+x), (240+y), 45, 90); //lft fin
  ellipse((360+x), (240+y), 45, 90); //rt fin

  fill(0, 0, 0, 0);
  stroke(38, 19, 0);
  ellipse((320+x), (150+y), 120, 220); //rocket body
  stroke(127, 56, 0);
  ellipse((320+x), (150+y), 120, 220); //rocket body
  stroke(166, 83, 2);
  ellipse((320+x), (150+y), 115, 215); //rocket body
  fill(255, 127, 0, 255);
  ellipse((320+x), (150+y), 110, 210); //rocket body

  fill(255);
  stroke(87);
  ellipse((320+x), (240+y), 5, 90); //cntr fin
  //fill(255,255,255);
  stroke(207, 104, 2);
  circle((320+x), (110+y), 85); //window
  stroke(0);
  circle((320+x), (110+y), 80);
  stroke(127);
  circle((320+x), (110+y), 75); //window
  stroke(187);
  circle((320+x), (110+y), 70); //window

  strokeWeight(1);
  ellipse((315+x), (135+y), 7, 25);//legs
  ellipse((325+x), (135+y), 7, 25);

  ellipse((310+x), (105+y), 20, 5);//arms
  ellipse((330+x), (105+y), 20, 5);
  fill(0, 127, 255);
  ellipse((320+x), (115+y), 10, 50);//body
  fill(242, 219, 208);
  circle((320+x), (90+y), 20);
}
