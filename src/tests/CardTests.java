package tests;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;

import graphics.CardGraphic;
import graphics.Window;
import graphics.shapes.Box;
import graphics.shapes.CardStock;
import graphics.shapes.ImageGraphic;
import graphics.shapes.Line;
import graphics.shapes.Rectangle;
import graphics.shapes.TextGraphic;
import graphics.shapes.Triangle;
import graphics.shapes.Vertex;

public class CardTests {

	
public static void main(String[] arg){
		
		Window w = new Window(100, 0, 0, 1024, 800);
		w.start();
		
		CardGraphic cg = new CardGraphic(600,ImageGraphic.PNG,"custom/images/smile.png","Mr. Card", "Happy Power", "Hehro", "Bloop");
		cg.setX(100);
		cg.setY(10);
		cg.setBackgroundColor(.5, .2, .2, 1);
		
		w.add(cg);
		
		w.setColor(.9, .8, .6, 1);
		
		while( w.update() ) { 
						
			cg.setX(Mouse.getX());
			cg.setY(w.getHeight()- Mouse.getY());
		}
		
	}
}
