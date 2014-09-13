package com.dragon.android.data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import android.opengl.GLES20;

import static android.opengl.GLES20.*;
import static android.opengl.GLUtils.*;
import static android.opengl.Matrix.*;

public class VertexArray {

	private static final int BYTES_PER_FLOAT = 4;
	
	private final FloatBuffer floatBuffer;
	private int[] buffer = new int[1];
	private int targetType = GL_ARRAY_BUFFER;
	
	private boolean isBound = false;
	
	//Builds a buffer from an array
	public VertexArray(float[] vertexData,boolean toVBO) {
		//This does mathy buffer shit. Honestly, I don't know what it means. I think this is what makes it fast
		floatBuffer = ByteBuffer.allocateDirect(vertexData.length * BYTES_PER_FLOAT).order(ByteOrder.nativeOrder()).asFloatBuffer().put(vertexData);
		if (toVBO){
			bindToBuffer();
		}
	}
	
	
	//depreciated call that sets vertex array 
	public void setVertexAttribPointer(int dataOffset, int attributeLocation,int componentCount, int stride) {
		//Inital offset of the data in the buffer we are accessing
		floatBuffer.position(dataOffset);
		//Binds the componentCount number of items from floatBuffer to attributeLocation
		glVertexAttribPointer(attributeLocation, componentCount, GL_FLOAT, false, stride, floatBuffer);
		//Enables it as opposed to some constant default
		glEnableVertexAttribArray(attributeLocation);
		//Resets the buffer back to the initial position for next run
		floatBuffer.position(0);
	}
	
	public void bindToBuffer(){
		//(number of buffers to gen, where to stick them, offset)
		GLES20.glGenBuffers(1, buffer , 0);
		//target can either be GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER
		GLES20.glBindBuffer(targetType, buffer[0]);
		//Sends the data from floatbuffer to memory
		//Resets the buffer back to the initial position for next run
		floatBuffer.position(0);
		GLES20.glBufferData(targetType, floatBuffer.capacity()*BYTES_PER_FLOAT, floatBuffer, GL_STATIC_DRAW);
		//sets the buffer back to zero, this is only used for creation
		GLES20.glBindBuffer(targetType, 0);
		isBound = true;
	}
	
	public void quickBind(){
		//Binds current buffer as active buffer
		GLES20.glBindBuffer(targetType,buffer[0]);
	}
	
	public void setActiveVBO(int attributeLocation,int componentCount, int stride,int offset){
		//Binds current buffer as active buffer
		GLES20.glBindBuffer(targetType,buffer[0]);
		//enables the attribute location
		GLES20.glEnableVertexAttribArray(attributeLocation);
		//Sets the currently bound buffer to attribute location, since pointer is set to zero it uses the bound buffer
		glVertexAttribPointer(attributeLocation, componentCount, GL_FLOAT, false, stride, offset);
		//sets the buffer back to zero, this is only used for creation
		GLES20.glBindBuffer(targetType, 0);
	}
	
	public void attribPointer(int attributeLocation,int componentCount, int stride,int offset){
		//enables the attribute location
		GLES20.glEnableVertexAttribArray(attributeLocation);
		//Sets the currently bound buffer to attribute location, since pointer is set to zero it uses the bound buffer
		glVertexAttribPointer(attributeLocation, componentCount, GL_FLOAT, false, stride, offset);
	}
	
	public boolean isBound(){
		return isBound;
	}

}
