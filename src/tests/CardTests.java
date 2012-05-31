package tests;

import graphics.CardGraphic;
import graphics.Window;
import graphics.shapes.Box;
import graphics.shapes.CardStock;
import graphics.shapes.ImageGraphic;
import graphics.shapes.Line;
import graphics.shapes.Rectangle;
import graphics.shapes.Triangle;
import graphics.shapes.Vertex;

public class CardTests {

	
public static void main(String[] arg){
		
		Window w = new Window(100, 0, 0, 1024, 800);
		w.start();
		
		CardStock cs = new CardStock(200,300);
		cs.setX(700);
		cs.setY(10);
		cs.setBorderColor(1, 0, 1, 1);

		CardGraphic cg = new CardGraphic(600,ImageGraphic.PNG,"custom/images/smile.png","Mr. Card", "Happy Power", "Hehro", "Bloop");
		cg.setX(100);
		cg.setY(10);
		cg.setBackgroundColor(.5, .2, .2, 1);
		
		//w.add(cg);
		w.add(cs);
		
		w.setColor(1, 1, 0, 1);
		
		while( w.update() ) { }
		
	}
}
