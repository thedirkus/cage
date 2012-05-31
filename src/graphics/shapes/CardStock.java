package graphics.shapes;

import graphics.Graphic;

import org.lwjgl.opengl.GL11;

public class CardStock extends Graphic {

	private Rectangle 	_background;
	private Box			_border;
	
	public CardStock (double _width, double _height) {
		
		_border = new Box(_width, _height);
		_background = new Rectangle(_width, _height);
	}
	
	
	public void setBackgroundColor(double red, double green, double blue, double alpha){
		
		_background.setColor(red, green, blue, alpha);
	}
	
	public void setBorderColor(double red, double green, double blue, double alpha){
		
		_border.setColor(red, green, blue, alpha);
	}

	
	@Override
	public void drawNormalized() {
				
		_background.draw();
		_border.draw();
	}
}
