package graphics;

import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class TextGraphic extends Graphic {

	private String 			_text;
	private TrueTypeFont	_font;
	
	// Attributes
	private String			_fontFace;
	private int				_fontStyle;
	private int				_fontSize;
	private Color			_fontColor;

	// Font Faces
	public static final String		TIMESNEWROMAN = "Times New Roman";
	
	
	
	public TextGraphic() {
		
		super();
	}
	
	public void setAttributes(String text, String font, int style, int size, Color color){
		
		_text 		= text;
		_fontFace 	= font;
		_fontStyle 	= style;
		_fontSize 	= size;
		_fontColor 	= color;
		
		_font = new TrueTypeFont(new Font(_fontFace,_fontStyle,_fontSize), false);
	}
	
	
	public void setText(String text) {
		
		_text = text;
		
		_font = new TrueTypeFont(new Font(_fontFace,_fontStyle,_fontSize), false);
	}
	
	public String getText() {
		
		return _text;
	}
	
	@Override
	public void drawNormalized() {
		
	    _font.drawString(this.getX(), this.getY(), _text, _fontColor);		
	}

	
	
	/* GETTERS AND SETTERS */

	public String getFontFace() {
		return _fontFace;
	}


	public void setFontFace(String _fontFace) {
		this._fontFace = _fontFace;
		_font = new TrueTypeFont(new Font(_fontFace,_fontStyle,_fontSize), false);
	}


	public int getFontStyle() {
		return _fontStyle;
	}


	public void setFontStyle(int _fontStyle) {
		this._fontStyle = _fontStyle;
		_font = new TrueTypeFont(new Font(_fontFace,_fontStyle,_fontSize), false);
	}


	public int getFontSize() {
		return _fontSize;
	}


	public void setFontSize(int _fontSize) {
		this._fontSize = _fontSize;
		_font = new TrueTypeFont(new Font(_fontFace,_fontStyle,_fontSize), false);
	}


	public Color getFontColor() {
		return _fontColor;
	}


	public void setFontColor(Color _fontColor) {
		this._fontColor = _fontColor;
		Font awtFont = new Font(_fontFace,_fontStyle,_fontSize);
		_font = new TrueTypeFont(awtFont, false);
	}
	

	
	
}
