package com.dragon.android.data;

import android.util.FloatMath;

import com.dragon.android.util.Logger;

public class Vec2 {
	
	private static String TAG = "Vec2";
	private float x;
	private float y;
	
	public Vec2(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public Vec2(Vec2 vector){
		this.x = vector.getX();
		this.y = vector.getY();
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	//Moves a vector in the direction of the given angle at a distance
	public void moveAngle(float distance,float angle){
		//Logger.loggerDebug(TAG, " x: " + ((float)Math.cos(Math.toRadians(angle))));
		//Logger.loggerDebug(TAG, " y: " + ((float)Math.sin(Math.toRadians(angle))));
		this.x = this.x + (distance*((float)Math.cos(Math.toRadians(angle))));
		this.y = this.y + (distance*((float)Math.sin(Math.toRadians(angle))));
	}
	
	public void move(float x,float y){
		this.x = this.x + x;
		this.y = this.y + y;
	}
	
	public void move(Vec2 vector){
		this.x = this.x + vector.getX();
		this.y = this.y + vector.getY();
	}
	
	public Vec2 scalarMul(float c){
		return new Vec2(this.x * c, this.y * c);
	}
	
	public float dot(Vec2 vector){
		return (this.x * vector.getX())+(this.y * vector.getY());
	}
	
	public Vec2 compMul(Vec2 vector){
		return new Vec2(this.x * vector.getX(), this.y * vector.getY());
	}
	
	public float getMagnitude(){
		return (float) Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
	}
	
	public void zeroOut(){
		this.x = 0;
		this.y = 0;
	}
	
	public Vec2 getDistanceVector(Vec2 vector){
		Vec2 tempVector =  new Vec2((vector.getX() - this.x),(vector.getY() - this.y));
		return tempVector;
	}
	
	public float getDistanceTo(Vec2 vector){
		Vec2 tempVector = this.getDistanceVector(vector);	
		return (float) Math.sqrt(Math.pow(tempVector.getX(), 2) + Math.pow(tempVector.getY(), 2));
	}
	
	public Vec2 getDirectionTo(Vec2 vector){
		Vec2 tempVector = this.getDistanceVector(vector);
		float dist = this.getDistanceTo(vector);
		
		if (dist == 0){
			return new Vec2(0.0f,0.0f);
		}else{
			return new Vec2(tempVector.getX()/dist,tempVector.getY()/dist);
		}
		
	}
	
	public float getAngle(){
		
		/*float tempAngle =  (float)Math.toDegrees(Math.acos(Math.toRadians((dot(new Vec2(1,0))/getMagnitude()))));
		Logger.loggerDebug(TAG, "tempAngle: " + tempAngle);
		if (y < 0){
			return 180 + (180 - tempAngle);
		}
		
		return tempAngle;*/
		if ((y > 0) && (x > 0)){
			return (float)Math.toDegrees(Math.atan(y/x));
		}
		if ((y > 0) && (x < 0)){
			return 90 + (float)Math.toDegrees(Math.atan((-x)/y));
		}
		if ((y < 0) && (x < 0)){
			return 180 + (float)Math.toDegrees(Math.atan((-y)/(-x)));
		}
		if ((y < 0) && (x > 0)){
			return 270 + (float)Math.toDegrees(Math.atan((x)/(-y)));
		}
		
		if (y==0){
			if (x > 0){
				return 0;
			}
			return 180;
		}
		
		if (x==0){
			if (y>0){
				return 90;
			}
			return 270;
		}
		
		return -1;
		
		
	}
	
	public String log(){
		return (Float.toString(x) + " | " + Float.toString(y));
	}
}
