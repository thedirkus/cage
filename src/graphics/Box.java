package graphics;

import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glScaled;
import static org.lwjgl.opengl.GL11.glTranslated;

import org.lwjgl.opengl.GL11;

public class Box extends Graphic{

	double	_r = 0, _g = 0, _b = 0, _a = 1;
	
	public Box (int width, int height) {
		
		setWidth(width);
		setHeight(height);
	}
	
	
	public void setColor(double red, double green, double blue, double alpha){
		
		_r = red;
		_g = green;
		_b = blue;
		_a = alpha;
	}
	
//	@Override
//	public void draw() {
//		
//		// translate, rotate, and scale
//		// the reason you push if the same reason you save s registers 
//		// - other functions might use old matrices - DON'T DELETE, MASON
//		glPushMatrix();
//		//glTranslated(getX(), getY(), 0);
//		//glRotated(getRotation(), 0, 0, 1);
//		//glTranslated(-getAnchorX(), -getAnchorY(), 0);
//		//glScaled(getWidth(), getHeight(), 1); 
//		
//		drawNormalized();
//		
//		// undo transformations
//		glPopMatrix();
//	}
	
	
	@Override
	public void draw() {
				
		GL11.glBegin(GL11.GL_LINES);
			GL11.glColor4d(1, 0, 0, 1);
			GL11.glVertex3d(100, 100, 1);
			GL11.glVertex3d(200, 100, 1);
			
//			GL11.glVertex3d(1, 0, getZ());
//			GL11.glVertex3d(1, 1, getZ());
//			
//			GL11.glVertex3d(1, 1, getZ());
//			GL11.glVertex3d(0, 1, getZ());
//			
//			GL11.glVertex3d(0, 1, getZ());
//			GL11.glVertex3d(0, 0, getZ());
		GL11.glEnd();
	}
	
	
}
