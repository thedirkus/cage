package graphics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dynamic.Parameterizable;

public abstract class Graphic implements Drawable, Parameterizable {

	private double _x, _y, _z;
	private double _width, _height;
	private double _anchorX, _anchorY, _rotation;
	
	private Map<String, String> _parameters;
	
	public Graphic() {
		
		_width = 1;
		_height = 1;
		_parameters = new HashMap<String, String>();
	}
	
	/**
	 * translates, scales, and rotates to the Graphic's coordinates, then
	 * calls [drawNormalized]
	 */
	@Override
	public void draw() {
		
		// translate, rotate, and scale
		// the reason you push if the same reason you save s registers 
		// - other functions might use old matrices - DON'T DELETE, MASON
		glPushMatrix();
		glTranslated(_x, _y, 0);
		glRotated(_rotation, 0, 0, 1);
		glTranslated(-_anchorX, -_anchorY, 0);
		glScaled(_width, _height, 1); 
		
		drawNormalized();
		
		// undo transformations
		glPopMatrix();
	}
	
	
	/**
	 * called by the default draw implementation; should assume the Graphic is
	 * being drawn on a non-rotated unit square going from (0, 0) to (1, 1);
	 * [draw] actually performs the transformations
	 */
	public void drawNormalized() { }
	
	
	/**
	 * override if the Graphic should change over time
	 */
	public void update(float dt) { }
	
	
	/**
	 * Rotate the shape around its centerpoint regardless of anchorpoints
	 */
	public void rotateOnCenter() { }
	
	
	
	@Override
	public void set(String parameter, String value) {
		
		_parameters.put(parameter, value);
	}
	
	
	@Override
	public String get(String parameter) {
		
		return _parameters.get(parameter);
	}
	
	
	@Override
	public List<String> getParameterNames() {
		
		return new ArrayList<String>(_parameters.keySet());
	}
	
	
	public void setX       (double x       ) { _x        = x;        }
	public void setY       (double y       ) { _y        = y;        }
	public void setZ       (double z       ) { _z        = z;        }
	public void setScaleX  (double width   ) { _width    = width;    }
	public void setScaleY  (double height  ) { _height   = height;   }
	public void setAnchorX (double anchorX ) { _anchorX  = anchorX;  }
	public void setAnchorY (double anchorY ) { _anchorY  = anchorY;  }
	public void setRotation(double rotation) { _rotation = rotation; }
	
	
	public double getX       () { return _x;        }
	public double getY       () { return _y;        }
	public double getZ       () { return _z;        }
	public double getScaleX  () { return _width;    }
	public double getScaleY  () { return _height;   }
	public double getAnchorX () { return _anchorX;  }
	public double getAnchorY () { return _anchorY;  }
	public double getRotation() { return _rotation; }
}
