package com.dragon.android.util;

import java.util.Random;

import com.dragon.android.data.Vec2;


public class ProbabilityHandler {
	private static final Random random = new Random();
	public static Vec2 randVec2(float xMin,float xMax, float yMin, float yMax){
		
		return new Vec2((random.nextFloat() * (xMax - xMin))+ xMin,(random.nextFloat() * (yMax - yMin))+ yMin);
		
	}
	
	public static boolean bernoulli(float prob){
		if (random.nextFloat() < prob)
			return true;
		else
			return false;
	}
	
	public static int randInt(int lower,int upper){
		return random.nextInt((upper-lower)+1) + lower;
		
	}
}
