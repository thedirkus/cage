package graphics.shapes;

import graphics.Graphic;

import org.lwjgl.opengl.GL11;

public class Triangle extends Graphic{

	private double	_r = 0, _g = 0, _b = 0, _a = 1;
	private	Vertex  _v1, _v2, _v3;
	
	public Triangle (Vertex vert1, Vertex vert2, Vertex vert3) {
		
		super();
		_v1 = vert1;
		_v2 = vert2;
		_v3 = vert3;
	}
	
	
	public void setColor(double red, double green, double blue, double alpha){
		
		_r = red;
		_g = green;
		_b = blue;
		_a = alpha;
	}
	
	
	public void setVerticies (Vertex vert1, Vertex vert2, Vertex vert3)  {	
		
		_v1 = vert1;
		_v2 = vert2;
		_v3 = vert3;   
	}
	
	
	public void rotateOnCenter(){
		
		
	}
	
	@Override
	public void drawNormalized() {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);		
		GL11.glBegin(GL11.GL_TRIANGLES);
			GL11.glColor4d(_r, _g, _b, _a);

			GL11.glVertex3d(_v1.getX(),      _v1.getY(),       getZ());
			GL11.glVertex3d(_v2.getX(),      _v2.getY(),       getZ());
			GL11.glVertex3d(_v3.getX(),      _v3.getY(),       getZ());
		GL11.glEnd();
	}
}
