package graphics.shapes;

import graphics.Graphic;

import org.lwjgl.opengl.GL11;

public class Rectangle extends Graphic{

	private double	_r = 0, _g = 0, _b = 0, _a = 1;
	private double  _width, _height;
	
	public Rectangle (double _width2, double _height2) {
		
		super();
		setWidth(_width2);
		setHeight(_height2);
	}
	
	
	public void setColor(double red, double green, double blue, double alpha){
		
		_r = red;
		_g = green;
		_b = blue;
		_a = alpha;
	}
	
	
	public void setWidth (double _width2)  {	_width = _width2;   }
	public void setHeight(double _height2) { 	_height = _height2; }
	
	public double getWidth()	{ return _width;  }
	public double getHeight()	{ return _height; }
	
	
	@Override
	public void drawNormalized() {
				
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4d(_r, _g, _b, _a);

			GL11.glVertex3d(0,      0,       getZ());
			GL11.glVertex3d(_width, 0,	     getZ());
			GL11.glVertex3d(_width, _height, getZ());
			GL11.glVertex3d(0, 		_height, getZ());
		GL11.glEnd();
	}
	
}
