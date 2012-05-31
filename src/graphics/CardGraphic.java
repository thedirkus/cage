package graphics;

import java.awt.Font;

import graphics.shapes.CardStock;
import graphics.shapes.ImageGraphic;
import graphics.shapes.TextGraphic;
import graphics.shapes.Vertex;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

/**
 * Graphic for a full-view Card
 * Includes an image, name, and up to three stats (name, value)
 * Can change the color of the card background and the border
 * @author Ryan
 *
 */
public class CardGraphic extends Graphic{
	
	private	double			_width, _height;
	private CardStock 		_card;
	private ImageGraphic 	_image;
	private TextGraphic		_name, _infoA, _infoB, _infoC;
	
	public CardGraphic (double height, String imagetype, String imagepath, String name, String infoA, String infoB, String infoC) {
		
		_height = height;
		_width  = Math.floor(height*0.7);
		
		System.out.println(_height);
		System.out.println(_width);
		
		_card = new CardStock(_width, _height);
		
		_image = new ImageGraphic(imagetype, imagepath, (_width*0.9), (height*0.5));
		_image.setX(_width*.05);
		_image.setY(_height*.09);
//		
//		_name = new TextGraphic(name, TextGraphic.TIMESNEWROMAN, Font.PLAIN, (int) Math.round(height*0.075), new Color(0,0,0), true);
//		_name.setX(_width*.05);
//		_name.setY(_height*.02);
//		
//		_infoA = new TextGraphic(name, TextGraphic.TIMESNEWROMAN, Font.PLAIN, (int) Math.round(height*0.05), new Color(0,0,0), true);
//		_infoB = new TextGraphic(name, TextGraphic.TIMESNEWROMAN, Font.PLAIN, (int) Math.round(height*0.05), new Color(0,0,0), true);
//		_infoC = new TextGraphic(name, TextGraphic.TIMESNEWROMAN, Font.PLAIN, (int) Math.round(height*0.05), new Color(0,0,0), true);
//		_infoA.setX(_width*.05);
//		_infoB.setX(_width*.05);
//		_infoC.setX(_width*.05);
//		
//		double infostart = _height*.09 + _image.getHeight();
//		System.out.println(infostart);
//		
//		_infoA.setY(infostart + _height*.02);
//		_infoB.setY(infostart + _height*.09);
//		_infoC.setY(infostart + _height*.16);
		
	}
	
	
	public void setBackgroundColor(double red, double green, double blue, double alpha){
		_card.setBackgroundColor(red, green, blue, alpha);
	}
	
	public void setBorderColor(double red, double green, double blue, double alpha){
		_card.setBorderColor(red, green, blue, alpha);
	}
	
	public void setNameColor(int red, int green, int blue){
		_name.setFontColor(new Color(red, green, blue));
	}
	
	public void setInfoColor(int red, int green, int blue){
		_infoA.setFontColor(new Color(red, green, blue));
		_infoB.setFontColor(new Color(red, green, blue));
		_infoC.setFontColor(new Color(red, green, blue));
	}

	
	@Override
	public void drawNormalized() {
				
		_card.draw();
		_image.draw();
		_name.draw();
		_infoA.draw();
		_infoB.draw();
		_infoC.draw();
	}
	
}
