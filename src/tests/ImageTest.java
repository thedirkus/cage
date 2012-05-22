package tests;

import dynamic.ClassReader;
import graphics.ImageGraphic;
import graphics.Window;

public class ImageTest {

	public static void main(String[] args){
		
		Window w = new Window(60, 0, 0, 640, 480);
		w.start();
		
		
		ImageGraphic ig = new ImageGraphic();
		System.out.println("Path: " + ClassReader.CLASSPATH + "custom/images/smile.png");
		ig.set("file", "D:/Users/Ryan/Documents/ceworkspace/cage/bin/custom/images/smile.png");
		ig.setHeight(256);
		ig.setWidth(256);
		ig.setX(100);
		ig.setY(100);
		ig.setZ(0);
		ig.setRotation(0);
		
		w.add(ig);

		
		while(true) { w.update(); }

	}
	
	
	
}
