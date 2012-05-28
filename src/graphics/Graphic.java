package graphics;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dynamic.Parameterizable;

public abstract class Graphic implements Drawable, Parameterizable {

	private float _x, _y, _z;
	private float _width, _height;
	private float _anchorX, _anchorY, _rotation;
	
	private Map<String, String> _parameters;
	
	public Graphic() {
		
		_width  = 1;
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
	
	
	public void setX       (float x       ) { _x        = x;        }
	public void setY       (float y       ) { _y        = y;        }
	public void setZ       (float z       ) { _z        = z;        }
	public void setWidth   (float width   ) { _width    = width;    }
	public void setHeight  (float height  ) { _height   = height;   }
	public void setAnchorX (float anchorX ) { _anchorX  = anchorX;  }
	public void setAnchorY (float anchorY ) { _anchorY  = anchorY;  }
	public void setRotation(float rotation) { _rotation = rotation; }
	
	
	public float getX       () { return _x;        }
	public float getY       () { return _y;        }
	public float getZ       () { return _z;        }
	public float getWidth   () { return _width;    }
	public float getHeight  () { return _height;   }
	public float getAnchorX () { return _anchorX;  }
	public float getAnchorY () { return _anchorY;  }
	public float getRotation() { return _rotation; }
}
