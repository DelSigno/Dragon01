package com.dragon.android.util;

import java.util.Arrays;
import java.util.HashMap;

import com.dragon.android.data.VertexArray;

public class TextTextureHandler {
	
	//CONSTANT
	private static final String TAG = "TextTextureHandler";

	private static int POSITION_COMPONENT_COUNT = 2;
	private static int VERTEX_PER_NUMBER = 6;
		
	public static float[] generateDivisionMap(int subSquaresLen){
		
		int offset = 0;
		int totalSquares = (subSquaresLen*subSquaresLen);
		float[] vertexData = new float[ totalSquares * POSITION_COMPONENT_COUNT * VERTEX_PER_NUMBER];
		float division = 1.0f / (float)subSquaresLen;
		
		
		for (int i = 0; i < totalSquares;i++){
			//vertex 1 : S and T
			vertexData[offset++] = ((float)(i%subSquaresLen) * division);
			vertexData[offset++] = 1 - ((float)(i/subSquaresLen) * division);
			//vertex 2 : S and T
			vertexData[offset++] = ((float)((i%subSquaresLen)+1) * division);
			vertexData[offset++] = 1 - ((float)(i/subSquaresLen) * division);
			//vertex 3 : S and T
			vertexData[offset++] = ((float)((i%subSquaresLen)+1) * division);
			vertexData[offset++] = 1 - ((float)((i/subSquaresLen)+1) * division);
			//vertex 4 : S and T
			vertexData[offset++] = ((float)(i%subSquaresLen) * division);
			vertexData[offset++] = 1 - ((float)(i/subSquaresLen) * division);
			//vertex 5 : S and T
			vertexData[offset++] = ((float)((i%subSquaresLen)+1) * division);
			vertexData[offset++] = 1 - ((float)((i/subSquaresLen)+1) * division);
			//vertex 6 : S and T
			vertexData[offset++] = ((float)(i%subSquaresLen) * division);
			vertexData[offset++] = 1 - ((float)((i/subSquaresLen)+1) * division);
		}
		
		return vertexData;
	}

	
	private static float[] getLetterVerts(String letter, HashMap<String,Integer> letterLookup,float[] divisionMap){
		int offset = letterLookup.get(letter) * (VERTEX_PER_NUMBER * POSITION_COMPONENT_COUNT);
		//Logger.loggerVerbose(TAG, "Offset: " + letter + "|" + offset);
		return new float[] {divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++],
							divisionMap[offset++]};
	}
	
	public static VertexArray generateTextureVertexArray(String text, HashMap<String,Integer> letterLookup, float[] divisionMap){
		
		float[] vertexData = null;
		for(int i = 0; i < text.length(); i++)	{
			
			vertexData = NumberHandler.addArrays(getLetterVerts(Character.toString(text.charAt(i)),  letterLookup, divisionMap),vertexData);
		}
		//Logger.loggerVerbose(TAG, Arrays.toString(vertexData));
		
		return new VertexArray(vertexData,false);
	}

}
