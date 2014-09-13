package com.dragon.android;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;

import com.dragon.android.data.Vec2;
import com.dragon.android.framework.Game;
import com.dragon.android.framework.InputListener;
import com.dragon.android.framework.OrthoCamera;
import com.dragon.android.framework.InputActions.InputAction;
import com.dragon.android.framework.InputActions.Press;
import com.dragon.android.framework.InputActions.InputTypes;

import com.dragon.android.objects.Background;
import com.dragon.android.objects.DrawCollection;
import com.dragon.android.objects.ExpandingDragon;
import com.dragon.android.programs.ShaderProgram;
import com.dragon.android.programs.TextureShader2DProgram;
import com.dragon.android.util.Logger;

public class Dragon extends Game {
	
	private static final String TAG = "Dragon";
	
	//BACKGROUND
	private Background background;
	
	//EXPANDINGDRAGON
	private ExpandingDragon fredo;
	
	//PROGRAMS
	private TextureShader2DProgram textureProgram;
	
	//************************Main Code Begins*********************************
	
	protected void onCreate(Bundle savedInstanceState) {
		this.maxPointers = 1;
		this.inputListener = new InputListener(maxPointers);
		
		super.onCreate(savedInstanceState);
		
		
	}

	@Override
	public void onDrawFrame(GL10 arg0) {
		super.onDrawFrame(arg0);
		
	}

	@Override
	public void onSurfaceChanged(GL10 arg0, int width, int height) {
		super.onSurfaceChanged(arg0, width, height);
		
		
		//Initialize Background
		background = new Background(this, camera.getSize(), textureProgram,R.drawable.background_paper_01);
		drawList.add(background);
		
		//Initialize fredo the dragon
		fredo = new ExpandingDragon(this,textureProgram);
		drawList.add(fredo);
		
	}

	@Override
	public void onSurfaceCreated(GL10 arg0, EGLConfig arg1) {
		super.onSurfaceCreated(arg0,arg1);
		
		
				
		//Initialize programs
		textureProgram = new TextureShader2DProgram(this, true);	
		
		
		
		
		
	}

	@Override
	public void onHear(LinkedList<InputAction> actions) {
		
		
		if (actions.peekFirst() != null) {
			switch (actions.pollFirst().type()) {
			case PRESS:
				fredo.setTargeting(true);
				break;

			case RELEASE:
				fredo.setTargeting(false);
				break;
			default:
				break;
			}
			
		}
		//Logger.loggerDebug(TAG, "Starting set target.");

		if (inputListener.getPointerCount() > 0) {
			//Logger.loggerDebug(TAG, "We send this to target -> " + inputListener.getFirstPointerPos().log());
			fredo.setTarget(inputListener.getFirstPointerPos());
		}
		
	}
	
	

}
