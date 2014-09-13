package com.dragon.android.data;

import static android.opengl.GLES20.GL_FLOAT;
import static android.opengl.GLES20.glVertexAttribPointer;
import android.opengl.GLES20;

public class ObjectArray {
	
	//ARRAYS
	private VertexArray vertexArray;
	private IndiceArray indiceArray;
	
	public ObjectArray(VertexArray iVert, IndiceArray iInd){
		
		this.vertexArray = iVert;
		this.indiceArray = iInd;
		
	}
	
	public void bind(){
		if (vertexArray.isBound() == false)
			vertexArray.bindToBuffer();
		if (indiceArray.isBound() == false)
			indiceArray.bindToBuffer();
	}
	
	public void setActive(int attributeLocation,int componentCount, int stride,int offset){
	
		//vertexArray.setActiveVBO(program.getPositionCoordinatesAttributeLocation(), TRIS_COUNT, POSITION_COMPONENT_COUNT * BYTES_PER_FLOAT, 0);
	}
}
