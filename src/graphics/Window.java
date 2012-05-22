package graphics;


import java.util.LinkedList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;


public class Window {

	int		_x, _y, _width, _height, _fps;
	List<Drawable> _contents;
	
	public Window(int desiredFPS, int x, int y, int width, int height){
		
		_fps 	= 	desiredFPS;
		_x 		= 	x;
		_y 		=	y;
		_width  =	width;
		_height =   height;
		_contents = new LinkedList<Drawable>();
	}
	
	
	
	public void start() {
		
		try {
			
			Display.setDisplayMode(new DisplayMode(_width, _height));
			Display.create();
		} catch (LWJGLException e) {
			
			System.out.println("Error: Display could not create()");
			System.exit(0);
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, _width, 0, _height, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	
	public void update(){
		
		if(Display.isCloseRequested()){
			System.out.println("Closing...");
			Display.destroy();
		} else {
			
			for(Drawable g : _contents)
				g.draw();
			
			Display.update();
			Display.sync(_fps);
		}
	}
	
	
	
	public void add(Graphic g){
		
		_contents.add(g);
	}
	

}
