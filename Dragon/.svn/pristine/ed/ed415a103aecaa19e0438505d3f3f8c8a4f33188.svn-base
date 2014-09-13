package com.dragon.android.util;

import static android.opengl.GLES20.*;
import static android.opengl.GLUtils.texImage2D;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.util.Log;


public class TextureHandler {
private static final String TAG = "TextureHelper";
	
	public static int loadTexture(Context context, int resourceId) {
		
		final int[] textureObjectIds = new int[1];
		
		//creates the ID for the new texture
		glGenTextures(1, textureObjectIds, 0);
		
		if (textureObjectIds[0] == 0) {
			Logger.loggerDebug(TAG, "failed to create openGLtexture ID");
		}
		
		//Creates BitmapFactory options for use later on
		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inScaled = false;
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		
		glEnable(GLES20.GL_BLEND);
		glBlendFunc(GL_ONE, GL_ONE_MINUS_SRC_ALPHA);
		
		
		//turns our .png into a bitmap via androids BitmapFactory
		final Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId, options);
		if (bitmap == null) {
			Logger.loggerDebug(TAG, "Bitmap not created");
			//if we couldn't succesfully get a bitmap we delete the texture ID
			glDeleteTextures(1, textureObjectIds, 0);
			return 0;
		}
		
		//Binds texture, the following commands are applied to the specific texture
		//turns our focus to textureObjectIds[0], the current texture we are working on
		glBindTexture(GL_TEXTURE_2D, textureObjectIds[0]);
		//Assigns the bitmap to the texture is some way
		texImage2D(GL_TEXTURE_2D, 0, bitmap, 0);
		//removes the bitmap from memory 
		bitmap.recycle();
		//Automatically generates the mipmaps
		glGenerateMipmap(GL_TEXTURE_2D);
		//unbinds texture
		glBindTexture(GL_TEXTURE_2D, 0);	
		//Returns the OpenGL id of the texture
		return textureObjectIds[0];
	}
	
	//*******************************************
	//While these setting aren't the be all end all
	//they are pretty much the only settings we need for
	//blocky type images. actually, renaming to blocky
	public static void setBlockySettings(int textureID){
		
		//binds texture we want to set setting for
		glBindTexture(GL_TEXTURE_2D, textureID);
		
		//sets some setting for this texture
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_MIRRORED_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_MIRRORED_REPEAT);
		
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	
	//sets to all bilinear with mipmaps, the "nicest" setting there are
	public static void setPrettySettings(int textureID){
		//binds texture we want to set setting for
		glBindTexture(GL_TEXTURE_2D, textureID);
		
		//sets some setting for this texture
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_MIRRORED_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_MIRRORED_REPEAT);
		
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
}
