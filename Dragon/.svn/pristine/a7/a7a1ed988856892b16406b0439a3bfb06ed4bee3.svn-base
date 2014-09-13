package com.dragon.android.objects;

import com.dragon.android.util.ProbabilityHandler;

public class MercTimer {
	
	//aniCount is the total number of animation cells for that posible animation state
	private final int aniCount;
	//interval is the time between changes 
	private long interval;
	
	private int offset;
	private long startTime;
	private long endTime;
	
	public MercTimer(int totalAnimationCells, long timeBetweenChanges){
		aniCount = totalAnimationCells - 1;
		interval = timeBetweenChanges;
		
		startTime = System.currentTimeMillis();
	}
	
	//This is a 2d engine, I should probably make this compatable with 3d but only give 2 shits
	public int getOffset(){
		endTime = System.currentTimeMillis();
		if (endTime-startTime > interval){
			offset = ProbabilityHandler.randInt(0, aniCount);
			startTime = System.currentTimeMillis();
		}
		
		return offset;
	}
	
	public int getNewOffset(){
		endTime = System.currentTimeMillis();
		if (endTime-startTime > interval){
			int oldoffset = offset;
			offset = ProbabilityHandler.randInt(0, aniCount);
			while (oldoffset == offset){
				offset = ProbabilityHandler.randInt(0, aniCount);
			}
			startTime = System.currentTimeMillis();
		}
		
		return offset;
	}
	
	public int getNewOffset(int xDim){
		endTime = System.currentTimeMillis();
		if (endTime-startTime > interval){
			int oldoffset = offset;
			offset = ProbabilityHandler.randInt(0, aniCount);
			while (oldoffset == offset){
				
				if (0 == (offset%xDim)){
					offset += 1;
					
				} else {
					offset = ProbabilityHandler.randInt(0, aniCount);
					
				}
			}
			startTime = System.currentTimeMillis();
		}
		
		return offset;
	}
	
	public boolean pollTimer(){
		endTime = System.currentTimeMillis();
		if (endTime-startTime > interval){
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
}
