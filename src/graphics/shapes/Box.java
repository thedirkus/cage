package graphics.shapes;

import org.lwjgl.opengl.GL11;

import graphics.Graphic;

public class Box extends Graphic{

	private double	_r = 0, _g = 0, _b = 0, _a = 1;
	private Vertex	_topleft, _topright, _bottomleft, _bottomright;
	
	public Box (int width, int height) {
		
		_topleft = new Vertex(0, 0);
		_topright = new Vertex(width, 0);
		_bottomleft = new Vertex(0, height);
		_bottomright = new Vertex(width, height);
	}
	
	
	public void setColor(double red, double green, double blue, double alpha){
		
		_r = red;
		_g = green;
		_b = blue;
		_a = alpha;
	}

	
	@Override
	public void drawNormalized() {
				
		GL11.glBegin(GL11.GL_LINES);
			GL11.glColor4d(_r, _g, _b, _a);
	
			GL11.glVertex3d(_topleft.getX(),      _topleft.getY(),       getZ());
			GL11.glVertex3d(_topright.getX(),     _topright.getY(),       getZ());
			
			GL11.glVertex3d(_topright.getX(),      _topright.getY(),       getZ());
			GL11.glVertex3d(_bottomright.getX(),   _bottomright.getY(),       getZ());
			
			GL11.glVertex3d(_bottomright.getX(),  _bottomright.getY(),       getZ());
			GL11.glVertex3d(_bottomleft.getX(),   _bottomleft.getY(),       getZ());
			
			GL11.glVertex3d(_bottomleft.getX(),   _bottomleft.getY(),       getZ());
			GL11.glVertex3d(_topleft.getX(),      _topleft.getY(),       getZ());
		GL11.glEnd();
		
	}
	
	
}