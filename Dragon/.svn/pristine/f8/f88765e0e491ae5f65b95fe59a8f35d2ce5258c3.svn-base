package com.dragon.android.objects;


import static android.opengl.GLES20.GL_TRIANGLES;
import static android.opengl.GLES20.GL_UNSIGNED_SHORT;
import static android.opengl.GLES20.glDrawElements;
import android.content.Context;

import com.dragon.android.R;
import com.dragon.android.data.IndiceArray;
import com.dragon.android.data.Vec2;
import com.dragon.android.data.VertexArray;
import com.dragon.android.framework.OrthoCamera;
import com.dragon.android.objects.geometry.Square;
import com.dragon.android.programs.TextureShader2DProgram;
import com.dragon.android.util.Logger;
import com.dragon.android.util.TextureHandler;
import com.dragon.android.util.TextureMapVertexCreator;

public class DragonHead implements DrawCollection {
	
	//PROPERTIES
	private float direction = 90.0f;
	private Vec2 position = new Vec2(0.0f,-1.3f);
	private Vec2 vectorDirection;
	
	//STATICS
	private static final float SIZE = 0.25f;
	private static final long ANIMATION_SPEED = 35; //in milliseconds
	public static final float SPEED = 0.015f;
	private static final float TURN_SPEED = 2.5f;
	private static final int BYTES_PER_FLOAT = 4;
	private static final int BYTES_PER_INT = 4;
	private static final int TRIS_COUNT = 2;
	private static final int POSITION_COMPONENT_COUNT = 2;
	private static final int TEXTURE_COMPONENT_COUNT = 2;
	private static final String TAG = "DragonHead";
	
	//MOVEMENT
	private boolean targeting = false;
	private Vec2 target = new Vec2(0.0f,0.0f);
	
	//CAMERA
	private OrthoCamera camera;
		
	//GRAPHICS
	private VertexArray vertexArray;
	private VertexArray textureVertexArray;
	private IndiceArray indiceArray;
	private int texture;
	private TextureShader2DProgram program;
	
	//MERCTIMER
	private MercTimer mercTimer = new MercTimer(6,ANIMATION_SPEED);
	
	
	//*****************CODE***********************
	public DragonHead(Context context, TextureShader2DProgram iProg){
		
		this.vertexArray = TextureMapVertexCreator.getHomeSquare(6,new Square(SIZE).getData());
		this.vertexArray.bindToBuffer();
		
		this.texture = TextureHandler.loadTexture(context, R.drawable.dragon_head);
		
		this.textureVertexArray = TextureMapVertexCreator.createTextureVertexArray(6, 1);
		this.textureVertexArray.bindToBuffer();
		
		this.indiceArray = TextureMapVertexCreator.getHomeSqareIndices((short)6);
		this.indiceArray.bindToBuffer();
		
		this.program = iProg;
		
		
		
	}
	
	public void setDirection(float nDir){
		direction = nDir;
	}
	
	public void setTarget(Vec2 nTarg){
		target = nTarg;
		//Logger.loggerDebug(TAG, "Target set at: " + target.log() + "  |   Dir-> " + direction);

	}
	
	public Vec2 getVectorDirection(){
		return new Vec2(((float)Math.cos(Math.toRadians(direction))),((float)Math.sin(Math.toRadians(direction))));
	}
	
	public boolean setTargeting(boolean nTarg){
		targeting = nTarg;
		//Logger.loggerDebug(TAG, "targeting is : " + targeting);
		return targeting;
	}
	
	public Vec2 getPosition(){
		return position;
	}
	
	public void updatePos(){
		
		if (targeting) {
			
			//normalize our direction
			direction%=360;
			if (direction < 0){
				//Logger.loggerDebug(TAG,  " direction >  " + direction);	
				direction+=360;
				//Logger.loggerDebug(TAG,  " direction >  " + direction);	
				
			}
			
			//float angleToTarget = (float)Math.acos(Math.toRadians(getVectorDirection().dot(position.getDistanceVector(target))/getMagnitude())))
			float angleToTarget = position.getDistanceVector(target).getAngle();
			float attMinDir; 
			
			//Logger.loggerDebug(TAG,  " angle to target >  " + angleToTarget);
			if (direction < angleToTarget){
				attMinDir = (angleToTarget - direction) % 360;
				if(attMinDir > 180){
					direction -= TURN_SPEED;
				} else {
					direction += TURN_SPEED;
				}
			} else if (direction > angleToTarget){
				attMinDir = (direction - angleToTarget) % 360;
				if(attMinDir > 180){
					direction += TURN_SPEED;
				} else {
					direction -= TURN_SPEED;
				}
			}
			
			//Logger.loggerDebug(TAG,  " direction >  " + direction);	
			//Logger.loggerDebug(TAG,  " angle to target minus direcion >  " + attMinDir);
			/*if (((attMinDir <= 180)&&(attMinDir > 0)) || (attMinDir < -180)){
				direction += TURN_SPEED;
				//Logger.loggerDebug(TAG,  "Dir-=>  " + direction);
			}else {
				direction -= TURN_SPEED;
				//Logger.loggerDebug(TAG,  "!Dir+=>  " + direction);
			}*/
			
			
		}
		
		//transports you if you go off the screen
		//rightwall
		if (position.getX() > camera.getRight()){
			position.setX(camera.getLeft());
			//position.setY(-position.getY());
		}
		//leftwall
		if (position.getX() < camera.getLeft()){
			position.setX(camera.getRight());
			//position.setY(-position.getY());
		}
		//topwall
		if (position.getY() > camera.getTop()){
			position.setY(camera.getBottom());
			//position.setX(-position.getX());
		}
		//bottomwall
		if (position.getY() < camera.getBottom()){
			position.setY(camera.getTop());
			//position.setX(-position.getX());

		}
		
		
		
		position.moveAngle(SPEED, direction);
		//Logger.loggerDebug(TAG, position.log() + "|Dir-> " + direction);
		
	}

	@Override
	public void draw() {
		
		 updatePos();
		 
		//Logger.loggerVerbose(TAG, "Binding camera");
		program.setuMatrix(camera.srtToObject2D(1,1,1,direction,position.getX(),position.getY(),0));
		
		//Logger.loggerVerbose(TAG, "Begging draw");
		glDrawElements(GL_TRIANGLES,TRIS_COUNT * 3,GL_UNSIGNED_SHORT, 0);
		
	}


	@Override
	public void bindData(OrthoCamera iCamera) {
		//Logger.loggerVerbose(TAG, "Begging bind data");
		
		program.useProgram();
		
		vertexArray.setActiveVBO(program.getPositionCoordinatesAttributeLocation(), TRIS_COUNT, POSITION_COMPONENT_COUNT * BYTES_PER_FLOAT, 0);
		textureVertexArray.setActiveVBO(program.getTextureCoordinatesAttributeLocation(), TRIS_COUNT, TEXTURE_COMPONENT_COUNT * BYTES_PER_FLOAT, mercTimer.getNewOffset() * (POSITION_COMPONENT_COUNT * BYTES_PER_FLOAT));
		
		indiceArray.setActiveIBO();
		
		this.camera = iCamera;
		
		program.setTextureId(texture);
		
	}
	
}


