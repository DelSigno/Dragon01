package com.dragon.android.data;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import android.opengl.GLES20;

import static android.opengl.GLES20.*;
import static android.opengl.GLUtils.*;
import static android.opengl.Matrix.*;

public class IndiceArray {

	private static final int BYTES_PER_INT = 4;
	private static final int BYTES_PER_SHORT = 2;
	
	private final ShortBuffer shortBuffer;
	private int[] buffer = new int[1];
	private final int targetType = GL_ELEMENT_ARRAY_BUFFER;
	
	private boolean isBound = false;
	
	//Builds a buffer from an array
	public IndiceArray(short[] vertexData,boolean toVBO) {
		//This does mathy buffer shit. Honestly, I don't know what it means. I think this is what makes it fast
		shortBuffer = ByteBuffer.allocateDirect(vertexData.length * BYTES_PER_SHORT).order(ByteOrder.nativeOrder()).asShortBuffer().put(vertexData);
		if (toVBO){	
			bindToBuffer();
		}
	}
	
	
	//depreciated call that sets vertex array 
	public void setVertexAttribPointer(int dataOffset, int attributeLocation,int componentCount, int stride) {
		//Inital offset of the data in the buffer we are accessing
		shortBuffer.position(dataOffset);
		//Binds the componentCount number of items from floatBuffer to attributeLocation
		glVertexAttribPointer(attributeLocation, componentCount, GL_INT, false, stride, shortBuffer);
		//Enables it as opposed to some constant default
		glEnableVertexAttribArray(attributeLocation);
		//Resets the buffer back to the initial position for next run
		shortBuffer.position(0);
	}
	
	public void bindToBuffer(){
		//(number of buffers to gen, where to stick them, offset)
		GLES20.glGenBuffers(1, buffer , 0);
		//target can either be GL_ARRAY_BUFFER or GL_ELEMENT_ARRAY_BUFFER
		GLES20.glBindBuffer(targetType, buffer[0]);
		//Resets the buffer back to the initial position for next run
		shortBuffer.position(0);
		//Binds the buffer data to IBO
		GLES20.glBufferData(targetType, shortBuffer.capacity()*BYTES_PER_SHORT, shortBuffer, GL_STATIC_DRAW);
		//sets the buffer back to zero, this is only used for creation
		GLES20.glBindBuffer(targetType, 0);
		isBound = true;
	}
	
	public void setActiveIBO(){
		//Binds current buffer as active buffer
		GLES20.glBindBuffer(targetType,buffer[0]);
		
	}
	
	public boolean isBound(){
		return isBound;
	}

}
