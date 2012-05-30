package tests;

import graphics.Window;
import graphics.shapes.Box;
import graphics.shapes.Line;
import graphics.shapes.Rectangle;
import graphics.shapes.Triangle;
import graphics.shapes.Vertex;

public class NewGLTest {

	
	public static void main(String[] arg){
		
		Window w = new Window(100, 0, 0, 1024, 800);
		w.start();
		
		Box box = new Box(100,100);
		box.setX(50);
		box.setY(50);
		box.setRotation(30);
		
		Rectangle rect = new Rectangle(100,200);
		rect.setX(300);
		rect.setY(300);
		
		Rectangle rect2 = new Rectangle(100,100);
		rect2.setX(100);
		rect2.setY(100);
		
		Triangle tri = new Triangle ( 	new Vertex(0,0),
										new Vertex(0,100),
										new Vertex(100,0));

		Line line = new Line ( new Vertex(0,0), new Vertex(100,0));
		line.setX(400);
		line.setY(10);
			
		
		w.add(box);
		w.add(rect);
		w.add(rect2);
		w.add(tri);
		w.add(line);
		
		w.setColor(1, 1, 0, 1);
		
		while( w.update() ) { }
		
	}
}
