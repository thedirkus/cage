package tests;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import graphics.RightTriangle;
import graphics.Window;
import graphics.shapes.Box;
import graphics.shapes.ImageGraphic;
import graphics.shapes.Rectangle;
import graphics.shapes.TextGraphic;

public class ImageTest {

	public static void main(String[] args){
		
		Window w = new Window(100, 0, 0, 640, 480);
		w.start();		
		
		TextGraphic loading = new TextGraphic();
		loading.setAttributes("Loading...", TextGraphic.TIMESNEWROMAN, Font.BOLD,
								24, Color.white, true);
		loading.setX(300);
		loading.setY(220);
		
		w.add(loading);
		w.update();
		
		
		Rectangle rect = new Rectangle(100,100);
		rect.setX(300);
		rect.setY(300);
		rect.setColor(1, 0, 0, 1);
		rect.setRotation(45);
		rect.setAnchorX(50);
		rect.setAnchorY(50);
		
		Box box = new Box(1000,150);
		box.setColor(0, 1, 0, 1);

		
		ImageGraphic ig = new ImageGraphic();
		ig.setTexture("PNG", "custom/images/smile.png");
		ig.setHeight(256);
		ig.setWidth(256);
		ig.setAnchorX(128);
		ig.setAnchorY(128);
		ig.setX(150);
		ig.setY(150);
		ig.setRotation(30);
		
		
		TextGraphic t = new TextGraphic();
		t.setAttributes("Testing", TextGraphic.TIMESNEWROMAN, Font.BOLD, 24, Color.yellow, true);
		t.setX(400);
		t.setY(300);
		t.setZ(1);
	
		
		RightTriangle tri = new RightTriangle(100,100);
		tri.setX(100);
		tri.setY(100);
		tri.setColor(0, 1, 0, 1);
		
		w.add(tri);
		w.add(ig);
		w.add(rect);
		w.add(t);
		w.add(box);
		w.remove(loading);
				
		while(w.update()) { 
			
			int mousex = Mouse.getX();
			int mousey = w.getHeight() - Mouse.getY();
			
			ig.setX(mousex);
			ig.setY(mousey);
			
		}

	}
	
	
	
}
