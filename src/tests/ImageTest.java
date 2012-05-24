package tests;

import java.awt.Font;

import org.newdawn.slick.Color;

import dynamic.ClassReader;
import graphics.ImageGraphic;
import graphics.TextGraphic;
import graphics.Window;

public class ImageTest {

	public static void main(String[] args){
		
		Window w = new Window(60, 0, 0, 640, 480);
		w.start();		
		
		ImageGraphic ig = new ImageGraphic();
		ig.set("file", "/custom/images/smile.png");
		ig.setHeight(256);
		ig.setWidth(256);
		ig.setAnchorX(128);
		ig.setAnchorY(128);
		ig.setX(150);
		ig.setY(150);
		ig.setZ(0);
		ig.setRotation(1);
		
		
		TextGraphic t = new TextGraphic();
		t.setAttributes("Testing", TextGraphic.TIMESNEWROMAN, Font.PLAIN, 18, Color.white);
		t.setX(250);
		t.setY(250);
		t.setZ(0);
		
		
		w.add(ig);
		w.add(t);
		
		while(w.update()) {  }

	}
	
	
	
}
