package graphics;

import org.lwjgl.opengl.GL11;

public class Rectangle extends Graphic{

	double	_r = 0, _g = 0, _b = 0, _a = 1;
	
	public Rectangle (int width, int height) {
		
		setWidth(width);
		setHeight(height);
	}
	
	
	public void setColor(double red, double green, double blue, double alpha){
		
		_r = red;
		_g = green;
		_b = blue;
		_a = alpha;
	}
	
	
	@Override
	public void drawNormalized() {
				
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glColor4d(_r, _g, _b, _a);
			GL11.glVertex3d(0, 0, getZ());
			GL11.glVertex3d(1, 0, getZ());
			GL11.glVertex3d(1, 1, getZ());
			GL11.glVertex3d(0, 1, getZ());
		GL11.glEnd();
	}
	
}
