package com.dragon.android.programs;

import static android.opengl.GLES20.*;


import com.dragon.android.R;
import com.dragon.android.util.ShaderHandler;
import com.dragon.android.util.TextResourceReader;

import android.content.Context;


public class TextureShader2DProgram extends ShaderProgram{
	
	//Attribute Locations
	private final int aPositionLocation;
	private final int aTextureCoordinatesLocation;
	
	//Uniform Locations
	private final int uTextureLocation;
	private final int uMatrixLocation;
	
	private final int program;
	
	public TextureShader2DProgram(Context context, boolean validate){
		
		//Builds our program
		program = ShaderHandler.buildProgram(TextResourceReader.readTextFileFromResource(context, R.raw.textureshader2d_vertex_shader),TextResourceReader.readTextFileFromResource(context, R.raw.textureshader2d_fragment_shader), validate);
		
		
		//finds shader variables by name
		//Attribute
		aPositionLocation = glGetAttribLocation(program, "a_VertexPosition");
		aTextureCoordinatesLocation = glGetAttribLocation(program, "a_TextureCoordinates");
		//Uniforms
		uTextureLocation = glGetUniformLocation(program, "s_Texture");
		uMatrixLocation = glGetUniformLocation(program, "u_CameraMatrix");

		

	}
	
	@Override
	public int getPositionCoordinatesAttributeLocation(){
		return aPositionLocation;
	}
	
	public int getTextureCoordinatesAttributeLocation(){
		return aTextureCoordinatesLocation;
	}
	
	public void setUniforms(float[] uMatrix, int textureId){
		glUniformMatrix4fv(uMatrixLocation, 1, false, uMatrix, 0);
		//glUniform4fv(uColorLocation, 1, colorVector, 0);
		
		//These next few steps do a few things
		//First it sets texture 0 as the active texture
		//Second it binds our texture id to the active texture
		//Thirdly it assigns the texture at 0, that we set as active in step one, to the texture location
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, textureId);
		glUniform1i(uTextureLocation, 0);
	}
	
	public void setuMatrix(float[] uMatrix){
		glUniformMatrix4fv(uMatrixLocation, 1, false, uMatrix, 0);
	}
	public void setTextureId(int textureId){
		//These next few steps do a few things
		//First it sets texture 0 as the active texture
		//Second it binds our texture id to the active texture
		//Thirdly it assigns the texture at 0, that we set as active in step one, to the texture location
		glActiveTexture(GL_TEXTURE0);
		glBindTexture(GL_TEXTURE_2D, textureId);
		glUniform1i(uTextureLocation, 0);
	}
	
	@Override
	public void useProgram() {
		// Set the current OpenGL shader program to this program.
		glUseProgram(program);
	}

}
