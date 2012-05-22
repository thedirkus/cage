package graphics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.opengl.PixelFormat;


public class Canvas extends AWTGLCanvas {
	
	
	private List<Drawable> _contents;
	private Viewport       _viewport;
	private float          _r, _g, _b, _a;
	
	
	public Canvas() throws LWJGLException {
		
		super(new PixelFormat(8, 16, 0)); // alpha, int, stencil
		_contents = new ArrayList<Drawable>();
		setViewport(new Viewport(-4, -4, 8, 8));
	}
	
	
	public void setViewport(Viewport viewport) {
		
		_viewport = viewport;
	}
	
	
	public Viewport getViewport() {
		
		return _viewport;
	}
	
	
	public void add(Drawable element) {
		
		_contents.add(element);
	}
	
	
	public void remove(Drawable element) {
		
		_contents.remove(element);
	}
	
	
	public void setBackground(float r, float g, float b, float a) {
		
		_r = r;
		_g = g;
		_b = b;
		_a = a;
	}
	
	
	@Override
    public void initGL() {
        
        // optimizations
        glDisable(GL_LIGHTING);
        glEnable(GL_SCISSOR_TEST);
        
        // translucency and antialiasing
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA); // this part confuses maggie
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
    }
	
	
	//called by repaint()
	@Override
    public void paintGL() {
        
		// viewport
		glViewport(0, 0, getWidth(), getHeight());
        glScissor(0, 0, getWidth(), getHeight());
		
        // othographic projection
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        float loX = _viewport.x;
        float loY = _viewport.y;
        float hiX = _viewport.x + _viewport.width;
        float hiY = _viewport.y + _viewport.height;
        glOrtho(loX, hiX, loY, hiY, -1.0, 1.0);
        glMatrixMode(GL_MODELVIEW);
		
		// clear all previous drawings
		glClearColor(_r, _g, _b, _a);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		
        // draw contents
        for (Drawable element : _contents)
        	element.draw();
        
        // swap the drawing and screen buffers
        try                     { swapBuffers();       }
        catch(LWJGLException e) { e.printStackTrace(); }
    }
}