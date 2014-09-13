package com.dragon.android.programs;

import static android.opengl.GLES20.glUseProgram;

public abstract class ShaderProgram {
	
	private final int aPositionLocation = 0;
	
	public void useProgram() {
		
	}
	
	public int getPositionCoordinatesAttributeLocation(){
		return aPositionLocation;
	}
}
