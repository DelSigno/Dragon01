package com.dragon.android.util;

import com.dragon.android.data.IndiceArray;
import com.dragon.android.data.VertexArray;

public class TextureMapVertexCreator {
	
	public static VertexArray createTextureVertexArray(int xDim,int yDim){
		
		int totalNodes = (xDim + 1) * (yDim + 1);
		float xDiv = 1.0f/(float)xDim;
		float yDiv = 1.0f/(float)yDim;
		float[] vertexData = new float[totalNodes *2];
		int offset = 0;
		
		for (float i = 1; i >= 0; i -= yDiv){
			for (float j = 0; j <= 1; j += xDiv){
				vertexData[offset++] = j;
				vertexData[offset++] = i;
			}
		}
		return new VertexArray(vertexData,false);
	}
	
	//the home square is the lower right recangle( square is just a shorter word)
	//this returns the 4 input into the correct indices.
	public static VertexArray getHomeSquare(int xDim, float[] values){
		
		//we add three, one for the fact we are looking at corners not edges, and two for the top 
		//two verticies
		int vertexCount = (xDim + 3) *2;
		float[] vertexData = new float[vertexCount];
		
		//Vertex 1
		vertexData[0] = values[0];
		vertexData[1] = values[1];
		//Vertex 2
		vertexData[2] = values[2];
		vertexData[3] = values[3];
		//Vertex 3
		vertexData[vertexCount - 4] = values[4];
		vertexData[vertexCount - 3] = values[5];
		//Vertex 4
		vertexData[vertexCount - 2] = values[6];
		vertexData[vertexCount - 1] = values[7];
		
		return new VertexArray(vertexData,false);
	}
	
	public static IndiceArray getHomeSqareIndices(short xDim){
		return new IndiceArray(new short[] {0, 1, (short) (xDim + 2),
											0, (short) (xDim + 2), (short) (xDim + 1)},false);
	}
	
}

