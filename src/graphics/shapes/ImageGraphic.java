package graphics.shapes;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;

import graphics.Graphic;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ImageGraphic extends Graphic{

	Texture		_texture;
	double 		_width, _height;
	
	public static final String 	PNG = "PNG";
	public static final String	JPG = "JPG";
	public static final String	GIF = "GIF";
	public static final String	TGA = "TGA";
	
	public ImageGraphic(String type, String path, double d, double f) {
		
		super();
		
		_width = d;
		_height = f;
		try {
			_texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			System.out.println("Could not load texture.\nPath: " + path + "\nType: " + type);
		}
	}
	
	
	public void setTexture(String type, String path){
		
		try {
			_texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			System.out.println("Could not load texture.\nPath: " + path + "\nType: " + type);
		}
	}
	
	
	public void setWidth (double _width2)  {	_width = _width2;   }
	public void setHeight(double _height2) { 	_height = _height2; }
	
	public double getWidth()	{ return _width;  }
	public double getHeight()	{ return _height; }
	
	
	@Override
	public void drawNormalized() {
		
		Color.white.bind();
		_texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2d(0,0);
			GL11.glVertex3d(0,0, this.getZ());
			GL11.glTexCoord2d(1,0);
			GL11.glVertex3d(_width,0, this.getZ());
			GL11.glTexCoord2d(1,1);
			GL11.glVertex3d(_width,_height, this.getZ());
			GL11.glTexCoord2d(0,1);
			GL11.glVertex3d(0,_height, this.getZ());
		GL11.glEnd();
	}
	
}
