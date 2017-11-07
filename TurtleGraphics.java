import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*;

public class TurtleGraphics {
  public static void main(String[] args) {
    JFrame fr = new JFrame("TurtleGraphics");

    fr.setSize(1000,1000);
    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fr.getContentPane().setBackground(new Color(255, 255, 255));

    TurtleGraphicsPanel panel = new TurtleGraphicsPanel();
    panel.setOpaque(false);
    fr.add(panel);

    fr.setVisible(true);
  }
}

class TurtleGraphicsPanel extends JPanel implements MouseMotionListener, MouseListener {
  ArrayList <Turtle> turtles = new ArrayList <Turtle>();

  private Turtle kamekichi1;
  private Turtle kamekichi2;
  private Turtle kamekichi3;
  private Turtle kamekichi4;
  private Turtle kamekichi5;

  private int selectedTurtle = 0;

  Random rnd = new Random();

  TurtleGraphicsPanel() {
    kamekichi1 = new Turtle(50, 250);
    kamekichi2 = new Turtle(150, 500);
    kamekichi3 = new Turtle(150, 800);
    kamekichi4 = new Turtle(500, 400);
    kamekichi5 = new Turtle(450, 700);

    square(kamekichi1);
    turtles.add(kamekichi1);

    triangles(kamekichi2, 40, 4, 10);
    turtles.add(kamekichi2);

    triangles(kamekichi3, 20, 8, 20);
    turtles.add(kamekichi3);

    polygon(kamekichi4);
    turtles.add(kamekichi4);

    free(kamekichi5);
    turtles.add(kamekichi5);

    addMouseMotionListener(this);
    addMouseListener(this);
  }

  public void square(Turtle t) {
    for (int i = 0; i < 4; i++) {
      t.move(200);
      t.turn(90);
    }
  }

  public void triangle(Turtle t, int size) {
    t.move(size);
    t.turn(120);
    t.move(size);
    t.turn(120);
    t.move(size);
    t.turn(120);
  }

  public void triangles(Turtle t, int n, int c, int d) {
    for (int i = 0; i++ < n; ) {
      triangle(t, i * c);
      t.turn(d);
    }
  }

  public void polygon(Turtle t) {
    for (int i = 0; i<3; i++){
      t.move(100);
      t.turn(120);
    }

    for (int i = 0; i<4; i++){
      t.move(100);
      t.turn(90);
    }

    for (int i = 0; i<5; i++){
      t.move(100);
      t.turn(72);
    }

    for (int i = 0; i<6; i++){
      t.move(100);
      t.turn(60);
    }

    for (int i = 0; i<7; i++){
      t.move(100);
      t.turn(51.42);
    }

    for (int i = 0; i<8; i++){
      t.move(100);
      t.turn(45);
    }

    for (int i = 0; i<9; i++){
      t.move(100);
      t.turn(40);
    }

    for (int i = 0; i<10; i++){
      t.move(100);
      t.turn(36);
    }
  }

  public void free(Turtle t) {
    for (int i = 0; i<5; i++){
      t.move(300);
      t.turn(144);
      t.penSize(rnd.nextInt(15));
      t.penColor(new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
    }
  }

  @Override
  public void paintComponent(Graphics g) {
    for (int i=0; i<turtles.size(); i++) {
      turtles.get(i).paint(g);
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {

  }

  @Override
    public void mouseDragged(MouseEvent e) {
      turtles.get(selectedTurtle).setOffset(e.getPoint());
      turtles.get(selectedTurtle).setCenter(e.getPoint());

      repaint();
  }

  @Override
  public void mouseClicked(MouseEvent e) {

  }

  @Override
  public void mouseEntered(MouseEvent e) {

  }

  @Override
  public void mouseExited(MouseEvent e) {

  }

  @Override
  public void mousePressed(MouseEvent e) {
    for (int i = turtles.size() - 1; i >= 0; i--) {
      if (turtles.get(i).inTurtle(e.getPoint().getX(), e.getPoint().getY())) {
        selectedTurtle = i;
        break;
      }
    }

    repaint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {

  }
}
