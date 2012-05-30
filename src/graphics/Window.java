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
			Display.setVSyncEnabled(true);
		} catch (LWJGLException e) {
			
			System.out.println("Error: Display could not create()");
			System.exit(0);
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);
		
		GL11.glClearColor(0f, 0f, 0f, 0f);
		GL11.glClearDepth(1);
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glViewport(0, 0, _width, _height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, _width, _height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	
	/**
	 * Updates the Window State.  Returns true if still open, otherwise returns false
	 * if something happened to the window or it is closed.
	 * @return
	 */
	public boolean update(){
		
		if(Display.isCloseRequested()){
			System.out.println("Closing...");
			Display.destroy();
			return false;
		} else {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			for(Drawable g : _contents)
				g.draw();
			
			Display.update();
			Display.sync(_fps);
						
			return true;
		}
	}
	
	
	public void setColor(float r, float g, float b, float a){
		
		GL11.glClearColor(r, g, b, a);
	}
	
	
	public void add(Graphic g){
		
		_contents.add(g);
	}
	
	
	public void remove(Graphic g){
		
		_contents.remove(g);
	}
	

	public int getHeight(){ return _height;	}
	public int getWidth() { return _width;  }
	
}
