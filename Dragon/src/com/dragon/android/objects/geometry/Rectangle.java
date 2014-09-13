package com.dragon.android.objects.geometry;

import com.dragon.android.data.Vec2;
import com.dragon.android.data.VertexArray;
import static android.opengl.GLES20.*;

public class Rectangle implements Shape {
	
	private float[] vertexData;
	private VertexArray vertexArray;
	
	public Rectangle(Vec2 size){
	
		vertexData = new float[]{-(size.getX()/2),-(size.getY()/2),
								  (size.getX()/2),-(size.getY()/2),
								  -(size.getX()/2),(size.getY()/2),
								  (size.getX()/2),(size.getY()/2)};
	
		
	}
	
	public VertexArray getVertexArray(){
		vertexArray = new VertexArray(vertexData,false);
		return vertexArray;
	}
}
