package graphics;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class ImageGraphic extends Graphic{

	Texture		_texture;
	
	public static final String 	PNG = "PNG";
	public static final String	JPG = "JPG";
	public static final String	GIF = "GIF";
	public static final String	TGA = "TGA";
	
	public ImageGraphic() {
		
		super();
	}
	
	
	public void setTexture(String type, String path){
		
		try {
			_texture = TextureLoader.getTexture(type, ResourceLoader.getResourceAsStream(path));
		} catch (IOException e) {
			System.out.println("Could not load texture.\nPath: " + path + "\nType: " + type);
		}
	}
	
	
	
	@Override
	public void drawNormalized() {
		
		Color.white.bind();
		_texture.bind();
		
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex3f(0,0, this.getZ());
			GL11.glTexCoord2f(1,0);
			GL11.glVertex3f(1,0, this.getZ());
			GL11.glTexCoord2f(1,1);
			GL11.glVertex3f(1,1, this.getZ());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex3f(0,1, this.getZ());
		GL11.glEnd();
	}
	
}
