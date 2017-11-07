import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class Turtle {
  ArrayList <Point> points = new ArrayList <Point>();
  ArrayList <Color> pcolor = new ArrayList <Color>();
  ArrayList <Integer> psize = new ArrayList <Integer>();

  private double x,y;
  private double angle;

  private Point rcenter;
  private int rsize;

  private double offsetX;
  private double offsetY;

  public Turtle(int i, int j) {
    x = i;
    y = j;
    angle = 0;

    offsetX = i;
    offsetY = j;

    this.rcenter = new Point((int)x,(int)y);
    this.rsize = 10;

    psize.add(1);
    pcolor.add(new Color(200, 200, 200));
    points.add(new Point((int)x,(int)y));
  }

  public void move(double length) {
    x += length * Math.cos(Math.toRadians(-angle));
    y += length * Math.sin(Math.toRadians(-angle));
    points.add(new Point((int)x,(int)y));
  }

  public void turn(double deg) {
    angle += deg;
  }

  public void penSize(int size) {
    psize.add(size);
  }

  public void penColor(Color c) {
    pcolor.add(c);
  }

  public void setCenter(Point p) {
   this.rcenter = p;
  }

  public void setOffset(Point p) {
   offsetX = p.getX();
   offsetY = p.getY();
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;

    for (int i = 0; i < points.size()-1; i++) {
      if (psize.size() > 1) {
        BasicStroke wideStroke = new BasicStroke(psize.get(i));
        g2.setStroke(wideStroke);
      }

      if (pcolor.size() > 1) {
        g.setColor(pcolor.get(i));
      }

      g.drawLine((int)(points.get(i).getX() + offsetX - x), (int)(points.get(i).getY() + offsetY - y),
                 (int)(points.get(i+1).getX() + offsetX - x), (int)(points.get(i+1).getY() + offsetY - y));

      g.setColor(new Color(0, 200, 0));
      g.fillOval((int) (rcenter.getX() - rsize / 2), (int) (rcenter.getY() - rsize / 2), rsize, rsize);
      g.setColor(pcolor.get(0));
    }
  }
  
  public boolean inTurtle(double x, double y) {
    double distance = Math.sqrt(Math.pow(x - rcenter.getX(), 2) + Math.pow(y - rcenter.getY(), 2));
    if (distance <= rsize / 2) {
      return true;
    } else {
      return false;
    }
  }
}
