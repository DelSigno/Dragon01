package com.dragon.android.programs;

import static android.opengl.GLES20.*;


import com.dragon.android.R;
import com.dragon.android.util.ShaderHandler;
import com.dragon.android.util.TextResourceReader;

import android.content.Context;


public class ColorShader2DProgram extends ShaderProgram{
	
	//Attribute Locations
	private final int aPositionLocation;
	
	
	//Uniform Locations
	private final int uColorLocation;
	private final int uMatrixLocation;
	
	private final int program;
	
	public ColorShader2DProgram(Context context, boolean validate){
		
		//Builds our program
		program = ShaderHandler.buildProgram(TextResourceReader.readTextFileFromResource(context, R.raw.colorshader2d_vertex_shader),TextResourceReader.readTextFileFromResource(context, R.raw.colorshader2d_fragment_shader), validate);
		
		
		//finds shader variables by name
		//Attribute
		aPositionLocation = glGetAttribLocation(program, "a_Position");
		
		//Uniforms
		uMatrixLocation = glGetUniformLocation(program, "u_Matrix");
		uColorLocation = glGetUniformLocation(program, "u_Color");

	}
	
	@Override
	public int getPositionCoordinatesAttributeLocation(){
		return aPositionLocation;
	}
	
	
	public void setUniforms(float[] uMatrix, float[] colorVector){
		glUniformMatrix4fv(uMatrixLocation, 1, false, uMatrix, 0);
		glUniform4fv(uColorLocation, 1, colorVector, 0);
		
	}
	
	@Override
	public void useProgram() {
		// Set the current OpenGL shader program to this program.
		glUseProgram(program);
	}

}
