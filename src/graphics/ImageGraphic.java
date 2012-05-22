package graphics;


import static org.lwjgl.opengl.GL11.*;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.*;

import javax.imageio.ImageIO;

public class ImageGraphic extends Graphic {


	// filename to texture int - cache textures
	private static final Map<String, Integer> _textures =
			new HashMap<String, Integer>();

	// cache aspect ratios
	private static final Map<String, Float> _aspectRatios =
			new HashMap<String, Float>();


	private int     _texID;
	private boolean _imageToBind;
	private boolean _imageLoaded;

	private int        _texWidth;
	private int        _texHeight;
	private ByteBuffer _rgbBuf;


	public ImageGraphic() {

		super();
		set("file", "");
	}

	@Override
	public void set(String parameter, String value) {

		if (parameter.equals("file")) {

			if (_textures.get(value) != null) {

				_texID       = _textures.get(value);
				_imageLoaded = true;

				float oldHeight = getHeight();
				setHeight(_aspectRatios.get(value) * getWidth());
				setAnchorY(getAnchorY() * getHeight() / oldHeight);

			} else if (loadImage()) {

				_imageLoaded = true;
				_imageToBind = true;
				_texID       = _textures.size();
				_textures.put(value, _texID);
				_aspectRatios.put(value, (float) _texHeight / _texWidth);

				float oldHeight = getHeight();
				setHeight(_aspectRatios.get(value) * getWidth());
				setAnchorY(getAnchorY() * getHeight() / oldHeight);
			}
		}
	}


	@Override
	public void drawNormalized() {

		if (_imageToBind) {

			bindImage();
			_imageToBind = false;
		}

		if (_imageLoaded) {

			glColor4f(1, 1, 1, 1);
	        glEnable(GL_TEXTURE_2D);
	        glTexEnvi(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
			glBindTexture (GL_TEXTURE_2D, _texID);
			glBegin (GL_QUADS);
			glTexCoord2f (0.0f, 0.0f);
			//glVertex3f (0.0f, 0.0f, this.getZ());
			glVertex3f (0.0f, 0.0f, 0.0f);
			glTexCoord2f (1.0f, 0.0f);
			//glVertex3f (1.0f, 0.0f, this.getZ());
			glVertex3f (1.0f, 0.0f, 0.0f);
			glTexCoord2f (1.0f, 1.0f);
			//glVertex3f (1.0f, 1.0f, this.getZ());
			glVertex3f (1.0f, 1.0f, 0.0f);
			glTexCoord2f (0.0f, 1.0f);
			//glVertex3f (0.0f, 1.0f, this.getZ());
			glVertex3f (0.0f, 1.0f, 0.0f);
			glEnd ();
	        glDisable(GL_TEXTURE_2D);
		}
	}


	//------------------------------------------------------------------------//


	private boolean loadImage() {

		try {
			URL           imageFile = getClass().getResource(get("file"));
			BufferedImage texture   = ImageIO.read(imageFile);
			
			_texWidth  = texture.getWidth();
			_texHeight = texture.getHeight();

			int   texNumPix = _texWidth*_texHeight;
			int[] rgbArray  = new int[texNumPix];

			texture.getRGB(0, 0, _texWidth, _texHeight, rgbArray, 0, _texWidth);
			
			// Create a ByteBuffer that holds the RGBA contents of the texture
			_rgbBuf = ByteBuffer.allocateDirect(4*texNumPix);
			IntBuffer rgbIntBuf = _rgbBuf.asIntBuffer();
			rgbIntBuf.put(rgbArray);
			
			// Need to rotate pixel data from ARGB -> RGBA
			int blag,newblag;
			for(int i = 0; i<texNumPix; i++){
				if( (blag = rgbIntBuf.get(i)) != 0){
					newblag = (( blag << 8 ) | ( blag >>> (24) ));
					rgbIntBuf.put(i, newblag);
				}
			}
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
	}


	private void bindImage() {

		// Load into video memory
		glBindTexture(GL_TEXTURE_2D, _texID);
		glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
		glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_MODULATE);
		glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, _texWidth, _texHeight,
		             0, GL_RGBA, GL_UNSIGNED_BYTE, _rgbBuf);
	}
	
	
}
