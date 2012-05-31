package tests;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import graphics.Window;
import graphics.shapes.Box;
import graphics.shapes.ImageGraphic;
import graphics.shapes.Rectangle;
import graphics.shapes.TextGraphic;

public class ImageTest {

	public static void main(String[] args){
		
		Window w = new Window(100, 0, 0, 640, 480);
		w.start();		
		
		Rectangle rect = new Rectangle(100,100);
		rect.setX(300);
		rect.setY(300);
		rect.setColor(1, 0, 0, 1);
		rect.setRotation(45);
		rect.setAnchorX(50);
		rect.setAnchorY(50);
		
		Box box = new Box(1000,150);
		box.setColor(0, 1, 0, 1);

		
		ImageGraphic ig = new ImageGraphic("PNG", "custom/images/smile.png", 256, 256);
		ig.setAnchorX(128);
		ig.setAnchorY(128);
		ig.setX(150);
		ig.setY(150);
		


		w.add(ig);
		w.add(rect);

		w.add(box);

				
		while(w.update()) { 
			
			int mousex = Mouse.getX();
			int mousey = w.getHeight() - Mouse.getY();
			
			ig.setX(mousex);
			ig.setY(mousey);
			
		}

	}
	
	
	
}
