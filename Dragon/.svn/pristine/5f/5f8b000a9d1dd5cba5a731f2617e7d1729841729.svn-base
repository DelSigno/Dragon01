package com.dragon.android.objects.geometry;

import com.dragon.android.data.Vec2;
import com.dragon.android.data.VertexArray;
import static android.opengl.GLES20.*;

public class Square implements Shape{
	
	private float[] vertexData;
	private VertexArray vertexArray;
	
	public Square(float size){
	
		vertexData = new float[]{-(size/2),-(size/2),
								  (size/2),-(size/2),
								  -(size/2),(size/2),
								  (size/2),(size/2)};
	}
	
	public float[] getData(){
		return vertexData;
	}
	public VertexArray getVertexArray(){
		
		vertexArray = new VertexArray(vertexData,false);
		return vertexArray;
	}
}
